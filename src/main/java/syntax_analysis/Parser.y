%language "Java"
%define api.package {syntax_analysis}
%define api.prefix {Parser}
%define api.parser.class {Parser}
%define api.parser.public

%code imports {
	import java.io.IOException;
	import java.io.FileReader;
	import java.util.List;
	import lexical_analysis.tokens.keyword.QuoteShortToken;
        import syntax_analysis.node.*;
        import lexical_analysis.tokens.Token;
        import lexical_analysis.tokens.literal.*;
        import lexical_analysis.tokens.IdentifierToken;
}

%code {
	static AST ast;
        public static AST makeAST(String sourceProgramPath) throws IOException {
		//AST ast = new AST();
		FileReader fileReader = new FileReader(sourceProgramPath);
		LexerAdapter lexerAdapter = new LexerAdapter(fileReader);
		Parser p = new Parser(lexerAdapter);
		p.parse();
		return ast;
	}
}

%token <OpenParenthesisToken> OpenParenthesisToken
%token <CloseParenthesisToken> CloseParenthesisToken
%token <IntegerNumberLiteralToken> IntegerNumberLiteralToken
%token <RealNumberLiteralToken> RealNumberLiteralToken
%token <BooleanLiteralToken> BooleanLiteralToken
%token <NullLiteralToken> NullLiteralToken
%token <IdentifierToken> IdentifierToken
%token <QuoteToken> QuoteToken
%token <QuoteShortToken> QuoteShortToken
%token <SetqToken> SetqToken
%token <FuncToken> FuncToken
%token <LambdaToken> LambdaToken
%token <ProgToken> ProgToken
%token <CondToken> CondToken
%token <WhileToken> WhileToken
%token <ReturnToken> ReturnToken
%token <BreakToken> BreakToken
%token <PlusToken> PlusToken
%token <MinusToken> MinusToken
%token <TimesToken> TimesToken
%token <DivideToken> DivideToken
%token <HeadToken> HeadToken
%token <TailToken> TailToken
%token <ConsToken> ConsToken
%token <EqualToken> EqualToken
%token <NonEqualToken> NonEqualToken
%token <LessToken> LessToken
%token <LessEqToken> LessEqToken
%token <GreaterToken> GreaterToken
%token <GreaterEqToken> GreaterEqToken
%token <IsIntToken> IsIntToken
%token <IsRealToken> IsRealToken
%token <IsBoolToken> IsBoolToken
%token <IsNullToken> IsNullToken
%token <IsAtomToken> IsAtomToken
%token <IsListToken> IsListToken
%token <AndToken> AndToken
%token <OrToken> OrToken
%token <XorToken> XorToken
%token <NotToken> NotToken
%token <EvalToken> EvalToken

%type Program
%type SpecialForm
%type <ElementNode> Element
%type <ListNode> Elements
%type <AtomNode> Atom
%type <LiteralNode> Literal
%type <ListNode> List
%type <ArithmeticFunctionNode> ArithmeticFunction

%start Program

%%

Program
	: Element {ast = new AST(new ListNode($1));}
       	| Element Elements {ast = new AST(new ListNode($1, $2)); }
	;
Elements
	: /* empty */  {$$ = new ListNode();}
	| Element Elements {$$ = new ListNode($1, $2);}
	;
Element
	: Atom {$$ = new ElementNode($1);}
	| Literal {$$ = new ElementNode($1);}
	| List {$$ = new ElementNode($1);}
	| QuoteShortToken Element {$$ = $2;}
	;
List
	: OpenParenthesisToken Element Elements CloseParenthesisToken {$$ = new ListNode($2, $3);}
	| OpenParenthesisToken SpecialForm CloseParenthesisToken
	| OpenParenthesisToken ArithmeticFunction CloseParenthesisToken {$$ = new ListNode($2);}
	| OpenParenthesisToken OperationOnLists CloseParenthesisToken
	| OpenParenthesisToken Comparison CloseParenthesisToken
	| OpenParenthesisToken Predicate CloseParenthesisToken
	| OpenParenthesisToken LogicalOperator CloseParenthesisToken
	| OpenParenthesisToken Evaluator CloseParenthesisToken
	;
OptionalElement
	: /* empty */
	| Element
	;
Atom
	: IdentifierToken {$$ = new AtomNode($1);}
	;
Literal
	: IntegerNumberLiteralToken {$$ = new LiteralNode($1);}
	| RealNumberLiteralToken {$$ = new LiteralNode($1);}
	| BooleanLiteralToken {$$ = new LiteralNode($1);}
	| NullLiteralToken {$$ = new LiteralNode($1);}
	;
SpecialForm
	: QuoteToken Element
	| SetqToken Atom Element
	| FuncToken Atom List Element
	| LambdaToken List Element
	| ProgToken List Element
	| CondToken Element Element OptionalElement
	| WhileToken Element Element
	| ReturnToken Element
	| BreakToken
	;
ArithmeticFunction
	:
	| PlusToken Element Element {$$ = new ArithmeticFunctionNode(ArithmeticFunctionNode.Operation.ADDITION, $2, $3);}
	| MinusToken Element Element {$$ = new ArithmeticFunctionNode(ArithmeticFunctionNode.Operation.SUBTRACTION, $2, $3);}
	| TimesToken Element Element {$$ = new ArithmeticFunctionNode(ArithmeticFunctionNode.Operation.MULTIPLICATION, $2, $3);}
	| DivideToken Element Element {$$ = new ArithmeticFunctionNode(ArithmeticFunctionNode.Operation.DIVISION, $2, $3);}
	;
OperationOnLists
	: HeadToken Element
	| TailToken Element
	| ConsToken Element Element
	;
Comparison
	: EqualToken Element Element
	| NonEqualToken Element Element
	| LessToken Element Element
	| LessEqToken Element Element
	| GreaterToken Element Element
	| GreaterEqToken Element Element
	;
Predicate
	: IsIntToken Element
	| IsRealToken Element
	| IsBoolToken Element
	| IsNullToken Element
	| IsAtomToken Element
	| IsListToken Element
	;
LogicalOperator
	: AndToken Element Element
	| OrToken Element Element
	| XorToken Element Element
	| NotToken Element
	;
Evaluator
	: EvalToken Element
	;
%%

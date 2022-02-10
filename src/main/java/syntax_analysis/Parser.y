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
%type <OperationOnListsNode> OperationOnLists
%type <ComparisonNode> Comparison
%type <PredicateNode> Predicate
%type <LogicalOperatorNode> LogicalOperator
%type <EvaluatorNode> Evaluator
%type <SpecialFormNode> SpecialForm
%type <ElementNode> OptionalElement

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
	| OpenParenthesisToken SpecialForm CloseParenthesisToken {$$ = new ListNode($2);}
	| OpenParenthesisToken ArithmeticFunction CloseParenthesisToken {$$ = new ListNode($2);}
	| OpenParenthesisToken OperationOnLists CloseParenthesisToken {$$ = new ListNode($2);}
	| OpenParenthesisToken Comparison CloseParenthesisToken {$$ = new ListNode($2);}
	| OpenParenthesisToken Predicate CloseParenthesisToken {$$ = new ListNode($2);}
	| OpenParenthesisToken LogicalOperator CloseParenthesisToken {$$ = new ListNode($2);}
	| OpenParenthesisToken Evaluator CloseParenthesisToken {$$ = new ListNode($2);}
	;
OptionalElement
	: /* empty */ {$$ = null;}
	| Element {$$ = $1;}
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
	: QuoteToken Element {$$ = new SpecialFormNode(SpecialFormNode.Form.QUOTE, $2);}
	| SetqToken Atom Element {$$ = new SpecialFormNode(SpecialFormNode.Form.SETQ, $2, $3);}
	| FuncToken Atom List Element {$$ = new SpecialFormNode(SpecialFormNode.Form.FUNC, $2, $3, $4);}
	| LambdaToken List Element {$$ = new SpecialFormNode(SpecialFormNode.Form.LAMBDA, $2, $3);}
	| ProgToken List Element {$$ = new SpecialFormNode(SpecialFormNode.Form.PROG, $2, $3);}
	| CondToken Element Element OptionalElement {$$ = new SpecialFormNode(SpecialFormNode.Form.COND, $2, $3, $4);}
	| WhileToken Element Element {$$ = new SpecialFormNode(SpecialFormNode.Form.WHILE, $2, $3);}
	| ReturnToken Element {$$ = new SpecialFormNode(SpecialFormNode.Form.RETURN, $2);}
	| BreakToken {$$ = new SpecialFormNode(SpecialFormNode.Form.BREAK);}
	;
ArithmeticFunction
	:
	| PlusToken Element Element {$$ = new ArithmeticFunctionNode(ArithmeticFunctionNode.Operation.ADDITION, $2, $3);}
	| MinusToken Element Element {$$ = new ArithmeticFunctionNode(ArithmeticFunctionNode.Operation.SUBTRACTION, $2, $3);}
	| TimesToken Element Element {$$ = new ArithmeticFunctionNode(ArithmeticFunctionNode.Operation.MULTIPLICATION, $2, $3);}
	| DivideToken Element Element {$$ = new ArithmeticFunctionNode(ArithmeticFunctionNode.Operation.DIVISION, $2, $3);}
	;
OperationOnLists
	: HeadToken Element {$$ = new OperationOnListsNode(OperationOnListsNode.Operation.HEAD, $2);}
	| TailToken Element {$$ = new OperationOnListsNode(OperationOnListsNode.Operation.TAIL, $2);}
	| ConsToken Element Element {$$ = new OperationOnListsNode(OperationOnListsNode.Operation.CONS, $2, $3);}
	;
Comparison
	: EqualToken Element Element {$$ = new ComparisonNode(ComparisonNode.Operation.EQUAL, $2, $3);}
	| NonEqualToken Element Element {$$ = new ComparisonNode(ComparisonNode.Operation.NONEQUAL, $2, $3);}
	| LessToken Element Element {$$ = new ComparisonNode(ComparisonNode.Operation.LESS, $2, $3);}
	| LessEqToken Element Element {$$ = new ComparisonNode(ComparisonNode.Operation.LESSEQUAL, $2, $3);}
	| GreaterToken Element Element {$$ = new ComparisonNode(ComparisonNode.Operation.GREATER, $2, $3);}
	| GreaterEqToken Element Element {$$ = new ComparisonNode(ComparisonNode.Operation.GREATEREQUAL, $2, $3);}
	;
Predicate
	: IsIntToken Element {$$ = new PredicateNode(PredicateNode.Operation.ISINT, $2);}
	| IsRealToken Element {$$ = new PredicateNode(PredicateNode.Operation.ISREAL, $2);}
	| IsBoolToken Element {$$ = new PredicateNode(PredicateNode.Operation.ISBOOL, $2);}
	| IsNullToken Element {$$ = new PredicateNode(PredicateNode.Operation.ISNULL, $2);}
	| IsAtomToken Element {$$ = new PredicateNode(PredicateNode.Operation.ISATOM, $2);}
	| IsListToken Element {$$ = new PredicateNode(PredicateNode.Operation.ISLIST, $2);}
	;
LogicalOperator
	: AndToken Element Element {$$ = new LogicalOperatorNode(LogicalOperatorNode.Operation.AND, $2, $3);}
	| OrToken Element Element {$$ = new LogicalOperatorNode(LogicalOperatorNode.Operation.OR, $2, $3);}
	| XorToken Element Element {$$ = new LogicalOperatorNode(LogicalOperatorNode.Operation.XOR, $2, $3);}
	| NotToken Element {$$ = new LogicalOperatorNode(LogicalOperatorNode.Operation.NOT, $2);}
	;
Evaluator
	: EvalToken Element {$$ = new EvaluatorNode($2);}
	;
%%

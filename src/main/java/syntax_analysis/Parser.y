%language "Java"
%define api.package {syntax_analysis}
%define api.prefix {Parser}
%define api.parser.class {Parser}
%define api.parser.public

%code imports {
	import java.io.IOException;
	import java.io.FileReader;
}

%code {
//	private static ElementsList ast;
//    public static List<Integer> lines;
	AST ast;
            public static AST makeAST(String sourceProgramPath) throws IOException {
            	//AST ast = new AST();
            	FileReader fileReader = new FileReader(sourceProgramPath);
                LexerAdapter lexerAdapter = new LexerAdapter(fileReader);
                Parser p = new Parser(lexerAdapter);
                p.parse();
                return ast;

//                int status;
//                do {
//                    int token = l.getToken();
//                    IElement lval = l.getValue();
//                    Parser.Location yyloc = l.getLocation();
//                    status = p.push_parse(token, lval, yyloc);
//                } while (status == Parser.YYPUSH_MORE);
//                if (status != Parser.YYACCEPT) {
//                    return null;
//                }
//                return ast;
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

%start Program

%%

Program
	: Element {ast = new AST(ast.createElementList($1)); System.out.println("haha1");}
	| Element Elements {ast = new AST(ast.addElementToList($1, $2)); System.out.println("haha2");}
	;
Elements
	: /* empty */  {$$ = ast.createEmptyList();}
	| Element Elements {$$ = ast.addElementToList($1, $2);}
	;
List
	: OpenParenthesisToken Element Elements CloseParenthesisToken
	| OpenParenthesisToken SpecialForm CloseParenthesisToken
	| OpenParenthesisToken ArithmeticFunction CloseParenthesisToken
	| OpenParenthesisToken OperationOnLists CloseParenthesisToken
	| OpenParenthesisToken Comparison CloseParenthesisToken
	| OpenParenthesisToken Predicate CloseParenthesisToken
	| OpenParenthesisToken LogicalOperator CloseParenthesisToken
	| OpenParenthesisToken Evaluator CloseParenthesisToken
	;
Element
	: Atom {$$ = new ElementNode();}
	| Literal {$$ = new ElementNode();}
	| List {$$ = new ElementNode();}
	| QuoteShortToken Element {$$ = new ElementNode();}
	;
OptionalElement
	: /* empty */
	| Element
	;
Atom
	: Identifier
	;
Literal
	: IntegerNumberLiteralToken
	| RealNumberLiteralToken
	| BooleanLiteralToken
	| NullLiteralToken
	;
Identifier
	: IdentifierToken
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
	| PlusToken Element Element
	| MinusToken Element Element
	| TimesToken Element Element
	| DivideToken Element Element
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

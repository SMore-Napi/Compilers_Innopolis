package lexical;
import lexical.arithmetic_functions.DivideToken;import lexical.arithmetic_functions.MinusToken;import lexical.arithmetic_functions.PlusToken;import lexical.arithmetic_functions.TimesToken;import lexical.basic_syntax.CloseParanthesisToken;import lexical.basic_syntax.OpenParanthesisToken;import lexical.basic_syntax.QuoteShortToken;import lexical.comparisions.*;import lexical.evaluator.EvalToken;import lexical.identifier.IdentifierToken;import lexical.keywords.*;import lexical.logical_operators.AndToken;import lexical.logical_operators.NotToken;import lexical.logical_operators.OrToken;import lexical.logical_operators.XorToken;import lexical.number_literals.IntegerNumberLiteralToken;import lexical.number_literals.RealNumberLiteralToken;import lexical.operations_on_lists.ConsToken;import lexical.operations_on_lists.HeadToken;import lexical.operations_on_lists.TailToken;import lexical.predicates.*;import java.util.ArrayList;
import java.util.List;

%%

%class Lexer
%public
%unicode
%line
%column

%function tokenize
%type Token


LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

OpenBrace = [(]
CloseBrace = [)]
QuoteShort = [']
Comment = (;)

Quote = (quote)
Setq = (setq)
Func = (func)
Lambda = (lambda)
Prog = (prog)
Cond =(cond)
While = (while)
Return = (return)
Break = (break)

Plus = (plus)
Minus = (minus)
Times = (times)
Divide = (divide)

Head = (head)
Tail = (tail)
Cons = (cons)

Equal = (equal)
NonEqual = (nonequal)
Less = (less)
LessEq = (lesseq)
Greater = (greater)
GreaterEq = (greatereq)

IsInt = (isint)
IsReal = (isreal)
IsBool = (isbool)
IsNull = (isnull)
IsAtom = (isatom)
IsList = (islist)

And = (and)
Or = (or)
Xor = (xor)
Not = (not)

Eval = (eval)

IntegerNumberLiteral = -{0,1}[0-9]+
RealNumberLiteral = -{0,1}[0-9]+[.][0-9]+

Identifier = [a-zA-Z]+[[a-zA-Z]*[0-9]*]*


%{
  List<Token> list = new ArrayList<>();

  public List<Token> getList() {
      return list;
  }

  public void setList(List<Token> list) {
      this.list = list;
  }

  boolean isCommentLine = false;
%}


%%


{OpenBrace}  {if (!isCommentLine) list.add(new OpenParanthesisToken(yyline, yycolumn, yytext()));}
{CloseBrace} {if (!isCommentLine) list.add(new CloseParanthesisToken(yyline, yycolumn, yytext()));}
{Setq} {if (!isCommentLine) list.add(new SetqToken(yyline, yycolumn, yytext()));}
{QuoteShort} {if (!isCommentLine) list.add(new QuoteShortToken(yyline,yycolumn,yytext()));}
{Quote} {if (!isCommentLine) list.add(new QuoteToken(yyline,yycolumn,yytext()));}
{Setq} {if (!isCommentLine) list.add(new SetqToken(yyline,yycolumn,yytext()));}
{Func} {if (!isCommentLine) list.add(new FuncToken(yyline,yycolumn,yytext()));}
{Lambda} {if (!isCommentLine) list.add(new LambdaToken(yyline,yycolumn,yytext()));}
{Prog} {if (!isCommentLine) list.add(new ProgToken(yyline,yycolumn,yytext()));}
{Cond} {if (!isCommentLine) list.add(new CondToken(yyline,yycolumn,yytext()));}
{While} {if (!isCommentLine) list.add(new WhileToken(yyline,yycolumn,yytext()));}
{Return} {if (!isCommentLine) list.add(new ReturnToken(yyline,yycolumn,yytext()));}
{Break} {if (!isCommentLine) list.add(new BreakToken(yyline,yycolumn,yytext()));}
{Plus} {if (!isCommentLine) list.add(new PlusToken(yyline,yycolumn,yytext()));}
{Minus} {if (!isCommentLine) list.add(new MinusToken(yyline,yycolumn, yytext()));}
{Times} {if (!isCommentLine) list.add(new TimesToken(yyline,yycolumn,yytext()));}
{Divide} {if (!isCommentLine) list.add(new DivideToken(yyline,yycolumn,yytext()));}
{Head} {if (!isCommentLine) list.add(new HeadToken(yyline,yycolumn,yytext()));}
{Tail} {if (!isCommentLine) list.add(new TailToken(yyline,yycolumn,yytext()));}
{Cons} {if (!isCommentLine) list.add(new ConsToken(yyline,yycolumn,yytext()));}
{Equal} {if (!isCommentLine) list.add(new EqualToken(yyline,yycolumn,yytext()));}
{NonEqual} {if (!isCommentLine) list.add(new NonEqualToken(yyline,yycolumn,yytext()));}
{Less} {if (!isCommentLine) list.add(new LessToken(yyline,yycolumn,yytext()));}
{LessEq} {if (!isCommentLine) list.add(new LessEqToken(yyline,yycolumn,yytext()));}
{Greater} {if (!isCommentLine) list.add(new GreaterToken(yyline,yycolumn, yytext()));}
{GreaterEq} {if (!isCommentLine) list.add(new GreaterEqToken(yyline,yycolumn,yytext()));}
{IsInt} {if (!isCommentLine) list.add(new IsIntToken(yyline,yycolumn,yytext()));}
{IsReal} {if (!isCommentLine) list.add(new IsRealToken(yyline,yycolumn,yytext()));}
{IsBool} {if (!isCommentLine) list.add(new IsBoolToken(yyline,yycolumn,yytext()));}
{IsNull} {if (!isCommentLine) list.add(new IsNullToken(yyline,yycolumn,yytext()));}
{IsAtom} {if (!isCommentLine) list.add(new IsAtomToken(yyline,yycolumn,yytext()));}
{IsList} {if (!isCommentLine) list.add(new IsListToken(yyline,yycolumn,yytext()));}
{And} {if (!isCommentLine) list.add(new AndToken(yyline, yycolumn, yytext()));}
{Or} {if (!isCommentLine) list.add(new OrToken(yyline,yycolumn,yytext()));}
{Xor} {if (!isCommentLine) list.add(new XorToken(yyline,yycolumn,yytext()));}
{Not} {if (!isCommentLine) list.add(new NotToken(yyline,yycolumn,yytext()));}
{Eval} {if (!isCommentLine) list.add(new EvalToken(yyline,yycolumn,yytext()));}
{Identifier} {if (!isCommentLine) list.add(new IdentifierToken(yyline,yycolumn,yytext()));}
{IntegerNumberLiteral} {if (!isCommentLine) list.add(new IntegerNumberLiteralToken(yyline,yycolumn,yytext()));}
{RealNumberLiteral} {if (!isCommentLine) list.add(new RealNumberLiteralToken(yyline,yycolumn,yytext()));}
{Comment} {isCommentLine = true;}
{LineTerminator} {isCommentLine = false;}
{WhiteSpace} {}
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }

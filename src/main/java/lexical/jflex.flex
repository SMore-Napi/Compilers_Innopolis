package lexical;

import lexical.tokens.Token;
import lexical.tokens.arithmetic_function.DivideToken;
import lexical.tokens.arithmetic_function.MinusToken;
import lexical.tokens.arithmetic_function.PlusToken;
import lexical.tokens.arithmetic_function.TimesToken;
import lexical.tokens.parenthesis.CloseParenthesisToken;
import lexical.tokens.parenthesis.OpenParenthesisToken;
import lexical.tokens.keyword.QuoteShortToken;
import lexical.tokens.comparison.*;
import lexical.tokens.EvalToken;
import lexical.tokens.IdentifierToken;
import lexical.tokens.keyword.*;
import lexical.tokens.logical_operator.AndToken;
import lexical.tokens.logical_operator.NotToken;
import lexical.tokens.logical_operator.OrToken;
import lexical.tokens.logical_operator.XorToken;
import lexical.tokens.literal.IntegerNumberLiteralToken;
import lexical.tokens.literal.RealNumberLiteralToken;
import lexical.tokens.literal.BooleanLiteralToken;
import lexical.tokens.literal.NullLiteralToken;
import lexical.tokens.operation_on_lists.ConsToken;
import lexical.tokens.operation_on_lists.HeadToken;
import lexical.tokens.operation_on_lists.TailToken;
import lexical.tokens.predicate.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
WhiteSpace = {LineTerminator} | [ \t\f]

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
BooleanLiteral = (false|true)
NullLiteral = (null)

Identifier = [a-zA-Z]+[[a-zA-Z]*[0-9]*]*
IllegalIdentifier = [0-9]+[[a-zA-Z]*[0-9]*]*


%{
  List<Token> tokens = new ArrayList<>();

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    boolean isCommentLine = false;

    public void addToken(Class<? extends Token> className, int row, int column, String content) {
            try {
                if (!isCommentLine) {
                    Token token = className.getDeclaredConstructor(int.class, int.class, String.class).newInstance(row, column, content);
                    tokens.add(token);
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
    }

    public void printIllegalCharacterError(int row, int column, String content) {
        throw new Error(String.format("Illegal character <%s> on row=%d; column=%d", content, row, column));
    }

     public void printIllegalIdentifierError(int row, int column, String content) {
            throw new Error(String.format("Illegal Identifier name <%s> on row=%d; column=%d. The name can't start with a digit.", content, row, column));
        }
%}


%%


{OpenBrace}  {addToken(OpenParenthesisToken.class, yyline, yycolumn, yytext());}
{CloseBrace} {addToken(CloseParenthesisToken.class, yyline, yycolumn, yytext());}
{Setq} {addToken(SetqToken.class, yyline, yycolumn, yytext());}
{QuoteShort} {addToken(QuoteShortToken.class, yyline, yycolumn, yytext());}
{Quote} {addToken(QuoteToken.class, yyline, yycolumn, yytext());}
{Setq} {addToken(SetqToken.class, yyline, yycolumn, yytext());}
{Func} {addToken(FuncToken.class, yyline, yycolumn, yytext());}
{Lambda} {addToken(LambdaToken.class, yyline, yycolumn, yytext());}
{Prog} {addToken(ProgToken.class, yyline, yycolumn, yytext());}
{Cond} {addToken(CondToken.class, yyline, yycolumn, yytext());}
{While} {addToken(WhileToken.class, yyline, yycolumn, yytext());}
{Return} {addToken(ReturnToken.class, yyline, yycolumn, yytext());}
{Break} {addToken(BreakToken.class, yyline, yycolumn, yytext());}
{Plus} {addToken(PlusToken.class, yyline, yycolumn, yytext());}
{Minus} {addToken(MinusToken.class, yyline, yycolumn, yytext());}
{Times} {addToken(TimesToken.class, yyline, yycolumn, yytext());}
{Divide} {addToken(DivideToken.class, yyline, yycolumn, yytext());}
{Head} {addToken(HeadToken.class, yyline, yycolumn, yytext());}
{Tail} {addToken(TailToken.class, yyline, yycolumn, yytext());}
{Cons} {addToken(ConsToken.class, yyline, yycolumn, yytext());}
{Equal} {addToken(EqualToken.class, yyline, yycolumn, yytext());}
{NonEqual} {addToken(NonEqualToken.class, yyline, yycolumn, yytext());}
{Less} {addToken(LessToken.class, yyline, yycolumn, yytext());}
{LessEq} {addToken(LessEqToken.class, yyline, yycolumn, yytext());}
{Greater} {addToken(GreaterToken.class, yyline, yycolumn, yytext());}
{GreaterEq} {addToken(GreaterEqToken.class, yyline, yycolumn, yytext());}
{IsInt} {addToken(IsIntToken.class, yyline, yycolumn, yytext());}
{IsReal} {addToken(IsRealToken.class, yyline, yycolumn, yytext());}
{IsBool} {addToken(IsBoolToken.class, yyline, yycolumn, yytext());}
{IsNull} {addToken(IsNullToken.class, yyline, yycolumn, yytext());}
{IsAtom} {addToken(IsAtomToken.class, yyline, yycolumn, yytext());}
{IsList} {addToken(IsListToken.class, yyline, yycolumn, yytext());}
{And} {addToken(AndToken.class, yyline, yycolumn, yytext());}
{Or} {addToken(OrToken.class, yyline, yycolumn, yytext());}
{Xor} {addToken(XorToken.class, yyline, yycolumn, yytext());}
{Not} {addToken(NotToken.class, yyline, yycolumn, yytext());}
{Eval} {addToken(EvalToken.class, yyline, yycolumn, yytext());}
{IntegerNumberLiteral} {addToken(IntegerNumberLiteralToken.class, yyline, yycolumn, yytext());}
{RealNumberLiteral} {addToken(RealNumberLiteralToken.class, yyline, yycolumn, yytext());}
{BooleanLiteral} {addToken(BooleanLiteralToken.class, yyline, yycolumn, yytext());}
{NullLiteral} {addToken(NullLiteralToken.class, yyline, yycolumn, yytext());}
{Identifier} {addToken(IdentifierToken.class, yyline, yycolumn, yytext());}
{IllegalIdentifier} {printIllegalIdentifierError(yyline, yycolumn, yytext());}
{Comment} {isCommentLine = true;}
{LineTerminator} {isCommentLine = false;}
{WhiteSpace} {}
[^] {printIllegalCharacterError(yyline, yycolumn, yytext());}

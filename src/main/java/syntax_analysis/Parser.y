%language "Java"

%define api.parser.class {Parser}
%define api.value.type {Object}
%define api.parser.public
%define api.push-pull push

%define parse.error custom
%define parse.trace

%locations

%code imports {
import java.io.IOException;
import java.util.*;

}

%code {

}

%token <IntegerNumberLiteralToken> INTEGER
%token <RealNumberLiteralToken> REAL
%token <BooleanLiteralToken> BOOLEAN
%token <IdentifierToken>  IDENTIFIER

%token OPENBRACE       "("
%token CLOSEBRACE       ")"
%token QUOTE_SHORT "'"

%token <QuoteToken> QUOTE
%token <SetqToken>           SETQ
%token <FuncToken>           FUNC
%token <LambdaToken>         LAMBDA
%token <ProgToken>           PROG
%token <CondToken>           COND
%token <WhileToken>          WHILE
%token <ReturnToken>         RETURN
%token <BreakToken>          BREAK


%%

%%

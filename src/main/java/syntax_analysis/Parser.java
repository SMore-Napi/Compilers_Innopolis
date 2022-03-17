/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2021 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

package syntax_analysis;


import lexical_analysis.tokens.EvalToken;
import lexical_analysis.tokens.IdentifierToken;
import lexical_analysis.tokens.arithmetic_function.DivideToken;
import lexical_analysis.tokens.arithmetic_function.MinusToken;
import lexical_analysis.tokens.arithmetic_function.PlusToken;
import lexical_analysis.tokens.arithmetic_function.TimesToken;
import lexical_analysis.tokens.comparison.*;
import lexical_analysis.tokens.literal.BooleanLiteralToken;
import lexical_analysis.tokens.literal.IntegerNumberLiteralToken;
import lexical_analysis.tokens.literal.NullLiteralToken;
import lexical_analysis.tokens.literal.RealNumberLiteralToken;
import lexical_analysis.tokens.logical_operator.AndToken;
import lexical_analysis.tokens.logical_operator.NotToken;
import lexical_analysis.tokens.logical_operator.OrToken;
import lexical_analysis.tokens.logical_operator.XorToken;
import lexical_analysis.tokens.operation_on_lists.ConsToken;
import lexical_analysis.tokens.operation_on_lists.HeadToken;
import lexical_analysis.tokens.operation_on_lists.TailToken;
import lexical_analysis.tokens.predicate.*;
import syntax_analysis.node.*;
import syntax_analysis.node.special_form.*;

import java.io.FileReader;
import java.io.IOException;

/* "Parser.java":72  */

/**
 * A Bison parser, automatically generated from <tt>Parser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Parser {
    /**
     * Version number for the Bison executable that generated this parser.
     */
    public static final String bisonVersion = "3.8.2";

    /**
     * Name of the skeleton that generated this parser.
     */
    public static final String bisonSkeleton = "lalr1.java";
    /**
     * Returned by a Bison action in order to stop the parsing process and
     * return success (<tt>true</tt>).
     */
    public static final int YYACCEPT = 0;

    ;
    /**
     * Returned by a Bison action in order to stop the parsing process and
     * return failure (<tt>false</tt>).
     */
    public static final int YYABORT = 1;
    /**
     * Returned by a Bison action in order to start error recovery without
     * printing an error message.
     */
    public static final int YYERROR = 2;
    /**
     * Internal return codes that are not supported for user semantic
     * actions.
     */
    private static final int YYERRLAB = 3;
    private static final int YYNEWSTATE = 4;
    private static final int YYDEFAULT = 5;
    private static final int YYREDUCE = 6;
    private static final int YYERRLAB1 = 7;
    private static final int YYRETURN = 8;
    private static final byte yypact_ninf_ = -45;
    private static final byte yytable_ninf_ = -1;
    /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
       STATE-NUM.  */
    private static final byte[] yypact_ = yypact_init();
    /* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
       Performed when YYTABLE does not specify something else to do.  Zero
       means the default is an error.  */
    private static final byte[] yydefact_ = yydefact_init();
    /* YYPGOTO[NTERM-NUM].  */
    private static final byte[] yypgoto_ = yypgoto_init();
    /* YYDEFGOTO[NTERM-NUM].  */
    private static final byte[] yydefgoto_ = yydefgoto_init();
    /* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
       positive, shift that token.  If negative, reduce the rule whose
       number is the opposite.  If YYTABLE_NINF, syntax error.  */
    private static final byte[] yytable_ = yytable_init();
    private static final byte[] yycheck_ = yycheck_init();
    /* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
       state STATE-NUM.  */
    private static final byte[] yystos_ = yystos_init();
    /* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
    private static final byte[] yyr1_ = yyr1_init();
    /* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
    private static final byte[] yyr2_ = yyr2_init();
    private static final byte[] yytranslate_table_ = yytranslate_table_init();
    private static final int YYLAST_ = 150;
    private static final int YYEMPTY_ = -2;
    private static final int YYFINAL_ = 50;
    private static final int YYNTOKENS_ = 44;
    static AST ast;
    /**
     * The object doing lexical analysis for us.
     */
    private Lexer yylexer;
    private int yynerrs = 0;
    private int yyerrstatus_ = 0;

    /**
     * Instantiates the Bison-generated parser.
     *
     * @param yylexer The scanner that will supply tokens to the parser.
     */
    public Parser(Lexer yylexer) {

        this.yylexer = yylexer;

    }

    /**
     * Whether the given <code>yypact_</code> value indicates a defaulted state.
     *
     * @param yyvalue the value to check
     */
    private static boolean yyPactValueIsDefault(int yyvalue) {
        return yyvalue == yypact_ninf_;
    }

    /**
     * Whether the given <code>yytable_</code>
     * value indicates a syntax error.
     *
     * @param yyvalue the value to check
     */
    private static boolean yyTableValueIsError(int yyvalue) {
        return yyvalue == yytable_ninf_;
    }

    private static final byte[] yypact_init() {
        return new byte[]
                {
                        107, 66, -45, -45, -45, -45, -45, 107, -45, -45,
                        -45, -45, -45, -45, -45, -45, -45, -45, -45, -45,
                        -45, -45, -45, -45, -45, -45, -45, -45, -45, -45,
                        -45, -45, 6, 107, -45, -45, -45, -45, 107, -7,
                        -7, 7, 7, 107, 107, 107, -45, 107, 5, -45,
                        -45, -45, 107, -45, 107, 7, 107, 107, 107, 107,
                        -45, 8, -45, -45, -45, 107, -45, -45, 107, -45,
                        -45, -45, -45, -45
                };
    }

    private static final byte[] yydefact_init() {
        return new byte[]
                {
                        0, 0, 49, 50, 51, 52, 24, 0, 25, 26,
                        27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
                        37, 38, 39, 40, 41, 42, 43, 44, 45, 46,
                        47, 48, 0, 2, 8, 6, 7, 12, 0, 0,
                        0, 0, 0, 0, 0, 0, 23, 4, 0, 9,
                        1, 3, 4, 15, 0, 0, 0, 0, 0, 0,
                        22, 0, 11, 5, 16, 0, 18, 19, 13, 21,
                        10, 17, 14, 20
                };
    }

    private static final byte[] yypgoto_init() {
        return new byte[]
                {
                        -45, -45, -44, 0, -2, -45, -45, -35, -45
                };
    }

    private static final byte[] yydefgoto_init() {
        return new byte[]
                {
                        0, 32, 51, 52, 34, 73, 48, 35, 36
                };
    }

    private static final byte[] yytable_init() {
        return new byte[]
                {
                        33, 47, 6, 61, 54, 55, 50, 49, 63, 62,
                        1, 0, 70, 8, 9, 10, 11, 12, 13, 14,
                        15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                        25, 26, 27, 28, 29, 30, 31, 0, 53, 56,
                        57, 0, 0, 58, 59, 60, 0, 0, 0, 0,
                        0, 0, 0, 65, 64, 0, 66, 67, 68, 69,
                        0, 0, 0, 0, 0, 71, 0, 0, 72, 1,
                        37, 2, 3, 4, 5, 6, 38, 7, 39, 40,
                        41, 42, 43, 44, 45, 46, 8, 9, 10, 11,
                        12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                        22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
                        1, 0, 2, 3, 4, 5, 6, 0, 7, 0,
                        0, 0, 0, 0, 0, 0, 0, 8, 9, 10,
                        11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                        21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                        31
                };
    }

    private static final byte[] yycheck_init() {
        return new byte[]
                {
                        0, 1, 9, 47, 39, 40, 0, 7, 52, 4,
                        3, -1, 4, 20, 21, 22, 23, 24, 25, 26,
                        27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
                        37, 38, 39, 40, 41, 42, 43, -1, 38, 41,
                        42, -1, -1, 43, 44, 45, -1, -1, -1, -1,
                        -1, -1, -1, 55, 54, -1, 56, 57, 58, 59,
                        -1, -1, -1, -1, -1, 65, -1, -1, 68, 3,
                        4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                        14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
                        24, 25, 26, 27, 28, 29, 30, 31, 32, 33,
                        34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
                        3, -1, 5, 6, 7, 8, 9, -1, 11, -1,
                        -1, -1, -1, -1, -1, -1, -1, 20, 21, 22,
                        23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
                        33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
                        43
                };
    }

    private static final byte[] yystos_init() {
        return new byte[]
                {
                        0, 3, 5, 6, 7, 8, 9, 11, 20, 21,
                        22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
                        32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
                        42, 43, 45, 47, 48, 51, 52, 4, 10, 12,
                        13, 14, 15, 16, 17, 18, 19, 47, 50, 47,
                        0, 46, 47, 47, 51, 51, 48, 48, 47, 47,
                        47, 46, 4, 46, 47, 48, 47, 47, 47, 47,
                        4, 47, 47, 49
                };
    }

    private static final byte[] yyr1_init() {
        return new byte[]
                {
                        0, 44, 45, 45, 46, 46, 47, 47, 47, 47,
                        48, 48, 48, 49, 49, 50, 50, 50, 50, 50,
                        50, 50, 50, 50, 51, 51, 51, 51, 51, 51,
                        51, 51, 51, 51, 51, 51, 51, 51, 51, 51,
                        51, 51, 51, 51, 51, 51, 51, 51, 51, 52,
                        52, 52, 52
                };
    }

    private static final byte[] yyr2_init() {
        return new byte[]
                {
                        0, 2, 1, 2, 0, 2, 1, 1, 1, 2,
                        4, 3, 2, 0, 1, 2, 3, 4, 3, 3,
                        4, 3, 2, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1
                };
    }

    /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
       as returned by yylex, with out-of-bounds checking.  */
    private static final SymbolKind yytranslate_(int t) {
        // Last valid token kind.
        int code_max = 298;
        if (t <= 0)
            return SymbolKind.S_YYEOF;
        else if (t <= code_max)
            return SymbolKind.get(yytranslate_table_[t]);
        else
            return SymbolKind.S_YYUNDEF;
    }

    private static final byte[] yytranslate_table_init() {
        return new byte[]
                {
                        0, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 1, 2, 3, 4,
                        5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                        15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                        25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
                        35, 36, 37, 38, 39, 40, 41, 42, 43
                };
    }

    public static AST makeAST(String sourceProgramPath) throws IOException {
        FileReader fileReader = new FileReader(sourceProgramPath);
        LexerAdapter lexerAdapter = new LexerAdapter(fileReader);
        Parser p = new Parser(lexerAdapter);
        p.parse();
        return ast;
    }

    /**
     * The number of syntax errors so far.
     */
    public final int getNumberOfErrors() {
        return yynerrs;
    }

    /**
     * Print an error message via the lexer.
     *
     * @param msg The error message.
     */
    public final void yyerror(String msg) {
        yylexer.yyerror(msg);
    }

    /**
     * Whether error recovery is being done.  In this state, the parser
     * reads token until it reaches a known state, and then restarts normal
     * operation.
     */
    public final boolean recovering() {
        return yyerrstatus_ == 0;
    }

    /**
     * Compute post-reduction state.
     *
     * @param yystate the current state
     * @param yysym   the nonterminal to push on the stack
     */
    private int yyLRGotoState(int yystate, int yysym) {
        int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
        if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
            return yytable_[yyr];
        else
            return yydefgoto_[yysym - YYNTOKENS_];
    }

    private int yyaction(int yyn, YYStack yystack, int yylen) {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
        Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);

        switch (yyn) {
            case 2: /* Program: Element  */
                if (yyn == 2)
                    /* "Parser.y":102  */ {
                    ast = new AST(new ListNode(((ElementInterface) (yystack.valueAt(0)))));
                }
                ;
                break;


            case 3: /* Program: Element Elements  */
                if (yyn == 3)
                    /* "Parser.y":103  */ {
                    ast = new AST(new ListNode(((ElementInterface) (yystack.valueAt(1))), ((ListNode) (yystack.valueAt(0)))));
                }
                ;
                break;


            case 4: /* Elements: %empty  */
                if (yyn == 4)
                    /* "Parser.y":106  */ {
                    yyval = new ListNode();
                }
                ;
                break;


            case 5: /* Elements: Element Elements  */
                if (yyn == 5)
                    /* "Parser.y":107  */ {
                    yyval = new ListNode(((ElementInterface) (yystack.valueAt(1))), ((ListNode) (yystack.valueAt(0))));
                }
                ;
                break;


            case 6: /* Element: Atom  */
                if (yyn == 6)
                    /* "Parser.y":110  */ {
                    yyval = ((AtomNode) (yystack.valueAt(0)));
                }
                ;
                break;


            case 7: /* Element: Literal  */
                if (yyn == 7)
                    /* "Parser.y":111  */ {
                    yyval = ((LiteralNode) (yystack.valueAt(0)));
                }
                ;
                break;


            case 8: /* Element: List  */
                if (yyn == 8)
                    /* "Parser.y":112  */ {
                    yyval = ((ElementInterface) (yystack.valueAt(0)));
                }
                ;
                break;


            case 9: /* Element: QuoteShortToken Element  */
                if (yyn == 9)
                    /* "Parser.y":113  */ {
                    yyval = new QuoteNode(((ElementInterface) (yystack.valueAt(0))));
                }
                ;
                break;


            case 10: /* List: OpenParenthesisToken Element Elements CloseParenthesisToken  */
                if (yyn == 10)
                    /* "Parser.y":116  */ {
                    yyval = new ListNode(((ElementInterface) (yystack.valueAt(2))), ((ListNode) (yystack.valueAt(1))));
                }
                ;
                break;


            case 11: /* List: OpenParenthesisToken SpecialForm CloseParenthesisToken  */
                if (yyn == 11)
                    /* "Parser.y":117  */ {
                    yyval = ((ElementInterface) (yystack.valueAt(1)));
                }
                ;
                break;


            case 12: /* List: OpenParenthesisToken CloseParenthesisToken  */
                if (yyn == 12)
                    /* "Parser.y":118  */ {
                    yyval = new ListNode();
                }
                ;
                break;


            case 13: /* OptionalElement: %empty  */
                if (yyn == 13)
                    /* "Parser.y":121  */ {
                    yyval = null;
                }
                ;
                break;


            case 14: /* OptionalElement: Element  */
                if (yyn == 14)
                    /* "Parser.y":122  */ {
                    yyval = ((ElementInterface) (yystack.valueAt(0)));
                }
                ;
                break;


            case 15: /* SpecialForm: QuoteToken Element  */
                if (yyn == 15)
                    /* "Parser.y":125  */ {
                    yyval = new QuoteNode(((ElementInterface) (yystack.valueAt(0))));
                }
                ;
                break;


            case 16: /* SpecialForm: SetQToken Atom Element  */
                if (yyn == 16)
                    /* "Parser.y":126  */ {
                    yyval = new SetQNode(((AtomNode) (yystack.valueAt(1))), ((ElementInterface) (yystack.valueAt(0))));
                }
                ;
                break;


            case 17: /* SpecialForm: FuncToken Atom List Element  */
                if (yyn == 17)
                    /* "Parser.y":127  */ {
                    yyval = new FuncNode(((AtomNode) (yystack.valueAt(2))), ((ElementInterface) (yystack.valueAt(1))), ((ElementInterface) (yystack.valueAt(0))));
                }
                ;
                break;


            case 18: /* SpecialForm: LambdaToken List Element  */
                if (yyn == 18)
                    /* "Parser.y":128  */ {
                    yyval = new LambdaNode(((ElementInterface) (yystack.valueAt(1))), ((ElementInterface) (yystack.valueAt(0))));
                }
                ;
                break;


            case 19: /* SpecialForm: ProgToken List Element  */
                if (yyn == 19)
                    /* "Parser.y":129  */ {
                    yyval = new ProgNode(((ElementInterface) (yystack.valueAt(1))), ((ElementInterface) (yystack.valueAt(0))));
                }
                ;
                break;


            case 20: /* SpecialForm: CondToken Element Element OptionalElement  */
                if (yyn == 20)
                    /* "Parser.y":130  */ {
                    yyval = new CondNode(((ElementInterface) (yystack.valueAt(2))), ((ElementInterface) (yystack.valueAt(1))), ((ElementInterface) (yystack.valueAt(0))));
                }
                ;
                break;


            case 21: /* SpecialForm: WhileToken Element Element  */
                if (yyn == 21)
                    /* "Parser.y":131  */ {
                    yyval = new WhileNode(((ElementInterface) (yystack.valueAt(1))), ((ElementInterface) (yystack.valueAt(0))));
                }
                ;
                break;


            case 22: /* SpecialForm: ReturnToken Element  */
                if (yyn == 22)
                    /* "Parser.y":132  */ {
                    yyval = new ReturnNode(((ElementInterface) (yystack.valueAt(0))));
                }
                ;
                break;


            case 23: /* SpecialForm: BreakToken  */
                if (yyn == 23)
                    /* "Parser.y":133  */ {
                    yyval = new BreakNode();
                }
                ;
                break;


            case 24: /* Atom: IdentifierToken  */
                if (yyn == 24)
                    /* "Parser.y":136  */ {
                    yyval = new AtomNode(((IdentifierToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 25: /* Atom: PlusToken  */
                if (yyn == 25)
                    /* "Parser.y":137  */ {
                    yyval = new AtomNode(((PlusToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 26: /* Atom: MinusToken  */
                if (yyn == 26)
                    /* "Parser.y":138  */ {
                    yyval = new AtomNode(((MinusToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 27: /* Atom: TimesToken  */
                if (yyn == 27)
                    /* "Parser.y":139  */ {
                    yyval = new AtomNode(((TimesToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 28: /* Atom: DivideToken  */
                if (yyn == 28)
                    /* "Parser.y":140  */ {
                    yyval = new AtomNode(((DivideToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 29: /* Atom: HeadToken  */
                if (yyn == 29)
                    /* "Parser.y":141  */ {
                    yyval = new AtomNode(((HeadToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 30: /* Atom: TailToken  */
                if (yyn == 30)
                    /* "Parser.y":142  */ {
                    yyval = new AtomNode(((TailToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 31: /* Atom: ConsToken  */
                if (yyn == 31)
                    /* "Parser.y":143  */ {
                    yyval = new AtomNode(((ConsToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 32: /* Atom: EqualToken  */
                if (yyn == 32)
                    /* "Parser.y":144  */ {
                    yyval = new AtomNode(((EqualToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 33: /* Atom: NonEqualToken  */
                if (yyn == 33)
                    /* "Parser.y":145  */ {
                    yyval = new AtomNode(((NonEqualToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 34: /* Atom: LessToken  */
                if (yyn == 34)
                    /* "Parser.y":146  */ {
                    yyval = new AtomNode(((LessToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 35: /* Atom: LessEqToken  */
                if (yyn == 35)
                    /* "Parser.y":147  */ {
                    yyval = new AtomNode(((LessEqToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 36: /* Atom: GreaterToken  */
                if (yyn == 36)
                    /* "Parser.y":148  */ {
                    yyval = new AtomNode(((GreaterToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 37: /* Atom: GreaterEqToken  */
                if (yyn == 37)
                    /* "Parser.y":149  */ {
                    yyval = new AtomNode(((GreaterEqToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 38: /* Atom: IsIntToken  */
                if (yyn == 38)
                    /* "Parser.y":150  */ {
                    yyval = new AtomNode(((IsIntToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 39: /* Atom: IsRealToken  */
                if (yyn == 39)
                    /* "Parser.y":151  */ {
                    yyval = new AtomNode(((IsRealToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 40: /* Atom: IsBoolToken  */
                if (yyn == 40)
                    /* "Parser.y":152  */ {
                    yyval = new AtomNode(((IsBoolToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 41: /* Atom: IsNullToken  */
                if (yyn == 41)
                    /* "Parser.y":153  */ {
                    yyval = new AtomNode(((IsNullToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 42: /* Atom: IsAtomToken  */
                if (yyn == 42)
                    /* "Parser.y":154  */ {
                    yyval = new AtomNode(((IsAtomToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 43: /* Atom: IsListToken  */
                if (yyn == 43)
                    /* "Parser.y":155  */ {
                    yyval = new AtomNode(((IsListToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 44: /* Atom: AndToken  */
                if (yyn == 44)
                    /* "Parser.y":156  */ {
                    yyval = new AtomNode(((AndToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 45: /* Atom: OrToken  */
                if (yyn == 45)
                    /* "Parser.y":157  */ {
                    yyval = new AtomNode(((OrToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 46: /* Atom: XorToken  */
                if (yyn == 46)
                    /* "Parser.y":158  */ {
                    yyval = new AtomNode(((XorToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 47: /* Atom: NotToken  */
                if (yyn == 47)
                    /* "Parser.y":159  */ {
                    yyval = new AtomNode(((NotToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 48: /* Atom: EvalToken  */
                if (yyn == 48)
                    /* "Parser.y":160  */ {
                    yyval = new AtomNode(((EvalToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 49: /* Literal: IntegerNumberLiteralToken  */
                if (yyn == 49)
                    /* "Parser.y":163  */ {
                    yyval = new LiteralNode(((IntegerNumberLiteralToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 50: /* Literal: RealNumberLiteralToken  */
                if (yyn == 50)
                    /* "Parser.y":164  */ {
                    yyval = new LiteralNode(((RealNumberLiteralToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 51: /* Literal: BooleanLiteralToken  */
                if (yyn == 51)
                    /* "Parser.y":165  */ {
                    yyval = new LiteralNode(((BooleanLiteralToken) (yystack.valueAt(0))));
                }
                ;
                break;


            case 52: /* Literal: NullLiteralToken  */
                if (yyn == 52)
                    /* "Parser.y":166  */ {
                    yyval = new LiteralNode(((NullLiteralToken) (yystack.valueAt(0))));
                }
                ;
                break;



            /* "Parser.java":930  */

            default:
                break;
        }

        yystack.pop(yylen);
        yylen = 0;
        /* Shift the result of the reduction.  */
        int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
        yystack.push(yystate, yyval);
        return YYNEWSTATE;
    }

    /**
     * Parse input from the scanner that was specified at object construction
     * time.  Return whether the end of the input was reached successfully.
     *
     * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
     * imply that there were no syntax errors.
     */
    public boolean parse() throws java.io.IOException {


        /* Lookahead token kind.  */
        int yychar = YYEMPTY_;
        /* Lookahead symbol kind.  */
        SymbolKind yytoken = null;

        /* State.  */
        int yyn = 0;
        int yylen = 0;
        int yystate = 0;
        YYStack yystack = new YYStack();
        int label = YYNEWSTATE;



        /* Semantic value of the lookahead.  */
        Object yylval = null;


        yyerrstatus_ = 0;
        yynerrs = 0;

        /* Initialize the stack.  */
        yystack.push(yystate, yylval);


        for (; ; )
            switch (label) {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
                case YYNEWSTATE:

                    /* Accept?  */
                    if (yystate == YYFINAL_)
                        return true;

                    /* Take a decision.  First try without lookahead.  */
                    yyn = yypact_[yystate];
                    if (yyPactValueIsDefault(yyn)) {
                        label = YYDEFAULT;
                        break;
                    }

                    /* Read a lookahead token.  */
                    if (yychar == YYEMPTY_) {

                        yychar = yylexer.yylex();
                        yylval = yylexer.getLVal();

                    }

                    /* Convert token to internal form.  */
                    yytoken = yytranslate_(yychar);

                    if (yytoken == SymbolKind.S_YYerror) {
                        // The scanner already issued an error message, process directly
                        // to error recovery.  But do not keep the error token as
                        // lookahead, it is too special and may lead us to an endless
                        // loop in error recovery. */
                        yychar = Lexer.YYUNDEF;
                        yytoken = SymbolKind.S_YYUNDEF;
                        label = YYERRLAB1;
                    } else {
            /* If the proper action on seeing token YYTOKEN is to reduce or to
               detect an error, take that action.  */
                        yyn += yytoken.getCode();
                        if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode()) {
                            label = YYDEFAULT;
                        }

                        /* <= 0 means reduce or error.  */
                        else if ((yyn = yytable_[yyn]) <= 0) {
                            if (yyTableValueIsError(yyn)) {
                                label = YYERRLAB;
                            } else {
                                yyn = -yyn;
                                label = YYREDUCE;
                            }
                        } else {
                            /* Shift the lookahead token.  */
                            /* Discard the token being shifted.  */
                            yychar = YYEMPTY_;

                /* Count tokens shifted since error; after three, turn off error
                   status.  */
                            if (yyerrstatus_ > 0)
                                --yyerrstatus_;

                            yystate = yyn;
                            yystack.push(yystate, yylval);
                            label = YYNEWSTATE;
                        }
                    }
                    break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
                case YYDEFAULT:
                    yyn = yydefact_[yystate];
                    if (yyn == 0)
                        label = YYERRLAB;
                    else
                        label = YYREDUCE;
                    break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
                case YYREDUCE:
                    yylen = yyr2_[yyn];
                    label = yyaction(yyn, yystack, yylen);
                    yystate = yystack.stateAt(0);
                    break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
                case YYERRLAB:
                    /* If not already recovering from an error, report this error.  */
                    if (yyerrstatus_ == 0) {
                        ++yynerrs;
                        if (yychar == YYEMPTY_)
                            yytoken = null;
                        yyreportSyntaxError(new Context(this, yystack, yytoken));
                    }

                    if (yyerrstatus_ == 3) {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

                        if (yychar <= Lexer.YYEOF) {
                            /* Return failure if at end of input.  */
                            if (yychar == Lexer.YYEOF)
                                return false;
                        } else
                            yychar = YYEMPTY_;
                    }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
                    label = YYERRLAB1;
                    break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
                case YYERROR:
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
                    yystack.pop(yylen);
                    yylen = 0;
                    yystate = yystack.stateAt(0);
                    label = YYERRLAB1;
                    break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
                case YYERRLAB1:
                    yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

                    // Pop stack until we find a state that shifts the error token.
                    for (; ; ) {
                        yyn = yypact_[yystate];
                        if (!yyPactValueIsDefault(yyn)) {
                            yyn += SymbolKind.S_YYerror.getCode();
                            if (0 <= yyn && yyn <= YYLAST_
                                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode()) {
                                yyn = yytable_[yyn];
                                if (0 < yyn)
                                    break;
                            }
                        }

                        /* Pop the current state because it cannot handle the
                         * error token.  */
                        if (yystack.height == 0)
                            return false;


                        yystack.pop();
                        yystate = yystack.stateAt(0);
                    }

                    if (label == YYABORT)
                        /* Leave the switch.  */
                        break;



                    /* Shift the error token.  */

                    yystate = yyn;
                    yystack.push(yyn, yylval);
                    label = YYNEWSTATE;
                    break;

                /* Accept.  */
                case YYACCEPT:
                    return true;

                /* Abort.  */
                case YYABORT:
                    return false;
            }
    }

    /**
     * Build and emit a "syntax error" message in a user-defined way.
     *
     * @param ctx The context of the error.
     */
    private void yyreportSyntaxError(Context yyctx) {
        yyerror("syntax error");
    }

    public enum SymbolKind {
        S_YYEOF(0),                    /* "end of file"  */
        S_YYerror(1),                  /* error  */
        S_YYUNDEF(2),                  /* "invalid token"  */
        S_OpenParenthesisToken(3),     /* OpenParenthesisToken  */
        S_CloseParenthesisToken(4),    /* CloseParenthesisToken  */
        S_IntegerNumberLiteralToken(5), /* IntegerNumberLiteralToken  */
        S_RealNumberLiteralToken(6),   /* RealNumberLiteralToken  */
        S_BooleanLiteralToken(7),      /* BooleanLiteralToken  */
        S_NullLiteralToken(8),         /* NullLiteralToken  */
        S_IdentifierToken(9),          /* IdentifierToken  */
        S_QuoteToken(10),              /* QuoteToken  */
        S_QuoteShortToken(11),         /* QuoteShortToken  */
        S_SetQToken(12),               /* SetQToken  */
        S_FuncToken(13),               /* FuncToken  */
        S_LambdaToken(14),             /* LambdaToken  */
        S_ProgToken(15),               /* ProgToken  */
        S_CondToken(16),               /* CondToken  */
        S_WhileToken(17),              /* WhileToken  */
        S_ReturnToken(18),             /* ReturnToken  */
        S_BreakToken(19),              /* BreakToken  */
        S_PlusToken(20),               /* PlusToken  */
        S_MinusToken(21),              /* MinusToken  */
        S_TimesToken(22),              /* TimesToken  */
        S_DivideToken(23),             /* DivideToken  */
        S_HeadToken(24),               /* HeadToken  */
        S_TailToken(25),               /* TailToken  */
        S_ConsToken(26),               /* ConsToken  */
        S_EqualToken(27),              /* EqualToken  */
        S_NonEqualToken(28),           /* NonEqualToken  */
        S_LessToken(29),               /* LessToken  */
        S_LessEqToken(30),             /* LessEqToken  */
        S_GreaterToken(31),            /* GreaterToken  */
        S_GreaterEqToken(32),          /* GreaterEqToken  */
        S_IsIntToken(33),              /* IsIntToken  */
        S_IsRealToken(34),             /* IsRealToken  */
        S_IsBoolToken(35),             /* IsBoolToken  */
        S_IsNullToken(36),             /* IsNullToken  */
        S_IsAtomToken(37),             /* IsAtomToken  */
        S_IsListToken(38),             /* IsListToken  */
        S_AndToken(39),                /* AndToken  */
        S_OrToken(40),                 /* OrToken  */
        S_XorToken(41),                /* XorToken  */
        S_NotToken(42),                /* NotToken  */
        S_EvalToken(43),               /* EvalToken  */
        S_YYACCEPT(44),                /* $accept  */
        S_Program(45),                 /* Program  */
        S_Elements(46),                /* Elements  */
        S_Element(47),                 /* Element  */
        S_List(48),                    /* List  */
        S_OptionalElement(49),         /* OptionalElement  */
        S_SpecialForm(50),             /* SpecialForm  */
        S_Atom(51),                    /* Atom  */
        S_Literal(52);                 /* Literal  */


        private static final SymbolKind[] values_ = {
                SymbolKind.S_YYEOF,
                SymbolKind.S_YYerror,
                SymbolKind.S_YYUNDEF,
                SymbolKind.S_OpenParenthesisToken,
                SymbolKind.S_CloseParenthesisToken,
                SymbolKind.S_IntegerNumberLiteralToken,
                SymbolKind.S_RealNumberLiteralToken,
                SymbolKind.S_BooleanLiteralToken,
                SymbolKind.S_NullLiteralToken,
                SymbolKind.S_IdentifierToken,
                SymbolKind.S_QuoteToken,
                SymbolKind.S_QuoteShortToken,
                SymbolKind.S_SetQToken,
                SymbolKind.S_FuncToken,
                SymbolKind.S_LambdaToken,
                SymbolKind.S_ProgToken,
                SymbolKind.S_CondToken,
                SymbolKind.S_WhileToken,
                SymbolKind.S_ReturnToken,
                SymbolKind.S_BreakToken,
                SymbolKind.S_PlusToken,
                SymbolKind.S_MinusToken,
                SymbolKind.S_TimesToken,
                SymbolKind.S_DivideToken,
                SymbolKind.S_HeadToken,
                SymbolKind.S_TailToken,
                SymbolKind.S_ConsToken,
                SymbolKind.S_EqualToken,
                SymbolKind.S_NonEqualToken,
                SymbolKind.S_LessToken,
                SymbolKind.S_LessEqToken,
                SymbolKind.S_GreaterToken,
                SymbolKind.S_GreaterEqToken,
                SymbolKind.S_IsIntToken,
                SymbolKind.S_IsRealToken,
                SymbolKind.S_IsBoolToken,
                SymbolKind.S_IsNullToken,
                SymbolKind.S_IsAtomToken,
                SymbolKind.S_IsListToken,
                SymbolKind.S_AndToken,
                SymbolKind.S_OrToken,
                SymbolKind.S_XorToken,
                SymbolKind.S_NotToken,
                SymbolKind.S_EvalToken,
                SymbolKind.S_YYACCEPT,
                SymbolKind.S_Program,
                SymbolKind.S_Elements,
                SymbolKind.S_Element,
                SymbolKind.S_List,
                SymbolKind.S_OptionalElement,
                SymbolKind.S_SpecialForm,
                SymbolKind.S_Atom,
                SymbolKind.S_Literal
        };
        /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
           First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.  */
        private static final String[] yytname_ = yytname_init();
        private final int yycode_;

        SymbolKind(int n) {
            this.yycode_ = n;
        }

        static final SymbolKind get(int code) {
            return values_[code];
        }

        /* Return YYSTR after stripping away unnecessary quotes and
           backslashes, so that it's suitable for yyerror.  The heuristic is
           that double-quoting is unnecessary unless the string contains an
           apostrophe, a comma, or backslash (other than backslash-backslash).
           YYSTR is taken from yytname.  */
        private static String yytnamerr_(String yystr) {
            if (yystr.charAt(0) == '"') {
                StringBuffer yyr = new StringBuffer();
                strip_quotes:
                for (int i = 1; i < yystr.length(); i++)
                    switch (yystr.charAt(i)) {
                        case '\'':
                        case ',':
                            break strip_quotes;

                        case '\\':
                            if (yystr.charAt(++i) != '\\')
                                break strip_quotes;
                            /* Fall through.  */
                        default:
                            yyr.append(yystr.charAt(i));
                            break;

                        case '"':
                            return yyr.toString();
                    }
            }
            return yystr;
        }

        private static final String[] yytname_init() {
            return new String[]
                    {
                            "\"end of file\"", "error", "\"invalid token\"", "OpenParenthesisToken",
                            "CloseParenthesisToken", "IntegerNumberLiteralToken",
                            "RealNumberLiteralToken", "BooleanLiteralToken", "NullLiteralToken",
                            "IdentifierToken", "QuoteToken", "QuoteShortToken", "SetQToken",
                            "FuncToken", "LambdaToken", "ProgToken", "CondToken", "WhileToken",
                            "ReturnToken", "BreakToken", "PlusToken", "MinusToken", "TimesToken",
                            "DivideToken", "HeadToken", "TailToken", "ConsToken", "EqualToken",
                            "NonEqualToken", "LessToken", "LessEqToken", "GreaterToken",
                            "GreaterEqToken", "IsIntToken", "IsRealToken", "IsBoolToken",
                            "IsNullToken", "IsAtomToken", "IsListToken", "AndToken", "OrToken",
                            "XorToken", "NotToken", "EvalToken", "$accept", "Program", "Elements",
                            "Element", "List", "OptionalElement", "SpecialForm", "Atom", "Literal", null
                    };
        }

        public final int getCode() {
            return this.yycode_;
        }

        /* The user-facing name of this symbol.  */
        public final String getName() {
            return yytnamerr_(yytname_[yycode_]);
        }

    }

    /**
     * Communication interface between the scanner and the Bison-generated
     * parser <tt>Parser</tt>.
     */
    public interface Lexer {
        /* Token kinds.  */
        /**
         * Token "end of file", to be returned by the scanner.
         */
        static final int YYEOF = 0;
        /**
         * Token error, to be returned by the scanner.
         */
        static final int YYerror = 256;
        /**
         * Token "invalid token", to be returned by the scanner.
         */
        static final int YYUNDEF = 257;
        /**
         * Token OpenParenthesisToken, to be returned by the scanner.
         */
        static final int OpenParenthesisToken = 258;
        /**
         * Token CloseParenthesisToken, to be returned by the scanner.
         */
        static final int CloseParenthesisToken = 259;
        /**
         * Token IntegerNumberLiteralToken, to be returned by the scanner.
         */
        static final int IntegerNumberLiteralToken = 260;
        /**
         * Token RealNumberLiteralToken, to be returned by the scanner.
         */
        static final int RealNumberLiteralToken = 261;
        /**
         * Token BooleanLiteralToken, to be returned by the scanner.
         */
        static final int BooleanLiteralToken = 262;
        /**
         * Token NullLiteralToken, to be returned by the scanner.
         */
        static final int NullLiteralToken = 263;
        /**
         * Token IdentifierToken, to be returned by the scanner.
         */
        static final int IdentifierToken = 264;
        /**
         * Token QuoteToken, to be returned by the scanner.
         */
        static final int QuoteToken = 265;
        /**
         * Token QuoteShortToken, to be returned by the scanner.
         */
        static final int QuoteShortToken = 266;
        /**
         * Token SetQToken, to be returned by the scanner.
         */
        static final int SetQToken = 267;
        /**
         * Token FuncToken, to be returned by the scanner.
         */
        static final int FuncToken = 268;
        /**
         * Token LambdaToken, to be returned by the scanner.
         */
        static final int LambdaToken = 269;
        /**
         * Token ProgToken, to be returned by the scanner.
         */
        static final int ProgToken = 270;
        /**
         * Token CondToken, to be returned by the scanner.
         */
        static final int CondToken = 271;
        /**
         * Token WhileToken, to be returned by the scanner.
         */
        static final int WhileToken = 272;
        /**
         * Token ReturnToken, to be returned by the scanner.
         */
        static final int ReturnToken = 273;
        /**
         * Token BreakToken, to be returned by the scanner.
         */
        static final int BreakToken = 274;
        /**
         * Token PlusToken, to be returned by the scanner.
         */
        static final int PlusToken = 275;
        /**
         * Token MinusToken, to be returned by the scanner.
         */
        static final int MinusToken = 276;
        /**
         * Token TimesToken, to be returned by the scanner.
         */
        static final int TimesToken = 277;
        /**
         * Token DivideToken, to be returned by the scanner.
         */
        static final int DivideToken = 278;
        /**
         * Token HeadToken, to be returned by the scanner.
         */
        static final int HeadToken = 279;
        /**
         * Token TailToken, to be returned by the scanner.
         */
        static final int TailToken = 280;
        /**
         * Token ConsToken, to be returned by the scanner.
         */
        static final int ConsToken = 281;
        /**
         * Token EqualToken, to be returned by the scanner.
         */
        static final int EqualToken = 282;
        /**
         * Token NonEqualToken, to be returned by the scanner.
         */
        static final int NonEqualToken = 283;
        /**
         * Token LessToken, to be returned by the scanner.
         */
        static final int LessToken = 284;
        /**
         * Token LessEqToken, to be returned by the scanner.
         */
        static final int LessEqToken = 285;
        /**
         * Token GreaterToken, to be returned by the scanner.
         */
        static final int GreaterToken = 286;
        /**
         * Token GreaterEqToken, to be returned by the scanner.
         */
        static final int GreaterEqToken = 287;
        /**
         * Token IsIntToken, to be returned by the scanner.
         */
        static final int IsIntToken = 288;
        /**
         * Token IsRealToken, to be returned by the scanner.
         */
        static final int IsRealToken = 289;
        /**
         * Token IsBoolToken, to be returned by the scanner.
         */
        static final int IsBoolToken = 290;
        /**
         * Token IsNullToken, to be returned by the scanner.
         */
        static final int IsNullToken = 291;
        /**
         * Token IsAtomToken, to be returned by the scanner.
         */
        static final int IsAtomToken = 292;
        /**
         * Token IsListToken, to be returned by the scanner.
         */
        static final int IsListToken = 293;
        /**
         * Token AndToken, to be returned by the scanner.
         */
        static final int AndToken = 294;
        /**
         * Token OrToken, to be returned by the scanner.
         */
        static final int OrToken = 295;
        /**
         * Token XorToken, to be returned by the scanner.
         */
        static final int XorToken = 296;
        /**
         * Token NotToken, to be returned by the scanner.
         */
        static final int NotToken = 297;
        /**
         * Token EvalToken, to be returned by the scanner.
         */
        static final int EvalToken = 298;

        /**
         * Deprecated, use YYEOF instead.
         */
        public static final int EOF = YYEOF;


        /**
         * Method to retrieve the semantic value of the last scanned token.
         *
         * @return the semantic value of the last scanned token.
         */
        Object getLVal();

        /**
         * Entry point for the scanner.  Returns the token identifier corresponding
         * to the next token and prepares to return the semantic value
         * of the token.
         *
         * @return the token identifier corresponding to the next token.
         */
        int yylex() throws java.io.IOException;

        /**
         * Emit an errorin a user-defined way.
         *
         * @param msg The string for the error message.
         */
        void yyerror(String msg);


    }

    /* Unqualified %code blocks.  */
    /* "Parser.y":34  */

    /**
     * Information needed to get the list of expected tokens and to forge
     * a syntax error diagnostic.
     */
    public static final class Context {
        static final int NTOKENS = Parser.YYNTOKENS_;
        private Parser yyparser;
        private YYStack yystack;
        private SymbolKind yytoken;

        Context(Parser parser, YYStack stack, SymbolKind token) {
            yyparser = parser;
            yystack = stack;
            yytoken = token;
        }

        /**
         * The symbol kind of the lookahead token.
         */
        public final SymbolKind getToken() {
            return yytoken;
        }

        /**
         * Put in YYARG at most YYARGN of the expected tokens given the
         * current YYCTX, and return the number of tokens stored in YYARG.  If
         * YYARG is null, return the number of expected tokens (guaranteed to
         * be less than YYNTOKENS).
         */
        int getExpectedTokens(SymbolKind yyarg[], int yyargn) {
            return getExpectedTokens(yyarg, 0, yyargn);
        }

        int getExpectedTokens(SymbolKind yyarg[], int yyoffset, int yyargn) {
            int yycount = yyoffset;
            int yyn = yypact_[this.yystack.stateAt(0)];
            if (!yyPactValueIsDefault(yyn)) {
          /* Start YYX at -YYN if negative to avoid negative
             indexes in YYCHECK.  In other words, skip the first
             -YYN actions for this state because they are default
             actions.  */
                int yyxbegin = yyn < 0 ? -yyn : 0;
                /* Stay within bounds of both yycheck and yytname.  */
                int yychecklim = YYLAST_ - yyn + 1;
                int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
                for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
                    if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                            && !yyTableValueIsError(yytable_[yyx + yyn])) {
                        if (yyarg == null)
                            yycount += 1;
                        else if (yycount == yyargn)
                            return 0; // FIXME: this is incorrect.
                        else
                            yyarg[yycount++] = SymbolKind.get(yyx);
                    }
            }
            if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
                yyarg[yycount] = null;
            return yycount - yyoffset;
        }
    }

    private final class YYStack {
        public int size = 16;
        public int height = -1;
        private int[] stateStack = new int[16];
        private Object[] valueStack = new Object[16];

        public final void push(int state, Object value) {
            height++;
            if (size == height) {
                int[] newStateStack = new int[size * 2];
                System.arraycopy(stateStack, 0, newStateStack, 0, height);
                stateStack = newStateStack;

                Object[] newValueStack = new Object[size * 2];
                System.arraycopy(valueStack, 0, newValueStack, 0, height);
                valueStack = newValueStack;

                size *= 2;
            }

            stateStack[height] = state;
            valueStack[height] = value;
        }

        public final void pop() {
            pop(1);
        }

        public final void pop(int num) {
            // Avoid memory leaks... garbage collection is a white lie!
            if (0 < num) {
                java.util.Arrays.fill(valueStack, height - num + 1, height + 1, null);
            }
            height -= num;
        }

        public final int stateAt(int i) {
            return stateStack[height - i];
        }

        public final Object valueAt(int i) {
            return valueStack[height - i];
        }

        // Print the state stack on the debug stream.
        public void print(java.io.PrintStream out) {
            out.print("Stack now");

            for (int i = 0; i <= height; i++) {
                out.print(' ');
                out.print(stateStack[i]);
            }
            out.println();
        }
    }

    /* "Parser.java":1514  */

}
/* "Parser.y":168  */


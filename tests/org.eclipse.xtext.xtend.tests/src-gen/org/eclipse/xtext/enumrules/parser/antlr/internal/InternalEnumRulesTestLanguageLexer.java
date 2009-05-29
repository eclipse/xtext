package org.eclipse.xtext.enumrules.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEnumRulesTestLanguageLexer extends Lexer {
    public static final int RULE_ML_COMMENT=7;
    public static final int T14=14;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int T11=11;
    public static final int T15=15;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int T12=12;
    public static final int Tokens=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T13=13;
    public InternalEnumRulesTestLanguageLexer() {;} 
    public InternalEnumRulesTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:10:5: ( 'existing' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:10:7: 'existing'
            {
            match("existing"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:11:5: ( 'generated' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:11:7: 'generated'
            {
            match("generated"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:12:5: ( 'SameName' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:12:7: 'SameName'
            {
            match("SameName"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:13:5: ( 'overridden' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:13:7: 'overridden'
            {
            match("overridden"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:14:5: ( 'DifferentLiteral' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:14:7: 'DifferentLiteral'
            {
            match("DifferentLiteral"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:217:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:217:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:217:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:217:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:217:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:219:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:219:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:219:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:219:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:221:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:221:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:221:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("221:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:221:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:221:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFE')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:221:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:221:62: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:221:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:221:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFE')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:221:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:221:129: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:223:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:223:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:223:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFE')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:223:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:225:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:225:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:225:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:225:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:225:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:225:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:225:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:225:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:227:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:227:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:227:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:229:16: ( . )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:229:18: .
            {
            matchAny(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ANY_OTHER

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:8: ( T11 | T12 | T13 | T14 | T15 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=12;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='e') ) {
            int LA12_1 = input.LA(2);

            if ( (LA12_1=='x') ) {
                int LA12_14 = input.LA(3);

                if ( (LA12_14=='i') ) {
                    int LA12_25 = input.LA(4);

                    if ( (LA12_25=='s') ) {
                        int LA12_30 = input.LA(5);

                        if ( (LA12_30=='t') ) {
                            int LA12_35 = input.LA(6);

                            if ( (LA12_35=='i') ) {
                                int LA12_40 = input.LA(7);

                                if ( (LA12_40=='n') ) {
                                    int LA12_45 = input.LA(8);

                                    if ( (LA12_45=='g') ) {
                                        int LA12_50 = input.LA(9);

                                        if ( ((LA12_50>='0' && LA12_50<='9')||(LA12_50>='A' && LA12_50<='Z')||LA12_50=='_'||(LA12_50>='a' && LA12_50<='z')) ) {
                                            alt12=6;
                                        }
                                        else {
                                            alt12=1;}
                                    }
                                    else {
                                        alt12=6;}
                                }
                                else {
                                    alt12=6;}
                            }
                            else {
                                alt12=6;}
                        }
                        else {
                            alt12=6;}
                    }
                    else {
                        alt12=6;}
                }
                else {
                    alt12=6;}
            }
            else {
                alt12=6;}
        }
        else if ( (LA12_0=='g') ) {
            int LA12_2 = input.LA(2);

            if ( (LA12_2=='e') ) {
                int LA12_16 = input.LA(3);

                if ( (LA12_16=='n') ) {
                    int LA12_26 = input.LA(4);

                    if ( (LA12_26=='e') ) {
                        int LA12_31 = input.LA(5);

                        if ( (LA12_31=='r') ) {
                            int LA12_36 = input.LA(6);

                            if ( (LA12_36=='a') ) {
                                int LA12_41 = input.LA(7);

                                if ( (LA12_41=='t') ) {
                                    int LA12_46 = input.LA(8);

                                    if ( (LA12_46=='e') ) {
                                        int LA12_51 = input.LA(9);

                                        if ( (LA12_51=='d') ) {
                                            int LA12_56 = input.LA(10);

                                            if ( ((LA12_56>='0' && LA12_56<='9')||(LA12_56>='A' && LA12_56<='Z')||LA12_56=='_'||(LA12_56>='a' && LA12_56<='z')) ) {
                                                alt12=6;
                                            }
                                            else {
                                                alt12=2;}
                                        }
                                        else {
                                            alt12=6;}
                                    }
                                    else {
                                        alt12=6;}
                                }
                                else {
                                    alt12=6;}
                            }
                            else {
                                alt12=6;}
                        }
                        else {
                            alt12=6;}
                    }
                    else {
                        alt12=6;}
                }
                else {
                    alt12=6;}
            }
            else {
                alt12=6;}
        }
        else if ( (LA12_0=='S') ) {
            int LA12_3 = input.LA(2);

            if ( (LA12_3=='a') ) {
                int LA12_17 = input.LA(3);

                if ( (LA12_17=='m') ) {
                    int LA12_27 = input.LA(4);

                    if ( (LA12_27=='e') ) {
                        int LA12_32 = input.LA(5);

                        if ( (LA12_32=='N') ) {
                            int LA12_37 = input.LA(6);

                            if ( (LA12_37=='a') ) {
                                int LA12_42 = input.LA(7);

                                if ( (LA12_42=='m') ) {
                                    int LA12_47 = input.LA(8);

                                    if ( (LA12_47=='e') ) {
                                        int LA12_52 = input.LA(9);

                                        if ( ((LA12_52>='0' && LA12_52<='9')||(LA12_52>='A' && LA12_52<='Z')||LA12_52=='_'||(LA12_52>='a' && LA12_52<='z')) ) {
                                            alt12=6;
                                        }
                                        else {
                                            alt12=3;}
                                    }
                                    else {
                                        alt12=6;}
                                }
                                else {
                                    alt12=6;}
                            }
                            else {
                                alt12=6;}
                        }
                        else {
                            alt12=6;}
                    }
                    else {
                        alt12=6;}
                }
                else {
                    alt12=6;}
            }
            else {
                alt12=6;}
        }
        else if ( (LA12_0=='o') ) {
            int LA12_4 = input.LA(2);

            if ( (LA12_4=='v') ) {
                int LA12_18 = input.LA(3);

                if ( (LA12_18=='e') ) {
                    int LA12_28 = input.LA(4);

                    if ( (LA12_28=='r') ) {
                        int LA12_33 = input.LA(5);

                        if ( (LA12_33=='r') ) {
                            int LA12_38 = input.LA(6);

                            if ( (LA12_38=='i') ) {
                                int LA12_43 = input.LA(7);

                                if ( (LA12_43=='d') ) {
                                    int LA12_48 = input.LA(8);

                                    if ( (LA12_48=='d') ) {
                                        int LA12_53 = input.LA(9);

                                        if ( (LA12_53=='e') ) {
                                            int LA12_58 = input.LA(10);

                                            if ( (LA12_58=='n') ) {
                                                int LA12_61 = input.LA(11);

                                                if ( ((LA12_61>='0' && LA12_61<='9')||(LA12_61>='A' && LA12_61<='Z')||LA12_61=='_'||(LA12_61>='a' && LA12_61<='z')) ) {
                                                    alt12=6;
                                                }
                                                else {
                                                    alt12=4;}
                                            }
                                            else {
                                                alt12=6;}
                                        }
                                        else {
                                            alt12=6;}
                                    }
                                    else {
                                        alt12=6;}
                                }
                                else {
                                    alt12=6;}
                            }
                            else {
                                alt12=6;}
                        }
                        else {
                            alt12=6;}
                    }
                    else {
                        alt12=6;}
                }
                else {
                    alt12=6;}
            }
            else {
                alt12=6;}
        }
        else if ( (LA12_0=='D') ) {
            int LA12_5 = input.LA(2);

            if ( (LA12_5=='i') ) {
                int LA12_19 = input.LA(3);

                if ( (LA12_19=='f') ) {
                    int LA12_29 = input.LA(4);

                    if ( (LA12_29=='f') ) {
                        int LA12_34 = input.LA(5);

                        if ( (LA12_34=='e') ) {
                            int LA12_39 = input.LA(6);

                            if ( (LA12_39=='r') ) {
                                int LA12_44 = input.LA(7);

                                if ( (LA12_44=='e') ) {
                                    int LA12_49 = input.LA(8);

                                    if ( (LA12_49=='n') ) {
                                        int LA12_54 = input.LA(9);

                                        if ( (LA12_54=='t') ) {
                                            int LA12_59 = input.LA(10);

                                            if ( (LA12_59=='L') ) {
                                                int LA12_62 = input.LA(11);

                                                if ( (LA12_62=='i') ) {
                                                    int LA12_64 = input.LA(12);

                                                    if ( (LA12_64=='t') ) {
                                                        int LA12_65 = input.LA(13);

                                                        if ( (LA12_65=='e') ) {
                                                            int LA12_66 = input.LA(14);

                                                            if ( (LA12_66=='r') ) {
                                                                int LA12_67 = input.LA(15);

                                                                if ( (LA12_67=='a') ) {
                                                                    int LA12_68 = input.LA(16);

                                                                    if ( (LA12_68=='l') ) {
                                                                        int LA12_69 = input.LA(17);

                                                                        if ( ((LA12_69>='0' && LA12_69<='9')||(LA12_69>='A' && LA12_69<='Z')||LA12_69=='_'||(LA12_69>='a' && LA12_69<='z')) ) {
                                                                            alt12=6;
                                                                        }
                                                                        else {
                                                                            alt12=5;}
                                                                    }
                                                                    else {
                                                                        alt12=6;}
                                                                }
                                                                else {
                                                                    alt12=6;}
                                                            }
                                                            else {
                                                                alt12=6;}
                                                        }
                                                        else {
                                                            alt12=6;}
                                                    }
                                                    else {
                                                        alt12=6;}
                                                }
                                                else {
                                                    alt12=6;}
                                            }
                                            else {
                                                alt12=6;}
                                        }
                                        else {
                                            alt12=6;}
                                    }
                                    else {
                                        alt12=6;}
                                }
                                else {
                                    alt12=6;}
                            }
                            else {
                                alt12=6;}
                        }
                        else {
                            alt12=6;}
                    }
                    else {
                        alt12=6;}
                }
                else {
                    alt12=6;}
            }
            else {
                alt12=6;}
        }
        else if ( (LA12_0=='^') ) {
            int LA12_6 = input.LA(2);

            if ( ((LA12_6>='A' && LA12_6<='Z')||LA12_6=='_'||(LA12_6>='a' && LA12_6<='z')) ) {
                alt12=6;
            }
            else {
                alt12=12;}
        }
        else if ( ((LA12_0>='A' && LA12_0<='C')||(LA12_0>='E' && LA12_0<='R')||(LA12_0>='T' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='d')||LA12_0=='f'||(LA12_0>='h' && LA12_0<='n')||(LA12_0>='p' && LA12_0<='z')) ) {
            alt12=6;
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=7;
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_9 = input.LA(2);

            if ( ((LA12_9>='\u0000' && LA12_9<='\uFFFE')) ) {
                alt12=8;
            }
            else {
                alt12=12;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_10 = input.LA(2);

            if ( ((LA12_10>='\u0000' && LA12_10<='\uFFFE')) ) {
                alt12=8;
            }
            else {
                alt12=12;}
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '*':
                {
                alt12=9;
                }
                break;
            case '/':
                {
                alt12=10;
                }
                break;
            default:
                alt12=12;}

        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=11;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12=12;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:30: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:38: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:47: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:59: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:75: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:91: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:1:99: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}
package org.eclipse.xtext.grammarinheritance.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalAbstractTestLanguageLexer extends Lexer {
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=7;
    public static final int T12=12;
    public static final int Tokens=13;
    public static final int RULE_REAL=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public InternalAbstractTestLanguageLexer() {;} 
    public InternalAbstractTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:10:5: ( 'element' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:10:7: 'element'
            {
            match("element"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start RULE_REAL
    public final void mRULE_REAL() throws RecognitionException {
        try {
            int _type = RULE_REAL;
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:224:11: ( RULE_INT '.' RULE_INT )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:224:13: RULE_INT '.' RULE_INT
            {
            mRULE_INT(); 
            match('.'); 
            mRULE_INT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_REAL

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:226:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '\\u00F6' | '\\u00E4' | '\\u00FC' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:226:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '\\u00F6' | '\\u00E4' | '\\u00FC' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:226:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:226:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u00E4'||input.LA(1)=='\u00F6'||input.LA(1)=='\u00FC' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:226:67: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:
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
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:228:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:228:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:228:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:228:13: '0' .. '9'
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
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:230:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:230:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:230:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("230:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:230:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:230:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:230:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:230:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:230:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:230:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:230:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:230:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:232:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:232:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:232:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:232:52: .
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
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:234:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:234:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:234:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:234:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:234:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:234:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:234:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:234:41: '\\r'
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
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:236:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:236:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:236:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:
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
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:238:16: ( . )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:238:18: .
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
        // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:1:8: ( T12 | RULE_REAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=9;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:1:14: RULE_REAL
                {
                mRULE_REAL(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:1:24: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:1:32: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:1:41: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:1:53: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:1:69: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:1:85: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:1:93: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\13\1\14\1\11\1\uffff\3\11\2\uffff\1\13\2\uffff\1\14\5"+
        "\uffff\4\13\1\30\1\uffff";
    static final String DFA12_eofS =
        "\31\uffff";
    static final String DFA12_minS =
        "\1\0\1\154\1\56\1\101\1\uffff\2\0\1\52\2\uffff\1\145\2\uffff\1\56"+
        "\5\uffff\1\155\1\145\1\156\1\164\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\ufffe\1\154\1\71\1\u00fc\1\uffff\2\ufffe\1\57\2\uffff\1\145\2"+
        "\uffff\1\71\5\uffff\1\155\1\145\1\156\1\164\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\4\uffff\1\3\3\uffff\1\10\1\11\1\uffff\1\3\1\4\1\uffff\1\2\1\5\1"+
        "\6\1\7\1\10\5\uffff\1\1";
    static final String DFA12_specialS =
        "\31\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\11\2\10\2\11\1\10\22\11\1\10\1\11\1\5\4\11\1\6\7\11\1\7"+
            "\12\2\7\11\32\4\3\11\1\3\1\4\1\11\4\4\1\1\25\4\151\11\1\4\21"+
            "\11\1\4\5\11\1\4\uff02\11",
            "\1\12",
            "\1\16\1\uffff\12\15",
            "\32\13\4\uffff\1\13\1\uffff\32\13\151\uffff\1\13\21\uffff\1"+
            "\13\5\uffff\1\13",
            "",
            "\uffff\17",
            "\uffff\17",
            "\1\20\4\uffff\1\21",
            "",
            "",
            "\1\23",
            "",
            "",
            "\1\16\1\uffff\12\15",
            "",
            "",
            "",
            "",
            "",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T12 | RULE_REAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
    }
 

}
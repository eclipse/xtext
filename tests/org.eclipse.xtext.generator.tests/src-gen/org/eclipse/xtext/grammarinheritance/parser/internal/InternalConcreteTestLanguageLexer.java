// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g 2008-07-08 10:01:30

package org.eclipse.xtext.grammarinheritance.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalConcreteTestLanguageLexer extends Lexer {
    public static final int RULE_ML_COMMENT=8;
    public static final int T14=14;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int T15=15;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=7;
    public static final int Tokens=16;
    public static final int RULE_REAL=4;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_SL_COMMENT=9;
    public static final int T13=13;
    public static final int RULE_LEXER_BODY=11;
    public InternalConcreteTestLanguageLexer() {;} 
    public InternalConcreteTestLanguageLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g"; }

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:10:5: ( 'model' )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:10:7: 'model'
            {
            match("model"); 


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
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:11:5: ( ':' )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:11:7: ':'
            {
            match(':'); 

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
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:12:5: ( 'element' )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:12:7: 'element'
            {
            match("element"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start RULE_REAL
    public final void mRULE_REAL() throws RecognitionException {
        try {
            int _type = RULE_REAL;
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:153:11: ( RULE_INT '.' RULE_INT )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:153:13: RULE_INT '.' RULE_INT
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
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:155:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | 'ö' | 'ä' | 'ü' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:155:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | 'ö' | 'ä' | 'ü' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:155:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:155:12: '^'
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

            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:155:53: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:
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
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:157:10: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:157:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:157:12: ( '0' .. '9' )+
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
            	    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:157:13: '0' .. '9'
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
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:159:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
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
                    new NoViableAltException("159:1: RULE_STRING : ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:159:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:159:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )*
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
                    	    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:159:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:159:65: ~ ( '\\\\' | '\"' )
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
                    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:159:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:159:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
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
                    	    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:159:93: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:159:137: ~ ( '\\\\' | '\\'' )
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
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:161:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:161:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:161:24: ( options {greedy=false; } : . )*
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
            	    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:161:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 

            channel=HIDDEN;

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
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:163:17: ( '//' (~ ( '\\n' | '\\r' ) )* ( ( options {greedy=true; } : '\\r\\n' | '\\r' | '\\n' ) )? )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:163:19: '//' (~ ( '\\n' | '\\r' ) )* ( ( options {greedy=true; } : '\\r\\n' | '\\r' | '\\n' ) )?
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:163:24: (~ ( '\\n' | '\\r' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:163:26: ~ ( '\\n' | '\\r' )
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

            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:163:41: ( ( options {greedy=true; } : '\\r\\n' | '\\r' | '\\n' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:163:42: ( options {greedy=true; } : '\\r\\n' | '\\r' | '\\n' )
                    {
                    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:163:42: ( options {greedy=true; } : '\\r\\n' | '\\r' | '\\n' )
                    int alt9=3;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        int LA9_1 = input.LA(2);

                        if ( (LA9_1=='\n') ) {
                            alt9=1;
                        }
                        else {
                            alt9=2;}
                    }
                    else if ( (LA9_0=='\n') ) {
                        alt9=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("163:42: ( options {greedy=true; } : '\\r\\n' | '\\r' | '\\n' )", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:163:65: '\\r\\n'
                            {
                            match("\r\n"); 


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:163:74: '\\r'
                            {
                            match('\r'); 

                            }
                            break;
                        case 3 :
                            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:163:81: '\\n'
                            {
                            match('\n'); 

                            }
                            break;

                    }


                    }
                    break;

            }

            channel=HIDDEN;

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
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:165:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:165:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:165:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:
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

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_LEXER_BODY
    public final void mRULE_LEXER_BODY() throws RecognitionException {
        try {
            int _type = RULE_LEXER_BODY;
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:167:17: ( '<#' ( '.' )* '#>' )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:167:19: '<#' ( '.' )* '#>'
            {
            match("<#"); 

            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:167:24: ( '.' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='.') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:167:24: '.'
            	    {
            	    match('.'); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match("#>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_LEXER_BODY

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:169:16: ( . )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:169:18: .
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
        // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:8: ( T13 | T14 | T15 | RULE_REAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_LEXER_BODY | RULE_ANY_OTHER )
        int alt13=12;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:10: T13
                {
                mT13(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:14: T14
                {
                mT14(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:18: T15
                {
                mT15(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:22: RULE_REAL
                {
                mRULE_REAL(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:32: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:40: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:49: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:61: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:77: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 10 :
                // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:93: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 11 :
                // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:101: RULE_LEXER_BODY
                {
                mRULE_LEXER_BODY(); 

                }
                break;
            case 12 :
                // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:1:117: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\1\16\1\uffff\1\16\1\21\1\14\1\uffff\3\14\1\uffff\1\14\1"+
        "\uffff\1\16\2\uffff\1\16\2\uffff\1\21\5\uffff\4\16\1\37\1\16\1\uffff"+
        "\1\16\1\42\1\uffff";
    static final String DFA13_eofS =
        "\43\uffff";
    static final String DFA13_minS =
        "\1\0\1\157\1\uffff\1\154\1\56\1\101\1\uffff\2\0\1\52\1\uffff\1\43"+
        "\1\uffff\1\144\2\uffff\1\145\2\uffff\1\56\5\uffff\1\145\1\155\1"+
        "\154\1\145\1\60\1\156\1\uffff\1\164\1\60\1\uffff";
    static final String DFA13_maxS =
        "\1\ufffe\1\157\1\uffff\1\154\1\71\1\u00fc\1\uffff\2\ufffe\1\57\1"+
        "\uffff\1\43\1\uffff\1\144\2\uffff\1\145\2\uffff\1\71\5\uffff\1\145"+
        "\1\155\1\154\1\145\1\172\1\156\1\uffff\1\164\1\172\1\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\2\3\uffff\1\5\3\uffff\1\12\1\uffff\1\14\1\uffff\1\5\1"+
        "\2\1\uffff\1\6\1\4\1\uffff\1\7\1\10\1\11\1\12\1\13\6\uffff\1\1\2"+
        "\uffff\1\3";
    static final String DFA13_specialS =
        "\43\uffff}>";
    static final String[] DFA13_transitionS = {
            "\11\14\2\12\2\14\1\12\22\14\1\12\1\14\1\7\4\14\1\10\7\14\1\11"+
            "\12\4\1\2\1\14\1\13\4\14\32\6\3\14\1\5\1\6\1\14\4\6\1\3\7\6"+
            "\1\1\15\6\151\14\1\6\21\14\1\6\5\14\1\6\uff02\14",
            "\1\15",
            "",
            "\1\20",
            "\1\22\1\uffff\12\23",
            "\32\16\4\uffff\1\16\1\uffff\32\16\151\uffff\1\16\21\uffff\1"+
            "\16\5\uffff\1\16",
            "",
            "\uffff\24",
            "\uffff\24",
            "\1\25\4\uffff\1\26",
            "",
            "\1\30",
            "",
            "\1\31",
            "",
            "",
            "\1\32",
            "",
            "",
            "\1\22\1\uffff\12\23",
            "",
            "",
            "",
            "",
            "",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\40",
            "",
            "\1\41",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T13 | T14 | T15 | RULE_REAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_LEXER_BODY | RULE_ANY_OTHER );";
        }
    }
 

}
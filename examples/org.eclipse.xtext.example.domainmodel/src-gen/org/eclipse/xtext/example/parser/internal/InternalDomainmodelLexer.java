// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g 2009-01-06 12:26:46

package org.eclipse.xtext.example.parser.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalDomainmodelLexer extends Lexer {
    public static final int RULE_ID=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int T25=25;
    public static final int Tokens=26;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_STRING=4;
    public static final int RULE_INT=6;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int RULE_WS=9;
    public static final int T15=15;
    public static final int T16=16;
    public static final int T17=17;
    public static final int T18=18;
    public static final int T19=19;
    public InternalDomainmodelLexer() {;} 
    public InternalDomainmodelLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:10:5: ( 'import' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:10:7: 'import'
            {
            match("import"); 


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
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:11:5: ( 'package' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:11:7: 'package'
            {
            match("package"); 


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
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:12:5: ( '{' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:12:7: '{'
            {
            match('{'); 

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
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:13:5: ( '}' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:13:7: '}'
            {
            match('}'); 

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
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:14:5: ( 'datatype' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:14:7: 'datatype'
            {
            match("datatype"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:15:5: ( 'entity' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:15:7: 'entity'
            {
            match("entity"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:16:5: ( 'extends' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:16:7: 'extends'
            {
            match("extends"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:17:5: ( 'attr' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:17:7: 'attr'
            {
            match("attr"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:18:5: ( ':' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:18:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:19:5: ( 'ref' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:19:7: 'ref'
            {
            match("ref"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:20:5: ( 'opposite' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:20:7: 'opposite'
            {
            match("opposite"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:21:5: ( 'op' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:21:7: 'op'
            {
            match("op"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:22:5: ( '(' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:22:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:23:5: ( ',' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:23:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:24:5: ( ')' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:24:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:886:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )* )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:886:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:886:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:886:12: '^'
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

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:886:41: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:
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

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:886:75: ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='.') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:886:76: '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            	    {
            	    match('.'); 
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }

            	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:886:104: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:
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
            	    	    break loop3;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop4;
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
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:888:10: ( ( '0' .. '9' )+ )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:888:12: ( '0' .. '9' )+
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:888:12: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:888:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:890:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("890:1: RULE_STRING : ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:890:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:890:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\"' ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFE')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:890:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:890:65: ~ ( '\\\\' | '\"' )
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
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:890:101: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:890:106: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFE')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:890:108: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:890:152: ~ ( '\\\\' | '\\'' )
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
                    	    break loop7;
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
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:892:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:892:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:892:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFE')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:892:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
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
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:894:17: ( '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\r' )? '\\n' )? )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:894:19: '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:894:24: (~ ( '\\n' | '\\r' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:894:24: ~ ( '\\n' | '\\r' )
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
            	    break loop10;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:894:38: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:894:39: ( '\\r' )? '\\n'
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:894:39: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:894:39: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

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
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:896:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:896:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:896:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:
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
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            channel=HIDDEN;

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
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:898:16: ( . )
            // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:898:18: .
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
        // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=22;
        int LA14_0 = input.LA(1);

        if ( (LA14_0=='i') ) {
            int LA14_1 = input.LA(2);

            if ( (LA14_1=='m') ) {
                int LA14_22 = input.LA(3);

                if ( (LA14_22=='p') ) {
                    int LA14_42 = input.LA(4);

                    if ( (LA14_42=='o') ) {
                        int LA14_51 = input.LA(5);

                        if ( (LA14_51=='r') ) {
                            int LA14_59 = input.LA(6);

                            if ( (LA14_59=='t') ) {
                                int LA14_66 = input.LA(7);

                                if ( (LA14_66=='.'||(LA14_66>='0' && LA14_66<='9')||(LA14_66>='A' && LA14_66<='Z')||LA14_66=='_'||(LA14_66>='a' && LA14_66<='z')) ) {
                                    alt14=16;
                                }
                                else {
                                    alt14=1;}
                            }
                            else {
                                alt14=16;}
                        }
                        else {
                            alt14=16;}
                    }
                    else {
                        alt14=16;}
                }
                else {
                    alt14=16;}
            }
            else {
                alt14=16;}
        }
        else if ( (LA14_0=='p') ) {
            int LA14_2 = input.LA(2);

            if ( (LA14_2=='a') ) {
                int LA14_24 = input.LA(3);

                if ( (LA14_24=='c') ) {
                    int LA14_43 = input.LA(4);

                    if ( (LA14_43=='k') ) {
                        int LA14_52 = input.LA(5);

                        if ( (LA14_52=='a') ) {
                            int LA14_60 = input.LA(6);

                            if ( (LA14_60=='g') ) {
                                int LA14_67 = input.LA(7);

                                if ( (LA14_67=='e') ) {
                                    int LA14_73 = input.LA(8);

                                    if ( (LA14_73=='.'||(LA14_73>='0' && LA14_73<='9')||(LA14_73>='A' && LA14_73<='Z')||LA14_73=='_'||(LA14_73>='a' && LA14_73<='z')) ) {
                                        alt14=16;
                                    }
                                    else {
                                        alt14=2;}
                                }
                                else {
                                    alt14=16;}
                            }
                            else {
                                alt14=16;}
                        }
                        else {
                            alt14=16;}
                    }
                    else {
                        alt14=16;}
                }
                else {
                    alt14=16;}
            }
            else {
                alt14=16;}
        }
        else if ( (LA14_0=='{') ) {
            alt14=3;
        }
        else if ( (LA14_0=='}') ) {
            alt14=4;
        }
        else if ( (LA14_0=='d') ) {
            int LA14_5 = input.LA(2);

            if ( (LA14_5=='a') ) {
                int LA14_27 = input.LA(3);

                if ( (LA14_27=='t') ) {
                    int LA14_44 = input.LA(4);

                    if ( (LA14_44=='a') ) {
                        int LA14_53 = input.LA(5);

                        if ( (LA14_53=='t') ) {
                            int LA14_61 = input.LA(6);

                            if ( (LA14_61=='y') ) {
                                int LA14_68 = input.LA(7);

                                if ( (LA14_68=='p') ) {
                                    int LA14_74 = input.LA(8);

                                    if ( (LA14_74=='e') ) {
                                        int LA14_79 = input.LA(9);

                                        if ( (LA14_79=='.'||(LA14_79>='0' && LA14_79<='9')||(LA14_79>='A' && LA14_79<='Z')||LA14_79=='_'||(LA14_79>='a' && LA14_79<='z')) ) {
                                            alt14=16;
                                        }
                                        else {
                                            alt14=5;}
                                    }
                                    else {
                                        alt14=16;}
                                }
                                else {
                                    alt14=16;}
                            }
                            else {
                                alt14=16;}
                        }
                        else {
                            alt14=16;}
                    }
                    else {
                        alt14=16;}
                }
                else {
                    alt14=16;}
            }
            else {
                alt14=16;}
        }
        else if ( (LA14_0=='e') ) {
            switch ( input.LA(2) ) {
            case 'n':
                {
                int LA14_28 = input.LA(3);

                if ( (LA14_28=='t') ) {
                    int LA14_45 = input.LA(4);

                    if ( (LA14_45=='i') ) {
                        int LA14_54 = input.LA(5);

                        if ( (LA14_54=='t') ) {
                            int LA14_62 = input.LA(6);

                            if ( (LA14_62=='y') ) {
                                int LA14_69 = input.LA(7);

                                if ( (LA14_69=='.'||(LA14_69>='0' && LA14_69<='9')||(LA14_69>='A' && LA14_69<='Z')||LA14_69=='_'||(LA14_69>='a' && LA14_69<='z')) ) {
                                    alt14=16;
                                }
                                else {
                                    alt14=6;}
                            }
                            else {
                                alt14=16;}
                        }
                        else {
                            alt14=16;}
                    }
                    else {
                        alt14=16;}
                }
                else {
                    alt14=16;}
                }
                break;
            case 'x':
                {
                int LA14_29 = input.LA(3);

                if ( (LA14_29=='t') ) {
                    int LA14_46 = input.LA(4);

                    if ( (LA14_46=='e') ) {
                        int LA14_55 = input.LA(5);

                        if ( (LA14_55=='n') ) {
                            int LA14_63 = input.LA(6);

                            if ( (LA14_63=='d') ) {
                                int LA14_70 = input.LA(7);

                                if ( (LA14_70=='s') ) {
                                    int LA14_76 = input.LA(8);

                                    if ( (LA14_76=='.'||(LA14_76>='0' && LA14_76<='9')||(LA14_76>='A' && LA14_76<='Z')||LA14_76=='_'||(LA14_76>='a' && LA14_76<='z')) ) {
                                        alt14=16;
                                    }
                                    else {
                                        alt14=7;}
                                }
                                else {
                                    alt14=16;}
                            }
                            else {
                                alt14=16;}
                        }
                        else {
                            alt14=16;}
                    }
                    else {
                        alt14=16;}
                }
                else {
                    alt14=16;}
                }
                break;
            default:
                alt14=16;}

        }
        else if ( (LA14_0=='a') ) {
            int LA14_7 = input.LA(2);

            if ( (LA14_7=='t') ) {
                int LA14_30 = input.LA(3);

                if ( (LA14_30=='t') ) {
                    int LA14_47 = input.LA(4);

                    if ( (LA14_47=='r') ) {
                        int LA14_56 = input.LA(5);

                        if ( (LA14_56=='.'||(LA14_56>='0' && LA14_56<='9')||(LA14_56>='A' && LA14_56<='Z')||LA14_56=='_'||(LA14_56>='a' && LA14_56<='z')) ) {
                            alt14=16;
                        }
                        else {
                            alt14=8;}
                    }
                    else {
                        alt14=16;}
                }
                else {
                    alt14=16;}
            }
            else {
                alt14=16;}
        }
        else if ( (LA14_0==':') ) {
            alt14=9;
        }
        else if ( (LA14_0=='r') ) {
            int LA14_9 = input.LA(2);

            if ( (LA14_9=='e') ) {
                int LA14_32 = input.LA(3);

                if ( (LA14_32=='f') ) {
                    int LA14_48 = input.LA(4);

                    if ( (LA14_48=='.'||(LA14_48>='0' && LA14_48<='9')||(LA14_48>='A' && LA14_48<='Z')||LA14_48=='_'||(LA14_48>='a' && LA14_48<='z')) ) {
                        alt14=16;
                    }
                    else {
                        alt14=10;}
                }
                else {
                    alt14=16;}
            }
            else {
                alt14=16;}
        }
        else if ( (LA14_0=='o') ) {
            int LA14_10 = input.LA(2);

            if ( (LA14_10=='p') ) {
                switch ( input.LA(3) ) {
                case 'p':
                    {
                    int LA14_49 = input.LA(4);

                    if ( (LA14_49=='o') ) {
                        int LA14_58 = input.LA(5);

                        if ( (LA14_58=='s') ) {
                            int LA14_65 = input.LA(6);

                            if ( (LA14_65=='i') ) {
                                int LA14_71 = input.LA(7);

                                if ( (LA14_71=='t') ) {
                                    int LA14_77 = input.LA(8);

                                    if ( (LA14_77=='e') ) {
                                        int LA14_81 = input.LA(9);

                                        if ( (LA14_81=='.'||(LA14_81>='0' && LA14_81<='9')||(LA14_81>='A' && LA14_81<='Z')||LA14_81=='_'||(LA14_81>='a' && LA14_81<='z')) ) {
                                            alt14=16;
                                        }
                                        else {
                                            alt14=11;}
                                    }
                                    else {
                                        alt14=16;}
                                }
                                else {
                                    alt14=16;}
                            }
                            else {
                                alt14=16;}
                        }
                        else {
                            alt14=16;}
                    }
                    else {
                        alt14=16;}
                    }
                    break;
                case '.':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt14=16;
                    }
                    break;
                default:
                    alt14=12;}

            }
            else {
                alt14=16;}
        }
        else if ( (LA14_0=='(') ) {
            alt14=13;
        }
        else if ( (LA14_0==',') ) {
            alt14=14;
        }
        else if ( (LA14_0==')') ) {
            alt14=15;
        }
        else if ( (LA14_0=='^') ) {
            int LA14_14 = input.LA(2);

            if ( ((LA14_14>='A' && LA14_14<='Z')||LA14_14=='_'||(LA14_14>='a' && LA14_14<='z')) ) {
                alt14=16;
            }
            else {
                alt14=22;}
        }
        else if ( ((LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='b' && LA14_0<='c')||(LA14_0>='f' && LA14_0<='h')||(LA14_0>='j' && LA14_0<='n')||LA14_0=='q'||(LA14_0>='s' && LA14_0<='z')) ) {
            alt14=16;
        }
        else if ( ((LA14_0>='0' && LA14_0<='9')) ) {
            alt14=17;
        }
        else if ( (LA14_0=='\"') ) {
            int LA14_17 = input.LA(2);

            if ( ((LA14_17>='\u0000' && LA14_17<='\uFFFE')) ) {
                alt14=18;
            }
            else {
                alt14=22;}
        }
        else if ( (LA14_0=='\'') ) {
            int LA14_18 = input.LA(2);

            if ( ((LA14_18>='\u0000' && LA14_18<='\uFFFE')) ) {
                alt14=18;
            }
            else {
                alt14=22;}
        }
        else if ( (LA14_0=='/') ) {
            switch ( input.LA(2) ) {
            case '*':
                {
                alt14=19;
                }
                break;
            case '/':
                {
                alt14=20;
                }
                break;
            default:
                alt14=22;}

        }
        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {
            alt14=21;
        }
        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||(LA14_0>='#' && LA14_0<='&')||(LA14_0>='*' && LA14_0<='+')||(LA14_0>='-' && LA14_0<='.')||(LA14_0>=';' && LA14_0<='@')||(LA14_0>='[' && LA14_0<=']')||LA14_0=='`'||LA14_0=='|'||(LA14_0>='~' && LA14_0<='\uFFFE')) ) {
            alt14=22;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 14, 0, input);

            throw nvae;
        }
        switch (alt14) {
            case 1 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:70: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 17 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:78: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 18 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:87: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 19 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:99: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 20 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:115: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 21 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:131: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 22 :
                // ./src-gen/org/eclipse/xtext/example/parser/internal/InternalDomainmodel.g:1:139: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}
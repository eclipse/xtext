package org.eclipse.xtext.example.arithmetics.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalArithmeticsLexer extends Lexer {
    public static final int T21=21;
    public static final int RULE_ML_COMMENT=8;
    public static final int T14=14;
    public static final int RULE_ID=4;
    public static final int T22=22;
    public static final int RULE_NUMBER=5;
    public static final int RULE_STRING=7;
    public static final int T12=12;
    public static final int T23=23;
    public static final int T13=13;
    public static final int T20=20;
    public static final int T25=25;
    public static final int T18=18;
    public static final int RULE_WS=10;
    public static final int T15=15;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int T17=17;
    public static final int Tokens=26;
    public static final int RULE_ANY_OTHER=11;
    public static final int T16=16;
    public static final int RULE_SL_COMMENT=9;
    public static final int T24=24;
    public static final int T19=19;
    public InternalArithmeticsLexer() {;} 
    public InternalArithmeticsLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:10:5: ( 'module' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:10:7: 'module'
            {
            match("module"); 


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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:11:5: ( 'import' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:11:7: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:12:5: ( '.' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:12:7: '.'
            {
            match('.'); 

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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:13:5: ( '*' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:13:7: '*'
            {
            match('*'); 

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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:14:5: ( 'def' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:14:7: 'def'
            {
            match("def"); 


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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:15:5: ( ':' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:15:7: ':'
            {
            match(':'); 

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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:16:5: ( ';' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:16:7: ';'
            {
            match(';'); 

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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:17:5: ( '(' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:17:7: '('
            {
            match('('); 

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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:18:5: ( ')' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:18:7: ')'
            {
            match(')'); 

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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:19:5: ( ',' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:19:7: ','
            {
            match(','); 

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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:20:5: ( '+' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:20:7: '+'
            {
            match('+'); 

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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:21:5: ( '-' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:21:7: '-'
            {
            match('-'); 

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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:22:5: ( '/' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:22:7: '/'
            {
            match('/'); 

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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:23:5: ( '\\u00B9' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:23:7: '\\u00B9'
            {
            match('\u00B9'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start RULE_NUMBER
    public final void mRULE_NUMBER() throws RecognitionException {
        try {
            int _type = RULE_NUMBER;
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1873:13: ( ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1873:15: ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )?
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1873:15: ( '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1873:16: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1873:27: ( '.' ( '0' .. '9' )+ )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='.') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1873:28: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1873:32: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1873:33: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_NUMBER

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1875:10: ( 'this one has been deactivated' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1875:12: 'this one has been deactivated'
            {
            match("this one has been deactivated"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1877:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1877:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1877:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1877:11: '^'
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

            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1877:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:
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
            	    break loop5;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1879:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1879:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1879:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("1879:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1879:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1879:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1879:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1879:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1879:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1879:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1879:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1879:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1881:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1881:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1881:24: ( options {greedy=false; } : . )*
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
            	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1881:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1883:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1883:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1883:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1883:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1883:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1883:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1883:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1883:41: '\\r'
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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1885:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1885:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1885:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:
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
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1887:16: ( . )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1887:18: .
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
        // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:8: ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | RULE_NUMBER | RULE_INT | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=22;
        int LA14_0 = input.LA(1);

        if ( (LA14_0=='m') ) {
            int LA14_1 = input.LA(2);

            if ( (LA14_1=='o') ) {
                int LA14_24 = input.LA(3);

                if ( (LA14_24=='d') ) {
                    int LA14_44 = input.LA(4);

                    if ( (LA14_44=='u') ) {
                        int LA14_48 = input.LA(5);

                        if ( (LA14_48=='l') ) {
                            int LA14_52 = input.LA(6);

                            if ( (LA14_52=='e') ) {
                                int LA14_55 = input.LA(7);

                                if ( ((LA14_55>='0' && LA14_55<='9')||(LA14_55>='A' && LA14_55<='Z')||LA14_55=='_'||(LA14_55>='a' && LA14_55<='z')) ) {
                                    alt14=17;
                                }
                                else {
                                    alt14=1;}
                            }
                            else {
                                alt14=17;}
                        }
                        else {
                            alt14=17;}
                    }
                    else {
                        alt14=17;}
                }
                else {
                    alt14=17;}
            }
            else {
                alt14=17;}
        }
        else if ( (LA14_0=='i') ) {
            int LA14_2 = input.LA(2);

            if ( (LA14_2=='m') ) {
                int LA14_26 = input.LA(3);

                if ( (LA14_26=='p') ) {
                    int LA14_45 = input.LA(4);

                    if ( (LA14_45=='o') ) {
                        int LA14_49 = input.LA(5);

                        if ( (LA14_49=='r') ) {
                            int LA14_53 = input.LA(6);

                            if ( (LA14_53=='t') ) {
                                int LA14_56 = input.LA(7);

                                if ( ((LA14_56>='0' && LA14_56<='9')||(LA14_56>='A' && LA14_56<='Z')||LA14_56=='_'||(LA14_56>='a' && LA14_56<='z')) ) {
                                    alt14=17;
                                }
                                else {
                                    alt14=2;}
                            }
                            else {
                                alt14=17;}
                        }
                        else {
                            alt14=17;}
                    }
                    else {
                        alt14=17;}
                }
                else {
                    alt14=17;}
            }
            else {
                alt14=17;}
        }
        else if ( (LA14_0=='.') ) {
            int LA14_3 = input.LA(2);

            if ( ((LA14_3>='0' && LA14_3<='9')) ) {
                alt14=15;
            }
            else {
                alt14=3;}
        }
        else if ( (LA14_0=='*') ) {
            alt14=4;
        }
        else if ( (LA14_0=='d') ) {
            int LA14_5 = input.LA(2);

            if ( (LA14_5=='e') ) {
                int LA14_29 = input.LA(3);

                if ( (LA14_29=='f') ) {
                    int LA14_46 = input.LA(4);

                    if ( ((LA14_46>='0' && LA14_46<='9')||(LA14_46>='A' && LA14_46<='Z')||LA14_46=='_'||(LA14_46>='a' && LA14_46<='z')) ) {
                        alt14=17;
                    }
                    else {
                        alt14=5;}
                }
                else {
                    alt14=17;}
            }
            else {
                alt14=17;}
        }
        else if ( (LA14_0==':') ) {
            alt14=6;
        }
        else if ( (LA14_0==';') ) {
            alt14=7;
        }
        else if ( (LA14_0=='(') ) {
            alt14=8;
        }
        else if ( (LA14_0==')') ) {
            alt14=9;
        }
        else if ( (LA14_0==',') ) {
            alt14=10;
        }
        else if ( (LA14_0=='+') ) {
            alt14=11;
        }
        else if ( (LA14_0=='-') ) {
            alt14=12;
        }
        else if ( (LA14_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt14=20;
                }
                break;
            case '*':
                {
                alt14=19;
                }
                break;
            default:
                alt14=13;}

        }
        else if ( (LA14_0=='\u00B9') ) {
            alt14=14;
        }
        else if ( ((LA14_0>='0' && LA14_0<='9')) ) {
            alt14=15;
        }
        else if ( (LA14_0=='t') ) {
            int LA14_17 = input.LA(2);

            if ( (LA14_17=='h') ) {
                int LA14_41 = input.LA(3);

                if ( (LA14_41=='i') ) {
                    int LA14_47 = input.LA(4);

                    if ( (LA14_47=='s') ) {
                        int LA14_51 = input.LA(5);

                        if ( (LA14_51==' ') ) {
                            alt14=16;
                        }
                        else {
                            alt14=17;}
                    }
                    else {
                        alt14=17;}
                }
                else {
                    alt14=17;}
            }
            else {
                alt14=17;}
        }
        else if ( (LA14_0=='^') ) {
            int LA14_18 = input.LA(2);

            if ( ((LA14_18>='A' && LA14_18<='Z')||LA14_18=='_'||(LA14_18>='a' && LA14_18<='z')) ) {
                alt14=17;
            }
            else {
                alt14=22;}
        }
        else if ( ((LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='c')||(LA14_0>='e' && LA14_0<='h')||(LA14_0>='j' && LA14_0<='l')||(LA14_0>='n' && LA14_0<='s')||(LA14_0>='u' && LA14_0<='z')) ) {
            alt14=17;
        }
        else if ( (LA14_0=='\"') ) {
            int LA14_20 = input.LA(2);

            if ( ((LA14_20>='\u0000' && LA14_20<='\uFFFE')) ) {
                alt14=18;
            }
            else {
                alt14=22;}
        }
        else if ( (LA14_0=='\'') ) {
            int LA14_21 = input.LA(2);

            if ( ((LA14_21>='\u0000' && LA14_21<='\uFFFE')) ) {
                alt14=18;
            }
            else {
                alt14=22;}
        }
        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {
            alt14=21;
        }
        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||(LA14_0>='#' && LA14_0<='&')||(LA14_0>='<' && LA14_0<='@')||(LA14_0>='[' && LA14_0<=']')||LA14_0=='`'||(LA14_0>='{' && LA14_0<='\u00B8')||(LA14_0>='\u00BA' && LA14_0<='\uFFFE')) ) {
            alt14=22;
        }
        else {
            alt14=15;}
        switch (alt14) {
            case 1 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:14: T13
                {
                mT13(); 

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:18: T14
                {
                mT14(); 

                }
                break;
            case 4 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:22: T15
                {
                mT15(); 

                }
                break;
            case 5 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:26: T16
                {
                mT16(); 

                }
                break;
            case 6 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:30: T17
                {
                mT17(); 

                }
                break;
            case 7 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:34: T18
                {
                mT18(); 

                }
                break;
            case 8 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:38: T19
                {
                mT19(); 

                }
                break;
            case 9 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:42: T20
                {
                mT20(); 

                }
                break;
            case 10 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:46: T21
                {
                mT21(); 

                }
                break;
            case 11 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:50: T22
                {
                mT22(); 

                }
                break;
            case 12 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:54: T23
                {
                mT23(); 

                }
                break;
            case 13 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:58: T24
                {
                mT24(); 

                }
                break;
            case 14 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:62: T25
                {
                mT25(); 

                }
                break;
            case 15 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:66: RULE_NUMBER
                {
                mRULE_NUMBER(); 

                }
                break;
            case 16 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:78: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 17 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:87: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 18 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:95: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 19 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:107: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 20 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:123: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 21 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:139: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 22 :
                // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1:147: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}
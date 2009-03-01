package org.eclipse.xtext.valueconverter.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug250313Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'mykeyword1'", "'1+'", "'2'", "'2+'", "'3'", "'3+'", "'4'", "'4+'", "'content'", "'ref'", "'-'", "'+'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug250313Parser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g"; }


     
     	private Bug250313GrammarAccess grammarAccess;
     	
        public InternalBug250313Parser(TokenStream input, IAstFactory factory, Bug250313GrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:70:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:71:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prModel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel72);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel82); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:78:1: ruleModel returns [EObject current=null] : ( ( ( ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_value_1=null;
        Token lv_multiValue_3=null;
        Token lv_value_5=null;
        Token lv_multiValue_7=null;
        AntlrDatatypeRuleToken lv_value_9 = null;

        AntlrDatatypeRuleToken lv_multiValue_11 = null;

        AntlrDatatypeRuleToken lv_value_13 = null;

        AntlrDatatypeRuleToken lv_multiValue_15 = null;

        EObject lv_children_17 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:83:6: ( ( ( ( ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:1: ( ( ( ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:1: ( ( ( ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_ID)||(LA19_0>=11 && LA19_0<=19)) ) {
                alt19=1;
            }
            else if ( (LA19_0==20) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("84:1: ( ( ( ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:2: ( ( ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:2: ( ( ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_ID)||(LA16_0>=11 && LA16_0<=18)) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==19) ) {
                        alt16=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("84:2: ( ( ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) )", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:3: ( ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:3: ( ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) )
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_ID)||(LA15_0>=11 && LA15_0<=17)) ) {
                                alt15=1;
                            }
                            else if ( (LA15_0==18) ) {
                                alt15=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("84:3: ( ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) )", 15, 0, input);

                                throw nvae;
                            }
                            switch (alt15) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:4: ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:4: ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) )
                                    int alt14=2;
                                    int LA14_0 = input.LA(1);

                                    if ( ((LA14_0>=RULE_STRING && LA14_0<=RULE_ID)||(LA14_0>=11 && LA14_0<=16)) ) {
                                        alt14=1;
                                    }
                                    else if ( (LA14_0==17) ) {
                                        alt14=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("84:4: ( ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) )", 14, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt14) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:5: ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) )
                                            {
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:5: ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) )
                                            int alt13=2;
                                            int LA13_0 = input.LA(1);

                                            if ( ((LA13_0>=RULE_STRING && LA13_0<=RULE_ID)||(LA13_0>=11 && LA13_0<=15)) ) {
                                                alt13=1;
                                            }
                                            else if ( (LA13_0==16) ) {
                                                alt13=2;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("84:5: ( ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) ) | ( '3' (lv_value_9= ruleDatatype ) ) )", 13, 0, input);

                                                throw nvae;
                                            }
                                            switch (alt13) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:6: ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) )
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:6: ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) )
                                                    int alt12=2;
                                                    int LA12_0 = input.LA(1);

                                                    if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_ID)||(LA12_0>=11 && LA12_0<=14)) ) {
                                                        alt12=1;
                                                    }
                                                    else if ( (LA12_0==15) ) {
                                                        alt12=2;
                                                    }
                                                    else {
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("84:6: ( ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) )", 12, 0, input);

                                                        throw nvae;
                                                    }
                                                    switch (alt12) {
                                                        case 1 :
                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:7: ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) )
                                                            {
                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:7: ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) )
                                                            int alt11=2;
                                                            int LA11_0 = input.LA(1);

                                                            if ( ((LA11_0>=RULE_STRING && LA11_0<=RULE_ID)||(LA11_0>=11 && LA11_0<=13)) ) {
                                                                alt11=1;
                                                            }
                                                            else if ( (LA11_0==14) ) {
                                                                alt11=2;
                                                            }
                                                            else {
                                                                NoViableAltException nvae =
                                                                    new NoViableAltException("84:7: ( ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) )", 11, 0, input);

                                                                throw nvae;
                                                            }
                                                            switch (alt11) {
                                                                case 1 :
                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:8: ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) )
                                                                    {
                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:8: ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) )
                                                                    int alt10=2;
                                                                    int LA10_0 = input.LA(1);

                                                                    if ( ((LA10_0>=RULE_STRING && LA10_0<=RULE_ID)||(LA10_0>=11 && LA10_0<=12)) ) {
                                                                        alt10=1;
                                                                    }
                                                                    else if ( (LA10_0==13) ) {
                                                                        alt10=2;
                                                                    }
                                                                    else {
                                                                        NoViableAltException nvae =
                                                                            new NoViableAltException("84:8: ( ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) ) )", 10, 0, input);

                                                                        throw nvae;
                                                                    }
                                                                    switch (alt10) {
                                                                        case 1 :
                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:9: ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) )
                                                                            {
                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:9: ( ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) )
                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:10: ( '1' )? (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) )
                                                                            {
                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:10: ( '1' )?
                                                                            int alt1=2;
                                                                            int LA1_0 = input.LA(1);

                                                                            if ( (LA1_0==11) ) {
                                                                                alt1=1;
                                                                            }
                                                                            switch (alt1) {
                                                                                case 1 :
                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:84:11: '1'
                                                                                    {
                                                                                    match(input,11,FOLLOW_11_in_ruleModel125); 

                                                                                            createLeafNode(grammarAccess.prModel().ele000000000KeywordDigitOne(), null); 
                                                                                        

                                                                                    }
                                                                                    break;

                                                                            }

                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:88:3: (lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) )
                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:6: lv_value_1= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID )
                                                                            {
                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:17: ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID )
                                                                            int alt5=2;
                                                                            int LA5_0 = input.LA(1);

                                                                            if ( (LA5_0==RULE_STRING||LA5_0==12) ) {
                                                                                alt5=1;
                                                                            }
                                                                            else if ( (LA5_0==RULE_ID) ) {
                                                                                int LA5_2 = input.LA(2);

                                                                                if ( ((LA5_2>=22 && LA5_2<=23)) ) {
                                                                                    alt5=1;
                                                                                }
                                                                                else if ( (LA5_2==EOF) ) {
                                                                                    alt5=2;
                                                                                }
                                                                                else {
                                                                                    NoViableAltException nvae =
                                                                                        new NoViableAltException("90:17: ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID )", 5, 2, input);

                                                                                    throw nvae;
                                                                                }
                                                                            }
                                                                            else {
                                                                                NoViableAltException nvae =
                                                                                    new NoViableAltException("90:17: ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID )", 5, 0, input);

                                                                                throw nvae;
                                                                            }
                                                                            switch (alt5) {
                                                                                case 1 :
                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:18: ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype )
                                                                                    {
                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:18: ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype )
                                                                                    int alt4=2;
                                                                                    int LA4_0 = input.LA(1);

                                                                                    if ( (LA4_0==RULE_STRING||LA4_0==12) ) {
                                                                                        alt4=1;
                                                                                    }
                                                                                    else if ( (LA4_0==RULE_ID) ) {
                                                                                        int LA4_2 = input.LA(2);

                                                                                        if ( (LA4_2==22) ) {
                                                                                            alt4=2;
                                                                                        }
                                                                                        else if ( (LA4_2==23) ) {
                                                                                            alt4=1;
                                                                                        }
                                                                                        else {
                                                                                            NoViableAltException nvae =
                                                                                                new NoViableAltException("90:18: ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype )", 4, 2, input);

                                                                                            throw nvae;
                                                                                        }
                                                                                    }
                                                                                    else {
                                                                                        NoViableAltException nvae =
                                                                                            new NoViableAltException("90:18: ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype )", 4, 0, input);

                                                                                        throw nvae;
                                                                                    }
                                                                                    switch (alt4) {
                                                                                        case 1 :
                                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:19: ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype )
                                                                                            {
                                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:19: ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype )
                                                                                            int alt3=2;
                                                                                            int LA3_0 = input.LA(1);

                                                                                            if ( (LA3_0==RULE_STRING||LA3_0==12) ) {
                                                                                                alt3=1;
                                                                                            }
                                                                                            else if ( (LA3_0==RULE_ID) ) {
                                                                                                alt3=2;
                                                                                            }
                                                                                            else {
                                                                                                NoViableAltException nvae =
                                                                                                    new NoViableAltException("90:19: ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype )", 3, 0, input);

                                                                                                throw nvae;
                                                                                            }
                                                                                            switch (alt3) {
                                                                                                case 1 :
                                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:20: ( 'mykeyword1' | RULE_STRING )
                                                                                                    {
                                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:20: ( 'mykeyword1' | RULE_STRING )
                                                                                                    int alt2=2;
                                                                                                    int LA2_0 = input.LA(1);

                                                                                                    if ( (LA2_0==12) ) {
                                                                                                        alt2=1;
                                                                                                    }
                                                                                                    else if ( (LA2_0==RULE_STRING) ) {
                                                                                                        alt2=2;
                                                                                                    }
                                                                                                    else {
                                                                                                        NoViableAltException nvae =
                                                                                                            new NoViableAltException("90:20: ( 'mykeyword1' | RULE_STRING )", 2, 0, input);

                                                                                                        throw nvae;
                                                                                                    }
                                                                                                    switch (alt2) {
                                                                                                        case 1 :
                                                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:21: 'mykeyword1'
                                                                                                            {
                                                                                                            match(input,12,FOLLOW_12_in_ruleModel152); 

                                                                                                                    createLeafNode(grammarAccess.prModel().ele00000000100000KeywordMykeyword1(), "value"); 
                                                                                                                

                                                                                                            }
                                                                                                            break;
                                                                                                        case 2 :
                                                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:96:7: RULE_STRING
                                                                                                            {
                                                                                                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel169); 

                                                                                                            		createLeafNode(grammarAccess.prModel().ele00000000100001ParserRuleCallSTRING(), "value"); 
                                                                                                            	

                                                                                                            }
                                                                                                            break;

                                                                                                    }


                                                                                                    }
                                                                                                    break;
                                                                                                case 2 :
                                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:102:8: ruleNestedDatatype
                                                                                                    {
                                                                                                     
                                                                                                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele0000000010001ParserRuleCallNestedDatatype(), currentNode); 
                                                                                                    	    
                                                                                                    pushFollow(FOLLOW_ruleNestedDatatype_in_ruleModel188);
                                                                                                    ruleNestedDatatype();
                                                                                                    _fsp--;

                                                                                                     
                                                                                                    	        currentNode = currentNode.getParent();
                                                                                                    	    

                                                                                                    }
                                                                                                    break;

                                                                                            }


                                                                                            }
                                                                                            break;
                                                                                        case 2 :
                                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:110:8: ruleDatatype
                                                                                            {
                                                                                             
                                                                                            	        currentNode=createCompositeNode(grammarAccess.prModel().ele000000001001ParserRuleCallDatatype(), currentNode); 
                                                                                            	    
                                                                                            pushFollow(FOLLOW_ruleDatatype_in_ruleModel207);
                                                                                            ruleDatatype();
                                                                                            _fsp--;

                                                                                             
                                                                                            	        currentNode = currentNode.getParent();
                                                                                            	    

                                                                                            }
                                                                                            break;

                                                                                    }


                                                                                    }
                                                                                    break;
                                                                                case 2 :
                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:118:7: RULE_ID
                                                                                    {
                                                                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel221); 

                                                                                    		createLeafNode(grammarAccess.prModel().ele00000000101ParserRuleCallID(), "value"); 
                                                                                    	

                                                                                    }
                                                                                    break;

                                                                            }


                                                                            	        if (current==null) {
                                                                            	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                                                                            	            associateNodeWithAstElement(currentNode, current);
                                                                            	        }
                                                                            	        
                                                                            	        try {
                                                                            	       		set(current, "value", /* lv_value_1 */ input.LT(-1), null, lastConsumedNode);
                                                                            	        } catch (ValueConverterException vce) {
                                                                            				handleValueConverterException(vce);
                                                                            	        }
                                                                            	    

                                                                            }


                                                                            }


                                                                            }
                                                                            break;
                                                                        case 2 :
                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:138:6: ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) )
                                                                            {
                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:138:6: ( '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) ) )
                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:138:7: '1+' (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) )
                                                                            {
                                                                            match(input,13,FOLLOW_13_in_ruleModel248); 

                                                                                    createLeafNode(grammarAccess.prModel().ele000000010KeywordDigitOnePlusSign(), null); 
                                                                                
                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:142:1: (lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID ) )
                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:144:6: lv_multiValue_3= ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID )
                                                                            {
                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:144:22: ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID )
                                                                            int alt9=2;
                                                                            int LA9_0 = input.LA(1);

                                                                            if ( (LA9_0==RULE_STRING||LA9_0==12) ) {
                                                                                alt9=1;
                                                                            }
                                                                            else if ( (LA9_0==RULE_ID) ) {
                                                                                int LA9_2 = input.LA(2);

                                                                                if ( ((LA9_2>=22 && LA9_2<=23)) ) {
                                                                                    alt9=1;
                                                                                }
                                                                                else if ( (LA9_2==EOF) ) {
                                                                                    alt9=2;
                                                                                }
                                                                                else {
                                                                                    NoViableAltException nvae =
                                                                                        new NoViableAltException("144:22: ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID )", 9, 2, input);

                                                                                    throw nvae;
                                                                                }
                                                                            }
                                                                            else {
                                                                                NoViableAltException nvae =
                                                                                    new NoViableAltException("144:22: ( ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype ) | RULE_ID )", 9, 0, input);

                                                                                throw nvae;
                                                                            }
                                                                            switch (alt9) {
                                                                                case 1 :
                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:144:23: ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype )
                                                                                    {
                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:144:23: ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype )
                                                                                    int alt8=2;
                                                                                    int LA8_0 = input.LA(1);

                                                                                    if ( (LA8_0==RULE_STRING||LA8_0==12) ) {
                                                                                        alt8=1;
                                                                                    }
                                                                                    else if ( (LA8_0==RULE_ID) ) {
                                                                                        int LA8_2 = input.LA(2);

                                                                                        if ( (LA8_2==23) ) {
                                                                                            alt8=1;
                                                                                        }
                                                                                        else if ( (LA8_2==22) ) {
                                                                                            alt8=2;
                                                                                        }
                                                                                        else {
                                                                                            NoViableAltException nvae =
                                                                                                new NoViableAltException("144:23: ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype )", 8, 2, input);

                                                                                            throw nvae;
                                                                                        }
                                                                                    }
                                                                                    else {
                                                                                        NoViableAltException nvae =
                                                                                            new NoViableAltException("144:23: ( ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype ) | ruleDatatype )", 8, 0, input);

                                                                                        throw nvae;
                                                                                    }
                                                                                    switch (alt8) {
                                                                                        case 1 :
                                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:144:24: ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype )
                                                                                            {
                                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:144:24: ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype )
                                                                                            int alt7=2;
                                                                                            int LA7_0 = input.LA(1);

                                                                                            if ( (LA7_0==RULE_STRING||LA7_0==12) ) {
                                                                                                alt7=1;
                                                                                            }
                                                                                            else if ( (LA7_0==RULE_ID) ) {
                                                                                                alt7=2;
                                                                                            }
                                                                                            else {
                                                                                                NoViableAltException nvae =
                                                                                                    new NoViableAltException("144:24: ( ( 'mykeyword1' | RULE_STRING ) | ruleNestedDatatype )", 7, 0, input);

                                                                                                throw nvae;
                                                                                            }
                                                                                            switch (alt7) {
                                                                                                case 1 :
                                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:144:25: ( 'mykeyword1' | RULE_STRING )
                                                                                                    {
                                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:144:25: ( 'mykeyword1' | RULE_STRING )
                                                                                                    int alt6=2;
                                                                                                    int LA6_0 = input.LA(1);

                                                                                                    if ( (LA6_0==12) ) {
                                                                                                        alt6=1;
                                                                                                    }
                                                                                                    else if ( (LA6_0==RULE_STRING) ) {
                                                                                                        alt6=2;
                                                                                                    }
                                                                                                    else {
                                                                                                        NoViableAltException nvae =
                                                                                                            new NoViableAltException("144:25: ( 'mykeyword1' | RULE_STRING )", 6, 0, input);

                                                                                                        throw nvae;
                                                                                                    }
                                                                                                    switch (alt6) {
                                                                                                        case 1 :
                                                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:144:26: 'mykeyword1'
                                                                                                            {
                                                                                                            match(input,12,FOLLOW_12_in_ruleModel273); 

                                                                                                                    createLeafNode(grammarAccess.prModel().ele00000001100000KeywordMykeyword1(), "multiValue"); 
                                                                                                                

                                                                                                            }
                                                                                                            break;
                                                                                                        case 2 :
                                                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:150:7: RULE_STRING
                                                                                                            {
                                                                                                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel290); 

                                                                                                            		createLeafNode(grammarAccess.prModel().ele00000001100001ParserRuleCallSTRING(), "multiValue"); 
                                                                                                            	

                                                                                                            }
                                                                                                            break;

                                                                                                    }


                                                                                                    }
                                                                                                    break;
                                                                                                case 2 :
                                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:156:8: ruleNestedDatatype
                                                                                                    {
                                                                                                     
                                                                                                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele0000000110001ParserRuleCallNestedDatatype(), currentNode); 
                                                                                                    	    
                                                                                                    pushFollow(FOLLOW_ruleNestedDatatype_in_ruleModel309);
                                                                                                    ruleNestedDatatype();
                                                                                                    _fsp--;

                                                                                                     
                                                                                                    	        currentNode = currentNode.getParent();
                                                                                                    	    

                                                                                                    }
                                                                                                    break;

                                                                                            }


                                                                                            }
                                                                                            break;
                                                                                        case 2 :
                                                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:164:8: ruleDatatype
                                                                                            {
                                                                                             
                                                                                            	        currentNode=createCompositeNode(grammarAccess.prModel().ele000000011001ParserRuleCallDatatype(), currentNode); 
                                                                                            	    
                                                                                            pushFollow(FOLLOW_ruleDatatype_in_ruleModel328);
                                                                                            ruleDatatype();
                                                                                            _fsp--;

                                                                                             
                                                                                            	        currentNode = currentNode.getParent();
                                                                                            	    

                                                                                            }
                                                                                            break;

                                                                                    }


                                                                                    }
                                                                                    break;
                                                                                case 2 :
                                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:172:7: RULE_ID
                                                                                    {
                                                                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel342); 

                                                                                    		createLeafNode(grammarAccess.prModel().ele00000001101ParserRuleCallID(), "multiValue"); 
                                                                                    	

                                                                                    }
                                                                                    break;

                                                                            }


                                                                            	        if (current==null) {
                                                                            	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                                                                            	            associateNodeWithAstElement(currentNode, current);
                                                                            	        }
                                                                            	        
                                                                            	        try {
                                                                            	       		add(current, "multiValue", /* lv_multiValue_3 */ input.LT(-1), null, lastConsumedNode);
                                                                            	        } catch (ValueConverterException vce) {
                                                                            				handleValueConverterException(vce);
                                                                            	        }
                                                                            	    

                                                                            }


                                                                            }


                                                                            }
                                                                            break;

                                                                    }


                                                                    }
                                                                    break;
                                                                case 2 :
                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:192:6: ( '2' (lv_value_5= RULE_STRING ) )
                                                                    {
                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:192:6: ( '2' (lv_value_5= RULE_STRING ) )
                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:192:7: '2' (lv_value_5= RULE_STRING )
                                                                    {
                                                                    match(input,14,FOLLOW_14_in_ruleModel370); 

                                                                            createLeafNode(grammarAccess.prModel().ele00000010KeywordDigitTwo(), null); 
                                                                        
                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:196:1: (lv_value_5= RULE_STRING )
                                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:198:6: lv_value_5= RULE_STRING
                                                                    {
                                                                    lv_value_5=(Token)input.LT(1);
                                                                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel391); 

                                                                    		createLeafNode(grammarAccess.prModel().ele000000110ParserRuleCallSTRING(), "value"); 
                                                                    	

                                                                    	        if (current==null) {
                                                                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                                                                    	            associateNodeWithAstElement(currentNode, current);
                                                                    	        }
                                                                    	        
                                                                    	        try {
                                                                    	       		set(current, "value", lv_value_5, "STRING", lastConsumedNode);
                                                                    	        } catch (ValueConverterException vce) {
                                                                    				handleValueConverterException(vce);
                                                                    	        }
                                                                    	    

                                                                    }


                                                                    }


                                                                    }
                                                                    break;

                                                            }


                                                            }
                                                            break;
                                                        case 2 :
                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:216:6: ( '2+' (lv_multiValue_7= RULE_STRING ) )
                                                            {
                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:216:6: ( '2+' (lv_multiValue_7= RULE_STRING ) )
                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:216:7: '2+' (lv_multiValue_7= RULE_STRING )
                                                            {
                                                            match(input,15,FOLLOW_15_in_ruleModel416); 

                                                                    createLeafNode(grammarAccess.prModel().ele0000010KeywordDigitTwoPlusSign(), null); 
                                                                
                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:220:1: (lv_multiValue_7= RULE_STRING )
                                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:222:6: lv_multiValue_7= RULE_STRING
                                                            {
                                                            lv_multiValue_7=(Token)input.LT(1);
                                                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel437); 

                                                            		createLeafNode(grammarAccess.prModel().ele00000110ParserRuleCallSTRING(), "multiValue"); 
                                                            	

                                                            	        if (current==null) {
                                                            	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                                                            	            associateNodeWithAstElement(currentNode, current);
                                                            	        }
                                                            	        
                                                            	        try {
                                                            	       		add(current, "multiValue", lv_multiValue_7, "STRING", lastConsumedNode);
                                                            	        } catch (ValueConverterException vce) {
                                                            				handleValueConverterException(vce);
                                                            	        }
                                                            	    

                                                            }


                                                            }


                                                            }
                                                            break;

                                                    }


                                                    }
                                                    break;
                                                case 2 :
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:240:6: ( '3' (lv_value_9= ruleDatatype ) )
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:240:6: ( '3' (lv_value_9= ruleDatatype ) )
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:240:7: '3' (lv_value_9= ruleDatatype )
                                                    {
                                                    match(input,16,FOLLOW_16_in_ruleModel462); 

                                                            createLeafNode(grammarAccess.prModel().ele000010KeywordDigitThree(), null); 
                                                        
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:244:1: (lv_value_9= ruleDatatype )
                                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:247:6: lv_value_9= ruleDatatype
                                                    {
                                                     
                                                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele0000110ParserRuleCallDatatype(), currentNode); 
                                                    	    
                                                    pushFollow(FOLLOW_ruleDatatype_in_ruleModel496);
                                                    lv_value_9=ruleDatatype();
                                                    _fsp--;


                                                    	        if (current==null) {
                                                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                                                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                                                    	        }
                                                    	        
                                                    	        try {
                                                    	       		set(current, "value", lv_value_9, "Datatype", currentNode);
                                                    	        } catch (ValueConverterException vce) {
                                                    				handleValueConverterException(vce);
                                                    	        }
                                                    	        currentNode = currentNode.getParent();
                                                    	    

                                                    }


                                                    }


                                                    }
                                                    break;

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:266:6: ( '3+' (lv_multiValue_11= ruleDatatype ) )
                                            {
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:266:6: ( '3+' (lv_multiValue_11= ruleDatatype ) )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:266:7: '3+' (lv_multiValue_11= ruleDatatype )
                                            {
                                            match(input,17,FOLLOW_17_in_ruleModel518); 

                                                    createLeafNode(grammarAccess.prModel().ele00010KeywordDigitThreePlusSign(), null); 
                                                
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:270:1: (lv_multiValue_11= ruleDatatype )
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:273:6: lv_multiValue_11= ruleDatatype
                                            {
                                             
                                            	        currentNode=createCompositeNode(grammarAccess.prModel().ele000110ParserRuleCallDatatype(), currentNode); 
                                            	    
                                            pushFollow(FOLLOW_ruleDatatype_in_ruleModel552);
                                            lv_multiValue_11=ruleDatatype();
                                            _fsp--;


                                            	        if (current==null) {
                                            	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                                            	        }
                                            	        
                                            	        try {
                                            	       		add(current, "multiValue", lv_multiValue_11, "Datatype", currentNode);
                                            	        } catch (ValueConverterException vce) {
                                            				handleValueConverterException(vce);
                                            	        }
                                            	        currentNode = currentNode.getParent();
                                            	    

                                            }


                                            }


                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:292:6: ( '4' (lv_value_13= ruleNestedDatatype ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:292:6: ( '4' (lv_value_13= ruleNestedDatatype ) )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:292:7: '4' (lv_value_13= ruleNestedDatatype )
                                    {
                                    match(input,18,FOLLOW_18_in_ruleModel574); 

                                            createLeafNode(grammarAccess.prModel().ele0010KeywordDigitFour(), null); 
                                        
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:296:1: (lv_value_13= ruleNestedDatatype )
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:299:6: lv_value_13= ruleNestedDatatype
                                    {
                                     
                                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele00110ParserRuleCallNestedDatatype(), currentNode); 
                                    	    
                                    pushFollow(FOLLOW_ruleNestedDatatype_in_ruleModel608);
                                    lv_value_13=ruleNestedDatatype();
                                    _fsp--;


                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "value", lv_value_13, "NestedDatatype", currentNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	        currentNode = currentNode.getParent();
                                    	    

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:318:6: ( '4+' (lv_multiValue_15= ruleNestedDatatype ) )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:318:6: ( '4+' (lv_multiValue_15= ruleNestedDatatype ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:318:7: '4+' (lv_multiValue_15= ruleNestedDatatype )
                            {
                            match(input,19,FOLLOW_19_in_ruleModel630); 

                                    createLeafNode(grammarAccess.prModel().ele010KeywordDigitFourPlusSign(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:322:1: (lv_multiValue_15= ruleNestedDatatype )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:325:6: lv_multiValue_15= ruleNestedDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.prModel().ele0110ParserRuleCallNestedDatatype(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleNestedDatatype_in_ruleModel664);
                            lv_multiValue_15=ruleNestedDatatype();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        
                            	        try {
                            	       		add(current, "multiValue", lv_multiValue_15, "NestedDatatype", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:344:6: ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:344:6: ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:344:7: ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:344:7: ( 'content' (lv_children_17= ruleChild ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:344:8: 'content' (lv_children_17= ruleChild )
                    {
                    match(input,20,FOLLOW_20_in_ruleModel687); 

                            createLeafNode(grammarAccess.prModel().ele100KeywordContent(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:348:1: (lv_children_17= ruleChild )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:351:6: lv_children_17= ruleChild
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele1010ParserRuleCallChild(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleChild_in_ruleModel721);
                    lv_children_17=ruleChild();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "children", lv_children_17, "Child", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:369:3: ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==21) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:369:4: 'ref' ( ( RULE_STRING | RULE_ID ) )
                            {
                            match(input,21,FOLLOW_21_in_ruleModel736); 

                                    createLeafNode(grammarAccess.prModel().ele110KeywordRef(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:373:1: ( ( RULE_STRING | RULE_ID ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:376:3: ( RULE_STRING | RULE_ID )
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:382:1: ( RULE_STRING | RULE_ID )
                            int alt17=2;
                            int LA17_0 = input.LA(1);

                            if ( (LA17_0==RULE_STRING) ) {
                                alt17=1;
                            }
                            else if ( (LA17_0==RULE_ID) ) {
                                alt17=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("382:1: ( RULE_STRING | RULE_ID )", 17, 0, input);

                                throw nvae;
                            }
                            switch (alt17) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:382:3: RULE_STRING
                                    {
                                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel759); 

                                    		createLeafNode(grammarAccess.prModel().ele11100CrossReferenceEStringChild1(), "ref"); 
                                    	

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:387:7: RULE_ID
                                    {
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel771); 

                                    		createLeafNode(grammarAccess.prModel().ele11101CrossReferenceEStringChild2(), "ref"); 
                                    	

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:404:1: entryRuleDatatype returns [String current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final String entryRuleDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:404:49: (iv_ruleDatatype= ruleDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:405:2: iv_ruleDatatype= ruleDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.prDatatype().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleDatatype_in_entryRuleDatatype815);
            iv_ruleDatatype=ruleDatatype();
            _fsp--;

             current =iv_ruleDatatype.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatype826); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDatatype


    // $ANTLR start ruleDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:412:1: ruleDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '-' ) this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:418:6: ( ( (this_ID_0= RULE_ID kw= '-' ) this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:419:1: ( (this_ID_0= RULE_ID kw= '-' ) this_ID_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:419:1: ( (this_ID_0= RULE_ID kw= '-' ) this_ID_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:419:2: (this_ID_0= RULE_ID kw= '-' ) this_ID_2= RULE_ID
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:419:2: (this_ID_0= RULE_ID kw= '-' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:419:7: this_ID_0= RULE_ID kw= '-'
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype867); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prDatatype().ele00ParserRuleCallID(), null); 
                
            kw=(Token)input.LT(1);
            match(input,22,FOLLOW_22_in_ruleDatatype885); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.prDatatype().ele01KeywordHyphenMinus(), null); 
                

            }

            this_ID_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype901); 

            		current.merge(this_ID_2);
                
             
                createLeafNode(grammarAccess.prDatatype().ele1ParserRuleCallID(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDatatype


    // $ANTLR start entryRuleNestedDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:449:1: entryRuleNestedDatatype returns [String current=null] : iv_ruleNestedDatatype= ruleNestedDatatype EOF ;
    public final String entryRuleNestedDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNestedDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:449:55: (iv_ruleNestedDatatype= ruleNestedDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:450:2: iv_ruleNestedDatatype= ruleNestedDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNestedDatatype().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNestedDatatype_in_entryRuleNestedDatatype947);
            iv_ruleNestedDatatype=ruleNestedDatatype();
            _fsp--;

             current =iv_ruleNestedDatatype.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedDatatype958); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNestedDatatype


    // $ANTLR start ruleNestedDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:457:1: ruleNestedDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '+' ) (this_Datatype_2= ruleDatatype )? ) ;
    public final AntlrDatatypeRuleToken ruleNestedDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_Datatype_2 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:463:6: ( ( (this_ID_0= RULE_ID kw= '+' ) (this_Datatype_2= ruleDatatype )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:464:1: ( (this_ID_0= RULE_ID kw= '+' ) (this_Datatype_2= ruleDatatype )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:464:1: ( (this_ID_0= RULE_ID kw= '+' ) (this_Datatype_2= ruleDatatype )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:464:2: (this_ID_0= RULE_ID kw= '+' ) (this_Datatype_2= ruleDatatype )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:464:2: (this_ID_0= RULE_ID kw= '+' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:464:7: this_ID_0= RULE_ID kw= '+'
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNestedDatatype999); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prNestedDatatype().ele00ParserRuleCallID(), null); 
                
            kw=(Token)input.LT(1);
            match(input,23,FOLLOW_23_in_ruleNestedDatatype1017); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.prNestedDatatype().ele01KeywordPlusSign(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:477:2: (this_Datatype_2= ruleDatatype )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:478:5: this_Datatype_2= ruleDatatype
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prNestedDatatype().ele1ParserRuleCallDatatype(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDatatype_in_ruleNestedDatatype1041);
                    this_Datatype_2=ruleDatatype();
                    _fsp--;


                    		current.merge(this_Datatype_2);
                        
                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNestedDatatype


    // $ANTLR start entryRuleChild
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:498:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:498:47: (iv_ruleChild= ruleChild EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:499:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.prChild().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleChild_in_entryRuleChild1088);
            iv_ruleChild=ruleChild();
            _fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild1098); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleChild


    // $ANTLR start ruleChild
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:506:1: ruleChild returns [EObject current=null] : (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        EObject this_Child1_0 = null;

        EObject this_Child2_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:511:6: ( (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:512:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:512:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                alt21=1;
            }
            else if ( (LA21_0==RULE_STRING) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("512:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:513:5: this_Child1_0= ruleChild1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prChild().ele0ParserRuleCallChild1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChild1_in_ruleChild1145);
                    this_Child1_0=ruleChild1();
                    _fsp--;

                     
                            current = this_Child1_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:523:5: this_Child2_1= ruleChild2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prChild().ele1ParserRuleCallChild2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChild2_in_ruleChild1172);
                    this_Child2_1=ruleChild2();
                    _fsp--;

                     
                            current = this_Child2_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleChild


    // $ANTLR start entryRuleChild1
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:540:1: entryRuleChild1 returns [EObject current=null] : iv_ruleChild1= ruleChild1 EOF ;
    public final EObject entryRuleChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:540:48: (iv_ruleChild1= ruleChild1 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:541:2: iv_ruleChild1= ruleChild1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prChild1().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleChild1_in_entryRuleChild11206);
            iv_ruleChild1=ruleChild1();
            _fsp--;

             current =iv_ruleChild1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild11216); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleChild1


    // $ANTLR start ruleChild1
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:548:1: ruleChild1 returns [EObject current=null] : (lv_name_0= RULE_ID ) ;
    public final EObject ruleChild1() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:553:6: ( (lv_name_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:554:1: (lv_name_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:554:1: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:556:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChild11261); 

            		createLeafNode(grammarAccess.prChild1().ele0ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prChild1().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleChild1


    // $ANTLR start entryRuleChild2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:582:1: entryRuleChild2 returns [EObject current=null] : iv_ruleChild2= ruleChild2 EOF ;
    public final EObject entryRuleChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:582:48: (iv_ruleChild2= ruleChild2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:583:2: iv_ruleChild2= ruleChild2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prChild2().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleChild2_in_entryRuleChild21302);
            iv_ruleChild2=ruleChild2();
            _fsp--;

             current =iv_ruleChild2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild21312); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleChild2


    // $ANTLR start ruleChild2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:590:1: ruleChild2 returns [EObject current=null] : (lv_name_0= RULE_STRING ) ;
    public final EObject ruleChild2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:595:6: ( (lv_name_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:596:1: (lv_name_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:596:1: (lv_name_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:598:6: lv_name_0= RULE_STRING
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleChild21357); 

            		createLeafNode(grammarAccess.prChild2().ele0ParserRuleCallSTRING(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prChild2().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleChild2


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel125 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_12_in_ruleModel152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModel248 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_12_in_ruleModel273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleModel370 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleModel416 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleModel462 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleModel518 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleModel574 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleModel630 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleModel687 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleChild_in_ruleModel721 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleModel736 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype815 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatype826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype867 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleDatatype885 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_entryRuleNestedDatatype947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedDatatype958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNestedDatatype999 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNestedDatatype1017 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleNestedDatatype1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild_in_entryRuleChild1088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild1_in_ruleChild1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild2_in_ruleChild1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild1_in_entryRuleChild11206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild11216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChild11261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild2_in_entryRuleChild21302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild21312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleChild21357 = new BitSet(new long[]{0x0000000000000002L});

}
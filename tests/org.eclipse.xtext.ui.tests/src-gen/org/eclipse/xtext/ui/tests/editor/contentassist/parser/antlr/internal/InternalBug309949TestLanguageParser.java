package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug309949TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug309949TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1*'", "'{'", "'}'", "'#1+'", "'#2*'", "'#2+'", "'#3*'", "'#3+'", "'#4*'", "'#4+'", "'#5*'", "'#5+'", "'error'", "'operation'", "'@uuid'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug309949TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g"; }



     	private Bug309949TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug309949TestLanguageParser(TokenStream input, IAstFactory factory, Bug309949TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug309949TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( () ( ( '#1*' '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* '}' ) | ( '#1+' '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ '}' ) | ( '#2*' '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* '}' ) | ( '#2+' ( (lv_name_17_0= RULE_ID ) ) '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ '}' ) | ( '#3*' ( (lv_name_23_0= RULE_ID ) ) '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* '}' ) | ( '#3+' ( (lv_name_29_0= RULE_ID ) ) '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ '}' ) | ( '#4*' ( (lv_name_35_0= RULE_ID ) ) '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* '}' ) | ( '#4+' ( (lv_name_41_0= RULE_ID ) ) '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ '}' ) | ( '#5*' ( (lv_name_47_0= RULE_ID ) ) '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* '}' ) | ( '#5+' ( (lv_name_53_0= RULE_ID ) ) '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ '}' ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_17_0=null;
        Token lv_name_23_0=null;
        Token lv_name_29_0=null;
        Token lv_name_35_0=null;
        Token lv_name_41_0=null;
        Token lv_name_47_0=null;
        Token lv_name_53_0=null;
        EObject lv_errors_3_0 = null;

        EObject lv_operations_4_0 = null;

        EObject lv_errors_8_0 = null;

        EObject lv_operations_9_0 = null;

        EObject lv_errors_13_0 = null;

        EObject lv_operations_14_0 = null;

        EObject lv_errors_19_0 = null;

        EObject lv_operations_20_0 = null;

        EObject lv_errors_25_0 = null;

        EObject lv_operations_26_0 = null;

        EObject lv_errors_31_0 = null;

        EObject lv_operations_32_0 = null;

        EObject lv_errors_37_0 = null;

        EObject lv_operations_38_0 = null;

        EObject lv_errors_43_0 = null;

        EObject lv_operations_44_0 = null;

        EObject lv_errors_49_0 = null;

        EObject lv_operations_50_0 = null;

        EObject lv_errors_55_0 = null;

        EObject lv_operations_56_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:91:6: ( ( () ( ( '#1*' '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* '}' ) | ( '#1+' '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ '}' ) | ( '#2*' '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* '}' ) | ( '#2+' ( (lv_name_17_0= RULE_ID ) ) '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ '}' ) | ( '#3*' ( (lv_name_23_0= RULE_ID ) ) '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* '}' ) | ( '#3+' ( (lv_name_29_0= RULE_ID ) ) '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ '}' ) | ( '#4*' ( (lv_name_35_0= RULE_ID ) ) '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* '}' ) | ( '#4+' ( (lv_name_41_0= RULE_ID ) ) '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ '}' ) | ( '#5*' ( (lv_name_47_0= RULE_ID ) ) '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* '}' ) | ( '#5+' ( (lv_name_53_0= RULE_ID ) ) '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ '}' ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:92:1: ( () ( ( '#1*' '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* '}' ) | ( '#1+' '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ '}' ) | ( '#2*' '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* '}' ) | ( '#2+' ( (lv_name_17_0= RULE_ID ) ) '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ '}' ) | ( '#3*' ( (lv_name_23_0= RULE_ID ) ) '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* '}' ) | ( '#3+' ( (lv_name_29_0= RULE_ID ) ) '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ '}' ) | ( '#4*' ( (lv_name_35_0= RULE_ID ) ) '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* '}' ) | ( '#4+' ( (lv_name_41_0= RULE_ID ) ) '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ '}' ) | ( '#5*' ( (lv_name_47_0= RULE_ID ) ) '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* '}' ) | ( '#5+' ( (lv_name_53_0= RULE_ID ) ) '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ '}' ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:92:1: ( () ( ( '#1*' '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* '}' ) | ( '#1+' '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ '}' ) | ( '#2*' '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* '}' ) | ( '#2+' ( (lv_name_17_0= RULE_ID ) ) '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ '}' ) | ( '#3*' ( (lv_name_23_0= RULE_ID ) ) '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* '}' ) | ( '#3+' ( (lv_name_29_0= RULE_ID ) ) '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ '}' ) | ( '#4*' ( (lv_name_35_0= RULE_ID ) ) '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* '}' ) | ( '#4+' ( (lv_name_41_0= RULE_ID ) ) '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ '}' ) | ( '#5*' ( (lv_name_47_0= RULE_ID ) ) '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* '}' ) | ( '#5+' ( (lv_name_53_0= RULE_ID ) ) '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ '}' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:92:2: () ( ( '#1*' '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* '}' ) | ( '#1+' '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ '}' ) | ( '#2*' '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* '}' ) | ( '#2+' ( (lv_name_17_0= RULE_ID ) ) '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ '}' ) | ( '#3*' ( (lv_name_23_0= RULE_ID ) ) '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* '}' ) | ( '#3+' ( (lv_name_29_0= RULE_ID ) ) '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ '}' ) | ( '#4*' ( (lv_name_35_0= RULE_ID ) ) '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* '}' ) | ( '#4+' ( (lv_name_41_0= RULE_ID ) ) '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ '}' ) | ( '#5*' ( (lv_name_47_0= RULE_ID ) ) '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* '}' ) | ( '#5+' ( (lv_name_53_0= RULE_ID ) ) '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ '}' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:92:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:93:5: 
            {
             
                    temp=factory.create(grammarAccess.getModelAccess().getModelAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getModelAccess().getModelAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:103:2: ( ( '#1*' '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* '}' ) | ( '#1+' '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ '}' ) | ( '#2*' '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* '}' ) | ( '#2+' ( (lv_name_17_0= RULE_ID ) ) '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ '}' ) | ( '#3*' ( (lv_name_23_0= RULE_ID ) ) '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* '}' ) | ( '#3+' ( (lv_name_29_0= RULE_ID ) ) '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ '}' ) | ( '#4*' ( (lv_name_35_0= RULE_ID ) ) '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* '}' ) | ( '#4+' ( (lv_name_41_0= RULE_ID ) ) '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ '}' ) | ( '#5*' ( (lv_name_47_0= RULE_ID ) ) '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* '}' ) | ( '#5+' ( (lv_name_53_0= RULE_ID ) ) '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ '}' ) )
            int alt21=10;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt21=1;
                }
                break;
            case 14:
                {
                alt21=2;
                }
                break;
            case 15:
                {
                alt21=3;
                }
                break;
            case 16:
                {
                alt21=4;
                }
                break;
            case 17:
                {
                alt21=5;
                }
                break;
            case 18:
                {
                alt21=6;
                }
                break;
            case 19:
                {
                alt21=7;
                }
                break;
            case 20:
                {
                alt21=8;
                }
                break;
            case 21:
                {
                alt21=9;
                }
                break;
            case 22:
                {
                alt21=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("103:2: ( ( '#1*' '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* '}' ) | ( '#1+' '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ '}' ) | ( '#2*' '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* '}' ) | ( '#2+' ( (lv_name_17_0= RULE_ID ) ) '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ '}' ) | ( '#3*' ( (lv_name_23_0= RULE_ID ) ) '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* '}' ) | ( '#3+' ( (lv_name_29_0= RULE_ID ) ) '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ '}' ) | ( '#4*' ( (lv_name_35_0= RULE_ID ) ) '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* '}' ) | ( '#4+' ( (lv_name_41_0= RULE_ID ) ) '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ '}' ) | ( '#5*' ( (lv_name_47_0= RULE_ID ) ) '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* '}' ) | ( '#5+' ( (lv_name_53_0= RULE_ID ) ) '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ '}' ) )", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:103:3: ( '#1*' '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:103:3: ( '#1*' '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:103:5: '#1*' '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* '}'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleModel131); 

                            createLeafNode(grammarAccess.getModelAccess().getNumberSignDigitOneAsteriskKeyword_1_0_0(), null); 
                        
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel141); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_0_1(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:111:1: ( (lv_errors_3_0= ruleError_1 ) )*
                    loop1:
                    do {
                        int alt1=2;
                        alt1 = dfa1.predict(input);
                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:112:1: (lv_errors_3_0= ruleError_1 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:112:1: (lv_errors_3_0= ruleError_1 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:113:3: lv_errors_3_0= ruleError_1
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getErrorsError_1ParserRuleCall_1_0_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_1_in_ruleModel162);
                    	    lv_errors_3_0=ruleError_1();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"errors",
                    	    	        		lv_errors_3_0, 
                    	    	        		"Error_1", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:135:3: ( (lv_operations_4_0= ruleOperation_1 ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=24 && LA2_0<=25)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:136:1: (lv_operations_4_0= ruleOperation_1 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:136:1: (lv_operations_4_0= ruleOperation_1 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:137:3: lv_operations_4_0= ruleOperation_1
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_1ParserRuleCall_1_0_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_1_in_ruleModel184);
                    	    lv_operations_4_0=ruleOperation_1();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operations",
                    	    	        		lv_operations_4_0, 
                    	    	        		"Operation_1", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel195); 

                            createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_0_4(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:164:6: ( '#1+' '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:164:6: ( '#1+' '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:164:8: '#1+' '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ '}'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleModel213); 

                            createLeafNode(grammarAccess.getModelAccess().getNumberSignDigitOnePlusSignKeyword_1_1_0(), null); 
                        
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel223); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_1_1(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:172:1: ( (lv_errors_8_0= ruleError_1 ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        alt3 = dfa3.predict(input);
                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:173:1: (lv_errors_8_0= ruleError_1 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:173:1: (lv_errors_8_0= ruleError_1 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:174:3: lv_errors_8_0= ruleError_1
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getErrorsError_1ParserRuleCall_1_1_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_1_in_ruleModel244);
                    	    lv_errors_8_0=ruleError_1();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"errors",
                    	    	        		lv_errors_8_0, 
                    	    	        		"Error_1", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


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

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:196:3: ( (lv_operations_9_0= ruleOperation_1 ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=24 && LA4_0<=25)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:197:1: (lv_operations_9_0= ruleOperation_1 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:197:1: (lv_operations_9_0= ruleOperation_1 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:198:3: lv_operations_9_0= ruleOperation_1
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_1ParserRuleCall_1_1_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_1_in_ruleModel266);
                    	    lv_operations_9_0=ruleOperation_1();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operations",
                    	    	        		lv_operations_9_0, 
                    	    	        		"Operation_1", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel277); 

                            createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_1_4(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:225:6: ( '#2*' '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:225:6: ( '#2*' '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:225:8: '#2*' '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* '}'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleModel295); 

                            createLeafNode(grammarAccess.getModelAccess().getNumberSignDigitTwoAsteriskKeyword_1_2_0(), null); 
                        
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel305); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_2_1(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:233:1: ( (lv_errors_13_0= ruleError_2 ) )*
                    loop5:
                    do {
                        int alt5=2;
                        alt5 = dfa5.predict(input);
                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:234:1: (lv_errors_13_0= ruleError_2 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:234:1: (lv_errors_13_0= ruleError_2 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:235:3: lv_errors_13_0= ruleError_2
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getErrorsError_2ParserRuleCall_1_2_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_2_in_ruleModel326);
                    	    lv_errors_13_0=ruleError_2();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"errors",
                    	    	        		lv_errors_13_0, 
                    	    	        		"Error_2", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:257:3: ( (lv_operations_14_0= ruleOperation_2 ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==25) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:258:1: (lv_operations_14_0= ruleOperation_2 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:258:1: (lv_operations_14_0= ruleOperation_2 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:259:3: lv_operations_14_0= ruleOperation_2
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_2ParserRuleCall_1_2_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_2_in_ruleModel348);
                    	    lv_operations_14_0=ruleOperation_2();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operations",
                    	    	        		lv_operations_14_0, 
                    	    	        		"Operation_2", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel359); 

                            createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_2_4(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:286:6: ( '#2+' ( (lv_name_17_0= RULE_ID ) ) '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:286:6: ( '#2+' ( (lv_name_17_0= RULE_ID ) ) '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:286:8: '#2+' ( (lv_name_17_0= RULE_ID ) ) '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ '}'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleModel377); 

                            createLeafNode(grammarAccess.getModelAccess().getNumberSignDigitTwoPlusSignKeyword_1_3_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:290:1: ( (lv_name_17_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:291:1: (lv_name_17_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:291:1: (lv_name_17_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:292:3: lv_name_17_0= RULE_ID
                    {
                    lv_name_17_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel394); 

                    			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_3_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_17_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel409); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_3_2(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:318:1: ( (lv_errors_19_0= ruleError_2 ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        alt7 = dfa7.predict(input);
                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:319:1: (lv_errors_19_0= ruleError_2 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:319:1: (lv_errors_19_0= ruleError_2 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:320:3: lv_errors_19_0= ruleError_2
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getErrorsError_2ParserRuleCall_1_3_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_2_in_ruleModel430);
                    	    lv_errors_19_0=ruleError_2();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"errors",
                    	    	        		lv_errors_19_0, 
                    	    	        		"Error_2", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:342:3: ( (lv_operations_20_0= ruleOperation_2 ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==25) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:343:1: (lv_operations_20_0= ruleOperation_2 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:343:1: (lv_operations_20_0= ruleOperation_2 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:344:3: lv_operations_20_0= ruleOperation_2
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_2ParserRuleCall_1_3_4_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_2_in_ruleModel452);
                    	    lv_operations_20_0=ruleOperation_2();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operations",
                    	    	        		lv_operations_20_0, 
                    	    	        		"Operation_2", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel463); 

                            createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_3_5(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:371:6: ( '#3*' ( (lv_name_23_0= RULE_ID ) ) '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:371:6: ( '#3*' ( (lv_name_23_0= RULE_ID ) ) '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:371:8: '#3*' ( (lv_name_23_0= RULE_ID ) ) '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* '}'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleModel481); 

                            createLeafNode(grammarAccess.getModelAccess().getNumberSignDigitThreeAsteriskKeyword_1_4_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:375:1: ( (lv_name_23_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:376:1: (lv_name_23_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:376:1: (lv_name_23_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:377:3: lv_name_23_0= RULE_ID
                    {
                    lv_name_23_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel498); 

                    			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_4_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_23_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel513); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_4_2(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:403:1: ( (lv_errors_25_0= ruleError_3 ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==25) ) {
                            int LA9_1 = input.LA(2);

                            if ( (LA9_1==RULE_ID) ) {
                                int LA9_4 = input.LA(3);

                                if ( (LA9_4==23) ) {
                                    alt9=1;
                                }


                            }


                        }
                        else if ( (LA9_0==23) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:404:1: (lv_errors_25_0= ruleError_3 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:404:1: (lv_errors_25_0= ruleError_3 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:405:3: lv_errors_25_0= ruleError_3
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getErrorsError_3ParserRuleCall_1_4_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_3_in_ruleModel534);
                    	    lv_errors_25_0=ruleError_3();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"errors",
                    	    	        		lv_errors_25_0, 
                    	    	        		"Error_3", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:427:3: ( (lv_operations_26_0= ruleOperation_3 ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=24 && LA10_0<=25)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:428:1: (lv_operations_26_0= ruleOperation_3 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:428:1: (lv_operations_26_0= ruleOperation_3 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:429:3: lv_operations_26_0= ruleOperation_3
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_3ParserRuleCall_1_4_4_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_3_in_ruleModel556);
                    	    lv_operations_26_0=ruleOperation_3();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operations",
                    	    	        		lv_operations_26_0, 
                    	    	        		"Operation_3", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel567); 

                            createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_4_5(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:456:6: ( '#3+' ( (lv_name_29_0= RULE_ID ) ) '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:456:6: ( '#3+' ( (lv_name_29_0= RULE_ID ) ) '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:456:8: '#3+' ( (lv_name_29_0= RULE_ID ) ) '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ '}'
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleModel585); 

                            createLeafNode(grammarAccess.getModelAccess().getNumberSignDigitThreePlusSignKeyword_1_5_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:460:1: ( (lv_name_29_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:461:1: (lv_name_29_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:461:1: (lv_name_29_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:462:3: lv_name_29_0= RULE_ID
                    {
                    lv_name_29_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel602); 

                    			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_5_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_29_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel617); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_5_2(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:488:1: ( (lv_errors_31_0= ruleError_3 ) )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==25) ) {
                            int LA11_1 = input.LA(2);

                            if ( (LA11_1==RULE_ID) ) {
                                int LA11_4 = input.LA(3);

                                if ( (LA11_4==23) ) {
                                    alt11=1;
                                }


                            }


                        }
                        else if ( (LA11_0==23) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:489:1: (lv_errors_31_0= ruleError_3 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:489:1: (lv_errors_31_0= ruleError_3 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:490:3: lv_errors_31_0= ruleError_3
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getErrorsError_3ParserRuleCall_1_5_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_3_in_ruleModel638);
                    	    lv_errors_31_0=ruleError_3();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"errors",
                    	    	        		lv_errors_31_0, 
                    	    	        		"Error_3", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:512:3: ( (lv_operations_32_0= ruleOperation_3 ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=24 && LA12_0<=25)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:513:1: (lv_operations_32_0= ruleOperation_3 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:513:1: (lv_operations_32_0= ruleOperation_3 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:514:3: lv_operations_32_0= ruleOperation_3
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_3ParserRuleCall_1_5_4_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_3_in_ruleModel660);
                    	    lv_operations_32_0=ruleOperation_3();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operations",
                    	    	        		lv_operations_32_0, 
                    	    	        		"Operation_3", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel671); 

                            createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_5_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:541:6: ( '#4*' ( (lv_name_35_0= RULE_ID ) ) '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:541:6: ( '#4*' ( (lv_name_35_0= RULE_ID ) ) '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:541:8: '#4*' ( (lv_name_35_0= RULE_ID ) ) '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* '}'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleModel689); 

                            createLeafNode(grammarAccess.getModelAccess().getNumberSignDigitFourAsteriskKeyword_1_6_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:545:1: ( (lv_name_35_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:546:1: (lv_name_35_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:546:1: (lv_name_35_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:547:3: lv_name_35_0= RULE_ID
                    {
                    lv_name_35_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel706); 

                    			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_6_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_35_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel721); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_6_2(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:573:1: ( (lv_errors_37_0= ruleError_4 ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==25) ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1==RULE_ID) ) {
                                int LA13_3 = input.LA(3);

                                if ( (LA13_3==23) ) {
                                    alt13=1;
                                }


                            }


                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:574:1: (lv_errors_37_0= ruleError_4 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:574:1: (lv_errors_37_0= ruleError_4 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:575:3: lv_errors_37_0= ruleError_4
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getErrorsError_4ParserRuleCall_1_6_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_4_in_ruleModel742);
                    	    lv_errors_37_0=ruleError_4();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"errors",
                    	    	        		lv_errors_37_0, 
                    	    	        		"Error_4", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:597:3: ( (lv_operations_38_0= ruleOperation_4 ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==25) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:598:1: (lv_operations_38_0= ruleOperation_4 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:598:1: (lv_operations_38_0= ruleOperation_4 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:599:3: lv_operations_38_0= ruleOperation_4
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_4ParserRuleCall_1_6_4_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_4_in_ruleModel764);
                    	    lv_operations_38_0=ruleOperation_4();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operations",
                    	    	        		lv_operations_38_0, 
                    	    	        		"Operation_4", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel775); 

                            createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_6_5(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:626:6: ( '#4+' ( (lv_name_41_0= RULE_ID ) ) '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:626:6: ( '#4+' ( (lv_name_41_0= RULE_ID ) ) '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:626:8: '#4+' ( (lv_name_41_0= RULE_ID ) ) '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ '}'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleModel793); 

                            createLeafNode(grammarAccess.getModelAccess().getNumberSignDigitFourPlusSignKeyword_1_7_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:630:1: ( (lv_name_41_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:631:1: (lv_name_41_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:631:1: (lv_name_41_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:632:3: lv_name_41_0= RULE_ID
                    {
                    lv_name_41_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel810); 

                    			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_7_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_41_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel825); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_7_2(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:658:1: ( (lv_errors_43_0= ruleError_4 ) )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==25) ) {
                            int LA15_1 = input.LA(2);

                            if ( (LA15_1==RULE_ID) ) {
                                int LA15_2 = input.LA(3);

                                if ( (LA15_2==23) ) {
                                    alt15=1;
                                }


                            }


                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:659:1: (lv_errors_43_0= ruleError_4 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:659:1: (lv_errors_43_0= ruleError_4 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:660:3: lv_errors_43_0= ruleError_4
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getErrorsError_4ParserRuleCall_1_7_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_4_in_ruleModel846);
                    	    lv_errors_43_0=ruleError_4();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"errors",
                    	    	        		lv_errors_43_0, 
                    	    	        		"Error_4", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:682:3: ( (lv_operations_44_0= ruleOperation_4 ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==25) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:683:1: (lv_operations_44_0= ruleOperation_4 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:683:1: (lv_operations_44_0= ruleOperation_4 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:684:3: lv_operations_44_0= ruleOperation_4
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_4ParserRuleCall_1_7_4_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_4_in_ruleModel868);
                    	    lv_operations_44_0=ruleOperation_4();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operations",
                    	    	        		lv_operations_44_0, 
                    	    	        		"Operation_4", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel879); 

                            createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_7_5(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:711:6: ( '#5*' ( (lv_name_47_0= RULE_ID ) ) '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:711:6: ( '#5*' ( (lv_name_47_0= RULE_ID ) ) '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:711:8: '#5*' ( (lv_name_47_0= RULE_ID ) ) '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* '}'
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleModel897); 

                            createLeafNode(grammarAccess.getModelAccess().getNumberSignDigitFiveAsteriskKeyword_1_8_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:715:1: ( (lv_name_47_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:716:1: (lv_name_47_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:716:1: (lv_name_47_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:717:3: lv_name_47_0= RULE_ID
                    {
                    lv_name_47_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel914); 

                    			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_8_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_47_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel929); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_8_2(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:743:1: ( (lv_errors_49_0= ruleError_5 ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==23) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:744:1: (lv_errors_49_0= ruleError_5 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:744:1: (lv_errors_49_0= ruleError_5 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:745:3: lv_errors_49_0= ruleError_5
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getErrorsError_5ParserRuleCall_1_8_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_5_in_ruleModel950);
                    	    lv_errors_49_0=ruleError_5();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"errors",
                    	    	        		lv_errors_49_0, 
                    	    	        		"Error_5", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:767:3: ( (lv_operations_50_0= ruleOperation_5 ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==24) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:768:1: (lv_operations_50_0= ruleOperation_5 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:768:1: (lv_operations_50_0= ruleOperation_5 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:769:3: lv_operations_50_0= ruleOperation_5
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_5ParserRuleCall_1_8_4_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_5_in_ruleModel972);
                    	    lv_operations_50_0=ruleOperation_5();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operations",
                    	    	        		lv_operations_50_0, 
                    	    	        		"Operation_5", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel983); 

                            createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_8_5(), null); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:796:6: ( '#5+' ( (lv_name_53_0= RULE_ID ) ) '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:796:6: ( '#5+' ( (lv_name_53_0= RULE_ID ) ) '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:796:8: '#5+' ( (lv_name_53_0= RULE_ID ) ) '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ '}'
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleModel1001); 

                            createLeafNode(grammarAccess.getModelAccess().getNumberSignDigitFivePlusSignKeyword_1_9_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:800:1: ( (lv_name_53_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:801:1: (lv_name_53_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:801:1: (lv_name_53_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:802:3: lv_name_53_0= RULE_ID
                    {
                    lv_name_53_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel1018); 

                    			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_9_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_53_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel1033); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_9_2(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:828:1: ( (lv_errors_55_0= ruleError_5 ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==23) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:829:1: (lv_errors_55_0= ruleError_5 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:829:1: (lv_errors_55_0= ruleError_5 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:830:3: lv_errors_55_0= ruleError_5
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getErrorsError_5ParserRuleCall_1_9_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_5_in_ruleModel1054);
                    	    lv_errors_55_0=ruleError_5();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"errors",
                    	    	        		lv_errors_55_0, 
                    	    	        		"Error_5", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:852:3: ( (lv_operations_56_0= ruleOperation_5 ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==24) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:853:1: (lv_operations_56_0= ruleOperation_5 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:853:1: (lv_operations_56_0= ruleOperation_5 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:854:3: lv_operations_56_0= ruleOperation_5
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_5ParserRuleCall_1_9_4_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_5_in_ruleModel1076);
                    	    lv_operations_56_0=ruleOperation_5();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operations",
                    	    	        		lv_operations_56_0, 
                    	    	        		"Operation_5", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel1087); 

                            createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_9_5(), null); 
                        

                    }


                    }
                    break;

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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleError_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:888:1: entryRuleError_1 returns [EObject current=null] : iv_ruleError_1= ruleError_1 EOF ;
    public final EObject entryRuleError_1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_1 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:889:2: (iv_ruleError_1= ruleError_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:890:2: iv_ruleError_1= ruleError_1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getError_1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleError_1_in_entryRuleError_11125);
            iv_ruleError_1=ruleError_1();
            _fsp--;

             current =iv_ruleError_1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_11135); 

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
    // $ANTLR end entryRuleError_1


    // $ANTLR start ruleError_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:897:1: ruleError_1 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )* 'error' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleError_1() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:902:6: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )* 'error' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:903:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )* 'error' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:903:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )* 'error' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:903:2: ( (lv_annotations_0_0= ruleAnnotation ) )* 'error' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:903:2: ( (lv_annotations_0_0= ruleAnnotation ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==25) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:904:1: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:904:1: (lv_annotations_0_0= ruleAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:905:3: lv_annotations_0_0= ruleAnnotation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getError_1Access().getAnnotationsAnnotationParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleError_11181);
            	    lv_annotations_0_0=ruleAnnotation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getError_1Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"annotations",
            	    	        		lv_annotations_0_0, 
            	    	        		"Annotation", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            match(input,23,FollowSets000.FOLLOW_23_in_ruleError_11192); 

                    createLeafNode(grammarAccess.getError_1Access().getErrorKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:931:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:932:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:932:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:933:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleError_11209); 

            			createLeafNode(grammarAccess.getError_1Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getError_1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleError_1


    // $ANTLR start entryRuleOperation_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:963:1: entryRuleOperation_1 returns [EObject current=null] : iv_ruleOperation_1= ruleOperation_1 EOF ;
    public final EObject entryRuleOperation_1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_1 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:964:2: (iv_ruleOperation_1= ruleOperation_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:965:2: iv_ruleOperation_1= ruleOperation_1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperation_1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_1_in_entryRuleOperation_11250);
            iv_ruleOperation_1=ruleOperation_1();
            _fsp--;

             current =iv_ruleOperation_1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_11260); 

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
    // $ANTLR end entryRuleOperation_1


    // $ANTLR start ruleOperation_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:972:1: ruleOperation_1 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )* 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_1() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:977:6: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )* 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:978:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )* 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:978:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )* 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:978:2: ( (lv_annotations_0_0= ruleAnnotation ) )* 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:978:2: ( (lv_annotations_0_0= ruleAnnotation ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==25) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:979:1: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:979:1: (lv_annotations_0_0= ruleAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:980:3: lv_annotations_0_0= ruleAnnotation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getOperation_1Access().getAnnotationsAnnotationParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleOperation_11306);
            	    lv_annotations_0_0=ruleAnnotation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getOperation_1Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"annotations",
            	    	        		lv_annotations_0_0, 
            	    	        		"Annotation", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            match(input,24,FollowSets000.FOLLOW_24_in_ruleOperation_11317); 

                    createLeafNode(grammarAccess.getOperation_1Access().getOperationKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1006:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1007:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1007:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1008:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOperation_11334); 

            			createLeafNode(grammarAccess.getOperation_1Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperation_1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleOperation_1


    // $ANTLR start entryRuleError_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1038:1: entryRuleError_2 returns [EObject current=null] : iv_ruleError_2= ruleError_2 EOF ;
    public final EObject entryRuleError_2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1039:2: (iv_ruleError_2= ruleError_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1040:2: iv_ruleError_2= ruleError_2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getError_2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleError_2_in_entryRuleError_21375);
            iv_ruleError_2=ruleError_2();
            _fsp--;

             current =iv_ruleError_2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_21385); 

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
    // $ANTLR end entryRuleError_2


    // $ANTLR start ruleError_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1047:1: ruleError_2 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )+ 'error' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleError_2() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1052:6: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )+ 'error' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1053:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )+ 'error' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1053:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )+ 'error' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1053:2: ( (lv_annotations_0_0= ruleAnnotation ) )+ 'error' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1053:2: ( (lv_annotations_0_0= ruleAnnotation ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==25) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1054:1: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1054:1: (lv_annotations_0_0= ruleAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1055:3: lv_annotations_0_0= ruleAnnotation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getError_2Access().getAnnotationsAnnotationParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleError_21431);
            	    lv_annotations_0_0=ruleAnnotation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getError_2Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"annotations",
            	    	        		lv_annotations_0_0, 
            	    	        		"Annotation", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            match(input,23,FollowSets000.FOLLOW_23_in_ruleError_21442); 

                    createLeafNode(grammarAccess.getError_2Access().getErrorKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1081:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1082:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1082:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1083:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleError_21459); 

            			createLeafNode(grammarAccess.getError_2Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getError_2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleError_2


    // $ANTLR start entryRuleOperation_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1113:1: entryRuleOperation_2 returns [EObject current=null] : iv_ruleOperation_2= ruleOperation_2 EOF ;
    public final EObject entryRuleOperation_2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1114:2: (iv_ruleOperation_2= ruleOperation_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1115:2: iv_ruleOperation_2= ruleOperation_2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperation_2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_2_in_entryRuleOperation_21500);
            iv_ruleOperation_2=ruleOperation_2();
            _fsp--;

             current =iv_ruleOperation_2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_21510); 

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
    // $ANTLR end entryRuleOperation_2


    // $ANTLR start ruleOperation_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1122:1: ruleOperation_2 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )+ 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_2() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1127:6: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )+ 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1128:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )+ 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1128:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )+ 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1128:2: ( (lv_annotations_0_0= ruleAnnotation ) )+ 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1128:2: ( (lv_annotations_0_0= ruleAnnotation ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==25) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1129:1: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1129:1: (lv_annotations_0_0= ruleAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1130:3: lv_annotations_0_0= ruleAnnotation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getOperation_2Access().getAnnotationsAnnotationParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleOperation_21556);
            	    lv_annotations_0_0=ruleAnnotation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getOperation_2Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"annotations",
            	    	        		lv_annotations_0_0, 
            	    	        		"Annotation", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            match(input,24,FollowSets000.FOLLOW_24_in_ruleOperation_21567); 

                    createLeafNode(grammarAccess.getOperation_2Access().getOperationKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1156:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1157:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1157:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1158:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOperation_21584); 

            			createLeafNode(grammarAccess.getOperation_2Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperation_2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleOperation_2


    // $ANTLR start entryRuleError_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1188:1: entryRuleError_3 returns [EObject current=null] : iv_ruleError_3= ruleError_3 EOF ;
    public final EObject entryRuleError_3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_3 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1189:2: (iv_ruleError_3= ruleError_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1190:2: iv_ruleError_3= ruleError_3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getError_3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleError_3_in_entryRuleError_31625);
            iv_ruleError_3=ruleError_3();
            _fsp--;

             current =iv_ruleError_3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_31635); 

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
    // $ANTLR end entryRuleError_3


    // $ANTLR start ruleError_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1197:1: ruleError_3 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )? 'error' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleError_3() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1202:6: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )? 'error' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1203:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )? 'error' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1203:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )? 'error' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1203:2: ( (lv_annotations_0_0= ruleAnnotation ) )? 'error' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1203:2: ( (lv_annotations_0_0= ruleAnnotation ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==25) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1204:1: (lv_annotations_0_0= ruleAnnotation )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1204:1: (lv_annotations_0_0= ruleAnnotation )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1205:3: lv_annotations_0_0= ruleAnnotation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getError_3Access().getAnnotationsAnnotationParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleError_31681);
                    lv_annotations_0_0=ruleAnnotation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getError_3Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"annotations",
                    	        		lv_annotations_0_0, 
                    	        		"Annotation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleError_31692); 

                    createLeafNode(grammarAccess.getError_3Access().getErrorKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1231:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1232:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1232:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1233:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleError_31709); 

            			createLeafNode(grammarAccess.getError_3Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getError_3Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleError_3


    // $ANTLR start entryRuleOperation_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1263:1: entryRuleOperation_3 returns [EObject current=null] : iv_ruleOperation_3= ruleOperation_3 EOF ;
    public final EObject entryRuleOperation_3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_3 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1264:2: (iv_ruleOperation_3= ruleOperation_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1265:2: iv_ruleOperation_3= ruleOperation_3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperation_3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_3_in_entryRuleOperation_31750);
            iv_ruleOperation_3=ruleOperation_3();
            _fsp--;

             current =iv_ruleOperation_3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_31760); 

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
    // $ANTLR end entryRuleOperation_3


    // $ANTLR start ruleOperation_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1272:1: ruleOperation_3 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )? 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_3() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1277:6: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )? 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1278:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )? 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1278:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )? 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1278:2: ( (lv_annotations_0_0= ruleAnnotation ) )? 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1278:2: ( (lv_annotations_0_0= ruleAnnotation ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==25) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1279:1: (lv_annotations_0_0= ruleAnnotation )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1279:1: (lv_annotations_0_0= ruleAnnotation )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1280:3: lv_annotations_0_0= ruleAnnotation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperation_3Access().getAnnotationsAnnotationParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleOperation_31806);
                    lv_annotations_0_0=ruleAnnotation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperation_3Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"annotations",
                    	        		lv_annotations_0_0, 
                    	        		"Annotation", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,24,FollowSets000.FOLLOW_24_in_ruleOperation_31817); 

                    createLeafNode(grammarAccess.getOperation_3Access().getOperationKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1306:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1307:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1307:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1308:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOperation_31834); 

            			createLeafNode(grammarAccess.getOperation_3Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperation_3Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleOperation_3


    // $ANTLR start entryRuleError_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1338:1: entryRuleError_4 returns [EObject current=null] : iv_ruleError_4= ruleError_4 EOF ;
    public final EObject entryRuleError_4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_4 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1339:2: (iv_ruleError_4= ruleError_4 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1340:2: iv_ruleError_4= ruleError_4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getError_4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleError_4_in_entryRuleError_41875);
            iv_ruleError_4=ruleError_4();
            _fsp--;

             current =iv_ruleError_4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_41885); 

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
    // $ANTLR end entryRuleError_4


    // $ANTLR start ruleError_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1347:1: ruleError_4 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) ) 'error' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleError_4() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1352:6: ( ( ( (lv_annotations_0_0= ruleAnnotation ) ) 'error' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1353:1: ( ( (lv_annotations_0_0= ruleAnnotation ) ) 'error' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1353:1: ( ( (lv_annotations_0_0= ruleAnnotation ) ) 'error' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1353:2: ( (lv_annotations_0_0= ruleAnnotation ) ) 'error' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1353:2: ( (lv_annotations_0_0= ruleAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1354:1: (lv_annotations_0_0= ruleAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1354:1: (lv_annotations_0_0= ruleAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1355:3: lv_annotations_0_0= ruleAnnotation
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getError_4Access().getAnnotationsAnnotationParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleError_41931);
            lv_annotations_0_0=ruleAnnotation();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getError_4Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"annotations",
            	        		lv_annotations_0_0, 
            	        		"Annotation", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleError_41941); 

                    createLeafNode(grammarAccess.getError_4Access().getErrorKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1381:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1382:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1382:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1383:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleError_41958); 

            			createLeafNode(grammarAccess.getError_4Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getError_4Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleError_4


    // $ANTLR start entryRuleOperation_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1413:1: entryRuleOperation_4 returns [EObject current=null] : iv_ruleOperation_4= ruleOperation_4 EOF ;
    public final EObject entryRuleOperation_4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_4 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1414:2: (iv_ruleOperation_4= ruleOperation_4 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1415:2: iv_ruleOperation_4= ruleOperation_4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperation_4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_4_in_entryRuleOperation_41999);
            iv_ruleOperation_4=ruleOperation_4();
            _fsp--;

             current =iv_ruleOperation_4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_42009); 

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
    // $ANTLR end entryRuleOperation_4


    // $ANTLR start ruleOperation_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1422:1: ruleOperation_4 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) ) 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_4() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1427:6: ( ( ( (lv_annotations_0_0= ruleAnnotation ) ) 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1428:1: ( ( (lv_annotations_0_0= ruleAnnotation ) ) 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1428:1: ( ( (lv_annotations_0_0= ruleAnnotation ) ) 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1428:2: ( (lv_annotations_0_0= ruleAnnotation ) ) 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1428:2: ( (lv_annotations_0_0= ruleAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1429:1: (lv_annotations_0_0= ruleAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1429:1: (lv_annotations_0_0= ruleAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1430:3: lv_annotations_0_0= ruleAnnotation
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getOperation_4Access().getAnnotationsAnnotationParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleOperation_42055);
            lv_annotations_0_0=ruleAnnotation();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperation_4Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"annotations",
            	        		lv_annotations_0_0, 
            	        		"Annotation", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,24,FollowSets000.FOLLOW_24_in_ruleOperation_42065); 

                    createLeafNode(grammarAccess.getOperation_4Access().getOperationKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1456:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1457:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1457:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1458:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOperation_42082); 

            			createLeafNode(grammarAccess.getOperation_4Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperation_4Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleOperation_4


    // $ANTLR start entryRuleError_5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1488:1: entryRuleError_5 returns [EObject current=null] : iv_ruleError_5= ruleError_5 EOF ;
    public final EObject entryRuleError_5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_5 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1489:2: (iv_ruleError_5= ruleError_5 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1490:2: iv_ruleError_5= ruleError_5 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getError_5Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleError_5_in_entryRuleError_52123);
            iv_ruleError_5=ruleError_5();
            _fsp--;

             current =iv_ruleError_5; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_52133); 

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
    // $ANTLR end entryRuleError_5


    // $ANTLR start ruleError_5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1497:1: ruleError_5 returns [EObject current=null] : ( 'error' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleError_5() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1502:6: ( ( 'error' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1503:1: ( 'error' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1503:1: ( 'error' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1503:3: 'error' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,23,FollowSets000.FOLLOW_23_in_ruleError_52168); 

                    createLeafNode(grammarAccess.getError_5Access().getErrorKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1507:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1508:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1508:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1509:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleError_52185); 

            			createLeafNode(grammarAccess.getError_5Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getError_5Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleError_5


    // $ANTLR start entryRuleOperation_5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1539:1: entryRuleOperation_5 returns [EObject current=null] : iv_ruleOperation_5= ruleOperation_5 EOF ;
    public final EObject entryRuleOperation_5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_5 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1540:2: (iv_ruleOperation_5= ruleOperation_5 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1541:2: iv_ruleOperation_5= ruleOperation_5 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperation_5Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_5_in_entryRuleOperation_52226);
            iv_ruleOperation_5=ruleOperation_5();
            _fsp--;

             current =iv_ruleOperation_5; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_52236); 

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
    // $ANTLR end entryRuleOperation_5


    // $ANTLR start ruleOperation_5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1548:1: ruleOperation_5 returns [EObject current=null] : ( 'operation' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_5() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1553:6: ( ( 'operation' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1554:1: ( 'operation' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1554:1: ( 'operation' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1554:3: 'operation' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,24,FollowSets000.FOLLOW_24_in_ruleOperation_52271); 

                    createLeafNode(grammarAccess.getOperation_5Access().getOperationKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1558:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1559:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1559:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1560:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOperation_52288); 

            			createLeafNode(grammarAccess.getOperation_5Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperation_5Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleOperation_5


    // $ANTLR start entryRuleAnnotation
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1590:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1591:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1592:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAnnotationRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_entryRuleAnnotation2329);
            iv_ruleAnnotation=ruleAnnotation();
            _fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnnotation2339); 

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
    // $ANTLR end entryRuleAnnotation


    // $ANTLR start ruleAnnotation
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1599:1: ruleAnnotation returns [EObject current=null] : ( '@uuid' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1604:6: ( ( '@uuid' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1605:1: ( '@uuid' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1605:1: ( '@uuid' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1605:3: '@uuid' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,25,FollowSets000.FOLLOW_25_in_ruleAnnotation2374); 

                    createLeafNode(grammarAccess.getAnnotationAccess().getUuidKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1609:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1610:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1610:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1611:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAnnotation2391); 

            			createLeafNode(grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAnnotationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleAnnotation


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA1_eotS =
        "\5\uffff";
    static final String DFA1_eofS =
        "\5\uffff";
    static final String DFA1_minS =
        "\1\15\1\4\2\uffff\1\27";
    static final String DFA1_maxS =
        "\1\31\1\4\2\uffff\1\31";
    static final String DFA1_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA1_specialS =
        "\5\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\11\uffff\1\3\1\2\1\1",
            "\1\4",
            "",
            "",
            "\1\3\1\2\1\1"
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "()* loopback of 111:1: ( (lv_errors_3_0= ruleError_1 ) )*";
        }
    }
    static final String DFA3_eotS =
        "\5\uffff";
    static final String DFA3_eofS =
        "\5\uffff";
    static final String DFA3_minS =
        "\1\27\1\4\2\uffff\1\27";
    static final String DFA3_maxS =
        "\1\31\1\4\2\uffff\1\31";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA3_specialS =
        "\5\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\3\1\2\1\1",
            "\1\4",
            "",
            "",
            "\1\3\1\2\1\1"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()+ loopback of 172:1: ( (lv_errors_8_0= ruleError_1 ) )+";
        }
    }
    static final String DFA5_eotS =
        "\5\uffff";
    static final String DFA5_eofS =
        "\5\uffff";
    static final String DFA5_minS =
        "\1\15\1\4\1\uffff\1\27\1\uffff";
    static final String DFA5_maxS =
        "\1\31\1\4\1\uffff\1\31\1\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA5_specialS =
        "\5\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\13\uffff\1\1",
            "\1\3",
            "",
            "\1\4\1\2\1\1",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()* loopback of 233:1: ( (lv_errors_13_0= ruleError_2 ) )*";
        }
    }
    static final String DFA7_eotS =
        "\5\uffff";
    static final String DFA7_eofS =
        "\5\uffff";
    static final String DFA7_minS =
        "\1\31\1\4\1\27\2\uffff";
    static final String DFA7_maxS =
        "\1\31\1\4\1\31\2\uffff";
    static final String DFA7_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA7_specialS =
        "\5\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1",
            "\1\2",
            "\1\4\1\3\1\1",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "()+ loopback of 318:1: ( (lv_errors_19_0= ruleError_2 ) )+";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel131 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel141 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_ruleError_1_in_ruleModel162 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_ruleOperation_1_in_ruleModel184 = new BitSet(new long[]{0x0000000003002000L});
        public static final BitSet FOLLOW_13_in_ruleModel195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel213 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel223 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_ruleError_1_in_ruleModel244 = new BitSet(new long[]{0x0000000003800000L});
        public static final BitSet FOLLOW_ruleOperation_1_in_ruleModel266 = new BitSet(new long[]{0x0000000003002000L});
        public static final BitSet FOLLOW_13_in_ruleModel277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel295 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel305 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_ruleError_2_in_ruleModel326 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_ruleOperation_2_in_ruleModel348 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_13_in_ruleModel359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel377 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel394 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel409 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleError_2_in_ruleModel430 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleOperation_2_in_ruleModel452 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_13_in_ruleModel463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel481 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel498 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel513 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_ruleError_3_in_ruleModel534 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_ruleOperation_3_in_ruleModel556 = new BitSet(new long[]{0x0000000003002000L});
        public static final BitSet FOLLOW_13_in_ruleModel567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleModel585 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel602 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel617 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_ruleError_3_in_ruleModel638 = new BitSet(new long[]{0x0000000003800000L});
        public static final BitSet FOLLOW_ruleOperation_3_in_ruleModel660 = new BitSet(new long[]{0x0000000003002000L});
        public static final BitSet FOLLOW_13_in_ruleModel671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleModel689 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel706 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel721 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_ruleError_4_in_ruleModel742 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_ruleOperation_4_in_ruleModel764 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_13_in_ruleModel775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleModel793 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel810 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel825 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleError_4_in_ruleModel846 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleOperation_4_in_ruleModel868 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_13_in_ruleModel879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleModel897 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel914 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel929 = new BitSet(new long[]{0x0000000001802000L});
        public static final BitSet FOLLOW_ruleError_5_in_ruleModel950 = new BitSet(new long[]{0x0000000001802000L});
        public static final BitSet FOLLOW_ruleOperation_5_in_ruleModel972 = new BitSet(new long[]{0x0000000001002000L});
        public static final BitSet FOLLOW_13_in_ruleModel983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleModel1001 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel1018 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel1033 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_ruleError_5_in_ruleModel1054 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_ruleOperation_5_in_ruleModel1076 = new BitSet(new long[]{0x0000000001002000L});
        public static final BitSet FOLLOW_13_in_ruleModel1087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_1_in_entryRuleError_11125 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_11135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleError_11181 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_23_in_ruleError_11192 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleError_11209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_1_in_entryRuleOperation_11250 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_11260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleOperation_11306 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_24_in_ruleOperation_11317 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOperation_11334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_2_in_entryRuleError_21375 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_21385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleError_21431 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_23_in_ruleError_21442 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleError_21459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_2_in_entryRuleOperation_21500 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_21510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleOperation_21556 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_24_in_ruleOperation_21567 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOperation_21584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_3_in_entryRuleError_31625 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_31635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleError_31681 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleError_31692 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleError_31709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_3_in_entryRuleOperation_31750 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_31760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleOperation_31806 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleOperation_31817 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOperation_31834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_4_in_entryRuleError_41875 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_41885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleError_41931 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleError_41941 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleError_41958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_4_in_entryRuleOperation_41999 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_42009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleOperation_42055 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleOperation_42065 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOperation_42082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_5_in_entryRuleError_52123 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_52133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleError_52168 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleError_52185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_5_in_entryRuleOperation_52226 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_52236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleOperation_52271 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOperation_52288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_entryRuleAnnotation2329 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnnotation2339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleAnnotation2374 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotation2391 = new BitSet(new long[]{0x0000000000000002L});
    }


}
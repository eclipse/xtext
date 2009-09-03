package org.eclipse.xtext.linking.parser.antlr.internal; 

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
import org.eclipse.xtext.linking.services.Bug287988TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug287988TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'actions'", "'simple'", "'rulecall'", "'rulecall2'", "'rulecall3'", "'inlinedActions'", "'ref'", "';'", "'attribute'", "'master'", "'call'", "'me'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug287988TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g"; }


     
     	private Bug287988TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug287988TestLanguageParser(TokenStream input, IAstFactory factory, Bug287988TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel83); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_attributes_1_0 = null;

        EObject lv_attributes_3_0 = null;

        EObject lv_attributes_5_0 = null;

        EObject lv_attributes_7_0 = null;

        EObject lv_attributes_9_0 = null;

        EObject lv_attributes_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:85:6: ( ( ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:86:1: ( ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:86:1: ( ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt7=1;
                }
                break;
            case 12:
                {
                alt7=2;
                }
                break;
            case 13:
                {
                alt7=3;
                }
                break;
            case 14:
                {
                alt7=4;
                }
                break;
            case 15:
                {
                alt7=5;
                }
                break;
            case 16:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("86:1: ( ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:86:2: ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:86:2: ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:86:3: 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )*
                    {
                    match(input,11,FOLLOW_11_in_ruleModel118); 

                            createLeafNode(grammarAccess.getModelAccess().getActionsKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:90:1: ( (lv_attributes_1_0= ruleBaseAttribute ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=19 && LA1_0<=20)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:91:1: (lv_attributes_1_0= ruleBaseAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:91:1: (lv_attributes_1_0= ruleBaseAttribute )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:92:3: lv_attributes_1_0= ruleBaseAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesBaseAttributeParserRuleCall_0_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBaseAttribute_in_ruleModel139);
                    	    lv_attributes_1_0=ruleBaseAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_1_0, 
                    	    	        		"BaseAttribute", 
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


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:115:6: ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:115:6: ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:115:7: 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )*
                    {
                    match(input,12,FOLLOW_12_in_ruleModel157); 

                            createLeafNode(grammarAccess.getModelAccess().getSimpleKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:119:1: ( (lv_attributes_3_0= ruleSimpleAttribute ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID||LA2_0==17) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:120:1: (lv_attributes_3_0= ruleSimpleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:120:1: (lv_attributes_3_0= ruleSimpleAttribute )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:121:3: lv_attributes_3_0= ruleSimpleAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesSimpleAttributeParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSimpleAttribute_in_ruleModel178);
                    	    lv_attributes_3_0=ruleSimpleAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_3_0, 
                    	    	        		"SimpleAttribute", 
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


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:144:6: ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:144:6: ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:144:7: 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )*
                    {
                    match(input,13,FOLLOW_13_in_ruleModel196); 

                            createLeafNode(grammarAccess.getModelAccess().getRulecallKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:148:1: ( (lv_attributes_5_0= ruleRuleCallAttribute ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID||LA3_0==17) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:149:1: (lv_attributes_5_0= ruleRuleCallAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:149:1: (lv_attributes_5_0= ruleRuleCallAttribute )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:150:3: lv_attributes_5_0= ruleRuleCallAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesRuleCallAttributeParserRuleCall_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleRuleCallAttribute_in_ruleModel217);
                    	    lv_attributes_5_0=ruleRuleCallAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_5_0, 
                    	    	        		"RuleCallAttribute", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:173:6: ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:173:6: ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:173:7: 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )*
                    {
                    match(input,14,FOLLOW_14_in_ruleModel235); 

                            createLeafNode(grammarAccess.getModelAccess().getRulecall2Keyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:177:1: ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:178:1: (lv_attributes_7_0= ruleRuleCallAttribute2 )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:178:1: (lv_attributes_7_0= ruleRuleCallAttribute2 )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:179:3: lv_attributes_7_0= ruleRuleCallAttribute2
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesRuleCallAttribute2ParserRuleCall_3_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleRuleCallAttribute2_in_ruleModel256);
                    	    lv_attributes_7_0=ruleRuleCallAttribute2();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_7_0, 
                    	    	        		"RuleCallAttribute2", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:202:6: ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:202:6: ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:202:7: 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )*
                    {
                    match(input,15,FOLLOW_15_in_ruleModel274); 

                            createLeafNode(grammarAccess.getModelAccess().getRulecall3Keyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:206:1: ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==21) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:207:1: (lv_attributes_9_0= ruleRuleCallAttribute3 )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:207:1: (lv_attributes_9_0= ruleRuleCallAttribute3 )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:208:3: lv_attributes_9_0= ruleRuleCallAttribute3
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesRuleCallAttribute3ParserRuleCall_4_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleRuleCallAttribute3_in_ruleModel295);
                    	    lv_attributes_9_0=ruleRuleCallAttribute3();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_9_0, 
                    	    	        		"RuleCallAttribute3", 
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


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:231:6: ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:231:6: ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:231:7: 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )*
                    {
                    match(input,16,FOLLOW_16_in_ruleModel313); 

                            createLeafNode(grammarAccess.getModelAccess().getInlinedActionsKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:235:1: ( (lv_attributes_11_0= ruleActionAttribute ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=19 && LA6_0<=20)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:236:1: (lv_attributes_11_0= ruleActionAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:236:1: (lv_attributes_11_0= ruleActionAttribute )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:237:3: lv_attributes_11_0= ruleActionAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesActionAttributeParserRuleCall_5_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleActionAttribute_in_ruleModel334);
                    	    lv_attributes_11_0=ruleActionAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_11_0, 
                    	    	        		"ActionAttribute", 
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


    // $ANTLR start entryRuleBaseAttribute
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:266:1: entryRuleBaseAttribute returns [EObject current=null] : iv_ruleBaseAttribute= ruleBaseAttribute EOF ;
    public final EObject entryRuleBaseAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseAttribute = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:266:55: (iv_ruleBaseAttribute= ruleBaseAttribute EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:267:2: iv_ruleBaseAttribute= ruleBaseAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBaseAttributeRule(), currentNode); 
            pushFollow(FOLLOW_ruleBaseAttribute_in_entryRuleBaseAttribute369);
            iv_ruleBaseAttribute=ruleBaseAttribute();
            _fsp--;

             current =iv_ruleBaseAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBaseAttribute379); 

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
    // $ANTLR end entryRuleBaseAttribute


    // $ANTLR start ruleBaseAttribute
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:274:1: ruleBaseAttribute returns [EObject current=null] : ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleBaseAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_type_4_0=null;
        Token lv_name_5_0=null;
        EObject this_Attribute_0 = null;

        EObject this_Master_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:279:6: ( ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:280:1: ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:280:1: ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:280:2: (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:280:2: (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            else if ( (LA8_0==20) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("280:2: (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:281:5: this_Attribute_0= ruleAttribute
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBaseAttributeAccess().getAttributeParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAttribute_in_ruleBaseAttribute427);
                    this_Attribute_0=ruleAttribute();
                    _fsp--;

                     
                            current = this_Attribute_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:291:5: this_Master_1= ruleMaster
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBaseAttributeAccess().getMasterParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMaster_in_ruleBaseAttribute454);
                    this_Master_1=ruleMaster();
                    _fsp--;

                     
                            current = this_Master_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:299:2: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("299:2: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:299:3: ( 'ref' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:299:3: ( 'ref' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:299:4: 'ref' ( ( RULE_ID ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleBaseAttribute465); 

                            createLeafNode(grammarAccess.getBaseAttributeAccess().getRefKeyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:303:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:304:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:304:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:305:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getBaseAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBaseAttribute483); 

                    		createLeafNode(grammarAccess.getBaseAttributeAccess().getTypeRefBaseAttributeCrossReference_1_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:318:6: ( (lv_type_4_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:318:6: ( (lv_type_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:319:1: (lv_type_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:319:1: (lv_type_4_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:320:3: lv_type_4_0= RULE_ID
                    {
                    lv_type_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBaseAttribute507); 

                    			createLeafNode(grammarAccess.getBaseAttributeAccess().getTypeIDTerminalRuleCall_1_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBaseAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_4_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:342:3: ( (lv_name_5_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:343:1: (lv_name_5_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:343:1: (lv_name_5_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:344:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBaseAttribute530); 

            			createLeafNode(grammarAccess.getBaseAttributeAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBaseAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_5_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleBaseAttribute544); 

                    createLeafNode(grammarAccess.getBaseAttributeAccess().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleBaseAttribute


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:377:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:377:51: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:378:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute577);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute587); 

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
    // $ANTLR end entryRuleAttribute


    // $ANTLR start ruleAttribute
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:385:1: ruleAttribute returns [EObject current=null] : ( () 'attribute' ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:390:6: ( ( () 'attribute' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:391:1: ( () 'attribute' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:391:1: ( () 'attribute' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:391:2: () 'attribute'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:391:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:392:5: 
            {
             
                    temp=factory.create(grammarAccess.getAttributeAccess().getAttributeAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getAttributeAccess().getAttributeAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,19,FOLLOW_19_in_ruleAttribute630); 

                    createLeafNode(grammarAccess.getAttributeAccess().getAttributeKeyword_1(), null); 
                

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
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRuleMaster
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:413:1: entryRuleMaster returns [EObject current=null] : iv_ruleMaster= ruleMaster EOF ;
    public final EObject entryRuleMaster() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaster = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:413:48: (iv_ruleMaster= ruleMaster EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:414:2: iv_ruleMaster= ruleMaster EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMasterRule(), currentNode); 
            pushFollow(FOLLOW_ruleMaster_in_entryRuleMaster663);
            iv_ruleMaster=ruleMaster();
            _fsp--;

             current =iv_ruleMaster; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMaster673); 

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
    // $ANTLR end entryRuleMaster


    // $ANTLR start ruleMaster
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:421:1: ruleMaster returns [EObject current=null] : ( () 'master' ) ;
    public final EObject ruleMaster() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:426:6: ( ( () 'master' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:427:1: ( () 'master' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:427:1: ( () 'master' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:427:2: () 'master'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:427:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:428:5: 
            {
             
                    temp=factory.create(grammarAccess.getMasterAccess().getMasterAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getMasterAccess().getMasterAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,20,FOLLOW_20_in_ruleMaster716); 

                    createLeafNode(grammarAccess.getMasterAccess().getMasterKeyword_1(), null); 
                

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
    // $ANTLR end ruleMaster


    // $ANTLR start entryRuleActionAttribute
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:449:1: entryRuleActionAttribute returns [EObject current=null] : iv_ruleActionAttribute= ruleActionAttribute EOF ;
    public final EObject entryRuleActionAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionAttribute = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:449:57: (iv_ruleActionAttribute= ruleActionAttribute EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:450:2: iv_ruleActionAttribute= ruleActionAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionAttributeRule(), currentNode); 
            pushFollow(FOLLOW_ruleActionAttribute_in_entryRuleActionAttribute749);
            iv_ruleActionAttribute=ruleActionAttribute();
            _fsp--;

             current =iv_ruleActionAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActionAttribute759); 

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
    // $ANTLR end entryRuleActionAttribute


    // $ANTLR start ruleActionAttribute
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:457:1: ruleActionAttribute returns [EObject current=null] : ( ( ( () 'attribute' ) | ( () 'master' ) ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleActionAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_type_6_0=null;
        Token lv_name_7_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:462:6: ( ( ( ( () 'attribute' ) | ( () 'master' ) ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:463:1: ( ( ( () 'attribute' ) | ( () 'master' ) ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:463:1: ( ( ( () 'attribute' ) | ( () 'master' ) ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:463:2: ( ( () 'attribute' ) | ( () 'master' ) ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:463:2: ( ( () 'attribute' ) | ( () 'master' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            else if ( (LA10_0==20) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("463:2: ( ( () 'attribute' ) | ( () 'master' ) )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:463:3: ( () 'attribute' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:463:3: ( () 'attribute' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:463:4: () 'attribute'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:463:4: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:464:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getActionAttributeAccess().getAttributeAction_0_0_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getActionAttributeAccess().getAttributeAction_0_0_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,19,FOLLOW_19_in_ruleActionAttribute804); 

                            createLeafNode(grammarAccess.getActionAttributeAccess().getAttributeKeyword_0_0_1(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:479:6: ( () 'master' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:479:6: ( () 'master' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:479:7: () 'master'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:479:7: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:480:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getActionAttributeAccess().getMasterAction_0_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getActionAttributeAccess().getMasterAction_0_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,20,FOLLOW_20_in_ruleActionAttribute830); 

                            createLeafNode(grammarAccess.getActionAttributeAccess().getMasterKeyword_0_1_1(), null); 
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:494:3: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_ID) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("494:3: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:494:4: ( 'ref' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:494:4: ( 'ref' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:494:5: 'ref' ( ( RULE_ID ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleActionAttribute843); 

                            createLeafNode(grammarAccess.getActionAttributeAccess().getRefKeyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:498:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:499:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:499:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:500:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getActionAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActionAttribute861); 

                    		createLeafNode(grammarAccess.getActionAttributeAccess().getTypeRefBaseAttributeCrossReference_1_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:513:6: ( (lv_type_6_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:513:6: ( (lv_type_6_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:514:1: (lv_type_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:514:1: (lv_type_6_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:515:3: lv_type_6_0= RULE_ID
                    {
                    lv_type_6_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActionAttribute885); 

                    			createLeafNode(grammarAccess.getActionAttributeAccess().getTypeIDTerminalRuleCall_1_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getActionAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_6_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:537:3: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:538:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:538:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:539:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActionAttribute908); 

            			createLeafNode(grammarAccess.getActionAttributeAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getActionAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_7_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleActionAttribute922); 

                    createLeafNode(grammarAccess.getActionAttributeAccess().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleActionAttribute


    // $ANTLR start entryRuleSimpleAttribute
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:572:1: entryRuleSimpleAttribute returns [EObject current=null] : iv_ruleSimpleAttribute= ruleSimpleAttribute EOF ;
    public final EObject entryRuleSimpleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAttribute = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:572:57: (iv_ruleSimpleAttribute= ruleSimpleAttribute EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:573:2: iv_ruleSimpleAttribute= ruleSimpleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleAttributeRule(), currentNode); 
            pushFollow(FOLLOW_ruleSimpleAttribute_in_entryRuleSimpleAttribute955);
            iv_ruleSimpleAttribute=ruleSimpleAttribute();
            _fsp--;

             current =iv_ruleSimpleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleAttribute965); 

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
    // $ANTLR end entryRuleSimpleAttribute


    // $ANTLR start ruleSimpleAttribute
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:580:1: ruleSimpleAttribute returns [EObject current=null] : ( ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleSimpleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_type_2_0=null;
        Token lv_name_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:585:6: ( ( ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:586:1: ( ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:586:1: ( ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:586:2: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:586:2: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("586:2: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:586:3: ( 'ref' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:586:3: ( 'ref' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:586:4: 'ref' ( ( RULE_ID ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleSimpleAttribute1001); 

                            createLeafNode(grammarAccess.getSimpleAttributeAccess().getRefKeyword_0_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:590:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:591:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:591:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:592:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSimpleAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleAttribute1019); 

                    		createLeafNode(grammarAccess.getSimpleAttributeAccess().getTypeRefBaseAttributeCrossReference_0_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:605:6: ( (lv_type_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:605:6: ( (lv_type_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:606:1: (lv_type_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:606:1: (lv_type_2_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:607:3: lv_type_2_0= RULE_ID
                    {
                    lv_type_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleAttribute1043); 

                    			createLeafNode(grammarAccess.getSimpleAttributeAccess().getTypeIDTerminalRuleCall_0_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSimpleAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:629:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:630:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:630:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:631:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleAttribute1066); 

            			createLeafNode(grammarAccess.getSimpleAttributeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_3_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleSimpleAttribute1080); 

                    createLeafNode(grammarAccess.getSimpleAttributeAccess().getSemicolonKeyword_2(), null); 
                

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
    // $ANTLR end ruleSimpleAttribute


    // $ANTLR start entryRuleRuleCallAttribute
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:664:1: entryRuleRuleCallAttribute returns [EObject current=null] : iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF ;
    public final EObject entryRuleRuleCallAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallAttribute = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:664:59: (iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:665:2: iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallAttributeRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCallAttribute_in_entryRuleRuleCallAttribute1113);
            iv_ruleRuleCallAttribute=ruleRuleCallAttribute();
            _fsp--;

             current =iv_ruleRuleCallAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCallAttribute1123); 

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
    // $ANTLR end entryRuleRuleCallAttribute


    // $ANTLR start ruleRuleCallAttribute
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:672:1: ruleRuleCallAttribute returns [EObject current=null] : (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleRuleCallAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject this_CallMe_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:677:6: ( (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:678:1: (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:678:1: (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:679:5: this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRuleCallAttributeAccess().getCallMeParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleCallMe_in_ruleRuleCallAttribute1170);
            this_CallMe_0=ruleCallMe();
            _fsp--;

             
                    current = this_CallMe_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:687:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:688:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:688:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:689:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCallAttribute1186); 

            			createLeafNode(grammarAccess.getRuleCallAttributeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRuleCallAttributeRule().getType().getClassifier());
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

            match(input,18,FOLLOW_18_in_ruleRuleCallAttribute1200); 

                    createLeafNode(grammarAccess.getRuleCallAttributeAccess().getSemicolonKeyword_2(), null); 
                

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
    // $ANTLR end ruleRuleCallAttribute


    // $ANTLR start entryRuleCallMe
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:722:1: entryRuleCallMe returns [EObject current=null] : iv_ruleCallMe= ruleCallMe EOF ;
    public final EObject entryRuleCallMe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:722:48: (iv_ruleCallMe= ruleCallMe EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:723:2: iv_ruleCallMe= ruleCallMe EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallMeRule(), currentNode); 
            pushFollow(FOLLOW_ruleCallMe_in_entryRuleCallMe1233);
            iv_ruleCallMe=ruleCallMe();
            _fsp--;

             current =iv_ruleCallMe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallMe1243); 

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
    // $ANTLR end entryRuleCallMe


    // $ANTLR start ruleCallMe
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:730:1: ruleCallMe returns [EObject current=null] : ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ;
    public final EObject ruleCallMe() throws RecognitionException {
        EObject current = null;

        Token lv_type_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:735:6: ( ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:736:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:736:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("736:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:736:2: ( 'ref' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:736:2: ( 'ref' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:736:3: 'ref' ( ( RULE_ID ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleCallMe1278); 

                            createLeafNode(grammarAccess.getCallMeAccess().getRefKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:740:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:741:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:741:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:742:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getCallMeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCallMe1296); 

                    		createLeafNode(grammarAccess.getCallMeAccess().getTypeRefBaseAttributeCrossReference_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:755:6: ( (lv_type_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:755:6: ( (lv_type_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:756:1: (lv_type_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:756:1: (lv_type_2_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:757:3: lv_type_2_0= RULE_ID
                    {
                    lv_type_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCallMe1320); 

                    			createLeafNode(grammarAccess.getCallMeAccess().getTypeIDTerminalRuleCall_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCallMeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // $ANTLR end ruleCallMe


    // $ANTLR start entryRuleRuleCallAttribute2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:786:1: entryRuleRuleCallAttribute2 returns [EObject current=null] : iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF ;
    public final EObject entryRuleRuleCallAttribute2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallAttribute2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:786:60: (iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:787:2: iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallAttribute2Rule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCallAttribute2_in_entryRuleRuleCallAttribute21358);
            iv_ruleRuleCallAttribute2=ruleRuleCallAttribute2();
            _fsp--;

             current =iv_ruleRuleCallAttribute2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCallAttribute21368); 

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
    // $ANTLR end entryRuleRuleCallAttribute2


    // $ANTLR start ruleRuleCallAttribute2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:794:1: ruleRuleCallAttribute2 returns [EObject current=null] : (this_CallMe2_0= ruleCallMe2 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' ) ;
    public final EObject ruleRuleCallAttribute2() throws RecognitionException {
        EObject current = null;

        Token lv_type_3_0=null;
        EObject this_CallMe2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:799:6: ( (this_CallMe2_0= ruleCallMe2 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:800:1: (this_CallMe2_0= ruleCallMe2 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:800:1: (this_CallMe2_0= ruleCallMe2 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:801:5: this_CallMe2_0= ruleCallMe2 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRuleCallAttribute2Access().getCallMe2ParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleCallMe2_in_ruleRuleCallAttribute21415);
            this_CallMe2_0=ruleCallMe2();
            _fsp--;

             
                    current = this_CallMe2_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:809:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==17) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("809:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:809:2: ( 'ref' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:809:2: ( 'ref' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:809:3: 'ref' ( ( RULE_ID ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleRuleCallAttribute21425); 

                            createLeafNode(grammarAccess.getRuleCallAttribute2Access().getRefKeyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:813:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:814:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:814:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:815:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleCallAttribute2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCallAttribute21443); 

                    		createLeafNode(grammarAccess.getRuleCallAttribute2Access().getTypeRefBaseAttributeCrossReference_1_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:828:6: ( (lv_type_3_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:828:6: ( (lv_type_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:829:1: (lv_type_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:829:1: (lv_type_3_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:830:3: lv_type_3_0= RULE_ID
                    {
                    lv_type_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCallAttribute21467); 

                    			createLeafNode(grammarAccess.getRuleCallAttribute2Access().getTypeIDTerminalRuleCall_1_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleCallAttribute2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleRuleCallAttribute21482); 

                    createLeafNode(grammarAccess.getRuleCallAttribute2Access().getSemicolonKeyword_2(), null); 
                

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
    // $ANTLR end ruleRuleCallAttribute2


    // $ANTLR start entryRuleCallMe2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:863:1: entryRuleCallMe2 returns [EObject current=null] : iv_ruleCallMe2= ruleCallMe2 EOF ;
    public final EObject entryRuleCallMe2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:863:49: (iv_ruleCallMe2= ruleCallMe2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:864:2: iv_ruleCallMe2= ruleCallMe2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallMe2Rule(), currentNode); 
            pushFollow(FOLLOW_ruleCallMe2_in_entryRuleCallMe21515);
            iv_ruleCallMe2=ruleCallMe2();
            _fsp--;

             current =iv_ruleCallMe2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallMe21525); 

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
    // $ANTLR end entryRuleCallMe2


    // $ANTLR start ruleCallMe2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:871:1: ruleCallMe2 returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleCallMe2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:876:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:877:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:877:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:878:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:878:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:879:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCallMe21566); 

            			createLeafNode(grammarAccess.getCallMe2Access().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCallMe2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleCallMe2


    // $ANTLR start entryRuleRuleCallAttribute3
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:908:1: entryRuleRuleCallAttribute3 returns [EObject current=null] : iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF ;
    public final EObject entryRuleRuleCallAttribute3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallAttribute3 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:908:60: (iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:909:2: iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallAttribute3Rule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCallAttribute3_in_entryRuleRuleCallAttribute31603);
            iv_ruleRuleCallAttribute3=ruleRuleCallAttribute3();
            _fsp--;

             current =iv_ruleRuleCallAttribute3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCallAttribute31613); 

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
    // $ANTLR end entryRuleRuleCallAttribute3


    // $ANTLR start ruleRuleCallAttribute3
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:916:1: ruleRuleCallAttribute3 returns [EObject current=null] : (this_CallMe3_0= ruleCallMe3 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' ) ;
    public final EObject ruleRuleCallAttribute3() throws RecognitionException {
        EObject current = null;

        Token lv_type_3_0=null;
        EObject this_CallMe3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:921:6: ( (this_CallMe3_0= ruleCallMe3 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:922:1: (this_CallMe3_0= ruleCallMe3 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:922:1: (this_CallMe3_0= ruleCallMe3 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:923:5: this_CallMe3_0= ruleCallMe3 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRuleCallAttribute3Access().getCallMe3ParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleCallMe3_in_ruleRuleCallAttribute31660);
            this_CallMe3_0=ruleCallMe3();
            _fsp--;

             
                    current = this_CallMe3_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:931:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==17) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ID) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("931:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:931:2: ( 'ref' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:931:2: ( 'ref' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:931:3: 'ref' ( ( RULE_ID ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleRuleCallAttribute31670); 

                            createLeafNode(grammarAccess.getRuleCallAttribute3Access().getRefKeyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:935:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:936:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:936:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:937:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleCallAttribute3Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCallAttribute31688); 

                    		createLeafNode(grammarAccess.getRuleCallAttribute3Access().getTypeRefBaseAttributeCrossReference_1_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:950:6: ( (lv_type_3_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:950:6: ( (lv_type_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:951:1: (lv_type_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:951:1: (lv_type_3_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:952:3: lv_type_3_0= RULE_ID
                    {
                    lv_type_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCallAttribute31712); 

                    			createLeafNode(grammarAccess.getRuleCallAttribute3Access().getTypeIDTerminalRuleCall_1_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleCallAttribute3Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleRuleCallAttribute31727); 

                    createLeafNode(grammarAccess.getRuleCallAttribute3Access().getSemicolonKeyword_2(), null); 
                

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
    // $ANTLR end ruleRuleCallAttribute3


    // $ANTLR start entryRuleCallMe3
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:985:1: entryRuleCallMe3 returns [EObject current=null] : iv_ruleCallMe3= ruleCallMe3 EOF ;
    public final EObject entryRuleCallMe3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe3 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:985:49: (iv_ruleCallMe3= ruleCallMe3 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:986:2: iv_ruleCallMe3= ruleCallMe3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallMe3Rule(), currentNode); 
            pushFollow(FOLLOW_ruleCallMe3_in_entryRuleCallMe31760);
            iv_ruleCallMe3=ruleCallMe3();
            _fsp--;

             current =iv_ruleCallMe3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallMe31770); 

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
    // $ANTLR end entryRuleCallMe3


    // $ANTLR start ruleCallMe3
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:993:1: ruleCallMe3 returns [EObject current=null] : ( 'call' 'me' this_CallMe4_2= ruleCallMe4 ) ;
    public final EObject ruleCallMe3() throws RecognitionException {
        EObject current = null;

        EObject this_CallMe4_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:998:6: ( ( 'call' 'me' this_CallMe4_2= ruleCallMe4 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:999:1: ( 'call' 'me' this_CallMe4_2= ruleCallMe4 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:999:1: ( 'call' 'me' this_CallMe4_2= ruleCallMe4 )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:999:2: 'call' 'me' this_CallMe4_2= ruleCallMe4
            {
            match(input,21,FOLLOW_21_in_ruleCallMe31804); 

                    createLeafNode(grammarAccess.getCallMe3Access().getCallKeyword_0(), null); 
                
            match(input,22,FOLLOW_22_in_ruleCallMe31813); 

                    createLeafNode(grammarAccess.getCallMe3Access().getMeKeyword_1(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getCallMe3Access().getCallMe4ParserRuleCall_2(), currentNode); 
                
            pushFollow(FOLLOW_ruleCallMe4_in_ruleCallMe31835);
            this_CallMe4_2=ruleCallMe4();
            _fsp--;

             
                    current = this_CallMe4_2; 
                    currentNode = currentNode.getParent();
                

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
    // $ANTLR end ruleCallMe3


    // $ANTLR start entryRuleCallMe4
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1023:1: entryRuleCallMe4 returns [EObject current=null] : iv_ruleCallMe4= ruleCallMe4 EOF ;
    public final EObject entryRuleCallMe4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe4 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1023:49: (iv_ruleCallMe4= ruleCallMe4 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1024:2: iv_ruleCallMe4= ruleCallMe4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallMe4Rule(), currentNode); 
            pushFollow(FOLLOW_ruleCallMe4_in_entryRuleCallMe41867);
            iv_ruleCallMe4=ruleCallMe4();
            _fsp--;

             current =iv_ruleCallMe4; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallMe41877); 

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
    // $ANTLR end entryRuleCallMe4


    // $ANTLR start ruleCallMe4
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1031:1: ruleCallMe4 returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleCallMe4() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1036:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1037:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1037:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1038:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1038:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1039:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCallMe41918); 

            			createLeafNode(grammarAccess.getCallMe4Access().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCallMe4Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleCallMe4


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel118 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_ruleBaseAttribute_in_ruleModel139 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_12_in_ruleModel157 = new BitSet(new long[]{0x0000000000020012L});
    public static final BitSet FOLLOW_ruleSimpleAttribute_in_ruleModel178 = new BitSet(new long[]{0x0000000000020012L});
    public static final BitSet FOLLOW_13_in_ruleModel196 = new BitSet(new long[]{0x0000000000020012L});
    public static final BitSet FOLLOW_ruleRuleCallAttribute_in_ruleModel217 = new BitSet(new long[]{0x0000000000020012L});
    public static final BitSet FOLLOW_14_in_ruleModel235 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleRuleCallAttribute2_in_ruleModel256 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_15_in_ruleModel274 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleRuleCallAttribute3_in_ruleModel295 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_16_in_ruleModel313 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_ruleActionAttribute_in_ruleModel334 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_ruleBaseAttribute_in_entryRuleBaseAttribute369 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBaseAttribute379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleBaseAttribute427 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleMaster_in_ruleBaseAttribute454 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_ruleBaseAttribute465 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBaseAttribute483 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBaseAttribute507 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBaseAttribute530 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleBaseAttribute544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute577 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleAttribute630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMaster_in_entryRuleMaster663 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMaster673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleMaster716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActionAttribute_in_entryRuleActionAttribute749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActionAttribute759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleActionAttribute804 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_20_in_ruleActionAttribute830 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_ruleActionAttribute843 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActionAttribute861 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActionAttribute885 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActionAttribute908 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleActionAttribute922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAttribute_in_entryRuleSimpleAttribute955 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAttribute965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSimpleAttribute1001 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAttribute1019 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAttribute1043 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAttribute1066 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSimpleAttribute1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCallAttribute_in_entryRuleRuleCallAttribute1113 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallAttribute1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallMe_in_ruleRuleCallAttribute1170 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute1186 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRuleCallAttribute1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallMe_in_entryRuleCallMe1233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallMe1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleCallMe1278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCallMe1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCallMe1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCallAttribute2_in_entryRuleRuleCallAttribute21358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallAttribute21368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallMe2_in_ruleRuleCallAttribute21415 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_ruleRuleCallAttribute21425 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute21443 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute21467 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRuleCallAttribute21482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallMe2_in_entryRuleCallMe21515 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallMe21525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCallMe21566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCallAttribute3_in_entryRuleRuleCallAttribute31603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallAttribute31613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallMe3_in_ruleRuleCallAttribute31660 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_ruleRuleCallAttribute31670 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute31688 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute31712 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRuleCallAttribute31727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallMe3_in_entryRuleCallMe31760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallMe31770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleCallMe31804 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleCallMe31813 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCallMe4_in_ruleCallMe31835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallMe4_in_entryRuleCallMe41867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallMe41877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCallMe41918 = new BitSet(new long[]{0x0000000000000002L});

}
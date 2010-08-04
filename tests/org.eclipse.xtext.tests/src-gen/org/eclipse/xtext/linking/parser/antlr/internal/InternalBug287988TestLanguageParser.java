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

@SuppressWarnings("all")
public class InternalBug287988TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'actions'", "'simple'", "'rulecall'", "'rulecall2'", "'rulecall3'", "'inlinedActions'", "'ref'", "';'", "'attribute'", "'master'", "'call'", "'me'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalBug287988TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g"; }



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
       	
       	@Override
       	protected Bug287988TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:91:6: ( ( ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:92:1: ( ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:92:1: ( ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )
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
                    new NoViableAltException("92:1: ( ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:92:2: ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:92:2: ( 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:92:4: 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )*
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleModel121); 

                            createLeafNode(grammarAccess.getModelAccess().getActionsKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:96:1: ( (lv_attributes_1_0= ruleBaseAttribute ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=19 && LA1_0<=20)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:97:1: (lv_attributes_1_0= ruleBaseAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:97:1: (lv_attributes_1_0= ruleBaseAttribute )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:98:3: lv_attributes_1_0= ruleBaseAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesBaseAttributeParserRuleCall_0_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleBaseAttribute_in_ruleModel142);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:121:6: ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:121:6: ( 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:121:8: 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )*
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel161); 

                            createLeafNode(grammarAccess.getModelAccess().getSimpleKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:125:1: ( (lv_attributes_3_0= ruleSimpleAttribute ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID||LA2_0==17) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:126:1: (lv_attributes_3_0= ruleSimpleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:126:1: (lv_attributes_3_0= ruleSimpleAttribute )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:127:3: lv_attributes_3_0= ruleSimpleAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesSimpleAttributeParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleSimpleAttribute_in_ruleModel182);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:150:6: ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:150:6: ( 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:150:8: 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )*
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel201); 

                            createLeafNode(grammarAccess.getModelAccess().getRulecallKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:154:1: ( (lv_attributes_5_0= ruleRuleCallAttribute ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID||LA3_0==17) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:155:1: (lv_attributes_5_0= ruleRuleCallAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:155:1: (lv_attributes_5_0= ruleRuleCallAttribute )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:156:3: lv_attributes_5_0= ruleRuleCallAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesRuleCallAttributeParserRuleCall_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleRuleCallAttribute_in_ruleModel222);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:179:6: ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:179:6: ( 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:179:8: 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )*
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleModel241); 

                            createLeafNode(grammarAccess.getModelAccess().getRulecall2Keyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:183:1: ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:184:1: (lv_attributes_7_0= ruleRuleCallAttribute2 )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:184:1: (lv_attributes_7_0= ruleRuleCallAttribute2 )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:185:3: lv_attributes_7_0= ruleRuleCallAttribute2
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesRuleCallAttribute2ParserRuleCall_3_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleRuleCallAttribute2_in_ruleModel262);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:208:6: ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:208:6: ( 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:208:8: 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )*
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleModel281); 

                            createLeafNode(grammarAccess.getModelAccess().getRulecall3Keyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:212:1: ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==21) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:213:1: (lv_attributes_9_0= ruleRuleCallAttribute3 )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:213:1: (lv_attributes_9_0= ruleRuleCallAttribute3 )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:214:3: lv_attributes_9_0= ruleRuleCallAttribute3
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesRuleCallAttribute3ParserRuleCall_4_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleRuleCallAttribute3_in_ruleModel302);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:237:6: ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:237:6: ( 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:237:8: 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )*
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleModel321); 

                            createLeafNode(grammarAccess.getModelAccess().getInlinedActionsKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:241:1: ( (lv_attributes_11_0= ruleActionAttribute ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=19 && LA6_0<=20)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:242:1: (lv_attributes_11_0= ruleActionAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:242:1: (lv_attributes_11_0= ruleActionAttribute )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:243:3: lv_attributes_11_0= ruleActionAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesActionAttributeParserRuleCall_5_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleActionAttribute_in_ruleModel342);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:273:1: entryRuleBaseAttribute returns [EObject current=null] : iv_ruleBaseAttribute= ruleBaseAttribute EOF ;
    public final EObject entryRuleBaseAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseAttribute = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:274:2: (iv_ruleBaseAttribute= ruleBaseAttribute EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:275:2: iv_ruleBaseAttribute= ruleBaseAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBaseAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBaseAttribute_in_entryRuleBaseAttribute380);
            iv_ruleBaseAttribute=ruleBaseAttribute();
            _fsp--;

             current =iv_ruleBaseAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBaseAttribute390); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:282:1: ruleBaseAttribute returns [EObject current=null] : ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleBaseAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_type_4_0=null;
        Token lv_name_5_0=null;
        EObject this_Attribute_0 = null;

        EObject this_Master_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:287:6: ( ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:288:1: ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:288:1: ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:288:2: (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:288:2: (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster )
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
                    new NoViableAltException("288:2: (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:289:5: this_Attribute_0= ruleAttribute
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBaseAttributeAccess().getAttributeParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleBaseAttribute438);
                    this_Attribute_0=ruleAttribute();
                    _fsp--;

                     
                            current = this_Attribute_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:299:5: this_Master_1= ruleMaster
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBaseAttributeAccess().getMasterParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMaster_in_ruleBaseAttribute465);
                    this_Master_1=ruleMaster();
                    _fsp--;

                     
                            current = this_Master_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:307:2: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) )
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
                    new NoViableAltException("307:2: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:307:3: ( 'ref' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:307:3: ( 'ref' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:307:5: 'ref' ( ( RULE_ID ) )
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleBaseAttribute477); 

                            createLeafNode(grammarAccess.getBaseAttributeAccess().getRefKeyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:311:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:312:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:312:1: ( RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:313:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getBaseAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBaseAttribute495); 

                    		createLeafNode(grammarAccess.getBaseAttributeAccess().getTypeRefBaseAttributeCrossReference_1_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:326:6: ( (lv_type_4_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:326:6: ( (lv_type_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:327:1: (lv_type_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:327:1: (lv_type_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:328:3: lv_type_4_0= RULE_ID
                    {
                    lv_type_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBaseAttribute519); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:350:3: ( (lv_name_5_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:351:1: (lv_name_5_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:351:1: (lv_name_5_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:352:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBaseAttribute542); 

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

            match(input,18,FollowSets000.FOLLOW_18_in_ruleBaseAttribute557); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:386:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:387:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:388:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute593);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute603); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:395:1: ruleAttribute returns [EObject current=null] : ( () 'attribute' ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:400:6: ( ( () 'attribute' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:401:1: ( () 'attribute' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:401:1: ( () 'attribute' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:401:2: () 'attribute'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:401:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:402:5: 
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

            match(input,19,FollowSets000.FOLLOW_19_in_ruleAttribute647); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:424:1: entryRuleMaster returns [EObject current=null] : iv_ruleMaster= ruleMaster EOF ;
    public final EObject entryRuleMaster() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaster = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:425:2: (iv_ruleMaster= ruleMaster EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:426:2: iv_ruleMaster= ruleMaster EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMasterRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMaster_in_entryRuleMaster683);
            iv_ruleMaster=ruleMaster();
            _fsp--;

             current =iv_ruleMaster; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaster693); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:433:1: ruleMaster returns [EObject current=null] : ( () 'master' ) ;
    public final EObject ruleMaster() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:438:6: ( ( () 'master' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:439:1: ( () 'master' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:439:1: ( () 'master' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:439:2: () 'master'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:439:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:440:5: 
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

            match(input,20,FollowSets000.FOLLOW_20_in_ruleMaster737); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:462:1: entryRuleActionAttribute returns [EObject current=null] : iv_ruleActionAttribute= ruleActionAttribute EOF ;
    public final EObject entryRuleActionAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionAttribute = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:463:2: (iv_ruleActionAttribute= ruleActionAttribute EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:464:2: iv_ruleActionAttribute= ruleActionAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleActionAttribute_in_entryRuleActionAttribute773);
            iv_ruleActionAttribute=ruleActionAttribute();
            _fsp--;

             current =iv_ruleActionAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleActionAttribute783); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:471:1: ruleActionAttribute returns [EObject current=null] : ( ( ( () 'attribute' ) | ( () 'master' ) ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleActionAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_type_6_0=null;
        Token lv_name_7_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:476:6: ( ( ( ( () 'attribute' ) | ( () 'master' ) ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:477:1: ( ( ( () 'attribute' ) | ( () 'master' ) ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:477:1: ( ( ( () 'attribute' ) | ( () 'master' ) ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:477:2: ( ( () 'attribute' ) | ( () 'master' ) ) ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:477:2: ( ( () 'attribute' ) | ( () 'master' ) )
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
                    new NoViableAltException("477:2: ( ( () 'attribute' ) | ( () 'master' ) )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:477:3: ( () 'attribute' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:477:3: ( () 'attribute' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:477:4: () 'attribute'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:477:4: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:478:5: 
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

                    match(input,19,FollowSets000.FOLLOW_19_in_ruleActionAttribute829); 

                            createLeafNode(grammarAccess.getActionAttributeAccess().getAttributeKeyword_0_0_1(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:493:6: ( () 'master' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:493:6: ( () 'master' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:493:7: () 'master'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:493:7: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:494:5: 
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

                    match(input,20,FollowSets000.FOLLOW_20_in_ruleActionAttribute856); 

                            createLeafNode(grammarAccess.getActionAttributeAccess().getMasterKeyword_0_1_1(), null); 
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:508:3: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) )
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
                    new NoViableAltException("508:3: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:508:4: ( 'ref' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:508:4: ( 'ref' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:508:6: 'ref' ( ( RULE_ID ) )
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleActionAttribute870); 

                            createLeafNode(grammarAccess.getActionAttributeAccess().getRefKeyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:512:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:513:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:513:1: ( RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:514:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getActionAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleActionAttribute888); 

                    		createLeafNode(grammarAccess.getActionAttributeAccess().getTypeRefBaseAttributeCrossReference_1_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:527:6: ( (lv_type_6_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:527:6: ( (lv_type_6_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:528:1: (lv_type_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:528:1: (lv_type_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:529:3: lv_type_6_0= RULE_ID
                    {
                    lv_type_6_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleActionAttribute912); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:551:3: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:552:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:552:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:553:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleActionAttribute935); 

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

            match(input,18,FollowSets000.FOLLOW_18_in_ruleActionAttribute950); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:587:1: entryRuleSimpleAttribute returns [EObject current=null] : iv_ruleSimpleAttribute= ruleSimpleAttribute EOF ;
    public final EObject entryRuleSimpleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAttribute = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:588:2: (iv_ruleSimpleAttribute= ruleSimpleAttribute EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:589:2: iv_ruleSimpleAttribute= ruleSimpleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleAttribute_in_entryRuleSimpleAttribute986);
            iv_ruleSimpleAttribute=ruleSimpleAttribute();
            _fsp--;

             current =iv_ruleSimpleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleAttribute996); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:596:1: ruleSimpleAttribute returns [EObject current=null] : ( ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleSimpleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_type_2_0=null;
        Token lv_name_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:601:6: ( ( ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:602:1: ( ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:602:1: ( ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:602:2: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:602:2: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
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
                    new NoViableAltException("602:2: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:602:3: ( 'ref' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:602:3: ( 'ref' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:602:5: 'ref' ( ( RULE_ID ) )
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleSimpleAttribute1033); 

                            createLeafNode(grammarAccess.getSimpleAttributeAccess().getRefKeyword_0_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:606:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:607:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:607:1: ( RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:608:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSimpleAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAttribute1051); 

                    		createLeafNode(grammarAccess.getSimpleAttributeAccess().getTypeRefBaseAttributeCrossReference_0_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:621:6: ( (lv_type_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:621:6: ( (lv_type_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:622:1: (lv_type_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:622:1: (lv_type_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:623:3: lv_type_2_0= RULE_ID
                    {
                    lv_type_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAttribute1075); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:645:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:646:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:646:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:647:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAttribute1098); 

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

            match(input,18,FollowSets000.FOLLOW_18_in_ruleSimpleAttribute1113); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:681:1: entryRuleRuleCallAttribute returns [EObject current=null] : iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF ;
    public final EObject entryRuleRuleCallAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallAttribute = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:682:2: (iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:683:2: iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallAttribute_in_entryRuleRuleCallAttribute1149);
            iv_ruleRuleCallAttribute=ruleRuleCallAttribute();
            _fsp--;

             current =iv_ruleRuleCallAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallAttribute1159); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:690:1: ruleRuleCallAttribute returns [EObject current=null] : (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleRuleCallAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject this_CallMe_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:695:6: ( (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:696:1: (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:696:1: (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:697:5: this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRuleCallAttributeAccess().getCallMeParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCallMe_in_ruleRuleCallAttribute1206);
            this_CallMe_0=ruleCallMe();
            _fsp--;

             
                    current = this_CallMe_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:705:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:706:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:706:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:707:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallAttribute1222); 

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

            match(input,18,FollowSets000.FOLLOW_18_in_ruleRuleCallAttribute1237); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:741:1: entryRuleCallMe returns [EObject current=null] : iv_ruleCallMe= ruleCallMe EOF ;
    public final EObject entryRuleCallMe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:742:2: (iv_ruleCallMe= ruleCallMe EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:743:2: iv_ruleCallMe= ruleCallMe EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallMeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCallMe_in_entryRuleCallMe1273);
            iv_ruleCallMe=ruleCallMe();
            _fsp--;

             current =iv_ruleCallMe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallMe1283); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:750:1: ruleCallMe returns [EObject current=null] : ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ;
    public final EObject ruleCallMe() throws RecognitionException {
        EObject current = null;

        Token lv_type_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:755:6: ( ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:756:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:756:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
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
                    new NoViableAltException("756:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:756:2: ( 'ref' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:756:2: ( 'ref' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:756:4: 'ref' ( ( RULE_ID ) )
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleCallMe1319); 

                            createLeafNode(grammarAccess.getCallMeAccess().getRefKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:760:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:761:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:761:1: ( RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:762:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getCallMeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCallMe1337); 

                    		createLeafNode(grammarAccess.getCallMeAccess().getTypeRefBaseAttributeCrossReference_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:775:6: ( (lv_type_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:775:6: ( (lv_type_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:776:1: (lv_type_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:776:1: (lv_type_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:777:3: lv_type_2_0= RULE_ID
                    {
                    lv_type_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCallMe1361); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:807:1: entryRuleRuleCallAttribute2 returns [EObject current=null] : iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF ;
    public final EObject entryRuleRuleCallAttribute2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallAttribute2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:808:2: (iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:809:2: iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallAttribute2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallAttribute2_in_entryRuleRuleCallAttribute21402);
            iv_ruleRuleCallAttribute2=ruleRuleCallAttribute2();
            _fsp--;

             current =iv_ruleRuleCallAttribute2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallAttribute21412); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:816:1: ruleRuleCallAttribute2 returns [EObject current=null] : (this_CallMe2_0= ruleCallMe2 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' ) ;
    public final EObject ruleRuleCallAttribute2() throws RecognitionException {
        EObject current = null;

        Token lv_type_3_0=null;
        EObject this_CallMe2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:821:6: ( (this_CallMe2_0= ruleCallMe2 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:822:1: (this_CallMe2_0= ruleCallMe2 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:822:1: (this_CallMe2_0= ruleCallMe2 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:823:5: this_CallMe2_0= ruleCallMe2 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRuleCallAttribute2Access().getCallMe2ParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCallMe2_in_ruleRuleCallAttribute21459);
            this_CallMe2_0=ruleCallMe2();
            _fsp--;

             
                    current = this_CallMe2_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:831:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )
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
                    new NoViableAltException("831:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:831:2: ( 'ref' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:831:2: ( 'ref' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:831:4: 'ref' ( ( RULE_ID ) )
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleCallAttribute21470); 

                            createLeafNode(grammarAccess.getRuleCallAttribute2Access().getRefKeyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:835:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:836:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:836:1: ( RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:837:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleCallAttribute2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallAttribute21488); 

                    		createLeafNode(grammarAccess.getRuleCallAttribute2Access().getTypeRefBaseAttributeCrossReference_1_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:850:6: ( (lv_type_3_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:850:6: ( (lv_type_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:851:1: (lv_type_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:851:1: (lv_type_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:852:3: lv_type_3_0= RULE_ID
                    {
                    lv_type_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallAttribute21512); 

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

            match(input,18,FollowSets000.FOLLOW_18_in_ruleRuleCallAttribute21528); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:886:1: entryRuleCallMe2 returns [EObject current=null] : iv_ruleCallMe2= ruleCallMe2 EOF ;
    public final EObject entryRuleCallMe2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:887:2: (iv_ruleCallMe2= ruleCallMe2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:888:2: iv_ruleCallMe2= ruleCallMe2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallMe2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCallMe2_in_entryRuleCallMe21564);
            iv_ruleCallMe2=ruleCallMe2();
            _fsp--;

             current =iv_ruleCallMe2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallMe21574); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:895:1: ruleCallMe2 returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleCallMe2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:900:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:901:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:901:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:902:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:902:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:903:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCallMe21615); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:933:1: entryRuleRuleCallAttribute3 returns [EObject current=null] : iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF ;
    public final EObject entryRuleRuleCallAttribute3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallAttribute3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:934:2: (iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:935:2: iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallAttribute3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallAttribute3_in_entryRuleRuleCallAttribute31655);
            iv_ruleRuleCallAttribute3=ruleRuleCallAttribute3();
            _fsp--;

             current =iv_ruleRuleCallAttribute3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallAttribute31665); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:942:1: ruleRuleCallAttribute3 returns [EObject current=null] : (this_CallMe3_0= ruleCallMe3 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' ) ;
    public final EObject ruleRuleCallAttribute3() throws RecognitionException {
        EObject current = null;

        Token lv_type_3_0=null;
        EObject this_CallMe3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:947:6: ( (this_CallMe3_0= ruleCallMe3 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:948:1: (this_CallMe3_0= ruleCallMe3 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:948:1: (this_CallMe3_0= ruleCallMe3 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:949:5: this_CallMe3_0= ruleCallMe3 ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRuleCallAttribute3Access().getCallMe3ParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCallMe3_in_ruleRuleCallAttribute31712);
            this_CallMe3_0=ruleCallMe3();
            _fsp--;

             
                    current = this_CallMe3_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:957:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )
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
                    new NoViableAltException("957:1: ( ( 'ref' ( ( RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:957:2: ( 'ref' ( ( RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:957:2: ( 'ref' ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:957:4: 'ref' ( ( RULE_ID ) )
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleCallAttribute31723); 

                            createLeafNode(grammarAccess.getRuleCallAttribute3Access().getRefKeyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:961:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:962:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:962:1: ( RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:963:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleCallAttribute3Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallAttribute31741); 

                    		createLeafNode(grammarAccess.getRuleCallAttribute3Access().getTypeRefBaseAttributeCrossReference_1_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:976:6: ( (lv_type_3_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:976:6: ( (lv_type_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:977:1: (lv_type_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:977:1: (lv_type_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:978:3: lv_type_3_0= RULE_ID
                    {
                    lv_type_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallAttribute31765); 

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

            match(input,18,FollowSets000.FOLLOW_18_in_ruleRuleCallAttribute31781); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1012:1: entryRuleCallMe3 returns [EObject current=null] : iv_ruleCallMe3= ruleCallMe3 EOF ;
    public final EObject entryRuleCallMe3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1013:2: (iv_ruleCallMe3= ruleCallMe3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1014:2: iv_ruleCallMe3= ruleCallMe3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallMe3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCallMe3_in_entryRuleCallMe31817);
            iv_ruleCallMe3=ruleCallMe3();
            _fsp--;

             current =iv_ruleCallMe3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallMe31827); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1021:1: ruleCallMe3 returns [EObject current=null] : ( 'call' 'me' this_CallMe4_2= ruleCallMe4 ) ;
    public final EObject ruleCallMe3() throws RecognitionException {
        EObject current = null;

        EObject this_CallMe4_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1026:6: ( ( 'call' 'me' this_CallMe4_2= ruleCallMe4 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1027:1: ( 'call' 'me' this_CallMe4_2= ruleCallMe4 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1027:1: ( 'call' 'me' this_CallMe4_2= ruleCallMe4 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1027:3: 'call' 'me' this_CallMe4_2= ruleCallMe4
            {
            match(input,21,FollowSets000.FOLLOW_21_in_ruleCallMe31862); 

                    createLeafNode(grammarAccess.getCallMe3Access().getCallKeyword_0(), null); 
                
            match(input,22,FollowSets000.FOLLOW_22_in_ruleCallMe31872); 

                    createLeafNode(grammarAccess.getCallMe3Access().getMeKeyword_1(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getCallMe3Access().getCallMe4ParserRuleCall_2(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCallMe4_in_ruleCallMe31894);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1052:1: entryRuleCallMe4 returns [EObject current=null] : iv_ruleCallMe4= ruleCallMe4 EOF ;
    public final EObject entryRuleCallMe4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1053:2: (iv_ruleCallMe4= ruleCallMe4 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1054:2: iv_ruleCallMe4= ruleCallMe4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallMe4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCallMe4_in_entryRuleCallMe41929);
            iv_ruleCallMe4=ruleCallMe4();
            _fsp--;

             current =iv_ruleCallMe4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallMe41939); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1061:1: ruleCallMe4 returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleCallMe4() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1066:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1067:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1067:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1068:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1068:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1069:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCallMe41980); 

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel121 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_ruleBaseAttribute_in_ruleModel142 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_12_in_ruleModel161 = new BitSet(new long[]{0x0000000000020012L});
        public static final BitSet FOLLOW_ruleSimpleAttribute_in_ruleModel182 = new BitSet(new long[]{0x0000000000020012L});
        public static final BitSet FOLLOW_13_in_ruleModel201 = new BitSet(new long[]{0x0000000000020012L});
        public static final BitSet FOLLOW_ruleRuleCallAttribute_in_ruleModel222 = new BitSet(new long[]{0x0000000000020012L});
        public static final BitSet FOLLOW_14_in_ruleModel241 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleRuleCallAttribute2_in_ruleModel262 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_15_in_ruleModel281 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleRuleCallAttribute3_in_ruleModel302 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_16_in_ruleModel321 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_ruleActionAttribute_in_ruleModel342 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_ruleBaseAttribute_in_entryRuleBaseAttribute380 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBaseAttribute390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleBaseAttribute438 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleMaster_in_ruleBaseAttribute465 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_17_in_ruleBaseAttribute477 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBaseAttribute495 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBaseAttribute519 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBaseAttribute542 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleBaseAttribute557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute593 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleAttribute647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaster_in_entryRuleMaster683 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaster693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleMaster737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleActionAttribute_in_entryRuleActionAttribute773 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleActionAttribute783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleActionAttribute829 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_20_in_ruleActionAttribute856 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_17_in_ruleActionAttribute870 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleActionAttribute888 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleActionAttribute912 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleActionAttribute935 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleActionAttribute950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAttribute_in_entryRuleSimpleAttribute986 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAttribute996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSimpleAttribute1033 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAttribute1051 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAttribute1075 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAttribute1098 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleSimpleAttribute1113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallAttribute_in_entryRuleRuleCallAttribute1149 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallAttribute1159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe_in_ruleRuleCallAttribute1206 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute1222 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleRuleCallAttribute1237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe_in_entryRuleCallMe1273 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallMe1283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleCallMe1319 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCallMe1337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCallMe1361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallAttribute2_in_entryRuleRuleCallAttribute21402 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallAttribute21412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe2_in_ruleRuleCallAttribute21459 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_17_in_ruleRuleCallAttribute21470 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute21488 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute21512 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleRuleCallAttribute21528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe2_in_entryRuleCallMe21564 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallMe21574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCallMe21615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallAttribute3_in_entryRuleRuleCallAttribute31655 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallAttribute31665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe3_in_ruleRuleCallAttribute31712 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_17_in_ruleRuleCallAttribute31723 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute31741 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute31765 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleRuleCallAttribute31781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe3_in_entryRuleCallMe31817 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallMe31827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleCallMe31862 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleCallMe31872 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleCallMe4_in_ruleCallMe31894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe4_in_entryRuleCallMe41929 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallMe41939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCallMe41980 = new BitSet(new long[]{0x0000000000000002L});
    }


}
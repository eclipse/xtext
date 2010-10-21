package org.eclipse.xtext.ui.codetemplates.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.codetemplates.services.SingleCodetemplateGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSingleCodetemplateParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_12", "KEYWORD_11", "KEYWORD_8", "KEYWORD_9", "KEYWORD_10", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "KEYWORD_5", "KEYWORD_6", "KEYWORD_7", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int KEYWORD_7=15;
    public static final int RULE_ID=16;
    public static final int KEYWORD_10=8;
    public static final int KEYWORD_1=9;
    public static final int RULE_STRING=17;
    public static final int KEYWORD_9=7;
    public static final int KEYWORD_2=10;
    public static final int KEYWORD_11=5;
    public static final int KEYWORD_4=12;
    public static final int RULE_WS=18;
    public static final int EOF=-1;
    public static final int KEYWORD_5=13;
    public static final int KEYWORD_6=14;
    public static final int RULE_ANY_OTHER=19;
    public static final int KEYWORD_12=4;
    public static final int KEYWORD_8=6;
    public static final int KEYWORD_3=11;

    // delegates
    // delegators


        public InternalSingleCodetemplateParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSingleCodetemplateParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSingleCodetemplateParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g"; }




     	private SingleCodetemplateGrammarAccess grammarAccess;
     	
        public InternalSingleCodetemplateParser(TokenStream input, IAstFactory factory, SingleCodetemplateGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Codetemplates";	
       	} 
       	   	
       	@Override
       	protected SingleCodetemplateGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleCodetemplates"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:65:1: entryRuleCodetemplates returns [EObject current=null] : iv_ruleCodetemplates= ruleCodetemplates EOF ;
    public final EObject entryRuleCodetemplates() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodetemplates = null;


        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:66:2: (iv_ruleCodetemplates= ruleCodetemplates EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:67:2: iv_ruleCodetemplates= ruleCodetemplates EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCodetemplatesRule(), currentNode); 
            pushFollow(FOLLOW_ruleCodetemplates_in_entryRuleCodetemplates67);
            iv_ruleCodetemplates=ruleCodetemplates();

            state._fsp--;

             current =iv_ruleCodetemplates; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodetemplates77); 

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
    // $ANTLR end "entryRuleCodetemplates"


    // $ANTLR start "ruleCodetemplates"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:74:1: ruleCodetemplates returns [EObject current=null] : (otherlv_0= KEYWORD_12 otherlv_1= KEYWORD_11 ( ( ruleFQN ) ) ( (lv_templates_3_0= ruleCodetemplate ) ) ) ;
    public final EObject ruleCodetemplates() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_templates_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:79:6: ( (otherlv_0= KEYWORD_12 otherlv_1= KEYWORD_11 ( ( ruleFQN ) ) ( (lv_templates_3_0= ruleCodetemplate ) ) ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:80:1: (otherlv_0= KEYWORD_12 otherlv_1= KEYWORD_11 ( ( ruleFQN ) ) ( (lv_templates_3_0= ruleCodetemplate ) ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:80:1: (otherlv_0= KEYWORD_12 otherlv_1= KEYWORD_11 ( ( ruleFQN ) ) ( (lv_templates_3_0= ruleCodetemplate ) ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:81:2: otherlv_0= KEYWORD_12 otherlv_1= KEYWORD_11 ( ( ruleFQN ) ) ( (lv_templates_3_0= ruleCodetemplate ) )
            {
            otherlv_0=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleCodetemplates115); 

                	createLeafNode(otherlv_0, grammarAccess.getCodetemplatesAccess().getTemplatesKeyword_0(), null);
                
            otherlv_1=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleCodetemplates128); 

                	createLeafNode(otherlv_1, grammarAccess.getCodetemplatesAccess().getForKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:90:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:91:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:91:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:92:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getCodetemplatesRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getCodetemplatesAccess().getLanguageGrammarCrossReference_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleCodetemplates151);
            ruleFQN();

            state._fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:106:2: ( (lv_templates_3_0= ruleCodetemplate ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:107:1: (lv_templates_3_0= ruleCodetemplate )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:107:1: (lv_templates_3_0= ruleCodetemplate )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:108:3: lv_templates_3_0= ruleCodetemplate
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCodetemplatesAccess().getTemplatesCodetemplateParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleCodetemplate_in_ruleCodetemplates172);
            lv_templates_3_0=ruleCodetemplate();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCodetemplatesRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"templates",
            	        		lv_templates_3_0, 
            	        		"Codetemplate", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end "ruleCodetemplates"


    // $ANTLR start "entryRuleCodetemplate"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:138:1: entryRuleCodetemplate returns [EObject current=null] : iv_ruleCodetemplate= ruleCodetemplate EOF ;
    public final EObject entryRuleCodetemplate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodetemplate = null;


        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:139:2: (iv_ruleCodetemplate= ruleCodetemplate EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:140:2: iv_ruleCodetemplate= ruleCodetemplate EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCodetemplateRule(), currentNode); 
            pushFollow(FOLLOW_ruleCodetemplate_in_entryRuleCodetemplate207);
            iv_ruleCodetemplate=ruleCodetemplate();

            state._fsp--;

             current =iv_ruleCodetemplate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodetemplate217); 

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
    // $ANTLR end "entryRuleCodetemplate"


    // $ANTLR start "ruleCodetemplate"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:147:1: ruleCodetemplate returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= KEYWORD_11 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_3_0= RULE_STRING ) ) ) ( (lv_body_4_0= ruleTemplateBodyWithQuotes ) ) ) ;
    public final EObject ruleCodetemplate() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_keywordContext_3_0=null;
        EObject lv_body_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:152:6: ( ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= KEYWORD_11 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_3_0= RULE_STRING ) ) ) ( (lv_body_4_0= ruleTemplateBodyWithQuotes ) ) ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:153:1: ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= KEYWORD_11 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_3_0= RULE_STRING ) ) ) ( (lv_body_4_0= ruleTemplateBodyWithQuotes ) ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:153:1: ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= KEYWORD_11 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_3_0= RULE_STRING ) ) ) ( (lv_body_4_0= ruleTemplateBodyWithQuotes ) ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:153:2: ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= KEYWORD_11 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_3_0= RULE_STRING ) ) ) ( (lv_body_4_0= ruleTemplateBodyWithQuotes ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:153:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:154:1: (lv_name_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:154:1: (lv_name_0_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:155:3: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCodetemplate259); 

            			createLeafNode(lv_name_0_0, grammarAccess.getCodetemplateAccess().getNameSTRINGTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCodetemplateRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_1=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleCodetemplate277); 

                	createLeafNode(otherlv_1, grammarAccess.getCodetemplateAccess().getForKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:182:1: ( ( ( ruleValidID ) ) | ( (lv_keywordContext_3_0= RULE_STRING ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=KEYWORD_12 && LA1_0<=KEYWORD_11)||LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_STRING) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:182:2: ( ( ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:182:2: ( ( ruleValidID ) )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:183:1: ( ruleValidID )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:183:1: ( ruleValidID )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:184:3: ruleValidID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getCodetemplateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_2_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleValidID_in_ruleCodetemplate301);
                    ruleValidID();

                    state._fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:199:6: ( (lv_keywordContext_3_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:199:6: ( (lv_keywordContext_3_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:200:1: (lv_keywordContext_3_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:200:1: (lv_keywordContext_3_0= RULE_STRING )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:201:3: lv_keywordContext_3_0= RULE_STRING
                    {
                    lv_keywordContext_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCodetemplate324); 

                    			createLeafNode(lv_keywordContext_3_0, grammarAccess.getCodetemplateAccess().getKeywordContextSTRINGTerminalRuleCall_2_1_0(), "keywordContext"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCodetemplateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"keywordContext",
                    	        		lv_keywordContext_3_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:223:3: ( (lv_body_4_0= ruleTemplateBodyWithQuotes ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:224:1: (lv_body_4_0= ruleTemplateBodyWithQuotes )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:224:1: (lv_body_4_0= ruleTemplateBodyWithQuotes )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:225:3: lv_body_4_0= ruleTemplateBodyWithQuotes
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCodetemplateAccess().getBodyTemplateBodyWithQuotesParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTemplateBodyWithQuotes_in_ruleCodetemplate351);
            lv_body_4_0=ruleTemplateBodyWithQuotes();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCodetemplateRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"body",
            	        		lv_body_4_0, 
            	        		"TemplateBodyWithQuotes", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end "ruleCodetemplate"


    // $ANTLR start "entryRuleTemplateBodyWithQuotes"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:255:1: entryRuleTemplateBodyWithQuotes returns [EObject current=null] : iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF ;
    public final EObject entryRuleTemplateBodyWithQuotes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBodyWithQuotes = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:259:2: (iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:260:2: iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTemplateBodyWithQuotesRule(), currentNode); 
            pushFollow(FOLLOW_ruleTemplateBodyWithQuotes_in_entryRuleTemplateBodyWithQuotes392);
            iv_ruleTemplateBodyWithQuotes=ruleTemplateBodyWithQuotes();

            state._fsp--;

             current =iv_ruleTemplateBodyWithQuotes; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTemplateBodyWithQuotes402); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateBodyWithQuotes"


    // $ANTLR start "ruleTemplateBodyWithQuotes"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:270:1: ruleTemplateBodyWithQuotes returns [EObject current=null] : (otherlv_0= KEYWORD_10 this_TemplateBody_1= ruleTemplateBody ) ;
    public final EObject ruleTemplateBodyWithQuotes() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TemplateBody_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:276:6: ( (otherlv_0= KEYWORD_10 this_TemplateBody_1= ruleTemplateBody ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:277:1: (otherlv_0= KEYWORD_10 this_TemplateBody_1= ruleTemplateBody )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:277:1: (otherlv_0= KEYWORD_10 this_TemplateBody_1= ruleTemplateBody )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:278:2: otherlv_0= KEYWORD_10 this_TemplateBody_1= ruleTemplateBody
            {
            otherlv_0=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleTemplateBodyWithQuotes444); 

                	createLeafNode(otherlv_0, grammarAccess.getTemplateBodyWithQuotesAccess().getGreaterThanSignGreaterThanSignKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getTemplateBodyWithQuotesAccess().getTemplateBodyParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleTemplateBody_in_ruleTemplateBodyWithQuotes466);
            this_TemplateBody_1=ruleTemplateBody();

            state._fsp--;


                    current = this_TemplateBody_1;
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleTemplateBodyWithQuotes"


    // $ANTLR start "entryRuleLiteralValue"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:302:1: entryRuleLiteralValue returns [String current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final String entryRuleLiteralValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteralValue = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:306:1: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:307:2: iv_ruleLiteralValue= ruleLiteralValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue511);
            iv_ruleLiteralValue=ruleLiteralValue();

            state._fsp--;

             current =iv_ruleLiteralValue.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralValue522); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralValue"


    // $ANTLR start "ruleLiteralValue"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:317:1: ruleLiteralValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID )+ ;
    public final AntlrDatatypeRuleToken ruleLiteralValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token this_ANY_OTHER_1=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:323:6: ( (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID )+ )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:324:1: (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID )+
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:324:1: (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID )+
            int cnt2=0;
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case RULE_WS:
                    {
                    alt2=1;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt2=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:324:6: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleLiteralValue566); 

            	    		current.merge(this_WS_0);
            	        
            	     
            	        createLeafNode(this_WS_0, grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0(), null); 
            	        

            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:332:10: this_ANY_OTHER_1= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_1=(Token)match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_ruleLiteralValue592); 

            	    		current.merge(this_ANY_OTHER_1);
            	        
            	     
            	        createLeafNode(this_ANY_OTHER_1, grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1(), null); 
            	        

            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:340:10: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLiteralValue618); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(this_ID_2, grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2(), null); 
            	        

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

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleLiteralValue"


    // $ANTLR start "entryRuleTemplateBody"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:358:1: entryRuleTemplateBody returns [EObject current=null] : iv_ruleTemplateBody= ruleTemplateBody EOF ;
    public final EObject entryRuleTemplateBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBody = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:362:2: (iv_ruleTemplateBody= ruleTemplateBody EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:363:2: iv_ruleTemplateBody= ruleTemplateBody EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTemplateBodyRule(), currentNode); 
            pushFollow(FOLLOW_ruleTemplateBody_in_entryRuleTemplateBody673);
            iv_ruleTemplateBody=ruleTemplateBody();

            state._fsp--;

             current =iv_ruleTemplateBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTemplateBody683); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateBody"


    // $ANTLR start "ruleTemplateBody"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:373:1: ruleTemplateBody returns [EObject current=null] : ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* ) ;
    public final EObject ruleTemplateBody() throws RecognitionException {
        EObject current = null;

        EObject lv_parts_1_0 = null;

        EObject lv_parts_2_0 = null;

        EObject lv_parts_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:379:6: ( ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:380:1: ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:380:1: ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:380:2: () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )*
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:380:2: ()
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:381:5: 
            {
             
                    temp=factory.create(grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:391:2: ( (lv_parts_1_0= ruleLiteral ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID||(LA3_0>=RULE_WS && LA3_0<=RULE_ANY_OTHER)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:392:1: (lv_parts_1_0= ruleLiteral )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:392:1: (lv_parts_1_0= ruleLiteral )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:393:3: lv_parts_1_0= ruleLiteral
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLiteral_in_ruleTemplateBody742);
                    lv_parts_1_0=ruleLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTemplateBodyRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"parts",
                    	        		lv_parts_1_0, 
                    	        		"Literal", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:415:3: ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=KEYWORD_8 && LA5_0<=KEYWORD_9)||LA5_0==KEYWORD_1) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:415:4: ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )?
            	    {
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:415:4: ( (lv_parts_2_0= ruleVariableOrDollar ) )
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:416:1: (lv_parts_2_0= ruleVariableOrDollar )
            	    {
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:416:1: (lv_parts_2_0= ruleVariableOrDollar )
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:417:3: lv_parts_2_0= ruleVariableOrDollar
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsVariableOrDollarParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleVariableOrDollar_in_ruleTemplateBody765);
            	    lv_parts_2_0=ruleVariableOrDollar();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTemplateBodyRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"parts",
            	    	        		lv_parts_2_0, 
            	    	        		"VariableOrDollar", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:439:2: ( (lv_parts_3_0= ruleLiteral ) )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==RULE_ID||(LA4_0>=RULE_WS && LA4_0<=RULE_ANY_OTHER)) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:440:1: (lv_parts_3_0= ruleLiteral )
            	            {
            	            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:440:1: (lv_parts_3_0= ruleLiteral )
            	            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:441:3: lv_parts_3_0= ruleLiteral
            	            {
            	             
            	            	        currentNode=createCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_2_1_0(), currentNode); 
            	            	    
            	            pushFollow(FOLLOW_ruleLiteral_in_ruleTemplateBody786);
            	            lv_parts_3_0=ruleLiteral();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getTemplateBodyRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	            	        }
            	            	        try {
            	            	       		add(
            	            	       			current, 
            	            	       			"parts",
            	            	        		lv_parts_3_0, 
            	            	        		"Literal", 
            	            	        		currentNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	        currentNode = currentNode.getParent();
            	            	    

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleTemplateBody"


    // $ANTLR start "entryRuleVariableOrDollar"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:476:1: entryRuleVariableOrDollar returns [EObject current=null] : iv_ruleVariableOrDollar= ruleVariableOrDollar EOF ;
    public final EObject entryRuleVariableOrDollar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableOrDollar = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:480:2: (iv_ruleVariableOrDollar= ruleVariableOrDollar EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:481:2: iv_ruleVariableOrDollar= ruleVariableOrDollar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableOrDollarRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableOrDollar_in_entryRuleVariableOrDollar836);
            iv_ruleVariableOrDollar=ruleVariableOrDollar();

            state._fsp--;

             current =iv_ruleVariableOrDollar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableOrDollar846); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVariableOrDollar"


    // $ANTLR start "ruleVariableOrDollar"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:491:1: ruleVariableOrDollar returns [EObject current=null] : (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar ) ;
    public final EObject ruleVariableOrDollar() throws RecognitionException {
        EObject current = null;

        EObject this_Variable_0 = null;

        EObject this_Dollar_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:497:6: ( (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:498:1: (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:498:1: (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==KEYWORD_9) ) {
                alt6=1;
            }
            else if ( (LA6_0==KEYWORD_8||LA6_0==KEYWORD_1) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:499:5: this_Variable_0= ruleVariable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVariableOrDollarAccess().getVariableParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariable_in_ruleVariableOrDollar897);
                    this_Variable_0=ruleVariable();

                    state._fsp--;


                            current = this_Variable_0;
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:509:5: this_Dollar_1= ruleDollar
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVariableOrDollarAccess().getDollarParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDollar_in_ruleVariableOrDollar924);
                    this_Dollar_1=ruleDollar();

                    state._fsp--;


                            current = this_Dollar_1;
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVariableOrDollar"


    // $ANTLR start "entryRuleVariable"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:528:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:532:2: (iv_ruleVariable= ruleVariable EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:533:2: iv_ruleVariable= ruleVariable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable968);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable978); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:543:1: ruleVariable returns [EObject current=null] : (otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7 ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_WS_1=null;
        Token this_WS_4=null;
        Token otherlv_5=null;
        Token this_WS_6=null;
        Token this_WS_8=null;
        Token otherlv_9=null;
        Token this_WS_10=null;
        Token lv_parameters_11_1=null;
        Token this_WS_12=null;
        Token otherlv_13=null;
        Token this_WS_14=null;
        Token lv_parameters_15_1=null;
        Token this_WS_16=null;
        Token otherlv_17=null;
        Token this_WS_18=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_type_7_0 = null;

        AntlrDatatypeRuleToken lv_parameters_11_2 = null;

        AntlrDatatypeRuleToken lv_parameters_15_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:549:6: ( (otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7 ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:550:1: (otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7 )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:550:1: (otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7 )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:551:2: otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7
            {
            otherlv_0=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleVariable1020); 

                	createLeafNode(otherlv_0, grammarAccess.getVariableAccess().getDollarSignLeftCurlyBracketKeyword_0(), null);
                
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:555:1: (this_WS_1= RULE_WS )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_WS) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:555:2: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1032); 
            	     
            	        createLeafNode(this_WS_1, grammarAccess.getVariableAccess().getWSTerminalRuleCall_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:559:3: ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) )
            int alt20=2;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:559:4: ( (lv_name_2_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:559:4: ( (lv_name_2_0= ruleValidID ) )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:560:1: (lv_name_2_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:560:1: (lv_name_2_0= ruleValidID )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:561:3: lv_name_2_0= ruleValidID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleValidID_in_ruleVariable1055);
                    lv_name_2_0=ruleValidID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_2_0, 
                    	        		"ValidID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:584:6: ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:584:6: ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:584:7: ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )?
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:584:7: ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=KEYWORD_12 && LA9_0<=KEYWORD_11)||LA9_0==RULE_ID) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:584:8: ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )*
                            {
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:584:8: ( (lv_name_3_0= ruleValidID ) )
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:585:1: (lv_name_3_0= ruleValidID )
                            {
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:585:1: (lv_name_3_0= ruleValidID )
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:586:3: lv_name_3_0= ruleValidID
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_1_0_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleValidID_in_ruleVariable1084);
                            lv_name_3_0=ruleValidID();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"name",
                            	        		lv_name_3_0, 
                            	        		"ValidID", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:608:2: (this_WS_4= RULE_WS )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==RULE_WS) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:608:3: this_WS_4= RULE_WS
                            	    {
                            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1096); 
                            	     
                            	        createLeafNode(this_WS_4, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1(), null); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleVariable1112); 

                        	createLeafNode(otherlv_5, grammarAccess.getVariableAccess().getColonKeyword_2_1_1(), null);
                        
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:617:1: (this_WS_6= RULE_WS )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_WS) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:617:2: this_WS_6= RULE_WS
                    	    {
                    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1124); 
                    	     
                    	        createLeafNode(this_WS_6, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2(), null); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:621:3: ( (lv_type_7_0= ruleValidID ) )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:622:1: (lv_type_7_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:622:1: (lv_type_7_0= ruleValidID )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:623:3: lv_type_7_0= ruleValidID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getTypeValidIDParserRuleCall_2_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleValidID_in_ruleVariable1146);
                    lv_type_7_0=ruleValidID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_7_0, 
                    	        		"ValidID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:645:2: ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )?
                    int alt19=2;
                    alt19 = dfa19.predict(input);
                    switch (alt19) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:645:3: (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3
                            {
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:645:3: (this_WS_8= RULE_WS )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==RULE_WS) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:645:4: this_WS_8= RULE_WS
                            	    {
                            	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1159); 
                            	     
                            	        createLeafNode(this_WS_8, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0(), null); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);

                            otherlv_9=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleVariable1173); 

                                	createLeafNode(otherlv_9, grammarAccess.getVariableAccess().getLeftParenthesisKeyword_2_1_4_1(), null);
                                
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:654:1: (this_WS_10= RULE_WS )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==RULE_WS) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:654:2: this_WS_10= RULE_WS
                            	    {
                            	    this_WS_10=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1185); 
                            	     
                            	        createLeafNode(this_WS_10, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2(), null); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop12;
                                }
                            } while (true);

                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:658:3: ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) )
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:659:1: ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) )
                            {
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:659:1: ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) )
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:660:1: (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN )
                            {
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:660:1: (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN )
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( (LA13_0==RULE_STRING) ) {
                                alt13=1;
                            }
                            else if ( ((LA13_0>=KEYWORD_12 && LA13_0<=KEYWORD_11)||LA13_0==RULE_ID) ) {
                                alt13=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 0, input);

                                throw nvae;
                            }
                            switch (alt13) {
                                case 1 :
                                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:661:3: lv_parameters_11_1= RULE_STRING
                                    {
                                    lv_parameters_11_1=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVariable1205); 

                                    			createLeafNode(lv_parameters_11_1, grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0(), "parameters"); 
                                    		

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        try {
                                    	       		add(
                                    	       			current, 
                                    	       			"parameters",
                                    	        		lv_parameters_11_1, 
                                    	        		"STRING", 
                                    	        		lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:682:8: lv_parameters_11_2= ruleFQN
                                    {
                                     
                                    	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_0_1(), currentNode); 
                                    	    
                                    pushFollow(FOLLOW_ruleFQN_in_ruleVariable1229);
                                    lv_parameters_11_2=ruleFQN();

                                    state._fsp--;


                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                                    	        }
                                    	        try {
                                    	       		add(
                                    	       			current, 
                                    	       			"parameters",
                                    	        		lv_parameters_11_2, 
                                    	        		"FQN", 
                                    	        		currentNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	        currentNode = currentNode.getParent();
                                    	    

                                    }
                                    break;

                            }


                            }


                            }

                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:706:2: ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )*
                            loop17:
                            do {
                                int alt17=2;
                                alt17 = dfa17.predict(input);
                                switch (alt17) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:706:3: (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) )
                            	    {
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:706:3: (this_WS_12= RULE_WS )*
                            	    loop14:
                            	    do {
                            	        int alt14=2;
                            	        int LA14_0 = input.LA(1);

                            	        if ( (LA14_0==RULE_WS) ) {
                            	            alt14=1;
                            	        }


                            	        switch (alt14) {
                            	    	case 1 :
                            	    	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:706:4: this_WS_12= RULE_WS
                            	    	    {
                            	    	    this_WS_12=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1245); 
                            	    	     
                            	    	        createLeafNode(this_WS_12, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_4_0(), null); 
                            	    	        

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    break loop14;
                            	        }
                            	    } while (true);

                            	    otherlv_13=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleVariable1259); 

                            	        	createLeafNode(otherlv_13, grammarAccess.getVariableAccess().getCommaKeyword_2_1_4_4_1(), null);
                            	        
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:715:1: (this_WS_14= RULE_WS )*
                            	    loop15:
                            	    do {
                            	        int alt15=2;
                            	        int LA15_0 = input.LA(1);

                            	        if ( (LA15_0==RULE_WS) ) {
                            	            alt15=1;
                            	        }


                            	        switch (alt15) {
                            	    	case 1 :
                            	    	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:715:2: this_WS_14= RULE_WS
                            	    	    {
                            	    	    this_WS_14=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1271); 
                            	    	     
                            	    	        createLeafNode(this_WS_14, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_4_2(), null); 
                            	    	        

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    break loop15;
                            	        }
                            	    } while (true);

                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:719:3: ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) )
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:720:1: ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) )
                            	    {
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:720:1: ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) )
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:721:1: (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN )
                            	    {
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:721:1: (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN )
                            	    int alt16=2;
                            	    int LA16_0 = input.LA(1);

                            	    if ( (LA16_0==RULE_STRING) ) {
                            	        alt16=1;
                            	    }
                            	    else if ( ((LA16_0>=KEYWORD_12 && LA16_0<=KEYWORD_11)||LA16_0==RULE_ID) ) {
                            	        alt16=2;
                            	    }
                            	    else {
                            	        NoViableAltException nvae =
                            	            new NoViableAltException("", 16, 0, input);

                            	        throw nvae;
                            	    }
                            	    switch (alt16) {
                            	        case 1 :
                            	            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:722:3: lv_parameters_15_1= RULE_STRING
                            	            {
                            	            lv_parameters_15_1=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVariable1291); 

                            	            			createLeafNode(lv_parameters_15_1, grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_4_3_0_0(), "parameters"); 
                            	            		

                            	            	        if (current==null) {
                            	            	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
                            	            	            associateNodeWithAstElement(currentNode, current);
                            	            	        }
                            	            	        try {
                            	            	       		add(
                            	            	       			current, 
                            	            	       			"parameters",
                            	            	        		lv_parameters_15_1, 
                            	            	        		"STRING", 
                            	            	        		lastConsumedNode);
                            	            	        } catch (ValueConverterException vce) {
                            	            				handleValueConverterException(vce);
                            	            	        }
                            	            	    

                            	            }
                            	            break;
                            	        case 2 :
                            	            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:743:8: lv_parameters_15_2= ruleFQN
                            	            {
                            	             
                            	            	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_4_3_0_1(), currentNode); 
                            	            	    
                            	            pushFollow(FOLLOW_ruleFQN_in_ruleVariable1315);
                            	            lv_parameters_15_2=ruleFQN();

                            	            state._fsp--;


                            	            	        if (current==null) {
                            	            	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
                            	            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	            	        }
                            	            	        try {
                            	            	       		add(
                            	            	       			current, 
                            	            	       			"parameters",
                            	            	        		lv_parameters_15_2, 
                            	            	        		"FQN", 
                            	            	        		currentNode);
                            	            	        } catch (ValueConverterException vce) {
                            	            				handleValueConverterException(vce);
                            	            	        }
                            	            	        currentNode = currentNode.getParent();
                            	            	    

                            	            }
                            	            break;

                            	    }


                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop17;
                                }
                            } while (true);

                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:767:4: (this_WS_16= RULE_WS )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==RULE_WS) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:767:5: this_WS_16= RULE_WS
                            	    {
                            	    this_WS_16=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1332); 
                            	     
                            	        createLeafNode(this_WS_16, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_5(), null); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop18;
                                }
                            } while (true);

                            otherlv_17=(Token)match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_ruleVariable1346); 

                                	createLeafNode(otherlv_17, grammarAccess.getVariableAccess().getRightParenthesisKeyword_2_1_4_6(), null);
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:776:5: (this_WS_18= RULE_WS )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_WS) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:776:6: this_WS_18= RULE_WS
            	    {
            	    this_WS_18=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1362); 
            	     
            	        createLeafNode(this_WS_18, grammarAccess.getVariableAccess().getWSTerminalRuleCall_3(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_19=(Token)match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_ruleVariable1376); 

                	createLeafNode(otherlv_19, grammarAccess.getVariableAccess().getRightCurlyBracketKeyword_4(), null);
                

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleValidID"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:796:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:800:1: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:801:2: iv_ruleValidID= ruleValidID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValidIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID1422);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID1433); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:811:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= KEYWORD_11 | kw= KEYWORD_12 ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:817:6: ( (this_ID_0= RULE_ID | kw= KEYWORD_11 | kw= KEYWORD_12 ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:818:1: (this_ID_0= RULE_ID | kw= KEYWORD_11 | kw= KEYWORD_12 )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:818:1: (this_ID_0= RULE_ID | kw= KEYWORD_11 | kw= KEYWORD_12 )
            int alt22=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt22=1;
                }
                break;
            case KEYWORD_11:
                {
                alt22=2;
                }
                break;
            case KEYWORD_12:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:818:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID1477); 

                    		current.merge(this_ID_0);
                        
                     
                        createLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:827:2: kw= KEYWORD_11
                    {
                    kw=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleValidID1501); 

                            current.merge(kw);
                            createLeafNode(kw, grammarAccess.getValidIDAccess().getForKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:834:2: kw= KEYWORD_12
                    {
                    kw=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleValidID1520); 

                            current.merge(kw);
                            createLeafNode(kw, grammarAccess.getValidIDAccess().getTemplatesKeyword_2(), null); 
                        

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:850:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:854:1: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:855:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1570);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1581); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:865:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:871:6: ( (this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:872:1: (this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:872:1: (this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:873:5: this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getFQNAccess().getValidIDParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleValidID_in_ruleFQN1632);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            		current.merge(this_ValidID_0);
                
             
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:883:1: (kw= KEYWORD_5 this_ValidID_2= ruleValidID )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==KEYWORD_5) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:884:2: kw= KEYWORD_5 this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleFQN1651); 

            	            current.merge(kw);
            	            createLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	     
            	            currentNode=createCompositeNode(grammarAccess.getFQNAccess().getValidIDParserRuleCall_1_1(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleValidID_in_ruleFQN1673);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    		current.merge(this_ValidID_2);
            	        
            	     
            	            currentNode = currentNode.getParent();
            	        

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:911:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:915:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:916:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1729);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1739); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:926:1: ruleLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleLiteralValue ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:932:6: ( ( (lv_value_0_0= ruleLiteralValue ) ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:933:1: ( (lv_value_0_0= ruleLiteralValue ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:933:1: ( (lv_value_0_0= ruleLiteralValue ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:934:1: (lv_value_0_0= ruleLiteralValue )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:934:1: (lv_value_0_0= ruleLiteralValue )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:935:3: lv_value_0_0= ruleLiteralValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getValueLiteralValueParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleLiteralValue_in_ruleLiteral1788);
            lv_value_0_0=ruleLiteralValue();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLiteralRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"LiteralValue", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleDollar"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:968:1: entryRuleDollar returns [EObject current=null] : iv_ruleDollar= ruleDollar EOF ;
    public final EObject entryRuleDollar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDollar = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:972:2: (iv_ruleDollar= ruleDollar EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:973:2: iv_ruleDollar= ruleDollar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDollarRule(), currentNode); 
            pushFollow(FOLLOW_ruleDollar_in_entryRuleDollar1832);
            iv_ruleDollar=ruleDollar();

            state._fsp--;

             current =iv_ruleDollar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDollar1842); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDollar"


    // $ANTLR start "ruleDollar"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:983:1: ruleDollar returns [EObject current=null] : ( () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 ) ) ;
    public final EObject ruleDollar() throws RecognitionException {
        EObject current = null;

        Token lv_escaped_1_0=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:989:6: ( ( () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:990:1: ( () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:990:1: ( () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:990:2: () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:990:2: ()
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:991:5: 
            {
             
                    temp=factory.create(grammarAccess.getDollarAccess().getDollarAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getDollarAccess().getDollarAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:1001:2: ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==KEYWORD_8) ) {
                alt24=1;
            }
            else if ( (LA24_0==KEYWORD_1) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:1001:3: ( (lv_escaped_1_0= KEYWORD_8 ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:1001:3: ( (lv_escaped_1_0= KEYWORD_8 ) )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:1002:1: (lv_escaped_1_0= KEYWORD_8 )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:1002:1: (lv_escaped_1_0= KEYWORD_8 )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:1003:3: lv_escaped_1_0= KEYWORD_8
                    {
                    lv_escaped_1_0=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleDollar1900); 

                            createLeafNode(lv_escaped_1_0, grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0(), "escaped");
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getDollarRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "escaped", true, "$$", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalSingleCodetemplateParser.g:1025:2: otherlv_2= KEYWORD_1
                    {
                    otherlv_2=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleDollar1932); 

                        	createLeafNode(otherlv_2, grammarAccess.getDollarAccess().getDollarSignKeyword_1_1(), null);
                        

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDollar"

    // Delegated rules


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA20_eotS =
        "\7\uffff";
    static final String DFA20_eofS =
        "\7\uffff";
    static final String DFA20_minS =
        "\1\4\3\16\1\uffff\1\16\1\uffff";
    static final String DFA20_maxS =
        "\1\20\3\22\1\uffff\1\22\1\uffff";
    static final String DFA20_acceptS =
        "\4\uffff\1\2\1\uffff\1\1";
    static final String DFA20_specialS =
        "\7\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\3\1\2\10\uffff\1\4\1\uffff\1\1",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "",
            "\1\4\1\6\2\uffff\1\5",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "559:3: ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) )";
        }
    }
    static final String DFA19_eotS =
        "\4\uffff";
    static final String DFA19_eofS =
        "\4\uffff";
    static final String DFA19_minS =
        "\2\12\2\uffff";
    static final String DFA19_maxS =
        "\2\22\2\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA19_specialS =
        "\4\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "645:2: ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )?";
        }
    }
    static final String DFA17_eotS =
        "\4\uffff";
    static final String DFA17_eofS =
        "\4\uffff";
    static final String DFA17_minS =
        "\2\13\2\uffff";
    static final String DFA17_maxS =
        "\2\22\2\uffff";
    static final String DFA17_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA17_specialS =
        "\4\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\2\1\3\5\uffff\1\1",
            "\1\2\1\3\5\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "()* loopback of 706:2: ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleCodetemplates_in_entryRuleCodetemplates67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodetemplates77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleCodetemplates115 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleCodetemplates128 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleCodetemplates151 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleCodetemplate_in_ruleCodetemplates172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodetemplate_in_entryRuleCodetemplate207 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodetemplate217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCodetemplate259 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleCodetemplate277 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleCodetemplate301 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCodetemplate324 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleTemplateBodyWithQuotes_in_ruleCodetemplate351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTemplateBodyWithQuotes_in_entryRuleTemplateBodyWithQuotes392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBodyWithQuotes402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleTemplateBodyWithQuotes444 = new BitSet(new long[]{0x00000000000D02C0L});
    public static final BitSet FOLLOW_ruleTemplateBody_in_ruleTemplateBodyWithQuotes466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue511 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralValue522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleLiteralValue566 = new BitSet(new long[]{0x00000000000D0002L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_ruleLiteralValue592 = new BitSet(new long[]{0x00000000000D0002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLiteralValue618 = new BitSet(new long[]{0x00000000000D0002L});
    public static final BitSet FOLLOW_ruleTemplateBody_in_entryRuleTemplateBody673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBody683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleTemplateBody742 = new BitSet(new long[]{0x00000000000002C2L});
    public static final BitSet FOLLOW_ruleVariableOrDollar_in_ruleTemplateBody765 = new BitSet(new long[]{0x00000000000D02C2L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleTemplateBody786 = new BitSet(new long[]{0x00000000000002C2L});
    public static final BitSet FOLLOW_ruleVariableOrDollar_in_entryRuleVariableOrDollar836 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableOrDollar846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleVariableOrDollar897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDollar_in_ruleVariableOrDollar924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleVariable1020 = new BitSet(new long[]{0x0000000000054030L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1032 = new BitSet(new long[]{0x0000000000054030L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleVariable1055 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleVariable1084 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1096 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleVariable1112 = new BitSet(new long[]{0x0000000000050030L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1124 = new BitSet(new long[]{0x0000000000050030L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleVariable1146 = new BitSet(new long[]{0x0000000000048400L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1159 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleVariable1173 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1185 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVariable1205 = new BitSet(new long[]{0x0000000000041800L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleVariable1229 = new BitSet(new long[]{0x0000000000041800L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1245 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleVariable1259 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1271 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVariable1291 = new BitSet(new long[]{0x0000000000041800L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleVariable1315 = new BitSet(new long[]{0x0000000000041800L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1332 = new BitSet(new long[]{0x0000000000040800L});
    public static final BitSet FOLLOW_KEYWORD_3_in_ruleVariable1346 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1362 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_KEYWORD_7_in_ruleVariable1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID1422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID1477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleValidID1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleValidID1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFQN1632 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleFQN1651 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFQN1673 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_ruleLiteral1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDollar_in_entryRuleDollar1832 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDollar1842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleDollar1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleDollar1932 = new BitSet(new long[]{0x0000000000000002L});

}
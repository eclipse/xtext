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
import org.eclipse.xtext.ui.codetemplates.services.CodetemplatesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCodetemplatesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_14", "KEYWORD_12", "KEYWORD_13", "KEYWORD_8", "KEYWORD_9", "KEYWORD_10", "KEYWORD_11", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "KEYWORD_5", "KEYWORD_6", "KEYWORD_7", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int KEYWORD_7=17;
    public static final int RULE_ID=18;
    public static final int KEYWORD_10=9;
    public static final int KEYWORD_1=11;
    public static final int RULE_STRING=19;
    public static final int KEYWORD_9=8;
    public static final int KEYWORD_2=12;
    public static final int KEYWORD_11=10;
    public static final int KEYWORD_4=14;
    public static final int RULE_WS=20;
    public static final int EOF=-1;
    public static final int KEYWORD_13=6;
    public static final int KEYWORD_14=4;
    public static final int KEYWORD_5=15;
    public static final int KEYWORD_6=16;
    public static final int RULE_ANY_OTHER=21;
    public static final int KEYWORD_12=5;
    public static final int KEYWORD_8=7;
    public static final int KEYWORD_3=13;

    // delegates
    // delegators


        public InternalCodetemplatesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCodetemplatesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCodetemplatesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g"; }




     	private CodetemplatesGrammarAccess grammarAccess;
     	
        public InternalCodetemplatesParser(TokenStream input, IAstFactory factory, CodetemplatesGrammarAccess grammarAccess) {
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
       	protected CodetemplatesGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleCodetemplates"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:65:1: entryRuleCodetemplates returns [EObject current=null] : iv_ruleCodetemplates= ruleCodetemplates EOF ;
    public final EObject entryRuleCodetemplates() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodetemplates = null;


        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:66:2: (iv_ruleCodetemplates= ruleCodetemplates EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:67:2: iv_ruleCodetemplates= ruleCodetemplates EOF
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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:74:1: ruleCodetemplates returns [EObject current=null] : (otherlv_0= KEYWORD_14 otherlv_1= KEYWORD_13 ( ( ruleFQN ) ) otherlv_3= KEYWORD_6 ( (lv_templates_4_0= ruleCodetemplate ) )* ) ;
    public final EObject ruleCodetemplates() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_templates_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:79:6: ( (otherlv_0= KEYWORD_14 otherlv_1= KEYWORD_13 ( ( ruleFQN ) ) otherlv_3= KEYWORD_6 ( (lv_templates_4_0= ruleCodetemplate ) )* ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:80:1: (otherlv_0= KEYWORD_14 otherlv_1= KEYWORD_13 ( ( ruleFQN ) ) otherlv_3= KEYWORD_6 ( (lv_templates_4_0= ruleCodetemplate ) )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:80:1: (otherlv_0= KEYWORD_14 otherlv_1= KEYWORD_13 ( ( ruleFQN ) ) otherlv_3= KEYWORD_6 ( (lv_templates_4_0= ruleCodetemplate ) )* )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:81:2: otherlv_0= KEYWORD_14 otherlv_1= KEYWORD_13 ( ( ruleFQN ) ) otherlv_3= KEYWORD_6 ( (lv_templates_4_0= ruleCodetemplate ) )*
            {
            otherlv_0=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleCodetemplates115); 

                	createLeafNode(otherlv_0, grammarAccess.getCodetemplatesAccess().getTemplatesKeyword_0(), null);
                
            otherlv_1=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleCodetemplates128); 

                	createLeafNode(otherlv_1, grammarAccess.getCodetemplatesAccess().getForKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:90:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:91:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:91:1: ( ruleFQN )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:92:3: ruleFQN
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

            otherlv_3=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleCodetemplates164); 

                	createLeafNode(otherlv_3, grammarAccess.getCodetemplatesAccess().getColonKeyword_3(), null);
                
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:111:1: ( (lv_templates_4_0= ruleCodetemplate ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==KEYWORD_14||LA1_0==KEYWORD_13||LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:112:1: (lv_templates_4_0= ruleCodetemplate )
            	    {
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:112:1: (lv_templates_4_0= ruleCodetemplate )
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:113:3: lv_templates_4_0= ruleCodetemplate
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getCodetemplatesAccess().getTemplatesCodetemplateParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleCodetemplate_in_ruleCodetemplates185);
            	    lv_templates_4_0=ruleCodetemplate();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getCodetemplatesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"templates",
            	    	        		lv_templates_4_0, 
            	    	        		"Codetemplate", 
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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:143:1: entryRuleCodetemplate returns [EObject current=null] : iv_ruleCodetemplate= ruleCodetemplate EOF ;
    public final EObject entryRuleCodetemplate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodetemplate = null;


        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:144:2: (iv_ruleCodetemplate= ruleCodetemplate EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:145:2: iv_ruleCodetemplate= ruleCodetemplate EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCodetemplateRule(), currentNode); 
            pushFollow(FOLLOW_ruleCodetemplate_in_entryRuleCodetemplate221);
            iv_ruleCodetemplate=ruleCodetemplate();

            state._fsp--;

             current =iv_ruleCodetemplate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodetemplate231); 

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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:152:1: ruleCodetemplate returns [EObject current=null] : ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= KEYWORD_2 ( (lv_id_2_0= RULE_ID ) ) otherlv_3= KEYWORD_4 ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= KEYWORD_3 otherlv_6= KEYWORD_13 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) ) ) ;
    public final EObject ruleCodetemplate() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_id_2_0=null;
        Token otherlv_3=null;
        Token lv_description_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_keywordContext_8_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_body_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:157:6: ( ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= KEYWORD_2 ( (lv_id_2_0= RULE_ID ) ) otherlv_3= KEYWORD_4 ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= KEYWORD_3 otherlv_6= KEYWORD_13 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) ) ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:158:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= KEYWORD_2 ( (lv_id_2_0= RULE_ID ) ) otherlv_3= KEYWORD_4 ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= KEYWORD_3 otherlv_6= KEYWORD_13 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:158:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= KEYWORD_2 ( (lv_id_2_0= RULE_ID ) ) otherlv_3= KEYWORD_4 ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= KEYWORD_3 otherlv_6= KEYWORD_13 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:158:2: ( (lv_name_0_0= ruleValidID ) ) otherlv_1= KEYWORD_2 ( (lv_id_2_0= RULE_ID ) ) otherlv_3= KEYWORD_4 ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= KEYWORD_3 otherlv_6= KEYWORD_13 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:158:2: ( (lv_name_0_0= ruleValidID ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:159:1: (lv_name_0_0= ruleValidID )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:159:1: (lv_name_0_0= ruleValidID )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:160:3: lv_name_0_0= ruleValidID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCodetemplateAccess().getNameValidIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleValidID_in_ruleCodetemplate277);
            lv_name_0_0=ruleValidID();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCodetemplateRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ValidID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            otherlv_1=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleCodetemplate290); 

                	createLeafNode(otherlv_1, grammarAccess.getCodetemplateAccess().getLeftParenthesisKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:187:1: ( (lv_id_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:188:1: (lv_id_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:188:1: (lv_id_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:189:3: lv_id_2_0= RULE_ID
            {
            lv_id_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCodetemplate307); 

            			createLeafNode(lv_id_2_0, grammarAccess.getCodetemplateAccess().getIdIDTerminalRuleCall_2_0(), "id"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCodetemplateRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"id",
            	        		lv_id_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleCodetemplate325); 

                	createLeafNode(otherlv_3, grammarAccess.getCodetemplateAccess().getCommaKeyword_3(), null);
                
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:216:1: ( (lv_description_4_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:217:1: (lv_description_4_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:217:1: (lv_description_4_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:218:3: lv_description_4_0= RULE_STRING
            {
            lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCodetemplate342); 

            			createLeafNode(lv_description_4_0, grammarAccess.getCodetemplateAccess().getDescriptionSTRINGTerminalRuleCall_4_0(), "description"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCodetemplateRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"description",
            	        		lv_description_4_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_5=(Token)match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_ruleCodetemplate360); 

                	createLeafNode(otherlv_5, grammarAccess.getCodetemplateAccess().getRightParenthesisKeyword_5(), null);
                
            otherlv_6=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleCodetemplate373); 

                	createLeafNode(otherlv_6, grammarAccess.getCodetemplateAccess().getForKeyword_6(), null);
                
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:250:1: ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==KEYWORD_14||LA2_0==KEYWORD_13||LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_STRING) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:250:2: ( ( ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:250:2: ( ( ruleValidID ) )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:251:1: ( ruleValidID )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:251:1: ( ruleValidID )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:252:3: ruleValidID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getCodetemplateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_7_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleValidID_in_ruleCodetemplate397);
                    ruleValidID();

                    state._fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:267:6: ( (lv_keywordContext_8_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:267:6: ( (lv_keywordContext_8_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:268:1: (lv_keywordContext_8_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:268:1: (lv_keywordContext_8_0= RULE_STRING )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:269:3: lv_keywordContext_8_0= RULE_STRING
                    {
                    lv_keywordContext_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCodetemplate420); 

                    			createLeafNode(lv_keywordContext_8_0, grammarAccess.getCodetemplateAccess().getKeywordContextSTRINGTerminalRuleCall_7_1_0(), "keywordContext"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCodetemplateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"keywordContext",
                    	        		lv_keywordContext_8_0, 
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

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:291:3: ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:292:1: (lv_body_9_0= ruleTemplateBodyWithQuotes )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:292:1: (lv_body_9_0= ruleTemplateBodyWithQuotes )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:293:3: lv_body_9_0= ruleTemplateBodyWithQuotes
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCodetemplateAccess().getBodyTemplateBodyWithQuotesParserRuleCall_8_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTemplateBodyWithQuotes_in_ruleCodetemplate447);
            lv_body_9_0=ruleTemplateBodyWithQuotes();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCodetemplateRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"body",
            	        		lv_body_9_0, 
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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:323:1: entryRuleTemplateBodyWithQuotes returns [EObject current=null] : iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF ;
    public final EObject entryRuleTemplateBodyWithQuotes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBodyWithQuotes = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:327:2: (iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:328:2: iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTemplateBodyWithQuotesRule(), currentNode); 
            pushFollow(FOLLOW_ruleTemplateBodyWithQuotes_in_entryRuleTemplateBodyWithQuotes488);
            iv_ruleTemplateBodyWithQuotes=ruleTemplateBodyWithQuotes();

            state._fsp--;

             current =iv_ruleTemplateBodyWithQuotes; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTemplateBodyWithQuotes498); 

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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:338:1: ruleTemplateBodyWithQuotes returns [EObject current=null] : ( (this_WS_0= RULE_WS )? otherlv_1= KEYWORD_11 this_TemplateBody_2= ruleTemplateBody otherlv_3= KEYWORD_10 ) ;
    public final EObject ruleTemplateBodyWithQuotes() throws RecognitionException {
        EObject current = null;

        Token this_WS_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_TemplateBody_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:344:6: ( ( (this_WS_0= RULE_WS )? otherlv_1= KEYWORD_11 this_TemplateBody_2= ruleTemplateBody otherlv_3= KEYWORD_10 ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:345:1: ( (this_WS_0= RULE_WS )? otherlv_1= KEYWORD_11 this_TemplateBody_2= ruleTemplateBody otherlv_3= KEYWORD_10 )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:345:1: ( (this_WS_0= RULE_WS )? otherlv_1= KEYWORD_11 this_TemplateBody_2= ruleTemplateBody otherlv_3= KEYWORD_10 )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:345:2: (this_WS_0= RULE_WS )? otherlv_1= KEYWORD_11 this_TemplateBody_2= ruleTemplateBody otherlv_3= KEYWORD_10
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:345:2: (this_WS_0= RULE_WS )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:345:3: this_WS_0= RULE_WS
                    {
                    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleTemplateBodyWithQuotes539); 
                     
                        createLeafNode(this_WS_0, grammarAccess.getTemplateBodyWithQuotesAccess().getWSTerminalRuleCall_0(), null); 
                        

                    }
                    break;

            }

            otherlv_1=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleTemplateBodyWithQuotes553); 

                	createLeafNode(otherlv_1, grammarAccess.getTemplateBodyWithQuotesAccess().getGreaterThanSignGreaterThanSignKeyword_1(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getTemplateBodyWithQuotesAccess().getTemplateBodyParserRuleCall_2(), currentNode); 
                
            pushFollow(FOLLOW_ruleTemplateBody_in_ruleTemplateBodyWithQuotes575);
            this_TemplateBody_2=ruleTemplateBody();

            state._fsp--;


                    current = this_TemplateBody_2;
                    currentNode = currentNode.getParent();
                
            otherlv_3=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleTemplateBodyWithQuotes587); 

                	createLeafNode(otherlv_3, grammarAccess.getTemplateBodyWithQuotesAccess().getLessThanSignLessThanSignKeyword_3(), null);
                

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


    // $ANTLR start "entryRuleTemplateBody"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:379:1: entryRuleTemplateBody returns [EObject current=null] : iv_ruleTemplateBody= ruleTemplateBody EOF ;
    public final EObject entryRuleTemplateBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBody = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:383:2: (iv_ruleTemplateBody= ruleTemplateBody EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:384:2: iv_ruleTemplateBody= ruleTemplateBody EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTemplateBodyRule(), currentNode); 
            pushFollow(FOLLOW_ruleTemplateBody_in_entryRuleTemplateBody632);
            iv_ruleTemplateBody=ruleTemplateBody();

            state._fsp--;

             current =iv_ruleTemplateBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTemplateBody642); 

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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:394:1: ruleTemplateBody returns [EObject current=null] : ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* ) ;
    public final EObject ruleTemplateBody() throws RecognitionException {
        EObject current = null;

        EObject lv_parts_1_0 = null;

        EObject lv_parts_2_0 = null;

        EObject lv_parts_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:400:6: ( ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:401:1: ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:401:1: ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:401:2: () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )*
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:401:2: ()
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:402:5: 
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

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:412:2: ( (lv_parts_1_0= ruleLiteral ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==KEYWORD_12||LA4_0==RULE_ID||(LA4_0>=RULE_WS && LA4_0<=RULE_ANY_OTHER)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:413:1: (lv_parts_1_0= ruleLiteral )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:413:1: (lv_parts_1_0= ruleLiteral )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:414:3: lv_parts_1_0= ruleLiteral
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLiteral_in_ruleTemplateBody701);
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

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:436:3: ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=KEYWORD_8 && LA6_0<=KEYWORD_9)||LA6_0==KEYWORD_1) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:436:4: ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )?
            	    {
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:436:4: ( (lv_parts_2_0= ruleVariableOrDollar ) )
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:437:1: (lv_parts_2_0= ruleVariableOrDollar )
            	    {
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:437:1: (lv_parts_2_0= ruleVariableOrDollar )
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:438:3: lv_parts_2_0= ruleVariableOrDollar
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsVariableOrDollarParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleVariableOrDollar_in_ruleTemplateBody724);
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

            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:460:2: ( (lv_parts_3_0= ruleLiteral ) )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==KEYWORD_12||LA5_0==RULE_ID||(LA5_0>=RULE_WS && LA5_0<=RULE_ANY_OTHER)) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:461:1: (lv_parts_3_0= ruleLiteral )
            	            {
            	            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:461:1: (lv_parts_3_0= ruleLiteral )
            	            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:462:3: lv_parts_3_0= ruleLiteral
            	            {
            	             
            	            	        currentNode=createCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_2_1_0(), currentNode); 
            	            	    
            	            pushFollow(FOLLOW_ruleLiteral_in_ruleTemplateBody745);
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
            	    break loop6;
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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:497:1: entryRuleVariableOrDollar returns [EObject current=null] : iv_ruleVariableOrDollar= ruleVariableOrDollar EOF ;
    public final EObject entryRuleVariableOrDollar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableOrDollar = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:501:2: (iv_ruleVariableOrDollar= ruleVariableOrDollar EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:502:2: iv_ruleVariableOrDollar= ruleVariableOrDollar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableOrDollarRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableOrDollar_in_entryRuleVariableOrDollar795);
            iv_ruleVariableOrDollar=ruleVariableOrDollar();

            state._fsp--;

             current =iv_ruleVariableOrDollar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableOrDollar805); 

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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:512:1: ruleVariableOrDollar returns [EObject current=null] : (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar ) ;
    public final EObject ruleVariableOrDollar() throws RecognitionException {
        EObject current = null;

        EObject this_Variable_0 = null;

        EObject this_Dollar_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:518:6: ( (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:519:1: (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:519:1: (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==KEYWORD_9) ) {
                alt7=1;
            }
            else if ( (LA7_0==KEYWORD_8||LA7_0==KEYWORD_1) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:520:5: this_Variable_0= ruleVariable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVariableOrDollarAccess().getVariableParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariable_in_ruleVariableOrDollar856);
                    this_Variable_0=ruleVariable();

                    state._fsp--;


                            current = this_Variable_0;
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:530:5: this_Dollar_1= ruleDollar
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getVariableOrDollarAccess().getDollarParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDollar_in_ruleVariableOrDollar883);
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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:549:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:553:2: (iv_ruleVariable= ruleVariable EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:554:2: iv_ruleVariable= ruleVariable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable927);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable937); 

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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:564:1: ruleVariable returns [EObject current=null] : (otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7 ) ;
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
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:570:6: ( (otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7 ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:571:1: (otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7 )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:571:1: (otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7 )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:572:2: otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7
            {
            otherlv_0=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleVariable979); 

                	createLeafNode(otherlv_0, grammarAccess.getVariableAccess().getDollarSignLeftCurlyBracketKeyword_0(), null);
                
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:576:1: (this_WS_1= RULE_WS )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_WS) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:576:2: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable991); 
            	     
            	        createLeafNode(this_WS_1, grammarAccess.getVariableAccess().getWSTerminalRuleCall_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:580:3: ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) )
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:580:4: ( (lv_name_2_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:580:4: ( (lv_name_2_0= ruleValidID ) )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:581:1: (lv_name_2_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:581:1: (lv_name_2_0= ruleValidID )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:582:3: lv_name_2_0= ruleValidID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleValidID_in_ruleVariable1014);
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
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:605:6: ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:605:6: ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:605:7: ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )?
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:605:7: ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==KEYWORD_14||LA10_0==KEYWORD_13||LA10_0==RULE_ID) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:605:8: ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )*
                            {
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:605:8: ( (lv_name_3_0= ruleValidID ) )
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:606:1: (lv_name_3_0= ruleValidID )
                            {
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:606:1: (lv_name_3_0= ruleValidID )
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:607:3: lv_name_3_0= ruleValidID
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_1_0_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleValidID_in_ruleVariable1043);
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

                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:629:2: (this_WS_4= RULE_WS )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==RULE_WS) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:629:3: this_WS_4= RULE_WS
                            	    {
                            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1055); 
                            	     
                            	        createLeafNode(this_WS_4, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1(), null); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop9;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleVariable1071); 

                        	createLeafNode(otherlv_5, grammarAccess.getVariableAccess().getColonKeyword_2_1_1(), null);
                        
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:638:1: (this_WS_6= RULE_WS )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_WS) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:638:2: this_WS_6= RULE_WS
                    	    {
                    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1083); 
                    	     
                    	        createLeafNode(this_WS_6, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2(), null); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:642:3: ( (lv_type_7_0= ruleValidID ) )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:643:1: (lv_type_7_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:643:1: (lv_type_7_0= ruleValidID )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:644:3: lv_type_7_0= ruleValidID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getTypeValidIDParserRuleCall_2_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleValidID_in_ruleVariable1105);
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

                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:666:2: ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )?
                    int alt20=2;
                    alt20 = dfa20.predict(input);
                    switch (alt20) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:666:3: (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3
                            {
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:666:3: (this_WS_8= RULE_WS )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==RULE_WS) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:666:4: this_WS_8= RULE_WS
                            	    {
                            	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1118); 
                            	     
                            	        createLeafNode(this_WS_8, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0(), null); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop12;
                                }
                            } while (true);

                            otherlv_9=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleVariable1132); 

                                	createLeafNode(otherlv_9, grammarAccess.getVariableAccess().getLeftParenthesisKeyword_2_1_4_1(), null);
                                
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:675:1: (this_WS_10= RULE_WS )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==RULE_WS) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:675:2: this_WS_10= RULE_WS
                            	    {
                            	    this_WS_10=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1144); 
                            	     
                            	        createLeafNode(this_WS_10, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2(), null); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);

                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:679:3: ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) )
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:680:1: ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) )
                            {
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:680:1: ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) )
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:681:1: (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN )
                            {
                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:681:1: (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN )
                            int alt14=2;
                            int LA14_0 = input.LA(1);

                            if ( (LA14_0==RULE_STRING) ) {
                                alt14=1;
                            }
                            else if ( (LA14_0==KEYWORD_14||LA14_0==KEYWORD_13||LA14_0==RULE_ID) ) {
                                alt14=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 0, input);

                                throw nvae;
                            }
                            switch (alt14) {
                                case 1 :
                                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:682:3: lv_parameters_11_1= RULE_STRING
                                    {
                                    lv_parameters_11_1=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVariable1164); 

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
                                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:703:8: lv_parameters_11_2= ruleFQN
                                    {
                                     
                                    	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_0_1(), currentNode); 
                                    	    
                                    pushFollow(FOLLOW_ruleFQN_in_ruleVariable1188);
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

                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:727:2: ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )*
                            loop18:
                            do {
                                int alt18=2;
                                alt18 = dfa18.predict(input);
                                switch (alt18) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:727:3: (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) )
                            	    {
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:727:3: (this_WS_12= RULE_WS )*
                            	    loop15:
                            	    do {
                            	        int alt15=2;
                            	        int LA15_0 = input.LA(1);

                            	        if ( (LA15_0==RULE_WS) ) {
                            	            alt15=1;
                            	        }


                            	        switch (alt15) {
                            	    	case 1 :
                            	    	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:727:4: this_WS_12= RULE_WS
                            	    	    {
                            	    	    this_WS_12=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1204); 
                            	    	     
                            	    	        createLeafNode(this_WS_12, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_4_0(), null); 
                            	    	        

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    break loop15;
                            	        }
                            	    } while (true);

                            	    otherlv_13=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleVariable1218); 

                            	        	createLeafNode(otherlv_13, grammarAccess.getVariableAccess().getCommaKeyword_2_1_4_4_1(), null);
                            	        
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:736:1: (this_WS_14= RULE_WS )*
                            	    loop16:
                            	    do {
                            	        int alt16=2;
                            	        int LA16_0 = input.LA(1);

                            	        if ( (LA16_0==RULE_WS) ) {
                            	            alt16=1;
                            	        }


                            	        switch (alt16) {
                            	    	case 1 :
                            	    	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:736:2: this_WS_14= RULE_WS
                            	    	    {
                            	    	    this_WS_14=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1230); 
                            	    	     
                            	    	        createLeafNode(this_WS_14, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_4_2(), null); 
                            	    	        

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    break loop16;
                            	        }
                            	    } while (true);

                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:740:3: ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) )
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:741:1: ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) )
                            	    {
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:741:1: ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) )
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:742:1: (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN )
                            	    {
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:742:1: (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN )
                            	    int alt17=2;
                            	    int LA17_0 = input.LA(1);

                            	    if ( (LA17_0==RULE_STRING) ) {
                            	        alt17=1;
                            	    }
                            	    else if ( (LA17_0==KEYWORD_14||LA17_0==KEYWORD_13||LA17_0==RULE_ID) ) {
                            	        alt17=2;
                            	    }
                            	    else {
                            	        NoViableAltException nvae =
                            	            new NoViableAltException("", 17, 0, input);

                            	        throw nvae;
                            	    }
                            	    switch (alt17) {
                            	        case 1 :
                            	            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:743:3: lv_parameters_15_1= RULE_STRING
                            	            {
                            	            lv_parameters_15_1=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVariable1250); 

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
                            	            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:764:8: lv_parameters_15_2= ruleFQN
                            	            {
                            	             
                            	            	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_4_3_0_1(), currentNode); 
                            	            	    
                            	            pushFollow(FOLLOW_ruleFQN_in_ruleVariable1274);
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
                            	    break loop18;
                                }
                            } while (true);

                            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:788:4: (this_WS_16= RULE_WS )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==RULE_WS) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:788:5: this_WS_16= RULE_WS
                            	    {
                            	    this_WS_16=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1291); 
                            	     
                            	        createLeafNode(this_WS_16, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_5(), null); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop19;
                                }
                            } while (true);

                            otherlv_17=(Token)match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_ruleVariable1305); 

                                	createLeafNode(otherlv_17, grammarAccess.getVariableAccess().getRightParenthesisKeyword_2_1_4_6(), null);
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:797:5: (this_WS_18= RULE_WS )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_WS) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:797:6: this_WS_18= RULE_WS
            	    {
            	    this_WS_18=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1321); 
            	     
            	        createLeafNode(this_WS_18, grammarAccess.getVariableAccess().getWSTerminalRuleCall_3(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_19=(Token)match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_ruleVariable1335); 

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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:817:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:821:1: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:822:2: iv_ruleValidID= ruleValidID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValidIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID1381);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID1392); 

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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:832:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= KEYWORD_13 | kw= KEYWORD_14 ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:838:6: ( (this_ID_0= RULE_ID | kw= KEYWORD_13 | kw= KEYWORD_14 ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:839:1: (this_ID_0= RULE_ID | kw= KEYWORD_13 | kw= KEYWORD_14 )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:839:1: (this_ID_0= RULE_ID | kw= KEYWORD_13 | kw= KEYWORD_14 )
            int alt23=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt23=1;
                }
                break;
            case KEYWORD_13:
                {
                alt23=2;
                }
                break;
            case KEYWORD_14:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:839:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID1436); 

                    		current.merge(this_ID_0);
                        
                     
                        createLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:848:2: kw= KEYWORD_13
                    {
                    kw=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleValidID1460); 

                            current.merge(kw);
                            createLeafNode(kw, grammarAccess.getValidIDAccess().getForKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:855:2: kw= KEYWORD_14
                    {
                    kw=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleValidID1479); 

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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:871:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:875:1: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:876:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1529);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1540); 

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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:886:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:892:6: ( (this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:893:1: (this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:893:1: (this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:894:5: this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getFQNAccess().getValidIDParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleValidID_in_ruleFQN1591);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            		current.merge(this_ValidID_0);
                
             
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:904:1: (kw= KEYWORD_5 this_ValidID_2= ruleValidID )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==KEYWORD_5) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:905:2: kw= KEYWORD_5 this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleFQN1610); 

            	            current.merge(kw);
            	            createLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	     
            	            currentNode=createCompositeNode(grammarAccess.getFQNAccess().getValidIDParserRuleCall_1_1(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleValidID_in_ruleFQN1632);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    		current.merge(this_ValidID_2);
            	        
            	     
            	            currentNode = currentNode.getParent();
            	        

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:932:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:936:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:937:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1688);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1698); 

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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:947:1: ruleLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleLiteralValue ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:953:6: ( ( (lv_value_0_0= ruleLiteralValue ) ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:954:1: ( (lv_value_0_0= ruleLiteralValue ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:954:1: ( (lv_value_0_0= ruleLiteralValue ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:955:1: (lv_value_0_0= ruleLiteralValue )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:955:1: (lv_value_0_0= ruleLiteralValue )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:956:3: lv_value_0_0= ruleLiteralValue
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getValueLiteralValueParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleLiteralValue_in_ruleLiteral1747);
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


    // $ANTLR start "entryRuleLiteralValue"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:989:1: entryRuleLiteralValue returns [String current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final String entryRuleLiteralValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteralValue = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:993:1: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:994:2: iv_ruleLiteralValue= ruleLiteralValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue1792);
            iv_ruleLiteralValue=ruleLiteralValue();

            state._fsp--;

             current =iv_ruleLiteralValue.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralValue1803); 

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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1004:1: ruleLiteralValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID | kw= KEYWORD_12 )+ ;
    public final AntlrDatatypeRuleToken ruleLiteralValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token this_ANY_OTHER_1=null;
        Token this_ID_2=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1010:6: ( (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID | kw= KEYWORD_12 )+ )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1011:1: (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID | kw= KEYWORD_12 )+
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1011:1: (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID | kw= KEYWORD_12 )+
            int cnt25=0;
            loop25:
            do {
                int alt25=5;
                switch ( input.LA(1) ) {
                case RULE_WS:
                    {
                    alt25=1;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt25=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt25=3;
                    }
                    break;
                case KEYWORD_12:
                    {
                    alt25=4;
                    }
                    break;

                }

                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1011:6: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleLiteralValue1847); 

            	    		current.merge(this_WS_0);
            	        
            	     
            	        createLeafNode(this_WS_0, grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0(), null); 
            	        

            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1019:10: this_ANY_OTHER_1= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_1=(Token)match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_ruleLiteralValue1873); 

            	    		current.merge(this_ANY_OTHER_1);
            	        
            	     
            	        createLeafNode(this_ANY_OTHER_1, grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1(), null); 
            	        

            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1027:10: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLiteralValue1899); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(this_ID_2, grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2(), null); 
            	        

            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1036:2: kw= KEYWORD_12
            	    {
            	    kw=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleLiteralValue1923); 

            	            current.merge(kw);
            	            createLeafNode(kw, grammarAccess.getLiteralValueAccess().getReverseSolidusLessThanSignLessThanSignKeyword_3(), null); 
            	        

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


    // $ANTLR start "entryRuleDollar"
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1052:1: entryRuleDollar returns [EObject current=null] : iv_ruleDollar= ruleDollar EOF ;
    public final EObject entryRuleDollar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDollar = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1056:2: (iv_ruleDollar= ruleDollar EOF )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1057:2: iv_ruleDollar= ruleDollar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDollarRule(), currentNode); 
            pushFollow(FOLLOW_ruleDollar_in_entryRuleDollar1973);
            iv_ruleDollar=ruleDollar();

            state._fsp--;

             current =iv_ruleDollar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDollar1983); 

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
    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1067:1: ruleDollar returns [EObject current=null] : ( () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 ) ) ;
    public final EObject ruleDollar() throws RecognitionException {
        EObject current = null;

        Token lv_escaped_1_0=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1073:6: ( ( () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 ) ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1074:1: ( () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 ) )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1074:1: ( () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 ) )
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1074:2: () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 )
            {
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1074:2: ()
            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1075:5: 
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

            // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1085:2: ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==KEYWORD_8) ) {
                alt26=1;
            }
            else if ( (LA26_0==KEYWORD_1) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1085:3: ( (lv_escaped_1_0= KEYWORD_8 ) )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1085:3: ( (lv_escaped_1_0= KEYWORD_8 ) )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1086:1: (lv_escaped_1_0= KEYWORD_8 )
                    {
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1086:1: (lv_escaped_1_0= KEYWORD_8 )
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1087:3: lv_escaped_1_0= KEYWORD_8
                    {
                    lv_escaped_1_0=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleDollar2041); 

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
                    // ../org.eclipse.xtext.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:1109:2: otherlv_2= KEYWORD_1
                    {
                    otherlv_2=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleDollar2073); 

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


    protected DFA21 dfa21 = new DFA21(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA21_eotS =
        "\7\uffff";
    static final String DFA21_eofS =
        "\7\uffff";
    static final String DFA21_minS =
        "\1\4\3\20\1\uffff\1\20\1\uffff";
    static final String DFA21_maxS =
        "\1\22\3\24\1\uffff\1\24\1\uffff";
    static final String DFA21_acceptS =
        "\4\uffff\1\2\1\uffff\1\1";
    static final String DFA21_specialS =
        "\7\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\3\1\uffff\1\2\11\uffff\1\4\1\uffff\1\1",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "",
            "\1\4\1\6\2\uffff\1\5",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "580:3: ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )? ) )";
        }
    }
    static final String DFA20_eotS =
        "\4\uffff";
    static final String DFA20_eofS =
        "\4\uffff";
    static final String DFA20_minS =
        "\2\14\2\uffff";
    static final String DFA20_maxS =
        "\2\24\2\uffff";
    static final String DFA20_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA20_specialS =
        "\4\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "",
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
            return "666:2: ( (this_WS_8= RULE_WS )* otherlv_9= KEYWORD_2 (this_WS_10= RULE_WS )* ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* otherlv_17= KEYWORD_3 )?";
        }
    }
    static final String DFA18_eotS =
        "\4\uffff";
    static final String DFA18_eofS =
        "\4\uffff";
    static final String DFA18_minS =
        "\2\15\2\uffff";
    static final String DFA18_maxS =
        "\2\24\2\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA18_specialS =
        "\4\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\1\3\5\uffff\1\1",
            "\1\2\1\3\5\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "()* loopback of 727:2: ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleCodetemplates_in_entryRuleCodetemplates67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodetemplates77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleCodetemplates115 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleCodetemplates128 = new BitSet(new long[]{0x0000000000040050L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleCodetemplates151 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleCodetemplates164 = new BitSet(new long[]{0x0000000000040052L});
    public static final BitSet FOLLOW_ruleCodetemplate_in_ruleCodetemplates185 = new BitSet(new long[]{0x0000000000040052L});
    public static final BitSet FOLLOW_ruleCodetemplate_in_entryRuleCodetemplate221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodetemplate231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleCodetemplate277 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleCodetemplate290 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCodetemplate307 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleCodetemplate325 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCodetemplate342 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_KEYWORD_3_in_ruleCodetemplate360 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleCodetemplate373 = new BitSet(new long[]{0x00000000000C0050L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleCodetemplate397 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCodetemplate420 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_ruleTemplateBodyWithQuotes_in_ruleCodetemplate447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTemplateBodyWithQuotes_in_entryRuleTemplateBodyWithQuotes488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBodyWithQuotes498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleTemplateBodyWithQuotes539 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleTemplateBodyWithQuotes553 = new BitSet(new long[]{0x0000000000340BA0L});
    public static final BitSet FOLLOW_ruleTemplateBody_in_ruleTemplateBodyWithQuotes575 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleTemplateBodyWithQuotes587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTemplateBody_in_entryRuleTemplateBody632 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBody642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleTemplateBody701 = new BitSet(new long[]{0x0000000000000982L});
    public static final BitSet FOLLOW_ruleVariableOrDollar_in_ruleTemplateBody724 = new BitSet(new long[]{0x00000000003409A2L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleTemplateBody745 = new BitSet(new long[]{0x0000000000000982L});
    public static final BitSet FOLLOW_ruleVariableOrDollar_in_entryRuleVariableOrDollar795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableOrDollar805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleVariableOrDollar856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDollar_in_ruleVariableOrDollar883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleVariable979 = new BitSet(new long[]{0x0000000000150050L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable991 = new BitSet(new long[]{0x0000000000150050L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleVariable1014 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleVariable1043 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1055 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleVariable1071 = new BitSet(new long[]{0x0000000000140050L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1083 = new BitSet(new long[]{0x0000000000140050L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleVariable1105 = new BitSet(new long[]{0x0000000000121000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1118 = new BitSet(new long[]{0x0000000000101000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleVariable1132 = new BitSet(new long[]{0x00000000001C0050L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1144 = new BitSet(new long[]{0x00000000001C0050L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVariable1164 = new BitSet(new long[]{0x0000000000106000L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleVariable1188 = new BitSet(new long[]{0x0000000000106000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1204 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleVariable1218 = new BitSet(new long[]{0x00000000001C0050L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1230 = new BitSet(new long[]{0x00000000001C0050L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVariable1250 = new BitSet(new long[]{0x0000000000106000L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleVariable1274 = new BitSet(new long[]{0x0000000000106000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1291 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_KEYWORD_3_in_ruleVariable1305 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1321 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_KEYWORD_7_in_ruleVariable1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID1381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleValidID1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleValidID1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1529 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFQN1591 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleFQN1610 = new BitSet(new long[]{0x0000000000040050L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFQN1632 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_ruleLiteral1747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue1792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralValue1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleLiteralValue1847 = new BitSet(new long[]{0x0000000000340022L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_ruleLiteralValue1873 = new BitSet(new long[]{0x0000000000340022L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLiteralValue1899 = new BitSet(new long[]{0x0000000000340022L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleLiteralValue1923 = new BitSet(new long[]{0x0000000000340022L});
    public static final BitSet FOLLOW_ruleDollar_in_entryRuleDollar1973 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDollar1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleDollar2041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleDollar2073 = new BitSet(new long[]{0x0000000000000002L});

}
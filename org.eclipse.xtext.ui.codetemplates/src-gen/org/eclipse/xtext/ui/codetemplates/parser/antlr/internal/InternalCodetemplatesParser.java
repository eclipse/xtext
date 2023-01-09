package org.eclipse.xtext.ui.codetemplates.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.codetemplates.services.CodetemplatesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalCodetemplatesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Templates", "ReverseSolidusLessThanSignLessThanSign", "For", "DollarSignDollarSign", "DollarSignLeftCurlyBracket", "LessThanSignLessThanSign", "GreaterThanSignGreaterThanSign", "DollarSign", "LeftParenthesis", "RightParenthesis", "Comma", "FullStop", "Colon", "RightCurlyBracket", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int DollarSignDollarSign=7;
    public static final int DollarSignLeftCurlyBracket=8;
    public static final int Templates=4;
    public static final int RULE_STRING=19;
    public static final int Comma=14;
    public static final int LeftParenthesis=12;
    public static final int Colon=16;
    public static final int RightCurlyBracket=17;
    public static final int EOF=-1;
    public static final int FullStop=15;
    public static final int ReverseSolidusLessThanSignLessThanSign=5;
    public static final int RULE_ID=18;
    public static final int RULE_WS=20;
    public static final int For=6;
    public static final int RightParenthesis=13;
    public static final int RULE_ANY_OTHER=21;
    public static final int GreaterThanSignGreaterThanSign=10;
    public static final int DollarSign=11;
    public static final int LessThanSignLessThanSign=9;

    // delegates
    // delegators


        public InternalCodetemplatesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCodetemplatesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCodetemplatesParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCodetemplatesParser.g"; }



     	private CodetemplatesGrammarAccess grammarAccess;

        public InternalCodetemplatesParser(TokenStream input, CodetemplatesGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // InternalCodetemplatesParser.g:62:1: entryRuleCodetemplates returns [EObject current=null] : iv_ruleCodetemplates= ruleCodetemplates EOF ;
    public final EObject entryRuleCodetemplates() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodetemplates = null;


        try {
            // InternalCodetemplatesParser.g:62:54: (iv_ruleCodetemplates= ruleCodetemplates EOF )
            // InternalCodetemplatesParser.g:63:2: iv_ruleCodetemplates= ruleCodetemplates EOF
            {
             newCompositeNode(grammarAccess.getCodetemplatesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCodetemplates=ruleCodetemplates();

            state._fsp--;

             current =iv_ruleCodetemplates; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCodetemplatesParser.g:69:1: ruleCodetemplates returns [EObject current=null] : (otherlv_0= Templates otherlv_1= For ( ( ruleFQN ) ) otherlv_3= Colon ( (lv_templates_4_0= ruleCodetemplate ) )* ) ;
    public final EObject ruleCodetemplates() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_templates_4_0 = null;



        	enterRule();

        try {
            // InternalCodetemplatesParser.g:75:2: ( (otherlv_0= Templates otherlv_1= For ( ( ruleFQN ) ) otherlv_3= Colon ( (lv_templates_4_0= ruleCodetemplate ) )* ) )
            // InternalCodetemplatesParser.g:76:2: (otherlv_0= Templates otherlv_1= For ( ( ruleFQN ) ) otherlv_3= Colon ( (lv_templates_4_0= ruleCodetemplate ) )* )
            {
            // InternalCodetemplatesParser.g:76:2: (otherlv_0= Templates otherlv_1= For ( ( ruleFQN ) ) otherlv_3= Colon ( (lv_templates_4_0= ruleCodetemplate ) )* )
            // InternalCodetemplatesParser.g:77:3: otherlv_0= Templates otherlv_1= For ( ( ruleFQN ) ) otherlv_3= Colon ( (lv_templates_4_0= ruleCodetemplate ) )*
            {
            otherlv_0=(Token)match(input,Templates,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCodetemplatesAccess().getTemplatesKeyword_0());
            		
            otherlv_1=(Token)match(input,For,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getCodetemplatesAccess().getForKeyword_1());
            		
            // InternalCodetemplatesParser.g:85:3: ( ( ruleFQN ) )
            // InternalCodetemplatesParser.g:86:4: ( ruleFQN )
            {
            // InternalCodetemplatesParser.g:86:4: ( ruleFQN )
            // InternalCodetemplatesParser.g:87:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCodetemplatesRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCodetemplatesAccess().getLanguageGrammarCrossReference_2_0());
            				
            pushFollow(FOLLOW_5);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,Colon,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getCodetemplatesAccess().getColonKeyword_3());
            		
            // InternalCodetemplatesParser.g:105:3: ( (lv_templates_4_0= ruleCodetemplate ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Templates||LA1_0==For||LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:106:4: (lv_templates_4_0= ruleCodetemplate )
            	    {
            	    // InternalCodetemplatesParser.g:106:4: (lv_templates_4_0= ruleCodetemplate )
            	    // InternalCodetemplatesParser.g:107:5: lv_templates_4_0= ruleCodetemplate
            	    {

            	    					newCompositeNode(grammarAccess.getCodetemplatesAccess().getTemplatesCodetemplateParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_templates_4_0=ruleCodetemplate();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCodetemplatesRule());
            	    					}
            	    					add(
            	    						current,
            	    						"templates",
            	    						lv_templates_4_0,
            	    						"org.eclipse.xtext.ui.codetemplates.Codetemplates.Codetemplate");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

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
    // InternalCodetemplatesParser.g:128:1: entryRuleCodetemplate returns [EObject current=null] : iv_ruleCodetemplate= ruleCodetemplate EOF ;
    public final EObject entryRuleCodetemplate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodetemplate = null;


        try {
            // InternalCodetemplatesParser.g:128:53: (iv_ruleCodetemplate= ruleCodetemplate EOF )
            // InternalCodetemplatesParser.g:129:2: iv_ruleCodetemplate= ruleCodetemplate EOF
            {
             newCompositeNode(grammarAccess.getCodetemplateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCodetemplate=ruleCodetemplate();

            state._fsp--;

             current =iv_ruleCodetemplate; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCodetemplatesParser.g:135:1: ruleCodetemplate returns [EObject current=null] : ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= LeftParenthesis ( (lv_id_2_0= RULE_ID ) ) otherlv_3= Comma ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= RightParenthesis otherlv_6= For ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) ) ) ;
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



        	enterRule();

        try {
            // InternalCodetemplatesParser.g:141:2: ( ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= LeftParenthesis ( (lv_id_2_0= RULE_ID ) ) otherlv_3= Comma ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= RightParenthesis otherlv_6= For ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) ) ) )
            // InternalCodetemplatesParser.g:142:2: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= LeftParenthesis ( (lv_id_2_0= RULE_ID ) ) otherlv_3= Comma ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= RightParenthesis otherlv_6= For ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) ) )
            {
            // InternalCodetemplatesParser.g:142:2: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= LeftParenthesis ( (lv_id_2_0= RULE_ID ) ) otherlv_3= Comma ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= RightParenthesis otherlv_6= For ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) ) )
            // InternalCodetemplatesParser.g:143:3: ( (lv_name_0_0= ruleValidID ) ) otherlv_1= LeftParenthesis ( (lv_id_2_0= RULE_ID ) ) otherlv_3= Comma ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= RightParenthesis otherlv_6= For ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) )
            {
            // InternalCodetemplatesParser.g:143:3: ( (lv_name_0_0= ruleValidID ) )
            // InternalCodetemplatesParser.g:144:4: (lv_name_0_0= ruleValidID )
            {
            // InternalCodetemplatesParser.g:144:4: (lv_name_0_0= ruleValidID )
            // InternalCodetemplatesParser.g:145:5: lv_name_0_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getCodetemplateAccess().getNameValidIDParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_0_0=ruleValidID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCodetemplateRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.ui.codetemplates.Codetemplates.ValidID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,LeftParenthesis,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getCodetemplateAccess().getLeftParenthesisKeyword_1());
            		
            // InternalCodetemplatesParser.g:166:3: ( (lv_id_2_0= RULE_ID ) )
            // InternalCodetemplatesParser.g:167:4: (lv_id_2_0= RULE_ID )
            {
            // InternalCodetemplatesParser.g:167:4: (lv_id_2_0= RULE_ID )
            // InternalCodetemplatesParser.g:168:5: lv_id_2_0= RULE_ID
            {
            lv_id_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_id_2_0, grammarAccess.getCodetemplateAccess().getIdIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCodetemplateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"id",
            						lv_id_2_0,
            						"org.eclipse.xtext.ui.codetemplates.Codetemplates.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,Comma,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getCodetemplateAccess().getCommaKeyword_3());
            		
            // InternalCodetemplatesParser.g:188:3: ( (lv_description_4_0= RULE_STRING ) )
            // InternalCodetemplatesParser.g:189:4: (lv_description_4_0= RULE_STRING )
            {
            // InternalCodetemplatesParser.g:189:4: (lv_description_4_0= RULE_STRING )
            // InternalCodetemplatesParser.g:190:5: lv_description_4_0= RULE_STRING
            {
            lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            					newLeafNode(lv_description_4_0, grammarAccess.getCodetemplateAccess().getDescriptionSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCodetemplateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_4_0,
            						"org.eclipse.xtext.ui.codetemplates.Codetemplates.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,RightParenthesis,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getCodetemplateAccess().getRightParenthesisKeyword_5());
            		
            otherlv_6=(Token)match(input,For,FOLLOW_12); 

            			newLeafNode(otherlv_6, grammarAccess.getCodetemplateAccess().getForKeyword_6());
            		
            // InternalCodetemplatesParser.g:214:3: ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Templates||LA2_0==For||LA2_0==RULE_ID) ) {
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
                    // InternalCodetemplatesParser.g:215:4: ( ( ruleValidID ) )
                    {
                    // InternalCodetemplatesParser.g:215:4: ( ( ruleValidID ) )
                    // InternalCodetemplatesParser.g:216:5: ( ruleValidID )
                    {
                    // InternalCodetemplatesParser.g:216:5: ( ruleValidID )
                    // InternalCodetemplatesParser.g:217:6: ruleValidID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCodetemplateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_7_0_0());
                    					
                    pushFollow(FOLLOW_13);
                    ruleValidID();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:232:4: ( (lv_keywordContext_8_0= RULE_STRING ) )
                    {
                    // InternalCodetemplatesParser.g:232:4: ( (lv_keywordContext_8_0= RULE_STRING ) )
                    // InternalCodetemplatesParser.g:233:5: (lv_keywordContext_8_0= RULE_STRING )
                    {
                    // InternalCodetemplatesParser.g:233:5: (lv_keywordContext_8_0= RULE_STRING )
                    // InternalCodetemplatesParser.g:234:6: lv_keywordContext_8_0= RULE_STRING
                    {
                    lv_keywordContext_8_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

                    						newLeafNode(lv_keywordContext_8_0, grammarAccess.getCodetemplateAccess().getKeywordContextSTRINGTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCodetemplateRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"keywordContext",
                    							lv_keywordContext_8_0,
                    							"org.eclipse.xtext.ui.codetemplates.Codetemplates.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalCodetemplatesParser.g:251:3: ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) )
            // InternalCodetemplatesParser.g:252:4: (lv_body_9_0= ruleTemplateBodyWithQuotes )
            {
            // InternalCodetemplatesParser.g:252:4: (lv_body_9_0= ruleTemplateBodyWithQuotes )
            // InternalCodetemplatesParser.g:253:5: lv_body_9_0= ruleTemplateBodyWithQuotes
            {

            					newCompositeNode(grammarAccess.getCodetemplateAccess().getBodyTemplateBodyWithQuotesParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_2);
            lv_body_9_0=ruleTemplateBodyWithQuotes();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCodetemplateRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_9_0,
            						"org.eclipse.xtext.ui.codetemplates.Codetemplates.TemplateBodyWithQuotes");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

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
    // InternalCodetemplatesParser.g:274:1: entryRuleTemplateBodyWithQuotes returns [EObject current=null] : iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF ;
    public final EObject entryRuleTemplateBodyWithQuotes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBodyWithQuotes = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:276:2: (iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF )
            // InternalCodetemplatesParser.g:277:2: iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF
            {
             newCompositeNode(grammarAccess.getTemplateBodyWithQuotesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemplateBodyWithQuotes=ruleTemplateBodyWithQuotes();

            state._fsp--;

             current =iv_ruleTemplateBodyWithQuotes; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCodetemplatesParser.g:286:1: ruleTemplateBodyWithQuotes returns [EObject current=null] : ( (this_WS_0= RULE_WS )? otherlv_1= GreaterThanSignGreaterThanSign this_TemplateBody_2= ruleTemplateBody otherlv_3= LessThanSignLessThanSign ) ;
    public final EObject ruleTemplateBodyWithQuotes() throws RecognitionException {
        EObject current = null;

        Token this_WS_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_TemplateBody_2 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:293:2: ( ( (this_WS_0= RULE_WS )? otherlv_1= GreaterThanSignGreaterThanSign this_TemplateBody_2= ruleTemplateBody otherlv_3= LessThanSignLessThanSign ) )
            // InternalCodetemplatesParser.g:294:2: ( (this_WS_0= RULE_WS )? otherlv_1= GreaterThanSignGreaterThanSign this_TemplateBody_2= ruleTemplateBody otherlv_3= LessThanSignLessThanSign )
            {
            // InternalCodetemplatesParser.g:294:2: ( (this_WS_0= RULE_WS )? otherlv_1= GreaterThanSignGreaterThanSign this_TemplateBody_2= ruleTemplateBody otherlv_3= LessThanSignLessThanSign )
            // InternalCodetemplatesParser.g:295:3: (this_WS_0= RULE_WS )? otherlv_1= GreaterThanSignGreaterThanSign this_TemplateBody_2= ruleTemplateBody otherlv_3= LessThanSignLessThanSign
            {
            // InternalCodetemplatesParser.g:295:3: (this_WS_0= RULE_WS )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalCodetemplatesParser.g:296:4: this_WS_0= RULE_WS
                    {
                    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_14); 

                    				newLeafNode(this_WS_0, grammarAccess.getTemplateBodyWithQuotesAccess().getWSTerminalRuleCall_0());
                    			

                    }
                    break;

            }

            otherlv_1=(Token)match(input,GreaterThanSignGreaterThanSign,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getTemplateBodyWithQuotesAccess().getGreaterThanSignGreaterThanSignKeyword_1());
            		

            			newCompositeNode(grammarAccess.getTemplateBodyWithQuotesAccess().getTemplateBodyParserRuleCall_2());
            		
            pushFollow(FOLLOW_16);
            this_TemplateBody_2=ruleTemplateBody();

            state._fsp--;


            			current = this_TemplateBody_2;
            			afterParserOrEnumRuleCall();
            		
            otherlv_3=(Token)match(input,LessThanSignLessThanSign,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getTemplateBodyWithQuotesAccess().getLessThanSignLessThanSignKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalCodetemplatesParser.g:324:1: entryRuleTemplateBody returns [EObject current=null] : iv_ruleTemplateBody= ruleTemplateBody EOF ;
    public final EObject entryRuleTemplateBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBody = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:326:2: (iv_ruleTemplateBody= ruleTemplateBody EOF )
            // InternalCodetemplatesParser.g:327:2: iv_ruleTemplateBody= ruleTemplateBody EOF
            {
             newCompositeNode(grammarAccess.getTemplateBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemplateBody=ruleTemplateBody();

            state._fsp--;

             current =iv_ruleTemplateBody; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCodetemplatesParser.g:336:1: ruleTemplateBody returns [EObject current=null] : ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* ) ;
    public final EObject ruleTemplateBody() throws RecognitionException {
        EObject current = null;

        EObject lv_parts_1_0 = null;

        EObject lv_parts_2_0 = null;

        EObject lv_parts_3_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:343:2: ( ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* ) )
            // InternalCodetemplatesParser.g:344:2: ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* )
            {
            // InternalCodetemplatesParser.g:344:2: ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* )
            // InternalCodetemplatesParser.g:345:3: () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )*
            {
            // InternalCodetemplatesParser.g:345:3: ()
            // InternalCodetemplatesParser.g:346:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0(),
            					current);
            			

            }

            // InternalCodetemplatesParser.g:352:3: ( (lv_parts_1_0= ruleLiteral ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ReverseSolidusLessThanSignLessThanSign||LA4_0==RULE_ID||(LA4_0>=RULE_WS && LA4_0<=RULE_ANY_OTHER)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalCodetemplatesParser.g:353:4: (lv_parts_1_0= ruleLiteral )
                    {
                    // InternalCodetemplatesParser.g:353:4: (lv_parts_1_0= ruleLiteral )
                    // InternalCodetemplatesParser.g:354:5: lv_parts_1_0= ruleLiteral
                    {

                    					newCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_17);
                    lv_parts_1_0=ruleLiteral();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTemplateBodyRule());
                    					}
                    					add(
                    						current,
                    						"parts",
                    						lv_parts_1_0,
                    						"org.eclipse.xtext.ui.codetemplates.Codetemplates.Literal");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalCodetemplatesParser.g:371:3: ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=DollarSignDollarSign && LA6_0<=DollarSignLeftCurlyBracket)||LA6_0==DollarSign) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:372:4: ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )?
            	    {
            	    // InternalCodetemplatesParser.g:372:4: ( (lv_parts_2_0= ruleVariableOrDollar ) )
            	    // InternalCodetemplatesParser.g:373:5: (lv_parts_2_0= ruleVariableOrDollar )
            	    {
            	    // InternalCodetemplatesParser.g:373:5: (lv_parts_2_0= ruleVariableOrDollar )
            	    // InternalCodetemplatesParser.g:374:6: lv_parts_2_0= ruleVariableOrDollar
            	    {

            	    						newCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsVariableOrDollarParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_18);
            	    lv_parts_2_0=ruleVariableOrDollar();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTemplateBodyRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parts",
            	    							lv_parts_2_0,
            	    							"org.eclipse.xtext.ui.codetemplates.Codetemplates.VariableOrDollar");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalCodetemplatesParser.g:391:4: ( (lv_parts_3_0= ruleLiteral ) )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==ReverseSolidusLessThanSignLessThanSign||LA5_0==RULE_ID||(LA5_0>=RULE_WS && LA5_0<=RULE_ANY_OTHER)) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // InternalCodetemplatesParser.g:392:5: (lv_parts_3_0= ruleLiteral )
            	            {
            	            // InternalCodetemplatesParser.g:392:5: (lv_parts_3_0= ruleLiteral )
            	            // InternalCodetemplatesParser.g:393:6: lv_parts_3_0= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_2_1_0());
            	            					
            	            pushFollow(FOLLOW_17);
            	            lv_parts_3_0=ruleLiteral();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getTemplateBodyRule());
            	            						}
            	            						add(
            	            							current,
            	            							"parts",
            	            							lv_parts_3_0,
            	            							"org.eclipse.xtext.ui.codetemplates.Codetemplates.Literal");
            	            						afterParserOrEnumRuleCall();
            	            					

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


            	leaveRule();

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
    // InternalCodetemplatesParser.g:418:1: entryRuleVariableOrDollar returns [EObject current=null] : iv_ruleVariableOrDollar= ruleVariableOrDollar EOF ;
    public final EObject entryRuleVariableOrDollar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableOrDollar = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:420:2: (iv_ruleVariableOrDollar= ruleVariableOrDollar EOF )
            // InternalCodetemplatesParser.g:421:2: iv_ruleVariableOrDollar= ruleVariableOrDollar EOF
            {
             newCompositeNode(grammarAccess.getVariableOrDollarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableOrDollar=ruleVariableOrDollar();

            state._fsp--;

             current =iv_ruleVariableOrDollar; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCodetemplatesParser.g:430:1: ruleVariableOrDollar returns [EObject current=null] : (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar ) ;
    public final EObject ruleVariableOrDollar() throws RecognitionException {
        EObject current = null;

        EObject this_Variable_0 = null;

        EObject this_Dollar_1 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:437:2: ( (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar ) )
            // InternalCodetemplatesParser.g:438:2: (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar )
            {
            // InternalCodetemplatesParser.g:438:2: (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==DollarSignLeftCurlyBracket) ) {
                alt7=1;
            }
            else if ( (LA7_0==DollarSignDollarSign||LA7_0==DollarSign) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalCodetemplatesParser.g:439:3: this_Variable_0= ruleVariable
                    {

                    			newCompositeNode(grammarAccess.getVariableOrDollarAccess().getVariableParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Variable_0=ruleVariable();

                    state._fsp--;


                    			current = this_Variable_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:448:3: this_Dollar_1= ruleDollar
                    {

                    			newCompositeNode(grammarAccess.getVariableOrDollarAccess().getDollarParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Dollar_1=ruleDollar();

                    state._fsp--;


                    			current = this_Dollar_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalCodetemplatesParser.g:463:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:465:2: (iv_ruleVariable= ruleVariable EOF )
            // InternalCodetemplatesParser.g:466:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCodetemplatesParser.g:475:1: ruleVariable returns [EObject current=null] : (otherlv_0= DollarSignLeftCurlyBracket (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) ) (this_WS_18= RULE_WS )* otherlv_19= RightCurlyBracket ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_WS_1=null;
        Token this_WS_4=null;
        Token otherlv_5=null;
        Token this_WS_6=null;
        Token this_WS_8=null;
        Token lv_expectingParameters_9_0=null;
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



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:482:2: ( (otherlv_0= DollarSignLeftCurlyBracket (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) ) (this_WS_18= RULE_WS )* otherlv_19= RightCurlyBracket ) )
            // InternalCodetemplatesParser.g:483:2: (otherlv_0= DollarSignLeftCurlyBracket (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) ) (this_WS_18= RULE_WS )* otherlv_19= RightCurlyBracket )
            {
            // InternalCodetemplatesParser.g:483:2: (otherlv_0= DollarSignLeftCurlyBracket (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) ) (this_WS_18= RULE_WS )* otherlv_19= RightCurlyBracket )
            // InternalCodetemplatesParser.g:484:3: otherlv_0= DollarSignLeftCurlyBracket (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) ) (this_WS_18= RULE_WS )* otherlv_19= RightCurlyBracket
            {
            otherlv_0=(Token)match(input,DollarSignLeftCurlyBracket,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getDollarSignLeftCurlyBracketKeyword_0());
            		
            // InternalCodetemplatesParser.g:488:3: (this_WS_1= RULE_WS )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_WS) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:489:4: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_19); 

            	    				newLeafNode(this_WS_1, grammarAccess.getVariableAccess().getWSTerminalRuleCall_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalCodetemplatesParser.g:494:3: ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalCodetemplatesParser.g:495:4: ( (lv_name_2_0= ruleValidID ) )
                    {
                    // InternalCodetemplatesParser.g:495:4: ( (lv_name_2_0= ruleValidID ) )
                    // InternalCodetemplatesParser.g:496:5: (lv_name_2_0= ruleValidID )
                    {
                    // InternalCodetemplatesParser.g:496:5: (lv_name_2_0= ruleValidID )
                    // InternalCodetemplatesParser.g:497:6: lv_name_2_0= ruleValidID
                    {

                    						newCompositeNode(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_name_2_0=ruleValidID();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVariableRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"org.eclipse.xtext.ui.codetemplates.Codetemplates.ValidID");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:515:4: ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? )
                    {
                    // InternalCodetemplatesParser.g:515:4: ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? )
                    // InternalCodetemplatesParser.g:516:5: ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )?
                    {
                    // InternalCodetemplatesParser.g:516:5: ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==Templates||LA10_0==For||LA10_0==RULE_ID) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalCodetemplatesParser.g:517:6: ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )*
                            {
                            // InternalCodetemplatesParser.g:517:6: ( (lv_name_3_0= ruleValidID ) )
                            // InternalCodetemplatesParser.g:518:7: (lv_name_3_0= ruleValidID )
                            {
                            // InternalCodetemplatesParser.g:518:7: (lv_name_3_0= ruleValidID )
                            // InternalCodetemplatesParser.g:519:8: lv_name_3_0= ruleValidID
                            {

                            								newCompositeNode(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_1_0_0_0());
                            							
                            pushFollow(FOLLOW_21);
                            lv_name_3_0=ruleValidID();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getVariableRule());
                            								}
                            								set(
                            									current,
                            									"name",
                            									lv_name_3_0,
                            									"org.eclipse.xtext.ui.codetemplates.Codetemplates.ValidID");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalCodetemplatesParser.g:536:6: (this_WS_4= RULE_WS )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==RULE_WS) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // InternalCodetemplatesParser.g:537:7: this_WS_4= RULE_WS
                            	    {
                            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_21); 

                            	    							newLeafNode(this_WS_4, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1());
                            	    						

                            	    }
                            	    break;

                            	default :
                            	    break loop9;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,Colon,FOLLOW_22); 

                    					newLeafNode(otherlv_5, grammarAccess.getVariableAccess().getColonKeyword_2_1_1());
                    				
                    // InternalCodetemplatesParser.g:547:5: (this_WS_6= RULE_WS )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_WS) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalCodetemplatesParser.g:548:6: this_WS_6= RULE_WS
                    	    {
                    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_22); 

                    	    						newLeafNode(this_WS_6, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2());
                    	    					

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    // InternalCodetemplatesParser.g:553:5: ( (lv_type_7_0= ruleValidID ) )
                    // InternalCodetemplatesParser.g:554:6: (lv_type_7_0= ruleValidID )
                    {
                    // InternalCodetemplatesParser.g:554:6: (lv_type_7_0= ruleValidID )
                    // InternalCodetemplatesParser.g:555:7: lv_type_7_0= ruleValidID
                    {

                    							newCompositeNode(grammarAccess.getVariableAccess().getTypeValidIDParserRuleCall_2_1_3_0());
                    						
                    pushFollow(FOLLOW_23);
                    lv_type_7_0=ruleValidID();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getVariableRule());
                    							}
                    							set(
                    								current,
                    								"type",
                    								lv_type_7_0,
                    								"org.eclipse.xtext.ui.codetemplates.Codetemplates.ValidID");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalCodetemplatesParser.g:572:5: ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )?
                    int alt21=2;
                    alt21 = dfa21.predict(input);
                    switch (alt21) {
                        case 1 :
                            // InternalCodetemplatesParser.g:573:6: (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis
                            {
                            // InternalCodetemplatesParser.g:573:6: (this_WS_8= RULE_WS )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==RULE_WS) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // InternalCodetemplatesParser.g:574:7: this_WS_8= RULE_WS
                            	    {
                            	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_24); 

                            	    							newLeafNode(this_WS_8, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0());
                            	    						

                            	    }
                            	    break;

                            	default :
                            	    break loop12;
                                }
                            } while (true);

                            // InternalCodetemplatesParser.g:579:6: ( (lv_expectingParameters_9_0= LeftParenthesis ) )
                            // InternalCodetemplatesParser.g:580:7: (lv_expectingParameters_9_0= LeftParenthesis )
                            {
                            // InternalCodetemplatesParser.g:580:7: (lv_expectingParameters_9_0= LeftParenthesis )
                            // InternalCodetemplatesParser.g:581:8: lv_expectingParameters_9_0= LeftParenthesis
                            {
                            lv_expectingParameters_9_0=(Token)match(input,LeftParenthesis,FOLLOW_25); 

                            								newLeafNode(lv_expectingParameters_9_0, grammarAccess.getVariableAccess().getExpectingParametersLeftParenthesisKeyword_2_1_4_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getVariableRule());
                            								}
                            								setWithLastConsumed(current, "expectingParameters", lv_expectingParameters_9_0 != null, "(");
                            							

                            }


                            }

                            // InternalCodetemplatesParser.g:593:6: (this_WS_10= RULE_WS )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==RULE_WS) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // InternalCodetemplatesParser.g:594:7: this_WS_10= RULE_WS
                            	    {
                            	    this_WS_10=(Token)match(input,RULE_WS,FOLLOW_25); 

                            	    							newLeafNode(this_WS_10, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2());
                            	    						

                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);

                            // InternalCodetemplatesParser.g:599:6: ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )?
                            int alt20=2;
                            int LA20_0 = input.LA(1);

                            if ( (LA20_0==Templates||LA20_0==For||(LA20_0>=RULE_ID && LA20_0<=RULE_STRING)) ) {
                                alt20=1;
                            }
                            switch (alt20) {
                                case 1 :
                                    // InternalCodetemplatesParser.g:600:7: ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )*
                                    {
                                    // InternalCodetemplatesParser.g:600:7: ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) )
                                    // InternalCodetemplatesParser.g:601:8: ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) )
                                    {
                                    // InternalCodetemplatesParser.g:601:8: ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) )
                                    // InternalCodetemplatesParser.g:602:9: (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN )
                                    {
                                    // InternalCodetemplatesParser.g:602:9: (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN )
                                    int alt14=2;
                                    int LA14_0 = input.LA(1);

                                    if ( (LA14_0==RULE_STRING) ) {
                                        alt14=1;
                                    }
                                    else if ( (LA14_0==Templates||LA14_0==For||LA14_0==RULE_ID) ) {
                                        alt14=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt14) {
                                        case 1 :
                                            // InternalCodetemplatesParser.g:603:10: lv_parameters_11_1= RULE_STRING
                                            {
                                            lv_parameters_11_1=(Token)match(input,RULE_STRING,FOLLOW_26); 

                                            										newLeafNode(lv_parameters_11_1, grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0());
                                            									

                                            										if (current==null) {
                                            											current = createModelElement(grammarAccess.getVariableRule());
                                            										}
                                            										addWithLastConsumed(
                                            											current,
                                            											"parameters",
                                            											lv_parameters_11_1,
                                            											"org.eclipse.xtext.ui.codetemplates.Codetemplates.STRING");
                                            									

                                            }
                                            break;
                                        case 2 :
                                            // InternalCodetemplatesParser.g:618:10: lv_parameters_11_2= ruleFQN
                                            {

                                            										newCompositeNode(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_0_0_1());
                                            									
                                            pushFollow(FOLLOW_26);
                                            lv_parameters_11_2=ruleFQN();

                                            state._fsp--;


                                            										if (current==null) {
                                            											current = createModelElementForParent(grammarAccess.getVariableRule());
                                            										}
                                            										add(
                                            											current,
                                            											"parameters",
                                            											lv_parameters_11_2,
                                            											"org.eclipse.xtext.ui.codetemplates.Codetemplates.FQN");
                                            										afterParserOrEnumRuleCall();
                                            									

                                            }
                                            break;

                                    }


                                    }


                                    }

                                    // InternalCodetemplatesParser.g:636:7: ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )*
                                    loop18:
                                    do {
                                        int alt18=2;
                                        alt18 = dfa18.predict(input);
                                        switch (alt18) {
                                    	case 1 :
                                    	    // InternalCodetemplatesParser.g:637:8: (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) )
                                    	    {
                                    	    // InternalCodetemplatesParser.g:637:8: (this_WS_12= RULE_WS )*
                                    	    loop15:
                                    	    do {
                                    	        int alt15=2;
                                    	        int LA15_0 = input.LA(1);

                                    	        if ( (LA15_0==RULE_WS) ) {
                                    	            alt15=1;
                                    	        }


                                    	        switch (alt15) {
                                    	    	case 1 :
                                    	    	    // InternalCodetemplatesParser.g:638:9: this_WS_12= RULE_WS
                                    	    	    {
                                    	    	    this_WS_12=(Token)match(input,RULE_WS,FOLLOW_27); 

                                    	    	    									newLeafNode(this_WS_12, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_0());
                                    	    	    								

                                    	    	    }
                                    	    	    break;

                                    	    	default :
                                    	    	    break loop15;
                                    	        }
                                    	    } while (true);

                                    	    otherlv_13=(Token)match(input,Comma,FOLLOW_28); 

                                    	    								newLeafNode(otherlv_13, grammarAccess.getVariableAccess().getCommaKeyword_2_1_4_3_1_1());
                                    	    							
                                    	    // InternalCodetemplatesParser.g:647:8: (this_WS_14= RULE_WS )*
                                    	    loop16:
                                    	    do {
                                    	        int alt16=2;
                                    	        int LA16_0 = input.LA(1);

                                    	        if ( (LA16_0==RULE_WS) ) {
                                    	            alt16=1;
                                    	        }


                                    	        switch (alt16) {
                                    	    	case 1 :
                                    	    	    // InternalCodetemplatesParser.g:648:9: this_WS_14= RULE_WS
                                    	    	    {
                                    	    	    this_WS_14=(Token)match(input,RULE_WS,FOLLOW_28); 

                                    	    	    									newLeafNode(this_WS_14, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_2());
                                    	    	    								

                                    	    	    }
                                    	    	    break;

                                    	    	default :
                                    	    	    break loop16;
                                    	        }
                                    	    } while (true);

                                    	    // InternalCodetemplatesParser.g:653:8: ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) )
                                    	    // InternalCodetemplatesParser.g:654:9: ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) )
                                    	    {
                                    	    // InternalCodetemplatesParser.g:654:9: ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) )
                                    	    // InternalCodetemplatesParser.g:655:10: (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN )
                                    	    {
                                    	    // InternalCodetemplatesParser.g:655:10: (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN )
                                    	    int alt17=2;
                                    	    int LA17_0 = input.LA(1);

                                    	    if ( (LA17_0==RULE_STRING) ) {
                                    	        alt17=1;
                                    	    }
                                    	    else if ( (LA17_0==Templates||LA17_0==For||LA17_0==RULE_ID) ) {
                                    	        alt17=2;
                                    	    }
                                    	    else {
                                    	        NoViableAltException nvae =
                                    	            new NoViableAltException("", 17, 0, input);

                                    	        throw nvae;
                                    	    }
                                    	    switch (alt17) {
                                    	        case 1 :
                                    	            // InternalCodetemplatesParser.g:656:11: lv_parameters_15_1= RULE_STRING
                                    	            {
                                    	            lv_parameters_15_1=(Token)match(input,RULE_STRING,FOLLOW_26); 

                                    	            											newLeafNode(lv_parameters_15_1, grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0());
                                    	            										

                                    	            											if (current==null) {
                                    	            												current = createModelElement(grammarAccess.getVariableRule());
                                    	            											}
                                    	            											addWithLastConsumed(
                                    	            												current,
                                    	            												"parameters",
                                    	            												lv_parameters_15_1,
                                    	            												"org.eclipse.xtext.ui.codetemplates.Codetemplates.STRING");
                                    	            										

                                    	            }
                                    	            break;
                                    	        case 2 :
                                    	            // InternalCodetemplatesParser.g:671:11: lv_parameters_15_2= ruleFQN
                                    	            {

                                    	            											newCompositeNode(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_1_3_0_1());
                                    	            										
                                    	            pushFollow(FOLLOW_26);
                                    	            lv_parameters_15_2=ruleFQN();

                                    	            state._fsp--;


                                    	            											if (current==null) {
                                    	            												current = createModelElementForParent(grammarAccess.getVariableRule());
                                    	            											}
                                    	            											add(
                                    	            												current,
                                    	            												"parameters",
                                    	            												lv_parameters_15_2,
                                    	            												"org.eclipse.xtext.ui.codetemplates.Codetemplates.FQN");
                                    	            											afterParserOrEnumRuleCall();
                                    	            										

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

                                    // InternalCodetemplatesParser.g:690:7: (this_WS_16= RULE_WS )*
                                    loop19:
                                    do {
                                        int alt19=2;
                                        int LA19_0 = input.LA(1);

                                        if ( (LA19_0==RULE_WS) ) {
                                            alt19=1;
                                        }


                                        switch (alt19) {
                                    	case 1 :
                                    	    // InternalCodetemplatesParser.g:691:8: this_WS_16= RULE_WS
                                    	    {
                                    	    this_WS_16=(Token)match(input,RULE_WS,FOLLOW_29); 

                                    	    								newLeafNode(this_WS_16, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_2());
                                    	    							

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop19;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            otherlv_17=(Token)match(input,RightParenthesis,FOLLOW_20); 

                            						newLeafNode(otherlv_17, grammarAccess.getVariableAccess().getRightParenthesisKeyword_2_1_4_4());
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalCodetemplatesParser.g:704:3: (this_WS_18= RULE_WS )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_WS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:705:4: this_WS_18= RULE_WS
            	    {
            	    this_WS_18=(Token)match(input,RULE_WS,FOLLOW_20); 

            	    				newLeafNode(this_WS_18, grammarAccess.getVariableAccess().getWSTerminalRuleCall_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_19=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

            			newLeafNode(otherlv_19, grammarAccess.getVariableAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

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
    // InternalCodetemplatesParser.g:721:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:723:2: (iv_ruleValidID= ruleValidID EOF )
            // InternalCodetemplatesParser.g:724:2: iv_ruleValidID= ruleValidID EOF
            {
             newCompositeNode(grammarAccess.getValidIDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCodetemplatesParser.g:733:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= For | kw= Templates ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:740:2: ( (this_ID_0= RULE_ID | kw= For | kw= Templates ) )
            // InternalCodetemplatesParser.g:741:2: (this_ID_0= RULE_ID | kw= For | kw= Templates )
            {
            // InternalCodetemplatesParser.g:741:2: (this_ID_0= RULE_ID | kw= For | kw= Templates )
            int alt24=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt24=1;
                }
                break;
            case For:
                {
                alt24=2;
                }
                break;
            case Templates:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalCodetemplatesParser.g:742:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:750:3: kw= For
                    {
                    kw=(Token)match(input,For,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getValidIDAccess().getForKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalCodetemplatesParser.g:756:3: kw= Templates
                    {
                    kw=(Token)match(input,Templates,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getValidIDAccess().getTemplatesKeyword_2());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalCodetemplatesParser.g:768:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:770:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalCodetemplatesParser.g:771:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCodetemplatesParser.g:780:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= FullStop this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:787:2: ( (this_ValidID_0= ruleValidID (kw= FullStop this_ValidID_2= ruleValidID )* ) )
            // InternalCodetemplatesParser.g:788:2: (this_ValidID_0= ruleValidID (kw= FullStop this_ValidID_2= ruleValidID )* )
            {
            // InternalCodetemplatesParser.g:788:2: (this_ValidID_0= ruleValidID (kw= FullStop this_ValidID_2= ruleValidID )* )
            // InternalCodetemplatesParser.g:789:3: this_ValidID_0= ruleValidID (kw= FullStop this_ValidID_2= ruleValidID )*
            {

            			newCompositeNode(grammarAccess.getFQNAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FOLLOW_30);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalCodetemplatesParser.g:799:3: (kw= FullStop this_ValidID_2= ruleValidID )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==FullStop) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:800:4: kw= FullStop this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getFQNAccess().getValidIDParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_30);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    				current.merge(this_ValidID_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }


            	leaveRule();

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
    // InternalCodetemplatesParser.g:823:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:825:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalCodetemplatesParser.g:826:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCodetemplatesParser.g:835:1: ruleLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleLiteralValue ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:842:2: ( ( (lv_value_0_0= ruleLiteralValue ) ) )
            // InternalCodetemplatesParser.g:843:2: ( (lv_value_0_0= ruleLiteralValue ) )
            {
            // InternalCodetemplatesParser.g:843:2: ( (lv_value_0_0= ruleLiteralValue ) )
            // InternalCodetemplatesParser.g:844:3: (lv_value_0_0= ruleLiteralValue )
            {
            // InternalCodetemplatesParser.g:844:3: (lv_value_0_0= ruleLiteralValue )
            // InternalCodetemplatesParser.g:845:4: lv_value_0_0= ruleLiteralValue
            {

            				newCompositeNode(grammarAccess.getLiteralAccess().getValueLiteralValueParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleLiteralValue();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getLiteralRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.ui.codetemplates.Codetemplates.LiteralValue");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

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
    // InternalCodetemplatesParser.g:868:1: entryRuleLiteralValue returns [String current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final String entryRuleLiteralValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteralValue = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:870:2: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // InternalCodetemplatesParser.g:871:2: iv_ruleLiteralValue= ruleLiteralValue EOF
            {
             newCompositeNode(grammarAccess.getLiteralValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralValue=ruleLiteralValue();

            state._fsp--;

             current =iv_ruleLiteralValue.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCodetemplatesParser.g:880:1: ruleLiteralValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID | kw= ReverseSolidusLessThanSignLessThanSign )+ ;
    public final AntlrDatatypeRuleToken ruleLiteralValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token this_ANY_OTHER_1=null;
        Token this_ID_2=null;
        Token kw=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:887:2: ( (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID | kw= ReverseSolidusLessThanSignLessThanSign )+ )
            // InternalCodetemplatesParser.g:888:2: (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID | kw= ReverseSolidusLessThanSignLessThanSign )+
            {
            // InternalCodetemplatesParser.g:888:2: (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID | kw= ReverseSolidusLessThanSignLessThanSign )+
            int cnt26=0;
            loop26:
            do {
                int alt26=5;
                switch ( input.LA(1) ) {
                case RULE_WS:
                    {
                    alt26=1;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt26=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt26=3;
                    }
                    break;
                case ReverseSolidusLessThanSignLessThanSign:
                    {
                    alt26=4;
                    }
                    break;

                }

                switch (alt26) {
            	case 1 :
            	    // InternalCodetemplatesParser.g:889:3: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_31); 

            	    			current.merge(this_WS_0);
            	    		

            	    			newLeafNode(this_WS_0, grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalCodetemplatesParser.g:897:3: this_ANY_OTHER_1= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_1=(Token)match(input,RULE_ANY_OTHER,FOLLOW_31); 

            	    			current.merge(this_ANY_OTHER_1);
            	    		

            	    			newLeafNode(this_ANY_OTHER_1, grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalCodetemplatesParser.g:905:3: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_31); 

            	    			current.merge(this_ID_2);
            	    		

            	    			newLeafNode(this_ID_2, grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalCodetemplatesParser.g:913:3: kw= ReverseSolidusLessThanSignLessThanSign
            	    {
            	    kw=(Token)match(input,ReverseSolidusLessThanSignLessThanSign,FOLLOW_31); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getLiteralValueAccess().getReverseSolidusLessThanSignLessThanSignKeyword_3());
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            }


            	leaveRule();

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
    // InternalCodetemplatesParser.g:925:1: entryRuleDollar returns [EObject current=null] : iv_ruleDollar= ruleDollar EOF ;
    public final EObject entryRuleDollar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDollar = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:927:2: (iv_ruleDollar= ruleDollar EOF )
            // InternalCodetemplatesParser.g:928:2: iv_ruleDollar= ruleDollar EOF
            {
             newCompositeNode(grammarAccess.getDollarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDollar=ruleDollar();

            state._fsp--;

             current =iv_ruleDollar; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCodetemplatesParser.g:937:1: ruleDollar returns [EObject current=null] : ( () ( ( (lv_escaped_1_0= DollarSignDollarSign ) ) | otherlv_2= DollarSign ) ) ;
    public final EObject ruleDollar() throws RecognitionException {
        EObject current = null;

        Token lv_escaped_1_0=null;
        Token otherlv_2=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalCodetemplatesParser.g:944:2: ( ( () ( ( (lv_escaped_1_0= DollarSignDollarSign ) ) | otherlv_2= DollarSign ) ) )
            // InternalCodetemplatesParser.g:945:2: ( () ( ( (lv_escaped_1_0= DollarSignDollarSign ) ) | otherlv_2= DollarSign ) )
            {
            // InternalCodetemplatesParser.g:945:2: ( () ( ( (lv_escaped_1_0= DollarSignDollarSign ) ) | otherlv_2= DollarSign ) )
            // InternalCodetemplatesParser.g:946:3: () ( ( (lv_escaped_1_0= DollarSignDollarSign ) ) | otherlv_2= DollarSign )
            {
            // InternalCodetemplatesParser.g:946:3: ()
            // InternalCodetemplatesParser.g:947:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDollarAccess().getDollarAction_0(),
            					current);
            			

            }

            // InternalCodetemplatesParser.g:953:3: ( ( (lv_escaped_1_0= DollarSignDollarSign ) ) | otherlv_2= DollarSign )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==DollarSignDollarSign) ) {
                alt27=1;
            }
            else if ( (LA27_0==DollarSign) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalCodetemplatesParser.g:954:4: ( (lv_escaped_1_0= DollarSignDollarSign ) )
                    {
                    // InternalCodetemplatesParser.g:954:4: ( (lv_escaped_1_0= DollarSignDollarSign ) )
                    // InternalCodetemplatesParser.g:955:5: (lv_escaped_1_0= DollarSignDollarSign )
                    {
                    // InternalCodetemplatesParser.g:955:5: (lv_escaped_1_0= DollarSignDollarSign )
                    // InternalCodetemplatesParser.g:956:6: lv_escaped_1_0= DollarSignDollarSign
                    {
                    lv_escaped_1_0=(Token)match(input,DollarSignDollarSign,FOLLOW_2); 

                    						newLeafNode(lv_escaped_1_0, grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDollarRule());
                    						}
                    						setWithLastConsumed(current, "escaped", lv_escaped_1_0 != null, "$$");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCodetemplatesParser.g:969:4: otherlv_2= DollarSign
                    {
                    otherlv_2=(Token)match(input,DollarSign,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getDollarAccess().getDollarSignKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

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


    protected DFA22 dfa22 = new DFA22(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\4\3\20\1\uffff\1\20\1\uffff";
    static final String dfa_3s = "\1\22\3\24\1\uffff\1\24\1\uffff";
    static final String dfa_4s = "\4\uffff\1\2\1\uffff\1\1";
    static final String dfa_5s = "\7\uffff}>";
    static final String[] dfa_6s = {
            "\1\3\1\uffff\1\2\11\uffff\1\4\1\uffff\1\1",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "",
            "\1\4\1\6\2\uffff\1\5",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "494:3: ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) )";
        }
    }
    static final String dfa_7s = "\4\uffff";
    static final String dfa_8s = "\2\14\2\uffff";
    static final String dfa_9s = "\2\24\2\uffff";
    static final String dfa_10s = "\2\uffff\1\1\1\2";
    static final String dfa_11s = "\4\uffff}>";
    static final String[] dfa_12s = {
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "572:5: ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )?";
        }
    }
    static final String dfa_13s = "\2\15\2\uffff";
    static final String dfa_14s = "\2\uffff\1\2\1\1";
    static final String[] dfa_15s = {
            "\1\2\1\3\5\uffff\1\1",
            "\1\2\1\3\5\uffff\1\1",
            "",
            ""
    };
    static final char[] dfa_13 = DFA.unpackEncodedStringToUnsignedChars(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[][] dfa_15 = unpackEncodedStringArray(dfa_15s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_13;
            this.max = dfa_9;
            this.accept = dfa_14;
            this.special = dfa_11;
            this.transition = dfa_15;
        }
        public String getDescription() {
            return "()* loopback of 636:7: ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000040050L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000040052L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000000C0050L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000340BA0L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000982L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000000003409A2L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000150050L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000140050L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000121000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000101000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000000001C2050L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000106000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00000000001C0050L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000340022L});

}
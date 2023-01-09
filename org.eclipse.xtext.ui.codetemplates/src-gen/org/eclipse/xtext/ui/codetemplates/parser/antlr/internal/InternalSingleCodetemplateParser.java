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
import org.eclipse.xtext.ui.codetemplates.services.SingleCodetemplateGrammarAccess;



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
public class InternalSingleCodetemplateParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Templates", "For", "DollarSignDollarSign", "DollarSignLeftCurlyBracket", "GreaterThanSignGreaterThanSign", "DollarSign", "LeftParenthesis", "RightParenthesis", "Comma", "FullStop", "Colon", "RightCurlyBracket", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int DollarSignDollarSign=6;
    public static final int DollarSignLeftCurlyBracket=7;
    public static final int Templates=4;
    public static final int RULE_STRING=17;
    public static final int Comma=12;
    public static final int LeftParenthesis=10;
    public static final int Colon=14;
    public static final int RightCurlyBracket=15;
    public static final int EOF=-1;
    public static final int FullStop=13;
    public static final int RULE_ID=16;
    public static final int RULE_WS=18;
    public static final int For=5;
    public static final int RightParenthesis=11;
    public static final int RULE_ANY_OTHER=19;
    public static final int GreaterThanSignGreaterThanSign=8;
    public static final int DollarSign=9;

    // delegates
    // delegators


        public InternalSingleCodetemplateParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSingleCodetemplateParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSingleCodetemplateParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSingleCodetemplateParser.g"; }



     	private SingleCodetemplateGrammarAccess grammarAccess;

        public InternalSingleCodetemplateParser(TokenStream input, SingleCodetemplateGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // InternalSingleCodetemplateParser.g:62:1: entryRuleCodetemplates returns [EObject current=null] : iv_ruleCodetemplates= ruleCodetemplates EOF ;
    public final EObject entryRuleCodetemplates() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodetemplates = null;


        try {
            // InternalSingleCodetemplateParser.g:62:54: (iv_ruleCodetemplates= ruleCodetemplates EOF )
            // InternalSingleCodetemplateParser.g:63:2: iv_ruleCodetemplates= ruleCodetemplates EOF
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
    // InternalSingleCodetemplateParser.g:69:1: ruleCodetemplates returns [EObject current=null] : (otherlv_0= Templates otherlv_1= For ( ( ruleFQN ) ) ( (lv_templates_3_0= ruleCodetemplate ) ) ) ;
    public final EObject ruleCodetemplates() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_templates_3_0 = null;



        	enterRule();

        try {
            // InternalSingleCodetemplateParser.g:75:2: ( (otherlv_0= Templates otherlv_1= For ( ( ruleFQN ) ) ( (lv_templates_3_0= ruleCodetemplate ) ) ) )
            // InternalSingleCodetemplateParser.g:76:2: (otherlv_0= Templates otherlv_1= For ( ( ruleFQN ) ) ( (lv_templates_3_0= ruleCodetemplate ) ) )
            {
            // InternalSingleCodetemplateParser.g:76:2: (otherlv_0= Templates otherlv_1= For ( ( ruleFQN ) ) ( (lv_templates_3_0= ruleCodetemplate ) ) )
            // InternalSingleCodetemplateParser.g:77:3: otherlv_0= Templates otherlv_1= For ( ( ruleFQN ) ) ( (lv_templates_3_0= ruleCodetemplate ) )
            {
            otherlv_0=(Token)match(input,Templates,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCodetemplatesAccess().getTemplatesKeyword_0());
            		
            otherlv_1=(Token)match(input,For,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getCodetemplatesAccess().getForKeyword_1());
            		
            // InternalSingleCodetemplateParser.g:85:3: ( ( ruleFQN ) )
            // InternalSingleCodetemplateParser.g:86:4: ( ruleFQN )
            {
            // InternalSingleCodetemplateParser.g:86:4: ( ruleFQN )
            // InternalSingleCodetemplateParser.g:87:5: ruleFQN
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

            // InternalSingleCodetemplateParser.g:101:3: ( (lv_templates_3_0= ruleCodetemplate ) )
            // InternalSingleCodetemplateParser.g:102:4: (lv_templates_3_0= ruleCodetemplate )
            {
            // InternalSingleCodetemplateParser.g:102:4: (lv_templates_3_0= ruleCodetemplate )
            // InternalSingleCodetemplateParser.g:103:5: lv_templates_3_0= ruleCodetemplate
            {

            					newCompositeNode(grammarAccess.getCodetemplatesAccess().getTemplatesCodetemplateParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_templates_3_0=ruleCodetemplate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCodetemplatesRule());
            					}
            					add(
            						current,
            						"templates",
            						lv_templates_3_0,
            						"org.eclipse.xtext.ui.codetemplates.SingleCodetemplate.Codetemplate");
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
    // $ANTLR end "ruleCodetemplates"


    // $ANTLR start "entryRuleCodetemplate"
    // InternalSingleCodetemplateParser.g:124:1: entryRuleCodetemplate returns [EObject current=null] : iv_ruleCodetemplate= ruleCodetemplate EOF ;
    public final EObject entryRuleCodetemplate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodetemplate = null;


        try {
            // InternalSingleCodetemplateParser.g:124:53: (iv_ruleCodetemplate= ruleCodetemplate EOF )
            // InternalSingleCodetemplateParser.g:125:2: iv_ruleCodetemplate= ruleCodetemplate EOF
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
    // InternalSingleCodetemplateParser.g:131:1: ruleCodetemplate returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= For ( ( ( ruleValidID ) ) | ( (lv_keywordContext_3_0= RULE_STRING ) ) ) ( (lv_body_4_0= ruleTemplateBodyWithQuotes ) ) ) ;
    public final EObject ruleCodetemplate() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_keywordContext_3_0=null;
        EObject lv_body_4_0 = null;



        	enterRule();

        try {
            // InternalSingleCodetemplateParser.g:137:2: ( ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= For ( ( ( ruleValidID ) ) | ( (lv_keywordContext_3_0= RULE_STRING ) ) ) ( (lv_body_4_0= ruleTemplateBodyWithQuotes ) ) ) )
            // InternalSingleCodetemplateParser.g:138:2: ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= For ( ( ( ruleValidID ) ) | ( (lv_keywordContext_3_0= RULE_STRING ) ) ) ( (lv_body_4_0= ruleTemplateBodyWithQuotes ) ) )
            {
            // InternalSingleCodetemplateParser.g:138:2: ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= For ( ( ( ruleValidID ) ) | ( (lv_keywordContext_3_0= RULE_STRING ) ) ) ( (lv_body_4_0= ruleTemplateBodyWithQuotes ) ) )
            // InternalSingleCodetemplateParser.g:139:3: ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= For ( ( ( ruleValidID ) ) | ( (lv_keywordContext_3_0= RULE_STRING ) ) ) ( (lv_body_4_0= ruleTemplateBodyWithQuotes ) )
            {
            // InternalSingleCodetemplateParser.g:139:3: ( (lv_name_0_0= RULE_STRING ) )
            // InternalSingleCodetemplateParser.g:140:4: (lv_name_0_0= RULE_STRING )
            {
            // InternalSingleCodetemplateParser.g:140:4: (lv_name_0_0= RULE_STRING )
            // InternalSingleCodetemplateParser.g:141:5: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_3); 

            					newLeafNode(lv_name_0_0, grammarAccess.getCodetemplateAccess().getNameSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCodetemplateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.ui.codetemplates.Codetemplates.STRING");
            				

            }


            }

            otherlv_1=(Token)match(input,For,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getCodetemplateAccess().getForKeyword_1());
            		
            // InternalSingleCodetemplateParser.g:161:3: ( ( ( ruleValidID ) ) | ( (lv_keywordContext_3_0= RULE_STRING ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=Templates && LA1_0<=For)||LA1_0==RULE_ID) ) {
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
                    // InternalSingleCodetemplateParser.g:162:4: ( ( ruleValidID ) )
                    {
                    // InternalSingleCodetemplateParser.g:162:4: ( ( ruleValidID ) )
                    // InternalSingleCodetemplateParser.g:163:5: ( ruleValidID )
                    {
                    // InternalSingleCodetemplateParser.g:163:5: ( ruleValidID )
                    // InternalSingleCodetemplateParser.g:164:6: ruleValidID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCodetemplateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_2_0_0());
                    					
                    pushFollow(FOLLOW_7);
                    ruleValidID();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:179:4: ( (lv_keywordContext_3_0= RULE_STRING ) )
                    {
                    // InternalSingleCodetemplateParser.g:179:4: ( (lv_keywordContext_3_0= RULE_STRING ) )
                    // InternalSingleCodetemplateParser.g:180:5: (lv_keywordContext_3_0= RULE_STRING )
                    {
                    // InternalSingleCodetemplateParser.g:180:5: (lv_keywordContext_3_0= RULE_STRING )
                    // InternalSingleCodetemplateParser.g:181:6: lv_keywordContext_3_0= RULE_STRING
                    {
                    lv_keywordContext_3_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

                    						newLeafNode(lv_keywordContext_3_0, grammarAccess.getCodetemplateAccess().getKeywordContextSTRINGTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCodetemplateRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"keywordContext",
                    							lv_keywordContext_3_0,
                    							"org.eclipse.xtext.ui.codetemplates.Codetemplates.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSingleCodetemplateParser.g:198:3: ( (lv_body_4_0= ruleTemplateBodyWithQuotes ) )
            // InternalSingleCodetemplateParser.g:199:4: (lv_body_4_0= ruleTemplateBodyWithQuotes )
            {
            // InternalSingleCodetemplateParser.g:199:4: (lv_body_4_0= ruleTemplateBodyWithQuotes )
            // InternalSingleCodetemplateParser.g:200:5: lv_body_4_0= ruleTemplateBodyWithQuotes
            {

            					newCompositeNode(grammarAccess.getCodetemplateAccess().getBodyTemplateBodyWithQuotesParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_body_4_0=ruleTemplateBodyWithQuotes();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCodetemplateRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_4_0,
            						"org.eclipse.xtext.ui.codetemplates.SingleCodetemplate.TemplateBodyWithQuotes");
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
    // InternalSingleCodetemplateParser.g:221:1: entryRuleTemplateBodyWithQuotes returns [EObject current=null] : iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF ;
    public final EObject entryRuleTemplateBodyWithQuotes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBodyWithQuotes = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:223:2: (iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF )
            // InternalSingleCodetemplateParser.g:224:2: iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF
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
    // InternalSingleCodetemplateParser.g:233:1: ruleTemplateBodyWithQuotes returns [EObject current=null] : (otherlv_0= GreaterThanSignGreaterThanSign this_TemplateBody_1= ruleTemplateBody ) ;
    public final EObject ruleTemplateBodyWithQuotes() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TemplateBody_1 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:240:2: ( (otherlv_0= GreaterThanSignGreaterThanSign this_TemplateBody_1= ruleTemplateBody ) )
            // InternalSingleCodetemplateParser.g:241:2: (otherlv_0= GreaterThanSignGreaterThanSign this_TemplateBody_1= ruleTemplateBody )
            {
            // InternalSingleCodetemplateParser.g:241:2: (otherlv_0= GreaterThanSignGreaterThanSign this_TemplateBody_1= ruleTemplateBody )
            // InternalSingleCodetemplateParser.g:242:3: otherlv_0= GreaterThanSignGreaterThanSign this_TemplateBody_1= ruleTemplateBody
            {
            otherlv_0=(Token)match(input,GreaterThanSignGreaterThanSign,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getTemplateBodyWithQuotesAccess().getGreaterThanSignGreaterThanSignKeyword_0());
            		

            			newCompositeNode(grammarAccess.getTemplateBodyWithQuotesAccess().getTemplateBodyParserRuleCall_1());
            		
            pushFollow(FOLLOW_2);
            this_TemplateBody_1=ruleTemplateBody();

            state._fsp--;


            			current = this_TemplateBody_1;
            			afterParserOrEnumRuleCall();
            		

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


    // $ANTLR start "entryRuleLiteralValue"
    // InternalSingleCodetemplateParser.g:261:1: entryRuleLiteralValue returns [String current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final String entryRuleLiteralValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteralValue = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:263:2: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // InternalSingleCodetemplateParser.g:264:2: iv_ruleLiteralValue= ruleLiteralValue EOF
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
    // InternalSingleCodetemplateParser.g:273:1: ruleLiteralValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID )+ ;
    public final AntlrDatatypeRuleToken ruleLiteralValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token this_ANY_OTHER_1=null;
        Token this_ID_2=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:280:2: ( (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID )+ )
            // InternalSingleCodetemplateParser.g:281:2: (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID )+
            {
            // InternalSingleCodetemplateParser.g:281:2: (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID )+
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
            	    // InternalSingleCodetemplateParser.g:282:3: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_9); 

            	    			current.merge(this_WS_0);
            	    		

            	    			newLeafNode(this_WS_0, grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalSingleCodetemplateParser.g:290:3: this_ANY_OTHER_1= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_1=(Token)match(input,RULE_ANY_OTHER,FOLLOW_9); 

            	    			current.merge(this_ANY_OTHER_1);
            	    		

            	    			newLeafNode(this_ANY_OTHER_1, grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalSingleCodetemplateParser.g:298:3: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    			current.merge(this_ID_2);
            	    		

            	    			newLeafNode(this_ID_2, grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2());
            	    		

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


    // $ANTLR start "entryRuleTemplateBody"
    // InternalSingleCodetemplateParser.g:312:1: entryRuleTemplateBody returns [EObject current=null] : iv_ruleTemplateBody= ruleTemplateBody EOF ;
    public final EObject entryRuleTemplateBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBody = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:314:2: (iv_ruleTemplateBody= ruleTemplateBody EOF )
            // InternalSingleCodetemplateParser.g:315:2: iv_ruleTemplateBody= ruleTemplateBody EOF
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
    // InternalSingleCodetemplateParser.g:324:1: ruleTemplateBody returns [EObject current=null] : ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* ) ;
    public final EObject ruleTemplateBody() throws RecognitionException {
        EObject current = null;

        EObject lv_parts_1_0 = null;

        EObject lv_parts_2_0 = null;

        EObject lv_parts_3_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:331:2: ( ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* ) )
            // InternalSingleCodetemplateParser.g:332:2: ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* )
            {
            // InternalSingleCodetemplateParser.g:332:2: ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* )
            // InternalSingleCodetemplateParser.g:333:3: () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )*
            {
            // InternalSingleCodetemplateParser.g:333:3: ()
            // InternalSingleCodetemplateParser.g:334:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0(),
            					current);
            			

            }

            // InternalSingleCodetemplateParser.g:340:3: ( (lv_parts_1_0= ruleLiteral ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID||(LA3_0>=RULE_WS && LA3_0<=RULE_ANY_OTHER)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:341:4: (lv_parts_1_0= ruleLiteral )
                    {
                    // InternalSingleCodetemplateParser.g:341:4: (lv_parts_1_0= ruleLiteral )
                    // InternalSingleCodetemplateParser.g:342:5: lv_parts_1_0= ruleLiteral
                    {

                    					newCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_10);
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

            // InternalSingleCodetemplateParser.g:359:3: ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=DollarSignDollarSign && LA5_0<=DollarSignLeftCurlyBracket)||LA5_0==DollarSign) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:360:4: ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )?
            	    {
            	    // InternalSingleCodetemplateParser.g:360:4: ( (lv_parts_2_0= ruleVariableOrDollar ) )
            	    // InternalSingleCodetemplateParser.g:361:5: (lv_parts_2_0= ruleVariableOrDollar )
            	    {
            	    // InternalSingleCodetemplateParser.g:361:5: (lv_parts_2_0= ruleVariableOrDollar )
            	    // InternalSingleCodetemplateParser.g:362:6: lv_parts_2_0= ruleVariableOrDollar
            	    {

            	    						newCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsVariableOrDollarParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_11);
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

            	    // InternalSingleCodetemplateParser.g:379:4: ( (lv_parts_3_0= ruleLiteral ) )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==RULE_ID||(LA4_0>=RULE_WS && LA4_0<=RULE_ANY_OTHER)) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // InternalSingleCodetemplateParser.g:380:5: (lv_parts_3_0= ruleLiteral )
            	            {
            	            // InternalSingleCodetemplateParser.g:380:5: (lv_parts_3_0= ruleLiteral )
            	            // InternalSingleCodetemplateParser.g:381:6: lv_parts_3_0= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_2_1_0());
            	            					
            	            pushFollow(FOLLOW_10);
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
            	    break loop5;
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
    // InternalSingleCodetemplateParser.g:406:1: entryRuleVariableOrDollar returns [EObject current=null] : iv_ruleVariableOrDollar= ruleVariableOrDollar EOF ;
    public final EObject entryRuleVariableOrDollar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableOrDollar = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:408:2: (iv_ruleVariableOrDollar= ruleVariableOrDollar EOF )
            // InternalSingleCodetemplateParser.g:409:2: iv_ruleVariableOrDollar= ruleVariableOrDollar EOF
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
    // InternalSingleCodetemplateParser.g:418:1: ruleVariableOrDollar returns [EObject current=null] : (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar ) ;
    public final EObject ruleVariableOrDollar() throws RecognitionException {
        EObject current = null;

        EObject this_Variable_0 = null;

        EObject this_Dollar_1 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:425:2: ( (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar ) )
            // InternalSingleCodetemplateParser.g:426:2: (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar )
            {
            // InternalSingleCodetemplateParser.g:426:2: (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DollarSignLeftCurlyBracket) ) {
                alt6=1;
            }
            else if ( (LA6_0==DollarSignDollarSign||LA6_0==DollarSign) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:427:3: this_Variable_0= ruleVariable
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
                    // InternalSingleCodetemplateParser.g:436:3: this_Dollar_1= ruleDollar
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
    // InternalSingleCodetemplateParser.g:451:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:453:2: (iv_ruleVariable= ruleVariable EOF )
            // InternalSingleCodetemplateParser.g:454:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalSingleCodetemplateParser.g:463:1: ruleVariable returns [EObject current=null] : (otherlv_0= DollarSignLeftCurlyBracket (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) ) (this_WS_18= RULE_WS )* otherlv_19= RightCurlyBracket ) ;
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
            // InternalSingleCodetemplateParser.g:470:2: ( (otherlv_0= DollarSignLeftCurlyBracket (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) ) (this_WS_18= RULE_WS )* otherlv_19= RightCurlyBracket ) )
            // InternalSingleCodetemplateParser.g:471:2: (otherlv_0= DollarSignLeftCurlyBracket (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) ) (this_WS_18= RULE_WS )* otherlv_19= RightCurlyBracket )
            {
            // InternalSingleCodetemplateParser.g:471:2: (otherlv_0= DollarSignLeftCurlyBracket (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) ) (this_WS_18= RULE_WS )* otherlv_19= RightCurlyBracket )
            // InternalSingleCodetemplateParser.g:472:3: otherlv_0= DollarSignLeftCurlyBracket (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) ) (this_WS_18= RULE_WS )* otherlv_19= RightCurlyBracket
            {
            otherlv_0=(Token)match(input,DollarSignLeftCurlyBracket,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getDollarSignLeftCurlyBracketKeyword_0());
            		
            // InternalSingleCodetemplateParser.g:476:3: (this_WS_1= RULE_WS )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_WS) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:477:4: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); 

            	    				newLeafNode(this_WS_1, grammarAccess.getVariableAccess().getWSTerminalRuleCall_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalSingleCodetemplateParser.g:482:3: ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) )
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:483:4: ( (lv_name_2_0= ruleValidID ) )
                    {
                    // InternalSingleCodetemplateParser.g:483:4: ( (lv_name_2_0= ruleValidID ) )
                    // InternalSingleCodetemplateParser.g:484:5: (lv_name_2_0= ruleValidID )
                    {
                    // InternalSingleCodetemplateParser.g:484:5: (lv_name_2_0= ruleValidID )
                    // InternalSingleCodetemplateParser.g:485:6: lv_name_2_0= ruleValidID
                    {

                    						newCompositeNode(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_13);
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
                    // InternalSingleCodetemplateParser.g:503:4: ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? )
                    {
                    // InternalSingleCodetemplateParser.g:503:4: ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? )
                    // InternalSingleCodetemplateParser.g:504:5: ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )?
                    {
                    // InternalSingleCodetemplateParser.g:504:5: ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=Templates && LA9_0<=For)||LA9_0==RULE_ID) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalSingleCodetemplateParser.g:505:6: ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )*
                            {
                            // InternalSingleCodetemplateParser.g:505:6: ( (lv_name_3_0= ruleValidID ) )
                            // InternalSingleCodetemplateParser.g:506:7: (lv_name_3_0= ruleValidID )
                            {
                            // InternalSingleCodetemplateParser.g:506:7: (lv_name_3_0= ruleValidID )
                            // InternalSingleCodetemplateParser.g:507:8: lv_name_3_0= ruleValidID
                            {

                            								newCompositeNode(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_1_0_0_0());
                            							
                            pushFollow(FOLLOW_14);
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

                            // InternalSingleCodetemplateParser.g:524:6: (this_WS_4= RULE_WS )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==RULE_WS) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // InternalSingleCodetemplateParser.g:525:7: this_WS_4= RULE_WS
                            	    {
                            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_14); 

                            	    							newLeafNode(this_WS_4, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1());
                            	    						

                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,Colon,FOLLOW_15); 

                    					newLeafNode(otherlv_5, grammarAccess.getVariableAccess().getColonKeyword_2_1_1());
                    				
                    // InternalSingleCodetemplateParser.g:535:5: (this_WS_6= RULE_WS )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_WS) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalSingleCodetemplateParser.g:536:6: this_WS_6= RULE_WS
                    	    {
                    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_15); 

                    	    						newLeafNode(this_WS_6, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2());
                    	    					

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // InternalSingleCodetemplateParser.g:541:5: ( (lv_type_7_0= ruleValidID ) )
                    // InternalSingleCodetemplateParser.g:542:6: (lv_type_7_0= ruleValidID )
                    {
                    // InternalSingleCodetemplateParser.g:542:6: (lv_type_7_0= ruleValidID )
                    // InternalSingleCodetemplateParser.g:543:7: lv_type_7_0= ruleValidID
                    {

                    							newCompositeNode(grammarAccess.getVariableAccess().getTypeValidIDParserRuleCall_2_1_3_0());
                    						
                    pushFollow(FOLLOW_16);
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

                    // InternalSingleCodetemplateParser.g:560:5: ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )?
                    int alt20=2;
                    alt20 = dfa20.predict(input);
                    switch (alt20) {
                        case 1 :
                            // InternalSingleCodetemplateParser.g:561:6: (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis
                            {
                            // InternalSingleCodetemplateParser.g:561:6: (this_WS_8= RULE_WS )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==RULE_WS) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // InternalSingleCodetemplateParser.g:562:7: this_WS_8= RULE_WS
                            	    {
                            	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_17); 

                            	    							newLeafNode(this_WS_8, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0());
                            	    						

                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);

                            // InternalSingleCodetemplateParser.g:567:6: ( (lv_expectingParameters_9_0= LeftParenthesis ) )
                            // InternalSingleCodetemplateParser.g:568:7: (lv_expectingParameters_9_0= LeftParenthesis )
                            {
                            // InternalSingleCodetemplateParser.g:568:7: (lv_expectingParameters_9_0= LeftParenthesis )
                            // InternalSingleCodetemplateParser.g:569:8: lv_expectingParameters_9_0= LeftParenthesis
                            {
                            lv_expectingParameters_9_0=(Token)match(input,LeftParenthesis,FOLLOW_18); 

                            								newLeafNode(lv_expectingParameters_9_0, grammarAccess.getVariableAccess().getExpectingParametersLeftParenthesisKeyword_2_1_4_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getVariableRule());
                            								}
                            								setWithLastConsumed(current, "expectingParameters", lv_expectingParameters_9_0 != null, "(");
                            							

                            }


                            }

                            // InternalSingleCodetemplateParser.g:581:6: (this_WS_10= RULE_WS )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==RULE_WS) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // InternalSingleCodetemplateParser.g:582:7: this_WS_10= RULE_WS
                            	    {
                            	    this_WS_10=(Token)match(input,RULE_WS,FOLLOW_18); 

                            	    							newLeafNode(this_WS_10, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2());
                            	    						

                            	    }
                            	    break;

                            	default :
                            	    break loop12;
                                }
                            } while (true);

                            // InternalSingleCodetemplateParser.g:587:6: ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )?
                            int alt19=2;
                            int LA19_0 = input.LA(1);

                            if ( ((LA19_0>=Templates && LA19_0<=For)||(LA19_0>=RULE_ID && LA19_0<=RULE_STRING)) ) {
                                alt19=1;
                            }
                            switch (alt19) {
                                case 1 :
                                    // InternalSingleCodetemplateParser.g:588:7: ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )*
                                    {
                                    // InternalSingleCodetemplateParser.g:588:7: ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) )
                                    // InternalSingleCodetemplateParser.g:589:8: ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) )
                                    {
                                    // InternalSingleCodetemplateParser.g:589:8: ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) )
                                    // InternalSingleCodetemplateParser.g:590:9: (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN )
                                    {
                                    // InternalSingleCodetemplateParser.g:590:9: (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN )
                                    int alt13=2;
                                    int LA13_0 = input.LA(1);

                                    if ( (LA13_0==RULE_STRING) ) {
                                        alt13=1;
                                    }
                                    else if ( ((LA13_0>=Templates && LA13_0<=For)||LA13_0==RULE_ID) ) {
                                        alt13=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 13, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt13) {
                                        case 1 :
                                            // InternalSingleCodetemplateParser.g:591:10: lv_parameters_11_1= RULE_STRING
                                            {
                                            lv_parameters_11_1=(Token)match(input,RULE_STRING,FOLLOW_19); 

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
                                            // InternalSingleCodetemplateParser.g:606:10: lv_parameters_11_2= ruleFQN
                                            {

                                            										newCompositeNode(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_0_0_1());
                                            									
                                            pushFollow(FOLLOW_19);
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

                                    // InternalSingleCodetemplateParser.g:624:7: ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )*
                                    loop17:
                                    do {
                                        int alt17=2;
                                        alt17 = dfa17.predict(input);
                                        switch (alt17) {
                                    	case 1 :
                                    	    // InternalSingleCodetemplateParser.g:625:8: (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) )
                                    	    {
                                    	    // InternalSingleCodetemplateParser.g:625:8: (this_WS_12= RULE_WS )*
                                    	    loop14:
                                    	    do {
                                    	        int alt14=2;
                                    	        int LA14_0 = input.LA(1);

                                    	        if ( (LA14_0==RULE_WS) ) {
                                    	            alt14=1;
                                    	        }


                                    	        switch (alt14) {
                                    	    	case 1 :
                                    	    	    // InternalSingleCodetemplateParser.g:626:9: this_WS_12= RULE_WS
                                    	    	    {
                                    	    	    this_WS_12=(Token)match(input,RULE_WS,FOLLOW_20); 

                                    	    	    									newLeafNode(this_WS_12, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_0());
                                    	    	    								

                                    	    	    }
                                    	    	    break;

                                    	    	default :
                                    	    	    break loop14;
                                    	        }
                                    	    } while (true);

                                    	    otherlv_13=(Token)match(input,Comma,FOLLOW_21); 

                                    	    								newLeafNode(otherlv_13, grammarAccess.getVariableAccess().getCommaKeyword_2_1_4_3_1_1());
                                    	    							
                                    	    // InternalSingleCodetemplateParser.g:635:8: (this_WS_14= RULE_WS )*
                                    	    loop15:
                                    	    do {
                                    	        int alt15=2;
                                    	        int LA15_0 = input.LA(1);

                                    	        if ( (LA15_0==RULE_WS) ) {
                                    	            alt15=1;
                                    	        }


                                    	        switch (alt15) {
                                    	    	case 1 :
                                    	    	    // InternalSingleCodetemplateParser.g:636:9: this_WS_14= RULE_WS
                                    	    	    {
                                    	    	    this_WS_14=(Token)match(input,RULE_WS,FOLLOW_21); 

                                    	    	    									newLeafNode(this_WS_14, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_2());
                                    	    	    								

                                    	    	    }
                                    	    	    break;

                                    	    	default :
                                    	    	    break loop15;
                                    	        }
                                    	    } while (true);

                                    	    // InternalSingleCodetemplateParser.g:641:8: ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) )
                                    	    // InternalSingleCodetemplateParser.g:642:9: ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) )
                                    	    {
                                    	    // InternalSingleCodetemplateParser.g:642:9: ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) )
                                    	    // InternalSingleCodetemplateParser.g:643:10: (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN )
                                    	    {
                                    	    // InternalSingleCodetemplateParser.g:643:10: (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN )
                                    	    int alt16=2;
                                    	    int LA16_0 = input.LA(1);

                                    	    if ( (LA16_0==RULE_STRING) ) {
                                    	        alt16=1;
                                    	    }
                                    	    else if ( ((LA16_0>=Templates && LA16_0<=For)||LA16_0==RULE_ID) ) {
                                    	        alt16=2;
                                    	    }
                                    	    else {
                                    	        NoViableAltException nvae =
                                    	            new NoViableAltException("", 16, 0, input);

                                    	        throw nvae;
                                    	    }
                                    	    switch (alt16) {
                                    	        case 1 :
                                    	            // InternalSingleCodetemplateParser.g:644:11: lv_parameters_15_1= RULE_STRING
                                    	            {
                                    	            lv_parameters_15_1=(Token)match(input,RULE_STRING,FOLLOW_19); 

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
                                    	            // InternalSingleCodetemplateParser.g:659:11: lv_parameters_15_2= ruleFQN
                                    	            {

                                    	            											newCompositeNode(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_1_3_0_1());
                                    	            										
                                    	            pushFollow(FOLLOW_19);
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
                                    	    break loop17;
                                        }
                                    } while (true);

                                    // InternalSingleCodetemplateParser.g:678:7: (this_WS_16= RULE_WS )*
                                    loop18:
                                    do {
                                        int alt18=2;
                                        int LA18_0 = input.LA(1);

                                        if ( (LA18_0==RULE_WS) ) {
                                            alt18=1;
                                        }


                                        switch (alt18) {
                                    	case 1 :
                                    	    // InternalSingleCodetemplateParser.g:679:8: this_WS_16= RULE_WS
                                    	    {
                                    	    this_WS_16=(Token)match(input,RULE_WS,FOLLOW_22); 

                                    	    								newLeafNode(this_WS_16, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_2());
                                    	    							

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop18;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            otherlv_17=(Token)match(input,RightParenthesis,FOLLOW_13); 

                            						newLeafNode(otherlv_17, grammarAccess.getVariableAccess().getRightParenthesisKeyword_2_1_4_4());
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalSingleCodetemplateParser.g:692:3: (this_WS_18= RULE_WS )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_WS) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:693:4: this_WS_18= RULE_WS
            	    {
            	    this_WS_18=(Token)match(input,RULE_WS,FOLLOW_13); 

            	    				newLeafNode(this_WS_18, grammarAccess.getVariableAccess().getWSTerminalRuleCall_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalSingleCodetemplateParser.g:709:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:711:2: (iv_ruleValidID= ruleValidID EOF )
            // InternalSingleCodetemplateParser.g:712:2: iv_ruleValidID= ruleValidID EOF
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
    // InternalSingleCodetemplateParser.g:721:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= For | kw= Templates ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:728:2: ( (this_ID_0= RULE_ID | kw= For | kw= Templates ) )
            // InternalSingleCodetemplateParser.g:729:2: (this_ID_0= RULE_ID | kw= For | kw= Templates )
            {
            // InternalSingleCodetemplateParser.g:729:2: (this_ID_0= RULE_ID | kw= For | kw= Templates )
            int alt23=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt23=1;
                }
                break;
            case For:
                {
                alt23=2;
                }
                break;
            case Templates:
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
                    // InternalSingleCodetemplateParser.g:730:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSingleCodetemplateParser.g:738:3: kw= For
                    {
                    kw=(Token)match(input,For,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getValidIDAccess().getForKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSingleCodetemplateParser.g:744:3: kw= Templates
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
    // InternalSingleCodetemplateParser.g:756:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:758:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalSingleCodetemplateParser.g:759:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalSingleCodetemplateParser.g:768:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= FullStop this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:775:2: ( (this_ValidID_0= ruleValidID (kw= FullStop this_ValidID_2= ruleValidID )* ) )
            // InternalSingleCodetemplateParser.g:776:2: (this_ValidID_0= ruleValidID (kw= FullStop this_ValidID_2= ruleValidID )* )
            {
            // InternalSingleCodetemplateParser.g:776:2: (this_ValidID_0= ruleValidID (kw= FullStop this_ValidID_2= ruleValidID )* )
            // InternalSingleCodetemplateParser.g:777:3: this_ValidID_0= ruleValidID (kw= FullStop this_ValidID_2= ruleValidID )*
            {

            			newCompositeNode(grammarAccess.getFQNAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FOLLOW_23);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalSingleCodetemplateParser.g:787:3: (kw= FullStop this_ValidID_2= ruleValidID )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==FullStop) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalSingleCodetemplateParser.g:788:4: kw= FullStop this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getFQNAccess().getValidIDParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_23);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    				current.merge(this_ValidID_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalSingleCodetemplateParser.g:811:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:813:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalSingleCodetemplateParser.g:814:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalSingleCodetemplateParser.g:823:1: ruleLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleLiteralValue ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:830:2: ( ( (lv_value_0_0= ruleLiteralValue ) ) )
            // InternalSingleCodetemplateParser.g:831:2: ( (lv_value_0_0= ruleLiteralValue ) )
            {
            // InternalSingleCodetemplateParser.g:831:2: ( (lv_value_0_0= ruleLiteralValue ) )
            // InternalSingleCodetemplateParser.g:832:3: (lv_value_0_0= ruleLiteralValue )
            {
            // InternalSingleCodetemplateParser.g:832:3: (lv_value_0_0= ruleLiteralValue )
            // InternalSingleCodetemplateParser.g:833:4: lv_value_0_0= ruleLiteralValue
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
            					"org.eclipse.xtext.ui.codetemplates.SingleCodetemplate.LiteralValue");
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


    // $ANTLR start "entryRuleDollar"
    // InternalSingleCodetemplateParser.g:856:1: entryRuleDollar returns [EObject current=null] : iv_ruleDollar= ruleDollar EOF ;
    public final EObject entryRuleDollar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDollar = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:858:2: (iv_ruleDollar= ruleDollar EOF )
            // InternalSingleCodetemplateParser.g:859:2: iv_ruleDollar= ruleDollar EOF
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
    // InternalSingleCodetemplateParser.g:868:1: ruleDollar returns [EObject current=null] : ( () ( ( (lv_escaped_1_0= DollarSignDollarSign ) ) | otherlv_2= DollarSign ) ) ;
    public final EObject ruleDollar() throws RecognitionException {
        EObject current = null;

        Token lv_escaped_1_0=null;
        Token otherlv_2=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalSingleCodetemplateParser.g:875:2: ( ( () ( ( (lv_escaped_1_0= DollarSignDollarSign ) ) | otherlv_2= DollarSign ) ) )
            // InternalSingleCodetemplateParser.g:876:2: ( () ( ( (lv_escaped_1_0= DollarSignDollarSign ) ) | otherlv_2= DollarSign ) )
            {
            // InternalSingleCodetemplateParser.g:876:2: ( () ( ( (lv_escaped_1_0= DollarSignDollarSign ) ) | otherlv_2= DollarSign ) )
            // InternalSingleCodetemplateParser.g:877:3: () ( ( (lv_escaped_1_0= DollarSignDollarSign ) ) | otherlv_2= DollarSign )
            {
            // InternalSingleCodetemplateParser.g:877:3: ()
            // InternalSingleCodetemplateParser.g:878:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDollarAccess().getDollarAction_0(),
            					current);
            			

            }

            // InternalSingleCodetemplateParser.g:884:3: ( ( (lv_escaped_1_0= DollarSignDollarSign ) ) | otherlv_2= DollarSign )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==DollarSignDollarSign) ) {
                alt25=1;
            }
            else if ( (LA25_0==DollarSign) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalSingleCodetemplateParser.g:885:4: ( (lv_escaped_1_0= DollarSignDollarSign ) )
                    {
                    // InternalSingleCodetemplateParser.g:885:4: ( (lv_escaped_1_0= DollarSignDollarSign ) )
                    // InternalSingleCodetemplateParser.g:886:5: (lv_escaped_1_0= DollarSignDollarSign )
                    {
                    // InternalSingleCodetemplateParser.g:886:5: (lv_escaped_1_0= DollarSignDollarSign )
                    // InternalSingleCodetemplateParser.g:887:6: lv_escaped_1_0= DollarSignDollarSign
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
                    // InternalSingleCodetemplateParser.g:900:4: otherlv_2= DollarSign
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


    protected DFA21 dfa21 = new DFA21(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\4\3\16\1\uffff\1\16\1\uffff";
    static final String dfa_3s = "\1\20\3\22\1\uffff\1\22\1\uffff";
    static final String dfa_4s = "\4\uffff\1\2\1\uffff\1\1";
    static final String dfa_5s = "\7\uffff}>";
    static final String[] dfa_6s = {
            "\1\3\1\2\10\uffff\1\4\1\uffff\1\1",
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

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "482:3: ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= Colon (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )? ) )";
        }
    }
    static final String dfa_7s = "\4\uffff";
    static final String dfa_8s = "\2\12\2\uffff";
    static final String dfa_9s = "\2\22\2\uffff";
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

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "560:5: ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= LeftParenthesis ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= RightParenthesis )?";
        }
    }
    static final String dfa_13s = "\2\13\2\uffff";
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

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_13;
            this.max = dfa_9;
            this.accept = dfa_14;
            this.special = dfa_11;
            this.transition = dfa_15;
        }
        public String getDescription() {
            return "()* loopback of 624:7: ( (this_WS_12= RULE_WS )* otherlv_13= Comma (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000D02C0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000D0002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000002C2L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000D02C2L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000054030L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000050030L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000048400L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000070830L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000041800L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000040800L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000002002L});

}
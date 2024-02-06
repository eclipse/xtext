package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.GH341TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalGH341TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'works'", "'.'", "';'", "'X'", "'broken'", "'stream'", "'define'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalGH341TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGH341TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGH341TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGH341TestLanguage.g"; }



     	private GH341TestLanguageGrammarAccess grammarAccess;

        public InternalGH341TestLanguageParser(TokenStream input, GH341TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected GH341TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalGH341TestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalGH341TestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalGH341TestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalGH341TestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_elements_0_1= ruleWorks | lv_elements_0_2= ruleBroken | lv_elements_0_3= ruleThird ) ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_1 = null;

        EObject lv_elements_0_2 = null;

        EObject lv_elements_0_3 = null;



        	enterRule();

        try {
            // InternalGH341TestLanguage.g:82:2: ( ( ( (lv_elements_0_1= ruleWorks | lv_elements_0_2= ruleBroken | lv_elements_0_3= ruleThird ) ) )* )
            // InternalGH341TestLanguage.g:83:2: ( ( (lv_elements_0_1= ruleWorks | lv_elements_0_2= ruleBroken | lv_elements_0_3= ruleThird ) ) )*
            {
            // InternalGH341TestLanguage.g:83:2: ( ( (lv_elements_0_1= ruleWorks | lv_elements_0_2= ruleBroken | lv_elements_0_3= ruleThird ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11||LA2_0==15||LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:84:3: ( (lv_elements_0_1= ruleWorks | lv_elements_0_2= ruleBroken | lv_elements_0_3= ruleThird ) )
            	    {
            	    // InternalGH341TestLanguage.g:84:3: ( (lv_elements_0_1= ruleWorks | lv_elements_0_2= ruleBroken | lv_elements_0_3= ruleThird ) )
            	    // InternalGH341TestLanguage.g:85:4: (lv_elements_0_1= ruleWorks | lv_elements_0_2= ruleBroken | lv_elements_0_3= ruleThird )
            	    {
            	    // InternalGH341TestLanguage.g:85:4: (lv_elements_0_1= ruleWorks | lv_elements_0_2= ruleBroken | lv_elements_0_3= ruleThird )
            	    int alt1=3;
            	    switch ( input.LA(1) ) {
            	    case 11:
            	        {
            	        alt1=1;
            	        }
            	        break;
            	    case 15:
            	        {
            	        alt1=2;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt1=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt1) {
            	        case 1 :
            	            // InternalGH341TestLanguage.g:86:5: lv_elements_0_1= ruleWorks
            	            {

            	            					newCompositeNode(grammarAccess.getModelAccess().getElementsWorksParserRuleCall_0_0());
            	            				
            	            pushFollow(FollowSets000.FOLLOW_3);
            	            lv_elements_0_1=ruleWorks();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getModelRule());
            	            					}
            	            					add(
            	            						current,
            	            						"elements",
            	            						lv_elements_0_1,
            	            						"org.eclipse.xtext.ui.tests.editor.contentassist.GH341TestLanguage.Works");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalGH341TestLanguage.g:102:5: lv_elements_0_2= ruleBroken
            	            {

            	            					newCompositeNode(grammarAccess.getModelAccess().getElementsBrokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FollowSets000.FOLLOW_3);
            	            lv_elements_0_2=ruleBroken();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getModelRule());
            	            					}
            	            					add(
            	            						current,
            	            						"elements",
            	            						lv_elements_0_2,
            	            						"org.eclipse.xtext.ui.tests.editor.contentassist.GH341TestLanguage.Broken");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;
            	        case 3 :
            	            // InternalGH341TestLanguage.g:118:5: lv_elements_0_3= ruleThird
            	            {

            	            					newCompositeNode(grammarAccess.getModelAccess().getElementsThirdParserRuleCall_0_2());
            	            				
            	            pushFollow(FollowSets000.FOLLOW_3);
            	            lv_elements_0_3=ruleThird();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getModelRule());
            	            					}
            	            					add(
            	            						current,
            	            						"elements",
            	            						lv_elements_0_3,
            	            						"org.eclipse.xtext.ui.tests.editor.contentassist.GH341TestLanguage.Third");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleWorks"
    // InternalGH341TestLanguage.g:139:1: entryRuleWorks returns [EObject current=null] : iv_ruleWorks= ruleWorks EOF ;
    public final EObject entryRuleWorks() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorks = null;


        try {
            // InternalGH341TestLanguage.g:139:46: (iv_ruleWorks= ruleWorks EOF )
            // InternalGH341TestLanguage.g:140:2: iv_ruleWorks= ruleWorks EOF
            {
             newCompositeNode(grammarAccess.getWorksRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWorks=ruleWorks();

            state._fsp--;

             current =iv_ruleWorks; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleWorks"


    // $ANTLR start "ruleWorks"
    // InternalGH341TestLanguage.g:146:1: ruleWorks returns [EObject current=null] : (otherlv_0= 'works' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_ids_4_0= RULE_ID ) ) )* otherlv_5= ';' )* ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (otherlv_8= RULE_ID ) ) )* otherlv_9= 'X' otherlv_10= ';' )* ) ;
    public final EObject ruleWorks() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_ids_2_0=null;
        Token otherlv_3=null;
        Token lv_ids_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;


        	enterRule();

        try {
            // InternalGH341TestLanguage.g:152:2: ( (otherlv_0= 'works' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_ids_4_0= RULE_ID ) ) )* otherlv_5= ';' )* ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (otherlv_8= RULE_ID ) ) )* otherlv_9= 'X' otherlv_10= ';' )* ) )
            // InternalGH341TestLanguage.g:153:2: (otherlv_0= 'works' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_ids_4_0= RULE_ID ) ) )* otherlv_5= ';' )* ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (otherlv_8= RULE_ID ) ) )* otherlv_9= 'X' otherlv_10= ';' )* )
            {
            // InternalGH341TestLanguage.g:153:2: (otherlv_0= 'works' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_ids_4_0= RULE_ID ) ) )* otherlv_5= ';' )* ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (otherlv_8= RULE_ID ) ) )* otherlv_9= 'X' otherlv_10= ';' )* )
            // InternalGH341TestLanguage.g:154:3: otherlv_0= 'works' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_ids_4_0= RULE_ID ) ) )* otherlv_5= ';' )* ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (otherlv_8= RULE_ID ) ) )* otherlv_9= 'X' otherlv_10= ';' )*
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getWorksAccess().getWorksKeyword_0());
            		
            // InternalGH341TestLanguage.g:158:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGH341TestLanguage.g:159:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGH341TestLanguage.g:159:4: (lv_name_1_0= RULE_ID )
            // InternalGH341TestLanguage.g:160:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getWorksAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWorksRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalGH341TestLanguage.g:176:3: ( ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_ids_4_0= RULE_ID ) ) )* otherlv_5= ';' )*
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:177:4: ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_ids_4_0= RULE_ID ) ) )* otherlv_5= ';'
            	    {
            	    // InternalGH341TestLanguage.g:177:4: ( (lv_ids_2_0= RULE_ID ) )
            	    // InternalGH341TestLanguage.g:178:5: (lv_ids_2_0= RULE_ID )
            	    {
            	    // InternalGH341TestLanguage.g:178:5: (lv_ids_2_0= RULE_ID )
            	    // InternalGH341TestLanguage.g:179:6: lv_ids_2_0= RULE_ID
            	    {
            	    lv_ids_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            	    						newLeafNode(lv_ids_2_0, grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_0_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getWorksRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"ids",
            	    							lv_ids_2_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }

            	    // InternalGH341TestLanguage.g:195:4: (otherlv_3= '.' ( (lv_ids_4_0= RULE_ID ) ) )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==12) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalGH341TestLanguage.g:196:5: otherlv_3= '.' ( (lv_ids_4_0= RULE_ID ) )
            	    	    {
            	    	    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            	    	    					newLeafNode(otherlv_3, grammarAccess.getWorksAccess().getFullStopKeyword_2_1_0());
            	    	    				
            	    	    // InternalGH341TestLanguage.g:200:5: ( (lv_ids_4_0= RULE_ID ) )
            	    	    // InternalGH341TestLanguage.g:201:6: (lv_ids_4_0= RULE_ID )
            	    	    {
            	    	    // InternalGH341TestLanguage.g:201:6: (lv_ids_4_0= RULE_ID )
            	    	    // InternalGH341TestLanguage.g:202:7: lv_ids_4_0= RULE_ID
            	    	    {
            	    	    lv_ids_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            	    	    							newLeafNode(lv_ids_4_0, grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_1_1_0());
            	    	    						

            	    	    							if (current==null) {
            	    	    								current = createModelElement(grammarAccess.getWorksRule());
            	    	    							}
            	    	    							addWithLastConsumed(
            	    	    								current,
            	    	    								"ids",
            	    	    								lv_ids_4_0,
            	    	    								"org.eclipse.xtext.common.Terminals.ID");
            	    	    						

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);

            	    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            	    				newLeafNode(otherlv_5, grammarAccess.getWorksAccess().getSemicolonKeyword_2_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalGH341TestLanguage.g:224:3: ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (otherlv_8= RULE_ID ) ) )* otherlv_9= 'X' otherlv_10= ';' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:225:4: ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (otherlv_8= RULE_ID ) ) )* otherlv_9= 'X' otherlv_10= ';'
            	    {
            	    // InternalGH341TestLanguage.g:225:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalGH341TestLanguage.g:226:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalGH341TestLanguage.g:226:5: (otherlv_6= RULE_ID )
            	    // InternalGH341TestLanguage.g:227:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getWorksRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            	    						newLeafNode(otherlv_6, grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_0_0());
            	    					

            	    }


            	    }

            	    // InternalGH341TestLanguage.g:238:4: (otherlv_7= '.' ( (otherlv_8= RULE_ID ) ) )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==12) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // InternalGH341TestLanguage.g:239:5: otherlv_7= '.' ( (otherlv_8= RULE_ID ) )
            	    	    {
            	    	    otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            	    	    					newLeafNode(otherlv_7, grammarAccess.getWorksAccess().getFullStopKeyword_3_1_0());
            	    	    				
            	    	    // InternalGH341TestLanguage.g:243:5: ( (otherlv_8= RULE_ID ) )
            	    	    // InternalGH341TestLanguage.g:244:6: (otherlv_8= RULE_ID )
            	    	    {
            	    	    // InternalGH341TestLanguage.g:244:6: (otherlv_8= RULE_ID )
            	    	    // InternalGH341TestLanguage.g:245:7: otherlv_8= RULE_ID
            	    	    {

            	    	    							if (current==null) {
            	    	    								current = createModelElement(grammarAccess.getWorksRule());
            	    	    							}
            	    	    						
            	    	    otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            	    	    							newLeafNode(otherlv_8, grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_1_1_0());
            	    	    						

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);

            	    otherlv_9=(Token)match(input,14,FollowSets000.FOLLOW_8); 

            	    				newLeafNode(otherlv_9, grammarAccess.getWorksAccess().getXKeyword_3_2());
            	    			
            	    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            	    				newLeafNode(otherlv_10, grammarAccess.getWorksAccess().getSemicolonKeyword_3_3());
            	    			

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
        }
        return current;
    }
    // $ANTLR end "ruleWorks"


    // $ANTLR start "entryRuleBroken"
    // InternalGH341TestLanguage.g:270:1: entryRuleBroken returns [EObject current=null] : iv_ruleBroken= ruleBroken EOF ;
    public final EObject entryRuleBroken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBroken = null;


        try {
            // InternalGH341TestLanguage.g:270:47: (iv_ruleBroken= ruleBroken EOF )
            // InternalGH341TestLanguage.g:271:2: iv_ruleBroken= ruleBroken EOF
            {
             newCompositeNode(grammarAccess.getBrokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBroken=ruleBroken();

            state._fsp--;

             current =iv_ruleBroken; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleBroken"


    // $ANTLR start "ruleBroken"
    // InternalGH341TestLanguage.g:277:1: ruleBroken returns [EObject current=null] : (otherlv_0= 'broken' ( (lv_name_1_0= RULE_ID ) ) this_Fragment_2= ruleFragment[$current] ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= 'X' otherlv_7= ';' )* ) ;
    public final EObject ruleBroken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject this_Fragment_2 = null;



        	enterRule();

        try {
            // InternalGH341TestLanguage.g:283:2: ( (otherlv_0= 'broken' ( (lv_name_1_0= RULE_ID ) ) this_Fragment_2= ruleFragment[$current] ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= 'X' otherlv_7= ';' )* ) )
            // InternalGH341TestLanguage.g:284:2: (otherlv_0= 'broken' ( (lv_name_1_0= RULE_ID ) ) this_Fragment_2= ruleFragment[$current] ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= 'X' otherlv_7= ';' )* )
            {
            // InternalGH341TestLanguage.g:284:2: (otherlv_0= 'broken' ( (lv_name_1_0= RULE_ID ) ) this_Fragment_2= ruleFragment[$current] ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= 'X' otherlv_7= ';' )* )
            // InternalGH341TestLanguage.g:285:3: otherlv_0= 'broken' ( (lv_name_1_0= RULE_ID ) ) this_Fragment_2= ruleFragment[$current] ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= 'X' otherlv_7= ';' )*
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getBrokenAccess().getBrokenKeyword_0());
            		
            // InternalGH341TestLanguage.g:289:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGH341TestLanguage.g:290:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGH341TestLanguage.g:290:4: (lv_name_1_0= RULE_ID )
            // InternalGH341TestLanguage.g:291:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getBrokenAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBrokenRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            			if (current==null) {
            				current = createModelElement(grammarAccess.getBrokenRule());
            			}
            			newCompositeNode(grammarAccess.getBrokenAccess().getFragmentParserRuleCall_2());
            		
            pushFollow(FollowSets000.FOLLOW_5);
            this_Fragment_2=ruleFragment(current);

            state._fsp--;


            			current = this_Fragment_2;
            			afterParserOrEnumRuleCall();
            		
            // InternalGH341TestLanguage.g:318:3: ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= 'X' otherlv_7= ';' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:319:4: ( (otherlv_3= RULE_ID ) ) (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= 'X' otherlv_7= ';'
            	    {
            	    // InternalGH341TestLanguage.g:319:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalGH341TestLanguage.g:320:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalGH341TestLanguage.g:320:5: (otherlv_3= RULE_ID )
            	    // InternalGH341TestLanguage.g:321:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getBrokenRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            	    						newLeafNode(otherlv_3, grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_0_0());
            	    					

            	    }


            	    }

            	    // InternalGH341TestLanguage.g:332:4: (otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==12) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // InternalGH341TestLanguage.g:333:5: otherlv_4= '.' ( (otherlv_5= RULE_ID ) )
            	    	    {
            	    	    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            	    	    					newLeafNode(otherlv_4, grammarAccess.getBrokenAccess().getFullStopKeyword_3_1_0());
            	    	    				
            	    	    // InternalGH341TestLanguage.g:337:5: ( (otherlv_5= RULE_ID ) )
            	    	    // InternalGH341TestLanguage.g:338:6: (otherlv_5= RULE_ID )
            	    	    {
            	    	    // InternalGH341TestLanguage.g:338:6: (otherlv_5= RULE_ID )
            	    	    // InternalGH341TestLanguage.g:339:7: otherlv_5= RULE_ID
            	    	    {

            	    	    							if (current==null) {
            	    	    								current = createModelElement(grammarAccess.getBrokenRule());
            	    	    							}
            	    	    						
            	    	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            	    	    							newLeafNode(otherlv_5, grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_1_1_0());
            	    	    						

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);

            	    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_8); 

            	    				newLeafNode(otherlv_6, grammarAccess.getBrokenAccess().getXKeyword_3_2());
            	    			
            	    otherlv_7=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            	    				newLeafNode(otherlv_7, grammarAccess.getBrokenAccess().getSemicolonKeyword_3_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "ruleBroken"


    // $ANTLR start "entryRuleThird"
    // InternalGH341TestLanguage.g:364:1: entryRuleThird returns [EObject current=null] : iv_ruleThird= ruleThird EOF ;
    public final EObject entryRuleThird() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThird = null;


        try {
            // InternalGH341TestLanguage.g:364:46: (iv_ruleThird= ruleThird EOF )
            // InternalGH341TestLanguage.g:365:2: iv_ruleThird= ruleThird EOF
            {
             newCompositeNode(grammarAccess.getThirdRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleThird=ruleThird();

            state._fsp--;

             current =iv_ruleThird; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleThird"


    // $ANTLR start "ruleThird"
    // InternalGH341TestLanguage.g:371:1: ruleThird returns [EObject current=null] : (this_DEFINE_0= ruleDEFINE[$current] this_STREAM_1= ruleSTREAM[$current] ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleThird() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_DEFINE_0 = null;

        EObject this_STREAM_1 = null;



        	enterRule();

        try {
            // InternalGH341TestLanguage.g:377:2: ( (this_DEFINE_0= ruleDEFINE[$current] this_STREAM_1= ruleSTREAM[$current] ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalGH341TestLanguage.g:378:2: (this_DEFINE_0= ruleDEFINE[$current] this_STREAM_1= ruleSTREAM[$current] ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalGH341TestLanguage.g:378:2: (this_DEFINE_0= ruleDEFINE[$current] this_STREAM_1= ruleSTREAM[$current] ( (lv_name_2_0= RULE_ID ) ) )
            // InternalGH341TestLanguage.g:379:3: this_DEFINE_0= ruleDEFINE[$current] this_STREAM_1= ruleSTREAM[$current] ( (lv_name_2_0= RULE_ID ) )
            {

            			if (current==null) {
            				current = createModelElement(grammarAccess.getThirdRule());
            			}
            			newCompositeNode(grammarAccess.getThirdAccess().getDEFINEParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_9);
            this_DEFINE_0=ruleDEFINE(current);

            state._fsp--;


            			current = this_DEFINE_0;
            			afterParserOrEnumRuleCall();
            		

            			if (current==null) {
            				current = createModelElement(grammarAccess.getThirdRule());
            			}
            			newCompositeNode(grammarAccess.getThirdAccess().getSTREAMParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_4);
            this_STREAM_1=ruleSTREAM(current);

            state._fsp--;


            			current = this_STREAM_1;
            			afterParserOrEnumRuleCall();
            		
            // InternalGH341TestLanguage.g:401:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalGH341TestLanguage.g:402:4: (lv_name_2_0= RULE_ID )
            {
            // InternalGH341TestLanguage.g:402:4: (lv_name_2_0= RULE_ID )
            // InternalGH341TestLanguage.g:403:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getThirdAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getThirdRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleThird"


    // $ANTLR start "ruleSTREAM"
    // InternalGH341TestLanguage.g:424:1: ruleSTREAM[EObject in_current] returns [EObject current=in_current] : otherlv_0= 'stream' ;
    public final EObject ruleSTREAM(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGH341TestLanguage.g:430:2: (otherlv_0= 'stream' )
            // InternalGH341TestLanguage.g:431:2: otherlv_0= 'stream'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_0, grammarAccess.getSTREAMAccess().getStreamKeyword());
            	

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
    // $ANTLR end "ruleSTREAM"


    // $ANTLR start "ruleDEFINE"
    // InternalGH341TestLanguage.g:439:1: ruleDEFINE[EObject in_current] returns [EObject current=in_current] : otherlv_0= 'define' ;
    public final EObject ruleDEFINE(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGH341TestLanguage.g:445:2: (otherlv_0= 'define' )
            // InternalGH341TestLanguage.g:446:2: otherlv_0= 'define'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_0, grammarAccess.getDEFINEAccess().getDefineKeyword());
            	

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
    // $ANTLR end "ruleDEFINE"


    // $ANTLR start "ruleFragment"
    // InternalGH341TestLanguage.g:454:1: ruleFragment[EObject in_current] returns [EObject current=in_current] : ( ( (lv_ids_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_ids_2_0= RULE_ID ) ) )* otherlv_3= ';' )* ;
    public final EObject ruleFragment(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_ids_0_0=null;
        Token otherlv_1=null;
        Token lv_ids_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalGH341TestLanguage.g:460:2: ( ( ( (lv_ids_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_ids_2_0= RULE_ID ) ) )* otherlv_3= ';' )* )
            // InternalGH341TestLanguage.g:461:2: ( ( (lv_ids_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_ids_2_0= RULE_ID ) ) )* otherlv_3= ';' )*
            {
            // InternalGH341TestLanguage.g:461:2: ( ( (lv_ids_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_ids_2_0= RULE_ID ) ) )* otherlv_3= ';' )*
            loop10:
            do {
                int alt10=2;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // InternalGH341TestLanguage.g:462:3: ( (lv_ids_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_ids_2_0= RULE_ID ) ) )* otherlv_3= ';'
            	    {
            	    // InternalGH341TestLanguage.g:462:3: ( (lv_ids_0_0= RULE_ID ) )
            	    // InternalGH341TestLanguage.g:463:4: (lv_ids_0_0= RULE_ID )
            	    {
            	    // InternalGH341TestLanguage.g:463:4: (lv_ids_0_0= RULE_ID )
            	    // InternalGH341TestLanguage.g:464:5: lv_ids_0_0= RULE_ID
            	    {
            	    lv_ids_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            	    					newLeafNode(lv_ids_0_0, grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_0_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getFragmentRule());
            	    					}
            	    					addWithLastConsumed(
            	    						current,
            	    						"ids",
            	    						lv_ids_0_0,
            	    						"org.eclipse.xtext.common.Terminals.ID");
            	    				

            	    }


            	    }

            	    // InternalGH341TestLanguage.g:480:3: (otherlv_1= '.' ( (lv_ids_2_0= RULE_ID ) ) )*
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==12) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // InternalGH341TestLanguage.g:481:4: otherlv_1= '.' ( (lv_ids_2_0= RULE_ID ) )
            	    	    {
            	    	    otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            	    	    				newLeafNode(otherlv_1, grammarAccess.getFragmentAccess().getFullStopKeyword_1_0());
            	    	    			
            	    	    // InternalGH341TestLanguage.g:485:4: ( (lv_ids_2_0= RULE_ID ) )
            	    	    // InternalGH341TestLanguage.g:486:5: (lv_ids_2_0= RULE_ID )
            	    	    {
            	    	    // InternalGH341TestLanguage.g:486:5: (lv_ids_2_0= RULE_ID )
            	    	    // InternalGH341TestLanguage.g:487:6: lv_ids_2_0= RULE_ID
            	    	    {
            	    	    lv_ids_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            	    	    						newLeafNode(lv_ids_2_0, grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_1_1_0());
            	    	    					

            	    	    						if (current==null) {
            	    	    							current = createModelElement(grammarAccess.getFragmentRule());
            	    	    						}
            	    	    						addWithLastConsumed(
            	    	    							current,
            	    	    							"ids",
            	    	    							lv_ids_2_0,
            	    	    							"org.eclipse.xtext.common.Terminals.ID");
            	    	    					

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop9;
            	        }
            	    } while (true);

            	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            	    			newLeafNode(otherlv_3, grammarAccess.getFragmentAccess().getSemicolonKeyword_2());
            	    		

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


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
    // $ANTLR end "ruleFragment"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA10 dfa10 = new DFA10(this);
    static final String dfa_1s = "\6\uffff";
    static final String dfa_2s = "\1\2\5\uffff";
    static final String dfa_3s = "\1\4\1\14\1\uffff\1\4\1\uffff\1\14";
    static final String dfa_4s = "\1\21\1\16\1\uffff\1\4\1\uffff\1\16";
    static final String dfa_5s = "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String dfa_6s = "\6\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\6\uffff\1\2\3\uffff\1\2\1\uffff\1\2",
            "\1\3\1\4\1\2",
            "",
            "\1\5",
            "",
            "\1\3\1\4\1\2"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 176:3: ( ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_ids_4_0= RULE_ID ) ) )* otherlv_5= ';' )*";
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 461:2: ( ( (lv_ids_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_ids_2_0= RULE_ID ) ) )* otherlv_3= ';' )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000028802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000005000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    }


}
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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistContextTestLanguageGrammarAccess;



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
public class InternalContentAssistContextTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'A1'", "'A2'", "'B1'", "'B2'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalContentAssistContextTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistContextTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistContextTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContentAssistContextTestLanguage.g"; }



     	private ContentAssistContextTestLanguageGrammarAccess grammarAccess;

        public InternalContentAssistContextTestLanguageParser(TokenStream input, ContentAssistContextTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "FirstLevel";
       	}

       	@Override
       	protected ContentAssistContextTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleFirstLevel"
    // InternalContentAssistContextTestLanguage.g:69:1: entryRuleFirstLevel returns [EObject current=null] : iv_ruleFirstLevel= ruleFirstLevel EOF ;
    public final EObject entryRuleFirstLevel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstLevel = null;


        try {
            // InternalContentAssistContextTestLanguage.g:69:51: (iv_ruleFirstLevel= ruleFirstLevel EOF )
            // InternalContentAssistContextTestLanguage.g:70:2: iv_ruleFirstLevel= ruleFirstLevel EOF
            {
             newCompositeNode(grammarAccess.getFirstLevelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFirstLevel=ruleFirstLevel();

            state._fsp--;

             current =iv_ruleFirstLevel; 
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
    // $ANTLR end "entryRuleFirstLevel"


    // $ANTLR start "ruleFirstLevel"
    // InternalContentAssistContextTestLanguage.g:76:1: ruleFirstLevel returns [EObject current=null] : ( ( (lv_secondLevelA_0_0= ruleSecondLevelA ) )* ( (lv_secondLevelB_1_0= ruleSecondLevelB ) )* ) ;
    public final EObject ruleFirstLevel() throws RecognitionException {
        EObject current = null;

        EObject lv_secondLevelA_0_0 = null;

        EObject lv_secondLevelB_1_0 = null;



        	enterRule();

        try {
            // InternalContentAssistContextTestLanguage.g:82:2: ( ( ( (lv_secondLevelA_0_0= ruleSecondLevelA ) )* ( (lv_secondLevelB_1_0= ruleSecondLevelB ) )* ) )
            // InternalContentAssistContextTestLanguage.g:83:2: ( ( (lv_secondLevelA_0_0= ruleSecondLevelA ) )* ( (lv_secondLevelB_1_0= ruleSecondLevelB ) )* )
            {
            // InternalContentAssistContextTestLanguage.g:83:2: ( ( (lv_secondLevelA_0_0= ruleSecondLevelA ) )* ( (lv_secondLevelB_1_0= ruleSecondLevelB ) )* )
            // InternalContentAssistContextTestLanguage.g:84:3: ( (lv_secondLevelA_0_0= ruleSecondLevelA ) )* ( (lv_secondLevelB_1_0= ruleSecondLevelB ) )*
            {
            // InternalContentAssistContextTestLanguage.g:84:3: ( (lv_secondLevelA_0_0= ruleSecondLevelA ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:85:4: (lv_secondLevelA_0_0= ruleSecondLevelA )
            	    {
            	    // InternalContentAssistContextTestLanguage.g:85:4: (lv_secondLevelA_0_0= ruleSecondLevelA )
            	    // InternalContentAssistContextTestLanguage.g:86:5: lv_secondLevelA_0_0= ruleSecondLevelA
            	    {

            	    					newCompositeNode(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_secondLevelA_0_0=ruleSecondLevelA();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFirstLevelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"secondLevelA",
            	    						lv_secondLevelA_0_0,
            	    						"org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistContextTestLanguage.SecondLevelA");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalContentAssistContextTestLanguage.g:103:3: ( (lv_secondLevelB_1_0= ruleSecondLevelB ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:104:4: (lv_secondLevelB_1_0= ruleSecondLevelB )
            	    {
            	    // InternalContentAssistContextTestLanguage.g:104:4: (lv_secondLevelB_1_0= ruleSecondLevelB )
            	    // InternalContentAssistContextTestLanguage.g:105:5: lv_secondLevelB_1_0= ruleSecondLevelB
            	    {

            	    					newCompositeNode(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_secondLevelB_1_0=ruleSecondLevelB();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFirstLevelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"secondLevelB",
            	    						lv_secondLevelB_1_0,
            	    						"org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistContextTestLanguage.SecondLevelB");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleFirstLevel"


    // $ANTLR start "entryRuleSecondLevelA"
    // InternalContentAssistContextTestLanguage.g:126:1: entryRuleSecondLevelA returns [EObject current=null] : iv_ruleSecondLevelA= ruleSecondLevelA EOF ;
    public final EObject entryRuleSecondLevelA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondLevelA = null;


        try {
            // InternalContentAssistContextTestLanguage.g:126:53: (iv_ruleSecondLevelA= ruleSecondLevelA EOF )
            // InternalContentAssistContextTestLanguage.g:127:2: iv_ruleSecondLevelA= ruleSecondLevelA EOF
            {
             newCompositeNode(grammarAccess.getSecondLevelARule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSecondLevelA=ruleSecondLevelA();

            state._fsp--;

             current =iv_ruleSecondLevelA; 
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
    // $ANTLR end "entryRuleSecondLevelA"


    // $ANTLR start "ruleSecondLevelA"
    // InternalContentAssistContextTestLanguage.g:133:1: ruleSecondLevelA returns [EObject current=null] : ( ( (lv_thirdLevelA1_0_0= ruleThirdLevelA1 ) )+ ( (lv_thirdLevelA2_1_0= ruleThirdLevelA2 ) )+ ) ;
    public final EObject ruleSecondLevelA() throws RecognitionException {
        EObject current = null;

        EObject lv_thirdLevelA1_0_0 = null;

        EObject lv_thirdLevelA2_1_0 = null;



        	enterRule();

        try {
            // InternalContentAssistContextTestLanguage.g:139:2: ( ( ( (lv_thirdLevelA1_0_0= ruleThirdLevelA1 ) )+ ( (lv_thirdLevelA2_1_0= ruleThirdLevelA2 ) )+ ) )
            // InternalContentAssistContextTestLanguage.g:140:2: ( ( (lv_thirdLevelA1_0_0= ruleThirdLevelA1 ) )+ ( (lv_thirdLevelA2_1_0= ruleThirdLevelA2 ) )+ )
            {
            // InternalContentAssistContextTestLanguage.g:140:2: ( ( (lv_thirdLevelA1_0_0= ruleThirdLevelA1 ) )+ ( (lv_thirdLevelA2_1_0= ruleThirdLevelA2 ) )+ )
            // InternalContentAssistContextTestLanguage.g:141:3: ( (lv_thirdLevelA1_0_0= ruleThirdLevelA1 ) )+ ( (lv_thirdLevelA2_1_0= ruleThirdLevelA2 ) )+
            {
            // InternalContentAssistContextTestLanguage.g:141:3: ( (lv_thirdLevelA1_0_0= ruleThirdLevelA1 ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:142:4: (lv_thirdLevelA1_0_0= ruleThirdLevelA1 )
            	    {
            	    // InternalContentAssistContextTestLanguage.g:142:4: (lv_thirdLevelA1_0_0= ruleThirdLevelA1 )
            	    // InternalContentAssistContextTestLanguage.g:143:5: lv_thirdLevelA1_0_0= ruleThirdLevelA1
            	    {

            	    					newCompositeNode(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_thirdLevelA1_0_0=ruleThirdLevelA1();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSecondLevelARule());
            	    					}
            	    					add(
            	    						current,
            	    						"thirdLevelA1",
            	    						lv_thirdLevelA1_0_0,
            	    						"org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistContextTestLanguage.ThirdLevelA1");
            	    					afterParserOrEnumRuleCall();
            	    				

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

            // InternalContentAssistContextTestLanguage.g:160:3: ( (lv_thirdLevelA2_1_0= ruleThirdLevelA2 ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:161:4: (lv_thirdLevelA2_1_0= ruleThirdLevelA2 )
            	    {
            	    // InternalContentAssistContextTestLanguage.g:161:4: (lv_thirdLevelA2_1_0= ruleThirdLevelA2 )
            	    // InternalContentAssistContextTestLanguage.g:162:5: lv_thirdLevelA2_1_0= ruleThirdLevelA2
            	    {

            	    					newCompositeNode(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_thirdLevelA2_1_0=ruleThirdLevelA2();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSecondLevelARule());
            	    					}
            	    					add(
            	    						current,
            	    						"thirdLevelA2",
            	    						lv_thirdLevelA2_1_0,
            	    						"org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistContextTestLanguage.ThirdLevelA2");
            	    					afterParserOrEnumRuleCall();
            	    				

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
    // $ANTLR end "ruleSecondLevelA"


    // $ANTLR start "entryRuleSecondLevelB"
    // InternalContentAssistContextTestLanguage.g:183:1: entryRuleSecondLevelB returns [EObject current=null] : iv_ruleSecondLevelB= ruleSecondLevelB EOF ;
    public final EObject entryRuleSecondLevelB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondLevelB = null;


        try {
            // InternalContentAssistContextTestLanguage.g:183:53: (iv_ruleSecondLevelB= ruleSecondLevelB EOF )
            // InternalContentAssistContextTestLanguage.g:184:2: iv_ruleSecondLevelB= ruleSecondLevelB EOF
            {
             newCompositeNode(grammarAccess.getSecondLevelBRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSecondLevelB=ruleSecondLevelB();

            state._fsp--;

             current =iv_ruleSecondLevelB; 
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
    // $ANTLR end "entryRuleSecondLevelB"


    // $ANTLR start "ruleSecondLevelB"
    // InternalContentAssistContextTestLanguage.g:190:1: ruleSecondLevelB returns [EObject current=null] : ( ( (lv_thirdLevelB1_0_0= ruleThirdLevelB1 ) )+ ( (lv_thirdLevelB2_1_0= ruleThirdLevelB2 ) )+ ) ;
    public final EObject ruleSecondLevelB() throws RecognitionException {
        EObject current = null;

        EObject lv_thirdLevelB1_0_0 = null;

        EObject lv_thirdLevelB2_1_0 = null;



        	enterRule();

        try {
            // InternalContentAssistContextTestLanguage.g:196:2: ( ( ( (lv_thirdLevelB1_0_0= ruleThirdLevelB1 ) )+ ( (lv_thirdLevelB2_1_0= ruleThirdLevelB2 ) )+ ) )
            // InternalContentAssistContextTestLanguage.g:197:2: ( ( (lv_thirdLevelB1_0_0= ruleThirdLevelB1 ) )+ ( (lv_thirdLevelB2_1_0= ruleThirdLevelB2 ) )+ )
            {
            // InternalContentAssistContextTestLanguage.g:197:2: ( ( (lv_thirdLevelB1_0_0= ruleThirdLevelB1 ) )+ ( (lv_thirdLevelB2_1_0= ruleThirdLevelB2 ) )+ )
            // InternalContentAssistContextTestLanguage.g:198:3: ( (lv_thirdLevelB1_0_0= ruleThirdLevelB1 ) )+ ( (lv_thirdLevelB2_1_0= ruleThirdLevelB2 ) )+
            {
            // InternalContentAssistContextTestLanguage.g:198:3: ( (lv_thirdLevelB1_0_0= ruleThirdLevelB1 ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:199:4: (lv_thirdLevelB1_0_0= ruleThirdLevelB1 )
            	    {
            	    // InternalContentAssistContextTestLanguage.g:199:4: (lv_thirdLevelB1_0_0= ruleThirdLevelB1 )
            	    // InternalContentAssistContextTestLanguage.g:200:5: lv_thirdLevelB1_0_0= ruleThirdLevelB1
            	    {

            	    					newCompositeNode(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_thirdLevelB1_0_0=ruleThirdLevelB1();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSecondLevelBRule());
            	    					}
            	    					add(
            	    						current,
            	    						"thirdLevelB1",
            	    						lv_thirdLevelB1_0_0,
            	    						"org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistContextTestLanguage.ThirdLevelB1");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            // InternalContentAssistContextTestLanguage.g:217:3: ( (lv_thirdLevelB2_1_0= ruleThirdLevelB2 ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalContentAssistContextTestLanguage.g:218:4: (lv_thirdLevelB2_1_0= ruleThirdLevelB2 )
            	    {
            	    // InternalContentAssistContextTestLanguage.g:218:4: (lv_thirdLevelB2_1_0= ruleThirdLevelB2 )
            	    // InternalContentAssistContextTestLanguage.g:219:5: lv_thirdLevelB2_1_0= ruleThirdLevelB2
            	    {

            	    					newCompositeNode(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_thirdLevelB2_1_0=ruleThirdLevelB2();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSecondLevelBRule());
            	    					}
            	    					add(
            	    						current,
            	    						"thirdLevelB2",
            	    						lv_thirdLevelB2_1_0,
            	    						"org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistContextTestLanguage.ThirdLevelB2");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
    // $ANTLR end "ruleSecondLevelB"


    // $ANTLR start "entryRuleThirdLevelA1"
    // InternalContentAssistContextTestLanguage.g:240:1: entryRuleThirdLevelA1 returns [EObject current=null] : iv_ruleThirdLevelA1= ruleThirdLevelA1 EOF ;
    public final EObject entryRuleThirdLevelA1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdLevelA1 = null;


        try {
            // InternalContentAssistContextTestLanguage.g:240:53: (iv_ruleThirdLevelA1= ruleThirdLevelA1 EOF )
            // InternalContentAssistContextTestLanguage.g:241:2: iv_ruleThirdLevelA1= ruleThirdLevelA1 EOF
            {
             newCompositeNode(grammarAccess.getThirdLevelA1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleThirdLevelA1=ruleThirdLevelA1();

            state._fsp--;

             current =iv_ruleThirdLevelA1; 
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
    // $ANTLR end "entryRuleThirdLevelA1"


    // $ANTLR start "ruleThirdLevelA1"
    // InternalContentAssistContextTestLanguage.g:247:1: ruleThirdLevelA1 returns [EObject current=null] : (otherlv_0= 'A1' () ( (lv_name_2_0= RULE_ID ) )? ) ;
    public final EObject ruleThirdLevelA1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalContentAssistContextTestLanguage.g:253:2: ( (otherlv_0= 'A1' () ( (lv_name_2_0= RULE_ID ) )? ) )
            // InternalContentAssistContextTestLanguage.g:254:2: (otherlv_0= 'A1' () ( (lv_name_2_0= RULE_ID ) )? )
            {
            // InternalContentAssistContextTestLanguage.g:254:2: (otherlv_0= 'A1' () ( (lv_name_2_0= RULE_ID ) )? )
            // InternalContentAssistContextTestLanguage.g:255:3: otherlv_0= 'A1' () ( (lv_name_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getThirdLevelA1Access().getA1Keyword_0());
            		
            // InternalContentAssistContextTestLanguage.g:259:3: ()
            // InternalContentAssistContextTestLanguage.g:260:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1(),
            					current);
            			

            }

            // InternalContentAssistContextTestLanguage.g:266:3: ( (lv_name_2_0= RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:267:4: (lv_name_2_0= RULE_ID )
                    {
                    // InternalContentAssistContextTestLanguage.g:267:4: (lv_name_2_0= RULE_ID )
                    // InternalContentAssistContextTestLanguage.g:268:5: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_name_2_0, grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getThirdLevelA1Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_2_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleThirdLevelA1"


    // $ANTLR start "entryRuleThirdLevelA2"
    // InternalContentAssistContextTestLanguage.g:288:1: entryRuleThirdLevelA2 returns [EObject current=null] : iv_ruleThirdLevelA2= ruleThirdLevelA2 EOF ;
    public final EObject entryRuleThirdLevelA2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdLevelA2 = null;


        try {
            // InternalContentAssistContextTestLanguage.g:288:53: (iv_ruleThirdLevelA2= ruleThirdLevelA2 EOF )
            // InternalContentAssistContextTestLanguage.g:289:2: iv_ruleThirdLevelA2= ruleThirdLevelA2 EOF
            {
             newCompositeNode(grammarAccess.getThirdLevelA2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleThirdLevelA2=ruleThirdLevelA2();

            state._fsp--;

             current =iv_ruleThirdLevelA2; 
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
    // $ANTLR end "entryRuleThirdLevelA2"


    // $ANTLR start "ruleThirdLevelA2"
    // InternalContentAssistContextTestLanguage.g:295:1: ruleThirdLevelA2 returns [EObject current=null] : (otherlv_0= 'A2' () ( (lv_name_2_0= RULE_ID ) )? ) ;
    public final EObject ruleThirdLevelA2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalContentAssistContextTestLanguage.g:301:2: ( (otherlv_0= 'A2' () ( (lv_name_2_0= RULE_ID ) )? ) )
            // InternalContentAssistContextTestLanguage.g:302:2: (otherlv_0= 'A2' () ( (lv_name_2_0= RULE_ID ) )? )
            {
            // InternalContentAssistContextTestLanguage.g:302:2: (otherlv_0= 'A2' () ( (lv_name_2_0= RULE_ID ) )? )
            // InternalContentAssistContextTestLanguage.g:303:3: otherlv_0= 'A2' () ( (lv_name_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getThirdLevelA2Access().getA2Keyword_0());
            		
            // InternalContentAssistContextTestLanguage.g:307:3: ()
            // InternalContentAssistContextTestLanguage.g:308:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1(),
            					current);
            			

            }

            // InternalContentAssistContextTestLanguage.g:314:3: ( (lv_name_2_0= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:315:4: (lv_name_2_0= RULE_ID )
                    {
                    // InternalContentAssistContextTestLanguage.g:315:4: (lv_name_2_0= RULE_ID )
                    // InternalContentAssistContextTestLanguage.g:316:5: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_name_2_0, grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getThirdLevelA2Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_2_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleThirdLevelA2"


    // $ANTLR start "entryRuleThirdLevelB1"
    // InternalContentAssistContextTestLanguage.g:336:1: entryRuleThirdLevelB1 returns [EObject current=null] : iv_ruleThirdLevelB1= ruleThirdLevelB1 EOF ;
    public final EObject entryRuleThirdLevelB1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdLevelB1 = null;


        try {
            // InternalContentAssistContextTestLanguage.g:336:53: (iv_ruleThirdLevelB1= ruleThirdLevelB1 EOF )
            // InternalContentAssistContextTestLanguage.g:337:2: iv_ruleThirdLevelB1= ruleThirdLevelB1 EOF
            {
             newCompositeNode(grammarAccess.getThirdLevelB1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleThirdLevelB1=ruleThirdLevelB1();

            state._fsp--;

             current =iv_ruleThirdLevelB1; 
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
    // $ANTLR end "entryRuleThirdLevelB1"


    // $ANTLR start "ruleThirdLevelB1"
    // InternalContentAssistContextTestLanguage.g:343:1: ruleThirdLevelB1 returns [EObject current=null] : (otherlv_0= 'B1' () ( (lv_name_2_0= RULE_ID ) )? ) ;
    public final EObject ruleThirdLevelB1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalContentAssistContextTestLanguage.g:349:2: ( (otherlv_0= 'B1' () ( (lv_name_2_0= RULE_ID ) )? ) )
            // InternalContentAssistContextTestLanguage.g:350:2: (otherlv_0= 'B1' () ( (lv_name_2_0= RULE_ID ) )? )
            {
            // InternalContentAssistContextTestLanguage.g:350:2: (otherlv_0= 'B1' () ( (lv_name_2_0= RULE_ID ) )? )
            // InternalContentAssistContextTestLanguage.g:351:3: otherlv_0= 'B1' () ( (lv_name_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getThirdLevelB1Access().getB1Keyword_0());
            		
            // InternalContentAssistContextTestLanguage.g:355:3: ()
            // InternalContentAssistContextTestLanguage.g:356:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1(),
            					current);
            			

            }

            // InternalContentAssistContextTestLanguage.g:362:3: ( (lv_name_2_0= RULE_ID ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:363:4: (lv_name_2_0= RULE_ID )
                    {
                    // InternalContentAssistContextTestLanguage.g:363:4: (lv_name_2_0= RULE_ID )
                    // InternalContentAssistContextTestLanguage.g:364:5: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_name_2_0, grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getThirdLevelB1Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_2_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleThirdLevelB1"


    // $ANTLR start "entryRuleThirdLevelB2"
    // InternalContentAssistContextTestLanguage.g:384:1: entryRuleThirdLevelB2 returns [EObject current=null] : iv_ruleThirdLevelB2= ruleThirdLevelB2 EOF ;
    public final EObject entryRuleThirdLevelB2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdLevelB2 = null;


        try {
            // InternalContentAssistContextTestLanguage.g:384:53: (iv_ruleThirdLevelB2= ruleThirdLevelB2 EOF )
            // InternalContentAssistContextTestLanguage.g:385:2: iv_ruleThirdLevelB2= ruleThirdLevelB2 EOF
            {
             newCompositeNode(grammarAccess.getThirdLevelB2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleThirdLevelB2=ruleThirdLevelB2();

            state._fsp--;

             current =iv_ruleThirdLevelB2; 
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
    // $ANTLR end "entryRuleThirdLevelB2"


    // $ANTLR start "ruleThirdLevelB2"
    // InternalContentAssistContextTestLanguage.g:391:1: ruleThirdLevelB2 returns [EObject current=null] : (otherlv_0= 'B2' () ( (lv_name_2_0= RULE_ID ) )? ) ;
    public final EObject ruleThirdLevelB2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalContentAssistContextTestLanguage.g:397:2: ( (otherlv_0= 'B2' () ( (lv_name_2_0= RULE_ID ) )? ) )
            // InternalContentAssistContextTestLanguage.g:398:2: (otherlv_0= 'B2' () ( (lv_name_2_0= RULE_ID ) )? )
            {
            // InternalContentAssistContextTestLanguage.g:398:2: (otherlv_0= 'B2' () ( (lv_name_2_0= RULE_ID ) )? )
            // InternalContentAssistContextTestLanguage.g:399:3: otherlv_0= 'B2' () ( (lv_name_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getThirdLevelB2Access().getB2Keyword_0());
            		
            // InternalContentAssistContextTestLanguage.g:403:3: ()
            // InternalContentAssistContextTestLanguage.g:404:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1(),
            					current);
            			

            }

            // InternalContentAssistContextTestLanguage.g:410:3: ( (lv_name_2_0= RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalContentAssistContextTestLanguage.g:411:4: (lv_name_2_0= RULE_ID )
                    {
                    // InternalContentAssistContextTestLanguage.g:411:4: (lv_name_2_0= RULE_ID )
                    // InternalContentAssistContextTestLanguage.g:412:5: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_name_2_0, grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getThirdLevelB2Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_2_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleThirdLevelB2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000003800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000012L});
    }


}
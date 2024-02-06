package org.eclipse.xtext.parser.antlr.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.services.Bug289515TestLanguageGrammarAccess;



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
public class InternalBug289515TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'%'", "'2'", "'3'", "'\\\\%'", "'4'", "'5'", "'%%'", "'6'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalBug289515TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug289515TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug289515TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug289515TestLanguage.g"; }



     	private Bug289515TestLanguageGrammarAccess grammarAccess;

        public InternalBug289515TestLanguageParser(TokenStream input, Bug289515TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected Bug289515TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalBug289515TestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug289515TestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalBug289515TestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalBug289515TestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) ) | (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) ) | (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) ) | (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) ) | (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) ) | (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;
        Token otherlv_6=null;
        Token lv_value_7_0=null;
        Token otherlv_8=null;
        Token lv_value_9_0=null;
        Token otherlv_10=null;
        Token lv_value_11_0=null;


        	enterRule();

        try {
            // InternalBug289515TestLanguage.g:82:2: ( ( (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) ) | (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) ) | (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) ) | (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) ) | (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) ) | (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) ) ) )
            // InternalBug289515TestLanguage.g:83:2: ( (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) ) | (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) ) | (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) ) | (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) ) | (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) ) | (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) ) )
            {
            // InternalBug289515TestLanguage.g:83:2: ( (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) ) | (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) ) | (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) ) | (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) ) | (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) ) | (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 14:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            case 19:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalBug289515TestLanguage.g:84:3: (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) )
                    {
                    // InternalBug289515TestLanguage.g:84:3: (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) )
                    // InternalBug289515TestLanguage.g:85:4: otherlv_0= '1' ( (lv_value_1_0= '%' ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getModelAccess().getDigitOneKeyword_0_0());
                    			
                    // InternalBug289515TestLanguage.g:89:4: ( (lv_value_1_0= '%' ) )
                    // InternalBug289515TestLanguage.g:90:5: (lv_value_1_0= '%' )
                    {
                    // InternalBug289515TestLanguage.g:90:5: (lv_value_1_0= '%' )
                    // InternalBug289515TestLanguage.g:91:6: lv_value_1_0= '%'
                    {
                    lv_value_1_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getModelAccess().getValuePercentSignKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_0, "%");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug289515TestLanguage.g:105:3: (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) )
                    {
                    // InternalBug289515TestLanguage.g:105:3: (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) )
                    // InternalBug289515TestLanguage.g:106:4: otherlv_2= '2' ( (lv_value_3_0= '%' ) )
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getDigitTwoKeyword_1_0());
                    			
                    // InternalBug289515TestLanguage.g:110:4: ( (lv_value_3_0= '%' ) )
                    // InternalBug289515TestLanguage.g:111:5: (lv_value_3_0= '%' )
                    {
                    // InternalBug289515TestLanguage.g:111:5: (lv_value_3_0= '%' )
                    // InternalBug289515TestLanguage.g:112:6: lv_value_3_0= '%'
                    {
                    lv_value_3_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getModelAccess().getValuePercentSignKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_3_0, "%");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBug289515TestLanguage.g:126:3: (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) )
                    {
                    // InternalBug289515TestLanguage.g:126:3: (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) )
                    // InternalBug289515TestLanguage.g:127:4: otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) )
                    {
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_4, grammarAccess.getModelAccess().getDigitThreeKeyword_2_0());
                    			
                    // InternalBug289515TestLanguage.g:131:4: ( (lv_value_5_0= '\\\\%' ) )
                    // InternalBug289515TestLanguage.g:132:5: (lv_value_5_0= '\\\\%' )
                    {
                    // InternalBug289515TestLanguage.g:132:5: (lv_value_5_0= '\\\\%' )
                    // InternalBug289515TestLanguage.g:133:6: lv_value_5_0= '\\\\%'
                    {
                    lv_value_5_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_value_5_0, grammarAccess.getModelAccess().getValueReverseSolidusPercentSignKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_5_0, "\\%");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBug289515TestLanguage.g:147:3: (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) )
                    {
                    // InternalBug289515TestLanguage.g:147:3: (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) )
                    // InternalBug289515TestLanguage.g:148:4: otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) )
                    {
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getDigitFourKeyword_3_0());
                    			
                    // InternalBug289515TestLanguage.g:152:4: ( (lv_value_7_0= '\\\\%' ) )
                    // InternalBug289515TestLanguage.g:153:5: (lv_value_7_0= '\\\\%' )
                    {
                    // InternalBug289515TestLanguage.g:153:5: (lv_value_7_0= '\\\\%' )
                    // InternalBug289515TestLanguage.g:154:6: lv_value_7_0= '\\\\%'
                    {
                    lv_value_7_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_value_7_0, grammarAccess.getModelAccess().getValueReverseSolidusPercentSignKeyword_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_7_0, "\\%");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalBug289515TestLanguage.g:168:3: (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) )
                    {
                    // InternalBug289515TestLanguage.g:168:3: (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) )
                    // InternalBug289515TestLanguage.g:169:4: otherlv_8= '5' ( (lv_value_9_0= '%%' ) )
                    {
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_8, grammarAccess.getModelAccess().getDigitFiveKeyword_4_0());
                    			
                    // InternalBug289515TestLanguage.g:173:4: ( (lv_value_9_0= '%%' ) )
                    // InternalBug289515TestLanguage.g:174:5: (lv_value_9_0= '%%' )
                    {
                    // InternalBug289515TestLanguage.g:174:5: (lv_value_9_0= '%%' )
                    // InternalBug289515TestLanguage.g:175:6: lv_value_9_0= '%%'
                    {
                    lv_value_9_0=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_value_9_0, grammarAccess.getModelAccess().getValuePercentSignPercentSignKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_9_0, "%%");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalBug289515TestLanguage.g:189:3: (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) )
                    {
                    // InternalBug289515TestLanguage.g:189:3: (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) )
                    // InternalBug289515TestLanguage.g:190:4: otherlv_10= '6' ( (lv_value_11_0= '%%' ) )
                    {
                    otherlv_10=(Token)match(input,19,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getModelAccess().getDigitSixKeyword_5_0());
                    			
                    // InternalBug289515TestLanguage.g:194:4: ( (lv_value_11_0= '%%' ) )
                    // InternalBug289515TestLanguage.g:195:5: (lv_value_11_0= '%%' )
                    {
                    // InternalBug289515TestLanguage.g:195:5: (lv_value_11_0= '%%' )
                    // InternalBug289515TestLanguage.g:196:6: lv_value_11_0= '%%'
                    {
                    lv_value_11_0=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_value_11_0, grammarAccess.getModelAccess().getValuePercentSignPercentSignKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_11_0, "%%");
                    					

                    }


                    }


                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000040000L});
    }


}
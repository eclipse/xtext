package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;



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
public class InternalTerminalRulesTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_RICH_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "RULE_ESCAPED_CHAR", "RULE_IN_RICH_STRING"
    };
    public static final int RULE_RICH_STRING=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_ESCAPED_CHAR=12;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_IN_RICH_STRING=13;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=8;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalTerminalRulesTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTerminalRulesTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTerminalRulesTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTerminalRulesTestLanguage.g"; }



     	private TerminalRulesTestLanguageGrammarAccess grammarAccess;

        public InternalTerminalRulesTestLanguageParser(TokenStream input, TerminalRulesTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected TerminalRulesTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalTerminalRulesTestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalTerminalRulesTestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalTerminalRulesTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalTerminalRulesTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_richStringValue_3_0= RULE_RICH_STRING ) ) | ( (lv_mlCommentValue_4_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_5_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_6_0= RULE_WS ) ) | ( (lv_anyValue_7_0= RULE_ANY_OTHER ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_idValue_0_0=null;
        Token lv_intValue_1_0=null;
        Token lv_stringValue_2_0=null;
        Token lv_richStringValue_3_0=null;
        Token lv_mlCommentValue_4_0=null;
        Token lv_slCommentValue_5_0=null;
        Token lv_wsValue_6_0=null;
        Token lv_anyValue_7_0=null;


        	enterRule();

        try {
            // InternalTerminalRulesTestLanguage.g:82:2: ( ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_richStringValue_3_0= RULE_RICH_STRING ) ) | ( (lv_mlCommentValue_4_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_5_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_6_0= RULE_WS ) ) | ( (lv_anyValue_7_0= RULE_ANY_OTHER ) ) ) )
            // InternalTerminalRulesTestLanguage.g:83:2: ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_richStringValue_3_0= RULE_RICH_STRING ) ) | ( (lv_mlCommentValue_4_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_5_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_6_0= RULE_WS ) ) | ( (lv_anyValue_7_0= RULE_ANY_OTHER ) ) )
            {
            // InternalTerminalRulesTestLanguage.g:83:2: ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_richStringValue_3_0= RULE_RICH_STRING ) ) | ( (lv_mlCommentValue_4_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_5_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_6_0= RULE_WS ) ) | ( (lv_anyValue_7_0= RULE_ANY_OTHER ) ) )
            int alt1=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt1=1;
                }
                break;
            case RULE_INT:
                {
                alt1=2;
                }
                break;
            case RULE_STRING:
                {
                alt1=3;
                }
                break;
            case RULE_RICH_STRING:
                {
                alt1=4;
                }
                break;
            case RULE_ML_COMMENT:
                {
                alt1=5;
                }
                break;
            case RULE_SL_COMMENT:
                {
                alt1=6;
                }
                break;
            case RULE_WS:
                {
                alt1=7;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalTerminalRulesTestLanguage.g:84:3: ( (lv_idValue_0_0= RULE_ID ) )
                    {
                    // InternalTerminalRulesTestLanguage.g:84:3: ( (lv_idValue_0_0= RULE_ID ) )
                    // InternalTerminalRulesTestLanguage.g:85:4: (lv_idValue_0_0= RULE_ID )
                    {
                    // InternalTerminalRulesTestLanguage.g:85:4: (lv_idValue_0_0= RULE_ID )
                    // InternalTerminalRulesTestLanguage.g:86:5: lv_idValue_0_0= RULE_ID
                    {
                    lv_idValue_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_idValue_0_0, grammarAccess.getModelAccess().getIdValueIDTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"idValue",
                    						lv_idValue_0_0,
                    						"org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage.ID");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTerminalRulesTestLanguage.g:103:3: ( (lv_intValue_1_0= RULE_INT ) )
                    {
                    // InternalTerminalRulesTestLanguage.g:103:3: ( (lv_intValue_1_0= RULE_INT ) )
                    // InternalTerminalRulesTestLanguage.g:104:4: (lv_intValue_1_0= RULE_INT )
                    {
                    // InternalTerminalRulesTestLanguage.g:104:4: (lv_intValue_1_0= RULE_INT )
                    // InternalTerminalRulesTestLanguage.g:105:5: lv_intValue_1_0= RULE_INT
                    {
                    lv_intValue_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_intValue_1_0, grammarAccess.getModelAccess().getIntValueINTTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"intValue",
                    						lv_intValue_1_0,
                    						"org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage.INT");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalTerminalRulesTestLanguage.g:122:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // InternalTerminalRulesTestLanguage.g:122:3: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // InternalTerminalRulesTestLanguage.g:123:4: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // InternalTerminalRulesTestLanguage.g:123:4: (lv_stringValue_2_0= RULE_STRING )
                    // InternalTerminalRulesTestLanguage.g:124:5: lv_stringValue_2_0= RULE_STRING
                    {
                    lv_stringValue_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_stringValue_2_0, grammarAccess.getModelAccess().getStringValueSTRINGTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"stringValue",
                    						lv_stringValue_2_0,
                    						"org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage.STRING");
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalTerminalRulesTestLanguage.g:141:3: ( (lv_richStringValue_3_0= RULE_RICH_STRING ) )
                    {
                    // InternalTerminalRulesTestLanguage.g:141:3: ( (lv_richStringValue_3_0= RULE_RICH_STRING ) )
                    // InternalTerminalRulesTestLanguage.g:142:4: (lv_richStringValue_3_0= RULE_RICH_STRING )
                    {
                    // InternalTerminalRulesTestLanguage.g:142:4: (lv_richStringValue_3_0= RULE_RICH_STRING )
                    // InternalTerminalRulesTestLanguage.g:143:5: lv_richStringValue_3_0= RULE_RICH_STRING
                    {
                    lv_richStringValue_3_0=(Token)match(input,RULE_RICH_STRING,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_richStringValue_3_0, grammarAccess.getModelAccess().getRichStringValueRICH_STRINGTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"richStringValue",
                    						lv_richStringValue_3_0,
                    						"org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage.RICH_STRING");
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalTerminalRulesTestLanguage.g:160:3: ( (lv_mlCommentValue_4_0= RULE_ML_COMMENT ) )
                    {
                    // InternalTerminalRulesTestLanguage.g:160:3: ( (lv_mlCommentValue_4_0= RULE_ML_COMMENT ) )
                    // InternalTerminalRulesTestLanguage.g:161:4: (lv_mlCommentValue_4_0= RULE_ML_COMMENT )
                    {
                    // InternalTerminalRulesTestLanguage.g:161:4: (lv_mlCommentValue_4_0= RULE_ML_COMMENT )
                    // InternalTerminalRulesTestLanguage.g:162:5: lv_mlCommentValue_4_0= RULE_ML_COMMENT
                    {
                    lv_mlCommentValue_4_0=(Token)match(input,RULE_ML_COMMENT,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_mlCommentValue_4_0, grammarAccess.getModelAccess().getMlCommentValueML_COMMENTTerminalRuleCall_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"mlCommentValue",
                    						lv_mlCommentValue_4_0,
                    						"org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage.ML_COMMENT");
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalTerminalRulesTestLanguage.g:179:3: ( (lv_slCommentValue_5_0= RULE_SL_COMMENT ) )
                    {
                    // InternalTerminalRulesTestLanguage.g:179:3: ( (lv_slCommentValue_5_0= RULE_SL_COMMENT ) )
                    // InternalTerminalRulesTestLanguage.g:180:4: (lv_slCommentValue_5_0= RULE_SL_COMMENT )
                    {
                    // InternalTerminalRulesTestLanguage.g:180:4: (lv_slCommentValue_5_0= RULE_SL_COMMENT )
                    // InternalTerminalRulesTestLanguage.g:181:5: lv_slCommentValue_5_0= RULE_SL_COMMENT
                    {
                    lv_slCommentValue_5_0=(Token)match(input,RULE_SL_COMMENT,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_slCommentValue_5_0, grammarAccess.getModelAccess().getSlCommentValueSL_COMMENTTerminalRuleCall_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"slCommentValue",
                    						lv_slCommentValue_5_0,
                    						"org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage.SL_COMMENT");
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalTerminalRulesTestLanguage.g:198:3: ( (lv_wsValue_6_0= RULE_WS ) )
                    {
                    // InternalTerminalRulesTestLanguage.g:198:3: ( (lv_wsValue_6_0= RULE_WS ) )
                    // InternalTerminalRulesTestLanguage.g:199:4: (lv_wsValue_6_0= RULE_WS )
                    {
                    // InternalTerminalRulesTestLanguage.g:199:4: (lv_wsValue_6_0= RULE_WS )
                    // InternalTerminalRulesTestLanguage.g:200:5: lv_wsValue_6_0= RULE_WS
                    {
                    lv_wsValue_6_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_wsValue_6_0, grammarAccess.getModelAccess().getWsValueWSTerminalRuleCall_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"wsValue",
                    						lv_wsValue_6_0,
                    						"org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage.WS");
                    				

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalTerminalRulesTestLanguage.g:217:3: ( (lv_anyValue_7_0= RULE_ANY_OTHER ) )
                    {
                    // InternalTerminalRulesTestLanguage.g:217:3: ( (lv_anyValue_7_0= RULE_ANY_OTHER ) )
                    // InternalTerminalRulesTestLanguage.g:218:4: (lv_anyValue_7_0= RULE_ANY_OTHER )
                    {
                    // InternalTerminalRulesTestLanguage.g:218:4: (lv_anyValue_7_0= RULE_ANY_OTHER )
                    // InternalTerminalRulesTestLanguage.g:219:5: lv_anyValue_7_0= RULE_ANY_OTHER
                    {
                    lv_anyValue_7_0=(Token)match(input,RULE_ANY_OTHER,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_anyValue_7_0, grammarAccess.getModelAccess().getAnyValueANY_OTHERTerminalRuleCall_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"anyValue",
                    						lv_anyValue_7_0,
                    						"org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage.ANY_OTHER");
                    				

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
    }


}
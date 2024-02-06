package org.eclipse.xtext.parsetree.unassignedtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parsetree.unassignedtext.services.UnassignedTextTestLanguageGrammarAccess;



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
public class InternalUnassignedTextTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_CASEINSENSITIVEKEYWORD", "RULE_INT", "RULE_PLURAL", "RULE_MULTI", "RULE_STRING", "RULE_ID", "RULE_MULTI2", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'contents:'", "'multi'", "'datatype'", "'str'", "'terminals'", "'group'", "'this'", "'is'", "'a'", "'test'"
    };
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__19=19;
    public static final int RULE_MULTI2=10;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int RULE_PLURAL=6;
    public static final int EOF=-1;
    public static final int RULE_ID=9;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_MULTI=7;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int RULE_CASEINSENSITIVEKEYWORD=4;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalUnassignedTextTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUnassignedTextTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUnassignedTextTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalUnassignedTextTestLanguage.g"; }



     	private UnassignedTextTestLanguageGrammarAccess grammarAccess;

        public InternalUnassignedTextTestLanguageParser(TokenStream input, UnassignedTextTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected UnassignedTextTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalUnassignedTextTestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalUnassignedTextTestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalUnassignedTextTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalUnassignedTextTestLanguage.g:76:1: ruleModel returns [EObject current=null] : (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule | this_GroupRule_5= ruleGroupRule ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_CaseInsensitiveKeywordRule_0 = null;

        EObject this_PluralRule_1 = null;

        EObject this_MultiRule_2 = null;

        EObject this_DatatypeRule_3 = null;

        EObject this_CommonTerminalsRule_4 = null;

        EObject this_GroupRule_5 = null;



        	enterRule();

        try {
            // InternalUnassignedTextTestLanguage.g:82:2: ( (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule | this_GroupRule_5= ruleGroupRule ) )
            // InternalUnassignedTextTestLanguage.g:83:2: (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule | this_GroupRule_5= ruleGroupRule )
            {
            // InternalUnassignedTextTestLanguage.g:83:2: (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule | this_GroupRule_5= ruleGroupRule )
            int alt1=6;
            switch ( input.LA(1) ) {
            case RULE_CASEINSENSITIVEKEYWORD:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 16:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            case 19:
                {
                alt1=5;
                }
                break;
            case 20:
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
                    // InternalUnassignedTextTestLanguage.g:84:3: this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getCaseInsensitiveKeywordRuleParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CaseInsensitiveKeywordRule_0=ruleCaseInsensitiveKeywordRule();

                    state._fsp--;


                    			current = this_CaseInsensitiveKeywordRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalUnassignedTextTestLanguage.g:93:3: this_PluralRule_1= rulePluralRule
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getPluralRuleParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PluralRule_1=rulePluralRule();

                    state._fsp--;


                    			current = this_PluralRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalUnassignedTextTestLanguage.g:102:3: this_MultiRule_2= ruleMultiRule
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getMultiRuleParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_MultiRule_2=ruleMultiRule();

                    state._fsp--;


                    			current = this_MultiRule_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalUnassignedTextTestLanguage.g:111:3: this_DatatypeRule_3= ruleDatatypeRule
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getDatatypeRuleParserRuleCall_3());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DatatypeRule_3=ruleDatatypeRule();

                    state._fsp--;


                    			current = this_DatatypeRule_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalUnassignedTextTestLanguage.g:120:3: this_CommonTerminalsRule_4= ruleCommonTerminalsRule
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getCommonTerminalsRuleParserRuleCall_4());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CommonTerminalsRule_4=ruleCommonTerminalsRule();

                    state._fsp--;


                    			current = this_CommonTerminalsRule_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalUnassignedTextTestLanguage.g:129:3: this_GroupRule_5= ruleGroupRule
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getGroupRuleParserRuleCall_5());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_GroupRule_5=ruleGroupRule();

                    state._fsp--;


                    			current = this_GroupRule_5;
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
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleCaseInsensitiveKeywordRule"
    // InternalUnassignedTextTestLanguage.g:141:1: entryRuleCaseInsensitiveKeywordRule returns [EObject current=null] : iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF ;
    public final EObject entryRuleCaseInsensitiveKeywordRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseInsensitiveKeywordRule = null;


        try {
            // InternalUnassignedTextTestLanguage.g:141:67: (iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF )
            // InternalUnassignedTextTestLanguage.g:142:2: iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF
            {
             newCompositeNode(grammarAccess.getCaseInsensitiveKeywordRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCaseInsensitiveKeywordRule=ruleCaseInsensitiveKeywordRule();

            state._fsp--;

             current =iv_ruleCaseInsensitiveKeywordRule; 
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
    // $ANTLR end "entryRuleCaseInsensitiveKeywordRule"


    // $ANTLR start "ruleCaseInsensitiveKeywordRule"
    // InternalUnassignedTextTestLanguage.g:148:1: ruleCaseInsensitiveKeywordRule returns [EObject current=null] : (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final EObject ruleCaseInsensitiveKeywordRule() throws RecognitionException {
        EObject current = null;

        Token this_CaseInsensitiveKeyword_0=null;
        Token lv_val_1_0=null;


        	enterRule();

        try {
            // InternalUnassignedTextTestLanguage.g:154:2: ( (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) )
            // InternalUnassignedTextTestLanguage.g:155:2: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            {
            // InternalUnassignedTextTestLanguage.g:155:2: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            // InternalUnassignedTextTestLanguage.g:156:3: this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) )
            {
            this_CaseInsensitiveKeyword_0=(Token)match(input,RULE_CASEINSENSITIVEKEYWORD,FollowSets000.FOLLOW_3); 

            			newLeafNode(this_CaseInsensitiveKeyword_0, grammarAccess.getCaseInsensitiveKeywordRuleAccess().getCaseInsensitiveKeywordTerminalRuleCall_0());
            		
            // InternalUnassignedTextTestLanguage.g:160:3: ( (lv_val_1_0= RULE_INT ) )
            // InternalUnassignedTextTestLanguage.g:161:4: (lv_val_1_0= RULE_INT )
            {
            // InternalUnassignedTextTestLanguage.g:161:4: (lv_val_1_0= RULE_INT )
            // InternalUnassignedTextTestLanguage.g:162:5: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_val_1_0, grammarAccess.getCaseInsensitiveKeywordRuleAccess().getValINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCaseInsensitiveKeywordRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"val",
            						lv_val_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    // $ANTLR end "ruleCaseInsensitiveKeywordRule"


    // $ANTLR start "entryRulePluralRule"
    // InternalUnassignedTextTestLanguage.g:182:1: entryRulePluralRule returns [EObject current=null] : iv_rulePluralRule= rulePluralRule EOF ;
    public final EObject entryRulePluralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePluralRule = null;


        try {
            // InternalUnassignedTextTestLanguage.g:182:51: (iv_rulePluralRule= rulePluralRule EOF )
            // InternalUnassignedTextTestLanguage.g:183:2: iv_rulePluralRule= rulePluralRule EOF
            {
             newCompositeNode(grammarAccess.getPluralRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePluralRule=rulePluralRule();

            state._fsp--;

             current =iv_rulePluralRule; 
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
    // $ANTLR end "entryRulePluralRule"


    // $ANTLR start "rulePluralRule"
    // InternalUnassignedTextTestLanguage.g:189:1: rulePluralRule returns [EObject current=null] : (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) ;
    public final EObject rulePluralRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_count_1_0=null;
        Token this_Plural_2=null;


        	enterRule();

        try {
            // InternalUnassignedTextTestLanguage.g:195:2: ( (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) )
            // InternalUnassignedTextTestLanguage.g:196:2: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            {
            // InternalUnassignedTextTestLanguage.g:196:2: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            // InternalUnassignedTextTestLanguage.g:197:3: otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPluralRuleAccess().getContentsKeyword_0());
            		
            // InternalUnassignedTextTestLanguage.g:201:3: ( (lv_count_1_0= RULE_INT ) )
            // InternalUnassignedTextTestLanguage.g:202:4: (lv_count_1_0= RULE_INT )
            {
            // InternalUnassignedTextTestLanguage.g:202:4: (lv_count_1_0= RULE_INT )
            // InternalUnassignedTextTestLanguage.g:203:5: lv_count_1_0= RULE_INT
            {
            lv_count_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 

            					newLeafNode(lv_count_1_0, grammarAccess.getPluralRuleAccess().getCountINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPluralRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"count",
            						lv_count_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            this_Plural_2=(Token)match(input,RULE_PLURAL,FollowSets000.FOLLOW_2); 

            			newLeafNode(this_Plural_2, grammarAccess.getPluralRuleAccess().getPluralTerminalRuleCall_2());
            		

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
    // $ANTLR end "rulePluralRule"


    // $ANTLR start "entryRuleMultiRule"
    // InternalUnassignedTextTestLanguage.g:227:1: entryRuleMultiRule returns [EObject current=null] : iv_ruleMultiRule= ruleMultiRule EOF ;
    public final EObject entryRuleMultiRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiRule = null;


        try {
            // InternalUnassignedTextTestLanguage.g:227:50: (iv_ruleMultiRule= ruleMultiRule EOF )
            // InternalUnassignedTextTestLanguage.g:228:2: iv_ruleMultiRule= ruleMultiRule EOF
            {
             newCompositeNode(grammarAccess.getMultiRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiRule=ruleMultiRule();

            state._fsp--;

             current =iv_ruleMultiRule; 
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
    // $ANTLR end "entryRuleMultiRule"


    // $ANTLR start "ruleMultiRule"
    // InternalUnassignedTextTestLanguage.g:234:1: ruleMultiRule returns [EObject current=null] : (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) ;
    public final EObject ruleMultiRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token this_Multi_2=null;
        Token this_Multi_3=null;
        Token this_Multi_4=null;


        	enterRule();

        try {
            // InternalUnassignedTextTestLanguage.g:240:2: ( (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) )
            // InternalUnassignedTextTestLanguage.g:241:2: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            {
            // InternalUnassignedTextTestLanguage.g:241:2: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            // InternalUnassignedTextTestLanguage.g:242:3: otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMultiRuleAccess().getMultiKeyword_0());
            		
            // InternalUnassignedTextTestLanguage.g:246:3: ( (lv_val_1_0= RULE_INT ) )
            // InternalUnassignedTextTestLanguage.g:247:4: (lv_val_1_0= RULE_INT )
            {
            // InternalUnassignedTextTestLanguage.g:247:4: (lv_val_1_0= RULE_INT )
            // InternalUnassignedTextTestLanguage.g:248:5: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_5); 

            					newLeafNode(lv_val_1_0, grammarAccess.getMultiRuleAccess().getValINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMultiRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"val",
            						lv_val_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            this_Multi_2=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_5); 

            			newLeafNode(this_Multi_2, grammarAccess.getMultiRuleAccess().getMultiTerminalRuleCall_2());
            		
            this_Multi_3=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_5); 

            			newLeafNode(this_Multi_3, grammarAccess.getMultiRuleAccess().getMultiTerminalRuleCall_3());
            		
            this_Multi_4=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_2); 

            			newLeafNode(this_Multi_4, grammarAccess.getMultiRuleAccess().getMultiTerminalRuleCall_4());
            		

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
    // $ANTLR end "ruleMultiRule"


    // $ANTLR start "entryRuleDatatypeRule"
    // InternalUnassignedTextTestLanguage.g:280:1: entryRuleDatatypeRule returns [EObject current=null] : iv_ruleDatatypeRule= ruleDatatypeRule EOF ;
    public final EObject entryRuleDatatypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeRule = null;


        try {
            // InternalUnassignedTextTestLanguage.g:280:53: (iv_ruleDatatypeRule= ruleDatatypeRule EOF )
            // InternalUnassignedTextTestLanguage.g:281:2: iv_ruleDatatypeRule= ruleDatatypeRule EOF
            {
             newCompositeNode(grammarAccess.getDatatypeRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatypeRule=ruleDatatypeRule();

            state._fsp--;

             current =iv_ruleDatatypeRule; 
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
    // $ANTLR end "entryRuleDatatypeRule"


    // $ANTLR start "ruleDatatypeRule"
    // InternalUnassignedTextTestLanguage.g:287:1: ruleDatatypeRule returns [EObject current=null] : (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) ;
    public final EObject ruleDatatypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;


        	enterRule();

        try {
            // InternalUnassignedTextTestLanguage.g:293:2: ( (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) )
            // InternalUnassignedTextTestLanguage.g:294:2: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            {
            // InternalUnassignedTextTestLanguage.g:294:2: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            // InternalUnassignedTextTestLanguage.g:295:3: otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDatatypeRuleAccess().getDatatypeKeyword_0());
            		
            // InternalUnassignedTextTestLanguage.g:299:3: ( (lv_val_1_0= RULE_INT ) )
            // InternalUnassignedTextTestLanguage.g:300:4: (lv_val_1_0= RULE_INT )
            {
            // InternalUnassignedTextTestLanguage.g:300:4: (lv_val_1_0= RULE_INT )
            // InternalUnassignedTextTestLanguage.g:301:5: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_6); 

            					newLeafNode(lv_val_1_0, grammarAccess.getDatatypeRuleAccess().getValINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDatatypeRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"val",
            						lv_val_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            			newCompositeNode(grammarAccess.getDatatypeRuleAccess().getDatatypeParserRuleCall_2());
            		
            pushFollow(FollowSets000.FOLLOW_2);
            ruleDatatype();

            state._fsp--;


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
        }
        return current;
    }
    // $ANTLR end "ruleDatatypeRule"


    // $ANTLR start "entryRuleDatatype"
    // InternalUnassignedTextTestLanguage.g:328:1: entryRuleDatatype returns [String current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final String entryRuleDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype = null;


        try {
            // InternalUnassignedTextTestLanguage.g:328:48: (iv_ruleDatatype= ruleDatatype EOF )
            // InternalUnassignedTextTestLanguage.g:329:2: iv_ruleDatatype= ruleDatatype EOF
            {
             newCompositeNode(grammarAccess.getDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatype=ruleDatatype();

            state._fsp--;

             current =iv_ruleDatatype.getText(); 
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
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // InternalUnassignedTextTestLanguage.g:335:1: ruleDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 ) ;
    public final AntlrDatatypeRuleToken ruleDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_Datatype2_2 = null;



        	enterRule();

        try {
            // InternalUnassignedTextTestLanguage.g:341:2: ( (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 ) )
            // InternalUnassignedTextTestLanguage.g:342:2: (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 )
            {
            // InternalUnassignedTextTestLanguage.g:342:2: (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt2=1;
                }
                break;
            case RULE_INT:
                {
                alt2=2;
                }
                break;
            case RULE_STRING:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalUnassignedTextTestLanguage.g:343:3: kw= 'str'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getDatatypeAccess().getStrKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalUnassignedTextTestLanguage.g:349:3: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    			current.merge(this_INT_1);
                    		

                    			newLeafNode(this_INT_1, grammarAccess.getDatatypeAccess().getINTTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalUnassignedTextTestLanguage.g:357:3: this_Datatype2_2= ruleDatatype2
                    {

                    			newCompositeNode(grammarAccess.getDatatypeAccess().getDatatype2ParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Datatype2_2=ruleDatatype2();

                    state._fsp--;


                    			current.merge(this_Datatype2_2);
                    		

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
        }
        return current;
    }
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "entryRuleDatatype2"
    // InternalUnassignedTextTestLanguage.g:371:1: entryRuleDatatype2 returns [String current=null] : iv_ruleDatatype2= ruleDatatype2 EOF ;
    public final String entryRuleDatatype2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype2 = null;


        try {
            // InternalUnassignedTextTestLanguage.g:371:49: (iv_ruleDatatype2= ruleDatatype2 EOF )
            // InternalUnassignedTextTestLanguage.g:372:2: iv_ruleDatatype2= ruleDatatype2 EOF
            {
             newCompositeNode(grammarAccess.getDatatype2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatype2=ruleDatatype2();

            state._fsp--;

             current =iv_ruleDatatype2.getText(); 
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
    // $ANTLR end "entryRuleDatatype2"


    // $ANTLR start "ruleDatatype2"
    // InternalUnassignedTextTestLanguage.g:378:1: ruleDatatype2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleDatatype2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalUnassignedTextTestLanguage.g:384:2: (this_STRING_0= RULE_STRING )
            // InternalUnassignedTextTestLanguage.g:385:2: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            		current.merge(this_STRING_0);
            	

            		newLeafNode(this_STRING_0, grammarAccess.getDatatype2Access().getSTRINGTerminalRuleCall());
            	

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
    // $ANTLR end "ruleDatatype2"


    // $ANTLR start "entryRuleCommonTerminalsRule"
    // InternalUnassignedTextTestLanguage.g:395:1: entryRuleCommonTerminalsRule returns [EObject current=null] : iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF ;
    public final EObject entryRuleCommonTerminalsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommonTerminalsRule = null;


        try {
            // InternalUnassignedTextTestLanguage.g:395:60: (iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF )
            // InternalUnassignedTextTestLanguage.g:396:2: iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF
            {
             newCompositeNode(grammarAccess.getCommonTerminalsRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCommonTerminalsRule=ruleCommonTerminalsRule();

            state._fsp--;

             current =iv_ruleCommonTerminalsRule; 
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
    // $ANTLR end "entryRuleCommonTerminalsRule"


    // $ANTLR start "ruleCommonTerminalsRule"
    // InternalUnassignedTextTestLanguage.g:402:1: ruleCommonTerminalsRule returns [EObject current=null] : (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) ;
    public final EObject ruleCommonTerminalsRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_ID_1=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;
        Token lv_val_4_0=null;


        	enterRule();

        try {
            // InternalUnassignedTextTestLanguage.g:408:2: ( (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) )
            // InternalUnassignedTextTestLanguage.g:409:2: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            {
            // InternalUnassignedTextTestLanguage.g:409:2: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            // InternalUnassignedTextTestLanguage.g:410:3: otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getCommonTerminalsRuleAccess().getTerminalsKeyword_0());
            		
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            			newLeafNode(this_ID_1, grammarAccess.getCommonTerminalsRuleAccess().getIDTerminalRuleCall_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_8); 

            			newLeafNode(this_INT_2, grammarAccess.getCommonTerminalsRuleAccess().getINTTerminalRuleCall_2());
            		
            this_STRING_3=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_7); 

            			newLeafNode(this_STRING_3, grammarAccess.getCommonTerminalsRuleAccess().getSTRINGTerminalRuleCall_3());
            		
            // InternalUnassignedTextTestLanguage.g:426:3: ( (lv_val_4_0= RULE_ID ) )
            // InternalUnassignedTextTestLanguage.g:427:4: (lv_val_4_0= RULE_ID )
            {
            // InternalUnassignedTextTestLanguage.g:427:4: (lv_val_4_0= RULE_ID )
            // InternalUnassignedTextTestLanguage.g:428:5: lv_val_4_0= RULE_ID
            {
            lv_val_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_val_4_0, grammarAccess.getCommonTerminalsRuleAccess().getValIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCommonTerminalsRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"val",
            						lv_val_4_0,
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
    // $ANTLR end "ruleCommonTerminalsRule"


    // $ANTLR start "entryRuleGroupRule"
    // InternalUnassignedTextTestLanguage.g:448:1: entryRuleGroupRule returns [EObject current=null] : iv_ruleGroupRule= ruleGroupRule EOF ;
    public final EObject entryRuleGroupRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupRule = null;


        try {
            // InternalUnassignedTextTestLanguage.g:448:50: (iv_ruleGroupRule= ruleGroupRule EOF )
            // InternalUnassignedTextTestLanguage.g:449:2: iv_ruleGroupRule= ruleGroupRule EOF
            {
             newCompositeNode(grammarAccess.getGroupRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGroupRule=ruleGroupRule();

            state._fsp--;

             current =iv_ruleGroupRule; 
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
    // $ANTLR end "entryRuleGroupRule"


    // $ANTLR start "ruleGroupRule"
    // InternalUnassignedTextTestLanguage.g:455:1: ruleGroupRule returns [EObject current=null] : ( () otherlv_1= 'group' ruleGroupDataTypeRule ) ;
    public final EObject ruleGroupRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalUnassignedTextTestLanguage.g:461:2: ( ( () otherlv_1= 'group' ruleGroupDataTypeRule ) )
            // InternalUnassignedTextTestLanguage.g:462:2: ( () otherlv_1= 'group' ruleGroupDataTypeRule )
            {
            // InternalUnassignedTextTestLanguage.g:462:2: ( () otherlv_1= 'group' ruleGroupDataTypeRule )
            // InternalUnassignedTextTestLanguage.g:463:3: () otherlv_1= 'group' ruleGroupDataTypeRule
            {
            // InternalUnassignedTextTestLanguage.g:463:3: ()
            // InternalUnassignedTextTestLanguage.g:464:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGroupRuleAccess().getGroupRuleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getGroupRuleAccess().getGroupKeyword_1());
            		

            			newCompositeNode(grammarAccess.getGroupRuleAccess().getGroupDataTypeRuleParserRuleCall_2());
            		
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGroupDataTypeRule();

            state._fsp--;


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
        }
        return current;
    }
    // $ANTLR end "ruleGroupRule"


    // $ANTLR start "entryRuleGroupDataTypeRule"
    // InternalUnassignedTextTestLanguage.g:485:1: entryRuleGroupDataTypeRule returns [String current=null] : iv_ruleGroupDataTypeRule= ruleGroupDataTypeRule EOF ;
    public final String entryRuleGroupDataTypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGroupDataTypeRule = null;


        try {
            // InternalUnassignedTextTestLanguage.g:485:57: (iv_ruleGroupDataTypeRule= ruleGroupDataTypeRule EOF )
            // InternalUnassignedTextTestLanguage.g:486:2: iv_ruleGroupDataTypeRule= ruleGroupDataTypeRule EOF
            {
             newCompositeNode(grammarAccess.getGroupDataTypeRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGroupDataTypeRule=ruleGroupDataTypeRule();

            state._fsp--;

             current =iv_ruleGroupDataTypeRule.getText(); 
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
    // $ANTLR end "entryRuleGroupDataTypeRule"


    // $ANTLR start "ruleGroupDataTypeRule"
    // InternalUnassignedTextTestLanguage.g:492:1: ruleGroupDataTypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'this' kw= 'is' kw= 'a' kw= 'test' ) ;
    public final AntlrDatatypeRuleToken ruleGroupDataTypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalUnassignedTextTestLanguage.g:498:2: ( (kw= 'this' kw= 'is' kw= 'a' kw= 'test' ) )
            // InternalUnassignedTextTestLanguage.g:499:2: (kw= 'this' kw= 'is' kw= 'a' kw= 'test' )
            {
            // InternalUnassignedTextTestLanguage.g:499:2: (kw= 'this' kw= 'is' kw= 'a' kw= 'test' )
            // InternalUnassignedTextTestLanguage.g:500:3: kw= 'this' kw= 'is' kw= 'a' kw= 'test'
            {
            kw=(Token)match(input,21,FollowSets000.FOLLOW_10); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getGroupDataTypeRuleAccess().getThisKeyword_0());
            		
            kw=(Token)match(input,22,FollowSets000.FOLLOW_11); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getGroupDataTypeRuleAccess().getIsKeyword_1());
            		
            kw=(Token)match(input,23,FollowSets000.FOLLOW_12); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getGroupDataTypeRuleAccess().getAKeyword_2());
            		
            kw=(Token)match(input,24,FollowSets000.FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getGroupDataTypeRuleAccess().getTestKeyword_3());
            		

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
    // $ANTLR end "ruleGroupDataTypeRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000040120L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001000000L});
    }


}
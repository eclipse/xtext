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

@SuppressWarnings("all")
public class InternalUnassignedTextTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_CASEINSENSITIVEKEYWORD", "RULE_INT", "RULE_PLURAL", "RULE_MULTI", "RULE_STRING", "RULE_ID", "RULE_MULTI2", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'contents:'", "'multi'", "'datatype'", "'str'", "'terminals'"
    };
    public static final int RULE_ID=9;
    public static final int RULE_ANY_OTHER=14;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_PLURAL=6;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__19=19;
    public static final int RULE_STRING=8;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_CASEINSENSITIVEKEYWORD=4;
    public static final int RULE_MULTI2=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=13;
    public static final int RULE_MULTI=7;

    // delegates
    // delegators


        public InternalUnassignedTextTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUnassignedTextTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUnassignedTextTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g"; }



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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:76:1: ruleModel returns [EObject current=null] : (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_CaseInsensitiveKeywordRule_0 = null;

        EObject this_PluralRule_1 = null;

        EObject this_MultiRule_2 = null;

        EObject this_DatatypeRule_3 = null;

        EObject this_CommonTerminalsRule_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:79:28: ( (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:80:1: (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:80:1: (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule )
            int alt1=5;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:81:5: this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getCaseInsensitiveKeywordRuleParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCaseInsensitiveKeywordRule_in_ruleModel132);
                    this_CaseInsensitiveKeywordRule_0=ruleCaseInsensitiveKeywordRule();

                    state._fsp--;

                     
                            current = this_CaseInsensitiveKeywordRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:91:5: this_PluralRule_1= rulePluralRule
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getPluralRuleParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_rulePluralRule_in_ruleModel159);
                    this_PluralRule_1=rulePluralRule();

                    state._fsp--;

                     
                            current = this_PluralRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:101:5: this_MultiRule_2= ruleMultiRule
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getMultiRuleParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMultiRule_in_ruleModel186);
                    this_MultiRule_2=ruleMultiRule();

                    state._fsp--;

                     
                            current = this_MultiRule_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:111:5: this_DatatypeRule_3= ruleDatatypeRule
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getDatatypeRuleParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_ruleModel213);
                    this_DatatypeRule_3=ruleDatatypeRule();

                    state._fsp--;

                     
                            current = this_DatatypeRule_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:121:5: this_CommonTerminalsRule_4= ruleCommonTerminalsRule
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getCommonTerminalsRuleParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCommonTerminalsRule_in_ruleModel240);
                    this_CommonTerminalsRule_4=ruleCommonTerminalsRule();

                    state._fsp--;

                     
                            current = this_CommonTerminalsRule_4; 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:137:1: entryRuleCaseInsensitiveKeywordRule returns [EObject current=null] : iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF ;
    public final EObject entryRuleCaseInsensitiveKeywordRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseInsensitiveKeywordRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:138:2: (iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:139:2: iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF
            {
             newCompositeNode(grammarAccess.getCaseInsensitiveKeywordRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCaseInsensitiveKeywordRule_in_entryRuleCaseInsensitiveKeywordRule275);
            iv_ruleCaseInsensitiveKeywordRule=ruleCaseInsensitiveKeywordRule();

            state._fsp--;

             current =iv_ruleCaseInsensitiveKeywordRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCaseInsensitiveKeywordRule285); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:146:1: ruleCaseInsensitiveKeywordRule returns [EObject current=null] : (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final EObject ruleCaseInsensitiveKeywordRule() throws RecognitionException {
        EObject current = null;

        Token this_CaseInsensitiveKeyword_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:149:28: ( (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:150:1: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:150:1: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:150:2: this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) )
            {
            this_CaseInsensitiveKeyword_0=(Token)match(input,RULE_CASEINSENSITIVEKEYWORD,FollowSets000.FOLLOW_RULE_CASEINSENSITIVEKEYWORD_in_ruleCaseInsensitiveKeywordRule321); 
             
                newLeafNode(this_CaseInsensitiveKeyword_0, grammarAccess.getCaseInsensitiveKeywordRuleAccess().getCaseInsensitiveKeywordTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:154:1: ( (lv_val_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:155:1: (lv_val_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:155:1: (lv_val_1_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:156:3: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCaseInsensitiveKeywordRule337); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:180:1: entryRulePluralRule returns [EObject current=null] : iv_rulePluralRule= rulePluralRule EOF ;
    public final EObject entryRulePluralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePluralRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:181:2: (iv_rulePluralRule= rulePluralRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:182:2: iv_rulePluralRule= rulePluralRule EOF
            {
             newCompositeNode(grammarAccess.getPluralRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePluralRule_in_entryRulePluralRule378);
            iv_rulePluralRule=rulePluralRule();

            state._fsp--;

             current =iv_rulePluralRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePluralRule388); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:189:1: rulePluralRule returns [EObject current=null] : (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) ;
    public final EObject rulePluralRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_count_1_0=null;
        Token this_Plural_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:192:28: ( (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:193:1: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:193:1: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:193:3: otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_rulePluralRule425); 

                	newLeafNode(otherlv_0, grammarAccess.getPluralRuleAccess().getContentsKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:197:1: ( (lv_count_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:198:1: (lv_count_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:198:1: (lv_count_1_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:199:3: lv_count_1_0= RULE_INT
            {
            lv_count_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePluralRule442); 

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

            this_Plural_2=(Token)match(input,RULE_PLURAL,FollowSets000.FOLLOW_RULE_PLURAL_in_rulePluralRule458); 
             
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:227:1: entryRuleMultiRule returns [EObject current=null] : iv_ruleMultiRule= ruleMultiRule EOF ;
    public final EObject entryRuleMultiRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:228:2: (iv_ruleMultiRule= ruleMultiRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:229:2: iv_ruleMultiRule= ruleMultiRule EOF
            {
             newCompositeNode(grammarAccess.getMultiRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiRule_in_entryRuleMultiRule493);
            iv_ruleMultiRule=ruleMultiRule();

            state._fsp--;

             current =iv_ruleMultiRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiRule503); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:236:1: ruleMultiRule returns [EObject current=null] : (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) ;
    public final EObject ruleMultiRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token this_Multi_2=null;
        Token this_Multi_3=null;
        Token this_Multi_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:239:28: ( (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:240:1: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:240:1: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:240:3: otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiRule540); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiRuleAccess().getMultiKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:244:1: ( (lv_val_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:245:1: (lv_val_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:245:1: (lv_val_1_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:246:3: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMultiRule557); 

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

            this_Multi_2=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_RULE_MULTI_in_ruleMultiRule573); 
             
                newLeafNode(this_Multi_2, grammarAccess.getMultiRuleAccess().getMultiTerminalRuleCall_2()); 
                
            this_Multi_3=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_RULE_MULTI_in_ruleMultiRule583); 
             
                newLeafNode(this_Multi_3, grammarAccess.getMultiRuleAccess().getMultiTerminalRuleCall_3()); 
                
            this_Multi_4=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_RULE_MULTI_in_ruleMultiRule593); 
             
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:282:1: entryRuleDatatypeRule returns [EObject current=null] : iv_ruleDatatypeRule= ruleDatatypeRule EOF ;
    public final EObject entryRuleDatatypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:283:2: (iv_ruleDatatypeRule= ruleDatatypeRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:284:2: iv_ruleDatatypeRule= ruleDatatypeRule EOF
            {
             newCompositeNode(grammarAccess.getDatatypeRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule628);
            iv_ruleDatatypeRule=ruleDatatypeRule();

            state._fsp--;

             current =iv_ruleDatatypeRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeRule638); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:291:1: ruleDatatypeRule returns [EObject current=null] : (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) ;
    public final EObject ruleDatatypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:294:28: ( (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:295:1: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:295:1: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:295:3: otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDatatypeRule675); 

                	newLeafNode(otherlv_0, grammarAccess.getDatatypeRuleAccess().getDatatypeKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:299:1: ( (lv_val_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:300:1: (lv_val_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:300:1: (lv_val_1_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:301:3: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDatatypeRule692); 

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
                
            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleDatatypeRule713);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:333:1: entryRuleDatatype returns [String current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final String entryRuleDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:334:2: (iv_ruleDatatype= ruleDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:335:2: iv_ruleDatatype= ruleDatatype EOF
            {
             newCompositeNode(grammarAccess.getDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_entryRuleDatatype749);
            iv_ruleDatatype=ruleDatatype();

            state._fsp--;

             current =iv_ruleDatatype.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype760); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:342:1: ruleDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 ) ;
    public final AntlrDatatypeRuleToken ruleDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_Datatype2_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:345:28: ( (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:346:1: (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:346:1: (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:347:2: kw= 'str'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleDatatype798); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDatatypeAccess().getStrKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:353:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDatatype819); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getDatatypeAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:362:5: this_Datatype2_2= ruleDatatype2
                    {
                     
                            newCompositeNode(grammarAccess.getDatatypeAccess().getDatatype2ParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype2_in_ruleDatatype852);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:380:1: entryRuleDatatype2 returns [String current=null] : iv_ruleDatatype2= ruleDatatype2 EOF ;
    public final String entryRuleDatatype2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:381:2: (iv_ruleDatatype2= ruleDatatype2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:382:2: iv_ruleDatatype2= ruleDatatype2 EOF
            {
             newCompositeNode(grammarAccess.getDatatype2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype2_in_entryRuleDatatype2898);
            iv_ruleDatatype2=ruleDatatype2();

            state._fsp--;

             current =iv_ruleDatatype2.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype2909); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:389:1: ruleDatatype2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleDatatype2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:392:28: (this_STRING_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:393:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleDatatype2948); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:408:1: entryRuleCommonTerminalsRule returns [EObject current=null] : iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF ;
    public final EObject entryRuleCommonTerminalsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommonTerminalsRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:409:2: (iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:410:2: iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF
            {
             newCompositeNode(grammarAccess.getCommonTerminalsRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCommonTerminalsRule_in_entryRuleCommonTerminalsRule992);
            iv_ruleCommonTerminalsRule=ruleCommonTerminalsRule();

            state._fsp--;

             current =iv_ruleCommonTerminalsRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommonTerminalsRule1002); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:417:1: ruleCommonTerminalsRule returns [EObject current=null] : (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) ;
    public final EObject ruleCommonTerminalsRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_ID_1=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;
        Token lv_val_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:420:28: ( (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:421:1: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:421:1: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:421:3: otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCommonTerminalsRule1039); 

                	newLeafNode(otherlv_0, grammarAccess.getCommonTerminalsRuleAccess().getTerminalsKeyword_0());
                
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCommonTerminalsRule1050); 
             
                newLeafNode(this_ID_1, grammarAccess.getCommonTerminalsRuleAccess().getIDTerminalRuleCall_1()); 
                
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCommonTerminalsRule1060); 
             
                newLeafNode(this_INT_2, grammarAccess.getCommonTerminalsRuleAccess().getINTTerminalRuleCall_2()); 
                
            this_STRING_3=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCommonTerminalsRule1070); 
             
                newLeafNode(this_STRING_3, grammarAccess.getCommonTerminalsRuleAccess().getSTRINGTerminalRuleCall_3()); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:437:1: ( (lv_val_4_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:438:1: (lv_val_4_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:438:1: (lv_val_4_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:439:3: lv_val_4_0= RULE_ID
            {
            lv_val_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCommonTerminalsRule1086); 

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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCaseInsensitiveKeywordRule_in_ruleModel132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePluralRule_in_ruleModel159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiRule_in_ruleModel186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_ruleModel213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommonTerminalsRule_in_ruleModel240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCaseInsensitiveKeywordRule_in_entryRuleCaseInsensitiveKeywordRule275 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCaseInsensitiveKeywordRule285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_CASEINSENSITIVEKEYWORD_in_ruleCaseInsensitiveKeywordRule321 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCaseInsensitiveKeywordRule337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePluralRule_in_entryRulePluralRule378 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePluralRule388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rulePluralRule425 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePluralRule442 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_PLURAL_in_rulePluralRule458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiRule_in_entryRuleMultiRule493 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiRule503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleMultiRule540 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMultiRule557 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_MULTI_in_ruleMultiRule573 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_MULTI_in_ruleMultiRule583 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_MULTI_in_ruleMultiRule593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule628 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeRule638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleDatatypeRule675 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDatatypeRule692 = new BitSet(new long[]{0x0000000000040120L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleDatatypeRule713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype749 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleDatatype798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDatatype819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype2_in_ruleDatatype852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype2_in_entryRuleDatatype2898 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype2909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleDatatype2948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommonTerminalsRule_in_entryRuleCommonTerminalsRule992 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommonTerminalsRule1002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleCommonTerminalsRule1039 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCommonTerminalsRule1050 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCommonTerminalsRule1060 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCommonTerminalsRule1070 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCommonTerminalsRule1086 = new BitSet(new long[]{0x0000000000000002L});
    }


}
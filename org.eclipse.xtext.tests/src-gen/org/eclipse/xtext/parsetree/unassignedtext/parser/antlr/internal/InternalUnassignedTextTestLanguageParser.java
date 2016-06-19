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
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_CASEINSENSITIVEKEYWORD=4;

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
    // InternalUnassignedTextTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalUnassignedTextTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalUnassignedTextTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalUnassignedTextTestLanguage.g:76:1: ruleModel returns [EObject current=null] : (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_CaseInsensitiveKeywordRule_0 = null;

        EObject this_PluralRule_1 = null;

        EObject this_MultiRule_2 = null;

        EObject this_DatatypeRule_3 = null;

        EObject this_CommonTerminalsRule_4 = null;


         enterRule(); 
            
        try {
            // InternalUnassignedTextTestLanguage.g:79:28: ( (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule ) )
            // InternalUnassignedTextTestLanguage.g:80:1: (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule )
            {
            // InternalUnassignedTextTestLanguage.g:80:1: (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule )
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
                    // InternalUnassignedTextTestLanguage.g:81:5: this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule
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
                    // InternalUnassignedTextTestLanguage.g:91:5: this_PluralRule_1= rulePluralRule
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
                    // InternalUnassignedTextTestLanguage.g:101:5: this_MultiRule_2= ruleMultiRule
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
                    // InternalUnassignedTextTestLanguage.g:111:5: this_DatatypeRule_3= ruleDatatypeRule
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
                    // InternalUnassignedTextTestLanguage.g:121:5: this_CommonTerminalsRule_4= ruleCommonTerminalsRule
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getCommonTerminalsRuleParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalUnassignedTextTestLanguage.g:137:1: entryRuleCaseInsensitiveKeywordRule returns [EObject current=null] : iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF ;
    public final EObject entryRuleCaseInsensitiveKeywordRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseInsensitiveKeywordRule = null;


        try {
            // InternalUnassignedTextTestLanguage.g:138:2: (iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF )
            // InternalUnassignedTextTestLanguage.g:139:2: iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF
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
    // InternalUnassignedTextTestLanguage.g:146:1: ruleCaseInsensitiveKeywordRule returns [EObject current=null] : (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final EObject ruleCaseInsensitiveKeywordRule() throws RecognitionException {
        EObject current = null;

        Token this_CaseInsensitiveKeyword_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // InternalUnassignedTextTestLanguage.g:149:28: ( (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) )
            // InternalUnassignedTextTestLanguage.g:150:1: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            {
            // InternalUnassignedTextTestLanguage.g:150:1: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            // InternalUnassignedTextTestLanguage.g:150:2: this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) )
            {
            this_CaseInsensitiveKeyword_0=(Token)match(input,RULE_CASEINSENSITIVEKEYWORD,FollowSets000.FOLLOW_3); 
             
                newLeafNode(this_CaseInsensitiveKeyword_0, grammarAccess.getCaseInsensitiveKeywordRuleAccess().getCaseInsensitiveKeywordTerminalRuleCall_0()); 
                
            // InternalUnassignedTextTestLanguage.g:154:1: ( (lv_val_1_0= RULE_INT ) )
            // InternalUnassignedTextTestLanguage.g:155:1: (lv_val_1_0= RULE_INT )
            {
            // InternalUnassignedTextTestLanguage.g:155:1: (lv_val_1_0= RULE_INT )
            // InternalUnassignedTextTestLanguage.g:156:3: lv_val_1_0= RULE_INT
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
    // InternalUnassignedTextTestLanguage.g:180:1: entryRulePluralRule returns [EObject current=null] : iv_rulePluralRule= rulePluralRule EOF ;
    public final EObject entryRulePluralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePluralRule = null;


        try {
            // InternalUnassignedTextTestLanguage.g:181:2: (iv_rulePluralRule= rulePluralRule EOF )
            // InternalUnassignedTextTestLanguage.g:182:2: iv_rulePluralRule= rulePluralRule EOF
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
            // InternalUnassignedTextTestLanguage.g:192:28: ( (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) )
            // InternalUnassignedTextTestLanguage.g:193:1: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            {
            // InternalUnassignedTextTestLanguage.g:193:1: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            // InternalUnassignedTextTestLanguage.g:193:3: otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getPluralRuleAccess().getContentsKeyword_0());
                
            // InternalUnassignedTextTestLanguage.g:197:1: ( (lv_count_1_0= RULE_INT ) )
            // InternalUnassignedTextTestLanguage.g:198:1: (lv_count_1_0= RULE_INT )
            {
            // InternalUnassignedTextTestLanguage.g:198:1: (lv_count_1_0= RULE_INT )
            // InternalUnassignedTextTestLanguage.g:199:3: lv_count_1_0= RULE_INT
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
            // InternalUnassignedTextTestLanguage.g:228:2: (iv_ruleMultiRule= ruleMultiRule EOF )
            // InternalUnassignedTextTestLanguage.g:229:2: iv_ruleMultiRule= ruleMultiRule EOF
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
    // InternalUnassignedTextTestLanguage.g:236:1: ruleMultiRule returns [EObject current=null] : (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) ;
    public final EObject ruleMultiRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token this_Multi_2=null;
        Token this_Multi_3=null;
        Token this_Multi_4=null;

         enterRule(); 
            
        try {
            // InternalUnassignedTextTestLanguage.g:239:28: ( (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) )
            // InternalUnassignedTextTestLanguage.g:240:1: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            {
            // InternalUnassignedTextTestLanguage.g:240:1: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            // InternalUnassignedTextTestLanguage.g:240:3: otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiRuleAccess().getMultiKeyword_0());
                
            // InternalUnassignedTextTestLanguage.g:244:1: ( (lv_val_1_0= RULE_INT ) )
            // InternalUnassignedTextTestLanguage.g:245:1: (lv_val_1_0= RULE_INT )
            {
            // InternalUnassignedTextTestLanguage.g:245:1: (lv_val_1_0= RULE_INT )
            // InternalUnassignedTextTestLanguage.g:246:3: lv_val_1_0= RULE_INT
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
    // InternalUnassignedTextTestLanguage.g:282:1: entryRuleDatatypeRule returns [EObject current=null] : iv_ruleDatatypeRule= ruleDatatypeRule EOF ;
    public final EObject entryRuleDatatypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeRule = null;


        try {
            // InternalUnassignedTextTestLanguage.g:283:2: (iv_ruleDatatypeRule= ruleDatatypeRule EOF )
            // InternalUnassignedTextTestLanguage.g:284:2: iv_ruleDatatypeRule= ruleDatatypeRule EOF
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
    // InternalUnassignedTextTestLanguage.g:291:1: ruleDatatypeRule returns [EObject current=null] : (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) ;
    public final EObject ruleDatatypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // InternalUnassignedTextTestLanguage.g:294:28: ( (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) )
            // InternalUnassignedTextTestLanguage.g:295:1: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            {
            // InternalUnassignedTextTestLanguage.g:295:1: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            // InternalUnassignedTextTestLanguage.g:295:3: otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getDatatypeRuleAccess().getDatatypeKeyword_0());
                
            // InternalUnassignedTextTestLanguage.g:299:1: ( (lv_val_1_0= RULE_INT ) )
            // InternalUnassignedTextTestLanguage.g:300:1: (lv_val_1_0= RULE_INT )
            {
            // InternalUnassignedTextTestLanguage.g:300:1: (lv_val_1_0= RULE_INT )
            // InternalUnassignedTextTestLanguage.g:301:3: lv_val_1_0= RULE_INT
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
    // InternalUnassignedTextTestLanguage.g:333:1: entryRuleDatatype returns [String current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final String entryRuleDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype = null;


        try {
            // InternalUnassignedTextTestLanguage.g:334:2: (iv_ruleDatatype= ruleDatatype EOF )
            // InternalUnassignedTextTestLanguage.g:335:2: iv_ruleDatatype= ruleDatatype EOF
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
    // InternalUnassignedTextTestLanguage.g:342:1: ruleDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 ) ;
    public final AntlrDatatypeRuleToken ruleDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_Datatype2_2 = null;


         enterRule(); 
            
        try {
            // InternalUnassignedTextTestLanguage.g:345:28: ( (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 ) )
            // InternalUnassignedTextTestLanguage.g:346:1: (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 )
            {
            // InternalUnassignedTextTestLanguage.g:346:1: (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 )
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
                    // InternalUnassignedTextTestLanguage.g:347:2: kw= 'str'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDatatypeAccess().getStrKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalUnassignedTextTestLanguage.g:353:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getDatatypeAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalUnassignedTextTestLanguage.g:362:5: this_Datatype2_2= ruleDatatype2
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
    // InternalUnassignedTextTestLanguage.g:380:1: entryRuleDatatype2 returns [String current=null] : iv_ruleDatatype2= ruleDatatype2 EOF ;
    public final String entryRuleDatatype2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype2 = null;


        try {
            // InternalUnassignedTextTestLanguage.g:381:2: (iv_ruleDatatype2= ruleDatatype2 EOF )
            // InternalUnassignedTextTestLanguage.g:382:2: iv_ruleDatatype2= ruleDatatype2 EOF
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
    // InternalUnassignedTextTestLanguage.g:389:1: ruleDatatype2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleDatatype2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalUnassignedTextTestLanguage.g:392:28: (this_STRING_0= RULE_STRING )
            // InternalUnassignedTextTestLanguage.g:393:5: this_STRING_0= RULE_STRING
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
    // InternalUnassignedTextTestLanguage.g:408:1: entryRuleCommonTerminalsRule returns [EObject current=null] : iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF ;
    public final EObject entryRuleCommonTerminalsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommonTerminalsRule = null;


        try {
            // InternalUnassignedTextTestLanguage.g:409:2: (iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF )
            // InternalUnassignedTextTestLanguage.g:410:2: iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF
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
    // InternalUnassignedTextTestLanguage.g:417:1: ruleCommonTerminalsRule returns [EObject current=null] : (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) ;
    public final EObject ruleCommonTerminalsRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_ID_1=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;
        Token lv_val_4_0=null;

         enterRule(); 
            
        try {
            // InternalUnassignedTextTestLanguage.g:420:28: ( (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) )
            // InternalUnassignedTextTestLanguage.g:421:1: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            {
            // InternalUnassignedTextTestLanguage.g:421:1: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            // InternalUnassignedTextTestLanguage.g:421:3: otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getCommonTerminalsRuleAccess().getTerminalsKeyword_0());
                
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 
             
                newLeafNode(this_ID_1, grammarAccess.getCommonTerminalsRuleAccess().getIDTerminalRuleCall_1()); 
                
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_8); 
             
                newLeafNode(this_INT_2, grammarAccess.getCommonTerminalsRuleAccess().getINTTerminalRuleCall_2()); 
                
            this_STRING_3=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_7); 
             
                newLeafNode(this_STRING_3, grammarAccess.getCommonTerminalsRuleAccess().getSTRINGTerminalRuleCall_3()); 
                
            // InternalUnassignedTextTestLanguage.g:437:1: ( (lv_val_4_0= RULE_ID ) )
            // InternalUnassignedTextTestLanguage.g:438:1: (lv_val_4_0= RULE_ID )
            {
            // InternalUnassignedTextTestLanguage.g:438:1: (lv_val_4_0= RULE_ID )
            // InternalUnassignedTextTestLanguage.g:439:3: lv_val_4_0= RULE_ID
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
    }


}
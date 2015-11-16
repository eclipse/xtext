package org.eclipse.xtext.parsetree.unassignedtext.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.unassignedtext.services.UnassignedTextTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalUnassignedTextTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_CASEINSENSITIVEKEYWORD", "RULE_INT", "RULE_PLURAL", "RULE_MULTI", "RULE_STRING", "RULE_ID", "RULE_MULTI2", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'contents:'", "'multi'", "'datatype'", "'str'", "'terminals'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=9;
    public static final int RULE_STRING=8;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_CASEINSENSITIVEKEYWORD=4;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_MULTI2=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=13;
    public static final int RULE_SL_COMMENT=12;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_MULTI=7;
    public static final int RULE_PLURAL=6;

    // delegates
    // delegators


        public PsiInternalUnassignedTextTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalUnassignedTextTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalUnassignedTextTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalUnassignedTextTestLanguage.g"; }



    	protected UnassignedTextTestLanguageGrammarAccess grammarAccess;

    	protected UnassignedTextTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalUnassignedTextTestLanguageParser(PsiBuilder builder, TokenStream input, UnassignedTextTestLanguageElementTypeProvider elementTypeProvider, UnassignedTextTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalUnassignedTextTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalUnassignedTextTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalUnassignedTextTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalUnassignedTextTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean this_CaseInsensitiveKeywordRule_0 = null;

        Boolean this_PluralRule_1 = null;

        Boolean this_MultiRule_2 = null;

        Boolean this_DatatypeRule_3 = null;

        Boolean this_CommonTerminalsRule_4 = null;


        try {
            // PsiInternalUnassignedTextTestLanguage.g:60:1: ( (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule ) )
            // PsiInternalUnassignedTextTestLanguage.g:61:2: (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule )
            {
            // PsiInternalUnassignedTextTestLanguage.g:61:2: (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule )
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
                    // PsiInternalUnassignedTextTestLanguage.g:62:3: this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule
                    {

                    			markComposite(elementTypeProvider.getModel_CaseInsensitiveKeywordRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CaseInsensitiveKeywordRule_0=ruleCaseInsensitiveKeywordRule();

                    state._fsp--;


                    			current = this_CaseInsensitiveKeywordRule_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalUnassignedTextTestLanguage.g:71:3: this_PluralRule_1= rulePluralRule
                    {

                    			markComposite(elementTypeProvider.getModel_PluralRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PluralRule_1=rulePluralRule();

                    state._fsp--;


                    			current = this_PluralRule_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalUnassignedTextTestLanguage.g:80:3: this_MultiRule_2= ruleMultiRule
                    {

                    			markComposite(elementTypeProvider.getModel_MultiRuleParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_MultiRule_2=ruleMultiRule();

                    state._fsp--;


                    			current = this_MultiRule_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalUnassignedTextTestLanguage.g:89:3: this_DatatypeRule_3= ruleDatatypeRule
                    {

                    			markComposite(elementTypeProvider.getModel_DatatypeRuleParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DatatypeRule_3=ruleDatatypeRule();

                    state._fsp--;


                    			current = this_DatatypeRule_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalUnassignedTextTestLanguage.g:98:3: this_CommonTerminalsRule_4= ruleCommonTerminalsRule
                    {

                    			markComposite(elementTypeProvider.getModel_CommonTerminalsRuleParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CommonTerminalsRule_4=ruleCommonTerminalsRule();

                    state._fsp--;


                    			current = this_CommonTerminalsRule_4;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleCaseInsensitiveKeywordRule"
    // PsiInternalUnassignedTextTestLanguage.g:110:1: entryRuleCaseInsensitiveKeywordRule returns [Boolean current=false] : iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF ;
    public final Boolean entryRuleCaseInsensitiveKeywordRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCaseInsensitiveKeywordRule = null;


        try {
            // PsiInternalUnassignedTextTestLanguage.g:110:68: (iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF )
            // PsiInternalUnassignedTextTestLanguage.g:111:2: iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF
            {
             markComposite(elementTypeProvider.getCaseInsensitiveKeywordRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCaseInsensitiveKeywordRule=ruleCaseInsensitiveKeywordRule();

            state._fsp--;

             current =iv_ruleCaseInsensitiveKeywordRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseInsensitiveKeywordRule"


    // $ANTLR start "ruleCaseInsensitiveKeywordRule"
    // PsiInternalUnassignedTextTestLanguage.g:117:1: ruleCaseInsensitiveKeywordRule returns [Boolean current=false] : (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final Boolean ruleCaseInsensitiveKeywordRule() throws RecognitionException {
        Boolean current = false;

        Token this_CaseInsensitiveKeyword_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:118:1: ( (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) )
            // PsiInternalUnassignedTextTestLanguage.g:119:2: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            {
            // PsiInternalUnassignedTextTestLanguage.g:119:2: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            // PsiInternalUnassignedTextTestLanguage.g:120:3: this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) )
            {

            			markLeaf(elementTypeProvider.getCaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0ElementType());
            		
            this_CaseInsensitiveKeyword_0=(Token)match(input,RULE_CASEINSENSITIVEKEYWORD,FollowSets000.FOLLOW_3); 

            			doneLeaf(this_CaseInsensitiveKeyword_0);
            		
            // PsiInternalUnassignedTextTestLanguage.g:127:3: ( (lv_val_1_0= RULE_INT ) )
            // PsiInternalUnassignedTextTestLanguage.g:128:4: (lv_val_1_0= RULE_INT )
            {
            // PsiInternalUnassignedTextTestLanguage.g:128:4: (lv_val_1_0= RULE_INT )
            // PsiInternalUnassignedTextTestLanguage.g:129:5: lv_val_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getCaseInsensitiveKeywordRule_ValINTTerminalRuleCall_1_0ElementType());
            				
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val_1_0);
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseInsensitiveKeywordRule"


    // $ANTLR start "entryRulePluralRule"
    // PsiInternalUnassignedTextTestLanguage.g:148:1: entryRulePluralRule returns [Boolean current=false] : iv_rulePluralRule= rulePluralRule EOF ;
    public final Boolean entryRulePluralRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePluralRule = null;


        try {
            // PsiInternalUnassignedTextTestLanguage.g:148:52: (iv_rulePluralRule= rulePluralRule EOF )
            // PsiInternalUnassignedTextTestLanguage.g:149:2: iv_rulePluralRule= rulePluralRule EOF
            {
             markComposite(elementTypeProvider.getPluralRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePluralRule=rulePluralRule();

            state._fsp--;

             current =iv_rulePluralRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePluralRule"


    // $ANTLR start "rulePluralRule"
    // PsiInternalUnassignedTextTestLanguage.g:155:1: rulePluralRule returns [Boolean current=false] : (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) ;
    public final Boolean rulePluralRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_count_1_0=null;
        Token this_Plural_2=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:156:1: ( (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) )
            // PsiInternalUnassignedTextTestLanguage.g:157:2: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            {
            // PsiInternalUnassignedTextTestLanguage.g:157:2: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            // PsiInternalUnassignedTextTestLanguage.g:158:3: otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL
            {

            			markLeaf(elementTypeProvider.getPluralRule_ContentsKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalUnassignedTextTestLanguage.g:165:3: ( (lv_count_1_0= RULE_INT ) )
            // PsiInternalUnassignedTextTestLanguage.g:166:4: (lv_count_1_0= RULE_INT )
            {
            // PsiInternalUnassignedTextTestLanguage.g:166:4: (lv_count_1_0= RULE_INT )
            // PsiInternalUnassignedTextTestLanguage.g:167:5: lv_count_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getPluralRule_CountINTTerminalRuleCall_1_0ElementType());
            				
            lv_count_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_count_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getPluralRule_PluralTerminalRuleCall_2ElementType());
            		
            this_Plural_2=(Token)match(input,RULE_PLURAL,FollowSets000.FOLLOW_2); 

            			doneLeaf(this_Plural_2);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePluralRule"


    // $ANTLR start "entryRuleMultiRule"
    // PsiInternalUnassignedTextTestLanguage.g:193:1: entryRuleMultiRule returns [Boolean current=false] : iv_ruleMultiRule= ruleMultiRule EOF ;
    public final Boolean entryRuleMultiRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMultiRule = null;


        try {
            // PsiInternalUnassignedTextTestLanguage.g:193:51: (iv_ruleMultiRule= ruleMultiRule EOF )
            // PsiInternalUnassignedTextTestLanguage.g:194:2: iv_ruleMultiRule= ruleMultiRule EOF
            {
             markComposite(elementTypeProvider.getMultiRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiRule=ruleMultiRule();

            state._fsp--;

             current =iv_ruleMultiRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiRule"


    // $ANTLR start "ruleMultiRule"
    // PsiInternalUnassignedTextTestLanguage.g:200:1: ruleMultiRule returns [Boolean current=false] : (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) ;
    public final Boolean ruleMultiRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token this_Multi_2=null;
        Token this_Multi_3=null;
        Token this_Multi_4=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:201:1: ( (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) )
            // PsiInternalUnassignedTextTestLanguage.g:202:2: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            {
            // PsiInternalUnassignedTextTestLanguage.g:202:2: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            // PsiInternalUnassignedTextTestLanguage.g:203:3: otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI
            {

            			markLeaf(elementTypeProvider.getMultiRule_MultiKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalUnassignedTextTestLanguage.g:210:3: ( (lv_val_1_0= RULE_INT ) )
            // PsiInternalUnassignedTextTestLanguage.g:211:4: (lv_val_1_0= RULE_INT )
            {
            // PsiInternalUnassignedTextTestLanguage.g:211:4: (lv_val_1_0= RULE_INT )
            // PsiInternalUnassignedTextTestLanguage.g:212:5: lv_val_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMultiRule_ValINTTerminalRuleCall_1_0ElementType());
            				
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_5); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMultiRule_MultiTerminalRuleCall_2ElementType());
            		
            this_Multi_2=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_5); 

            			doneLeaf(this_Multi_2);
            		

            			markLeaf(elementTypeProvider.getMultiRule_MultiTerminalRuleCall_3ElementType());
            		
            this_Multi_3=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_5); 

            			doneLeaf(this_Multi_3);
            		

            			markLeaf(elementTypeProvider.getMultiRule_MultiTerminalRuleCall_4ElementType());
            		
            this_Multi_4=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_2); 

            			doneLeaf(this_Multi_4);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiRule"


    // $ANTLR start "entryRuleDatatypeRule"
    // PsiInternalUnassignedTextTestLanguage.g:252:1: entryRuleDatatypeRule returns [Boolean current=false] : iv_ruleDatatypeRule= ruleDatatypeRule EOF ;
    public final Boolean entryRuleDatatypeRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatypeRule = null;


        try {
            // PsiInternalUnassignedTextTestLanguage.g:252:54: (iv_ruleDatatypeRule= ruleDatatypeRule EOF )
            // PsiInternalUnassignedTextTestLanguage.g:253:2: iv_ruleDatatypeRule= ruleDatatypeRule EOF
            {
             markComposite(elementTypeProvider.getDatatypeRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatypeRule=ruleDatatypeRule();

            state._fsp--;

             current =iv_ruleDatatypeRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDatatypeRule"


    // $ANTLR start "ruleDatatypeRule"
    // PsiInternalUnassignedTextTestLanguage.g:259:1: ruleDatatypeRule returns [Boolean current=false] : (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) ;
    public final Boolean ruleDatatypeRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:260:1: ( (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) )
            // PsiInternalUnassignedTextTestLanguage.g:261:2: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            {
            // PsiInternalUnassignedTextTestLanguage.g:261:2: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            // PsiInternalUnassignedTextTestLanguage.g:262:3: otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype
            {

            			markLeaf(elementTypeProvider.getDatatypeRule_DatatypeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalUnassignedTextTestLanguage.g:269:3: ( (lv_val_1_0= RULE_INT ) )
            // PsiInternalUnassignedTextTestLanguage.g:270:4: (lv_val_1_0= RULE_INT )
            {
            // PsiInternalUnassignedTextTestLanguage.g:270:4: (lv_val_1_0= RULE_INT )
            // PsiInternalUnassignedTextTestLanguage.g:271:5: lv_val_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getDatatypeRule_ValINTTerminalRuleCall_1_0ElementType());
            				
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_6); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val_1_0);
            				

            }


            }


            			markComposite(elementTypeProvider.getDatatypeRule_DatatypeParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_2);
            ruleDatatype();

            state._fsp--;


            			doneComposite();
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDatatypeRule"


    // $ANTLR start "entryRuleDatatype"
    // PsiInternalUnassignedTextTestLanguage.g:297:1: entryRuleDatatype returns [Boolean current=false] : iv_ruleDatatype= ruleDatatype EOF ;
    public final Boolean entryRuleDatatype() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatype = null;


        try {
            // PsiInternalUnassignedTextTestLanguage.g:297:50: (iv_ruleDatatype= ruleDatatype EOF )
            // PsiInternalUnassignedTextTestLanguage.g:298:2: iv_ruleDatatype= ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatype=ruleDatatype();

            state._fsp--;

             current =iv_ruleDatatype; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // PsiInternalUnassignedTextTestLanguage.g:304:1: ruleDatatype returns [Boolean current=false] : (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 ) ;
    public final Boolean ruleDatatype() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_INT_1=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:305:1: ( (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 ) )
            // PsiInternalUnassignedTextTestLanguage.g:306:2: (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 )
            {
            // PsiInternalUnassignedTextTestLanguage.g:306:2: (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 )
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
                    // PsiInternalUnassignedTextTestLanguage.g:307:3: kw= 'str'
                    {

                    			markLeaf(elementTypeProvider.getDatatype_StrKeyword_0ElementType());
                    		
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalUnassignedTextTestLanguage.g:315:3: this_INT_1= RULE_INT
                    {

                    			markLeaf(elementTypeProvider.getDatatype_INTTerminalRuleCall_1ElementType());
                    		
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    			doneLeaf(this_INT_1);
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalUnassignedTextTestLanguage.g:323:3: ruleDatatype2
                    {

                    			markComposite(elementTypeProvider.getDatatype_Datatype2ParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDatatype2();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "entryRuleDatatype2"
    // PsiInternalUnassignedTextTestLanguage.g:334:1: entryRuleDatatype2 returns [Boolean current=false] : iv_ruleDatatype2= ruleDatatype2 EOF ;
    public final Boolean entryRuleDatatype2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatype2 = null;


        try {
            // PsiInternalUnassignedTextTestLanguage.g:334:51: (iv_ruleDatatype2= ruleDatatype2 EOF )
            // PsiInternalUnassignedTextTestLanguage.g:335:2: iv_ruleDatatype2= ruleDatatype2 EOF
            {
             markComposite(elementTypeProvider.getDatatype2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatype2=ruleDatatype2();

            state._fsp--;

             current =iv_ruleDatatype2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDatatype2"


    // $ANTLR start "ruleDatatype2"
    // PsiInternalUnassignedTextTestLanguage.g:341:1: ruleDatatype2 returns [Boolean current=false] : this_STRING_0= RULE_STRING ;
    public final Boolean ruleDatatype2() throws RecognitionException {
        Boolean current = false;

        Token this_STRING_0=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:342:1: (this_STRING_0= RULE_STRING )
            // PsiInternalUnassignedTextTestLanguage.g:343:2: this_STRING_0= RULE_STRING
            {

            		markLeaf(elementTypeProvider.getDatatype2_STRINGTerminalRuleCallElementType());
            	
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            		doneLeaf(this_STRING_0);
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDatatype2"


    // $ANTLR start "entryRuleCommonTerminalsRule"
    // PsiInternalUnassignedTextTestLanguage.g:353:1: entryRuleCommonTerminalsRule returns [Boolean current=false] : iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF ;
    public final Boolean entryRuleCommonTerminalsRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCommonTerminalsRule = null;


        try {
            // PsiInternalUnassignedTextTestLanguage.g:353:61: (iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF )
            // PsiInternalUnassignedTextTestLanguage.g:354:2: iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF
            {
             markComposite(elementTypeProvider.getCommonTerminalsRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCommonTerminalsRule=ruleCommonTerminalsRule();

            state._fsp--;

             current =iv_ruleCommonTerminalsRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommonTerminalsRule"


    // $ANTLR start "ruleCommonTerminalsRule"
    // PsiInternalUnassignedTextTestLanguage.g:360:1: ruleCommonTerminalsRule returns [Boolean current=false] : (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) ;
    public final Boolean ruleCommonTerminalsRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token this_ID_1=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;
        Token lv_val_4_0=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:361:1: ( (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) )
            // PsiInternalUnassignedTextTestLanguage.g:362:2: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            {
            // PsiInternalUnassignedTextTestLanguage.g:362:2: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            // PsiInternalUnassignedTextTestLanguage.g:363:3: otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getCommonTerminalsRule_TerminalsKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getCommonTerminalsRule_IDTerminalRuleCall_1ElementType());
            		
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            			doneLeaf(this_ID_1);
            		

            			markLeaf(elementTypeProvider.getCommonTerminalsRule_INTTerminalRuleCall_2ElementType());
            		
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_8); 

            			doneLeaf(this_INT_2);
            		

            			markLeaf(elementTypeProvider.getCommonTerminalsRule_STRINGTerminalRuleCall_3ElementType());
            		
            this_STRING_3=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_7); 

            			doneLeaf(this_STRING_3);
            		
            // PsiInternalUnassignedTextTestLanguage.g:391:3: ( (lv_val_4_0= RULE_ID ) )
            // PsiInternalUnassignedTextTestLanguage.g:392:4: (lv_val_4_0= RULE_ID )
            {
            // PsiInternalUnassignedTextTestLanguage.g:392:4: (lv_val_4_0= RULE_ID )
            // PsiInternalUnassignedTextTestLanguage.g:393:5: lv_val_4_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getCommonTerminalsRule_ValIDTerminalRuleCall_4_0ElementType());
            				
            lv_val_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val_4_0);
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
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
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:59:1: ruleModel : ( ruleCaseInsensitiveKeywordRule | rulePluralRule | ruleMultiRule | ruleDatatypeRule | ruleCommonTerminalsRule ) ;
    public final void ruleModel() throws RecognitionException {


        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:62:2: ( ( ruleCaseInsensitiveKeywordRule | rulePluralRule | ruleMultiRule | ruleDatatypeRule | ruleCommonTerminalsRule ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:63:2: ( ruleCaseInsensitiveKeywordRule | rulePluralRule | ruleMultiRule | ruleDatatypeRule | ruleCommonTerminalsRule )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:63:2: ( ruleCaseInsensitiveKeywordRule | rulePluralRule | ruleMultiRule | ruleDatatypeRule | ruleCommonTerminalsRule )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:64:3: ruleCaseInsensitiveKeywordRule
                    {

                    			markComposite(elementTypeProvider.getModel_CaseInsensitiveKeywordRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCaseInsensitiveKeywordRule_in_ruleModel86);
                    ruleCaseInsensitiveKeywordRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:72:3: rulePluralRule
                    {

                    			markComposite(elementTypeProvider.getModel_PluralRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_rulePluralRule_in_ruleModel106);
                    rulePluralRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:80:3: ruleMultiRule
                    {

                    			markComposite(elementTypeProvider.getModel_MultiRuleParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleMultiRule_in_ruleModel126);
                    ruleMultiRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:88:3: ruleDatatypeRule
                    {

                    			markComposite(elementTypeProvider.getModel_DatatypeRuleParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_ruleModel146);
                    ruleDatatypeRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:96:3: ruleCommonTerminalsRule
                    {

                    			markComposite(elementTypeProvider.getModel_CommonTerminalsRuleParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCommonTerminalsRule_in_ruleModel166);
                    ruleCommonTerminalsRule();

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
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleCaseInsensitiveKeywordRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:107:1: entryRuleCaseInsensitiveKeywordRule : ruleCaseInsensitiveKeywordRule EOF ;
    public final void entryRuleCaseInsensitiveKeywordRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:107:36: ( ruleCaseInsensitiveKeywordRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:108:2: ruleCaseInsensitiveKeywordRule EOF
            {
             markComposite(elementTypeProvider.getCaseInsensitiveKeywordRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCaseInsensitiveKeywordRule_in_entryRuleCaseInsensitiveKeywordRule186);
            ruleCaseInsensitiveKeywordRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCaseInsensitiveKeywordRule192); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCaseInsensitiveKeywordRule"


    // $ANTLR start "ruleCaseInsensitiveKeywordRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:114:1: ruleCaseInsensitiveKeywordRule : (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final void ruleCaseInsensitiveKeywordRule() throws RecognitionException {
        Token this_CaseInsensitiveKeyword_0=null;
        Token lv_val_1_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:117:2: ( (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:118:2: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:118:2: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:119:3: this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) )
            {

            			markLeaf();
            		
            this_CaseInsensitiveKeyword_0=(Token)match(input,RULE_CASEINSENSITIVEKEYWORD,FollowSets000.FOLLOW_RULE_CASEINSENSITIVEKEYWORD_in_ruleCaseInsensitiveKeywordRule220); 

            			doneLeaf(this_CaseInsensitiveKeyword_0, elementTypeProvider.getCaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:126:3: ( (lv_val_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:127:4: (lv_val_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:127:4: (lv_val_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:128:5: lv_val_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCaseInsensitiveKeywordRule247); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getCaseInsensitiveKeywordRule_ValINTTerminalRuleCall_1_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleCaseInsensitiveKeywordRule"


    // $ANTLR start "entryRulePluralRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:141:1: entryRulePluralRule : rulePluralRule EOF ;
    public final void entryRulePluralRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:141:20: ( rulePluralRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:142:2: rulePluralRule EOF
            {
             markComposite(elementTypeProvider.getPluralRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePluralRule_in_entryRulePluralRule278);
            rulePluralRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePluralRule284); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePluralRule"


    // $ANTLR start "rulePluralRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:148:1: rulePluralRule : (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) ;
    public final void rulePluralRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_count_1_0=null;
        Token this_Plural_2=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:151:2: ( (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:152:2: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:152:2: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:153:3: otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_rulePluralRule312); 

            			doneLeaf(otherlv_0, elementTypeProvider.getPluralRule_ContentsKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:160:3: ( (lv_count_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:161:4: (lv_count_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:161:4: (lv_count_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:162:5: lv_count_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_count_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePluralRule339); 

            					doneLeaf(lv_count_1_0, elementTypeProvider.getPluralRule_CountINTTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            this_Plural_2=(Token)match(input,RULE_PLURAL,FollowSets000.FOLLOW_RULE_PLURAL_in_rulePluralRule364); 

            			doneLeaf(this_Plural_2, elementTypeProvider.getPluralRule_PluralTerminalRuleCall_2ElementType());
            		

            }


            }



        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rulePluralRule"


    // $ANTLR start "entryRuleMultiRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:182:1: entryRuleMultiRule : ruleMultiRule EOF ;
    public final void entryRuleMultiRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:182:19: ( ruleMultiRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:183:2: ruleMultiRule EOF
            {
             markComposite(elementTypeProvider.getMultiRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiRule_in_entryRuleMultiRule384);
            ruleMultiRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiRule390); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiRule"


    // $ANTLR start "ruleMultiRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:189:1: ruleMultiRule : (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) ;
    public final void ruleMultiRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token this_Multi_2=null;
        Token this_Multi_3=null;
        Token this_Multi_4=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:192:2: ( (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:193:2: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:193:2: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:194:3: otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiRule418); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMultiRule_MultiKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:201:3: ( (lv_val_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:202:4: (lv_val_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:202:4: (lv_val_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:203:5: lv_val_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMultiRule445); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getMultiRule_ValINTTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            this_Multi_2=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_RULE_MULTI_in_ruleMultiRule470); 

            			doneLeaf(this_Multi_2, elementTypeProvider.getMultiRule_MultiTerminalRuleCall_2ElementType());
            		

            			markLeaf();
            		
            this_Multi_3=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_RULE_MULTI_in_ruleMultiRule484); 

            			doneLeaf(this_Multi_3, elementTypeProvider.getMultiRule_MultiTerminalRuleCall_3ElementType());
            		

            			markLeaf();
            		
            this_Multi_4=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_RULE_MULTI_in_ruleMultiRule498); 

            			doneLeaf(this_Multi_4, elementTypeProvider.getMultiRule_MultiTerminalRuleCall_4ElementType());
            		

            }


            }



        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleMultiRule"


    // $ANTLR start "entryRuleDatatypeRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:237:1: entryRuleDatatypeRule : ruleDatatypeRule EOF ;
    public final void entryRuleDatatypeRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:237:22: ( ruleDatatypeRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:238:2: ruleDatatypeRule EOF
            {
             markComposite(elementTypeProvider.getDatatypeRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule518);
            ruleDatatypeRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeRule524); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDatatypeRule"


    // $ANTLR start "ruleDatatypeRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:244:1: ruleDatatypeRule : (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) ;
    public final void ruleDatatypeRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:247:2: ( (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:248:2: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:248:2: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:249:3: otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDatatypeRule552); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDatatypeRule_DatatypeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:256:3: ( (lv_val_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:257:4: (lv_val_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:257:4: (lv_val_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:258:5: lv_val_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDatatypeRule579); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getDatatypeRule_ValINTTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markComposite(elementTypeProvider.getDatatypeRule_DatatypeParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleDatatypeRule602);
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
        return ;
    }
    // $ANTLR end "ruleDatatypeRule"


    // $ANTLR start "entryRuleDatatype"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:278:1: entryRuleDatatype : ruleDatatype EOF ;
    public final void entryRuleDatatype() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:278:18: ( ruleDatatype EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:279:2: ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_entryRuleDatatype622);
            ruleDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype628); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:285:1: ruleDatatype : (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 ) ;
    public final void ruleDatatype() throws RecognitionException {
        Token kw=null;
        Token this_INT_1=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:288:2: ( (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:289:2: (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:289:2: (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:290:3: kw= 'str'
                    {

                    			markLeaf();
                    		
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleDatatype656); 

                    			doneLeaf(kw, elementTypeProvider.getDatatype_StrKeyword_0ElementType());
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:298:3: this_INT_1= RULE_INT
                    {

                    			markLeaf();
                    		
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDatatype678); 

                    			doneLeaf(this_INT_1, elementTypeProvider.getDatatype_INTTerminalRuleCall_1ElementType());
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:306:3: ruleDatatype2
                    {

                    			markComposite(elementTypeProvider.getDatatype_Datatype2ParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype2_in_ruleDatatype698);
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
        return ;
    }
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "entryRuleDatatype2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:317:1: entryRuleDatatype2 : ruleDatatype2 EOF ;
    public final void entryRuleDatatype2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:317:19: ( ruleDatatype2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:318:2: ruleDatatype2 EOF
            {
             markComposite(elementTypeProvider.getDatatype2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype2_in_entryRuleDatatype2718);
            ruleDatatype2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype2724); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDatatype2"


    // $ANTLR start "ruleDatatype2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:324:1: ruleDatatype2 : this_STRING_0= RULE_STRING ;
    public final void ruleDatatype2() throws RecognitionException {
        Token this_STRING_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:327:2: (this_STRING_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:328:2: this_STRING_0= RULE_STRING
            {

            		markLeaf();
            	
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleDatatype2747); 

            		doneLeaf(this_STRING_0, elementTypeProvider.getDatatype2_STRINGTerminalRuleCallElementType());
            	

            }



        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleDatatype2"


    // $ANTLR start "entryRuleCommonTerminalsRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:338:1: entryRuleCommonTerminalsRule : ruleCommonTerminalsRule EOF ;
    public final void entryRuleCommonTerminalsRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:338:29: ( ruleCommonTerminalsRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:339:2: ruleCommonTerminalsRule EOF
            {
             markComposite(elementTypeProvider.getCommonTerminalsRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCommonTerminalsRule_in_entryRuleCommonTerminalsRule763);
            ruleCommonTerminalsRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommonTerminalsRule769); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCommonTerminalsRule"


    // $ANTLR start "ruleCommonTerminalsRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:345:1: ruleCommonTerminalsRule : (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) ;
    public final void ruleCommonTerminalsRule() throws RecognitionException {
        Token otherlv_0=null;
        Token this_ID_1=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;
        Token lv_val_4_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:348:2: ( (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:349:2: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:349:2: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:350:3: otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCommonTerminalsRule797); 

            			doneLeaf(otherlv_0, elementTypeProvider.getCommonTerminalsRule_TerminalsKeyword_0ElementType());
            		

            			markLeaf();
            		
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCommonTerminalsRule811); 

            			doneLeaf(this_ID_1, elementTypeProvider.getCommonTerminalsRule_IDTerminalRuleCall_1ElementType());
            		

            			markLeaf();
            		
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCommonTerminalsRule825); 

            			doneLeaf(this_INT_2, elementTypeProvider.getCommonTerminalsRule_INTTerminalRuleCall_2ElementType());
            		

            			markLeaf();
            		
            this_STRING_3=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCommonTerminalsRule839); 

            			doneLeaf(this_STRING_3, elementTypeProvider.getCommonTerminalsRule_STRINGTerminalRuleCall_3ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:378:3: ( (lv_val_4_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:379:4: (lv_val_4_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:379:4: (lv_val_4_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:380:5: lv_val_4_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCommonTerminalsRule866); 

            					doneLeaf(lv_val_4_0, elementTypeProvider.getCommonTerminalsRule_ValIDTerminalRuleCall_4_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleCommonTerminalsRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCaseInsensitiveKeywordRule_in_ruleModel86 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePluralRule_in_ruleModel106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiRule_in_ruleModel126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_ruleModel146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommonTerminalsRule_in_ruleModel166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCaseInsensitiveKeywordRule_in_entryRuleCaseInsensitiveKeywordRule186 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCaseInsensitiveKeywordRule192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_CASEINSENSITIVEKEYWORD_in_ruleCaseInsensitiveKeywordRule220 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCaseInsensitiveKeywordRule247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePluralRule_in_entryRulePluralRule278 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePluralRule284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rulePluralRule312 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePluralRule339 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_PLURAL_in_rulePluralRule364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiRule_in_entryRuleMultiRule384 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiRule390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleMultiRule418 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMultiRule445 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_MULTI_in_ruleMultiRule470 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_MULTI_in_ruleMultiRule484 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_MULTI_in_ruleMultiRule498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule518 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeRule524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleDatatypeRule552 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDatatypeRule579 = new BitSet(new long[]{0x0000000000040120L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleDatatypeRule602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype622 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleDatatype656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDatatype678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype2_in_ruleDatatype698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype2_in_entryRuleDatatype2718 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype2724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleDatatype2747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommonTerminalsRule_in_entryRuleCommonTerminalsRule763 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommonTerminalsRule769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleCommonTerminalsRule797 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCommonTerminalsRule811 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCommonTerminalsRule825 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCommonTerminalsRule839 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCommonTerminalsRule866 = new BitSet(new long[]{0x0000000000000002L});
    }


}
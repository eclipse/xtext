package org.eclipse.xtext.parsetree.unassignedtext.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:51:2: ruleModel EOF
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:59:10: ( ( ruleCaseInsensitiveKeywordRule | rulePluralRule | ruleMultiRule | ruleDatatypeRule | ruleCommonTerminalsRule ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:60:2: ( ruleCaseInsensitiveKeywordRule | rulePluralRule | ruleMultiRule | ruleDatatypeRule | ruleCommonTerminalsRule )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:60:2: ( ruleCaseInsensitiveKeywordRule | rulePluralRule | ruleMultiRule | ruleDatatypeRule | ruleCommonTerminalsRule )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:61:3: ruleCaseInsensitiveKeywordRule
                    {

                    			markComposite(elementTypeProvider.getModel_CaseInsensitiveKeywordRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCaseInsensitiveKeywordRule_in_ruleModel81);
                    ruleCaseInsensitiveKeywordRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:69:3: rulePluralRule
                    {

                    			markComposite(elementTypeProvider.getModel_PluralRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_rulePluralRule_in_ruleModel101);
                    rulePluralRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:77:3: ruleMultiRule
                    {

                    			markComposite(elementTypeProvider.getModel_MultiRuleParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleMultiRule_in_ruleModel121);
                    ruleMultiRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:85:3: ruleDatatypeRule
                    {

                    			markComposite(elementTypeProvider.getModel_DatatypeRuleParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_ruleModel141);
                    ruleDatatypeRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:93:3: ruleCommonTerminalsRule
                    {

                    			markComposite(elementTypeProvider.getModel_CommonTerminalsRuleParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCommonTerminalsRule_in_ruleModel161);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:104:1: entryRuleCaseInsensitiveKeywordRule : ruleCaseInsensitiveKeywordRule EOF ;
    public final void entryRuleCaseInsensitiveKeywordRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:104:36: ( ruleCaseInsensitiveKeywordRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:105:2: ruleCaseInsensitiveKeywordRule EOF
            {
             markComposite(elementTypeProvider.getCaseInsensitiveKeywordRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCaseInsensitiveKeywordRule_in_entryRuleCaseInsensitiveKeywordRule181);
            ruleCaseInsensitiveKeywordRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCaseInsensitiveKeywordRule187); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:113:1: ruleCaseInsensitiveKeywordRule : (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final void ruleCaseInsensitiveKeywordRule() throws RecognitionException {
        Token this_CaseInsensitiveKeyword_0=null;
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:113:31: ( (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:114:2: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:114:2: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:115:3: this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) )
            {

            			markLeaf();
            		
            this_CaseInsensitiveKeyword_0=(Token)match(input,RULE_CASEINSENSITIVEKEYWORD,FollowSets000.FOLLOW_RULE_CASEINSENSITIVEKEYWORD_in_ruleCaseInsensitiveKeywordRule210); 

            			doneLeaf(this_CaseInsensitiveKeyword_0, elementTypeProvider.getCaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:122:3: ( (lv_val_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:123:4: (lv_val_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:123:4: (lv_val_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:124:5: lv_val_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCaseInsensitiveKeywordRule237); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:137:1: entryRulePluralRule : rulePluralRule EOF ;
    public final void entryRulePluralRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:137:20: ( rulePluralRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:138:2: rulePluralRule EOF
            {
             markComposite(elementTypeProvider.getPluralRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePluralRule_in_entryRulePluralRule268);
            rulePluralRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePluralRule274); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:146:1: rulePluralRule : (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) ;
    public final void rulePluralRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_count_1_0=null;
        Token this_Plural_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:146:15: ( (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:147:2: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:147:2: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:148:3: otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_rulePluralRule297); 

            			doneLeaf(otherlv_0, elementTypeProvider.getPluralRule_ContentsKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:155:3: ( (lv_count_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:156:4: (lv_count_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:156:4: (lv_count_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:157:5: lv_count_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_count_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePluralRule324); 

            					doneLeaf(lv_count_1_0, elementTypeProvider.getPluralRule_CountINTTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            this_Plural_2=(Token)match(input,RULE_PLURAL,FollowSets000.FOLLOW_RULE_PLURAL_in_rulePluralRule349); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:177:1: entryRuleMultiRule : ruleMultiRule EOF ;
    public final void entryRuleMultiRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:177:19: ( ruleMultiRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:178:2: ruleMultiRule EOF
            {
             markComposite(elementTypeProvider.getMultiRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiRule_in_entryRuleMultiRule369);
            ruleMultiRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiRule375); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:186:1: ruleMultiRule : (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) ;
    public final void ruleMultiRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token this_Multi_2=null;
        Token this_Multi_3=null;
        Token this_Multi_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:186:14: ( (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:187:2: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:187:2: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:188:3: otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiRule398); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMultiRule_MultiKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:195:3: ( (lv_val_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:196:4: (lv_val_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:196:4: (lv_val_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:197:5: lv_val_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMultiRule425); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getMultiRule_ValINTTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            this_Multi_2=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_RULE_MULTI_in_ruleMultiRule450); 

            			doneLeaf(this_Multi_2, elementTypeProvider.getMultiRule_MultiTerminalRuleCall_2ElementType());
            		

            			markLeaf();
            		
            this_Multi_3=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_RULE_MULTI_in_ruleMultiRule464); 

            			doneLeaf(this_Multi_3, elementTypeProvider.getMultiRule_MultiTerminalRuleCall_3ElementType());
            		

            			markLeaf();
            		
            this_Multi_4=(Token)match(input,RULE_MULTI,FollowSets000.FOLLOW_RULE_MULTI_in_ruleMultiRule478); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:231:1: entryRuleDatatypeRule : ruleDatatypeRule EOF ;
    public final void entryRuleDatatypeRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:231:22: ( ruleDatatypeRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:232:2: ruleDatatypeRule EOF
            {
             markComposite(elementTypeProvider.getDatatypeRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule498);
            ruleDatatypeRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeRule504); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:240:1: ruleDatatypeRule : (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) ;
    public final void ruleDatatypeRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:240:17: ( (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:241:2: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:241:2: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:242:3: otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDatatypeRule527); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDatatypeRule_DatatypeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:249:3: ( (lv_val_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:250:4: (lv_val_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:250:4: (lv_val_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:251:5: lv_val_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDatatypeRule554); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getDatatypeRule_ValINTTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markComposite(elementTypeProvider.getDatatypeRule_DatatypeParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleDatatypeRule577);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:271:1: entryRuleDatatype : ruleDatatype EOF ;
    public final void entryRuleDatatype() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:271:18: ( ruleDatatype EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:272:2: ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_entryRuleDatatype597);
            ruleDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype603); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:280:1: ruleDatatype : (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 ) ;
    public final void ruleDatatype() throws RecognitionException {
        Token kw=null;
        Token this_INT_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:280:13: ( (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:281:2: (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:281:2: (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:282:3: kw= 'str'
                    {

                    			markLeaf();
                    		
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleDatatype626); 

                    			doneLeaf(kw, elementTypeProvider.getDatatype_StrKeyword_0ElementType());
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:290:3: this_INT_1= RULE_INT
                    {

                    			markLeaf();
                    		
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDatatype648); 

                    			doneLeaf(this_INT_1, elementTypeProvider.getDatatype_INTTerminalRuleCall_1ElementType());
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:298:3: ruleDatatype2
                    {

                    			markComposite(elementTypeProvider.getDatatype_Datatype2ParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype2_in_ruleDatatype668);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:309:1: entryRuleDatatype2 : ruleDatatype2 EOF ;
    public final void entryRuleDatatype2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:309:19: ( ruleDatatype2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:310:2: ruleDatatype2 EOF
            {
             markComposite(elementTypeProvider.getDatatype2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype2_in_entryRuleDatatype2688);
            ruleDatatype2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype2694); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:318:1: ruleDatatype2 : this_STRING_0= RULE_STRING ;
    public final void ruleDatatype2() throws RecognitionException {
        Token this_STRING_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:318:14: (this_STRING_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:319:2: this_STRING_0= RULE_STRING
            {

            		markLeaf();
            	
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleDatatype2712); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:329:1: entryRuleCommonTerminalsRule : ruleCommonTerminalsRule EOF ;
    public final void entryRuleCommonTerminalsRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:329:29: ( ruleCommonTerminalsRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:330:2: ruleCommonTerminalsRule EOF
            {
             markComposite(elementTypeProvider.getCommonTerminalsRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCommonTerminalsRule_in_entryRuleCommonTerminalsRule728);
            ruleCommonTerminalsRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommonTerminalsRule734); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:338:1: ruleCommonTerminalsRule : (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) ;
    public final void ruleCommonTerminalsRule() throws RecognitionException {
        Token otherlv_0=null;
        Token this_ID_1=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;
        Token lv_val_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:338:24: ( (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:339:2: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:339:2: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:340:3: otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCommonTerminalsRule757); 

            			doneLeaf(otherlv_0, elementTypeProvider.getCommonTerminalsRule_TerminalsKeyword_0ElementType());
            		

            			markLeaf();
            		
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCommonTerminalsRule771); 

            			doneLeaf(this_ID_1, elementTypeProvider.getCommonTerminalsRule_IDTerminalRuleCall_1ElementType());
            		

            			markLeaf();
            		
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCommonTerminalsRule785); 

            			doneLeaf(this_INT_2, elementTypeProvider.getCommonTerminalsRule_INTTerminalRuleCall_2ElementType());
            		

            			markLeaf();
            		
            this_STRING_3=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCommonTerminalsRule799); 

            			doneLeaf(this_STRING_3, elementTypeProvider.getCommonTerminalsRule_STRINGTerminalRuleCall_3ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:368:3: ( (lv_val_4_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:369:4: (lv_val_4_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:369:4: (lv_val_4_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/idea/parser/antlr/internal/PsiInternalUnassignedTextTestLanguage.g:370:5: lv_val_4_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCommonTerminalsRule826); 

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
        public static final BitSet FOLLOW_ruleCaseInsensitiveKeywordRule_in_ruleModel81 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePluralRule_in_ruleModel101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiRule_in_ruleModel121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_ruleModel141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommonTerminalsRule_in_ruleModel161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCaseInsensitiveKeywordRule_in_entryRuleCaseInsensitiveKeywordRule181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCaseInsensitiveKeywordRule187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_CASEINSENSITIVEKEYWORD_in_ruleCaseInsensitiveKeywordRule210 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCaseInsensitiveKeywordRule237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePluralRule_in_entryRulePluralRule268 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePluralRule274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rulePluralRule297 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePluralRule324 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_PLURAL_in_rulePluralRule349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiRule_in_entryRuleMultiRule369 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiRule375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleMultiRule398 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMultiRule425 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_MULTI_in_ruleMultiRule450 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_MULTI_in_ruleMultiRule464 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_MULTI_in_ruleMultiRule478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule498 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeRule504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleDatatypeRule527 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDatatypeRule554 = new BitSet(new long[]{0x0000000000040120L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleDatatypeRule577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype597 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleDatatype626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDatatype648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype2_in_ruleDatatype668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype2_in_entryRuleDatatype2688 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype2694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleDatatype2712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommonTerminalsRule_in_entryRuleCommonTerminalsRule728 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommonTerminalsRule734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleCommonTerminalsRule757 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCommonTerminalsRule771 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCommonTerminalsRule785 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCommonTerminalsRule799 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCommonTerminalsRule826 = new BitSet(new long[]{0x0000000000000002L});
    }


}
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
    // PsiInternalUnassignedTextTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalUnassignedTextTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalUnassignedTextTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalUnassignedTextTestLanguage.g:58:1: ruleModel : ( ruleCaseInsensitiveKeywordRule | rulePluralRule | ruleMultiRule | ruleDatatypeRule | ruleCommonTerminalsRule ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalUnassignedTextTestLanguage.g:58:10: ( ( ruleCaseInsensitiveKeywordRule | rulePluralRule | ruleMultiRule | ruleDatatypeRule | ruleCommonTerminalsRule ) )
            // PsiInternalUnassignedTextTestLanguage.g:59:2: ( ruleCaseInsensitiveKeywordRule | rulePluralRule | ruleMultiRule | ruleDatatypeRule | ruleCommonTerminalsRule )
            {
            // PsiInternalUnassignedTextTestLanguage.g:59:2: ( ruleCaseInsensitiveKeywordRule | rulePluralRule | ruleMultiRule | ruleDatatypeRule | ruleCommonTerminalsRule )
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
                    // PsiInternalUnassignedTextTestLanguage.g:60:3: ruleCaseInsensitiveKeywordRule
                    {

                    			markComposite(elementTypeProvider.getModel_CaseInsensitiveKeywordRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCaseInsensitiveKeywordRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalUnassignedTextTestLanguage.g:68:3: rulePluralRule
                    {

                    			markComposite(elementTypeProvider.getModel_PluralRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePluralRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalUnassignedTextTestLanguage.g:76:3: ruleMultiRule
                    {

                    			markComposite(elementTypeProvider.getModel_MultiRuleParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleMultiRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalUnassignedTextTestLanguage.g:84:3: ruleDatatypeRule
                    {

                    			markComposite(elementTypeProvider.getModel_DatatypeRuleParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDatatypeRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalUnassignedTextTestLanguage.g:92:3: ruleCommonTerminalsRule
                    {

                    			markComposite(elementTypeProvider.getModel_CommonTerminalsRuleParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalUnassignedTextTestLanguage.g:103:1: entryRuleCaseInsensitiveKeywordRule : ruleCaseInsensitiveKeywordRule EOF ;
    public final void entryRuleCaseInsensitiveKeywordRule() throws RecognitionException {
        try {
            // PsiInternalUnassignedTextTestLanguage.g:103:36: ( ruleCaseInsensitiveKeywordRule EOF )
            // PsiInternalUnassignedTextTestLanguage.g:104:2: ruleCaseInsensitiveKeywordRule EOF
            {
             markComposite(elementTypeProvider.getCaseInsensitiveKeywordRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCaseInsensitiveKeywordRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalUnassignedTextTestLanguage.g:109:1: ruleCaseInsensitiveKeywordRule : (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final void ruleCaseInsensitiveKeywordRule() throws RecognitionException {
        Token this_CaseInsensitiveKeyword_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:109:31: ( (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) )
            // PsiInternalUnassignedTextTestLanguage.g:110:2: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            {
            // PsiInternalUnassignedTextTestLanguage.g:110:2: (this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            // PsiInternalUnassignedTextTestLanguage.g:111:3: this_CaseInsensitiveKeyword_0= RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) )
            {

            			markLeaf(elementTypeProvider.getCaseInsensitiveKeywordRule_CaseInsensitiveKeywordTerminalRuleCall_0ElementType());
            		
            this_CaseInsensitiveKeyword_0=(Token)match(input,RULE_CASEINSENSITIVEKEYWORD,FollowSets000.FOLLOW_3); 

            			doneLeaf(this_CaseInsensitiveKeyword_0);
            		
            // PsiInternalUnassignedTextTestLanguage.g:118:3: ( (lv_val_1_0= RULE_INT ) )
            // PsiInternalUnassignedTextTestLanguage.g:119:4: (lv_val_1_0= RULE_INT )
            {
            // PsiInternalUnassignedTextTestLanguage.g:119:4: (lv_val_1_0= RULE_INT )
            // PsiInternalUnassignedTextTestLanguage.g:120:5: lv_val_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getCaseInsensitiveKeywordRule_ValINTTerminalRuleCall_1_0ElementType());
            				
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleCaseInsensitiveKeywordRule"


    // $ANTLR start "entryRulePluralRule"
    // PsiInternalUnassignedTextTestLanguage.g:133:1: entryRulePluralRule : rulePluralRule EOF ;
    public final void entryRulePluralRule() throws RecognitionException {
        try {
            // PsiInternalUnassignedTextTestLanguage.g:133:20: ( rulePluralRule EOF )
            // PsiInternalUnassignedTextTestLanguage.g:134:2: rulePluralRule EOF
            {
             markComposite(elementTypeProvider.getPluralRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePluralRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalUnassignedTextTestLanguage.g:139:1: rulePluralRule : (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) ;
    public final void rulePluralRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_count_1_0=null;
        Token this_Plural_2=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:139:15: ( (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL ) )
            // PsiInternalUnassignedTextTestLanguage.g:140:2: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            {
            // PsiInternalUnassignedTextTestLanguage.g:140:2: (otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL )
            // PsiInternalUnassignedTextTestLanguage.g:141:3: otherlv_0= 'contents:' ( (lv_count_1_0= RULE_INT ) ) this_Plural_2= RULE_PLURAL
            {

            			markLeaf(elementTypeProvider.getPluralRule_ContentsKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalUnassignedTextTestLanguage.g:148:3: ( (lv_count_1_0= RULE_INT ) )
            // PsiInternalUnassignedTextTestLanguage.g:149:4: (lv_count_1_0= RULE_INT )
            {
            // PsiInternalUnassignedTextTestLanguage.g:149:4: (lv_count_1_0= RULE_INT )
            // PsiInternalUnassignedTextTestLanguage.g:150:5: lv_count_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getPluralRule_CountINTTerminalRuleCall_1_0ElementType());
            				
            lv_count_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 

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
        return ;
    }
    // $ANTLR end "rulePluralRule"


    // $ANTLR start "entryRuleMultiRule"
    // PsiInternalUnassignedTextTestLanguage.g:170:1: entryRuleMultiRule : ruleMultiRule EOF ;
    public final void entryRuleMultiRule() throws RecognitionException {
        try {
            // PsiInternalUnassignedTextTestLanguage.g:170:19: ( ruleMultiRule EOF )
            // PsiInternalUnassignedTextTestLanguage.g:171:2: ruleMultiRule EOF
            {
             markComposite(elementTypeProvider.getMultiRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMultiRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalUnassignedTextTestLanguage.g:176:1: ruleMultiRule : (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) ;
    public final void ruleMultiRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token this_Multi_2=null;
        Token this_Multi_3=null;
        Token this_Multi_4=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:176:14: ( (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI ) )
            // PsiInternalUnassignedTextTestLanguage.g:177:2: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            {
            // PsiInternalUnassignedTextTestLanguage.g:177:2: (otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI )
            // PsiInternalUnassignedTextTestLanguage.g:178:3: otherlv_0= 'multi' ( (lv_val_1_0= RULE_INT ) ) this_Multi_2= RULE_MULTI this_Multi_3= RULE_MULTI this_Multi_4= RULE_MULTI
            {

            			markLeaf(elementTypeProvider.getMultiRule_MultiKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalUnassignedTextTestLanguage.g:185:3: ( (lv_val_1_0= RULE_INT ) )
            // PsiInternalUnassignedTextTestLanguage.g:186:4: (lv_val_1_0= RULE_INT )
            {
            // PsiInternalUnassignedTextTestLanguage.g:186:4: (lv_val_1_0= RULE_INT )
            // PsiInternalUnassignedTextTestLanguage.g:187:5: lv_val_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMultiRule_ValINTTerminalRuleCall_1_0ElementType());
            				
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_5); 

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
        return ;
    }
    // $ANTLR end "ruleMultiRule"


    // $ANTLR start "entryRuleDatatypeRule"
    // PsiInternalUnassignedTextTestLanguage.g:221:1: entryRuleDatatypeRule : ruleDatatypeRule EOF ;
    public final void entryRuleDatatypeRule() throws RecognitionException {
        try {
            // PsiInternalUnassignedTextTestLanguage.g:221:22: ( ruleDatatypeRule EOF )
            // PsiInternalUnassignedTextTestLanguage.g:222:2: ruleDatatypeRule EOF
            {
             markComposite(elementTypeProvider.getDatatypeRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDatatypeRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalUnassignedTextTestLanguage.g:227:1: ruleDatatypeRule : (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) ;
    public final void ruleDatatypeRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:227:17: ( (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) )
            // PsiInternalUnassignedTextTestLanguage.g:228:2: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            {
            // PsiInternalUnassignedTextTestLanguage.g:228:2: (otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            // PsiInternalUnassignedTextTestLanguage.g:229:3: otherlv_0= 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype
            {

            			markLeaf(elementTypeProvider.getDatatypeRule_DatatypeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalUnassignedTextTestLanguage.g:236:3: ( (lv_val_1_0= RULE_INT ) )
            // PsiInternalUnassignedTextTestLanguage.g:237:4: (lv_val_1_0= RULE_INT )
            {
            // PsiInternalUnassignedTextTestLanguage.g:237:4: (lv_val_1_0= RULE_INT )
            // PsiInternalUnassignedTextTestLanguage.g:238:5: lv_val_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getDatatypeRule_ValINTTerminalRuleCall_1_0ElementType());
            				
            lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_6); 

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
        return ;
    }
    // $ANTLR end "ruleDatatypeRule"


    // $ANTLR start "entryRuleDatatype"
    // PsiInternalUnassignedTextTestLanguage.g:258:1: entryRuleDatatype : ruleDatatype EOF ;
    public final void entryRuleDatatype() throws RecognitionException {
        try {
            // PsiInternalUnassignedTextTestLanguage.g:258:18: ( ruleDatatype EOF )
            // PsiInternalUnassignedTextTestLanguage.g:259:2: ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDatatype();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalUnassignedTextTestLanguage.g:264:1: ruleDatatype : (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 ) ;
    public final void ruleDatatype() throws RecognitionException {
        Token kw=null;
        Token this_INT_1=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:264:13: ( (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 ) )
            // PsiInternalUnassignedTextTestLanguage.g:265:2: (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 )
            {
            // PsiInternalUnassignedTextTestLanguage.g:265:2: (kw= 'str' | this_INT_1= RULE_INT | ruleDatatype2 )
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
                    // PsiInternalUnassignedTextTestLanguage.g:266:3: kw= 'str'
                    {

                    			markLeaf(elementTypeProvider.getDatatype_StrKeyword_0ElementType());
                    		
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalUnassignedTextTestLanguage.g:274:3: this_INT_1= RULE_INT
                    {

                    			markLeaf(elementTypeProvider.getDatatype_INTTerminalRuleCall_1ElementType());
                    		
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    			doneLeaf(this_INT_1);
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalUnassignedTextTestLanguage.g:282:3: ruleDatatype2
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
        return ;
    }
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "entryRuleDatatype2"
    // PsiInternalUnassignedTextTestLanguage.g:293:1: entryRuleDatatype2 : ruleDatatype2 EOF ;
    public final void entryRuleDatatype2() throws RecognitionException {
        try {
            // PsiInternalUnassignedTextTestLanguage.g:293:19: ( ruleDatatype2 EOF )
            // PsiInternalUnassignedTextTestLanguage.g:294:2: ruleDatatype2 EOF
            {
             markComposite(elementTypeProvider.getDatatype2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDatatype2();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalUnassignedTextTestLanguage.g:299:1: ruleDatatype2 : this_STRING_0= RULE_STRING ;
    public final void ruleDatatype2() throws RecognitionException {
        Token this_STRING_0=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:299:14: (this_STRING_0= RULE_STRING )
            // PsiInternalUnassignedTextTestLanguage.g:300:2: this_STRING_0= RULE_STRING
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
        return ;
    }
    // $ANTLR end "ruleDatatype2"


    // $ANTLR start "entryRuleCommonTerminalsRule"
    // PsiInternalUnassignedTextTestLanguage.g:310:1: entryRuleCommonTerminalsRule : ruleCommonTerminalsRule EOF ;
    public final void entryRuleCommonTerminalsRule() throws RecognitionException {
        try {
            // PsiInternalUnassignedTextTestLanguage.g:310:29: ( ruleCommonTerminalsRule EOF )
            // PsiInternalUnassignedTextTestLanguage.g:311:2: ruleCommonTerminalsRule EOF
            {
             markComposite(elementTypeProvider.getCommonTerminalsRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCommonTerminalsRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalUnassignedTextTestLanguage.g:316:1: ruleCommonTerminalsRule : (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) ;
    public final void ruleCommonTerminalsRule() throws RecognitionException {
        Token otherlv_0=null;
        Token this_ID_1=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;
        Token lv_val_4_0=null;

        try {
            // PsiInternalUnassignedTextTestLanguage.g:316:24: ( (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) )
            // PsiInternalUnassignedTextTestLanguage.g:317:2: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            {
            // PsiInternalUnassignedTextTestLanguage.g:317:2: (otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            // PsiInternalUnassignedTextTestLanguage.g:318:3: otherlv_0= 'terminals' this_ID_1= RULE_ID this_INT_2= RULE_INT this_STRING_3= RULE_STRING ( (lv_val_4_0= RULE_ID ) )
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
            		
            // PsiInternalUnassignedTextTestLanguage.g:346:3: ( (lv_val_4_0= RULE_ID ) )
            // PsiInternalUnassignedTextTestLanguage.g:347:4: (lv_val_4_0= RULE_ID )
            {
            // PsiInternalUnassignedTextTestLanguage.g:347:4: (lv_val_4_0= RULE_ID )
            // PsiInternalUnassignedTextTestLanguage.g:348:5: lv_val_4_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getCommonTerminalsRule_ValIDTerminalRuleCall_4_0ElementType());
            				
            lv_val_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
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
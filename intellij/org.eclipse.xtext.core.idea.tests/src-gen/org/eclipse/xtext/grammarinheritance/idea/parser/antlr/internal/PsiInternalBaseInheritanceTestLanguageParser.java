package org.eclipse.xtext.grammarinheritance.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.grammarinheritance.idea.lang.BaseInheritanceTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.grammarinheritance.services.BaseInheritanceTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBaseInheritanceTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalBaseInheritanceTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBaseInheritanceTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBaseInheritanceTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBaseInheritanceTestLanguage.g"; }



    	protected BaseInheritanceTestLanguageGrammarAccess grammarAccess;

    	protected BaseInheritanceTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBaseInheritanceTestLanguageParser(PsiBuilder builder, TokenStream input, BaseInheritanceTestLanguageElementTypeProvider elementTypeProvider, BaseInheritanceTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalBaseInheritanceTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalBaseInheritanceTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalBaseInheritanceTestLanguage.g:53:2: ruleModel EOF
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
    // PsiInternalBaseInheritanceTestLanguage.g:58:1: ruleModel : (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalBaseInheritanceTestLanguage.g:58:10: ( (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalBaseInheritanceTestLanguage.g:59:2: (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalBaseInheritanceTestLanguage.g:59:2: (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalBaseInheritanceTestLanguage.g:60:3: otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getModel_ModelKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBaseInheritanceTestLanguage.g:67:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBaseInheritanceTestLanguage.g:68:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBaseInheritanceTestLanguage.g:68:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBaseInheritanceTestLanguage.g:69:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getModel_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_1_0);
            				

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
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    }


}
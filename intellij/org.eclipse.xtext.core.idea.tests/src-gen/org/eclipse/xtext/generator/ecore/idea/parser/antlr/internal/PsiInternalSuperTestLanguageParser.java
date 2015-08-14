package org.eclipse.xtext.generator.ecore.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.generator.ecore.services.SuperTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalSuperTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'super'"
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


        public PsiInternalSuperTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalSuperTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalSuperTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalSuperTestLanguage.g"; }



    	protected SuperTestLanguageGrammarAccess grammarAccess;

    	protected SuperTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalSuperTestLanguageParser(PsiBuilder builder, TokenStream input, SuperTestLanguageElementTypeProvider elementTypeProvider, SuperTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "SuperMain";
    	}




    // $ANTLR start "entryRuleSuperMain"
    // PsiInternalSuperTestLanguage.g:52:1: entryRuleSuperMain : ruleSuperMain EOF ;
    public final void entryRuleSuperMain() throws RecognitionException {
        try {
            // PsiInternalSuperTestLanguage.g:52:19: ( ruleSuperMain EOF )
            // PsiInternalSuperTestLanguage.g:53:2: ruleSuperMain EOF
            {
             markComposite(elementTypeProvider.getSuperMainElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSuperMain();

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
    // $ANTLR end "entryRuleSuperMain"


    // $ANTLR start "ruleSuperMain"
    // PsiInternalSuperTestLanguage.g:58:1: ruleSuperMain : (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleSuperMain() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalSuperTestLanguage.g:58:14: ( (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSuperTestLanguage.g:59:2: (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSuperTestLanguage.g:59:2: (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSuperTestLanguage.g:60:3: otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSuperMain_SuperKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSuperTestLanguage.g:67:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSuperTestLanguage.g:68:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSuperTestLanguage.g:68:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSuperTestLanguage.g:69:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSuperMain_NameIDTerminalRuleCall_1_0ElementType());
            				
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
    // $ANTLR end "ruleSuperMain"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    }


}
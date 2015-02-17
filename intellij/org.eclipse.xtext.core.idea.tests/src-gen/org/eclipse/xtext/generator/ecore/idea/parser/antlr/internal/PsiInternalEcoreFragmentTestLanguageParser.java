package org.eclipse.xtext.generator.ecore.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.generator.ecore.services.EcoreFragmentTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalEcoreFragmentTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'first'"
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


        public PsiInternalEcoreFragmentTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalEcoreFragmentTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalEcoreFragmentTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g"; }



    private EcoreFragmentTestLanguageGrammarAccess grammarAccess;

    private EcoreFragmentTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalEcoreFragmentTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, EcoreFragmentTestLanguageElementTypeProvider elementTypeProvider, EcoreFragmentTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Second";
    }




    // $ANTLR start "entryRuleSecond"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:49:1: entryRuleSecond : ruleSecond EOF ;
    public final void entryRuleSecond() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:49:16: ( ruleSecond EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:50:2: ruleSecond EOF
            {
             markComposite(elementTypeProvider.getSecondElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSecond_in_entryRuleSecond54);
            ruleSecond();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecond60); 

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
    // $ANTLR end "entryRuleSecond"


    // $ANTLR start "ruleSecond"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:58:1: ruleSecond : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'first' ( (otherlv_2= RULE_ID ) ) ) ;
    public final void ruleSecond() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:58:11: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'first' ( (otherlv_2= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:59:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'first' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:59:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'first' ( (otherlv_2= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:60:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'first' ( (otherlv_2= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:60:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:61:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:61:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:62:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSecond96); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getSecond_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSecond121); 

            			doneLeaf(otherlv_1, elementTypeProvider.getSecond_FirstKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:78:3: ( (otherlv_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:79:4: (otherlv_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:79:4: (otherlv_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/ecore/idea/parser/antlr/internal/PsiInternalEcoreFragmentTestLanguage.g:80:5: otherlv_2= RULE_ID
            {

            					markLeaf();
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSecond148); 

            					doneLeaf(otherlv_2, elementTypeProvider.getSecond_FirstFirstCrossReference_2_0ElementType());
            				

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
    // $ANTLR end "ruleSecond"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleSecond_in_entryRuleSecond54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecond60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSecond96 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleSecond121 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSecond148 = new BitSet(new long[]{0x0000000000000002L});
    }


}
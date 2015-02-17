package org.eclipse.xtext.metamodelreferencing.tests.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.metamodelreferencing.tests.services.MultiGenMMTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalMultiGenMMTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalMultiGenMMTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalMultiGenMMTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalMultiGenMMTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g"; }



    private MultiGenMMTestLanguageGrammarAccess grammarAccess;

    private MultiGenMMTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalMultiGenMMTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, MultiGenMMTestLanguageElementTypeProvider elementTypeProvider, MultiGenMMTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Foo";
    }




    // $ANTLR start "entryRuleFoo"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:49:1: entryRuleFoo : ruleFoo EOF ;
    public final void entryRuleFoo() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:49:13: ( ruleFoo EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:50:2: ruleFoo EOF
            {
             markComposite(elementTypeProvider.getFooElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFoo_in_entryRuleFoo54);
            ruleFoo();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoo60); 

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
    // $ANTLR end "entryRuleFoo"


    // $ANTLR start "ruleFoo"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:58:1: ruleFoo : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* ) ;
    public final void ruleFoo() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:58:8: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:59:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:59:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:60:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:60:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:61:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:61:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:62:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFoo96); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getFoo_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:71:3: ( (lv_nameRefs_1_0= ruleNameRef ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:72:4: (lv_nameRefs_1_0= ruleNameRef )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:72:4: (lv_nameRefs_1_0= ruleNameRef )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:73:5: lv_nameRefs_1_0= ruleNameRef
            	    {

            	    					markComposite(elementTypeProvider.getFoo_NameRefsNameRefParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleNameRef_in_ruleFoo134);
            	    ruleNameRef();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleFoo"


    // $ANTLR start "entryRuleNameRef"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:86:1: entryRuleNameRef : ruleNameRef EOF ;
    public final void entryRuleNameRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:86:17: ( ruleNameRef EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:87:2: ruleNameRef EOF
            {
             markComposite(elementTypeProvider.getNameRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNameRef_in_entryRuleNameRef166);
            ruleNameRef();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNameRef172); 

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
    // $ANTLR end "entryRuleNameRef"


    // $ANTLR start "ruleNameRef"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:95:1: ruleNameRef : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final void ruleNameRef() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:95:12: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:96:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:96:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:97:3: (lv_name_0_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:97:3: (lv_name_0_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMultiGenMMTestLanguage.g:98:4: lv_name_0_0= RULE_STRING
            {

            				markLeaf();
            			
            lv_name_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNameRef201); 

            				doneLeaf(lv_name_0_0, elementTypeProvider.getNameRef_NameSTRINGTerminalRuleCall_0ElementType());
            			

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
    // $ANTLR end "ruleNameRef"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoo60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFoo96 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleNameRef_in_ruleFoo134 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleNameRef_in_entryRuleNameRef166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNameRef172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNameRef201 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.metamodelreferencing.tests.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalMetamodelRefTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalMetamodelRefTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalMetamodelRefTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalMetamodelRefTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g"; }



    	protected MetamodelRefTestLanguageGrammarAccess grammarAccess;

    	protected MetamodelRefTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalMetamodelRefTestLanguageParser(PsiBuilder builder, TokenStream input, MetamodelRefTestLanguageElementTypeProvider elementTypeProvider, MetamodelRefTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Foo";
    	}




    // $ANTLR start "entryRuleFoo"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:50:1: entryRuleFoo : ruleFoo EOF ;
    public final void entryRuleFoo() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:50:13: ( ruleFoo EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:51:2: ruleFoo EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:59:1: ruleFoo : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* ) ;
    public final void ruleFoo() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:59:8: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:60:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:60:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:61:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:61:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:62:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:62:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:63:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFoo96); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getFoo_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:72:3: ( (lv_nameRefs_1_0= ruleNameRef ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:73:4: (lv_nameRefs_1_0= ruleNameRef )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:73:4: (lv_nameRefs_1_0= ruleNameRef )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:74:5: lv_nameRefs_1_0= ruleNameRef
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:87:1: entryRuleNameRef : ruleNameRef EOF ;
    public final void entryRuleNameRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:87:17: ( ruleNameRef EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:88:2: ruleNameRef EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:96:1: ruleNameRef : ( (otherlv_0= RULE_ID ) ) ;
    public final void ruleNameRef() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:96:12: ( ( (otherlv_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:97:2: ( (otherlv_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:97:2: ( (otherlv_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:98:3: (otherlv_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:98:3: (otherlv_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/idea/parser/antlr/internal/PsiInternalMetamodelRefTestLanguage.g:99:4: otherlv_0= RULE_ID
            {

            				markLeaf();
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNameRef201); 

            				doneLeaf(otherlv_0, elementTypeProvider.getNameRef_RuleParserRuleCrossReference_0ElementType());
            			

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
        public static final BitSet FOLLOW_RULE_ID_in_ruleFoo96 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNameRef_in_ruleFoo134 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNameRef_in_entryRuleNameRef166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNameRef172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNameRef201 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.metamodelreferencing.tests.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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
    public String getGrammarFileName() { return "PsiInternalMultiGenMMTestLanguage.g"; }



    	protected MultiGenMMTestLanguageGrammarAccess grammarAccess;

    	protected MultiGenMMTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalMultiGenMMTestLanguageParser(PsiBuilder builder, TokenStream input, MultiGenMMTestLanguageElementTypeProvider elementTypeProvider, MultiGenMMTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalMultiGenMMTestLanguage.g:52:1: entryRuleFoo : ruleFoo EOF ;
    public final void entryRuleFoo() throws RecognitionException {
        try {
            // PsiInternalMultiGenMMTestLanguage.g:52:13: ( ruleFoo EOF )
            // PsiInternalMultiGenMMTestLanguage.g:53:2: ruleFoo EOF
            {
             markComposite(elementTypeProvider.getFooElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFoo();

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
    // $ANTLR end "entryRuleFoo"


    // $ANTLR start "ruleFoo"
    // PsiInternalMultiGenMMTestLanguage.g:58:1: ruleFoo : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* ) ;
    public final void ruleFoo() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalMultiGenMMTestLanguage.g:58:8: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* ) )
            // PsiInternalMultiGenMMTestLanguage.g:59:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* )
            {
            // PsiInternalMultiGenMMTestLanguage.g:59:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* )
            // PsiInternalMultiGenMMTestLanguage.g:60:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )*
            {
            // PsiInternalMultiGenMMTestLanguage.g:60:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalMultiGenMMTestLanguage.g:61:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalMultiGenMMTestLanguage.g:61:4: (lv_name_0_0= RULE_ID )
            // PsiInternalMultiGenMMTestLanguage.g:62:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFoo_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalMultiGenMMTestLanguage.g:71:3: ( (lv_nameRefs_1_0= ruleNameRef ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalMultiGenMMTestLanguage.g:72:4: (lv_nameRefs_1_0= ruleNameRef )
            	    {
            	    // PsiInternalMultiGenMMTestLanguage.g:72:4: (lv_nameRefs_1_0= ruleNameRef )
            	    // PsiInternalMultiGenMMTestLanguage.g:73:5: lv_nameRefs_1_0= ruleNameRef
            	    {

            	    					markComposite(elementTypeProvider.getFoo_NameRefsNameRefParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
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
    // PsiInternalMultiGenMMTestLanguage.g:86:1: entryRuleNameRef : ruleNameRef EOF ;
    public final void entryRuleNameRef() throws RecognitionException {
        try {
            // PsiInternalMultiGenMMTestLanguage.g:86:17: ( ruleNameRef EOF )
            // PsiInternalMultiGenMMTestLanguage.g:87:2: ruleNameRef EOF
            {
             markComposite(elementTypeProvider.getNameRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNameRef();

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
    // $ANTLR end "entryRuleNameRef"


    // $ANTLR start "ruleNameRef"
    // PsiInternalMultiGenMMTestLanguage.g:92:1: ruleNameRef : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final void ruleNameRef() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalMultiGenMMTestLanguage.g:92:12: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // PsiInternalMultiGenMMTestLanguage.g:93:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // PsiInternalMultiGenMMTestLanguage.g:93:2: ( (lv_name_0_0= RULE_STRING ) )
            // PsiInternalMultiGenMMTestLanguage.g:94:3: (lv_name_0_0= RULE_STRING )
            {
            // PsiInternalMultiGenMMTestLanguage.g:94:3: (lv_name_0_0= RULE_STRING )
            // PsiInternalMultiGenMMTestLanguage.g:95:4: lv_name_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getNameRef_NameSTRINGTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_name_0_0);
            			

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000022L});
    }


}
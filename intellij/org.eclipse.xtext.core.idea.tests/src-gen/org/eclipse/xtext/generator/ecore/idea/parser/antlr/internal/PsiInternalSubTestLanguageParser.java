package org.eclipse.xtext.generator.ecore.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.generator.ecore.services.SubTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalSubTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'ups'", "'super'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalSubTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalSubTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalSubTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalSubTestLanguage.g"; }



    	protected SubTestLanguageGrammarAccess grammarAccess;

    	protected SubTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalSubTestLanguageParser(PsiBuilder builder, TokenStream input, SubTestLanguageElementTypeProvider elementTypeProvider, SubTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "SubMain";
    	}




    // $ANTLR start "entryRuleSubMain"
    // PsiInternalSubTestLanguage.g:52:1: entryRuleSubMain : ruleSubMain EOF ;
    public final void entryRuleSubMain() throws RecognitionException {
        try {
            // PsiInternalSubTestLanguage.g:52:17: ( ruleSubMain EOF )
            // PsiInternalSubTestLanguage.g:53:2: ruleSubMain EOF
            {
             markComposite(elementTypeProvider.getSubMainElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSubMain();

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
    // $ANTLR end "entryRuleSubMain"


    // $ANTLR start "ruleSubMain"
    // PsiInternalSubTestLanguage.g:58:1: ruleSubMain : (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? ) ;
    public final void ruleSubMain() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalSubTestLanguage.g:58:12: ( (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? ) )
            // PsiInternalSubTestLanguage.g:59:2: (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? )
            {
            // PsiInternalSubTestLanguage.g:59:2: (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? )
            // PsiInternalSubTestLanguage.g:60:3: otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )?
            {

            			markLeaf(elementTypeProvider.getSubMain_LeftCurlyBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSubTestLanguage.g:67:3: ( (lv_superMains_1_0= ruleSuperMain ) )
            // PsiInternalSubTestLanguage.g:68:4: (lv_superMains_1_0= ruleSuperMain )
            {
            // PsiInternalSubTestLanguage.g:68:4: (lv_superMains_1_0= ruleSuperMain )
            // PsiInternalSubTestLanguage.g:69:5: lv_superMains_1_0= ruleSuperMain
            {

            					markComposite(elementTypeProvider.getSubMain_SuperMainsSuperMainParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            ruleSuperMain();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getSubMain_RightCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSubTestLanguage.g:85:3: ( (lv_another_3_0= ruleAnotherSuperMain ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // PsiInternalSubTestLanguage.g:86:4: (lv_another_3_0= ruleAnotherSuperMain )
                    {
                    // PsiInternalSubTestLanguage.g:86:4: (lv_another_3_0= ruleAnotherSuperMain )
                    // PsiInternalSubTestLanguage.g:87:5: lv_another_3_0= ruleAnotherSuperMain
                    {

                    					markComposite(elementTypeProvider.getSubMain_AnotherAnotherSuperMainParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAnotherSuperMain();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleSubMain"


    // $ANTLR start "entryRuleAnotherSuperMain"
    // PsiInternalSubTestLanguage.g:100:1: entryRuleAnotherSuperMain : ruleAnotherSuperMain EOF ;
    public final void entryRuleAnotherSuperMain() throws RecognitionException {
        try {
            // PsiInternalSubTestLanguage.g:100:26: ( ruleAnotherSuperMain EOF )
            // PsiInternalSubTestLanguage.g:101:2: ruleAnotherSuperMain EOF
            {
             markComposite(elementTypeProvider.getAnotherSuperMainElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAnotherSuperMain();

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
    // $ANTLR end "entryRuleAnotherSuperMain"


    // $ANTLR start "ruleAnotherSuperMain"
    // PsiInternalSubTestLanguage.g:106:1: ruleAnotherSuperMain : (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleAnotherSuperMain() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalSubTestLanguage.g:106:21: ( (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSubTestLanguage.g:107:2: (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSubTestLanguage.g:107:2: (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSubTestLanguage.g:108:3: otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getAnotherSuperMain_UpsKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSubTestLanguage.g:115:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSubTestLanguage.g:116:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSubTestLanguage.g:116:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSubTestLanguage.g:117:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAnotherSuperMain_NameIDTerminalRuleCall_1_0ElementType());
            				
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
    // $ANTLR end "ruleAnotherSuperMain"


    // $ANTLR start "entryRuleSuperMain"
    // PsiInternalSubTestLanguage.g:130:1: entryRuleSuperMain : ruleSuperMain EOF ;
    public final void entryRuleSuperMain() throws RecognitionException {
        try {
            // PsiInternalSubTestLanguage.g:130:19: ( ruleSuperMain EOF )
            // PsiInternalSubTestLanguage.g:131:2: ruleSuperMain EOF
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
    // PsiInternalSubTestLanguage.g:136:1: ruleSuperMain : (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleSuperMain() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalSubTestLanguage.g:136:14: ( (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSubTestLanguage.g:137:2: (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSubTestLanguage.g:137:2: (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSubTestLanguage.g:138:3: otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSuperMain_SuperKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSubTestLanguage.g:145:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSubTestLanguage.g:146:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSubTestLanguage.g:146:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSubTestLanguage.g:147:5: lv_name_1_0= RULE_ID
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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    }


}
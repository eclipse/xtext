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
    // PsiInternalSubTestLanguage.g:52:1: entryRuleSubMain returns [Boolean current=false] : iv_ruleSubMain= ruleSubMain EOF ;
    public final Boolean entryRuleSubMain() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSubMain = null;


        try {
            // PsiInternalSubTestLanguage.g:52:49: (iv_ruleSubMain= ruleSubMain EOF )
            // PsiInternalSubTestLanguage.g:53:2: iv_ruleSubMain= ruleSubMain EOF
            {
             markComposite(elementTypeProvider.getSubMainElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSubMain=ruleSubMain();

            state._fsp--;

             current =iv_ruleSubMain; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubMain"


    // $ANTLR start "ruleSubMain"
    // PsiInternalSubTestLanguage.g:59:1: ruleSubMain returns [Boolean current=false] : (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? ) ;
    public final Boolean ruleSubMain() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean lv_superMains_1_0 = null;

        Boolean lv_another_3_0 = null;


        try {
            // PsiInternalSubTestLanguage.g:60:1: ( (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? ) )
            // PsiInternalSubTestLanguage.g:61:2: (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? )
            {
            // PsiInternalSubTestLanguage.g:61:2: (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? )
            // PsiInternalSubTestLanguage.g:62:3: otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )?
            {

            			markLeaf(elementTypeProvider.getSubMain_LeftCurlyBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSubTestLanguage.g:69:3: ( (lv_superMains_1_0= ruleSuperMain ) )
            // PsiInternalSubTestLanguage.g:70:4: (lv_superMains_1_0= ruleSuperMain )
            {
            // PsiInternalSubTestLanguage.g:70:4: (lv_superMains_1_0= ruleSuperMain )
            // PsiInternalSubTestLanguage.g:71:5: lv_superMains_1_0= ruleSuperMain
            {

            					markComposite(elementTypeProvider.getSubMain_SuperMainsSuperMainParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_superMains_1_0=ruleSuperMain();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getSubMain_RightCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSubTestLanguage.g:91:3: ( (lv_another_3_0= ruleAnotherSuperMain ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // PsiInternalSubTestLanguage.g:92:4: (lv_another_3_0= ruleAnotherSuperMain )
                    {
                    // PsiInternalSubTestLanguage.g:92:4: (lv_another_3_0= ruleAnotherSuperMain )
                    // PsiInternalSubTestLanguage.g:93:5: lv_another_3_0= ruleAnotherSuperMain
                    {

                    					markComposite(elementTypeProvider.getSubMain_AnotherAnotherSuperMainParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_another_3_0=ruleAnotherSuperMain();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

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
        return current;
    }
    // $ANTLR end "ruleSubMain"


    // $ANTLR start "entryRuleAnotherSuperMain"
    // PsiInternalSubTestLanguage.g:110:1: entryRuleAnotherSuperMain returns [Boolean current=false] : iv_ruleAnotherSuperMain= ruleAnotherSuperMain EOF ;
    public final Boolean entryRuleAnotherSuperMain() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAnotherSuperMain = null;


        try {
            // PsiInternalSubTestLanguage.g:110:58: (iv_ruleAnotherSuperMain= ruleAnotherSuperMain EOF )
            // PsiInternalSubTestLanguage.g:111:2: iv_ruleAnotherSuperMain= ruleAnotherSuperMain EOF
            {
             markComposite(elementTypeProvider.getAnotherSuperMainElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAnotherSuperMain=ruleAnotherSuperMain();

            state._fsp--;

             current =iv_ruleAnotherSuperMain; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnotherSuperMain"


    // $ANTLR start "ruleAnotherSuperMain"
    // PsiInternalSubTestLanguage.g:117:1: ruleAnotherSuperMain returns [Boolean current=false] : (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleAnotherSuperMain() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalSubTestLanguage.g:118:1: ( (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSubTestLanguage.g:119:2: (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSubTestLanguage.g:119:2: (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSubTestLanguage.g:120:3: otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getAnotherSuperMain_UpsKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSubTestLanguage.g:127:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSubTestLanguage.g:128:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSubTestLanguage.g:128:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSubTestLanguage.g:129:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAnotherSuperMain_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleAnotherSuperMain"


    // $ANTLR start "entryRuleSuperMain"
    // PsiInternalSubTestLanguage.g:148:1: entryRuleSuperMain returns [Boolean current=false] : iv_ruleSuperMain= ruleSuperMain EOF ;
    public final Boolean entryRuleSuperMain() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSuperMain = null;


        try {
            // PsiInternalSubTestLanguage.g:148:51: (iv_ruleSuperMain= ruleSuperMain EOF )
            // PsiInternalSubTestLanguage.g:149:2: iv_ruleSuperMain= ruleSuperMain EOF
            {
             markComposite(elementTypeProvider.getSuperMainElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSuperMain=ruleSuperMain();

            state._fsp--;

             current =iv_ruleSuperMain; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuperMain"


    // $ANTLR start "ruleSuperMain"
    // PsiInternalSubTestLanguage.g:155:1: ruleSuperMain returns [Boolean current=false] : (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleSuperMain() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalSubTestLanguage.g:156:1: ( (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSubTestLanguage.g:157:2: (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSubTestLanguage.g:157:2: (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSubTestLanguage.g:158:3: otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSuperMain_SuperKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSubTestLanguage.g:165:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSubTestLanguage.g:166:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSubTestLanguage.g:166:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSubTestLanguage.g:167:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSuperMain_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
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
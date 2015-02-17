package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalLookaheadTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'bar'", "'a'", "'foo'", "'b'", "'d'", "'c'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
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


        public PsiInternalLookaheadTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalLookaheadTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalLookaheadTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g"; }



    private LookaheadTestLanguageGrammarAccess grammarAccess;

    private LookaheadTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalLookaheadTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, LookaheadTestLanguageElementTypeProvider elementTypeProvider, LookaheadTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Entry";
    }




    // $ANTLR start "entryRuleEntry"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:49:1: entryRuleEntry : ruleEntry EOF ;
    public final void entryRuleEntry() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:49:15: ( ruleEntry EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:50:2: ruleEntry EOF
            {
             markComposite(elementTypeProvider.getEntryElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEntry_in_entryRuleEntry54);
            ruleEntry();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEntry60); 

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
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:58:1: ruleEntry : ( (lv_contents_0_0= ruleAlts ) )* ;
    public final void ruleEntry() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:58:10: ( ( (lv_contents_0_0= ruleAlts ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:59:2: ( (lv_contents_0_0= ruleAlts ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:59:2: ( (lv_contents_0_0= ruleAlts ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:60:3: (lv_contents_0_0= ruleAlts )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:60:3: (lv_contents_0_0= ruleAlts )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:61:4: lv_contents_0_0= ruleAlts
            	    {

            	    				markComposite(elementTypeProvider.getEntry_ContentsAltsParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleAlts_in_ruleEntry89);
            	    ruleAlts();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleAlts"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:73:1: entryRuleAlts : ruleAlts EOF ;
    public final void entryRuleAlts() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:73:14: ( ruleAlts EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:74:2: ruleAlts EOF
            {
             markComposite(elementTypeProvider.getAltsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlts_in_entryRuleAlts115);
            ruleAlts();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlts121); 

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
    // $ANTLR end "entryRuleAlts"


    // $ANTLR start "ruleAlts"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:82:1: ruleAlts : ( ruleLookAhead0 | ruleLookAhead1 | ruleLookAhead3 ) ;
    public final void ruleAlts() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:82:9: ( ( ruleLookAhead0 | ruleLookAhead1 | ruleLookAhead3 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:83:2: ( ruleLookAhead0 | ruleLookAhead1 | ruleLookAhead3 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:83:2: ( ruleLookAhead0 | ruleLookAhead1 | ruleLookAhead3 )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==11) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==16) ) {
                        alt2=2;
                    }
                    else if ( (LA2_3==14) ) {
                        alt2=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA2_2==13) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:84:3: ruleLookAhead0
                    {

                    			markComposite(elementTypeProvider.getAlts_LookAhead0ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLookAhead0_in_ruleAlts142);
                    ruleLookAhead0();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:92:3: ruleLookAhead1
                    {

                    			markComposite(elementTypeProvider.getAlts_LookAhead1ParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLookAhead1_in_ruleAlts162);
                    ruleLookAhead1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:100:3: ruleLookAhead3
                    {

                    			markComposite(elementTypeProvider.getAlts_LookAhead3ParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLookAhead3_in_ruleAlts182);
                    ruleLookAhead3();

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
    // $ANTLR end "ruleAlts"


    // $ANTLR start "entryRuleLookAhead0"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:111:1: entryRuleLookAhead0 : ruleLookAhead0 EOF ;
    public final void entryRuleLookAhead0() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:111:20: ( ruleLookAhead0 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:112:2: ruleLookAhead0 EOF
            {
             markComposite(elementTypeProvider.getLookAhead0ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0202);
            ruleLookAhead0();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead0208); 

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
    // $ANTLR end "entryRuleLookAhead0"


    // $ANTLR start "ruleLookAhead0"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:120:1: ruleLookAhead0 : (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) ) ;
    public final void ruleLookAhead0() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_x_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:120:15: ( (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:121:2: (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:121:2: (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:122:3: otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleLookAhead0231); 

            			doneLeaf(otherlv_0, elementTypeProvider.getLookAhead0_BarKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:129:3: ( (lv_x_1_0= 'a' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:130:4: (lv_x_1_0= 'a' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:130:4: (lv_x_1_0= 'a' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:131:5: lv_x_1_0= 'a'
            {

            					markLeaf();
            				
            lv_x_1_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLookAhead0258); 

            					doneLeaf(lv_x_1_0, elementTypeProvider.getLookAhead0_XAKeyword_1_0ElementType());
            				

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
    // $ANTLR end "ruleLookAhead0"


    // $ANTLR start "entryRuleLookAhead1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:144:1: entryRuleLookAhead1 : ruleLookAhead1 EOF ;
    public final void entryRuleLookAhead1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:144:20: ( ruleLookAhead1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:145:2: ruleLookAhead1 EOF
            {
             markComposite(elementTypeProvider.getLookAhead1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1289);
            ruleLookAhead1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead1295); 

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
    // $ANTLR end "entryRuleLookAhead1"


    // $ANTLR start "ruleLookAhead1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:153:1: ruleLookAhead1 : (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) ) ;
    public final void ruleLookAhead1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_x_2_0=null;
        Token lv_z_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:153:15: ( (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:154:2: (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:154:2: (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:155:3: otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLookAhead1318); 

            			doneLeaf(otherlv_0, elementTypeProvider.getLookAhead1_FooKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:162:3: ( (lv_y_1_0= ruleLookAhead2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:163:4: (lv_y_1_0= ruleLookAhead2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:163:4: (lv_y_1_0= ruleLookAhead2 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:164:5: lv_y_1_0= ruleLookAhead2
            {

            					markComposite(elementTypeProvider.getLookAhead1_YLookAhead2ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead2_in_ruleLookAhead1345);
            ruleLookAhead2();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:173:3: ( (lv_x_2_0= 'b' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:174:4: (lv_x_2_0= 'b' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:174:4: (lv_x_2_0= 'b' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:175:5: lv_x_2_0= 'b'
            {

            					markLeaf();
            				
            lv_x_2_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleLookAhead1383); 

            					doneLeaf(lv_x_2_0, elementTypeProvider.getLookAhead1_XBKeyword_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:184:3: ( (lv_z_3_0= 'd' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:185:4: (lv_z_3_0= 'd' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:185:4: (lv_z_3_0= 'd' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:186:5: lv_z_3_0= 'd'
            {

            					markLeaf();
            				
            lv_z_3_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleLookAhead1421); 

            					doneLeaf(lv_z_3_0, elementTypeProvider.getLookAhead1_ZDKeyword_3_0ElementType());
            				

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
    // $ANTLR end "ruleLookAhead1"


    // $ANTLR start "entryRuleLookAhead2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:199:1: entryRuleLookAhead2 : ruleLookAhead2 EOF ;
    public final void entryRuleLookAhead2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:199:20: ( ruleLookAhead2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:200:2: ruleLookAhead2 EOF
            {
             markComposite(elementTypeProvider.getLookAhead2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2452);
            ruleLookAhead2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead2458); 

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
    // $ANTLR end "entryRuleLookAhead2"


    // $ANTLR start "ruleLookAhead2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:208:1: ruleLookAhead2 : ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' ) ;
    public final void ruleLookAhead2() throws RecognitionException {
        Token lv_z_0_0=null;
        Token lv_z_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:208:15: ( ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:209:2: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:209:2: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:210:3: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:210:3: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==11) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:211:4: ( (lv_z_0_0= 'foo' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:211:4: ( (lv_z_0_0= 'foo' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:212:5: (lv_z_0_0= 'foo' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:212:5: (lv_z_0_0= 'foo' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:213:6: lv_z_0_0= 'foo'
                    {

                    						markLeaf();
                    					
                    lv_z_0_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLookAhead2502); 

                    						doneLeaf(lv_z_0_0, elementTypeProvider.getLookAhead2_ZFooKeyword_0_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:223:4: ( (lv_z_1_0= 'bar' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:223:4: ( (lv_z_1_0= 'bar' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:224:5: (lv_z_1_0= 'bar' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:224:5: (lv_z_1_0= 'bar' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:225:6: lv_z_1_0= 'bar'
                    {

                    						markLeaf();
                    					
                    lv_z_1_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleLookAhead2556); 

                    						doneLeaf(lv_z_1_0, elementTypeProvider.getLookAhead2_ZBarKeyword_0_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleLookAhead2588); 

            			doneLeaf(otherlv_2, elementTypeProvider.getLookAhead2_CKeyword_1ElementType());
            		

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
    // $ANTLR end "ruleLookAhead2"


    // $ANTLR start "entryRuleLookAhead3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:246:1: entryRuleLookAhead3 : ruleLookAhead3 EOF ;
    public final void entryRuleLookAhead3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:246:20: ( ruleLookAhead3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:247:2: ruleLookAhead3 EOF
            {
             markComposite(elementTypeProvider.getLookAhead3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3608);
            ruleLookAhead3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead3614); 

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
    // $ANTLR end "entryRuleLookAhead3"


    // $ANTLR start "ruleLookAhead3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:255:1: ruleLookAhead3 : (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) ;
    public final void ruleLookAhead3() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_x_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:255:15: ( (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:256:2: (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:256:2: (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:257:3: otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLookAhead3637); 

            			doneLeaf(otherlv_0, elementTypeProvider.getLookAhead3_FooKeyword_0ElementType());
            		

            			markLeaf();
            		
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleLookAhead3651); 

            			doneLeaf(otherlv_1, elementTypeProvider.getLookAhead3_BarKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:271:3: ( (lv_x_2_0= 'b' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:272:4: (lv_x_2_0= 'b' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:272:4: (lv_x_2_0= 'b' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:273:5: lv_x_2_0= 'b'
            {

            					markLeaf();
            				
            lv_x_2_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleLookAhead3678); 

            					doneLeaf(lv_x_2_0, elementTypeProvider.getLookAhead3_XBKeyword_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:282:3: ( (lv_z_3_0= ruleLookAhead4 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:283:4: (lv_z_3_0= ruleLookAhead4 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:283:4: (lv_z_3_0= ruleLookAhead4 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:284:5: lv_z_3_0= ruleLookAhead4
            {

            					markComposite(elementTypeProvider.getLookAhead3_ZLookAhead4ParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead4_in_ruleLookAhead3716);
            ruleLookAhead4();

            state._fsp--;


            					doneComposite();
            				

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
    // $ANTLR end "ruleLookAhead3"


    // $ANTLR start "entryRuleLookAhead4"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:297:1: entryRuleLookAhead4 : ruleLookAhead4 EOF ;
    public final void entryRuleLookAhead4() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:297:20: ( ruleLookAhead4 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:298:2: ruleLookAhead4 EOF
            {
             markComposite(elementTypeProvider.getLookAhead4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4747);
            ruleLookAhead4();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead4753); 

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
    // $ANTLR end "entryRuleLookAhead4"


    // $ANTLR start "ruleLookAhead4"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:306:1: ruleLookAhead4 : ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) ;
    public final void ruleLookAhead4() throws RecognitionException {
        Token lv_x_0_0=null;
        Token lv_x_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:306:15: ( ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:307:2: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:307:2: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:308:3: ( (lv_x_0_0= 'c' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:308:3: ( (lv_x_0_0= 'c' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:309:4: (lv_x_0_0= 'c' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:309:4: (lv_x_0_0= 'c' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:310:5: lv_x_0_0= 'c'
                    {

                    					markLeaf();
                    				
                    lv_x_0_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleLookAhead4789); 

                    					doneLeaf(lv_x_0_0, elementTypeProvider.getLookAhead4_XCKeyword_0_0ElementType());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:320:3: ( (lv_x_1_0= 'd' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:320:3: ( (lv_x_1_0= 'd' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:321:4: (lv_x_1_0= 'd' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:321:4: (lv_x_1_0= 'd' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:322:5: lv_x_1_0= 'd'
                    {

                    					markLeaf();
                    				
                    lv_x_1_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleLookAhead4835); 

                    					doneLeaf(lv_x_1_0, elementTypeProvider.getLookAhead4_XDKeyword_1_0ElementType());
                    				

                    }


                    }


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
    // $ANTLR end "ruleLookAhead4"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEntry_in_entryRuleEntry54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEntry60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlts_in_ruleEntry89 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_ruleAlts_in_entryRuleAlts115 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlts121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead0_in_ruleAlts142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead1_in_ruleAlts162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead3_in_ruleAlts182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0202 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead0208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleLookAhead0231 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLookAhead0258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1289 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead1295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleLookAhead1318 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_ruleLookAhead2_in_ruleLookAhead1345 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleLookAhead1383 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleLookAhead1421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2452 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead2458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleLookAhead2502 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_11_in_ruleLookAhead2556 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleLookAhead2588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3608 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead3614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleLookAhead3637 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleLookAhead3651 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleLookAhead3678 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_ruleLookAhead4_in_ruleLookAhead3716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4747 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead4753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleLookAhead4789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleLookAhead4835 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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



    	protected LookaheadTestLanguageGrammarAccess grammarAccess;

    	protected LookaheadTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalLookaheadTestLanguageParser(PsiBuilder builder, TokenStream input, LookaheadTestLanguageElementTypeProvider elementTypeProvider, LookaheadTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Entry";
    	}




    // $ANTLR start "entryRuleEntry"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:52:1: entryRuleEntry : ruleEntry EOF ;
    public final void entryRuleEntry() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:52:15: ( ruleEntry EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:53:2: ruleEntry EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:59:1: ruleEntry : ( (lv_contents_0_0= ruleAlts ) )* ;
    public final void ruleEntry() throws RecognitionException {


        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:62:2: ( ( (lv_contents_0_0= ruleAlts ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:63:2: ( (lv_contents_0_0= ruleAlts ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:63:2: ( (lv_contents_0_0= ruleAlts ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:64:3: (lv_contents_0_0= ruleAlts )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:64:3: (lv_contents_0_0= ruleAlts )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:65:4: lv_contents_0_0= ruleAlts
            	    {

            	    				markComposite(elementTypeProvider.getEntry_ContentsAltsParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleAlts_in_ruleEntry94);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:77:1: entryRuleAlts : ruleAlts EOF ;
    public final void entryRuleAlts() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:77:14: ( ruleAlts EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:78:2: ruleAlts EOF
            {
             markComposite(elementTypeProvider.getAltsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlts_in_entryRuleAlts120);
            ruleAlts();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlts126); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:84:1: ruleAlts : ( ruleLookAhead0 | ruleLookAhead1 | ruleLookAhead3 ) ;
    public final void ruleAlts() throws RecognitionException {


        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:87:2: ( ( ruleLookAhead0 | ruleLookAhead1 | ruleLookAhead3 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:88:2: ( ruleLookAhead0 | ruleLookAhead1 | ruleLookAhead3 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:88:2: ( ruleLookAhead0 | ruleLookAhead1 | ruleLookAhead3 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:89:3: ruleLookAhead0
                    {

                    			markComposite(elementTypeProvider.getAlts_LookAhead0ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLookAhead0_in_ruleAlts152);
                    ruleLookAhead0();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:97:3: ruleLookAhead1
                    {

                    			markComposite(elementTypeProvider.getAlts_LookAhead1ParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLookAhead1_in_ruleAlts172);
                    ruleLookAhead1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:105:3: ruleLookAhead3
                    {

                    			markComposite(elementTypeProvider.getAlts_LookAhead3ParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLookAhead3_in_ruleAlts192);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:116:1: entryRuleLookAhead0 : ruleLookAhead0 EOF ;
    public final void entryRuleLookAhead0() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:116:20: ( ruleLookAhead0 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:117:2: ruleLookAhead0 EOF
            {
             markComposite(elementTypeProvider.getLookAhead0ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0212);
            ruleLookAhead0();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead0218); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:123:1: ruleLookAhead0 : (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) ) ;
    public final void ruleLookAhead0() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_x_1_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:126:2: ( (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:127:2: (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:127:2: (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:128:3: otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleLookAhead0246); 

            			doneLeaf(otherlv_0, elementTypeProvider.getLookAhead0_BarKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:135:3: ( (lv_x_1_0= 'a' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:136:4: (lv_x_1_0= 'a' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:136:4: (lv_x_1_0= 'a' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:137:5: lv_x_1_0= 'a'
            {

            					markLeaf();
            				
            lv_x_1_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLookAhead0273); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:150:1: entryRuleLookAhead1 : ruleLookAhead1 EOF ;
    public final void entryRuleLookAhead1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:150:20: ( ruleLookAhead1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:151:2: ruleLookAhead1 EOF
            {
             markComposite(elementTypeProvider.getLookAhead1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1304);
            ruleLookAhead1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead1310); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:157:1: ruleLookAhead1 : (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) ) ;
    public final void ruleLookAhead1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_x_2_0=null;
        Token lv_z_3_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:160:2: ( (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:161:2: (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:161:2: (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:162:3: otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLookAhead1338); 

            			doneLeaf(otherlv_0, elementTypeProvider.getLookAhead1_FooKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:169:3: ( (lv_y_1_0= ruleLookAhead2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:170:4: (lv_y_1_0= ruleLookAhead2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:170:4: (lv_y_1_0= ruleLookAhead2 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:171:5: lv_y_1_0= ruleLookAhead2
            {

            					markComposite(elementTypeProvider.getLookAhead1_YLookAhead2ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead2_in_ruleLookAhead1365);
            ruleLookAhead2();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:180:3: ( (lv_x_2_0= 'b' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:181:4: (lv_x_2_0= 'b' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:181:4: (lv_x_2_0= 'b' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:182:5: lv_x_2_0= 'b'
            {

            					markLeaf();
            				
            lv_x_2_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleLookAhead1403); 

            					doneLeaf(lv_x_2_0, elementTypeProvider.getLookAhead1_XBKeyword_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:191:3: ( (lv_z_3_0= 'd' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:192:4: (lv_z_3_0= 'd' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:192:4: (lv_z_3_0= 'd' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:193:5: lv_z_3_0= 'd'
            {

            					markLeaf();
            				
            lv_z_3_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleLookAhead1441); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:206:1: entryRuleLookAhead2 : ruleLookAhead2 EOF ;
    public final void entryRuleLookAhead2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:206:20: ( ruleLookAhead2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:207:2: ruleLookAhead2 EOF
            {
             markComposite(elementTypeProvider.getLookAhead2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2472);
            ruleLookAhead2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead2478); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:213:1: ruleLookAhead2 : ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' ) ;
    public final void ruleLookAhead2() throws RecognitionException {
        Token lv_z_0_0=null;
        Token lv_z_1_0=null;
        Token otherlv_2=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:216:2: ( ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:217:2: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:217:2: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:218:3: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:218:3: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:219:4: ( (lv_z_0_0= 'foo' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:219:4: ( (lv_z_0_0= 'foo' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:220:5: (lv_z_0_0= 'foo' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:220:5: (lv_z_0_0= 'foo' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:221:6: lv_z_0_0= 'foo'
                    {

                    						markLeaf();
                    					
                    lv_z_0_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLookAhead2527); 

                    						doneLeaf(lv_z_0_0, elementTypeProvider.getLookAhead2_ZFooKeyword_0_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:231:4: ( (lv_z_1_0= 'bar' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:231:4: ( (lv_z_1_0= 'bar' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:232:5: (lv_z_1_0= 'bar' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:232:5: (lv_z_1_0= 'bar' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:233:6: lv_z_1_0= 'bar'
                    {

                    						markLeaf();
                    					
                    lv_z_1_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleLookAhead2581); 

                    						doneLeaf(lv_z_1_0, elementTypeProvider.getLookAhead2_ZBarKeyword_0_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleLookAhead2613); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:254:1: entryRuleLookAhead3 : ruleLookAhead3 EOF ;
    public final void entryRuleLookAhead3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:254:20: ( ruleLookAhead3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:255:2: ruleLookAhead3 EOF
            {
             markComposite(elementTypeProvider.getLookAhead3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3633);
            ruleLookAhead3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead3639); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:261:1: ruleLookAhead3 : (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) ;
    public final void ruleLookAhead3() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_x_2_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:264:2: ( (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:265:2: (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:265:2: (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:266:3: otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLookAhead3667); 

            			doneLeaf(otherlv_0, elementTypeProvider.getLookAhead3_FooKeyword_0ElementType());
            		

            			markLeaf();
            		
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleLookAhead3681); 

            			doneLeaf(otherlv_1, elementTypeProvider.getLookAhead3_BarKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:280:3: ( (lv_x_2_0= 'b' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:281:4: (lv_x_2_0= 'b' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:281:4: (lv_x_2_0= 'b' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:282:5: lv_x_2_0= 'b'
            {

            					markLeaf();
            				
            lv_x_2_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleLookAhead3708); 

            					doneLeaf(lv_x_2_0, elementTypeProvider.getLookAhead3_XBKeyword_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:291:3: ( (lv_z_3_0= ruleLookAhead4 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:292:4: (lv_z_3_0= ruleLookAhead4 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:292:4: (lv_z_3_0= ruleLookAhead4 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:293:5: lv_z_3_0= ruleLookAhead4
            {

            					markComposite(elementTypeProvider.getLookAhead3_ZLookAhead4ParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead4_in_ruleLookAhead3746);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:306:1: entryRuleLookAhead4 : ruleLookAhead4 EOF ;
    public final void entryRuleLookAhead4() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:306:20: ( ruleLookAhead4 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:307:2: ruleLookAhead4 EOF
            {
             markComposite(elementTypeProvider.getLookAhead4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4777);
            ruleLookAhead4();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLookAhead4783); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:313:1: ruleLookAhead4 : ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) ;
    public final void ruleLookAhead4() throws RecognitionException {
        Token lv_x_0_0=null;
        Token lv_x_1_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:316:2: ( ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:317:2: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:317:2: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:318:3: ( (lv_x_0_0= 'c' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:318:3: ( (lv_x_0_0= 'c' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:319:4: (lv_x_0_0= 'c' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:319:4: (lv_x_0_0= 'c' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:320:5: lv_x_0_0= 'c'
                    {

                    					markLeaf();
                    				
                    lv_x_0_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleLookAhead4824); 

                    					doneLeaf(lv_x_0_0, elementTypeProvider.getLookAhead4_XCKeyword_0_0ElementType());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:330:3: ( (lv_x_1_0= 'd' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:330:3: ( (lv_x_1_0= 'd' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:331:4: (lv_x_1_0= 'd' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:331:4: (lv_x_1_0= 'd' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalLookaheadTestLanguage.g:332:5: lv_x_1_0= 'd'
                    {

                    					markLeaf();
                    				
                    lv_x_1_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleLookAhead4870); 

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
        public static final BitSet FOLLOW_ruleAlts_in_ruleEntry94 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_ruleAlts_in_entryRuleAlts120 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlts126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead0_in_ruleAlts152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead1_in_ruleAlts172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead3_in_ruleAlts192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead0_in_entryRuleLookAhead0212 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead0218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleLookAhead0246 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLookAhead0273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead1_in_entryRuleLookAhead1304 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead1310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleLookAhead1338 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_ruleLookAhead2_in_ruleLookAhead1365 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleLookAhead1403 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleLookAhead1441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead2_in_entryRuleLookAhead2472 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead2478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleLookAhead2527 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_11_in_ruleLookAhead2581 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleLookAhead2613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead3_in_entryRuleLookAhead3633 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead3639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleLookAhead3667 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleLookAhead3681 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleLookAhead3708 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_ruleLookAhead4_in_ruleLookAhead3746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLookAhead4_in_entryRuleLookAhead4777 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLookAhead4783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleLookAhead4824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleLookAhead4870 = new BitSet(new long[]{0x0000000000000002L});
    }


}
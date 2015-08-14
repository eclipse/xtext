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
    public String getGrammarFileName() { return "PsiInternalLookaheadTestLanguage.g"; }



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
    // PsiInternalLookaheadTestLanguage.g:52:1: entryRuleEntry : ruleEntry EOF ;
    public final void entryRuleEntry() throws RecognitionException {
        try {
            // PsiInternalLookaheadTestLanguage.g:52:15: ( ruleEntry EOF )
            // PsiInternalLookaheadTestLanguage.g:53:2: ruleEntry EOF
            {
             markComposite(elementTypeProvider.getEntryElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEntry();

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
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // PsiInternalLookaheadTestLanguage.g:58:1: ruleEntry : ( (lv_contents_0_0= ruleAlts ) )* ;
    public final void ruleEntry() throws RecognitionException {
        try {
            // PsiInternalLookaheadTestLanguage.g:58:10: ( ( (lv_contents_0_0= ruleAlts ) )* )
            // PsiInternalLookaheadTestLanguage.g:59:2: ( (lv_contents_0_0= ruleAlts ) )*
            {
            // PsiInternalLookaheadTestLanguage.g:59:2: ( (lv_contents_0_0= ruleAlts ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalLookaheadTestLanguage.g:60:3: (lv_contents_0_0= ruleAlts )
            	    {
            	    // PsiInternalLookaheadTestLanguage.g:60:3: (lv_contents_0_0= ruleAlts )
            	    // PsiInternalLookaheadTestLanguage.g:61:4: lv_contents_0_0= ruleAlts
            	    {

            	    				markComposite(elementTypeProvider.getEntry_ContentsAltsParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
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
    // PsiInternalLookaheadTestLanguage.g:73:1: entryRuleAlts : ruleAlts EOF ;
    public final void entryRuleAlts() throws RecognitionException {
        try {
            // PsiInternalLookaheadTestLanguage.g:73:14: ( ruleAlts EOF )
            // PsiInternalLookaheadTestLanguage.g:74:2: ruleAlts EOF
            {
             markComposite(elementTypeProvider.getAltsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAlts();

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
    // $ANTLR end "entryRuleAlts"


    // $ANTLR start "ruleAlts"
    // PsiInternalLookaheadTestLanguage.g:79:1: ruleAlts : ( ruleLookAhead0 | ruleLookAhead1 | ruleLookAhead3 ) ;
    public final void ruleAlts() throws RecognitionException {
        try {
            // PsiInternalLookaheadTestLanguage.g:79:9: ( ( ruleLookAhead0 | ruleLookAhead1 | ruleLookAhead3 ) )
            // PsiInternalLookaheadTestLanguage.g:80:2: ( ruleLookAhead0 | ruleLookAhead1 | ruleLookAhead3 )
            {
            // PsiInternalLookaheadTestLanguage.g:80:2: ( ruleLookAhead0 | ruleLookAhead1 | ruleLookAhead3 )
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
                    // PsiInternalLookaheadTestLanguage.g:81:3: ruleLookAhead0
                    {

                    			markComposite(elementTypeProvider.getAlts_LookAhead0ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleLookAhead0();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalLookaheadTestLanguage.g:89:3: ruleLookAhead1
                    {

                    			markComposite(elementTypeProvider.getAlts_LookAhead1ParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleLookAhead1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalLookaheadTestLanguage.g:97:3: ruleLookAhead3
                    {

                    			markComposite(elementTypeProvider.getAlts_LookAhead3ParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalLookaheadTestLanguage.g:108:1: entryRuleLookAhead0 : ruleLookAhead0 EOF ;
    public final void entryRuleLookAhead0() throws RecognitionException {
        try {
            // PsiInternalLookaheadTestLanguage.g:108:20: ( ruleLookAhead0 EOF )
            // PsiInternalLookaheadTestLanguage.g:109:2: ruleLookAhead0 EOF
            {
             markComposite(elementTypeProvider.getLookAhead0ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLookAhead0();

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
    // $ANTLR end "entryRuleLookAhead0"


    // $ANTLR start "ruleLookAhead0"
    // PsiInternalLookaheadTestLanguage.g:114:1: ruleLookAhead0 : (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) ) ;
    public final void ruleLookAhead0() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_x_1_0=null;

        try {
            // PsiInternalLookaheadTestLanguage.g:114:15: ( (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) ) )
            // PsiInternalLookaheadTestLanguage.g:115:2: (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) )
            {
            // PsiInternalLookaheadTestLanguage.g:115:2: (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) )
            // PsiInternalLookaheadTestLanguage.g:116:3: otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) )
            {

            			markLeaf(elementTypeProvider.getLookAhead0_BarKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLookaheadTestLanguage.g:123:3: ( (lv_x_1_0= 'a' ) )
            // PsiInternalLookaheadTestLanguage.g:124:4: (lv_x_1_0= 'a' )
            {
            // PsiInternalLookaheadTestLanguage.g:124:4: (lv_x_1_0= 'a' )
            // PsiInternalLookaheadTestLanguage.g:125:5: lv_x_1_0= 'a'
            {

            					markLeaf(elementTypeProvider.getLookAhead0_XAKeyword_1_0ElementType());
            				
            lv_x_1_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_x_1_0);
            				

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
    // PsiInternalLookaheadTestLanguage.g:138:1: entryRuleLookAhead1 : ruleLookAhead1 EOF ;
    public final void entryRuleLookAhead1() throws RecognitionException {
        try {
            // PsiInternalLookaheadTestLanguage.g:138:20: ( ruleLookAhead1 EOF )
            // PsiInternalLookaheadTestLanguage.g:139:2: ruleLookAhead1 EOF
            {
             markComposite(elementTypeProvider.getLookAhead1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLookAhead1();

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
    // $ANTLR end "entryRuleLookAhead1"


    // $ANTLR start "ruleLookAhead1"
    // PsiInternalLookaheadTestLanguage.g:144:1: ruleLookAhead1 : (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) ) ;
    public final void ruleLookAhead1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_x_2_0=null;
        Token lv_z_3_0=null;

        try {
            // PsiInternalLookaheadTestLanguage.g:144:15: ( (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) ) )
            // PsiInternalLookaheadTestLanguage.g:145:2: (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) )
            {
            // PsiInternalLookaheadTestLanguage.g:145:2: (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) )
            // PsiInternalLookaheadTestLanguage.g:146:3: otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) )
            {

            			markLeaf(elementTypeProvider.getLookAhead1_FooKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLookaheadTestLanguage.g:153:3: ( (lv_y_1_0= ruleLookAhead2 ) )
            // PsiInternalLookaheadTestLanguage.g:154:4: (lv_y_1_0= ruleLookAhead2 )
            {
            // PsiInternalLookaheadTestLanguage.g:154:4: (lv_y_1_0= ruleLookAhead2 )
            // PsiInternalLookaheadTestLanguage.g:155:5: lv_y_1_0= ruleLookAhead2
            {

            					markComposite(elementTypeProvider.getLookAhead1_YLookAhead2ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_6);
            ruleLookAhead2();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalLookaheadTestLanguage.g:164:3: ( (lv_x_2_0= 'b' ) )
            // PsiInternalLookaheadTestLanguage.g:165:4: (lv_x_2_0= 'b' )
            {
            // PsiInternalLookaheadTestLanguage.g:165:4: (lv_x_2_0= 'b' )
            // PsiInternalLookaheadTestLanguage.g:166:5: lv_x_2_0= 'b'
            {

            					markLeaf(elementTypeProvider.getLookAhead1_XBKeyword_2_0ElementType());
            				
            lv_x_2_0=(Token)match(input,14,FollowSets000.FOLLOW_7); 

            					doneLeaf(lv_x_2_0);
            				

            }


            }

            // PsiInternalLookaheadTestLanguage.g:175:3: ( (lv_z_3_0= 'd' ) )
            // PsiInternalLookaheadTestLanguage.g:176:4: (lv_z_3_0= 'd' )
            {
            // PsiInternalLookaheadTestLanguage.g:176:4: (lv_z_3_0= 'd' )
            // PsiInternalLookaheadTestLanguage.g:177:5: lv_z_3_0= 'd'
            {

            					markLeaf(elementTypeProvider.getLookAhead1_ZDKeyword_3_0ElementType());
            				
            lv_z_3_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_z_3_0);
            				

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
    // PsiInternalLookaheadTestLanguage.g:190:1: entryRuleLookAhead2 : ruleLookAhead2 EOF ;
    public final void entryRuleLookAhead2() throws RecognitionException {
        try {
            // PsiInternalLookaheadTestLanguage.g:190:20: ( ruleLookAhead2 EOF )
            // PsiInternalLookaheadTestLanguage.g:191:2: ruleLookAhead2 EOF
            {
             markComposite(elementTypeProvider.getLookAhead2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLookAhead2();

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
    // $ANTLR end "entryRuleLookAhead2"


    // $ANTLR start "ruleLookAhead2"
    // PsiInternalLookaheadTestLanguage.g:196:1: ruleLookAhead2 : ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' ) ;
    public final void ruleLookAhead2() throws RecognitionException {
        Token lv_z_0_0=null;
        Token lv_z_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalLookaheadTestLanguage.g:196:15: ( ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' ) )
            // PsiInternalLookaheadTestLanguage.g:197:2: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' )
            {
            // PsiInternalLookaheadTestLanguage.g:197:2: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' )
            // PsiInternalLookaheadTestLanguage.g:198:3: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c'
            {
            // PsiInternalLookaheadTestLanguage.g:198:3: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) )
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
                    // PsiInternalLookaheadTestLanguage.g:199:4: ( (lv_z_0_0= 'foo' ) )
                    {
                    // PsiInternalLookaheadTestLanguage.g:199:4: ( (lv_z_0_0= 'foo' ) )
                    // PsiInternalLookaheadTestLanguage.g:200:5: (lv_z_0_0= 'foo' )
                    {
                    // PsiInternalLookaheadTestLanguage.g:200:5: (lv_z_0_0= 'foo' )
                    // PsiInternalLookaheadTestLanguage.g:201:6: lv_z_0_0= 'foo'
                    {

                    						markLeaf(elementTypeProvider.getLookAhead2_ZFooKeyword_0_0_0ElementType());
                    					
                    lv_z_0_0=(Token)match(input,13,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_z_0_0);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalLookaheadTestLanguage.g:211:4: ( (lv_z_1_0= 'bar' ) )
                    {
                    // PsiInternalLookaheadTestLanguage.g:211:4: ( (lv_z_1_0= 'bar' ) )
                    // PsiInternalLookaheadTestLanguage.g:212:5: (lv_z_1_0= 'bar' )
                    {
                    // PsiInternalLookaheadTestLanguage.g:212:5: (lv_z_1_0= 'bar' )
                    // PsiInternalLookaheadTestLanguage.g:213:6: lv_z_1_0= 'bar'
                    {

                    						markLeaf(elementTypeProvider.getLookAhead2_ZBarKeyword_0_1_0ElementType());
                    					
                    lv_z_1_0=(Token)match(input,11,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_z_1_0);
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getLookAhead2_CKeyword_1ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

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
    // PsiInternalLookaheadTestLanguage.g:234:1: entryRuleLookAhead3 : ruleLookAhead3 EOF ;
    public final void entryRuleLookAhead3() throws RecognitionException {
        try {
            // PsiInternalLookaheadTestLanguage.g:234:20: ( ruleLookAhead3 EOF )
            // PsiInternalLookaheadTestLanguage.g:235:2: ruleLookAhead3 EOF
            {
             markComposite(elementTypeProvider.getLookAhead3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLookAhead3();

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
    // $ANTLR end "entryRuleLookAhead3"


    // $ANTLR start "ruleLookAhead3"
    // PsiInternalLookaheadTestLanguage.g:240:1: ruleLookAhead3 : (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) ;
    public final void ruleLookAhead3() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_x_2_0=null;

        try {
            // PsiInternalLookaheadTestLanguage.g:240:15: ( (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) )
            // PsiInternalLookaheadTestLanguage.g:241:2: (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            {
            // PsiInternalLookaheadTestLanguage.g:241:2: (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            // PsiInternalLookaheadTestLanguage.g:242:3: otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) )
            {

            			markLeaf(elementTypeProvider.getLookAhead3_FooKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getLookAhead3_BarKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLookaheadTestLanguage.g:256:3: ( (lv_x_2_0= 'b' ) )
            // PsiInternalLookaheadTestLanguage.g:257:4: (lv_x_2_0= 'b' )
            {
            // PsiInternalLookaheadTestLanguage.g:257:4: (lv_x_2_0= 'b' )
            // PsiInternalLookaheadTestLanguage.g:258:5: lv_x_2_0= 'b'
            {

            					markLeaf(elementTypeProvider.getLookAhead3_XBKeyword_2_0ElementType());
            				
            lv_x_2_0=(Token)match(input,14,FollowSets000.FOLLOW_10); 

            					doneLeaf(lv_x_2_0);
            				

            }


            }

            // PsiInternalLookaheadTestLanguage.g:267:3: ( (lv_z_3_0= ruleLookAhead4 ) )
            // PsiInternalLookaheadTestLanguage.g:268:4: (lv_z_3_0= ruleLookAhead4 )
            {
            // PsiInternalLookaheadTestLanguage.g:268:4: (lv_z_3_0= ruleLookAhead4 )
            // PsiInternalLookaheadTestLanguage.g:269:5: lv_z_3_0= ruleLookAhead4
            {

            					markComposite(elementTypeProvider.getLookAhead3_ZLookAhead4ParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalLookaheadTestLanguage.g:282:1: entryRuleLookAhead4 : ruleLookAhead4 EOF ;
    public final void entryRuleLookAhead4() throws RecognitionException {
        try {
            // PsiInternalLookaheadTestLanguage.g:282:20: ( ruleLookAhead4 EOF )
            // PsiInternalLookaheadTestLanguage.g:283:2: ruleLookAhead4 EOF
            {
             markComposite(elementTypeProvider.getLookAhead4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLookAhead4();

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
    // $ANTLR end "entryRuleLookAhead4"


    // $ANTLR start "ruleLookAhead4"
    // PsiInternalLookaheadTestLanguage.g:288:1: ruleLookAhead4 : ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) ;
    public final void ruleLookAhead4() throws RecognitionException {
        Token lv_x_0_0=null;
        Token lv_x_1_0=null;

        try {
            // PsiInternalLookaheadTestLanguage.g:288:15: ( ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) )
            // PsiInternalLookaheadTestLanguage.g:289:2: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
            {
            // PsiInternalLookaheadTestLanguage.g:289:2: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
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
                    // PsiInternalLookaheadTestLanguage.g:290:3: ( (lv_x_0_0= 'c' ) )
                    {
                    // PsiInternalLookaheadTestLanguage.g:290:3: ( (lv_x_0_0= 'c' ) )
                    // PsiInternalLookaheadTestLanguage.g:291:4: (lv_x_0_0= 'c' )
                    {
                    // PsiInternalLookaheadTestLanguage.g:291:4: (lv_x_0_0= 'c' )
                    // PsiInternalLookaheadTestLanguage.g:292:5: lv_x_0_0= 'c'
                    {

                    					markLeaf(elementTypeProvider.getLookAhead4_XCKeyword_0_0ElementType());
                    				
                    lv_x_0_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_x_0_0);
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalLookaheadTestLanguage.g:302:3: ( (lv_x_1_0= 'd' ) )
                    {
                    // PsiInternalLookaheadTestLanguage.g:302:3: ( (lv_x_1_0= 'd' ) )
                    // PsiInternalLookaheadTestLanguage.g:303:4: (lv_x_1_0= 'd' )
                    {
                    // PsiInternalLookaheadTestLanguage.g:303:4: (lv_x_1_0= 'd' )
                    // PsiInternalLookaheadTestLanguage.g:304:5: lv_x_1_0= 'd'
                    {

                    					markLeaf(elementTypeProvider.getLookAhead4_XDKeyword_1_0ElementType());
                    				
                    lv_x_1_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_x_1_0);
                    				

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000018000L});
    }


}
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
    // PsiInternalLookaheadTestLanguage.g:52:1: entryRuleEntry returns [Boolean current=false] : iv_ruleEntry= ruleEntry EOF ;
    public final Boolean entryRuleEntry() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEntry = null;


        try {
            // PsiInternalLookaheadTestLanguage.g:52:47: (iv_ruleEntry= ruleEntry EOF )
            // PsiInternalLookaheadTestLanguage.g:53:2: iv_ruleEntry= ruleEntry EOF
            {
             markComposite(elementTypeProvider.getEntryElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEntry=ruleEntry();

            state._fsp--;

             current =iv_ruleEntry; 
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
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // PsiInternalLookaheadTestLanguage.g:59:1: ruleEntry returns [Boolean current=false] : ( (lv_contents_0_0= ruleAlts ) )* ;
    public final Boolean ruleEntry() throws RecognitionException {
        Boolean current = false;

        Boolean lv_contents_0_0 = null;


        try {
            // PsiInternalLookaheadTestLanguage.g:60:1: ( ( (lv_contents_0_0= ruleAlts ) )* )
            // PsiInternalLookaheadTestLanguage.g:61:2: ( (lv_contents_0_0= ruleAlts ) )*
            {
            // PsiInternalLookaheadTestLanguage.g:61:2: ( (lv_contents_0_0= ruleAlts ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalLookaheadTestLanguage.g:62:3: (lv_contents_0_0= ruleAlts )
            	    {
            	    // PsiInternalLookaheadTestLanguage.g:62:3: (lv_contents_0_0= ruleAlts )
            	    // PsiInternalLookaheadTestLanguage.g:63:4: lv_contents_0_0= ruleAlts
            	    {

            	    				markComposite(elementTypeProvider.getEntry_ContentsAltsParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_contents_0_0=ruleAlts();

            	    state._fsp--;


            	    				doneComposite();
            	    				if(!current) {
            	    					associateWithSemanticElement();
            	    					current = true;
            	    				}
            	    			

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
        return current;
    }
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleAlts"
    // PsiInternalLookaheadTestLanguage.g:79:1: entryRuleAlts returns [Boolean current=false] : iv_ruleAlts= ruleAlts EOF ;
    public final Boolean entryRuleAlts() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAlts = null;


        try {
            // PsiInternalLookaheadTestLanguage.g:79:46: (iv_ruleAlts= ruleAlts EOF )
            // PsiInternalLookaheadTestLanguage.g:80:2: iv_ruleAlts= ruleAlts EOF
            {
             markComposite(elementTypeProvider.getAltsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAlts=ruleAlts();

            state._fsp--;

             current =iv_ruleAlts; 
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
    // $ANTLR end "entryRuleAlts"


    // $ANTLR start "ruleAlts"
    // PsiInternalLookaheadTestLanguage.g:86:1: ruleAlts returns [Boolean current=false] : (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 ) ;
    public final Boolean ruleAlts() throws RecognitionException {
        Boolean current = false;

        Boolean this_LookAhead0_0 = null;

        Boolean this_LookAhead1_1 = null;

        Boolean this_LookAhead3_2 = null;


        try {
            // PsiInternalLookaheadTestLanguage.g:87:1: ( (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 ) )
            // PsiInternalLookaheadTestLanguage.g:88:2: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )
            {
            // PsiInternalLookaheadTestLanguage.g:88:2: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==13) ) {
                    alt2=2;
                }
                else if ( (LA2_2==11) ) {
                    int LA2_4 = input.LA(3);

                    if ( (LA2_4==14) ) {
                        alt2=3;
                    }
                    else if ( (LA2_4==16) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 4, input);

                        throw nvae;
                    }
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
                    // PsiInternalLookaheadTestLanguage.g:89:3: this_LookAhead0_0= ruleLookAhead0
                    {

                    			markComposite(elementTypeProvider.getAlts_LookAhead0ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LookAhead0_0=ruleLookAhead0();

                    state._fsp--;


                    			current = this_LookAhead0_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalLookaheadTestLanguage.g:98:3: this_LookAhead1_1= ruleLookAhead1
                    {

                    			markComposite(elementTypeProvider.getAlts_LookAhead1ParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LookAhead1_1=ruleLookAhead1();

                    state._fsp--;


                    			current = this_LookAhead1_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalLookaheadTestLanguage.g:107:3: this_LookAhead3_2= ruleLookAhead3
                    {

                    			markComposite(elementTypeProvider.getAlts_LookAhead3ParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LookAhead3_2=ruleLookAhead3();

                    state._fsp--;


                    			current = this_LookAhead3_2;
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
        return current;
    }
    // $ANTLR end "ruleAlts"


    // $ANTLR start "entryRuleLookAhead0"
    // PsiInternalLookaheadTestLanguage.g:119:1: entryRuleLookAhead0 returns [Boolean current=false] : iv_ruleLookAhead0= ruleLookAhead0 EOF ;
    public final Boolean entryRuleLookAhead0() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLookAhead0 = null;


        try {
            // PsiInternalLookaheadTestLanguage.g:119:52: (iv_ruleLookAhead0= ruleLookAhead0 EOF )
            // PsiInternalLookaheadTestLanguage.g:120:2: iv_ruleLookAhead0= ruleLookAhead0 EOF
            {
             markComposite(elementTypeProvider.getLookAhead0ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookAhead0=ruleLookAhead0();

            state._fsp--;

             current =iv_ruleLookAhead0; 
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
    // $ANTLR end "entryRuleLookAhead0"


    // $ANTLR start "ruleLookAhead0"
    // PsiInternalLookaheadTestLanguage.g:126:1: ruleLookAhead0 returns [Boolean current=false] : (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) ) ;
    public final Boolean ruleLookAhead0() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_x_1_0=null;

        try {
            // PsiInternalLookaheadTestLanguage.g:127:1: ( (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) ) )
            // PsiInternalLookaheadTestLanguage.g:128:2: (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) )
            {
            // PsiInternalLookaheadTestLanguage.g:128:2: (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) )
            // PsiInternalLookaheadTestLanguage.g:129:3: otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) )
            {

            			markLeaf(elementTypeProvider.getLookAhead0_BarKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLookaheadTestLanguage.g:136:3: ( (lv_x_1_0= 'a' ) )
            // PsiInternalLookaheadTestLanguage.g:137:4: (lv_x_1_0= 'a' )
            {
            // PsiInternalLookaheadTestLanguage.g:137:4: (lv_x_1_0= 'a' )
            // PsiInternalLookaheadTestLanguage.g:138:5: lv_x_1_0= 'a'
            {

            					markLeaf(elementTypeProvider.getLookAhead0_XAKeyword_1_0ElementType());
            				
            lv_x_1_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_x_1_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // $ANTLR end "ruleLookAhead0"


    // $ANTLR start "entryRuleLookAhead1"
    // PsiInternalLookaheadTestLanguage.g:157:1: entryRuleLookAhead1 returns [Boolean current=false] : iv_ruleLookAhead1= ruleLookAhead1 EOF ;
    public final Boolean entryRuleLookAhead1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLookAhead1 = null;


        try {
            // PsiInternalLookaheadTestLanguage.g:157:52: (iv_ruleLookAhead1= ruleLookAhead1 EOF )
            // PsiInternalLookaheadTestLanguage.g:158:2: iv_ruleLookAhead1= ruleLookAhead1 EOF
            {
             markComposite(elementTypeProvider.getLookAhead1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookAhead1=ruleLookAhead1();

            state._fsp--;

             current =iv_ruleLookAhead1; 
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
    // $ANTLR end "entryRuleLookAhead1"


    // $ANTLR start "ruleLookAhead1"
    // PsiInternalLookaheadTestLanguage.g:164:1: ruleLookAhead1 returns [Boolean current=false] : (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) ) ;
    public final Boolean ruleLookAhead1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_x_2_0=null;
        Token lv_z_3_0=null;
        Boolean lv_y_1_0 = null;


        try {
            // PsiInternalLookaheadTestLanguage.g:165:1: ( (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) ) )
            // PsiInternalLookaheadTestLanguage.g:166:2: (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) )
            {
            // PsiInternalLookaheadTestLanguage.g:166:2: (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) )
            // PsiInternalLookaheadTestLanguage.g:167:3: otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) )
            {

            			markLeaf(elementTypeProvider.getLookAhead1_FooKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLookaheadTestLanguage.g:174:3: ( (lv_y_1_0= ruleLookAhead2 ) )
            // PsiInternalLookaheadTestLanguage.g:175:4: (lv_y_1_0= ruleLookAhead2 )
            {
            // PsiInternalLookaheadTestLanguage.g:175:4: (lv_y_1_0= ruleLookAhead2 )
            // PsiInternalLookaheadTestLanguage.g:176:5: lv_y_1_0= ruleLookAhead2
            {

            					markComposite(elementTypeProvider.getLookAhead1_YLookAhead2ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_6);
            lv_y_1_0=ruleLookAhead2();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalLookaheadTestLanguage.g:189:3: ( (lv_x_2_0= 'b' ) )
            // PsiInternalLookaheadTestLanguage.g:190:4: (lv_x_2_0= 'b' )
            {
            // PsiInternalLookaheadTestLanguage.g:190:4: (lv_x_2_0= 'b' )
            // PsiInternalLookaheadTestLanguage.g:191:5: lv_x_2_0= 'b'
            {

            					markLeaf(elementTypeProvider.getLookAhead1_XBKeyword_2_0ElementType());
            				
            lv_x_2_0=(Token)match(input,14,FollowSets000.FOLLOW_7); 

            					doneLeaf(lv_x_2_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalLookaheadTestLanguage.g:206:3: ( (lv_z_3_0= 'd' ) )
            // PsiInternalLookaheadTestLanguage.g:207:4: (lv_z_3_0= 'd' )
            {
            // PsiInternalLookaheadTestLanguage.g:207:4: (lv_z_3_0= 'd' )
            // PsiInternalLookaheadTestLanguage.g:208:5: lv_z_3_0= 'd'
            {

            					markLeaf(elementTypeProvider.getLookAhead1_ZDKeyword_3_0ElementType());
            				
            lv_z_3_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_z_3_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // $ANTLR end "ruleLookAhead1"


    // $ANTLR start "entryRuleLookAhead2"
    // PsiInternalLookaheadTestLanguage.g:227:1: entryRuleLookAhead2 returns [Boolean current=false] : iv_ruleLookAhead2= ruleLookAhead2 EOF ;
    public final Boolean entryRuleLookAhead2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLookAhead2 = null;


        try {
            // PsiInternalLookaheadTestLanguage.g:227:52: (iv_ruleLookAhead2= ruleLookAhead2 EOF )
            // PsiInternalLookaheadTestLanguage.g:228:2: iv_ruleLookAhead2= ruleLookAhead2 EOF
            {
             markComposite(elementTypeProvider.getLookAhead2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookAhead2=ruleLookAhead2();

            state._fsp--;

             current =iv_ruleLookAhead2; 
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
    // $ANTLR end "entryRuleLookAhead2"


    // $ANTLR start "ruleLookAhead2"
    // PsiInternalLookaheadTestLanguage.g:234:1: ruleLookAhead2 returns [Boolean current=false] : ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' ) ;
    public final Boolean ruleLookAhead2() throws RecognitionException {
        Boolean current = false;

        Token lv_z_0_0=null;
        Token lv_z_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalLookaheadTestLanguage.g:235:1: ( ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' ) )
            // PsiInternalLookaheadTestLanguage.g:236:2: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' )
            {
            // PsiInternalLookaheadTestLanguage.g:236:2: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' )
            // PsiInternalLookaheadTestLanguage.g:237:3: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c'
            {
            // PsiInternalLookaheadTestLanguage.g:237:3: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) )
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
                    // PsiInternalLookaheadTestLanguage.g:238:4: ( (lv_z_0_0= 'foo' ) )
                    {
                    // PsiInternalLookaheadTestLanguage.g:238:4: ( (lv_z_0_0= 'foo' ) )
                    // PsiInternalLookaheadTestLanguage.g:239:5: (lv_z_0_0= 'foo' )
                    {
                    // PsiInternalLookaheadTestLanguage.g:239:5: (lv_z_0_0= 'foo' )
                    // PsiInternalLookaheadTestLanguage.g:240:6: lv_z_0_0= 'foo'
                    {

                    						markLeaf(elementTypeProvider.getLookAhead2_ZFooKeyword_0_0_0ElementType());
                    					
                    lv_z_0_0=(Token)match(input,13,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_z_0_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalLookaheadTestLanguage.g:256:4: ( (lv_z_1_0= 'bar' ) )
                    {
                    // PsiInternalLookaheadTestLanguage.g:256:4: ( (lv_z_1_0= 'bar' ) )
                    // PsiInternalLookaheadTestLanguage.g:257:5: (lv_z_1_0= 'bar' )
                    {
                    // PsiInternalLookaheadTestLanguage.g:257:5: (lv_z_1_0= 'bar' )
                    // PsiInternalLookaheadTestLanguage.g:258:6: lv_z_1_0= 'bar'
                    {

                    						markLeaf(elementTypeProvider.getLookAhead2_ZBarKeyword_0_1_0ElementType());
                    					
                    lv_z_1_0=(Token)match(input,11,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_z_1_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
        return current;
    }
    // $ANTLR end "ruleLookAhead2"


    // $ANTLR start "entryRuleLookAhead3"
    // PsiInternalLookaheadTestLanguage.g:285:1: entryRuleLookAhead3 returns [Boolean current=false] : iv_ruleLookAhead3= ruleLookAhead3 EOF ;
    public final Boolean entryRuleLookAhead3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLookAhead3 = null;


        try {
            // PsiInternalLookaheadTestLanguage.g:285:52: (iv_ruleLookAhead3= ruleLookAhead3 EOF )
            // PsiInternalLookaheadTestLanguage.g:286:2: iv_ruleLookAhead3= ruleLookAhead3 EOF
            {
             markComposite(elementTypeProvider.getLookAhead3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookAhead3=ruleLookAhead3();

            state._fsp--;

             current =iv_ruleLookAhead3; 
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
    // $ANTLR end "entryRuleLookAhead3"


    // $ANTLR start "ruleLookAhead3"
    // PsiInternalLookaheadTestLanguage.g:292:1: ruleLookAhead3 returns [Boolean current=false] : (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) ;
    public final Boolean ruleLookAhead3() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_x_2_0=null;
        Boolean lv_z_3_0 = null;


        try {
            // PsiInternalLookaheadTestLanguage.g:293:1: ( (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) )
            // PsiInternalLookaheadTestLanguage.g:294:2: (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            {
            // PsiInternalLookaheadTestLanguage.g:294:2: (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            // PsiInternalLookaheadTestLanguage.g:295:3: otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) )
            {

            			markLeaf(elementTypeProvider.getLookAhead3_FooKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getLookAhead3_BarKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLookaheadTestLanguage.g:309:3: ( (lv_x_2_0= 'b' ) )
            // PsiInternalLookaheadTestLanguage.g:310:4: (lv_x_2_0= 'b' )
            {
            // PsiInternalLookaheadTestLanguage.g:310:4: (lv_x_2_0= 'b' )
            // PsiInternalLookaheadTestLanguage.g:311:5: lv_x_2_0= 'b'
            {

            					markLeaf(elementTypeProvider.getLookAhead3_XBKeyword_2_0ElementType());
            				
            lv_x_2_0=(Token)match(input,14,FollowSets000.FOLLOW_10); 

            					doneLeaf(lv_x_2_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalLookaheadTestLanguage.g:326:3: ( (lv_z_3_0= ruleLookAhead4 ) )
            // PsiInternalLookaheadTestLanguage.g:327:4: (lv_z_3_0= ruleLookAhead4 )
            {
            // PsiInternalLookaheadTestLanguage.g:327:4: (lv_z_3_0= ruleLookAhead4 )
            // PsiInternalLookaheadTestLanguage.g:328:5: lv_z_3_0= ruleLookAhead4
            {

            					markComposite(elementTypeProvider.getLookAhead3_ZLookAhead4ParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_z_3_0=ruleLookAhead4();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // $ANTLR end "ruleLookAhead3"


    // $ANTLR start "entryRuleLookAhead4"
    // PsiInternalLookaheadTestLanguage.g:345:1: entryRuleLookAhead4 returns [Boolean current=false] : iv_ruleLookAhead4= ruleLookAhead4 EOF ;
    public final Boolean entryRuleLookAhead4() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLookAhead4 = null;


        try {
            // PsiInternalLookaheadTestLanguage.g:345:52: (iv_ruleLookAhead4= ruleLookAhead4 EOF )
            // PsiInternalLookaheadTestLanguage.g:346:2: iv_ruleLookAhead4= ruleLookAhead4 EOF
            {
             markComposite(elementTypeProvider.getLookAhead4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookAhead4=ruleLookAhead4();

            state._fsp--;

             current =iv_ruleLookAhead4; 
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
    // $ANTLR end "entryRuleLookAhead4"


    // $ANTLR start "ruleLookAhead4"
    // PsiInternalLookaheadTestLanguage.g:352:1: ruleLookAhead4 returns [Boolean current=false] : ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) ;
    public final Boolean ruleLookAhead4() throws RecognitionException {
        Boolean current = false;

        Token lv_x_0_0=null;
        Token lv_x_1_0=null;

        try {
            // PsiInternalLookaheadTestLanguage.g:353:1: ( ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) )
            // PsiInternalLookaheadTestLanguage.g:354:2: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
            {
            // PsiInternalLookaheadTestLanguage.g:354:2: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
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
                    // PsiInternalLookaheadTestLanguage.g:355:3: ( (lv_x_0_0= 'c' ) )
                    {
                    // PsiInternalLookaheadTestLanguage.g:355:3: ( (lv_x_0_0= 'c' ) )
                    // PsiInternalLookaheadTestLanguage.g:356:4: (lv_x_0_0= 'c' )
                    {
                    // PsiInternalLookaheadTestLanguage.g:356:4: (lv_x_0_0= 'c' )
                    // PsiInternalLookaheadTestLanguage.g:357:5: lv_x_0_0= 'c'
                    {

                    					markLeaf(elementTypeProvider.getLookAhead4_XCKeyword_0_0ElementType());
                    				
                    lv_x_0_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_x_0_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalLookaheadTestLanguage.g:373:3: ( (lv_x_1_0= 'd' ) )
                    {
                    // PsiInternalLookaheadTestLanguage.g:373:3: ( (lv_x_1_0= 'd' ) )
                    // PsiInternalLookaheadTestLanguage.g:374:4: (lv_x_1_0= 'd' )
                    {
                    // PsiInternalLookaheadTestLanguage.g:374:4: (lv_x_1_0= 'd' )
                    // PsiInternalLookaheadTestLanguage.g:375:5: lv_x_1_0= 'd'
                    {

                    					markLeaf(elementTypeProvider.getLookAhead4_XDKeyword_1_0ElementType());
                    				
                    lv_x_1_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_x_1_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

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
        return current;
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
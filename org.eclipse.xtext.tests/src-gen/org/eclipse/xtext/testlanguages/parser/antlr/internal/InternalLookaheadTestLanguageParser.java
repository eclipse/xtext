package org.eclipse.xtext.testlanguages.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalLookaheadTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'bar'", "'a'", "'foo'", "'b'", "'d'", "'c'", "'zonk'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalLookaheadTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLookaheadTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLookaheadTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLookaheadTestLanguage.g"; }



     	private LookaheadTestLanguageGrammarAccess grammarAccess;

        public InternalLookaheadTestLanguageParser(TokenStream input, LookaheadTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Entry";
       	}

       	@Override
       	protected LookaheadTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleEntry"
    // InternalLookaheadTestLanguage.g:69:1: entryRuleEntry returns [EObject current=null] : iv_ruleEntry= ruleEntry EOF ;
    public final EObject entryRuleEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntry = null;


        try {
            // InternalLookaheadTestLanguage.g:69:46: (iv_ruleEntry= ruleEntry EOF )
            // InternalLookaheadTestLanguage.g:70:2: iv_ruleEntry= ruleEntry EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntryRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEntry=ruleEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntry; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // InternalLookaheadTestLanguage.g:76:1: ruleEntry returns [EObject current=null] : ( (lv_contents_0_0= ruleAlts ) )* ;
    public final EObject ruleEntry() throws RecognitionException {
        EObject current = null;

        EObject lv_contents_0_0 = null;



        	enterRule();

        try {
            // InternalLookaheadTestLanguage.g:82:2: ( ( (lv_contents_0_0= ruleAlts ) )* )
            // InternalLookaheadTestLanguage.g:83:2: ( (lv_contents_0_0= ruleAlts ) )*
            {
            // InternalLookaheadTestLanguage.g:83:2: ( (lv_contents_0_0= ruleAlts ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING||LA1_0==11||LA1_0==13||LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLookaheadTestLanguage.g:84:3: (lv_contents_0_0= ruleAlts )
            	    {
            	    // InternalLookaheadTestLanguage.g:84:3: (lv_contents_0_0= ruleAlts )
            	    // InternalLookaheadTestLanguage.g:85:4: lv_contents_0_0= ruleAlts
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getEntryAccess().getContentsAltsParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_contents_0_0=ruleAlts();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getEntryRule());
            	      				}
            	      				add(
            	      					current,
            	      					"contents",
            	      					lv_contents_0_0,
            	      					"org.eclipse.xtext.testlanguages.LookaheadTestLanguage.Alts");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleAlts"
    // InternalLookaheadTestLanguage.g:105:1: entryRuleAlts returns [EObject current=null] : iv_ruleAlts= ruleAlts EOF ;
    public final EObject entryRuleAlts() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlts = null;


        try {
            // InternalLookaheadTestLanguage.g:105:45: (iv_ruleAlts= ruleAlts EOF )
            // InternalLookaheadTestLanguage.g:106:2: iv_ruleAlts= ruleAlts EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAltsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAlts=ruleAlts();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlts; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlts"


    // $ANTLR start "ruleAlts"
    // InternalLookaheadTestLanguage.g:112:1: ruleAlts returns [EObject current=null] : (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 | ( ( ( () 'zonk' 'a' 'b' ) )=>this_LookAheadPredicate_3= ruleLookAheadPredicate ) | this_LookBeyond_4= ruleLookBeyond ) ;
    public final EObject ruleAlts() throws RecognitionException {
        EObject current = null;

        EObject this_LookAhead0_0 = null;

        EObject this_LookAhead1_1 = null;

        EObject this_LookAhead3_2 = null;

        EObject this_LookAheadPredicate_3 = null;

        EObject this_LookBeyond_4 = null;



        	enterRule();

        try {
            // InternalLookaheadTestLanguage.g:118:2: ( (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 | ( ( ( () 'zonk' 'a' 'b' ) )=>this_LookAheadPredicate_3= ruleLookAheadPredicate ) | this_LookBeyond_4= ruleLookBeyond ) )
            // InternalLookaheadTestLanguage.g:119:2: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 | ( ( ( () 'zonk' 'a' 'b' ) )=>this_LookAheadPredicate_3= ruleLookAheadPredicate ) | this_LookBeyond_4= ruleLookBeyond )
            {
            // InternalLookaheadTestLanguage.g:119:2: (this_LookAhead0_0= ruleLookAhead0 | this_LookAhead1_1= ruleLookAhead1 | this_LookAhead3_2= ruleLookAhead3 | ( ( ( () 'zonk' 'a' 'b' ) )=>this_LookAheadPredicate_3= ruleLookAheadPredicate ) | this_LookBeyond_4= ruleLookBeyond )
            int alt2=5;
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
                    int LA2_6 = input.LA(3);

                    if ( (LA2_6==16) ) {
                        alt2=2;
                    }
                    else if ( (LA2_6==14) ) {
                        alt2=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==17) && (synpred1_InternalLookaheadTestLanguage())) {
                alt2=4;
            }
            else if ( (LA2_0==RULE_STRING) ) {
                alt2=5;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalLookaheadTestLanguage.g:120:3: this_LookAhead0_0= ruleLookAhead0
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAltsAccess().getLookAhead0ParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LookAhead0_0=ruleLookAhead0();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LookAhead0_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalLookaheadTestLanguage.g:129:3: this_LookAhead1_1= ruleLookAhead1
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAltsAccess().getLookAhead1ParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LookAhead1_1=ruleLookAhead1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LookAhead1_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalLookaheadTestLanguage.g:138:3: this_LookAhead3_2= ruleLookAhead3
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAltsAccess().getLookAhead3ParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LookAhead3_2=ruleLookAhead3();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LookAhead3_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalLookaheadTestLanguage.g:147:3: ( ( ( () 'zonk' 'a' 'b' ) )=>this_LookAheadPredicate_3= ruleLookAheadPredicate )
                    {
                    // InternalLookaheadTestLanguage.g:147:3: ( ( ( () 'zonk' 'a' 'b' ) )=>this_LookAheadPredicate_3= ruleLookAheadPredicate )
                    // InternalLookaheadTestLanguage.g:148:4: ( ( () 'zonk' 'a' 'b' ) )=>this_LookAheadPredicate_3= ruleLookAheadPredicate
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAltsAccess().getLookAheadPredicateParserRuleCall_3());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LookAheadPredicate_3=ruleLookAheadPredicate();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_LookAheadPredicate_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalLookaheadTestLanguage.g:166:3: this_LookBeyond_4= ruleLookBeyond
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAltsAccess().getLookBeyondParserRuleCall_4());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LookBeyond_4=ruleLookBeyond();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LookBeyond_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlts"


    // $ANTLR start "entryRuleLookAhead0"
    // InternalLookaheadTestLanguage.g:178:1: entryRuleLookAhead0 returns [EObject current=null] : iv_ruleLookAhead0= ruleLookAhead0 EOF ;
    public final EObject entryRuleLookAhead0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead0 = null;


        try {
            // InternalLookaheadTestLanguage.g:178:51: (iv_ruleLookAhead0= ruleLookAhead0 EOF )
            // InternalLookaheadTestLanguage.g:179:2: iv_ruleLookAhead0= ruleLookAhead0 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLookAhead0Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookAhead0=ruleLookAhead0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLookAhead0; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLookAhead0"


    // $ANTLR start "ruleLookAhead0"
    // InternalLookaheadTestLanguage.g:185:1: ruleLookAhead0 returns [EObject current=null] : (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) ) ;
    public final EObject ruleLookAhead0() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_x_1_0=null;


        	enterRule();

        try {
            // InternalLookaheadTestLanguage.g:191:2: ( (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) ) )
            // InternalLookaheadTestLanguage.g:192:2: (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) )
            {
            // InternalLookaheadTestLanguage.g:192:2: (otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) ) )
            // InternalLookaheadTestLanguage.g:193:3: otherlv_0= 'bar' ( (lv_x_1_0= 'a' ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLookAhead0Access().getBarKeyword_0());
              		
            }
            // InternalLookaheadTestLanguage.g:197:3: ( (lv_x_1_0= 'a' ) )
            // InternalLookaheadTestLanguage.g:198:4: (lv_x_1_0= 'a' )
            {
            // InternalLookaheadTestLanguage.g:198:4: (lv_x_1_0= 'a' )
            // InternalLookaheadTestLanguage.g:199:5: lv_x_1_0= 'a'
            {
            lv_x_1_0=(Token)match(input,12,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_x_1_0, grammarAccess.getLookAhead0Access().getXAKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLookAhead0Rule());
              					}
              					setWithLastConsumed(current, "x", lv_x_1_0, "a");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLookAhead0"


    // $ANTLR start "entryRuleLookAhead1"
    // InternalLookaheadTestLanguage.g:215:1: entryRuleLookAhead1 returns [EObject current=null] : iv_ruleLookAhead1= ruleLookAhead1 EOF ;
    public final EObject entryRuleLookAhead1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead1 = null;


        try {
            // InternalLookaheadTestLanguage.g:215:51: (iv_ruleLookAhead1= ruleLookAhead1 EOF )
            // InternalLookaheadTestLanguage.g:216:2: iv_ruleLookAhead1= ruleLookAhead1 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLookAhead1Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookAhead1=ruleLookAhead1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLookAhead1; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLookAhead1"


    // $ANTLR start "ruleLookAhead1"
    // InternalLookaheadTestLanguage.g:222:1: ruleLookAhead1 returns [EObject current=null] : (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) ) ;
    public final EObject ruleLookAhead1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_x_2_0=null;
        Token lv_z_3_0=null;
        EObject lv_y_1_0 = null;



        	enterRule();

        try {
            // InternalLookaheadTestLanguage.g:228:2: ( (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) ) )
            // InternalLookaheadTestLanguage.g:229:2: (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) )
            {
            // InternalLookaheadTestLanguage.g:229:2: (otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) ) )
            // InternalLookaheadTestLanguage.g:230:3: otherlv_0= 'foo' ( (lv_y_1_0= ruleLookAhead2 ) ) ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= 'd' ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLookAhead1Access().getFooKeyword_0());
              		
            }
            // InternalLookaheadTestLanguage.g:234:3: ( (lv_y_1_0= ruleLookAhead2 ) )
            // InternalLookaheadTestLanguage.g:235:4: (lv_y_1_0= ruleLookAhead2 )
            {
            // InternalLookaheadTestLanguage.g:235:4: (lv_y_1_0= ruleLookAhead2 )
            // InternalLookaheadTestLanguage.g:236:5: lv_y_1_0= ruleLookAhead2
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLookAhead1Access().getYLookAhead2ParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_y_1_0=ruleLookAhead2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLookAhead1Rule());
              					}
              					set(
              						current,
              						"y",
              						lv_y_1_0,
              						"org.eclipse.xtext.testlanguages.LookaheadTestLanguage.LookAhead2");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalLookaheadTestLanguage.g:253:3: ( (lv_x_2_0= 'b' ) )
            // InternalLookaheadTestLanguage.g:254:4: (lv_x_2_0= 'b' )
            {
            // InternalLookaheadTestLanguage.g:254:4: (lv_x_2_0= 'b' )
            // InternalLookaheadTestLanguage.g:255:5: lv_x_2_0= 'b'
            {
            lv_x_2_0=(Token)match(input,14,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_x_2_0, grammarAccess.getLookAhead1Access().getXBKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLookAhead1Rule());
              					}
              					setWithLastConsumed(current, "x", lv_x_2_0, "b");
              				
            }

            }


            }

            // InternalLookaheadTestLanguage.g:267:3: ( (lv_z_3_0= 'd' ) )
            // InternalLookaheadTestLanguage.g:268:4: (lv_z_3_0= 'd' )
            {
            // InternalLookaheadTestLanguage.g:268:4: (lv_z_3_0= 'd' )
            // InternalLookaheadTestLanguage.g:269:5: lv_z_3_0= 'd'
            {
            lv_z_3_0=(Token)match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_z_3_0, grammarAccess.getLookAhead1Access().getZDKeyword_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLookAhead1Rule());
              					}
              					setWithLastConsumed(current, "z", lv_z_3_0, "d");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLookAhead1"


    // $ANTLR start "entryRuleLookAhead2"
    // InternalLookaheadTestLanguage.g:285:1: entryRuleLookAhead2 returns [EObject current=null] : iv_ruleLookAhead2= ruleLookAhead2 EOF ;
    public final EObject entryRuleLookAhead2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead2 = null;


        try {
            // InternalLookaheadTestLanguage.g:285:51: (iv_ruleLookAhead2= ruleLookAhead2 EOF )
            // InternalLookaheadTestLanguage.g:286:2: iv_ruleLookAhead2= ruleLookAhead2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLookAhead2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookAhead2=ruleLookAhead2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLookAhead2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLookAhead2"


    // $ANTLR start "ruleLookAhead2"
    // InternalLookaheadTestLanguage.g:292:1: ruleLookAhead2 returns [EObject current=null] : ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' ) ;
    public final EObject ruleLookAhead2() throws RecognitionException {
        EObject current = null;

        Token lv_z_0_0=null;
        Token lv_z_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalLookaheadTestLanguage.g:298:2: ( ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' ) )
            // InternalLookaheadTestLanguage.g:299:2: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' )
            {
            // InternalLookaheadTestLanguage.g:299:2: ( ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c' )
            // InternalLookaheadTestLanguage.g:300:3: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) ) otherlv_2= 'c'
            {
            // InternalLookaheadTestLanguage.g:300:3: ( ( (lv_z_0_0= 'foo' ) ) | ( (lv_z_1_0= 'bar' ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==11) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalLookaheadTestLanguage.g:301:4: ( (lv_z_0_0= 'foo' ) )
                    {
                    // InternalLookaheadTestLanguage.g:301:4: ( (lv_z_0_0= 'foo' ) )
                    // InternalLookaheadTestLanguage.g:302:5: (lv_z_0_0= 'foo' )
                    {
                    // InternalLookaheadTestLanguage.g:302:5: (lv_z_0_0= 'foo' )
                    // InternalLookaheadTestLanguage.g:303:6: lv_z_0_0= 'foo'
                    {
                    lv_z_0_0=(Token)match(input,13,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_z_0_0, grammarAccess.getLookAhead2Access().getZFooKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getLookAhead2Rule());
                      						}
                      						setWithLastConsumed(current, "z", lv_z_0_0, "foo");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLookaheadTestLanguage.g:316:4: ( (lv_z_1_0= 'bar' ) )
                    {
                    // InternalLookaheadTestLanguage.g:316:4: ( (lv_z_1_0= 'bar' ) )
                    // InternalLookaheadTestLanguage.g:317:5: (lv_z_1_0= 'bar' )
                    {
                    // InternalLookaheadTestLanguage.g:317:5: (lv_z_1_0= 'bar' )
                    // InternalLookaheadTestLanguage.g:318:6: lv_z_1_0= 'bar'
                    {
                    lv_z_1_0=(Token)match(input,11,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_z_1_0, grammarAccess.getLookAhead2Access().getZBarKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getLookAhead2Rule());
                      						}
                      						setWithLastConsumed(current, "z", lv_z_1_0, "bar");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLookAhead2Access().getCKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLookAhead2"


    // $ANTLR start "entryRuleLookAhead3"
    // InternalLookaheadTestLanguage.g:339:1: entryRuleLookAhead3 returns [EObject current=null] : iv_ruleLookAhead3= ruleLookAhead3 EOF ;
    public final EObject entryRuleLookAhead3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead3 = null;


        try {
            // InternalLookaheadTestLanguage.g:339:51: (iv_ruleLookAhead3= ruleLookAhead3 EOF )
            // InternalLookaheadTestLanguage.g:340:2: iv_ruleLookAhead3= ruleLookAhead3 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLookAhead3Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookAhead3=ruleLookAhead3();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLookAhead3; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLookAhead3"


    // $ANTLR start "ruleLookAhead3"
    // InternalLookaheadTestLanguage.g:346:1: ruleLookAhead3 returns [EObject current=null] : (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) ;
    public final EObject ruleLookAhead3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_x_2_0=null;
        EObject lv_z_3_0 = null;



        	enterRule();

        try {
            // InternalLookaheadTestLanguage.g:352:2: ( (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) ) )
            // InternalLookaheadTestLanguage.g:353:2: (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            {
            // InternalLookaheadTestLanguage.g:353:2: (otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) ) )
            // InternalLookaheadTestLanguage.g:354:3: otherlv_0= 'foo' otherlv_1= 'bar' ( (lv_x_2_0= 'b' ) ) ( (lv_z_3_0= ruleLookAhead4 ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLookAhead3Access().getFooKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLookAhead3Access().getBarKeyword_1());
              		
            }
            // InternalLookaheadTestLanguage.g:362:3: ( (lv_x_2_0= 'b' ) )
            // InternalLookaheadTestLanguage.g:363:4: (lv_x_2_0= 'b' )
            {
            // InternalLookaheadTestLanguage.g:363:4: (lv_x_2_0= 'b' )
            // InternalLookaheadTestLanguage.g:364:5: lv_x_2_0= 'b'
            {
            lv_x_2_0=(Token)match(input,14,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_x_2_0, grammarAccess.getLookAhead3Access().getXBKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLookAhead3Rule());
              					}
              					setWithLastConsumed(current, "x", lv_x_2_0, "b");
              				
            }

            }


            }

            // InternalLookaheadTestLanguage.g:376:3: ( (lv_z_3_0= ruleLookAhead4 ) )
            // InternalLookaheadTestLanguage.g:377:4: (lv_z_3_0= ruleLookAhead4 )
            {
            // InternalLookaheadTestLanguage.g:377:4: (lv_z_3_0= ruleLookAhead4 )
            // InternalLookaheadTestLanguage.g:378:5: lv_z_3_0= ruleLookAhead4
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLookAhead3Access().getZLookAhead4ParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_z_3_0=ruleLookAhead4();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLookAhead3Rule());
              					}
              					set(
              						current,
              						"z",
              						lv_z_3_0,
              						"org.eclipse.xtext.testlanguages.LookaheadTestLanguage.LookAhead4");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLookAhead3"


    // $ANTLR start "entryRuleLookAhead4"
    // InternalLookaheadTestLanguage.g:399:1: entryRuleLookAhead4 returns [EObject current=null] : iv_ruleLookAhead4= ruleLookAhead4 EOF ;
    public final EObject entryRuleLookAhead4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAhead4 = null;


        try {
            // InternalLookaheadTestLanguage.g:399:51: (iv_ruleLookAhead4= ruleLookAhead4 EOF )
            // InternalLookaheadTestLanguage.g:400:2: iv_ruleLookAhead4= ruleLookAhead4 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLookAhead4Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookAhead4=ruleLookAhead4();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLookAhead4; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLookAhead4"


    // $ANTLR start "ruleLookAhead4"
    // InternalLookaheadTestLanguage.g:406:1: ruleLookAhead4 returns [EObject current=null] : ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) ;
    public final EObject ruleLookAhead4() throws RecognitionException {
        EObject current = null;

        Token lv_x_0_0=null;
        Token lv_x_1_0=null;


        	enterRule();

        try {
            // InternalLookaheadTestLanguage.g:412:2: ( ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) ) )
            // InternalLookaheadTestLanguage.g:413:2: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
            {
            // InternalLookaheadTestLanguage.g:413:2: ( ( (lv_x_0_0= 'c' ) ) | ( (lv_x_1_0= 'd' ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalLookaheadTestLanguage.g:414:3: ( (lv_x_0_0= 'c' ) )
                    {
                    // InternalLookaheadTestLanguage.g:414:3: ( (lv_x_0_0= 'c' ) )
                    // InternalLookaheadTestLanguage.g:415:4: (lv_x_0_0= 'c' )
                    {
                    // InternalLookaheadTestLanguage.g:415:4: (lv_x_0_0= 'c' )
                    // InternalLookaheadTestLanguage.g:416:5: lv_x_0_0= 'c'
                    {
                    lv_x_0_0=(Token)match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_x_0_0, grammarAccess.getLookAhead4Access().getXCKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getLookAhead4Rule());
                      					}
                      					setWithLastConsumed(current, "x", lv_x_0_0, "c");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLookaheadTestLanguage.g:429:3: ( (lv_x_1_0= 'd' ) )
                    {
                    // InternalLookaheadTestLanguage.g:429:3: ( (lv_x_1_0= 'd' ) )
                    // InternalLookaheadTestLanguage.g:430:4: (lv_x_1_0= 'd' )
                    {
                    // InternalLookaheadTestLanguage.g:430:4: (lv_x_1_0= 'd' )
                    // InternalLookaheadTestLanguage.g:431:5: lv_x_1_0= 'd'
                    {
                    lv_x_1_0=(Token)match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_x_1_0, grammarAccess.getLookAhead4Access().getXDKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getLookAhead4Rule());
                      					}
                      					setWithLastConsumed(current, "x", lv_x_1_0, "d");
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLookAhead4"


    // $ANTLR start "entryRuleLookAheadPredicate"
    // InternalLookaheadTestLanguage.g:447:1: entryRuleLookAheadPredicate returns [EObject current=null] : iv_ruleLookAheadPredicate= ruleLookAheadPredicate EOF ;
    public final EObject entryRuleLookAheadPredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAheadPredicate = null;


        try {
            // InternalLookaheadTestLanguage.g:447:59: (iv_ruleLookAheadPredicate= ruleLookAheadPredicate EOF )
            // InternalLookaheadTestLanguage.g:448:2: iv_ruleLookAheadPredicate= ruleLookAheadPredicate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLookAheadPredicateRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookAheadPredicate=ruleLookAheadPredicate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLookAheadPredicate; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLookAheadPredicate"


    // $ANTLR start "ruleLookAheadPredicate"
    // InternalLookaheadTestLanguage.g:454:1: ruleLookAheadPredicate returns [EObject current=null] : ( ( ( ( () 'zonk' 'a' 'b' ) )=> ( () otherlv_1= 'zonk' otherlv_2= 'a' otherlv_3= 'b' ) ) otherlv_4= 'd' ) ;
    public final EObject ruleLookAheadPredicate() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalLookaheadTestLanguage.g:460:2: ( ( ( ( ( () 'zonk' 'a' 'b' ) )=> ( () otherlv_1= 'zonk' otherlv_2= 'a' otherlv_3= 'b' ) ) otherlv_4= 'd' ) )
            // InternalLookaheadTestLanguage.g:461:2: ( ( ( ( () 'zonk' 'a' 'b' ) )=> ( () otherlv_1= 'zonk' otherlv_2= 'a' otherlv_3= 'b' ) ) otherlv_4= 'd' )
            {
            // InternalLookaheadTestLanguage.g:461:2: ( ( ( ( () 'zonk' 'a' 'b' ) )=> ( () otherlv_1= 'zonk' otherlv_2= 'a' otherlv_3= 'b' ) ) otherlv_4= 'd' )
            // InternalLookaheadTestLanguage.g:462:3: ( ( ( () 'zonk' 'a' 'b' ) )=> ( () otherlv_1= 'zonk' otherlv_2= 'a' otherlv_3= 'b' ) ) otherlv_4= 'd'
            {
            // InternalLookaheadTestLanguage.g:462:3: ( ( ( () 'zonk' 'a' 'b' ) )=> ( () otherlv_1= 'zonk' otherlv_2= 'a' otherlv_3= 'b' ) )
            // InternalLookaheadTestLanguage.g:463:4: ( ( () 'zonk' 'a' 'b' ) )=> ( () otherlv_1= 'zonk' otherlv_2= 'a' otherlv_3= 'b' )
            {
            // InternalLookaheadTestLanguage.g:471:4: ( () otherlv_1= 'zonk' otherlv_2= 'a' otherlv_3= 'b' )
            // InternalLookaheadTestLanguage.g:472:5: () otherlv_1= 'zonk' otherlv_2= 'a' otherlv_3= 'b'
            {
            // InternalLookaheadTestLanguage.g:472:5: ()
            // InternalLookaheadTestLanguage.g:473:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getLookAheadPredicateAccess().getLookAheadPredicateAction_0_0_0(),
              							current);
              					
            }

            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getLookAheadPredicateAccess().getZonkKeyword_0_0_1());
              				
            }
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getLookAheadPredicateAccess().getAKeyword_0_0_2());
              				
            }
            otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_3, grammarAccess.getLookAheadPredicateAccess().getBKeyword_0_0_3());
              				
            }

            }


            }

            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLookAheadPredicateAccess().getDKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLookAheadPredicate"


    // $ANTLR start "entryRuleLookBeyond"
    // InternalLookaheadTestLanguage.g:501:1: entryRuleLookBeyond returns [EObject current=null] : iv_ruleLookBeyond= ruleLookBeyond EOF ;
    public final EObject entryRuleLookBeyond() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookBeyond = null;


        try {
            // InternalLookaheadTestLanguage.g:501:51: (iv_ruleLookBeyond= ruleLookBeyond EOF )
            // InternalLookaheadTestLanguage.g:502:2: iv_ruleLookBeyond= ruleLookBeyond EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLookBeyondRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookBeyond=ruleLookBeyond();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLookBeyond; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLookBeyond"


    // $ANTLR start "ruleLookBeyond"
    // InternalLookaheadTestLanguage.g:508:1: ruleLookBeyond returns [EObject current=null] : ( ( (lv_left_0_0= ruleLookAheadStrings ) )? ( (lv_right_1_0= ruleFewerLookAheadStrings ) ) ) ;
    public final EObject ruleLookBeyond() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalLookaheadTestLanguage.g:514:2: ( ( ( (lv_left_0_0= ruleLookAheadStrings ) )? ( (lv_right_1_0= ruleFewerLookAheadStrings ) ) ) )
            // InternalLookaheadTestLanguage.g:515:2: ( ( (lv_left_0_0= ruleLookAheadStrings ) )? ( (lv_right_1_0= ruleFewerLookAheadStrings ) ) )
            {
            // InternalLookaheadTestLanguage.g:515:2: ( ( (lv_left_0_0= ruleLookAheadStrings ) )? ( (lv_right_1_0= ruleFewerLookAheadStrings ) ) )
            // InternalLookaheadTestLanguage.g:516:3: ( (lv_left_0_0= ruleLookAheadStrings ) )? ( (lv_right_1_0= ruleFewerLookAheadStrings ) )
            {
            // InternalLookaheadTestLanguage.g:516:3: ( (lv_left_0_0= ruleLookAheadStrings ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_STRING) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==RULE_STRING) ) {
                        alt5=1;
                    }
                }
            }
            switch (alt5) {
                case 1 :
                    // InternalLookaheadTestLanguage.g:517:4: (lv_left_0_0= ruleLookAheadStrings )
                    {
                    // InternalLookaheadTestLanguage.g:517:4: (lv_left_0_0= ruleLookAheadStrings )
                    // InternalLookaheadTestLanguage.g:518:5: lv_left_0_0= ruleLookAheadStrings
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLookBeyondAccess().getLeftLookAheadStringsParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
                    lv_left_0_0=ruleLookAheadStrings();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getLookBeyondRule());
                      					}
                      					set(
                      						current,
                      						"left",
                      						lv_left_0_0,
                      						"org.eclipse.xtext.testlanguages.LookaheadTestLanguage.LookAheadStrings");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalLookaheadTestLanguage.g:535:3: ( (lv_right_1_0= ruleFewerLookAheadStrings ) )
            // InternalLookaheadTestLanguage.g:536:4: (lv_right_1_0= ruleFewerLookAheadStrings )
            {
            // InternalLookaheadTestLanguage.g:536:4: (lv_right_1_0= ruleFewerLookAheadStrings )
            // InternalLookaheadTestLanguage.g:537:5: lv_right_1_0= ruleFewerLookAheadStrings
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLookBeyondAccess().getRightFewerLookAheadStringsParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_right_1_0=ruleFewerLookAheadStrings();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLookBeyondRule());
              					}
              					set(
              						current,
              						"right",
              						lv_right_1_0,
              						"org.eclipse.xtext.testlanguages.LookaheadTestLanguage.FewerLookAheadStrings");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLookBeyond"


    // $ANTLR start "entryRuleLookAheadStrings"
    // InternalLookaheadTestLanguage.g:558:1: entryRuleLookAheadStrings returns [EObject current=null] : iv_ruleLookAheadStrings= ruleLookAheadStrings EOF ;
    public final EObject entryRuleLookAheadStrings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookAheadStrings = null;


        try {
            // InternalLookaheadTestLanguage.g:558:57: (iv_ruleLookAheadStrings= ruleLookAheadStrings EOF )
            // InternalLookaheadTestLanguage.g:559:2: iv_ruleLookAheadStrings= ruleLookAheadStrings EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLookAheadStringsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLookAheadStrings=ruleLookAheadStrings();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLookAheadStrings; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLookAheadStrings"


    // $ANTLR start "ruleLookAheadStrings"
    // InternalLookaheadTestLanguage.g:565:1: ruleLookAheadStrings returns [EObject current=null] : ( (lv_values_0_0= RULE_STRING ) )+ ;
    public final EObject ruleLookAheadStrings() throws RecognitionException {
        EObject current = null;

        Token lv_values_0_0=null;


        	enterRule();

        try {
            // InternalLookaheadTestLanguage.g:571:2: ( ( (lv_values_0_0= RULE_STRING ) )+ )
            // InternalLookaheadTestLanguage.g:572:2: ( (lv_values_0_0= RULE_STRING ) )+
            {
            // InternalLookaheadTestLanguage.g:572:2: ( (lv_values_0_0= RULE_STRING ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_STRING) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==RULE_STRING) ) {
                        int LA6_3 = input.LA(3);

                        if ( (LA6_3==EOF||LA6_3==RULE_STRING) ) {
                            alt6=1;
                        }


                    }
                    else if ( (LA6_1==EOF) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // InternalLookaheadTestLanguage.g:573:3: (lv_values_0_0= RULE_STRING )
            	    {
            	    // InternalLookaheadTestLanguage.g:573:3: (lv_values_0_0= RULE_STRING )
            	    // InternalLookaheadTestLanguage.g:574:4: lv_values_0_0= RULE_STRING
            	    {
            	    lv_values_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(lv_values_0_0, grammarAccess.getLookAheadStringsAccess().getValuesSTRINGTerminalRuleCall_0());
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElement(grammarAccess.getLookAheadStringsRule());
            	      				}
            	      				addWithLastConsumed(
            	      					current,
            	      					"values",
            	      					lv_values_0_0,
            	      					"org.eclipse.xtext.common.Terminals.STRING");
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLookAheadStrings"


    // $ANTLR start "entryRuleFewerLookAheadStrings"
    // InternalLookaheadTestLanguage.g:593:1: entryRuleFewerLookAheadStrings returns [EObject current=null] : iv_ruleFewerLookAheadStrings= ruleFewerLookAheadStrings EOF ;
    public final EObject entryRuleFewerLookAheadStrings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFewerLookAheadStrings = null;


        try {
            // InternalLookaheadTestLanguage.g:593:62: (iv_ruleFewerLookAheadStrings= ruleFewerLookAheadStrings EOF )
            // InternalLookaheadTestLanguage.g:594:2: iv_ruleFewerLookAheadStrings= ruleFewerLookAheadStrings EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFewerLookAheadStringsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFewerLookAheadStrings=ruleFewerLookAheadStrings();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFewerLookAheadStrings; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFewerLookAheadStrings"


    // $ANTLR start "ruleFewerLookAheadStrings"
    // InternalLookaheadTestLanguage.g:600:1: ruleFewerLookAheadStrings returns [EObject current=null] : ( ( (lv_values_0_0= RULE_STRING ) ) ( (lv_values_1_0= RULE_STRING ) ) ( (lv_values_2_0= RULE_ID ) ) ) ;
    public final EObject ruleFewerLookAheadStrings() throws RecognitionException {
        EObject current = null;

        Token lv_values_0_0=null;
        Token lv_values_1_0=null;
        Token lv_values_2_0=null;


        	enterRule();

        try {
            // InternalLookaheadTestLanguage.g:606:2: ( ( ( (lv_values_0_0= RULE_STRING ) ) ( (lv_values_1_0= RULE_STRING ) ) ( (lv_values_2_0= RULE_ID ) ) ) )
            // InternalLookaheadTestLanguage.g:607:2: ( ( (lv_values_0_0= RULE_STRING ) ) ( (lv_values_1_0= RULE_STRING ) ) ( (lv_values_2_0= RULE_ID ) ) )
            {
            // InternalLookaheadTestLanguage.g:607:2: ( ( (lv_values_0_0= RULE_STRING ) ) ( (lv_values_1_0= RULE_STRING ) ) ( (lv_values_2_0= RULE_ID ) ) )
            // InternalLookaheadTestLanguage.g:608:3: ( (lv_values_0_0= RULE_STRING ) ) ( (lv_values_1_0= RULE_STRING ) ) ( (lv_values_2_0= RULE_ID ) )
            {
            // InternalLookaheadTestLanguage.g:608:3: ( (lv_values_0_0= RULE_STRING ) )
            // InternalLookaheadTestLanguage.g:609:4: (lv_values_0_0= RULE_STRING )
            {
            // InternalLookaheadTestLanguage.g:609:4: (lv_values_0_0= RULE_STRING )
            // InternalLookaheadTestLanguage.g:610:5: lv_values_0_0= RULE_STRING
            {
            lv_values_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_values_0_0, grammarAccess.getFewerLookAheadStringsAccess().getValuesSTRINGTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFewerLookAheadStringsRule());
              					}
              					addWithLastConsumed(
              						current,
              						"values",
              						lv_values_0_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }

            // InternalLookaheadTestLanguage.g:626:3: ( (lv_values_1_0= RULE_STRING ) )
            // InternalLookaheadTestLanguage.g:627:4: (lv_values_1_0= RULE_STRING )
            {
            // InternalLookaheadTestLanguage.g:627:4: (lv_values_1_0= RULE_STRING )
            // InternalLookaheadTestLanguage.g:628:5: lv_values_1_0= RULE_STRING
            {
            lv_values_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_values_1_0, grammarAccess.getFewerLookAheadStringsAccess().getValuesSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFewerLookAheadStringsRule());
              					}
              					addWithLastConsumed(
              						current,
              						"values",
              						lv_values_1_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }

            // InternalLookaheadTestLanguage.g:644:3: ( (lv_values_2_0= RULE_ID ) )
            // InternalLookaheadTestLanguage.g:645:4: (lv_values_2_0= RULE_ID )
            {
            // InternalLookaheadTestLanguage.g:645:4: (lv_values_2_0= RULE_ID )
            // InternalLookaheadTestLanguage.g:646:5: lv_values_2_0= RULE_ID
            {
            lv_values_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_values_2_0, grammarAccess.getFewerLookAheadStringsAccess().getValuesIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFewerLookAheadStringsRule());
              					}
              					addWithLastConsumed(
              						current,
              						"values",
              						lv_values_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFewerLookAheadStrings"

    // $ANTLR start synpred1_InternalLookaheadTestLanguage
    public final void synpred1_InternalLookaheadTestLanguage_fragment() throws RecognitionException {   
        // InternalLookaheadTestLanguage.g:148:4: ( ( () 'zonk' 'a' 'b' ) )
        // InternalLookaheadTestLanguage.g:148:5: ( () 'zonk' 'a' 'b' )
        {
        // InternalLookaheadTestLanguage.g:148:5: ( () 'zonk' 'a' 'b' )
        // InternalLookaheadTestLanguage.g:149:5: () 'zonk' 'a' 'b'
        {
        // InternalLookaheadTestLanguage.g:149:5: ()
        // InternalLookaheadTestLanguage.g:150:5: 
        {
        }

        match(input,17,FollowSets000.FOLLOW_4); if (state.failed) return ;
        match(input,12,FollowSets000.FOLLOW_6); if (state.failed) return ;
        match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalLookaheadTestLanguage

    // Delegated rules

    public final boolean synpred1_InternalLookaheadTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalLookaheadTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000022812L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000022810L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
    }


}
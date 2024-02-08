package org.eclipse.xtext.grammarinheritance.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalConcreteTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_REAL", "RULE_ID", "RULE_INT", "RULE_STRING", "SUPER_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "':'", "'overriddenelement'", "'overridden other element'", "'-'", "'subrule1'", "'subrule3'", "'element'", "'overridemodel'", "'extendedmodel'"
    };
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int SUPER_ID=8;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=11;
    public static final int RULE_REAL=4;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalConcreteTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConcreteTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConcreteTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalConcreteTestLanguage.g"; }



     	private ConcreteTestLanguageGrammarAccess grammarAccess;

        public InternalConcreteTestLanguageParser(TokenStream input, ConcreteTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "RootRule";
       	}

       	@Override
       	protected ConcreteTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleRootRule"
    // InternalConcreteTestLanguage.g:69:1: entryRuleRootRule returns [EObject current=null] : iv_ruleRootRule= ruleRootRule EOF ;
    public final EObject entryRuleRootRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootRule = null;


        try {
            // InternalConcreteTestLanguage.g:69:49: (iv_ruleRootRule= ruleRootRule EOF )
            // InternalConcreteTestLanguage.g:70:2: iv_ruleRootRule= ruleRootRule EOF
            {
             newCompositeNode(grammarAccess.getRootRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRootRule=ruleRootRule();

            state._fsp--;

             current =iv_ruleRootRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleRootRule"


    // $ANTLR start "ruleRootRule"
    // InternalConcreteTestLanguage.g:76:1: ruleRootRule returns [EObject current=null] : (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule | this_CallExtendedParserRule_2= ruleCallExtendedParserRule | this_OverridableParserRule2_3= ruleOverridableParserRule2 ) ;
    public final EObject ruleRootRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteParserRule_0 = null;

        EObject this_CallOverridenParserRule_1 = null;

        EObject this_CallExtendedParserRule_2 = null;

        EObject this_OverridableParserRule2_3 = null;



        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:82:2: ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule | this_CallExtendedParserRule_2= ruleCallExtendedParserRule | this_OverridableParserRule2_3= ruleOverridableParserRule2 ) )
            // InternalConcreteTestLanguage.g:83:2: (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule | this_CallExtendedParserRule_2= ruleCallExtendedParserRule | this_OverridableParserRule2_3= ruleOverridableParserRule2 )
            {
            // InternalConcreteTestLanguage.g:83:2: (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule | this_CallExtendedParserRule_2= ruleCallExtendedParserRule | this_OverridableParserRule2_3= ruleOverridableParserRule2 )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt1=1;
                }
                break;
            case 21:
                {
                alt1=2;
                }
                break;
            case 22:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalConcreteTestLanguage.g:84:3: this_ConcreteParserRule_0= ruleConcreteParserRule
                    {

                    			newCompositeNode(grammarAccess.getRootRuleAccess().getConcreteParserRuleParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ConcreteParserRule_0=ruleConcreteParserRule();

                    state._fsp--;


                    			current = this_ConcreteParserRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalConcreteTestLanguage.g:93:3: this_CallOverridenParserRule_1= ruleCallOverridenParserRule
                    {

                    			newCompositeNode(grammarAccess.getRootRuleAccess().getCallOverridenParserRuleParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CallOverridenParserRule_1=ruleCallOverridenParserRule();

                    state._fsp--;


                    			current = this_CallOverridenParserRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalConcreteTestLanguage.g:102:3: this_CallExtendedParserRule_2= ruleCallExtendedParserRule
                    {

                    			newCompositeNode(grammarAccess.getRootRuleAccess().getCallExtendedParserRuleParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CallExtendedParserRule_2=ruleCallExtendedParserRule();

                    state._fsp--;


                    			current = this_CallExtendedParserRule_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalConcreteTestLanguage.g:111:3: this_OverridableParserRule2_3= ruleOverridableParserRule2
                    {

                    			newCompositeNode(grammarAccess.getRootRuleAccess().getOverridableParserRule2ParserRuleCall_3());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_OverridableParserRule2_3=ruleOverridableParserRule2();

                    state._fsp--;


                    			current = this_OverridableParserRule2_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRootRule"


    // $ANTLR start "entryRuleConcreteParserRule"
    // InternalConcreteTestLanguage.g:123:1: entryRuleConcreteParserRule returns [EObject current=null] : iv_ruleConcreteParserRule= ruleConcreteParserRule EOF ;
    public final EObject entryRuleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteParserRule = null;


        try {
            // InternalConcreteTestLanguage.g:123:59: (iv_ruleConcreteParserRule= ruleConcreteParserRule EOF )
            // InternalConcreteTestLanguage.g:124:2: iv_ruleConcreteParserRule= ruleConcreteParserRule EOF
            {
             newCompositeNode(grammarAccess.getConcreteParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConcreteParserRule=ruleConcreteParserRule();

            state._fsp--;

             current =iv_ruleConcreteParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleConcreteParserRule"


    // $ANTLR start "ruleConcreteParserRule"
    // InternalConcreteTestLanguage.g:130:1: ruleConcreteParserRule returns [EObject current=null] : (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* ) ;
    public final EObject ruleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_magicNumber_1_0=null;
        Token otherlv_2=null;
        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:136:2: ( (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* ) )
            // InternalConcreteTestLanguage.g:137:2: (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* )
            {
            // InternalConcreteTestLanguage.g:137:2: (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* )
            // InternalConcreteTestLanguage.g:138:3: otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )*
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConcreteParserRuleAccess().getModelKeyword_0());
            		
            // InternalConcreteTestLanguage.g:142:3: ( (lv_magicNumber_1_0= RULE_REAL ) )
            // InternalConcreteTestLanguage.g:143:4: (lv_magicNumber_1_0= RULE_REAL )
            {
            // InternalConcreteTestLanguage.g:143:4: (lv_magicNumber_1_0= RULE_REAL )
            // InternalConcreteTestLanguage.g:144:5: lv_magicNumber_1_0= RULE_REAL
            {
            lv_magicNumber_1_0=(Token)match(input,RULE_REAL,FollowSets000.FOLLOW_4); 

            					newLeafNode(lv_magicNumber_1_0, grammarAccess.getConcreteParserRuleAccess().getMagicNumberREALTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteParserRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"magicNumber",
            						lv_magicNumber_1_0,
            						"org.eclipse.xtext.grammarinheritance.AbstractTestLanguage.REAL");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getConcreteParserRuleAccess().getColonKeyword_2());
            		
            // InternalConcreteTestLanguage.g:164:3: ( (lv_elements_3_0= ruleInheritedParserRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==20) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalConcreteTestLanguage.g:165:4: (lv_elements_3_0= ruleInheritedParserRule )
            	    {
            	    // InternalConcreteTestLanguage.g:165:4: (lv_elements_3_0= ruleInheritedParserRule )
            	    // InternalConcreteTestLanguage.g:166:5: lv_elements_3_0= ruleInheritedParserRule
            	    {

            	    					newCompositeNode(grammarAccess.getConcreteParserRuleAccess().getElementsInheritedParserRuleParserRuleCall_3_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_elements_3_0=ruleInheritedParserRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConcreteParserRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_3_0,
            	    						"org.eclipse.xtext.grammarinheritance.AbstractTestLanguage.InheritedParserRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcreteParserRule"


    // $ANTLR start "entryRuleOverridableParserRule"
    // InternalConcreteTestLanguage.g:187:1: entryRuleOverridableParserRule returns [EObject current=null] : iv_ruleOverridableParserRule= ruleOverridableParserRule EOF ;
    public final EObject entryRuleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule = null;


        try {
            // InternalConcreteTestLanguage.g:187:62: (iv_ruleOverridableParserRule= ruleOverridableParserRule EOF )
            // InternalConcreteTestLanguage.g:188:2: iv_ruleOverridableParserRule= ruleOverridableParserRule EOF
            {
             newCompositeNode(grammarAccess.getOverridableParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOverridableParserRule=ruleOverridableParserRule();

            state._fsp--;

             current =iv_ruleOverridableParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleOverridableParserRule"


    // $ANTLR start "ruleOverridableParserRule"
    // InternalConcreteTestLanguage.g:194:1: ruleOverridableParserRule returns [EObject current=null] : (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:200:2: ( (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalConcreteTestLanguage.g:201:2: (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalConcreteTestLanguage.g:201:2: (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalConcreteTestLanguage.g:202:3: otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getOverridableParserRuleAccess().getOverriddenelementKeyword_0());
            		
            // InternalConcreteTestLanguage.g:206:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalConcreteTestLanguage.g:207:4: (lv_name_1_0= RULE_ID )
            {
            // InternalConcreteTestLanguage.g:207:4: (lv_name_1_0= RULE_ID )
            // InternalConcreteTestLanguage.g:208:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOverridableParserRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOverridableParserRule"


    // $ANTLR start "entryRuleCallOverridenParserRule"
    // InternalConcreteTestLanguage.g:228:1: entryRuleCallOverridenParserRule returns [EObject current=null] : iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF ;
    public final EObject entryRuleCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallOverridenParserRule = null;


        try {
            // InternalConcreteTestLanguage.g:228:64: (iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF )
            // InternalConcreteTestLanguage.g:229:2: iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF
            {
             newCompositeNode(grammarAccess.getCallOverridenParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallOverridenParserRule=ruleCallOverridenParserRule();

            state._fsp--;

             current =iv_ruleCallOverridenParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleCallOverridenParserRule"


    // $ANTLR start "ruleCallOverridenParserRule"
    // InternalConcreteTestLanguage.g:235:1: ruleCallOverridenParserRule returns [EObject current=null] : ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) ) ;
    public final EObject ruleCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;



        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:241:2: ( ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) ) )
            // InternalConcreteTestLanguage.g:242:2: ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) )
            {
            // InternalConcreteTestLanguage.g:242:2: ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) )
            // InternalConcreteTestLanguage.g:243:3: (lv_call_0_0= ruleAbstractCallOverridenParserRule )
            {
            // InternalConcreteTestLanguage.g:243:3: (lv_call_0_0= ruleAbstractCallOverridenParserRule )
            // InternalConcreteTestLanguage.g:244:4: lv_call_0_0= ruleAbstractCallOverridenParserRule
            {

            				newCompositeNode(grammarAccess.getCallOverridenParserRuleAccess().getCallAbstractCallOverridenParserRuleParserRuleCall_0());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_call_0_0=ruleAbstractCallOverridenParserRule();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getCallOverridenParserRuleRule());
            				}
            				set(
            					current,
            					"call",
            					lv_call_0_0,
            					"org.eclipse.xtext.grammarinheritance.AbstractTestLanguage.AbstractCallOverridenParserRule");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallOverridenParserRule"


    // $ANTLR start "entryRuleOverridableParserRule2"
    // InternalConcreteTestLanguage.g:264:1: entryRuleOverridableParserRule2 returns [EObject current=null] : iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF ;
    public final EObject entryRuleOverridableParserRule2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule2 = null;


        try {
            // InternalConcreteTestLanguage.g:264:63: (iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF )
            // InternalConcreteTestLanguage.g:265:2: iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF
            {
             newCompositeNode(grammarAccess.getOverridableParserRule2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOverridableParserRule2=ruleOverridableParserRule2();

            state._fsp--;

             current =iv_ruleOverridableParserRule2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleOverridableParserRule2"


    // $ANTLR start "ruleOverridableParserRule2"
    // InternalConcreteTestLanguage.g:271:1: ruleOverridableParserRule2 returns [EObject current=null] : (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) ) ;
    public final EObject ruleOverridableParserRule2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_age_3_0=null;


        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:277:2: ( (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) ) )
            // InternalConcreteTestLanguage.g:278:2: (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) )
            {
            // InternalConcreteTestLanguage.g:278:2: (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) )
            // InternalConcreteTestLanguage.g:279:3: otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getOverridableParserRule2Access().getOverriddenOtherElementKeyword_0());
            		
            // InternalConcreteTestLanguage.g:283:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalConcreteTestLanguage.g:284:4: (lv_name_1_0= RULE_ID )
            {
            // InternalConcreteTestLanguage.g:284:4: (lv_name_1_0= RULE_ID )
            // InternalConcreteTestLanguage.g:285:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getOverridableParserRule2Access().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOverridableParserRule2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getOverridableParserRule2Access().getHyphenMinusKeyword_2());
            		
            // InternalConcreteTestLanguage.g:305:3: ( (lv_age_3_0= RULE_INT ) )
            // InternalConcreteTestLanguage.g:306:4: (lv_age_3_0= RULE_INT )
            {
            // InternalConcreteTestLanguage.g:306:4: (lv_age_3_0= RULE_INT )
            // InternalConcreteTestLanguage.g:307:5: lv_age_3_0= RULE_INT
            {
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_age_3_0, grammarAccess.getOverridableParserRule2Access().getAgeINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOverridableParserRule2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"age",
            						lv_age_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOverridableParserRule2"


    // $ANTLR start "entryRuleExtendableParserRule"
    // InternalConcreteTestLanguage.g:327:1: entryRuleExtendableParserRule returns [EObject current=null] : iv_ruleExtendableParserRule= ruleExtendableParserRule EOF ;
    public final EObject entryRuleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendableParserRule = null;


        try {
            // InternalConcreteTestLanguage.g:327:61: (iv_ruleExtendableParserRule= ruleExtendableParserRule EOF )
            // InternalConcreteTestLanguage.g:328:2: iv_ruleExtendableParserRule= ruleExtendableParserRule EOF
            {
             newCompositeNode(grammarAccess.getExtendableParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExtendableParserRule=ruleExtendableParserRule();

            state._fsp--;

             current =iv_ruleExtendableParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleExtendableParserRule"


    // $ANTLR start "ruleExtendableParserRule"
    // InternalConcreteTestLanguage.g:334:1: ruleExtendableParserRule returns [EObject current=null] : (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 | this_Subrule3_2= ruleSubrule3 ) ;
    public final EObject ruleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject this_Subrule1_0 = null;

        EObject this_Subrule2_1 = null;

        EObject this_Subrule3_2 = null;



        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:340:2: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 | this_Subrule3_2= ruleSubrule3 ) )
            // InternalConcreteTestLanguage.g:341:2: (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 | this_Subrule3_2= ruleSubrule3 )
            {
            // InternalConcreteTestLanguage.g:341:2: (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 | this_Subrule3_2= ruleSubrule3 )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            else if ( (LA3_0==19) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==RULE_ID) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==RULE_STRING) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==RULE_INT) ) {
                        alt3=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalConcreteTestLanguage.g:342:3: this_Subrule1_0= ruleSubrule1
                    {

                    			newCompositeNode(grammarAccess.getExtendableParserRuleAccess().getSubrule1ParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Subrule1_0=ruleSubrule1();

                    state._fsp--;


                    			current = this_Subrule1_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalConcreteTestLanguage.g:351:3: this_Subrule2_1= ruleSubrule2
                    {

                    			newCompositeNode(grammarAccess.getExtendableParserRuleAccess().getSubrule2ParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Subrule2_1=ruleSubrule2();

                    state._fsp--;


                    			current = this_Subrule2_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalConcreteTestLanguage.g:360:3: this_Subrule3_2= ruleSubrule3
                    {

                    			newCompositeNode(grammarAccess.getExtendableParserRuleAccess().getSubrule3ParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Subrule3_2=ruleSubrule3();

                    state._fsp--;


                    			current = this_Subrule3_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtendableParserRule"


    // $ANTLR start "entryRuleSubrule1"
    // InternalConcreteTestLanguage.g:372:1: entryRuleSubrule1 returns [EObject current=null] : iv_ruleSubrule1= ruleSubrule1 EOF ;
    public final EObject entryRuleSubrule1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule1 = null;


        try {
            // InternalConcreteTestLanguage.g:372:49: (iv_ruleSubrule1= ruleSubrule1 EOF )
            // InternalConcreteTestLanguage.g:373:2: iv_ruleSubrule1= ruleSubrule1 EOF
            {
             newCompositeNode(grammarAccess.getSubrule1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSubrule1=ruleSubrule1();

            state._fsp--;

             current =iv_ruleSubrule1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSubrule1"


    // $ANTLR start "ruleSubrule1"
    // InternalConcreteTestLanguage.g:379:1: ruleSubrule1 returns [EObject current=null] : (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) ) ;
    public final EObject ruleSubrule1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub1_2_0=null;


        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:385:2: ( (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) ) )
            // InternalConcreteTestLanguage.g:386:2: (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) )
            {
            // InternalConcreteTestLanguage.g:386:2: (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) )
            // InternalConcreteTestLanguage.g:387:3: otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getSubrule1Access().getSubrule1Keyword_0());
            		
            // InternalConcreteTestLanguage.g:391:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalConcreteTestLanguage.g:392:4: (lv_name_1_0= RULE_ID )
            {
            // InternalConcreteTestLanguage.g:392:4: (lv_name_1_0= RULE_ID )
            // InternalConcreteTestLanguage.g:393:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSubrule1Access().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubrule1Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage.ID");
            				

            }


            }

            // InternalConcreteTestLanguage.g:409:3: ( (lv_sub1_2_0= RULE_ID ) )
            // InternalConcreteTestLanguage.g:410:4: (lv_sub1_2_0= RULE_ID )
            {
            // InternalConcreteTestLanguage.g:410:4: (lv_sub1_2_0= RULE_ID )
            // InternalConcreteTestLanguage.g:411:5: lv_sub1_2_0= RULE_ID
            {
            lv_sub1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_sub1_2_0, grammarAccess.getSubrule1Access().getSub1IDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubrule1Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"sub1",
            						lv_sub1_2_0,
            						"org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubrule1"


    // $ANTLR start "entryRuleSubrule2"
    // InternalConcreteTestLanguage.g:431:1: entryRuleSubrule2 returns [EObject current=null] : iv_ruleSubrule2= ruleSubrule2 EOF ;
    public final EObject entryRuleSubrule2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule2 = null;


        try {
            // InternalConcreteTestLanguage.g:431:49: (iv_ruleSubrule2= ruleSubrule2 EOF )
            // InternalConcreteTestLanguage.g:432:2: iv_ruleSubrule2= ruleSubrule2 EOF
            {
             newCompositeNode(grammarAccess.getSubrule2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSubrule2=ruleSubrule2();

            state._fsp--;

             current =iv_ruleSubrule2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSubrule2"


    // $ANTLR start "ruleSubrule2"
    // InternalConcreteTestLanguage.g:438:1: ruleSubrule2 returns [EObject current=null] : (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleSubrule2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub2_2_0=null;


        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:444:2: ( (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) ) )
            // InternalConcreteTestLanguage.g:445:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) )
            {
            // InternalConcreteTestLanguage.g:445:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) )
            // InternalConcreteTestLanguage.g:446:3: otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getSubrule2Access().getSubrule3Keyword_0());
            		
            // InternalConcreteTestLanguage.g:450:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalConcreteTestLanguage.g:451:4: (lv_name_1_0= RULE_ID )
            {
            // InternalConcreteTestLanguage.g:451:4: (lv_name_1_0= RULE_ID )
            // InternalConcreteTestLanguage.g:452:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSubrule2Access().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubrule2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage.ID");
            				

            }


            }

            // InternalConcreteTestLanguage.g:468:3: ( (lv_sub2_2_0= RULE_STRING ) )
            // InternalConcreteTestLanguage.g:469:4: (lv_sub2_2_0= RULE_STRING )
            {
            // InternalConcreteTestLanguage.g:469:4: (lv_sub2_2_0= RULE_STRING )
            // InternalConcreteTestLanguage.g:470:5: lv_sub2_2_0= RULE_STRING
            {
            lv_sub2_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_sub2_2_0, grammarAccess.getSubrule2Access().getSub2STRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubrule2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"sub2",
            						lv_sub2_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubrule2"


    // $ANTLR start "entryRuleSubrule3"
    // InternalConcreteTestLanguage.g:490:1: entryRuleSubrule3 returns [EObject current=null] : iv_ruleSubrule3= ruleSubrule3 EOF ;
    public final EObject entryRuleSubrule3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule3 = null;


        try {
            // InternalConcreteTestLanguage.g:490:49: (iv_ruleSubrule3= ruleSubrule3 EOF )
            // InternalConcreteTestLanguage.g:491:2: iv_ruleSubrule3= ruleSubrule3 EOF
            {
             newCompositeNode(grammarAccess.getSubrule3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSubrule3=ruleSubrule3();

            state._fsp--;

             current =iv_ruleSubrule3; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSubrule3"


    // $ANTLR start "ruleSubrule3"
    // InternalConcreteTestLanguage.g:497:1: ruleSubrule3 returns [EObject current=null] : (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) ) ;
    public final EObject ruleSubrule3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub1_2_0=null;


        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:503:2: ( (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) ) )
            // InternalConcreteTestLanguage.g:504:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) )
            {
            // InternalConcreteTestLanguage.g:504:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) )
            // InternalConcreteTestLanguage.g:505:3: otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getSubrule3Access().getSubrule3Keyword_0());
            		
            // InternalConcreteTestLanguage.g:509:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalConcreteTestLanguage.g:510:4: (lv_name_1_0= RULE_ID )
            {
            // InternalConcreteTestLanguage.g:510:4: (lv_name_1_0= RULE_ID )
            // InternalConcreteTestLanguage.g:511:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSubrule3Access().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubrule3Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage.ID");
            				

            }


            }

            // InternalConcreteTestLanguage.g:527:3: ( (lv_sub1_2_0= RULE_INT ) )
            // InternalConcreteTestLanguage.g:528:4: (lv_sub1_2_0= RULE_INT )
            {
            // InternalConcreteTestLanguage.g:528:4: (lv_sub1_2_0= RULE_INT )
            // InternalConcreteTestLanguage.g:529:5: lv_sub1_2_0= RULE_INT
            {
            lv_sub1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_sub1_2_0, grammarAccess.getSubrule3Access().getSub1INTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubrule3Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"sub1",
            						lv_sub1_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubrule3"


    // $ANTLR start "entryRuleCallExtendedParserRule"
    // InternalConcreteTestLanguage.g:549:1: entryRuleCallExtendedParserRule returns [EObject current=null] : iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF ;
    public final EObject entryRuleCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExtendedParserRule = null;


        try {
            // InternalConcreteTestLanguage.g:549:63: (iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF )
            // InternalConcreteTestLanguage.g:550:2: iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF
            {
             newCompositeNode(grammarAccess.getCallExtendedParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallExtendedParserRule=ruleCallExtendedParserRule();

            state._fsp--;

             current =iv_ruleCallExtendedParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleCallExtendedParserRule"


    // $ANTLR start "ruleCallExtendedParserRule"
    // InternalConcreteTestLanguage.g:556:1: ruleCallExtendedParserRule returns [EObject current=null] : ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) ) ;
    public final EObject ruleCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;



        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:562:2: ( ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) ) )
            // InternalConcreteTestLanguage.g:563:2: ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) )
            {
            // InternalConcreteTestLanguage.g:563:2: ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) )
            // InternalConcreteTestLanguage.g:564:3: (lv_call_0_0= ruleAbstractCallExtendedParserRule )
            {
            // InternalConcreteTestLanguage.g:564:3: (lv_call_0_0= ruleAbstractCallExtendedParserRule )
            // InternalConcreteTestLanguage.g:565:4: lv_call_0_0= ruleAbstractCallExtendedParserRule
            {

            				newCompositeNode(grammarAccess.getCallExtendedParserRuleAccess().getCallAbstractCallExtendedParserRuleParserRuleCall_0());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_call_0_0=ruleAbstractCallExtendedParserRule();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getCallExtendedParserRuleRule());
            				}
            				set(
            					current,
            					"call",
            					lv_call_0_0,
            					"org.eclipse.xtext.grammarinheritance.AbstractTestLanguage.AbstractCallExtendedParserRule");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallExtendedParserRule"


    // $ANTLR start "entryRuleInheritedParserRule"
    // InternalConcreteTestLanguage.g:585:1: entryRuleInheritedParserRule returns [EObject current=null] : iv_ruleInheritedParserRule= ruleInheritedParserRule EOF ;
    public final EObject entryRuleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritedParserRule = null;


        try {
            // InternalConcreteTestLanguage.g:585:60: (iv_ruleInheritedParserRule= ruleInheritedParserRule EOF )
            // InternalConcreteTestLanguage.g:586:2: iv_ruleInheritedParserRule= ruleInheritedParserRule EOF
            {
             newCompositeNode(grammarAccess.getInheritedParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInheritedParserRule=ruleInheritedParserRule();

            state._fsp--;

             current =iv_ruleInheritedParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleInheritedParserRule"


    // $ANTLR start "ruleInheritedParserRule"
    // InternalConcreteTestLanguage.g:592:1: ruleInheritedParserRule returns [EObject current=null] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:598:2: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalConcreteTestLanguage.g:599:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalConcreteTestLanguage.g:599:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalConcreteTestLanguage.g:600:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getInheritedParserRuleAccess().getElementKeyword_0());
            		
            // InternalConcreteTestLanguage.g:604:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalConcreteTestLanguage.g:605:4: (lv_name_1_0= RULE_ID )
            {
            // InternalConcreteTestLanguage.g:605:4: (lv_name_1_0= RULE_ID )
            // InternalConcreteTestLanguage.g:606:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getInheritedParserRuleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInheritedParserRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInheritedParserRule"


    // $ANTLR start "entryRuleAbstractCallOverridenParserRule"
    // InternalConcreteTestLanguage.g:626:1: entryRuleAbstractCallOverridenParserRule returns [EObject current=null] : iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF ;
    public final EObject entryRuleAbstractCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractCallOverridenParserRule = null;


        try {
            // InternalConcreteTestLanguage.g:626:72: (iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF )
            // InternalConcreteTestLanguage.g:627:2: iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF
            {
             newCompositeNode(grammarAccess.getAbstractCallOverridenParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractCallOverridenParserRule=ruleAbstractCallOverridenParserRule();

            state._fsp--;

             current =iv_ruleAbstractCallOverridenParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleAbstractCallOverridenParserRule"


    // $ANTLR start "ruleAbstractCallOverridenParserRule"
    // InternalConcreteTestLanguage.g:633:1: ruleAbstractCallOverridenParserRule returns [EObject current=null] : (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* ) ;
    public final EObject ruleAbstractCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:639:2: ( (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* ) )
            // InternalConcreteTestLanguage.g:640:2: (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* )
            {
            // InternalConcreteTestLanguage.g:640:2: (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* )
            // InternalConcreteTestLanguage.g:641:3: otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )*
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getAbstractCallOverridenParserRuleAccess().getOverridemodelKeyword_0());
            		
            // InternalConcreteTestLanguage.g:645:3: ( (lv_elements_1_0= ruleOverridableParserRule ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalConcreteTestLanguage.g:646:4: (lv_elements_1_0= ruleOverridableParserRule )
            	    {
            	    // InternalConcreteTestLanguage.g:646:4: (lv_elements_1_0= ruleOverridableParserRule )
            	    // InternalConcreteTestLanguage.g:647:5: lv_elements_1_0= ruleOverridableParserRule
            	    {

            	    					newCompositeNode(grammarAccess.getAbstractCallOverridenParserRuleAccess().getElementsOverridableParserRuleParserRuleCall_1_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    lv_elements_1_0=ruleOverridableParserRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAbstractCallOverridenParserRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_1_0,
            	    						"org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage.OverridableParserRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractCallOverridenParserRule"


    // $ANTLR start "entryRuleAbstractCallExtendedParserRule"
    // InternalConcreteTestLanguage.g:668:1: entryRuleAbstractCallExtendedParserRule returns [EObject current=null] : iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF ;
    public final EObject entryRuleAbstractCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractCallExtendedParserRule = null;


        try {
            // InternalConcreteTestLanguage.g:668:71: (iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF )
            // InternalConcreteTestLanguage.g:669:2: iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF
            {
             newCompositeNode(grammarAccess.getAbstractCallExtendedParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractCallExtendedParserRule=ruleAbstractCallExtendedParserRule();

            state._fsp--;

             current =iv_ruleAbstractCallExtendedParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleAbstractCallExtendedParserRule"


    // $ANTLR start "ruleAbstractCallExtendedParserRule"
    // InternalConcreteTestLanguage.g:675:1: ruleAbstractCallExtendedParserRule returns [EObject current=null] : (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* ) ;
    public final EObject ruleAbstractCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalConcreteTestLanguage.g:681:2: ( (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* ) )
            // InternalConcreteTestLanguage.g:682:2: (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* )
            {
            // InternalConcreteTestLanguage.g:682:2: (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* )
            // InternalConcreteTestLanguage.g:683:3: otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )*
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getAbstractCallExtendedParserRuleAccess().getExtendedmodelKeyword_0());
            		
            // InternalConcreteTestLanguage.g:687:3: ( (lv_elements_1_0= ruleExtendableParserRule ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=18 && LA5_0<=19)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalConcreteTestLanguage.g:688:4: (lv_elements_1_0= ruleExtendableParserRule )
            	    {
            	    // InternalConcreteTestLanguage.g:688:4: (lv_elements_1_0= ruleExtendableParserRule )
            	    // InternalConcreteTestLanguage.g:689:5: lv_elements_1_0= ruleExtendableParserRule
            	    {

            	    					newCompositeNode(grammarAccess.getAbstractCallExtendedParserRuleAccess().getElementsExtendableParserRuleParserRuleCall_1_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_elements_1_0=ruleExtendableParserRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAbstractCallExtendedParserRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_1_0,
            	    						"org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage.ExtendableParserRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractCallExtendedParserRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000C0002L});
    }


}
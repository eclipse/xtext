package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug288734TestLanguageGrammarAccess;



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
public class InternalBug288734TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'constant'", "'string'", "'integer'", "'boolean'", "'@desc'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug288734TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug288734TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug288734TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug288734TestLanguage.g"; }



     	private Bug288734TestLanguageGrammarAccess grammarAccess;

        public InternalBug288734TestLanguageParser(TokenStream input, Bug288734TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected Bug288734TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalBug288734TestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug288734TestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalBug288734TestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalBug288734TestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_constants_0_0= ruleTConstant ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_constants_0_0 = null;



        	enterRule();

        try {
            // InternalBug288734TestLanguage.g:82:2: ( ( (lv_constants_0_0= ruleTConstant ) ) )
            // InternalBug288734TestLanguage.g:83:2: ( (lv_constants_0_0= ruleTConstant ) )
            {
            // InternalBug288734TestLanguage.g:83:2: ( (lv_constants_0_0= ruleTConstant ) )
            // InternalBug288734TestLanguage.g:84:3: (lv_constants_0_0= ruleTConstant )
            {
            // InternalBug288734TestLanguage.g:84:3: (lv_constants_0_0= ruleTConstant )
            // InternalBug288734TestLanguage.g:85:4: lv_constants_0_0= ruleTConstant
            {

            				newCompositeNode(grammarAccess.getModelAccess().getConstantsTConstantParserRuleCall_0());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_constants_0_0=ruleTConstant();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getModelRule());
            				}
            				add(
            					current,
            					"constants",
            					lv_constants_0_0,
            					"org.eclipse.xtext.ui.tests.editor.contentassist.Bug288734TestLanguage.TConstant");
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleTConstant"
    // InternalBug288734TestLanguage.g:105:1: entryRuleTConstant returns [EObject current=null] : iv_ruleTConstant= ruleTConstant EOF ;
    public final EObject entryRuleTConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTConstant = null;


        try {
            // InternalBug288734TestLanguage.g:105:50: (iv_ruleTConstant= ruleTConstant EOF )
            // InternalBug288734TestLanguage.g:106:2: iv_ruleTConstant= ruleTConstant EOF
            {
             newCompositeNode(grammarAccess.getTConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTConstant=ruleTConstant();

            state._fsp--;

             current =iv_ruleTConstant; 
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
    // $ANTLR end "entryRuleTConstant"


    // $ANTLR start "ruleTConstant"
    // InternalBug288734TestLanguage.g:112:1: ruleTConstant returns [EObject current=null] : (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant ) ;
    public final EObject ruleTConstant() throws RecognitionException {
        EObject current = null;

        EObject this_TStringConstant_0 = null;

        EObject this_TIntegerConstant_1 = null;

        EObject this_TBooleanConstant_2 = null;



        	enterRule();

        try {
            // InternalBug288734TestLanguage.g:118:2: ( (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant ) )
            // InternalBug288734TestLanguage.g:119:2: (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant )
            {
            // InternalBug288734TestLanguage.g:119:2: (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant )
            int alt1=3;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalBug288734TestLanguage.g:120:3: this_TStringConstant_0= ruleTStringConstant
                    {

                    			newCompositeNode(grammarAccess.getTConstantAccess().getTStringConstantParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TStringConstant_0=ruleTStringConstant();

                    state._fsp--;


                    			current = this_TStringConstant_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBug288734TestLanguage.g:129:3: this_TIntegerConstant_1= ruleTIntegerConstant
                    {

                    			newCompositeNode(grammarAccess.getTConstantAccess().getTIntegerConstantParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TIntegerConstant_1=ruleTIntegerConstant();

                    state._fsp--;


                    			current = this_TIntegerConstant_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalBug288734TestLanguage.g:138:3: this_TBooleanConstant_2= ruleTBooleanConstant
                    {

                    			newCompositeNode(grammarAccess.getTConstantAccess().getTBooleanConstantParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TBooleanConstant_2=ruleTBooleanConstant();

                    state._fsp--;


                    			current = this_TBooleanConstant_2;
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
    // $ANTLR end "ruleTConstant"


    // $ANTLR start "entryRuleTStringConstant"
    // InternalBug288734TestLanguage.g:150:1: entryRuleTStringConstant returns [EObject current=null] : iv_ruleTStringConstant= ruleTStringConstant EOF ;
    public final EObject entryRuleTStringConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTStringConstant = null;


        try {
            // InternalBug288734TestLanguage.g:150:56: (iv_ruleTStringConstant= ruleTStringConstant EOF )
            // InternalBug288734TestLanguage.g:151:2: iv_ruleTStringConstant= ruleTStringConstant EOF
            {
             newCompositeNode(grammarAccess.getTStringConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTStringConstant=ruleTStringConstant();

            state._fsp--;

             current =iv_ruleTStringConstant; 
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
    // $ANTLR end "entryRuleTStringConstant"


    // $ANTLR start "ruleTStringConstant"
    // InternalBug288734TestLanguage.g:157:1: ruleTStringConstant returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'string' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleTStringConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalBug288734TestLanguage.g:163:2: ( ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'string' ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalBug288734TestLanguage.g:164:2: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'string' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalBug288734TestLanguage.g:164:2: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'string' ( (lv_name_3_0= RULE_ID ) ) )
            // InternalBug288734TestLanguage.g:165:3: ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'string' ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalBug288734TestLanguage.g:165:3: ( (lv_annotations_0_0= ruleTAnnotation ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBug288734TestLanguage.g:166:4: (lv_annotations_0_0= ruleTAnnotation )
            	    {
            	    // InternalBug288734TestLanguage.g:166:4: (lv_annotations_0_0= ruleTAnnotation )
            	    // InternalBug288734TestLanguage.g:167:5: lv_annotations_0_0= ruleTAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getTStringConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_annotations_0_0=ruleTAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTStringConstantRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"org.eclipse.xtext.ui.tests.editor.contentassist.Bug288734TestLanguage.TAnnotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTStringConstantAccess().getConstantKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getTStringConstantAccess().getStringKeyword_2());
            		
            // InternalBug288734TestLanguage.g:192:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalBug288734TestLanguage.g:193:4: (lv_name_3_0= RULE_ID )
            {
            // InternalBug288734TestLanguage.g:193:4: (lv_name_3_0= RULE_ID )
            // InternalBug288734TestLanguage.g:194:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getTStringConstantAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTStringConstantRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleTStringConstant"


    // $ANTLR start "entryRuleTIntegerConstant"
    // InternalBug288734TestLanguage.g:214:1: entryRuleTIntegerConstant returns [EObject current=null] : iv_ruleTIntegerConstant= ruleTIntegerConstant EOF ;
    public final EObject entryRuleTIntegerConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTIntegerConstant = null;


        try {
            // InternalBug288734TestLanguage.g:214:57: (iv_ruleTIntegerConstant= ruleTIntegerConstant EOF )
            // InternalBug288734TestLanguage.g:215:2: iv_ruleTIntegerConstant= ruleTIntegerConstant EOF
            {
             newCompositeNode(grammarAccess.getTIntegerConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTIntegerConstant=ruleTIntegerConstant();

            state._fsp--;

             current =iv_ruleTIntegerConstant; 
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
    // $ANTLR end "entryRuleTIntegerConstant"


    // $ANTLR start "ruleTIntegerConstant"
    // InternalBug288734TestLanguage.g:221:1: ruleTIntegerConstant returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'integer' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleTIntegerConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalBug288734TestLanguage.g:227:2: ( ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'integer' ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalBug288734TestLanguage.g:228:2: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'integer' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalBug288734TestLanguage.g:228:2: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'integer' ( (lv_name_3_0= RULE_ID ) ) )
            // InternalBug288734TestLanguage.g:229:3: ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'integer' ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalBug288734TestLanguage.g:229:3: ( (lv_annotations_0_0= ruleTAnnotation ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug288734TestLanguage.g:230:4: (lv_annotations_0_0= ruleTAnnotation )
            	    {
            	    // InternalBug288734TestLanguage.g:230:4: (lv_annotations_0_0= ruleTAnnotation )
            	    // InternalBug288734TestLanguage.g:231:5: lv_annotations_0_0= ruleTAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getTIntegerConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_annotations_0_0=ruleTAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTIntegerConstantRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"org.eclipse.xtext.ui.tests.editor.contentassist.Bug288734TestLanguage.TAnnotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getTIntegerConstantAccess().getConstantKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getTIntegerConstantAccess().getIntegerKeyword_2());
            		
            // InternalBug288734TestLanguage.g:256:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalBug288734TestLanguage.g:257:4: (lv_name_3_0= RULE_ID )
            {
            // InternalBug288734TestLanguage.g:257:4: (lv_name_3_0= RULE_ID )
            // InternalBug288734TestLanguage.g:258:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getTIntegerConstantAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTIntegerConstantRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleTIntegerConstant"


    // $ANTLR start "entryRuleTBooleanConstant"
    // InternalBug288734TestLanguage.g:278:1: entryRuleTBooleanConstant returns [EObject current=null] : iv_ruleTBooleanConstant= ruleTBooleanConstant EOF ;
    public final EObject entryRuleTBooleanConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTBooleanConstant = null;


        try {
            // InternalBug288734TestLanguage.g:278:57: (iv_ruleTBooleanConstant= ruleTBooleanConstant EOF )
            // InternalBug288734TestLanguage.g:279:2: iv_ruleTBooleanConstant= ruleTBooleanConstant EOF
            {
             newCompositeNode(grammarAccess.getTBooleanConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTBooleanConstant=ruleTBooleanConstant();

            state._fsp--;

             current =iv_ruleTBooleanConstant; 
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
    // $ANTLR end "entryRuleTBooleanConstant"


    // $ANTLR start "ruleTBooleanConstant"
    // InternalBug288734TestLanguage.g:285:1: ruleTBooleanConstant returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'boolean' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleTBooleanConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalBug288734TestLanguage.g:291:2: ( ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'boolean' ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalBug288734TestLanguage.g:292:2: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'boolean' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalBug288734TestLanguage.g:292:2: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'boolean' ( (lv_name_3_0= RULE_ID ) ) )
            // InternalBug288734TestLanguage.g:293:3: ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'boolean' ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalBug288734TestLanguage.g:293:3: ( (lv_annotations_0_0= ruleTAnnotation ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalBug288734TestLanguage.g:294:4: (lv_annotations_0_0= ruleTAnnotation )
            	    {
            	    // InternalBug288734TestLanguage.g:294:4: (lv_annotations_0_0= ruleTAnnotation )
            	    // InternalBug288734TestLanguage.g:295:5: lv_annotations_0_0= ruleTAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getTBooleanConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_annotations_0_0=ruleTAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTBooleanConstantRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"org.eclipse.xtext.ui.tests.editor.contentassist.Bug288734TestLanguage.TAnnotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getTBooleanConstantAccess().getConstantKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getTBooleanConstantAccess().getBooleanKeyword_2());
            		
            // InternalBug288734TestLanguage.g:320:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalBug288734TestLanguage.g:321:4: (lv_name_3_0= RULE_ID )
            {
            // InternalBug288734TestLanguage.g:321:4: (lv_name_3_0= RULE_ID )
            // InternalBug288734TestLanguage.g:322:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getTBooleanConstantAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTBooleanConstantRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleTBooleanConstant"


    // $ANTLR start "entryRuleTAnnotation"
    // InternalBug288734TestLanguage.g:342:1: entryRuleTAnnotation returns [EObject current=null] : iv_ruleTAnnotation= ruleTAnnotation EOF ;
    public final EObject entryRuleTAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTAnnotation = null;


        try {
            // InternalBug288734TestLanguage.g:342:52: (iv_ruleTAnnotation= ruleTAnnotation EOF )
            // InternalBug288734TestLanguage.g:343:2: iv_ruleTAnnotation= ruleTAnnotation EOF
            {
             newCompositeNode(grammarAccess.getTAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTAnnotation=ruleTAnnotation();

            state._fsp--;

             current =iv_ruleTAnnotation; 
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
    // $ANTLR end "entryRuleTAnnotation"


    // $ANTLR start "ruleTAnnotation"
    // InternalBug288734TestLanguage.g:349:1: ruleTAnnotation returns [EObject current=null] : (otherlv_0= '@desc' ( (lv_description_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleTAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_description_1_0=null;


        	enterRule();

        try {
            // InternalBug288734TestLanguage.g:355:2: ( (otherlv_0= '@desc' ( (lv_description_1_0= RULE_STRING ) ) ) )
            // InternalBug288734TestLanguage.g:356:2: (otherlv_0= '@desc' ( (lv_description_1_0= RULE_STRING ) ) )
            {
            // InternalBug288734TestLanguage.g:356:2: (otherlv_0= '@desc' ( (lv_description_1_0= RULE_STRING ) ) )
            // InternalBug288734TestLanguage.g:357:3: otherlv_0= '@desc' ( (lv_description_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getTAnnotationAccess().getDescKeyword_0());
            		
            // InternalBug288734TestLanguage.g:361:3: ( (lv_description_1_0= RULE_STRING ) )
            // InternalBug288734TestLanguage.g:362:4: (lv_description_1_0= RULE_STRING )
            {
            // InternalBug288734TestLanguage.g:362:4: (lv_description_1_0= RULE_STRING )
            // InternalBug288734TestLanguage.g:363:5: lv_description_1_0= RULE_STRING
            {
            lv_description_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_description_1_0, grammarAccess.getTAnnotationAccess().getDescriptionSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTAnnotationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_1_0,
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
    // $ANTLR end "ruleTAnnotation"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\13\1\5\1\14\1\13\3\uffff";
    static final String dfa_3s = "\1\17\1\5\1\16\1\17\3\uffff";
    static final String dfa_4s = "\4\uffff\1\3\1\2\1\1";
    static final String dfa_5s = "\7\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\3\uffff\1\1",
            "\1\3",
            "\1\6\1\5\1\4",
            "\1\2\3\uffff\1\1",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "119:2: (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008800L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    }


}
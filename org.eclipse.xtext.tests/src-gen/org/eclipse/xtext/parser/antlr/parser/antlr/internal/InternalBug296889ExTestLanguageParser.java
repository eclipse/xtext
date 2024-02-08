package org.eclipse.xtext.parser.antlr.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.services.Bug296889ExTestLanguageGrammarAccess;



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
public class InternalBug296889ExTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Model'", "'DataType'", "'--'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug296889ExTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug296889ExTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug296889ExTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug296889ExTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private Bug296889ExTestLanguageGrammarAccess grammarAccess;

        public InternalBug296889ExTestLanguageParser(TokenStream input, Bug296889ExTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected Bug296889ExTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalBug296889ExTestLanguage.g:75:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug296889ExTestLanguage.g:75:46: (iv_ruleModel= ruleModel EOF )
            // InternalBug296889ExTestLanguage.g:76:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalBug296889ExTestLanguage.g:82:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;

        AntlrDatatypeRuleToken lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalBug296889ExTestLanguage.g:88:2: ( ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) ) )
            // InternalBug296889ExTestLanguage.g:89:2: ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )
            {
            // InternalBug296889ExTestLanguage.g:89:2: ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
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
                    // InternalBug296889ExTestLanguage.g:90:3: (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* )
                    {
                    // InternalBug296889ExTestLanguage.g:90:3: (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* )
                    // InternalBug296889ExTestLanguage.g:91:4: otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )*
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getModelAccess().getModelKeyword_0_0());
                      			
                    }
                    // InternalBug296889ExTestLanguage.g:95:4: ( (lv_expressions_1_0= ruleExpression ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_ID||LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalBug296889ExTestLanguage.g:96:5: (lv_expressions_1_0= ruleExpression )
                    	    {
                    	    // InternalBug296889ExTestLanguage.g:96:5: (lv_expressions_1_0= ruleExpression )
                    	    // InternalBug296889ExTestLanguage.g:97:6: lv_expressions_1_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getModelAccess().getExpressionsExpressionParserRuleCall_0_1_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_expressions_1_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getModelRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"expressions",
                    	      							lv_expressions_1_0,
                    	      							"org.eclipse.xtext.parser.antlr.Bug296889ExTestLanguage.Expression");
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


                    }
                    break;
                case 2 :
                    // InternalBug296889ExTestLanguage.g:116:3: (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* )
                    {
                    // InternalBug296889ExTestLanguage.g:116:3: (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* )
                    // InternalBug296889ExTestLanguage.g:117:4: otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )*
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getDataTypeKeyword_1_0());
                      			
                    }
                    // InternalBug296889ExTestLanguage.g:121:4: ( (lv_values_3_0= ruleDataTypeExpression ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID||LA2_0==13) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalBug296889ExTestLanguage.g:122:5: (lv_values_3_0= ruleDataTypeExpression )
                    	    {
                    	    // InternalBug296889ExTestLanguage.g:122:5: (lv_values_3_0= ruleDataTypeExpression )
                    	    // InternalBug296889ExTestLanguage.g:123:6: lv_values_3_0= ruleDataTypeExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getModelAccess().getValuesDataTypeExpressionParserRuleCall_1_1_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_values_3_0=ruleDataTypeExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getModelRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"values",
                    	      							lv_values_3_0,
                    	      							"org.eclipse.xtext.parser.antlr.Bug296889ExTestLanguage.DataTypeExpression");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleExpression"
    // InternalBug296889ExTestLanguage.g:145:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalBug296889ExTestLanguage.g:145:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalBug296889ExTestLanguage.g:146:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalBug296889ExTestLanguage.g:152:1: ruleExpression returns [EObject current=null] : (this_Postop_0= rulePostop | this_Preop_1= rulePreop ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Postop_0 = null;

        EObject this_Preop_1 = null;



        	enterRule();

        try {
            // InternalBug296889ExTestLanguage.g:158:2: ( (this_Postop_0= rulePostop | this_Preop_1= rulePreop ) )
            // InternalBug296889ExTestLanguage.g:159:2: (this_Postop_0= rulePostop | this_Preop_1= rulePreop )
            {
            // InternalBug296889ExTestLanguage.g:159:2: (this_Postop_0= rulePostop | this_Preop_1= rulePreop )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==13) ) {
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
                    // InternalBug296889ExTestLanguage.g:160:3: this_Postop_0= rulePostop
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getPostopParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Postop_0=rulePostop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Postop_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBug296889ExTestLanguage.g:172:3: this_Preop_1= rulePreop
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getPreopParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Preop_1=rulePreop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Preop_1;
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRulePreop"
    // InternalBug296889ExTestLanguage.g:187:1: entryRulePreop returns [EObject current=null] : iv_rulePreop= rulePreop EOF ;
    public final EObject entryRulePreop() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreop = null;


        try {
            // InternalBug296889ExTestLanguage.g:187:46: (iv_rulePreop= rulePreop EOF )
            // InternalBug296889ExTestLanguage.g:188:2: iv_rulePreop= rulePreop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPreopRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePreop=rulePreop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePreop; 
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
    // $ANTLR end "entryRulePreop"


    // $ANTLR start "rulePreop"
    // InternalBug296889ExTestLanguage.g:194:1: rulePreop returns [EObject current=null] : ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) ) ;
    public final EObject rulePreop() throws RecognitionException {
        EObject current = null;

        Token lv_functionName_1_0=null;
        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            // InternalBug296889ExTestLanguage.g:200:2: ( ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) ) )
            // InternalBug296889ExTestLanguage.g:201:2: ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) )
            {
            // InternalBug296889ExTestLanguage.g:201:2: ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) )
            // InternalBug296889ExTestLanguage.g:202:3: () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) )
            {
            // InternalBug296889ExTestLanguage.g:202:3: ()
            // InternalBug296889ExTestLanguage.g:203:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPreopAccess().getPreopAction_0(),
              					current);
              			
            }

            }

            // InternalBug296889ExTestLanguage.g:212:3: ( (lv_functionName_1_0= '--' ) )
            // InternalBug296889ExTestLanguage.g:213:4: (lv_functionName_1_0= '--' )
            {
            // InternalBug296889ExTestLanguage.g:213:4: (lv_functionName_1_0= '--' )
            // InternalBug296889ExTestLanguage.g:214:5: lv_functionName_1_0= '--'
            {
            lv_functionName_1_0=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_functionName_1_0, grammarAccess.getPreopAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPreopRule());
              					}
              					setWithLastConsumed(current, "functionName", lv_functionName_1_0, "--");
              				
            }

            }


            }

            // InternalBug296889ExTestLanguage.g:226:3: ( (lv_expr_2_0= ruleVariable ) )
            // InternalBug296889ExTestLanguage.g:227:4: (lv_expr_2_0= ruleVariable )
            {
            // InternalBug296889ExTestLanguage.g:227:4: (lv_expr_2_0= ruleVariable )
            // InternalBug296889ExTestLanguage.g:228:5: lv_expr_2_0= ruleVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPreopAccess().getExprVariableParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_2_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPreopRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"org.eclipse.xtext.parser.antlr.Bug296889ExTestLanguage.Variable");
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
    // $ANTLR end "rulePreop"


    // $ANTLR start "entryRulePostop"
    // InternalBug296889ExTestLanguage.g:249:1: entryRulePostop returns [EObject current=null] : iv_rulePostop= rulePostop EOF ;
    public final EObject entryRulePostop() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostop = null;


        try {
            // InternalBug296889ExTestLanguage.g:249:47: (iv_rulePostop= rulePostop EOF )
            // InternalBug296889ExTestLanguage.g:250:2: iv_rulePostop= rulePostop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostopRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePostop=rulePostop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostop; 
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
    // $ANTLR end "entryRulePostop"


    // $ANTLR start "rulePostop"
    // InternalBug296889ExTestLanguage.g:256:1: rulePostop returns [EObject current=null] : (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? ) ;
    public final EObject rulePostop() throws RecognitionException {
        EObject current = null;

        Token lv_functionName_2_0=null;
        EObject this_Variable_0 = null;



        	enterRule();

        try {
            // InternalBug296889ExTestLanguage.g:262:2: ( (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? ) )
            // InternalBug296889ExTestLanguage.g:263:2: (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? )
            {
            // InternalBug296889ExTestLanguage.g:263:2: (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? )
            // InternalBug296889ExTestLanguage.g:264:3: this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPostopAccess().getVariableParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_5);
            this_Variable_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Variable_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBug296889ExTestLanguage.g:275:3: ( () ( (lv_functionName_2_0= '--' ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==EOF||LA5_1==13) ) {
                    alt5=1;
                }
                else if ( (LA5_1==RULE_ID) ) {
                    int LA5_4 = input.LA(3);

                    if ( (synpred5_InternalBug296889ExTestLanguage()) ) {
                        alt5=1;
                    }
                }
            }
            switch (alt5) {
                case 1 :
                    // InternalBug296889ExTestLanguage.g:276:4: () ( (lv_functionName_2_0= '--' ) )
                    {
                    // InternalBug296889ExTestLanguage.g:276:4: ()
                    // InternalBug296889ExTestLanguage.g:277:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getPostopAccess().getPostopExprAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalBug296889ExTestLanguage.g:286:4: ( (lv_functionName_2_0= '--' ) )
                    // InternalBug296889ExTestLanguage.g:287:5: (lv_functionName_2_0= '--' )
                    {
                    // InternalBug296889ExTestLanguage.g:287:5: (lv_functionName_2_0= '--' )
                    // InternalBug296889ExTestLanguage.g:288:6: lv_functionName_2_0= '--'
                    {
                    lv_functionName_2_0=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_functionName_2_0, grammarAccess.getPostopAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPostopRule());
                      						}
                      						setWithLastConsumed(current, "functionName", lv_functionName_2_0, "--");
                      					
                    }

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "rulePostop"


    // $ANTLR start "entryRuleVariable"
    // InternalBug296889ExTestLanguage.g:305:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalBug296889ExTestLanguage.g:305:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalBug296889ExTestLanguage.g:306:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
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
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalBug296889ExTestLanguage.g:312:1: ruleVariable returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalBug296889ExTestLanguage.g:318:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalBug296889ExTestLanguage.g:319:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalBug296889ExTestLanguage.g:319:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalBug296889ExTestLanguage.g:320:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalBug296889ExTestLanguage.g:320:3: ()
            // InternalBug296889ExTestLanguage.g:321:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableAccess().getVariableAction_0(),
              					current);
              			
            }

            }

            // InternalBug296889ExTestLanguage.g:330:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalBug296889ExTestLanguage.g:331:4: (lv_name_1_0= RULE_ID )
            {
            // InternalBug296889ExTestLanguage.g:331:4: (lv_name_1_0= RULE_ID )
            // InternalBug296889ExTestLanguage.g:332:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
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
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleDataTypeExpression"
    // InternalBug296889ExTestLanguage.g:352:1: entryRuleDataTypeExpression returns [String current=null] : iv_ruleDataTypeExpression= ruleDataTypeExpression EOF ;
    public final String entryRuleDataTypeExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeExpression = null;


        try {
            // InternalBug296889ExTestLanguage.g:352:58: (iv_ruleDataTypeExpression= ruleDataTypeExpression EOF )
            // InternalBug296889ExTestLanguage.g:353:2: iv_ruleDataTypeExpression= ruleDataTypeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypeExpression=ruleDataTypeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeExpression.getText(); 
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
    // $ANTLR end "entryRuleDataTypeExpression"


    // $ANTLR start "ruleDataTypeExpression"
    // InternalBug296889ExTestLanguage.g:359:1: ruleDataTypeExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop ) ;
    public final AntlrDatatypeRuleToken ruleDataTypeExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_DataTypePostop_0 = null;

        AntlrDatatypeRuleToken this_DataTypePreop_1 = null;



        	enterRule();

        try {
            // InternalBug296889ExTestLanguage.g:365:2: ( (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop ) )
            // InternalBug296889ExTestLanguage.g:366:2: (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop )
            {
            // InternalBug296889ExTestLanguage.g:366:2: (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==13) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBug296889ExTestLanguage.g:367:3: this_DataTypePostop_0= ruleDataTypePostop
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataTypeExpressionAccess().getDataTypePostopParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DataTypePostop_0=ruleDataTypePostop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_DataTypePostop_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBug296889ExTestLanguage.g:378:3: this_DataTypePreop_1= ruleDataTypePreop
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataTypeExpressionAccess().getDataTypePreopParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DataTypePreop_1=ruleDataTypePreop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_DataTypePreop_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleDataTypeExpression"


    // $ANTLR start "entryRuleDataTypePreop"
    // InternalBug296889ExTestLanguage.g:392:1: entryRuleDataTypePreop returns [String current=null] : iv_ruleDataTypePreop= ruleDataTypePreop EOF ;
    public final String entryRuleDataTypePreop() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypePreop = null;


        try {
            // InternalBug296889ExTestLanguage.g:392:53: (iv_ruleDataTypePreop= ruleDataTypePreop EOF )
            // InternalBug296889ExTestLanguage.g:393:2: iv_ruleDataTypePreop= ruleDataTypePreop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypePreopRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypePreop=ruleDataTypePreop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypePreop.getText(); 
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
    // $ANTLR end "entryRuleDataTypePreop"


    // $ANTLR start "ruleDataTypePreop"
    // InternalBug296889ExTestLanguage.g:399:1: ruleDataTypePreop returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '--' this_DataTypeVariable_1= ruleDataTypeVariable ) ;
    public final AntlrDatatypeRuleToken ruleDataTypePreop() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_DataTypeVariable_1 = null;



        	enterRule();

        try {
            // InternalBug296889ExTestLanguage.g:405:2: ( (kw= '--' this_DataTypeVariable_1= ruleDataTypeVariable ) )
            // InternalBug296889ExTestLanguage.g:406:2: (kw= '--' this_DataTypeVariable_1= ruleDataTypeVariable )
            {
            // InternalBug296889ExTestLanguage.g:406:2: (kw= '--' this_DataTypeVariable_1= ruleDataTypeVariable )
            // InternalBug296889ExTestLanguage.g:407:3: kw= '--' this_DataTypeVariable_1= ruleDataTypeVariable
            {
            kw=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getDataTypePreopAccess().getHyphenMinusHyphenMinusKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getDataTypePreopAccess().getDataTypeVariableParserRuleCall_1());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_DataTypeVariable_1=ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_DataTypeVariable_1);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
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
    // $ANTLR end "ruleDataTypePreop"


    // $ANTLR start "entryRuleDataTypePostop"
    // InternalBug296889ExTestLanguage.g:426:1: entryRuleDataTypePostop returns [String current=null] : iv_ruleDataTypePostop= ruleDataTypePostop EOF ;
    public final String entryRuleDataTypePostop() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypePostop = null;


        try {
            // InternalBug296889ExTestLanguage.g:426:54: (iv_ruleDataTypePostop= ruleDataTypePostop EOF )
            // InternalBug296889ExTestLanguage.g:427:2: iv_ruleDataTypePostop= ruleDataTypePostop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypePostopRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypePostop=ruleDataTypePostop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypePostop.getText(); 
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
    // $ANTLR end "entryRuleDataTypePostop"


    // $ANTLR start "ruleDataTypePostop"
    // InternalBug296889ExTestLanguage.g:433:1: ruleDataTypePostop returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DataTypeVariable_0= ruleDataTypeVariable (kw= '--' )? ) ;
    public final AntlrDatatypeRuleToken ruleDataTypePostop() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_DataTypeVariable_0 = null;



        	enterRule();

        try {
            // InternalBug296889ExTestLanguage.g:439:2: ( (this_DataTypeVariable_0= ruleDataTypeVariable (kw= '--' )? ) )
            // InternalBug296889ExTestLanguage.g:440:2: (this_DataTypeVariable_0= ruleDataTypeVariable (kw= '--' )? )
            {
            // InternalBug296889ExTestLanguage.g:440:2: (this_DataTypeVariable_0= ruleDataTypeVariable (kw= '--' )? )
            // InternalBug296889ExTestLanguage.g:441:3: this_DataTypeVariable_0= ruleDataTypeVariable (kw= '--' )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getDataTypePostopAccess().getDataTypeVariableParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_5);
            this_DataTypeVariable_0=ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_DataTypeVariable_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBug296889ExTestLanguage.g:451:3: (kw= '--' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID) ) {
                    int LA7_3 = input.LA(3);

                    if ( (synpred7_InternalBug296889ExTestLanguage()) ) {
                        alt7=1;
                    }
                }
                else if ( (LA7_1==EOF||LA7_1==13) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalBug296889ExTestLanguage.g:452:4: kw= '--'
                    {
                    kw=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getDataTypePostopAccess().getHyphenMinusHyphenMinusKeyword_1());
                      			
                    }

                    }
                    break;

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
    // $ANTLR end "ruleDataTypePostop"


    // $ANTLR start "entryRuleDataTypeVariable"
    // InternalBug296889ExTestLanguage.g:462:1: entryRuleDataTypeVariable returns [String current=null] : iv_ruleDataTypeVariable= ruleDataTypeVariable EOF ;
    public final String entryRuleDataTypeVariable() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeVariable = null;


        try {
            // InternalBug296889ExTestLanguage.g:462:56: (iv_ruleDataTypeVariable= ruleDataTypeVariable EOF )
            // InternalBug296889ExTestLanguage.g:463:2: iv_ruleDataTypeVariable= ruleDataTypeVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeVariableRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypeVariable=ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeVariable.getText(); 
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
    // $ANTLR end "entryRuleDataTypeVariable"


    // $ANTLR start "ruleDataTypeVariable"
    // InternalBug296889ExTestLanguage.g:469:1: ruleDataTypeVariable returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleDataTypeVariable() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalBug296889ExTestLanguage.g:475:2: (this_ID_0= RULE_ID )
            // InternalBug296889ExTestLanguage.g:476:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_ID_0, grammarAccess.getDataTypeVariableAccess().getIDTerminalRuleCall());
              	
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
    // $ANTLR end "ruleDataTypeVariable"

    // $ANTLR start synpred5_InternalBug296889ExTestLanguage
    public final void synpred5_InternalBug296889ExTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_0=null;

        // InternalBug296889ExTestLanguage.g:276:4: ( () ( (lv_functionName_2_0= '--' ) ) )
        // InternalBug296889ExTestLanguage.g:276:4: () ( (lv_functionName_2_0= '--' ) )
        {
        // InternalBug296889ExTestLanguage.g:276:4: ()
        // InternalBug296889ExTestLanguage.g:277:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalBug296889ExTestLanguage.g:286:4: ( (lv_functionName_2_0= '--' ) )
        // InternalBug296889ExTestLanguage.g:287:5: (lv_functionName_2_0= '--' )
        {
        // InternalBug296889ExTestLanguage.g:287:5: (lv_functionName_2_0= '--' )
        // InternalBug296889ExTestLanguage.g:288:6: lv_functionName_2_0= '--'
        {
        lv_functionName_2_0=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred5_InternalBug296889ExTestLanguage

    // $ANTLR start synpred7_InternalBug296889ExTestLanguage
    public final void synpred7_InternalBug296889ExTestLanguage_fragment() throws RecognitionException {   
        Token kw=null;

        // InternalBug296889ExTestLanguage.g:452:4: (kw= '--' )
        // InternalBug296889ExTestLanguage.g:452:4: kw= '--'
        {
        kw=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalBug296889ExTestLanguage

    // Delegated rules

    public final boolean synpred5_InternalBug296889ExTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalBug296889ExTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalBug296889ExTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalBug296889ExTestLanguage_fragment(); // can never throw exception
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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
    }


}
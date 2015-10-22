package org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.services.Bug296889TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalBug296889TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Model'", "'DataType'", "'--'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalBug296889TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug296889TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug296889TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBug296889TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

    	protected Bug296889TestLanguageGrammarAccess grammarAccess;

    	protected Bug296889TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug296889TestLanguageParser(PsiBuilder builder, TokenStream input, Bug296889TestLanguageElementTypeProvider elementTypeProvider, Bug296889TestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalBug296889TestLanguage.g:58:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalBug296889TestLanguage.g:58:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBug296889TestLanguage.g:59:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
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
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalBug296889TestLanguage.g:65:1: ruleModel returns [Boolean current=false] : ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean lv_expressions_1_0 = null;

        Boolean lv_values_3_0 = null;


        try {
            // PsiInternalBug296889TestLanguage.g:66:1: ( ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) ) )
            // PsiInternalBug296889TestLanguage.g:67:2: ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )
            {
            // PsiInternalBug296889TestLanguage.g:67:2: ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )
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
                    // PsiInternalBug296889TestLanguage.g:68:3: (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* )
                    {
                    // PsiInternalBug296889TestLanguage.g:68:3: (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* )
                    // PsiInternalBug296889TestLanguage.g:69:4: otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getModel_ModelKeyword_0_0ElementType());
                      			
                    }
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0);
                      			
                    }
                    // PsiInternalBug296889TestLanguage.g:76:4: ( (lv_expressions_1_0= ruleExpression ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_ID||LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // PsiInternalBug296889TestLanguage.g:77:5: (lv_expressions_1_0= ruleExpression )
                    	    {
                    	    // PsiInternalBug296889TestLanguage.g:77:5: (lv_expressions_1_0= ruleExpression )
                    	    // PsiInternalBug296889TestLanguage.g:78:6: lv_expressions_1_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						markComposite(elementTypeProvider.getModel_ExpressionsExpressionParserRuleCall_0_1_0ElementType());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_expressions_1_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						doneComposite();
                    	      						if(!current) {
                    	      							associateWithSemanticElement();
                    	      							current = true;
                    	      						}
                    	      					
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
                    // PsiInternalBug296889TestLanguage.g:93:3: (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* )
                    {
                    // PsiInternalBug296889TestLanguage.g:93:3: (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* )
                    // PsiInternalBug296889TestLanguage.g:94:4: otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getModel_DataTypeKeyword_1_0ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }
                    // PsiInternalBug296889TestLanguage.g:101:4: ( (lv_values_3_0= ruleDataTypeExpression ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID||LA2_0==13) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // PsiInternalBug296889TestLanguage.g:102:5: (lv_values_3_0= ruleDataTypeExpression )
                    	    {
                    	    // PsiInternalBug296889TestLanguage.g:102:5: (lv_values_3_0= ruleDataTypeExpression )
                    	    // PsiInternalBug296889TestLanguage.g:103:6: lv_values_3_0= ruleDataTypeExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						markComposite(elementTypeProvider.getModel_ValuesDataTypeExpressionParserRuleCall_1_1_0ElementType());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_values_3_0=ruleDataTypeExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						doneComposite();
                    	      						if(!current) {
                    	      							associateWithSemanticElement();
                    	      							current = true;
                    	      						}
                    	      					
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleExpression"
    // PsiInternalBug296889TestLanguage.g:121:1: entryRuleExpression returns [Boolean current=false] : iv_ruleExpression= ruleExpression EOF ;
    public final Boolean entryRuleExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExpression = null;


        try {
            // PsiInternalBug296889TestLanguage.g:121:52: (iv_ruleExpression= ruleExpression EOF )
            // PsiInternalBug296889TestLanguage.g:122:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExpressionElementType()); 
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
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // PsiInternalBug296889TestLanguage.g:128:1: ruleExpression returns [Boolean current=false] : (this_Postop_0= rulePostop | this_Preop_1= rulePreop ) ;
    public final Boolean ruleExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_Postop_0 = null;

        Boolean this_Preop_1 = null;


        try {
            // PsiInternalBug296889TestLanguage.g:129:1: ( (this_Postop_0= rulePostop | this_Preop_1= rulePreop ) )
            // PsiInternalBug296889TestLanguage.g:130:2: (this_Postop_0= rulePostop | this_Preop_1= rulePreop )
            {
            // PsiInternalBug296889TestLanguage.g:130:2: (this_Postop_0= rulePostop | this_Preop_1= rulePreop )
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
                    // PsiInternalBug296889TestLanguage.g:131:3: this_Postop_0= rulePostop
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getExpression_PostopParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Postop_0=rulePostop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Postop_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBug296889TestLanguage.g:143:3: this_Preop_1= rulePreop
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getExpression_PreopParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Preop_1=rulePreop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Preop_1;
                      			doneComposite();
                      		
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRulePreop"
    // PsiInternalBug296889TestLanguage.g:158:1: entryRulePreop returns [Boolean current=false] : iv_rulePreop= rulePreop EOF ;
    public final Boolean entryRulePreop() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePreop = null;


        try {
            // PsiInternalBug296889TestLanguage.g:158:47: (iv_rulePreop= rulePreop EOF )
            // PsiInternalBug296889TestLanguage.g:159:2: iv_rulePreop= rulePreop EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPreopElementType()); 
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
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePreop"


    // $ANTLR start "rulePreop"
    // PsiInternalBug296889TestLanguage.g:165:1: rulePreop returns [Boolean current=false] : ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) ) ;
    public final Boolean rulePreop() throws RecognitionException {
        Boolean current = false;

        Token lv_functionName_1_0=null;
        Boolean lv_expr_2_0 = null;


        try {
            // PsiInternalBug296889TestLanguage.g:166:1: ( ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) ) )
            // PsiInternalBug296889TestLanguage.g:167:2: ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) )
            {
            // PsiInternalBug296889TestLanguage.g:167:2: ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) )
            // PsiInternalBug296889TestLanguage.g:168:3: () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) )
            {
            // PsiInternalBug296889TestLanguage.g:168:3: ()
            // PsiInternalBug296889TestLanguage.g:169:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getPreop_PreopAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBug296889TestLanguage.g:178:3: ( (lv_functionName_1_0= '--' ) )
            // PsiInternalBug296889TestLanguage.g:179:4: (lv_functionName_1_0= '--' )
            {
            // PsiInternalBug296889TestLanguage.g:179:4: (lv_functionName_1_0= '--' )
            // PsiInternalBug296889TestLanguage.g:180:5: lv_functionName_1_0= '--'
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getPreop_FunctionNameHyphenMinusHyphenMinusKeyword_1_0ElementType());
              				
            }
            lv_functionName_1_0=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_functionName_1_0);
              				
            }
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalBug296889TestLanguage.g:195:3: ( (lv_expr_2_0= ruleVariable ) )
            // PsiInternalBug296889TestLanguage.g:196:4: (lv_expr_2_0= ruleVariable )
            {
            // PsiInternalBug296889TestLanguage.g:196:4: (lv_expr_2_0= ruleVariable )
            // PsiInternalBug296889TestLanguage.g:197:5: lv_expr_2_0= ruleVariable
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getPreop_ExprVariableParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_2_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePreop"


    // $ANTLR start "entryRulePostop"
    // PsiInternalBug296889TestLanguage.g:214:1: entryRulePostop returns [Boolean current=false] : iv_rulePostop= rulePostop EOF ;
    public final Boolean entryRulePostop() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePostop = null;


        try {
            // PsiInternalBug296889TestLanguage.g:214:48: (iv_rulePostop= rulePostop EOF )
            // PsiInternalBug296889TestLanguage.g:215:2: iv_rulePostop= rulePostop EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPostopElementType()); 
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
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostop"


    // $ANTLR start "rulePostop"
    // PsiInternalBug296889TestLanguage.g:221:1: rulePostop returns [Boolean current=false] : (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? ) ;
    public final Boolean rulePostop() throws RecognitionException {
        Boolean current = false;

        Token lv_functionName_2_0=null;
        Boolean this_Variable_0 = null;


        try {
            // PsiInternalBug296889TestLanguage.g:222:1: ( (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? ) )
            // PsiInternalBug296889TestLanguage.g:223:2: (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? )
            {
            // PsiInternalBug296889TestLanguage.g:223:2: (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? )
            // PsiInternalBug296889TestLanguage.g:224:3: this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getPostop_VariableParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_5);
            this_Variable_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Variable_0;
              			doneComposite();
              		
            }
            // PsiInternalBug296889TestLanguage.g:235:3: ( () ( (lv_functionName_2_0= '--' ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_ID) ) {
                    int LA5_3 = input.LA(3);

                    if ( (synpred5_PsiInternalBug296889TestLanguage()) ) {
                        alt5=1;
                    }
                }
                else if ( (LA5_1==EOF||LA5_1==13) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalBug296889TestLanguage.g:236:4: () ( (lv_functionName_2_0= '--' ) )
                    {
                    // PsiInternalBug296889TestLanguage.g:236:4: ()
                    // PsiInternalBug296889TestLanguage.g:237:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getPostop_PostopExprAction_1_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalBug296889TestLanguage.g:246:4: ( (lv_functionName_2_0= '--' ) )
                    // PsiInternalBug296889TestLanguage.g:247:5: (lv_functionName_2_0= '--' )
                    {
                    // PsiInternalBug296889TestLanguage.g:247:5: (lv_functionName_2_0= '--' )
                    // PsiInternalBug296889TestLanguage.g:248:6: lv_functionName_2_0= '--'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPostop_FunctionNameHyphenMinusHyphenMinusKeyword_1_1_0ElementType());
                      					
                    }
                    lv_functionName_2_0=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_2_0);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

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
    // $ANTLR end "rulePostop"


    // $ANTLR start "entryRuleVariable"
    // PsiInternalBug296889TestLanguage.g:268:1: entryRuleVariable returns [Boolean current=false] : iv_ruleVariable= ruleVariable EOF ;
    public final Boolean entryRuleVariable() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleVariable = null;


        try {
            // PsiInternalBug296889TestLanguage.g:268:50: (iv_ruleVariable= ruleVariable EOF )
            // PsiInternalBug296889TestLanguage.g:269:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getVariableElementType()); 
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
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // PsiInternalBug296889TestLanguage.g:275:1: ruleVariable returns [Boolean current=false] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleVariable() throws RecognitionException {
        Boolean current = false;

        Token lv_name_1_0=null;

        try {
            // PsiInternalBug296889TestLanguage.g:276:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalBug296889TestLanguage.g:277:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalBug296889TestLanguage.g:277:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalBug296889TestLanguage.g:278:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalBug296889TestLanguage.g:278:3: ()
            // PsiInternalBug296889TestLanguage.g:279:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getVariable_VariableAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBug296889TestLanguage.g:288:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBug296889TestLanguage.g:289:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBug296889TestLanguage.g:289:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBug296889TestLanguage.g:290:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getVariable_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_1_0);
              				
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
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleDataTypeExpression"
    // PsiInternalBug296889TestLanguage.g:309:1: entryRuleDataTypeExpression returns [Boolean current=false] : iv_ruleDataTypeExpression= ruleDataTypeExpression EOF ;
    public final Boolean entryRuleDataTypeExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDataTypeExpression = null;


        try {
            // PsiInternalBug296889TestLanguage.g:309:60: (iv_ruleDataTypeExpression= ruleDataTypeExpression EOF )
            // PsiInternalBug296889TestLanguage.g:310:2: iv_ruleDataTypeExpression= ruleDataTypeExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDataTypeExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypeExpression=ruleDataTypeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataTypeExpression"


    // $ANTLR start "ruleDataTypeExpression"
    // PsiInternalBug296889TestLanguage.g:316:1: ruleDataTypeExpression returns [Boolean current=false] : ( ruleDataTypePostop | ruleDataTypePreop ) ;
    public final Boolean ruleDataTypeExpression() throws RecognitionException {
        Boolean current = false;

        try {
            // PsiInternalBug296889TestLanguage.g:317:1: ( ( ruleDataTypePostop | ruleDataTypePreop ) )
            // PsiInternalBug296889TestLanguage.g:318:2: ( ruleDataTypePostop | ruleDataTypePreop )
            {
            // PsiInternalBug296889TestLanguage.g:318:2: ( ruleDataTypePostop | ruleDataTypePreop )
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
                    // PsiInternalBug296889TestLanguage.g:319:3: ruleDataTypePostop
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getDataTypeExpression_DataTypePostopParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDataTypePostop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBug296889TestLanguage.g:327:3: ruleDataTypePreop
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getDataTypeExpression_DataTypePreopParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDataTypePreop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
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
    // $ANTLR end "ruleDataTypeExpression"


    // $ANTLR start "entryRuleDataTypePreop"
    // PsiInternalBug296889TestLanguage.g:338:1: entryRuleDataTypePreop returns [Boolean current=false] : iv_ruleDataTypePreop= ruleDataTypePreop EOF ;
    public final Boolean entryRuleDataTypePreop() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDataTypePreop = null;


        try {
            // PsiInternalBug296889TestLanguage.g:338:55: (iv_ruleDataTypePreop= ruleDataTypePreop EOF )
            // PsiInternalBug296889TestLanguage.g:339:2: iv_ruleDataTypePreop= ruleDataTypePreop EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDataTypePreopElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypePreop=ruleDataTypePreop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypePreop; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataTypePreop"


    // $ANTLR start "ruleDataTypePreop"
    // PsiInternalBug296889TestLanguage.g:345:1: ruleDataTypePreop returns [Boolean current=false] : (kw= '--' ruleDataTypeVariable ) ;
    public final Boolean ruleDataTypePreop() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalBug296889TestLanguage.g:346:1: ( (kw= '--' ruleDataTypeVariable ) )
            // PsiInternalBug296889TestLanguage.g:347:2: (kw= '--' ruleDataTypeVariable )
            {
            // PsiInternalBug296889TestLanguage.g:347:2: (kw= '--' ruleDataTypeVariable )
            // PsiInternalBug296889TestLanguage.g:348:3: kw= '--' ruleDataTypeVariable
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getDataTypePreop_HyphenMinusHyphenMinusKeyword_0ElementType());
              		
            }
            kw=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getDataTypePreop_DataTypeVariableParserRuleCall_1ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
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
    // $ANTLR end "ruleDataTypePreop"


    // $ANTLR start "entryRuleDataTypePostop"
    // PsiInternalBug296889TestLanguage.g:366:1: entryRuleDataTypePostop returns [Boolean current=false] : iv_ruleDataTypePostop= ruleDataTypePostop EOF ;
    public final Boolean entryRuleDataTypePostop() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDataTypePostop = null;


        try {
            // PsiInternalBug296889TestLanguage.g:366:56: (iv_ruleDataTypePostop= ruleDataTypePostop EOF )
            // PsiInternalBug296889TestLanguage.g:367:2: iv_ruleDataTypePostop= ruleDataTypePostop EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDataTypePostopElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypePostop=ruleDataTypePostop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypePostop; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataTypePostop"


    // $ANTLR start "ruleDataTypePostop"
    // PsiInternalBug296889TestLanguage.g:373:1: ruleDataTypePostop returns [Boolean current=false] : ( ruleDataTypeVariable (kw= '--' )? ) ;
    public final Boolean ruleDataTypePostop() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalBug296889TestLanguage.g:374:1: ( ( ruleDataTypeVariable (kw= '--' )? ) )
            // PsiInternalBug296889TestLanguage.g:375:2: ( ruleDataTypeVariable (kw= '--' )? )
            {
            // PsiInternalBug296889TestLanguage.g:375:2: ( ruleDataTypeVariable (kw= '--' )? )
            // PsiInternalBug296889TestLanguage.g:376:3: ruleDataTypeVariable (kw= '--' )?
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getDataTypePostop_DataTypeVariableParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_5);
            ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalBug296889TestLanguage.g:383:3: (kw= '--' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==EOF||LA7_1==13) ) {
                    alt7=1;
                }
                else if ( (LA7_1==RULE_ID) ) {
                    int LA7_4 = input.LA(3);

                    if ( (synpred7_PsiInternalBug296889TestLanguage()) ) {
                        alt7=1;
                    }
                }
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalBug296889TestLanguage.g:384:4: kw= '--'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getDataTypePostop_HyphenMinusHyphenMinusKeyword_1ElementType());
                      			
                    }
                    kw=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
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
    // $ANTLR end "ruleDataTypePostop"


    // $ANTLR start "entryRuleDataTypeVariable"
    // PsiInternalBug296889TestLanguage.g:396:1: entryRuleDataTypeVariable returns [Boolean current=false] : iv_ruleDataTypeVariable= ruleDataTypeVariable EOF ;
    public final Boolean entryRuleDataTypeVariable() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDataTypeVariable = null;


        try {
            // PsiInternalBug296889TestLanguage.g:396:58: (iv_ruleDataTypeVariable= ruleDataTypeVariable EOF )
            // PsiInternalBug296889TestLanguage.g:397:2: iv_ruleDataTypeVariable= ruleDataTypeVariable EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDataTypeVariableElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypeVariable=ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeVariable; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataTypeVariable"


    // $ANTLR start "ruleDataTypeVariable"
    // PsiInternalBug296889TestLanguage.g:403:1: ruleDataTypeVariable returns [Boolean current=false] : this_ID_0= RULE_ID ;
    public final Boolean ruleDataTypeVariable() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalBug296889TestLanguage.g:404:1: (this_ID_0= RULE_ID )
            // PsiInternalBug296889TestLanguage.g:405:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getDataTypeVariable_IDTerminalRuleCallElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneLeaf(this_ID_0);
              	
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
    // $ANTLR end "ruleDataTypeVariable"

    // $ANTLR start synpred5_PsiInternalBug296889TestLanguage
    public final void synpred5_PsiInternalBug296889TestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_0=null;

        // PsiInternalBug296889TestLanguage.g:236:4: ( () ( (lv_functionName_2_0= '--' ) ) )
        // PsiInternalBug296889TestLanguage.g:236:4: () ( (lv_functionName_2_0= '--' ) )
        {
        // PsiInternalBug296889TestLanguage.g:236:4: ()
        // PsiInternalBug296889TestLanguage.g:237:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBug296889TestLanguage.g:246:4: ( (lv_functionName_2_0= '--' ) )
        // PsiInternalBug296889TestLanguage.g:247:5: (lv_functionName_2_0= '--' )
        {
        // PsiInternalBug296889TestLanguage.g:247:5: (lv_functionName_2_0= '--' )
        // PsiInternalBug296889TestLanguage.g:248:6: lv_functionName_2_0= '--'
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getPostop_FunctionNameHyphenMinusHyphenMinusKeyword_1_1_0ElementType());
          					
        }
        lv_functionName_2_0=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred5_PsiInternalBug296889TestLanguage

    // $ANTLR start synpred7_PsiInternalBug296889TestLanguage
    public final void synpred7_PsiInternalBug296889TestLanguage_fragment() throws RecognitionException {   
        Token kw=null;

        // PsiInternalBug296889TestLanguage.g:384:4: (kw= '--' )
        // PsiInternalBug296889TestLanguage.g:384:4: kw= '--'
        {
        if ( state.backtracking==0 ) {

          				markLeaf(elementTypeProvider.getDataTypePostop_HyphenMinusHyphenMinusKeyword_1ElementType());
          			
        }
        kw=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_PsiInternalBug296889TestLanguage

    // Delegated rules

    public final boolean synpred5_PsiInternalBug296889TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_PsiInternalBug296889TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_PsiInternalBug296889TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PsiInternalBug296889TestLanguage_fragment(); // can never throw exception
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
package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.terminalrules.services.Bug297105TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalBug297105TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_EXT_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'+'", "'.'"
    };
    public static final int RULE_ID=6;
    public static final int RULE_STRING=7;
    public static final int RULE_EXT_INT=5;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=4;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;

    // delegates
    // delegators


        public PsiInternalBug297105TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug297105TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug297105TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBug297105TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

    	protected Bug297105TestLanguageGrammarAccess grammarAccess;

    	protected Bug297105TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug297105TestLanguageParser(PsiBuilder builder, TokenStream input, Bug297105TestLanguageElementTypeProvider elementTypeProvider, Bug297105TestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalBug297105TestLanguage.g:58:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalBug297105TestLanguage.g:58:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBug297105TestLanguage.g:59:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalBug297105TestLanguage.g:65:1: ruleModel returns [Boolean current=false] : ( (lv_expressions_0_0= ruleExpression ) )* ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_expressions_0_0 = null;


        try {
            // PsiInternalBug297105TestLanguage.g:66:1: ( ( (lv_expressions_0_0= ruleExpression ) )* )
            // PsiInternalBug297105TestLanguage.g:67:2: ( (lv_expressions_0_0= ruleExpression ) )*
            {
            // PsiInternalBug297105TestLanguage.g:67:2: ( (lv_expressions_0_0= ruleExpression ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_INT||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalBug297105TestLanguage.g:68:3: (lv_expressions_0_0= ruleExpression )
            	    {
            	    // PsiInternalBug297105TestLanguage.g:68:3: (lv_expressions_0_0= ruleExpression )
            	    // PsiInternalBug297105TestLanguage.g:69:4: lv_expressions_0_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getModel_ExpressionsExpressionParserRuleCall_0ElementType());
            	      			
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_expressions_0_0=ruleExpression();

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
    // PsiInternalBug297105TestLanguage.g:85:1: entryRuleExpression returns [Boolean current=false] : iv_ruleExpression= ruleExpression EOF ;
    public final Boolean entryRuleExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExpression = null;


        try {
            // PsiInternalBug297105TestLanguage.g:85:52: (iv_ruleExpression= ruleExpression EOF )
            // PsiInternalBug297105TestLanguage.g:86:2: iv_ruleExpression= ruleExpression EOF
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
    // PsiInternalBug297105TestLanguage.g:92:1: ruleExpression returns [Boolean current=false] : ( ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) ) ) ;
    public final Boolean ruleExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_left_0_0 = null;

        Boolean lv_right_2_0 = null;


        try {
            // PsiInternalBug297105TestLanguage.g:93:1: ( ( ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) ) ) )
            // PsiInternalBug297105TestLanguage.g:94:2: ( ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) ) )
            {
            // PsiInternalBug297105TestLanguage.g:94:2: ( ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) ) )
            // PsiInternalBug297105TestLanguage.g:95:3: ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) )
            {
            // PsiInternalBug297105TestLanguage.g:95:3: ( (lv_left_0_0= ruleLiteral ) )
            // PsiInternalBug297105TestLanguage.g:96:4: (lv_left_0_0= ruleLiteral )
            {
            // PsiInternalBug297105TestLanguage.g:96:4: (lv_left_0_0= ruleLiteral )
            // PsiInternalBug297105TestLanguage.g:97:5: lv_left_0_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getExpression_LeftLiteralParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_4);
            lv_left_0_0=ruleLiteral();

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

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getExpression_PlusSignKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalBug297105TestLanguage.g:117:3: ( (lv_right_2_0= ruleLiteral ) )
            // PsiInternalBug297105TestLanguage.g:118:4: (lv_right_2_0= ruleLiteral )
            {
            // PsiInternalBug297105TestLanguage.g:118:4: (lv_right_2_0= ruleLiteral )
            // PsiInternalBug297105TestLanguage.g:119:5: lv_right_2_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getExpression_RightLiteralParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_right_2_0=ruleLiteral();

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLiteral"
    // PsiInternalBug297105TestLanguage.g:136:1: entryRuleLiteral returns [Boolean current=false] : iv_ruleLiteral= ruleLiteral EOF ;
    public final Boolean entryRuleLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLiteral = null;


        try {
            // PsiInternalBug297105TestLanguage.g:136:49: (iv_ruleLiteral= ruleLiteral EOF )
            // PsiInternalBug297105TestLanguage.g:137:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // PsiInternalBug297105TestLanguage.g:143:1: ruleLiteral returns [Boolean current=false] : (this_RealLiteral_0= ruleRealLiteral | this_IntLiteral_1= ruleIntLiteral ) ;
    public final Boolean ruleLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean this_RealLiteral_0 = null;

        Boolean this_IntLiteral_1 = null;


        try {
            // PsiInternalBug297105TestLanguage.g:144:1: ( (this_RealLiteral_0= ruleRealLiteral | this_IntLiteral_1= ruleIntLiteral ) )
            // PsiInternalBug297105TestLanguage.g:145:2: (this_RealLiteral_0= ruleRealLiteral | this_IntLiteral_1= ruleIntLiteral )
            {
            // PsiInternalBug297105TestLanguage.g:145:2: (this_RealLiteral_0= ruleRealLiteral | this_IntLiteral_1= ruleIntLiteral )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred2_PsiInternalBug297105TestLanguage()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==13) ) {
                alt2=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalBug297105TestLanguage.g:146:3: this_RealLiteral_0= ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getLiteral_RealLiteralParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RealLiteral_0=ruleRealLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RealLiteral_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBug297105TestLanguage.g:158:3: this_IntLiteral_1= ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getLiteral_IntLiteralParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_IntLiteral_1=ruleIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntLiteral_1;
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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // PsiInternalBug297105TestLanguage.g:173:1: entryRuleIntLiteral returns [Boolean current=false] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final Boolean entryRuleIntLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIntLiteral = null;


        try {
            // PsiInternalBug297105TestLanguage.g:173:52: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // PsiInternalBug297105TestLanguage.g:174:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIntLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntLiteral; 
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
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // PsiInternalBug297105TestLanguage.g:180:1: ruleIntLiteral returns [Boolean current=false] : ( (lv_value_0_0= ruleIntValue ) ) ;
    public final Boolean ruleIntLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean lv_value_0_0 = null;


        try {
            // PsiInternalBug297105TestLanguage.g:181:1: ( ( (lv_value_0_0= ruleIntValue ) ) )
            // PsiInternalBug297105TestLanguage.g:182:2: ( (lv_value_0_0= ruleIntValue ) )
            {
            // PsiInternalBug297105TestLanguage.g:182:2: ( (lv_value_0_0= ruleIntValue ) )
            // PsiInternalBug297105TestLanguage.g:183:3: (lv_value_0_0= ruleIntValue )
            {
            // PsiInternalBug297105TestLanguage.g:183:3: (lv_value_0_0= ruleIntValue )
            // PsiInternalBug297105TestLanguage.g:184:4: lv_value_0_0= ruleIntValue
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getIntLiteral_ValueIntValueParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_0_0=ruleIntValue();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleRealLiteral"
    // PsiInternalBug297105TestLanguage.g:200:1: entryRuleRealLiteral returns [Boolean current=false] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final Boolean entryRuleRealLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRealLiteral = null;


        try {
            // PsiInternalBug297105TestLanguage.g:200:53: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // PsiInternalBug297105TestLanguage.g:201:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRealLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealLiteral; 
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
    // $ANTLR end "entryRuleRealLiteral"


    // $ANTLR start "ruleRealLiteral"
    // PsiInternalBug297105TestLanguage.g:207:1: ruleRealLiteral returns [Boolean current=false] : ( (lv_value_0_0= ruleRealValue ) ) ;
    public final Boolean ruleRealLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean lv_value_0_0 = null;


        try {
            // PsiInternalBug297105TestLanguage.g:208:1: ( ( (lv_value_0_0= ruleRealValue ) ) )
            // PsiInternalBug297105TestLanguage.g:209:2: ( (lv_value_0_0= ruleRealValue ) )
            {
            // PsiInternalBug297105TestLanguage.g:209:2: ( (lv_value_0_0= ruleRealValue ) )
            // PsiInternalBug297105TestLanguage.g:210:3: (lv_value_0_0= ruleRealValue )
            {
            // PsiInternalBug297105TestLanguage.g:210:3: (lv_value_0_0= ruleRealValue )
            // PsiInternalBug297105TestLanguage.g:211:4: lv_value_0_0= ruleRealValue
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getRealLiteral_ValueRealValueParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_0_0=ruleRealValue();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "entryRuleIntValue"
    // PsiInternalBug297105TestLanguage.g:227:1: entryRuleIntValue returns [Boolean current=false] : iv_ruleIntValue= ruleIntValue EOF ;
    public final Boolean entryRuleIntValue() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIntValue = null;


        try {
            // PsiInternalBug297105TestLanguage.g:227:50: (iv_ruleIntValue= ruleIntValue EOF )
            // PsiInternalBug297105TestLanguage.g:228:2: iv_ruleIntValue= ruleIntValue EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIntValueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIntValue=ruleIntValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntValue; 
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
    // $ANTLR end "entryRuleIntValue"


    // $ANTLR start "ruleIntValue"
    // PsiInternalBug297105TestLanguage.g:234:1: ruleIntValue returns [Boolean current=false] : this_INT_0= RULE_INT ;
    public final Boolean ruleIntValue() throws RecognitionException {
        Boolean current = false;

        Token this_INT_0=null;

        try {
            // PsiInternalBug297105TestLanguage.g:235:1: (this_INT_0= RULE_INT )
            // PsiInternalBug297105TestLanguage.g:236:2: this_INT_0= RULE_INT
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getIntValue_INTTerminalRuleCallElementType());
              	
            }
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneLeaf(this_INT_0);
              	
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
    // $ANTLR end "ruleIntValue"


    // $ANTLR start "entryRuleRealValue"
    // PsiInternalBug297105TestLanguage.g:246:1: entryRuleRealValue returns [Boolean current=false] : iv_ruleRealValue= ruleRealValue EOF ;
    public final Boolean entryRuleRealValue() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRealValue = null;


        try {
            // PsiInternalBug297105TestLanguage.g:246:51: (iv_ruleRealValue= ruleRealValue EOF )
            // PsiInternalBug297105TestLanguage.g:247:2: iv_ruleRealValue= ruleRealValue EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRealValueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRealValue=ruleRealValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealValue; 
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
    // $ANTLR end "entryRuleRealValue"


    // $ANTLR start "ruleRealValue"
    // PsiInternalBug297105TestLanguage.g:253:1: ruleRealValue returns [Boolean current=false] : ruleReal ;
    public final Boolean ruleRealValue() throws RecognitionException {
        Boolean current = false;

        try {
            // PsiInternalBug297105TestLanguage.g:254:1: ( ruleReal )
            // PsiInternalBug297105TestLanguage.g:255:2: ruleReal
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getRealValue_RealParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneComposite();
              	
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
    // $ANTLR end "ruleRealValue"


    // $ANTLR start "entryRuleReal"
    // PsiInternalBug297105TestLanguage.g:265:1: entryRuleReal returns [Boolean current=false] : iv_ruleReal= ruleReal EOF ;
    public final Boolean entryRuleReal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleReal = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalBug297105TestLanguage.g:267:2: (iv_ruleReal= ruleReal EOF )
            // PsiInternalBug297105TestLanguage.g:268:2: iv_ruleReal= ruleReal EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRealElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReal=ruleReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReal; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleReal"


    // $ANTLR start "ruleReal"
    // PsiInternalBug297105TestLanguage.g:277:1: ruleReal returns [Boolean current=false] : ( (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) ) ;
    public final Boolean ruleReal() throws RecognitionException {
        Boolean current = false;

        Token this_INT_0=null;
        Token kw=null;
        Token this_EXT_INT_2=null;
        Token this_INT_3=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalBug297105TestLanguage.g:280:2: ( ( (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) ) )
            // PsiInternalBug297105TestLanguage.g:281:2: ( (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) )
            {
            // PsiInternalBug297105TestLanguage.g:281:2: ( (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) )
            // PsiInternalBug297105TestLanguage.g:282:3: (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT )
            {
            // PsiInternalBug297105TestLanguage.g:282:3: (this_INT_0= RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalBug297105TestLanguage.g:283:4: this_INT_0= RULE_INT
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getReal_INTTerminalRuleCall_0ElementType());
                      			
                    }
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(this_INT_0);
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getReal_FullStopKeyword_1ElementType());
              		
            }
            kw=(Token)match(input,13,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            // PsiInternalBug297105TestLanguage.g:298:3: (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_EXT_INT) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
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
                    // PsiInternalBug297105TestLanguage.g:299:4: this_EXT_INT_2= RULE_EXT_INT
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getReal_EXT_INTTerminalRuleCall_2_0ElementType());
                      			
                    }
                    this_EXT_INT_2=(Token)match(input,RULE_EXT_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(this_EXT_INT_2);
                      			
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBug297105TestLanguage.g:307:4: this_INT_3= RULE_INT
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getReal_INTTerminalRuleCall_2_1ElementType());
                      			
                    }
                    this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(this_INT_3);
                      			
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleReal"

    // $ANTLR start synpred2_PsiInternalBug297105TestLanguage
    public final void synpred2_PsiInternalBug297105TestLanguage_fragment() throws RecognitionException {   
        Boolean this_RealLiteral_0 = null;


        // PsiInternalBug297105TestLanguage.g:146:3: (this_RealLiteral_0= ruleRealLiteral )
        // PsiInternalBug297105TestLanguage.g:146:3: this_RealLiteral_0= ruleRealLiteral
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_RealLiteral_0=ruleRealLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_PsiInternalBug297105TestLanguage

    // Delegated rules

    public final boolean synpred2_PsiInternalBug297105TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalBug297105TestLanguage_fragment(); // can never throw exception
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
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000030L});
    }


}
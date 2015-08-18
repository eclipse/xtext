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
    // PsiInternalBug297105TestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalBug297105TestLanguage.g:58:15: ( ruleModel EOF )
            // PsiInternalBug297105TestLanguage.g:59:2: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalBug297105TestLanguage.g:64:1: ruleModel : ( (lv_expressions_0_0= ruleExpression ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalBug297105TestLanguage.g:64:10: ( ( (lv_expressions_0_0= ruleExpression ) )* )
            // PsiInternalBug297105TestLanguage.g:65:2: ( (lv_expressions_0_0= ruleExpression ) )*
            {
            // PsiInternalBug297105TestLanguage.g:65:2: ( (lv_expressions_0_0= ruleExpression ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_INT||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalBug297105TestLanguage.g:66:3: (lv_expressions_0_0= ruleExpression )
            	    {
            	    // PsiInternalBug297105TestLanguage.g:66:3: (lv_expressions_0_0= ruleExpression )
            	    // PsiInternalBug297105TestLanguage.g:67:4: lv_expressions_0_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getModel_ExpressionsExpressionParserRuleCall_0ElementType());
            	      			
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite();
            	      			
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
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleExpression"
    // PsiInternalBug297105TestLanguage.g:79:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // PsiInternalBug297105TestLanguage.g:79:20: ( ruleExpression EOF )
            // PsiInternalBug297105TestLanguage.g:80:2: ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // PsiInternalBug297105TestLanguage.g:85:1: ruleExpression : ( ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) ) ) ;
    public final void ruleExpression() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalBug297105TestLanguage.g:85:15: ( ( ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) ) ) )
            // PsiInternalBug297105TestLanguage.g:86:2: ( ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) ) )
            {
            // PsiInternalBug297105TestLanguage.g:86:2: ( ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) ) )
            // PsiInternalBug297105TestLanguage.g:87:3: ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) )
            {
            // PsiInternalBug297105TestLanguage.g:87:3: ( (lv_left_0_0= ruleLiteral ) )
            // PsiInternalBug297105TestLanguage.g:88:4: (lv_left_0_0= ruleLiteral )
            {
            // PsiInternalBug297105TestLanguage.g:88:4: (lv_left_0_0= ruleLiteral )
            // PsiInternalBug297105TestLanguage.g:89:5: lv_left_0_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getExpression_LeftLiteralParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_4);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getExpression_PlusSignKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_5); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalBug297105TestLanguage.g:105:3: ( (lv_right_2_0= ruleLiteral ) )
            // PsiInternalBug297105TestLanguage.g:106:4: (lv_right_2_0= ruleLiteral )
            {
            // PsiInternalBug297105TestLanguage.g:106:4: (lv_right_2_0= ruleLiteral )
            // PsiInternalBug297105TestLanguage.g:107:5: lv_right_2_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getExpression_RightLiteralParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLiteral"
    // PsiInternalBug297105TestLanguage.g:120:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // PsiInternalBug297105TestLanguage.g:120:17: ( ruleLiteral EOF )
            // PsiInternalBug297105TestLanguage.g:121:2: ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // PsiInternalBug297105TestLanguage.g:126:1: ruleLiteral : ( ruleRealLiteral | ruleIntLiteral ) ;
    public final void ruleLiteral() throws RecognitionException {
        try {
            // PsiInternalBug297105TestLanguage.g:126:12: ( ( ruleRealLiteral | ruleIntLiteral ) )
            // PsiInternalBug297105TestLanguage.g:127:2: ( ruleRealLiteral | ruleIntLiteral )
            {
            // PsiInternalBug297105TestLanguage.g:127:2: ( ruleRealLiteral | ruleIntLiteral )
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
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==13) ) {
                alt2=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalBug297105TestLanguage.g:128:3: ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getLiteral_RealLiteralParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRealLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBug297105TestLanguage.g:139:3: ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getLiteral_IntLiteralParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleIntLiteral();

                    state._fsp--;
                    if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // PsiInternalBug297105TestLanguage.g:153:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // PsiInternalBug297105TestLanguage.g:153:20: ( ruleIntLiteral EOF )
            // PsiInternalBug297105TestLanguage.g:154:2: ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIntLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleIntLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // PsiInternalBug297105TestLanguage.g:159:1: ruleIntLiteral : ( (lv_value_0_0= ruleIntValue ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {
        try {
            // PsiInternalBug297105TestLanguage.g:159:15: ( ( (lv_value_0_0= ruleIntValue ) ) )
            // PsiInternalBug297105TestLanguage.g:160:2: ( (lv_value_0_0= ruleIntValue ) )
            {
            // PsiInternalBug297105TestLanguage.g:160:2: ( (lv_value_0_0= ruleIntValue ) )
            // PsiInternalBug297105TestLanguage.g:161:3: (lv_value_0_0= ruleIntValue )
            {
            // PsiInternalBug297105TestLanguage.g:161:3: (lv_value_0_0= ruleIntValue )
            // PsiInternalBug297105TestLanguage.g:162:4: lv_value_0_0= ruleIntValue
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getIntLiteral_ValueIntValueParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleIntValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleRealLiteral"
    // PsiInternalBug297105TestLanguage.g:174:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // PsiInternalBug297105TestLanguage.g:174:21: ( ruleRealLiteral EOF )
            // PsiInternalBug297105TestLanguage.g:175:2: ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRealLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRealLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleRealLiteral"


    // $ANTLR start "ruleRealLiteral"
    // PsiInternalBug297105TestLanguage.g:180:1: ruleRealLiteral : ( (lv_value_0_0= ruleRealValue ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {
        try {
            // PsiInternalBug297105TestLanguage.g:180:16: ( ( (lv_value_0_0= ruleRealValue ) ) )
            // PsiInternalBug297105TestLanguage.g:181:2: ( (lv_value_0_0= ruleRealValue ) )
            {
            // PsiInternalBug297105TestLanguage.g:181:2: ( (lv_value_0_0= ruleRealValue ) )
            // PsiInternalBug297105TestLanguage.g:182:3: (lv_value_0_0= ruleRealValue )
            {
            // PsiInternalBug297105TestLanguage.g:182:3: (lv_value_0_0= ruleRealValue )
            // PsiInternalBug297105TestLanguage.g:183:4: lv_value_0_0= ruleRealValue
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getRealLiteral_ValueRealValueParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRealValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "entryRuleIntValue"
    // PsiInternalBug297105TestLanguage.g:195:1: entryRuleIntValue : ruleIntValue EOF ;
    public final void entryRuleIntValue() throws RecognitionException {
        try {
            // PsiInternalBug297105TestLanguage.g:195:18: ( ruleIntValue EOF )
            // PsiInternalBug297105TestLanguage.g:196:2: ruleIntValue EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIntValueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleIntValue();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleIntValue"


    // $ANTLR start "ruleIntValue"
    // PsiInternalBug297105TestLanguage.g:201:1: ruleIntValue : this_INT_0= RULE_INT ;
    public final void ruleIntValue() throws RecognitionException {
        Token this_INT_0=null;

        try {
            // PsiInternalBug297105TestLanguage.g:201:13: (this_INT_0= RULE_INT )
            // PsiInternalBug297105TestLanguage.g:202:2: this_INT_0= RULE_INT
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getIntValue_INTTerminalRuleCallElementType());
              	
            }
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleIntValue"


    // $ANTLR start "entryRuleRealValue"
    // PsiInternalBug297105TestLanguage.g:212:1: entryRuleRealValue : ruleRealValue EOF ;
    public final void entryRuleRealValue() throws RecognitionException {
        try {
            // PsiInternalBug297105TestLanguage.g:212:19: ( ruleRealValue EOF )
            // PsiInternalBug297105TestLanguage.g:213:2: ruleRealValue EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRealValueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRealValue();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleRealValue"


    // $ANTLR start "ruleRealValue"
    // PsiInternalBug297105TestLanguage.g:218:1: ruleRealValue : ruleReal ;
    public final void ruleRealValue() throws RecognitionException {
        try {
            // PsiInternalBug297105TestLanguage.g:218:14: ( ruleReal )
            // PsiInternalBug297105TestLanguage.g:219:2: ruleReal
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getRealValue_RealParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleReal();

            state._fsp--;
            if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleRealValue"


    // $ANTLR start "entryRuleReal"
    // PsiInternalBug297105TestLanguage.g:229:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalBug297105TestLanguage.g:231:2: ( ruleReal EOF )
            // PsiInternalBug297105TestLanguage.g:232:2: ruleReal EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRealElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReal();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleReal"


    // $ANTLR start "ruleReal"
    // PsiInternalBug297105TestLanguage.g:240:1: ruleReal : ( (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) ) ;
    public final void ruleReal() throws RecognitionException {
        Token this_INT_0=null;
        Token kw=null;
        Token this_EXT_INT_2=null;
        Token this_INT_3=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalBug297105TestLanguage.g:242:2: ( ( (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) ) )
            // PsiInternalBug297105TestLanguage.g:243:2: ( (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) )
            {
            // PsiInternalBug297105TestLanguage.g:243:2: ( (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) )
            // PsiInternalBug297105TestLanguage.g:244:3: (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT )
            {
            // PsiInternalBug297105TestLanguage.g:244:3: (this_INT_0= RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalBug297105TestLanguage.g:245:4: this_INT_0= RULE_INT
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getReal_INTTerminalRuleCall_0ElementType());
                      			
                    }
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_6); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(this_INT_0);
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getReal_FullStopKeyword_1ElementType());
              		
            }
            kw=(Token)match(input,13,FollowSets000.FOLLOW_7); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            // PsiInternalBug297105TestLanguage.g:260:3: (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_EXT_INT) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalBug297105TestLanguage.g:261:4: this_EXT_INT_2= RULE_EXT_INT
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getReal_EXT_INTTerminalRuleCall_2_0ElementType());
                      			
                    }
                    this_EXT_INT_2=(Token)match(input,RULE_EXT_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(this_EXT_INT_2);
                      			
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBug297105TestLanguage.g:269:4: this_INT_3= RULE_INT
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getReal_INTTerminalRuleCall_2_1ElementType());
                      			
                    }
                    this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleReal"

    // $ANTLR start synpred2_PsiInternalBug297105TestLanguage
    public final void synpred2_PsiInternalBug297105TestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBug297105TestLanguage.g:128:3: ( ruleRealLiteral )
        // PsiInternalBug297105TestLanguage.g:128:3: ruleRealLiteral
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleRealLiteral();

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
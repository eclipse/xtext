package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:56:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:56:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:57:2: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel60);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel66); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:65:1: ruleModel : ( (lv_expressions_0_0= ruleExpression ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:65:10: ( ( (lv_expressions_0_0= ruleExpression ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:66:2: ( (lv_expressions_0_0= ruleExpression ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:66:2: ( (lv_expressions_0_0= ruleExpression ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_INT||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:67:3: (lv_expressions_0_0= ruleExpression )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:67:3: (lv_expressions_0_0= ruleExpression )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:68:4: lv_expressions_0_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getModel_ExpressionsExpressionParserRuleCall_0ElementType());
            	      			
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleModel95);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:80:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:80:20: ( ruleExpression EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:81:2: ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression121);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression127); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:89:1: ruleExpression : ( ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) ) ) ;
    public final void ruleExpression() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:89:15: ( ( ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:90:2: ( ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:90:2: ( ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:91:3: ( (lv_left_0_0= ruleLiteral ) ) otherlv_1= '+' ( (lv_right_2_0= ruleLiteral ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:91:3: ( (lv_left_0_0= ruleLiteral ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:92:4: (lv_left_0_0= ruleLiteral )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:92:4: (lv_left_0_0= ruleLiteral )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:93:5: lv_left_0_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getExpression_LeftLiteralParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_ruleLiteral_in_ruleExpression163);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleExpression188); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1, elementTypeProvider.getExpression_PlusSignKeyword_1ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:109:3: ( (lv_right_2_0= ruleLiteral ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:110:4: (lv_right_2_0= ruleLiteral )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:110:4: (lv_right_2_0= ruleLiteral )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:111:5: lv_right_2_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getExpression_RightLiteralParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_ruleLiteral_in_ruleExpression215);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:124:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:124:17: ( ruleLiteral EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:125:2: ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLiteral_in_entryRuleLiteral246);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLiteral252); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:133:1: ruleLiteral : ( ruleRealLiteral | ruleIntLiteral ) ;
    public final void ruleLiteral() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:133:12: ( ( ruleRealLiteral | ruleIntLiteral ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:134:2: ( ruleRealLiteral | ruleIntLiteral )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:134:2: ( ruleRealLiteral | ruleIntLiteral )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:135:3: ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getLiteral_RealLiteralParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRealLiteral_in_ruleLiteral277);
                    ruleRealLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:146:3: ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getLiteral_IntLiteralParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIntLiteral_in_ruleLiteral301);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:160:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:160:20: ( ruleIntLiteral EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:161:2: ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIntLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral321);
            ruleIntLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntLiteral327); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:169:1: ruleIntLiteral : ( (lv_value_0_0= ruleIntValue ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:169:15: ( ( (lv_value_0_0= ruleIntValue ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:170:2: ( (lv_value_0_0= ruleIntValue ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:170:2: ( (lv_value_0_0= ruleIntValue ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:171:3: (lv_value_0_0= ruleIntValue )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:171:3: (lv_value_0_0= ruleIntValue )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:172:4: lv_value_0_0= ruleIntValue
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getIntLiteral_ValueIntValueParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_ruleIntValue_in_ruleIntLiteral356);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:184:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:184:21: ( ruleRealLiteral EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:185:2: ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRealLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral381);
            ruleRealLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealLiteral387); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:193:1: ruleRealLiteral : ( (lv_value_0_0= ruleRealValue ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:193:16: ( ( (lv_value_0_0= ruleRealValue ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:194:2: ( (lv_value_0_0= ruleRealValue ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:194:2: ( (lv_value_0_0= ruleRealValue ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:195:3: (lv_value_0_0= ruleRealValue )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:195:3: (lv_value_0_0= ruleRealValue )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:196:4: lv_value_0_0= ruleRealValue
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getRealLiteral_ValueRealValueParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_ruleRealValue_in_ruleRealLiteral416);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:208:1: entryRuleIntValue : ruleIntValue EOF ;
    public final void entryRuleIntValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:208:18: ( ruleIntValue EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:209:2: ruleIntValue EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIntValueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIntValue_in_entryRuleIntValue441);
            ruleIntValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntValue447); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:217:1: ruleIntValue : this_INT_0= RULE_INT ;
    public final void ruleIntValue() throws RecognitionException {
        Token this_INT_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:217:13: (this_INT_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:218:2: this_INT_0= RULE_INT
            {
            if ( state.backtracking==0 ) {

              		markLeaf();
              	
            }
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleIntValue465); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              		doneLeaf(this_INT_0, elementTypeProvider.getIntValue_INTTerminalRuleCallElementType());
              	
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:228:1: entryRuleRealValue : ruleRealValue EOF ;
    public final void entryRuleRealValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:228:19: ( ruleRealValue EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:229:2: ruleRealValue EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRealValueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRealValue_in_entryRuleRealValue481);
            ruleRealValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealValue487); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:237:1: ruleRealValue : ruleReal ;
    public final void ruleRealValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:237:14: ( ruleReal )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:238:2: ruleReal
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getRealValue_RealParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_ruleReal_in_ruleRealValue503);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:248:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:248:14: ( ruleReal EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:249:2: ruleReal EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRealElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReal_in_entryRuleReal519);
            ruleReal();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReal525); if (state.failed) return ;

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
    // $ANTLR end "entryRuleReal"


    // $ANTLR start "ruleReal"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:257:1: ruleReal : ( (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) ) ;
    public final void ruleReal() throws RecognitionException {
        Token this_INT_0=null;
        Token kw=null;
        Token this_EXT_INT_2=null;
        Token this_INT_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:257:9: ( ( (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:258:2: ( (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:258:2: ( (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:259:3: (this_INT_0= RULE_INT )? kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:259:3: (this_INT_0= RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:260:4: this_INT_0= RULE_INT
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleReal554); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(this_INT_0, elementTypeProvider.getReal_INTTerminalRuleCall_0ElementType());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleReal574); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw, elementTypeProvider.getReal_FullStopKeyword_1ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:275:3: (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:276:4: this_EXT_INT_2= RULE_EXT_INT
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    this_EXT_INT_2=(Token)match(input,RULE_EXT_INT,FollowSets000.FOLLOW_RULE_EXT_INT_in_ruleReal594); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(this_EXT_INT_2, elementTypeProvider.getReal_EXT_INTTerminalRuleCall_2_0ElementType());
                      			
                    }

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:284:4: this_INT_3= RULE_INT
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleReal620); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(this_INT_3, elementTypeProvider.getReal_INTTerminalRuleCall_2_1ElementType());
                      			
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
        return ;
    }
    // $ANTLR end "ruleReal"

    // $ANTLR start synpred2_PsiInternalBug297105TestLanguage
    public final void synpred2_PsiInternalBug297105TestLanguage_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:135:3: ( ruleRealLiteral )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalBug297105TestLanguage.g:135:3: ruleRealLiteral
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_ruleRealLiteral_in_synpred2_PsiInternalBug297105TestLanguage277);
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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel66 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleModel95 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteral_in_ruleExpression163 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleExpression188 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_ruleLiteral_in_ruleExpression215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral246 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLiteral252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealLiteral_in_ruleLiteral277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntLiteral_in_ruleLiteral301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral321 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntValue_in_ruleIntLiteral356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral381 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealValue_in_ruleRealLiteral416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntValue_in_entryRuleIntValue441 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntValue447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleIntValue465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealValue_in_entryRuleRealValue481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealValue487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReal_in_ruleRealValue503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReal_in_entryRuleReal519 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReal525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleReal554 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleReal574 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_EXT_INT_in_ruleReal594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleReal620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealLiteral_in_synpred2_PsiInternalBug297105TestLanguage277 = new BitSet(new long[]{0x0000000000000002L});
    }


}
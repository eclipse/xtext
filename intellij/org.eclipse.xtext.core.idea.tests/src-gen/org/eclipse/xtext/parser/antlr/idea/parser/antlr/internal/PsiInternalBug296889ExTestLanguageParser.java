package org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.services.Bug296889ExTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalBug296889ExTestLanguageParser extends AbstractPsiAntlrParser {
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


        public PsiInternalBug296889ExTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug296889ExTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug296889ExTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

    private Bug296889ExTestLanguageGrammarAccess grammarAccess;

    private Bug296889ExTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalBug296889ExTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, Bug296889ExTestLanguageElementTypeProvider elementTypeProvider, Bug296889ExTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
    }




    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:55:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:55:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:56:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:64:1: ruleModel : ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:64:10: ( ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:65:2: ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:65:2: ( (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:66:3: (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:66:3: (otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )* )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:67:4: otherlv_0= 'Model' ( (lv_expressions_1_0= ruleExpression ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel95); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0, elementTypeProvider.getModel_ModelKeyword_0_0ElementType());
                      			
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:74:4: ( (lv_expressions_1_0= ruleExpression ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_ID||LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:75:5: (lv_expressions_1_0= ruleExpression )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:75:5: (lv_expressions_1_0= ruleExpression )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:76:6: lv_expressions_1_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						markComposite(elementTypeProvider.getModel_ExpressionsExpressionParserRuleCall_0_1_0ElementType());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleModel127);
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
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:87:3: (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:87:3: (otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )* )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:88:4: otherlv_2= 'DataType' ( (lv_values_3_0= ruleDataTypeExpression ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel174); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2, elementTypeProvider.getModel_DataTypeKeyword_1_0ElementType());
                      			
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:95:4: ( (lv_values_3_0= ruleDataTypeExpression ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID||LA2_0==13) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:96:5: (lv_values_3_0= ruleDataTypeExpression )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:96:5: (lv_values_3_0= ruleDataTypeExpression )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:97:6: lv_values_3_0= ruleDataTypeExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						markComposite(elementTypeProvider.getModel_ValuesDataTypeExpressionParserRuleCall_1_1_0ElementType());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleDataTypeExpression_in_ruleModel206);
                    	    ruleDataTypeExpression();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      						doneComposite();
                    	      					
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
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleExpression"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:111:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:111:20: ( ruleExpression EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:112:2: ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression245);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression251); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:120:1: ruleExpression : ( rulePostop | rulePreop ) ;
    public final void ruleExpression() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:120:15: ( ( rulePostop | rulePreop ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:121:2: ( rulePostop | rulePreop )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:121:2: ( rulePostop | rulePreop )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==13) ) {
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:122:3: rulePostop
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getExpression_PostopParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePostop_in_ruleExpression276);
                    rulePostop();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:133:3: rulePreop
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getExpression_PreopParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePreop_in_ruleExpression300);
                    rulePreop();

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRulePreop"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:147:1: entryRulePreop : rulePreop EOF ;
    public final void entryRulePreop() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:147:15: ( rulePreop EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:148:2: rulePreop EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPreopElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePreop_in_entryRulePreop320);
            rulePreop();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePreop326); if (state.failed) return ;

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
    // $ANTLR end "entryRulePreop"


    // $ANTLR start "rulePreop"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:156:1: rulePreop : ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) ) ;
    public final void rulePreop() throws RecognitionException {
        Token lv_functionName_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:156:10: ( ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:157:2: ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:157:2: ( () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:158:3: () ( (lv_functionName_1_0= '--' ) ) ( (lv_expr_2_0= ruleVariable ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:158:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:159:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getPreop_PreopAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:167:3: ( (lv_functionName_1_0= '--' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:168:4: (lv_functionName_1_0= '--' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:168:4: (lv_functionName_1_0= '--' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:169:5: lv_functionName_1_0= '--'
            {
            if ( state.backtracking==0 ) {

              					markLeaf();
              				
            }
            lv_functionName_1_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_rulePreop380); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_functionName_1_0, elementTypeProvider.getPreop_FunctionNameHyphenMinusHyphenMinusKeyword_1_0ElementType());
              				
            }

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:178:3: ( (lv_expr_2_0= ruleVariable ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:179:4: (lv_expr_2_0= ruleVariable )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:179:4: (lv_expr_2_0= ruleVariable )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:180:5: lv_expr_2_0= ruleVariable
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getPreop_ExprVariableParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_rulePreop418);
            ruleVariable();

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
    // $ANTLR end "rulePreop"


    // $ANTLR start "entryRulePostop"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:193:1: entryRulePostop : rulePostop EOF ;
    public final void entryRulePostop() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:193:16: ( rulePostop EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:194:2: rulePostop EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPostopElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePostop_in_entryRulePostop449);
            rulePostop();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePostop455); if (state.failed) return ;

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
    // $ANTLR end "entryRulePostop"


    // $ANTLR start "rulePostop"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:202:1: rulePostop : ( ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? ) ;
    public final void rulePostop() throws RecognitionException {
        Token lv_functionName_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:202:11: ( ( ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:203:2: ( ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:203:2: ( ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:204:3: ruleVariable ( () ( (lv_functionName_2_0= '--' ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getPostop_VariableParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_rulePostop480);
            ruleVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:214:3: ( () ( (lv_functionName_2_0= '--' ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==EOF||LA5_1==13) ) {
                    alt5=1;
                }
                else if ( (LA5_1==RULE_ID) ) {
                    int LA5_4 = input.LA(3);

                    if ( (synpred5_PsiInternalBug296889ExTestLanguage()) ) {
                        alt5=1;
                    }
                }
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:215:4: () ( (lv_functionName_2_0= '--' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:215:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:216:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getPostop_PostopExprAction_1_0ElementType());
                      					doneComposite();
                      				
                    }

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:224:4: ( (lv_functionName_2_0= '--' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:225:5: (lv_functionName_2_0= '--' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:225:5: (lv_functionName_2_0= '--' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:226:6: lv_functionName_2_0= '--'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf();
                      					
                    }
                    lv_functionName_2_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_rulePostop537); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_2_0, elementTypeProvider.getPostop_FunctionNameHyphenMinusHyphenMinusKeyword_1_1_0ElementType());
                      					
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
        return ;
    }
    // $ANTLR end "rulePostop"


    // $ANTLR start "entryRuleVariable"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:240:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:240:18: ( ruleVariable EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:241:2: ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getVariableElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_entryRuleVariable576);
            ruleVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariable582); if (state.failed) return ;

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
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:249:1: ruleVariable : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleVariable() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:249:13: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:250:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:250:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:251:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:251:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:252:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getVariable_VariableAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:260:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:261:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:261:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:262:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf();
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariable636); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_1_0, elementTypeProvider.getVariable_NameIDTerminalRuleCall_1_0ElementType());
              				
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
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleDataTypeExpression"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:275:1: entryRuleDataTypeExpression : ruleDataTypeExpression EOF ;
    public final void entryRuleDataTypeExpression() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:275:28: ( ruleDataTypeExpression EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:276:2: ruleDataTypeExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDataTypeExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeExpression_in_entryRuleDataTypeExpression667);
            ruleDataTypeExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataTypeExpression673); if (state.failed) return ;

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
    // $ANTLR end "entryRuleDataTypeExpression"


    // $ANTLR start "ruleDataTypeExpression"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:284:1: ruleDataTypeExpression : ( ruleDataTypePostop | ruleDataTypePreop ) ;
    public final void ruleDataTypeExpression() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:284:23: ( ( ruleDataTypePostop | ruleDataTypePreop ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:285:2: ( ruleDataTypePostop | ruleDataTypePreop )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:285:2: ( ruleDataTypePostop | ruleDataTypePreop )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==13) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:286:3: ruleDataTypePostop
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getDataTypeExpression_DataTypePostopParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDataTypePostop_in_ruleDataTypeExpression694);
                    ruleDataTypePostop();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:294:3: ruleDataTypePreop
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getDataTypeExpression_DataTypePreopParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDataTypePreop_in_ruleDataTypeExpression714);
                    ruleDataTypePreop();

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
    // $ANTLR end "ruleDataTypeExpression"


    // $ANTLR start "entryRuleDataTypePreop"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:305:1: entryRuleDataTypePreop : ruleDataTypePreop EOF ;
    public final void entryRuleDataTypePreop() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:305:23: ( ruleDataTypePreop EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:306:2: ruleDataTypePreop EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDataTypePreopElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataTypePreop_in_entryRuleDataTypePreop734);
            ruleDataTypePreop();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataTypePreop740); if (state.failed) return ;

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
    // $ANTLR end "entryRuleDataTypePreop"


    // $ANTLR start "ruleDataTypePreop"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:314:1: ruleDataTypePreop : (kw= '--' ruleDataTypeVariable ) ;
    public final void ruleDataTypePreop() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:314:18: ( (kw= '--' ruleDataTypeVariable ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:315:2: (kw= '--' ruleDataTypeVariable )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:315:2: (kw= '--' ruleDataTypeVariable )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:316:3: kw= '--' ruleDataTypeVariable
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDataTypePreop763); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw, elementTypeProvider.getDataTypePreop_HyphenMinusHyphenMinusKeyword_0ElementType());
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getDataTypePreop_DataTypeVariableParserRuleCall_1ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeVariable_in_ruleDataTypePreop775);
            ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleDataTypePreop"


    // $ANTLR start "entryRuleDataTypePostop"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:334:1: entryRuleDataTypePostop : ruleDataTypePostop EOF ;
    public final void entryRuleDataTypePostop() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:334:24: ( ruleDataTypePostop EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:335:2: ruleDataTypePostop EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDataTypePostopElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataTypePostop_in_entryRuleDataTypePostop795);
            ruleDataTypePostop();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataTypePostop801); if (state.failed) return ;

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
    // $ANTLR end "entryRuleDataTypePostop"


    // $ANTLR start "ruleDataTypePostop"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:343:1: ruleDataTypePostop : ( ruleDataTypeVariable (kw= '--' )? ) ;
    public final void ruleDataTypePostop() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:343:19: ( ( ruleDataTypeVariable (kw= '--' )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:344:2: ( ruleDataTypeVariable (kw= '--' )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:344:2: ( ruleDataTypeVariable (kw= '--' )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:345:3: ruleDataTypeVariable (kw= '--' )?
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getDataTypePostop_DataTypeVariableParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeVariable_in_ruleDataTypePostop822);
            ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:352:3: (kw= '--' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==EOF||LA7_1==13) ) {
                    alt7=1;
                }
                else if ( (LA7_1==RULE_ID) ) {
                    int LA7_4 = input.LA(3);

                    if ( (synpred7_PsiInternalBug296889ExTestLanguage()) ) {
                        alt7=1;
                    }
                }
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:353:4: kw= '--'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDataTypePostop842); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw, elementTypeProvider.getDataTypePostop_HyphenMinusHyphenMinusKeyword_1ElementType());
                      			
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
    // $ANTLR end "ruleDataTypePostop"


    // $ANTLR start "entryRuleDataTypeVariable"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:365:1: entryRuleDataTypeVariable : ruleDataTypeVariable EOF ;
    public final void entryRuleDataTypeVariable() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:365:26: ( ruleDataTypeVariable EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:366:2: ruleDataTypeVariable EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDataTypeVariableElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeVariable_in_entryRuleDataTypeVariable868);
            ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataTypeVariable874); if (state.failed) return ;

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
    // $ANTLR end "entryRuleDataTypeVariable"


    // $ANTLR start "ruleDataTypeVariable"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:374:1: ruleDataTypeVariable : this_ID_0= RULE_ID ;
    public final void ruleDataTypeVariable() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:374:21: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:375:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf();
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDataTypeVariable892); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              		doneLeaf(this_ID_0, elementTypeProvider.getDataTypeVariable_IDTerminalRuleCallElementType());
              	
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
    // $ANTLR end "ruleDataTypeVariable"

    // $ANTLR start synpred5_PsiInternalBug296889ExTestLanguage
    public final void synpred5_PsiInternalBug296889ExTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_0=null;

        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:215:4: ( () ( (lv_functionName_2_0= '--' ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:215:4: () ( (lv_functionName_2_0= '--' ) )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:215:4: ()
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:216:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:224:4: ( (lv_functionName_2_0= '--' ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:225:5: (lv_functionName_2_0= '--' )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:225:5: (lv_functionName_2_0= '--' )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:226:6: lv_functionName_2_0= '--'
        {
        if ( state.backtracking==0 ) {

          						markLeaf();
          					
        }
        lv_functionName_2_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_synpred5_PsiInternalBug296889ExTestLanguage537); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred5_PsiInternalBug296889ExTestLanguage

    // $ANTLR start synpred7_PsiInternalBug296889ExTestLanguage
    public final void synpred7_PsiInternalBug296889ExTestLanguage_fragment() throws RecognitionException {   
        Token kw=null;

        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:353:4: (kw= '--' )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug296889ExTestLanguage.g:353:4: kw= '--'
        {
        if ( state.backtracking==0 ) {

          				markLeaf();
          			
        }
        kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_synpred7_PsiInternalBug296889ExTestLanguage842); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_PsiInternalBug296889ExTestLanguage

    // Delegated rules

    public final boolean synpred5_PsiInternalBug296889ExTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_PsiInternalBug296889ExTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_PsiInternalBug296889ExTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PsiInternalBug296889ExTestLanguage_fragment(); // can never throw exception
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
        public static final BitSet FOLLOW_11_in_ruleModel95 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleModel127 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_12_in_ruleModel174 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_ruleDataTypeExpression_in_ruleModel206 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression245 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostop_in_ruleExpression276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePreop_in_ruleExpression300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePreop_in_entryRulePreop320 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePreop326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rulePreop380 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleVariable_in_rulePreop418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostop_in_entryRulePostop449 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePostop455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_rulePostop480 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_rulePostop537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable576 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariable582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariable636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypeExpression_in_entryRuleDataTypeExpression667 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeExpression673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypePostop_in_ruleDataTypeExpression694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypePreop_in_ruleDataTypeExpression714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypePreop_in_entryRuleDataTypePreop734 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataTypePreop740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleDataTypePreop763 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDataTypeVariable_in_ruleDataTypePreop775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypePostop_in_entryRuleDataTypePostop795 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataTypePostop801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypeVariable_in_ruleDataTypePostop822 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleDataTypePostop842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypeVariable_in_entryRuleDataTypeVariable868 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeVariable874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDataTypeVariable892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_synpred5_PsiInternalBug296889ExTestLanguage537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_synpred7_PsiInternalBug296889ExTestLanguage842 = new BitSet(new long[]{0x0000000000000002L});
    }


}
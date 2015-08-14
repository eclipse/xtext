package org.eclipse.xtext.parser.unorderedGroups.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExBacktrackingBug325745TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.unorderedGroups.services.ExBacktrackingBug325745TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalExBacktrackingBug325745TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "':='", "'['", "']'", "'*'", "'!'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalExBacktrackingBug325745TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalExBacktrackingBug325745TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalExBacktrackingBug325745TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalExBacktrackingBug325745TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

    	protected ExBacktrackingBug325745TestLanguageGrammarAccess grammarAccess;

    	protected ExBacktrackingBug325745TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalExBacktrackingBug325745TestLanguageParser(PsiBuilder builder, TokenStream input, ExBacktrackingBug325745TestLanguageElementTypeProvider elementTypeProvider, ExBacktrackingBug325745TestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "DelegateModel";
    	}




    // $ANTLR start "entryRuleDelegateModel"
    // PsiInternalExBacktrackingBug325745TestLanguage.g:59:1: entryRuleDelegateModel : ruleDelegateModel EOF ;
    public final void entryRuleDelegateModel() throws RecognitionException {
        try {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:59:23: ( ruleDelegateModel EOF )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:60:2: ruleDelegateModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDelegateModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDelegateModel();

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
    // $ANTLR end "entryRuleDelegateModel"


    // $ANTLR start "ruleDelegateModel"
    // PsiInternalExBacktrackingBug325745TestLanguage.g:65:1: ruleDelegateModel : ruleModel ;
    public final void ruleDelegateModel() throws RecognitionException {
        try {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:65:18: ( ruleModel )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:66:2: ruleModel
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getDelegateModel_ModelParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleModel();

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
    // $ANTLR end "ruleDelegateModel"


    // $ANTLR start "entryRuleModel"
    // PsiInternalExBacktrackingBug325745TestLanguage.g:79:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:79:15: ( ruleModel EOF )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:80:2: ruleModel EOF
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
    // PsiInternalExBacktrackingBug325745TestLanguage.g:85:1: ruleModel : ( () ( (lv_fields_1_0= ruleElement ) )+ ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:85:10: ( ( () ( (lv_fields_1_0= ruleElement ) )+ ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:86:2: ( () ( (lv_fields_1_0= ruleElement ) )+ )
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:86:2: ( () ( (lv_fields_1_0= ruleElement ) )+ )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:87:3: () ( (lv_fields_1_0= ruleElement ) )+
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:87:3: ()
            // PsiInternalExBacktrackingBug325745TestLanguage.g:88:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getModel_ModelAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalExBacktrackingBug325745TestLanguage.g:96:3: ( (lv_fields_1_0= ruleElement ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:97:4: (lv_fields_1_0= ruleElement )
            	    {
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:97:4: (lv_fields_1_0= ruleElement )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:98:5: lv_fields_1_0= ruleElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getModel_FieldsElementParserRuleCall_1_0ElementType());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleElement();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneComposite();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


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


    // $ANTLR start "entryRuleElement"
    // PsiInternalExBacktrackingBug325745TestLanguage.g:111:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:111:17: ( ruleElement EOF )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:112:2: ruleElement EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getElementElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleElement();

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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // PsiInternalExBacktrackingBug325745TestLanguage.g:117:1: ruleElement : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' ) ;
    public final void ruleElement() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:117:12: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:118:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' )
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:118:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:119:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.'
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:119:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:120:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:120:4: (lv_name_0_0= RULE_ID )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:121:5: lv_name_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getElement_NameIDTerminalRuleCall_0_0ElementType());
              				
            }
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_0_0);
              				
            }

            }


            }

            // PsiInternalExBacktrackingBug325745TestLanguage.g:130:3: ( (lv_dataType_1_0= ruleDataType ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred2_PsiInternalExBacktrackingBug325745TestLanguage()) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:131:4: (lv_dataType_1_0= ruleDataType )
                    {
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:131:4: (lv_dataType_1_0= ruleDataType )
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:132:5: lv_dataType_1_0= ruleDataType
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getElement_DataTypeDataTypeParserRuleCall_1_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_4);
                    ruleDataType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalExBacktrackingBug325745TestLanguage.g:141:3: ( (lv_expression_2_0= ruleExpression ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:142:4: (lv_expression_2_0= ruleExpression )
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:142:4: (lv_expression_2_0= ruleExpression )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:143:5: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getElement_ExpressionExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_5);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getElement_FullStopKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleDataType"
    // PsiInternalExBacktrackingBug325745TestLanguage.g:163:1: entryRuleDataType : ruleDataType EOF ;
    public final void entryRuleDataType() throws RecognitionException {
        try {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:163:18: ( ruleDataType EOF )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:164:2: ruleDataType EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDataTypeElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDataType();

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
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // PsiInternalExBacktrackingBug325745TestLanguage.g:169:1: ruleDataType : ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? ) ;
    public final void ruleDataType() throws RecognitionException {
        Token lv_baseType_0_0=null;
        Token otherlv_1=null;
        Token lv_defaultValue_2_0=null;

        try {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:169:13: ( ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:170:2: ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? )
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:170:2: ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:171:3: ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )?
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:171:3: ( (lv_baseType_0_0= RULE_ID ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:172:4: (lv_baseType_0_0= RULE_ID )
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:172:4: (lv_baseType_0_0= RULE_ID )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:173:5: lv_baseType_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getDataType_BaseTypeIDTerminalRuleCall_0_0ElementType());
              				
            }
            lv_baseType_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_baseType_0_0);
              				
            }

            }


            }

            // PsiInternalExBacktrackingBug325745TestLanguage.g:182:3: (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:183:4: otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getDataType_ColonEqualsSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_7); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:190:4: ( (lv_defaultValue_2_0= RULE_STRING ) )
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:191:5: (lv_defaultValue_2_0= RULE_STRING )
                    {
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:191:5: (lv_defaultValue_2_0= RULE_STRING )
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:192:6: lv_defaultValue_2_0= RULE_STRING
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getDataType_DefaultValueSTRINGTerminalRuleCall_1_1_0ElementType());
                      					
                    }
                    lv_defaultValue_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_defaultValue_2_0);
                      					
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
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleExpression"
    // PsiInternalExBacktrackingBug325745TestLanguage.g:206:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {

        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 
        	grammarAccess.getExpressionAccess().getUnorderedGroup_3()
        	);

        try {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:211:2: ( ruleExpression EOF )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:212:2: ruleExpression EOF
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

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // PsiInternalExBacktrackingBug325745TestLanguage.g:220:1: ruleExpression : ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) ) ;
    public final void ruleExpression() throws RecognitionException {
        Token otherlv_2=null;
        Token lv_prefix_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_postfix_9_0=null;


        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 
        	grammarAccess.getExpressionAccess().getUnorderedGroup_3()
        	);

        try {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:225:2: ( ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:226:2: ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) )
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:226:2: ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:227:3: () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) )
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:227:3: ()
            // PsiInternalExBacktrackingBug325745TestLanguage.g:228:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getExpression_ExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalExBacktrackingBug325745TestLanguage.g:236:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:237:4: ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) )
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:237:4: ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:238:5: ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_1());
            // PsiInternalExBacktrackingBug325745TestLanguage.g:241:5: ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:242:6: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )*
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:242:6: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    int LA4_1 = input.LA(2);

                    if ( synpred4_PsiInternalExBacktrackingBug325745TestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
                        alt4=1;
                    }


                }
                else if ( (LA4_0==RULE_STRING) ) {
                    int LA4_3 = input.LA(2);

                    if ( synpred5_PsiInternalExBacktrackingBug325745TestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
                        alt4=2;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:243:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
            	    {
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:243:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:244:5: {...}? => ( ({...}? => (otherlv_2= '[' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:244:107: ( ({...}? => (otherlv_2= '[' ) ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:245:6: ({...}? => (otherlv_2= '[' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:248:9: ({...}? => (otherlv_2= '[' ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:248:10: {...}? => (otherlv_2= '[' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:248:19: (otherlv_2= '[' )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:248:20: otherlv_2= '['
            	    {
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getExpression_LeftSquareBracketKeyword_1_0ElementType());
            	      								
            	    }
            	    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_8); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_2);
            	      								
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_1());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:261:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
            	    {
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:261:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:262:5: {...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:262:107: ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:263:6: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:266:9: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:266:10: {...}? => ( (lv_prefix_3_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:266:19: ( (lv_prefix_3_0= RULE_STRING ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:266:20: (lv_prefix_3_0= RULE_STRING )
            	    {
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:266:20: (lv_prefix_3_0= RULE_STRING )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:267:10: lv_prefix_3_0= RULE_STRING
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getExpression_PrefixSTRINGTerminalRuleCall_1_1_0ElementType());
            	      									
            	    }
            	    lv_prefix_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_8); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(lv_prefix_3_0);
            	      									
            	    }

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_1());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getExpressionAccess().getUnorderedGroup_1());

            }

            // PsiInternalExBacktrackingBug325745TestLanguage.g:288:3: ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==RULE_INT||LA7_0==13) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:289:4: (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )?
            	    {
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:289:4: (otherlv_4= '[' )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==13) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // PsiInternalExBacktrackingBug325745TestLanguage.g:290:5: otherlv_4= '['
            	            {
            	            if ( state.backtracking==0 ) {

            	              					markLeaf(elementTypeProvider.getExpression_LeftSquareBracketKeyword_2_0ElementType());
            	              				
            	            }
            	            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_9); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              					doneLeaf(otherlv_4);
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:298:4: ( (lv_terms_5_0= ruleSimpleTerm ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:299:5: (lv_terms_5_0= ruleSimpleTerm )
            	    {
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:299:5: (lv_terms_5_0= ruleSimpleTerm )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:300:6: lv_terms_5_0= ruleSimpleTerm
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getExpression_TermsSimpleTermParserRuleCall_2_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    ruleSimpleTerm();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:309:4: (otherlv_6= ']' )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==14) ) {
            	        int LA6_1 = input.LA(2);

            	        if ( (synpred7_PsiInternalExBacktrackingBug325745TestLanguage()) ) {
            	            alt6=1;
            	        }
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // PsiInternalExBacktrackingBug325745TestLanguage.g:310:5: otherlv_6= ']'
            	            {
            	            if ( state.backtracking==0 ) {

            	              					markLeaf(elementTypeProvider.getExpression_RightSquareBracketKeyword_2_2ElementType());
            	              				
            	            }
            	            otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_8); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              					doneLeaf(otherlv_6);
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // PsiInternalExBacktrackingBug325745TestLanguage.g:319:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:320:4: ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) )
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:320:4: ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:321:5: ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_3());
            // PsiInternalExBacktrackingBug325745TestLanguage.g:324:5: ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:325:6: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )*
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:325:6: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( LA8_0 == 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
                    alt8=1;
                }
                else if ( LA8_0 == RULE_STRING && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:326:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
            	    {
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:326:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:327:5: {...}? => ( ({...}? => (otherlv_8= ']' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:327:107: ( ({...}? => (otherlv_8= ']' ) ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:328:6: ({...}? => (otherlv_8= ']' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:331:9: ({...}? => (otherlv_8= ']' ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:331:10: {...}? => (otherlv_8= ']' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:331:19: (otherlv_8= ']' )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:331:20: otherlv_8= ']'
            	    {
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getExpression_RightSquareBracketKeyword_3_0ElementType());
            	      								
            	    }
            	    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_10); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_8);
            	      								
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_3());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:344:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:344:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:345:5: {...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:345:107: ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:346:6: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:349:9: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:349:10: {...}? => ( (lv_postfix_9_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:349:19: ( (lv_postfix_9_0= RULE_STRING ) )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:349:20: (lv_postfix_9_0= RULE_STRING )
            	    {
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:349:20: (lv_postfix_9_0= RULE_STRING )
            	    // PsiInternalExBacktrackingBug325745TestLanguage.g:350:10: lv_postfix_9_0= RULE_STRING
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getExpression_PostfixSTRINGTerminalRuleCall_3_1_0ElementType());
            	      									
            	    }
            	    lv_postfix_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_10); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(lv_postfix_9_0);
            	      									
            	    }

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_3());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getExpressionAccess().getUnorderedGroup_3());

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleSimpleTerm"
    // PsiInternalExBacktrackingBug325745TestLanguage.g:378:1: entryRuleSimpleTerm : ruleSimpleTerm EOF ;
    public final void entryRuleSimpleTerm() throws RecognitionException {
        try {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:378:20: ( ruleSimpleTerm EOF )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:379:2: ruleSimpleTerm EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getSimpleTermElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSimpleTerm();

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
    // $ANTLR end "entryRuleSimpleTerm"


    // $ANTLR start "ruleSimpleTerm"
    // PsiInternalExBacktrackingBug325745TestLanguage.g:384:1: ruleSimpleTerm : ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) ) ;
    public final void ruleSimpleTerm() throws RecognitionException {
        Token lv_lineCount_0_0=null;
        Token otherlv_1=null;
        Token lv_charCount_2_0=null;
        Token otherlv_3=null;
        Token lv_charSet_4_0=null;
        Token lv_refChar_5_0=null;

        try {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:384:15: ( ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) ) )
            // PsiInternalExBacktrackingBug325745TestLanguage.g:385:2: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )
            {
            // PsiInternalExBacktrackingBug325745TestLanguage.g:385:2: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_INT) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:386:3: ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? )
                    {
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:386:3: ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? )
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:387:4: ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )?
                    {
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:387:4: ( (lv_lineCount_0_0= RULE_INT ) )
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:388:5: (lv_lineCount_0_0= RULE_INT )
                    {
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:388:5: (lv_lineCount_0_0= RULE_INT )
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:389:6: lv_lineCount_0_0= RULE_INT
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSimpleTerm_LineCountINTTerminalRuleCall_0_0_0ElementType());
                      					
                    }
                    lv_lineCount_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_11); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_lineCount_0_0);
                      					
                    }

                    }


                    }

                    // PsiInternalExBacktrackingBug325745TestLanguage.g:398:4: (otherlv_1= '*' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==15) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // PsiInternalExBacktrackingBug325745TestLanguage.g:399:5: otherlv_1= '*'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getSimpleTerm_AsteriskKeyword_0_1ElementType());
                              				
                            }
                            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_12); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(otherlv_1);
                              				
                            }

                            }
                            break;

                    }

                    // PsiInternalExBacktrackingBug325745TestLanguage.g:407:4: ( (lv_charCount_2_0= RULE_INT ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_INT) ) {
                        int LA10_1 = input.LA(2);

                        if ( (synpred12_PsiInternalExBacktrackingBug325745TestLanguage()) ) {
                            alt10=1;
                        }
                    }
                    switch (alt10) {
                        case 1 :
                            // PsiInternalExBacktrackingBug325745TestLanguage.g:408:5: (lv_charCount_2_0= RULE_INT )
                            {
                            // PsiInternalExBacktrackingBug325745TestLanguage.g:408:5: (lv_charCount_2_0= RULE_INT )
                            // PsiInternalExBacktrackingBug325745TestLanguage.g:409:6: lv_charCount_2_0= RULE_INT
                            {
                            if ( state.backtracking==0 ) {

                              						markLeaf(elementTypeProvider.getSimpleTerm_CharCountINTTerminalRuleCall_0_2_0ElementType());
                              					
                            }
                            lv_charCount_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_13); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              						doneLeaf(lv_charCount_2_0);
                              					
                            }

                            }


                            }
                            break;

                    }

                    // PsiInternalExBacktrackingBug325745TestLanguage.g:418:4: (otherlv_3= '!' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==16) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // PsiInternalExBacktrackingBug325745TestLanguage.g:419:5: otherlv_3= '!'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getSimpleTerm_ExclamationMarkKeyword_0_3ElementType());
                              				
                            }
                            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(otherlv_3);
                              				
                            }

                            }
                            break;

                    }

                    // PsiInternalExBacktrackingBug325745TestLanguage.g:427:4: ( (lv_charSet_4_0= RULE_ID ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==RULE_ID) ) {
                        int LA12_1 = input.LA(2);

                        if ( (synpred14_PsiInternalExBacktrackingBug325745TestLanguage()) ) {
                            alt12=1;
                        }
                    }
                    switch (alt12) {
                        case 1 :
                            // PsiInternalExBacktrackingBug325745TestLanguage.g:428:5: (lv_charSet_4_0= RULE_ID )
                            {
                            // PsiInternalExBacktrackingBug325745TestLanguage.g:428:5: (lv_charSet_4_0= RULE_ID )
                            // PsiInternalExBacktrackingBug325745TestLanguage.g:429:6: lv_charSet_4_0= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              						markLeaf(elementTypeProvider.getSimpleTerm_CharSetIDTerminalRuleCall_0_4_0ElementType());
                              					
                            }
                            lv_charSet_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              						doneLeaf(lv_charSet_4_0);
                              					
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:440:3: ( (lv_refChar_5_0= RULE_ID ) )
                    {
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:440:3: ( (lv_refChar_5_0= RULE_ID ) )
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:441:4: (lv_refChar_5_0= RULE_ID )
                    {
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:441:4: (lv_refChar_5_0= RULE_ID )
                    // PsiInternalExBacktrackingBug325745TestLanguage.g:442:5: lv_refChar_5_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getSimpleTerm_RefCharIDTerminalRuleCall_1_0ElementType());
                      				
                    }
                    lv_refChar_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_refChar_5_0);
                      				
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
        return ;
    }
    // $ANTLR end "ruleSimpleTerm"

    // $ANTLR start synpred2_PsiInternalExBacktrackingBug325745TestLanguage
    public final void synpred2_PsiInternalExBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        // PsiInternalExBacktrackingBug325745TestLanguage.g:131:4: ( (lv_dataType_1_0= ruleDataType ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:131:4: (lv_dataType_1_0= ruleDataType )
        {
        // PsiInternalExBacktrackingBug325745TestLanguage.g:131:4: (lv_dataType_1_0= ruleDataType )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:132:5: lv_dataType_1_0= ruleDataType
        {
        if ( state.backtracking==0 ) {

          					markComposite(elementTypeProvider.getElement_DataTypeDataTypeParserRuleCall_1_0ElementType());
          				
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleDataType();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_PsiInternalExBacktrackingBug325745TestLanguage

    // $ANTLR start synpred4_PsiInternalExBacktrackingBug325745TestLanguage
    public final void synpred4_PsiInternalExBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // PsiInternalExBacktrackingBug325745TestLanguage.g:243:4: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:243:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
        {
        // PsiInternalExBacktrackingBug325745TestLanguage.g:243:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:244:5: {...}? => ( ({...}? => (otherlv_2= '[' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred4_PsiInternalExBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)");
        }
        // PsiInternalExBacktrackingBug325745TestLanguage.g:244:107: ( ({...}? => (otherlv_2= '[' ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:245:6: ({...}? => (otherlv_2= '[' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
        // PsiInternalExBacktrackingBug325745TestLanguage.g:248:9: ({...}? => (otherlv_2= '[' ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:248:10: {...}? => (otherlv_2= '[' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred4_PsiInternalExBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalExBacktrackingBug325745TestLanguage.g:248:19: (otherlv_2= '[' )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:248:20: otherlv_2= '['
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getExpression_LeftSquareBracketKeyword_1_0ElementType());
          								
        }
        otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred4_PsiInternalExBacktrackingBug325745TestLanguage

    // $ANTLR start synpred5_PsiInternalExBacktrackingBug325745TestLanguage
    public final void synpred5_PsiInternalExBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_prefix_3_0=null;

        // PsiInternalExBacktrackingBug325745TestLanguage.g:261:4: ( ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:261:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
        {
        // PsiInternalExBacktrackingBug325745TestLanguage.g:261:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:262:5: {...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred5_PsiInternalExBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)");
        }
        // PsiInternalExBacktrackingBug325745TestLanguage.g:262:107: ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:263:6: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
        // PsiInternalExBacktrackingBug325745TestLanguage.g:266:9: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:266:10: {...}? => ( (lv_prefix_3_0= RULE_STRING ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred5_PsiInternalExBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalExBacktrackingBug325745TestLanguage.g:266:19: ( (lv_prefix_3_0= RULE_STRING ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:266:20: (lv_prefix_3_0= RULE_STRING )
        {
        // PsiInternalExBacktrackingBug325745TestLanguage.g:266:20: (lv_prefix_3_0= RULE_STRING )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:267:10: lv_prefix_3_0= RULE_STRING
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getExpression_PrefixSTRINGTerminalRuleCall_1_1_0ElementType());
          									
        }
        lv_prefix_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred5_PsiInternalExBacktrackingBug325745TestLanguage

    // $ANTLR start synpred7_PsiInternalExBacktrackingBug325745TestLanguage
    public final void synpred7_PsiInternalExBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // PsiInternalExBacktrackingBug325745TestLanguage.g:310:5: (otherlv_6= ']' )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:310:5: otherlv_6= ']'
        {
        if ( state.backtracking==0 ) {

          					markLeaf(elementTypeProvider.getExpression_RightSquareBracketKeyword_2_2ElementType());
          				
        }
        otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_PsiInternalExBacktrackingBug325745TestLanguage

    // $ANTLR start synpred9_PsiInternalExBacktrackingBug325745TestLanguage
    public final void synpred9_PsiInternalExBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;

        // PsiInternalExBacktrackingBug325745TestLanguage.g:326:4: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:326:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
        {
        // PsiInternalExBacktrackingBug325745TestLanguage.g:326:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:327:5: {...}? => ( ({...}? => (otherlv_8= ']' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalExBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)");
        }
        // PsiInternalExBacktrackingBug325745TestLanguage.g:327:107: ( ({...}? => (otherlv_8= ']' ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:328:6: ({...}? => (otherlv_8= ']' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
        // PsiInternalExBacktrackingBug325745TestLanguage.g:331:9: ({...}? => (otherlv_8= ']' ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:331:10: {...}? => (otherlv_8= ']' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalExBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalExBacktrackingBug325745TestLanguage.g:331:19: (otherlv_8= ']' )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:331:20: otherlv_8= ']'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getExpression_RightSquareBracketKeyword_3_0ElementType());
          								
        }
        otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred9_PsiInternalExBacktrackingBug325745TestLanguage

    // $ANTLR start synpred10_PsiInternalExBacktrackingBug325745TestLanguage
    public final void synpred10_PsiInternalExBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_postfix_9_0=null;

        // PsiInternalExBacktrackingBug325745TestLanguage.g:344:4: ( ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:344:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
        {
        // PsiInternalExBacktrackingBug325745TestLanguage.g:344:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:345:5: {...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalExBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)");
        }
        // PsiInternalExBacktrackingBug325745TestLanguage.g:345:107: ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:346:6: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
        // PsiInternalExBacktrackingBug325745TestLanguage.g:349:9: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:349:10: {...}? => ( (lv_postfix_9_0= RULE_STRING ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalExBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalExBacktrackingBug325745TestLanguage.g:349:19: ( (lv_postfix_9_0= RULE_STRING ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:349:20: (lv_postfix_9_0= RULE_STRING )
        {
        // PsiInternalExBacktrackingBug325745TestLanguage.g:349:20: (lv_postfix_9_0= RULE_STRING )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:350:10: lv_postfix_9_0= RULE_STRING
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getExpression_PostfixSTRINGTerminalRuleCall_3_1_0ElementType());
          									
        }
        lv_postfix_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred10_PsiInternalExBacktrackingBug325745TestLanguage

    // $ANTLR start synpred12_PsiInternalExBacktrackingBug325745TestLanguage
    public final void synpred12_PsiInternalExBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_charCount_2_0=null;

        // PsiInternalExBacktrackingBug325745TestLanguage.g:408:5: ( (lv_charCount_2_0= RULE_INT ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:408:5: (lv_charCount_2_0= RULE_INT )
        {
        // PsiInternalExBacktrackingBug325745TestLanguage.g:408:5: (lv_charCount_2_0= RULE_INT )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:409:6: lv_charCount_2_0= RULE_INT
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getSimpleTerm_CharCountINTTerminalRuleCall_0_2_0ElementType());
          					
        }
        lv_charCount_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_PsiInternalExBacktrackingBug325745TestLanguage

    // $ANTLR start synpred14_PsiInternalExBacktrackingBug325745TestLanguage
    public final void synpred14_PsiInternalExBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_charSet_4_0=null;

        // PsiInternalExBacktrackingBug325745TestLanguage.g:428:5: ( (lv_charSet_4_0= RULE_ID ) )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:428:5: (lv_charSet_4_0= RULE_ID )
        {
        // PsiInternalExBacktrackingBug325745TestLanguage.g:428:5: (lv_charSet_4_0= RULE_ID )
        // PsiInternalExBacktrackingBug325745TestLanguage.g:429:6: lv_charSet_4_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getSimpleTerm_CharSetIDTerminalRuleCall_0_4_0ElementType());
          					
        }
        lv_charSet_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_PsiInternalExBacktrackingBug325745TestLanguage

    // Delegated rules

    public final boolean synpred9_PsiInternalExBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_PsiInternalExBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_PsiInternalExBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_PsiInternalExBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_PsiInternalExBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_PsiInternalExBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_PsiInternalExBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_PsiInternalExBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_PsiInternalExBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_PsiInternalExBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_PsiInternalExBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_PsiInternalExBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_PsiInternalExBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PsiInternalExBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PsiInternalExBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalExBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000006870L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000006072L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000002050L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004022L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000018052L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010052L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000010012L});
    }


}
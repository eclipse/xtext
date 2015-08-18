package org.eclipse.xtext.parser.unorderedGroups.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.BacktrackingBug325745TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.unorderedGroups.services.BacktrackingBug325745TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalBacktrackingBug325745TestLanguageParser extends AbstractPsiAntlrParser {
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


        public PsiInternalBacktrackingBug325745TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBacktrackingBug325745TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBacktrackingBug325745TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBacktrackingBug325745TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

    	protected BacktrackingBug325745TestLanguageGrammarAccess grammarAccess;

    	protected BacktrackingBug325745TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBacktrackingBug325745TestLanguageParser(PsiBuilder builder, TokenStream input, BacktrackingBug325745TestLanguageElementTypeProvider elementTypeProvider, BacktrackingBug325745TestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalBacktrackingBug325745TestLanguage.g:59:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:59:15: ( ruleModel EOF )
            // PsiInternalBacktrackingBug325745TestLanguage.g:60:2: ruleModel EOF
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
    // PsiInternalBacktrackingBug325745TestLanguage.g:65:1: ruleModel : ( () ( (lv_fields_1_0= ruleElement ) )+ ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:65:10: ( ( () ( (lv_fields_1_0= ruleElement ) )+ ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:66:2: ( () ( (lv_fields_1_0= ruleElement ) )+ )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:66:2: ( () ( (lv_fields_1_0= ruleElement ) )+ )
            // PsiInternalBacktrackingBug325745TestLanguage.g:67:3: () ( (lv_fields_1_0= ruleElement ) )+
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:67:3: ()
            // PsiInternalBacktrackingBug325745TestLanguage.g:68:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getModel_ModelAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBacktrackingBug325745TestLanguage.g:76:3: ( (lv_fields_1_0= ruleElement ) )+
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
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:77:4: (lv_fields_1_0= ruleElement )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:77:4: (lv_fields_1_0= ruleElement )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:78:5: lv_fields_1_0= ruleElement
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
    // PsiInternalBacktrackingBug325745TestLanguage.g:91:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:91:17: ( ruleElement EOF )
            // PsiInternalBacktrackingBug325745TestLanguage.g:92:2: ruleElement EOF
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
    // PsiInternalBacktrackingBug325745TestLanguage.g:97:1: ruleElement : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' ) ;
    public final void ruleElement() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:97:12: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:98:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:98:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' )
            // PsiInternalBacktrackingBug325745TestLanguage.g:99:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.'
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:99:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:100:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:100:4: (lv_name_0_0= RULE_ID )
            // PsiInternalBacktrackingBug325745TestLanguage.g:101:5: lv_name_0_0= RULE_ID
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

            // PsiInternalBacktrackingBug325745TestLanguage.g:110:3: ( (lv_dataType_1_0= ruleDataType ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred2_PsiInternalBacktrackingBug325745TestLanguage()) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalBacktrackingBug325745TestLanguage.g:111:4: (lv_dataType_1_0= ruleDataType )
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:111:4: (lv_dataType_1_0= ruleDataType )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:112:5: lv_dataType_1_0= ruleDataType
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

            // PsiInternalBacktrackingBug325745TestLanguage.g:121:3: ( (lv_expression_2_0= ruleExpression ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:122:4: (lv_expression_2_0= ruleExpression )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:122:4: (lv_expression_2_0= ruleExpression )
            // PsiInternalBacktrackingBug325745TestLanguage.g:123:5: lv_expression_2_0= ruleExpression
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
    // PsiInternalBacktrackingBug325745TestLanguage.g:143:1: entryRuleDataType : ruleDataType EOF ;
    public final void entryRuleDataType() throws RecognitionException {
        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:143:18: ( ruleDataType EOF )
            // PsiInternalBacktrackingBug325745TestLanguage.g:144:2: ruleDataType EOF
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
    // PsiInternalBacktrackingBug325745TestLanguage.g:149:1: ruleDataType : ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? ) ;
    public final void ruleDataType() throws RecognitionException {
        Token lv_baseType_0_0=null;
        Token otherlv_1=null;
        Token lv_defaultValue_2_0=null;

        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:149:13: ( ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:150:2: ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:150:2: ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? )
            // PsiInternalBacktrackingBug325745TestLanguage.g:151:3: ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )?
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:151:3: ( (lv_baseType_0_0= RULE_ID ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:152:4: (lv_baseType_0_0= RULE_ID )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:152:4: (lv_baseType_0_0= RULE_ID )
            // PsiInternalBacktrackingBug325745TestLanguage.g:153:5: lv_baseType_0_0= RULE_ID
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

            // PsiInternalBacktrackingBug325745TestLanguage.g:162:3: (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalBacktrackingBug325745TestLanguage.g:163:4: otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getDataType_ColonEqualsSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_7); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalBacktrackingBug325745TestLanguage.g:170:4: ( (lv_defaultValue_2_0= RULE_STRING ) )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:171:5: (lv_defaultValue_2_0= RULE_STRING )
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:171:5: (lv_defaultValue_2_0= RULE_STRING )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:172:6: lv_defaultValue_2_0= RULE_STRING
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
    // PsiInternalBacktrackingBug325745TestLanguage.g:186:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {

        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 
        	grammarAccess.getExpressionAccess().getUnorderedGroup_3()
        	);

        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:191:2: ( ruleExpression EOF )
            // PsiInternalBacktrackingBug325745TestLanguage.g:192:2: ruleExpression EOF
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
    // PsiInternalBacktrackingBug325745TestLanguage.g:200:1: ruleExpression : ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) ) ;
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
            // PsiInternalBacktrackingBug325745TestLanguage.g:205:2: ( ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:206:2: ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:206:2: ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:207:3: () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:207:3: ()
            // PsiInternalBacktrackingBug325745TestLanguage.g:208:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getExpression_ExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBacktrackingBug325745TestLanguage.g:216:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:217:4: ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:217:4: ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:218:5: ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_1());
            // PsiInternalBacktrackingBug325745TestLanguage.g:221:5: ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* )
            // PsiInternalBacktrackingBug325745TestLanguage.g:222:6: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )*
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:222:6: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    int LA4_1 = input.LA(2);

                    if ( synpred4_PsiInternalBacktrackingBug325745TestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
                        alt4=1;
                    }


                }
                else if ( (LA4_0==RULE_STRING) ) {
                    int LA4_3 = input.LA(2);

                    if ( synpred5_PsiInternalBacktrackingBug325745TestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
                        alt4=2;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:223:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:223:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:224:5: {...}? => ( ({...}? => (otherlv_2= '[' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:224:107: ( ({...}? => (otherlv_2= '[' ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:225:6: ({...}? => (otherlv_2= '[' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:228:9: ({...}? => (otherlv_2= '[' ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:228:10: {...}? => (otherlv_2= '[' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:228:19: (otherlv_2= '[' )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:228:20: otherlv_2= '['
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
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:241:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:241:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:242:5: {...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:242:107: ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:243:6: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:246:9: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:246:10: {...}? => ( (lv_prefix_3_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:246:19: ( (lv_prefix_3_0= RULE_STRING ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:246:20: (lv_prefix_3_0= RULE_STRING )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:246:20: (lv_prefix_3_0= RULE_STRING )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:247:10: lv_prefix_3_0= RULE_STRING
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

            // PsiInternalBacktrackingBug325745TestLanguage.g:268:3: ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==RULE_INT||LA7_0==13) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:269:4: (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )?
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:269:4: (otherlv_4= '[' )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==13) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // PsiInternalBacktrackingBug325745TestLanguage.g:270:5: otherlv_4= '['
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

            	    // PsiInternalBacktrackingBug325745TestLanguage.g:278:4: ( (lv_terms_5_0= ruleSimpleTerm ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:279:5: (lv_terms_5_0= ruleSimpleTerm )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:279:5: (lv_terms_5_0= ruleSimpleTerm )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:280:6: lv_terms_5_0= ruleSimpleTerm
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

            	    // PsiInternalBacktrackingBug325745TestLanguage.g:289:4: (otherlv_6= ']' )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==14) ) {
            	        int LA6_1 = input.LA(2);

            	        if ( (synpred7_PsiInternalBacktrackingBug325745TestLanguage()) ) {
            	            alt6=1;
            	        }
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // PsiInternalBacktrackingBug325745TestLanguage.g:290:5: otherlv_6= ']'
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

            // PsiInternalBacktrackingBug325745TestLanguage.g:299:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:300:4: ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:300:4: ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:301:5: ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_3());
            // PsiInternalBacktrackingBug325745TestLanguage.g:304:5: ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* )
            // PsiInternalBacktrackingBug325745TestLanguage.g:305:6: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )*
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:305:6: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )*
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
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:306:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:306:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:307:5: {...}? => ( ({...}? => (otherlv_8= ']' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:307:107: ( ({...}? => (otherlv_8= ']' ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:308:6: ({...}? => (otherlv_8= ']' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:311:9: ({...}? => (otherlv_8= ']' ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:311:10: {...}? => (otherlv_8= ']' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:311:19: (otherlv_8= ']' )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:311:20: otherlv_8= ']'
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
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:324:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:324:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:325:5: {...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:325:107: ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:326:6: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:329:9: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:329:10: {...}? => ( (lv_postfix_9_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:329:19: ( (lv_postfix_9_0= RULE_STRING ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:329:20: (lv_postfix_9_0= RULE_STRING )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:329:20: (lv_postfix_9_0= RULE_STRING )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:330:10: lv_postfix_9_0= RULE_STRING
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
    // PsiInternalBacktrackingBug325745TestLanguage.g:358:1: entryRuleSimpleTerm : ruleSimpleTerm EOF ;
    public final void entryRuleSimpleTerm() throws RecognitionException {
        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:358:20: ( ruleSimpleTerm EOF )
            // PsiInternalBacktrackingBug325745TestLanguage.g:359:2: ruleSimpleTerm EOF
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
    // PsiInternalBacktrackingBug325745TestLanguage.g:364:1: ruleSimpleTerm : ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) ) ;
    public final void ruleSimpleTerm() throws RecognitionException {
        Token lv_lineCount_0_0=null;
        Token otherlv_1=null;
        Token lv_charCount_2_0=null;
        Token otherlv_3=null;
        Token lv_charSet_4_0=null;
        Token lv_refChar_5_0=null;

        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:364:15: ( ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:365:2: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:365:2: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )
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
                    // PsiInternalBacktrackingBug325745TestLanguage.g:366:3: ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? )
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:366:3: ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:367:4: ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )?
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:367:4: ( (lv_lineCount_0_0= RULE_INT ) )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:368:5: (lv_lineCount_0_0= RULE_INT )
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:368:5: (lv_lineCount_0_0= RULE_INT )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:369:6: lv_lineCount_0_0= RULE_INT
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

                    // PsiInternalBacktrackingBug325745TestLanguage.g:378:4: (otherlv_1= '*' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==15) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // PsiInternalBacktrackingBug325745TestLanguage.g:379:5: otherlv_1= '*'
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

                    // PsiInternalBacktrackingBug325745TestLanguage.g:387:4: ( (lv_charCount_2_0= RULE_INT ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_INT) ) {
                        int LA10_1 = input.LA(2);

                        if ( (synpred12_PsiInternalBacktrackingBug325745TestLanguage()) ) {
                            alt10=1;
                        }
                    }
                    switch (alt10) {
                        case 1 :
                            // PsiInternalBacktrackingBug325745TestLanguage.g:388:5: (lv_charCount_2_0= RULE_INT )
                            {
                            // PsiInternalBacktrackingBug325745TestLanguage.g:388:5: (lv_charCount_2_0= RULE_INT )
                            // PsiInternalBacktrackingBug325745TestLanguage.g:389:6: lv_charCount_2_0= RULE_INT
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

                    // PsiInternalBacktrackingBug325745TestLanguage.g:398:4: (otherlv_3= '!' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==16) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // PsiInternalBacktrackingBug325745TestLanguage.g:399:5: otherlv_3= '!'
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

                    // PsiInternalBacktrackingBug325745TestLanguage.g:407:4: ( (lv_charSet_4_0= RULE_ID ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==RULE_ID) ) {
                        int LA12_1 = input.LA(2);

                        if ( (synpred14_PsiInternalBacktrackingBug325745TestLanguage()) ) {
                            alt12=1;
                        }
                    }
                    switch (alt12) {
                        case 1 :
                            // PsiInternalBacktrackingBug325745TestLanguage.g:408:5: (lv_charSet_4_0= RULE_ID )
                            {
                            // PsiInternalBacktrackingBug325745TestLanguage.g:408:5: (lv_charSet_4_0= RULE_ID )
                            // PsiInternalBacktrackingBug325745TestLanguage.g:409:6: lv_charSet_4_0= RULE_ID
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
                    // PsiInternalBacktrackingBug325745TestLanguage.g:420:3: ( (lv_refChar_5_0= RULE_ID ) )
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:420:3: ( (lv_refChar_5_0= RULE_ID ) )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:421:4: (lv_refChar_5_0= RULE_ID )
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:421:4: (lv_refChar_5_0= RULE_ID )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:422:5: lv_refChar_5_0= RULE_ID
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

    // $ANTLR start synpred2_PsiInternalBacktrackingBug325745TestLanguage
    public final void synpred2_PsiInternalBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBacktrackingBug325745TestLanguage.g:111:4: ( (lv_dataType_1_0= ruleDataType ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:111:4: (lv_dataType_1_0= ruleDataType )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:111:4: (lv_dataType_1_0= ruleDataType )
        // PsiInternalBacktrackingBug325745TestLanguage.g:112:5: lv_dataType_1_0= ruleDataType
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
    // $ANTLR end synpred2_PsiInternalBacktrackingBug325745TestLanguage

    // $ANTLR start synpred4_PsiInternalBacktrackingBug325745TestLanguage
    public final void synpred4_PsiInternalBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // PsiInternalBacktrackingBug325745TestLanguage.g:223:4: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:223:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:223:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:224:5: {...}? => ( ({...}? => (otherlv_2= '[' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred4_PsiInternalBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:224:107: ( ({...}? => (otherlv_2= '[' ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:225:6: ({...}? => (otherlv_2= '[' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
        // PsiInternalBacktrackingBug325745TestLanguage.g:228:9: ({...}? => (otherlv_2= '[' ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:228:10: {...}? => (otherlv_2= '[' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred4_PsiInternalBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:228:19: (otherlv_2= '[' )
        // PsiInternalBacktrackingBug325745TestLanguage.g:228:20: otherlv_2= '['
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
    // $ANTLR end synpred4_PsiInternalBacktrackingBug325745TestLanguage

    // $ANTLR start synpred5_PsiInternalBacktrackingBug325745TestLanguage
    public final void synpred5_PsiInternalBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_prefix_3_0=null;

        // PsiInternalBacktrackingBug325745TestLanguage.g:241:4: ( ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:241:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:241:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:242:5: {...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred5_PsiInternalBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:242:107: ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:243:6: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
        // PsiInternalBacktrackingBug325745TestLanguage.g:246:9: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:246:10: {...}? => ( (lv_prefix_3_0= RULE_STRING ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred5_PsiInternalBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:246:19: ( (lv_prefix_3_0= RULE_STRING ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:246:20: (lv_prefix_3_0= RULE_STRING )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:246:20: (lv_prefix_3_0= RULE_STRING )
        // PsiInternalBacktrackingBug325745TestLanguage.g:247:10: lv_prefix_3_0= RULE_STRING
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
    // $ANTLR end synpred5_PsiInternalBacktrackingBug325745TestLanguage

    // $ANTLR start synpred7_PsiInternalBacktrackingBug325745TestLanguage
    public final void synpred7_PsiInternalBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // PsiInternalBacktrackingBug325745TestLanguage.g:290:5: (otherlv_6= ']' )
        // PsiInternalBacktrackingBug325745TestLanguage.g:290:5: otherlv_6= ']'
        {
        if ( state.backtracking==0 ) {

          					markLeaf(elementTypeProvider.getExpression_RightSquareBracketKeyword_2_2ElementType());
          				
        }
        otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_PsiInternalBacktrackingBug325745TestLanguage

    // $ANTLR start synpred9_PsiInternalBacktrackingBug325745TestLanguage
    public final void synpred9_PsiInternalBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;

        // PsiInternalBacktrackingBug325745TestLanguage.g:306:4: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:306:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:306:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:307:5: {...}? => ( ({...}? => (otherlv_8= ']' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:307:107: ( ({...}? => (otherlv_8= ']' ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:308:6: ({...}? => (otherlv_8= ']' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
        // PsiInternalBacktrackingBug325745TestLanguage.g:311:9: ({...}? => (otherlv_8= ']' ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:311:10: {...}? => (otherlv_8= ']' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:311:19: (otherlv_8= ']' )
        // PsiInternalBacktrackingBug325745TestLanguage.g:311:20: otherlv_8= ']'
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
    // $ANTLR end synpred9_PsiInternalBacktrackingBug325745TestLanguage

    // $ANTLR start synpred10_PsiInternalBacktrackingBug325745TestLanguage
    public final void synpred10_PsiInternalBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_postfix_9_0=null;

        // PsiInternalBacktrackingBug325745TestLanguage.g:324:4: ( ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:324:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:324:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:325:5: {...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:325:107: ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:326:6: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
        // PsiInternalBacktrackingBug325745TestLanguage.g:329:9: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:329:10: {...}? => ( (lv_postfix_9_0= RULE_STRING ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:329:19: ( (lv_postfix_9_0= RULE_STRING ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:329:20: (lv_postfix_9_0= RULE_STRING )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:329:20: (lv_postfix_9_0= RULE_STRING )
        // PsiInternalBacktrackingBug325745TestLanguage.g:330:10: lv_postfix_9_0= RULE_STRING
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
    // $ANTLR end synpred10_PsiInternalBacktrackingBug325745TestLanguage

    // $ANTLR start synpred12_PsiInternalBacktrackingBug325745TestLanguage
    public final void synpred12_PsiInternalBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_charCount_2_0=null;

        // PsiInternalBacktrackingBug325745TestLanguage.g:388:5: ( (lv_charCount_2_0= RULE_INT ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:388:5: (lv_charCount_2_0= RULE_INT )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:388:5: (lv_charCount_2_0= RULE_INT )
        // PsiInternalBacktrackingBug325745TestLanguage.g:389:6: lv_charCount_2_0= RULE_INT
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getSimpleTerm_CharCountINTTerminalRuleCall_0_2_0ElementType());
          					
        }
        lv_charCount_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_PsiInternalBacktrackingBug325745TestLanguage

    // $ANTLR start synpred14_PsiInternalBacktrackingBug325745TestLanguage
    public final void synpred14_PsiInternalBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_charSet_4_0=null;

        // PsiInternalBacktrackingBug325745TestLanguage.g:408:5: ( (lv_charSet_4_0= RULE_ID ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:408:5: (lv_charSet_4_0= RULE_ID )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:408:5: (lv_charSet_4_0= RULE_ID )
        // PsiInternalBacktrackingBug325745TestLanguage.g:409:6: lv_charSet_4_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getSimpleTerm_CharSetIDTerminalRuleCall_0_4_0ElementType());
          					
        }
        lv_charSet_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_PsiInternalBacktrackingBug325745TestLanguage

    // Delegated rules

    public final boolean synpred12_PsiInternalBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_PsiInternalBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_PsiInternalBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_PsiInternalBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_PsiInternalBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_PsiInternalBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_PsiInternalBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PsiInternalBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PsiInternalBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_PsiInternalBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_PsiInternalBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_PsiInternalBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_PsiInternalBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_PsiInternalBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_PsiInternalBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
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
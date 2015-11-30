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
    // PsiInternalBacktrackingBug325745TestLanguage.g:59:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:59:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBacktrackingBug325745TestLanguage.g:60:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalBacktrackingBug325745TestLanguage.g:66:1: ruleModel returns [Boolean current=false] : ( () ( (lv_fields_1_0= ruleElement ) )+ ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_fields_1_0 = null;


        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:67:1: ( ( () ( (lv_fields_1_0= ruleElement ) )+ ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:68:2: ( () ( (lv_fields_1_0= ruleElement ) )+ )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:68:2: ( () ( (lv_fields_1_0= ruleElement ) )+ )
            // PsiInternalBacktrackingBug325745TestLanguage.g:69:3: () ( (lv_fields_1_0= ruleElement ) )+
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:69:3: ()
            // PsiInternalBacktrackingBug325745TestLanguage.g:70:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getModel_ModelAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBacktrackingBug325745TestLanguage.g:79:3: ( (lv_fields_1_0= ruleElement ) )+
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
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:80:4: (lv_fields_1_0= ruleElement )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:80:4: (lv_fields_1_0= ruleElement )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:81:5: lv_fields_1_0= ruleElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getModel_FieldsElementParserRuleCall_1_0ElementType());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_fields_1_0=ruleElement();

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
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return current;}
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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleElement"
    // PsiInternalBacktrackingBug325745TestLanguage.g:98:1: entryRuleElement returns [Boolean current=false] : iv_ruleElement= ruleElement EOF ;
    public final Boolean entryRuleElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleElement = null;


        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:98:49: (iv_ruleElement= ruleElement EOF )
            // PsiInternalBacktrackingBug325745TestLanguage.g:99:2: iv_ruleElement= ruleElement EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getElementElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElement; 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // PsiInternalBacktrackingBug325745TestLanguage.g:105:1: ruleElement returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' ) ;
    public final Boolean ruleElement() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_3=null;
        Boolean lv_dataType_1_0 = null;

        Boolean lv_expression_2_0 = null;


        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:106:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:107:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:107:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' )
            // PsiInternalBacktrackingBug325745TestLanguage.g:108:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.'
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:108:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:109:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:109:4: (lv_name_0_0= RULE_ID )
            // PsiInternalBacktrackingBug325745TestLanguage.g:110:5: lv_name_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getElement_NameIDTerminalRuleCall_0_0ElementType());
              				
            }
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_0_0);
              				
            }

            }


            }

            // PsiInternalBacktrackingBug325745TestLanguage.g:125:3: ( (lv_dataType_1_0= ruleDataType ) )?
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
                    // PsiInternalBacktrackingBug325745TestLanguage.g:126:4: (lv_dataType_1_0= ruleDataType )
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:126:4: (lv_dataType_1_0= ruleDataType )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:127:5: lv_dataType_1_0= ruleDataType
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getElement_DataTypeDataTypeParserRuleCall_1_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_dataType_1_0=ruleDataType();

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

            }

            // PsiInternalBacktrackingBug325745TestLanguage.g:140:3: ( (lv_expression_2_0= ruleExpression ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:141:4: (lv_expression_2_0= ruleExpression )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:141:4: (lv_expression_2_0= ruleExpression )
            // PsiInternalBacktrackingBug325745TestLanguage.g:142:5: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getElement_ExpressionExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_5);
            lv_expression_2_0=ruleExpression();

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

              			markLeaf(elementTypeProvider.getElement_FullStopKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleDataType"
    // PsiInternalBacktrackingBug325745TestLanguage.g:166:1: entryRuleDataType returns [Boolean current=false] : iv_ruleDataType= ruleDataType EOF ;
    public final Boolean entryRuleDataType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDataType = null;


        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:166:50: (iv_ruleDataType= ruleDataType EOF )
            // PsiInternalBacktrackingBug325745TestLanguage.g:167:2: iv_ruleDataType= ruleDataType EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDataTypeElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataType=ruleDataType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataType; 
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
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // PsiInternalBacktrackingBug325745TestLanguage.g:173:1: ruleDataType returns [Boolean current=false] : ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? ) ;
    public final Boolean ruleDataType() throws RecognitionException {
        Boolean current = false;

        Token lv_baseType_0_0=null;
        Token otherlv_1=null;
        Token lv_defaultValue_2_0=null;

        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:174:1: ( ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:175:2: ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:175:2: ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? )
            // PsiInternalBacktrackingBug325745TestLanguage.g:176:3: ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )?
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:176:3: ( (lv_baseType_0_0= RULE_ID ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:177:4: (lv_baseType_0_0= RULE_ID )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:177:4: (lv_baseType_0_0= RULE_ID )
            // PsiInternalBacktrackingBug325745TestLanguage.g:178:5: lv_baseType_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getDataType_BaseTypeIDTerminalRuleCall_0_0ElementType());
              				
            }
            lv_baseType_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_baseType_0_0);
              				
            }

            }


            }

            // PsiInternalBacktrackingBug325745TestLanguage.g:193:3: (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalBacktrackingBug325745TestLanguage.g:194:4: otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getDataType_ColonEqualsSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalBacktrackingBug325745TestLanguage.g:201:4: ( (lv_defaultValue_2_0= RULE_STRING ) )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:202:5: (lv_defaultValue_2_0= RULE_STRING )
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:202:5: (lv_defaultValue_2_0= RULE_STRING )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:203:6: lv_defaultValue_2_0= RULE_STRING
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getDataType_DefaultValueSTRINGTerminalRuleCall_1_1_0ElementType());
                      					
                    }
                    lv_defaultValue_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
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
        return current;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleExpression"
    // PsiInternalBacktrackingBug325745TestLanguage.g:223:1: entryRuleExpression returns [Boolean current=false] : iv_ruleExpression= ruleExpression EOF ;
    public final Boolean entryRuleExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExpression = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 
        	grammarAccess.getExpressionAccess().getUnorderedGroup_3()
        	);

        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:228:2: (iv_ruleExpression= ruleExpression EOF )
            // PsiInternalBacktrackingBug325745TestLanguage.g:229:2: iv_ruleExpression= ruleExpression EOF
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

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // PsiInternalBacktrackingBug325745TestLanguage.g:238:1: ruleExpression returns [Boolean current=false] : ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) ) ;
    public final Boolean ruleExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token lv_prefix_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_postfix_9_0=null;
        Boolean lv_terms_5_0 = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 
        	grammarAccess.getExpressionAccess().getUnorderedGroup_3()
        	);

        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:244:2: ( ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:245:2: ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:245:2: ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:246:3: () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:246:3: ()
            // PsiInternalBacktrackingBug325745TestLanguage.g:247:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getExpression_ExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBacktrackingBug325745TestLanguage.g:256:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:257:4: ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:257:4: ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:258:5: ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_1());
            // PsiInternalBacktrackingBug325745TestLanguage.g:261:5: ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* )
            // PsiInternalBacktrackingBug325745TestLanguage.g:262:6: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )*
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:262:6: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )*
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
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:263:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:263:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:264:5: {...}? => ( ({...}? => (otherlv_2= '[' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:264:107: ( ({...}? => (otherlv_2= '[' ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:265:6: ({...}? => (otherlv_2= '[' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:268:9: ({...}? => (otherlv_2= '[' ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:268:10: {...}? => (otherlv_2= '[' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:268:19: (otherlv_2= '[' )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:268:20: otherlv_2= '['
            	    {
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getExpression_LeftSquareBracketKeyword_1_0ElementType());
            	      								
            	    }
            	    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_8); if (state.failed) return current;
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
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:281:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:281:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:282:5: {...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:282:107: ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:283:6: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:286:9: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:286:10: {...}? => ( (lv_prefix_3_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:286:19: ( (lv_prefix_3_0= RULE_STRING ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:286:20: (lv_prefix_3_0= RULE_STRING )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:286:20: (lv_prefix_3_0= RULE_STRING )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:287:10: lv_prefix_3_0= RULE_STRING
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getExpression_PrefixSTRINGTerminalRuleCall_1_1_0ElementType());
            	      									
            	    }
            	    lv_prefix_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										if(!current) {
            	      											associateWithSemanticElement();
            	      											current = true;
            	      										}
            	      									
            	    }
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

            // PsiInternalBacktrackingBug325745TestLanguage.g:314:3: ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==RULE_INT||LA7_0==13) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:315:4: (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )?
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:315:4: (otherlv_4= '[' )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==13) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // PsiInternalBacktrackingBug325745TestLanguage.g:316:5: otherlv_4= '['
            	            {
            	            if ( state.backtracking==0 ) {

            	              					markLeaf(elementTypeProvider.getExpression_LeftSquareBracketKeyword_2_0ElementType());
            	              				
            	            }
            	            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					doneLeaf(otherlv_4);
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    // PsiInternalBacktrackingBug325745TestLanguage.g:324:4: ( (lv_terms_5_0= ruleSimpleTerm ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:325:5: (lv_terms_5_0= ruleSimpleTerm )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:325:5: (lv_terms_5_0= ruleSimpleTerm )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:326:6: lv_terms_5_0= ruleSimpleTerm
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getExpression_TermsSimpleTermParserRuleCall_2_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_terms_5_0=ruleSimpleTerm();

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

            	    // PsiInternalBacktrackingBug325745TestLanguage.g:339:4: (otherlv_6= ']' )?
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
            	            // PsiInternalBacktrackingBug325745TestLanguage.g:340:5: otherlv_6= ']'
            	            {
            	            if ( state.backtracking==0 ) {

            	              					markLeaf(elementTypeProvider.getExpression_RightSquareBracketKeyword_2_2ElementType());
            	              				
            	            }
            	            otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_8); if (state.failed) return current;
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

            // PsiInternalBacktrackingBug325745TestLanguage.g:349:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:350:4: ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:350:4: ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:351:5: ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_3());
            // PsiInternalBacktrackingBug325745TestLanguage.g:354:5: ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* )
            // PsiInternalBacktrackingBug325745TestLanguage.g:355:6: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )*
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:355:6: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )*
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
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:356:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:356:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:357:5: {...}? => ( ({...}? => (otherlv_8= ']' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:357:107: ( ({...}? => (otherlv_8= ']' ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:358:6: ({...}? => (otherlv_8= ']' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:361:9: ({...}? => (otherlv_8= ']' ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:361:10: {...}? => (otherlv_8= ']' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:361:19: (otherlv_8= ']' )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:361:20: otherlv_8= ']'
            	    {
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getExpression_RightSquareBracketKeyword_3_0ElementType());
            	      								
            	    }
            	    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_10); if (state.failed) return current;
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
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:374:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:374:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:375:5: {...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:375:107: ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:376:6: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:379:9: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:379:10: {...}? => ( (lv_postfix_9_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:379:19: ( (lv_postfix_9_0= RULE_STRING ) )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:379:20: (lv_postfix_9_0= RULE_STRING )
            	    {
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:379:20: (lv_postfix_9_0= RULE_STRING )
            	    // PsiInternalBacktrackingBug325745TestLanguage.g:380:10: lv_postfix_9_0= RULE_STRING
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getExpression_PostfixSTRINGTerminalRuleCall_3_1_0ElementType());
            	      									
            	    }
            	    lv_postfix_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										if(!current) {
            	      											associateWithSemanticElement();
            	      											current = true;
            	      										}
            	      									
            	    }
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
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleSimpleTerm"
    // PsiInternalBacktrackingBug325745TestLanguage.g:414:1: entryRuleSimpleTerm returns [Boolean current=false] : iv_ruleSimpleTerm= ruleSimpleTerm EOF ;
    public final Boolean entryRuleSimpleTerm() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimpleTerm = null;


        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:414:52: (iv_ruleSimpleTerm= ruleSimpleTerm EOF )
            // PsiInternalBacktrackingBug325745TestLanguage.g:415:2: iv_ruleSimpleTerm= ruleSimpleTerm EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getSimpleTermElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleTerm=ruleSimpleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleTerm; 
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
    // $ANTLR end "entryRuleSimpleTerm"


    // $ANTLR start "ruleSimpleTerm"
    // PsiInternalBacktrackingBug325745TestLanguage.g:421:1: ruleSimpleTerm returns [Boolean current=false] : ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) ) ;
    public final Boolean ruleSimpleTerm() throws RecognitionException {
        Boolean current = false;

        Token lv_lineCount_0_0=null;
        Token otherlv_1=null;
        Token lv_charCount_2_0=null;
        Token otherlv_3=null;
        Token lv_charSet_4_0=null;
        Token lv_refChar_5_0=null;

        try {
            // PsiInternalBacktrackingBug325745TestLanguage.g:422:1: ( ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) ) )
            // PsiInternalBacktrackingBug325745TestLanguage.g:423:2: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )
            {
            // PsiInternalBacktrackingBug325745TestLanguage.g:423:2: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_INT) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // PsiInternalBacktrackingBug325745TestLanguage.g:424:3: ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? )
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:424:3: ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:425:4: ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )?
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:425:4: ( (lv_lineCount_0_0= RULE_INT ) )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:426:5: (lv_lineCount_0_0= RULE_INT )
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:426:5: (lv_lineCount_0_0= RULE_INT )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:427:6: lv_lineCount_0_0= RULE_INT
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSimpleTerm_LineCountINTTerminalRuleCall_0_0_0ElementType());
                      					
                    }
                    lv_lineCount_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_lineCount_0_0);
                      					
                    }

                    }


                    }

                    // PsiInternalBacktrackingBug325745TestLanguage.g:442:4: (otherlv_1= '*' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==15) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // PsiInternalBacktrackingBug325745TestLanguage.g:443:5: otherlv_1= '*'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getSimpleTerm_AsteriskKeyword_0_1ElementType());
                              				
                            }
                            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(otherlv_1);
                              				
                            }

                            }
                            break;

                    }

                    // PsiInternalBacktrackingBug325745TestLanguage.g:451:4: ( (lv_charCount_2_0= RULE_INT ) )?
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
                            // PsiInternalBacktrackingBug325745TestLanguage.g:452:5: (lv_charCount_2_0= RULE_INT )
                            {
                            // PsiInternalBacktrackingBug325745TestLanguage.g:452:5: (lv_charCount_2_0= RULE_INT )
                            // PsiInternalBacktrackingBug325745TestLanguage.g:453:6: lv_charCount_2_0= RULE_INT
                            {
                            if ( state.backtracking==0 ) {

                              						markLeaf(elementTypeProvider.getSimpleTerm_CharCountINTTerminalRuleCall_0_2_0ElementType());
                              					
                            }
                            lv_charCount_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if(!current) {
                              							associateWithSemanticElement();
                              							current = true;
                              						}
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						doneLeaf(lv_charCount_2_0);
                              					
                            }

                            }


                            }
                            break;

                    }

                    // PsiInternalBacktrackingBug325745TestLanguage.g:468:4: (otherlv_3= '!' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==16) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // PsiInternalBacktrackingBug325745TestLanguage.g:469:5: otherlv_3= '!'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getSimpleTerm_ExclamationMarkKeyword_0_3ElementType());
                              				
                            }
                            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(otherlv_3);
                              				
                            }

                            }
                            break;

                    }

                    // PsiInternalBacktrackingBug325745TestLanguage.g:477:4: ( (lv_charSet_4_0= RULE_ID ) )?
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
                            // PsiInternalBacktrackingBug325745TestLanguage.g:478:5: (lv_charSet_4_0= RULE_ID )
                            {
                            // PsiInternalBacktrackingBug325745TestLanguage.g:478:5: (lv_charSet_4_0= RULE_ID )
                            // PsiInternalBacktrackingBug325745TestLanguage.g:479:6: lv_charSet_4_0= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              						markLeaf(elementTypeProvider.getSimpleTerm_CharSetIDTerminalRuleCall_0_4_0ElementType());
                              					
                            }
                            lv_charSet_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if(!current) {
                              							associateWithSemanticElement();
                              							current = true;
                              						}
                              					
                            }
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
                    // PsiInternalBacktrackingBug325745TestLanguage.g:496:3: ( (lv_refChar_5_0= RULE_ID ) )
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:496:3: ( (lv_refChar_5_0= RULE_ID ) )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:497:4: (lv_refChar_5_0= RULE_ID )
                    {
                    // PsiInternalBacktrackingBug325745TestLanguage.g:497:4: (lv_refChar_5_0= RULE_ID )
                    // PsiInternalBacktrackingBug325745TestLanguage.g:498:5: lv_refChar_5_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getSimpleTerm_RefCharIDTerminalRuleCall_1_0ElementType());
                      				
                    }
                    lv_refChar_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }
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
        return current;
    }
    // $ANTLR end "ruleSimpleTerm"

    // $ANTLR start synpred2_PsiInternalBacktrackingBug325745TestLanguage
    public final void synpred2_PsiInternalBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Boolean lv_dataType_1_0 = null;


        // PsiInternalBacktrackingBug325745TestLanguage.g:126:4: ( (lv_dataType_1_0= ruleDataType ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:126:4: (lv_dataType_1_0= ruleDataType )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:126:4: (lv_dataType_1_0= ruleDataType )
        // PsiInternalBacktrackingBug325745TestLanguage.g:127:5: lv_dataType_1_0= ruleDataType
        {
        if ( state.backtracking==0 ) {

          					markComposite(elementTypeProvider.getElement_DataTypeDataTypeParserRuleCall_1_0ElementType());
          				
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_dataType_1_0=ruleDataType();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_PsiInternalBacktrackingBug325745TestLanguage

    // $ANTLR start synpred4_PsiInternalBacktrackingBug325745TestLanguage
    public final void synpred4_PsiInternalBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // PsiInternalBacktrackingBug325745TestLanguage.g:263:4: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:263:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:263:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:264:5: {...}? => ( ({...}? => (otherlv_2= '[' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred4_PsiInternalBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:264:107: ( ({...}? => (otherlv_2= '[' ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:265:6: ({...}? => (otherlv_2= '[' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
        // PsiInternalBacktrackingBug325745TestLanguage.g:268:9: ({...}? => (otherlv_2= '[' ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:268:10: {...}? => (otherlv_2= '[' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred4_PsiInternalBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:268:19: (otherlv_2= '[' )
        // PsiInternalBacktrackingBug325745TestLanguage.g:268:20: otherlv_2= '['
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

        // PsiInternalBacktrackingBug325745TestLanguage.g:281:4: ( ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:281:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:281:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:282:5: {...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred5_PsiInternalBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:282:107: ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:283:6: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
        // PsiInternalBacktrackingBug325745TestLanguage.g:286:9: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:286:10: {...}? => ( (lv_prefix_3_0= RULE_STRING ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred5_PsiInternalBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:286:19: ( (lv_prefix_3_0= RULE_STRING ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:286:20: (lv_prefix_3_0= RULE_STRING )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:286:20: (lv_prefix_3_0= RULE_STRING )
        // PsiInternalBacktrackingBug325745TestLanguage.g:287:10: lv_prefix_3_0= RULE_STRING
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

        // PsiInternalBacktrackingBug325745TestLanguage.g:340:5: (otherlv_6= ']' )
        // PsiInternalBacktrackingBug325745TestLanguage.g:340:5: otherlv_6= ']'
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

        // PsiInternalBacktrackingBug325745TestLanguage.g:356:4: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:356:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:356:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:357:5: {...}? => ( ({...}? => (otherlv_8= ']' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:357:107: ( ({...}? => (otherlv_8= ']' ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:358:6: ({...}? => (otherlv_8= ']' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
        // PsiInternalBacktrackingBug325745TestLanguage.g:361:9: ({...}? => (otherlv_8= ']' ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:361:10: {...}? => (otherlv_8= ']' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:361:19: (otherlv_8= ']' )
        // PsiInternalBacktrackingBug325745TestLanguage.g:361:20: otherlv_8= ']'
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

        // PsiInternalBacktrackingBug325745TestLanguage.g:374:4: ( ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:374:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:374:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:375:5: {...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:375:107: ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:376:6: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
        // PsiInternalBacktrackingBug325745TestLanguage.g:379:9: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:379:10: {...}? => ( (lv_postfix_9_0= RULE_STRING ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalBacktrackingBug325745TestLanguage.g:379:19: ( (lv_postfix_9_0= RULE_STRING ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:379:20: (lv_postfix_9_0= RULE_STRING )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:379:20: (lv_postfix_9_0= RULE_STRING )
        // PsiInternalBacktrackingBug325745TestLanguage.g:380:10: lv_postfix_9_0= RULE_STRING
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

        // PsiInternalBacktrackingBug325745TestLanguage.g:452:5: ( (lv_charCount_2_0= RULE_INT ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:452:5: (lv_charCount_2_0= RULE_INT )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:452:5: (lv_charCount_2_0= RULE_INT )
        // PsiInternalBacktrackingBug325745TestLanguage.g:453:6: lv_charCount_2_0= RULE_INT
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

        // PsiInternalBacktrackingBug325745TestLanguage.g:478:5: ( (lv_charSet_4_0= RULE_ID ) )
        // PsiInternalBacktrackingBug325745TestLanguage.g:478:5: (lv_charSet_4_0= RULE_ID )
        {
        // PsiInternalBacktrackingBug325745TestLanguage.g:478:5: (lv_charSet_4_0= RULE_ID )
        // PsiInternalBacktrackingBug325745TestLanguage.g:479:6: lv_charSet_4_0= RULE_ID
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
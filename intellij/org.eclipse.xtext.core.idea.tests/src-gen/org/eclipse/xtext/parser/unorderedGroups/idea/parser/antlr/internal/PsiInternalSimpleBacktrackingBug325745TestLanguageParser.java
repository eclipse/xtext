package org.eclipse.xtext.parser.unorderedGroups.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.unorderedGroups.services.SimpleBacktrackingBug325745TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalSimpleBacktrackingBug325745TestLanguageParser extends AbstractPsiAntlrParser {
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


        public PsiInternalSimpleBacktrackingBug325745TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalSimpleBacktrackingBug325745TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalSimpleBacktrackingBug325745TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalSimpleBacktrackingBug325745TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

    	protected SimpleBacktrackingBug325745TestLanguageGrammarAccess grammarAccess;

    	protected SimpleBacktrackingBug325745TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalSimpleBacktrackingBug325745TestLanguageParser(PsiBuilder builder, TokenStream input, SimpleBacktrackingBug325745TestLanguageElementTypeProvider elementTypeProvider, SimpleBacktrackingBug325745TestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:59:1: entryRuleDelegateModel returns [Boolean current=false] : iv_ruleDelegateModel= ruleDelegateModel EOF ;
    public final Boolean entryRuleDelegateModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDelegateModel = null;


        try {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:59:55: (iv_ruleDelegateModel= ruleDelegateModel EOF )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:60:2: iv_ruleDelegateModel= ruleDelegateModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDelegateModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDelegateModel=ruleDelegateModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDelegateModel; 
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
    // $ANTLR end "entryRuleDelegateModel"


    // $ANTLR start "ruleDelegateModel"
    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:66:1: ruleDelegateModel returns [Boolean current=false] : this_Model_0= ruleModel ;
    public final Boolean ruleDelegateModel() throws RecognitionException {
        Boolean current = false;

        Boolean this_Model_0 = null;


        try {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:67:1: (this_Model_0= ruleModel )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:68:2: this_Model_0= ruleModel
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getDelegateModel_ModelParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Model_0=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_Model_0;
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
    // $ANTLR end "ruleDelegateModel"


    // $ANTLR start "entryRuleModel"
    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:82:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:82:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:83:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:89:1: ruleModel returns [Boolean current=false] : ( () ( (lv_fields_1_0= ruleElement ) )+ ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_fields_1_0 = null;


        try {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:90:1: ( ( () ( (lv_fields_1_0= ruleElement ) )+ ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:91:2: ( () ( (lv_fields_1_0= ruleElement ) )+ )
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:91:2: ( () ( (lv_fields_1_0= ruleElement ) )+ )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:92:3: () ( (lv_fields_1_0= ruleElement ) )+
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:92:3: ()
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:93:4: 
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

            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:102:3: ( (lv_fields_1_0= ruleElement ) )+
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
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:103:4: (lv_fields_1_0= ruleElement )
            	    {
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:103:4: (lv_fields_1_0= ruleElement )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:104:5: lv_fields_1_0= ruleElement
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
    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:121:1: entryRuleElement returns [Boolean current=false] : iv_ruleElement= ruleElement EOF ;
    public final Boolean entryRuleElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleElement = null;


        try {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:121:49: (iv_ruleElement= ruleElement EOF )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:122:2: iv_ruleElement= ruleElement EOF
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
    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:128:1: ruleElement returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' ) ;
    public final Boolean ruleElement() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_3=null;
        Boolean lv_dataType_1_0 = null;

        Boolean lv_expression_2_0 = null;


        try {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:129:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:130:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' )
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:130:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:131:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.'
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:131:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:132:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:132:4: (lv_name_0_0= RULE_ID )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:133:5: lv_name_0_0= RULE_ID
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

            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:148:3: ( (lv_dataType_1_0= ruleDataType ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred2_PsiInternalSimpleBacktrackingBug325745TestLanguage()) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:149:4: (lv_dataType_1_0= ruleDataType )
                    {
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:149:4: (lv_dataType_1_0= ruleDataType )
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:150:5: lv_dataType_1_0= ruleDataType
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

            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:163:3: ( (lv_expression_2_0= ruleExpression ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:164:4: (lv_expression_2_0= ruleExpression )
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:164:4: (lv_expression_2_0= ruleExpression )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:165:5: lv_expression_2_0= ruleExpression
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
    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:189:1: entryRuleDataType returns [Boolean current=false] : iv_ruleDataType= ruleDataType EOF ;
    public final Boolean entryRuleDataType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDataType = null;


        try {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:189:50: (iv_ruleDataType= ruleDataType EOF )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:190:2: iv_ruleDataType= ruleDataType EOF
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
    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:196:1: ruleDataType returns [Boolean current=false] : ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? ) ;
    public final Boolean ruleDataType() throws RecognitionException {
        Boolean current = false;

        Token lv_baseType_0_0=null;
        Token otherlv_1=null;
        Token lv_defaultValue_2_0=null;

        try {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:197:1: ( ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:198:2: ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? )
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:198:2: ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:199:3: ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )?
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:199:3: ( (lv_baseType_0_0= RULE_ID ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:200:4: (lv_baseType_0_0= RULE_ID )
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:200:4: (lv_baseType_0_0= RULE_ID )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:201:5: lv_baseType_0_0= RULE_ID
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

            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:216:3: (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:217:4: otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getDataType_ColonEqualsSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:224:4: ( (lv_defaultValue_2_0= RULE_STRING ) )
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:225:5: (lv_defaultValue_2_0= RULE_STRING )
                    {
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:225:5: (lv_defaultValue_2_0= RULE_STRING )
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:226:6: lv_defaultValue_2_0= RULE_STRING
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
    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:246:1: entryRuleExpression returns [Boolean current=false] : iv_ruleExpression= ruleExpression EOF ;
    public final Boolean entryRuleExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExpression = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 
        	grammarAccess.getExpressionAccess().getUnorderedGroup_3()
        	);

        try {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:251:2: (iv_ruleExpression= ruleExpression EOF )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:252:2: iv_ruleExpression= ruleExpression EOF
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
    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:261:1: ruleExpression returns [Boolean current=false] : ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) ) ;
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
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:267:2: ( ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:268:2: ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) )
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:268:2: ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:269:3: () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) )
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:269:3: ()
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:270:4: 
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

            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:279:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:280:4: ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) )
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:280:4: ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:281:5: ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_1());
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:284:5: ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:285:6: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )*
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:285:6: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    int LA4_1 = input.LA(2);

                    if ( synpred4_PsiInternalSimpleBacktrackingBug325745TestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
                        alt4=1;
                    }


                }
                else if ( (LA4_0==RULE_STRING) ) {
                    int LA4_3 = input.LA(2);

                    if ( synpred5_PsiInternalSimpleBacktrackingBug325745TestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
                        alt4=2;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:286:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
            	    {
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:286:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:287:5: {...}? => ( ({...}? => (otherlv_2= '[' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:287:107: ( ({...}? => (otherlv_2= '[' ) ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:288:6: ({...}? => (otherlv_2= '[' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:291:9: ({...}? => (otherlv_2= '[' ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:291:10: {...}? => (otherlv_2= '[' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:291:19: (otherlv_2= '[' )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:291:20: otherlv_2= '['
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
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:304:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
            	    {
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:304:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:305:5: {...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:305:107: ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:306:6: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:309:9: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:309:10: {...}? => ( (lv_prefix_3_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:309:19: ( (lv_prefix_3_0= RULE_STRING ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:309:20: (lv_prefix_3_0= RULE_STRING )
            	    {
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:309:20: (lv_prefix_3_0= RULE_STRING )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:310:10: lv_prefix_3_0= RULE_STRING
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

            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:337:3: ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==RULE_INT||LA7_0==13) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:338:4: (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )?
            	    {
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:338:4: (otherlv_4= '[' )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==13) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:339:5: otherlv_4= '['
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

            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:347:4: ( (lv_terms_5_0= ruleSimpleTerm ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:348:5: (lv_terms_5_0= ruleSimpleTerm )
            	    {
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:348:5: (lv_terms_5_0= ruleSimpleTerm )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:349:6: lv_terms_5_0= ruleSimpleTerm
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

            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:362:4: (otherlv_6= ']' )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==14) ) {
            	        int LA6_1 = input.LA(2);

            	        if ( (synpred7_PsiInternalSimpleBacktrackingBug325745TestLanguage()) ) {
            	            alt6=1;
            	        }
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:363:5: otherlv_6= ']'
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

            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:372:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:373:4: ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) )
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:373:4: ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:374:5: ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_3());
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:377:5: ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:378:6: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )*
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:378:6: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )*
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
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:379:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
            	    {
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:379:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:380:5: {...}? => ( ({...}? => (otherlv_8= ']' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:380:107: ( ({...}? => (otherlv_8= ']' ) ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:381:6: ({...}? => (otherlv_8= ']' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:384:9: ({...}? => (otherlv_8= ']' ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:384:10: {...}? => (otherlv_8= ']' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:384:19: (otherlv_8= ']' )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:384:20: otherlv_8= ']'
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
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:397:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:397:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:398:5: {...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:398:107: ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:399:6: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:402:9: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:402:10: {...}? => ( (lv_postfix_9_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:402:19: ( (lv_postfix_9_0= RULE_STRING ) )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:402:20: (lv_postfix_9_0= RULE_STRING )
            	    {
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:402:20: (lv_postfix_9_0= RULE_STRING )
            	    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:403:10: lv_postfix_9_0= RULE_STRING
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
    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:437:1: entryRuleSimpleTerm returns [Boolean current=false] : iv_ruleSimpleTerm= ruleSimpleTerm EOF ;
    public final Boolean entryRuleSimpleTerm() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimpleTerm = null;


        try {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:437:52: (iv_ruleSimpleTerm= ruleSimpleTerm EOF )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:438:2: iv_ruleSimpleTerm= ruleSimpleTerm EOF
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
    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:444:1: ruleSimpleTerm returns [Boolean current=false] : ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) ) ;
    public final Boolean ruleSimpleTerm() throws RecognitionException {
        Boolean current = false;

        Token lv_lineCount_0_0=null;
        Token otherlv_1=null;
        Token lv_charCount_2_0=null;
        Token otherlv_3=null;
        Token lv_charSet_4_0=null;
        Token lv_refChar_5_0=null;

        try {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:445:1: ( ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) ) )
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:446:2: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:446:2: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )
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
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:447:3: ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? )
                    {
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:447:3: ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? )
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:448:4: ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )?
                    {
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:448:4: ( (lv_lineCount_0_0= RULE_INT ) )
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:449:5: (lv_lineCount_0_0= RULE_INT )
                    {
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:449:5: (lv_lineCount_0_0= RULE_INT )
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:450:6: lv_lineCount_0_0= RULE_INT
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

                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:465:4: (otherlv_1= '*' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==15) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:466:5: otherlv_1= '*'
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

                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:474:4: ( (lv_charCount_2_0= RULE_INT ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_INT) ) {
                        int LA10_1 = input.LA(2);

                        if ( (synpred12_PsiInternalSimpleBacktrackingBug325745TestLanguage()) ) {
                            alt10=1;
                        }
                    }
                    switch (alt10) {
                        case 1 :
                            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:475:5: (lv_charCount_2_0= RULE_INT )
                            {
                            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:475:5: (lv_charCount_2_0= RULE_INT )
                            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:476:6: lv_charCount_2_0= RULE_INT
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

                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:491:4: (otherlv_3= '!' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==16) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:492:5: otherlv_3= '!'
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

                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:500:4: ( (lv_charSet_4_0= RULE_ID ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==RULE_ID) ) {
                        int LA12_1 = input.LA(2);

                        if ( (synpred14_PsiInternalSimpleBacktrackingBug325745TestLanguage()) ) {
                            alt12=1;
                        }
                    }
                    switch (alt12) {
                        case 1 :
                            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:501:5: (lv_charSet_4_0= RULE_ID )
                            {
                            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:501:5: (lv_charSet_4_0= RULE_ID )
                            // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:502:6: lv_charSet_4_0= RULE_ID
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
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:519:3: ( (lv_refChar_5_0= RULE_ID ) )
                    {
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:519:3: ( (lv_refChar_5_0= RULE_ID ) )
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:520:4: (lv_refChar_5_0= RULE_ID )
                    {
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:520:4: (lv_refChar_5_0= RULE_ID )
                    // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:521:5: lv_refChar_5_0= RULE_ID
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

    // $ANTLR start synpred2_PsiInternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred2_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Boolean lv_dataType_1_0 = null;


        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:149:4: ( (lv_dataType_1_0= ruleDataType ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:149:4: (lv_dataType_1_0= ruleDataType )
        {
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:149:4: (lv_dataType_1_0= ruleDataType )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:150:5: lv_dataType_1_0= ruleDataType
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
    // $ANTLR end synpred2_PsiInternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred4_PsiInternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred4_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:286:4: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:286:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
        {
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:286:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:287:5: {...}? => ( ({...}? => (otherlv_2= '[' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred4_PsiInternalSimpleBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)");
        }
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:287:107: ( ({...}? => (otherlv_2= '[' ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:288:6: ({...}? => (otherlv_2= '[' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:291:9: ({...}? => (otherlv_2= '[' ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:291:10: {...}? => (otherlv_2= '[' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred4_PsiInternalSimpleBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:291:19: (otherlv_2= '[' )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:291:20: otherlv_2= '['
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
    // $ANTLR end synpred4_PsiInternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred5_PsiInternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred5_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_prefix_3_0=null;

        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:304:4: ( ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:304:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
        {
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:304:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:305:5: {...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred5_PsiInternalSimpleBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)");
        }
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:305:107: ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:306:6: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:309:9: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:309:10: {...}? => ( (lv_prefix_3_0= RULE_STRING ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred5_PsiInternalSimpleBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:309:19: ( (lv_prefix_3_0= RULE_STRING ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:309:20: (lv_prefix_3_0= RULE_STRING )
        {
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:309:20: (lv_prefix_3_0= RULE_STRING )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:310:10: lv_prefix_3_0= RULE_STRING
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
    // $ANTLR end synpred5_PsiInternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred7_PsiInternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred7_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:363:5: (otherlv_6= ']' )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:363:5: otherlv_6= ']'
        {
        if ( state.backtracking==0 ) {

          					markLeaf(elementTypeProvider.getExpression_RightSquareBracketKeyword_2_2ElementType());
          				
        }
        otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_PsiInternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred9_PsiInternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred9_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;

        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:379:4: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:379:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
        {
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:379:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:380:5: {...}? => ( ({...}? => (otherlv_8= ']' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalSimpleBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)");
        }
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:380:107: ( ({...}? => (otherlv_8= ']' ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:381:6: ({...}? => (otherlv_8= ']' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:384:9: ({...}? => (otherlv_8= ']' ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:384:10: {...}? => (otherlv_8= ']' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalSimpleBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:384:19: (otherlv_8= ']' )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:384:20: otherlv_8= ']'
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
    // $ANTLR end synpred9_PsiInternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred10_PsiInternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred10_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_postfix_9_0=null;

        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:397:4: ( ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:397:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
        {
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:397:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:398:5: {...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalSimpleBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)");
        }
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:398:107: ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:399:6: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:402:9: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:402:10: {...}? => ( (lv_postfix_9_0= RULE_STRING ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalSimpleBacktrackingBug325745TestLanguage", "true");
        }
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:402:19: ( (lv_postfix_9_0= RULE_STRING ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:402:20: (lv_postfix_9_0= RULE_STRING )
        {
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:402:20: (lv_postfix_9_0= RULE_STRING )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:403:10: lv_postfix_9_0= RULE_STRING
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
    // $ANTLR end synpred10_PsiInternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred12_PsiInternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred12_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_charCount_2_0=null;

        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:475:5: ( (lv_charCount_2_0= RULE_INT ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:475:5: (lv_charCount_2_0= RULE_INT )
        {
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:475:5: (lv_charCount_2_0= RULE_INT )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:476:6: lv_charCount_2_0= RULE_INT
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getSimpleTerm_CharCountINTTerminalRuleCall_0_2_0ElementType());
          					
        }
        lv_charCount_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_PsiInternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred14_PsiInternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred14_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_charSet_4_0=null;

        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:501:5: ( (lv_charSet_4_0= RULE_ID ) )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:501:5: (lv_charSet_4_0= RULE_ID )
        {
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:501:5: (lv_charSet_4_0= RULE_ID )
        // PsiInternalSimpleBacktrackingBug325745TestLanguage.g:502:6: lv_charSet_4_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getSimpleTerm_CharSetIDTerminalRuleCall_0_4_0ElementType());
          					
        }
        lv_charSet_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_PsiInternalSimpleBacktrackingBug325745TestLanguage

    // Delegated rules

    public final boolean synpred9_PsiInternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_PsiInternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_PsiInternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_PsiInternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_PsiInternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_PsiInternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PsiInternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_PsiInternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_PsiInternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
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
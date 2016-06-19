package org.eclipse.xtext.parser.unorderedGroups.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.unorderedGroups.services.SimpleBacktrackingBug325745TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSimpleBacktrackingBug325745TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "':='", "'['", "']'", "'*'", "'!'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalSimpleBacktrackingBug325745TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSimpleBacktrackingBug325745TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSimpleBacktrackingBug325745TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSimpleBacktrackingBug325745TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private SimpleBacktrackingBug325745TestLanguageGrammarAccess grammarAccess;
     	
        public InternalSimpleBacktrackingBug325745TestLanguageParser(TokenStream input, SimpleBacktrackingBug325745TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "DelegateModel";	
       	}
       	
       	@Override
       	protected SimpleBacktrackingBug325745TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleDelegateModel"
    // InternalSimpleBacktrackingBug325745TestLanguage.g:74:1: entryRuleDelegateModel returns [EObject current=null] : iv_ruleDelegateModel= ruleDelegateModel EOF ;
    public final EObject entryRuleDelegateModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegateModel = null;


        try {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:75:2: (iv_ruleDelegateModel= ruleDelegateModel EOF )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:76:2: iv_ruleDelegateModel= ruleDelegateModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDelegateModelRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDelegateModel"


    // $ANTLR start "ruleDelegateModel"
    // InternalSimpleBacktrackingBug325745TestLanguage.g:83:1: ruleDelegateModel returns [EObject current=null] : this_Model_0= ruleModel ;
    public final EObject ruleDelegateModel() throws RecognitionException {
        EObject current = null;

        EObject this_Model_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:86:28: (this_Model_0= ruleModel )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:88:2: this_Model_0= ruleModel
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getDelegateModelAccess().getModelParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Model_0=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Model_0; 
                      afterParserOrEnumRuleCall();
                  
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
    // $ANTLR end "ruleDelegateModel"


    // $ANTLR start "entryRuleModel"
    // InternalSimpleBacktrackingBug325745TestLanguage.g:107:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:108:2: (iv_ruleModel= ruleModel EOF )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:109:2: iv_ruleModel= ruleModel EOF
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
    // InternalSimpleBacktrackingBug325745TestLanguage.g:116:1: ruleModel returns [EObject current=null] : ( () ( (lv_fields_1_0= ruleElement ) )+ ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_fields_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:119:28: ( ( () ( (lv_fields_1_0= ruleElement ) )+ ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:120:1: ( () ( (lv_fields_1_0= ruleElement ) )+ )
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:120:1: ( () ( (lv_fields_1_0= ruleElement ) )+ )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:120:2: () ( (lv_fields_1_0= ruleElement ) )+
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:120:2: ()
            // InternalSimpleBacktrackingBug325745TestLanguage.g:121:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getModelAccess().getModelAction_0(),
                          current);
                  
            }

            }

            // InternalSimpleBacktrackingBug325745TestLanguage.g:129:2: ( (lv_fields_1_0= ruleElement ) )+
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
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:130:1: (lv_fields_1_0= ruleElement )
            	    {
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:130:1: (lv_fields_1_0= ruleElement )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:131:3: lv_fields_1_0= ruleElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getFieldsElementParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_fields_1_0=ruleElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"fields",
            	              		lv_fields_1_0, 
            	              		"org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745TestLanguage.Element");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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


    // $ANTLR start "entryRuleElement"
    // InternalSimpleBacktrackingBug325745TestLanguage.g:155:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:156:2: (iv_ruleElement= ruleElement EOF )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:157:2: iv_ruleElement= ruleElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalSimpleBacktrackingBug325745TestLanguage.g:164:1: ruleElement returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_3=null;
        EObject lv_dataType_1_0 = null;

        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:167:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:168:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' )
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:168:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.' )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:168:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_dataType_1_0= ruleDataType ) )? ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= '.'
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:168:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:169:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:169:1: (lv_name_0_0= RULE_ID )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:170:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getElementRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            // InternalSimpleBacktrackingBug325745TestLanguage.g:186:2: ( (lv_dataType_1_0= ruleDataType ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred2_InternalSimpleBacktrackingBug325745TestLanguage()) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:187:1: (lv_dataType_1_0= ruleDataType )
                    {
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:187:1: (lv_dataType_1_0= ruleDataType )
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:188:3: lv_dataType_1_0= ruleDataType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getElementAccess().getDataTypeDataTypeParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_dataType_1_0=ruleDataType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getElementRule());
                      	        }
                             		set(
                             			current, 
                             			"dataType",
                              		lv_dataType_1_0, 
                              		"org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745TestLanguage.DataType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalSimpleBacktrackingBug325745TestLanguage.g:204:3: ( (lv_expression_2_0= ruleExpression ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:205:1: (lv_expression_2_0= ruleExpression )
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:205:1: (lv_expression_2_0= ruleExpression )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:206:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElementAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_5);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElementRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745TestLanguage.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getElementAccess().getFullStopKeyword_3());
                  
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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleDataType"
    // InternalSimpleBacktrackingBug325745TestLanguage.g:234:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:235:2: (iv_ruleDataType= ruleDataType EOF )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:236:2: iv_ruleDataType= ruleDataType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // InternalSimpleBacktrackingBug325745TestLanguage.g:243:1: ruleDataType returns [EObject current=null] : ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        Token lv_baseType_0_0=null;
        Token otherlv_1=null;
        Token lv_defaultValue_2_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:246:28: ( ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:247:1: ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? )
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:247:1: ( ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )? )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:247:2: ( (lv_baseType_0_0= RULE_ID ) ) (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )?
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:247:2: ( (lv_baseType_0_0= RULE_ID ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:248:1: (lv_baseType_0_0= RULE_ID )
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:248:1: (lv_baseType_0_0= RULE_ID )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:249:3: lv_baseType_0_0= RULE_ID
            {
            lv_baseType_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_baseType_0_0, grammarAccess.getDataTypeAccess().getBaseTypeIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDataTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"baseType",
                      		lv_baseType_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            // InternalSimpleBacktrackingBug325745TestLanguage.g:265:2: (otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:265:4: otherlv_1= ':=' ( (lv_defaultValue_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDataTypeAccess().getColonEqualsSignKeyword_1_0());
                          
                    }
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:269:1: ( (lv_defaultValue_2_0= RULE_STRING ) )
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:270:1: (lv_defaultValue_2_0= RULE_STRING )
                    {
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:270:1: (lv_defaultValue_2_0= RULE_STRING )
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:271:3: lv_defaultValue_2_0= RULE_STRING
                    {
                    lv_defaultValue_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_defaultValue_2_0, grammarAccess.getDataTypeAccess().getDefaultValueSTRINGTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"defaultValue",
                              		lv_defaultValue_2_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
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
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleExpression"
    // InternalSimpleBacktrackingBug325745TestLanguage.g:295:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 
        			grammarAccess.getExpressionAccess().getUnorderedGroup_3()
        		);
        	
        try {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:302:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:303:2: iv_ruleExpression= ruleExpression EOF
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

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalSimpleBacktrackingBug325745TestLanguage.g:313:1: ruleExpression returns [EObject current=null] : ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_prefix_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_postfix_9_0=null;
        EObject lv_terms_5_0 = null;


         enterRule(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 
        			grammarAccess.getExpressionAccess().getUnorderedGroup_3()
        		);
            
        try {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:320:28: ( ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:321:1: ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) )
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:321:1: ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:321:2: () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) ) ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) )
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:321:2: ()
            // InternalSimpleBacktrackingBug325745TestLanguage.g:322:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExpressionAccess().getExpressionAction_0(),
                          current);
                  
            }

            }

            // InternalSimpleBacktrackingBug325745TestLanguage.g:330:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:332:1: ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) )
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:332:1: ( ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:333:2: ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_1());
            // InternalSimpleBacktrackingBug325745TestLanguage.g:336:2: ( ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )* )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:337:3: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )*
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:337:3: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    int LA4_1 = input.LA(2);

                    if ( synpred4_InternalSimpleBacktrackingBug325745TestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
                        alt4=1;
                    }


                }
                else if ( (LA4_0==RULE_STRING) ) {
                    int LA4_3 = input.LA(2);

                    if ( synpred5_InternalSimpleBacktrackingBug325745TestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
                        alt4=2;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:339:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
            	    {
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:339:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:340:5: {...}? => ( ({...}? => (otherlv_2= '[' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:340:107: ( ({...}? => (otherlv_2= '[' ) ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:341:6: ({...}? => (otherlv_2= '[' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:344:6: ({...}? => (otherlv_2= '[' ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:344:7: {...}? => (otherlv_2= '[' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:344:16: (otherlv_2= '[' )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:344:18: otherlv_2= '['
            	    {
            	    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_1_0());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_1());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:355:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
            	    {
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:355:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:356:5: {...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:356:107: ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:357:6: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:360:6: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:360:7: {...}? => ( (lv_prefix_3_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:360:16: ( (lv_prefix_3_0= RULE_STRING ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:361:1: (lv_prefix_3_0= RULE_STRING )
            	    {
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:361:1: (lv_prefix_3_0= RULE_STRING )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:362:3: lv_prefix_3_0= RULE_STRING
            	    {
            	    lv_prefix_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_prefix_3_0, grammarAccess.getExpressionAccess().getPrefixSTRINGTerminalRuleCall_1_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getExpressionRule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"prefix",
            	              		lv_prefix_3_0, 
            	              		"org.eclipse.xtext.common.Terminals.STRING");
            	      	    
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

            // InternalSimpleBacktrackingBug325745TestLanguage.g:392:2: ( (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )? )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==RULE_INT||LA7_0==13) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:392:3: (otherlv_4= '[' )? ( (lv_terms_5_0= ruleSimpleTerm ) ) (otherlv_6= ']' )?
            	    {
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:392:3: (otherlv_4= '[' )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==13) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // InternalSimpleBacktrackingBug325745TestLanguage.g:392:5: otherlv_4= '['
            	            {
            	            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_9); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_4, grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_2_0());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:396:3: ( (lv_terms_5_0= ruleSimpleTerm ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:397:1: (lv_terms_5_0= ruleSimpleTerm )
            	    {
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:397:1: (lv_terms_5_0= ruleSimpleTerm )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:398:3: lv_terms_5_0= ruleSimpleTerm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionAccess().getTermsSimpleTermParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_terms_5_0=ruleSimpleTerm();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"terms",
            	              		lv_terms_5_0, 
            	              		"org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745TestLanguage.SimpleTerm");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:414:2: (otherlv_6= ']' )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==14) ) {
            	        int LA6_1 = input.LA(2);

            	        if ( (synpred7_InternalSimpleBacktrackingBug325745TestLanguage()) ) {
            	            alt6=1;
            	        }
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // InternalSimpleBacktrackingBug325745TestLanguage.g:414:4: otherlv_6= ']'
            	            {
            	            otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_6, grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_2_2());
            	                  
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

            // InternalSimpleBacktrackingBug325745TestLanguage.g:418:5: ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:420:1: ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) )
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:420:1: ( ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:421:2: ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getExpressionAccess().getUnorderedGroup_3());
            // InternalSimpleBacktrackingBug325745TestLanguage.g:424:2: ( ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )* )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:425:3: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )*
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:425:3: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )*
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
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:427:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
            	    {
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:427:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:428:5: {...}? => ( ({...}? => (otherlv_8= ']' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:428:107: ( ({...}? => (otherlv_8= ']' ) ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:429:6: ({...}? => (otherlv_8= ']' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:432:6: ({...}? => (otherlv_8= ']' ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:432:7: {...}? => (otherlv_8= ']' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:432:16: (otherlv_8= ']' )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:432:18: otherlv_8= ']'
            	    {
            	    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_3_0());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getExpressionAccess().getUnorderedGroup_3());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:443:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:443:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:444:5: {...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:444:107: ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:445:6: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:448:6: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:448:7: {...}? => ( (lv_postfix_9_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleExpression", "true");
            	    }
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:448:16: ( (lv_postfix_9_0= RULE_STRING ) )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:449:1: (lv_postfix_9_0= RULE_STRING )
            	    {
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:449:1: (lv_postfix_9_0= RULE_STRING )
            	    // InternalSimpleBacktrackingBug325745TestLanguage.g:450:3: lv_postfix_9_0= RULE_STRING
            	    {
            	    lv_postfix_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_postfix_9_0, grammarAccess.getExpressionAccess().getPostfixSTRINGTerminalRuleCall_3_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getExpressionRule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"postfix",
            	              		lv_postfix_9_0, 
            	              		"org.eclipse.xtext.common.Terminals.STRING");
            	      	    
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

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleSimpleTerm"
    // InternalSimpleBacktrackingBug325745TestLanguage.g:491:1: entryRuleSimpleTerm returns [EObject current=null] : iv_ruleSimpleTerm= ruleSimpleTerm EOF ;
    public final EObject entryRuleSimpleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleTerm = null;


        try {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:492:2: (iv_ruleSimpleTerm= ruleSimpleTerm EOF )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:493:2: iv_ruleSimpleTerm= ruleSimpleTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleTermRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleTerm"


    // $ANTLR start "ruleSimpleTerm"
    // InternalSimpleBacktrackingBug325745TestLanguage.g:500:1: ruleSimpleTerm returns [EObject current=null] : ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleTerm() throws RecognitionException {
        EObject current = null;

        Token lv_lineCount_0_0=null;
        Token otherlv_1=null;
        Token lv_charCount_2_0=null;
        Token otherlv_3=null;
        Token lv_charSet_4_0=null;
        Token lv_refChar_5_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:503:28: ( ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) ) )
            // InternalSimpleBacktrackingBug325745TestLanguage.g:504:1: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )
            {
            // InternalSimpleBacktrackingBug325745TestLanguage.g:504:1: ( ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? ) | ( (lv_refChar_5_0= RULE_ID ) ) )
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
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:504:2: ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? )
                    {
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:504:2: ( ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )? )
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:504:3: ( (lv_lineCount_0_0= RULE_INT ) ) (otherlv_1= '*' )? ( (lv_charCount_2_0= RULE_INT ) )? (otherlv_3= '!' )? ( (lv_charSet_4_0= RULE_ID ) )?
                    {
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:504:3: ( (lv_lineCount_0_0= RULE_INT ) )
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:505:1: (lv_lineCount_0_0= RULE_INT )
                    {
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:505:1: (lv_lineCount_0_0= RULE_INT )
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:506:3: lv_lineCount_0_0= RULE_INT
                    {
                    lv_lineCount_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_lineCount_0_0, grammarAccess.getSimpleTermAccess().getLineCountINTTerminalRuleCall_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSimpleTermRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"lineCount",
                              		lv_lineCount_0_0, 
                              		"org.eclipse.xtext.common.Terminals.INT");
                      	    
                    }

                    }


                    }

                    // InternalSimpleBacktrackingBug325745TestLanguage.g:522:2: (otherlv_1= '*' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==15) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalSimpleBacktrackingBug325745TestLanguage.g:522:4: otherlv_1= '*'
                            {
                            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getSimpleTermAccess().getAsteriskKeyword_0_1());
                                  
                            }

                            }
                            break;

                    }

                    // InternalSimpleBacktrackingBug325745TestLanguage.g:526:3: ( (lv_charCount_2_0= RULE_INT ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_INT) ) {
                        int LA10_1 = input.LA(2);

                        if ( (synpred12_InternalSimpleBacktrackingBug325745TestLanguage()) ) {
                            alt10=1;
                        }
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalSimpleBacktrackingBug325745TestLanguage.g:527:1: (lv_charCount_2_0= RULE_INT )
                            {
                            // InternalSimpleBacktrackingBug325745TestLanguage.g:527:1: (lv_charCount_2_0= RULE_INT )
                            // InternalSimpleBacktrackingBug325745TestLanguage.g:528:3: lv_charCount_2_0= RULE_INT
                            {
                            lv_charCount_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_charCount_2_0, grammarAccess.getSimpleTermAccess().getCharCountINTTerminalRuleCall_0_2_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSimpleTermRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"charCount",
                                      		lv_charCount_2_0, 
                                      		"org.eclipse.xtext.common.Terminals.INT");
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // InternalSimpleBacktrackingBug325745TestLanguage.g:544:3: (otherlv_3= '!' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==16) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalSimpleBacktrackingBug325745TestLanguage.g:544:5: otherlv_3= '!'
                            {
                            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getSimpleTermAccess().getExclamationMarkKeyword_0_3());
                                  
                            }

                            }
                            break;

                    }

                    // InternalSimpleBacktrackingBug325745TestLanguage.g:548:3: ( (lv_charSet_4_0= RULE_ID ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==RULE_ID) ) {
                        int LA12_1 = input.LA(2);

                        if ( (synpred14_InternalSimpleBacktrackingBug325745TestLanguage()) ) {
                            alt12=1;
                        }
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalSimpleBacktrackingBug325745TestLanguage.g:549:1: (lv_charSet_4_0= RULE_ID )
                            {
                            // InternalSimpleBacktrackingBug325745TestLanguage.g:549:1: (lv_charSet_4_0= RULE_ID )
                            // InternalSimpleBacktrackingBug325745TestLanguage.g:550:3: lv_charSet_4_0= RULE_ID
                            {
                            lv_charSet_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_charSet_4_0, grammarAccess.getSimpleTermAccess().getCharSetIDTerminalRuleCall_0_4_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSimpleTermRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"charSet",
                                      		lv_charSet_4_0, 
                                      		"org.eclipse.xtext.common.Terminals.ID");
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:567:6: ( (lv_refChar_5_0= RULE_ID ) )
                    {
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:567:6: ( (lv_refChar_5_0= RULE_ID ) )
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:568:1: (lv_refChar_5_0= RULE_ID )
                    {
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:568:1: (lv_refChar_5_0= RULE_ID )
                    // InternalSimpleBacktrackingBug325745TestLanguage.g:569:3: lv_refChar_5_0= RULE_ID
                    {
                    lv_refChar_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_refChar_5_0, grammarAccess.getSimpleTermAccess().getRefCharIDTerminalRuleCall_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSimpleTermRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"refChar",
                              		lv_refChar_5_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


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
    // $ANTLR end "ruleSimpleTerm"

    // $ANTLR start synpred2_InternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred2_InternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        EObject lv_dataType_1_0 = null;


        // InternalSimpleBacktrackingBug325745TestLanguage.g:187:1: ( (lv_dataType_1_0= ruleDataType ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:187:1: (lv_dataType_1_0= ruleDataType )
        {
        // InternalSimpleBacktrackingBug325745TestLanguage.g:187:1: (lv_dataType_1_0= ruleDataType )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:188:3: lv_dataType_1_0= ruleDataType
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getElementAccess().getDataTypeDataTypeParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_dataType_1_0=ruleDataType();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred4_InternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred4_InternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // InternalSimpleBacktrackingBug325745TestLanguage.g:339:4: ( ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:339:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
        {
        // InternalSimpleBacktrackingBug325745TestLanguage.g:339:4: ({...}? => ( ({...}? => (otherlv_2= '[' ) ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:340:5: {...}? => ( ({...}? => (otherlv_2= '[' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred4_InternalSimpleBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0)");
        }
        // InternalSimpleBacktrackingBug325745TestLanguage.g:340:107: ( ({...}? => (otherlv_2= '[' ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:341:6: ({...}? => (otherlv_2= '[' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 0);
        // InternalSimpleBacktrackingBug325745TestLanguage.g:344:6: ({...}? => (otherlv_2= '[' ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:344:7: {...}? => (otherlv_2= '[' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred4_InternalSimpleBacktrackingBug325745TestLanguage", "true");
        }
        // InternalSimpleBacktrackingBug325745TestLanguage.g:344:16: (otherlv_2= '[' )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:344:18: otherlv_2= '['
        {
        otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred5_InternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred5_InternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_prefix_3_0=null;

        // InternalSimpleBacktrackingBug325745TestLanguage.g:355:4: ( ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:355:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
        {
        // InternalSimpleBacktrackingBug325745TestLanguage.g:355:4: ({...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:356:5: {...}? => ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred5_InternalSimpleBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1)");
        }
        // InternalSimpleBacktrackingBug325745TestLanguage.g:356:107: ( ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:357:6: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_1(), 1);
        // InternalSimpleBacktrackingBug325745TestLanguage.g:360:6: ({...}? => ( (lv_prefix_3_0= RULE_STRING ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:360:7: {...}? => ( (lv_prefix_3_0= RULE_STRING ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred5_InternalSimpleBacktrackingBug325745TestLanguage", "true");
        }
        // InternalSimpleBacktrackingBug325745TestLanguage.g:360:16: ( (lv_prefix_3_0= RULE_STRING ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:361:1: (lv_prefix_3_0= RULE_STRING )
        {
        // InternalSimpleBacktrackingBug325745TestLanguage.g:361:1: (lv_prefix_3_0= RULE_STRING )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:362:3: lv_prefix_3_0= RULE_STRING
        {
        lv_prefix_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred7_InternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred7_InternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // InternalSimpleBacktrackingBug325745TestLanguage.g:414:4: (otherlv_6= ']' )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:414:4: otherlv_6= ']'
        {
        otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred9_InternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred9_InternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;

        // InternalSimpleBacktrackingBug325745TestLanguage.g:427:4: ( ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:427:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
        {
        // InternalSimpleBacktrackingBug325745TestLanguage.g:427:4: ({...}? => ( ({...}? => (otherlv_8= ']' ) ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:428:5: {...}? => ( ({...}? => (otherlv_8= ']' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_InternalSimpleBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0)");
        }
        // InternalSimpleBacktrackingBug325745TestLanguage.g:428:107: ( ({...}? => (otherlv_8= ']' ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:429:6: ({...}? => (otherlv_8= ']' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 0);
        // InternalSimpleBacktrackingBug325745TestLanguage.g:432:6: ({...}? => (otherlv_8= ']' ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:432:7: {...}? => (otherlv_8= ']' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_InternalSimpleBacktrackingBug325745TestLanguage", "true");
        }
        // InternalSimpleBacktrackingBug325745TestLanguage.g:432:16: (otherlv_8= ']' )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:432:18: otherlv_8= ']'
        {
        otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred10_InternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred10_InternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_postfix_9_0=null;

        // InternalSimpleBacktrackingBug325745TestLanguage.g:443:4: ( ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:443:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
        {
        // InternalSimpleBacktrackingBug325745TestLanguage.g:443:4: ({...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:444:5: {...}? => ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_InternalSimpleBacktrackingBug325745TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1)");
        }
        // InternalSimpleBacktrackingBug325745TestLanguage.g:444:107: ( ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:445:6: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getExpressionAccess().getUnorderedGroup_3(), 1);
        // InternalSimpleBacktrackingBug325745TestLanguage.g:448:6: ({...}? => ( (lv_postfix_9_0= RULE_STRING ) ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:448:7: {...}? => ( (lv_postfix_9_0= RULE_STRING ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_InternalSimpleBacktrackingBug325745TestLanguage", "true");
        }
        // InternalSimpleBacktrackingBug325745TestLanguage.g:448:16: ( (lv_postfix_9_0= RULE_STRING ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:449:1: (lv_postfix_9_0= RULE_STRING )
        {
        // InternalSimpleBacktrackingBug325745TestLanguage.g:449:1: (lv_postfix_9_0= RULE_STRING )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:450:3: lv_postfix_9_0= RULE_STRING
        {
        lv_postfix_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred10_InternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred12_InternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred12_InternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_charCount_2_0=null;

        // InternalSimpleBacktrackingBug325745TestLanguage.g:527:1: ( (lv_charCount_2_0= RULE_INT ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:527:1: (lv_charCount_2_0= RULE_INT )
        {
        // InternalSimpleBacktrackingBug325745TestLanguage.g:527:1: (lv_charCount_2_0= RULE_INT )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:528:3: lv_charCount_2_0= RULE_INT
        {
        lv_charCount_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_InternalSimpleBacktrackingBug325745TestLanguage

    // $ANTLR start synpred14_InternalSimpleBacktrackingBug325745TestLanguage
    public final void synpred14_InternalSimpleBacktrackingBug325745TestLanguage_fragment() throws RecognitionException {   
        Token lv_charSet_4_0=null;

        // InternalSimpleBacktrackingBug325745TestLanguage.g:549:1: ( (lv_charSet_4_0= RULE_ID ) )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:549:1: (lv_charSet_4_0= RULE_ID )
        {
        // InternalSimpleBacktrackingBug325745TestLanguage.g:549:1: (lv_charSet_4_0= RULE_ID )
        // InternalSimpleBacktrackingBug325745TestLanguage.g:550:3: lv_charSet_4_0= RULE_ID
        {
        lv_charSet_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalSimpleBacktrackingBug325745TestLanguage

    // Delegated rules

    public final boolean synpred4_InternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalSimpleBacktrackingBug325745TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalSimpleBacktrackingBug325745TestLanguage_fragment(); // can never throw exception
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
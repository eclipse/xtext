package org.eclipse.xtext.parser.antlr.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.services.Bug296889ExTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBug296889ExTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DataType", "Model", "HyphenMinusHyphenMinus", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int HyphenMinusHyphenMinus=6;
    public static final int RULE_ID=7;
    public static final int RULE_WS=12;
    public static final int RULE_STRING=9;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_INT=8;
    public static final int Model=5;
    public static final int RULE_ML_COMMENT=10;
    public static final int DataType=4;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug296889ExTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug296889ExTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug296889ExTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug296889ExTestLanguageParser.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     

    	private Bug296889ExTestLanguageGrammarAccess grammarAccess;
    	 	
    	public InternalBug296889ExTestLanguageParser(TokenStream input, Bug296889ExTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Model";	
    	} 
    	   	   	
    	@Override
    	protected Bug296889ExTestLanguageGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalBug296889ExTestLanguageParser.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug296889ExTestLanguageParser.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalBug296889ExTestLanguageParser.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalBug296889ExTestLanguageParser.g:76:1: ruleModel returns [EObject current=null] : ( (otherlv_0= Model ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= DataType ( (lv_values_3_0= ruleDataTypeExpression ) )* ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;

        AntlrDatatypeRuleToken lv_values_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug296889ExTestLanguageParser.g:79:28: ( ( (otherlv_0= Model ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= DataType ( (lv_values_3_0= ruleDataTypeExpression ) )* ) ) )
            // InternalBug296889ExTestLanguageParser.g:80:1: ( (otherlv_0= Model ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= DataType ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )
            {
            // InternalBug296889ExTestLanguageParser.g:80:1: ( (otherlv_0= Model ( (lv_expressions_1_0= ruleExpression ) )* ) | (otherlv_2= DataType ( (lv_values_3_0= ruleDataTypeExpression ) )* ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Model) ) {
                alt3=1;
            }
            else if ( (LA3_0==DataType) ) {
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
                    // InternalBug296889ExTestLanguageParser.g:80:2: (otherlv_0= Model ( (lv_expressions_1_0= ruleExpression ) )* )
                    {
                    // InternalBug296889ExTestLanguageParser.g:80:2: (otherlv_0= Model ( (lv_expressions_1_0= ruleExpression ) )* )
                    // InternalBug296889ExTestLanguageParser.g:81:2: otherlv_0= Model ( (lv_expressions_1_0= ruleExpression ) )*
                    {
                    otherlv_0=(Token)match(input,Model,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getModelKeyword_0_0());
                          
                    }
                    // InternalBug296889ExTestLanguageParser.g:85:1: ( (lv_expressions_1_0= ruleExpression ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=HyphenMinusHyphenMinus && LA1_0<=RULE_ID)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalBug296889ExTestLanguageParser.g:86:1: (lv_expressions_1_0= ruleExpression )
                    	    {
                    	    // InternalBug296889ExTestLanguageParser.g:86:1: (lv_expressions_1_0= ruleExpression )
                    	    // InternalBug296889ExTestLanguageParser.g:87:3: lv_expressions_1_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModelAccess().getExpressionsExpressionParserRuleCall_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_expressions_1_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"expressions",
                    	              		lv_expressions_1_0, 
                    	              		"org.eclipse.xtext.parser.antlr.Bug296889ExTestLanguage.Expression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
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
                    // InternalBug296889ExTestLanguageParser.g:104:6: (otherlv_2= DataType ( (lv_values_3_0= ruleDataTypeExpression ) )* )
                    {
                    // InternalBug296889ExTestLanguageParser.g:104:6: (otherlv_2= DataType ( (lv_values_3_0= ruleDataTypeExpression ) )* )
                    // InternalBug296889ExTestLanguageParser.g:105:2: otherlv_2= DataType ( (lv_values_3_0= ruleDataTypeExpression ) )*
                    {
                    otherlv_2=(Token)match(input,DataType,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getModelAccess().getDataTypeKeyword_1_0());
                          
                    }
                    // InternalBug296889ExTestLanguageParser.g:109:1: ( (lv_values_3_0= ruleDataTypeExpression ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=HyphenMinusHyphenMinus && LA2_0<=RULE_ID)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalBug296889ExTestLanguageParser.g:110:1: (lv_values_3_0= ruleDataTypeExpression )
                    	    {
                    	    // InternalBug296889ExTestLanguageParser.g:110:1: (lv_values_3_0= ruleDataTypeExpression )
                    	    // InternalBug296889ExTestLanguageParser.g:111:3: lv_values_3_0= ruleDataTypeExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModelAccess().getValuesDataTypeExpressionParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_values_3_0=ruleDataTypeExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"values",
                    	              		lv_values_3_0, 
                    	              		"org.eclipse.xtext.parser.antlr.Bug296889ExTestLanguage.DataTypeExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
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


    // $ANTLR start "entryRuleExpression"
    // InternalBug296889ExTestLanguageParser.g:135:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalBug296889ExTestLanguageParser.g:136:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalBug296889ExTestLanguageParser.g:137:2: iv_ruleExpression= ruleExpression EOF
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
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalBug296889ExTestLanguageParser.g:144:1: ruleExpression returns [EObject current=null] : (this_Postop_0= rulePostop | this_Preop_1= rulePreop ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Postop_0 = null;

        EObject this_Preop_1 = null;


         enterRule(); 
            
        try {
            // InternalBug296889ExTestLanguageParser.g:147:28: ( (this_Postop_0= rulePostop | this_Preop_1= rulePreop ) )
            // InternalBug296889ExTestLanguageParser.g:148:1: (this_Postop_0= rulePostop | this_Preop_1= rulePreop )
            {
            // InternalBug296889ExTestLanguageParser.g:148:1: (this_Postop_0= rulePostop | this_Preop_1= rulePreop )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==HyphenMinusHyphenMinus) ) {
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
                    // InternalBug296889ExTestLanguageParser.g:149:2: this_Postop_0= rulePostop
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getPostopParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Postop_0=rulePostop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Postop_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBug296889ExTestLanguageParser.g:162:2: this_Preop_1= rulePreop
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getPreopParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Preop_1=rulePreop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Preop_1;
                              afterParserOrEnumRuleCall();
                          
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRulePreop"
    // InternalBug296889ExTestLanguageParser.g:181:1: entryRulePreop returns [EObject current=null] : iv_rulePreop= rulePreop EOF ;
    public final EObject entryRulePreop() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreop = null;


        try {
            // InternalBug296889ExTestLanguageParser.g:182:2: (iv_rulePreop= rulePreop EOF )
            // InternalBug296889ExTestLanguageParser.g:183:2: iv_rulePreop= rulePreop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPreopRule()); 
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
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePreop"


    // $ANTLR start "rulePreop"
    // InternalBug296889ExTestLanguageParser.g:190:1: rulePreop returns [EObject current=null] : ( () ( (lv_functionName_1_0= HyphenMinusHyphenMinus ) ) ( (lv_expr_2_0= ruleVariable ) ) ) ;
    public final EObject rulePreop() throws RecognitionException {
        EObject current = null;

        Token lv_functionName_1_0=null;
        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBug296889ExTestLanguageParser.g:193:28: ( ( () ( (lv_functionName_1_0= HyphenMinusHyphenMinus ) ) ( (lv_expr_2_0= ruleVariable ) ) ) )
            // InternalBug296889ExTestLanguageParser.g:194:1: ( () ( (lv_functionName_1_0= HyphenMinusHyphenMinus ) ) ( (lv_expr_2_0= ruleVariable ) ) )
            {
            // InternalBug296889ExTestLanguageParser.g:194:1: ( () ( (lv_functionName_1_0= HyphenMinusHyphenMinus ) ) ( (lv_expr_2_0= ruleVariable ) ) )
            // InternalBug296889ExTestLanguageParser.g:194:2: () ( (lv_functionName_1_0= HyphenMinusHyphenMinus ) ) ( (lv_expr_2_0= ruleVariable ) )
            {
            // InternalBug296889ExTestLanguageParser.g:194:2: ()
            // InternalBug296889ExTestLanguageParser.g:195:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPreopAccess().getPreopAction_0(),
                          current);
                  
            }

            }

            // InternalBug296889ExTestLanguageParser.g:203:2: ( (lv_functionName_1_0= HyphenMinusHyphenMinus ) )
            // InternalBug296889ExTestLanguageParser.g:204:1: (lv_functionName_1_0= HyphenMinusHyphenMinus )
            {
            // InternalBug296889ExTestLanguageParser.g:204:1: (lv_functionName_1_0= HyphenMinusHyphenMinus )
            // InternalBug296889ExTestLanguageParser.g:205:3: lv_functionName_1_0= HyphenMinusHyphenMinus
            {
            lv_functionName_1_0=(Token)match(input,HyphenMinusHyphenMinus,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_functionName_1_0, grammarAccess.getPreopAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPreopRule());
              	        }
                     		setWithLastConsumed(current, "functionName", lv_functionName_1_0, "--");
              	    
            }

            }


            }

            // InternalBug296889ExTestLanguageParser.g:219:2: ( (lv_expr_2_0= ruleVariable ) )
            // InternalBug296889ExTestLanguageParser.g:220:1: (lv_expr_2_0= ruleVariable )
            {
            // InternalBug296889ExTestLanguageParser.g:220:1: (lv_expr_2_0= ruleVariable )
            // InternalBug296889ExTestLanguageParser.g:221:3: lv_expr_2_0= ruleVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPreopAccess().getExprVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_2_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPreopRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_2_0, 
                      		"org.eclipse.xtext.parser.antlr.Bug296889ExTestLanguage.Variable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


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
    // $ANTLR end "rulePreop"


    // $ANTLR start "entryRulePostop"
    // InternalBug296889ExTestLanguageParser.g:245:1: entryRulePostop returns [EObject current=null] : iv_rulePostop= rulePostop EOF ;
    public final EObject entryRulePostop() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostop = null;


        try {
            // InternalBug296889ExTestLanguageParser.g:246:2: (iv_rulePostop= rulePostop EOF )
            // InternalBug296889ExTestLanguageParser.g:247:2: iv_rulePostop= rulePostop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostopRule()); 
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
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostop"


    // $ANTLR start "rulePostop"
    // InternalBug296889ExTestLanguageParser.g:254:1: rulePostop returns [EObject current=null] : (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= HyphenMinusHyphenMinus ) ) )? ) ;
    public final EObject rulePostop() throws RecognitionException {
        EObject current = null;

        Token lv_functionName_2_0=null;
        EObject this_Variable_0 = null;


         enterRule(); 
            
        try {
            // InternalBug296889ExTestLanguageParser.g:257:28: ( (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= HyphenMinusHyphenMinus ) ) )? ) )
            // InternalBug296889ExTestLanguageParser.g:258:1: (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= HyphenMinusHyphenMinus ) ) )? )
            {
            // InternalBug296889ExTestLanguageParser.g:258:1: (this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= HyphenMinusHyphenMinus ) ) )? )
            // InternalBug296889ExTestLanguageParser.g:259:2: this_Variable_0= ruleVariable ( () ( (lv_functionName_2_0= HyphenMinusHyphenMinus ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPostopAccess().getVariableParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_5);
            this_Variable_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_Variable_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBug296889ExTestLanguageParser.g:270:1: ( () ( (lv_functionName_2_0= HyphenMinusHyphenMinus ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==HyphenMinusHyphenMinus) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==EOF||LA5_1==HyphenMinusHyphenMinus) ) {
                    alt5=1;
                }
                else if ( (LA5_1==RULE_ID) ) {
                    int LA5_4 = input.LA(3);

                    if ( (synpred5_InternalBug296889ExTestLanguageParser()) ) {
                        alt5=1;
                    }
                }
            }
            switch (alt5) {
                case 1 :
                    // InternalBug296889ExTestLanguageParser.g:270:2: () ( (lv_functionName_2_0= HyphenMinusHyphenMinus ) )
                    {
                    // InternalBug296889ExTestLanguageParser.g:270:2: ()
                    // InternalBug296889ExTestLanguageParser.g:271:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getPostopAccess().getPostopExprAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalBug296889ExTestLanguageParser.g:279:2: ( (lv_functionName_2_0= HyphenMinusHyphenMinus ) )
                    // InternalBug296889ExTestLanguageParser.g:280:1: (lv_functionName_2_0= HyphenMinusHyphenMinus )
                    {
                    // InternalBug296889ExTestLanguageParser.g:280:1: (lv_functionName_2_0= HyphenMinusHyphenMinus )
                    // InternalBug296889ExTestLanguageParser.g:281:3: lv_functionName_2_0= HyphenMinusHyphenMinus
                    {
                    lv_functionName_2_0=(Token)match(input,HyphenMinusHyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_functionName_2_0, grammarAccess.getPostopAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPostopRule());
                      	        }
                             		setWithLastConsumed(current, "functionName", lv_functionName_2_0, "--");
                      	    
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
    // $ANTLR end "rulePostop"


    // $ANTLR start "entryRuleVariable"
    // InternalBug296889ExTestLanguageParser.g:303:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalBug296889ExTestLanguageParser.g:304:2: (iv_ruleVariable= ruleVariable EOF )
            // InternalBug296889ExTestLanguageParser.g:305:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
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
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalBug296889ExTestLanguageParser.g:312:1: ruleVariable returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalBug296889ExTestLanguageParser.g:315:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalBug296889ExTestLanguageParser.g:316:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalBug296889ExTestLanguageParser.g:316:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalBug296889ExTestLanguageParser.g:316:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalBug296889ExTestLanguageParser.g:316:2: ()
            // InternalBug296889ExTestLanguageParser.g:317:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVariableAccess().getVariableAction_0(),
                          current);
                  
            }

            }

            // InternalBug296889ExTestLanguageParser.g:325:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalBug296889ExTestLanguageParser.g:326:1: (lv_name_1_0= RULE_ID )
            {
            // InternalBug296889ExTestLanguageParser.g:326:1: (lv_name_1_0= RULE_ID )
            // InternalBug296889ExTestLanguageParser.g:327:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVariableRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


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
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleDataTypeExpression"
    // InternalBug296889ExTestLanguageParser.g:351:1: entryRuleDataTypeExpression returns [String current=null] : iv_ruleDataTypeExpression= ruleDataTypeExpression EOF ;
    public final String entryRuleDataTypeExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeExpression = null;


        try {
            // InternalBug296889ExTestLanguageParser.g:352:1: (iv_ruleDataTypeExpression= ruleDataTypeExpression EOF )
            // InternalBug296889ExTestLanguageParser.g:353:2: iv_ruleDataTypeExpression= ruleDataTypeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypeExpression=ruleDataTypeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeExpression.getText(); 
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
    // $ANTLR end "entryRuleDataTypeExpression"


    // $ANTLR start "ruleDataTypeExpression"
    // InternalBug296889ExTestLanguageParser.g:360:1: ruleDataTypeExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop ) ;
    public final AntlrDatatypeRuleToken ruleDataTypeExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_DataTypePostop_0 = null;

        AntlrDatatypeRuleToken this_DataTypePreop_1 = null;


         enterRule(); 
            
        try {
            // InternalBug296889ExTestLanguageParser.g:364:6: ( (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop ) )
            // InternalBug296889ExTestLanguageParser.g:365:1: (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop )
            {
            // InternalBug296889ExTestLanguageParser.g:365:1: (this_DataTypePostop_0= ruleDataTypePostop | this_DataTypePreop_1= ruleDataTypePreop )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==HyphenMinusHyphenMinus) ) {
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
                    // InternalBug296889ExTestLanguageParser.g:366:5: this_DataTypePostop_0= ruleDataTypePostop
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDataTypeExpressionAccess().getDataTypePostopParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DataTypePostop_0=ruleDataTypePostop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DataTypePostop_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBug296889ExTestLanguageParser.g:378:5: this_DataTypePreop_1= ruleDataTypePreop
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDataTypeExpressionAccess().getDataTypePreopParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DataTypePreop_1=ruleDataTypePreop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DataTypePreop_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
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
    // $ANTLR end "ruleDataTypeExpression"


    // $ANTLR start "entryRuleDataTypePreop"
    // InternalBug296889ExTestLanguageParser.g:396:1: entryRuleDataTypePreop returns [String current=null] : iv_ruleDataTypePreop= ruleDataTypePreop EOF ;
    public final String entryRuleDataTypePreop() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypePreop = null;


        try {
            // InternalBug296889ExTestLanguageParser.g:397:1: (iv_ruleDataTypePreop= ruleDataTypePreop EOF )
            // InternalBug296889ExTestLanguageParser.g:398:2: iv_ruleDataTypePreop= ruleDataTypePreop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypePreopRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypePreop=ruleDataTypePreop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypePreop.getText(); 
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
    // $ANTLR end "entryRuleDataTypePreop"


    // $ANTLR start "ruleDataTypePreop"
    // InternalBug296889ExTestLanguageParser.g:405:1: ruleDataTypePreop returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= HyphenMinusHyphenMinus this_DataTypeVariable_1= ruleDataTypeVariable ) ;
    public final AntlrDatatypeRuleToken ruleDataTypePreop() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_DataTypeVariable_1 = null;


         enterRule(); 
            
        try {
            // InternalBug296889ExTestLanguageParser.g:409:6: ( (kw= HyphenMinusHyphenMinus this_DataTypeVariable_1= ruleDataTypeVariable ) )
            // InternalBug296889ExTestLanguageParser.g:410:1: (kw= HyphenMinusHyphenMinus this_DataTypeVariable_1= ruleDataTypeVariable )
            {
            // InternalBug296889ExTestLanguageParser.g:410:1: (kw= HyphenMinusHyphenMinus this_DataTypeVariable_1= ruleDataTypeVariable )
            // InternalBug296889ExTestLanguageParser.g:411:2: kw= HyphenMinusHyphenMinus this_DataTypeVariable_1= ruleDataTypeVariable
            {
            kw=(Token)match(input,HyphenMinusHyphenMinus,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getDataTypePreopAccess().getHyphenMinusHyphenMinusKeyword_0()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getDataTypePreopAccess().getDataTypeVariableParserRuleCall_1()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_DataTypeVariable_1=ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DataTypeVariable_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
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
    // $ANTLR end "ruleDataTypePreop"


    // $ANTLR start "entryRuleDataTypePostop"
    // InternalBug296889ExTestLanguageParser.g:435:1: entryRuleDataTypePostop returns [String current=null] : iv_ruleDataTypePostop= ruleDataTypePostop EOF ;
    public final String entryRuleDataTypePostop() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypePostop = null;


        try {
            // InternalBug296889ExTestLanguageParser.g:436:1: (iv_ruleDataTypePostop= ruleDataTypePostop EOF )
            // InternalBug296889ExTestLanguageParser.g:437:2: iv_ruleDataTypePostop= ruleDataTypePostop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypePostopRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypePostop=ruleDataTypePostop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypePostop.getText(); 
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
    // $ANTLR end "entryRuleDataTypePostop"


    // $ANTLR start "ruleDataTypePostop"
    // InternalBug296889ExTestLanguageParser.g:444:1: ruleDataTypePostop returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DataTypeVariable_0= ruleDataTypeVariable (kw= HyphenMinusHyphenMinus )? ) ;
    public final AntlrDatatypeRuleToken ruleDataTypePostop() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_DataTypeVariable_0 = null;


         enterRule(); 
            
        try {
            // InternalBug296889ExTestLanguageParser.g:448:6: ( (this_DataTypeVariable_0= ruleDataTypeVariable (kw= HyphenMinusHyphenMinus )? ) )
            // InternalBug296889ExTestLanguageParser.g:449:1: (this_DataTypeVariable_0= ruleDataTypeVariable (kw= HyphenMinusHyphenMinus )? )
            {
            // InternalBug296889ExTestLanguageParser.g:449:1: (this_DataTypeVariable_0= ruleDataTypeVariable (kw= HyphenMinusHyphenMinus )? )
            // InternalBug296889ExTestLanguageParser.g:450:5: this_DataTypeVariable_0= ruleDataTypeVariable (kw= HyphenMinusHyphenMinus )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getDataTypePostopAccess().getDataTypeVariableParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_5);
            this_DataTypeVariable_0=ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DataTypeVariable_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBug296889ExTestLanguageParser.g:460:1: (kw= HyphenMinusHyphenMinus )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==HyphenMinusHyphenMinus) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID) ) {
                    int LA7_3 = input.LA(3);

                    if ( (synpred7_InternalBug296889ExTestLanguageParser()) ) {
                        alt7=1;
                    }
                }
                else if ( (LA7_1==EOF||LA7_1==HyphenMinusHyphenMinus) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalBug296889ExTestLanguageParser.g:461:2: kw= HyphenMinusHyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinusHyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDataTypePostopAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                          
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
    // $ANTLR end "ruleDataTypePostop"


    // $ANTLR start "entryRuleDataTypeVariable"
    // InternalBug296889ExTestLanguageParser.g:474:1: entryRuleDataTypeVariable returns [String current=null] : iv_ruleDataTypeVariable= ruleDataTypeVariable EOF ;
    public final String entryRuleDataTypeVariable() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeVariable = null;


        try {
            // InternalBug296889ExTestLanguageParser.g:475:1: (iv_ruleDataTypeVariable= ruleDataTypeVariable EOF )
            // InternalBug296889ExTestLanguageParser.g:476:2: iv_ruleDataTypeVariable= ruleDataTypeVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeVariableRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataTypeVariable=ruleDataTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeVariable.getText(); 
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
    // $ANTLR end "entryRuleDataTypeVariable"


    // $ANTLR start "ruleDataTypeVariable"
    // InternalBug296889ExTestLanguageParser.g:483:1: ruleDataTypeVariable returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleDataTypeVariable() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalBug296889ExTestLanguageParser.g:487:6: (this_ID_0= RULE_ID )
            // InternalBug296889ExTestLanguageParser.g:488:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getDataTypeVariableAccess().getIDTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleDataTypeVariable"

    // $ANTLR start synpred5_InternalBug296889ExTestLanguageParser
    public final void synpred5_InternalBug296889ExTestLanguageParser_fragment() throws RecognitionException {   
        Token lv_functionName_2_0=null;

        // InternalBug296889ExTestLanguageParser.g:270:2: ( () ( (lv_functionName_2_0= HyphenMinusHyphenMinus ) ) )
        // InternalBug296889ExTestLanguageParser.g:270:2: () ( (lv_functionName_2_0= HyphenMinusHyphenMinus ) )
        {
        // InternalBug296889ExTestLanguageParser.g:270:2: ()
        // InternalBug296889ExTestLanguageParser.g:271:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // InternalBug296889ExTestLanguageParser.g:279:2: ( (lv_functionName_2_0= HyphenMinusHyphenMinus ) )
        // InternalBug296889ExTestLanguageParser.g:280:1: (lv_functionName_2_0= HyphenMinusHyphenMinus )
        {
        // InternalBug296889ExTestLanguageParser.g:280:1: (lv_functionName_2_0= HyphenMinusHyphenMinus )
        // InternalBug296889ExTestLanguageParser.g:281:3: lv_functionName_2_0= HyphenMinusHyphenMinus
        {
        lv_functionName_2_0=(Token)match(input,HyphenMinusHyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred5_InternalBug296889ExTestLanguageParser

    // $ANTLR start synpred7_InternalBug296889ExTestLanguageParser
    public final void synpred7_InternalBug296889ExTestLanguageParser_fragment() throws RecognitionException {   
        Token kw=null;

        // InternalBug296889ExTestLanguageParser.g:461:2: (kw= HyphenMinusHyphenMinus )
        // InternalBug296889ExTestLanguageParser.g:461:2: kw= HyphenMinusHyphenMinus
        {
        kw=(Token)match(input,HyphenMinusHyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalBug296889ExTestLanguageParser

    // Delegated rules

    public final boolean synpred5_InternalBug296889ExTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalBug296889ExTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalBug296889ExTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalBug296889ExTestLanguageParser_fragment(); // can never throw exception
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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000042L});
    }


}
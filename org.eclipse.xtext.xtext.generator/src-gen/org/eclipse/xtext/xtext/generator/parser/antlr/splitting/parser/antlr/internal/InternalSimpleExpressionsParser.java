package org.eclipse.xtext.xtext.generator.parser.antlr.splitting.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.services.SimpleExpressionsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSimpleExpressionsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'else'", "'if'", "'('", "')'", "'{'", "'||'", "'&&'", "'=='", "'<='", "'>='", "'!'", "'true'", "'false'", "','", "'.'"
    };
    public static final int RULE_ID=5;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalSimpleExpressionsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSimpleExpressionsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSimpleExpressionsParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSimpleExpressions.g"; }



     	private SimpleExpressionsGrammarAccess grammarAccess;
     	
        public InternalSimpleExpressionsParser(TokenStream input, SimpleExpressionsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "IfCondition";	
       	}
       	
       	@Override
       	protected SimpleExpressionsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleIfCondition"
    // InternalSimpleExpressions.g:67:1: entryRuleIfCondition returns [EObject current=null] : iv_ruleIfCondition= ruleIfCondition EOF ;
    public final EObject entryRuleIfCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfCondition = null;


        try {
            // InternalSimpleExpressions.g:68:2: (iv_ruleIfCondition= ruleIfCondition EOF )
            // InternalSimpleExpressions.g:69:2: iv_ruleIfCondition= ruleIfCondition EOF
            {
             newCompositeNode(grammarAccess.getIfConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIfCondition=ruleIfCondition();

            state._fsp--;

             current =iv_ruleIfCondition; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIfCondition"


    // $ANTLR start "ruleIfCondition"
    // InternalSimpleExpressions.g:76:1: ruleIfCondition returns [EObject current=null] : ( ( (lv_elseif_0_0= 'else' ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ) ;
    public final EObject ruleIfCondition() throws RecognitionException {
        EObject current = null;

        Token lv_elseif_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_condition_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:79:28: ( ( ( (lv_elseif_0_0= 'else' ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ) )
            // InternalSimpleExpressions.g:80:1: ( ( (lv_elseif_0_0= 'else' ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' )
            {
            // InternalSimpleExpressions.g:80:1: ( ( (lv_elseif_0_0= 'else' ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' )
            // InternalSimpleExpressions.g:80:2: ( (lv_elseif_0_0= 'else' ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{'
            {
            // InternalSimpleExpressions.g:80:2: ( (lv_elseif_0_0= 'else' ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalSimpleExpressions.g:81:1: (lv_elseif_0_0= 'else' )
                    {
                    // InternalSimpleExpressions.g:81:1: (lv_elseif_0_0= 'else' )
                    // InternalSimpleExpressions.g:82:3: lv_elseif_0_0= 'else'
                    {
                    lv_elseif_0_0=(Token)match(input,11,FOLLOW_3); 

                            newLeafNode(lv_elseif_0_0, grammarAccess.getIfConditionAccess().getElseifElseKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIfConditionRule());
                    	        }
                           		setWithLastConsumed(current, "elseif", true, "else");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,12,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getIfConditionAccess().getIfKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_5); 

                	newLeafNode(otherlv_2, grammarAccess.getIfConditionAccess().getLeftParenthesisKeyword_2());
                
            // InternalSimpleExpressions.g:103:1: ( (lv_condition_3_0= ruleExpression ) )
            // InternalSimpleExpressions.g:104:1: (lv_condition_3_0= ruleExpression )
            {
            // InternalSimpleExpressions.g:104:1: (lv_condition_3_0= ruleExpression )
            // InternalSimpleExpressions.g:105:3: lv_condition_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIfConditionAccess().getConditionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_6);
            lv_condition_3_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfConditionRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_3_0, 
                    		"org.eclipse.xtext.xtext.generator.parser.antlr.splitting.SimpleExpressions.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_7); 

                	newLeafNode(otherlv_4, grammarAccess.getIfConditionAccess().getRightParenthesisKeyword_4());
                
            otherlv_5=(Token)match(input,15,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getIfConditionAccess().getLeftCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfCondition"


    // $ANTLR start "entryRuleExpression"
    // InternalSimpleExpressions.g:137:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalSimpleExpressions.g:138:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalSimpleExpressions.g:139:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalSimpleExpressions.g:146:1: ruleExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:149:28: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalSimpleExpressions.g:150:1: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalSimpleExpressions.g:150:1: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalSimpleExpressions.g:151:5: this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getAndExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_8);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;

             
                    current = this_AndExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalSimpleExpressions.g:159:1: ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSimpleExpressions.g:159:2: () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalSimpleExpressions.g:159:2: ()
            	    // InternalSimpleExpressions.g:160:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getExpressionAccess().getOrExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,16,FOLLOW_5); 

            	        	newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	        
            	    // InternalSimpleExpressions.g:169:1: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalSimpleExpressions.g:170:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalSimpleExpressions.g:170:1: (lv_right_3_0= ruleAndExpression )
            	    // InternalSimpleExpressions.g:171:3: lv_right_3_0= ruleAndExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_8);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"org.eclipse.xtext.xtext.generator.parser.antlr.splitting.SimpleExpressions.AndExpression");
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

             leaveRule(); 
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


    // $ANTLR start "entryRuleAndExpression"
    // InternalSimpleExpressions.g:195:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalSimpleExpressions.g:196:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalSimpleExpressions.g:197:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalSimpleExpressions.g:204:1: ruleAndExpression returns [EObject current=null] : (this_Comparison_0= ruleComparison ( () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:207:28: ( (this_Comparison_0= ruleComparison ( () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalSimpleExpressions.g:208:1: (this_Comparison_0= ruleComparison ( () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalSimpleExpressions.g:208:1: (this_Comparison_0= ruleComparison ( () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalSimpleExpressions.g:209:5: this_Comparison_0= ruleComparison ( () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAndExpressionAccess().getComparisonParserRuleCall_0()); 
                
            pushFollow(FOLLOW_9);
            this_Comparison_0=ruleComparison();

            state._fsp--;

             
                    current = this_Comparison_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalSimpleExpressions.g:217:1: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSimpleExpressions.g:217:2: () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalSimpleExpressions.g:217:2: ()
            	    // InternalSimpleExpressions.g:218:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,17,FOLLOW_5); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	        
            	    // InternalSimpleExpressions.g:227:1: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalSimpleExpressions.g:228:1: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalSimpleExpressions.g:228:1: (lv_right_3_0= ruleComparison )
            	    // InternalSimpleExpressions.g:229:3: lv_right_3_0= ruleComparison
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAndExpressionAccess().getRightComparisonParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_9);
            	    lv_right_3_0=ruleComparison();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"org.eclipse.xtext.xtext.generator.parser.antlr.splitting.SimpleExpressions.Comparison");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleComparison"
    // InternalSimpleExpressions.g:253:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalSimpleExpressions.g:254:2: (iv_ruleComparison= ruleComparison EOF )
            // InternalSimpleExpressions.g:255:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalSimpleExpressions.g:262:1: ruleComparison returns [EObject current=null] : (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )? ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        EObject this_PrefixExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:265:28: ( (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )? ) )
            // InternalSimpleExpressions.g:266:1: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )? )
            {
            // InternalSimpleExpressions.g:266:1: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )? )
            // InternalSimpleExpressions.g:267:5: this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getComparisonAccess().getPrefixExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_10);
            this_PrefixExpression_0=rulePrefixExpression();

            state._fsp--;

             
                    current = this_PrefixExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalSimpleExpressions.g:275:1: ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=18 && LA5_0<=20)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSimpleExpressions.g:275:2: () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) )
                    {
                    // InternalSimpleExpressions.g:275:2: ()
                    // InternalSimpleExpressions.g:276:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0(),
                                current);
                        

                    }

                    // InternalSimpleExpressions.g:281:2: ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) )
                    // InternalSimpleExpressions.g:282:1: ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) )
                    {
                    // InternalSimpleExpressions.g:282:1: ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) )
                    // InternalSimpleExpressions.g:283:1: (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' )
                    {
                    // InternalSimpleExpressions.g:283:1: (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' )
                    int alt4=3;
                    switch ( input.LA(1) ) {
                    case 18:
                        {
                        alt4=1;
                        }
                        break;
                    case 19:
                        {
                        alt4=2;
                        }
                        break;
                    case 20:
                        {
                        alt4=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }

                    switch (alt4) {
                        case 1 :
                            // InternalSimpleExpressions.g:284:3: lv_operator_2_1= '=='
                            {
                            lv_operator_2_1=(Token)match(input,18,FOLLOW_5); 

                                    newLeafNode(lv_operator_2_1, grammarAccess.getComparisonAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getComparisonRule());
                            	        }
                                   		setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // InternalSimpleExpressions.g:296:8: lv_operator_2_2= '<='
                            {
                            lv_operator_2_2=(Token)match(input,19,FOLLOW_5); 

                                    newLeafNode(lv_operator_2_2, grammarAccess.getComparisonAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getComparisonRule());
                            	        }
                                   		setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // InternalSimpleExpressions.g:308:8: lv_operator_2_3= '>='
                            {
                            lv_operator_2_3=(Token)match(input,20,FOLLOW_5); 

                                    newLeafNode(lv_operator_2_3, grammarAccess.getComparisonAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getComparisonRule());
                            	        }
                                   		setWithLastConsumed(current, "operator", lv_operator_2_3, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // InternalSimpleExpressions.g:323:2: ( (lv_right_3_0= rulePrefixExpression ) )
                    // InternalSimpleExpressions.g:324:1: (lv_right_3_0= rulePrefixExpression )
                    {
                    // InternalSimpleExpressions.g:324:1: (lv_right_3_0= rulePrefixExpression )
                    // InternalSimpleExpressions.g:325:3: lv_right_3_0= rulePrefixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getComparisonAccess().getRightPrefixExpressionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=rulePrefixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getComparisonRule());
                    	        }
                           		set(
                           			current, 
                           			"right",
                            		lv_right_3_0, 
                            		"org.eclipse.xtext.xtext.generator.parser.antlr.splitting.SimpleExpressions.PrefixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRulePrefixExpression"
    // InternalSimpleExpressions.g:349:1: entryRulePrefixExpression returns [EObject current=null] : iv_rulePrefixExpression= rulePrefixExpression EOF ;
    public final EObject entryRulePrefixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpression = null;


        try {
            // InternalSimpleExpressions.g:350:2: (iv_rulePrefixExpression= rulePrefixExpression EOF )
            // InternalSimpleExpressions.g:351:2: iv_rulePrefixExpression= rulePrefixExpression EOF
            {
             newCompositeNode(grammarAccess.getPrefixExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrefixExpression=rulePrefixExpression();

            state._fsp--;

             current =iv_rulePrefixExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePrefixExpression"


    // $ANTLR start "rulePrefixExpression"
    // InternalSimpleExpressions.g:358:1: rulePrefixExpression returns [EObject current=null] : ( ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom ) ;
    public final EObject rulePrefixExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;

        EObject this_Atom_3 = null;


         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:361:28: ( ( ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom ) )
            // InternalSimpleExpressions.g:362:1: ( ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom )
            {
            // InternalSimpleExpressions.g:362:1: ( ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=RULE_INT && LA6_0<=RULE_ID)||LA6_0==13||(LA6_0>=22 && LA6_0<=23)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSimpleExpressions.g:362:2: ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) ) )
                    {
                    // InternalSimpleExpressions.g:362:2: ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) ) )
                    // InternalSimpleExpressions.g:362:3: () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) )
                    {
                    // InternalSimpleExpressions.g:362:3: ()
                    // InternalSimpleExpressions.g:363:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrefixExpressionAccess().getNotExpressionAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_5); 

                        	newLeafNode(otherlv_1, grammarAccess.getPrefixExpressionAccess().getExclamationMarkKeyword_0_1());
                        
                    // InternalSimpleExpressions.g:372:1: ( (lv_expression_2_0= ruleAtom ) )
                    // InternalSimpleExpressions.g:373:1: (lv_expression_2_0= ruleAtom )
                    {
                    // InternalSimpleExpressions.g:373:1: (lv_expression_2_0= ruleAtom )
                    // InternalSimpleExpressions.g:374:3: lv_expression_2_0= ruleAtom
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrefixExpressionAccess().getExpressionAtomParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleAtom();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrefixExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_2_0, 
                            		"org.eclipse.xtext.xtext.generator.parser.antlr.splitting.SimpleExpressions.Atom");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleExpressions.g:392:5: this_Atom_3= ruleAtom
                    {
                     
                            newCompositeNode(grammarAccess.getPrefixExpressionAccess().getAtomParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Atom_3=ruleAtom();

                    state._fsp--;

                     
                            current = this_Atom_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixExpression"


    // $ANTLR start "entryRuleAtom"
    // InternalSimpleExpressions.g:408:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // InternalSimpleExpressions.g:409:2: (iv_ruleAtom= ruleAtom EOF )
            // InternalSimpleExpressions.g:410:2: iv_ruleAtom= ruleAtom EOF
            {
             newCompositeNode(grammarAccess.getAtomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalSimpleExpressions.g:417:1: ruleAtom returns [EObject current=null] : (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall | this_BooleanLiteral_3= ruleBooleanLiteral ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        EObject this_ParenthesizedExpression_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_MethodCall_2 = null;

        EObject this_BooleanLiteral_3 = null;


         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:420:28: ( (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall | this_BooleanLiteral_3= ruleBooleanLiteral ) )
            // InternalSimpleExpressions.g:421:1: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall | this_BooleanLiteral_3= ruleBooleanLiteral )
            {
            // InternalSimpleExpressions.g:421:1: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall | this_BooleanLiteral_3= ruleBooleanLiteral )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt7=1;
                }
                break;
            case RULE_INT:
                {
                alt7=2;
                }
                break;
            case RULE_ID:
                {
                alt7=3;
                }
                break;
            case 22:
            case 23:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalSimpleExpressions.g:422:5: this_ParenthesizedExpression_0= ruleParenthesizedExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAtomAccess().getParenthesizedExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ParenthesizedExpression_0=ruleParenthesizedExpression();

                    state._fsp--;

                     
                            current = this_ParenthesizedExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalSimpleExpressions.g:432:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getAtomAccess().getNumberLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalSimpleExpressions.g:442:5: this_MethodCall_2= ruleMethodCall
                    {
                     
                            newCompositeNode(grammarAccess.getAtomAccess().getMethodCallParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_MethodCall_2=ruleMethodCall();

                    state._fsp--;

                     
                            current = this_MethodCall_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalSimpleExpressions.g:452:5: this_BooleanLiteral_3= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getAtomAccess().getBooleanLiteralParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteral_3=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleNumberLiteral"
    // InternalSimpleExpressions.g:468:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalSimpleExpressions.g:469:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalSimpleExpressions.g:470:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // InternalSimpleExpressions.g:477:1: ruleNumberLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:480:28: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalSimpleExpressions.g:481:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalSimpleExpressions.g:481:1: ( (lv_value_0_0= RULE_INT ) )
            // InternalSimpleExpressions.g:482:1: (lv_value_0_0= RULE_INT )
            {
            // InternalSimpleExpressions.g:482:1: (lv_value_0_0= RULE_INT )
            // InternalSimpleExpressions.g:483:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            			newLeafNode(lv_value_0_0, grammarAccess.getNumberLiteralAccess().getValueINTTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNumberLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalSimpleExpressions.g:507:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalSimpleExpressions.g:508:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalSimpleExpressions.g:509:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalSimpleExpressions.g:516:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:519:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalSimpleExpressions.g:520:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalSimpleExpressions.g:520:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalSimpleExpressions.g:520:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalSimpleExpressions.g:520:2: ()
            // InternalSimpleExpressions.g:521:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // InternalSimpleExpressions.g:526:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            else if ( (LA8_0==23) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalSimpleExpressions.g:526:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalSimpleExpressions.g:526:3: ( (lv_value_1_0= 'true' ) )
                    // InternalSimpleExpressions.g:527:1: (lv_value_1_0= 'true' )
                    {
                    // InternalSimpleExpressions.g:527:1: (lv_value_1_0= 'true' )
                    // InternalSimpleExpressions.g:528:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,22,FOLLOW_2); 

                            newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanLiteralRule());
                    	        }
                           		setWithLastConsumed(current, "value", true, "true");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleExpressions.g:542:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_2); 

                        	newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // InternalSimpleExpressions.g:554:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // InternalSimpleExpressions.g:555:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // InternalSimpleExpressions.g:556:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // InternalSimpleExpressions.g:563:1: ruleParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:566:28: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // InternalSimpleExpressions.g:567:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // InternalSimpleExpressions.g:567:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // InternalSimpleExpressions.g:567:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1()); 
                
            pushFollow(FOLLOW_6);
            this_Expression_1=ruleExpression();

            state._fsp--;

             
                    current = this_Expression_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleMethodCall"
    // InternalSimpleExpressions.g:592:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // InternalSimpleExpressions.g:593:2: (iv_ruleMethodCall= ruleMethodCall EOF )
            // InternalSimpleExpressions.g:594:2: iv_ruleMethodCall= ruleMethodCall EOF
            {
             newCompositeNode(grammarAccess.getMethodCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMethodCall=ruleMethodCall();

            state._fsp--;

             current =iv_ruleMethodCall; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMethodCall"


    // $ANTLR start "ruleMethodCall"
    // InternalSimpleExpressions.g:601:1: ruleMethodCall returns [EObject current=null] : ( (lv_value_0_0= ruleMethodCallLiteral ) ) ;
    public final EObject ruleMethodCall() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:604:28: ( ( (lv_value_0_0= ruleMethodCallLiteral ) ) )
            // InternalSimpleExpressions.g:605:1: ( (lv_value_0_0= ruleMethodCallLiteral ) )
            {
            // InternalSimpleExpressions.g:605:1: ( (lv_value_0_0= ruleMethodCallLiteral ) )
            // InternalSimpleExpressions.g:606:1: (lv_value_0_0= ruleMethodCallLiteral )
            {
            // InternalSimpleExpressions.g:606:1: (lv_value_0_0= ruleMethodCallLiteral )
            // InternalSimpleExpressions.g:607:3: lv_value_0_0= ruleMethodCallLiteral
            {
             
            	        newCompositeNode(grammarAccess.getMethodCallAccess().getValueMethodCallLiteralParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleMethodCallLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMethodCallRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.eclipse.xtext.xtext.generator.parser.antlr.splitting.SimpleExpressions.MethodCallLiteral");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodCall"


    // $ANTLR start "entryRuleMethodCallLiteral"
    // InternalSimpleExpressions.g:631:1: entryRuleMethodCallLiteral returns [String current=null] : iv_ruleMethodCallLiteral= ruleMethodCallLiteral EOF ;
    public final String entryRuleMethodCallLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMethodCallLiteral = null;


        try {
            // InternalSimpleExpressions.g:632:2: (iv_ruleMethodCallLiteral= ruleMethodCallLiteral EOF )
            // InternalSimpleExpressions.g:633:2: iv_ruleMethodCallLiteral= ruleMethodCallLiteral EOF
            {
             newCompositeNode(grammarAccess.getMethodCallLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMethodCallLiteral=ruleMethodCallLiteral();

            state._fsp--;

             current =iv_ruleMethodCallLiteral.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMethodCallLiteral"


    // $ANTLR start "ruleMethodCallLiteral"
    // InternalSimpleExpressions.g:640:1: ruleMethodCallLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )? ) ;
    public final AntlrDatatypeRuleToken ruleMethodCallLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;

        AntlrDatatypeRuleToken this_Argument_2 = null;

        AntlrDatatypeRuleToken this_Argument_4 = null;

        AntlrDatatypeRuleToken this_MethodCallLiteral_7 = null;


         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:643:28: ( (this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )? ) )
            // InternalSimpleExpressions.g:644:1: (this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )? )
            {
            // InternalSimpleExpressions.g:644:1: (this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )? )
            // InternalSimpleExpressions.g:645:5: this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )?
            {
             
                    newCompositeNode(grammarAccess.getMethodCallLiteralAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_11);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalSimpleExpressions.g:655:1: (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==13) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSimpleExpressions.g:656:2: kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )?
                    {
                    kw=(Token)match(input,13,FOLLOW_12); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMethodCallLiteralAccess().getLeftParenthesisKeyword_1_0()); 
                        
                    // InternalSimpleExpressions.g:661:1: (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=RULE_INT && LA10_0<=RULE_ID)) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalSimpleExpressions.g:662:5: this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )*
                            {
                             
                                    newCompositeNode(grammarAccess.getMethodCallLiteralAccess().getArgumentParserRuleCall_1_1_0()); 
                                
                            pushFollow(FOLLOW_13);
                            this_Argument_2=ruleArgument();

                            state._fsp--;


                            		current.merge(this_Argument_2);
                                
                             
                                    afterParserOrEnumRuleCall();
                                
                            // InternalSimpleExpressions.g:672:1: (kw= ',' this_Argument_4= ruleArgument )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==24) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // InternalSimpleExpressions.g:673:2: kw= ',' this_Argument_4= ruleArgument
                            	    {
                            	    kw=(Token)match(input,24,FOLLOW_14); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getMethodCallLiteralAccess().getCommaKeyword_1_1_1_0()); 
                            	        
                            	     
                            	            newCompositeNode(grammarAccess.getMethodCallLiteralAccess().getArgumentParserRuleCall_1_1_1_1()); 
                            	        
                            	    pushFollow(FOLLOW_13);
                            	    this_Argument_4=ruleArgument();

                            	    state._fsp--;


                            	    		current.merge(this_Argument_4);
                            	        
                            	     
                            	            afterParserOrEnumRuleCall();
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop9;
                                }
                            } while (true);


                            }
                            break;

                    }

                    kw=(Token)match(input,14,FOLLOW_15); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMethodCallLiteralAccess().getRightParenthesisKeyword_1_2()); 
                        
                    // InternalSimpleExpressions.g:695:1: (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==25) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalSimpleExpressions.g:696:2: kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral
                            {
                            kw=(Token)match(input,25,FOLLOW_16); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getMethodCallLiteralAccess().getFullStopKeyword_1_3_0()); 
                                
                             
                                    newCompositeNode(grammarAccess.getMethodCallLiteralAccess().getMethodCallLiteralParserRuleCall_1_3_1()); 
                                
                            pushFollow(FOLLOW_2);
                            this_MethodCallLiteral_7=ruleMethodCallLiteral();

                            state._fsp--;


                            		current.merge(this_MethodCallLiteral_7);
                                
                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodCallLiteral"


    // $ANTLR start "entryRuleArgument"
    // InternalSimpleExpressions.g:720:1: entryRuleArgument returns [String current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final String entryRuleArgument() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArgument = null;


        try {
            // InternalSimpleExpressions.g:721:2: (iv_ruleArgument= ruleArgument EOF )
            // InternalSimpleExpressions.g:722:2: iv_ruleArgument= ruleArgument EOF
            {
             newCompositeNode(grammarAccess.getArgumentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArgument=ruleArgument();

            state._fsp--;

             current =iv_ruleArgument.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleArgument"


    // $ANTLR start "ruleArgument"
    // InternalSimpleExpressions.g:729:1: ruleArgument returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleArgument() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_MethodCallLiteral_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:732:28: ( (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT ) )
            // InternalSimpleExpressions.g:733:1: (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT )
            {
            // InternalSimpleExpressions.g:733:1: (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_INT) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalSimpleExpressions.g:734:5: this_MethodCallLiteral_0= ruleMethodCallLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getArgumentAccess().getMethodCallLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_MethodCallLiteral_0=ruleMethodCallLiteral();

                    state._fsp--;


                    		current.merge(this_MethodCallLiteral_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalSimpleExpressions.g:745:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getArgumentAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArgument"


    // $ANTLR start "entryRuleFQN"
    // InternalSimpleExpressions.g:760:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalSimpleExpressions.g:761:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalSimpleExpressions.g:762:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalSimpleExpressions.g:769:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalSimpleExpressions.g:772:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalSimpleExpressions.g:773:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalSimpleExpressions.g:773:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalSimpleExpressions.g:773:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalSimpleExpressions.g:780:1: (kw= '.' this_ID_2= RULE_ID )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==25) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSimpleExpressions.g:781:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,25,FOLLOW_16); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_15); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFQN"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000E02030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000001C0002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000020L});

}
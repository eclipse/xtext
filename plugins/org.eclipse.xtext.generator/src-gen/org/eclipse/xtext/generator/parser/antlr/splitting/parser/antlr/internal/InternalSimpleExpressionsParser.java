package org.eclipse.xtext.generator.parser.antlr.splitting.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.generator.parser.antlr.splitting.services.SimpleExpressionsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSimpleExpressionsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'else'", "'if'", "'('", "')'", "'{'", "'||'", "'&&'", "'=='", "'<='", "'>='", "'!'", "','", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=5;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalSimpleExpressionsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSimpleExpressionsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSimpleExpressionsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g"; }



     	private SimpleExpressionsGrammarAccess grammarAccess;
     	
        public InternalSimpleExpressionsParser(TokenStream input, IAstFactory factory, SimpleExpressionsGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:71:1: entryRuleIfCondition returns [EObject current=null] : iv_ruleIfCondition= ruleIfCondition EOF ;
    public final EObject entryRuleIfCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfCondition = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:72:2: (iv_ruleIfCondition= ruleIfCondition EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:73:2: iv_ruleIfCondition= ruleIfCondition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIfConditionRule(), currentNode); 
            pushFollow(FOLLOW_ruleIfCondition_in_entryRuleIfCondition75);
            iv_ruleIfCondition=ruleIfCondition();

            state._fsp--;

             current =iv_ruleIfCondition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfCondition85); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:80:1: ruleIfCondition returns [EObject current=null] : ( ( (lv_elseif_0_0= 'else' ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ) ;
    public final EObject ruleIfCondition() throws RecognitionException {
        EObject current = null;

        Token lv_elseif_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_condition_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:85:6: ( ( ( (lv_elseif_0_0= 'else' ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:86:1: ( ( (lv_elseif_0_0= 'else' ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:86:1: ( ( (lv_elseif_0_0= 'else' ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:86:2: ( (lv_elseif_0_0= 'else' ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{'
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:86:2: ( (lv_elseif_0_0= 'else' ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:87:1: (lv_elseif_0_0= 'else' )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:87:1: (lv_elseif_0_0= 'else' )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:88:3: lv_elseif_0_0= 'else'
                    {
                    lv_elseif_0_0=(Token)match(input,11,FOLLOW_11_in_ruleIfCondition128); 

                            createLeafNode(lv_elseif_0_0, grammarAccess.getIfConditionAccess().getElseifElseKeyword_0_0(), "elseif");
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIfConditionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "elseif", true, "else", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleIfCondition154); 

                	createLeafNode(otherlv_1, grammarAccess.getIfConditionAccess().getIfKeyword_1(), null);
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleIfCondition166); 

                	createLeafNode(otherlv_2, grammarAccess.getIfConditionAccess().getLeftParenthesisKeyword_2(), null);
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:115:1: ( (lv_condition_3_0= ruleExpression ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:116:1: (lv_condition_3_0= ruleExpression )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:116:1: (lv_condition_3_0= ruleExpression )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:117:3: lv_condition_3_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfConditionAccess().getConditionExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfCondition187);
            lv_condition_3_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIfConditionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"condition",
            	        		lv_condition_3_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleIfCondition199); 

                	createLeafNode(otherlv_4, grammarAccess.getIfConditionAccess().getRightParenthesisKeyword_4(), null);
                
            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleIfCondition211); 

                	createLeafNode(otherlv_5, grammarAccess.getIfConditionAccess().getLeftCurlyBracketKeyword_5(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:155:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:156:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:157:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression247);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression257); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:164:1: ruleExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:169:6: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:170:1: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:170:1: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:171:5: this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getAndExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAndExpression_in_ruleExpression304);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;

             
                    current = this_AndExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:179:1: ( () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:179:2: () otherlv_2= '||' ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:179:2: ()
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:180:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getExpressionAccess().getOrExpressionLeftAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getExpressionAccess().getOrExpressionLeftAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleExpression325); 

            	        	createLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getVerticalLineVerticalLineKeyword_1_1(), null);
            	        
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:199:1: ( (lv_right_3_0= ruleAndExpression ) )
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:200:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:200:1: (lv_right_3_0= ruleAndExpression )
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:201:3: lv_right_3_0= ruleAndExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAndExpression_in_ruleExpression346);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"right",
            	    	        		lv_right_3_0, 
            	    	        		"AndExpression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:231:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:232:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:233:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression384);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression394); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:240:1: ruleAndExpression returns [EObject current=null] : (this_Comparison_0= ruleComparison ( () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:245:6: ( (this_Comparison_0= ruleComparison ( () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:246:1: (this_Comparison_0= ruleComparison ( () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:246:1: (this_Comparison_0= ruleComparison ( () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) ) )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:247:5: this_Comparison_0= ruleComparison ( () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getComparisonParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleComparison_in_ruleAndExpression441);
            this_Comparison_0=ruleComparison();

            state._fsp--;

             
                    current = this_Comparison_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:255:1: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:255:2: () otherlv_2= '&&' ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:255:2: ()
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:256:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleAndExpression462); 

            	        	createLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1(), null);
            	        
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:275:1: ( (lv_right_3_0= ruleComparison ) )
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:276:1: (lv_right_3_0= ruleComparison )
            	    {
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:276:1: (lv_right_3_0= ruleComparison )
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:277:3: lv_right_3_0= ruleComparison
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getRightComparisonParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleComparison_in_ruleAndExpression483);
            	    lv_right_3_0=ruleComparison();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAndExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"right",
            	    	        		lv_right_3_0, 
            	    	        		"Comparison", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:307:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:308:2: (iv_ruleComparison= ruleComparison EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:309:2: iv_ruleComparison= ruleComparison EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComparisonRule(), currentNode); 
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison521);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison531); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:316:1: ruleComparison returns [EObject current=null] : (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )? ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        EObject this_PrefixExpression_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:321:6: ( (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )? ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:322:1: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )? )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:322:1: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )? )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:323:5: this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getComparisonAccess().getPrefixExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulePrefixExpression_in_ruleComparison578);
            this_PrefixExpression_0=rulePrefixExpression();

            state._fsp--;

             
                    current = this_PrefixExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:331:1: ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=18 && LA5_0<=20)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:331:2: () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:331:2: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:332:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:347:2: ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:348:1: ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:348:1: ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:349:1: (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:349:1: (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' )
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
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:350:3: lv_operator_2_1= '=='
                            {
                            lv_operator_2_1=(Token)match(input,18,FOLLOW_18_in_ruleComparison607); 

                                    createLeafNode(lv_operator_2_1, grammarAccess.getComparisonAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_0(), "operator");
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getComparisonRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "operator", lv_operator_2_1, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:368:8: lv_operator_2_2= '<='
                            {
                            lv_operator_2_2=(Token)match(input,19,FOLLOW_19_in_ruleComparison636); 

                                    createLeafNode(lv_operator_2_2, grammarAccess.getComparisonAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_1(), "operator");
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getComparisonRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "operator", lv_operator_2_2, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:386:8: lv_operator_2_3= '>='
                            {
                            lv_operator_2_3=(Token)match(input,20,FOLLOW_20_in_ruleComparison665); 

                                    createLeafNode(lv_operator_2_3, grammarAccess.getComparisonAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_2(), "operator");
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getComparisonRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "operator", lv_operator_2_3, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:407:2: ( (lv_right_3_0= rulePrefixExpression ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:408:1: (lv_right_3_0= rulePrefixExpression )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:408:1: (lv_right_3_0= rulePrefixExpression )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:409:3: lv_right_3_0= rulePrefixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComparisonAccess().getRightPrefixExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrefixExpression_in_ruleComparison702);
                    lv_right_3_0=rulePrefixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getComparisonRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"right",
                    	        		lv_right_3_0, 
                    	        		"PrefixExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:439:1: entryRulePrefixExpression returns [EObject current=null] : iv_rulePrefixExpression= rulePrefixExpression EOF ;
    public final EObject entryRulePrefixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpression = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:440:2: (iv_rulePrefixExpression= rulePrefixExpression EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:441:2: iv_rulePrefixExpression= rulePrefixExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrefixExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrefixExpression_in_entryRulePrefixExpression740);
            iv_rulePrefixExpression=rulePrefixExpression();

            state._fsp--;

             current =iv_rulePrefixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrefixExpression750); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:448:1: rulePrefixExpression returns [EObject current=null] : ( ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom ) ;
    public final EObject rulePrefixExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;

        EObject this_Atom_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:453:6: ( ( ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:454:1: ( ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:454:1: ( ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=RULE_INT && LA6_0<=RULE_ID)||LA6_0==13) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:454:2: ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:454:2: ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:454:3: () otherlv_1= '!' ( (lv_expression_2_0= ruleAtom ) )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:454:3: ()
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:455:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getPrefixExpressionAccess().getNotExpressionAction_0_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getPrefixExpressionAccess().getNotExpressionAction_0_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_rulePrefixExpression797); 

                        	createLeafNode(otherlv_1, grammarAccess.getPrefixExpressionAccess().getExclamationMarkKeyword_0_1(), null);
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:469:1: ( (lv_expression_2_0= ruleAtom ) )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:470:1: (lv_expression_2_0= ruleAtom )
                    {
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:470:1: (lv_expression_2_0= ruleAtom )
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:471:3: lv_expression_2_0= ruleAtom
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPrefixExpressionAccess().getExpressionAtomParserRuleCall_0_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAtom_in_rulePrefixExpression818);
                    lv_expression_2_0=ruleAtom();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPrefixExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"expression",
                    	        		lv_expression_2_0, 
                    	        		"Atom", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:495:5: this_Atom_3= ruleAtom
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrefixExpressionAccess().getAtomParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAtom_in_rulePrefixExpression847);
                    this_Atom_3=ruleAtom();

                    state._fsp--;

                     
                            current = this_Atom_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:511:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:512:2: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:513:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAtomRule(), currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom882);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom892); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:520:1: ruleAtom returns [EObject current=null] : (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        EObject this_ParenthesizedExpression_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_MethodCall_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:525:6: ( (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:526:1: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:526:1: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall )
            int alt7=3;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:527:5: this_ParenthesizedExpression_0= ruleParenthesizedExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAtomAccess().getParenthesizedExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleAtom939);
                    this_ParenthesizedExpression_0=ruleParenthesizedExpression();

                    state._fsp--;

                     
                            current = this_ParenthesizedExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:537:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAtomAccess().getNumberLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleAtom966);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:547:5: this_MethodCall_2= ruleMethodCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAtomAccess().getMethodCallParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMethodCall_in_ruleAtom993);
                    this_MethodCall_2=ruleMethodCall();

                    state._fsp--;

                     
                            current = this_MethodCall_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:563:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:564:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:565:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumberLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1028);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral1038); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:572:1: ruleNumberLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:577:6: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:578:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:578:1: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:579:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:579:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:580:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumberLiteral1079); 

            			createLeafNode(lv_value_0_0, grammarAccess.getNumberLiteralAccess().getValueINTTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNumberLiteralRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:610:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:611:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:612:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression1119);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression1129); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:619:1: ruleParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:624:6: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:625:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:625:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:625:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleParenthesizedExpression1166); 

                	createLeafNode(otherlv_0, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression1188);
            this_Expression_1=ruleExpression();

            state._fsp--;

             
                    current = this_Expression_1; 
                    currentNode = currentNode.getParent();
                
            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleParenthesizedExpression1199); 

                	createLeafNode(otherlv_2, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:650:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:651:2: (iv_ruleMethodCall= ruleMethodCall EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:652:2: iv_ruleMethodCall= ruleMethodCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMethodCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleMethodCall_in_entryRuleMethodCall1235);
            iv_ruleMethodCall=ruleMethodCall();

            state._fsp--;

             current =iv_ruleMethodCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodCall1245); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:659:1: ruleMethodCall returns [EObject current=null] : ( (lv_value_0_0= ruleMethodCallLiteral ) ) ;
    public final EObject ruleMethodCall() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:664:6: ( ( (lv_value_0_0= ruleMethodCallLiteral ) ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:665:1: ( (lv_value_0_0= ruleMethodCallLiteral ) )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:665:1: ( (lv_value_0_0= ruleMethodCallLiteral ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:666:1: (lv_value_0_0= ruleMethodCallLiteral )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:666:1: (lv_value_0_0= ruleMethodCallLiteral )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:667:3: lv_value_0_0= ruleMethodCallLiteral
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMethodCallAccess().getValueMethodCallLiteralParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMethodCallLiteral_in_ruleMethodCall1290);
            lv_value_0_0=ruleMethodCallLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMethodCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"MethodCallLiteral", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:697:1: entryRuleMethodCallLiteral returns [String current=null] : iv_ruleMethodCallLiteral= ruleMethodCallLiteral EOF ;
    public final String entryRuleMethodCallLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMethodCallLiteral = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:698:2: (iv_ruleMethodCallLiteral= ruleMethodCallLiteral EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:699:2: iv_ruleMethodCallLiteral= ruleMethodCallLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMethodCallLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleMethodCallLiteral_in_entryRuleMethodCallLiteral1326);
            iv_ruleMethodCallLiteral=ruleMethodCallLiteral();

            state._fsp--;

             current =iv_ruleMethodCallLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodCallLiteral1337); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:706:1: ruleMethodCallLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )? ) ;
    public final AntlrDatatypeRuleToken ruleMethodCallLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;

        AntlrDatatypeRuleToken this_Argument_2 = null;

        AntlrDatatypeRuleToken this_Argument_4 = null;

        AntlrDatatypeRuleToken this_MethodCallLiteral_7 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:711:6: ( (this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )? ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:712:1: (this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )? )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:712:1: (this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )? )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:713:5: this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getMethodCallLiteralAccess().getFQNParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleMethodCallLiteral1384);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:723:1: (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==13) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:724:2: kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )?
                    {
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleMethodCallLiteral1403); 

                            current.merge(kw);
                            createLeafNode(kw, grammarAccess.getMethodCallLiteralAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:729:1: (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=RULE_INT && LA9_0<=RULE_ID)) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:730:5: this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )*
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.getMethodCallLiteralAccess().getArgumentParserRuleCall_1_1_0(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleArgument_in_ruleMethodCallLiteral1426);
                            this_Argument_2=ruleArgument();

                            state._fsp--;


                            		current.merge(this_Argument_2);
                                
                             
                                    currentNode = currentNode.getParent();
                                
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:740:1: (kw= ',' this_Argument_4= ruleArgument )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==22) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:741:2: kw= ',' this_Argument_4= ruleArgument
                            	    {
                            	    kw=(Token)match(input,22,FOLLOW_22_in_ruleMethodCallLiteral1445); 

                            	            current.merge(kw);
                            	            createLeafNode(kw, grammarAccess.getMethodCallLiteralAccess().getCommaKeyword_1_1_1_0(), null); 
                            	        
                            	     
                            	            currentNode=createCompositeNode(grammarAccess.getMethodCallLiteralAccess().getArgumentParserRuleCall_1_1_1_1(), currentNode); 
                            	        
                            	    pushFollow(FOLLOW_ruleArgument_in_ruleMethodCallLiteral1467);
                            	    this_Argument_4=ruleArgument();

                            	    state._fsp--;


                            	    		current.merge(this_Argument_4);
                            	        
                            	     
                            	            currentNode = currentNode.getParent();
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            }
                            break;

                    }

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleMethodCallLiteral1489); 

                            current.merge(kw);
                            createLeafNode(kw, grammarAccess.getMethodCallLiteralAccess().getRightParenthesisKeyword_1_2(), null); 
                        
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:763:1: (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==23) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:764:2: kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral
                            {
                            kw=(Token)match(input,23,FOLLOW_23_in_ruleMethodCallLiteral1503); 

                                    current.merge(kw);
                                    createLeafNode(kw, grammarAccess.getMethodCallLiteralAccess().getFullStopKeyword_1_3_0(), null); 
                                
                             
                                    currentNode=createCompositeNode(grammarAccess.getMethodCallLiteralAccess().getMethodCallLiteralParserRuleCall_1_3_1(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleMethodCallLiteral_in_ruleMethodCallLiteral1525);
                            this_MethodCallLiteral_7=ruleMethodCallLiteral();

                            state._fsp--;


                            		current.merge(this_MethodCallLiteral_7);
                                
                             
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:788:1: entryRuleArgument returns [String current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final String entryRuleArgument() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArgument = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:789:2: (iv_ruleArgument= ruleArgument EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:790:2: iv_ruleArgument= ruleArgument EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArgumentRule(), currentNode); 
            pushFollow(FOLLOW_ruleArgument_in_entryRuleArgument1575);
            iv_ruleArgument=ruleArgument();

            state._fsp--;

             current =iv_ruleArgument.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgument1586); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:797:1: ruleArgument returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleArgument() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_MethodCallLiteral_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:802:6: ( (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:803:1: (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:803:1: (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_INT) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:804:5: this_MethodCallLiteral_0= ruleMethodCallLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getArgumentAccess().getMethodCallLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMethodCallLiteral_in_ruleArgument1633);
                    this_MethodCallLiteral_0=ruleMethodCallLiteral();

                    state._fsp--;


                    		current.merge(this_MethodCallLiteral_0);
                        
                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:815:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleArgument1659); 

                    		current.merge(this_INT_1);
                        
                     
                        createLeafNode(this_INT_1, grammarAccess.getArgumentAccess().getINTTerminalRuleCall_1(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:830:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:831:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:832:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1705);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1716); 

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
    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:839:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:844:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:845:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:845:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:845:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1756); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:852:1: (kw= '.' this_ID_2= RULE_ID )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==23) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator/src-gen/org/eclipse/xtext/generator/parser/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:853:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,23,FOLLOW_23_in_ruleFQN1775); 

            	            current.merge(kw);
            	            createLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1790); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
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


 

    public static final BitSet FOLLOW_ruleIfCondition_in_entryRuleIfCondition75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfCondition85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleIfCondition128 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleIfCondition154 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleIfCondition166 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfCondition187 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleIfCondition199 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleIfCondition211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleExpression304 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleExpression325 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleExpression346 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression384 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleAndExpression441 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleAndExpression462 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleAndExpression483 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison521 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixExpression_in_ruleComparison578 = new BitSet(new long[]{0x00000000001C0002L});
    public static final BitSet FOLLOW_18_in_ruleComparison607 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_19_in_ruleComparison636 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_20_in_ruleComparison665 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_rulePrefixExpression_in_ruleComparison702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixExpression_in_entryRulePrefixExpression740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrefixExpression750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rulePrefixExpression797 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_ruleAtom_in_rulePrefixExpression818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_rulePrefixExpression847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom882 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleAtom939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleAtom966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCall_in_ruleAtom993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumberLiteral1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression1119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleParenthesizedExpression1166 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression1188 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleParenthesizedExpression1199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCall_in_entryRuleMethodCall1235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodCall1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCallLiteral_in_ruleMethodCall1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCallLiteral_in_entryRuleMethodCallLiteral1326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodCallLiteral1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleMethodCallLiteral1384 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleMethodCallLiteral1403 = new BitSet(new long[]{0x0000000000206030L});
    public static final BitSet FOLLOW_ruleArgument_in_ruleMethodCallLiteral1426 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_22_in_ruleMethodCallLiteral1445 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_ruleArgument_in_ruleMethodCallLiteral1467 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_14_in_ruleMethodCallLiteral1489 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleMethodCallLiteral1503 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_ruleMethodCallLiteral_in_ruleMethodCallLiteral1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_entryRuleArgument1575 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgument1586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCallLiteral_in_ruleArgument1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleArgument1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1705 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1756 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleFQN1775 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1790 = new BitSet(new long[]{0x0000000000800002L});

}
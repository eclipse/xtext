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
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalSimpleExpressionsParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g"; }



     	private SimpleExpressionsGrammarAccess grammarAccess;
     	
        public InternalSimpleExpressionsParser(TokenStream input, IAstFactory factory, SimpleExpressionsGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "IfCondition";	
       	}
       	
       	@Override
       	protected SimpleExpressionsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleIfCondition
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:77:1: entryRuleIfCondition returns [EObject current=null] : iv_ruleIfCondition= ruleIfCondition EOF ;
    public final EObject entryRuleIfCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfCondition = null;


        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:78:2: (iv_ruleIfCondition= ruleIfCondition EOF )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:79:2: iv_ruleIfCondition= ruleIfCondition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIfConditionRule(), currentNode); 
            pushFollow(FOLLOW_ruleIfCondition_in_entryRuleIfCondition75);
            iv_ruleIfCondition=ruleIfCondition();
            _fsp--;

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
    // $ANTLR end entryRuleIfCondition


    // $ANTLR start ruleIfCondition
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:86:1: ruleIfCondition returns [EObject current=null] : ( ( (lv_elseif_0_0= 'else' ) )? 'if' '(' ( (lv_condition_3_0= ruleExpression ) ) ')' '{' ) ;
    public final EObject ruleIfCondition() throws RecognitionException {
        EObject current = null;

        Token lv_elseif_0_0=null;
        EObject lv_condition_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:91:6: ( ( ( (lv_elseif_0_0= 'else' ) )? 'if' '(' ( (lv_condition_3_0= ruleExpression ) ) ')' '{' ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:92:1: ( ( (lv_elseif_0_0= 'else' ) )? 'if' '(' ( (lv_condition_3_0= ruleExpression ) ) ')' '{' )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:92:1: ( ( (lv_elseif_0_0= 'else' ) )? 'if' '(' ( (lv_condition_3_0= ruleExpression ) ) ')' '{' )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:92:2: ( (lv_elseif_0_0= 'else' ) )? 'if' '(' ( (lv_condition_3_0= ruleExpression ) ) ')' '{'
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:92:2: ( (lv_elseif_0_0= 'else' ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:93:1: (lv_elseif_0_0= 'else' )
                    {
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:93:1: (lv_elseif_0_0= 'else' )
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:94:3: lv_elseif_0_0= 'else'
                    {
                    lv_elseif_0_0=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleIfCondition128); 

                            createLeafNode(grammarAccess.getIfConditionAccess().getElseifElseKeyword_0_0(), "elseif"); 
                        

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

            match(input,12,FOLLOW_12_in_ruleIfCondition152); 

                    createLeafNode(grammarAccess.getIfConditionAccess().getIfKeyword_1(), null); 
                
            match(input,13,FOLLOW_13_in_ruleIfCondition162); 

                    createLeafNode(grammarAccess.getIfConditionAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:121:1: ( (lv_condition_3_0= ruleExpression ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:122:1: (lv_condition_3_0= ruleExpression )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:122:1: (lv_condition_3_0= ruleExpression )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:123:3: lv_condition_3_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfConditionAccess().getConditionExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfCondition183);
            lv_condition_3_0=ruleExpression();
            _fsp--;


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

            match(input,14,FOLLOW_14_in_ruleIfCondition193); 

                    createLeafNode(grammarAccess.getIfConditionAccess().getRightParenthesisKeyword_4(), null); 
                
            match(input,15,FOLLOW_15_in_ruleIfCondition203); 

                    createLeafNode(grammarAccess.getIfConditionAccess().getLeftCurlyBracketKeyword_5(), null); 
                

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
    // $ANTLR end ruleIfCondition


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:161:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:162:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:163:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression239);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression249); 

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
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:170:1: ruleExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () '||' ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:175:6: ( (this_AndExpression_0= ruleAndExpression ( () '||' ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:176:1: (this_AndExpression_0= ruleAndExpression ( () '||' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:176:1: (this_AndExpression_0= ruleAndExpression ( () '||' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:177:5: this_AndExpression_0= ruleAndExpression ( () '||' ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getAndExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAndExpression_in_ruleExpression296);
            this_AndExpression_0=ruleAndExpression();
            _fsp--;

             
                    current = this_AndExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:185:1: ( () '||' ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:185:2: () '||' ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:185:2: ()
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:186:5: 
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

            	    match(input,16,FOLLOW_16_in_ruleExpression315); 

            	            createLeafNode(grammarAccess.getExpressionAccess().getVerticalLineVerticalLineKeyword_1_1(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:205:1: ( (lv_right_3_0= ruleAndExpression ) )
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:206:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:206:1: (lv_right_3_0= ruleAndExpression )
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:207:3: lv_right_3_0= ruleAndExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAndExpression_in_ruleExpression336);
            	    lv_right_3_0=ruleAndExpression();
            	    _fsp--;


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
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleAndExpression
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:237:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:238:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:239:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression374);
            iv_ruleAndExpression=ruleAndExpression();
            _fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression384); 

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
    // $ANTLR end entryRuleAndExpression


    // $ANTLR start ruleAndExpression
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:246:1: ruleAndExpression returns [EObject current=null] : (this_Comparison_0= ruleComparison ( () '&&' ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:251:6: ( (this_Comparison_0= ruleComparison ( () '&&' ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:252:1: (this_Comparison_0= ruleComparison ( () '&&' ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:252:1: (this_Comparison_0= ruleComparison ( () '&&' ( (lv_right_3_0= ruleComparison ) ) )* )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:253:5: this_Comparison_0= ruleComparison ( () '&&' ( (lv_right_3_0= ruleComparison ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getComparisonParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleComparison_in_ruleAndExpression431);
            this_Comparison_0=ruleComparison();
            _fsp--;

             
                    current = this_Comparison_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:261:1: ( () '&&' ( (lv_right_3_0= ruleComparison ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:261:2: () '&&' ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:261:2: ()
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:262:5: 
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

            	    match(input,17,FOLLOW_17_in_ruleAndExpression450); 

            	            createLeafNode(grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:281:1: ( (lv_right_3_0= ruleComparison ) )
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:282:1: (lv_right_3_0= ruleComparison )
            	    {
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:282:1: (lv_right_3_0= ruleComparison )
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:283:3: lv_right_3_0= ruleComparison
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getRightComparisonParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleComparison_in_ruleAndExpression471);
            	    lv_right_3_0=ruleComparison();
            	    _fsp--;


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
    // $ANTLR end ruleAndExpression


    // $ANTLR start entryRuleComparison
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:313:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:314:2: (iv_ruleComparison= ruleComparison EOF )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:315:2: iv_ruleComparison= ruleComparison EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComparisonRule(), currentNode); 
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison509);
            iv_ruleComparison=ruleComparison();
            _fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison519); 

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
    // $ANTLR end entryRuleComparison


    // $ANTLR start ruleComparison
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:322:1: ruleComparison returns [EObject current=null] : (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )? ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        EObject this_PrefixExpression_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:327:6: ( (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )? ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:328:1: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )? )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:328:1: (this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )? )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:329:5: this_PrefixExpression_0= rulePrefixExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getComparisonAccess().getPrefixExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulePrefixExpression_in_ruleComparison566);
            this_PrefixExpression_0=rulePrefixExpression();
            _fsp--;

             
                    current = this_PrefixExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:337:1: ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=18 && LA5_0<=20)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:337:2: () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) ) ( (lv_right_3_0= rulePrefixExpression ) )
                    {
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:337:2: ()
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:338:5: 
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

                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:353:2: ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) ) )
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:354:1: ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) )
                    {
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:354:1: ( (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' ) )
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:355:1: (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' )
                    {
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:355:1: (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' )
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
                            new NoViableAltException("355:1: (lv_operator_2_1= '==' | lv_operator_2_2= '<=' | lv_operator_2_3= '>=' )", 4, 0, input);

                        throw nvae;
                    }

                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:356:3: lv_operator_2_1= '=='
                            {
                            lv_operator_2_1=(Token)input.LT(1);
                            match(input,18,FOLLOW_18_in_ruleComparison595); 

                                    createLeafNode(grammarAccess.getComparisonAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_0(), "operator"); 
                                

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
                            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:374:8: lv_operator_2_2= '<='
                            {
                            lv_operator_2_2=(Token)input.LT(1);
                            match(input,19,FOLLOW_19_in_ruleComparison624); 

                                    createLeafNode(grammarAccess.getComparisonAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_1(), "operator"); 
                                

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
                            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:392:8: lv_operator_2_3= '>='
                            {
                            lv_operator_2_3=(Token)input.LT(1);
                            match(input,20,FOLLOW_20_in_ruleComparison653); 

                                    createLeafNode(grammarAccess.getComparisonAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_2(), "operator"); 
                                

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

                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:413:2: ( (lv_right_3_0= rulePrefixExpression ) )
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:414:1: (lv_right_3_0= rulePrefixExpression )
                    {
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:414:1: (lv_right_3_0= rulePrefixExpression )
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:415:3: lv_right_3_0= rulePrefixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComparisonAccess().getRightPrefixExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrefixExpression_in_ruleComparison690);
                    lv_right_3_0=rulePrefixExpression();
                    _fsp--;


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
    // $ANTLR end ruleComparison


    // $ANTLR start entryRulePrefixExpression
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:445:1: entryRulePrefixExpression returns [EObject current=null] : iv_rulePrefixExpression= rulePrefixExpression EOF ;
    public final EObject entryRulePrefixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpression = null;


        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:446:2: (iv_rulePrefixExpression= rulePrefixExpression EOF )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:447:2: iv_rulePrefixExpression= rulePrefixExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrefixExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrefixExpression_in_entryRulePrefixExpression728);
            iv_rulePrefixExpression=rulePrefixExpression();
            _fsp--;

             current =iv_rulePrefixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrefixExpression738); 

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
    // $ANTLR end entryRulePrefixExpression


    // $ANTLR start rulePrefixExpression
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:454:1: rulePrefixExpression returns [EObject current=null] : ( ( () '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom ) ;
    public final EObject rulePrefixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_2_0 = null;

        EObject this_Atom_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:459:6: ( ( ( () '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:460:1: ( ( () '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:460:1: ( ( () '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom )
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
                    new NoViableAltException("460:1: ( ( () '!' ( (lv_expression_2_0= ruleAtom ) ) ) | this_Atom_3= ruleAtom )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:460:2: ( () '!' ( (lv_expression_2_0= ruleAtom ) ) )
                    {
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:460:2: ( () '!' ( (lv_expression_2_0= ruleAtom ) ) )
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:460:3: () '!' ( (lv_expression_2_0= ruleAtom ) )
                    {
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:460:3: ()
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:461:5: 
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

                    match(input,21,FOLLOW_21_in_rulePrefixExpression783); 

                            createLeafNode(grammarAccess.getPrefixExpressionAccess().getExclamationMarkKeyword_0_1(), null); 
                        
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:475:1: ( (lv_expression_2_0= ruleAtom ) )
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:476:1: (lv_expression_2_0= ruleAtom )
                    {
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:476:1: (lv_expression_2_0= ruleAtom )
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:477:3: lv_expression_2_0= ruleAtom
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPrefixExpressionAccess().getExpressionAtomParserRuleCall_0_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAtom_in_rulePrefixExpression804);
                    lv_expression_2_0=ruleAtom();
                    _fsp--;


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
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:501:5: this_Atom_3= ruleAtom
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrefixExpressionAccess().getAtomParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAtom_in_rulePrefixExpression833);
                    this_Atom_3=ruleAtom();
                    _fsp--;

                     
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
    // $ANTLR end rulePrefixExpression


    // $ANTLR start entryRuleAtom
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:517:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:518:2: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:519:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAtomRule(), currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom868);
            iv_ruleAtom=ruleAtom();
            _fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom878); 

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
    // $ANTLR end entryRuleAtom


    // $ANTLR start ruleAtom
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:526:1: ruleAtom returns [EObject current=null] : (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        EObject this_ParenthesizedExpression_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_MethodCall_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:531:6: ( (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:532:1: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:532:1: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall )
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
                    new NoViableAltException("532:1: (this_ParenthesizedExpression_0= ruleParenthesizedExpression | this_NumberLiteral_1= ruleNumberLiteral | this_MethodCall_2= ruleMethodCall )", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:533:5: this_ParenthesizedExpression_0= ruleParenthesizedExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAtomAccess().getParenthesizedExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleAtom925);
                    this_ParenthesizedExpression_0=ruleParenthesizedExpression();
                    _fsp--;

                     
                            current = this_ParenthesizedExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:543:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAtomAccess().getNumberLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleAtom952);
                    this_NumberLiteral_1=ruleNumberLiteral();
                    _fsp--;

                     
                            current = this_NumberLiteral_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:553:5: this_MethodCall_2= ruleMethodCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAtomAccess().getMethodCallParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMethodCall_in_ruleAtom979);
                    this_MethodCall_2=ruleMethodCall();
                    _fsp--;

                     
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
    // $ANTLR end ruleAtom


    // $ANTLR start entryRuleNumberLiteral
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:569:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:570:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:571:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumberLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1014);
            iv_ruleNumberLiteral=ruleNumberLiteral();
            _fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral1024); 

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
    // $ANTLR end entryRuleNumberLiteral


    // $ANTLR start ruleNumberLiteral
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:578:1: ruleNumberLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:583:6: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:584:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:584:1: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:585:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:585:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:586:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumberLiteral1065); 

            			createLeafNode(grammarAccess.getNumberLiteralAccess().getValueINTTerminalRuleCall_0(), "value"); 
            		

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
    // $ANTLR end ruleNumberLiteral


    // $ANTLR start entryRuleParenthesizedExpression
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:616:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:617:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:618:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression1105);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();
            _fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression1115); 

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
    // $ANTLR end entryRuleParenthesizedExpression


    // $ANTLR start ruleParenthesizedExpression
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:625:1: ruleParenthesizedExpression returns [EObject current=null] : ( '(' this_Expression_1= ruleExpression ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Expression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:630:6: ( ( '(' this_Expression_1= ruleExpression ')' ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:631:1: ( '(' this_Expression_1= ruleExpression ')' )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:631:1: ( '(' this_Expression_1= ruleExpression ')' )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:631:3: '(' this_Expression_1= ruleExpression ')'
            {
            match(input,13,FOLLOW_13_in_ruleParenthesizedExpression1150); 

                    createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression1172);
            this_Expression_1=ruleExpression();
            _fsp--;

             
                    current = this_Expression_1; 
                    currentNode = currentNode.getParent();
                
            match(input,14,FOLLOW_14_in_ruleParenthesizedExpression1181); 

                    createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2(), null); 
                

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
    // $ANTLR end ruleParenthesizedExpression


    // $ANTLR start entryRuleMethodCall
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:656:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:657:2: (iv_ruleMethodCall= ruleMethodCall EOF )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:658:2: iv_ruleMethodCall= ruleMethodCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMethodCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleMethodCall_in_entryRuleMethodCall1217);
            iv_ruleMethodCall=ruleMethodCall();
            _fsp--;

             current =iv_ruleMethodCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodCall1227); 

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
    // $ANTLR end entryRuleMethodCall


    // $ANTLR start ruleMethodCall
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:665:1: ruleMethodCall returns [EObject current=null] : ( (lv_value_0_0= ruleMethodCallLiteral ) ) ;
    public final EObject ruleMethodCall() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:670:6: ( ( (lv_value_0_0= ruleMethodCallLiteral ) ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:671:1: ( (lv_value_0_0= ruleMethodCallLiteral ) )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:671:1: ( (lv_value_0_0= ruleMethodCallLiteral ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:672:1: (lv_value_0_0= ruleMethodCallLiteral )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:672:1: (lv_value_0_0= ruleMethodCallLiteral )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:673:3: lv_value_0_0= ruleMethodCallLiteral
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMethodCallAccess().getValueMethodCallLiteralParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMethodCallLiteral_in_ruleMethodCall1272);
            lv_value_0_0=ruleMethodCallLiteral();
            _fsp--;


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
    // $ANTLR end ruleMethodCall


    // $ANTLR start entryRuleMethodCallLiteral
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:703:1: entryRuleMethodCallLiteral returns [String current=null] : iv_ruleMethodCallLiteral= ruleMethodCallLiteral EOF ;
    public final String entryRuleMethodCallLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMethodCallLiteral = null;


        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:704:2: (iv_ruleMethodCallLiteral= ruleMethodCallLiteral EOF )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:705:2: iv_ruleMethodCallLiteral= ruleMethodCallLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMethodCallLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleMethodCallLiteral_in_entryRuleMethodCallLiteral1308);
            iv_ruleMethodCallLiteral=ruleMethodCallLiteral();
            _fsp--;

             current =iv_ruleMethodCallLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodCallLiteral1319); 

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
    // $ANTLR end entryRuleMethodCallLiteral


    // $ANTLR start ruleMethodCallLiteral
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:712:1: ruleMethodCallLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )? ) ;
    public final AntlrDatatypeRuleToken ruleMethodCallLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;

        AntlrDatatypeRuleToken this_Argument_2 = null;

        AntlrDatatypeRuleToken this_Argument_4 = null;

        AntlrDatatypeRuleToken this_MethodCallLiteral_7 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:717:6: ( (this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )? ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:718:1: (this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )? )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:718:1: (this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )? )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:719:5: this_FQN_0= ruleFQN (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getMethodCallLiteralAccess().getFQNParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleMethodCallLiteral1366);
            this_FQN_0=ruleFQN();
            _fsp--;


            		current.merge(this_FQN_0);
                
             
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:729:1: (kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )? )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==13) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:730:2: kw= '(' (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )? kw= ')' (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )?
                    {
                    kw=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleMethodCallLiteral1385); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getMethodCallLiteralAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:735:1: (this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=RULE_INT && LA9_0<=RULE_ID)) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:736:5: this_Argument_2= ruleArgument (kw= ',' this_Argument_4= ruleArgument )*
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.getMethodCallLiteralAccess().getArgumentParserRuleCall_1_1_0(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleArgument_in_ruleMethodCallLiteral1408);
                            this_Argument_2=ruleArgument();
                            _fsp--;


                            		current.merge(this_Argument_2);
                                
                             
                                    currentNode = currentNode.getParent();
                                
                            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:746:1: (kw= ',' this_Argument_4= ruleArgument )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==22) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:747:2: kw= ',' this_Argument_4= ruleArgument
                            	    {
                            	    kw=(Token)input.LT(1);
                            	    match(input,22,FOLLOW_22_in_ruleMethodCallLiteral1427); 

                            	            current.merge(kw);
                            	            createLeafNode(grammarAccess.getMethodCallLiteralAccess().getCommaKeyword_1_1_1_0(), null); 
                            	        
                            	     
                            	            currentNode=createCompositeNode(grammarAccess.getMethodCallLiteralAccess().getArgumentParserRuleCall_1_1_1_1(), currentNode); 
                            	        
                            	    pushFollow(FOLLOW_ruleArgument_in_ruleMethodCallLiteral1449);
                            	    this_Argument_4=ruleArgument();
                            	    _fsp--;


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

                    kw=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleMethodCallLiteral1471); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getMethodCallLiteralAccess().getRightParenthesisKeyword_1_2(), null); 
                        
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:769:1: (kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==23) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:770:2: kw= '.' this_MethodCallLiteral_7= ruleMethodCallLiteral
                            {
                            kw=(Token)input.LT(1);
                            match(input,23,FOLLOW_23_in_ruleMethodCallLiteral1485); 

                                    current.merge(kw);
                                    createLeafNode(grammarAccess.getMethodCallLiteralAccess().getFullStopKeyword_1_3_0(), null); 
                                
                             
                                    currentNode=createCompositeNode(grammarAccess.getMethodCallLiteralAccess().getMethodCallLiteralParserRuleCall_1_3_1(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleMethodCallLiteral_in_ruleMethodCallLiteral1507);
                            this_MethodCallLiteral_7=ruleMethodCallLiteral();
                            _fsp--;


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
    // $ANTLR end ruleMethodCallLiteral


    // $ANTLR start entryRuleArgument
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:794:1: entryRuleArgument returns [String current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final String entryRuleArgument() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArgument = null;


        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:795:2: (iv_ruleArgument= ruleArgument EOF )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:796:2: iv_ruleArgument= ruleArgument EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArgumentRule(), currentNode); 
            pushFollow(FOLLOW_ruleArgument_in_entryRuleArgument1557);
            iv_ruleArgument=ruleArgument();
            _fsp--;

             current =iv_ruleArgument.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgument1568); 

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
    // $ANTLR end entryRuleArgument


    // $ANTLR start ruleArgument
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:803:1: ruleArgument returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleArgument() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_MethodCallLiteral_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:808:6: ( (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:809:1: (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:809:1: (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT )
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
                    new NoViableAltException("809:1: (this_MethodCallLiteral_0= ruleMethodCallLiteral | this_INT_1= RULE_INT )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:810:5: this_MethodCallLiteral_0= ruleMethodCallLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getArgumentAccess().getMethodCallLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMethodCallLiteral_in_ruleArgument1615);
                    this_MethodCallLiteral_0=ruleMethodCallLiteral();
                    _fsp--;


                    		current.merge(this_MethodCallLiteral_0);
                        
                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:821:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleArgument1641); 

                    		current.merge(this_INT_1);
                        
                     
                        createLeafNode(grammarAccess.getArgumentAccess().getINTTerminalRuleCall_1(), null); 
                        

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
    // $ANTLR end ruleArgument


    // $ANTLR start entryRuleFQN
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:836:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:837:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:838:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1687);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1698); 

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
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:845:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:850:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:851:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:851:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:851:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1738); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:858:1: (kw= '.' this_ID_2= RULE_ID )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==23) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.parser.packrat.antlr/src-gen/de/itemis/xtext/antlr/splitting/parser/antlr/internal/InternalSimpleExpressions.g:859:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,23,FOLLOW_23_in_ruleFQN1757); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1772); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

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
    // $ANTLR end ruleFQN


 

    public static final BitSet FOLLOW_ruleIfCondition_in_entryRuleIfCondition75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfCondition85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleIfCondition128 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleIfCondition152 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleIfCondition162 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfCondition183 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleIfCondition193 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleIfCondition203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression239 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleExpression296 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleExpression315 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleExpression336 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleAndExpression431 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleAndExpression450 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleAndExpression471 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison509 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixExpression_in_ruleComparison566 = new BitSet(new long[]{0x00000000001C0002L});
    public static final BitSet FOLLOW_18_in_ruleComparison595 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_19_in_ruleComparison624 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_20_in_ruleComparison653 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_rulePrefixExpression_in_ruleComparison690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixExpression_in_entryRulePrefixExpression728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrefixExpression738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rulePrefixExpression783 = new BitSet(new long[]{0x0000000000002030L});
    public static final BitSet FOLLOW_ruleAtom_in_rulePrefixExpression804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_rulePrefixExpression833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleAtom925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleAtom952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCall_in_ruleAtom979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1014 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumberLiteral1065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression1105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleParenthesizedExpression1150 = new BitSet(new long[]{0x0000000000202030L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression1172 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleParenthesizedExpression1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCall_in_entryRuleMethodCall1217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodCall1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCallLiteral_in_ruleMethodCall1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCallLiteral_in_entryRuleMethodCallLiteral1308 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodCallLiteral1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleMethodCallLiteral1366 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleMethodCallLiteral1385 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_ruleArgument_in_ruleMethodCallLiteral1408 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_22_in_ruleMethodCallLiteral1427 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleArgument_in_ruleMethodCallLiteral1449 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_14_in_ruleMethodCallLiteral1471 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleMethodCallLiteral1485 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleMethodCallLiteral_in_ruleMethodCallLiteral1507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_entryRuleArgument1557 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgument1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCallLiteral_in_ruleArgument1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleArgument1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1738 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleFQN1757 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1772 = new BitSet(new long[]{0x0000000000800002L});

}
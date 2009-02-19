package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

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
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleExpressionsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'+'", "'-'", "'*'", "'/'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalSimpleExpressionsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g"; }


     
     	private SimpleExpressionsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSimpleExpressionsTestLanguageParser(TokenStream input, IAstFactory factory, SimpleExpressionsTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Sequence";	
       	} 



    // $ANTLR start entryRuleSequence
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:70:1: entryRuleSequence returns [EObject current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final EObject entryRuleSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequence = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:70:50: (iv_ruleSequence= ruleSequence EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:71:2: iv_ruleSequence= ruleSequence EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSequence().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSequence_in_entryRuleSequence72);
            iv_ruleSequence=ruleSequence();
            _fsp--;

             current =iv_ruleSequence; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequence82); 

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
    // $ANTLR end entryRuleSequence


    // $ANTLR start ruleSequence
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:78:1: ruleSequence returns [EObject current=null] : (this_Addition_0= ruleAddition ( () (lv_expressions_2= ruleAddition ) )* ) ;
    public final EObject ruleSequence() throws RecognitionException {
        EObject current = null;

        EObject this_Addition_0 = null;

        EObject lv_expressions_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:83:6: ( (this_Addition_0= ruleAddition ( () (lv_expressions_2= ruleAddition ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:84:1: (this_Addition_0= ruleAddition ( () (lv_expressions_2= ruleAddition ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:84:1: (this_Addition_0= ruleAddition ( () (lv_expressions_2= ruleAddition ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:85:5: this_Addition_0= ruleAddition ( () (lv_expressions_2= ruleAddition ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prSequence().ele0ParserRuleCallAddition(), currentNode); 
                
            pushFollow(FOLLOW_ruleAddition_in_ruleSequence129);
            this_Addition_0=ruleAddition();
            _fsp--;

             
                    current = this_Addition_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:93:1: ( () (lv_expressions_2= ruleAddition ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:93:2: () (lv_expressions_2= ruleAddition )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:93:2: ()
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:94:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.prSequence().ele10ActionSequenceexpressions().getTypeName().getType());
            	            try {
            	            	factory.add(temp, "expressions", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.prSequence().ele10ActionSequenceexpressions(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:109:2: (lv_expressions_2= ruleAddition )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:112:6: lv_expressions_2= ruleAddition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prSequence().ele110ParserRuleCallAddition(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAddition_in_ruleSequence172);
            	    lv_expressions_2=ruleAddition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prSequence().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "expressions", lv_expressions_2, "Addition", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end ruleSequence


    // $ANTLR start entryRuleAddition
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:139:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:139:50: (iv_ruleAddition= ruleAddition EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:140:2: iv_ruleAddition= ruleAddition EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAddition().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition213);
            iv_ruleAddition=ruleAddition();
            _fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition223); 

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
    // $ANTLR end entryRuleAddition


    // $ANTLR start ruleAddition
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:147:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( () (lv_operator_2= ( '+' | '-' ) ) ) (lv_values_3= ruleMultiplication ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2=null;
        EObject this_Multiplication_0 = null;

        EObject lv_values_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:152:6: ( (this_Multiplication_0= ruleMultiplication ( ( () (lv_operator_2= ( '+' | '-' ) ) ) (lv_values_3= ruleMultiplication ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:153:1: (this_Multiplication_0= ruleMultiplication ( ( () (lv_operator_2= ( '+' | '-' ) ) ) (lv_values_3= ruleMultiplication ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:153:1: (this_Multiplication_0= ruleMultiplication ( ( () (lv_operator_2= ( '+' | '-' ) ) ) (lv_values_3= ruleMultiplication ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:154:5: this_Multiplication_0= ruleMultiplication ( ( () (lv_operator_2= ( '+' | '-' ) ) ) (lv_values_3= ruleMultiplication ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prAddition().ele0ParserRuleCallMultiplication(), currentNode); 
                
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition270);
            this_Multiplication_0=ruleMultiplication();
            _fsp--;

             
                    current = this_Multiplication_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:162:1: ( ( () (lv_operator_2= ( '+' | '-' ) ) ) (lv_values_3= ruleMultiplication ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=11 && LA3_0<=12)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:162:2: ( () (lv_operator_2= ( '+' | '-' ) ) ) (lv_values_3= ruleMultiplication )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:162:2: ( () (lv_operator_2= ( '+' | '-' ) ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:162:3: () (lv_operator_2= ( '+' | '-' ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:162:3: ()
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:163:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.prAddition().ele100ActionOpvalues().getTypeName().getType());
            	            try {
            	            	factory.add(temp, "values", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.prAddition().ele100ActionOpvalues(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:178:2: (lv_operator_2= ( '+' | '-' ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:180:6: lv_operator_2= ( '+' | '-' )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:180:20: ( '+' | '-' )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==11) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==12) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("180:20: ( '+' | '-' )", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:180:21: '+'
            	            {
            	            match(input,11,FOLLOW_11_in_ruleAddition302); 

            	                    createLeafNode(grammarAccess.prAddition().ele10100KeywordPlusSign(), "operator"); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:186:6: '-'
            	            {
            	            match(input,12,FOLLOW_12_in_ruleAddition318); 

            	                    createLeafNode(grammarAccess.prAddition().ele10101KeywordHyphenMinus(), "operator"); 
            	                

            	            }
            	            break;

            	    }


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prAddition().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operator", /* lv_operator_2 */ input.LT(-1), null, lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:206:3: (lv_values_3= ruleMultiplication )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:209:6: lv_values_3= ruleMultiplication
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prAddition().ele110ParserRuleCallMultiplication(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition368);
            	    lv_values_3=ruleMultiplication();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prAddition().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "values", lv_values_3, "Multiplication", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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
    // $ANTLR end ruleAddition


    // $ANTLR start entryRuleMultiplication
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:236:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:236:56: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:237:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMultiplication().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication409);
            iv_ruleMultiplication=ruleMultiplication();
            _fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication419); 

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
    // $ANTLR end entryRuleMultiplication


    // $ANTLR start ruleMultiplication
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:244:1: ruleMultiplication returns [EObject current=null] : (this_Term_0= ruleTerm ( ( () (lv_operator_2= ( '*' | '/' ) ) ) (lv_values_3= ruleTerm ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2=null;
        EObject this_Term_0 = null;

        EObject lv_values_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:249:6: ( (this_Term_0= ruleTerm ( ( () (lv_operator_2= ( '*' | '/' ) ) ) (lv_values_3= ruleTerm ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:250:1: (this_Term_0= ruleTerm ( ( () (lv_operator_2= ( '*' | '/' ) ) ) (lv_values_3= ruleTerm ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:250:1: (this_Term_0= ruleTerm ( ( () (lv_operator_2= ( '*' | '/' ) ) ) (lv_values_3= ruleTerm ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:251:5: this_Term_0= ruleTerm ( ( () (lv_operator_2= ( '*' | '/' ) ) ) (lv_values_3= ruleTerm ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prMultiplication().ele0ParserRuleCallTerm(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerm_in_ruleMultiplication466);
            this_Term_0=ruleTerm();
            _fsp--;

             
                    current = this_Term_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:259:1: ( ( () (lv_operator_2= ( '*' | '/' ) ) ) (lv_values_3= ruleTerm ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=13 && LA5_0<=14)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:259:2: ( () (lv_operator_2= ( '*' | '/' ) ) ) (lv_values_3= ruleTerm )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:259:2: ( () (lv_operator_2= ( '*' | '/' ) ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:259:3: () (lv_operator_2= ( '*' | '/' ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:259:3: ()
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:260:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.prMultiplication().ele100ActionOpvalues().getTypeName().getType());
            	            try {
            	            	factory.add(temp, "values", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.prMultiplication().ele100ActionOpvalues(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:275:2: (lv_operator_2= ( '*' | '/' ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:277:6: lv_operator_2= ( '*' | '/' )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:277:20: ( '*' | '/' )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==13) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==14) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("277:20: ( '*' | '/' )", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:277:21: '*'
            	            {
            	            match(input,13,FOLLOW_13_in_ruleMultiplication498); 

            	                    createLeafNode(grammarAccess.prMultiplication().ele10100KeywordAsterisk(), "operator"); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:283:6: '/'
            	            {
            	            match(input,14,FOLLOW_14_in_ruleMultiplication514); 

            	                    createLeafNode(grammarAccess.prMultiplication().ele10101KeywordSolidus(), "operator"); 
            	                

            	            }
            	            break;

            	    }


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prMultiplication().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "operator", /* lv_operator_2 */ input.LT(-1), null, lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:303:3: (lv_values_3= ruleTerm )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:306:6: lv_values_3= ruleTerm
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prMultiplication().ele110ParserRuleCallTerm(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerm_in_ruleMultiplication564);
            	    lv_values_3=ruleTerm();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prMultiplication().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "values", lv_values_3, "Term", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end ruleMultiplication


    // $ANTLR start entryRuleTerm
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:333:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:333:46: (iv_ruleTerm= ruleTerm EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:334:2: iv_ruleTerm= ruleTerm EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerm().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm605);
            iv_ruleTerm=ruleTerm();
            _fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm615); 

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
    // $ANTLR end entryRuleTerm


    // $ANTLR start ruleTerm
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:341:1: ruleTerm returns [EObject current=null] : (this_Atom_0= ruleAtom | this_Parens_1= ruleParens ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom_0 = null;

        EObject this_Parens_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:346:6: ( (this_Atom_0= ruleAtom | this_Parens_1= ruleParens ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:347:1: (this_Atom_0= ruleAtom | this_Parens_1= ruleParens )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:347:1: (this_Atom_0= ruleAtom | this_Parens_1= ruleParens )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==15) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("347:1: (this_Atom_0= ruleAtom | this_Parens_1= ruleParens )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:348:5: this_Atom_0= ruleAtom
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerm().ele0ParserRuleCallAtom(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm662);
                    this_Atom_0=ruleAtom();
                    _fsp--;

                     
                            current = this_Atom_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:358:5: this_Parens_1= ruleParens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerm().ele1ParserRuleCallParens(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParens_in_ruleTerm689);
                    this_Parens_1=ruleParens();
                    _fsp--;

                     
                            current = this_Parens_1; 
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
    // $ANTLR end ruleTerm


    // $ANTLR start entryRuleAtom
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:375:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:375:46: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:376:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAtom().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom723);
            iv_ruleAtom=ruleAtom();
            _fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom733); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:383:1: ruleAtom returns [EObject current=null] : (lv_name_0= RULE_ID ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:388:6: ( (lv_name_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:389:1: (lv_name_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:389:1: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:391:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom779); 

            		createLeafNode(grammarAccess.prAtom().ele0LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAtom().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleAtom


    // $ANTLR start entryRuleParens
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:418:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:418:48: (iv_ruleParens= ruleParens EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:419:2: iv_ruleParens= ruleParens EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParens().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParens_in_entryRuleParens821);
            iv_ruleParens=ruleParens();
            _fsp--;

             current =iv_ruleParens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParens831); 

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
    // $ANTLR end entryRuleParens


    // $ANTLR start ruleParens
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:426:1: ruleParens returns [EObject current=null] : ( ( '(' this_Addition_1= ruleAddition ) ')' ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        EObject this_Addition_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:431:6: ( ( ( '(' this_Addition_1= ruleAddition ) ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:432:1: ( ( '(' this_Addition_1= ruleAddition ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:432:1: ( ( '(' this_Addition_1= ruleAddition ) ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:432:2: ( '(' this_Addition_1= ruleAddition ) ')'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:432:2: ( '(' this_Addition_1= ruleAddition )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:432:3: '(' this_Addition_1= ruleAddition
            {
            match(input,15,FOLLOW_15_in_ruleParens866); 

                    createLeafNode(grammarAccess.prParens().ele00KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParens().ele01ParserRuleCallAddition(), currentNode); 
                
            pushFollow(FOLLOW_ruleAddition_in_ruleParens888);
            this_Addition_1=ruleAddition();
            _fsp--;

             
                    current = this_Addition_1; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,16,FOLLOW_16_in_ruleParens897); 

                    createLeafNode(grammarAccess.prParens().ele1KeywordRightParenthesis(), null); 
                

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
    // $ANTLR end ruleParens


 

    public static final BitSet FOLLOW_ruleSequence_in_entryRuleSequence72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequence82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleSequence129 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleSequence172 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition213 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition270 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_11_in_ruleAddition302 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_12_in_ruleAddition318 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition368 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication409 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleMultiplication466 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_13_in_ruleMultiplication498 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_14_in_ruleMultiplication514 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleMultiplication564 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_entryRuleParens821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParens831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParens866 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleParens888 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParens897 = new BitSet(new long[]{0x0000000000000002L});

}
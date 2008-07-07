// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g 2008-07-07 14:43:12

package org.eclipse.xtext.testlanguages.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleExpressionsParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'+'", "'-'", "'*'", "'/'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=10;

        public InternalSimpleExpressionsParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g"; }


     
        public InternalSimpleExpressionsParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalSimpleExpressionsParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Sequence";	
       	} 



    // $ANTLR start entryRuleSequence
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:63:1: entryRuleSequence returns [EObject current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final EObject entryRuleSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequence = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:63:50: (iv_ruleSequence= ruleSequence EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:64:2: iv_ruleSequence= ruleSequence EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSequence_in_entryRuleSequence71);
            iv_ruleSequence=ruleSequence();
            _fsp--;

             current =iv_ruleSequence; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequence81); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:71:1: ruleSequence returns [EObject current=null] : (this_Addition= ruleAddition ( () (lv_expressions= ruleAddition ) )* ) ;
    public final EObject ruleSequence() throws RecognitionException {
        EObject current = null;

        EObject this_Addition = null;

        EObject lv_expressions = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:73:33: ( (this_Addition= ruleAddition ( () (lv_expressions= ruleAddition ) )* ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:74:1: (this_Addition= ruleAddition ( () (lv_expressions= ruleAddition ) )* )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:74:1: (this_Addition= ruleAddition ( () (lv_expressions= ruleAddition ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:75:5: this_Addition= ruleAddition ( () (lv_expressions= ruleAddition ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.0/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAddition_in_ruleSequence128);
            this_Addition=ruleAddition();
            _fsp--;

             
                    current = this_Addition; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:83:1: ( () (lv_expressions= ruleAddition ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:83:2: () (lv_expressions= ruleAddition )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:83:2: ()
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:84:5: 
            	    {
            	     
            	            temp=factory.create("Sequence");
            	            factory.add(temp, "expressions",current);
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:95:2: (lv_expressions= ruleAddition )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:97:5: lv_expressions= ruleAddition
            	    {
            	     
            	            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleAddition_in_ruleSequence165);
            	    lv_expressions=ruleAddition();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Sequence");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.add(current, "expressions", lv_expressions,null);
            	            
            	             

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:116:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:116:50: (iv_ruleAddition= ruleAddition EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:117:2: iv_ruleAddition= ruleAddition EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition203);
            iv_ruleAddition=ruleAddition();
            _fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition213); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:124:1: ruleAddition returns [EObject current=null] : (this_Multiplication= ruleMultiplication ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token lv_operator=null;
        EObject this_Multiplication = null;

        EObject lv_values = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:126:33: ( (this_Multiplication= ruleMultiplication ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication ) )* ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:127:1: (this_Multiplication= ruleMultiplication ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication ) )* )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:127:1: (this_Multiplication= ruleMultiplication ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:128:5: this_Multiplication= ruleMultiplication ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.1/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition260);
            this_Multiplication=ruleMultiplication();
            _fsp--;

             
                    current = this_Multiplication; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:136:1: ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=12 && LA3_0<=13)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:136:2: ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:136:2: ( () (lv_operator= ( '+' | '-' ) ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:136:3: () (lv_operator= ( '+' | '-' ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:136:3: ()
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:137:5: 
            	    {
            	     
            	            temp=factory.create("Op");
            	            factory.add(temp, "values",current);
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:148:2: (lv_operator= ( '+' | '-' ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:149:5: lv_operator= ( '+' | '-' )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:149:17: ( '+' | '-' )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==12) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==13) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("149:17: ( '+' | '-' )", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:149:18: '+'
            	            {
            	            match(input,12,FOLLOW_12_in_ruleAddition288); 

            	                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0" /* xtext::Keyword */, "operator"); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:154:6: '-'
            	            {
            	            match(input,13,FOLLOW_13_in_ruleAddition303); 

            	                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
            	                

            	            }
            	            break;

            	    }


            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.set(current, "operator", input.LT(-1),null);
            	            
            	             

            	    }


            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:168:3: (lv_values= ruleMultiplication )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:170:5: lv_values= ruleMultiplication
            	    {
            	     
            	            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition342);
            	    lv_values=ruleMultiplication();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.add(current, "values", lv_values,null);
            	            
            	             

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:189:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:189:56: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:190:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication380);
            iv_ruleMultiplication=ruleMultiplication();
            _fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication390); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:197:1: ruleMultiplication returns [EObject current=null] : (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operator=null;
        EObject this_Term = null;

        EObject lv_values = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:199:33: ( (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:200:1: (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:200:1: (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:201:5: this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.2/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerm_in_ruleMultiplication437);
            this_Term=ruleTerm();
            _fsp--;

             
                    current = this_Term; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:209:1: ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=14 && LA5_0<=15)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:209:2: ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:209:2: ( () (lv_operator= ( '*' | '/' ) ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:209:3: () (lv_operator= ( '*' | '/' ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:209:3: ()
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:210:5: 
            	    {
            	     
            	            temp=factory.create("Op");
            	            factory.add(temp, "values",current);
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:221:2: (lv_operator= ( '*' | '/' ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:222:5: lv_operator= ( '*' | '/' )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:222:17: ( '*' | '/' )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==14) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==15) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("222:17: ( '*' | '/' )", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:222:18: '*'
            	            {
            	            match(input,14,FOLLOW_14_in_ruleMultiplication465); 

            	                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0" /* xtext::Keyword */, "operator"); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:227:6: '/'
            	            {
            	            match(input,15,FOLLOW_15_in_ruleMultiplication480); 

            	                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
            	                

            	            }
            	            break;

            	    }


            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.set(current, "operator", input.LT(-1),null);
            	            
            	             

            	    }


            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:241:3: (lv_values= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:243:5: lv_values= ruleTerm
            	    {
            	     
            	            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.2/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleTerm_in_ruleMultiplication519);
            	    lv_values=ruleTerm();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.add(current, "values", lv_values,null);
            	            
            	             

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:262:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:262:46: (iv_ruleTerm= ruleTerm EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:263:2: iv_ruleTerm= ruleTerm EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm557);
            iv_ruleTerm=ruleTerm();
            _fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm567); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:270:1: ruleTerm returns [EObject current=null] : (this_Atom= ruleAtom | this_Parens= ruleParens ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom = null;

        EObject this_Parens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:272:33: ( (this_Atom= ruleAtom | this_Parens= ruleParens ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:273:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:273:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==16) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("273:1: (this_Atom= ruleAtom | this_Parens= ruleParens )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:274:5: this_Atom= ruleAtom
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.3/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm614);
                    this_Atom=ruleAtom();
                    _fsp--;

                     
                            current = this_Atom; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:284:5: this_Parens= ruleParens
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.3/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleParens_in_ruleTerm641);
                    this_Parens=ruleParens();
                    _fsp--;

                     
                            current = this_Parens; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:297:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:297:46: (iv_ruleAtom= ruleAtom EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:298:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom675);
            iv_ruleAtom=ruleAtom();
            _fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom685); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:305:1: ruleAtom returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:307:33: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:308:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:308:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:309:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom726); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.4/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
                

                    if (current==null) {
                        current = factory.create("Atom");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.set(current, "name", lv_name,"ID");
                    
                     

            }


            }

             resetLookahead(); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:328:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:328:48: (iv_ruleParens= ruleParens EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:329:2: iv_ruleParens= ruleParens EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParens_in_entryRuleParens768);
            iv_ruleParens=ruleParens();
            _fsp--;

             current =iv_ruleParens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParens778); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:336:1: ruleParens returns [EObject current=null] : ( ( '(' this_Addition= ruleAddition ) ')' ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        EObject this_Addition = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:338:33: ( ( ( '(' this_Addition= ruleAddition ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:339:1: ( ( '(' this_Addition= ruleAddition ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:339:1: ( ( '(' this_Addition= ruleAddition ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:339:2: ( '(' this_Addition= ruleAddition ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:339:2: ( '(' this_Addition= ruleAddition )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalSimpleExpressions.g:339:3: '(' this_Addition= ruleAddition
            {
            match(input,16,FOLLOW_16_in_ruleParens813); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAddition_in_ruleParens835);
            this_Addition=ruleAddition();
            _fsp--;

             
                    current = this_Addition; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,17,FOLLOW_17_in_ruleParens844); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }


            }

             resetLookahead(); 
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


 

    public static final BitSet FOLLOW_ruleSequence_in_entryRuleSequence71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequence81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleSequence128 = new BitSet(new long[]{0x0000000000010012L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleSequence165 = new BitSet(new long[]{0x0000000000010012L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition260 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_12_in_ruleAddition288 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_13_in_ruleAddition303 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition342 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleMultiplication437 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_14_in_ruleMultiplication465 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_15_in_ruleMultiplication480 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleMultiplication519 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm557 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom675 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_entryRuleParens768 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParens778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleParens813 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleParens835 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParens844 = new BitSet(new long[]{0x0000000000000002L});

}
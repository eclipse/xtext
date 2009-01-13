// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g 2009-01-13 09:48:29

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
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g"; }


     
        public InternalSimpleExpressionsTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalSimpleExpressionsTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Sequence";	
       	} 



    // $ANTLR start entryRuleSequence
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:66:1: entryRuleSequence returns [EObject current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final EObject entryRuleSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequence = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:66:50: (iv_ruleSequence= ruleSequence EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:67:2: iv_ruleSequence= ruleSequence EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:74:1: ruleSequence returns [EObject current=null] : (this_Addition= ruleAddition ( () (lv_expressions= ruleAddition ) )* ) ;
    public final EObject ruleSequence() throws RecognitionException {
        EObject current = null;

        EObject this_Addition = null;

        EObject lv_expressions = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:76:33: ( (this_Addition= ruleAddition ( () (lv_expressions= ruleAddition ) )* ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:77:1: (this_Addition= ruleAddition ( () (lv_expressions= ruleAddition ) )* )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:77:1: (this_Addition= ruleAddition ( () (lv_expressions= ruleAddition ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:78:5: this_Addition= ruleAddition ( () (lv_expressions= ruleAddition ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAddition_in_ruleSequence128);
            this_Addition=ruleAddition();
            _fsp--;

             
                    current = this_Addition; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:86:1: ( () (lv_expressions= ruleAddition ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:86:2: () (lv_expressions= ruleAddition )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:86:2: ()
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:87:5: 
            	    {
            	     
            	            temp=factory.create("Sequence");
            	            try {
            	            	factory.add(temp, "expressions", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:102:2: (lv_expressions= ruleAddition )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:105:6: lv_expressions= ruleAddition
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAddition_in_ruleSequence171);
            	    lv_expressions=ruleAddition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Sequence");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "expressions", lv_expressions, "Addition", currentNode);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:130:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:130:50: (iv_ruleAddition= ruleAddition EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:131:2: iv_ruleAddition= ruleAddition EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition210);
            iv_ruleAddition=ruleAddition();
            _fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition220); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:138:1: ruleAddition returns [EObject current=null] : (this_Multiplication= ruleMultiplication ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token lv_operator=null;
        EObject this_Multiplication = null;

        EObject lv_values = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:140:33: ( (this_Multiplication= ruleMultiplication ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication ) )* ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:141:1: (this_Multiplication= ruleMultiplication ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication ) )* )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:141:1: (this_Multiplication= ruleMultiplication ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:142:5: this_Multiplication= ruleMultiplication ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition267);
            this_Multiplication=ruleMultiplication();
            _fsp--;

             
                    current = this_Multiplication; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:150:1: ( ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=11 && LA3_0<=12)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:150:2: ( () (lv_operator= ( '+' | '-' ) ) ) (lv_values= ruleMultiplication )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:150:2: ( () (lv_operator= ( '+' | '-' ) ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:150:3: () (lv_operator= ( '+' | '-' ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:150:3: ()
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:151:5: 
            	    {
            	     
            	            temp=factory.create("Op");
            	            try {
            	            	factory.add(temp, "values", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:166:2: (lv_operator= ( '+' | '-' ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:168:6: lv_operator= ( '+' | '-' )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:168:18: ( '+' | '-' )
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
            	            new NoViableAltException("168:18: ( '+' | '-' )", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:168:19: '+'
            	            {
            	            match(input,11,FOLLOW_11_in_ruleAddition299); 

            	                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0" /* xtext::Keyword */, "operator"); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:173:6: '-'
            	            {
            	            match(input,12,FOLLOW_12_in_ruleAddition314); 

            	                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
            	                

            	            }
            	            break;

            	    }


            	    	        if (current==null) {
            	    	            current = factory.create("Expression");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.set(current, "operator", input.LT(-1), null, currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:191:3: (lv_values= ruleMultiplication )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:194:6: lv_values= ruleMultiplication
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition362);
            	    lv_values=ruleMultiplication();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Expression");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "values", lv_values, "Multiplication", currentNode);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:219:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:219:56: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:220:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication401);
            iv_ruleMultiplication=ruleMultiplication();
            _fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication411); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:227:1: ruleMultiplication returns [EObject current=null] : (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operator=null;
        EObject this_Term = null;

        EObject lv_values = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:229:33: ( (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:230:1: (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:230:1: (this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:231:5: this_Term= ruleTerm ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerm_in_ruleMultiplication458);
            this_Term=ruleTerm();
            _fsp--;

             
                    current = this_Term; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:239:1: ( ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=13 && LA5_0<=14)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:239:2: ( () (lv_operator= ( '*' | '/' ) ) ) (lv_values= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:239:2: ( () (lv_operator= ( '*' | '/' ) ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:239:3: () (lv_operator= ( '*' | '/' ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:239:3: ()
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:240:5: 
            	    {
            	     
            	            temp=factory.create("Op");
            	            try {
            	            	factory.add(temp, "values", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:255:2: (lv_operator= ( '*' | '/' ) )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:257:6: lv_operator= ( '*' | '/' )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:257:18: ( '*' | '/' )
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
            	            new NoViableAltException("257:18: ( '*' | '/' )", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:257:19: '*'
            	            {
            	            match(input,13,FOLLOW_13_in_ruleMultiplication490); 

            	                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0" /* xtext::Keyword */, "operator"); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:262:6: '/'
            	            {
            	            match(input,14,FOLLOW_14_in_ruleMultiplication505); 

            	                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
            	                

            	            }
            	            break;

            	    }


            	    	        if (current==null) {
            	    	            current = factory.create("Expression");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.set(current, "operator", input.LT(-1), null, currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:280:3: (lv_values= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:283:6: lv_values= ruleTerm
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerm_in_ruleMultiplication553);
            	    lv_values=ruleTerm();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Expression");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "values", lv_values, "Term", currentNode);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:308:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:308:46: (iv_ruleTerm= ruleTerm EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:309:2: iv_ruleTerm= ruleTerm EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm592);
            iv_ruleTerm=ruleTerm();
            _fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm602); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:316:1: ruleTerm returns [EObject current=null] : (this_Atom= ruleAtom | this_Parens= ruleParens ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom = null;

        EObject this_Parens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:318:33: ( (this_Atom= ruleAtom | this_Parens= ruleParens ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:319:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:319:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
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
                    new NoViableAltException("319:1: (this_Atom= ruleAtom | this_Parens= ruleParens )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:320:5: this_Atom= ruleAtom
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.3/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm649);
                    this_Atom=ruleAtom();
                    _fsp--;

                     
                            current = this_Atom; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:330:5: this_Parens= ruleParens
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.3/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleParens_in_ruleTerm676);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:345:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:345:46: (iv_ruleAtom= ruleAtom EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:346:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom708);
            iv_ruleAtom=ruleAtom();
            _fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom718); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:353:1: ruleAtom returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:355:33: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:356:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:356:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:358:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom763); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.4/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Atom");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:383:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:383:48: (iv_ruleParens= ruleParens EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:384:2: iv_ruleParens= ruleParens EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParens_in_entryRuleParens806);
            iv_ruleParens=ruleParens();
            _fsp--;

             current =iv_ruleParens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParens816); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:391:1: ruleParens returns [EObject current=null] : ( ( '(' this_Addition= ruleAddition ) ')' ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        EObject this_Addition = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:393:33: ( ( ( '(' this_Addition= ruleAddition ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:394:1: ( ( '(' this_Addition= ruleAddition ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:394:1: ( ( '(' this_Addition= ruleAddition ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:394:2: ( '(' this_Addition= ruleAddition ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:394:2: ( '(' this_Addition= ruleAddition )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalSimpleExpressionsTestLanguage.g:394:3: '(' this_Addition= ruleAddition
            {
            match(input,15,FOLLOW_15_in_ruleParens851); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAddition_in_ruleParens873);
            this_Addition=ruleAddition();
            _fsp--;

             
                    current = this_Addition; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,16,FOLLOW_16_in_ruleParens882); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    public static final BitSet FOLLOW_ruleAddition_in_ruleSequence128 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleSequence171 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition267 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_11_in_ruleAddition299 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_12_in_ruleAddition314 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition362 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleMultiplication458 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_13_in_ruleMultiplication490 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_14_in_ruleMultiplication505 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleMultiplication553 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm592 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom708 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_entryRuleParens806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParens816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParens851 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleParens873 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParens882 = new BitSet(new long[]{0x0000000000000002L});

}
// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g 2009-01-04 17:07:22

package org.eclipse.xtext.grammarinheritance.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.DatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalConcreteTestLanguageParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_REAL", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "':'", "'element'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=7;
    public static final int RULE_REAL=4;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;

        public InternalConcreteTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g"; }


     
        public InternalConcreteTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalConcreteTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ConcreteParserRule";	
       	} 



    // $ANTLR start entryRuleConcreteParserRule
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:66:1: entryRuleConcreteParserRule returns [EObject current=null] : iv_ruleConcreteParserRule= ruleConcreteParserRule EOF ;
    public final EObject entryRuleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:66:60: (iv_ruleConcreteParserRule= ruleConcreteParserRule EOF )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:67:2: iv_ruleConcreteParserRule= ruleConcreteParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule71);
            iv_ruleConcreteParserRule=ruleConcreteParserRule();
            _fsp--;

             current =iv_ruleConcreteParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteParserRule81); 

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
    // $ANTLR end entryRuleConcreteParserRule


    // $ANTLR start ruleConcreteParserRule
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:74:1: ruleConcreteParserRule returns [EObject current=null] : ( ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )* ) ;
    public final EObject ruleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_magicNumber=null;
        EObject lv_elements = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:76:33: ( ( ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )* ) )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:77:1: ( ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )* )
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:77:1: ( ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )* )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:77:2: ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )*
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:77:2: ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:77:3: ( 'model' (lv_magicNumber= RULE_REAL ) ) ':'
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:77:3: ( 'model' (lv_magicNumber= RULE_REAL ) )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:77:4: 'model' (lv_magicNumber= RULE_REAL )
            {
            match(input,12,FOLLOW_12_in_ruleConcreteParserRule117); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:81:1: (lv_magicNumber= RULE_REAL )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:83:6: lv_magicNumber= RULE_REAL
            {
            lv_magicNumber=(Token)input.LT(1);
            match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleConcreteParserRule138); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "magicNumber"); 
                

            	        if (current==null) {
            	            current = factory.create("ConcreteParserRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "magicNumber", lv_magicNumber, "REAL", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleConcreteParserRule159); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:105:2: (lv_elements= ruleInheritedParserRule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:108:6: lv_elements= ruleInheritedParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule194);
            	    lv_elements=ruleInheritedParserRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("ConcreteParserRule");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "elements", lv_elements, "InheritedParserRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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
    // $ANTLR end ruleConcreteParserRule


    // $ANTLR start entryRuleInheritedParserRule
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:133:1: entryRuleInheritedParserRule returns [EObject current=null] : iv_ruleInheritedParserRule= ruleInheritedParserRule EOF ;
    public final EObject entryRuleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritedParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:133:61: (iv_ruleInheritedParserRule= ruleInheritedParserRule EOF )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:134:2: iv_ruleInheritedParserRule= ruleInheritedParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule232);
            iv_ruleInheritedParserRule=ruleInheritedParserRule();
            _fsp--;

             current =iv_ruleInheritedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInheritedParserRule242); 

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
    // $ANTLR end entryRuleInheritedParserRule


    // $ANTLR start ruleInheritedParserRule
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:141:1: ruleInheritedParserRule returns [EObject current=null] : ( 'element' (lv_name= RULE_ID ) ) ;
    public final EObject ruleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:143:33: ( ( 'element' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:144:1: ( 'element' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:144:1: ( 'element' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:144:2: 'element' (lv_name= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleInheritedParserRule276); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:148:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/internal/InternalConcreteTestLanguage.g:150:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInheritedParserRule297); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("AType");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end ruleInheritedParserRule


 

    public static final BitSet FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteParserRule81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleConcreteParserRule117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleConcreteParserRule138 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleConcreteParserRule159 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule194 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritedParserRule242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleInheritedParserRule276 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInheritedParserRule297 = new BitSet(new long[]{0x0000000000000002L});

}
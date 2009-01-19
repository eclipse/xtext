// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g 2009-01-19 15:13:57

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

public class InternalLexerTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalLexerTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g"; }


     
        public InternalLexerTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalLexerTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:67:47: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:68:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LexerTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel72);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel82); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:75:1: ruleModel returns [EObject current=null] : (lv_children= ruleElement )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:77:33: ( (lv_children= ruleElement )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:78:1: (lv_children= ruleElement )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:78:1: (lv_children= ruleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:81:6: lv_children= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LexerTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleModel140);
            	    lv_children=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Model");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "children", lv_children, "Element", currentNode);
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleElement
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:108:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:108:49: (iv_ruleElement= ruleElement EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:109:2: iv_ruleElement= ruleElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/LexerTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement179);
            iv_ruleElement=ruleElement();
            _fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement189); 

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
    // $ANTLR end entryRuleElement


    // $ANTLR start ruleElement
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:116:1: ruleElement returns [EObject current=null] : ( (lv_name= RULE_ID ) (lv_h= RULE_STRING ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_h=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:118:33: ( ( (lv_name= RULE_ID ) (lv_h= RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:119:1: ( (lv_name= RULE_ID ) (lv_h= RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:119:1: ( (lv_name= RULE_ID ) (lv_h= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:119:2: (lv_name= RULE_ID ) (lv_h= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:119:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:121:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElement235); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LexerTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Element");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:139:2: (lv_h= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalLexerTestLanguage.g:141:6: lv_h= RULE_STRING
            {
            lv_h=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElement267); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/LexerTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "h"); 
                

            	        if (current==null) {
            	            current = factory.create("Element");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "h", lv_h, "STRING", currentNode);
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
    // $ANTLR end ruleElement


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_ruleModel140 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElement235 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElement267 = new BitSet(new long[]{0x0000000000000002L});

}
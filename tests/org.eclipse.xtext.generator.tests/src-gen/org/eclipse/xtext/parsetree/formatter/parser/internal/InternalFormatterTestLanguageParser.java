// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g 2008-12-10 21:58:24

package org.eclipse.xtext.parsetree.formatter.parser.internal; 

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

public class InternalFormatterTestLanguageParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "';'", "'linewrap'", "'indentation'", "'{'", "'}'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalFormatterTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g"; }


     
        public InternalFormatterTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalFormatterTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	} 



    // $ANTLR start entryRuleRoot
    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:62:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:62:46: (iv_ruleRoot= ruleRoot EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:63:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRoot_in_entryRuleRoot70);
            iv_ruleRoot=ruleRoot();
            _fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoot80); 

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
    // $ANTLR end entryRuleRoot


    // $ANTLR start ruleRoot
    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:70:1: ruleRoot returns [EObject current=null] : ( 'test' (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject this_TestLinewrap = null;

        EObject this_TestIndentation = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:72:33: ( ( 'test' (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:73:1: ( 'test' (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:73:1: ( 'test' (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation ) )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:73:2: 'test' (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation )
            {
            match(input,11,FOLLOW_11_in_ruleRoot114); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:77:1: (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            else if ( (LA1_0==14) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("77:1: (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:78:5: this_TestLinewrap= ruleTestLinewrap
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestLinewrap_in_ruleRoot137);
                    this_TestLinewrap=ruleTestLinewrap();
                    _fsp--;

                     
                            current = this_TestLinewrap; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:88:5: this_TestIndentation= ruleTestIndentation
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestIndentation_in_ruleRoot164);
                    this_TestIndentation=ruleTestIndentation();
                    _fsp--;

                     
                            current = this_TestIndentation; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleRoot


    // $ANTLR start entryRuleLine
    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:101:1: entryRuleLine returns [EObject current=null] : iv_ruleLine= ruleLine EOF ;
    public final EObject entryRuleLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLine = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:101:46: (iv_ruleLine= ruleLine EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:102:2: iv_ruleLine= ruleLine EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLine_in_entryRuleLine199);
            iv_ruleLine=ruleLine();
            _fsp--;

             current =iv_ruleLine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLine209); 

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
    // $ANTLR end entryRuleLine


    // $ANTLR start ruleLine
    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:109:1: ruleLine returns [EObject current=null] : ( ( (lv_type= RULE_ID ) (lv_name= RULE_ID ) ) ';' ) ;
    public final EObject ruleLine() throws RecognitionException {
        EObject current = null;

        Token lv_type=null;
        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:111:33: ( ( ( (lv_type= RULE_ID ) (lv_name= RULE_ID ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:112:1: ( ( (lv_type= RULE_ID ) (lv_name= RULE_ID ) ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:112:1: ( ( (lv_type= RULE_ID ) (lv_name= RULE_ID ) ) ';' )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:112:2: ( (lv_type= RULE_ID ) (lv_name= RULE_ID ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:112:2: ( (lv_type= RULE_ID ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:112:3: (lv_type= RULE_ID ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:112:3: (lv_type= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:114:6: lv_type= RULE_ID
            {
            lv_type=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLine256); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "type"); 
                

            	        if (current==null) {
            	            current = factory.create("Line");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.add(current, "type", lv_type,"ID");
            	         

            }

            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:128:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:130:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLine288); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Line");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.add(current, "name", lv_name,"ID");
            	         

            }


            }

            match(input,12,FOLLOW_12_in_ruleLine309); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleLine


    // $ANTLR start entryRuleTestLinewrap
    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:153:1: entryRuleTestLinewrap returns [EObject current=null] : iv_ruleTestLinewrap= ruleTestLinewrap EOF ;
    public final EObject entryRuleTestLinewrap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestLinewrap = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:153:54: (iv_ruleTestLinewrap= ruleTestLinewrap EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:154:2: iv_ruleTestLinewrap= ruleTestLinewrap EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap344);
            iv_ruleTestLinewrap=ruleTestLinewrap();
            _fsp--;

             current =iv_ruleTestLinewrap; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestLinewrap354); 

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
    // $ANTLR end entryRuleTestLinewrap


    // $ANTLR start ruleTestLinewrap
    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:161:1: ruleTestLinewrap returns [EObject current=null] : ( 'linewrap' (lv_items= ruleLine )* ) ;
    public final EObject ruleTestLinewrap() throws RecognitionException {
        EObject current = null;

        EObject lv_items = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:163:33: ( ( 'linewrap' (lv_items= ruleLine )* ) )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:164:1: ( 'linewrap' (lv_items= ruleLine )* )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:164:1: ( 'linewrap' (lv_items= ruleLine )* )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:164:2: 'linewrap' (lv_items= ruleLine )*
            {
            match(input,13,FOLLOW_13_in_ruleTestLinewrap388); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:168:1: (lv_items= ruleLine )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:171:6: lv_items= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLine_in_ruleTestLinewrap422);
            	    lv_items=ruleLine();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("TestLinewrap");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "items", lv_items,null);
            	    	         

            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end ruleTestLinewrap


    // $ANTLR start entryRuleTestIndentation
    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:190:1: entryRuleTestIndentation returns [EObject current=null] : iv_ruleTestIndentation= ruleTestIndentation EOF ;
    public final EObject entryRuleTestIndentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestIndentation = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:190:57: (iv_ruleTestIndentation= ruleTestIndentation EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:191:2: iv_ruleTestIndentation= ruleTestIndentation EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation462);
            iv_ruleTestIndentation=ruleTestIndentation();
            _fsp--;

             current =iv_ruleTestIndentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestIndentation472); 

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
    // $ANTLR end entryRuleTestIndentation


    // $ANTLR start ruleTestIndentation
    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:198:1: ruleTestIndentation returns [EObject current=null] : ( ( ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )* ) '}' ) ;
    public final EObject ruleTestIndentation() throws RecognitionException {
        EObject current = null;

        EObject lv_sub = null;

        EObject lv_items = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:200:33: ( ( ( ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:201:1: ( ( ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:201:1: ( ( ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )* ) '}' )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:201:2: ( ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:201:2: ( ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )* )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:201:3: ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )*
            {
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:201:3: ( 'indentation' '{' )
            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:201:4: 'indentation' '{'
            {
            match(input,14,FOLLOW_14_in_ruleTestIndentation508); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleTestIndentation517); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:209:2: ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }
                else if ( (LA3_0==RULE_ID) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:209:3: (lv_sub= ruleTestIndentation )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:209:3: (lv_sub= ruleTestIndentation )
            	    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:212:6: lv_sub= ruleTestIndentation
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTestIndentation_in_ruleTestIndentation553);
            	    lv_sub=ruleTestIndentation();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("TestIndentation");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "sub", lv_sub,null);
            	    	         

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:227:6: (lv_items= ruleLine )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:227:6: (lv_items= ruleLine )
            	    // ./src-gen/org/eclipse/xtext/parsetree/formatter/parser/internal/InternalFormatterTestLanguage.g:230:6: lv_items= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLine_in_ruleTestIndentation597);
            	    lv_items=ruleLine();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("TestIndentation");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "items", lv_items,null);
            	    	         

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            match(input,16,FOLLOW_16_in_ruleTestIndentation613); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleTestIndentation


 

    public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot70 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoot80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRoot114 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_ruleTestLinewrap_in_ruleRoot137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_ruleRoot164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLine_in_entryRuleLine199 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLine209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLine256 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLine288 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLine309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestLinewrap354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleTestLinewrap388 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleLine_in_ruleTestLinewrap422 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestIndentation472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleTestIndentation508 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTestIndentation517 = new BitSet(new long[]{0x0000000000014010L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_ruleTestIndentation553 = new BitSet(new long[]{0x0000000000014010L});
    public static final BitSet FOLLOW_ruleLine_in_ruleTestIndentation597 = new BitSet(new long[]{0x0000000000014010L});
    public static final BitSet FOLLOW_16_in_ruleTestIndentation613 = new BitSet(new long[]{0x0000000000000002L});

}
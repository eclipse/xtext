package org.eclipse.xtext.parsetree.formatter.parser.antlr.internal; 

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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalFormatterTestLanguageParser extends AbstractInternalAntlrParser {
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g"; }


     
        public InternalFormatterTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalFormatterTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	} 



    // $ANTLR start entryRuleRoot
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:68:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:68:46: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:69:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRoot_in_entryRuleRoot72);
            iv_ruleRoot=ruleRoot();
            _fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoot82); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:76:1: ruleRoot returns [EObject current=null] : ( 'test' (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject this_TestLinewrap = null;

        EObject this_TestIndentation = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:80:6: ( ( 'test' (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:81:1: ( 'test' (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:81:1: ( 'test' (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:81:2: 'test' (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation )
            {
            match(input,11,FOLLOW_11_in_ruleRoot116); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:85:1: (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation )
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
                    new NoViableAltException("85:1: (this_TestLinewrap= ruleTestLinewrap | this_TestIndentation= ruleTestIndentation )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:86:5: this_TestLinewrap= ruleTestLinewrap
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.1/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestLinewrap_in_ruleRoot139);
                    this_TestLinewrap=ruleTestLinewrap();
                    _fsp--;

                     
                            current = this_TestLinewrap; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:96:5: this_TestIndentation= ruleTestIndentation
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.1/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestIndentation_in_ruleRoot166);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:113:1: entryRuleLine returns [EObject current=null] : iv_ruleLine= ruleLine EOF ;
    public final EObject entryRuleLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLine = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:113:46: (iv_ruleLine= ruleLine EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:114:2: iv_ruleLine= ruleLine EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLine_in_entryRuleLine201);
            iv_ruleLine=ruleLine();
            _fsp--;

             current =iv_ruleLine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLine211); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:121:1: ruleLine returns [EObject current=null] : ( ( (lv_type= RULE_ID ) (lv_name= RULE_ID ) ) ';' ) ;
    public final EObject ruleLine() throws RecognitionException {
        EObject current = null;

        Token lv_type=null;
        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:125:6: ( ( ( (lv_type= RULE_ID ) (lv_name= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:126:1: ( ( (lv_type= RULE_ID ) (lv_name= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:126:1: ( ( (lv_type= RULE_ID ) (lv_name= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:126:2: ( (lv_type= RULE_ID ) (lv_name= RULE_ID ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:126:2: ( (lv_type= RULE_ID ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:126:3: (lv_type= RULE_ID ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:126:3: (lv_type= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:128:6: lv_type= RULE_ID
            {
            lv_type=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLine258); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "type"); 
                

            	        if (current==null) {
            	            current = factory.create("Line");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "type", lv_type, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:146:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:148:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLine290); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Line");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleLine311); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:179:1: entryRuleTestLinewrap returns [EObject current=null] : iv_ruleTestLinewrap= ruleTestLinewrap EOF ;
    public final EObject entryRuleTestLinewrap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestLinewrap = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:179:54: (iv_ruleTestLinewrap= ruleTestLinewrap EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:180:2: iv_ruleTestLinewrap= ruleTestLinewrap EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap346);
            iv_ruleTestLinewrap=ruleTestLinewrap();
            _fsp--;

             current =iv_ruleTestLinewrap; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestLinewrap356); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:187:1: ruleTestLinewrap returns [EObject current=null] : ( 'linewrap' (lv_items= ruleLine )* ) ;
    public final EObject ruleTestLinewrap() throws RecognitionException {
        EObject current = null;

        EObject lv_items = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:191:6: ( ( 'linewrap' (lv_items= ruleLine )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:192:1: ( 'linewrap' (lv_items= ruleLine )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:192:1: ( 'linewrap' (lv_items= ruleLine )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:192:2: 'linewrap' (lv_items= ruleLine )*
            {
            match(input,13,FOLLOW_13_in_ruleTestLinewrap390); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.2/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:196:1: (lv_items= ruleLine )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:199:6: lv_items= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLine_in_ruleTestLinewrap424);
            	    lv_items=ruleLine();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("TestLinewrap");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "items", lv_items, "Line", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:226:1: entryRuleTestIndentation returns [EObject current=null] : iv_ruleTestIndentation= ruleTestIndentation EOF ;
    public final EObject entryRuleTestIndentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestIndentation = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:226:57: (iv_ruleTestIndentation= ruleTestIndentation EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:227:2: iv_ruleTestIndentation= ruleTestIndentation EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation464);
            iv_ruleTestIndentation=ruleTestIndentation();
            _fsp--;

             current =iv_ruleTestIndentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestIndentation474); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:234:1: ruleTestIndentation returns [EObject current=null] : ( ( ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )* ) '}' ) ;
    public final EObject ruleTestIndentation() throws RecognitionException {
        EObject current = null;

        EObject lv_sub = null;

        EObject lv_items = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:238:6: ( ( ( ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )* ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:239:1: ( ( ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )* ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:239:1: ( ( ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )* ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:239:2: ( ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )* ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:239:2: ( ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:239:3: ( 'indentation' '{' ) ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:239:3: ( 'indentation' '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:239:4: 'indentation' '{'
            {
            match(input,14,FOLLOW_14_in_ruleTestIndentation510); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleTestIndentation519); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:247:2: ( (lv_sub= ruleTestIndentation ) | (lv_items= ruleLine ) )*
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
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:247:3: (lv_sub= ruleTestIndentation )
            	    {
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:247:3: (lv_sub= ruleTestIndentation )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:250:6: lv_sub= ruleTestIndentation
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTestIndentation_in_ruleTestIndentation555);
            	    lv_sub=ruleTestIndentation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("TestIndentation");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "sub", lv_sub, "TestIndentation", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:269:6: (lv_items= ruleLine )
            	    {
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:269:6: (lv_items= ruleLine )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:272:6: lv_items= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLine_in_ruleTestIndentation599);
            	    lv_items=ruleLine();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("TestIndentation");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "items", lv_items, "Line", currentNode);
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

            match(input,16,FOLLOW_16_in_ruleTestIndentation615); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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


 

    public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoot82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRoot116 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_ruleTestLinewrap_in_ruleRoot139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_ruleRoot166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLine_in_entryRuleLine201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLine211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLine258 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLine290 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLine311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestLinewrap356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleTestLinewrap390 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleLine_in_ruleTestLinewrap424 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestIndentation474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleTestIndentation510 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTestIndentation519 = new BitSet(new long[]{0x0000000000014010L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_ruleTestIndentation555 = new BitSet(new long[]{0x0000000000014010L});
    public static final BitSet FOLLOW_ruleLine_in_ruleTestIndentation599 = new BitSet(new long[]{0x0000000000014010L});
    public static final BitSet FOLLOW_16_in_ruleTestIndentation615 = new BitSet(new long[]{0x0000000000000002L});

}
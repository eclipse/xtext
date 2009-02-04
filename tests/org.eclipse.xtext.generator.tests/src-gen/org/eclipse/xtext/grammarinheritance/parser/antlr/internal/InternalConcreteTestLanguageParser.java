package org.eclipse.xtext.grammarinheritance.parser.antlr.internal; 

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

public class InternalConcreteTestLanguageParser extends AbstractInternalAntlrParser {
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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g"; }


     
        public InternalConcreteTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalConcreteTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RootRule";	
       	} 



    // $ANTLR start entryRuleRootRule
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:68:1: entryRuleRootRule returns [EObject current=null] : iv_ruleRootRule= ruleRootRule EOF ;
    public final EObject entryRuleRootRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:68:50: (iv_ruleRootRule= ruleRootRule EOF )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:69:2: iv_ruleRootRule= ruleRootRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRootRule_in_entryRuleRootRule72);
            iv_ruleRootRule=ruleRootRule();
            _fsp--;

             current =iv_ruleRootRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRootRule82); 

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
    // $ANTLR end entryRuleRootRule


    // $ANTLR start ruleRootRule
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:76:1: ruleRootRule returns [EObject current=null] : this_ConcreteParserRule= ruleConcreteParserRule ;
    public final EObject ruleRootRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteParserRule = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:80:6: (this_ConcreteParserRule= ruleConcreteParserRule )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:82:5: this_ConcreteParserRule= ruleConcreteParserRule
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.0/@alternatives" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleConcreteParserRule_in_ruleRootRule128);
            this_ConcreteParserRule=ruleConcreteParserRule();
            _fsp--;

             
                    current = this_ConcreteParserRule; 
                    currentNode = currentNode.getParent();
                

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
    // $ANTLR end ruleRootRule


    // $ANTLR start entryRuleConcreteParserRule
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:99:1: entryRuleConcreteParserRule returns [EObject current=null] : iv_ruleConcreteParserRule= ruleConcreteParserRule EOF ;
    public final EObject entryRuleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:99:60: (iv_ruleConcreteParserRule= ruleConcreteParserRule EOF )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:100:2: iv_ruleConcreteParserRule= ruleConcreteParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule161);
            iv_ruleConcreteParserRule=ruleConcreteParserRule();
            _fsp--;

             current =iv_ruleConcreteParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteParserRule171); 

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
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:107:1: ruleConcreteParserRule returns [EObject current=null] : ( ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )* ) ;
    public final EObject ruleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_magicNumber=null;
        EObject lv_elements = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:111:6: ( ( ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )* ) )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:112:1: ( ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )* )
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:112:1: ( ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )* )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:112:2: ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )*
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:112:2: ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:112:3: ( 'model' (lv_magicNumber= RULE_REAL ) ) ':'
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:112:3: ( 'model' (lv_magicNumber= RULE_REAL ) )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:112:4: 'model' (lv_magicNumber= RULE_REAL )
            {
            match(input,12,FOLLOW_12_in_ruleConcreteParserRule207); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:116:1: (lv_magicNumber= RULE_REAL )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:118:6: lv_magicNumber= RULE_REAL
            {
            lv_magicNumber=(Token)input.LT(1);
            match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleConcreteParserRule228); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "magicNumber"); 
                

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

            match(input,13,FOLLOW_13_in_ruleConcreteParserRule249); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:140:2: (lv_elements= ruleInheritedParserRule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:143:6: lv_elements= ruleInheritedParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule284);
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
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:170:1: entryRuleInheritedParserRule returns [EObject current=null] : iv_ruleInheritedParserRule= ruleInheritedParserRule EOF ;
    public final EObject entryRuleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritedParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:170:61: (iv_ruleInheritedParserRule= ruleInheritedParserRule EOF )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:171:2: iv_ruleInheritedParserRule= ruleInheritedParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule324);
            iv_ruleInheritedParserRule=ruleInheritedParserRule();
            _fsp--;

             current =iv_ruleInheritedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInheritedParserRule334); 

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
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:178:1: ruleInheritedParserRule returns [EObject current=null] : ( 'element' (lv_name= RULE_ID ) ) ;
    public final EObject ruleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:182:6: ( ( 'element' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:183:1: ( 'element' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:183:1: ( 'element' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:183:2: 'element' (lv_name= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleInheritedParserRule368); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:187:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:189:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInheritedParserRule389); 
             
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


    // $ANTLR start entryRuleOverridableParserRule
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:218:1: entryRuleOverridableParserRule returns [EObject current=null] : iv_ruleOverridableParserRule= ruleOverridableParserRule EOF ;
    public final EObject entryRuleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:218:63: (iv_ruleOverridableParserRule= ruleOverridableParserRule EOF )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:219:2: iv_ruleOverridableParserRule= ruleOverridableParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule437);
            iv_ruleOverridableParserRule=ruleOverridableParserRule();
            _fsp--;

             current =iv_ruleOverridableParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridableParserRule447); 

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
    // $ANTLR end entryRuleOverridableParserRule


    // $ANTLR start ruleOverridableParserRule
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:226:1: ruleOverridableParserRule returns [EObject current=null] : ( 'element' (lv_name= RULE_ID ) ) ;
    public final EObject ruleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:230:6: ( ( 'element' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:231:1: ( 'element' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:231:1: ( 'element' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:231:2: 'element' (lv_name= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleOverridableParserRule481); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:235:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:237:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOverridableParserRule502); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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
    // $ANTLR end ruleOverridableParserRule


    // $ANTLR start entryRuleExtendableParserRule
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:266:1: entryRuleExtendableParserRule returns [EObject current=null] : iv_ruleExtendableParserRule= ruleExtendableParserRule EOF ;
    public final EObject entryRuleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendableParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:266:62: (iv_ruleExtendableParserRule= ruleExtendableParserRule EOF )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:267:2: iv_ruleExtendableParserRule= ruleExtendableParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule550);
            iv_ruleExtendableParserRule=ruleExtendableParserRule();
            _fsp--;

             current =iv_ruleExtendableParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtendableParserRule560); 

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
    // $ANTLR end entryRuleExtendableParserRule


    // $ANTLR start ruleExtendableParserRule
    // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:274:1: ruleExtendableParserRule returns [EObject current=null] : ( 'element' (lv_name= RULE_ID ) ) ;
    public final EObject ruleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:278:6: ( ( 'element' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:279:1: ( 'element' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:279:1: ( 'element' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:279:2: 'element' (lv_name= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleExtendableParserRule594); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:283:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:285:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtendableParserRule615); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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
    // $ANTLR end ruleExtendableParserRule


 

    public static final BitSet FOLLOW_ruleRootRule_in_entryRuleRootRule72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRootRule82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteParserRule_in_ruleRootRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteParserRule171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleConcreteParserRule207 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleConcreteParserRule228 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleConcreteParserRule249 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule284 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritedParserRule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleInheritedParserRule368 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInheritedParserRule389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule437 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOverridableParserRule481 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtendableParserRule560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleExtendableParserRule594 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtendableParserRule615 = new BitSet(new long[]{0x0000000000000002L});

}
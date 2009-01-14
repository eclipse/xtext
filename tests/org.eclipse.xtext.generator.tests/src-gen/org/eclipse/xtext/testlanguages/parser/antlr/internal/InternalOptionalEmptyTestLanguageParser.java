// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g 2009-01-14 17:06:09

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

public class InternalOptionalEmptyTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'hallo'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalOptionalEmptyTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g"; }


     
        public InternalOptionalEmptyTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalOptionalEmptyTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:66:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:66:47: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:67:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel71);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel81); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:74:1: ruleModel returns [EObject current=null] : (lv_child= ruleGreeting )? ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_child = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:76:33: ( (lv_child= ruleGreeting )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:77:1: (lv_child= ruleGreeting )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:77:1: (lv_child= ruleGreeting )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:80:6: lv_child= ruleGreeting
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGreeting_in_ruleModel139);
                    lv_child=ruleGreeting();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("Model");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "child", lv_child, "Greeting", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleGreeting
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:105:1: entryRuleGreeting returns [EObject current=null] : iv_ruleGreeting= ruleGreeting EOF ;
    public final EObject entryRuleGreeting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreeting = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:105:50: (iv_ruleGreeting= ruleGreeting EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:106:2: iv_ruleGreeting= ruleGreeting EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGreeting_in_entryRuleGreeting176);
            iv_ruleGreeting=ruleGreeting();
            _fsp--;

             current =iv_ruleGreeting; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGreeting186); 

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
    // $ANTLR end entryRuleGreeting


    // $ANTLR start ruleGreeting
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:113:1: ruleGreeting returns [EObject current=null] : ( 'hallo' (lv_name= RULE_ID ) ) ;
    public final EObject ruleGreeting() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:115:33: ( ( 'hallo' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:116:1: ( 'hallo' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:116:1: ( 'hallo' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:116:2: 'hallo' (lv_name= RULE_ID )
            {
            match(input,11,FOLLOW_11_in_ruleGreeting220); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:120:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalOptionalEmptyTestLanguage.g:122:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGreeting241); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Greeting");
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
    // $ANTLR end ruleGreeting


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreeting_in_ruleModel139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreeting_in_entryRuleGreeting176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGreeting186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGreeting220 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGreeting241 = new BitSet(new long[]{0x0000000000000002L});

}
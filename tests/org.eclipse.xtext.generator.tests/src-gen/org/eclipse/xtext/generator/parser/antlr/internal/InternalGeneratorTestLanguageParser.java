package org.eclipse.xtext.generator.parser.antlr.internal; 

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
import org.eclipse.xtext.generator.services.GeneratorTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalGeneratorTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'x'", "'y'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalGeneratorTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g"; }


     
     	private GeneratorTestLanguageGrammarAccess grammarAccess;
     	
        public InternalGeneratorTestLanguageParser(TokenStream input, IAstFactory factory, GeneratorTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Rule";	
       	} 



    // $ANTLR start entryRuleRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g:69:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g:69:46: (iv_ruleRule= ruleRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g:70:2: iv_ruleRule= ruleRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleRule_in_entryRuleRule71);
            iv_ruleRule=ruleRule();
            _fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRule81); 

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
    // $ANTLR end entryRuleRule


    // $ANTLR start ruleRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g:77:1: ruleRule returns [EObject current=null] : 'x' ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g:82:6: ( 'x' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g:83:1: 'x'
            {
            match(input,11,FOLLOW_11_in_ruleRule114); 

                    createLeafNode(grammarAccess.getRuleAccess().getXKeyword(), null); 
                

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
    // $ANTLR end ruleRule


    // $ANTLR start entryRuleRuleB
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g:94:1: entryRuleRuleB returns [EObject current=null] : iv_ruleRuleB= ruleRuleB EOF ;
    public final EObject entryRuleRuleB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleB = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g:94:47: (iv_ruleRuleB= ruleRuleB EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g:95:2: iv_ruleRuleB= ruleRuleB EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleBRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleB_in_entryRuleRuleB146);
            iv_ruleRuleB=ruleRuleB();
            _fsp--;

             current =iv_ruleRuleB; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleB156); 

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
    // $ANTLR end entryRuleRuleB


    // $ANTLR start ruleRuleB
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g:102:1: ruleRuleB returns [EObject current=null] : 'y' ;
    public final EObject ruleRuleB() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g:107:6: ( 'y' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/parser/antlr/internal/InternalGeneratorTestLanguage.g:108:1: 'y'
            {
            match(input,12,FOLLOW_12_in_ruleRuleB189); 

                    createLeafNode(grammarAccess.getRuleBAccess().getYKeyword(), null); 
                

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
    // $ANTLR end ruleRuleB


 

    public static final BitSet FOLLOW_ruleRule_in_entryRuleRule71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRule81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRule114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleB_in_entryRuleRuleB146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleB156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleRuleB189 = new BitSet(new long[]{0x0000000000000002L});

}
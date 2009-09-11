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
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalAbstractTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_REAL", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=7;
    public static final int RULE_REAL=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;

        public InternalAbstractTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g"; }


     
     	private AbstractTestLanguageGrammarAccess grammarAccess;
     	
        public InternalAbstractTestLanguageParser(TokenStream input, IAstFactory factory, AbstractTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "InheritedParserRule";	
       	} 



    // $ANTLR start entryRuleInheritedParserRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:72:1: entryRuleInheritedParserRule returns [EObject current=null] : iv_ruleInheritedParserRule= ruleInheritedParserRule EOF ;
    public final EObject entryRuleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritedParserRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:72:61: (iv_ruleInheritedParserRule= ruleInheritedParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:73:2: iv_ruleInheritedParserRule= ruleInheritedParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInheritedParserRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule73);
            iv_ruleInheritedParserRule=ruleInheritedParserRule();
            _fsp--;

             current =iv_ruleInheritedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInheritedParserRule83); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:80:1: ruleInheritedParserRule returns [EObject current=null] : ( 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:85:6: ( ( 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:86:1: ( 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:86:1: ( 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:86:2: 'element' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,12,FOLLOW_12_in_ruleInheritedParserRule117); 

                    createLeafNode(grammarAccess.getInheritedParserRuleAccess().getElementKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:90:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:91:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:91:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:92:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInheritedParserRule134); 

            			createLeafNode(grammarAccess.getInheritedParserRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getInheritedParserRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleInheritedParserRule


    // $ANTLR start entryRuleOverridableParserRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:123:1: entryRuleOverridableParserRule returns [EObject current=null] : iv_ruleOverridableParserRule= ruleOverridableParserRule EOF ;
    public final EObject entryRuleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:123:63: (iv_ruleOverridableParserRule= ruleOverridableParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:124:2: iv_ruleOverridableParserRule= ruleOverridableParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOverridableParserRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule174);
            iv_ruleOverridableParserRule=ruleOverridableParserRule();
            _fsp--;

             current =iv_ruleOverridableParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridableParserRule184); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:131:1: ruleOverridableParserRule returns [EObject current=null] : ( 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:136:6: ( ( 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:137:1: ( 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:137:1: ( 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:137:2: 'element' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,12,FOLLOW_12_in_ruleOverridableParserRule218); 

                    createLeafNode(grammarAccess.getOverridableParserRuleAccess().getElementKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:141:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:142:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:142:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:143:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOverridableParserRule235); 

            			createLeafNode(grammarAccess.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOverridableParserRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleOverridableParserRule


    // $ANTLR start entryRuleExtendableParserRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:176:1: entryRuleExtendableParserRule returns [EObject current=null] : iv_ruleExtendableParserRule= ruleExtendableParserRule EOF ;
    public final EObject entryRuleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendableParserRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:176:62: (iv_ruleExtendableParserRule= ruleExtendableParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:177:2: iv_ruleExtendableParserRule= ruleExtendableParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExtendableParserRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule277);
            iv_ruleExtendableParserRule=ruleExtendableParserRule();
            _fsp--;

             current =iv_ruleExtendableParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtendableParserRule287); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:184:1: ruleExtendableParserRule returns [EObject current=null] : ( 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:189:6: ( ( 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:190:1: ( 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:190:1: ( 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:190:2: 'element' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,12,FOLLOW_12_in_ruleExtendableParserRule321); 

                    createLeafNode(grammarAccess.getExtendableParserRuleAccess().getElementKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:194:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:195:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:195:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:196:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtendableParserRule338); 

            			createLeafNode(grammarAccess.getExtendableParserRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExtendableParserRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleExtendableParserRule


 

    public static final BitSet FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritedParserRule83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleInheritedParserRule117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInheritedParserRule134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule174 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleOverridableParserRule218 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtendableParserRule287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleExtendableParserRule321 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtendableParserRule338 = new BitSet(new long[]{0x0000000000000002L});

}
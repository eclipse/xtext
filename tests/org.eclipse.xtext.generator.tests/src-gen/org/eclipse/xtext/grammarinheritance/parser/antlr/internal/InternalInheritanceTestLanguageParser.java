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
import org.eclipse.xtext.grammarinheritance.services.InheritanceTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalInheritanceTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "'{'", "'}'", "'element'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalInheritanceTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g"; }



     	private InheritanceTestLanguageGrammarAccess grammarAccess;
     	
        public InternalInheritanceTestLanguageParser(TokenStream input, IAstFactory factory, InheritanceTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel83); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( 'model' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_elements_3_0= ruleElement ) )* '}' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_elements_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:85:6: ( ( 'model' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_elements_3_0= ruleElement ) )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:86:1: ( 'model' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_elements_3_0= ruleElement ) )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:86:1: ( 'model' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_elements_3_0= ruleElement ) )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:86:3: 'model' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_elements_3_0= ruleElement ) )* '}'
            {
            match(input,11,FOLLOW_11_in_ruleModel118); 

                    createLeafNode(grammarAccess.getModelAccess().getModelKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:90:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:91:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:91:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:92:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel135); 

            			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
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

            match(input,12,FOLLOW_12_in_ruleModel150); 

                    createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:118:1: ( (lv_elements_3_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:119:1: (lv_elements_3_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:119:1: (lv_elements_3_0= ruleElement )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:120:3: lv_elements_3_0= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getElementsElementParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleModel171);
            	    lv_elements_3_0=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_3_0, 
            	    	        		"Element", 
            	    	        		currentNode);
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

            match(input,13,FOLLOW_13_in_ruleModel182); 

                    createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleElement
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:153:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:153:49: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:154:2: iv_ruleElement= ruleElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement215);
            iv_ruleElement=ruleElement();
            _fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement225); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:161:1: ruleElement returns [EObject current=null] : ( 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:166:6: ( ( 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:167:1: ( 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:167:1: ( 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:167:3: 'element' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,14,FOLLOW_14_in_ruleElement260); 

                    createLeafNode(grammarAccess.getElementAccess().getElementKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:171:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:172:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:172:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:173:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElement277); 

            			createLeafNode(grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
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
    // $ANTLR end ruleElement


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel135 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleModel150 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_ruleElement_in_ruleModel171 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleModel182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement215 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleElement260 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElement277 = new BitSet(new long[]{0x0000000000000002L});

}
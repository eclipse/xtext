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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g"; }


     
     	private AbstractTestLanguageGrammarAccess grammarAccess;
     	
        public InternalAbstractTestLanguageParser(TokenStream input, IAstFactory factory, AbstractTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:70:1: entryRuleInheritedParserRule returns [EObject current=null] : iv_ruleInheritedParserRule= ruleInheritedParserRule EOF ;
    public final EObject entryRuleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritedParserRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:70:61: (iv_ruleInheritedParserRule= ruleInheritedParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:71:2: iv_ruleInheritedParserRule= ruleInheritedParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prInheritedParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule72);
            iv_ruleInheritedParserRule=ruleInheritedParserRule();
            _fsp--;

             current =iv_ruleInheritedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInheritedParserRule82); 

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
    // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:78:1: ruleInheritedParserRule returns [EObject current=null] : ( 'element' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:83:6: ( ( 'element' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:84:1: ( 'element' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:84:1: ( 'element' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:84:2: 'element' (lv_name_1= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleInheritedParserRule116); 

                    createLeafNode(grammarAccess.prInheritedParserRule().ele0KeywordElement(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:88:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:90:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInheritedParserRule138); 

            		createLeafNode(grammarAccess.prInheritedParserRule().ele10LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prInheritedParserRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:119:1: entryRuleOverridableParserRule returns [EObject current=null] : iv_ruleOverridableParserRule= ruleOverridableParserRule EOF ;
    public final EObject entryRuleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:119:63: (iv_ruleOverridableParserRule= ruleOverridableParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:120:2: iv_ruleOverridableParserRule= ruleOverridableParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prOverridableParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule183);
            iv_ruleOverridableParserRule=ruleOverridableParserRule();
            _fsp--;

             current =iv_ruleOverridableParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridableParserRule193); 

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
    // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:127:1: ruleOverridableParserRule returns [EObject current=null] : ( 'element' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:132:6: ( ( 'element' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:133:1: ( 'element' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:133:1: ( 'element' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:133:2: 'element' (lv_name_1= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleOverridableParserRule227); 

                    createLeafNode(grammarAccess.prOverridableParserRule().ele0KeywordElement(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:137:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:139:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOverridableParserRule249); 

            		createLeafNode(grammarAccess.prOverridableParserRule().ele10LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prOverridableParserRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:170:1: entryRuleExtendableParserRule returns [EObject current=null] : iv_ruleExtendableParserRule= ruleExtendableParserRule EOF ;
    public final EObject entryRuleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendableParserRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:170:62: (iv_ruleExtendableParserRule= ruleExtendableParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:171:2: iv_ruleExtendableParserRule= ruleExtendableParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prExtendableParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule296);
            iv_ruleExtendableParserRule=ruleExtendableParserRule();
            _fsp--;

             current =iv_ruleExtendableParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtendableParserRule306); 

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
    // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:178:1: ruleExtendableParserRule returns [EObject current=null] : ( 'element' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:183:6: ( ( 'element' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:184:1: ( 'element' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:184:1: ( 'element' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:184:2: 'element' (lv_name_1= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleExtendableParserRule340); 

                    createLeafNode(grammarAccess.prExtendableParserRule().ele0KeywordElement(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:188:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalAbstractTestLanguage.g:190:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExtendableParserRule362); 

            		createLeafNode(grammarAccess.prExtendableParserRule().ele10LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prExtendableParserRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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


 

    public static final BitSet FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritedParserRule82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleInheritedParserRule116 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInheritedParserRule138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleOverridableParserRule227 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtendableParserRule306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleExtendableParserRule340 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExtendableParserRule362 = new BitSet(new long[]{0x0000000000000002L});

}
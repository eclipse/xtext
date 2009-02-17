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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g"; }


     
     	private InheritanceTestLanguageGrammarAccess grammarAccess;
     	
        public InternalInheritanceTestLanguageParser(TokenStream input, IAstFactory factory, InheritanceTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalInheritanceTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:70:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:71:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prModel().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:78:1: ruleModel returns [EObject current=null] : ( ( ( ( 'model' (lv_name_1= RULE_ID ) ) '{' ) (lv_elements_3= ruleElement )* ) '}' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_elements_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:83:6: ( ( ( ( ( 'model' (lv_name_1= RULE_ID ) ) '{' ) (lv_elements_3= ruleElement )* ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:84:1: ( ( ( ( 'model' (lv_name_1= RULE_ID ) ) '{' ) (lv_elements_3= ruleElement )* ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:84:1: ( ( ( ( 'model' (lv_name_1= RULE_ID ) ) '{' ) (lv_elements_3= ruleElement )* ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:84:2: ( ( ( 'model' (lv_name_1= RULE_ID ) ) '{' ) (lv_elements_3= ruleElement )* ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:84:2: ( ( ( 'model' (lv_name_1= RULE_ID ) ) '{' ) (lv_elements_3= ruleElement )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:84:3: ( ( 'model' (lv_name_1= RULE_ID ) ) '{' ) (lv_elements_3= ruleElement )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:84:3: ( ( 'model' (lv_name_1= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:84:4: ( 'model' (lv_name_1= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:84:4: ( 'model' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:84:5: 'model' (lv_name_1= RULE_ID )
            {
            match(input,11,FOLLOW_11_in_ruleModel119); 

                    createLeafNode(grammarAccess.prModel().ele0000KeywordModel(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:88:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:90:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel141); 

            		createLeafNode(grammarAccess.prModel().ele00010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleModel159); 

                    createLeafNode(grammarAccess.prModel().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:112:2: (lv_elements_3= ruleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:115:6: lv_elements_3= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prModel().ele010ParserRuleCallElement(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleModel194);
            	    lv_elements_3=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "elements", lv_elements_3, "Element", currentNode);
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

            match(input,13,FOLLOW_13_in_ruleModel209); 

                    createLeafNode(grammarAccess.prModel().ele1KeywordRightCurlyBracket(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:146:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:146:49: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:147:2: iv_ruleElement= ruleElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement244);
            iv_ruleElement=ruleElement();
            _fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement254); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:154:1: ruleElement returns [EObject current=null] : ( 'element' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:159:6: ( ( 'element' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:160:1: ( 'element' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:160:1: ( 'element' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:160:2: 'element' (lv_name_1= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleElement288); 

                    createLeafNode(grammarAccess.prElement().ele0KeywordElement(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:164:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalInheritanceTestLanguage.g:166:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElement310); 

            		createLeafNode(grammarAccess.prElement().ele10LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prElement().getRule().getType().getType());
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
    // $ANTLR end ruleElement


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel119 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel141 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleModel159 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_ruleElement_in_ruleModel194 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleModel209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement244 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleElement288 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElement310 = new BitSet(new long[]{0x0000000000000002L});

}
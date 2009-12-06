package org.eclipse.xtext.xtend.parser.antlr.internal; 

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
import org.eclipse.xtext.xtend.services.TreeTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTreeTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'{'", "'};'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalTreeTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g"; }



     	private TreeTestLanguageGrammarAccess grammarAccess;
     	
        public InternalTreeTestLanguageParser(TokenStream input, IAstFactory factory, TreeTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( (lv_children_0_0= ruleNode ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:85:6: ( ( (lv_children_0_0= ruleNode ) )* )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:86:1: ( (lv_children_0_0= ruleNode ) )*
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:86:1: ( (lv_children_0_0= ruleNode ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:87:1: (lv_children_0_0= ruleNode )
            	    {
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:87:1: (lv_children_0_0= ruleNode )
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:88:3: lv_children_0_0= ruleNode
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getChildrenNodeParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNode_in_ruleModel128);
            	    lv_children_0_0=ruleNode();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"children",
            	    	        		lv_children_0_0, 
            	    	        		"Node", 
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


    // $ANTLR start entryRuleNode
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:117:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:117:46: (iv_ruleNode= ruleNode EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:118:2: iv_ruleNode= ruleNode EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNodeRule(), currentNode); 
            pushFollow(FOLLOW_ruleNode_in_entryRuleNode161);
            iv_ruleNode=ruleNode();
            _fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNode171); 

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
    // $ANTLR end entryRuleNode


    // $ANTLR start ruleNode
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:125:1: ruleNode returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) '(' ( (lv_attrib_2_0= RULE_STRING ) ) ')' '{' ( (lv_children_5_0= ruleNode ) )* '};' ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_attrib_2_0=null;
        EObject lv_children_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:130:6: ( ( ( (lv_name_0_0= RULE_ID ) ) '(' ( (lv_attrib_2_0= RULE_STRING ) ) ')' '{' ( (lv_children_5_0= ruleNode ) )* '};' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:131:1: ( ( (lv_name_0_0= RULE_ID ) ) '(' ( (lv_attrib_2_0= RULE_STRING ) ) ')' '{' ( (lv_children_5_0= ruleNode ) )* '};' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:131:1: ( ( (lv_name_0_0= RULE_ID ) ) '(' ( (lv_attrib_2_0= RULE_STRING ) ) ')' '{' ( (lv_children_5_0= ruleNode ) )* '};' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:131:2: ( (lv_name_0_0= RULE_ID ) ) '(' ( (lv_attrib_2_0= RULE_STRING ) ) ')' '{' ( (lv_children_5_0= ruleNode ) )* '};'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:131:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:132:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:132:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:133:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNode213); 

            			createLeafNode(grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNodeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,11,FOLLOW_11_in_ruleNode228); 

                    createLeafNode(grammarAccess.getNodeAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:159:1: ( (lv_attrib_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:160:1: (lv_attrib_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:160:1: (lv_attrib_2_0= RULE_STRING )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:161:3: lv_attrib_2_0= RULE_STRING
            {
            lv_attrib_2_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNode245); 

            			createLeafNode(grammarAccess.getNodeAccess().getAttribSTRINGTerminalRuleCall_2_0(), "attrib"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNodeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"attrib",
            	        		lv_attrib_2_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleNode260); 

                    createLeafNode(grammarAccess.getNodeAccess().getRightParenthesisKeyword_3(), null); 
                
            match(input,13,FOLLOW_13_in_ruleNode270); 

                    createLeafNode(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_4(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:191:1: ( (lv_children_5_0= ruleNode ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:192:1: (lv_children_5_0= ruleNode )
            	    {
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:192:1: (lv_children_5_0= ruleNode )
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/xtend/parser/antlr/internal/InternalTreeTestLanguage.g:193:3: lv_children_5_0= ruleNode
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNodeAccess().getChildrenNodeParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNode_in_ruleNode291);
            	    lv_children_5_0=ruleNode();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNodeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"children",
            	    	        		lv_children_5_0, 
            	    	        		"Node", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_ruleNode302); 

                    createLeafNode(grammarAccess.getNodeAccess().getRightCurlyBracketSemicolonKeyword_6(), null); 
                

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
    // $ANTLR end ruleNode


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleModel128 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleNode_in_entryRuleNode161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNode171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNode213 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleNode228 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNode245 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNode260 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNode270 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleNode_in_ruleNode291 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleNode302 = new BitSet(new long[]{0x0000000000000002L});

}
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
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess;



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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g"; }


     
     	private TreeTestLanguageGrammarAccess grammarAccess;
     	
        public InternalTreeTestLanguageParser(TokenStream input, IAstFactory factory, TreeTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalTreeTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:70:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:71:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:78:1: ruleModel returns [EObject current=null] : (lv_children= ruleNode )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:82:6: ( (lv_children= ruleNode )* )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:83:1: (lv_children= ruleNode )*
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:83:1: (lv_children= ruleNode )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:86:6: lv_children= ruleNode
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prModel().ele0ParserRuleCallNode(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNode_in_ruleModel140);
            	    lv_children=ruleNode();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Model");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "children", lv_children, "Node", currentNode);
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


    // $ANTLR start entryRuleNode
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:113:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:113:46: (iv_ruleNode= ruleNode EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:114:2: iv_ruleNode= ruleNode EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNode().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNode_in_entryRuleNode179);
            iv_ruleNode=ruleNode();
            _fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNode189); 

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
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:121:1: ruleNode returns [EObject current=null] : ( ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};' ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_attrib=null;
        EObject lv_children = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:125:6: ( ( ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};' ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:1: ( ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};' )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:1: ( ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:2: ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:2: ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:3: ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )*
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:3: ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:4: ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:4: ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:5: ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:5: ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:6: ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:6: ( (lv_name= RULE_ID ) '(' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:7: (lv_name= RULE_ID ) '('
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:126:7: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNode240); 
             
                createLeafNode(grammarAccess.prNode().ele0000000LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Node");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,11,FOLLOW_11_in_ruleNode260); 

                    createLeafNode(grammarAccess.prNode().ele000001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:150:2: (lv_attrib= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:152:6: lv_attrib= RULE_STRING
            {
            lv_attrib=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNode282); 
             
                createLeafNode(grammarAccess.prNode().ele000010LexerRuleCallSTRING(), "attrib"); 
                

            	        if (current==null) {
            	            current = factory.create("Node");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "attrib", lv_attrib, "STRING", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleNode303); 

                    createLeafNode(grammarAccess.prNode().ele0001KeywordRightParenthesis(), null); 
                

            }

            match(input,13,FOLLOW_13_in_ruleNode313); 

                    createLeafNode(grammarAccess.prNode().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:178:2: (lv_children= ruleNode )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:181:6: lv_children= ruleNode
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prNode().ele010ParserRuleCallNode(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNode_in_ruleNode348);
            	    lv_children=ruleNode();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Node");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "children", lv_children, "Node", currentNode);
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

            match(input,14,FOLLOW_14_in_ruleNode363); 

                    createLeafNode(grammarAccess.prNode().ele1KeywordRightCurlyBracketSemicolon(), null); 
                

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
    // $ANTLR end ruleNode


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleModel140 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleNode_in_entryRuleNode179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNode189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNode240 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleNode260 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNode282 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNode303 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNode313 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleNode_in_ruleNode348 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleNode363 = new BitSet(new long[]{0x0000000000000002L});

}
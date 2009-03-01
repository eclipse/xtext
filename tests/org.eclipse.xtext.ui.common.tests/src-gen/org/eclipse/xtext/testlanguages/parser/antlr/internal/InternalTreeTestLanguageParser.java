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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g"; }


     
     	private TreeTestLanguageGrammarAccess grammarAccess;
     	
        public InternalTreeTestLanguageParser(TokenStream input, IAstFactory factory, TreeTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:70:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:71:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:78:1: ruleModel returns [EObject current=null] : (lv_children_0= ruleNode )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:83:6: ( (lv_children_0= ruleNode )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:84:1: (lv_children_0= ruleNode )*
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:84:1: (lv_children_0= ruleNode )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:87:6: lv_children_0= ruleNode
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prModel().ele0ParserRuleCallNode(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNode_in_ruleModel140);
            	    lv_children_0=ruleNode();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "children", lv_children_0, "Node", currentNode);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:114:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:114:46: (iv_ruleNode= ruleNode EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:115:2: iv_ruleNode= ruleNode EOF
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:122:1: ruleNode returns [EObject current=null] : ( ( ( ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING ) ) ')' ) '{' ) (lv_children_5= ruleNode )* ) '};' ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        Token lv_attrib_2=null;
        EObject lv_children_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:127:6: ( ( ( ( ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING ) ) ')' ) '{' ) (lv_children_5= ruleNode )* ) '};' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:1: ( ( ( ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING ) ) ')' ) '{' ) (lv_children_5= ruleNode )* ) '};' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:1: ( ( ( ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING ) ) ')' ) '{' ) (lv_children_5= ruleNode )* ) '};' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:2: ( ( ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING ) ) ')' ) '{' ) (lv_children_5= ruleNode )* ) '};'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:2: ( ( ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING ) ) ')' ) '{' ) (lv_children_5= ruleNode )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:3: ( ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING ) ) ')' ) '{' ) (lv_children_5= ruleNode )*
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:3: ( ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING ) ) ')' ) '{' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:4: ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING ) ) ')' ) '{'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:4: ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING ) ) ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:5: ( ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING ) ) ')'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:5: ( ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:6: ( (lv_name_0= RULE_ID ) '(' ) (lv_attrib_2= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:6: ( (lv_name_0= RULE_ID ) '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:7: (lv_name_0= RULE_ID ) '('
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:128:7: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:130:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNode240); 

            		createLeafNode(grammarAccess.prNode().ele0000000ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prNode().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,11,FOLLOW_11_in_ruleNode256); 

                    createLeafNode(grammarAccess.prNode().ele000001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:151:2: (lv_attrib_2= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:153:6: lv_attrib_2= RULE_STRING
            {
            lv_attrib_2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNode278); 

            		createLeafNode(grammarAccess.prNode().ele000010ParserRuleCallSTRING(), "attrib"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prNode().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "attrib", lv_attrib_2, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleNode295); 

                    createLeafNode(grammarAccess.prNode().ele0001KeywordRightParenthesis(), null); 
                

            }

            match(input,13,FOLLOW_13_in_ruleNode305); 

                    createLeafNode(grammarAccess.prNode().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:178:2: (lv_children_5= ruleNode )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTreeTestLanguage.g:181:6: lv_children_5= ruleNode
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prNode().ele010ParserRuleCallNode(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNode_in_ruleNode340);
            	    lv_children_5=ruleNode();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prNode().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "children", lv_children_5, "Node", currentNode);
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

            match(input,14,FOLLOW_14_in_ruleNode355); 

                    createLeafNode(grammarAccess.prNode().ele1KeywordRightCurlyBracketSemicolon(), null); 
                

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleModel140 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleNode_in_entryRuleNode179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNode189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNode240 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleNode256 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNode278 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNode295 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNode305 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleNode_in_ruleNode340 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleNode355 = new BitSet(new long[]{0x0000000000000002L});

}
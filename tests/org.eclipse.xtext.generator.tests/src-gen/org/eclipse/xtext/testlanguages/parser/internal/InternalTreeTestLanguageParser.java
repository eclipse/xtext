// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g 2008-12-02 18:42:26

package org.eclipse.xtext.testlanguages.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTreeTestLanguageParser extends AbstractAntlrParser {
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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g"; }


     
        public InternalTreeTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalTreeTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:62:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:62:47: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:63:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel70);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel80); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:70:1: ruleModel returns [EObject current=null] : (lv_children= ruleNode )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:72:33: ( (lv_children= ruleNode )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:73:1: (lv_children= ruleNode )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:73:1: (lv_children= ruleNode )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:76:6: lv_children= ruleNode
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNode_in_ruleModel138);
            	    lv_children=ruleNode();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Model");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "children", lv_children,null);
            	    	         

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:95:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:95:46: (iv_ruleNode= ruleNode EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:96:2: iv_ruleNode= ruleNode EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNode_in_entryRuleNode177);
            iv_ruleNode=ruleNode();
            _fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNode187); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:103:1: ruleNode returns [EObject current=null] : ( ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};' ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_attrib=null;
        EObject lv_children = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:105:33: ( ( ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:1: ( ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:1: ( ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:2: ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:2: ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:3: ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:3: ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:4: ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:4: ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:5: ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:5: ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:6: ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:6: ( (lv_name= RULE_ID ) '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:7: (lv_name= RULE_ID ) '('
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:7: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:108:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNode238); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Node");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }

            match(input,11,FOLLOW_11_in_ruleNode258); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:126:2: (lv_attrib= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:128:6: lv_attrib= RULE_STRING
            {
            lv_attrib=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNode280); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "attrib"); 
                

            	        if (current==null) {
            	            current = factory.create("Node");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "attrib", lv_attrib,"STRING");
            	         

            }


            }

            match(input,12,FOLLOW_12_in_ruleNode301); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,13,FOLLOW_13_in_ruleNode311); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:150:2: (lv_children= ruleNode )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:153:6: lv_children= ruleNode
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNode_in_ruleNode346);
            	    lv_children=ruleNode();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Node");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "children", lv_children,null);
            	    	         

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            match(input,14,FOLLOW_14_in_ruleNode361); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel70 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleModel138 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleNode_in_entryRuleNode177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNode187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNode238 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleNode258 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNode280 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNode301 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNode311 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleNode_in_ruleNode346 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleNode361 = new BitSet(new long[]{0x0000000000000002L});

}
// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g 2008-12-18 11:06:27

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
import org.eclipse.xtext.parser.antlr.DatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.ValueConverterException;



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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:66:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:66:47: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:67:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:74:1: ruleModel returns [EObject current=null] : (lv_children= ruleNode )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:76:33: ( (lv_children= ruleNode )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:77:1: (lv_children= ruleNode )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:77:1: (lv_children= ruleNode )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:80:6: lv_children= ruleNode
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNode_in_ruleModel139);
            	    lv_children=ruleNode();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Model");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "children", lv_children,"Node");
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:105:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:105:46: (iv_ruleNode= ruleNode EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:106:2: iv_ruleNode= ruleNode EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNode_in_entryRuleNode176);
            iv_ruleNode=ruleNode();
            _fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNode186); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:113:1: ruleNode returns [EObject current=null] : ( ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};' ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_attrib=null;
        EObject lv_children = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:115:33: ( ( ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:1: ( ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:1: ( ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:2: ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* ) '};'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:2: ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:3: ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' ) (lv_children= ruleNode )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:3: ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:4: ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' ) '{'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:4: ( ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:5: ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:5: ( ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:6: ( (lv_name= RULE_ID ) '(' ) (lv_attrib= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:6: ( (lv_name= RULE_ID ) '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:7: (lv_name= RULE_ID ) '('
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:116:7: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:118:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNode237); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Node");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name,"ID");
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,11,FOLLOW_11_in_ruleNode257); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:140:2: (lv_attrib= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:142:6: lv_attrib= RULE_STRING
            {
            lv_attrib=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNode279); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "attrib"); 
                

            	        if (current==null) {
            	            current = factory.create("Node");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "attrib", lv_attrib,"STRING");
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleNode300); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,13,FOLLOW_13_in_ruleNode310); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:168:2: (lv_children= ruleNode )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalTreeTestLanguage.g:171:6: lv_children= ruleNode
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNode_in_ruleNode345);
            	    lv_children=ruleNode();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Node");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "children", lv_children,"Node");
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            match(input,14,FOLLOW_14_in_ruleNode360); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNode_in_ruleModel139 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleNode_in_entryRuleNode176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNode186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNode237 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleNode257 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNode279 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNode300 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNode310 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleNode_in_ruleNode345 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleNode360 = new BitSet(new long[]{0x0000000000000002L});

}
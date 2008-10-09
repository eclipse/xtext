// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g 2008-10-09 14:53:41

package org.eclipse.xtext.ui.core.parser.internal; 

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

public class InternalTestLanguageParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'stuff'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g"; }


     
        public InternalTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	} 



    // $ANTLR start entryRuleFile
    // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:63:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:63:46: (iv_ruleFile= ruleFile EOF )
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:64:2: iv_ruleFile= ruleFile EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile71);
            iv_ruleFile=ruleFile();
            _fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile81); 

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
    // $ANTLR end entryRuleFile


    // $ANTLR start ruleFile
    // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:71:1: ruleFile returns [EObject current=null] : (lv_stuff= ruleStuff )* ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_stuff = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:73:33: ( (lv_stuff= ruleStuff )* )
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:74:1: (lv_stuff= ruleStuff )*
            {
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:74:1: (lv_stuff= ruleStuff )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:77:6: lv_stuff= ruleStuff
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStuff_in_ruleFile139);
            	    lv_stuff=ruleStuff();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("File");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "stuff", lv_stuff,null);
            	    	         

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
    // $ANTLR end ruleFile


    // $ANTLR start entryRuleStuff
    // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:96:1: entryRuleStuff returns [EObject current=null] : iv_ruleStuff= ruleStuff EOF ;
    public final EObject entryRuleStuff() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStuff = null;


        try {
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:96:47: (iv_ruleStuff= ruleStuff EOF )
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:97:2: iv_ruleStuff= ruleStuff EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleStuff_in_entryRuleStuff178);
            iv_ruleStuff=ruleStuff();
            _fsp--;

             current =iv_ruleStuff; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStuff188); 

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
    // $ANTLR end entryRuleStuff


    // $ANTLR start ruleStuff
    // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:104:1: ruleStuff returns [EObject current=null] : ( 'stuff' (lv_name= RULE_ID ) ) ;
    public final EObject ruleStuff() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:106:33: ( ( 'stuff' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:107:1: ( 'stuff' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:107:1: ( 'stuff' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:107:2: 'stuff' (lv_name= RULE_ID )
            {
            match(input,11,FOLLOW_11_in_ruleStuff222); 

                    createLeafNode("classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:111:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/ui/core/parser/internal/InternalTestLanguage.g:113:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStuff243); 
             
                createLeafNode("classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Stuff");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


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
    // $ANTLR end ruleStuff


 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStuff_in_ruleFile139 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleStuff_in_entryRuleStuff178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStuff188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleStuff222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStuff243 = new BitSet(new long[]{0x0000000000000002L});

}
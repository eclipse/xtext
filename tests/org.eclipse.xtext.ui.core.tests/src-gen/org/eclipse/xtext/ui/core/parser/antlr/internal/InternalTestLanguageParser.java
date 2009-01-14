// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g 2009-01-14 16:50:55

package org.eclipse.xtext.ui.core.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'stuff'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g"; }


     
        public InternalTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	} 



    // $ANTLR start entryRuleFile
    // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:66:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:66:46: (iv_ruleFile= ruleFile EOF )
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:67:2: iv_ruleFile= ruleFile EOF
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
    // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:74:1: ruleFile returns [EObject current=null] : (lv_stuff= ruleStuff )* ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_stuff = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:76:33: ( (lv_stuff= ruleStuff )* )
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:77:1: (lv_stuff= ruleStuff )*
            {
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:77:1: (lv_stuff= ruleStuff )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:80:6: lv_stuff= ruleStuff
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStuff_in_ruleFile139);
            	    lv_stuff=ruleStuff();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("File");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "stuff", lv_stuff, "Stuff", currentNode);
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
    // $ANTLR end ruleFile


    // $ANTLR start entryRuleStuff
    // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:105:1: entryRuleStuff returns [EObject current=null] : iv_ruleStuff= ruleStuff EOF ;
    public final EObject entryRuleStuff() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStuff = null;


        try {
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:105:47: (iv_ruleStuff= ruleStuff EOF )
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:106:2: iv_ruleStuff= ruleStuff EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleStuff_in_entryRuleStuff176);
            iv_ruleStuff=ruleStuff();
            _fsp--;

             current =iv_ruleStuff; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStuff186); 

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
    // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:113:1: ruleStuff returns [EObject current=null] : ( 'stuff' (lv_name= RULE_ID ) ) ;
    public final EObject ruleStuff() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:115:33: ( ( 'stuff' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:116:1: ( 'stuff' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:116:1: ( 'stuff' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:116:2: 'stuff' (lv_name= RULE_ID )
            {
            match(input,11,FOLLOW_11_in_ruleStuff220); 

                    createLeafNode("classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:120:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/ui/core/parser/antlr/internal/InternalTestLanguage.g:122:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStuff241); 
             
                createLeafNode("classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Stuff");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    public static final BitSet FOLLOW_ruleStuff_in_entryRuleStuff176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStuff186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleStuff220 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStuff241 = new BitSet(new long[]{0x0000000000000002L});

}
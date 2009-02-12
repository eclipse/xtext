package org.eclipse.xtext.ui.integration.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.integration.services.TestLanguageGrammarAccess;



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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g"; }


     
     	private TestLanguageGrammarAccess grammarAccess;
     	
        public InternalTestLanguageParser(TokenStream input, IAstFactory factory, TestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	} 



    // $ANTLR start entryRuleFile
    // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:70:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:70:46: (iv_ruleFile= ruleFile EOF )
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:71:2: iv_ruleFile= ruleFile EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFile().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile72);
            iv_ruleFile=ruleFile();
            _fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile82); 

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
    // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:78:1: ruleFile returns [EObject current=null] : (lv_stuff= ruleStuff )* ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_stuff = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:82:6: ( (lv_stuff= ruleStuff )* )
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:83:1: (lv_stuff= ruleStuff )*
            {
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:83:1: (lv_stuff= ruleStuff )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:86:6: lv_stuff= ruleStuff
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prFile().ele0ParserRuleCallStuff(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStuff_in_ruleFile140);
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
    // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:113:1: entryRuleStuff returns [EObject current=null] : iv_ruleStuff= ruleStuff EOF ;
    public final EObject entryRuleStuff() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStuff = null;


        try {
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:113:47: (iv_ruleStuff= ruleStuff EOF )
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:114:2: iv_ruleStuff= ruleStuff EOF
            {
             currentNode = createCompositeNode(grammarAccess.prStuff().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleStuff_in_entryRuleStuff179);
            iv_ruleStuff=ruleStuff();
            _fsp--;

             current =iv_ruleStuff; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStuff189); 

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
    // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:121:1: ruleStuff returns [EObject current=null] : ( 'stuff' (lv_name= RULE_ID ) ) ;
    public final EObject ruleStuff() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:125:6: ( ( 'stuff' (lv_name= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:126:1: ( 'stuff' (lv_name= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:126:1: ( 'stuff' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:126:2: 'stuff' (lv_name= RULE_ID )
            {
            match(input,11,FOLLOW_11_in_ruleStuff223); 

                    createLeafNode(grammarAccess.prStuff().ele0KeywordStuff(), null); 
                
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:130:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.ui.integration.tests/./src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:132:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStuff244); 
             
                createLeafNode(grammarAccess.prStuff().ele10LexerRuleCallID(), "name"); 
                

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


 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStuff_in_ruleFile140 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleStuff_in_entryRuleStuff179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStuff189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleStuff223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStuff244 = new BitSet(new long[]{0x0000000000000002L});

}
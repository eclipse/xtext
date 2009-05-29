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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g"; }


     
     	private TestLanguageGrammarAccess grammarAccess;
     	
        public InternalTestLanguageParser(TokenStream input, IAstFactory factory, TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	} 



    // $ANTLR start entryRuleFile
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:72:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:72:46: (iv_ruleFile= ruleFile EOF )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:73:2: iv_ruleFile= ruleFile EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFileRule(), currentNode); 
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile73);
            iv_ruleFile=ruleFile();
            _fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile83); 

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
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:80:1: ruleFile returns [EObject current=null] : (lv_stuff_0= ruleStuff )* ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_stuff_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:85:6: ( (lv_stuff_0= ruleStuff )* )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:86:1: (lv_stuff_0= ruleStuff )*
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:86:1: (lv_stuff_0= ruleStuff )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:89:6: lv_stuff_0= ruleStuff
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFileAccess().getStuffStuffParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStuff_in_ruleFile141);
            	    lv_stuff_0=ruleStuff();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFileRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "stuff", lv_stuff_0, "Stuff", currentNode);
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
    // $ANTLR end ruleFile


    // $ANTLR start entryRuleStuff
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:114:1: entryRuleStuff returns [EObject current=null] : iv_ruleStuff= ruleStuff EOF ;
    public final EObject entryRuleStuff() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStuff = null;


        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:114:47: (iv_ruleStuff= ruleStuff EOF )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:115:2: iv_ruleStuff= ruleStuff EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStuffRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:122:1: ruleStuff returns [EObject current=null] : ( 'stuff' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleStuff() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:127:6: ( ( 'stuff' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:128:1: ( 'stuff' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:128:1: ( 'stuff' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:128:2: 'stuff' (lv_name_1= RULE_ID )
            {
            match(input,11,FOLLOW_11_in_ruleStuff222); 

                    createLeafNode(grammarAccess.getStuffAccess().getStuffKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:132:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/parser/antlr/internal/InternalTestLanguage.g:134:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStuff244); 

            		createLeafNode(grammarAccess.getStuffAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStuffRule().getType().getClassifier());
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
    // $ANTLR end ruleStuff


 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStuff_in_ruleFile141 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleStuff_in_entryRuleStuff178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStuff188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleStuff222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStuff244 = new BitSet(new long[]{0x0000000000000002L});

}
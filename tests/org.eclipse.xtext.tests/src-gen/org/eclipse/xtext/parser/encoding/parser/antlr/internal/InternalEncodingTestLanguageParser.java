package org.eclipse.xtext.parser.encoding.parser.antlr.internal; 

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
import org.eclipse.xtext.parser.encoding.services.EncodingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEncodingTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WORD", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_WORD=4;
    public static final int RULE_ANY_OTHER=6;
    public static final int RULE_WS=5;
    public static final int EOF=-1;

        public InternalEncodingTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g"; }



     	private EncodingTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEncodingTestLanguageParser(TokenStream input, IAstFactory factory, EncodingTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected EncodingTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( (lv_words_0_0= RULE_WORD ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_words_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:91:6: ( ( (lv_words_0_0= RULE_WORD ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:92:1: ( (lv_words_0_0= RULE_WORD ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:92:1: ( (lv_words_0_0= RULE_WORD ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_WORD) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:93:1: (lv_words_0_0= RULE_WORD )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:93:1: (lv_words_0_0= RULE_WORD )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:94:3: lv_words_0_0= RULE_WORD
            	    {
            	    lv_words_0_0=(Token)input.LT(1);
            	    match(input,RULE_WORD,FollowSets000.FOLLOW_RULE_WORD_in_ruleModel126); 

            	    			createLeafNode(grammarAccess.getModelAccess().getWordsWORDTerminalRuleCall_0(), "words"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"words",
            	    	        		lv_words_0_0, 
            	    	        		"WORD", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WORD_in_ruleModel126 = new BitSet(new long[]{0x0000000000000012L});
    }


}
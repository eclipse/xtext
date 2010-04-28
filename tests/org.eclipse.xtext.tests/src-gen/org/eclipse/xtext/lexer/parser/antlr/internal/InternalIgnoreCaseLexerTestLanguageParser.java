package org.eclipse.xtext.lexer.parser.antlr.internal; 

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
import org.eclipse.xtext.lexer.services.IgnoreCaseLexerTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalIgnoreCaseLexerTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_2", "KEYWORD_1", "RULE_WS", "RULE_SL_COMMENT", "Tokens"
    };
    public static final int KEYWORD_1=5;
    public static final int KEYWORD_2=4;
    public static final int RULE_WS=6;
    public static final int RULE_SL_COMMENT=7;
    public static final int EOF=-1;
    public static final int Tokens=8;

        public InternalIgnoreCaseLexerTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g"; }




     	private IgnoreCaseLexerTestLanguageGrammarAccess grammarAccess;
     	
        public InternalIgnoreCaseLexerTestLanguageParser(TokenStream input, IAstFactory factory, IgnoreCaseLexerTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 
       	   	
       	@Override
       	protected IgnoreCaseLexerTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel67);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel77); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( KEYWORD_2 ( KEYWORD_1 )? ( (lv_value_2_0= KEYWORD_2 ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_value_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:85:6: ( ( KEYWORD_2 ( KEYWORD_1 )? ( (lv_value_2_0= KEYWORD_2 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:86:1: ( KEYWORD_2 ( KEYWORD_1 )? ( (lv_value_2_0= KEYWORD_2 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:86:1: ( KEYWORD_2 ( KEYWORD_1 )? ( (lv_value_2_0= KEYWORD_2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:87:2: KEYWORD_2 ( KEYWORD_1 )? ( (lv_value_2_0= KEYWORD_2 ) )
            {
            match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleModel113); 

                    createLeafNode(grammarAccess.getModelAccess().getCaseKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:91:1: ( KEYWORD_1 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==KEYWORD_1) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:92:2: KEYWORD_1
                    {
                    match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleModel125); 

                            createLeafNode(grammarAccess.getModelAccess().getFooKeyword_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:96:3: ( (lv_value_2_0= KEYWORD_2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:97:1: (lv_value_2_0= KEYWORD_2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:97:1: (lv_value_2_0= KEYWORD_2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/lexer/parser/antlr/internal/InternalIgnoreCaseLexerTestLanguage.g:98:3: lv_value_2_0= KEYWORD_2
            {
            lv_value_2_0=(Token)input.LT(1);
            match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleModel146); 

                    createLeafNode(grammarAccess.getModelAccess().getValueCaSeKeyword_2_0(), "value"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_2_0, "CaSe", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end ruleModel


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel77 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleModel113 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleModel125 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleModel146 = new BitSet(new long[]{0x0000000000000002L});
    }


}
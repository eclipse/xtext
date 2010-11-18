package org.eclipse.xtext.ui.tests.editor.encoding.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.encoding.services.EncodingUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEncodingUiTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEXEME", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ANY_OTHER=6;
    public static final int RULE_WS=5;
    public static final int RULE_LEXEME=4;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalEncodingUiTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEncodingUiTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEncodingUiTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g"; }



     	private EncodingUiTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEncodingUiTestLanguageParser(TokenStream input, IAstFactory factory, EncodingUiTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected EncodingUiTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( (lv_words_0_0= ruleWord ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_words_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:85:6: ( ( (lv_words_0_0= ruleWord ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:86:1: ( (lv_words_0_0= ruleWord ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:86:1: ( (lv_words_0_0= ruleWord ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_LEXEME) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:87:1: (lv_words_0_0= ruleWord )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:87:1: (lv_words_0_0= ruleWord )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:88:3: lv_words_0_0= ruleWord
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getWordsWordParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleWord_in_ruleModel130);
            	    lv_words_0_0=ruleWord();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"words",
            	            		lv_words_0_0, 
            	            		"Word", 
            	            		currentNode);
            	    	        afterParserOrEnumRuleCall();
            	    	    

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleWord"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:113:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:114:2: (iv_ruleWord= ruleWord EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:115:2: iv_ruleWord= ruleWord EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWordRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleWord_in_entryRuleWord166);
            iv_ruleWord=ruleWord();

            state._fsp--;

             current =iv_ruleWord; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWord176); 

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
    // $ANTLR end "entryRuleWord"


    // $ANTLR start "ruleWord"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:122:1: ruleWord returns [EObject current=null] : ( (lv_value_0_0= RULE_LEXEME ) ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:127:6: ( ( (lv_value_0_0= RULE_LEXEME ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:128:1: ( (lv_value_0_0= RULE_LEXEME ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:128:1: ( (lv_value_0_0= RULE_LEXEME ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:129:1: (lv_value_0_0= RULE_LEXEME )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:129:1: (lv_value_0_0= RULE_LEXEME )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/parser/antlr/internal/InternalEncodingUiTestLanguage.g:130:3: lv_value_0_0= RULE_LEXEME
            {
            lv_value_0_0=(Token)match(input,RULE_LEXEME,FollowSets000.FOLLOW_RULE_LEXEME_in_ruleWord217); 

            			createLeafNode(lv_value_0_0, grammarAccess.getWordAccess().getValueLEXEMETerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWordRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"LEXEME", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleWord"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWord_in_ruleModel130 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleWord_in_entryRuleWord166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWord176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LEXEME_in_ruleWord217 = new BitSet(new long[]{0x0000000000000002L});
    }


}
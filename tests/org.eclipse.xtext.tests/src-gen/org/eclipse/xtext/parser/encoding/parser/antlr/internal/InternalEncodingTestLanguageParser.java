package org.eclipse.xtext.parser.encoding.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.encoding.services.EncodingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEncodingTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEXEME", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_WS=5;
    public static final int EOF=-1;
    public static final int RULE_ANY_OTHER=6;
    public static final int RULE_LEXEME=4;

    // delegates
    // delegators


        public InternalEncodingTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEncodingTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEncodingTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g"; }



     	private EncodingTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEncodingTestLanguageParser(TokenStream input, EncodingTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected EncodingTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_words_0_0= ruleWord ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_words_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:79:28: ( ( (lv_words_0_0= ruleWord ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:80:1: ( (lv_words_0_0= ruleWord ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:80:1: ( (lv_words_0_0= ruleWord ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_LEXEME) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:81:1: (lv_words_0_0= ruleWord )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:81:1: (lv_words_0_0= ruleWord )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:82:3: lv_words_0_0= ruleWord
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getWordsWordParserRuleCall_0()); 
            	    	    
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
            	            		"org.eclipse.xtext.parser.encoding.EncodingTestLanguage.Word");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:106:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:107:2: (iv_ruleWord= ruleWord EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:108:2: iv_ruleWord= ruleWord EOF
            {
             newCompositeNode(grammarAccess.getWordRule()); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:115:1: ruleWord returns [EObject current=null] : ( (lv_value_0_0= RULE_LEXEME ) ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:118:28: ( ( (lv_value_0_0= RULE_LEXEME ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:119:1: ( (lv_value_0_0= RULE_LEXEME ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:119:1: ( (lv_value_0_0= RULE_LEXEME ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:120:1: (lv_value_0_0= RULE_LEXEME )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:120:1: (lv_value_0_0= RULE_LEXEME )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/encoding/parser/antlr/internal/InternalEncodingTestLanguage.g:121:3: lv_value_0_0= RULE_LEXEME
            {
            lv_value_0_0=(Token)match(input,RULE_LEXEME,FollowSets000.FOLLOW_RULE_LEXEME_in_ruleWord217); 

            			newLeafNode(lv_value_0_0, grammarAccess.getWordAccess().getValueLEXEMETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWordRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.eclipse.xtext.parser.encoding.EncodingTestLanguage.LEXEME");
            	    

            }


            }


            }

             leaveRule(); 
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
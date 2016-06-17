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
    public static final int RULE_LEXEME=4;
    public static final int RULE_ANY_OTHER=6;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalEncodingTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEncodingTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEncodingTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEncodingTestLanguage.g"; }



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
    // InternalEncodingTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalEncodingTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalEncodingTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalEncodingTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_words_0_0= ruleWord ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_words_0_0 = null;


         enterRule(); 
            
        try {
            // InternalEncodingTestLanguage.g:79:28: ( ( (lv_words_0_0= ruleWord ) )* )
            // InternalEncodingTestLanguage.g:80:1: ( (lv_words_0_0= ruleWord ) )*
            {
            // InternalEncodingTestLanguage.g:80:1: ( (lv_words_0_0= ruleWord ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_LEXEME) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalEncodingTestLanguage.g:81:1: (lv_words_0_0= ruleWord )
            	    {
            	    // InternalEncodingTestLanguage.g:81:1: (lv_words_0_0= ruleWord )
            	    // InternalEncodingTestLanguage.g:82:3: lv_words_0_0= ruleWord
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getWordsWordParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
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
    // InternalEncodingTestLanguage.g:106:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // InternalEncodingTestLanguage.g:107:2: (iv_ruleWord= ruleWord EOF )
            // InternalEncodingTestLanguage.g:108:2: iv_ruleWord= ruleWord EOF
            {
             newCompositeNode(grammarAccess.getWordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWord=ruleWord();

            state._fsp--;

             current =iv_ruleWord; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalEncodingTestLanguage.g:115:1: ruleWord returns [EObject current=null] : ( (lv_value_0_0= RULE_LEXEME ) ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalEncodingTestLanguage.g:118:28: ( ( (lv_value_0_0= RULE_LEXEME ) ) )
            // InternalEncodingTestLanguage.g:119:1: ( (lv_value_0_0= RULE_LEXEME ) )
            {
            // InternalEncodingTestLanguage.g:119:1: ( (lv_value_0_0= RULE_LEXEME ) )
            // InternalEncodingTestLanguage.g:120:1: (lv_value_0_0= RULE_LEXEME )
            {
            // InternalEncodingTestLanguage.g:120:1: (lv_value_0_0= RULE_LEXEME )
            // InternalEncodingTestLanguage.g:121:3: lv_value_0_0= RULE_LEXEME
            {
            lv_value_0_0=(Token)match(input,RULE_LEXEME,FollowSets000.FOLLOW_2); 

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    }


}
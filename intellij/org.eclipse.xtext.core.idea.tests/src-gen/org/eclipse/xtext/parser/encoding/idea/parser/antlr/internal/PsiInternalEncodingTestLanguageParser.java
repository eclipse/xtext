package org.eclipse.xtext.parser.encoding.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.encoding.services.EncodingTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalEncodingTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEXEME", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_WS=5;
    public static final int EOF=-1;
    public static final int RULE_ANY_OTHER=6;
    public static final int RULE_LEXEME=4;

    // delegates
    // delegators


        public PsiInternalEncodingTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalEncodingTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalEncodingTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalEncodingTestLanguage.g"; }



    	protected EncodingTestLanguageGrammarAccess grammarAccess;

    	protected EncodingTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalEncodingTestLanguageParser(PsiBuilder builder, TokenStream input, EncodingTestLanguageElementTypeProvider elementTypeProvider, EncodingTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalEncodingTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalEncodingTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalEncodingTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalEncodingTestLanguage.g:58:1: ruleModel : ( (lv_words_0_0= ruleWord ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalEncodingTestLanguage.g:58:10: ( ( (lv_words_0_0= ruleWord ) )* )
            // PsiInternalEncodingTestLanguage.g:59:2: ( (lv_words_0_0= ruleWord ) )*
            {
            // PsiInternalEncodingTestLanguage.g:59:2: ( (lv_words_0_0= ruleWord ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_LEXEME) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalEncodingTestLanguage.g:60:3: (lv_words_0_0= ruleWord )
            	    {
            	    // PsiInternalEncodingTestLanguage.g:60:3: (lv_words_0_0= ruleWord )
            	    // PsiInternalEncodingTestLanguage.g:61:4: lv_words_0_0= ruleWord
            	    {

            	    				markComposite(elementTypeProvider.getModel_WordsWordParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleWord();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleWord"
    // PsiInternalEncodingTestLanguage.g:73:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // PsiInternalEncodingTestLanguage.g:73:14: ( ruleWord EOF )
            // PsiInternalEncodingTestLanguage.g:74:2: ruleWord EOF
            {
             markComposite(elementTypeProvider.getWordElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWord();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWord"


    // $ANTLR start "ruleWord"
    // PsiInternalEncodingTestLanguage.g:79:1: ruleWord : ( (lv_value_0_0= RULE_LEXEME ) ) ;
    public final void ruleWord() throws RecognitionException {
        Token lv_value_0_0=null;

        try {
            // PsiInternalEncodingTestLanguage.g:79:9: ( ( (lv_value_0_0= RULE_LEXEME ) ) )
            // PsiInternalEncodingTestLanguage.g:80:2: ( (lv_value_0_0= RULE_LEXEME ) )
            {
            // PsiInternalEncodingTestLanguage.g:80:2: ( (lv_value_0_0= RULE_LEXEME ) )
            // PsiInternalEncodingTestLanguage.g:81:3: (lv_value_0_0= RULE_LEXEME )
            {
            // PsiInternalEncodingTestLanguage.g:81:3: (lv_value_0_0= RULE_LEXEME )
            // PsiInternalEncodingTestLanguage.g:82:4: lv_value_0_0= RULE_LEXEME
            {

            				markLeaf(elementTypeProvider.getWord_ValueLEXEMETerminalRuleCall_0ElementType());
            			
            lv_value_0_0=(Token)match(input,RULE_LEXEME,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_value_0_0);
            			

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleWord"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    }


}
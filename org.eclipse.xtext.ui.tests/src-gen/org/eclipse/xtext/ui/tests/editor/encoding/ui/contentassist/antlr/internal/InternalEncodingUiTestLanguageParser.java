package org.eclipse.xtext.ui.tests.editor.encoding.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.editor.encoding.services.EncodingUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEncodingUiTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEXEME", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_WS=5;
    public static final int EOF=-1;
    public static final int RULE_ANY_OTHER=6;
    public static final int RULE_LEXEME=4;

    // delegates
    // delegators


        public InternalEncodingUiTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEncodingUiTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEncodingUiTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEncodingUiTestLanguage.g"; }


     
     	private EncodingUiTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(EncodingUiTestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleModel"
    // InternalEncodingUiTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalEncodingUiTestLanguage.g:61:1: ( ruleModel EOF )
            // InternalEncodingUiTestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
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
    // InternalEncodingUiTestLanguage.g:69:1: ruleModel : ( ( rule__Model__WordsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalEncodingUiTestLanguage.g:73:2: ( ( ( rule__Model__WordsAssignment )* ) )
            // InternalEncodingUiTestLanguage.g:74:1: ( ( rule__Model__WordsAssignment )* )
            {
            // InternalEncodingUiTestLanguage.g:74:1: ( ( rule__Model__WordsAssignment )* )
            // InternalEncodingUiTestLanguage.g:75:1: ( rule__Model__WordsAssignment )*
            {
             before(grammarAccess.getModelAccess().getWordsAssignment()); 
            // InternalEncodingUiTestLanguage.g:76:1: ( rule__Model__WordsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_LEXEME) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalEncodingUiTestLanguage.g:76:2: rule__Model__WordsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Model__WordsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getWordsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleWord"
    // InternalEncodingUiTestLanguage.g:88:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalEncodingUiTestLanguage.g:89:1: ( ruleWord EOF )
            // InternalEncodingUiTestLanguage.g:90:1: ruleWord EOF
            {
             before(grammarAccess.getWordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getWordRule()); 
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
    // InternalEncodingUiTestLanguage.g:97:1: ruleWord : ( ( rule__Word__ValueAssignment ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalEncodingUiTestLanguage.g:101:2: ( ( ( rule__Word__ValueAssignment ) ) )
            // InternalEncodingUiTestLanguage.g:102:1: ( ( rule__Word__ValueAssignment ) )
            {
            // InternalEncodingUiTestLanguage.g:102:1: ( ( rule__Word__ValueAssignment ) )
            // InternalEncodingUiTestLanguage.g:103:1: ( rule__Word__ValueAssignment )
            {
             before(grammarAccess.getWordAccess().getValueAssignment()); 
            // InternalEncodingUiTestLanguage.g:104:1: ( rule__Word__ValueAssignment )
            // InternalEncodingUiTestLanguage.g:104:2: rule__Word__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Word__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getWordAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWord"


    // $ANTLR start "rule__Model__WordsAssignment"
    // InternalEncodingUiTestLanguage.g:119:1: rule__Model__WordsAssignment : ( ruleWord ) ;
    public final void rule__Model__WordsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalEncodingUiTestLanguage.g:123:1: ( ( ruleWord ) )
            // InternalEncodingUiTestLanguage.g:124:1: ( ruleWord )
            {
            // InternalEncodingUiTestLanguage.g:124:1: ( ruleWord )
            // InternalEncodingUiTestLanguage.g:125:1: ruleWord
            {
             before(grammarAccess.getModelAccess().getWordsWordParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getModelAccess().getWordsWordParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__WordsAssignment"


    // $ANTLR start "rule__Word__ValueAssignment"
    // InternalEncodingUiTestLanguage.g:134:1: rule__Word__ValueAssignment : ( RULE_LEXEME ) ;
    public final void rule__Word__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalEncodingUiTestLanguage.g:138:1: ( ( RULE_LEXEME ) )
            // InternalEncodingUiTestLanguage.g:139:1: ( RULE_LEXEME )
            {
            // InternalEncodingUiTestLanguage.g:139:1: ( RULE_LEXEME )
            // InternalEncodingUiTestLanguage.g:140:1: RULE_LEXEME
            {
             before(grammarAccess.getWordAccess().getValueLEXEMETerminalRuleCall_0()); 
            match(input,RULE_LEXEME,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWordAccess().getValueLEXEMETerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Word__ValueAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    }


}
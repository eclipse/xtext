package org.eclipse.xtext.ui.tests.editor.encoding.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
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
    public static final int RULE_LEXEME=4;
    public static final int RULE_ANY_OTHER=6;
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
    // InternalEncodingUiTestLanguage.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalEncodingUiTestLanguage.g:54:1: ( ruleModel EOF )
            // InternalEncodingUiTestLanguage.g:55:1: ruleModel EOF
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
    // InternalEncodingUiTestLanguage.g:62:1: ruleModel : ( ( rule__Model__WordsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEncodingUiTestLanguage.g:66:2: ( ( ( rule__Model__WordsAssignment )* ) )
            // InternalEncodingUiTestLanguage.g:67:2: ( ( rule__Model__WordsAssignment )* )
            {
            // InternalEncodingUiTestLanguage.g:67:2: ( ( rule__Model__WordsAssignment )* )
            // InternalEncodingUiTestLanguage.g:68:3: ( rule__Model__WordsAssignment )*
            {
             before(grammarAccess.getModelAccess().getWordsAssignment()); 
            // InternalEncodingUiTestLanguage.g:69:3: ( rule__Model__WordsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_LEXEME) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalEncodingUiTestLanguage.g:69:4: rule__Model__WordsAssignment
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
    // InternalEncodingUiTestLanguage.g:78:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalEncodingUiTestLanguage.g:79:1: ( ruleWord EOF )
            // InternalEncodingUiTestLanguage.g:80:1: ruleWord EOF
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
    // InternalEncodingUiTestLanguage.g:87:1: ruleWord : ( ( rule__Word__ValueAssignment ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEncodingUiTestLanguage.g:91:2: ( ( ( rule__Word__ValueAssignment ) ) )
            // InternalEncodingUiTestLanguage.g:92:2: ( ( rule__Word__ValueAssignment ) )
            {
            // InternalEncodingUiTestLanguage.g:92:2: ( ( rule__Word__ValueAssignment ) )
            // InternalEncodingUiTestLanguage.g:93:3: ( rule__Word__ValueAssignment )
            {
             before(grammarAccess.getWordAccess().getValueAssignment()); 
            // InternalEncodingUiTestLanguage.g:94:3: ( rule__Word__ValueAssignment )
            // InternalEncodingUiTestLanguage.g:94:4: rule__Word__ValueAssignment
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
    // InternalEncodingUiTestLanguage.g:102:1: rule__Model__WordsAssignment : ( ruleWord ) ;
    public final void rule__Model__WordsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEncodingUiTestLanguage.g:106:1: ( ( ruleWord ) )
            // InternalEncodingUiTestLanguage.g:107:2: ( ruleWord )
            {
            // InternalEncodingUiTestLanguage.g:107:2: ( ruleWord )
            // InternalEncodingUiTestLanguage.g:108:3: ruleWord
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
    // InternalEncodingUiTestLanguage.g:117:1: rule__Word__ValueAssignment : ( RULE_LEXEME ) ;
    public final void rule__Word__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEncodingUiTestLanguage.g:121:1: ( ( RULE_LEXEME ) )
            // InternalEncodingUiTestLanguage.g:122:2: ( RULE_LEXEME )
            {
            // InternalEncodingUiTestLanguage.g:122:2: ( RULE_LEXEME )
            // InternalEncodingUiTestLanguage.g:123:3: RULE_LEXEME
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
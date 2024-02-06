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

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
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
    // InternalEncodingUiTestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalEncodingUiTestLanguage.g:59:1: ( ruleModel EOF )
            // InternalEncodingUiTestLanguage.g:60:1: ruleModel EOF
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
    // InternalEncodingUiTestLanguage.g:67:1: ruleModel : ( ( rule__Model__WordsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEncodingUiTestLanguage.g:71:2: ( ( ( rule__Model__WordsAssignment )* ) )
            // InternalEncodingUiTestLanguage.g:72:2: ( ( rule__Model__WordsAssignment )* )
            {
            // InternalEncodingUiTestLanguage.g:72:2: ( ( rule__Model__WordsAssignment )* )
            // InternalEncodingUiTestLanguage.g:73:3: ( rule__Model__WordsAssignment )*
            {
             before(grammarAccess.getModelAccess().getWordsAssignment()); 
            // InternalEncodingUiTestLanguage.g:74:3: ( rule__Model__WordsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_LEXEME) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalEncodingUiTestLanguage.g:74:4: rule__Model__WordsAssignment
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
    // InternalEncodingUiTestLanguage.g:83:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalEncodingUiTestLanguage.g:84:1: ( ruleWord EOF )
            // InternalEncodingUiTestLanguage.g:85:1: ruleWord EOF
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
    // InternalEncodingUiTestLanguage.g:92:1: ruleWord : ( ( rule__Word__ValueAssignment ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEncodingUiTestLanguage.g:96:2: ( ( ( rule__Word__ValueAssignment ) ) )
            // InternalEncodingUiTestLanguage.g:97:2: ( ( rule__Word__ValueAssignment ) )
            {
            // InternalEncodingUiTestLanguage.g:97:2: ( ( rule__Word__ValueAssignment ) )
            // InternalEncodingUiTestLanguage.g:98:3: ( rule__Word__ValueAssignment )
            {
             before(grammarAccess.getWordAccess().getValueAssignment()); 
            // InternalEncodingUiTestLanguage.g:99:3: ( rule__Word__ValueAssignment )
            // InternalEncodingUiTestLanguage.g:99:4: rule__Word__ValueAssignment
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
    // InternalEncodingUiTestLanguage.g:107:1: rule__Model__WordsAssignment : ( ruleWord ) ;
    public final void rule__Model__WordsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEncodingUiTestLanguage.g:111:1: ( ( ruleWord ) )
            // InternalEncodingUiTestLanguage.g:112:2: ( ruleWord )
            {
            // InternalEncodingUiTestLanguage.g:112:2: ( ruleWord )
            // InternalEncodingUiTestLanguage.g:113:3: ruleWord
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
    // InternalEncodingUiTestLanguage.g:122:1: rule__Word__ValueAssignment : ( RULE_LEXEME ) ;
    public final void rule__Word__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEncodingUiTestLanguage.g:126:1: ( ( RULE_LEXEME ) )
            // InternalEncodingUiTestLanguage.g:127:2: ( RULE_LEXEME )
            {
            // InternalEncodingUiTestLanguage.g:127:2: ( RULE_LEXEME )
            // InternalEncodingUiTestLanguage.g:128:3: RULE_LEXEME
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
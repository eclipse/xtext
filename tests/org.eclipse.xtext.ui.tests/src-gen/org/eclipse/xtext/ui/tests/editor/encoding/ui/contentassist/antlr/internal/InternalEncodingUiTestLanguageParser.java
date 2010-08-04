package org.eclipse.xtext.ui.tests.editor.encoding.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
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

        public InternalEncodingUiTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g"; }


     
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




    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:63:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel68); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:70:1: ruleModel : ( ( rule__Model__WordsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:74:2: ( ( ( rule__Model__WordsAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:75:1: ( ( rule__Model__WordsAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:75:1: ( ( rule__Model__WordsAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:76:1: ( rule__Model__WordsAssignment )*
            {
             before(grammarAccess.getModelAccess().getWordsAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:77:1: ( rule__Model__WordsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_LEXEME) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:77:2: rule__Model__WordsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__WordsAssignment_in_ruleModel94);
            	    rule__Model__WordsAssignment();
            	    _fsp--;


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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleWord
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:89:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:90:1: ( ruleWord EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:91:1: ruleWord EOF
            {
             before(grammarAccess.getWordRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWord_in_entryRuleWord122);
            ruleWord();
            _fsp--;

             after(grammarAccess.getWordRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWord129); 

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
    // $ANTLR end entryRuleWord


    // $ANTLR start ruleWord
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:98:1: ruleWord : ( ( rule__Word__ValueAssignment ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:102:2: ( ( ( rule__Word__ValueAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:103:1: ( ( rule__Word__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:103:1: ( ( rule__Word__ValueAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:104:1: ( rule__Word__ValueAssignment )
            {
             before(grammarAccess.getWordAccess().getValueAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:105:1: ( rule__Word__ValueAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:105:2: rule__Word__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Word__ValueAssignment_in_ruleWord155);
            rule__Word__ValueAssignment();
            _fsp--;


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
    // $ANTLR end ruleWord


    // $ANTLR start rule__Model__WordsAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:120:1: rule__Model__WordsAssignment : ( ruleWord ) ;
    public final void rule__Model__WordsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:124:1: ( ( ruleWord ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:125:1: ( ruleWord )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:125:1: ( ruleWord )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:126:1: ruleWord
            {
             before(grammarAccess.getModelAccess().getWordsWordParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleWord_in_rule__Model__WordsAssignment194);
            ruleWord();
            _fsp--;

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
    // $ANTLR end rule__Model__WordsAssignment


    // $ANTLR start rule__Word__ValueAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:135:1: rule__Word__ValueAssignment : ( RULE_LEXEME ) ;
    public final void rule__Word__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:139:1: ( ( RULE_LEXEME ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:140:1: ( RULE_LEXEME )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:140:1: ( RULE_LEXEME )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingUiTestLanguage.g:141:1: RULE_LEXEME
            {
             before(grammarAccess.getWordAccess().getValueLEXEMETerminalRuleCall_0()); 
            match(input,RULE_LEXEME,FollowSets000.FOLLOW_RULE_LEXEME_in_rule__Word__ValueAssignment225); 
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
    // $ANTLR end rule__Word__ValueAssignment


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__WordsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleWord_in_entryRuleWord122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWord129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Word__ValueAssignment_in_ruleWord155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWord_in_rule__Model__WordsAssignment194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LEXEME_in_rule__Word__ValueAssignment225 = new BitSet(new long[]{0x0000000000000002L});
    }


}
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
import org.eclipse.xtext.ui.tests.editor.encoding.services.EncodingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEncodingTestLanguageParser extends AbstractInternalContentAssistParser {
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g"; }


     
     	private EncodingTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(EncodingTestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:63:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:70:1: ruleModel : ( ( rule__Model__WordsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:74:2: ( ( ( rule__Model__WordsAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:75:1: ( ( rule__Model__WordsAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:75:1: ( ( rule__Model__WordsAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:76:1: ( rule__Model__WordsAssignment )*
            {
             before(grammarAccess.getModelAccess().getWordsAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:77:1: ( rule__Model__WordsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_WORD) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:77:2: rule__Model__WordsAssignment
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


    // $ANTLR start rule__Model__WordsAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:92:1: rule__Model__WordsAssignment : ( RULE_WORD ) ;
    public final void rule__Model__WordsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:96:1: ( ( RULE_WORD ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:97:1: ( RULE_WORD )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:97:1: ( RULE_WORD )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/encoding/ui/contentassist/antlr/internal/InternalEncodingTestLanguage.g:98:1: RULE_WORD
            {
             before(grammarAccess.getModelAccess().getWordsWORDTerminalRuleCall_0()); 
            match(input,RULE_WORD,FollowSets000.FOLLOW_RULE_WORD_in_rule__Model__WordsAssignment134); 
             after(grammarAccess.getModelAccess().getWordsWORDTerminalRuleCall_0()); 

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__WordsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_WORD_in_rule__Model__WordsAssignment134 = new BitSet(new long[]{0x0000000000000002L});
    }


}
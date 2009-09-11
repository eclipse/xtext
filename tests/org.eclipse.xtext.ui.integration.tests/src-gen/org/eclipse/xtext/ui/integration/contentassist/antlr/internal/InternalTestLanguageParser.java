package org.eclipse.xtext.ui.integration.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.integration.services.TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'stuff'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g"; }


     
     	private TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(TestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleFile
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:60:1: entryRuleFile : ruleFile EOF ;
    public final void entryRuleFile() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:60:15: ( ruleFile EOF )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:61:1: ruleFile EOF
            {
             before(grammarAccess.getFileRule()); 
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile60);
            ruleFile();
            _fsp--;

             after(grammarAccess.getFileRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile67); 

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
    // $ANTLR end entryRuleFile


    // $ANTLR start ruleFile
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:68:1: ruleFile : ( ( rule__File__StuffAssignment )* ) ;
    public final void ruleFile() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:72:2: ( ( ( rule__File__StuffAssignment )* ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:73:1: ( ( rule__File__StuffAssignment )* )
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:73:1: ( ( rule__File__StuffAssignment )* )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:74:1: ( rule__File__StuffAssignment )*
            {
             before(grammarAccess.getFileAccess().getStuffAssignment()); 
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:75:1: ( rule__File__StuffAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:75:2: rule__File__StuffAssignment
            	    {
            	    pushFollow(FOLLOW_rule__File__StuffAssignment_in_ruleFile94);
            	    rule__File__StuffAssignment();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getFileAccess().getStuffAssignment()); 

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
    // $ANTLR end ruleFile


    // $ANTLR start entryRuleStuff
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:87:1: entryRuleStuff : ruleStuff EOF ;
    public final void entryRuleStuff() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:87:16: ( ruleStuff EOF )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:88:1: ruleStuff EOF
            {
             before(grammarAccess.getStuffRule()); 
            pushFollow(FOLLOW_ruleStuff_in_entryRuleStuff121);
            ruleStuff();
            _fsp--;

             after(grammarAccess.getStuffRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStuff128); 

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
    // $ANTLR end entryRuleStuff


    // $ANTLR start ruleStuff
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:95:1: ruleStuff : ( ( rule__Stuff__Group__0 ) ) ;
    public final void ruleStuff() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:99:2: ( ( ( rule__Stuff__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:100:1: ( ( rule__Stuff__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:100:1: ( ( rule__Stuff__Group__0 ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:101:1: ( rule__Stuff__Group__0 )
            {
             before(grammarAccess.getStuffAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:102:1: ( rule__Stuff__Group__0 )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:102:2: rule__Stuff__Group__0
            {
            pushFollow(FOLLOW_rule__Stuff__Group__0_in_ruleStuff155);
            rule__Stuff__Group__0();
            _fsp--;


            }

             after(grammarAccess.getStuffAccess().getGroup()); 

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
    // $ANTLR end ruleStuff


    // $ANTLR start rule__Stuff__Group__0
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:116:1: rule__Stuff__Group__0 : ( 'stuff' ) rule__Stuff__Group__1 ;
    public final void rule__Stuff__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:120:1: ( ( 'stuff' ) rule__Stuff__Group__1 )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:121:1: ( 'stuff' ) rule__Stuff__Group__1
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:121:1: ( 'stuff' )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:122:1: 'stuff'
            {
             before(grammarAccess.getStuffAccess().getStuffKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Stuff__Group__0194); 
             after(grammarAccess.getStuffAccess().getStuffKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Stuff__Group__1_in_rule__Stuff__Group__0204);
            rule__Stuff__Group__1();
            _fsp--;


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
    // $ANTLR end rule__Stuff__Group__0


    // $ANTLR start rule__Stuff__Group__1
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:136:1: rule__Stuff__Group__1 : ( ( rule__Stuff__NameAssignment_1 ) ) ;
    public final void rule__Stuff__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:140:1: ( ( ( rule__Stuff__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:141:1: ( ( rule__Stuff__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:141:1: ( ( rule__Stuff__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:142:1: ( rule__Stuff__NameAssignment_1 )
            {
             before(grammarAccess.getStuffAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:143:1: ( rule__Stuff__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:143:2: rule__Stuff__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Stuff__NameAssignment_1_in_rule__Stuff__Group__1232);
            rule__Stuff__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getStuffAccess().getNameAssignment_1()); 

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
    // $ANTLR end rule__Stuff__Group__1


    // $ANTLR start rule__File__StuffAssignment
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:157:1: rule__File__StuffAssignment : ( ruleStuff ) ;
    public final void rule__File__StuffAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:161:1: ( ( ruleStuff ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:162:1: ( ruleStuff )
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:162:1: ( ruleStuff )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:163:1: ruleStuff
            {
             before(grammarAccess.getFileAccess().getStuffStuffParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleStuff_in_rule__File__StuffAssignment270);
            ruleStuff();
            _fsp--;

             after(grammarAccess.getFileAccess().getStuffStuffParserRuleCall_0()); 

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
    // $ANTLR end rule__File__StuffAssignment


    // $ANTLR start rule__Stuff__NameAssignment_1
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:172:1: rule__Stuff__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Stuff__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:176:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:177:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:177:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/contentassist/antlr/internal/InternalTestLanguage.g:178:1: RULE_ID
            {
             before(grammarAccess.getStuffAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Stuff__NameAssignment_1301); 
             after(grammarAccess.getStuffAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end rule__Stuff__NameAssignment_1


 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__File__StuffAssignment_in_ruleFile94 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleStuff_in_entryRuleStuff121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStuff128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stuff__Group__0_in_ruleStuff155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Stuff__Group__0194 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stuff__Group__1_in_rule__Stuff__Group__0204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stuff__NameAssignment_1_in_rule__Stuff__Group__1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStuff_in_rule__File__StuffAssignment270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Stuff__NameAssignment_1301 = new BitSet(new long[]{0x0000000000000002L});

}
package org.eclipse.xtext.ui.tests.linking.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.linking.services.ImportUriUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalImportUriUiTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'extends'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalImportUriUiTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g"; }


     
     	private ImportUriUiTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ImportUriUiTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleMain
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:61:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:62:1: ( ruleMain EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:63:1: ruleMain EOF
            {
             before(grammarAccess.getMainRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMain_in_entryRuleMain61);
            ruleMain();
            _fsp--;

             after(grammarAccess.getMainRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMain68); 

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
    // $ANTLR end entryRuleMain


    // $ANTLR start ruleMain
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:70:1: ruleMain : ( ( rule__Main__Group__0 ) ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:74:2: ( ( ( rule__Main__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:75:1: ( ( rule__Main__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:75:1: ( ( rule__Main__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:76:1: ( rule__Main__Group__0 )
            {
             before(grammarAccess.getMainAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:77:1: ( rule__Main__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:77:2: rule__Main__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Main__Group__0_in_ruleMain94);
            rule__Main__Group__0();
            _fsp--;


            }

             after(grammarAccess.getMainAccess().getGroup()); 

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
    // $ANTLR end ruleMain


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:89:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:90:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:91:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport121);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport128); 

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
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:98:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:102:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:103:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:103:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:104:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:105:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:105:2: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0_in_ruleImport154);
            rule__Import__Group__0();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:117:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:118:1: ( ruleType EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:119:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType181);
            ruleType();
            _fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType188); 

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
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:126:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:130:2: ( ( ( rule__Type__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:131:1: ( ( rule__Type__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:131:1: ( ( rule__Type__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:132:1: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:133:1: ( rule__Type__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:133:2: rule__Type__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__0_in_ruleType214);
            rule__Type__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTypeAccess().getGroup()); 

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
    // $ANTLR end ruleType


    // $ANTLR start rule__Main__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:147:1: rule__Main__Group__0 : ( ( rule__Main__ImportsAssignment_0 )* ) rule__Main__Group__1 ;
    public final void rule__Main__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:151:1: ( ( ( rule__Main__ImportsAssignment_0 )* ) rule__Main__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:152:1: ( ( rule__Main__ImportsAssignment_0 )* ) rule__Main__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:152:1: ( ( rule__Main__ImportsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:153:1: ( rule__Main__ImportsAssignment_0 )*
            {
             before(grammarAccess.getMainAccess().getImportsAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:154:1: ( rule__Main__ImportsAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:154:2: rule__Main__ImportsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Main__ImportsAssignment_0_in_rule__Main__Group__0252);
            	    rule__Main__ImportsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getMainAccess().getImportsAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Main__Group__1_in_rule__Main__Group__0262);
            rule__Main__Group__1();
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
    // $ANTLR end rule__Main__Group__0


    // $ANTLR start rule__Main__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:165:1: rule__Main__Group__1 : ( ( rule__Main__TypesAssignment_1 )* ) ;
    public final void rule__Main__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:169:1: ( ( ( rule__Main__TypesAssignment_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:170:1: ( ( rule__Main__TypesAssignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:170:1: ( ( rule__Main__TypesAssignment_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:171:1: ( rule__Main__TypesAssignment_1 )*
            {
             before(grammarAccess.getMainAccess().getTypesAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:172:1: ( rule__Main__TypesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:172:2: rule__Main__TypesAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Main__TypesAssignment_1_in_rule__Main__Group__1290);
            	    rule__Main__TypesAssignment_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getMainAccess().getTypesAssignment_1()); 

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
    // $ANTLR end rule__Main__Group__1


    // $ANTLR start rule__Import__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:186:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:190:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:191:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:191:1: ( 'import' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:192:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Import__Group__0330); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0340);
            rule__Import__Group__1();
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
    // $ANTLR end rule__Import__Group__0


    // $ANTLR start rule__Import__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:206:1: rule__Import__Group__1 : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:210:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:211:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:211:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:212:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:213:1: ( rule__Import__ImportURIAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:213:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1368);
            rule__Import__ImportURIAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

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
    // $ANTLR end rule__Import__Group__1


    // $ANTLR start rule__Type__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:227:1: rule__Type__Group__0 : ( 'type' ) rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:231:1: ( ( 'type' ) rule__Type__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:232:1: ( 'type' ) rule__Type__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:232:1: ( 'type' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:233:1: 'type'
            {
             before(grammarAccess.getTypeAccess().getTypeKeyword_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Type__Group__0407); 
             after(grammarAccess.getTypeAccess().getTypeKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__1_in_rule__Type__Group__0417);
            rule__Type__Group__1();
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
    // $ANTLR end rule__Type__Group__0


    // $ANTLR start rule__Type__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:247:1: rule__Type__Group__1 : ( ( rule__Type__NameAssignment_1 ) ) rule__Type__Group__2 ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:251:1: ( ( ( rule__Type__NameAssignment_1 ) ) rule__Type__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:252:1: ( ( rule__Type__NameAssignment_1 ) ) rule__Type__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:252:1: ( ( rule__Type__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:253:1: ( rule__Type__NameAssignment_1 )
            {
             before(grammarAccess.getTypeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:254:1: ( rule__Type__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:254:2: rule__Type__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__NameAssignment_1_in_rule__Type__Group__1445);
            rule__Type__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTypeAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__2_in_rule__Type__Group__1454);
            rule__Type__Group__2();
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
    // $ANTLR end rule__Type__Group__1


    // $ANTLR start rule__Type__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:265:1: rule__Type__Group__2 : ( 'extends' ) rule__Type__Group__3 ;
    public final void rule__Type__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:269:1: ( ( 'extends' ) rule__Type__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:270:1: ( 'extends' ) rule__Type__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:270:1: ( 'extends' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:271:1: 'extends'
            {
             before(grammarAccess.getTypeAccess().getExtendsKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Type__Group__2483); 
             after(grammarAccess.getTypeAccess().getExtendsKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__3_in_rule__Type__Group__2493);
            rule__Type__Group__3();
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
    // $ANTLR end rule__Type__Group__2


    // $ANTLR start rule__Type__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:285:1: rule__Type__Group__3 : ( ( rule__Type__ExtendsAssignment_3 ) ) ;
    public final void rule__Type__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:289:1: ( ( ( rule__Type__ExtendsAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:290:1: ( ( rule__Type__ExtendsAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:290:1: ( ( rule__Type__ExtendsAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:291:1: ( rule__Type__ExtendsAssignment_3 )
            {
             before(grammarAccess.getTypeAccess().getExtendsAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:292:1: ( rule__Type__ExtendsAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:292:2: rule__Type__ExtendsAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__ExtendsAssignment_3_in_rule__Type__Group__3521);
            rule__Type__ExtendsAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getTypeAccess().getExtendsAssignment_3()); 

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
    // $ANTLR end rule__Type__Group__3


    // $ANTLR start rule__Main__ImportsAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:311:1: rule__Main__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Main__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:315:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:316:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:316:1: ( ruleImport )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:317:1: ruleImport
            {
             before(grammarAccess.getMainAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_rule__Main__ImportsAssignment_0564);
            ruleImport();
            _fsp--;

             after(grammarAccess.getMainAccess().getImportsImportParserRuleCall_0_0()); 

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
    // $ANTLR end rule__Main__ImportsAssignment_0


    // $ANTLR start rule__Main__TypesAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:326:1: rule__Main__TypesAssignment_1 : ( ruleType ) ;
    public final void rule__Main__TypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:330:1: ( ( ruleType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:331:1: ( ruleType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:331:1: ( ruleType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:332:1: ruleType
            {
             before(grammarAccess.getMainAccess().getTypesTypeParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_rule__Main__TypesAssignment_1595);
            ruleType();
            _fsp--;

             after(grammarAccess.getMainAccess().getTypesTypeParserRuleCall_1_0()); 

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
    // $ANTLR end rule__Main__TypesAssignment_1


    // $ANTLR start rule__Import__ImportURIAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:341:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:345:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:346:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:346:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:347:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_1626); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end rule__Import__ImportURIAssignment_1


    // $ANTLR start rule__Type__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:356:1: rule__Type__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Type__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:360:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:361:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:361:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:362:1: RULE_ID
            {
             before(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Type__NameAssignment_1657); 
             after(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end rule__Type__NameAssignment_1


    // $ANTLR start rule__Type__ExtendsAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:371:1: rule__Type__ExtendsAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Type__ExtendsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:375:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:376:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:376:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:377:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:378:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/linking/ui/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:379:1: RULE_ID
            {
             before(grammarAccess.getTypeAccess().getExtendsTypeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Type__ExtendsAssignment_3692); 
             after(grammarAccess.getTypeAccess().getExtendsTypeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0()); 

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
    // $ANTLR end rule__Type__ExtendsAssignment_3


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMain_in_entryRuleMain61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMain68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Main__Group__0_in_ruleMain94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group__0_in_ruleType214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Main__ImportsAssignment_0_in_rule__Main__Group__0252 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_rule__Main__Group__1_in_rule__Main__Group__0262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Main__TypesAssignment_1_in_rule__Main__Group__1290 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_11_in_rule__Import__Group__0330 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Type__Group__0407 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Type__Group__1_in_rule__Type__Group__0417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__NameAssignment_1_in_rule__Type__Group__1445 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Type__Group__2_in_rule__Type__Group__1454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Type__Group__2483 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Type__Group__3_in_rule__Type__Group__2493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__ExtendsAssignment_3_in_rule__Type__Group__3521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_rule__Main__ImportsAssignment_0564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_rule__Main__TypesAssignment_1595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_1626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Type__NameAssignment_1657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Type__ExtendsAssignment_3692 = new BitSet(new long[]{0x0000000000000002L});
    }


}
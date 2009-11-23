package org.eclipse.xtext.linking.contentassist.antlr.internal; 

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
import org.eclipse.xtext.linking.services.ImportUriUiTestLanguageGrammarAccess;



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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:60:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:60:15: ( ruleMain EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:61:1: ruleMain EOF
            {
             before(grammarAccess.getMainRule()); 
            pushFollow(FOLLOW_ruleMain_in_entryRuleMain60);
            ruleMain();
            _fsp--;

             after(grammarAccess.getMainRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMain67); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:68:1: ruleMain : ( ( rule__Main__Group__0 ) ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:72:2: ( ( ( rule__Main__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:73:1: ( ( rule__Main__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:73:1: ( ( rule__Main__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:74:1: ( rule__Main__Group__0 )
            {
             before(grammarAccess.getMainAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:75:1: ( rule__Main__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:75:2: rule__Main__Group__0
            {
            pushFollow(FOLLOW_rule__Main__Group__0_in_ruleMain94);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:87:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:87:17: ( ruleImport EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:88:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport120);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport127); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:95:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:99:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:100:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:100:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:101:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:102:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:102:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport154);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:114:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:114:15: ( ruleType EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:115:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType180);
            ruleType();
            _fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType187); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:122:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:126:2: ( ( ( rule__Type__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:127:1: ( ( rule__Type__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:127:1: ( ( rule__Type__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:128:1: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:129:1: ( rule__Type__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:129:2: rule__Type__Group__0
            {
            pushFollow(FOLLOW_rule__Type__Group__0_in_ruleType214);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:143:1: rule__Main__Group__0 : ( ( rule__Main__ImportsAssignment_0 )* ) rule__Main__Group__1 ;
    public final void rule__Main__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:147:1: ( ( ( rule__Main__ImportsAssignment_0 )* ) rule__Main__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:148:1: ( ( rule__Main__ImportsAssignment_0 )* ) rule__Main__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:148:1: ( ( rule__Main__ImportsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:149:1: ( rule__Main__ImportsAssignment_0 )*
            {
             before(grammarAccess.getMainAccess().getImportsAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:150:1: ( rule__Main__ImportsAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:150:2: rule__Main__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Main__ImportsAssignment_0_in_rule__Main__Group__0252);
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

            pushFollow(FOLLOW_rule__Main__Group__1_in_rule__Main__Group__0262);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:161:1: rule__Main__Group__1 : ( ( rule__Main__TypesAssignment_1 )* ) ;
    public final void rule__Main__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:165:1: ( ( ( rule__Main__TypesAssignment_1 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:166:1: ( ( rule__Main__TypesAssignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:166:1: ( ( rule__Main__TypesAssignment_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:167:1: ( rule__Main__TypesAssignment_1 )*
            {
             before(grammarAccess.getMainAccess().getTypesAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:168:1: ( rule__Main__TypesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:168:2: rule__Main__TypesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Main__TypesAssignment_1_in_rule__Main__Group__1290);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:182:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:186:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:187:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:187:1: ( 'import' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:188:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Import__Group__0330); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0340);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:202:1: rule__Import__Group__1 : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:206:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:207:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:207:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:208:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:209:1: ( rule__Import__ImportURIAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:209:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1368);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:223:1: rule__Type__Group__0 : ( 'type' ) rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:227:1: ( ( 'type' ) rule__Type__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:228:1: ( 'type' ) rule__Type__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:228:1: ( 'type' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:229:1: 'type'
            {
             before(grammarAccess.getTypeAccess().getTypeKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__Type__Group__0407); 
             after(grammarAccess.getTypeAccess().getTypeKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Type__Group__1_in_rule__Type__Group__0417);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:243:1: rule__Type__Group__1 : ( ( rule__Type__NameAssignment_1 ) ) rule__Type__Group__2 ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:247:1: ( ( ( rule__Type__NameAssignment_1 ) ) rule__Type__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:248:1: ( ( rule__Type__NameAssignment_1 ) ) rule__Type__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:248:1: ( ( rule__Type__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:249:1: ( rule__Type__NameAssignment_1 )
            {
             before(grammarAccess.getTypeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:250:1: ( rule__Type__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:250:2: rule__Type__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Type__NameAssignment_1_in_rule__Type__Group__1445);
            rule__Type__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTypeAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Type__Group__2_in_rule__Type__Group__1454);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:261:1: rule__Type__Group__2 : ( 'extends' ) rule__Type__Group__3 ;
    public final void rule__Type__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:265:1: ( ( 'extends' ) rule__Type__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:266:1: ( 'extends' ) rule__Type__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:266:1: ( 'extends' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:267:1: 'extends'
            {
             before(grammarAccess.getTypeAccess().getExtendsKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__Type__Group__2483); 
             after(grammarAccess.getTypeAccess().getExtendsKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__Type__Group__3_in_rule__Type__Group__2493);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:281:1: rule__Type__Group__3 : ( ( rule__Type__ExtendsAssignment_3 ) ) ;
    public final void rule__Type__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:285:1: ( ( ( rule__Type__ExtendsAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:286:1: ( ( rule__Type__ExtendsAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:286:1: ( ( rule__Type__ExtendsAssignment_3 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:287:1: ( rule__Type__ExtendsAssignment_3 )
            {
             before(grammarAccess.getTypeAccess().getExtendsAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:288:1: ( rule__Type__ExtendsAssignment_3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:288:2: rule__Type__ExtendsAssignment_3
            {
            pushFollow(FOLLOW_rule__Type__ExtendsAssignment_3_in_rule__Type__Group__3521);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:306:1: rule__Main__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Main__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:310:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:311:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:311:1: ( ruleImport )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:312:1: ruleImport
            {
             before(grammarAccess.getMainAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Main__ImportsAssignment_0563);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:321:1: rule__Main__TypesAssignment_1 : ( ruleType ) ;
    public final void rule__Main__TypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:325:1: ( ( ruleType ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:326:1: ( ruleType )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:326:1: ( ruleType )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:327:1: ruleType
            {
             before(grammarAccess.getMainAccess().getTypesTypeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleType_in_rule__Main__TypesAssignment_1594);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:336:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:340:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:341:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:341:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:342:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_1625); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:351:1: rule__Type__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Type__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:355:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:356:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:356:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:357:1: RULE_ID
            {
             before(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Type__NameAssignment_1656); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:366:1: rule__Type__ExtendsAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Type__ExtendsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:370:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:371:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:371:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:372:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:373:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:374:1: RULE_ID
            {
             before(grammarAccess.getTypeAccess().getExtendsTypeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Type__ExtendsAssignment_3691); 
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


 

    public static final BitSet FOLLOW_ruleMain_in_entryRuleMain60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMain67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Main__Group__0_in_ruleMain94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType187 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_ruleImport_in_rule__Main__ImportsAssignment_0563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Main__TypesAssignment_1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Type__NameAssignment_1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Type__ExtendsAssignment_3691 = new BitSet(new long[]{0x0000000000000002L});

}
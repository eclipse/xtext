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
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:61:1: ( ruleMain EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:62:1: ruleMain EOF
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:69:1: ruleMain : ( ( rule__Main__Group__0 ) ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:73:2: ( ( ( rule__Main__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:74:1: ( ( rule__Main__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:74:1: ( ( rule__Main__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:75:1: ( rule__Main__Group__0 )
            {
             before(grammarAccess.getMainAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:76:1: ( rule__Main__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:76:2: rule__Main__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Main__Group__0_in_ruleMain95);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:88:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:89:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:90:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport122);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport129); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:97:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:101:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:102:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:102:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:103:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:104:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:104:2: rule__Import__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__0_in_ruleImport156);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:116:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:117:1: ( ruleType EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:118:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType183);
            ruleType();
            _fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType190); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:125:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:129:2: ( ( ( rule__Type__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:130:1: ( ( rule__Type__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:130:1: ( ( rule__Type__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:131:1: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:132:1: ( rule__Type__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:132:2: rule__Type__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__0_in_ruleType217);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:146:1: rule__Main__Group__0 : ( ( rule__Main__ImportsAssignment_0 )* ) rule__Main__Group__1 ;
    public final void rule__Main__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:150:1: ( ( ( rule__Main__ImportsAssignment_0 )* ) rule__Main__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:151:1: ( ( rule__Main__ImportsAssignment_0 )* ) rule__Main__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:151:1: ( ( rule__Main__ImportsAssignment_0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:152:1: ( rule__Main__ImportsAssignment_0 )*
            {
             before(grammarAccess.getMainAccess().getImportsAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:153:1: ( rule__Main__ImportsAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:153:2: rule__Main__ImportsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Main__ImportsAssignment_0_in_rule__Main__Group__0255);
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

            pushFollow(FollowSets000.FOLLOW_rule__Main__Group__1_in_rule__Main__Group__0265);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:164:1: rule__Main__Group__1 : ( ( rule__Main__TypesAssignment_1 )* ) ;
    public final void rule__Main__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:168:1: ( ( ( rule__Main__TypesAssignment_1 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:169:1: ( ( rule__Main__TypesAssignment_1 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:169:1: ( ( rule__Main__TypesAssignment_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:170:1: ( rule__Main__TypesAssignment_1 )*
            {
             before(grammarAccess.getMainAccess().getTypesAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:171:1: ( rule__Main__TypesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:171:2: rule__Main__TypesAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Main__TypesAssignment_1_in_rule__Main__Group__1293);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:185:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:189:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:190:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:190:1: ( 'import' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:191:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Import__Group__0333); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0343);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:205:1: rule__Import__Group__1 : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:209:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:210:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:210:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:211:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:212:1: ( rule__Import__ImportURIAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:212:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1371);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:226:1: rule__Type__Group__0 : ( 'type' ) rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:230:1: ( ( 'type' ) rule__Type__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:231:1: ( 'type' ) rule__Type__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:231:1: ( 'type' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:232:1: 'type'
            {
             before(grammarAccess.getTypeAccess().getTypeKeyword_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Type__Group__0410); 
             after(grammarAccess.getTypeAccess().getTypeKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__1_in_rule__Type__Group__0420);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:246:1: rule__Type__Group__1 : ( ( rule__Type__NameAssignment_1 ) ) rule__Type__Group__2 ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:250:1: ( ( ( rule__Type__NameAssignment_1 ) ) rule__Type__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:251:1: ( ( rule__Type__NameAssignment_1 ) ) rule__Type__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:251:1: ( ( rule__Type__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:252:1: ( rule__Type__NameAssignment_1 )
            {
             before(grammarAccess.getTypeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:253:1: ( rule__Type__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:253:2: rule__Type__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__NameAssignment_1_in_rule__Type__Group__1448);
            rule__Type__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTypeAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__2_in_rule__Type__Group__1457);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:264:1: rule__Type__Group__2 : ( 'extends' ) rule__Type__Group__3 ;
    public final void rule__Type__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:268:1: ( ( 'extends' ) rule__Type__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:269:1: ( 'extends' ) rule__Type__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:269:1: ( 'extends' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:270:1: 'extends'
            {
             before(grammarAccess.getTypeAccess().getExtendsKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Type__Group__2486); 
             after(grammarAccess.getTypeAccess().getExtendsKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Type__Group__3_in_rule__Type__Group__2496);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:284:1: rule__Type__Group__3 : ( ( rule__Type__ExtendsAssignment_3 ) ) ;
    public final void rule__Type__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:288:1: ( ( ( rule__Type__ExtendsAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:289:1: ( ( rule__Type__ExtendsAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:289:1: ( ( rule__Type__ExtendsAssignment_3 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:290:1: ( rule__Type__ExtendsAssignment_3 )
            {
             before(grammarAccess.getTypeAccess().getExtendsAssignment_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:291:1: ( rule__Type__ExtendsAssignment_3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:291:2: rule__Type__ExtendsAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Type__ExtendsAssignment_3_in_rule__Type__Group__3524);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:309:1: rule__Main__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Main__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:313:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:314:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:314:1: ( ruleImport )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:315:1: ruleImport
            {
             before(grammarAccess.getMainAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_rule__Main__ImportsAssignment_0566);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:324:1: rule__Main__TypesAssignment_1 : ( ruleType ) ;
    public final void rule__Main__TypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:328:1: ( ( ruleType ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:329:1: ( ruleType )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:329:1: ( ruleType )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:330:1: ruleType
            {
             before(grammarAccess.getMainAccess().getTypesTypeParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_rule__Main__TypesAssignment_1597);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:339:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:343:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:344:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:344:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:345:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_1628); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:354:1: rule__Type__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Type__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:358:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:359:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:359:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:360:1: RULE_ID
            {
             before(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Type__NameAssignment_1659); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:369:1: rule__Type__ExtendsAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Type__ExtendsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:373:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:374:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:374:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:375:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:376:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/linking/contentassist/antlr/internal/InternalImportUriUiTestLanguage.g:377:1: RULE_ID
            {
             before(grammarAccess.getTypeAccess().getExtendsTypeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Type__ExtendsAssignment_3694); 
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
        public static final BitSet FOLLOW_rule__Main__Group__0_in_ruleMain95 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__Group__0_in_ruleType217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Main__ImportsAssignment_0_in_rule__Main__Group__0255 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_rule__Main__Group__1_in_rule__Main__Group__0265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Main__TypesAssignment_1_in_rule__Main__Group__1293 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_11_in_rule__Import__Group__0333 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Type__Group__0410 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Type__Group__1_in_rule__Type__Group__0420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__NameAssignment_1_in_rule__Type__Group__1448 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Type__Group__2_in_rule__Type__Group__1457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Type__Group__2486 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Type__Group__3_in_rule__Type__Group__2496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Type__ExtendsAssignment_3_in_rule__Type__Group__3524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_rule__Main__ImportsAssignment_0566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_rule__Main__TypesAssignment_1597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_1628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Type__NameAssignment_1659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Type__ExtendsAssignment_3694 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.ui.tests.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.services.XtextGrammarUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextGrammarUiTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'?'", "'*'", "'+'", "'='", "'+='", "'?='", "'grammar'", "'with'", "','", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "':'", "';'", "'returns'", "'::'", "'|'", "'{'", "'}'", "'current'", "'['", "']'", "'terminal'", "'!'", "'->'", "'..'", "'enum'", "'hidden'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalXtextGrammarUiTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g"; }


     
     	private XtextGrammarUiTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(XtextGrammarUiTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleGrammar
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:61:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:62:1: ( ruleGrammar EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:63:1: ruleGrammar EOF
            {
             before(grammarAccess.getGrammarRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammar_in_entryRuleGrammar61);
            ruleGrammar();
            _fsp--;

             after(grammarAccess.getGrammarRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammar68); 

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
    // $ANTLR end entryRuleGrammar


    // $ANTLR start ruleGrammar
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:70:1: ruleGrammar : ( ( rule__Grammar__Group__0 ) ) ;
    public final void ruleGrammar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:74:2: ( ( ( rule__Grammar__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:75:1: ( ( rule__Grammar__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:75:1: ( ( rule__Grammar__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:76:1: ( rule__Grammar__Group__0 )
            {
             before(grammarAccess.getGrammarAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:77:1: ( rule__Grammar__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:77:2: rule__Grammar__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__0_in_ruleGrammar94);
            rule__Grammar__Group__0();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getGroup()); 

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
    // $ANTLR end ruleGrammar


    // $ANTLR start entryRuleGrammarID
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:89:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:90:1: ( ruleGrammarID EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:91:1: ruleGrammarID EOF
            {
             before(grammarAccess.getGrammarIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_entryRuleGrammarID121);
            ruleGrammarID();
            _fsp--;

             after(grammarAccess.getGrammarIDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammarID128); 

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
    // $ANTLR end entryRuleGrammarID


    // $ANTLR start ruleGrammarID
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:98:1: ruleGrammarID : ( ( rule__GrammarID__Group__0 ) ) ;
    public final void ruleGrammarID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:102:2: ( ( ( rule__GrammarID__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:103:1: ( ( rule__GrammarID__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:103:1: ( ( rule__GrammarID__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:104:1: ( rule__GrammarID__Group__0 )
            {
             before(grammarAccess.getGrammarIDAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:105:1: ( rule__GrammarID__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:105:2: rule__GrammarID__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__0_in_ruleGrammarID154);
            rule__GrammarID__Group__0();
            _fsp--;


            }

             after(grammarAccess.getGrammarIDAccess().getGroup()); 

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
    // $ANTLR end ruleGrammarID


    // $ANTLR start entryRuleAbstractRule
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:117:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:118:1: ( ruleAbstractRule EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:119:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule181);
            ruleAbstractRule();
            _fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRule188); 

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
    // $ANTLR end entryRuleAbstractRule


    // $ANTLR start ruleAbstractRule
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:126:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:130:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:131:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:131:1: ( ( rule__AbstractRule__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:132:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:133:1: ( rule__AbstractRule__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:133:2: rule__AbstractRule__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule214);
            rule__AbstractRule__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getAbstractRuleAccess().getAlternatives()); 

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
    // $ANTLR end ruleAbstractRule


    // $ANTLR start entryRuleAbstractMetamodelDeclaration
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:145:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:146:1: ( ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:147:1: ruleAbstractMetamodelDeclaration EOF
            {
             before(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration241);
            ruleAbstractMetamodelDeclaration();
            _fsp--;

             after(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration248); 

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
    // $ANTLR end entryRuleAbstractMetamodelDeclaration


    // $ANTLR start ruleAbstractMetamodelDeclaration
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:154:1: ruleAbstractMetamodelDeclaration : ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:158:2: ( ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:159:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:159:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:160:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            {
             before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:161:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:161:2: rule__AbstractMetamodelDeclaration__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractMetamodelDeclaration__Alternatives_in_ruleAbstractMetamodelDeclaration274);
            rule__AbstractMetamodelDeclaration__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 

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
    // $ANTLR end ruleAbstractMetamodelDeclaration


    // $ANTLR start entryRuleGeneratedMetamodel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:173:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:174:1: ( ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:175:1: ruleGeneratedMetamodel EOF
            {
             before(grammarAccess.getGeneratedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel301);
            ruleGeneratedMetamodel();
            _fsp--;

             after(grammarAccess.getGeneratedMetamodelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGeneratedMetamodel308); 

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
    // $ANTLR end entryRuleGeneratedMetamodel


    // $ANTLR start ruleGeneratedMetamodel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:182:1: ruleGeneratedMetamodel : ( ( rule__GeneratedMetamodel__Group__0 ) ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:186:2: ( ( ( rule__GeneratedMetamodel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:187:1: ( ( rule__GeneratedMetamodel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:187:1: ( ( rule__GeneratedMetamodel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:188:1: ( rule__GeneratedMetamodel__Group__0 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:189:1: ( rule__GeneratedMetamodel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:189:2: rule__GeneratedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__0_in_ruleGeneratedMetamodel334);
            rule__GeneratedMetamodel__Group__0();
            _fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 

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
    // $ANTLR end ruleGeneratedMetamodel


    // $ANTLR start entryRuleReferencedMetamodel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:201:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:202:1: ( ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:203:1: ruleReferencedMetamodel EOF
            {
             before(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel361);
            ruleReferencedMetamodel();
            _fsp--;

             after(grammarAccess.getReferencedMetamodelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferencedMetamodel368); 

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
    // $ANTLR end entryRuleReferencedMetamodel


    // $ANTLR start ruleReferencedMetamodel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:210:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:214:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:215:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:215:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:216:1: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:217:1: ( rule__ReferencedMetamodel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:217:2: rule__ReferencedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__0_in_ruleReferencedMetamodel394);
            rule__ReferencedMetamodel__Group__0();
            _fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getGroup()); 

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
    // $ANTLR end ruleReferencedMetamodel


    // $ANTLR start entryRuleParserRule
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:229:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:230:1: ( ruleParserRule EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:231:1: ruleParserRule EOF
            {
             before(grammarAccess.getParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_entryRuleParserRule421);
            ruleParserRule();
            _fsp--;

             after(grammarAccess.getParserRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRule428); 

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
    // $ANTLR end entryRuleParserRule


    // $ANTLR start ruleParserRule
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:238:1: ruleParserRule : ( ( rule__ParserRule__Group__0 ) ) ;
    public final void ruleParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:242:2: ( ( ( rule__ParserRule__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:243:1: ( ( rule__ParserRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:243:1: ( ( rule__ParserRule__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:244:1: ( rule__ParserRule__Group__0 )
            {
             before(grammarAccess.getParserRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:245:1: ( rule__ParserRule__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:245:2: rule__ParserRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__0_in_ruleParserRule454);
            rule__ParserRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getGroup()); 

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
    // $ANTLR end ruleParserRule


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:257:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:258:1: ( ruleTypeRef EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:259:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_entryRuleTypeRef481);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getTypeRefRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRef488); 

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
    // $ANTLR end entryRuleTypeRef


    // $ANTLR start ruleTypeRef
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:266:1: ruleTypeRef : ( ( rule__TypeRef__Group__0 ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:270:2: ( ( ( rule__TypeRef__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:271:1: ( ( rule__TypeRef__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:271:1: ( ( rule__TypeRef__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:272:1: ( rule__TypeRef__Group__0 )
            {
             before(grammarAccess.getTypeRefAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:273:1: ( rule__TypeRef__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:273:2: rule__TypeRef__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__0_in_ruleTypeRef514);
            rule__TypeRef__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getGroup()); 

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
    // $ANTLR end ruleTypeRef


    // $ANTLR start entryRuleAlternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:285:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:286:1: ( ruleAlternatives EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:287:1: ruleAlternatives EOF
            {
             before(grammarAccess.getAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_entryRuleAlternatives541);
            ruleAlternatives();
            _fsp--;

             after(grammarAccess.getAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternatives548); 

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
    // $ANTLR end entryRuleAlternatives


    // $ANTLR start ruleAlternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:294:1: ruleAlternatives : ( ( rule__Alternatives__Group__0 ) ) ;
    public final void ruleAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:298:2: ( ( ( rule__Alternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:299:1: ( ( rule__Alternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:299:1: ( ( rule__Alternatives__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:300:1: ( rule__Alternatives__Group__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:301:1: ( rule__Alternatives__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:301:2: rule__Alternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__0_in_ruleAlternatives574);
            rule__Alternatives__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup()); 

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
    // $ANTLR end ruleAlternatives


    // $ANTLR start entryRuleGroup
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:313:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:314:1: ( ruleGroup EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:315:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_entryRuleGroup601);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroup608); 

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
    // $ANTLR end entryRuleGroup


    // $ANTLR start ruleGroup
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:322:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:326:2: ( ( ( rule__Group__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:327:1: ( ( rule__Group__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:327:1: ( ( rule__Group__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:328:1: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:329:1: ( rule__Group__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:329:2: rule__Group__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__0_in_ruleGroup634);
            rule__Group__Group__0();
            _fsp--;


            }

             after(grammarAccess.getGroupAccess().getGroup()); 

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
    // $ANTLR end ruleGroup


    // $ANTLR start entryRuleAbstractToken
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:341:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:342:1: ( ruleAbstractToken EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:343:1: ruleAbstractToken EOF
            {
             before(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken661);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getAbstractTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractToken668); 

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
    // $ANTLR end entryRuleAbstractToken


    // $ANTLR start ruleAbstractToken
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:350:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:354:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:355:1: ( ( rule__AbstractToken__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:355:1: ( ( rule__AbstractToken__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:356:1: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:357:1: ( rule__AbstractToken__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:357:2: rule__AbstractToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken694);
            rule__AbstractToken__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getAbstractTokenAccess().getAlternatives()); 

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
    // $ANTLR end ruleAbstractToken


    // $ANTLR start entryRuleAbstractTokenWithCardinality
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:369:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:370:1: ( ruleAbstractTokenWithCardinality EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:371:1: ruleAbstractTokenWithCardinality EOF
            {
             before(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality721);
            ruleAbstractTokenWithCardinality();
            _fsp--;

             after(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality728); 

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
    // $ANTLR end entryRuleAbstractTokenWithCardinality


    // $ANTLR start ruleAbstractTokenWithCardinality
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:378:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:382:2: ( ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:383:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:383:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:384:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:385:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:385:2: rule__AbstractTokenWithCardinality__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__0_in_ruleAbstractTokenWithCardinality754);
            rule__AbstractTokenWithCardinality__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 

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
    // $ANTLR end ruleAbstractTokenWithCardinality


    // $ANTLR start entryRuleAction
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:397:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:398:1: ( ruleAction EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:399:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction781);
            ruleAction();
            _fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction788); 

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
    // $ANTLR end entryRuleAction


    // $ANTLR start ruleAction
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:406:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:410:2: ( ( ( rule__Action__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:411:1: ( ( rule__Action__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:411:1: ( ( rule__Action__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:412:1: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:413:1: ( rule__Action__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:413:2: rule__Action__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__0_in_ruleAction814);
            rule__Action__Group__0();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getGroup()); 

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
    // $ANTLR end ruleAction


    // $ANTLR start entryRuleAbstractTerminal
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:425:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:426:1: ( ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:427:1: ruleAbstractTerminal EOF
            {
             before(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal841);
            ruleAbstractTerminal();
            _fsp--;

             after(grammarAccess.getAbstractTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTerminal848); 

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
    // $ANTLR end entryRuleAbstractTerminal


    // $ANTLR start ruleAbstractTerminal
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:434:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:438:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:439:1: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:439:1: ( ( rule__AbstractTerminal__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:440:1: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:441:1: ( rule__AbstractTerminal__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:441:2: rule__AbstractTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal874);
            rule__AbstractTerminal__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 

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
    // $ANTLR end ruleAbstractTerminal


    // $ANTLR start entryRuleKeyword
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:453:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:454:1: ( ruleKeyword EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:455:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_entryRuleKeyword901);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeyword908); 

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
    // $ANTLR end entryRuleKeyword


    // $ANTLR start ruleKeyword
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:462:1: ruleKeyword : ( ( rule__Keyword__ValueAssignment ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:466:2: ( ( ( rule__Keyword__ValueAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:467:1: ( ( rule__Keyword__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:467:1: ( ( rule__Keyword__ValueAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:468:1: ( rule__Keyword__ValueAssignment )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:469:1: ( rule__Keyword__ValueAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:469:2: rule__Keyword__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Keyword__ValueAssignment_in_ruleKeyword934);
            rule__Keyword__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getKeywordAccess().getValueAssignment()); 

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
    // $ANTLR end ruleKeyword


    // $ANTLR start entryRuleRuleCall
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:481:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:482:1: ( ruleRuleCall EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:483:1: ruleRuleCall EOF
            {
             before(grammarAccess.getRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_entryRuleRuleCall961);
            ruleRuleCall();
            _fsp--;

             after(grammarAccess.getRuleCallRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCall968); 

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
    // $ANTLR end entryRuleRuleCall


    // $ANTLR start ruleRuleCall
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:490:1: ruleRuleCall : ( ( rule__RuleCall__RuleAssignment ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:494:2: ( ( ( rule__RuleCall__RuleAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:495:1: ( ( rule__RuleCall__RuleAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:495:1: ( ( rule__RuleCall__RuleAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:496:1: ( rule__RuleCall__RuleAssignment )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:497:1: ( rule__RuleCall__RuleAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:497:2: rule__RuleCall__RuleAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__RuleCall__RuleAssignment_in_ruleRuleCall994);
            rule__RuleCall__RuleAssignment();
            _fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getRuleAssignment()); 

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
    // $ANTLR end ruleRuleCall


    // $ANTLR start entryRuleAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:509:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:510:1: ( ruleAssignment EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:511:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment1021);
            ruleAssignment();
            _fsp--;

             after(grammarAccess.getAssignmentRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment1028); 

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
    // $ANTLR end entryRuleAssignment


    // $ANTLR start ruleAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:518:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:522:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:523:1: ( ( rule__Assignment__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:523:1: ( ( rule__Assignment__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:524:1: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:525:1: ( rule__Assignment__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:525:2: rule__Assignment__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__0_in_ruleAssignment1054);
            rule__Assignment__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getGroup()); 

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
    // $ANTLR end ruleAssignment


    // $ANTLR start entryRuleAssignableTerminal
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:537:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:538:1: ( ruleAssignableTerminal EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:539:1: ruleAssignableTerminal EOF
            {
             before(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1081);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableTerminal1088); 

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
    // $ANTLR end entryRuleAssignableTerminal


    // $ANTLR start ruleAssignableTerminal
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:546:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:550:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:551:1: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:551:1: ( ( rule__AssignableTerminal__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:552:1: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:553:1: ( rule__AssignableTerminal__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:553:2: rule__AssignableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1114);
            rule__AssignableTerminal__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 

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
    // $ANTLR end ruleAssignableTerminal


    // $ANTLR start entryRuleParenthesizedAssignableElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:565:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:566:1: ( ruleParenthesizedAssignableElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:567:1: ruleParenthesizedAssignableElement EOF
            {
             before(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1141);
            ruleParenthesizedAssignableElement();
            _fsp--;

             after(grammarAccess.getParenthesizedAssignableElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement1148); 

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
    // $ANTLR end entryRuleParenthesizedAssignableElement


    // $ANTLR start ruleParenthesizedAssignableElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:574:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:578:2: ( ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:579:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:579:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:580:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:581:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:581:2: rule__ParenthesizedAssignableElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__0_in_ruleParenthesizedAssignableElement1174);
            rule__ParenthesizedAssignableElement__Group__0();
            _fsp--;


            }

             after(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 

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
    // $ANTLR end ruleParenthesizedAssignableElement


    // $ANTLR start entryRuleAssignableAlternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:593:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:594:1: ( ruleAssignableAlternatives EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:595:1: ruleAssignableAlternatives EOF
            {
             before(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1201);
            ruleAssignableAlternatives();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableAlternatives1208); 

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
    // $ANTLR end entryRuleAssignableAlternatives


    // $ANTLR start ruleAssignableAlternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:602:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group__0 ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:606:2: ( ( ( rule__AssignableAlternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:607:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:607:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:608:1: ( rule__AssignableAlternatives__Group__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:609:1: ( rule__AssignableAlternatives__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:609:2: rule__AssignableAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__0_in_ruleAssignableAlternatives1234);
            rule__AssignableAlternatives__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup()); 

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
    // $ANTLR end ruleAssignableAlternatives


    // $ANTLR start entryRuleCrossReference
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:621:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:622:1: ( ruleCrossReference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:623:1: ruleCrossReference EOF
            {
             before(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_entryRuleCrossReference1261);
            ruleCrossReference();
            _fsp--;

             after(grammarAccess.getCrossReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReference1268); 

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
    // $ANTLR end entryRuleCrossReference


    // $ANTLR start ruleCrossReference
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:630:1: ruleCrossReference : ( ( rule__CrossReference__Group__0 ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:634:2: ( ( ( rule__CrossReference__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:635:1: ( ( rule__CrossReference__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:635:1: ( ( rule__CrossReference__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:636:1: ( rule__CrossReference__Group__0 )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:637:1: ( rule__CrossReference__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:637:2: rule__CrossReference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__0_in_ruleCrossReference1294);
            rule__CrossReference__Group__0();
            _fsp--;


            }

             after(grammarAccess.getCrossReferenceAccess().getGroup()); 

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
    // $ANTLR end ruleCrossReference


    // $ANTLR start entryRuleCrossReferenceableTerminal
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:649:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:650:1: ( ruleCrossReferenceableTerminal EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:651:1: ruleCrossReferenceableTerminal EOF
            {
             before(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1321);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceableTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal1328); 

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
    // $ANTLR end entryRuleCrossReferenceableTerminal


    // $ANTLR start ruleCrossReferenceableTerminal
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:658:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:662:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:663:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:663:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:664:1: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:665:1: ( rule__CrossReferenceableTerminal__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:665:2: rule__CrossReferenceableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1354);
            rule__CrossReferenceableTerminal__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 

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
    // $ANTLR end ruleCrossReferenceableTerminal


    // $ANTLR start entryRuleParenthesizedCrossReferenceableElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:677:1: entryRuleParenthesizedCrossReferenceableElement : ruleParenthesizedCrossReferenceableElement EOF ;
    public final void entryRuleParenthesizedCrossReferenceableElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:678:1: ( ruleParenthesizedCrossReferenceableElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:679:1: ruleParenthesizedCrossReferenceableElement EOF
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement1381);
            ruleParenthesizedCrossReferenceableElement();
            _fsp--;

             after(grammarAccess.getParenthesizedCrossReferenceableElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement1388); 

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
    // $ANTLR end entryRuleParenthesizedCrossReferenceableElement


    // $ANTLR start ruleParenthesizedCrossReferenceableElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:686:1: ruleParenthesizedCrossReferenceableElement : ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) ) ;
    public final void ruleParenthesizedCrossReferenceableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:690:2: ( ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:691:1: ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:691:1: ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:692:1: ( rule__ParenthesizedCrossReferenceableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:693:1: ( rule__ParenthesizedCrossReferenceableElement__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:693:2: rule__ParenthesizedCrossReferenceableElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__0_in_ruleParenthesizedCrossReferenceableElement1414);
            rule__ParenthesizedCrossReferenceableElement__Group__0();
            _fsp--;


            }

             after(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getGroup()); 

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
    // $ANTLR end ruleParenthesizedCrossReferenceableElement


    // $ANTLR start entryRuleCrossReferenceableAlternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:705:1: entryRuleCrossReferenceableAlternatives : ruleCrossReferenceableAlternatives EOF ;
    public final void entryRuleCrossReferenceableAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:706:1: ( ruleCrossReferenceableAlternatives EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:707:1: ruleCrossReferenceableAlternatives EOF
            {
             before(grammarAccess.getCrossReferenceableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives1441);
            ruleCrossReferenceableAlternatives();
            _fsp--;

             after(grammarAccess.getCrossReferenceableAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives1448); 

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
    // $ANTLR end entryRuleCrossReferenceableAlternatives


    // $ANTLR start ruleCrossReferenceableAlternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:714:1: ruleCrossReferenceableAlternatives : ( ( rule__CrossReferenceableAlternatives__Group__0 ) ) ;
    public final void ruleCrossReferenceableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:718:2: ( ( ( rule__CrossReferenceableAlternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:719:1: ( ( rule__CrossReferenceableAlternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:719:1: ( ( rule__CrossReferenceableAlternatives__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:720:1: ( rule__CrossReferenceableAlternatives__Group__0 )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:721:1: ( rule__CrossReferenceableAlternatives__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:721:2: rule__CrossReferenceableAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group__0_in_ruleCrossReferenceableAlternatives1474);
            rule__CrossReferenceableAlternatives__Group__0();
            _fsp--;


            }

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup()); 

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
    // $ANTLR end ruleCrossReferenceableAlternatives


    // $ANTLR start entryRuleParenthesizedElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:733:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:734:1: ( ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:735:1: ruleParenthesizedElement EOF
            {
             before(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1501);
            ruleParenthesizedElement();
            _fsp--;

             after(grammarAccess.getParenthesizedElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedElement1508); 

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
    // $ANTLR end entryRuleParenthesizedElement


    // $ANTLR start ruleParenthesizedElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:742:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group__0 ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:746:2: ( ( ( rule__ParenthesizedElement__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:747:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:747:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:748:1: ( rule__ParenthesizedElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:749:1: ( rule__ParenthesizedElement__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:749:2: rule__ParenthesizedElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__0_in_ruleParenthesizedElement1534);
            rule__ParenthesizedElement__Group__0();
            _fsp--;


            }

             after(grammarAccess.getParenthesizedElementAccess().getGroup()); 

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
    // $ANTLR end ruleParenthesizedElement


    // $ANTLR start entryRuleTerminalRule
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:761:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:762:1: ( ruleTerminalRule EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:763:1: ruleTerminalRule EOF
            {
             before(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1561);
            ruleTerminalRule();
            _fsp--;

             after(grammarAccess.getTerminalRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule1568); 

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
    // $ANTLR end entryRuleTerminalRule


    // $ANTLR start ruleTerminalRule
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:770:1: ruleTerminalRule : ( ( rule__TerminalRule__Group__0 ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:774:2: ( ( ( rule__TerminalRule__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:775:1: ( ( rule__TerminalRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:775:1: ( ( rule__TerminalRule__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:776:1: ( rule__TerminalRule__Group__0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:777:1: ( rule__TerminalRule__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:777:2: rule__TerminalRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__0_in_ruleTerminalRule1594);
            rule__TerminalRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getGroup()); 

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
    // $ANTLR end ruleTerminalRule


    // $ANTLR start entryRuleTerminalAlternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:789:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:790:1: ( ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:791:1: ruleTerminalAlternatives EOF
            {
             before(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1621);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalAlternatives1628); 

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
    // $ANTLR end entryRuleTerminalAlternatives


    // $ANTLR start ruleTerminalAlternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:798:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group__0 ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:802:2: ( ( ( rule__TerminalAlternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:803:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:803:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:804:1: ( rule__TerminalAlternatives__Group__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:805:1: ( rule__TerminalAlternatives__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:805:2: rule__TerminalAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__0_in_ruleTerminalAlternatives1654);
            rule__TerminalAlternatives__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup()); 

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
    // $ANTLR end ruleTerminalAlternatives


    // $ANTLR start entryRuleTerminalGroup
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:817:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:818:1: ( ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:819:1: ruleTerminalGroup EOF
            {
             before(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1681);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalGroup1688); 

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
    // $ANTLR end entryRuleTerminalGroup


    // $ANTLR start ruleTerminalGroup
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:826:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group__0 ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:830:2: ( ( ( rule__TerminalGroup__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:831:1: ( ( rule__TerminalGroup__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:831:1: ( ( rule__TerminalGroup__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:832:1: ( rule__TerminalGroup__Group__0 )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:833:1: ( rule__TerminalGroup__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:833:2: rule__TerminalGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__0_in_ruleTerminalGroup1714);
            rule__TerminalGroup__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getGroup()); 

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
    // $ANTLR end ruleTerminalGroup


    // $ANTLR start entryRuleTerminalToken
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:845:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:846:1: ( ruleTerminalToken EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:847:1: ruleTerminalToken EOF
            {
             before(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1741);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalToken1748); 

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
    // $ANTLR end entryRuleTerminalToken


    // $ANTLR start ruleTerminalToken
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:854:1: ruleTerminalToken : ( ( rule__TerminalToken__Group__0 ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:858:2: ( ( ( rule__TerminalToken__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:859:1: ( ( rule__TerminalToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:859:1: ( ( rule__TerminalToken__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:860:1: ( rule__TerminalToken__Group__0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:861:1: ( rule__TerminalToken__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:861:2: rule__TerminalToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__0_in_ruleTerminalToken1774);
            rule__TerminalToken__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTerminalTokenAccess().getGroup()); 

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
    // $ANTLR end ruleTerminalToken


    // $ANTLR start entryRuleTerminalTokenElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:873:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:874:1: ( ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:875:1: ruleTerminalTokenElement EOF
            {
             before(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1801);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getTerminalTokenElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalTokenElement1808); 

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
    // $ANTLR end entryRuleTerminalTokenElement


    // $ANTLR start ruleTerminalTokenElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:882:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:886:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:887:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:887:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:888:1: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:889:1: ( rule__TerminalTokenElement__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:889:2: rule__TerminalTokenElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1834);
            rule__TerminalTokenElement__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 

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
    // $ANTLR end ruleTerminalTokenElement


    // $ANTLR start entryRuleParenthesizedTerminalElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:901:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:902:1: ( ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:903:1: ruleParenthesizedTerminalElement EOF
            {
             before(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1861);
            ruleParenthesizedTerminalElement();
            _fsp--;

             after(grammarAccess.getParenthesizedTerminalElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement1868); 

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
    // $ANTLR end entryRuleParenthesizedTerminalElement


    // $ANTLR start ruleParenthesizedTerminalElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:910:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:914:2: ( ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:915:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:915:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:916:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:917:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:917:2: rule__ParenthesizedTerminalElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__0_in_ruleParenthesizedTerminalElement1894);
            rule__ParenthesizedTerminalElement__Group__0();
            _fsp--;


            }

             after(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 

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
    // $ANTLR end ruleParenthesizedTerminalElement


    // $ANTLR start entryRuleAbstractNegatedToken
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:929:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:930:1: ( ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:931:1: ruleAbstractNegatedToken EOF
            {
             before(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1921);
            ruleAbstractNegatedToken();
            _fsp--;

             after(grammarAccess.getAbstractNegatedTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractNegatedToken1928); 

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
    // $ANTLR end entryRuleAbstractNegatedToken


    // $ANTLR start ruleAbstractNegatedToken
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:938:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:942:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:943:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:943:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:944:1: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:945:1: ( rule__AbstractNegatedToken__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:945:2: rule__AbstractNegatedToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1954);
            rule__AbstractNegatedToken__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 

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
    // $ANTLR end ruleAbstractNegatedToken


    // $ANTLR start entryRuleNegatedToken
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:957:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:958:1: ( ruleNegatedToken EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:959:1: ruleNegatedToken EOF
            {
             before(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1981);
            ruleNegatedToken();
            _fsp--;

             after(grammarAccess.getNegatedTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegatedToken1988); 

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
    // $ANTLR end entryRuleNegatedToken


    // $ANTLR start ruleNegatedToken
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:966:1: ruleNegatedToken : ( ( rule__NegatedToken__Group__0 ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:970:2: ( ( ( rule__NegatedToken__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:971:1: ( ( rule__NegatedToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:971:1: ( ( rule__NegatedToken__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:972:1: ( rule__NegatedToken__Group__0 )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:973:1: ( rule__NegatedToken__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:973:2: rule__NegatedToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__0_in_ruleNegatedToken2014);
            rule__NegatedToken__Group__0();
            _fsp--;


            }

             after(grammarAccess.getNegatedTokenAccess().getGroup()); 

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
    // $ANTLR end ruleNegatedToken


    // $ANTLR start entryRuleUntilToken
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:985:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:986:1: ( ruleUntilToken EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:987:1: ruleUntilToken EOF
            {
             before(grammarAccess.getUntilTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_entryRuleUntilToken2041);
            ruleUntilToken();
            _fsp--;

             after(grammarAccess.getUntilTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUntilToken2048); 

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
    // $ANTLR end entryRuleUntilToken


    // $ANTLR start ruleUntilToken
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:994:1: ruleUntilToken : ( ( rule__UntilToken__Group__0 ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:998:2: ( ( ( rule__UntilToken__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:999:1: ( ( rule__UntilToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:999:1: ( ( rule__UntilToken__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1000:1: ( rule__UntilToken__Group__0 )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1001:1: ( rule__UntilToken__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1001:2: rule__UntilToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__0_in_ruleUntilToken2074);
            rule__UntilToken__Group__0();
            _fsp--;


            }

             after(grammarAccess.getUntilTokenAccess().getGroup()); 

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
    // $ANTLR end ruleUntilToken


    // $ANTLR start entryRuleWildcard
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1013:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1014:1: ( ruleWildcard EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1015:1: ruleWildcard EOF
            {
             before(grammarAccess.getWildcardRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_entryRuleWildcard2101);
            ruleWildcard();
            _fsp--;

             after(grammarAccess.getWildcardRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcard2108); 

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
    // $ANTLR end entryRuleWildcard


    // $ANTLR start ruleWildcard
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1022:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1026:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1027:1: ( ( rule__Wildcard__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1027:1: ( ( rule__Wildcard__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1028:1: ( rule__Wildcard__Group__0 )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1029:1: ( rule__Wildcard__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1029:2: rule__Wildcard__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__0_in_ruleWildcard2134);
            rule__Wildcard__Group__0();
            _fsp--;


            }

             after(grammarAccess.getWildcardAccess().getGroup()); 

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
    // $ANTLR end ruleWildcard


    // $ANTLR start entryRuleCharacterRange
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1041:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1042:1: ( ruleCharacterRange EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1043:1: ruleCharacterRange EOF
            {
             before(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2161);
            ruleCharacterRange();
            _fsp--;

             after(grammarAccess.getCharacterRangeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCharacterRange2168); 

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
    // $ANTLR end entryRuleCharacterRange


    // $ANTLR start ruleCharacterRange
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1050:1: ruleCharacterRange : ( ( rule__CharacterRange__Group__0 ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1054:2: ( ( ( rule__CharacterRange__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1055:1: ( ( rule__CharacterRange__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1055:1: ( ( rule__CharacterRange__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1056:1: ( rule__CharacterRange__Group__0 )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1057:1: ( rule__CharacterRange__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1057:2: rule__CharacterRange__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__0_in_ruleCharacterRange2194);
            rule__CharacterRange__Group__0();
            _fsp--;


            }

             after(grammarAccess.getCharacterRangeAccess().getGroup()); 

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
    // $ANTLR end ruleCharacterRange


    // $ANTLR start entryRuleEnumRule
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1069:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1070:1: ( ruleEnumRule EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1071:1: ruleEnumRule EOF
            {
             before(grammarAccess.getEnumRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_entryRuleEnumRule2221);
            ruleEnumRule();
            _fsp--;

             after(grammarAccess.getEnumRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumRule2228); 

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
    // $ANTLR end entryRuleEnumRule


    // $ANTLR start ruleEnumRule
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1078:1: ruleEnumRule : ( ( rule__EnumRule__Group__0 ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1082:2: ( ( ( rule__EnumRule__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1083:1: ( ( rule__EnumRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1083:1: ( ( rule__EnumRule__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1084:1: ( rule__EnumRule__Group__0 )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1085:1: ( rule__EnumRule__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1085:2: rule__EnumRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__0_in_ruleEnumRule2254);
            rule__EnumRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getGroup()); 

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
    // $ANTLR end ruleEnumRule


    // $ANTLR start entryRuleEnumLiterals
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1097:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1098:1: ( ruleEnumLiterals EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1099:1: ruleEnumLiterals EOF
            {
             before(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2281);
            ruleEnumLiterals();
            _fsp--;

             after(grammarAccess.getEnumLiteralsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiterals2288); 

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
    // $ANTLR end entryRuleEnumLiterals


    // $ANTLR start ruleEnumLiterals
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1106:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group__0 ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1110:2: ( ( ( rule__EnumLiterals__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1111:1: ( ( rule__EnumLiterals__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1111:1: ( ( rule__EnumLiterals__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1112:1: ( rule__EnumLiterals__Group__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1113:1: ( rule__EnumLiterals__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1113:2: rule__EnumLiterals__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__0_in_ruleEnumLiterals2314);
            rule__EnumLiterals__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup()); 

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
    // $ANTLR end ruleEnumLiterals


    // $ANTLR start entryRuleEnumLiteralDeclaration
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1125:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1126:1: ( ruleEnumLiteralDeclaration EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1127:1: ruleEnumLiteralDeclaration EOF
            {
             before(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2341);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration2348); 

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
    // $ANTLR end entryRuleEnumLiteralDeclaration


    // $ANTLR start ruleEnumLiteralDeclaration
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1134:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group__0 ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1138:2: ( ( ( rule__EnumLiteralDeclaration__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1139:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1139:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1140:1: ( rule__EnumLiteralDeclaration__Group__0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1141:1: ( rule__EnumLiteralDeclaration__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1141:2: rule__EnumLiteralDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__0_in_ruleEnumLiteralDeclaration2374);
            rule__EnumLiteralDeclaration__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 

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
    // $ANTLR end ruleEnumLiteralDeclaration


    // $ANTLR start rule__AbstractRule__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1153:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1157:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt1=1;
                }
                break;
            case 36:
                {
                alt1=2;
                }
                break;
            case 40:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1153:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1158:1: ( ruleParserRule )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1158:1: ( ruleParserRule )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1159:1: ruleParserRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_rule__AbstractRule__Alternatives2410);
                    ruleParserRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1164:6: ( ruleTerminalRule )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1164:6: ( ruleTerminalRule )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1165:1: ruleTerminalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_rule__AbstractRule__Alternatives2427);
                    ruleTerminalRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1170:6: ( ruleEnumRule )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1170:6: ( ruleEnumRule )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1171:1: ruleEnumRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_rule__AbstractRule__Alternatives2444);
                    ruleEnumRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__AbstractRule__Alternatives


    // $ANTLR start rule__AbstractMetamodelDeclaration__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1181:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1185:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==23) ) {
                alt2=1;
            }
            else if ( (LA2_0==25) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1181:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1186:1: ( ruleGeneratedMetamodel )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1186:1: ( ruleGeneratedMetamodel )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1187:1: ruleGeneratedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2476);
                    ruleGeneratedMetamodel();
                    _fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1192:6: ( ruleReferencedMetamodel )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1192:6: ( ruleReferencedMetamodel )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1193:1: ruleReferencedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2493);
                    ruleReferencedMetamodel();
                    _fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__AbstractMetamodelDeclaration__Alternatives


    // $ANTLR start rule__AbstractToken__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1203:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1207:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_STRING)||LA3_0==20) ) {
                alt3=1;
            }
            else if ( (LA3_0==31) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1203:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1208:1: ( ruleAbstractTokenWithCardinality )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1208:1: ( ruleAbstractTokenWithCardinality )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1209:1: ruleAbstractTokenWithCardinality
                    {
                     before(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_rule__AbstractToken__Alternatives2525);
                    ruleAbstractTokenWithCardinality();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1214:6: ( ruleAction )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1214:6: ( ruleAction )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1215:1: ruleAction
                    {
                     before(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_rule__AbstractToken__Alternatives2542);
                    ruleAction();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__AbstractToken__Alternatives


    // $ANTLR start rule__AbstractTokenWithCardinality__Alternatives_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1225:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1229:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==EOF||(LA4_1>=RULE_ID && LA4_1<=RULE_STRING)||(LA4_1>=11 && LA4_1<=13)||(LA4_1>=20 && LA4_1<=21)||LA4_1==27||(LA4_1>=30 && LA4_1<=31)) ) {
                    alt4=2;
                }
                else if ( ((LA4_1>=14 && LA4_1<=16)) ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1225:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==RULE_STRING||LA4_0==20) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1225:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1230:1: ( ruleAssignment )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1230:1: ( ruleAssignment )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1231:1: ruleAssignment
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_rule__AbstractTokenWithCardinality__Alternatives_02574);
                    ruleAssignment();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1236:6: ( ruleAbstractTerminal )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1236:6: ( ruleAbstractTerminal )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1237:1: ruleAbstractTerminal
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_rule__AbstractTokenWithCardinality__Alternatives_02591);
                    ruleAbstractTerminal();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__AbstractTokenWithCardinality__Alternatives_0


    // $ANTLR start rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1247:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1251:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt5=1;
                }
                break;
            case 12:
                {
                alt5=2;
                }
                break;
            case 13:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1247:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1252:1: ( '?' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1252:1: ( '?' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1253:1: '?'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02624); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1260:6: ( '*' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1260:6: ( '*' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1261:1: '*'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02644); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1268:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1268:6: ( '+' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1269:1: '+'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02664); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0


    // $ANTLR start rule__Action__OperatorAlternatives_2_2_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1281:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1285:1: ( ( '=' ) | ( '+=' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            else if ( (LA6_0==15) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1281:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1286:1: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1286:1: ( '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1287:1: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Action__OperatorAlternatives_2_2_02699); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1294:6: ( '+=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1294:6: ( '+=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1295:1: '+='
                    {
                     before(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Action__OperatorAlternatives_2_2_02719); 
                     after(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__Action__OperatorAlternatives_2_2_0


    // $ANTLR start rule__AbstractTerminal__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1307:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1311:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt7=1;
                }
                break;
            case RULE_ID:
                {
                alt7=2;
                }
                break;
            case 20:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1307:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1312:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1312:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1313:1: ruleKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__AbstractTerminal__Alternatives2753);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1318:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1318:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1319:1: ruleRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__AbstractTerminal__Alternatives2770);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1324:6: ( ruleParenthesizedElement )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1324:6: ( ruleParenthesizedElement )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1325:1: ruleParenthesizedElement
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_rule__AbstractTerminal__Alternatives2787);
                    ruleParenthesizedElement();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__AbstractTerminal__Alternatives


    // $ANTLR start rule__Assignment__OperatorAlternatives_1_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1335:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1339:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt8=1;
                }
                break;
            case 14:
                {
                alt8=2;
                }
                break;
            case 16:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1335:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1340:1: ( '+=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1340:1: ( '+=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1341:1: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Assignment__OperatorAlternatives_1_02820); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1348:6: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1348:6: ( '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1349:1: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Assignment__OperatorAlternatives_1_02840); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1356:6: ( '?=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1356:6: ( '?=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1357:1: '?='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2()); 
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__Assignment__OperatorAlternatives_1_02860); 
                     after(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__Assignment__OperatorAlternatives_1_0


    // $ANTLR start rule__AssignableTerminal__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1369:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1373:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt9=1;
                }
                break;
            case RULE_ID:
                {
                alt9=2;
                }
                break;
            case 20:
                {
                alt9=3;
                }
                break;
            case 34:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1369:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1374:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1374:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1375:1: ruleKeyword
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__AssignableTerminal__Alternatives2894);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1380:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1380:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1381:1: ruleRuleCall
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__AssignableTerminal__Alternatives2911);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1386:6: ( ruleParenthesizedAssignableElement )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1386:6: ( ruleParenthesizedAssignableElement )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1387:1: ruleParenthesizedAssignableElement
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_rule__AssignableTerminal__Alternatives2928);
                    ruleParenthesizedAssignableElement();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1392:6: ( ruleCrossReference )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1392:6: ( ruleCrossReference )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1393:1: ruleCrossReference
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_rule__AssignableTerminal__Alternatives2945);
                    ruleCrossReference();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__AssignableTerminal__Alternatives


    // $ANTLR start rule__CrossReferenceableTerminal__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1403:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1407:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt10=1;
                }
                break;
            case RULE_ID:
                {
                alt10=2;
                }
                break;
            case 20:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1403:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1408:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1408:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1409:1: ruleKeyword
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CrossReferenceableTerminal__Alternatives2977);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1414:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1414:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1415:1: ruleRuleCall
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__CrossReferenceableTerminal__Alternatives2994);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1420:6: ( ruleParenthesizedCrossReferenceableElement )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1420:6: ( ruleParenthesizedCrossReferenceableElement )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1421:1: ruleParenthesizedCrossReferenceableElement
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getParenthesizedCrossReferenceableElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedCrossReferenceableElement_in_rule__CrossReferenceableTerminal__Alternatives3011);
                    ruleParenthesizedCrossReferenceableElement();
                    _fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getParenthesizedCrossReferenceableElementParserRuleCall_2()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__CrossReferenceableTerminal__Alternatives


    // $ANTLR start rule__TerminalToken__CardinalityAlternatives_1_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1431:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__TerminalToken__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1435:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt11=1;
                }
                break;
            case 12:
                {
                alt11=2;
                }
                break;
            case 13:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1431:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1436:1: ( '?' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1436:1: ( '?' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1437:1: '?'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_03044); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1444:6: ( '*' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1444:6: ( '*' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1445:1: '*'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_03064); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1452:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1452:6: ( '+' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1453:1: '+'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_03084); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__TerminalToken__CardinalityAlternatives_1_0


    // $ANTLR start rule__TerminalTokenElement__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1465:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1469:1: ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) )
            int alt12=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt12=1;
                }
                break;
            case RULE_ID:
                {
                alt12=2;
                }
                break;
            case 20:
                {
                alt12=3;
                }
                break;
            case 37:
            case 38:
                {
                alt12=4;
                }
                break;
            case 22:
                {
                alt12=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1465:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1470:1: ( ruleCharacterRange )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1470:1: ( ruleCharacterRange )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1471:1: ruleCharacterRange
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3118);
                    ruleCharacterRange();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1476:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1476:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1477:1: ruleRuleCall
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3135);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1482:6: ( ruleParenthesizedTerminalElement )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1482:6: ( ruleParenthesizedTerminalElement )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1483:1: ruleParenthesizedTerminalElement
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3152);
                    ruleParenthesizedTerminalElement();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1488:6: ( ruleAbstractNegatedToken )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1488:6: ( ruleAbstractNegatedToken )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1489:1: ruleAbstractNegatedToken
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3169);
                    ruleAbstractNegatedToken();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1494:6: ( ruleWildcard )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1494:6: ( ruleWildcard )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1495:1: ruleWildcard
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3186);
                    ruleWildcard();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__TerminalTokenElement__Alternatives


    // $ANTLR start rule__AbstractNegatedToken__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1505:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1509:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==37) ) {
                alt13=1;
            }
            else if ( (LA13_0==38) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1505:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1510:1: ( ruleNegatedToken )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1510:1: ( ruleNegatedToken )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1511:1: ruleNegatedToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3218);
                    ruleNegatedToken();
                    _fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1516:6: ( ruleUntilToken )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1516:6: ( ruleUntilToken )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1517:1: ruleUntilToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3235);
                    ruleUntilToken();
                    _fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 

                    }


                    }
                    break;

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
    // $ANTLR end rule__AbstractNegatedToken__Alternatives


    // $ANTLR start rule__Grammar__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1529:1: rule__Grammar__Group__0 : rule__Grammar__Group__0__Impl rule__Grammar__Group__1 ;
    public final void rule__Grammar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1533:1: ( rule__Grammar__Group__0__Impl rule__Grammar__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1534:2: rule__Grammar__Group__0__Impl rule__Grammar__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__0__Impl_in_rule__Grammar__Group__03265);
            rule__Grammar__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__1_in_rule__Grammar__Group__03268);
            rule__Grammar__Group__1();
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
    // $ANTLR end rule__Grammar__Group__0


    // $ANTLR start rule__Grammar__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1541:1: rule__Grammar__Group__0__Impl : ( 'grammar' ) ;
    public final void rule__Grammar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1545:1: ( ( 'grammar' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1546:1: ( 'grammar' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1546:1: ( 'grammar' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1547:1: 'grammar'
            {
             before(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Grammar__Group__0__Impl3296); 
             after(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 

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
    // $ANTLR end rule__Grammar__Group__0__Impl


    // $ANTLR start rule__Grammar__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1560:1: rule__Grammar__Group__1 : rule__Grammar__Group__1__Impl rule__Grammar__Group__2 ;
    public final void rule__Grammar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1564:1: ( rule__Grammar__Group__1__Impl rule__Grammar__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1565:2: rule__Grammar__Group__1__Impl rule__Grammar__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__1__Impl_in_rule__Grammar__Group__13327);
            rule__Grammar__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__2_in_rule__Grammar__Group__13330);
            rule__Grammar__Group__2();
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
    // $ANTLR end rule__Grammar__Group__1


    // $ANTLR start rule__Grammar__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1572:1: rule__Grammar__Group__1__Impl : ( ( rule__Grammar__NameAssignment_1 ) ) ;
    public final void rule__Grammar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1576:1: ( ( ( rule__Grammar__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1577:1: ( ( rule__Grammar__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1577:1: ( ( rule__Grammar__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1578:1: ( rule__Grammar__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1579:1: ( rule__Grammar__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1579:2: rule__Grammar__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__NameAssignment_1_in_rule__Grammar__Group__1__Impl3357);
            rule__Grammar__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getNameAssignment_1()); 

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
    // $ANTLR end rule__Grammar__Group__1__Impl


    // $ANTLR start rule__Grammar__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1589:1: rule__Grammar__Group__2 : rule__Grammar__Group__2__Impl rule__Grammar__Group__3 ;
    public final void rule__Grammar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1593:1: ( rule__Grammar__Group__2__Impl rule__Grammar__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1594:2: rule__Grammar__Group__2__Impl rule__Grammar__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__2__Impl_in_rule__Grammar__Group__23387);
            rule__Grammar__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__3_in_rule__Grammar__Group__23390);
            rule__Grammar__Group__3();
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
    // $ANTLR end rule__Grammar__Group__2


    // $ANTLR start rule__Grammar__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1601:1: rule__Grammar__Group__2__Impl : ( ( rule__Grammar__Group_2__0 )? ) ;
    public final void rule__Grammar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1605:1: ( ( ( rule__Grammar__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1606:1: ( ( rule__Grammar__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1606:1: ( ( rule__Grammar__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1607:1: ( rule__Grammar__Group_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1608:1: ( rule__Grammar__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1608:2: rule__Grammar__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__0_in_rule__Grammar__Group__2__Impl3417);
                    rule__Grammar__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_2()); 

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
    // $ANTLR end rule__Grammar__Group__2__Impl


    // $ANTLR start rule__Grammar__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1618:1: rule__Grammar__Group__3 : rule__Grammar__Group__3__Impl rule__Grammar__Group__4 ;
    public final void rule__Grammar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1622:1: ( rule__Grammar__Group__3__Impl rule__Grammar__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1623:2: rule__Grammar__Group__3__Impl rule__Grammar__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__3__Impl_in_rule__Grammar__Group__33448);
            rule__Grammar__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__4_in_rule__Grammar__Group__33451);
            rule__Grammar__Group__4();
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
    // $ANTLR end rule__Grammar__Group__3


    // $ANTLR start rule__Grammar__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1630:1: rule__Grammar__Group__3__Impl : ( ( rule__Grammar__Group_3__0 )? ) ;
    public final void rule__Grammar__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1634:1: ( ( ( rule__Grammar__Group_3__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1635:1: ( ( rule__Grammar__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1635:1: ( ( rule__Grammar__Group_3__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1636:1: ( rule__Grammar__Group_3__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1637:1: ( rule__Grammar__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==41) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1637:2: rule__Grammar__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__0_in_rule__Grammar__Group__3__Impl3478);
                    rule__Grammar__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_3()); 

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
    // $ANTLR end rule__Grammar__Group__3__Impl


    // $ANTLR start rule__Grammar__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1647:1: rule__Grammar__Group__4 : rule__Grammar__Group__4__Impl rule__Grammar__Group__5 ;
    public final void rule__Grammar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1651:1: ( rule__Grammar__Group__4__Impl rule__Grammar__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1652:2: rule__Grammar__Group__4__Impl rule__Grammar__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__4__Impl_in_rule__Grammar__Group__43509);
            rule__Grammar__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__5_in_rule__Grammar__Group__43512);
            rule__Grammar__Group__5();
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
    // $ANTLR end rule__Grammar__Group__4


    // $ANTLR start rule__Grammar__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1659:1: rule__Grammar__Group__4__Impl : ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) ;
    public final void rule__Grammar__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1663:1: ( ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1664:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1664:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1665:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1666:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23||LA16_0==25) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1666:2: rule__Grammar__MetamodelDeclarationsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__MetamodelDeclarationsAssignment_4_in_rule__Grammar__Group__4__Impl3539);
            	    rule__Grammar__MetamodelDeclarationsAssignment_4();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 

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
    // $ANTLR end rule__Grammar__Group__4__Impl


    // $ANTLR start rule__Grammar__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1676:1: rule__Grammar__Group__5 : rule__Grammar__Group__5__Impl ;
    public final void rule__Grammar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1680:1: ( rule__Grammar__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1681:2: rule__Grammar__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__5__Impl_in_rule__Grammar__Group__53570);
            rule__Grammar__Group__5__Impl();
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
    // $ANTLR end rule__Grammar__Group__5


    // $ANTLR start rule__Grammar__Group__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1687:1: rule__Grammar__Group__5__Impl : ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) ;
    public final void rule__Grammar__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1691:1: ( ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1692:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1692:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1693:1: ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1693:1: ( ( rule__Grammar__RulesAssignment_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1694:1: ( rule__Grammar__RulesAssignment_5 )
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1695:1: ( rule__Grammar__RulesAssignment_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1695:2: rule__Grammar__RulesAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__5__Impl3599);
            rule__Grammar__RulesAssignment_5();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1698:1: ( ( rule__Grammar__RulesAssignment_5 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1699:1: ( rule__Grammar__RulesAssignment_5 )*
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1700:1: ( rule__Grammar__RulesAssignment_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID||LA17_0==36||LA17_0==40) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1700:2: rule__Grammar__RulesAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__5__Impl3611);
            	    rule__Grammar__RulesAssignment_5();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }


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
    // $ANTLR end rule__Grammar__Group__5__Impl


    // $ANTLR start rule__Grammar__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1723:1: rule__Grammar__Group_2__0 : rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 ;
    public final void rule__Grammar__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1727:1: ( rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1728:2: rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__0__Impl_in_rule__Grammar__Group_2__03656);
            rule__Grammar__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__1_in_rule__Grammar__Group_2__03659);
            rule__Grammar__Group_2__1();
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
    // $ANTLR end rule__Grammar__Group_2__0


    // $ANTLR start rule__Grammar__Group_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1735:1: rule__Grammar__Group_2__0__Impl : ( 'with' ) ;
    public final void rule__Grammar__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1739:1: ( ( 'with' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1740:1: ( 'with' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1740:1: ( 'with' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1741:1: 'with'
            {
             before(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Grammar__Group_2__0__Impl3687); 
             after(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 

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
    // $ANTLR end rule__Grammar__Group_2__0__Impl


    // $ANTLR start rule__Grammar__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1754:1: rule__Grammar__Group_2__1 : rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 ;
    public final void rule__Grammar__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1758:1: ( rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1759:2: rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__1__Impl_in_rule__Grammar__Group_2__13718);
            rule__Grammar__Group_2__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__2_in_rule__Grammar__Group_2__13721);
            rule__Grammar__Group_2__2();
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
    // $ANTLR end rule__Grammar__Group_2__1


    // $ANTLR start rule__Grammar__Group_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1766:1: rule__Grammar__Group_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) ;
    public final void rule__Grammar__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1770:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1771:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1771:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1772:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1773:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1773:2: rule__Grammar__UsedGrammarsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_1_in_rule__Grammar__Group_2__1__Impl3748);
            rule__Grammar__UsedGrammarsAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 

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
    // $ANTLR end rule__Grammar__Group_2__1__Impl


    // $ANTLR start rule__Grammar__Group_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1783:1: rule__Grammar__Group_2__2 : rule__Grammar__Group_2__2__Impl ;
    public final void rule__Grammar__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1787:1: ( rule__Grammar__Group_2__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1788:2: rule__Grammar__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__2__Impl_in_rule__Grammar__Group_2__23778);
            rule__Grammar__Group_2__2__Impl();
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
    // $ANTLR end rule__Grammar__Group_2__2


    // $ANTLR start rule__Grammar__Group_2__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1794:1: rule__Grammar__Group_2__2__Impl : ( ( rule__Grammar__Group_2_2__0 )* ) ;
    public final void rule__Grammar__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1798:1: ( ( ( rule__Grammar__Group_2_2__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1799:1: ( ( rule__Grammar__Group_2_2__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1799:1: ( ( rule__Grammar__Group_2_2__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1800:1: ( rule__Grammar__Group_2_2__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1801:1: ( rule__Grammar__Group_2_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1801:2: rule__Grammar__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__0_in_rule__Grammar__Group_2__2__Impl3805);
            	    rule__Grammar__Group_2_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getGrammarAccess().getGroup_2_2()); 

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
    // $ANTLR end rule__Grammar__Group_2__2__Impl


    // $ANTLR start rule__Grammar__Group_2_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1817:1: rule__Grammar__Group_2_2__0 : rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 ;
    public final void rule__Grammar__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1821:1: ( rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1822:2: rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__0__Impl_in_rule__Grammar__Group_2_2__03842);
            rule__Grammar__Group_2_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__1_in_rule__Grammar__Group_2_2__03845);
            rule__Grammar__Group_2_2__1();
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
    // $ANTLR end rule__Grammar__Group_2_2__0


    // $ANTLR start rule__Grammar__Group_2_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1829:1: rule__Grammar__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1833:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1834:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1834:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1835:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Grammar__Group_2_2__0__Impl3873); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 

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
    // $ANTLR end rule__Grammar__Group_2_2__0__Impl


    // $ANTLR start rule__Grammar__Group_2_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1848:1: rule__Grammar__Group_2_2__1 : rule__Grammar__Group_2_2__1__Impl ;
    public final void rule__Grammar__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1852:1: ( rule__Grammar__Group_2_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1853:2: rule__Grammar__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__1__Impl_in_rule__Grammar__Group_2_2__13904);
            rule__Grammar__Group_2_2__1__Impl();
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
    // $ANTLR end rule__Grammar__Group_2_2__1


    // $ANTLR start rule__Grammar__Group_2_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1859:1: rule__Grammar__Group_2_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) ;
    public final void rule__Grammar__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1863:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1864:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1864:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1865:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1866:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1866:2: rule__Grammar__UsedGrammarsAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_2_1_in_rule__Grammar__Group_2_2__1__Impl3931);
            rule__Grammar__UsedGrammarsAssignment_2_2_1();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 

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
    // $ANTLR end rule__Grammar__Group_2_2__1__Impl


    // $ANTLR start rule__Grammar__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1880:1: rule__Grammar__Group_3__0 : rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 ;
    public final void rule__Grammar__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1884:1: ( rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1885:2: rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__0__Impl_in_rule__Grammar__Group_3__03965);
            rule__Grammar__Group_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__1_in_rule__Grammar__Group_3__03968);
            rule__Grammar__Group_3__1();
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
    // $ANTLR end rule__Grammar__Group_3__0


    // $ANTLR start rule__Grammar__Group_3__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1892:1: rule__Grammar__Group_3__0__Impl : ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) ;
    public final void rule__Grammar__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1896:1: ( ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1897:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1897:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1898:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1899:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1899:2: rule__Grammar__DefinesHiddenTokensAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__DefinesHiddenTokensAssignment_3_0_in_rule__Grammar__Group_3__0__Impl3995);
            rule__Grammar__DefinesHiddenTokensAssignment_3_0();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 

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
    // $ANTLR end rule__Grammar__Group_3__0__Impl


    // $ANTLR start rule__Grammar__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1909:1: rule__Grammar__Group_3__1 : rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 ;
    public final void rule__Grammar__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1913:1: ( rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1914:2: rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__1__Impl_in_rule__Grammar__Group_3__14025);
            rule__Grammar__Group_3__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__2_in_rule__Grammar__Group_3__14028);
            rule__Grammar__Group_3__2();
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
    // $ANTLR end rule__Grammar__Group_3__1


    // $ANTLR start rule__Grammar__Group_3__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1921:1: rule__Grammar__Group_3__1__Impl : ( '(' ) ;
    public final void rule__Grammar__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1925:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1926:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1926:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1927:1: '('
            {
             before(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Grammar__Group_3__1__Impl4056); 
             after(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 

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
    // $ANTLR end rule__Grammar__Group_3__1__Impl


    // $ANTLR start rule__Grammar__Group_3__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1940:1: rule__Grammar__Group_3__2 : rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 ;
    public final void rule__Grammar__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1944:1: ( rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1945:2: rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__2__Impl_in_rule__Grammar__Group_3__24087);
            rule__Grammar__Group_3__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__3_in_rule__Grammar__Group_3__24090);
            rule__Grammar__Group_3__3();
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
    // $ANTLR end rule__Grammar__Group_3__2


    // $ANTLR start rule__Grammar__Group_3__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1952:1: rule__Grammar__Group_3__2__Impl : ( ( rule__Grammar__Group_3_2__0 )? ) ;
    public final void rule__Grammar__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1956:1: ( ( ( rule__Grammar__Group_3_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1957:1: ( ( rule__Grammar__Group_3_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1957:1: ( ( rule__Grammar__Group_3_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1958:1: ( rule__Grammar__Group_3_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1959:1: ( rule__Grammar__Group_3_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1959:2: rule__Grammar__Group_3_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__0_in_rule__Grammar__Group_3__2__Impl4117);
                    rule__Grammar__Group_3_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_3_2()); 

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
    // $ANTLR end rule__Grammar__Group_3__2__Impl


    // $ANTLR start rule__Grammar__Group_3__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1969:1: rule__Grammar__Group_3__3 : rule__Grammar__Group_3__3__Impl ;
    public final void rule__Grammar__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1973:1: ( rule__Grammar__Group_3__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1974:2: rule__Grammar__Group_3__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__3__Impl_in_rule__Grammar__Group_3__34148);
            rule__Grammar__Group_3__3__Impl();
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
    // $ANTLR end rule__Grammar__Group_3__3


    // $ANTLR start rule__Grammar__Group_3__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1980:1: rule__Grammar__Group_3__3__Impl : ( ')' ) ;
    public final void rule__Grammar__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1984:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1985:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1985:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1986:1: ')'
            {
             before(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Grammar__Group_3__3__Impl4176); 
             after(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); 

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
    // $ANTLR end rule__Grammar__Group_3__3__Impl


    // $ANTLR start rule__Grammar__Group_3_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2007:1: rule__Grammar__Group_3_2__0 : rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 ;
    public final void rule__Grammar__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2011:1: ( rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2012:2: rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__0__Impl_in_rule__Grammar__Group_3_2__04215);
            rule__Grammar__Group_3_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__1_in_rule__Grammar__Group_3_2__04218);
            rule__Grammar__Group_3_2__1();
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
    // $ANTLR end rule__Grammar__Group_3_2__0


    // $ANTLR start rule__Grammar__Group_3_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2019:1: rule__Grammar__Group_3_2__0__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) ;
    public final void rule__Grammar__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2023:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2024:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2024:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2025:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2026:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2026:2: rule__Grammar__HiddenTokensAssignment_3_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_0_in_rule__Grammar__Group_3_2__0__Impl4245);
            rule__Grammar__HiddenTokensAssignment_3_2_0();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 

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
    // $ANTLR end rule__Grammar__Group_3_2__0__Impl


    // $ANTLR start rule__Grammar__Group_3_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2036:1: rule__Grammar__Group_3_2__1 : rule__Grammar__Group_3_2__1__Impl ;
    public final void rule__Grammar__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2040:1: ( rule__Grammar__Group_3_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2041:2: rule__Grammar__Group_3_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__1__Impl_in_rule__Grammar__Group_3_2__14275);
            rule__Grammar__Group_3_2__1__Impl();
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
    // $ANTLR end rule__Grammar__Group_3_2__1


    // $ANTLR start rule__Grammar__Group_3_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2047:1: rule__Grammar__Group_3_2__1__Impl : ( ( rule__Grammar__Group_3_2_1__0 )* ) ;
    public final void rule__Grammar__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2051:1: ( ( ( rule__Grammar__Group_3_2_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2052:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2052:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2053:1: ( rule__Grammar__Group_3_2_1__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2054:1: ( rule__Grammar__Group_3_2_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==19) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2054:2: rule__Grammar__Group_3_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__0_in_rule__Grammar__Group_3_2__1__Impl4302);
            	    rule__Grammar__Group_3_2_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 

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
    // $ANTLR end rule__Grammar__Group_3_2__1__Impl


    // $ANTLR start rule__Grammar__Group_3_2_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2068:1: rule__Grammar__Group_3_2_1__0 : rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 ;
    public final void rule__Grammar__Group_3_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2072:1: ( rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2073:2: rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__0__Impl_in_rule__Grammar__Group_3_2_1__04337);
            rule__Grammar__Group_3_2_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__1_in_rule__Grammar__Group_3_2_1__04340);
            rule__Grammar__Group_3_2_1__1();
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
    // $ANTLR end rule__Grammar__Group_3_2_1__0


    // $ANTLR start rule__Grammar__Group_3_2_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2080:1: rule__Grammar__Group_3_2_1__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_3_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2084:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2085:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2085:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2086:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Grammar__Group_3_2_1__0__Impl4368); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 

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
    // $ANTLR end rule__Grammar__Group_3_2_1__0__Impl


    // $ANTLR start rule__Grammar__Group_3_2_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2099:1: rule__Grammar__Group_3_2_1__1 : rule__Grammar__Group_3_2_1__1__Impl ;
    public final void rule__Grammar__Group_3_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2103:1: ( rule__Grammar__Group_3_2_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2104:2: rule__Grammar__Group_3_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__1__Impl_in_rule__Grammar__Group_3_2_1__14399);
            rule__Grammar__Group_3_2_1__1__Impl();
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
    // $ANTLR end rule__Grammar__Group_3_2_1__1


    // $ANTLR start rule__Grammar__Group_3_2_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2110:1: rule__Grammar__Group_3_2_1__1__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) ;
    public final void rule__Grammar__Group_3_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2114:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2115:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2115:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2116:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2117:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2117:2: rule__Grammar__HiddenTokensAssignment_3_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_1_1_in_rule__Grammar__Group_3_2_1__1__Impl4426);
            rule__Grammar__HiddenTokensAssignment_3_2_1_1();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 

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
    // $ANTLR end rule__Grammar__Group_3_2_1__1__Impl


    // $ANTLR start rule__GrammarID__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2131:1: rule__GrammarID__Group__0 : rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 ;
    public final void rule__GrammarID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2135:1: ( rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2136:2: rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__0__Impl_in_rule__GrammarID__Group__04460);
            rule__GrammarID__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__1_in_rule__GrammarID__Group__04463);
            rule__GrammarID__Group__1();
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
    // $ANTLR end rule__GrammarID__Group__0


    // $ANTLR start rule__GrammarID__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2143:1: rule__GrammarID__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__GrammarID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2147:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2148:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2148:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2149:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GrammarID__Group__0__Impl4490); 
             after(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 

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
    // $ANTLR end rule__GrammarID__Group__0__Impl


    // $ANTLR start rule__GrammarID__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2160:1: rule__GrammarID__Group__1 : rule__GrammarID__Group__1__Impl ;
    public final void rule__GrammarID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2164:1: ( rule__GrammarID__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2165:2: rule__GrammarID__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__1__Impl_in_rule__GrammarID__Group__14519);
            rule__GrammarID__Group__1__Impl();
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
    // $ANTLR end rule__GrammarID__Group__1


    // $ANTLR start rule__GrammarID__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2171:1: rule__GrammarID__Group__1__Impl : ( ( rule__GrammarID__Group_1__0 )* ) ;
    public final void rule__GrammarID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2175:1: ( ( ( rule__GrammarID__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2176:1: ( ( rule__GrammarID__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2176:1: ( ( rule__GrammarID__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2177:1: ( rule__GrammarID__Group_1__0 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2178:1: ( rule__GrammarID__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2178:2: rule__GrammarID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__0_in_rule__GrammarID__Group__1__Impl4546);
            	    rule__GrammarID__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getGrammarIDAccess().getGroup_1()); 

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
    // $ANTLR end rule__GrammarID__Group__1__Impl


    // $ANTLR start rule__GrammarID__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2192:1: rule__GrammarID__Group_1__0 : rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 ;
    public final void rule__GrammarID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2196:1: ( rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2197:2: rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__0__Impl_in_rule__GrammarID__Group_1__04581);
            rule__GrammarID__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__1_in_rule__GrammarID__Group_1__04584);
            rule__GrammarID__Group_1__1();
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
    // $ANTLR end rule__GrammarID__Group_1__0


    // $ANTLR start rule__GrammarID__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2204:1: rule__GrammarID__Group_1__0__Impl : ( '.' ) ;
    public final void rule__GrammarID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2208:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2209:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2209:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2210:1: '.'
            {
             before(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__GrammarID__Group_1__0__Impl4612); 
             after(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 

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
    // $ANTLR end rule__GrammarID__Group_1__0__Impl


    // $ANTLR start rule__GrammarID__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2223:1: rule__GrammarID__Group_1__1 : rule__GrammarID__Group_1__1__Impl ;
    public final void rule__GrammarID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2227:1: ( rule__GrammarID__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2228:2: rule__GrammarID__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__1__Impl_in_rule__GrammarID__Group_1__14643);
            rule__GrammarID__Group_1__1__Impl();
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
    // $ANTLR end rule__GrammarID__Group_1__1


    // $ANTLR start rule__GrammarID__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2234:1: rule__GrammarID__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__GrammarID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2238:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2239:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2239:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2240:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GrammarID__Group_1__1__Impl4670); 
             after(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1()); 

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
    // $ANTLR end rule__GrammarID__Group_1__1__Impl


    // $ANTLR start rule__GeneratedMetamodel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2255:1: rule__GeneratedMetamodel__Group__0 : rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 ;
    public final void rule__GeneratedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2259:1: ( rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2260:2: rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__0__Impl_in_rule__GeneratedMetamodel__Group__04703);
            rule__GeneratedMetamodel__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__1_in_rule__GeneratedMetamodel__Group__04706);
            rule__GeneratedMetamodel__Group__1();
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
    // $ANTLR end rule__GeneratedMetamodel__Group__0


    // $ANTLR start rule__GeneratedMetamodel__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2267:1: rule__GeneratedMetamodel__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GeneratedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2271:1: ( ( 'generate' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2272:1: ( 'generate' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2272:1: ( 'generate' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2273:1: 'generate'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__GeneratedMetamodel__Group__0__Impl4734); 
             after(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 

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
    // $ANTLR end rule__GeneratedMetamodel__Group__0__Impl


    // $ANTLR start rule__GeneratedMetamodel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2286:1: rule__GeneratedMetamodel__Group__1 : rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 ;
    public final void rule__GeneratedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2290:1: ( rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2291:2: rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__1__Impl_in_rule__GeneratedMetamodel__Group__14765);
            rule__GeneratedMetamodel__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__2_in_rule__GeneratedMetamodel__Group__14768);
            rule__GeneratedMetamodel__Group__2();
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
    // $ANTLR end rule__GeneratedMetamodel__Group__1


    // $ANTLR start rule__GeneratedMetamodel__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2298:1: rule__GeneratedMetamodel__Group__1__Impl : ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2302:1: ( ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2303:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2303:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2304:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2305:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2305:2: rule__GeneratedMetamodel__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__NameAssignment_1_in_rule__GeneratedMetamodel__Group__1__Impl4795);
            rule__GeneratedMetamodel__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 

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
    // $ANTLR end rule__GeneratedMetamodel__Group__1__Impl


    // $ANTLR start rule__GeneratedMetamodel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2315:1: rule__GeneratedMetamodel__Group__2 : rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 ;
    public final void rule__GeneratedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2319:1: ( rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2320:2: rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__2__Impl_in_rule__GeneratedMetamodel__Group__24825);
            rule__GeneratedMetamodel__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__3_in_rule__GeneratedMetamodel__Group__24828);
            rule__GeneratedMetamodel__Group__3();
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
    // $ANTLR end rule__GeneratedMetamodel__Group__2


    // $ANTLR start rule__GeneratedMetamodel__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2327:1: rule__GeneratedMetamodel__Group__2__Impl : ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) ;
    public final void rule__GeneratedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2331:1: ( ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2332:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2332:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2333:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2334:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2334:2: rule__GeneratedMetamodel__EPackageAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__EPackageAssignment_2_in_rule__GeneratedMetamodel__Group__2__Impl4855);
            rule__GeneratedMetamodel__EPackageAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 

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
    // $ANTLR end rule__GeneratedMetamodel__Group__2__Impl


    // $ANTLR start rule__GeneratedMetamodel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2344:1: rule__GeneratedMetamodel__Group__3 : rule__GeneratedMetamodel__Group__3__Impl ;
    public final void rule__GeneratedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2348:1: ( rule__GeneratedMetamodel__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2349:2: rule__GeneratedMetamodel__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__3__Impl_in_rule__GeneratedMetamodel__Group__34885);
            rule__GeneratedMetamodel__Group__3__Impl();
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
    // $ANTLR end rule__GeneratedMetamodel__Group__3


    // $ANTLR start rule__GeneratedMetamodel__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2355:1: rule__GeneratedMetamodel__Group__3__Impl : ( ( rule__GeneratedMetamodel__Group_3__0 )? ) ;
    public final void rule__GeneratedMetamodel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2359:1: ( ( ( rule__GeneratedMetamodel__Group_3__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2360:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2360:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2361:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2362:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2362:2: rule__GeneratedMetamodel__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__0_in_rule__GeneratedMetamodel__Group__3__Impl4912);
                    rule__GeneratedMetamodel__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 

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
    // $ANTLR end rule__GeneratedMetamodel__Group__3__Impl


    // $ANTLR start rule__GeneratedMetamodel__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2380:1: rule__GeneratedMetamodel__Group_3__0 : rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 ;
    public final void rule__GeneratedMetamodel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2384:1: ( rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2385:2: rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__0__Impl_in_rule__GeneratedMetamodel__Group_3__04951);
            rule__GeneratedMetamodel__Group_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__1_in_rule__GeneratedMetamodel__Group_3__04954);
            rule__GeneratedMetamodel__Group_3__1();
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
    // $ANTLR end rule__GeneratedMetamodel__Group_3__0


    // $ANTLR start rule__GeneratedMetamodel__Group_3__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2392:1: rule__GeneratedMetamodel__Group_3__0__Impl : ( 'as' ) ;
    public final void rule__GeneratedMetamodel__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2396:1: ( ( 'as' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2397:1: ( 'as' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2397:1: ( 'as' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2398:1: 'as'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__GeneratedMetamodel__Group_3__0__Impl4982); 
             after(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 

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
    // $ANTLR end rule__GeneratedMetamodel__Group_3__0__Impl


    // $ANTLR start rule__GeneratedMetamodel__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2411:1: rule__GeneratedMetamodel__Group_3__1 : rule__GeneratedMetamodel__Group_3__1__Impl ;
    public final void rule__GeneratedMetamodel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2415:1: ( rule__GeneratedMetamodel__Group_3__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2416:2: rule__GeneratedMetamodel__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__1__Impl_in_rule__GeneratedMetamodel__Group_3__15013);
            rule__GeneratedMetamodel__Group_3__1__Impl();
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
    // $ANTLR end rule__GeneratedMetamodel__Group_3__1


    // $ANTLR start rule__GeneratedMetamodel__Group_3__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2422:1: rule__GeneratedMetamodel__Group_3__1__Impl : ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2426:1: ( ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2427:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2427:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2428:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2429:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2429:2: rule__GeneratedMetamodel__AliasAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__AliasAssignment_3_1_in_rule__GeneratedMetamodel__Group_3__1__Impl5040);
            rule__GeneratedMetamodel__AliasAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 

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
    // $ANTLR end rule__GeneratedMetamodel__Group_3__1__Impl


    // $ANTLR start rule__ReferencedMetamodel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2443:1: rule__ReferencedMetamodel__Group__0 : rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2447:1: ( rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2448:2: rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__0__Impl_in_rule__ReferencedMetamodel__Group__05074);
            rule__ReferencedMetamodel__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__05077);
            rule__ReferencedMetamodel__Group__1();
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
    // $ANTLR end rule__ReferencedMetamodel__Group__0


    // $ANTLR start rule__ReferencedMetamodel__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2455:1: rule__ReferencedMetamodel__Group__0__Impl : ( 'import' ) ;
    public final void rule__ReferencedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2459:1: ( ( 'import' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2460:1: ( 'import' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2460:1: ( 'import' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2461:1: 'import'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__ReferencedMetamodel__Group__0__Impl5105); 
             after(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 

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
    // $ANTLR end rule__ReferencedMetamodel__Group__0__Impl


    // $ANTLR start rule__ReferencedMetamodel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2474:1: rule__ReferencedMetamodel__Group__1 : rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2478:1: ( rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2479:2: rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__1__Impl_in_rule__ReferencedMetamodel__Group__15136);
            rule__ReferencedMetamodel__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__15139);
            rule__ReferencedMetamodel__Group__2();
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
    // $ANTLR end rule__ReferencedMetamodel__Group__1


    // $ANTLR start rule__ReferencedMetamodel__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2486:1: rule__ReferencedMetamodel__Group__1__Impl : ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2490:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2491:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2491:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2492:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2493:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2493:2: rule__ReferencedMetamodel__EPackageAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_1_in_rule__ReferencedMetamodel__Group__1__Impl5166);
            rule__ReferencedMetamodel__EPackageAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 

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
    // $ANTLR end rule__ReferencedMetamodel__Group__1__Impl


    // $ANTLR start rule__ReferencedMetamodel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2503:1: rule__ReferencedMetamodel__Group__2 : rule__ReferencedMetamodel__Group__2__Impl ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2507:1: ( rule__ReferencedMetamodel__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2508:2: rule__ReferencedMetamodel__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__2__Impl_in_rule__ReferencedMetamodel__Group__25196);
            rule__ReferencedMetamodel__Group__2__Impl();
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
    // $ANTLR end rule__ReferencedMetamodel__Group__2


    // $ANTLR start rule__ReferencedMetamodel__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2514:1: rule__ReferencedMetamodel__Group__2__Impl : ( ( rule__ReferencedMetamodel__Group_2__0 )? ) ;
    public final void rule__ReferencedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2518:1: ( ( ( rule__ReferencedMetamodel__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2519:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2519:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2520:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2521:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==24) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2521:2: rule__ReferencedMetamodel__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__0_in_rule__ReferencedMetamodel__Group__2__Impl5223);
                    rule__ReferencedMetamodel__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 

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
    // $ANTLR end rule__ReferencedMetamodel__Group__2__Impl


    // $ANTLR start rule__ReferencedMetamodel__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2537:1: rule__ReferencedMetamodel__Group_2__0 : rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 ;
    public final void rule__ReferencedMetamodel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2541:1: ( rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2542:2: rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__0__Impl_in_rule__ReferencedMetamodel__Group_2__05260);
            rule__ReferencedMetamodel__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__1_in_rule__ReferencedMetamodel__Group_2__05263);
            rule__ReferencedMetamodel__Group_2__1();
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
    // $ANTLR end rule__ReferencedMetamodel__Group_2__0


    // $ANTLR start rule__ReferencedMetamodel__Group_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2549:1: rule__ReferencedMetamodel__Group_2__0__Impl : ( 'as' ) ;
    public final void rule__ReferencedMetamodel__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2553:1: ( ( 'as' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2554:1: ( 'as' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2554:1: ( 'as' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2555:1: 'as'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__ReferencedMetamodel__Group_2__0__Impl5291); 
             after(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 

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
    // $ANTLR end rule__ReferencedMetamodel__Group_2__0__Impl


    // $ANTLR start rule__ReferencedMetamodel__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2568:1: rule__ReferencedMetamodel__Group_2__1 : rule__ReferencedMetamodel__Group_2__1__Impl ;
    public final void rule__ReferencedMetamodel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2572:1: ( rule__ReferencedMetamodel__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2573:2: rule__ReferencedMetamodel__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__1__Impl_in_rule__ReferencedMetamodel__Group_2__15322);
            rule__ReferencedMetamodel__Group_2__1__Impl();
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
    // $ANTLR end rule__ReferencedMetamodel__Group_2__1


    // $ANTLR start rule__ReferencedMetamodel__Group_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2579:1: rule__ReferencedMetamodel__Group_2__1__Impl : ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2583:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2584:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2584:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2585:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2586:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2586:2: rule__ReferencedMetamodel__AliasAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__AliasAssignment_2_1_in_rule__ReferencedMetamodel__Group_2__1__Impl5349);
            rule__ReferencedMetamodel__AliasAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 

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
    // $ANTLR end rule__ReferencedMetamodel__Group_2__1__Impl


    // $ANTLR start rule__ParserRule__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2600:1: rule__ParserRule__Group__0 : rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 ;
    public final void rule__ParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2604:1: ( rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2605:2: rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__0__Impl_in_rule__ParserRule__Group__05383);
            rule__ParserRule__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__1_in_rule__ParserRule__Group__05386);
            rule__ParserRule__Group__1();
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
    // $ANTLR end rule__ParserRule__Group__0


    // $ANTLR start rule__ParserRule__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2612:1: rule__ParserRule__Group__0__Impl : ( ( rule__ParserRule__NameAssignment_0 ) ) ;
    public final void rule__ParserRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2616:1: ( ( ( rule__ParserRule__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2617:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2617:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2618:1: ( rule__ParserRule__NameAssignment_0 )
            {
             before(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2619:1: ( rule__ParserRule__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2619:2: rule__ParserRule__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__NameAssignment_0_in_rule__ParserRule__Group__0__Impl5413);
            rule__ParserRule__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 

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
    // $ANTLR end rule__ParserRule__Group__0__Impl


    // $ANTLR start rule__ParserRule__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2629:1: rule__ParserRule__Group__1 : rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 ;
    public final void rule__ParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2633:1: ( rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2634:2: rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__1__Impl_in_rule__ParserRule__Group__15443);
            rule__ParserRule__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__2_in_rule__ParserRule__Group__15446);
            rule__ParserRule__Group__2();
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
    // $ANTLR end rule__ParserRule__Group__1


    // $ANTLR start rule__ParserRule__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2641:1: rule__ParserRule__Group__1__Impl : ( ( rule__ParserRule__Group_1__0 )? ) ;
    public final void rule__ParserRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2645:1: ( ( ( rule__ParserRule__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2646:1: ( ( rule__ParserRule__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2646:1: ( ( rule__ParserRule__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2647:1: ( rule__ParserRule__Group_1__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2648:1: ( rule__ParserRule__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==28) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2648:2: rule__ParserRule__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__0_in_rule__ParserRule__Group__1__Impl5473);
                    rule__ParserRule__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_1()); 

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
    // $ANTLR end rule__ParserRule__Group__1__Impl


    // $ANTLR start rule__ParserRule__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2658:1: rule__ParserRule__Group__2 : rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 ;
    public final void rule__ParserRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2662:1: ( rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2663:2: rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__2__Impl_in_rule__ParserRule__Group__25504);
            rule__ParserRule__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__3_in_rule__ParserRule__Group__25507);
            rule__ParserRule__Group__3();
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
    // $ANTLR end rule__ParserRule__Group__2


    // $ANTLR start rule__ParserRule__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2670:1: rule__ParserRule__Group__2__Impl : ( ( rule__ParserRule__Group_2__0 )? ) ;
    public final void rule__ParserRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2674:1: ( ( ( rule__ParserRule__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2675:1: ( ( rule__ParserRule__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2675:1: ( ( rule__ParserRule__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2676:1: ( rule__ParserRule__Group_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2677:1: ( rule__ParserRule__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==41) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2677:2: rule__ParserRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__0_in_rule__ParserRule__Group__2__Impl5534);
                    rule__ParserRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_2()); 

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
    // $ANTLR end rule__ParserRule__Group__2__Impl


    // $ANTLR start rule__ParserRule__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2687:1: rule__ParserRule__Group__3 : rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 ;
    public final void rule__ParserRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2691:1: ( rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2692:2: rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__3__Impl_in_rule__ParserRule__Group__35565);
            rule__ParserRule__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__4_in_rule__ParserRule__Group__35568);
            rule__ParserRule__Group__4();
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
    // $ANTLR end rule__ParserRule__Group__3


    // $ANTLR start rule__ParserRule__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2699:1: rule__ParserRule__Group__3__Impl : ( ':' ) ;
    public final void rule__ParserRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2703:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2704:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2704:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2705:1: ':'
            {
             before(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__ParserRule__Group__3__Impl5596); 
             after(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 

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
    // $ANTLR end rule__ParserRule__Group__3__Impl


    // $ANTLR start rule__ParserRule__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2718:1: rule__ParserRule__Group__4 : rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 ;
    public final void rule__ParserRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2722:1: ( rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2723:2: rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__4__Impl_in_rule__ParserRule__Group__45627);
            rule__ParserRule__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__5_in_rule__ParserRule__Group__45630);
            rule__ParserRule__Group__5();
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
    // $ANTLR end rule__ParserRule__Group__4


    // $ANTLR start rule__ParserRule__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2730:1: rule__ParserRule__Group__4__Impl : ( ( rule__ParserRule__AlternativesAssignment_4 ) ) ;
    public final void rule__ParserRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2734:1: ( ( ( rule__ParserRule__AlternativesAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2735:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2735:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2736:1: ( rule__ParserRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2737:1: ( rule__ParserRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2737:2: rule__ParserRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__AlternativesAssignment_4_in_rule__ParserRule__Group__4__Impl5657);
            rule__ParserRule__AlternativesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 

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
    // $ANTLR end rule__ParserRule__Group__4__Impl


    // $ANTLR start rule__ParserRule__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2747:1: rule__ParserRule__Group__5 : rule__ParserRule__Group__5__Impl ;
    public final void rule__ParserRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2751:1: ( rule__ParserRule__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2752:2: rule__ParserRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__5__Impl_in_rule__ParserRule__Group__55687);
            rule__ParserRule__Group__5__Impl();
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
    // $ANTLR end rule__ParserRule__Group__5


    // $ANTLR start rule__ParserRule__Group__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2758:1: rule__ParserRule__Group__5__Impl : ( ';' ) ;
    public final void rule__ParserRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2762:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2763:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2763:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2764:1: ';'
            {
             before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__ParserRule__Group__5__Impl5715); 
             after(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); 

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
    // $ANTLR end rule__ParserRule__Group__5__Impl


    // $ANTLR start rule__ParserRule__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2789:1: rule__ParserRule__Group_1__0 : rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1 ;
    public final void rule__ParserRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2793:1: ( rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2794:2: rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__0__Impl_in_rule__ParserRule__Group_1__05758);
            rule__ParserRule__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__1_in_rule__ParserRule__Group_1__05761);
            rule__ParserRule__Group_1__1();
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
    // $ANTLR end rule__ParserRule__Group_1__0


    // $ANTLR start rule__ParserRule__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2801:1: rule__ParserRule__Group_1__0__Impl : ( 'returns' ) ;
    public final void rule__ParserRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2805:1: ( ( 'returns' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2806:1: ( 'returns' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2806:1: ( 'returns' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2807:1: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__ParserRule__Group_1__0__Impl5789); 
             after(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 

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
    // $ANTLR end rule__ParserRule__Group_1__0__Impl


    // $ANTLR start rule__ParserRule__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2820:1: rule__ParserRule__Group_1__1 : rule__ParserRule__Group_1__1__Impl ;
    public final void rule__ParserRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2824:1: ( rule__ParserRule__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2825:2: rule__ParserRule__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__1__Impl_in_rule__ParserRule__Group_1__15820);
            rule__ParserRule__Group_1__1__Impl();
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
    // $ANTLR end rule__ParserRule__Group_1__1


    // $ANTLR start rule__ParserRule__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2831:1: rule__ParserRule__Group_1__1__Impl : ( ( rule__ParserRule__TypeAssignment_1_1 ) ) ;
    public final void rule__ParserRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2835:1: ( ( ( rule__ParserRule__TypeAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2836:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2836:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2837:1: ( rule__ParserRule__TypeAssignment_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2838:1: ( rule__ParserRule__TypeAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2838:2: rule__ParserRule__TypeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__TypeAssignment_1_1_in_rule__ParserRule__Group_1__1__Impl5847);
            rule__ParserRule__TypeAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1()); 

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
    // $ANTLR end rule__ParserRule__Group_1__1__Impl


    // $ANTLR start rule__ParserRule__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2852:1: rule__ParserRule__Group_2__0 : rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 ;
    public final void rule__ParserRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2856:1: ( rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2857:2: rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__0__Impl_in_rule__ParserRule__Group_2__05881);
            rule__ParserRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__1_in_rule__ParserRule__Group_2__05884);
            rule__ParserRule__Group_2__1();
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
    // $ANTLR end rule__ParserRule__Group_2__0


    // $ANTLR start rule__ParserRule__Group_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2864:1: rule__ParserRule__Group_2__0__Impl : ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) ;
    public final void rule__ParserRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2868:1: ( ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2869:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2869:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2870:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2871:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2871:2: rule__ParserRule__DefinesHiddenTokensAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__DefinesHiddenTokensAssignment_2_0_in_rule__ParserRule__Group_2__0__Impl5911);
            rule__ParserRule__DefinesHiddenTokensAssignment_2_0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 

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
    // $ANTLR end rule__ParserRule__Group_2__0__Impl


    // $ANTLR start rule__ParserRule__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2881:1: rule__ParserRule__Group_2__1 : rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 ;
    public final void rule__ParserRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2885:1: ( rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2886:2: rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__1__Impl_in_rule__ParserRule__Group_2__15941);
            rule__ParserRule__Group_2__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__2_in_rule__ParserRule__Group_2__15944);
            rule__ParserRule__Group_2__2();
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
    // $ANTLR end rule__ParserRule__Group_2__1


    // $ANTLR start rule__ParserRule__Group_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2893:1: rule__ParserRule__Group_2__1__Impl : ( '(' ) ;
    public final void rule__ParserRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2897:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2898:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2898:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2899:1: '('
            {
             before(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParserRule__Group_2__1__Impl5972); 
             after(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 

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
    // $ANTLR end rule__ParserRule__Group_2__1__Impl


    // $ANTLR start rule__ParserRule__Group_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2912:1: rule__ParserRule__Group_2__2 : rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 ;
    public final void rule__ParserRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2916:1: ( rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2917:2: rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__2__Impl_in_rule__ParserRule__Group_2__26003);
            rule__ParserRule__Group_2__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__3_in_rule__ParserRule__Group_2__26006);
            rule__ParserRule__Group_2__3();
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
    // $ANTLR end rule__ParserRule__Group_2__2


    // $ANTLR start rule__ParserRule__Group_2__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2924:1: rule__ParserRule__Group_2__2__Impl : ( ( rule__ParserRule__Group_2_2__0 )? ) ;
    public final void rule__ParserRule__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2928:1: ( ( ( rule__ParserRule__Group_2_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2929:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2929:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2930:1: ( rule__ParserRule__Group_2_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2931:1: ( rule__ParserRule__Group_2_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2931:2: rule__ParserRule__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__0_in_rule__ParserRule__Group_2__2__Impl6033);
                    rule__ParserRule__Group_2_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_2_2()); 

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
    // $ANTLR end rule__ParserRule__Group_2__2__Impl


    // $ANTLR start rule__ParserRule__Group_2__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2941:1: rule__ParserRule__Group_2__3 : rule__ParserRule__Group_2__3__Impl ;
    public final void rule__ParserRule__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2945:1: ( rule__ParserRule__Group_2__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2946:2: rule__ParserRule__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__3__Impl_in_rule__ParserRule__Group_2__36064);
            rule__ParserRule__Group_2__3__Impl();
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
    // $ANTLR end rule__ParserRule__Group_2__3


    // $ANTLR start rule__ParserRule__Group_2__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2952:1: rule__ParserRule__Group_2__3__Impl : ( ')' ) ;
    public final void rule__ParserRule__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2956:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2957:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2957:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2958:1: ')'
            {
             before(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParserRule__Group_2__3__Impl6092); 
             after(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); 

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
    // $ANTLR end rule__ParserRule__Group_2__3__Impl


    // $ANTLR start rule__ParserRule__Group_2_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2979:1: rule__ParserRule__Group_2_2__0 : rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 ;
    public final void rule__ParserRule__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2983:1: ( rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2984:2: rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__0__Impl_in_rule__ParserRule__Group_2_2__06131);
            rule__ParserRule__Group_2_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__1_in_rule__ParserRule__Group_2_2__06134);
            rule__ParserRule__Group_2_2__1();
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
    // $ANTLR end rule__ParserRule__Group_2_2__0


    // $ANTLR start rule__ParserRule__Group_2_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2991:1: rule__ParserRule__Group_2_2__0__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) ;
    public final void rule__ParserRule__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2995:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2996:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2996:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2997:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2998:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2998:2: rule__ParserRule__HiddenTokensAssignment_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_0_in_rule__ParserRule__Group_2_2__0__Impl6161);
            rule__ParserRule__HiddenTokensAssignment_2_2_0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 

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
    // $ANTLR end rule__ParserRule__Group_2_2__0__Impl


    // $ANTLR start rule__ParserRule__Group_2_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3008:1: rule__ParserRule__Group_2_2__1 : rule__ParserRule__Group_2_2__1__Impl ;
    public final void rule__ParserRule__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3012:1: ( rule__ParserRule__Group_2_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3013:2: rule__ParserRule__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__1__Impl_in_rule__ParserRule__Group_2_2__16191);
            rule__ParserRule__Group_2_2__1__Impl();
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
    // $ANTLR end rule__ParserRule__Group_2_2__1


    // $ANTLR start rule__ParserRule__Group_2_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3019:1: rule__ParserRule__Group_2_2__1__Impl : ( ( rule__ParserRule__Group_2_2_1__0 )* ) ;
    public final void rule__ParserRule__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3023:1: ( ( ( rule__ParserRule__Group_2_2_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3024:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3024:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3025:1: ( rule__ParserRule__Group_2_2_1__0 )*
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3026:1: ( rule__ParserRule__Group_2_2_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==19) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3026:2: rule__ParserRule__Group_2_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__0_in_rule__ParserRule__Group_2_2__1__Impl6218);
            	    rule__ParserRule__Group_2_2_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 

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
    // $ANTLR end rule__ParserRule__Group_2_2__1__Impl


    // $ANTLR start rule__ParserRule__Group_2_2_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3040:1: rule__ParserRule__Group_2_2_1__0 : rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 ;
    public final void rule__ParserRule__Group_2_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3044:1: ( rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3045:2: rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__0__Impl_in_rule__ParserRule__Group_2_2_1__06253);
            rule__ParserRule__Group_2_2_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__1_in_rule__ParserRule__Group_2_2_1__06256);
            rule__ParserRule__Group_2_2_1__1();
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
    // $ANTLR end rule__ParserRule__Group_2_2_1__0


    // $ANTLR start rule__ParserRule__Group_2_2_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3052:1: rule__ParserRule__Group_2_2_1__0__Impl : ( ',' ) ;
    public final void rule__ParserRule__Group_2_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3056:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3057:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3057:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3058:1: ','
            {
             before(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__ParserRule__Group_2_2_1__0__Impl6284); 
             after(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 

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
    // $ANTLR end rule__ParserRule__Group_2_2_1__0__Impl


    // $ANTLR start rule__ParserRule__Group_2_2_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3071:1: rule__ParserRule__Group_2_2_1__1 : rule__ParserRule__Group_2_2_1__1__Impl ;
    public final void rule__ParserRule__Group_2_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3075:1: ( rule__ParserRule__Group_2_2_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3076:2: rule__ParserRule__Group_2_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__1__Impl_in_rule__ParserRule__Group_2_2_1__16315);
            rule__ParserRule__Group_2_2_1__1__Impl();
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
    // $ANTLR end rule__ParserRule__Group_2_2_1__1


    // $ANTLR start rule__ParserRule__Group_2_2_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3082:1: rule__ParserRule__Group_2_2_1__1__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_2_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3086:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3087:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3087:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3088:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3089:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3089:2: rule__ParserRule__HiddenTokensAssignment_2_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_1_1_in_rule__ParserRule__Group_2_2_1__1__Impl6342);
            rule__ParserRule__HiddenTokensAssignment_2_2_1_1();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 

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
    // $ANTLR end rule__ParserRule__Group_2_2_1__1__Impl


    // $ANTLR start rule__TypeRef__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3103:1: rule__TypeRef__Group__0 : rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3107:1: ( rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3108:2: rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__0__Impl_in_rule__TypeRef__Group__06376);
            rule__TypeRef__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__1_in_rule__TypeRef__Group__06379);
            rule__TypeRef__Group__1();
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
    // $ANTLR end rule__TypeRef__Group__0


    // $ANTLR start rule__TypeRef__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3115:1: rule__TypeRef__Group__0__Impl : ( ( rule__TypeRef__Group_0__0 )? ) ;
    public final void rule__TypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3119:1: ( ( ( rule__TypeRef__Group_0__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3120:1: ( ( rule__TypeRef__Group_0__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3120:1: ( ( rule__TypeRef__Group_0__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3121:1: ( rule__TypeRef__Group_0__0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3122:1: ( rule__TypeRef__Group_0__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==29) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3122:2: rule__TypeRef__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__0_in_rule__TypeRef__Group__0__Impl6406);
                    rule__TypeRef__Group_0__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeRefAccess().getGroup_0()); 

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
    // $ANTLR end rule__TypeRef__Group__0__Impl


    // $ANTLR start rule__TypeRef__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3132:1: rule__TypeRef__Group__1 : rule__TypeRef__Group__1__Impl ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3136:1: ( rule__TypeRef__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3137:2: rule__TypeRef__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__1__Impl_in_rule__TypeRef__Group__16437);
            rule__TypeRef__Group__1__Impl();
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
    // $ANTLR end rule__TypeRef__Group__1


    // $ANTLR start rule__TypeRef__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3143:1: rule__TypeRef__Group__1__Impl : ( ( rule__TypeRef__ClassifierAssignment_1 ) ) ;
    public final void rule__TypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3147:1: ( ( ( rule__TypeRef__ClassifierAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3148:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3148:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3149:1: ( rule__TypeRef__ClassifierAssignment_1 )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3150:1: ( rule__TypeRef__ClassifierAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3150:2: rule__TypeRef__ClassifierAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__ClassifierAssignment_1_in_rule__TypeRef__Group__1__Impl6464);
            rule__TypeRef__ClassifierAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 

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
    // $ANTLR end rule__TypeRef__Group__1__Impl


    // $ANTLR start rule__TypeRef__Group_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3164:1: rule__TypeRef__Group_0__0 : rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 ;
    public final void rule__TypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3168:1: ( rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3169:2: rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__0__Impl_in_rule__TypeRef__Group_0__06498);
            rule__TypeRef__Group_0__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__1_in_rule__TypeRef__Group_0__06501);
            rule__TypeRef__Group_0__1();
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
    // $ANTLR end rule__TypeRef__Group_0__0


    // $ANTLR start rule__TypeRef__Group_0__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3176:1: rule__TypeRef__Group_0__0__Impl : ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) ;
    public final void rule__TypeRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3180:1: ( ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3181:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3181:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3182:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3183:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3183:2: rule__TypeRef__MetamodelAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__MetamodelAssignment_0_0_in_rule__TypeRef__Group_0__0__Impl6528);
            rule__TypeRef__MetamodelAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 

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
    // $ANTLR end rule__TypeRef__Group_0__0__Impl


    // $ANTLR start rule__TypeRef__Group_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3193:1: rule__TypeRef__Group_0__1 : rule__TypeRef__Group_0__1__Impl ;
    public final void rule__TypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3197:1: ( rule__TypeRef__Group_0__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3198:2: rule__TypeRef__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__1__Impl_in_rule__TypeRef__Group_0__16558);
            rule__TypeRef__Group_0__1__Impl();
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
    // $ANTLR end rule__TypeRef__Group_0__1


    // $ANTLR start rule__TypeRef__Group_0__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3204:1: rule__TypeRef__Group_0__1__Impl : ( '::' ) ;
    public final void rule__TypeRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3208:1: ( ( '::' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3209:1: ( '::' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3209:1: ( '::' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3210:1: '::'
            {
             before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__TypeRef__Group_0__1__Impl6586); 
             after(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 

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
    // $ANTLR end rule__TypeRef__Group_0__1__Impl


    // $ANTLR start rule__Alternatives__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3227:1: rule__Alternatives__Group__0 : rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 ;
    public final void rule__Alternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3231:1: ( rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3232:2: rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__0__Impl_in_rule__Alternatives__Group__06621);
            rule__Alternatives__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__1_in_rule__Alternatives__Group__06624);
            rule__Alternatives__Group__1();
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
    // $ANTLR end rule__Alternatives__Group__0


    // $ANTLR start rule__Alternatives__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3239:1: rule__Alternatives__Group__0__Impl : ( ruleGroup ) ;
    public final void rule__Alternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3243:1: ( ( ruleGroup ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3244:1: ( ruleGroup )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3244:1: ( ruleGroup )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3245:1: ruleGroup
            {
             before(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_rule__Alternatives__Group__0__Impl6651);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 

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
    // $ANTLR end rule__Alternatives__Group__0__Impl


    // $ANTLR start rule__Alternatives__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3256:1: rule__Alternatives__Group__1 : rule__Alternatives__Group__1__Impl ;
    public final void rule__Alternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3260:1: ( rule__Alternatives__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3261:2: rule__Alternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__1__Impl_in_rule__Alternatives__Group__16680);
            rule__Alternatives__Group__1__Impl();
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
    // $ANTLR end rule__Alternatives__Group__1


    // $ANTLR start rule__Alternatives__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3267:1: rule__Alternatives__Group__1__Impl : ( ( rule__Alternatives__Group_1__0 )? ) ;
    public final void rule__Alternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3271:1: ( ( ( rule__Alternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3272:1: ( ( rule__Alternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3272:1: ( ( rule__Alternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3273:1: ( rule__Alternatives__Group_1__0 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3274:1: ( rule__Alternatives__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==30) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3274:2: rule__Alternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__0_in_rule__Alternatives__Group__1__Impl6707);
                    rule__Alternatives__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAlternativesAccess().getGroup_1()); 

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
    // $ANTLR end rule__Alternatives__Group__1__Impl


    // $ANTLR start rule__Alternatives__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3288:1: rule__Alternatives__Group_1__0 : rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 ;
    public final void rule__Alternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3292:1: ( rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3293:2: rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__0__Impl_in_rule__Alternatives__Group_1__06742);
            rule__Alternatives__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__1_in_rule__Alternatives__Group_1__06745);
            rule__Alternatives__Group_1__1();
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
    // $ANTLR end rule__Alternatives__Group_1__0


    // $ANTLR start rule__Alternatives__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3300:1: rule__Alternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__Alternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3304:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3305:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3305:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3306:1: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3307:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3309:1: 
            {
            }

             after(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Alternatives__Group_1__0__Impl


    // $ANTLR start rule__Alternatives__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3319:1: rule__Alternatives__Group_1__1 : rule__Alternatives__Group_1__1__Impl ;
    public final void rule__Alternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3323:1: ( rule__Alternatives__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3324:2: rule__Alternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__1__Impl_in_rule__Alternatives__Group_1__16803);
            rule__Alternatives__Group_1__1__Impl();
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
    // $ANTLR end rule__Alternatives__Group_1__1


    // $ANTLR start rule__Alternatives__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3330:1: rule__Alternatives__Group_1__1__Impl : ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) ;
    public final void rule__Alternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3334:1: ( ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3335:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3335:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3336:1: ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3336:1: ( ( rule__Alternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3337:1: ( rule__Alternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3338:1: ( rule__Alternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3338:2: rule__Alternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__1__Impl6832);
            rule__Alternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3341:1: ( ( rule__Alternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3342:1: ( rule__Alternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3343:1: ( rule__Alternatives__Group_1_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==30) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3343:2: rule__Alternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__1__Impl6844);
            	    rule__Alternatives__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }


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
    // $ANTLR end rule__Alternatives__Group_1__1__Impl


    // $ANTLR start rule__Alternatives__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3358:1: rule__Alternatives__Group_1_1__0 : rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 ;
    public final void rule__Alternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3362:1: ( rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3363:2: rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0__Impl_in_rule__Alternatives__Group_1_1__06881);
            rule__Alternatives__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__1_in_rule__Alternatives__Group_1_1__06884);
            rule__Alternatives__Group_1_1__1();
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
    // $ANTLR end rule__Alternatives__Group_1_1__0


    // $ANTLR start rule__Alternatives__Group_1_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3370:1: rule__Alternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__Alternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3374:1: ( ( '|' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3375:1: ( '|' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3375:1: ( '|' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3376:1: '|'
            {
             before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__Alternatives__Group_1_1__0__Impl6912); 
             after(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

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
    // $ANTLR end rule__Alternatives__Group_1_1__0__Impl


    // $ANTLR start rule__Alternatives__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3389:1: rule__Alternatives__Group_1_1__1 : rule__Alternatives__Group_1_1__1__Impl ;
    public final void rule__Alternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3393:1: ( rule__Alternatives__Group_1_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3394:2: rule__Alternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__1__Impl_in_rule__Alternatives__Group_1_1__16943);
            rule__Alternatives__Group_1_1__1__Impl();
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
    // $ANTLR end rule__Alternatives__Group_1_1__1


    // $ANTLR start rule__Alternatives__Group_1_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3400:1: rule__Alternatives__Group_1_1__1__Impl : ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__Alternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3404:1: ( ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3405:1: ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3405:1: ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3406:1: ( rule__Alternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3407:1: ( rule__Alternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3407:2: rule__Alternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__GroupsAssignment_1_1_1_in_rule__Alternatives__Group_1_1__1__Impl6970);
            rule__Alternatives__GroupsAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroupsAssignment_1_1_1()); 

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
    // $ANTLR end rule__Alternatives__Group_1_1__1__Impl


    // $ANTLR start rule__Group__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3421:1: rule__Group__Group__0 : rule__Group__Group__0__Impl rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3425:1: ( rule__Group__Group__0__Impl rule__Group__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3426:2: rule__Group__Group__0__Impl rule__Group__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__0__Impl_in_rule__Group__Group__07004);
            rule__Group__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__1_in_rule__Group__Group__07007);
            rule__Group__Group__1();
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
    // $ANTLR end rule__Group__Group__0


    // $ANTLR start rule__Group__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3433:1: rule__Group__Group__0__Impl : ( ruleAbstractToken ) ;
    public final void rule__Group__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3437:1: ( ( ruleAbstractToken ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3438:1: ( ruleAbstractToken )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3438:1: ( ruleAbstractToken )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3439:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_rule__Group__Group__0__Impl7034);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 

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
    // $ANTLR end rule__Group__Group__0__Impl


    // $ANTLR start rule__Group__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3450:1: rule__Group__Group__1 : rule__Group__Group__1__Impl ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3454:1: ( rule__Group__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3455:2: rule__Group__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__1__Impl_in_rule__Group__Group__17063);
            rule__Group__Group__1__Impl();
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
    // $ANTLR end rule__Group__Group__1


    // $ANTLR start rule__Group__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3461:1: rule__Group__Group__1__Impl : ( ( rule__Group__Group_1__0 )? ) ;
    public final void rule__Group__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3465:1: ( ( ( rule__Group__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3466:1: ( ( rule__Group__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3466:1: ( ( rule__Group__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3467:1: ( rule__Group__Group_1__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3468:1: ( rule__Group__Group_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_STRING)||LA31_0==20||LA31_0==31) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3468:2: rule__Group__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__0_in_rule__Group__Group__1__Impl7090);
                    rule__Group__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGroupAccess().getGroup_1()); 

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
    // $ANTLR end rule__Group__Group__1__Impl


    // $ANTLR start rule__Group__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3482:1: rule__Group__Group_1__0 : rule__Group__Group_1__0__Impl rule__Group__Group_1__1 ;
    public final void rule__Group__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3486:1: ( rule__Group__Group_1__0__Impl rule__Group__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3487:2: rule__Group__Group_1__0__Impl rule__Group__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__0__Impl_in_rule__Group__Group_1__07125);
            rule__Group__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__1_in_rule__Group__Group_1__07128);
            rule__Group__Group_1__1();
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
    // $ANTLR end rule__Group__Group_1__0


    // $ANTLR start rule__Group__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3494:1: rule__Group__Group_1__0__Impl : ( () ) ;
    public final void rule__Group__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3498:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3499:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3499:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3500:1: ()
            {
             before(grammarAccess.getGroupAccess().getGroupTokensAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3501:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3503:1: 
            {
            }

             after(grammarAccess.getGroupAccess().getGroupTokensAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Group__Group_1__0__Impl


    // $ANTLR start rule__Group__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3513:1: rule__Group__Group_1__1 : rule__Group__Group_1__1__Impl ;
    public final void rule__Group__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3517:1: ( rule__Group__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3518:2: rule__Group__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__1__Impl_in_rule__Group__Group_1__17186);
            rule__Group__Group_1__1__Impl();
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
    // $ANTLR end rule__Group__Group_1__1


    // $ANTLR start rule__Group__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3524:1: rule__Group__Group_1__1__Impl : ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) ) ;
    public final void rule__Group__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3528:1: ( ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3529:1: ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3529:1: ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3530:1: ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3530:1: ( ( rule__Group__TokensAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3531:1: ( rule__Group__TokensAssignment_1_1 )
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3532:1: ( rule__Group__TokensAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3532:2: rule__Group__TokensAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__1__Impl7215);
            rule__Group__TokensAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3535:1: ( ( rule__Group__TokensAssignment_1_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3536:1: ( rule__Group__TokensAssignment_1_1 )*
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3537:1: ( rule__Group__TokensAssignment_1_1 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_STRING)||LA32_0==20||LA32_0==31) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3537:2: rule__Group__TokensAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__1__Impl7227);
            	    rule__Group__TokensAssignment_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 

            }


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
    // $ANTLR end rule__Group__Group_1__1__Impl


    // $ANTLR start rule__AbstractTokenWithCardinality__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3552:1: rule__AbstractTokenWithCardinality__Group__0 : rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 ;
    public final void rule__AbstractTokenWithCardinality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3556:1: ( rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3557:2: rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__0__Impl_in_rule__AbstractTokenWithCardinality__Group__07264);
            rule__AbstractTokenWithCardinality__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__1_in_rule__AbstractTokenWithCardinality__Group__07267);
            rule__AbstractTokenWithCardinality__Group__1();
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
    // $ANTLR end rule__AbstractTokenWithCardinality__Group__0


    // $ANTLR start rule__AbstractTokenWithCardinality__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3564:1: rule__AbstractTokenWithCardinality__Group__0__Impl : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3568:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3569:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3569:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3570:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3571:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3571:2: rule__AbstractTokenWithCardinality__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group__0__Impl7294);
            rule__AbstractTokenWithCardinality__Alternatives_0();
            _fsp--;


            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 

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
    // $ANTLR end rule__AbstractTokenWithCardinality__Group__0__Impl


    // $ANTLR start rule__AbstractTokenWithCardinality__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3581:1: rule__AbstractTokenWithCardinality__Group__1 : rule__AbstractTokenWithCardinality__Group__1__Impl ;
    public final void rule__AbstractTokenWithCardinality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3585:1: ( rule__AbstractTokenWithCardinality__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3586:2: rule__AbstractTokenWithCardinality__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__1__Impl_in_rule__AbstractTokenWithCardinality__Group__17324);
            rule__AbstractTokenWithCardinality__Group__1__Impl();
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
    // $ANTLR end rule__AbstractTokenWithCardinality__Group__1


    // $ANTLR start rule__AbstractTokenWithCardinality__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3592:1: rule__AbstractTokenWithCardinality__Group__1__Impl : ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3596:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3597:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3597:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3598:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3599:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=11 && LA33_0<=13)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3599:2: rule__AbstractTokenWithCardinality__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAssignment_1_in_rule__AbstractTokenWithCardinality__Group__1__Impl7351);
                    rule__AbstractTokenWithCardinality__CardinalityAssignment_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 

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
    // $ANTLR end rule__AbstractTokenWithCardinality__Group__1__Impl


    // $ANTLR start rule__Action__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3613:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3617:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3618:2: rule__Action__Group__0__Impl rule__Action__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__0__Impl_in_rule__Action__Group__07386);
            rule__Action__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__1_in_rule__Action__Group__07389);
            rule__Action__Group__1();
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
    // $ANTLR end rule__Action__Group__0


    // $ANTLR start rule__Action__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3625:1: rule__Action__Group__0__Impl : ( '{' ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3629:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3630:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3630:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3631:1: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__Action__Group__0__Impl7417); 
             after(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 

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
    // $ANTLR end rule__Action__Group__0__Impl


    // $ANTLR start rule__Action__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3644:1: rule__Action__Group__1 : rule__Action__Group__1__Impl rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3648:1: ( rule__Action__Group__1__Impl rule__Action__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3649:2: rule__Action__Group__1__Impl rule__Action__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__1__Impl_in_rule__Action__Group__17448);
            rule__Action__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__2_in_rule__Action__Group__17451);
            rule__Action__Group__2();
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
    // $ANTLR end rule__Action__Group__1


    // $ANTLR start rule__Action__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3656:1: rule__Action__Group__1__Impl : ( ( rule__Action__TypeAssignment_1 ) ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3660:1: ( ( ( rule__Action__TypeAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3661:1: ( ( rule__Action__TypeAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3661:1: ( ( rule__Action__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3662:1: ( rule__Action__TypeAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3663:1: ( rule__Action__TypeAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3663:2: rule__Action__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__TypeAssignment_1_in_rule__Action__Group__1__Impl7478);
            rule__Action__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getTypeAssignment_1()); 

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
    // $ANTLR end rule__Action__Group__1__Impl


    // $ANTLR start rule__Action__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3673:1: rule__Action__Group__2 : rule__Action__Group__2__Impl rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3677:1: ( rule__Action__Group__2__Impl rule__Action__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3678:2: rule__Action__Group__2__Impl rule__Action__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__2__Impl_in_rule__Action__Group__27508);
            rule__Action__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__3_in_rule__Action__Group__27511);
            rule__Action__Group__3();
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
    // $ANTLR end rule__Action__Group__2


    // $ANTLR start rule__Action__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3685:1: rule__Action__Group__2__Impl : ( ( rule__Action__Group_2__0 )? ) ;
    public final void rule__Action__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3689:1: ( ( ( rule__Action__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3690:1: ( ( rule__Action__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3690:1: ( ( rule__Action__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3691:1: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3692:1: ( rule__Action__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==22) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3692:2: rule__Action__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__0_in_rule__Action__Group__2__Impl7538);
                    rule__Action__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_2()); 

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
    // $ANTLR end rule__Action__Group__2__Impl


    // $ANTLR start rule__Action__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3702:1: rule__Action__Group__3 : rule__Action__Group__3__Impl ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3706:1: ( rule__Action__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3707:2: rule__Action__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__3__Impl_in_rule__Action__Group__37569);
            rule__Action__Group__3__Impl();
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
    // $ANTLR end rule__Action__Group__3


    // $ANTLR start rule__Action__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3713:1: rule__Action__Group__3__Impl : ( '}' ) ;
    public final void rule__Action__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3717:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3718:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3718:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3719:1: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Action__Group__3__Impl7597); 
             after(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 

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
    // $ANTLR end rule__Action__Group__3__Impl


    // $ANTLR start rule__Action__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3740:1: rule__Action__Group_2__0 : rule__Action__Group_2__0__Impl rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3744:1: ( rule__Action__Group_2__0__Impl rule__Action__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3745:2: rule__Action__Group_2__0__Impl rule__Action__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__0__Impl_in_rule__Action__Group_2__07636);
            rule__Action__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__1_in_rule__Action__Group_2__07639);
            rule__Action__Group_2__1();
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
    // $ANTLR end rule__Action__Group_2__0


    // $ANTLR start rule__Action__Group_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3752:1: rule__Action__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Action__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3756:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3757:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3757:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3758:1: '.'
            {
             before(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Action__Group_2__0__Impl7667); 
             after(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 

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
    // $ANTLR end rule__Action__Group_2__0__Impl


    // $ANTLR start rule__Action__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3771:1: rule__Action__Group_2__1 : rule__Action__Group_2__1__Impl rule__Action__Group_2__2 ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3775:1: ( rule__Action__Group_2__1__Impl rule__Action__Group_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3776:2: rule__Action__Group_2__1__Impl rule__Action__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__1__Impl_in_rule__Action__Group_2__17698);
            rule__Action__Group_2__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__2_in_rule__Action__Group_2__17701);
            rule__Action__Group_2__2();
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
    // $ANTLR end rule__Action__Group_2__1


    // $ANTLR start rule__Action__Group_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3783:1: rule__Action__Group_2__1__Impl : ( ( rule__Action__FeatureAssignment_2_1 ) ) ;
    public final void rule__Action__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3787:1: ( ( ( rule__Action__FeatureAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3788:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3788:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3789:1: ( rule__Action__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3790:1: ( rule__Action__FeatureAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3790:2: rule__Action__FeatureAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__FeatureAssignment_2_1_in_rule__Action__Group_2__1__Impl7728);
            rule__Action__FeatureAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 

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
    // $ANTLR end rule__Action__Group_2__1__Impl


    // $ANTLR start rule__Action__Group_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3800:1: rule__Action__Group_2__2 : rule__Action__Group_2__2__Impl rule__Action__Group_2__3 ;
    public final void rule__Action__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3804:1: ( rule__Action__Group_2__2__Impl rule__Action__Group_2__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3805:2: rule__Action__Group_2__2__Impl rule__Action__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__2__Impl_in_rule__Action__Group_2__27758);
            rule__Action__Group_2__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__3_in_rule__Action__Group_2__27761);
            rule__Action__Group_2__3();
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
    // $ANTLR end rule__Action__Group_2__2


    // $ANTLR start rule__Action__Group_2__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3812:1: rule__Action__Group_2__2__Impl : ( ( rule__Action__OperatorAssignment_2_2 ) ) ;
    public final void rule__Action__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3816:1: ( ( ( rule__Action__OperatorAssignment_2_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3817:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3817:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3818:1: ( rule__Action__OperatorAssignment_2_2 )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3819:1: ( rule__Action__OperatorAssignment_2_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3819:2: rule__Action__OperatorAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__OperatorAssignment_2_2_in_rule__Action__Group_2__2__Impl7788);
            rule__Action__OperatorAssignment_2_2();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 

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
    // $ANTLR end rule__Action__Group_2__2__Impl


    // $ANTLR start rule__Action__Group_2__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3829:1: rule__Action__Group_2__3 : rule__Action__Group_2__3__Impl ;
    public final void rule__Action__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3833:1: ( rule__Action__Group_2__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3834:2: rule__Action__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__3__Impl_in_rule__Action__Group_2__37818);
            rule__Action__Group_2__3__Impl();
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
    // $ANTLR end rule__Action__Group_2__3


    // $ANTLR start rule__Action__Group_2__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3840:1: rule__Action__Group_2__3__Impl : ( 'current' ) ;
    public final void rule__Action__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3844:1: ( ( 'current' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3845:1: ( 'current' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3845:1: ( 'current' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3846:1: 'current'
            {
             before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__Action__Group_2__3__Impl7846); 
             after(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 

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
    // $ANTLR end rule__Action__Group_2__3__Impl


    // $ANTLR start rule__Assignment__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3867:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3871:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3872:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__0__Impl_in_rule__Assignment__Group__07885);
            rule__Assignment__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__1_in_rule__Assignment__Group__07888);
            rule__Assignment__Group__1();
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
    // $ANTLR end rule__Assignment__Group__0


    // $ANTLR start rule__Assignment__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3879:1: rule__Assignment__Group__0__Impl : ( ( rule__Assignment__FeatureAssignment_0 ) ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3883:1: ( ( ( rule__Assignment__FeatureAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3884:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3884:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3885:1: ( rule__Assignment__FeatureAssignment_0 )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3886:1: ( rule__Assignment__FeatureAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3886:2: rule__Assignment__FeatureAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__FeatureAssignment_0_in_rule__Assignment__Group__0__Impl7915);
            rule__Assignment__FeatureAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 

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
    // $ANTLR end rule__Assignment__Group__0__Impl


    // $ANTLR start rule__Assignment__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3896:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3900:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3901:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__1__Impl_in_rule__Assignment__Group__17945);
            rule__Assignment__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__2_in_rule__Assignment__Group__17948);
            rule__Assignment__Group__2();
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
    // $ANTLR end rule__Assignment__Group__1


    // $ANTLR start rule__Assignment__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3908:1: rule__Assignment__Group__1__Impl : ( ( rule__Assignment__OperatorAssignment_1 ) ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3912:1: ( ( ( rule__Assignment__OperatorAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3913:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3913:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3914:1: ( rule__Assignment__OperatorAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3915:1: ( rule__Assignment__OperatorAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3915:2: rule__Assignment__OperatorAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__OperatorAssignment_1_in_rule__Assignment__Group__1__Impl7975);
            rule__Assignment__OperatorAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 

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
    // $ANTLR end rule__Assignment__Group__1__Impl


    // $ANTLR start rule__Assignment__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3925:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3929:1: ( rule__Assignment__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3930:2: rule__Assignment__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__2__Impl_in_rule__Assignment__Group__28005);
            rule__Assignment__Group__2__Impl();
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
    // $ANTLR end rule__Assignment__Group__2


    // $ANTLR start rule__Assignment__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3936:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__TerminalAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3940:1: ( ( ( rule__Assignment__TerminalAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3941:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3941:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3942:1: ( rule__Assignment__TerminalAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3943:1: ( rule__Assignment__TerminalAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3943:2: rule__Assignment__TerminalAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__TerminalAssignment_2_in_rule__Assignment__Group__2__Impl8032);
            rule__Assignment__TerminalAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getTerminalAssignment_2()); 

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
    // $ANTLR end rule__Assignment__Group__2__Impl


    // $ANTLR start rule__ParenthesizedAssignableElement__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3959:1: rule__ParenthesizedAssignableElement__Group__0 : rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 ;
    public final void rule__ParenthesizedAssignableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3963:1: ( rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3964:2: rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__0__Impl_in_rule__ParenthesizedAssignableElement__Group__08068);
            rule__ParenthesizedAssignableElement__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__1_in_rule__ParenthesizedAssignableElement__Group__08071);
            rule__ParenthesizedAssignableElement__Group__1();
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
    // $ANTLR end rule__ParenthesizedAssignableElement__Group__0


    // $ANTLR start rule__ParenthesizedAssignableElement__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3971:1: rule__ParenthesizedAssignableElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3975:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3976:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3976:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3977:1: '('
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedAssignableElement__Group__0__Impl8099); 
             after(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 

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
    // $ANTLR end rule__ParenthesizedAssignableElement__Group__0__Impl


    // $ANTLR start rule__ParenthesizedAssignableElement__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3990:1: rule__ParenthesizedAssignableElement__Group__1 : rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 ;
    public final void rule__ParenthesizedAssignableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3994:1: ( rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:3995:2: rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__1__Impl_in_rule__ParenthesizedAssignableElement__Group__18130);
            rule__ParenthesizedAssignableElement__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__2_in_rule__ParenthesizedAssignableElement__Group__18133);
            rule__ParenthesizedAssignableElement__Group__2();
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
    // $ANTLR end rule__ParenthesizedAssignableElement__Group__1


    // $ANTLR start rule__ParenthesizedAssignableElement__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4002:1: rule__ParenthesizedAssignableElement__Group__1__Impl : ( ruleAssignableAlternatives ) ;
    public final void rule__ParenthesizedAssignableElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4006:1: ( ( ruleAssignableAlternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4007:1: ( ruleAssignableAlternatives )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4007:1: ( ruleAssignableAlternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4008:1: ruleAssignableAlternatives
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group__1__Impl8160);
            ruleAssignableAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 

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
    // $ANTLR end rule__ParenthesizedAssignableElement__Group__1__Impl


    // $ANTLR start rule__ParenthesizedAssignableElement__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4019:1: rule__ParenthesizedAssignableElement__Group__2 : rule__ParenthesizedAssignableElement__Group__2__Impl ;
    public final void rule__ParenthesizedAssignableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4023:1: ( rule__ParenthesizedAssignableElement__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4024:2: rule__ParenthesizedAssignableElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__2__Impl_in_rule__ParenthesizedAssignableElement__Group__28189);
            rule__ParenthesizedAssignableElement__Group__2__Impl();
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
    // $ANTLR end rule__ParenthesizedAssignableElement__Group__2


    // $ANTLR start rule__ParenthesizedAssignableElement__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4030:1: rule__ParenthesizedAssignableElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4034:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4035:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4035:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4036:1: ')'
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group__2__Impl8217); 
             after(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 

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
    // $ANTLR end rule__ParenthesizedAssignableElement__Group__2__Impl


    // $ANTLR start rule__AssignableAlternatives__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4055:1: rule__AssignableAlternatives__Group__0 : rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 ;
    public final void rule__AssignableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4059:1: ( rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4060:2: rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__0__Impl_in_rule__AssignableAlternatives__Group__08254);
            rule__AssignableAlternatives__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__1_in_rule__AssignableAlternatives__Group__08257);
            rule__AssignableAlternatives__Group__1();
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
    // $ANTLR end rule__AssignableAlternatives__Group__0


    // $ANTLR start rule__AssignableAlternatives__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4067:1: rule__AssignableAlternatives__Group__0__Impl : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4071:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4072:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4072:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4073:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group__0__Impl8284);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 

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
    // $ANTLR end rule__AssignableAlternatives__Group__0__Impl


    // $ANTLR start rule__AssignableAlternatives__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4084:1: rule__AssignableAlternatives__Group__1 : rule__AssignableAlternatives__Group__1__Impl ;
    public final void rule__AssignableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4088:1: ( rule__AssignableAlternatives__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4089:2: rule__AssignableAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__1__Impl_in_rule__AssignableAlternatives__Group__18313);
            rule__AssignableAlternatives__Group__1__Impl();
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
    // $ANTLR end rule__AssignableAlternatives__Group__1


    // $ANTLR start rule__AssignableAlternatives__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4095:1: rule__AssignableAlternatives__Group__1__Impl : ( ( rule__AssignableAlternatives__Group_1__0 )? ) ;
    public final void rule__AssignableAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4099:1: ( ( ( rule__AssignableAlternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4100:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4100:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4101:1: ( rule__AssignableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4102:1: ( rule__AssignableAlternatives__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==30) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4102:2: rule__AssignableAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__0_in_rule__AssignableAlternatives__Group__1__Impl8340);
                    rule__AssignableAlternatives__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 

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
    // $ANTLR end rule__AssignableAlternatives__Group__1__Impl


    // $ANTLR start rule__AssignableAlternatives__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4116:1: rule__AssignableAlternatives__Group_1__0 : rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 ;
    public final void rule__AssignableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4120:1: ( rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4121:2: rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__0__Impl_in_rule__AssignableAlternatives__Group_1__08375);
            rule__AssignableAlternatives__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__1_in_rule__AssignableAlternatives__Group_1__08378);
            rule__AssignableAlternatives__Group_1__1();
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
    // $ANTLR end rule__AssignableAlternatives__Group_1__0


    // $ANTLR start rule__AssignableAlternatives__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4128:1: rule__AssignableAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__AssignableAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4132:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4133:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4133:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4134:1: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4135:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4137:1: 
            {
            }

             after(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AssignableAlternatives__Group_1__0__Impl


    // $ANTLR start rule__AssignableAlternatives__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4147:1: rule__AssignableAlternatives__Group_1__1 : rule__AssignableAlternatives__Group_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4151:1: ( rule__AssignableAlternatives__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4152:2: rule__AssignableAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__1__Impl_in_rule__AssignableAlternatives__Group_1__18436);
            rule__AssignableAlternatives__Group_1__1__Impl();
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
    // $ANTLR end rule__AssignableAlternatives__Group_1__1


    // $ANTLR start rule__AssignableAlternatives__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4158:1: rule__AssignableAlternatives__Group_1__1__Impl : ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__AssignableAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4162:1: ( ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4163:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4163:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4164:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4164:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4165:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4166:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4166:2: rule__AssignableAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__1__Impl8465);
            rule__AssignableAlternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4169:1: ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4170:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4171:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==30) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4171:2: rule__AssignableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__1__Impl8477);
            	    rule__AssignableAlternatives__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }


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
    // $ANTLR end rule__AssignableAlternatives__Group_1__1__Impl


    // $ANTLR start rule__AssignableAlternatives__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4186:1: rule__AssignableAlternatives__Group_1_1__0 : rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 ;
    public final void rule__AssignableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4190:1: ( rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4191:2: rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0__Impl_in_rule__AssignableAlternatives__Group_1_1__08514);
            rule__AssignableAlternatives__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__1_in_rule__AssignableAlternatives__Group_1_1__08517);
            rule__AssignableAlternatives__Group_1_1__1();
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
    // $ANTLR end rule__AssignableAlternatives__Group_1_1__0


    // $ANTLR start rule__AssignableAlternatives__Group_1_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4198:1: rule__AssignableAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__AssignableAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4202:1: ( ( '|' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4203:1: ( '|' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4203:1: ( '|' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4204:1: '|'
            {
             before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__AssignableAlternatives__Group_1_1__0__Impl8545); 
             after(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

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
    // $ANTLR end rule__AssignableAlternatives__Group_1_1__0__Impl


    // $ANTLR start rule__AssignableAlternatives__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4217:1: rule__AssignableAlternatives__Group_1_1__1 : rule__AssignableAlternatives__Group_1_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4221:1: ( rule__AssignableAlternatives__Group_1_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4222:2: rule__AssignableAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__1__Impl_in_rule__AssignableAlternatives__Group_1_1__18576);
            rule__AssignableAlternatives__Group_1_1__1__Impl();
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
    // $ANTLR end rule__AssignableAlternatives__Group_1_1__1


    // $ANTLR start rule__AssignableAlternatives__Group_1_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4228:1: rule__AssignableAlternatives__Group_1_1__1__Impl : ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4232:1: ( ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4233:1: ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4233:1: ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4234:1: ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4235:1: ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4235:2: rule__AssignableAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__GroupsAssignment_1_1_1_in_rule__AssignableAlternatives__Group_1_1__1__Impl8603);
            rule__AssignableAlternatives__GroupsAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignment_1_1_1()); 

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
    // $ANTLR end rule__AssignableAlternatives__Group_1_1__1__Impl


    // $ANTLR start rule__CrossReference__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4249:1: rule__CrossReference__Group__0 : rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 ;
    public final void rule__CrossReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4253:1: ( rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4254:2: rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__0__Impl_in_rule__CrossReference__Group__08637);
            rule__CrossReference__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__1_in_rule__CrossReference__Group__08640);
            rule__CrossReference__Group__1();
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
    // $ANTLR end rule__CrossReference__Group__0


    // $ANTLR start rule__CrossReference__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4261:1: rule__CrossReference__Group__0__Impl : ( '[' ) ;
    public final void rule__CrossReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4265:1: ( ( '[' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4266:1: ( '[' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4266:1: ( '[' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4267:1: '['
            {
             before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__CrossReference__Group__0__Impl8668); 
             after(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 

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
    // $ANTLR end rule__CrossReference__Group__0__Impl


    // $ANTLR start rule__CrossReference__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4280:1: rule__CrossReference__Group__1 : rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 ;
    public final void rule__CrossReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4284:1: ( rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4285:2: rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__1__Impl_in_rule__CrossReference__Group__18699);
            rule__CrossReference__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__2_in_rule__CrossReference__Group__18702);
            rule__CrossReference__Group__2();
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
    // $ANTLR end rule__CrossReference__Group__1


    // $ANTLR start rule__CrossReference__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4292:1: rule__CrossReference__Group__1__Impl : ( ( rule__CrossReference__TypeAssignment_1 ) ) ;
    public final void rule__CrossReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4296:1: ( ( ( rule__CrossReference__TypeAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4297:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4297:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4298:1: ( rule__CrossReference__TypeAssignment_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4299:1: ( rule__CrossReference__TypeAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4299:2: rule__CrossReference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__TypeAssignment_1_in_rule__CrossReference__Group__1__Impl8729);
            rule__CrossReference__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 

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
    // $ANTLR end rule__CrossReference__Group__1__Impl


    // $ANTLR start rule__CrossReference__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4309:1: rule__CrossReference__Group__2 : rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 ;
    public final void rule__CrossReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4313:1: ( rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4314:2: rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__2__Impl_in_rule__CrossReference__Group__28759);
            rule__CrossReference__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__3_in_rule__CrossReference__Group__28762);
            rule__CrossReference__Group__3();
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
    // $ANTLR end rule__CrossReference__Group__2


    // $ANTLR start rule__CrossReference__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4321:1: rule__CrossReference__Group__2__Impl : ( ( rule__CrossReference__Group_2__0 )? ) ;
    public final void rule__CrossReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4325:1: ( ( ( rule__CrossReference__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4326:1: ( ( rule__CrossReference__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4326:1: ( ( rule__CrossReference__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4327:1: ( rule__CrossReference__Group_2__0 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4328:1: ( rule__CrossReference__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==30) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4328:2: rule__CrossReference__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__0_in_rule__CrossReference__Group__2__Impl8789);
                    rule__CrossReference__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCrossReferenceAccess().getGroup_2()); 

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
    // $ANTLR end rule__CrossReference__Group__2__Impl


    // $ANTLR start rule__CrossReference__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4338:1: rule__CrossReference__Group__3 : rule__CrossReference__Group__3__Impl ;
    public final void rule__CrossReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4342:1: ( rule__CrossReference__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4343:2: rule__CrossReference__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__3__Impl_in_rule__CrossReference__Group__38820);
            rule__CrossReference__Group__3__Impl();
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
    // $ANTLR end rule__CrossReference__Group__3


    // $ANTLR start rule__CrossReference__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4349:1: rule__CrossReference__Group__3__Impl : ( ']' ) ;
    public final void rule__CrossReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4353:1: ( ( ']' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4354:1: ( ']' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4354:1: ( ']' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4355:1: ']'
            {
             before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__CrossReference__Group__3__Impl8848); 
             after(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 

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
    // $ANTLR end rule__CrossReference__Group__3__Impl


    // $ANTLR start rule__CrossReference__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4376:1: rule__CrossReference__Group_2__0 : rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 ;
    public final void rule__CrossReference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4380:1: ( rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4381:2: rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__0__Impl_in_rule__CrossReference__Group_2__08887);
            rule__CrossReference__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__1_in_rule__CrossReference__Group_2__08890);
            rule__CrossReference__Group_2__1();
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
    // $ANTLR end rule__CrossReference__Group_2__0


    // $ANTLR start rule__CrossReference__Group_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4388:1: rule__CrossReference__Group_2__0__Impl : ( '|' ) ;
    public final void rule__CrossReference__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4392:1: ( ( '|' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4393:1: ( '|' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4393:1: ( '|' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4394:1: '|'
            {
             before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__CrossReference__Group_2__0__Impl8918); 
             after(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 

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
    // $ANTLR end rule__CrossReference__Group_2__0__Impl


    // $ANTLR start rule__CrossReference__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4407:1: rule__CrossReference__Group_2__1 : rule__CrossReference__Group_2__1__Impl ;
    public final void rule__CrossReference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4411:1: ( rule__CrossReference__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4412:2: rule__CrossReference__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__1__Impl_in_rule__CrossReference__Group_2__18949);
            rule__CrossReference__Group_2__1__Impl();
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
    // $ANTLR end rule__CrossReference__Group_2__1


    // $ANTLR start rule__CrossReference__Group_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4418:1: rule__CrossReference__Group_2__1__Impl : ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) ;
    public final void rule__CrossReference__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4422:1: ( ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4423:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4423:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4424:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4425:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4425:2: rule__CrossReference__TerminalAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__TerminalAssignment_2_1_in_rule__CrossReference__Group_2__1__Impl8976);
            rule__CrossReference__TerminalAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 

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
    // $ANTLR end rule__CrossReference__Group_2__1__Impl


    // $ANTLR start rule__ParenthesizedCrossReferenceableElement__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4439:1: rule__ParenthesizedCrossReferenceableElement__Group__0 : rule__ParenthesizedCrossReferenceableElement__Group__0__Impl rule__ParenthesizedCrossReferenceableElement__Group__1 ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4443:1: ( rule__ParenthesizedCrossReferenceableElement__Group__0__Impl rule__ParenthesizedCrossReferenceableElement__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4444:2: rule__ParenthesizedCrossReferenceableElement__Group__0__Impl rule__ParenthesizedCrossReferenceableElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__0__Impl_in_rule__ParenthesizedCrossReferenceableElement__Group__09010);
            rule__ParenthesizedCrossReferenceableElement__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__1_in_rule__ParenthesizedCrossReferenceableElement__Group__09013);
            rule__ParenthesizedCrossReferenceableElement__Group__1();
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
    // $ANTLR end rule__ParenthesizedCrossReferenceableElement__Group__0


    // $ANTLR start rule__ParenthesizedCrossReferenceableElement__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4451:1: rule__ParenthesizedCrossReferenceableElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4455:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4456:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4456:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4457:1: '('
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedCrossReferenceableElement__Group__0__Impl9041); 
             after(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0()); 

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
    // $ANTLR end rule__ParenthesizedCrossReferenceableElement__Group__0__Impl


    // $ANTLR start rule__ParenthesizedCrossReferenceableElement__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4470:1: rule__ParenthesizedCrossReferenceableElement__Group__1 : rule__ParenthesizedCrossReferenceableElement__Group__1__Impl rule__ParenthesizedCrossReferenceableElement__Group__2 ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4474:1: ( rule__ParenthesizedCrossReferenceableElement__Group__1__Impl rule__ParenthesizedCrossReferenceableElement__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4475:2: rule__ParenthesizedCrossReferenceableElement__Group__1__Impl rule__ParenthesizedCrossReferenceableElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__1__Impl_in_rule__ParenthesizedCrossReferenceableElement__Group__19072);
            rule__ParenthesizedCrossReferenceableElement__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__2_in_rule__ParenthesizedCrossReferenceableElement__Group__19075);
            rule__ParenthesizedCrossReferenceableElement__Group__2();
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
    // $ANTLR end rule__ParenthesizedCrossReferenceableElement__Group__1


    // $ANTLR start rule__ParenthesizedCrossReferenceableElement__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4482:1: rule__ParenthesizedCrossReferenceableElement__Group__1__Impl : ( ruleCrossReferenceableAlternatives ) ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4486:1: ( ( ruleCrossReferenceableAlternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4487:1: ( ruleCrossReferenceableAlternatives )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4487:1: ( ruleCrossReferenceableAlternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4488:1: ruleCrossReferenceableAlternatives
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getCrossReferenceableAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableAlternatives_in_rule__ParenthesizedCrossReferenceableElement__Group__1__Impl9102);
            ruleCrossReferenceableAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getCrossReferenceableAlternativesParserRuleCall_1()); 

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
    // $ANTLR end rule__ParenthesizedCrossReferenceableElement__Group__1__Impl


    // $ANTLR start rule__ParenthesizedCrossReferenceableElement__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4499:1: rule__ParenthesizedCrossReferenceableElement__Group__2 : rule__ParenthesizedCrossReferenceableElement__Group__2__Impl ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4503:1: ( rule__ParenthesizedCrossReferenceableElement__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4504:2: rule__ParenthesizedCrossReferenceableElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__2__Impl_in_rule__ParenthesizedCrossReferenceableElement__Group__29131);
            rule__ParenthesizedCrossReferenceableElement__Group__2__Impl();
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
    // $ANTLR end rule__ParenthesizedCrossReferenceableElement__Group__2


    // $ANTLR start rule__ParenthesizedCrossReferenceableElement__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4510:1: rule__ParenthesizedCrossReferenceableElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4514:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4515:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4515:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4516:1: ')'
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedCrossReferenceableElement__Group__2__Impl9159); 
             after(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getRightParenthesisKeyword_2()); 

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
    // $ANTLR end rule__ParenthesizedCrossReferenceableElement__Group__2__Impl


    // $ANTLR start rule__CrossReferenceableAlternatives__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4535:1: rule__CrossReferenceableAlternatives__Group__0 : rule__CrossReferenceableAlternatives__Group__0__Impl rule__CrossReferenceableAlternatives__Group__1 ;
    public final void rule__CrossReferenceableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4539:1: ( rule__CrossReferenceableAlternatives__Group__0__Impl rule__CrossReferenceableAlternatives__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4540:2: rule__CrossReferenceableAlternatives__Group__0__Impl rule__CrossReferenceableAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group__0__Impl_in_rule__CrossReferenceableAlternatives__Group__09196);
            rule__CrossReferenceableAlternatives__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group__1_in_rule__CrossReferenceableAlternatives__Group__09199);
            rule__CrossReferenceableAlternatives__Group__1();
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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group__0


    // $ANTLR start rule__CrossReferenceableAlternatives__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4547:1: rule__CrossReferenceableAlternatives__Group__0__Impl : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReferenceableAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4551:1: ( ( ruleCrossReferenceableTerminal ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4552:1: ( ruleCrossReferenceableTerminal )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4552:1: ( ruleCrossReferenceableTerminal )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4553:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getCrossReferenceableTerminalParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReferenceableAlternatives__Group__0__Impl9226);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getCrossReferenceableTerminalParserRuleCall_0()); 

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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group__0__Impl


    // $ANTLR start rule__CrossReferenceableAlternatives__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4564:1: rule__CrossReferenceableAlternatives__Group__1 : rule__CrossReferenceableAlternatives__Group__1__Impl ;
    public final void rule__CrossReferenceableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4568:1: ( rule__CrossReferenceableAlternatives__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4569:2: rule__CrossReferenceableAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group__1__Impl_in_rule__CrossReferenceableAlternatives__Group__19255);
            rule__CrossReferenceableAlternatives__Group__1__Impl();
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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group__1


    // $ANTLR start rule__CrossReferenceableAlternatives__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4575:1: rule__CrossReferenceableAlternatives__Group__1__Impl : ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? ) ;
    public final void rule__CrossReferenceableAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4579:1: ( ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4580:1: ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4580:1: ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4581:1: ( rule__CrossReferenceableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4582:1: ( rule__CrossReferenceableAlternatives__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==30) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4582:2: rule__CrossReferenceableAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group_1__0_in_rule__CrossReferenceableAlternatives__Group__1__Impl9282);
                    rule__CrossReferenceableAlternatives__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1()); 

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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group__1__Impl


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4596:1: rule__CrossReferenceableAlternatives__Group_1__0 : rule__CrossReferenceableAlternatives__Group_1__0__Impl rule__CrossReferenceableAlternatives__Group_1__1 ;
    public final void rule__CrossReferenceableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4600:1: ( rule__CrossReferenceableAlternatives__Group_1__0__Impl rule__CrossReferenceableAlternatives__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4601:2: rule__CrossReferenceableAlternatives__Group_1__0__Impl rule__CrossReferenceableAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group_1__0__Impl_in_rule__CrossReferenceableAlternatives__Group_1__09317);
            rule__CrossReferenceableAlternatives__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group_1__1_in_rule__CrossReferenceableAlternatives__Group_1__09320);
            rule__CrossReferenceableAlternatives__Group_1__1();
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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group_1__0


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4608:1: rule__CrossReferenceableAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4612:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4613:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4613:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4614:1: ()
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4615:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4617:1: 
            {
            }

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__CrossReferenceableAlternatives__Group_1__0__Impl


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4627:1: rule__CrossReferenceableAlternatives__Group_1__1 : rule__CrossReferenceableAlternatives__Group_1__1__Impl ;
    public final void rule__CrossReferenceableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4631:1: ( rule__CrossReferenceableAlternatives__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4632:2: rule__CrossReferenceableAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group_1__1__Impl_in_rule__CrossReferenceableAlternatives__Group_1__19378);
            rule__CrossReferenceableAlternatives__Group_1__1__Impl();
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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group_1__1


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4638:1: rule__CrossReferenceableAlternatives__Group_1__1__Impl : ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4642:1: ( ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4643:1: ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4643:1: ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4644:1: ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4644:1: ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4645:1: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4646:1: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4646:2: rule__CrossReferenceableAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__0_in_rule__CrossReferenceableAlternatives__Group_1__1__Impl9407);
            rule__CrossReferenceableAlternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4649:1: ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4650:1: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4651:1: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==30) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4651:2: rule__CrossReferenceableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__0_in_rule__CrossReferenceableAlternatives__Group_1__1__Impl9419);
            	    rule__CrossReferenceableAlternatives__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 

            }


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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group_1__1__Impl


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4666:1: rule__CrossReferenceableAlternatives__Group_1_1__0 : rule__CrossReferenceableAlternatives__Group_1_1__0__Impl rule__CrossReferenceableAlternatives__Group_1_1__1 ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4670:1: ( rule__CrossReferenceableAlternatives__Group_1_1__0__Impl rule__CrossReferenceableAlternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4671:2: rule__CrossReferenceableAlternatives__Group_1_1__0__Impl rule__CrossReferenceableAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__0__Impl_in_rule__CrossReferenceableAlternatives__Group_1_1__09456);
            rule__CrossReferenceableAlternatives__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__1_in_rule__CrossReferenceableAlternatives__Group_1_1__09459);
            rule__CrossReferenceableAlternatives__Group_1_1__1();
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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group_1_1__0


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4678:1: rule__CrossReferenceableAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4682:1: ( ( '|' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4683:1: ( '|' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4683:1: ( '|' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4684:1: '|'
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__CrossReferenceableAlternatives__Group_1_1__0__Impl9487); 
             after(grammarAccess.getCrossReferenceableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group_1_1__0__Impl


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4697:1: rule__CrossReferenceableAlternatives__Group_1_1__1 : rule__CrossReferenceableAlternatives__Group_1_1__1__Impl ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4701:1: ( rule__CrossReferenceableAlternatives__Group_1_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4702:2: rule__CrossReferenceableAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__1__Impl_in_rule__CrossReferenceableAlternatives__Group_1_1__19518);
            rule__CrossReferenceableAlternatives__Group_1_1__1__Impl();
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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group_1_1__1


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4708:1: rule__CrossReferenceableAlternatives__Group_1_1__1__Impl : ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4712:1: ( ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4713:1: ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4713:1: ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4714:1: ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4715:1: ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4715:2: rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1_in_rule__CrossReferenceableAlternatives__Group_1_1__1__Impl9545);
            rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsAssignment_1_1_1()); 

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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group_1_1__1__Impl


    // $ANTLR start rule__ParenthesizedElement__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4729:1: rule__ParenthesizedElement__Group__0 : rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 ;
    public final void rule__ParenthesizedElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4733:1: ( rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4734:2: rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__0__Impl_in_rule__ParenthesizedElement__Group__09579);
            rule__ParenthesizedElement__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__1_in_rule__ParenthesizedElement__Group__09582);
            rule__ParenthesizedElement__Group__1();
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
    // $ANTLR end rule__ParenthesizedElement__Group__0


    // $ANTLR start rule__ParenthesizedElement__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4741:1: rule__ParenthesizedElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4745:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4746:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4746:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4747:1: '('
            {
             before(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedElement__Group__0__Impl9610); 
             after(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 

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
    // $ANTLR end rule__ParenthesizedElement__Group__0__Impl


    // $ANTLR start rule__ParenthesizedElement__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4760:1: rule__ParenthesizedElement__Group__1 : rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 ;
    public final void rule__ParenthesizedElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4764:1: ( rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4765:2: rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__1__Impl_in_rule__ParenthesizedElement__Group__19641);
            rule__ParenthesizedElement__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__2_in_rule__ParenthesizedElement__Group__19644);
            rule__ParenthesizedElement__Group__2();
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
    // $ANTLR end rule__ParenthesizedElement__Group__1


    // $ANTLR start rule__ParenthesizedElement__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4772:1: rule__ParenthesizedElement__Group__1__Impl : ( ruleAlternatives ) ;
    public final void rule__ParenthesizedElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4776:1: ( ( ruleAlternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4777:1: ( ruleAlternatives )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4777:1: ( ruleAlternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4778:1: ruleAlternatives
            {
             before(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group__1__Impl9671);
            ruleAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 

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
    // $ANTLR end rule__ParenthesizedElement__Group__1__Impl


    // $ANTLR start rule__ParenthesizedElement__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4789:1: rule__ParenthesizedElement__Group__2 : rule__ParenthesizedElement__Group__2__Impl ;
    public final void rule__ParenthesizedElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4793:1: ( rule__ParenthesizedElement__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4794:2: rule__ParenthesizedElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__2__Impl_in_rule__ParenthesizedElement__Group__29700);
            rule__ParenthesizedElement__Group__2__Impl();
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
    // $ANTLR end rule__ParenthesizedElement__Group__2


    // $ANTLR start rule__ParenthesizedElement__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4800:1: rule__ParenthesizedElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4804:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4805:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4805:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4806:1: ')'
            {
             before(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedElement__Group__2__Impl9728); 
             after(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 

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
    // $ANTLR end rule__ParenthesizedElement__Group__2__Impl


    // $ANTLR start rule__TerminalRule__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4825:1: rule__TerminalRule__Group__0 : rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 ;
    public final void rule__TerminalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4829:1: ( rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4830:2: rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__0__Impl_in_rule__TerminalRule__Group__09765);
            rule__TerminalRule__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__1_in_rule__TerminalRule__Group__09768);
            rule__TerminalRule__Group__1();
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
    // $ANTLR end rule__TerminalRule__Group__0


    // $ANTLR start rule__TerminalRule__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4837:1: rule__TerminalRule__Group__0__Impl : ( 'terminal' ) ;
    public final void rule__TerminalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4841:1: ( ( 'terminal' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4842:1: ( 'terminal' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4842:1: ( 'terminal' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4843:1: 'terminal'
            {
             before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__TerminalRule__Group__0__Impl9796); 
             after(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 

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
    // $ANTLR end rule__TerminalRule__Group__0__Impl


    // $ANTLR start rule__TerminalRule__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4856:1: rule__TerminalRule__Group__1 : rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 ;
    public final void rule__TerminalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4860:1: ( rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4861:2: rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__1__Impl_in_rule__TerminalRule__Group__19827);
            rule__TerminalRule__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__2_in_rule__TerminalRule__Group__19830);
            rule__TerminalRule__Group__2();
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
    // $ANTLR end rule__TerminalRule__Group__1


    // $ANTLR start rule__TerminalRule__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4868:1: rule__TerminalRule__Group__1__Impl : ( ( rule__TerminalRule__NameAssignment_1 ) ) ;
    public final void rule__TerminalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4872:1: ( ( ( rule__TerminalRule__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4873:1: ( ( rule__TerminalRule__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4873:1: ( ( rule__TerminalRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4874:1: ( rule__TerminalRule__NameAssignment_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4875:1: ( rule__TerminalRule__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4875:2: rule__TerminalRule__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__NameAssignment_1_in_rule__TerminalRule__Group__1__Impl9857);
            rule__TerminalRule__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 

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
    // $ANTLR end rule__TerminalRule__Group__1__Impl


    // $ANTLR start rule__TerminalRule__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4885:1: rule__TerminalRule__Group__2 : rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 ;
    public final void rule__TerminalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4889:1: ( rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4890:2: rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__2__Impl_in_rule__TerminalRule__Group__29887);
            rule__TerminalRule__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__3_in_rule__TerminalRule__Group__29890);
            rule__TerminalRule__Group__3();
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
    // $ANTLR end rule__TerminalRule__Group__2


    // $ANTLR start rule__TerminalRule__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4897:1: rule__TerminalRule__Group__2__Impl : ( ( rule__TerminalRule__Group_2__0 )? ) ;
    public final void rule__TerminalRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4901:1: ( ( ( rule__TerminalRule__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4902:1: ( ( rule__TerminalRule__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4902:1: ( ( rule__TerminalRule__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4903:1: ( rule__TerminalRule__Group_2__0 )?
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4904:1: ( rule__TerminalRule__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==28) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4904:2: rule__TerminalRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_2__0_in_rule__TerminalRule__Group__2__Impl9917);
                    rule__TerminalRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalRuleAccess().getGroup_2()); 

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
    // $ANTLR end rule__TerminalRule__Group__2__Impl


    // $ANTLR start rule__TerminalRule__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4914:1: rule__TerminalRule__Group__3 : rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 ;
    public final void rule__TerminalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4918:1: ( rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4919:2: rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__3__Impl_in_rule__TerminalRule__Group__39948);
            rule__TerminalRule__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__4_in_rule__TerminalRule__Group__39951);
            rule__TerminalRule__Group__4();
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
    // $ANTLR end rule__TerminalRule__Group__3


    // $ANTLR start rule__TerminalRule__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4926:1: rule__TerminalRule__Group__3__Impl : ( ':' ) ;
    public final void rule__TerminalRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4930:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4931:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4931:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4932:1: ':'
            {
             before(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__TerminalRule__Group__3__Impl9979); 
             after(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 

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
    // $ANTLR end rule__TerminalRule__Group__3__Impl


    // $ANTLR start rule__TerminalRule__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4945:1: rule__TerminalRule__Group__4 : rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5 ;
    public final void rule__TerminalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4949:1: ( rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4950:2: rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__4__Impl_in_rule__TerminalRule__Group__410010);
            rule__TerminalRule__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__5_in_rule__TerminalRule__Group__410013);
            rule__TerminalRule__Group__5();
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
    // $ANTLR end rule__TerminalRule__Group__4


    // $ANTLR start rule__TerminalRule__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4957:1: rule__TerminalRule__Group__4__Impl : ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) ;
    public final void rule__TerminalRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4961:1: ( ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4962:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4962:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4963:1: ( rule__TerminalRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4964:1: ( rule__TerminalRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4964:2: rule__TerminalRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__AlternativesAssignment_4_in_rule__TerminalRule__Group__4__Impl10040);
            rule__TerminalRule__AlternativesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 

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
    // $ANTLR end rule__TerminalRule__Group__4__Impl


    // $ANTLR start rule__TerminalRule__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4974:1: rule__TerminalRule__Group__5 : rule__TerminalRule__Group__5__Impl ;
    public final void rule__TerminalRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4978:1: ( rule__TerminalRule__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4979:2: rule__TerminalRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__5__Impl_in_rule__TerminalRule__Group__510070);
            rule__TerminalRule__Group__5__Impl();
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
    // $ANTLR end rule__TerminalRule__Group__5


    // $ANTLR start rule__TerminalRule__Group__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4985:1: rule__TerminalRule__Group__5__Impl : ( ';' ) ;
    public final void rule__TerminalRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4989:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4990:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4990:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:4991:1: ';'
            {
             before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__TerminalRule__Group__5__Impl10098); 
             after(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); 

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
    // $ANTLR end rule__TerminalRule__Group__5__Impl


    // $ANTLR start rule__TerminalRule__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5016:1: rule__TerminalRule__Group_2__0 : rule__TerminalRule__Group_2__0__Impl rule__TerminalRule__Group_2__1 ;
    public final void rule__TerminalRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5020:1: ( rule__TerminalRule__Group_2__0__Impl rule__TerminalRule__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5021:2: rule__TerminalRule__Group_2__0__Impl rule__TerminalRule__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_2__0__Impl_in_rule__TerminalRule__Group_2__010141);
            rule__TerminalRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_2__1_in_rule__TerminalRule__Group_2__010144);
            rule__TerminalRule__Group_2__1();
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
    // $ANTLR end rule__TerminalRule__Group_2__0


    // $ANTLR start rule__TerminalRule__Group_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5028:1: rule__TerminalRule__Group_2__0__Impl : ( 'returns' ) ;
    public final void rule__TerminalRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5032:1: ( ( 'returns' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5033:1: ( 'returns' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5033:1: ( 'returns' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5034:1: 'returns'
            {
             before(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__TerminalRule__Group_2__0__Impl10172); 
             after(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0()); 

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
    // $ANTLR end rule__TerminalRule__Group_2__0__Impl


    // $ANTLR start rule__TerminalRule__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5047:1: rule__TerminalRule__Group_2__1 : rule__TerminalRule__Group_2__1__Impl ;
    public final void rule__TerminalRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5051:1: ( rule__TerminalRule__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5052:2: rule__TerminalRule__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_2__1__Impl_in_rule__TerminalRule__Group_2__110203);
            rule__TerminalRule__Group_2__1__Impl();
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
    // $ANTLR end rule__TerminalRule__Group_2__1


    // $ANTLR start rule__TerminalRule__Group_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5058:1: rule__TerminalRule__Group_2__1__Impl : ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) ;
    public final void rule__TerminalRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5062:1: ( ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5063:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5063:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5064:1: ( rule__TerminalRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5065:1: ( rule__TerminalRule__TypeAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5065:2: rule__TerminalRule__TypeAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__TypeAssignment_2_1_in_rule__TerminalRule__Group_2__1__Impl10230);
            rule__TerminalRule__TypeAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1()); 

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
    // $ANTLR end rule__TerminalRule__Group_2__1__Impl


    // $ANTLR start rule__TerminalAlternatives__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5079:1: rule__TerminalAlternatives__Group__0 : rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 ;
    public final void rule__TerminalAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5083:1: ( rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5084:2: rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__0__Impl_in_rule__TerminalAlternatives__Group__010264);
            rule__TerminalAlternatives__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__1_in_rule__TerminalAlternatives__Group__010267);
            rule__TerminalAlternatives__Group__1();
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
    // $ANTLR end rule__TerminalAlternatives__Group__0


    // $ANTLR start rule__TerminalAlternatives__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5091:1: rule__TerminalAlternatives__Group__0__Impl : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5095:1: ( ( ruleTerminalGroup ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5096:1: ( ruleTerminalGroup )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5096:1: ( ruleTerminalGroup )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5097:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group__0__Impl10294);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 

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
    // $ANTLR end rule__TerminalAlternatives__Group__0__Impl


    // $ANTLR start rule__TerminalAlternatives__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5108:1: rule__TerminalAlternatives__Group__1 : rule__TerminalAlternatives__Group__1__Impl ;
    public final void rule__TerminalAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5112:1: ( rule__TerminalAlternatives__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5113:2: rule__TerminalAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__1__Impl_in_rule__TerminalAlternatives__Group__110323);
            rule__TerminalAlternatives__Group__1__Impl();
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
    // $ANTLR end rule__TerminalAlternatives__Group__1


    // $ANTLR start rule__TerminalAlternatives__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5119:1: rule__TerminalAlternatives__Group__1__Impl : ( ( rule__TerminalAlternatives__Group_1__0 )? ) ;
    public final void rule__TerminalAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5123:1: ( ( ( rule__TerminalAlternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5124:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5124:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5125:1: ( rule__TerminalAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5126:1: ( rule__TerminalAlternatives__Group_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==30) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5126:2: rule__TerminalAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__0_in_rule__TerminalAlternatives__Group__1__Impl10350);
                    rule__TerminalAlternatives__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 

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
    // $ANTLR end rule__TerminalAlternatives__Group__1__Impl


    // $ANTLR start rule__TerminalAlternatives__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5140:1: rule__TerminalAlternatives__Group_1__0 : rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 ;
    public final void rule__TerminalAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5144:1: ( rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5145:2: rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__0__Impl_in_rule__TerminalAlternatives__Group_1__010385);
            rule__TerminalAlternatives__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__1_in_rule__TerminalAlternatives__Group_1__010388);
            rule__TerminalAlternatives__Group_1__1();
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
    // $ANTLR end rule__TerminalAlternatives__Group_1__0


    // $ANTLR start rule__TerminalAlternatives__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5152:1: rule__TerminalAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5156:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5157:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5157:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5158:1: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5159:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5161:1: 
            {
            }

             after(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TerminalAlternatives__Group_1__0__Impl


    // $ANTLR start rule__TerminalAlternatives__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5171:1: rule__TerminalAlternatives__Group_1__1 : rule__TerminalAlternatives__Group_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5175:1: ( rule__TerminalAlternatives__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5176:2: rule__TerminalAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__1__Impl_in_rule__TerminalAlternatives__Group_1__110446);
            rule__TerminalAlternatives__Group_1__1__Impl();
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
    // $ANTLR end rule__TerminalAlternatives__Group_1__1


    // $ANTLR start rule__TerminalAlternatives__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5182:1: rule__TerminalAlternatives__Group_1__1__Impl : ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__TerminalAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5186:1: ( ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5187:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5187:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5188:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5188:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5189:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5190:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5190:2: rule__TerminalAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__1__Impl10475);
            rule__TerminalAlternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5193:1: ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5194:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5195:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==30) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5195:2: rule__TerminalAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__1__Impl10487);
            	    rule__TerminalAlternatives__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }


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
    // $ANTLR end rule__TerminalAlternatives__Group_1__1__Impl


    // $ANTLR start rule__TerminalAlternatives__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5210:1: rule__TerminalAlternatives__Group_1_1__0 : rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 ;
    public final void rule__TerminalAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5214:1: ( rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5215:2: rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0__Impl_in_rule__TerminalAlternatives__Group_1_1__010524);
            rule__TerminalAlternatives__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__1_in_rule__TerminalAlternatives__Group_1_1__010527);
            rule__TerminalAlternatives__Group_1_1__1();
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
    // $ANTLR end rule__TerminalAlternatives__Group_1_1__0


    // $ANTLR start rule__TerminalAlternatives__Group_1_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5222:1: rule__TerminalAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__TerminalAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5226:1: ( ( '|' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5227:1: ( '|' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5227:1: ( '|' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5228:1: '|'
            {
             before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__TerminalAlternatives__Group_1_1__0__Impl10555); 
             after(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

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
    // $ANTLR end rule__TerminalAlternatives__Group_1_1__0__Impl


    // $ANTLR start rule__TerminalAlternatives__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5241:1: rule__TerminalAlternatives__Group_1_1__1 : rule__TerminalAlternatives__Group_1_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5245:1: ( rule__TerminalAlternatives__Group_1_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5246:2: rule__TerminalAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__1__Impl_in_rule__TerminalAlternatives__Group_1_1__110586);
            rule__TerminalAlternatives__Group_1_1__1__Impl();
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
    // $ANTLR end rule__TerminalAlternatives__Group_1_1__1


    // $ANTLR start rule__TerminalAlternatives__Group_1_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5252:1: rule__TerminalAlternatives__Group_1_1__1__Impl : ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5256:1: ( ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5257:1: ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5257:1: ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5258:1: ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5259:1: ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5259:2: rule__TerminalAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__GroupsAssignment_1_1_1_in_rule__TerminalAlternatives__Group_1_1__1__Impl10613);
            rule__TerminalAlternatives__GroupsAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroupsAssignment_1_1_1()); 

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
    // $ANTLR end rule__TerminalAlternatives__Group_1_1__1__Impl


    // $ANTLR start rule__TerminalGroup__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5273:1: rule__TerminalGroup__Group__0 : rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 ;
    public final void rule__TerminalGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5277:1: ( rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5278:2: rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__0__Impl_in_rule__TerminalGroup__Group__010647);
            rule__TerminalGroup__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__1_in_rule__TerminalGroup__Group__010650);
            rule__TerminalGroup__Group__1();
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
    // $ANTLR end rule__TerminalGroup__Group__0


    // $ANTLR start rule__TerminalGroup__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5285:1: rule__TerminalGroup__Group__0__Impl : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5289:1: ( ( ruleTerminalToken ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5290:1: ( ruleTerminalToken )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5290:1: ( ruleTerminalToken )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5291:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group__0__Impl10677);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 

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
    // $ANTLR end rule__TerminalGroup__Group__0__Impl


    // $ANTLR start rule__TerminalGroup__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5302:1: rule__TerminalGroup__Group__1 : rule__TerminalGroup__Group__1__Impl ;
    public final void rule__TerminalGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5306:1: ( rule__TerminalGroup__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5307:2: rule__TerminalGroup__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__1__Impl_in_rule__TerminalGroup__Group__110706);
            rule__TerminalGroup__Group__1__Impl();
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
    // $ANTLR end rule__TerminalGroup__Group__1


    // $ANTLR start rule__TerminalGroup__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5313:1: rule__TerminalGroup__Group__1__Impl : ( ( rule__TerminalGroup__Group_1__0 )? ) ;
    public final void rule__TerminalGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5317:1: ( ( ( rule__TerminalGroup__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5318:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5318:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5319:1: ( rule__TerminalGroup__Group_1__0 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5320:1: ( rule__TerminalGroup__Group_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_STRING)||LA43_0==20||LA43_0==22||(LA43_0>=37 && LA43_0<=38)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5320:2: rule__TerminalGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__0_in_rule__TerminalGroup__Group__1__Impl10733);
                    rule__TerminalGroup__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalGroupAccess().getGroup_1()); 

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
    // $ANTLR end rule__TerminalGroup__Group__1__Impl


    // $ANTLR start rule__TerminalGroup__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5334:1: rule__TerminalGroup__Group_1__0 : rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 ;
    public final void rule__TerminalGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5338:1: ( rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5339:2: rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__0__Impl_in_rule__TerminalGroup__Group_1__010768);
            rule__TerminalGroup__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__1_in_rule__TerminalGroup__Group_1__010771);
            rule__TerminalGroup__Group_1__1();
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
    // $ANTLR end rule__TerminalGroup__Group_1__0


    // $ANTLR start rule__TerminalGroup__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5346:1: rule__TerminalGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5350:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5351:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5351:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5352:1: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5353:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5355:1: 
            {
            }

             after(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TerminalGroup__Group_1__0__Impl


    // $ANTLR start rule__TerminalGroup__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5365:1: rule__TerminalGroup__Group_1__1 : rule__TerminalGroup__Group_1__1__Impl ;
    public final void rule__TerminalGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5369:1: ( rule__TerminalGroup__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5370:2: rule__TerminalGroup__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__1__Impl_in_rule__TerminalGroup__Group_1__110829);
            rule__TerminalGroup__Group_1__1__Impl();
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
    // $ANTLR end rule__TerminalGroup__Group_1__1


    // $ANTLR start rule__TerminalGroup__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5376:1: rule__TerminalGroup__Group_1__1__Impl : ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) ) ;
    public final void rule__TerminalGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5380:1: ( ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5381:1: ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5381:1: ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5382:1: ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5382:1: ( ( rule__TerminalGroup__TokensAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5383:1: ( rule__TerminalGroup__TokensAssignment_1_1 )
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5384:1: ( rule__TerminalGroup__TokensAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5384:2: rule__TerminalGroup__TokensAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__1__Impl10858);
            rule__TerminalGroup__TokensAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5387:1: ( ( rule__TerminalGroup__TokensAssignment_1_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5388:1: ( rule__TerminalGroup__TokensAssignment_1_1 )*
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5389:1: ( rule__TerminalGroup__TokensAssignment_1_1 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||LA44_0==20||LA44_0==22||(LA44_0>=37 && LA44_0<=38)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5389:2: rule__TerminalGroup__TokensAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__1__Impl10870);
            	    rule__TerminalGroup__TokensAssignment_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 

            }


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
    // $ANTLR end rule__TerminalGroup__Group_1__1__Impl


    // $ANTLR start rule__TerminalToken__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5404:1: rule__TerminalToken__Group__0 : rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 ;
    public final void rule__TerminalToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5408:1: ( rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5409:2: rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__0__Impl_in_rule__TerminalToken__Group__010907);
            rule__TerminalToken__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__1_in_rule__TerminalToken__Group__010910);
            rule__TerminalToken__Group__1();
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
    // $ANTLR end rule__TerminalToken__Group__0


    // $ANTLR start rule__TerminalToken__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5416:1: rule__TerminalToken__Group__0__Impl : ( ruleTerminalTokenElement ) ;
    public final void rule__TerminalToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5420:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5421:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5421:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5422:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group__0__Impl10937);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 

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
    // $ANTLR end rule__TerminalToken__Group__0__Impl


    // $ANTLR start rule__TerminalToken__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5433:1: rule__TerminalToken__Group__1 : rule__TerminalToken__Group__1__Impl ;
    public final void rule__TerminalToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5437:1: ( rule__TerminalToken__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5438:2: rule__TerminalToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__1__Impl_in_rule__TerminalToken__Group__110966);
            rule__TerminalToken__Group__1__Impl();
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
    // $ANTLR end rule__TerminalToken__Group__1


    // $ANTLR start rule__TerminalToken__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5444:1: rule__TerminalToken__Group__1__Impl : ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) ;
    public final void rule__TerminalToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5448:1: ( ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5449:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5449:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5450:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5451:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=11 && LA45_0<=13)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5451:2: rule__TerminalToken__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__CardinalityAssignment_1_in_rule__TerminalToken__Group__1__Impl10993);
                    rule__TerminalToken__CardinalityAssignment_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 

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
    // $ANTLR end rule__TerminalToken__Group__1__Impl


    // $ANTLR start rule__ParenthesizedTerminalElement__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5465:1: rule__ParenthesizedTerminalElement__Group__0 : rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 ;
    public final void rule__ParenthesizedTerminalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5469:1: ( rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5470:2: rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__0__Impl_in_rule__ParenthesizedTerminalElement__Group__011028);
            rule__ParenthesizedTerminalElement__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__1_in_rule__ParenthesizedTerminalElement__Group__011031);
            rule__ParenthesizedTerminalElement__Group__1();
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
    // $ANTLR end rule__ParenthesizedTerminalElement__Group__0


    // $ANTLR start rule__ParenthesizedTerminalElement__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5477:1: rule__ParenthesizedTerminalElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5481:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5482:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5482:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5483:1: '('
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedTerminalElement__Group__0__Impl11059); 
             after(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 

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
    // $ANTLR end rule__ParenthesizedTerminalElement__Group__0__Impl


    // $ANTLR start rule__ParenthesizedTerminalElement__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5496:1: rule__ParenthesizedTerminalElement__Group__1 : rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 ;
    public final void rule__ParenthesizedTerminalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5500:1: ( rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5501:2: rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__1__Impl_in_rule__ParenthesizedTerminalElement__Group__111090);
            rule__ParenthesizedTerminalElement__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__2_in_rule__ParenthesizedTerminalElement__Group__111093);
            rule__ParenthesizedTerminalElement__Group__2();
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
    // $ANTLR end rule__ParenthesizedTerminalElement__Group__1


    // $ANTLR start rule__ParenthesizedTerminalElement__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5508:1: rule__ParenthesizedTerminalElement__Group__1__Impl : ( ruleTerminalAlternatives ) ;
    public final void rule__ParenthesizedTerminalElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5512:1: ( ( ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5513:1: ( ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5513:1: ( ruleTerminalAlternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5514:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group__1__Impl11120);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 

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
    // $ANTLR end rule__ParenthesizedTerminalElement__Group__1__Impl


    // $ANTLR start rule__ParenthesizedTerminalElement__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5525:1: rule__ParenthesizedTerminalElement__Group__2 : rule__ParenthesizedTerminalElement__Group__2__Impl ;
    public final void rule__ParenthesizedTerminalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5529:1: ( rule__ParenthesizedTerminalElement__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5530:2: rule__ParenthesizedTerminalElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__2__Impl_in_rule__ParenthesizedTerminalElement__Group__211149);
            rule__ParenthesizedTerminalElement__Group__2__Impl();
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
    // $ANTLR end rule__ParenthesizedTerminalElement__Group__2


    // $ANTLR start rule__ParenthesizedTerminalElement__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5536:1: rule__ParenthesizedTerminalElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5540:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5541:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5541:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5542:1: ')'
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group__2__Impl11177); 
             after(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 

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
    // $ANTLR end rule__ParenthesizedTerminalElement__Group__2__Impl


    // $ANTLR start rule__NegatedToken__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5561:1: rule__NegatedToken__Group__0 : rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 ;
    public final void rule__NegatedToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5565:1: ( rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5566:2: rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__0__Impl_in_rule__NegatedToken__Group__011214);
            rule__NegatedToken__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__1_in_rule__NegatedToken__Group__011217);
            rule__NegatedToken__Group__1();
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
    // $ANTLR end rule__NegatedToken__Group__0


    // $ANTLR start rule__NegatedToken__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5573:1: rule__NegatedToken__Group__0__Impl : ( '!' ) ;
    public final void rule__NegatedToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5577:1: ( ( '!' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5578:1: ( '!' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5578:1: ( '!' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5579:1: '!'
            {
             before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__NegatedToken__Group__0__Impl11245); 
             after(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 

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
    // $ANTLR end rule__NegatedToken__Group__0__Impl


    // $ANTLR start rule__NegatedToken__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5592:1: rule__NegatedToken__Group__1 : rule__NegatedToken__Group__1__Impl ;
    public final void rule__NegatedToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5596:1: ( rule__NegatedToken__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5597:2: rule__NegatedToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__1__Impl_in_rule__NegatedToken__Group__111276);
            rule__NegatedToken__Group__1__Impl();
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
    // $ANTLR end rule__NegatedToken__Group__1


    // $ANTLR start rule__NegatedToken__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5603:1: rule__NegatedToken__Group__1__Impl : ( ( rule__NegatedToken__TerminalAssignment_1 ) ) ;
    public final void rule__NegatedToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5607:1: ( ( ( rule__NegatedToken__TerminalAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5608:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5608:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5609:1: ( rule__NegatedToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5610:1: ( rule__NegatedToken__TerminalAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5610:2: rule__NegatedToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__TerminalAssignment_1_in_rule__NegatedToken__Group__1__Impl11303);
            rule__NegatedToken__TerminalAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 

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
    // $ANTLR end rule__NegatedToken__Group__1__Impl


    // $ANTLR start rule__UntilToken__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5624:1: rule__UntilToken__Group__0 : rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 ;
    public final void rule__UntilToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5628:1: ( rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5629:2: rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__0__Impl_in_rule__UntilToken__Group__011337);
            rule__UntilToken__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__1_in_rule__UntilToken__Group__011340);
            rule__UntilToken__Group__1();
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
    // $ANTLR end rule__UntilToken__Group__0


    // $ANTLR start rule__UntilToken__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5636:1: rule__UntilToken__Group__0__Impl : ( '->' ) ;
    public final void rule__UntilToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5640:1: ( ( '->' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5641:1: ( '->' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5641:1: ( '->' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5642:1: '->'
            {
             before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__UntilToken__Group__0__Impl11368); 
             after(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 

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
    // $ANTLR end rule__UntilToken__Group__0__Impl


    // $ANTLR start rule__UntilToken__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5655:1: rule__UntilToken__Group__1 : rule__UntilToken__Group__1__Impl ;
    public final void rule__UntilToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5659:1: ( rule__UntilToken__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5660:2: rule__UntilToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__1__Impl_in_rule__UntilToken__Group__111399);
            rule__UntilToken__Group__1__Impl();
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
    // $ANTLR end rule__UntilToken__Group__1


    // $ANTLR start rule__UntilToken__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5666:1: rule__UntilToken__Group__1__Impl : ( ( rule__UntilToken__TerminalAssignment_1 ) ) ;
    public final void rule__UntilToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5670:1: ( ( ( rule__UntilToken__TerminalAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5671:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5671:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5672:1: ( rule__UntilToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5673:1: ( rule__UntilToken__TerminalAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5673:2: rule__UntilToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__TerminalAssignment_1_in_rule__UntilToken__Group__1__Impl11426);
            rule__UntilToken__TerminalAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 

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
    // $ANTLR end rule__UntilToken__Group__1__Impl


    // $ANTLR start rule__Wildcard__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5687:1: rule__Wildcard__Group__0 : rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5691:1: ( rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5692:2: rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__0__Impl_in_rule__Wildcard__Group__011460);
            rule__Wildcard__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__1_in_rule__Wildcard__Group__011463);
            rule__Wildcard__Group__1();
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
    // $ANTLR end rule__Wildcard__Group__0


    // $ANTLR start rule__Wildcard__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5699:1: rule__Wildcard__Group__0__Impl : ( () ) ;
    public final void rule__Wildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5703:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5704:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5704:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5705:1: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5706:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5708:1: 
            {
            }

             after(grammarAccess.getWildcardAccess().getWildcardAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Wildcard__Group__0__Impl


    // $ANTLR start rule__Wildcard__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5718:1: rule__Wildcard__Group__1 : rule__Wildcard__Group__1__Impl ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5722:1: ( rule__Wildcard__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5723:2: rule__Wildcard__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__1__Impl_in_rule__Wildcard__Group__111521);
            rule__Wildcard__Group__1__Impl();
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
    // $ANTLR end rule__Wildcard__Group__1


    // $ANTLR start rule__Wildcard__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5729:1: rule__Wildcard__Group__1__Impl : ( '.' ) ;
    public final void rule__Wildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5733:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5734:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5734:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5735:1: '.'
            {
             before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Wildcard__Group__1__Impl11549); 
             after(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 

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
    // $ANTLR end rule__Wildcard__Group__1__Impl


    // $ANTLR start rule__CharacterRange__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5752:1: rule__CharacterRange__Group__0 : rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 ;
    public final void rule__CharacterRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5756:1: ( rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5757:2: rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__0__Impl_in_rule__CharacterRange__Group__011584);
            rule__CharacterRange__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__1_in_rule__CharacterRange__Group__011587);
            rule__CharacterRange__Group__1();
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
    // $ANTLR end rule__CharacterRange__Group__0


    // $ANTLR start rule__CharacterRange__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5764:1: rule__CharacterRange__Group__0__Impl : ( ruleKeyword ) ;
    public final void rule__CharacterRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5768:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5769:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5769:1: ( ruleKeyword )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5770:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CharacterRange__Group__0__Impl11614);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 

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
    // $ANTLR end rule__CharacterRange__Group__0__Impl


    // $ANTLR start rule__CharacterRange__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5781:1: rule__CharacterRange__Group__1 : rule__CharacterRange__Group__1__Impl ;
    public final void rule__CharacterRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5785:1: ( rule__CharacterRange__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5786:2: rule__CharacterRange__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__1__Impl_in_rule__CharacterRange__Group__111643);
            rule__CharacterRange__Group__1__Impl();
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
    // $ANTLR end rule__CharacterRange__Group__1


    // $ANTLR start rule__CharacterRange__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5792:1: rule__CharacterRange__Group__1__Impl : ( ( rule__CharacterRange__Group_1__0 )? ) ;
    public final void rule__CharacterRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5796:1: ( ( ( rule__CharacterRange__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5797:1: ( ( rule__CharacterRange__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5797:1: ( ( rule__CharacterRange__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5798:1: ( rule__CharacterRange__Group_1__0 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5799:1: ( rule__CharacterRange__Group_1__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==39) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5799:2: rule__CharacterRange__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__0_in_rule__CharacterRange__Group__1__Impl11670);
                    rule__CharacterRange__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCharacterRangeAccess().getGroup_1()); 

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
    // $ANTLR end rule__CharacterRange__Group__1__Impl


    // $ANTLR start rule__CharacterRange__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5813:1: rule__CharacterRange__Group_1__0 : rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 ;
    public final void rule__CharacterRange__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5817:1: ( rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5818:2: rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__0__Impl_in_rule__CharacterRange__Group_1__011705);
            rule__CharacterRange__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__1_in_rule__CharacterRange__Group_1__011708);
            rule__CharacterRange__Group_1__1();
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
    // $ANTLR end rule__CharacterRange__Group_1__0


    // $ANTLR start rule__CharacterRange__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5825:1: rule__CharacterRange__Group_1__0__Impl : ( () ) ;
    public final void rule__CharacterRange__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5829:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5830:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5830:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5831:1: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5832:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5834:1: 
            {
            }

             after(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__CharacterRange__Group_1__0__Impl


    // $ANTLR start rule__CharacterRange__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5844:1: rule__CharacterRange__Group_1__1 : rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 ;
    public final void rule__CharacterRange__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5848:1: ( rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5849:2: rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__1__Impl_in_rule__CharacterRange__Group_1__111766);
            rule__CharacterRange__Group_1__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__2_in_rule__CharacterRange__Group_1__111769);
            rule__CharacterRange__Group_1__2();
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
    // $ANTLR end rule__CharacterRange__Group_1__1


    // $ANTLR start rule__CharacterRange__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5856:1: rule__CharacterRange__Group_1__1__Impl : ( '..' ) ;
    public final void rule__CharacterRange__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5860:1: ( ( '..' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5861:1: ( '..' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5861:1: ( '..' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5862:1: '..'
            {
             before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__CharacterRange__Group_1__1__Impl11797); 
             after(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 

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
    // $ANTLR end rule__CharacterRange__Group_1__1__Impl


    // $ANTLR start rule__CharacterRange__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5875:1: rule__CharacterRange__Group_1__2 : rule__CharacterRange__Group_1__2__Impl ;
    public final void rule__CharacterRange__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5879:1: ( rule__CharacterRange__Group_1__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5880:2: rule__CharacterRange__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__2__Impl_in_rule__CharacterRange__Group_1__211828);
            rule__CharacterRange__Group_1__2__Impl();
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
    // $ANTLR end rule__CharacterRange__Group_1__2


    // $ANTLR start rule__CharacterRange__Group_1__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5886:1: rule__CharacterRange__Group_1__2__Impl : ( ( rule__CharacterRange__RightAssignment_1_2 ) ) ;
    public final void rule__CharacterRange__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5890:1: ( ( ( rule__CharacterRange__RightAssignment_1_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5891:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5891:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5892:1: ( rule__CharacterRange__RightAssignment_1_2 )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5893:1: ( rule__CharacterRange__RightAssignment_1_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5893:2: rule__CharacterRange__RightAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__RightAssignment_1_2_in_rule__CharacterRange__Group_1__2__Impl11855);
            rule__CharacterRange__RightAssignment_1_2();
            _fsp--;


            }

             after(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 

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
    // $ANTLR end rule__CharacterRange__Group_1__2__Impl


    // $ANTLR start rule__EnumRule__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5909:1: rule__EnumRule__Group__0 : rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 ;
    public final void rule__EnumRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5913:1: ( rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5914:2: rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__0__Impl_in_rule__EnumRule__Group__011891);
            rule__EnumRule__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__1_in_rule__EnumRule__Group__011894);
            rule__EnumRule__Group__1();
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
    // $ANTLR end rule__EnumRule__Group__0


    // $ANTLR start rule__EnumRule__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5921:1: rule__EnumRule__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5925:1: ( ( 'enum' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5926:1: ( 'enum' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5926:1: ( 'enum' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5927:1: 'enum'
            {
             before(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 
            match(input,40,FollowSets000.FOLLOW_40_in_rule__EnumRule__Group__0__Impl11922); 
             after(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 

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
    // $ANTLR end rule__EnumRule__Group__0__Impl


    // $ANTLR start rule__EnumRule__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5940:1: rule__EnumRule__Group__1 : rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 ;
    public final void rule__EnumRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5944:1: ( rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5945:2: rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__1__Impl_in_rule__EnumRule__Group__111953);
            rule__EnumRule__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__2_in_rule__EnumRule__Group__111956);
            rule__EnumRule__Group__2();
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
    // $ANTLR end rule__EnumRule__Group__1


    // $ANTLR start rule__EnumRule__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5952:1: rule__EnumRule__Group__1__Impl : ( ( rule__EnumRule__NameAssignment_1 ) ) ;
    public final void rule__EnumRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5956:1: ( ( ( rule__EnumRule__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5957:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5957:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5958:1: ( rule__EnumRule__NameAssignment_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5959:1: ( rule__EnumRule__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5959:2: rule__EnumRule__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__NameAssignment_1_in_rule__EnumRule__Group__1__Impl11983);
            rule__EnumRule__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 

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
    // $ANTLR end rule__EnumRule__Group__1__Impl


    // $ANTLR start rule__EnumRule__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5969:1: rule__EnumRule__Group__2 : rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 ;
    public final void rule__EnumRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5973:1: ( rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5974:2: rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__2__Impl_in_rule__EnumRule__Group__212013);
            rule__EnumRule__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__3_in_rule__EnumRule__Group__212016);
            rule__EnumRule__Group__3();
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
    // $ANTLR end rule__EnumRule__Group__2


    // $ANTLR start rule__EnumRule__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5981:1: rule__EnumRule__Group__2__Impl : ( ( rule__EnumRule__Group_2__0 )? ) ;
    public final void rule__EnumRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5985:1: ( ( ( rule__EnumRule__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5986:1: ( ( rule__EnumRule__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5986:1: ( ( rule__EnumRule__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5987:1: ( rule__EnumRule__Group_2__0 )?
            {
             before(grammarAccess.getEnumRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5988:1: ( rule__EnumRule__Group_2__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==28) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5988:2: rule__EnumRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__0_in_rule__EnumRule__Group__2__Impl12043);
                    rule__EnumRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumRuleAccess().getGroup_2()); 

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
    // $ANTLR end rule__EnumRule__Group__2__Impl


    // $ANTLR start rule__EnumRule__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:5998:1: rule__EnumRule__Group__3 : rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 ;
    public final void rule__EnumRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6002:1: ( rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6003:2: rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__3__Impl_in_rule__EnumRule__Group__312074);
            rule__EnumRule__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__4_in_rule__EnumRule__Group__312077);
            rule__EnumRule__Group__4();
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
    // $ANTLR end rule__EnumRule__Group__3


    // $ANTLR start rule__EnumRule__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6010:1: rule__EnumRule__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6014:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6015:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6015:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6016:1: ':'
            {
             before(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__EnumRule__Group__3__Impl12105); 
             after(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 

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
    // $ANTLR end rule__EnumRule__Group__3__Impl


    // $ANTLR start rule__EnumRule__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6029:1: rule__EnumRule__Group__4 : rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 ;
    public final void rule__EnumRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6033:1: ( rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6034:2: rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__4__Impl_in_rule__EnumRule__Group__412136);
            rule__EnumRule__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__5_in_rule__EnumRule__Group__412139);
            rule__EnumRule__Group__5();
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
    // $ANTLR end rule__EnumRule__Group__4


    // $ANTLR start rule__EnumRule__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6041:1: rule__EnumRule__Group__4__Impl : ( ( rule__EnumRule__AlternativesAssignment_4 ) ) ;
    public final void rule__EnumRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6045:1: ( ( ( rule__EnumRule__AlternativesAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6046:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6046:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6047:1: ( rule__EnumRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6048:1: ( rule__EnumRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6048:2: rule__EnumRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__AlternativesAssignment_4_in_rule__EnumRule__Group__4__Impl12166);
            rule__EnumRule__AlternativesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 

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
    // $ANTLR end rule__EnumRule__Group__4__Impl


    // $ANTLR start rule__EnumRule__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6058:1: rule__EnumRule__Group__5 : rule__EnumRule__Group__5__Impl ;
    public final void rule__EnumRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6062:1: ( rule__EnumRule__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6063:2: rule__EnumRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__5__Impl_in_rule__EnumRule__Group__512196);
            rule__EnumRule__Group__5__Impl();
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
    // $ANTLR end rule__EnumRule__Group__5


    // $ANTLR start rule__EnumRule__Group__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6069:1: rule__EnumRule__Group__5__Impl : ( ';' ) ;
    public final void rule__EnumRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6073:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6074:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6074:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6075:1: ';'
            {
             before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__EnumRule__Group__5__Impl12224); 
             after(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5()); 

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
    // $ANTLR end rule__EnumRule__Group__5__Impl


    // $ANTLR start rule__EnumRule__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6100:1: rule__EnumRule__Group_2__0 : rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1 ;
    public final void rule__EnumRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6104:1: ( rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6105:2: rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__0__Impl_in_rule__EnumRule__Group_2__012267);
            rule__EnumRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__1_in_rule__EnumRule__Group_2__012270);
            rule__EnumRule__Group_2__1();
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
    // $ANTLR end rule__EnumRule__Group_2__0


    // $ANTLR start rule__EnumRule__Group_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6112:1: rule__EnumRule__Group_2__0__Impl : ( 'returns' ) ;
    public final void rule__EnumRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6116:1: ( ( 'returns' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6117:1: ( 'returns' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6117:1: ( 'returns' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6118:1: 'returns'
            {
             before(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__EnumRule__Group_2__0__Impl12298); 
             after(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 

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
    // $ANTLR end rule__EnumRule__Group_2__0__Impl


    // $ANTLR start rule__EnumRule__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6131:1: rule__EnumRule__Group_2__1 : rule__EnumRule__Group_2__1__Impl ;
    public final void rule__EnumRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6135:1: ( rule__EnumRule__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6136:2: rule__EnumRule__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__1__Impl_in_rule__EnumRule__Group_2__112329);
            rule__EnumRule__Group_2__1__Impl();
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
    // $ANTLR end rule__EnumRule__Group_2__1


    // $ANTLR start rule__EnumRule__Group_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6142:1: rule__EnumRule__Group_2__1__Impl : ( ( rule__EnumRule__TypeAssignment_2_1 ) ) ;
    public final void rule__EnumRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6146:1: ( ( ( rule__EnumRule__TypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6147:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6147:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6148:1: ( rule__EnumRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6149:1: ( rule__EnumRule__TypeAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6149:2: rule__EnumRule__TypeAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__TypeAssignment_2_1_in_rule__EnumRule__Group_2__1__Impl12356);
            rule__EnumRule__TypeAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getTypeAssignment_2_1()); 

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
    // $ANTLR end rule__EnumRule__Group_2__1__Impl


    // $ANTLR start rule__EnumLiterals__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6163:1: rule__EnumLiterals__Group__0 : rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 ;
    public final void rule__EnumLiterals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6167:1: ( rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6168:2: rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__0__Impl_in_rule__EnumLiterals__Group__012390);
            rule__EnumLiterals__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__1_in_rule__EnumLiterals__Group__012393);
            rule__EnumLiterals__Group__1();
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
    // $ANTLR end rule__EnumLiterals__Group__0


    // $ANTLR start rule__EnumLiterals__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6175:1: rule__EnumLiterals__Group__0__Impl : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6179:1: ( ( ruleEnumLiteralDeclaration ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6180:1: ( ruleEnumLiteralDeclaration )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6180:1: ( ruleEnumLiteralDeclaration )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6181:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group__0__Impl12420);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 

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
    // $ANTLR end rule__EnumLiterals__Group__0__Impl


    // $ANTLR start rule__EnumLiterals__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6192:1: rule__EnumLiterals__Group__1 : rule__EnumLiterals__Group__1__Impl ;
    public final void rule__EnumLiterals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6196:1: ( rule__EnumLiterals__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6197:2: rule__EnumLiterals__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__1__Impl_in_rule__EnumLiterals__Group__112449);
            rule__EnumLiterals__Group__1__Impl();
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
    // $ANTLR end rule__EnumLiterals__Group__1


    // $ANTLR start rule__EnumLiterals__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6203:1: rule__EnumLiterals__Group__1__Impl : ( ( rule__EnumLiterals__Group_1__0 )? ) ;
    public final void rule__EnumLiterals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6207:1: ( ( ( rule__EnumLiterals__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6208:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6208:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6209:1: ( rule__EnumLiterals__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6210:1: ( rule__EnumLiterals__Group_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==30) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6210:2: rule__EnumLiterals__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__0_in_rule__EnumLiterals__Group__1__Impl12476);
                    rule__EnumLiterals__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 

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
    // $ANTLR end rule__EnumLiterals__Group__1__Impl


    // $ANTLR start rule__EnumLiterals__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6224:1: rule__EnumLiterals__Group_1__0 : rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 ;
    public final void rule__EnumLiterals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6228:1: ( rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6229:2: rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__0__Impl_in_rule__EnumLiterals__Group_1__012511);
            rule__EnumLiterals__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__1_in_rule__EnumLiterals__Group_1__012514);
            rule__EnumLiterals__Group_1__1();
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
    // $ANTLR end rule__EnumLiterals__Group_1__0


    // $ANTLR start rule__EnumLiterals__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6236:1: rule__EnumLiterals__Group_1__0__Impl : ( () ) ;
    public final void rule__EnumLiterals__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6240:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6241:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6241:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6242:1: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6243:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6245:1: 
            {
            }

             after(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EnumLiterals__Group_1__0__Impl


    // $ANTLR start rule__EnumLiterals__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6255:1: rule__EnumLiterals__Group_1__1 : rule__EnumLiterals__Group_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6259:1: ( rule__EnumLiterals__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6260:2: rule__EnumLiterals__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__1__Impl_in_rule__EnumLiterals__Group_1__112572);
            rule__EnumLiterals__Group_1__1__Impl();
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
    // $ANTLR end rule__EnumLiterals__Group_1__1


    // $ANTLR start rule__EnumLiterals__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6266:1: rule__EnumLiterals__Group_1__1__Impl : ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) ;
    public final void rule__EnumLiterals__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6270:1: ( ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6271:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6271:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6272:1: ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6272:1: ( ( rule__EnumLiterals__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6273:1: ( rule__EnumLiterals__Group_1_1__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6274:1: ( rule__EnumLiterals__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6274:2: rule__EnumLiterals__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__1__Impl12601);
            rule__EnumLiterals__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6277:1: ( ( rule__EnumLiterals__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6278:1: ( rule__EnumLiterals__Group_1_1__0 )*
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6279:1: ( rule__EnumLiterals__Group_1_1__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==30) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6279:2: rule__EnumLiterals__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__1__Impl12613);
            	    rule__EnumLiterals__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }


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
    // $ANTLR end rule__EnumLiterals__Group_1__1__Impl


    // $ANTLR start rule__EnumLiterals__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6294:1: rule__EnumLiterals__Group_1_1__0 : rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 ;
    public final void rule__EnumLiterals__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6298:1: ( rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6299:2: rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0__Impl_in_rule__EnumLiterals__Group_1_1__012650);
            rule__EnumLiterals__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__1_in_rule__EnumLiterals__Group_1_1__012653);
            rule__EnumLiterals__Group_1_1__1();
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
    // $ANTLR end rule__EnumLiterals__Group_1_1__0


    // $ANTLR start rule__EnumLiterals__Group_1_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6306:1: rule__EnumLiterals__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__EnumLiterals__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6310:1: ( ( '|' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6311:1: ( '|' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6311:1: ( '|' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6312:1: '|'
            {
             before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__EnumLiterals__Group_1_1__0__Impl12681); 
             after(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 

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
    // $ANTLR end rule__EnumLiterals__Group_1_1__0__Impl


    // $ANTLR start rule__EnumLiterals__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6325:1: rule__EnumLiterals__Group_1_1__1 : rule__EnumLiterals__Group_1_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6329:1: ( rule__EnumLiterals__Group_1_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6330:2: rule__EnumLiterals__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__1__Impl_in_rule__EnumLiterals__Group_1_1__112712);
            rule__EnumLiterals__Group_1_1__1__Impl();
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
    // $ANTLR end rule__EnumLiterals__Group_1_1__1


    // $ANTLR start rule__EnumLiterals__Group_1_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6336:1: rule__EnumLiterals__Group_1_1__1__Impl : ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__EnumLiterals__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6340:1: ( ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6341:1: ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6341:1: ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6342:1: ( rule__EnumLiterals__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6343:1: ( rule__EnumLiterals__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6343:2: rule__EnumLiterals__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__GroupsAssignment_1_1_1_in_rule__EnumLiterals__Group_1_1__1__Impl12739);
            rule__EnumLiterals__GroupsAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroupsAssignment_1_1_1()); 

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
    // $ANTLR end rule__EnumLiterals__Group_1_1__1__Impl


    // $ANTLR start rule__EnumLiteralDeclaration__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6357:1: rule__EnumLiteralDeclaration__Group__0 : rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 ;
    public final void rule__EnumLiteralDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6361:1: ( rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6362:2: rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__0__Impl_in_rule__EnumLiteralDeclaration__Group__012773);
            rule__EnumLiteralDeclaration__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__1_in_rule__EnumLiteralDeclaration__Group__012776);
            rule__EnumLiteralDeclaration__Group__1();
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
    // $ANTLR end rule__EnumLiteralDeclaration__Group__0


    // $ANTLR start rule__EnumLiteralDeclaration__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6369:1: rule__EnumLiteralDeclaration__Group__0__Impl : ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6373:1: ( ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6374:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6374:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6375:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6376:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6376:2: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__EnumLiteralAssignment_0_in_rule__EnumLiteralDeclaration__Group__0__Impl12803);
            rule__EnumLiteralDeclaration__EnumLiteralAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 

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
    // $ANTLR end rule__EnumLiteralDeclaration__Group__0__Impl


    // $ANTLR start rule__EnumLiteralDeclaration__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6386:1: rule__EnumLiteralDeclaration__Group__1 : rule__EnumLiteralDeclaration__Group__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6390:1: ( rule__EnumLiteralDeclaration__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6391:2: rule__EnumLiteralDeclaration__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__1__Impl_in_rule__EnumLiteralDeclaration__Group__112833);
            rule__EnumLiteralDeclaration__Group__1__Impl();
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
    // $ANTLR end rule__EnumLiteralDeclaration__Group__1


    // $ANTLR start rule__EnumLiteralDeclaration__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6397:1: rule__EnumLiteralDeclaration__Group__1__Impl : ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6401:1: ( ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6402:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6402:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6403:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6404:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==14) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6404:2: rule__EnumLiteralDeclaration__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__0_in_rule__EnumLiteralDeclaration__Group__1__Impl12860);
                    rule__EnumLiteralDeclaration__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 

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
    // $ANTLR end rule__EnumLiteralDeclaration__Group__1__Impl


    // $ANTLR start rule__EnumLiteralDeclaration__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6418:1: rule__EnumLiteralDeclaration__Group_1__0 : rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 ;
    public final void rule__EnumLiteralDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6422:1: ( rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6423:2: rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__0__Impl_in_rule__EnumLiteralDeclaration__Group_1__012895);
            rule__EnumLiteralDeclaration__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__1_in_rule__EnumLiteralDeclaration__Group_1__012898);
            rule__EnumLiteralDeclaration__Group_1__1();
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
    // $ANTLR end rule__EnumLiteralDeclaration__Group_1__0


    // $ANTLR start rule__EnumLiteralDeclaration__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6430:1: rule__EnumLiteralDeclaration__Group_1__0__Impl : ( '=' ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6434:1: ( ( '=' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6435:1: ( '=' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6435:1: ( '=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6436:1: '='
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_1__0__Impl12926); 
             after(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 

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
    // $ANTLR end rule__EnumLiteralDeclaration__Group_1__0__Impl


    // $ANTLR start rule__EnumLiteralDeclaration__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6449:1: rule__EnumLiteralDeclaration__Group_1__1 : rule__EnumLiteralDeclaration__Group_1__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6453:1: ( rule__EnumLiteralDeclaration__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6454:2: rule__EnumLiteralDeclaration__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__1__Impl_in_rule__EnumLiteralDeclaration__Group_1__112957);
            rule__EnumLiteralDeclaration__Group_1__1__Impl();
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
    // $ANTLR end rule__EnumLiteralDeclaration__Group_1__1


    // $ANTLR start rule__EnumLiteralDeclaration__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6460:1: rule__EnumLiteralDeclaration__Group_1__1__Impl : ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6464:1: ( ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6465:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6465:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6466:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6467:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6467:2: rule__EnumLiteralDeclaration__LiteralAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__LiteralAssignment_1_1_in_rule__EnumLiteralDeclaration__Group_1__1__Impl12984);
            rule__EnumLiteralDeclaration__LiteralAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 

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
    // $ANTLR end rule__EnumLiteralDeclaration__Group_1__1__Impl


    // $ANTLR start rule__Grammar__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6482:1: rule__Grammar__NameAssignment_1 : ( ruleGrammarID ) ;
    public final void rule__Grammar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6486:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6487:1: ( ruleGrammarID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6487:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6488:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__NameAssignment_113023);
            ruleGrammarID();
            _fsp--;

             after(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 

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
    // $ANTLR end rule__Grammar__NameAssignment_1


    // $ANTLR start rule__Grammar__UsedGrammarsAssignment_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6497:1: rule__Grammar__UsedGrammarsAssignment_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6501:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6502:1: ( ( ruleGrammarID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6502:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6503:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6504:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6505:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_113058);
            ruleGrammarID();
            _fsp--;

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 

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
    // $ANTLR end rule__Grammar__UsedGrammarsAssignment_2_1


    // $ANTLR start rule__Grammar__UsedGrammarsAssignment_2_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6516:1: rule__Grammar__UsedGrammarsAssignment_2_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6520:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6521:1: ( ( ruleGrammarID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6521:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6522:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6523:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6524:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_2_113097);
            ruleGrammarID();
            _fsp--;

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 

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
    // $ANTLR end rule__Grammar__UsedGrammarsAssignment_2_2_1


    // $ANTLR start rule__Grammar__DefinesHiddenTokensAssignment_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6535:1: rule__Grammar__DefinesHiddenTokensAssignment_3_0 : ( ( 'hidden' ) ) ;
    public final void rule__Grammar__DefinesHiddenTokensAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6539:1: ( ( ( 'hidden' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6540:1: ( ( 'hidden' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6540:1: ( ( 'hidden' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6541:1: ( 'hidden' )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6542:1: ( 'hidden' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6543:1: 'hidden'
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            match(input,41,FollowSets000.FOLLOW_41_in_rule__Grammar__DefinesHiddenTokensAssignment_3_013137); 
             after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 

            }

             after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 

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
    // $ANTLR end rule__Grammar__DefinesHiddenTokensAssignment_3_0


    // $ANTLR start rule__Grammar__HiddenTokensAssignment_3_2_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6558:1: rule__Grammar__HiddenTokensAssignment_3_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6562:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6563:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6563:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6564:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6565:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6566:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_013180); 
             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 

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
    // $ANTLR end rule__Grammar__HiddenTokensAssignment_3_2_0


    // $ANTLR start rule__Grammar__HiddenTokensAssignment_3_2_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6577:1: rule__Grammar__HiddenTokensAssignment_3_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6581:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6582:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6582:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6583:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6584:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6585:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_1_113219); 
             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 

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
    // $ANTLR end rule__Grammar__HiddenTokensAssignment_3_2_1_1


    // $ANTLR start rule__Grammar__MetamodelDeclarationsAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6596:1: rule__Grammar__MetamodelDeclarationsAssignment_4 : ( ruleAbstractMetamodelDeclaration ) ;
    public final void rule__Grammar__MetamodelDeclarationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6600:1: ( ( ruleAbstractMetamodelDeclaration ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6601:1: ( ruleAbstractMetamodelDeclaration )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6601:1: ( ruleAbstractMetamodelDeclaration )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6602:1: ruleAbstractMetamodelDeclaration
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__MetamodelDeclarationsAssignment_413254);
            ruleAbstractMetamodelDeclaration();
            _fsp--;

             after(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 

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
    // $ANTLR end rule__Grammar__MetamodelDeclarationsAssignment_4


    // $ANTLR start rule__Grammar__RulesAssignment_5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6611:1: rule__Grammar__RulesAssignment_5 : ( ruleAbstractRule ) ;
    public final void rule__Grammar__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6615:1: ( ( ruleAbstractRule ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6616:1: ( ruleAbstractRule )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6616:1: ( ruleAbstractRule )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6617:1: ruleAbstractRule
            {
             before(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_rule__Grammar__RulesAssignment_513285);
            ruleAbstractRule();
            _fsp--;

             after(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 

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
    // $ANTLR end rule__Grammar__RulesAssignment_5


    // $ANTLR start rule__GeneratedMetamodel__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6626:1: rule__GeneratedMetamodel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6630:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6631:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6631:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6632:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__NameAssignment_113316); 
             after(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end rule__GeneratedMetamodel__NameAssignment_1


    // $ANTLR start rule__GeneratedMetamodel__EPackageAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6641:1: rule__GeneratedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__GeneratedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6645:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6646:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6646:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6647:1: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6648:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6649:1: RULE_STRING
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__EPackageAssignment_213351); 
             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 

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
    // $ANTLR end rule__GeneratedMetamodel__EPackageAssignment_2


    // $ANTLR start rule__GeneratedMetamodel__AliasAssignment_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6660:1: rule__GeneratedMetamodel__AliasAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__AliasAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6664:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6665:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6665:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6666:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__AliasAssignment_3_113386); 
             after(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 

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
    // $ANTLR end rule__GeneratedMetamodel__AliasAssignment_3_1


    // $ANTLR start rule__ReferencedMetamodel__EPackageAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6675:1: rule__ReferencedMetamodel__EPackageAssignment_1 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6679:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6680:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6680:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6681:1: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6682:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6683:1: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_113421); 
             after(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 

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
    // $ANTLR end rule__ReferencedMetamodel__EPackageAssignment_1


    // $ANTLR start rule__ReferencedMetamodel__AliasAssignment_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6694:1: rule__ReferencedMetamodel__AliasAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6698:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6699:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6699:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6700:1: RULE_ID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_2_113456); 
             after(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 

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
    // $ANTLR end rule__ReferencedMetamodel__AliasAssignment_2_1


    // $ANTLR start rule__ParserRule__NameAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6709:1: rule__ParserRule__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParserRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6713:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6714:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6714:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6715:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__NameAssignment_013487); 
             after(grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end rule__ParserRule__NameAssignment_0


    // $ANTLR start rule__ParserRule__TypeAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6724:1: rule__ParserRule__TypeAssignment_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6728:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6729:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6729:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6730:1: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__ParserRule__TypeAssignment_1_113518);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__ParserRule__TypeAssignment_1_1


    // $ANTLR start rule__ParserRule__DefinesHiddenTokensAssignment_2_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6739:1: rule__ParserRule__DefinesHiddenTokensAssignment_2_0 : ( ( 'hidden' ) ) ;
    public final void rule__ParserRule__DefinesHiddenTokensAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6743:1: ( ( ( 'hidden' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6744:1: ( ( 'hidden' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6744:1: ( ( 'hidden' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6745:1: ( 'hidden' )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6746:1: ( 'hidden' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6747:1: 'hidden'
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            match(input,41,FollowSets000.FOLLOW_41_in_rule__ParserRule__DefinesHiddenTokensAssignment_2_013554); 
             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 

            }

             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 

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
    // $ANTLR end rule__ParserRule__DefinesHiddenTokensAssignment_2_0


    // $ANTLR start rule__ParserRule__HiddenTokensAssignment_2_2_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6762:1: rule__ParserRule__HiddenTokensAssignment_2_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6766:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6767:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6767:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6768:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6769:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6770:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_013597); 
             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1()); 

            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 

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
    // $ANTLR end rule__ParserRule__HiddenTokensAssignment_2_2_0


    // $ANTLR start rule__ParserRule__HiddenTokensAssignment_2_2_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6781:1: rule__ParserRule__HiddenTokensAssignment_2_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6785:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6786:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6786:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6787:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6788:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6789:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_1_113636); 
             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1()); 

            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 

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
    // $ANTLR end rule__ParserRule__HiddenTokensAssignment_2_2_1_1


    // $ANTLR start rule__ParserRule__AlternativesAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6800:1: rule__ParserRule__AlternativesAssignment_4 : ( ruleAlternatives ) ;
    public final void rule__ParserRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6804:1: ( ( ruleAlternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6805:1: ( ruleAlternatives )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6805:1: ( ruleAlternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6806:1: ruleAlternatives
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rule__ParserRule__AlternativesAssignment_413671);
            ruleAlternatives();
            _fsp--;

             after(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 

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
    // $ANTLR end rule__ParserRule__AlternativesAssignment_4


    // $ANTLR start rule__TypeRef__MetamodelAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6815:1: rule__TypeRef__MetamodelAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__MetamodelAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6819:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6820:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6820:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6821:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6822:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6823:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeRef__MetamodelAssignment_0_013706); 
             after(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 

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
    // $ANTLR end rule__TypeRef__MetamodelAssignment_0_0


    // $ANTLR start rule__TypeRef__ClassifierAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6834:1: rule__TypeRef__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6838:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6839:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6839:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6840:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6841:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6842:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeRef__ClassifierAssignment_113745); 
             after(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 

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
    // $ANTLR end rule__TypeRef__ClassifierAssignment_1


    // $ANTLR start rule__Alternatives__GroupsAssignment_1_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6853:1: rule__Alternatives__GroupsAssignment_1_1_1 : ( ruleGroup ) ;
    public final void rule__Alternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6857:1: ( ( ruleGroup ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6858:1: ( ruleGroup )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6858:1: ( ruleGroup )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6859:1: ruleGroup
            {
             before(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_rule__Alternatives__GroupsAssignment_1_1_113780);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0()); 

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
    // $ANTLR end rule__Alternatives__GroupsAssignment_1_1_1


    // $ANTLR start rule__Group__TokensAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6868:1: rule__Group__TokensAssignment_1_1 : ( ruleAbstractToken ) ;
    public final void rule__Group__TokensAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6872:1: ( ( ruleAbstractToken ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6873:1: ( ruleAbstractToken )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6873:1: ( ruleAbstractToken )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6874:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_rule__Group__TokensAssignment_1_113811);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__Group__TokensAssignment_1_1


    // $ANTLR start rule__AbstractTokenWithCardinality__CardinalityAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6883:1: rule__AbstractTokenWithCardinality__CardinalityAssignment_1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6887:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6888:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6888:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6889:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6890:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6890:2: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__CardinalityAssignment_113842);
            rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0();
            _fsp--;


            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 

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
    // $ANTLR end rule__AbstractTokenWithCardinality__CardinalityAssignment_1


    // $ANTLR start rule__Action__TypeAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6899:1: rule__Action__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Action__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6903:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6904:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6904:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6905:1: ruleTypeRef
            {
             before(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Action__TypeAssignment_113875);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 

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
    // $ANTLR end rule__Action__TypeAssignment_1


    // $ANTLR start rule__Action__FeatureAssignment_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6914:1: rule__Action__FeatureAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Action__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6918:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6919:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6919:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6920:1: RULE_ID
            {
             before(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Action__FeatureAssignment_2_113906); 
             after(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 

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
    // $ANTLR end rule__Action__FeatureAssignment_2_1


    // $ANTLR start rule__Action__OperatorAssignment_2_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6929:1: rule__Action__OperatorAssignment_2_2 : ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ;
    public final void rule__Action__OperatorAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6933:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6934:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6934:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6935:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6936:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6936:2: rule__Action__OperatorAlternatives_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__OperatorAssignment_2_213937);
            rule__Action__OperatorAlternatives_2_2_0();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 

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
    // $ANTLR end rule__Action__OperatorAssignment_2_2


    // $ANTLR start rule__Keyword__ValueAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6945:1: rule__Keyword__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Keyword__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6949:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6950:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6950:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6951:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Keyword__ValueAssignment13970); 
             after(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 

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
    // $ANTLR end rule__Keyword__ValueAssignment


    // $ANTLR start rule__RuleCall__RuleAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6960:1: rule__RuleCall__RuleAssignment : ( ( RULE_ID ) ) ;
    public final void rule__RuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6964:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6965:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6965:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6966:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6967:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6968:1: RULE_ID
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__RuleCall__RuleAssignment14005); 
             after(grammarAccess.getRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 

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
    // $ANTLR end rule__RuleCall__RuleAssignment


    // $ANTLR start rule__Assignment__FeatureAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6979:1: rule__Assignment__FeatureAssignment_0 : ( RULE_ID ) ;
    public final void rule__Assignment__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6983:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6984:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6984:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6985:1: RULE_ID
            {
             before(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Assignment__FeatureAssignment_014040); 
             after(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end rule__Assignment__FeatureAssignment_0


    // $ANTLR start rule__Assignment__OperatorAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6994:1: rule__Assignment__OperatorAssignment_1 : ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) ;
    public final void rule__Assignment__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6998:1: ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6999:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:6999:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7000:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7001:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7001:2: rule__Assignment__OperatorAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__OperatorAssignment_114071);
            rule__Assignment__OperatorAlternatives_1_0();
            _fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAlternatives_1_0()); 

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
    // $ANTLR end rule__Assignment__OperatorAssignment_1


    // $ANTLR start rule__Assignment__TerminalAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7010:1: rule__Assignment__TerminalAssignment_2 : ( ruleAssignableTerminal ) ;
    public final void rule__Assignment__TerminalAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7014:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7015:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7015:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7016:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__Assignment__TerminalAssignment_214104);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0()); 

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
    // $ANTLR end rule__Assignment__TerminalAssignment_2


    // $ANTLR start rule__AssignableAlternatives__GroupsAssignment_1_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7025:1: rule__AssignableAlternatives__GroupsAssignment_1_1_1 : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7029:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7030:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7030:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7031:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__GroupsAssignment_1_1_114135);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0()); 

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
    // $ANTLR end rule__AssignableAlternatives__GroupsAssignment_1_1_1


    // $ANTLR start rule__CrossReference__TypeAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7040:1: rule__CrossReference__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__CrossReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7044:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7045:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7045:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7046:1: ruleTypeRef
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__CrossReference__TypeAssignment_114166);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 

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
    // $ANTLR end rule__CrossReference__TypeAssignment_1


    // $ANTLR start rule__CrossReference__TerminalAssignment_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7055:1: rule__CrossReference__TerminalAssignment_2_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReference__TerminalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7059:1: ( ( ruleCrossReferenceableTerminal ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7060:1: ( ruleCrossReferenceableTerminal )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7060:1: ( ruleCrossReferenceableTerminal )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7061:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__TerminalAssignment_2_114197);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 

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
    // $ANTLR end rule__CrossReference__TerminalAssignment_2_1


    // $ANTLR start rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7070:1: rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7074:1: ( ( ruleCrossReferenceableTerminal ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7075:1: ( ruleCrossReferenceableTerminal )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7075:1: ( ruleCrossReferenceableTerminal )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7076:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsCrossReferenceableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_114228);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsCrossReferenceableTerminalParserRuleCall_1_1_1_0()); 

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
    // $ANTLR end rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1


    // $ANTLR start rule__TerminalRule__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7085:1: rule__TerminalRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TerminalRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7089:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7090:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7090:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7091:1: RULE_ID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_114259); 
             after(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end rule__TerminalRule__NameAssignment_1


    // $ANTLR start rule__TerminalRule__TypeAssignment_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7100:1: rule__TerminalRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__TerminalRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7104:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7105:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7105:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7106:1: ruleTypeRef
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__TerminalRule__TypeAssignment_2_114290);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 

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
    // $ANTLR end rule__TerminalRule__TypeAssignment_2_1


    // $ANTLR start rule__TerminalRule__AlternativesAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7115:1: rule__TerminalRule__AlternativesAssignment_4 : ( ruleTerminalAlternatives ) ;
    public final void rule__TerminalRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7119:1: ( ( ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7120:1: ( ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7120:1: ( ruleTerminalAlternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7121:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__AlternativesAssignment_414321);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 

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
    // $ANTLR end rule__TerminalRule__AlternativesAssignment_4


    // $ANTLR start rule__TerminalAlternatives__GroupsAssignment_1_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7130:1: rule__TerminalAlternatives__GroupsAssignment_1_1_1 : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7134:1: ( ( ruleTerminalGroup ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7135:1: ( ruleTerminalGroup )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7135:1: ( ruleTerminalGroup )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7136:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__GroupsAssignment_1_1_114352);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0()); 

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
    // $ANTLR end rule__TerminalAlternatives__GroupsAssignment_1_1_1


    // $ANTLR start rule__TerminalGroup__TokensAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7145:1: rule__TerminalGroup__TokensAssignment_1_1 : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__TokensAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7149:1: ( ( ruleTerminalToken ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7150:1: ( ruleTerminalToken )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7150:1: ( ruleTerminalToken )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7151:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__TokensAssignment_1_114383);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__TerminalGroup__TokensAssignment_1_1


    // $ANTLR start rule__TerminalToken__CardinalityAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7160:1: rule__TerminalToken__CardinalityAssignment_1 : ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__TerminalToken__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7164:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7165:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7165:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7166:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7167:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7167:2: rule__TerminalToken__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__CardinalityAssignment_114414);
            rule__TerminalToken__CardinalityAlternatives_1_0();
            _fsp--;


            }

             after(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 

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
    // $ANTLR end rule__TerminalToken__CardinalityAssignment_1


    // $ANTLR start rule__NegatedToken__TerminalAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7176:1: rule__NegatedToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__NegatedToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7180:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7181:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7181:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7182:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__TerminalAssignment_114447);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 

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
    // $ANTLR end rule__NegatedToken__TerminalAssignment_1


    // $ANTLR start rule__UntilToken__TerminalAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7191:1: rule__UntilToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__UntilToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7195:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7196:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7196:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7197:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__TerminalAssignment_114478);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 

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
    // $ANTLR end rule__UntilToken__TerminalAssignment_1


    // $ANTLR start rule__CharacterRange__RightAssignment_1_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7206:1: rule__CharacterRange__RightAssignment_1_2 : ( ruleKeyword ) ;
    public final void rule__CharacterRange__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7210:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7211:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7211:1: ( ruleKeyword )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7212:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CharacterRange__RightAssignment_1_214509);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 

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
    // $ANTLR end rule__CharacterRange__RightAssignment_1_2


    // $ANTLR start rule__EnumRule__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7221:1: rule__EnumRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7225:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7226:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7226:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7227:1: RULE_ID
            {
             before(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EnumRule__NameAssignment_114540); 
             after(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end rule__EnumRule__NameAssignment_1


    // $ANTLR start rule__EnumRule__TypeAssignment_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7236:1: rule__EnumRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__EnumRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7240:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7241:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7241:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7242:1: ruleTypeRef
            {
             before(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__EnumRule__TypeAssignment_2_114571);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 

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
    // $ANTLR end rule__EnumRule__TypeAssignment_2_1


    // $ANTLR start rule__EnumRule__AlternativesAssignment_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7251:1: rule__EnumRule__AlternativesAssignment_4 : ( ruleEnumLiterals ) ;
    public final void rule__EnumRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7255:1: ( ( ruleEnumLiterals ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7256:1: ( ruleEnumLiterals )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7256:1: ( ruleEnumLiterals )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7257:1: ruleEnumLiterals
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_rule__EnumRule__AlternativesAssignment_414602);
            ruleEnumLiterals();
            _fsp--;

             after(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 

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
    // $ANTLR end rule__EnumRule__AlternativesAssignment_4


    // $ANTLR start rule__EnumLiterals__GroupsAssignment_1_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7266:1: rule__EnumLiterals__GroupsAssignment_1_1_1 : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7270:1: ( ( ruleEnumLiteralDeclaration ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7271:1: ( ruleEnumLiteralDeclaration )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7271:1: ( ruleEnumLiteralDeclaration )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7272:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__GroupsAssignment_1_1_114633);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 

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
    // $ANTLR end rule__EnumLiterals__GroupsAssignment_1_1_1


    // $ANTLR start rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7281:1: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumLiteralDeclaration__EnumLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7285:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7286:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7286:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7287:1: ( RULE_ID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7288:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7289:1: RULE_ID
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__EnumLiteralAssignment_014668); 
             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 

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
    // $ANTLR end rule__EnumLiteralDeclaration__EnumLiteralAssignment_0


    // $ANTLR start rule__EnumLiteralDeclaration__LiteralAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7300:1: rule__EnumLiteralDeclaration__LiteralAssignment_1_1 : ( ruleKeyword ) ;
    public final void rule__EnumLiteralDeclaration__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7304:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7305:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7305:1: ( ruleKeyword )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalXtextGrammarUiTestLanguage.g:7306:1: ruleKeyword
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__LiteralAssignment_1_114703);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__EnumLiteralDeclaration__LiteralAssignment_1_1


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammar68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__0_in_ruleGrammar94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__0_in_ruleGrammarID154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractMetamodelDeclaration__Alternatives_in_ruleAbstractMetamodelDeclaration274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__0_in_ruleGeneratedMetamodel334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__0_in_ruleReferencedMetamodel394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRule428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__0_in_ruleParserRule454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__0_in_ruleTypeRef514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__0_in_ruleAlternatives574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroup608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group__0_in_ruleGroup634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__0_in_ruleAbstractTokenWithCardinality754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__0_in_ruleAction814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal841 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword901 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeyword908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Keyword__ValueAssignment_in_ruleKeyword934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall961 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RuleCall__RuleAssignment_in_ruleRuleCall994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment1021 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment1028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__0_in_ruleAssignment1054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1081 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal1088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1141 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement1148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__0_in_ruleParenthesizedAssignableElement1174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1201 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives1208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__0_in_ruleAssignableAlternatives1234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference1261 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference1268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__0_in_ruleCrossReference1294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1321 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal1328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement1381 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement1388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__0_in_ruleParenthesizedCrossReferenceableElement1414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives1441 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives1448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group__0_in_ruleCrossReferenceableAlternatives1474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1501 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement1508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__0_in_ruleParenthesizedElement1534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1561 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__0_in_ruleTerminalRule1594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1621 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives1628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__0_in_ruleTerminalAlternatives1654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1681 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup1688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__0_in_ruleTerminalGroup1714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1741 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken1748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__0_in_ruleTerminalToken1774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1801 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement1808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1861 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement1868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__0_in_ruleParenthesizedTerminalElement1894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1921 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken1928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1981 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken1988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__0_in_ruleNegatedToken2014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken2041 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken2048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__0_in_ruleUntilToken2074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard2101 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcard2108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__0_in_ruleWildcard2134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2161 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange2168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__0_in_ruleCharacterRange2194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule2221 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule2228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__0_in_ruleEnumRule2254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2281 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals2288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__0_in_ruleEnumLiterals2314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2341 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration2348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__0_in_ruleEnumLiteralDeclaration2374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_rule__AbstractRule__Alternatives2410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_rule__AbstractRule__Alternatives2427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_rule__AbstractRule__Alternatives2444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_rule__AbstractToken__Alternatives2525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_rule__AbstractToken__Alternatives2542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_rule__AbstractTokenWithCardinality__Alternatives_02574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_rule__AbstractTokenWithCardinality__Alternatives_02591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Action__OperatorAlternatives_2_2_02699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Action__OperatorAlternatives_2_2_02719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__AbstractTerminal__Alternatives2753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__AbstractTerminal__Alternatives2770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_rule__AbstractTerminal__Alternatives2787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Assignment__OperatorAlternatives_1_02820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Assignment__OperatorAlternatives_1_02840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Assignment__OperatorAlternatives_1_02860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__AssignableTerminal__Alternatives2894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__AssignableTerminal__Alternatives2911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_rule__AssignableTerminal__Alternatives2928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_rule__AssignableTerminal__Alternatives2945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CrossReferenceableTerminal__Alternatives2977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__CrossReferenceableTerminal__Alternatives2994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_rule__CrossReferenceableTerminal__Alternatives3011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_03044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_03064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_03084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__0__Impl_in_rule__Grammar__Group__03265 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__1_in_rule__Grammar__Group__03268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Grammar__Group__0__Impl3296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__1__Impl_in_rule__Grammar__Group__13327 = new BitSet(new long[]{0x0000031002840010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__2_in_rule__Grammar__Group__13330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__NameAssignment_1_in_rule__Grammar__Group__1__Impl3357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__2__Impl_in_rule__Grammar__Group__23387 = new BitSet(new long[]{0x0000031002800010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__3_in_rule__Grammar__Group__23390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__0_in_rule__Grammar__Group__2__Impl3417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__3__Impl_in_rule__Grammar__Group__33448 = new BitSet(new long[]{0x0000011002800010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__4_in_rule__Grammar__Group__33451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__0_in_rule__Grammar__Group__3__Impl3478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__4__Impl_in_rule__Grammar__Group__43509 = new BitSet(new long[]{0x0000011000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__5_in_rule__Grammar__Group__43512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__MetamodelDeclarationsAssignment_4_in_rule__Grammar__Group__4__Impl3539 = new BitSet(new long[]{0x0000000002800002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__5__Impl_in_rule__Grammar__Group__53570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__5__Impl3599 = new BitSet(new long[]{0x0000011000000012L});
        public static final BitSet FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__5__Impl3611 = new BitSet(new long[]{0x0000011000000012L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__0__Impl_in_rule__Grammar__Group_2__03656 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__1_in_rule__Grammar__Group_2__03659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Grammar__Group_2__0__Impl3687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__1__Impl_in_rule__Grammar__Group_2__13718 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__2_in_rule__Grammar__Group_2__13721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_1_in_rule__Grammar__Group_2__1__Impl3748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__2__Impl_in_rule__Grammar__Group_2__23778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__0_in_rule__Grammar__Group_2__2__Impl3805 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__0__Impl_in_rule__Grammar__Group_2_2__03842 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__1_in_rule__Grammar__Group_2_2__03845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Grammar__Group_2_2__0__Impl3873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__1__Impl_in_rule__Grammar__Group_2_2__13904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_2_1_in_rule__Grammar__Group_2_2__1__Impl3931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__0__Impl_in_rule__Grammar__Group_3__03965 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__1_in_rule__Grammar__Group_3__03968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__DefinesHiddenTokensAssignment_3_0_in_rule__Grammar__Group_3__0__Impl3995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__1__Impl_in_rule__Grammar__Group_3__14025 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__2_in_rule__Grammar__Group_3__14028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Grammar__Group_3__1__Impl4056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__2__Impl_in_rule__Grammar__Group_3__24087 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__3_in_rule__Grammar__Group_3__24090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__0_in_rule__Grammar__Group_3__2__Impl4117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__3__Impl_in_rule__Grammar__Group_3__34148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Grammar__Group_3__3__Impl4176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__0__Impl_in_rule__Grammar__Group_3_2__04215 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__1_in_rule__Grammar__Group_3_2__04218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_0_in_rule__Grammar__Group_3_2__0__Impl4245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__1__Impl_in_rule__Grammar__Group_3_2__14275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__0_in_rule__Grammar__Group_3_2__1__Impl4302 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__0__Impl_in_rule__Grammar__Group_3_2_1__04337 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__1_in_rule__Grammar__Group_3_2_1__04340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Grammar__Group_3_2_1__0__Impl4368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__1__Impl_in_rule__Grammar__Group_3_2_1__14399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_1_1_in_rule__Grammar__Group_3_2_1__1__Impl4426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__0__Impl_in_rule__GrammarID__Group__04460 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__1_in_rule__GrammarID__Group__04463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group__0__Impl4490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__1__Impl_in_rule__GrammarID__Group__14519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__0_in_rule__GrammarID__Group__1__Impl4546 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__0__Impl_in_rule__GrammarID__Group_1__04581 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__1_in_rule__GrammarID__Group_1__04584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__GrammarID__Group_1__0__Impl4612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__1__Impl_in_rule__GrammarID__Group_1__14643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group_1__1__Impl4670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__0__Impl_in_rule__GeneratedMetamodel__Group__04703 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__1_in_rule__GeneratedMetamodel__Group__04706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__GeneratedMetamodel__Group__0__Impl4734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__1__Impl_in_rule__GeneratedMetamodel__Group__14765 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__2_in_rule__GeneratedMetamodel__Group__14768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__NameAssignment_1_in_rule__GeneratedMetamodel__Group__1__Impl4795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__2__Impl_in_rule__GeneratedMetamodel__Group__24825 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__3_in_rule__GeneratedMetamodel__Group__24828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__EPackageAssignment_2_in_rule__GeneratedMetamodel__Group__2__Impl4855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__3__Impl_in_rule__GeneratedMetamodel__Group__34885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__0_in_rule__GeneratedMetamodel__Group__3__Impl4912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__0__Impl_in_rule__GeneratedMetamodel__Group_3__04951 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__1_in_rule__GeneratedMetamodel__Group_3__04954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__GeneratedMetamodel__Group_3__0__Impl4982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__1__Impl_in_rule__GeneratedMetamodel__Group_3__15013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__AliasAssignment_3_1_in_rule__GeneratedMetamodel__Group_3__1__Impl5040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__0__Impl_in_rule__ReferencedMetamodel__Group__05074 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__05077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ReferencedMetamodel__Group__0__Impl5105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__1__Impl_in_rule__ReferencedMetamodel__Group__15136 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__15139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_1_in_rule__ReferencedMetamodel__Group__1__Impl5166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__2__Impl_in_rule__ReferencedMetamodel__Group__25196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__0_in_rule__ReferencedMetamodel__Group__2__Impl5223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__0__Impl_in_rule__ReferencedMetamodel__Group_2__05260 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__1_in_rule__ReferencedMetamodel__Group_2__05263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__ReferencedMetamodel__Group_2__0__Impl5291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__1__Impl_in_rule__ReferencedMetamodel__Group_2__15322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__AliasAssignment_2_1_in_rule__ReferencedMetamodel__Group_2__1__Impl5349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__0__Impl_in_rule__ParserRule__Group__05383 = new BitSet(new long[]{0x0000020014000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__1_in_rule__ParserRule__Group__05386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__NameAssignment_0_in_rule__ParserRule__Group__0__Impl5413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__1__Impl_in_rule__ParserRule__Group__15443 = new BitSet(new long[]{0x0000020004000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__2_in_rule__ParserRule__Group__15446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__0_in_rule__ParserRule__Group__1__Impl5473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__2__Impl_in_rule__ParserRule__Group__25504 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__3_in_rule__ParserRule__Group__25507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__0_in_rule__ParserRule__Group__2__Impl5534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__3__Impl_in_rule__ParserRule__Group__35565 = new BitSet(new long[]{0x0000000080100030L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__4_in_rule__ParserRule__Group__35568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__ParserRule__Group__3__Impl5596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__4__Impl_in_rule__ParserRule__Group__45627 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__5_in_rule__ParserRule__Group__45630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__AlternativesAssignment_4_in_rule__ParserRule__Group__4__Impl5657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__5__Impl_in_rule__ParserRule__Group__55687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ParserRule__Group__5__Impl5715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__0__Impl_in_rule__ParserRule__Group_1__05758 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__1_in_rule__ParserRule__Group_1__05761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ParserRule__Group_1__0__Impl5789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__1__Impl_in_rule__ParserRule__Group_1__15820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__TypeAssignment_1_1_in_rule__ParserRule__Group_1__1__Impl5847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__0__Impl_in_rule__ParserRule__Group_2__05881 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__1_in_rule__ParserRule__Group_2__05884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__DefinesHiddenTokensAssignment_2_0_in_rule__ParserRule__Group_2__0__Impl5911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__1__Impl_in_rule__ParserRule__Group_2__15941 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__2_in_rule__ParserRule__Group_2__15944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParserRule__Group_2__1__Impl5972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__2__Impl_in_rule__ParserRule__Group_2__26003 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__3_in_rule__ParserRule__Group_2__26006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__0_in_rule__ParserRule__Group_2__2__Impl6033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__3__Impl_in_rule__ParserRule__Group_2__36064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParserRule__Group_2__3__Impl6092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__0__Impl_in_rule__ParserRule__Group_2_2__06131 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__1_in_rule__ParserRule__Group_2_2__06134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_0_in_rule__ParserRule__Group_2_2__0__Impl6161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__1__Impl_in_rule__ParserRule__Group_2_2__16191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__0_in_rule__ParserRule__Group_2_2__1__Impl6218 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__0__Impl_in_rule__ParserRule__Group_2_2_1__06253 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__1_in_rule__ParserRule__Group_2_2_1__06256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__ParserRule__Group_2_2_1__0__Impl6284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__1__Impl_in_rule__ParserRule__Group_2_2_1__16315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_1_1_in_rule__ParserRule__Group_2_2_1__1__Impl6342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__0__Impl_in_rule__TypeRef__Group__06376 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__1_in_rule__TypeRef__Group__06379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__0_in_rule__TypeRef__Group__0__Impl6406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__1__Impl_in_rule__TypeRef__Group__16437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__ClassifierAssignment_1_in_rule__TypeRef__Group__1__Impl6464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__0__Impl_in_rule__TypeRef__Group_0__06498 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__1_in_rule__TypeRef__Group_0__06501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__MetamodelAssignment_0_0_in_rule__TypeRef__Group_0__0__Impl6528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__1__Impl_in_rule__TypeRef__Group_0__16558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__TypeRef__Group_0__1__Impl6586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__0__Impl_in_rule__Alternatives__Group__06621 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__1_in_rule__Alternatives__Group__06624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_rule__Alternatives__Group__0__Impl6651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__1__Impl_in_rule__Alternatives__Group__16680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__0_in_rule__Alternatives__Group__1__Impl6707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__0__Impl_in_rule__Alternatives__Group_1__06742 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__1_in_rule__Alternatives__Group_1__06745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__1__Impl_in_rule__Alternatives__Group_1__16803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__1__Impl6832 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__1__Impl6844 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0__Impl_in_rule__Alternatives__Group_1_1__06881 = new BitSet(new long[]{0x0000000080100030L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__1_in_rule__Alternatives__Group_1_1__06884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__Alternatives__Group_1_1__0__Impl6912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__1__Impl_in_rule__Alternatives__Group_1_1__16943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__GroupsAssignment_1_1_1_in_rule__Alternatives__Group_1_1__1__Impl6970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group__0__Impl_in_rule__Group__Group__07004 = new BitSet(new long[]{0x0000000080100032L});
        public static final BitSet FOLLOW_rule__Group__Group__1_in_rule__Group__Group__07007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__Group__0__Impl7034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group__1__Impl_in_rule__Group__Group__17063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__0_in_rule__Group__Group__1__Impl7090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__0__Impl_in_rule__Group__Group_1__07125 = new BitSet(new long[]{0x0000000080100030L});
        public static final BitSet FOLLOW_rule__Group__Group_1__1_in_rule__Group__Group_1__07128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__1__Impl_in_rule__Group__Group_1__17186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__1__Impl7215 = new BitSet(new long[]{0x0000000080100032L});
        public static final BitSet FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__1__Impl7227 = new BitSet(new long[]{0x0000000080100032L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__0__Impl_in_rule__AbstractTokenWithCardinality__Group__07264 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__1_in_rule__AbstractTokenWithCardinality__Group__07267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group__0__Impl7294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__1__Impl_in_rule__AbstractTokenWithCardinality__Group__17324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAssignment_1_in_rule__AbstractTokenWithCardinality__Group__1__Impl7351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__0__Impl_in_rule__Action__Group__07386 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Action__Group__1_in_rule__Action__Group__07389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__Action__Group__0__Impl7417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__1__Impl_in_rule__Action__Group__17448 = new BitSet(new long[]{0x0000000100400000L});
        public static final BitSet FOLLOW_rule__Action__Group__2_in_rule__Action__Group__17451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__TypeAssignment_1_in_rule__Action__Group__1__Impl7478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__2__Impl_in_rule__Action__Group__27508 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__Action__Group__3_in_rule__Action__Group__27511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__0_in_rule__Action__Group__2__Impl7538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__3__Impl_in_rule__Action__Group__37569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Action__Group__3__Impl7597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__0__Impl_in_rule__Action__Group_2__07636 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Action__Group_2__1_in_rule__Action__Group_2__07639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Action__Group_2__0__Impl7667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__1__Impl_in_rule__Action__Group_2__17698 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_rule__Action__Group_2__2_in_rule__Action__Group_2__17701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__FeatureAssignment_2_1_in_rule__Action__Group_2__1__Impl7728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__2__Impl_in_rule__Action__Group_2__27758 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__Action__Group_2__3_in_rule__Action__Group_2__27761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__OperatorAssignment_2_2_in_rule__Action__Group_2__2__Impl7788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__3__Impl_in_rule__Action__Group_2__37818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__Action__Group_2__3__Impl7846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__0__Impl_in_rule__Assignment__Group__07885 = new BitSet(new long[]{0x000000000001C000L});
        public static final BitSet FOLLOW_rule__Assignment__Group__1_in_rule__Assignment__Group__07888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__FeatureAssignment_0_in_rule__Assignment__Group__0__Impl7915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__1__Impl_in_rule__Assignment__Group__17945 = new BitSet(new long[]{0x0000000400100030L});
        public static final BitSet FOLLOW_rule__Assignment__Group__2_in_rule__Assignment__Group__17948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__OperatorAssignment_1_in_rule__Assignment__Group__1__Impl7975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__2__Impl_in_rule__Assignment__Group__28005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__TerminalAssignment_2_in_rule__Assignment__Group__2__Impl8032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__0__Impl_in_rule__ParenthesizedAssignableElement__Group__08068 = new BitSet(new long[]{0x0000000400100030L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__1_in_rule__ParenthesizedAssignableElement__Group__08071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedAssignableElement__Group__0__Impl8099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__1__Impl_in_rule__ParenthesizedAssignableElement__Group__18130 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__2_in_rule__ParenthesizedAssignableElement__Group__18133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group__1__Impl8160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__2__Impl_in_rule__ParenthesizedAssignableElement__Group__28189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group__2__Impl8217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__0__Impl_in_rule__AssignableAlternatives__Group__08254 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__1_in_rule__AssignableAlternatives__Group__08257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group__0__Impl8284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__1__Impl_in_rule__AssignableAlternatives__Group__18313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__0_in_rule__AssignableAlternatives__Group__1__Impl8340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__0__Impl_in_rule__AssignableAlternatives__Group_1__08375 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__1_in_rule__AssignableAlternatives__Group_1__08378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__1__Impl_in_rule__AssignableAlternatives__Group_1__18436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__1__Impl8465 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__1__Impl8477 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0__Impl_in_rule__AssignableAlternatives__Group_1_1__08514 = new BitSet(new long[]{0x0000000400100030L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__1_in_rule__AssignableAlternatives__Group_1_1__08517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__AssignableAlternatives__Group_1_1__0__Impl8545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__1__Impl_in_rule__AssignableAlternatives__Group_1_1__18576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__GroupsAssignment_1_1_1_in_rule__AssignableAlternatives__Group_1_1__1__Impl8603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__0__Impl_in_rule__CrossReference__Group__08637 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__1_in_rule__CrossReference__Group__08640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__CrossReference__Group__0__Impl8668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__1__Impl_in_rule__CrossReference__Group__18699 = new BitSet(new long[]{0x0000000840000000L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__2_in_rule__CrossReference__Group__18702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__TypeAssignment_1_in_rule__CrossReference__Group__1__Impl8729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__2__Impl_in_rule__CrossReference__Group__28759 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__3_in_rule__CrossReference__Group__28762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__0_in_rule__CrossReference__Group__2__Impl8789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__3__Impl_in_rule__CrossReference__Group__38820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__CrossReference__Group__3__Impl8848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__0__Impl_in_rule__CrossReference__Group_2__08887 = new BitSet(new long[]{0x0000000000100030L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__1_in_rule__CrossReference__Group_2__08890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__CrossReference__Group_2__0__Impl8918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__1__Impl_in_rule__CrossReference__Group_2__18949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__TerminalAssignment_2_1_in_rule__CrossReference__Group_2__1__Impl8976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__0__Impl_in_rule__ParenthesizedCrossReferenceableElement__Group__09010 = new BitSet(new long[]{0x0000000000100030L});
        public static final BitSet FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__1_in_rule__ParenthesizedCrossReferenceableElement__Group__09013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedCrossReferenceableElement__Group__0__Impl9041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__1__Impl_in_rule__ParenthesizedCrossReferenceableElement__Group__19072 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__2_in_rule__ParenthesizedCrossReferenceableElement__Group__19075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_rule__ParenthesizedCrossReferenceableElement__Group__1__Impl9102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__2__Impl_in_rule__ParenthesizedCrossReferenceableElement__Group__29131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedCrossReferenceableElement__Group__2__Impl9159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group__0__Impl_in_rule__CrossReferenceableAlternatives__Group__09196 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group__1_in_rule__CrossReferenceableAlternatives__Group__09199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReferenceableAlternatives__Group__0__Impl9226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group__1__Impl_in_rule__CrossReferenceableAlternatives__Group__19255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1__0_in_rule__CrossReferenceableAlternatives__Group__1__Impl9282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1__0__Impl_in_rule__CrossReferenceableAlternatives__Group_1__09317 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1__1_in_rule__CrossReferenceableAlternatives__Group_1__09320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1__1__Impl_in_rule__CrossReferenceableAlternatives__Group_1__19378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__0_in_rule__CrossReferenceableAlternatives__Group_1__1__Impl9407 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__0_in_rule__CrossReferenceableAlternatives__Group_1__1__Impl9419 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__0__Impl_in_rule__CrossReferenceableAlternatives__Group_1_1__09456 = new BitSet(new long[]{0x0000000000100030L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__1_in_rule__CrossReferenceableAlternatives__Group_1_1__09459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__CrossReferenceableAlternatives__Group_1_1__0__Impl9487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__1__Impl_in_rule__CrossReferenceableAlternatives__Group_1_1__19518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1_in_rule__CrossReferenceableAlternatives__Group_1_1__1__Impl9545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__0__Impl_in_rule__ParenthesizedElement__Group__09579 = new BitSet(new long[]{0x0000000080100030L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__1_in_rule__ParenthesizedElement__Group__09582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedElement__Group__0__Impl9610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__1__Impl_in_rule__ParenthesizedElement__Group__19641 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__2_in_rule__ParenthesizedElement__Group__19644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group__1__Impl9671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__2__Impl_in_rule__ParenthesizedElement__Group__29700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedElement__Group__2__Impl9728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__0__Impl_in_rule__TerminalRule__Group__09765 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__1_in_rule__TerminalRule__Group__09768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__TerminalRule__Group__0__Impl9796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__1__Impl_in_rule__TerminalRule__Group__19827 = new BitSet(new long[]{0x0000000014000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__2_in_rule__TerminalRule__Group__19830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__NameAssignment_1_in_rule__TerminalRule__Group__1__Impl9857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__2__Impl_in_rule__TerminalRule__Group__29887 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__3_in_rule__TerminalRule__Group__29890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_2__0_in_rule__TerminalRule__Group__2__Impl9917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__3__Impl_in_rule__TerminalRule__Group__39948 = new BitSet(new long[]{0x0000006000500030L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__4_in_rule__TerminalRule__Group__39951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__TerminalRule__Group__3__Impl9979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__4__Impl_in_rule__TerminalRule__Group__410010 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__5_in_rule__TerminalRule__Group__410013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__AlternativesAssignment_4_in_rule__TerminalRule__Group__4__Impl10040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__5__Impl_in_rule__TerminalRule__Group__510070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__TerminalRule__Group__5__Impl10098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_2__0__Impl_in_rule__TerminalRule__Group_2__010141 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_2__1_in_rule__TerminalRule__Group_2__010144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__TerminalRule__Group_2__0__Impl10172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_2__1__Impl_in_rule__TerminalRule__Group_2__110203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__TypeAssignment_2_1_in_rule__TerminalRule__Group_2__1__Impl10230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__0__Impl_in_rule__TerminalAlternatives__Group__010264 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__1_in_rule__TerminalAlternatives__Group__010267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group__0__Impl10294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__1__Impl_in_rule__TerminalAlternatives__Group__110323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__0_in_rule__TerminalAlternatives__Group__1__Impl10350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__0__Impl_in_rule__TerminalAlternatives__Group_1__010385 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__1_in_rule__TerminalAlternatives__Group_1__010388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__1__Impl_in_rule__TerminalAlternatives__Group_1__110446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__1__Impl10475 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__1__Impl10487 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0__Impl_in_rule__TerminalAlternatives__Group_1_1__010524 = new BitSet(new long[]{0x0000006000500030L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__1_in_rule__TerminalAlternatives__Group_1_1__010527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__TerminalAlternatives__Group_1_1__0__Impl10555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__1__Impl_in_rule__TerminalAlternatives__Group_1_1__110586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__GroupsAssignment_1_1_1_in_rule__TerminalAlternatives__Group_1_1__1__Impl10613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__0__Impl_in_rule__TerminalGroup__Group__010647 = new BitSet(new long[]{0x0000006000500032L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__1_in_rule__TerminalGroup__Group__010650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group__0__Impl10677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__1__Impl_in_rule__TerminalGroup__Group__110706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__0_in_rule__TerminalGroup__Group__1__Impl10733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__0__Impl_in_rule__TerminalGroup__Group_1__010768 = new BitSet(new long[]{0x0000006000500030L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__1_in_rule__TerminalGroup__Group_1__010771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__1__Impl_in_rule__TerminalGroup__Group_1__110829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__1__Impl10858 = new BitSet(new long[]{0x0000006000500032L});
        public static final BitSet FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__1__Impl10870 = new BitSet(new long[]{0x0000006000500032L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__0__Impl_in_rule__TerminalToken__Group__010907 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__1_in_rule__TerminalToken__Group__010910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group__0__Impl10937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__1__Impl_in_rule__TerminalToken__Group__110966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAssignment_1_in_rule__TerminalToken__Group__1__Impl10993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__0__Impl_in_rule__ParenthesizedTerminalElement__Group__011028 = new BitSet(new long[]{0x0000006000500030L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__1_in_rule__ParenthesizedTerminalElement__Group__011031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedTerminalElement__Group__0__Impl11059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__1__Impl_in_rule__ParenthesizedTerminalElement__Group__111090 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__2_in_rule__ParenthesizedTerminalElement__Group__111093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group__1__Impl11120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__2__Impl_in_rule__ParenthesizedTerminalElement__Group__211149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group__2__Impl11177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__0__Impl_in_rule__NegatedToken__Group__011214 = new BitSet(new long[]{0x0000006000500030L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__1_in_rule__NegatedToken__Group__011217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__NegatedToken__Group__0__Impl11245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__1__Impl_in_rule__NegatedToken__Group__111276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__TerminalAssignment_1_in_rule__NegatedToken__Group__1__Impl11303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__0__Impl_in_rule__UntilToken__Group__011337 = new BitSet(new long[]{0x0000006000500030L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__1_in_rule__UntilToken__Group__011340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__UntilToken__Group__0__Impl11368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__1__Impl_in_rule__UntilToken__Group__111399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__TerminalAssignment_1_in_rule__UntilToken__Group__1__Impl11426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__0__Impl_in_rule__Wildcard__Group__011460 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__1_in_rule__Wildcard__Group__011463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__1__Impl_in_rule__Wildcard__Group__111521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Wildcard__Group__1__Impl11549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__0__Impl_in_rule__CharacterRange__Group__011584 = new BitSet(new long[]{0x0000008000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__1_in_rule__CharacterRange__Group__011587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__Group__0__Impl11614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__1__Impl_in_rule__CharacterRange__Group__111643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__0_in_rule__CharacterRange__Group__1__Impl11670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__0__Impl_in_rule__CharacterRange__Group_1__011705 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__1_in_rule__CharacterRange__Group_1__011708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__1__Impl_in_rule__CharacterRange__Group_1__111766 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__2_in_rule__CharacterRange__Group_1__111769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__CharacterRange__Group_1__1__Impl11797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__2__Impl_in_rule__CharacterRange__Group_1__211828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__RightAssignment_1_2_in_rule__CharacterRange__Group_1__2__Impl11855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__0__Impl_in_rule__EnumRule__Group__011891 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__1_in_rule__EnumRule__Group__011894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__EnumRule__Group__0__Impl11922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__1__Impl_in_rule__EnumRule__Group__111953 = new BitSet(new long[]{0x0000000014000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__2_in_rule__EnumRule__Group__111956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__NameAssignment_1_in_rule__EnumRule__Group__1__Impl11983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__2__Impl_in_rule__EnumRule__Group__212013 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__3_in_rule__EnumRule__Group__212016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__0_in_rule__EnumRule__Group__2__Impl12043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__3__Impl_in_rule__EnumRule__Group__312074 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__4_in_rule__EnumRule__Group__312077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__EnumRule__Group__3__Impl12105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__4__Impl_in_rule__EnumRule__Group__412136 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__5_in_rule__EnumRule__Group__412139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__AlternativesAssignment_4_in_rule__EnumRule__Group__4__Impl12166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__5__Impl_in_rule__EnumRule__Group__512196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__EnumRule__Group__5__Impl12224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__0__Impl_in_rule__EnumRule__Group_2__012267 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__1_in_rule__EnumRule__Group_2__012270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__EnumRule__Group_2__0__Impl12298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__1__Impl_in_rule__EnumRule__Group_2__112329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__TypeAssignment_2_1_in_rule__EnumRule__Group_2__1__Impl12356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__0__Impl_in_rule__EnumLiterals__Group__012390 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__1_in_rule__EnumLiterals__Group__012393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group__0__Impl12420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__1__Impl_in_rule__EnumLiterals__Group__112449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__0_in_rule__EnumLiterals__Group__1__Impl12476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__0__Impl_in_rule__EnumLiterals__Group_1__012511 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__1_in_rule__EnumLiterals__Group_1__012514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__1__Impl_in_rule__EnumLiterals__Group_1__112572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__1__Impl12601 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__1__Impl12613 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0__Impl_in_rule__EnumLiterals__Group_1_1__012650 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__1_in_rule__EnumLiterals__Group_1_1__012653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__EnumLiterals__Group_1_1__0__Impl12681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__1__Impl_in_rule__EnumLiterals__Group_1_1__112712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__GroupsAssignment_1_1_1_in_rule__EnumLiterals__Group_1_1__1__Impl12739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__0__Impl_in_rule__EnumLiteralDeclaration__Group__012773 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__1_in_rule__EnumLiteralDeclaration__Group__012776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__EnumLiteralAssignment_0_in_rule__EnumLiteralDeclaration__Group__0__Impl12803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__1__Impl_in_rule__EnumLiteralDeclaration__Group__112833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__0_in_rule__EnumLiteralDeclaration__Group__1__Impl12860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__0__Impl_in_rule__EnumLiteralDeclaration__Group_1__012895 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__1_in_rule__EnumLiteralDeclaration__Group_1__012898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_1__0__Impl12926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__1__Impl_in_rule__EnumLiteralDeclaration__Group_1__112957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__LiteralAssignment_1_1_in_rule__EnumLiteralDeclaration__Group_1__1__Impl12984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__NameAssignment_113023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_113058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_2_113097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__Grammar__DefinesHiddenTokensAssignment_3_013137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_013180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_1_113219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__MetamodelDeclarationsAssignment_413254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_rule__Grammar__RulesAssignment_513285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__NameAssignment_113316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__EPackageAssignment_213351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__AliasAssignment_3_113386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_113421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_2_113456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__NameAssignment_013487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__ParserRule__TypeAssignment_1_113518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__ParserRule__DefinesHiddenTokensAssignment_2_013554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_013597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_1_113636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParserRule__AlternativesAssignment_413671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__MetamodelAssignment_0_013706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__ClassifierAssignment_113745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_rule__Alternatives__GroupsAssignment_1_1_113780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__TokensAssignment_1_113811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__CardinalityAssignment_113842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Action__TypeAssignment_113875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Action__FeatureAssignment_2_113906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__OperatorAssignment_2_213937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__ValueAssignment13970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__RuleCall__RuleAssignment14005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Assignment__FeatureAssignment_014040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__OperatorAssignment_114071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__Assignment__TerminalAssignment_214104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__GroupsAssignment_1_1_114135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__CrossReference__TypeAssignment_114166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__TerminalAssignment_2_114197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_114228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_114259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__TerminalRule__TypeAssignment_2_114290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__AlternativesAssignment_414321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__GroupsAssignment_1_1_114352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__TokensAssignment_1_114383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__CardinalityAssignment_114414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__TerminalAssignment_114447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__TerminalAssignment_114478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__RightAssignment_1_214509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EnumRule__NameAssignment_114540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__EnumRule__TypeAssignment_2_114571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_rule__EnumRule__AlternativesAssignment_414602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__GroupsAssignment_1_1_114633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__EnumLiteralAssignment_014668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__LiteralAssignment_1_114703 = new BitSet(new long[]{0x0000000000000002L});
    }


}
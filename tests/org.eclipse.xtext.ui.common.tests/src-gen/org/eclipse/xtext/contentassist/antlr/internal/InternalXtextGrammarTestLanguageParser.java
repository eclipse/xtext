package org.eclipse.xtext.contentassist.antlr.internal; 

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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextGrammarTestLanguageParser extends AbstractInternalContentAssistParser {
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

        public InternalXtextGrammarTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g"; }


     
     	private XtextGrammarTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(XtextGrammarTestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }




    // $ANTLR start entryRuleGrammar
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:55:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:55:18: ( ruleGrammar EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:56:1: ruleGrammar EOF
            {
             before(grammarAccess.getGrammarRule()); 
            pushFollow(FOLLOW_ruleGrammar_in_entryRuleGrammar60);
            ruleGrammar();
            _fsp--;

             after(grammarAccess.getGrammarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammar67); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:63:1: ruleGrammar : ( ( rule__Grammar__Group__0 ) ) ;
    public final void ruleGrammar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:67:2: ( ( ( rule__Grammar__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:68:1: ( ( rule__Grammar__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:68:1: ( ( rule__Grammar__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:69:1: ( rule__Grammar__Group__0 )
            {
             before(grammarAccess.getGrammarAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:70:1: ( rule__Grammar__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:70:2: rule__Grammar__Group__0
            {
            pushFollow(FOLLOW_rule__Grammar__Group__0_in_ruleGrammar94);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:82:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:82:20: ( ruleGrammarID EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:83:1: ruleGrammarID EOF
            {
             before(grammarAccess.getGrammarIDRule()); 
            pushFollow(FOLLOW_ruleGrammarID_in_entryRuleGrammarID120);
            ruleGrammarID();
            _fsp--;

             after(grammarAccess.getGrammarIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammarID127); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:90:1: ruleGrammarID : ( ( rule__GrammarID__Group__0 ) ) ;
    public final void ruleGrammarID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:94:2: ( ( ( rule__GrammarID__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:95:1: ( ( rule__GrammarID__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:95:1: ( ( rule__GrammarID__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:96:1: ( rule__GrammarID__Group__0 )
            {
             before(grammarAccess.getGrammarIDAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:97:1: ( rule__GrammarID__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:97:2: rule__GrammarID__Group__0
            {
            pushFollow(FOLLOW_rule__GrammarID__Group__0_in_ruleGrammarID154);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:109:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:109:23: ( ruleAbstractRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:110:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule180);
            ruleAbstractRule();
            _fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule187); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:117:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:121:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:122:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:122:1: ( ( rule__AbstractRule__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:123:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:124:1: ( rule__AbstractRule__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:124:2: rule__AbstractRule__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule214);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:136:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:136:39: ( ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:137:1: ruleAbstractMetamodelDeclaration EOF
            {
             before(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration240);
            ruleAbstractMetamodelDeclaration();
            _fsp--;

             after(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration247); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:144:1: ruleAbstractMetamodelDeclaration : ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:148:2: ( ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:149:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:149:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:150:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            {
             before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:151:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:151:2: rule__AbstractMetamodelDeclaration__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractMetamodelDeclaration__Alternatives_in_ruleAbstractMetamodelDeclaration274);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:163:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:163:29: ( ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:164:1: ruleGeneratedMetamodel EOF
            {
             before(grammarAccess.getGeneratedMetamodelRule()); 
            pushFollow(FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel300);
            ruleGeneratedMetamodel();
            _fsp--;

             after(grammarAccess.getGeneratedMetamodelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratedMetamodel307); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:171:1: ruleGeneratedMetamodel : ( ( rule__GeneratedMetamodel__Group__0 ) ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:175:2: ( ( ( rule__GeneratedMetamodel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:176:1: ( ( rule__GeneratedMetamodel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:176:1: ( ( rule__GeneratedMetamodel__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:177:1: ( rule__GeneratedMetamodel__Group__0 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:178:1: ( rule__GeneratedMetamodel__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:178:2: rule__GeneratedMetamodel__Group__0
            {
            pushFollow(FOLLOW_rule__GeneratedMetamodel__Group__0_in_ruleGeneratedMetamodel334);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:190:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:190:30: ( ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:191:1: ruleReferencedMetamodel EOF
            {
             before(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel360);
            ruleReferencedMetamodel();
            _fsp--;

             after(grammarAccess.getReferencedMetamodelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel367); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:198:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:202:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:203:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:203:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:204:1: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:205:1: ( rule__ReferencedMetamodel__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:205:2: rule__ReferencedMetamodel__Group__0
            {
            pushFollow(FOLLOW_rule__ReferencedMetamodel__Group__0_in_ruleReferencedMetamodel394);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:217:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:217:21: ( ruleParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:218:1: ruleParserRule EOF
            {
             before(grammarAccess.getParserRuleRule()); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule420);
            ruleParserRule();
            _fsp--;

             after(grammarAccess.getParserRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule427); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:225:1: ruleParserRule : ( ( rule__ParserRule__Group__0 ) ) ;
    public final void ruleParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:229:2: ( ( ( rule__ParserRule__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:230:1: ( ( rule__ParserRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:230:1: ( ( rule__ParserRule__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:231:1: ( rule__ParserRule__Group__0 )
            {
             before(grammarAccess.getParserRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:232:1: ( rule__ParserRule__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:232:2: rule__ParserRule__Group__0
            {
            pushFollow(FOLLOW_rule__ParserRule__Group__0_in_ruleParserRule454);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:244:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:244:18: ( ruleTypeRef EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:245:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef480);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getTypeRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef487); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:252:1: ruleTypeRef : ( ( rule__TypeRef__Group__0 ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:256:2: ( ( ( rule__TypeRef__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:257:1: ( ( rule__TypeRef__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:257:1: ( ( rule__TypeRef__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:258:1: ( rule__TypeRef__Group__0 )
            {
             before(grammarAccess.getTypeRefAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:259:1: ( rule__TypeRef__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:259:2: rule__TypeRef__Group__0
            {
            pushFollow(FOLLOW_rule__TypeRef__Group__0_in_ruleTypeRef514);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:271:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:271:23: ( ruleAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:272:1: ruleAlternatives EOF
            {
             before(grammarAccess.getAlternativesRule()); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives540);
            ruleAlternatives();
            _fsp--;

             after(grammarAccess.getAlternativesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives547); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:279:1: ruleAlternatives : ( ( rule__Alternatives__Group__0 ) ) ;
    public final void ruleAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:283:2: ( ( ( rule__Alternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:284:1: ( ( rule__Alternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:284:1: ( ( rule__Alternatives__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:285:1: ( rule__Alternatives__Group__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:286:1: ( rule__Alternatives__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:286:2: rule__Alternatives__Group__0
            {
            pushFollow(FOLLOW_rule__Alternatives__Group__0_in_ruleAlternatives574);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:298:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:298:16: ( ruleGroup EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:299:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup600);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getGroupRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup607); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:306:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:310:2: ( ( ( rule__Group__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:311:1: ( ( rule__Group__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:311:1: ( ( rule__Group__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:312:1: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:313:1: ( rule__Group__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:313:2: rule__Group__Group__0
            {
            pushFollow(FOLLOW_rule__Group__Group__0_in_ruleGroup634);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:325:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:325:24: ( ruleAbstractToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:326:1: ruleAbstractToken EOF
            {
             before(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken660);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getAbstractTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken667); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:333:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:337:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:338:1: ( ( rule__AbstractToken__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:338:1: ( ( rule__AbstractToken__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:339:1: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:340:1: ( rule__AbstractToken__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:340:2: rule__AbstractToken__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken694);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:352:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:352:39: ( ruleAbstractTokenWithCardinality EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:353:1: ruleAbstractTokenWithCardinality EOF
            {
             before(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality720);
            ruleAbstractTokenWithCardinality();
            _fsp--;

             after(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality727); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:360:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:364:2: ( ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:365:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:365:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:366:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:367:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:367:2: rule__AbstractTokenWithCardinality__Group__0
            {
            pushFollow(FOLLOW_rule__AbstractTokenWithCardinality__Group__0_in_ruleAbstractTokenWithCardinality754);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:379:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:379:17: ( ruleAction EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:380:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction780);
            ruleAction();
            _fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction787); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:387:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:391:2: ( ( ( rule__Action__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:392:1: ( ( rule__Action__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:392:1: ( ( rule__Action__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:393:1: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:394:1: ( rule__Action__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:394:2: rule__Action__Group__0
            {
            pushFollow(FOLLOW_rule__Action__Group__0_in_ruleAction814);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:406:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:406:27: ( ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:407:1: ruleAbstractTerminal EOF
            {
             before(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal840);
            ruleAbstractTerminal();
            _fsp--;

             after(grammarAccess.getAbstractTerminalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal847); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:414:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:418:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:419:1: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:419:1: ( ( rule__AbstractTerminal__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:420:1: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:421:1: ( rule__AbstractTerminal__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:421:2: rule__AbstractTerminal__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal874);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:433:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:433:18: ( ruleKeyword EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:434:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword900);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword907); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:441:1: ruleKeyword : ( ( rule__Keyword__ValueAssignment ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:445:2: ( ( ( rule__Keyword__ValueAssignment ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:446:1: ( ( rule__Keyword__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:446:1: ( ( rule__Keyword__ValueAssignment ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:447:1: ( rule__Keyword__ValueAssignment )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:448:1: ( rule__Keyword__ValueAssignment )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:448:2: rule__Keyword__ValueAssignment
            {
            pushFollow(FOLLOW_rule__Keyword__ValueAssignment_in_ruleKeyword934);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:460:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:460:19: ( ruleRuleCall EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:461:1: ruleRuleCall EOF
            {
             before(grammarAccess.getRuleCallRule()); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall960);
            ruleRuleCall();
            _fsp--;

             after(grammarAccess.getRuleCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall967); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:468:1: ruleRuleCall : ( ( rule__RuleCall__RuleAssignment ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:472:2: ( ( ( rule__RuleCall__RuleAssignment ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:473:1: ( ( rule__RuleCall__RuleAssignment ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:473:1: ( ( rule__RuleCall__RuleAssignment ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:474:1: ( rule__RuleCall__RuleAssignment )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:475:1: ( rule__RuleCall__RuleAssignment )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:475:2: rule__RuleCall__RuleAssignment
            {
            pushFollow(FOLLOW_rule__RuleCall__RuleAssignment_in_ruleRuleCall994);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:487:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:487:21: ( ruleAssignment EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:488:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment1020);
            ruleAssignment();
            _fsp--;

             after(grammarAccess.getAssignmentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment1027); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:495:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:499:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:500:1: ( ( rule__Assignment__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:500:1: ( ( rule__Assignment__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:501:1: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:502:1: ( rule__Assignment__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:502:2: rule__Assignment__Group__0
            {
            pushFollow(FOLLOW_rule__Assignment__Group__0_in_ruleAssignment1054);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:514:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:514:29: ( ruleAssignableTerminal EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:515:1: ruleAssignableTerminal EOF
            {
             before(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1080);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableTerminalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignableTerminal1087); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:522:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:526:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:527:1: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:527:1: ( ( rule__AssignableTerminal__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:528:1: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:529:1: ( rule__AssignableTerminal__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:529:2: rule__AssignableTerminal__Alternatives
            {
            pushFollow(FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1114);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:541:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:541:41: ( ruleParenthesizedAssignableElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:542:1: ruleParenthesizedAssignableElement EOF
            {
             before(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1140);
            ruleParenthesizedAssignableElement();
            _fsp--;

             after(grammarAccess.getParenthesizedAssignableElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement1147); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:549:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:553:2: ( ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:554:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:554:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:555:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:556:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:556:2: rule__ParenthesizedAssignableElement__Group__0
            {
            pushFollow(FOLLOW_rule__ParenthesizedAssignableElement__Group__0_in_ruleParenthesizedAssignableElement1174);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:568:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:568:33: ( ruleAssignableAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:569:1: ruleAssignableAlternatives EOF
            {
             before(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1200);
            ruleAssignableAlternatives();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignableAlternatives1207); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:576:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group__0 ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:580:2: ( ( ( rule__AssignableAlternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:581:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:581:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:582:1: ( rule__AssignableAlternatives__Group__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:583:1: ( rule__AssignableAlternatives__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:583:2: rule__AssignableAlternatives__Group__0
            {
            pushFollow(FOLLOW_rule__AssignableAlternatives__Group__0_in_ruleAssignableAlternatives1234);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:595:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:595:25: ( ruleCrossReference EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:596:1: ruleCrossReference EOF
            {
             before(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference1260);
            ruleCrossReference();
            _fsp--;

             after(grammarAccess.getCrossReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference1267); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:603:1: ruleCrossReference : ( ( rule__CrossReference__Group__0 ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:607:2: ( ( ( rule__CrossReference__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:608:1: ( ( rule__CrossReference__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:608:1: ( ( rule__CrossReference__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:609:1: ( rule__CrossReference__Group__0 )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:610:1: ( rule__CrossReference__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:610:2: rule__CrossReference__Group__0
            {
            pushFollow(FOLLOW_rule__CrossReference__Group__0_in_ruleCrossReference1294);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:622:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:622:37: ( ruleCrossReferenceableTerminal EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:623:1: ruleCrossReferenceableTerminal EOF
            {
             before(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1320);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceableTerminalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal1327); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:630:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:634:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:635:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:635:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:636:1: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:637:1: ( rule__CrossReferenceableTerminal__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:637:2: rule__CrossReferenceableTerminal__Alternatives
            {
            pushFollow(FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1354);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:649:1: entryRuleParenthesizedCrossReferenceableElement : ruleParenthesizedCrossReferenceableElement EOF ;
    public final void entryRuleParenthesizedCrossReferenceableElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:649:49: ( ruleParenthesizedCrossReferenceableElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:650:1: ruleParenthesizedCrossReferenceableElement EOF
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementRule()); 
            pushFollow(FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement1380);
            ruleParenthesizedCrossReferenceableElement();
            _fsp--;

             after(grammarAccess.getParenthesizedCrossReferenceableElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement1387); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:657:1: ruleParenthesizedCrossReferenceableElement : ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) ) ;
    public final void ruleParenthesizedCrossReferenceableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:661:2: ( ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:662:1: ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:662:1: ( ( rule__ParenthesizedCrossReferenceableElement__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:663:1: ( rule__ParenthesizedCrossReferenceableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:664:1: ( rule__ParenthesizedCrossReferenceableElement__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:664:2: rule__ParenthesizedCrossReferenceableElement__Group__0
            {
            pushFollow(FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__0_in_ruleParenthesizedCrossReferenceableElement1414);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:676:1: entryRuleCrossReferenceableAlternatives : ruleCrossReferenceableAlternatives EOF ;
    public final void entryRuleCrossReferenceableAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:676:41: ( ruleCrossReferenceableAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:677:1: ruleCrossReferenceableAlternatives EOF
            {
             before(grammarAccess.getCrossReferenceableAlternativesRule()); 
            pushFollow(FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives1440);
            ruleCrossReferenceableAlternatives();
            _fsp--;

             after(grammarAccess.getCrossReferenceableAlternativesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives1447); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:684:1: ruleCrossReferenceableAlternatives : ( ( rule__CrossReferenceableAlternatives__Group__0 ) ) ;
    public final void ruleCrossReferenceableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:688:2: ( ( ( rule__CrossReferenceableAlternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:689:1: ( ( rule__CrossReferenceableAlternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:689:1: ( ( rule__CrossReferenceableAlternatives__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:690:1: ( rule__CrossReferenceableAlternatives__Group__0 )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:691:1: ( rule__CrossReferenceableAlternatives__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:691:2: rule__CrossReferenceableAlternatives__Group__0
            {
            pushFollow(FOLLOW_rule__CrossReferenceableAlternatives__Group__0_in_ruleCrossReferenceableAlternatives1474);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:703:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:703:31: ( ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:704:1: ruleParenthesizedElement EOF
            {
             before(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1500);
            ruleParenthesizedElement();
            _fsp--;

             after(grammarAccess.getParenthesizedElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement1507); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:711:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group__0 ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:715:2: ( ( ( rule__ParenthesizedElement__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:716:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:716:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:717:1: ( rule__ParenthesizedElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:718:1: ( rule__ParenthesizedElement__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:718:2: rule__ParenthesizedElement__Group__0
            {
            pushFollow(FOLLOW_rule__ParenthesizedElement__Group__0_in_ruleParenthesizedElement1534);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:730:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:730:23: ( ruleTerminalRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:731:1: ruleTerminalRule EOF
            {
             before(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1560);
            ruleTerminalRule();
            _fsp--;

             after(grammarAccess.getTerminalRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule1567); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:738:1: ruleTerminalRule : ( ( rule__TerminalRule__Group__0 ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:742:2: ( ( ( rule__TerminalRule__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:743:1: ( ( rule__TerminalRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:743:1: ( ( rule__TerminalRule__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:744:1: ( rule__TerminalRule__Group__0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:745:1: ( rule__TerminalRule__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:745:2: rule__TerminalRule__Group__0
            {
            pushFollow(FOLLOW_rule__TerminalRule__Group__0_in_ruleTerminalRule1594);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:757:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:757:31: ( ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:758:1: ruleTerminalAlternatives EOF
            {
             before(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1620);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives1627); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:765:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group__0 ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:769:2: ( ( ( rule__TerminalAlternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:770:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:770:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:771:1: ( rule__TerminalAlternatives__Group__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:772:1: ( rule__TerminalAlternatives__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:772:2: rule__TerminalAlternatives__Group__0
            {
            pushFollow(FOLLOW_rule__TerminalAlternatives__Group__0_in_ruleTerminalAlternatives1654);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:784:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:784:24: ( ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:785:1: ruleTerminalGroup EOF
            {
             before(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1680);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalGroupRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup1687); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:792:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group__0 ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:796:2: ( ( ( rule__TerminalGroup__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:797:1: ( ( rule__TerminalGroup__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:797:1: ( ( rule__TerminalGroup__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:798:1: ( rule__TerminalGroup__Group__0 )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:799:1: ( rule__TerminalGroup__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:799:2: rule__TerminalGroup__Group__0
            {
            pushFollow(FOLLOW_rule__TerminalGroup__Group__0_in_ruleTerminalGroup1714);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:811:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:811:24: ( ruleTerminalToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:812:1: ruleTerminalToken EOF
            {
             before(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1740);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken1747); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:819:1: ruleTerminalToken : ( ( rule__TerminalToken__Group__0 ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:823:2: ( ( ( rule__TerminalToken__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:824:1: ( ( rule__TerminalToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:824:1: ( ( rule__TerminalToken__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:825:1: ( rule__TerminalToken__Group__0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:826:1: ( rule__TerminalToken__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:826:2: rule__TerminalToken__Group__0
            {
            pushFollow(FOLLOW_rule__TerminalToken__Group__0_in_ruleTerminalToken1774);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:838:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:838:31: ( ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:839:1: ruleTerminalTokenElement EOF
            {
             before(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1800);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getTerminalTokenElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement1807); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:846:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:850:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:851:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:851:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:852:1: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:853:1: ( rule__TerminalTokenElement__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:853:2: rule__TerminalTokenElement__Alternatives
            {
            pushFollow(FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1834);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:865:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:865:39: ( ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:866:1: ruleParenthesizedTerminalElement EOF
            {
             before(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1860);
            ruleParenthesizedTerminalElement();
            _fsp--;

             after(grammarAccess.getParenthesizedTerminalElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement1867); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:873:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:877:2: ( ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:878:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:878:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:879:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:880:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:880:2: rule__ParenthesizedTerminalElement__Group__0
            {
            pushFollow(FOLLOW_rule__ParenthesizedTerminalElement__Group__0_in_ruleParenthesizedTerminalElement1894);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:892:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:892:31: ( ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:893:1: ruleAbstractNegatedToken EOF
            {
             before(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1920);
            ruleAbstractNegatedToken();
            _fsp--;

             after(grammarAccess.getAbstractNegatedTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken1927); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:900:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:904:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:905:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:905:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:906:1: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:907:1: ( rule__AbstractNegatedToken__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:907:2: rule__AbstractNegatedToken__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1954);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:919:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:919:23: ( ruleNegatedToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:920:1: ruleNegatedToken EOF
            {
             before(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1980);
            ruleNegatedToken();
            _fsp--;

             after(grammarAccess.getNegatedTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken1987); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:927:1: ruleNegatedToken : ( ( rule__NegatedToken__Group__0 ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:931:2: ( ( ( rule__NegatedToken__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:932:1: ( ( rule__NegatedToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:932:1: ( ( rule__NegatedToken__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:933:1: ( rule__NegatedToken__Group__0 )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:934:1: ( rule__NegatedToken__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:934:2: rule__NegatedToken__Group__0
            {
            pushFollow(FOLLOW_rule__NegatedToken__Group__0_in_ruleNegatedToken2014);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:946:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:946:21: ( ruleUntilToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:947:1: ruleUntilToken EOF
            {
             before(grammarAccess.getUntilTokenRule()); 
            pushFollow(FOLLOW_ruleUntilToken_in_entryRuleUntilToken2040);
            ruleUntilToken();
            _fsp--;

             after(grammarAccess.getUntilTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUntilToken2047); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:954:1: ruleUntilToken : ( ( rule__UntilToken__Group__0 ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:958:2: ( ( ( rule__UntilToken__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:959:1: ( ( rule__UntilToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:959:1: ( ( rule__UntilToken__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:960:1: ( rule__UntilToken__Group__0 )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:961:1: ( rule__UntilToken__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:961:2: rule__UntilToken__Group__0
            {
            pushFollow(FOLLOW_rule__UntilToken__Group__0_in_ruleUntilToken2074);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:973:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:973:19: ( ruleWildcard EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:974:1: ruleWildcard EOF
            {
             before(grammarAccess.getWildcardRule()); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard2100);
            ruleWildcard();
            _fsp--;

             after(grammarAccess.getWildcardRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard2107); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:981:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:985:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:986:1: ( ( rule__Wildcard__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:986:1: ( ( rule__Wildcard__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:987:1: ( rule__Wildcard__Group__0 )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:988:1: ( rule__Wildcard__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:988:2: rule__Wildcard__Group__0
            {
            pushFollow(FOLLOW_rule__Wildcard__Group__0_in_ruleWildcard2134);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1000:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1000:25: ( ruleCharacterRange EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1001:1: ruleCharacterRange EOF
            {
             before(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2160);
            ruleCharacterRange();
            _fsp--;

             after(grammarAccess.getCharacterRangeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange2167); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1008:1: ruleCharacterRange : ( ( rule__CharacterRange__Group__0 ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1012:2: ( ( ( rule__CharacterRange__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1013:1: ( ( rule__CharacterRange__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1013:1: ( ( rule__CharacterRange__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1014:1: ( rule__CharacterRange__Group__0 )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1015:1: ( rule__CharacterRange__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1015:2: rule__CharacterRange__Group__0
            {
            pushFollow(FOLLOW_rule__CharacterRange__Group__0_in_ruleCharacterRange2194);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1027:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1027:19: ( ruleEnumRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1028:1: ruleEnumRule EOF
            {
             before(grammarAccess.getEnumRuleRule()); 
            pushFollow(FOLLOW_ruleEnumRule_in_entryRuleEnumRule2220);
            ruleEnumRule();
            _fsp--;

             after(grammarAccess.getEnumRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumRule2227); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1035:1: ruleEnumRule : ( ( rule__EnumRule__Group__0 ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1039:2: ( ( ( rule__EnumRule__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1040:1: ( ( rule__EnumRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1040:1: ( ( rule__EnumRule__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1041:1: ( rule__EnumRule__Group__0 )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1042:1: ( rule__EnumRule__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1042:2: rule__EnumRule__Group__0
            {
            pushFollow(FOLLOW_rule__EnumRule__Group__0_in_ruleEnumRule2254);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1054:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1054:23: ( ruleEnumLiterals EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1055:1: ruleEnumLiterals EOF
            {
             before(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2280);
            ruleEnumLiterals();
            _fsp--;

             after(grammarAccess.getEnumLiteralsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumLiterals2287); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1062:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group__0 ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1066:2: ( ( ( rule__EnumLiterals__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1067:1: ( ( rule__EnumLiterals__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1067:1: ( ( rule__EnumLiterals__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1068:1: ( rule__EnumLiterals__Group__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1069:1: ( rule__EnumLiterals__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1069:2: rule__EnumLiterals__Group__0
            {
            pushFollow(FOLLOW_rule__EnumLiterals__Group__0_in_ruleEnumLiterals2314);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1081:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1081:33: ( ruleEnumLiteralDeclaration EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1082:1: ruleEnumLiteralDeclaration EOF
            {
             before(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2340);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration2347); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1089:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group__0 ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1093:2: ( ( ( rule__EnumLiteralDeclaration__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1094:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1094:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1095:1: ( rule__EnumLiteralDeclaration__Group__0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1096:1: ( rule__EnumLiteralDeclaration__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1096:2: rule__EnumLiteralDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__EnumLiteralDeclaration__Group__0_in_ruleEnumLiteralDeclaration2374);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1108:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1112:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
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
                    new NoViableAltException("1108:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1113:1: ( ruleParserRule )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1113:1: ( ruleParserRule )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1114:1: ruleParserRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleParserRule_in_rule__AbstractRule__Alternatives2410);
                    ruleParserRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1119:6: ( ruleTerminalRule )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1119:6: ( ruleTerminalRule )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1120:1: ruleTerminalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTerminalRule_in_rule__AbstractRule__Alternatives2427);
                    ruleTerminalRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1125:6: ( ruleEnumRule )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1125:6: ( ruleEnumRule )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1126:1: ruleEnumRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleEnumRule_in_rule__AbstractRule__Alternatives2444);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1136:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1140:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
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
                    new NoViableAltException("1136:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1141:1: ( ruleGeneratedMetamodel )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1141:1: ( ruleGeneratedMetamodel )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1142:1: ruleGeneratedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2476);
                    ruleGeneratedMetamodel();
                    _fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1147:6: ( ruleReferencedMetamodel )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1147:6: ( ruleReferencedMetamodel )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1148:1: ruleReferencedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2493);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1158:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1162:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) )
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
                    new NoViableAltException("1158:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1163:1: ( ruleAbstractTokenWithCardinality )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1163:1: ( ruleAbstractTokenWithCardinality )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1164:1: ruleAbstractTokenWithCardinality
                    {
                     before(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleAbstractTokenWithCardinality_in_rule__AbstractToken__Alternatives2525);
                    ruleAbstractTokenWithCardinality();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1169:6: ( ruleAction )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1169:6: ( ruleAction )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1170:1: ruleAction
                    {
                     before(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleAction_in_rule__AbstractToken__Alternatives2542);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1180:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1184:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
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
                        new NoViableAltException("1180:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==RULE_STRING||LA4_0==20) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1180:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1185:1: ( ruleAssignment )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1185:1: ( ruleAssignment )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1186:1: ruleAssignment
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_ruleAssignment_in_rule__AbstractTokenWithCardinality__Alternatives_02574);
                    ruleAssignment();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1191:6: ( ruleAbstractTerminal )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1191:6: ( ruleAbstractTerminal )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1192:1: ruleAbstractTerminal
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_rule__AbstractTokenWithCardinality__Alternatives_02591);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1202:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1206:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    new NoViableAltException("1202:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1207:1: ( '?' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1207:1: ( '?' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1208:1: '?'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FOLLOW_11_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02624); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1215:6: ( '*' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1215:6: ( '*' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1216:1: '*'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FOLLOW_12_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02644); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1223:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1223:6: ( '+' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1224:1: '+'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FOLLOW_13_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02664); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1236:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1240:1: ( ( '=' ) | ( '+=' ) )
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
                    new NoViableAltException("1236:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1241:1: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1241:1: ( '=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1242:1: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__Action__OperatorAlternatives_2_2_02699); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1249:6: ( '+=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1249:6: ( '+=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1250:1: '+='
                    {
                     before(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__Action__OperatorAlternatives_2_2_02719); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1262:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1266:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) )
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
                    new NoViableAltException("1262:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1267:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1267:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1268:1: ruleKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleKeyword_in_rule__AbstractTerminal__Alternatives2753);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1273:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1273:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1274:1: ruleRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRuleCall_in_rule__AbstractTerminal__Alternatives2770);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1279:6: ( ruleParenthesizedElement )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1279:6: ( ruleParenthesizedElement )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1280:1: ruleParenthesizedElement
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_rule__AbstractTerminal__Alternatives2787);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1290:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1294:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
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
                    new NoViableAltException("1290:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1295:1: ( '+=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1295:1: ( '+=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1296:1: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__Assignment__OperatorAlternatives_1_02820); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1303:6: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1303:6: ( '=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1304:1: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 
                    match(input,14,FOLLOW_14_in_rule__Assignment__OperatorAlternatives_1_02840); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1311:6: ( '?=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1311:6: ( '?=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1312:1: '?='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2()); 
                    match(input,16,FOLLOW_16_in_rule__Assignment__OperatorAlternatives_1_02860); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1324:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1328:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
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
                    new NoViableAltException("1324:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1329:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1329:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1330:1: ruleKeyword
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleKeyword_in_rule__AssignableTerminal__Alternatives2894);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1335:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1335:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1336:1: ruleRuleCall
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRuleCall_in_rule__AssignableTerminal__Alternatives2911);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1341:6: ( ruleParenthesizedAssignableElement )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1341:6: ( ruleParenthesizedAssignableElement )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1342:1: ruleParenthesizedAssignableElement
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleParenthesizedAssignableElement_in_rule__AssignableTerminal__Alternatives2928);
                    ruleParenthesizedAssignableElement();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1347:6: ( ruleCrossReference )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1347:6: ( ruleCrossReference )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1348:1: ruleCrossReference
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleCrossReference_in_rule__AssignableTerminal__Alternatives2945);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1358:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1362:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) )
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
                    new NoViableAltException("1358:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1363:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1363:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1364:1: ruleKeyword
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleKeyword_in_rule__CrossReferenceableTerminal__Alternatives2977);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1369:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1369:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1370:1: ruleRuleCall
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRuleCall_in_rule__CrossReferenceableTerminal__Alternatives2994);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1375:6: ( ruleParenthesizedCrossReferenceableElement )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1375:6: ( ruleParenthesizedCrossReferenceableElement )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1376:1: ruleParenthesizedCrossReferenceableElement
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getParenthesizedCrossReferenceableElementParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleParenthesizedCrossReferenceableElement_in_rule__CrossReferenceableTerminal__Alternatives3011);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1386:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__TerminalToken__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1390:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    new NoViableAltException("1386:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1391:1: ( '?' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1391:1: ( '?' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1392:1: '?'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_03044); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1399:6: ( '*' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1399:6: ( '*' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1400:1: '*'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_03064); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1407:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1407:6: ( '+' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1408:1: '+'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_03084); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1420:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1424:1: ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) )
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
                    new NoViableAltException("1420:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1425:1: ( ruleCharacterRange )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1425:1: ( ruleCharacterRange )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1426:1: ruleCharacterRange
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3118);
                    ruleCharacterRange();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1431:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1431:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1432:1: ruleRuleCall
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3135);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1437:6: ( ruleParenthesizedTerminalElement )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1437:6: ( ruleParenthesizedTerminalElement )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1438:1: ruleParenthesizedTerminalElement
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3152);
                    ruleParenthesizedTerminalElement();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1443:6: ( ruleAbstractNegatedToken )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1443:6: ( ruleAbstractNegatedToken )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1444:1: ruleAbstractNegatedToken
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3169);
                    ruleAbstractNegatedToken();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1449:6: ( ruleWildcard )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1449:6: ( ruleWildcard )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1450:1: ruleWildcard
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3186);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1460:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1464:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
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
                    new NoViableAltException("1460:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1465:1: ( ruleNegatedToken )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1465:1: ( ruleNegatedToken )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1466:1: ruleNegatedToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3218);
                    ruleNegatedToken();
                    _fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1471:6: ( ruleUntilToken )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1471:6: ( ruleUntilToken )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1472:1: ruleUntilToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3235);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1484:1: rule__Grammar__Group__0 : ( 'grammar' ) rule__Grammar__Group__1 ;
    public final void rule__Grammar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1488:1: ( ( 'grammar' ) rule__Grammar__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1489:1: ( 'grammar' ) rule__Grammar__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1489:1: ( 'grammar' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1490:1: 'grammar'
            {
             before(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__Grammar__Group__03270); 
             after(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Grammar__Group__1_in_rule__Grammar__Group__03280);
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


    // $ANTLR start rule__Grammar__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1504:1: rule__Grammar__Group__1 : ( ( rule__Grammar__NameAssignment_1 ) ) rule__Grammar__Group__2 ;
    public final void rule__Grammar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1508:1: ( ( ( rule__Grammar__NameAssignment_1 ) ) rule__Grammar__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1509:1: ( ( rule__Grammar__NameAssignment_1 ) ) rule__Grammar__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1509:1: ( ( rule__Grammar__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1510:1: ( rule__Grammar__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1511:1: ( rule__Grammar__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1511:2: rule__Grammar__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Grammar__NameAssignment_1_in_rule__Grammar__Group__13308);
            rule__Grammar__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Grammar__Group__2_in_rule__Grammar__Group__13317);
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


    // $ANTLR start rule__Grammar__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1522:1: rule__Grammar__Group__2 : ( ( rule__Grammar__Group_2__0 )? ) rule__Grammar__Group__3 ;
    public final void rule__Grammar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1526:1: ( ( ( rule__Grammar__Group_2__0 )? ) rule__Grammar__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1527:1: ( ( rule__Grammar__Group_2__0 )? ) rule__Grammar__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1527:1: ( ( rule__Grammar__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1528:1: ( rule__Grammar__Group_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1529:1: ( rule__Grammar__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1529:2: rule__Grammar__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Grammar__Group_2__0_in_rule__Grammar__Group__23345);
                    rule__Grammar__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__Grammar__Group__3_in_rule__Grammar__Group__23355);
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


    // $ANTLR start rule__Grammar__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1540:1: rule__Grammar__Group__3 : ( ( rule__Grammar__Group_3__0 )? ) rule__Grammar__Group__4 ;
    public final void rule__Grammar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1544:1: ( ( ( rule__Grammar__Group_3__0 )? ) rule__Grammar__Group__4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1545:1: ( ( rule__Grammar__Group_3__0 )? ) rule__Grammar__Group__4
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1545:1: ( ( rule__Grammar__Group_3__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1546:1: ( rule__Grammar__Group_3__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1547:1: ( rule__Grammar__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==41) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1547:2: rule__Grammar__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Grammar__Group_3__0_in_rule__Grammar__Group__33383);
                    rule__Grammar__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_3()); 

            }

            pushFollow(FOLLOW_rule__Grammar__Group__4_in_rule__Grammar__Group__33393);
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


    // $ANTLR start rule__Grammar__Group__4
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1558:1: rule__Grammar__Group__4 : ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) rule__Grammar__Group__5 ;
    public final void rule__Grammar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1562:1: ( ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) rule__Grammar__Group__5 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1563:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) rule__Grammar__Group__5
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1563:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1564:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1565:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23||LA16_0==25) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1565:2: rule__Grammar__MetamodelDeclarationsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Grammar__MetamodelDeclarationsAssignment_4_in_rule__Grammar__Group__43421);
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

            pushFollow(FOLLOW_rule__Grammar__Group__5_in_rule__Grammar__Group__43431);
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


    // $ANTLR start rule__Grammar__Group__5
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1576:1: rule__Grammar__Group__5 : ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) ;
    public final void rule__Grammar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1580:1: ( ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1581:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1581:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1582:1: ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1582:1: ( ( rule__Grammar__RulesAssignment_5 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1583:1: ( rule__Grammar__RulesAssignment_5 )
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1584:1: ( rule__Grammar__RulesAssignment_5 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1584:2: rule__Grammar__RulesAssignment_5
            {
            pushFollow(FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__53461);
            rule__Grammar__RulesAssignment_5();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1587:1: ( ( rule__Grammar__RulesAssignment_5 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1588:1: ( rule__Grammar__RulesAssignment_5 )*
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1589:1: ( rule__Grammar__RulesAssignment_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID||LA17_0==36||LA17_0==40) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1589:2: rule__Grammar__RulesAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__53473);
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
    // $ANTLR end rule__Grammar__Group__5


    // $ANTLR start rule__Grammar__Group_2__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1612:1: rule__Grammar__Group_2__0 : ( 'with' ) rule__Grammar__Group_2__1 ;
    public final void rule__Grammar__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1616:1: ( ( 'with' ) rule__Grammar__Group_2__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1617:1: ( 'with' ) rule__Grammar__Group_2__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1617:1: ( 'with' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1618:1: 'with'
            {
             before(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__Grammar__Group_2__03523); 
             after(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__Grammar__Group_2__1_in_rule__Grammar__Group_2__03533);
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


    // $ANTLR start rule__Grammar__Group_2__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1632:1: rule__Grammar__Group_2__1 : ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) rule__Grammar__Group_2__2 ;
    public final void rule__Grammar__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1636:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) rule__Grammar__Group_2__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1637:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) rule__Grammar__Group_2__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1637:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1638:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1639:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1639:2: rule__Grammar__UsedGrammarsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_1_in_rule__Grammar__Group_2__13561);
            rule__Grammar__UsedGrammarsAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 

            }

            pushFollow(FOLLOW_rule__Grammar__Group_2__2_in_rule__Grammar__Group_2__13570);
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


    // $ANTLR start rule__Grammar__Group_2__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1650:1: rule__Grammar__Group_2__2 : ( ( rule__Grammar__Group_2_2__0 )* ) ;
    public final void rule__Grammar__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1654:1: ( ( ( rule__Grammar__Group_2_2__0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1655:1: ( ( rule__Grammar__Group_2_2__0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1655:1: ( ( rule__Grammar__Group_2_2__0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1656:1: ( rule__Grammar__Group_2_2__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1657:1: ( rule__Grammar__Group_2_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1657:2: rule__Grammar__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Grammar__Group_2_2__0_in_rule__Grammar__Group_2__23598);
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
    // $ANTLR end rule__Grammar__Group_2__2


    // $ANTLR start rule__Grammar__Group_2_2__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1673:1: rule__Grammar__Group_2_2__0 : ( ',' ) rule__Grammar__Group_2_2__1 ;
    public final void rule__Grammar__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1677:1: ( ( ',' ) rule__Grammar__Group_2_2__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1678:1: ( ',' ) rule__Grammar__Group_2_2__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1678:1: ( ',' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1679:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 
            match(input,19,FOLLOW_19_in_rule__Grammar__Group_2_2__03640); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 

            }

            pushFollow(FOLLOW_rule__Grammar__Group_2_2__1_in_rule__Grammar__Group_2_2__03650);
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


    // $ANTLR start rule__Grammar__Group_2_2__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1693:1: rule__Grammar__Group_2_2__1 : ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) ;
    public final void rule__Grammar__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1697:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1698:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1698:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1699:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1700:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1700:2: rule__Grammar__UsedGrammarsAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_2_1_in_rule__Grammar__Group_2_2__13678);
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
    // $ANTLR end rule__Grammar__Group_2_2__1


    // $ANTLR start rule__Grammar__Group_3__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1714:1: rule__Grammar__Group_3__0 : ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) rule__Grammar__Group_3__1 ;
    public final void rule__Grammar__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1718:1: ( ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) rule__Grammar__Group_3__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1719:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) rule__Grammar__Group_3__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1719:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1720:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1721:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1721:2: rule__Grammar__DefinesHiddenTokensAssignment_3_0
            {
            pushFollow(FOLLOW_rule__Grammar__DefinesHiddenTokensAssignment_3_0_in_rule__Grammar__Group_3__03716);
            rule__Grammar__DefinesHiddenTokensAssignment_3_0();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 

            }

            pushFollow(FOLLOW_rule__Grammar__Group_3__1_in_rule__Grammar__Group_3__03725);
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


    // $ANTLR start rule__Grammar__Group_3__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1732:1: rule__Grammar__Group_3__1 : ( '(' ) rule__Grammar__Group_3__2 ;
    public final void rule__Grammar__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1736:1: ( ( '(' ) rule__Grammar__Group_3__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1737:1: ( '(' ) rule__Grammar__Group_3__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1737:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1738:1: '('
            {
             before(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,20,FOLLOW_20_in_rule__Grammar__Group_3__13754); 
             after(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 

            }

            pushFollow(FOLLOW_rule__Grammar__Group_3__2_in_rule__Grammar__Group_3__13764);
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


    // $ANTLR start rule__Grammar__Group_3__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1752:1: rule__Grammar__Group_3__2 : ( ( rule__Grammar__Group_3_2__0 )? ) rule__Grammar__Group_3__3 ;
    public final void rule__Grammar__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1756:1: ( ( ( rule__Grammar__Group_3_2__0 )? ) rule__Grammar__Group_3__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1757:1: ( ( rule__Grammar__Group_3_2__0 )? ) rule__Grammar__Group_3__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1757:1: ( ( rule__Grammar__Group_3_2__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1758:1: ( rule__Grammar__Group_3_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1759:1: ( rule__Grammar__Group_3_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1759:2: rule__Grammar__Group_3_2__0
                    {
                    pushFollow(FOLLOW_rule__Grammar__Group_3_2__0_in_rule__Grammar__Group_3__23792);
                    rule__Grammar__Group_3_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_3_2()); 

            }

            pushFollow(FOLLOW_rule__Grammar__Group_3__3_in_rule__Grammar__Group_3__23802);
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


    // $ANTLR start rule__Grammar__Group_3__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1770:1: rule__Grammar__Group_3__3 : ( ')' ) ;
    public final void rule__Grammar__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1774:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1775:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1775:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1776:1: ')'
            {
             before(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); 
            match(input,21,FOLLOW_21_in_rule__Grammar__Group_3__33831); 
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
    // $ANTLR end rule__Grammar__Group_3__3


    // $ANTLR start rule__Grammar__Group_3_2__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1797:1: rule__Grammar__Group_3_2__0 : ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) rule__Grammar__Group_3_2__1 ;
    public final void rule__Grammar__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1801:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) rule__Grammar__Group_3_2__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1802:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) rule__Grammar__Group_3_2__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1802:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1803:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1804:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1804:2: rule__Grammar__HiddenTokensAssignment_3_2_0
            {
            pushFollow(FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_0_in_rule__Grammar__Group_3_2__03874);
            rule__Grammar__HiddenTokensAssignment_3_2_0();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 

            }

            pushFollow(FOLLOW_rule__Grammar__Group_3_2__1_in_rule__Grammar__Group_3_2__03883);
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


    // $ANTLR start rule__Grammar__Group_3_2__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1815:1: rule__Grammar__Group_3_2__1 : ( ( rule__Grammar__Group_3_2_1__0 )* ) ;
    public final void rule__Grammar__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1819:1: ( ( ( rule__Grammar__Group_3_2_1__0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1820:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1820:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1821:1: ( rule__Grammar__Group_3_2_1__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1822:1: ( rule__Grammar__Group_3_2_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==19) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1822:2: rule__Grammar__Group_3_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Grammar__Group_3_2_1__0_in_rule__Grammar__Group_3_2__13911);
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
    // $ANTLR end rule__Grammar__Group_3_2__1


    // $ANTLR start rule__Grammar__Group_3_2_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1836:1: rule__Grammar__Group_3_2_1__0 : ( ',' ) rule__Grammar__Group_3_2_1__1 ;
    public final void rule__Grammar__Group_3_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1840:1: ( ( ',' ) rule__Grammar__Group_3_2_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1841:1: ( ',' ) rule__Grammar__Group_3_2_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1841:1: ( ',' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1842:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 
            match(input,19,FOLLOW_19_in_rule__Grammar__Group_3_2_1__03951); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 

            }

            pushFollow(FOLLOW_rule__Grammar__Group_3_2_1__1_in_rule__Grammar__Group_3_2_1__03961);
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


    // $ANTLR start rule__Grammar__Group_3_2_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1856:1: rule__Grammar__Group_3_2_1__1 : ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) ;
    public final void rule__Grammar__Group_3_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1860:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1861:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1861:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1862:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1863:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1863:2: rule__Grammar__HiddenTokensAssignment_3_2_1_1
            {
            pushFollow(FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_1_1_in_rule__Grammar__Group_3_2_1__13989);
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
    // $ANTLR end rule__Grammar__Group_3_2_1__1


    // $ANTLR start rule__GrammarID__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1877:1: rule__GrammarID__Group__0 : ( RULE_ID ) rule__GrammarID__Group__1 ;
    public final void rule__GrammarID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1881:1: ( ( RULE_ID ) rule__GrammarID__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1882:1: ( RULE_ID ) rule__GrammarID__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1882:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1883:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GrammarID__Group__04027); 
             after(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__GrammarID__Group__1_in_rule__GrammarID__Group__04035);
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


    // $ANTLR start rule__GrammarID__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1895:1: rule__GrammarID__Group__1 : ( ( rule__GrammarID__Group_1__0 )* ) ;
    public final void rule__GrammarID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1899:1: ( ( ( rule__GrammarID__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1900:1: ( ( rule__GrammarID__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1900:1: ( ( rule__GrammarID__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1901:1: ( rule__GrammarID__Group_1__0 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1902:1: ( rule__GrammarID__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1902:2: rule__GrammarID__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__GrammarID__Group_1__0_in_rule__GrammarID__Group__14063);
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
    // $ANTLR end rule__GrammarID__Group__1


    // $ANTLR start rule__GrammarID__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1916:1: rule__GrammarID__Group_1__0 : ( '.' ) rule__GrammarID__Group_1__1 ;
    public final void rule__GrammarID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1920:1: ( ( '.' ) rule__GrammarID__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1921:1: ( '.' ) rule__GrammarID__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1921:1: ( '.' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1922:1: '.'
            {
             before(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 
            match(input,22,FOLLOW_22_in_rule__GrammarID__Group_1__04103); 
             after(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__GrammarID__Group_1__1_in_rule__GrammarID__Group_1__04113);
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


    // $ANTLR start rule__GrammarID__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1936:1: rule__GrammarID__Group_1__1 : ( RULE_ID ) ;
    public final void rule__GrammarID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1940:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1941:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1941:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1942:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GrammarID__Group_1__14141); 
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
    // $ANTLR end rule__GrammarID__Group_1__1


    // $ANTLR start rule__GeneratedMetamodel__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1957:1: rule__GeneratedMetamodel__Group__0 : ( 'generate' ) rule__GeneratedMetamodel__Group__1 ;
    public final void rule__GeneratedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1961:1: ( ( 'generate' ) rule__GeneratedMetamodel__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1962:1: ( 'generate' ) rule__GeneratedMetamodel__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1962:1: ( 'generate' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1963:1: 'generate'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__GeneratedMetamodel__Group__04179); 
             after(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__GeneratedMetamodel__Group__1_in_rule__GeneratedMetamodel__Group__04189);
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


    // $ANTLR start rule__GeneratedMetamodel__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1977:1: rule__GeneratedMetamodel__Group__1 : ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) rule__GeneratedMetamodel__Group__2 ;
    public final void rule__GeneratedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1981:1: ( ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) rule__GeneratedMetamodel__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1982:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) rule__GeneratedMetamodel__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1982:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1983:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1984:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1984:2: rule__GeneratedMetamodel__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__GeneratedMetamodel__NameAssignment_1_in_rule__GeneratedMetamodel__Group__14217);
            rule__GeneratedMetamodel__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__GeneratedMetamodel__Group__2_in_rule__GeneratedMetamodel__Group__14226);
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


    // $ANTLR start rule__GeneratedMetamodel__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1995:1: rule__GeneratedMetamodel__Group__2 : ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) rule__GeneratedMetamodel__Group__3 ;
    public final void rule__GeneratedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:1999:1: ( ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) rule__GeneratedMetamodel__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2000:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) rule__GeneratedMetamodel__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2000:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2001:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2002:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2002:2: rule__GeneratedMetamodel__EPackageAssignment_2
            {
            pushFollow(FOLLOW_rule__GeneratedMetamodel__EPackageAssignment_2_in_rule__GeneratedMetamodel__Group__24254);
            rule__GeneratedMetamodel__EPackageAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__GeneratedMetamodel__Group__3_in_rule__GeneratedMetamodel__Group__24263);
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


    // $ANTLR start rule__GeneratedMetamodel__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2013:1: rule__GeneratedMetamodel__Group__3 : ( ( rule__GeneratedMetamodel__Group_3__0 )? ) ;
    public final void rule__GeneratedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2017:1: ( ( ( rule__GeneratedMetamodel__Group_3__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2018:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2018:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2019:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2020:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2020:2: rule__GeneratedMetamodel__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__GeneratedMetamodel__Group_3__0_in_rule__GeneratedMetamodel__Group__34291);
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
    // $ANTLR end rule__GeneratedMetamodel__Group__3


    // $ANTLR start rule__GeneratedMetamodel__Group_3__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2038:1: rule__GeneratedMetamodel__Group_3__0 : ( 'as' ) rule__GeneratedMetamodel__Group_3__1 ;
    public final void rule__GeneratedMetamodel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2042:1: ( ( 'as' ) rule__GeneratedMetamodel__Group_3__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2043:1: ( 'as' ) rule__GeneratedMetamodel__Group_3__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2043:1: ( 'as' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2044:1: 'as'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 
            match(input,24,FOLLOW_24_in_rule__GeneratedMetamodel__Group_3__04335); 
             after(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 

            }

            pushFollow(FOLLOW_rule__GeneratedMetamodel__Group_3__1_in_rule__GeneratedMetamodel__Group_3__04345);
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


    // $ANTLR start rule__GeneratedMetamodel__Group_3__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2058:1: rule__GeneratedMetamodel__Group_3__1 : ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2062:1: ( ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2063:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2063:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2064:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2065:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2065:2: rule__GeneratedMetamodel__AliasAssignment_3_1
            {
            pushFollow(FOLLOW_rule__GeneratedMetamodel__AliasAssignment_3_1_in_rule__GeneratedMetamodel__Group_3__14373);
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
    // $ANTLR end rule__GeneratedMetamodel__Group_3__1


    // $ANTLR start rule__ReferencedMetamodel__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2079:1: rule__ReferencedMetamodel__Group__0 : ( 'import' ) rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2083:1: ( ( 'import' ) rule__ReferencedMetamodel__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2084:1: ( 'import' ) rule__ReferencedMetamodel__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2084:1: ( 'import' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2085:1: 'import'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__ReferencedMetamodel__Group__04412); 
             after(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__04422);
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


    // $ANTLR start rule__ReferencedMetamodel__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2099:1: rule__ReferencedMetamodel__Group__1 : ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2103:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) rule__ReferencedMetamodel__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2104:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) rule__ReferencedMetamodel__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2104:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2105:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2106:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2106:2: rule__ReferencedMetamodel__EPackageAssignment_1
            {
            pushFollow(FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_1_in_rule__ReferencedMetamodel__Group__14450);
            rule__ReferencedMetamodel__EPackageAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__14459);
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


    // $ANTLR start rule__ReferencedMetamodel__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2117:1: rule__ReferencedMetamodel__Group__2 : ( ( rule__ReferencedMetamodel__Group_2__0 )? ) ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2121:1: ( ( ( rule__ReferencedMetamodel__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2122:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2122:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2123:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2124:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==24) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2124:2: rule__ReferencedMetamodel__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ReferencedMetamodel__Group_2__0_in_rule__ReferencedMetamodel__Group__24487);
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
    // $ANTLR end rule__ReferencedMetamodel__Group__2


    // $ANTLR start rule__ReferencedMetamodel__Group_2__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2140:1: rule__ReferencedMetamodel__Group_2__0 : ( 'as' ) rule__ReferencedMetamodel__Group_2__1 ;
    public final void rule__ReferencedMetamodel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2144:1: ( ( 'as' ) rule__ReferencedMetamodel__Group_2__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2145:1: ( 'as' ) rule__ReferencedMetamodel__Group_2__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2145:1: ( 'as' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2146:1: 'as'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 
            match(input,24,FOLLOW_24_in_rule__ReferencedMetamodel__Group_2__04529); 
             after(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__ReferencedMetamodel__Group_2__1_in_rule__ReferencedMetamodel__Group_2__04539);
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


    // $ANTLR start rule__ReferencedMetamodel__Group_2__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2160:1: rule__ReferencedMetamodel__Group_2__1 : ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2164:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2165:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2165:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2166:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2167:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2167:2: rule__ReferencedMetamodel__AliasAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ReferencedMetamodel__AliasAssignment_2_1_in_rule__ReferencedMetamodel__Group_2__14567);
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
    // $ANTLR end rule__ReferencedMetamodel__Group_2__1


    // $ANTLR start rule__ParserRule__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2181:1: rule__ParserRule__Group__0 : ( ( rule__ParserRule__NameAssignment_0 ) ) rule__ParserRule__Group__1 ;
    public final void rule__ParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2185:1: ( ( ( rule__ParserRule__NameAssignment_0 ) ) rule__ParserRule__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2186:1: ( ( rule__ParserRule__NameAssignment_0 ) ) rule__ParserRule__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2186:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2187:1: ( rule__ParserRule__NameAssignment_0 )
            {
             before(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2188:1: ( rule__ParserRule__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2188:2: rule__ParserRule__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ParserRule__NameAssignment_0_in_rule__ParserRule__Group__04605);
            rule__ParserRule__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__ParserRule__Group__1_in_rule__ParserRule__Group__04614);
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


    // $ANTLR start rule__ParserRule__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2199:1: rule__ParserRule__Group__1 : ( ( rule__ParserRule__Group_1__0 )? ) rule__ParserRule__Group__2 ;
    public final void rule__ParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2203:1: ( ( ( rule__ParserRule__Group_1__0 )? ) rule__ParserRule__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2204:1: ( ( rule__ParserRule__Group_1__0 )? ) rule__ParserRule__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2204:1: ( ( rule__ParserRule__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2205:1: ( rule__ParserRule__Group_1__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2206:1: ( rule__ParserRule__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==28) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2206:2: rule__ParserRule__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ParserRule__Group_1__0_in_rule__ParserRule__Group__14642);
                    rule__ParserRule__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_1()); 

            }

            pushFollow(FOLLOW_rule__ParserRule__Group__2_in_rule__ParserRule__Group__14652);
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


    // $ANTLR start rule__ParserRule__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2217:1: rule__ParserRule__Group__2 : ( ( rule__ParserRule__Group_2__0 )? ) rule__ParserRule__Group__3 ;
    public final void rule__ParserRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2221:1: ( ( ( rule__ParserRule__Group_2__0 )? ) rule__ParserRule__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2222:1: ( ( rule__ParserRule__Group_2__0 )? ) rule__ParserRule__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2222:1: ( ( rule__ParserRule__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2223:1: ( rule__ParserRule__Group_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2224:1: ( rule__ParserRule__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==41) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2224:2: rule__ParserRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ParserRule__Group_2__0_in_rule__ParserRule__Group__24680);
                    rule__ParserRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__ParserRule__Group__3_in_rule__ParserRule__Group__24690);
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


    // $ANTLR start rule__ParserRule__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2235:1: rule__ParserRule__Group__3 : ( ':' ) rule__ParserRule__Group__4 ;
    public final void rule__ParserRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2239:1: ( ( ':' ) rule__ParserRule__Group__4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2240:1: ( ':' ) rule__ParserRule__Group__4
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2240:1: ( ':' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2241:1: ':'
            {
             before(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 
            match(input,26,FOLLOW_26_in_rule__ParserRule__Group__34719); 
             after(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__ParserRule__Group__4_in_rule__ParserRule__Group__34729);
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


    // $ANTLR start rule__ParserRule__Group__4
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2255:1: rule__ParserRule__Group__4 : ( ( rule__ParserRule__AlternativesAssignment_4 ) ) rule__ParserRule__Group__5 ;
    public final void rule__ParserRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2259:1: ( ( ( rule__ParserRule__AlternativesAssignment_4 ) ) rule__ParserRule__Group__5 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2260:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) ) rule__ParserRule__Group__5
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2260:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2261:1: ( rule__ParserRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2262:1: ( rule__ParserRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2262:2: rule__ParserRule__AlternativesAssignment_4
            {
            pushFollow(FOLLOW_rule__ParserRule__AlternativesAssignment_4_in_rule__ParserRule__Group__44757);
            rule__ParserRule__AlternativesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__ParserRule__Group__5_in_rule__ParserRule__Group__44766);
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


    // $ANTLR start rule__ParserRule__Group__5
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2273:1: rule__ParserRule__Group__5 : ( ';' ) ;
    public final void rule__ParserRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2277:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2278:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2278:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2279:1: ';'
            {
             before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FOLLOW_27_in_rule__ParserRule__Group__54795); 
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
    // $ANTLR end rule__ParserRule__Group__5


    // $ANTLR start rule__ParserRule__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2304:1: rule__ParserRule__Group_1__0 : ( 'returns' ) rule__ParserRule__Group_1__1 ;
    public final void rule__ParserRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2308:1: ( ( 'returns' ) rule__ParserRule__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2309:1: ( 'returns' ) rule__ParserRule__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2309:1: ( 'returns' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2310:1: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 
            match(input,28,FOLLOW_28_in_rule__ParserRule__Group_1__04843); 
             after(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__ParserRule__Group_1__1_in_rule__ParserRule__Group_1__04853);
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


    // $ANTLR start rule__ParserRule__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2324:1: rule__ParserRule__Group_1__1 : ( ( rule__ParserRule__TypeAssignment_1_1 ) ) ;
    public final void rule__ParserRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2328:1: ( ( ( rule__ParserRule__TypeAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2329:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2329:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2330:1: ( rule__ParserRule__TypeAssignment_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2331:1: ( rule__ParserRule__TypeAssignment_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2331:2: rule__ParserRule__TypeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ParserRule__TypeAssignment_1_1_in_rule__ParserRule__Group_1__14881);
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
    // $ANTLR end rule__ParserRule__Group_1__1


    // $ANTLR start rule__ParserRule__Group_2__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2345:1: rule__ParserRule__Group_2__0 : ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) rule__ParserRule__Group_2__1 ;
    public final void rule__ParserRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2349:1: ( ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) rule__ParserRule__Group_2__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2350:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) rule__ParserRule__Group_2__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2350:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2351:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2352:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2352:2: rule__ParserRule__DefinesHiddenTokensAssignment_2_0
            {
            pushFollow(FOLLOW_rule__ParserRule__DefinesHiddenTokensAssignment_2_0_in_rule__ParserRule__Group_2__04919);
            rule__ParserRule__DefinesHiddenTokensAssignment_2_0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 

            }

            pushFollow(FOLLOW_rule__ParserRule__Group_2__1_in_rule__ParserRule__Group_2__04928);
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


    // $ANTLR start rule__ParserRule__Group_2__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2363:1: rule__ParserRule__Group_2__1 : ( '(' ) rule__ParserRule__Group_2__2 ;
    public final void rule__ParserRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2367:1: ( ( '(' ) rule__ParserRule__Group_2__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2368:1: ( '(' ) rule__ParserRule__Group_2__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2368:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2369:1: '('
            {
             before(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 
            match(input,20,FOLLOW_20_in_rule__ParserRule__Group_2__14957); 
             after(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 

            }

            pushFollow(FOLLOW_rule__ParserRule__Group_2__2_in_rule__ParserRule__Group_2__14967);
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


    // $ANTLR start rule__ParserRule__Group_2__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2383:1: rule__ParserRule__Group_2__2 : ( ( rule__ParserRule__Group_2_2__0 )? ) rule__ParserRule__Group_2__3 ;
    public final void rule__ParserRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2387:1: ( ( ( rule__ParserRule__Group_2_2__0 )? ) rule__ParserRule__Group_2__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2388:1: ( ( rule__ParserRule__Group_2_2__0 )? ) rule__ParserRule__Group_2__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2388:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2389:1: ( rule__ParserRule__Group_2_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2390:1: ( rule__ParserRule__Group_2_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2390:2: rule__ParserRule__Group_2_2__0
                    {
                    pushFollow(FOLLOW_rule__ParserRule__Group_2_2__0_in_rule__ParserRule__Group_2__24995);
                    rule__ParserRule__Group_2_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_2_2()); 

            }

            pushFollow(FOLLOW_rule__ParserRule__Group_2__3_in_rule__ParserRule__Group_2__25005);
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


    // $ANTLR start rule__ParserRule__Group_2__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2401:1: rule__ParserRule__Group_2__3 : ( ')' ) ;
    public final void rule__ParserRule__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2405:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2406:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2406:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2407:1: ')'
            {
             before(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); 
            match(input,21,FOLLOW_21_in_rule__ParserRule__Group_2__35034); 
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
    // $ANTLR end rule__ParserRule__Group_2__3


    // $ANTLR start rule__ParserRule__Group_2_2__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2428:1: rule__ParserRule__Group_2_2__0 : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) rule__ParserRule__Group_2_2__1 ;
    public final void rule__ParserRule__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2432:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) rule__ParserRule__Group_2_2__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2433:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) rule__ParserRule__Group_2_2__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2433:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2434:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2435:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2435:2: rule__ParserRule__HiddenTokensAssignment_2_2_0
            {
            pushFollow(FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_0_in_rule__ParserRule__Group_2_2__05077);
            rule__ParserRule__HiddenTokensAssignment_2_2_0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 

            }

            pushFollow(FOLLOW_rule__ParserRule__Group_2_2__1_in_rule__ParserRule__Group_2_2__05086);
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


    // $ANTLR start rule__ParserRule__Group_2_2__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2446:1: rule__ParserRule__Group_2_2__1 : ( ( rule__ParserRule__Group_2_2_1__0 )* ) ;
    public final void rule__ParserRule__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2450:1: ( ( ( rule__ParserRule__Group_2_2_1__0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2451:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2451:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2452:1: ( rule__ParserRule__Group_2_2_1__0 )*
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2453:1: ( rule__ParserRule__Group_2_2_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==19) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2453:2: rule__ParserRule__Group_2_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ParserRule__Group_2_2_1__0_in_rule__ParserRule__Group_2_2__15114);
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
    // $ANTLR end rule__ParserRule__Group_2_2__1


    // $ANTLR start rule__ParserRule__Group_2_2_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2467:1: rule__ParserRule__Group_2_2_1__0 : ( ',' ) rule__ParserRule__Group_2_2_1__1 ;
    public final void rule__ParserRule__Group_2_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2471:1: ( ( ',' ) rule__ParserRule__Group_2_2_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2472:1: ( ',' ) rule__ParserRule__Group_2_2_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2472:1: ( ',' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2473:1: ','
            {
             before(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 
            match(input,19,FOLLOW_19_in_rule__ParserRule__Group_2_2_1__05154); 
             after(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 

            }

            pushFollow(FOLLOW_rule__ParserRule__Group_2_2_1__1_in_rule__ParserRule__Group_2_2_1__05164);
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


    // $ANTLR start rule__ParserRule__Group_2_2_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2487:1: rule__ParserRule__Group_2_2_1__1 : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_2_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2491:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2492:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2492:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2493:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2494:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2494:2: rule__ParserRule__HiddenTokensAssignment_2_2_1_1
            {
            pushFollow(FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_1_1_in_rule__ParserRule__Group_2_2_1__15192);
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
    // $ANTLR end rule__ParserRule__Group_2_2_1__1


    // $ANTLR start rule__TypeRef__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2508:1: rule__TypeRef__Group__0 : ( ( rule__TypeRef__Group_0__0 )? ) rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2512:1: ( ( ( rule__TypeRef__Group_0__0 )? ) rule__TypeRef__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2513:1: ( ( rule__TypeRef__Group_0__0 )? ) rule__TypeRef__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2513:1: ( ( rule__TypeRef__Group_0__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2514:1: ( rule__TypeRef__Group_0__0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2515:1: ( rule__TypeRef__Group_0__0 )?
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
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2515:2: rule__TypeRef__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__TypeRef__Group_0__0_in_rule__TypeRef__Group__05230);
                    rule__TypeRef__Group_0__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeRefAccess().getGroup_0()); 

            }

            pushFollow(FOLLOW_rule__TypeRef__Group__1_in_rule__TypeRef__Group__05240);
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


    // $ANTLR start rule__TypeRef__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2526:1: rule__TypeRef__Group__1 : ( ( rule__TypeRef__ClassifierAssignment_1 ) ) ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2530:1: ( ( ( rule__TypeRef__ClassifierAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2531:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2531:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2532:1: ( rule__TypeRef__ClassifierAssignment_1 )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2533:1: ( rule__TypeRef__ClassifierAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2533:2: rule__TypeRef__ClassifierAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeRef__ClassifierAssignment_1_in_rule__TypeRef__Group__15268);
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
    // $ANTLR end rule__TypeRef__Group__1


    // $ANTLR start rule__TypeRef__Group_0__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2547:1: rule__TypeRef__Group_0__0 : ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) rule__TypeRef__Group_0__1 ;
    public final void rule__TypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2551:1: ( ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) rule__TypeRef__Group_0__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2552:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) rule__TypeRef__Group_0__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2552:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2553:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2554:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2554:2: rule__TypeRef__MetamodelAssignment_0_0
            {
            pushFollow(FOLLOW_rule__TypeRef__MetamodelAssignment_0_0_in_rule__TypeRef__Group_0__05306);
            rule__TypeRef__MetamodelAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 

            }

            pushFollow(FOLLOW_rule__TypeRef__Group_0__1_in_rule__TypeRef__Group_0__05315);
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


    // $ANTLR start rule__TypeRef__Group_0__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2565:1: rule__TypeRef__Group_0__1 : ( '::' ) ;
    public final void rule__TypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2569:1: ( ( '::' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2570:1: ( '::' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2570:1: ( '::' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2571:1: '::'
            {
             before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 
            match(input,29,FOLLOW_29_in_rule__TypeRef__Group_0__15344); 
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
    // $ANTLR end rule__TypeRef__Group_0__1


    // $ANTLR start rule__Alternatives__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2588:1: rule__Alternatives__Group__0 : ( ruleGroup ) rule__Alternatives__Group__1 ;
    public final void rule__Alternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2592:1: ( ( ruleGroup ) rule__Alternatives__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2593:1: ( ruleGroup ) rule__Alternatives__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2593:1: ( ruleGroup )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2594:1: ruleGroup
            {
             before(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleGroup_in_rule__Alternatives__Group__05383);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__Alternatives__Group__1_in_rule__Alternatives__Group__05391);
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


    // $ANTLR start rule__Alternatives__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2606:1: rule__Alternatives__Group__1 : ( ( rule__Alternatives__Group_1__0 )? ) ;
    public final void rule__Alternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2610:1: ( ( ( rule__Alternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2611:1: ( ( rule__Alternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2611:1: ( ( rule__Alternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2612:1: ( rule__Alternatives__Group_1__0 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2613:1: ( rule__Alternatives__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==30) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2613:2: rule__Alternatives__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Alternatives__Group_1__0_in_rule__Alternatives__Group__15419);
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
    // $ANTLR end rule__Alternatives__Group__1


    // $ANTLR start rule__Alternatives__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2627:1: rule__Alternatives__Group_1__0 : ( () ) rule__Alternatives__Group_1__1 ;
    public final void rule__Alternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2631:1: ( ( () ) rule__Alternatives__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2632:1: ( () ) rule__Alternatives__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2632:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2633:1: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2634:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2636:1: 
            {
            }

             after(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__Alternatives__Group_1__1_in_rule__Alternatives__Group_1__05468);
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


    // $ANTLR start rule__Alternatives__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2647:1: rule__Alternatives__Group_1__1 : ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) ;
    public final void rule__Alternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2651:1: ( ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2652:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2652:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2653:1: ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2653:1: ( ( rule__Alternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2654:1: ( rule__Alternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2655:1: ( rule__Alternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2655:2: rule__Alternatives__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__15498);
            rule__Alternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2658:1: ( ( rule__Alternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2659:1: ( rule__Alternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2660:1: ( rule__Alternatives__Group_1_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==30) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2660:2: rule__Alternatives__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__15510);
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
    // $ANTLR end rule__Alternatives__Group_1__1


    // $ANTLR start rule__Alternatives__Group_1_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2675:1: rule__Alternatives__Group_1_1__0 : ( '|' ) rule__Alternatives__Group_1_1__1 ;
    public final void rule__Alternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2679:1: ( ( '|' ) rule__Alternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2680:1: ( '|' ) rule__Alternatives__Group_1_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2680:1: ( '|' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2681:1: '|'
            {
             before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FOLLOW_30_in_rule__Alternatives__Group_1_1__05552); 
             after(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FOLLOW_rule__Alternatives__Group_1_1__1_in_rule__Alternatives__Group_1_1__05562);
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


    // $ANTLR start rule__Alternatives__Group_1_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2695:1: rule__Alternatives__Group_1_1__1 : ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__Alternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2699:1: ( ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2700:1: ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2700:1: ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2701:1: ( rule__Alternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2702:1: ( rule__Alternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2702:2: rule__Alternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__Alternatives__GroupsAssignment_1_1_1_in_rule__Alternatives__Group_1_1__15590);
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
    // $ANTLR end rule__Alternatives__Group_1_1__1


    // $ANTLR start rule__Group__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2716:1: rule__Group__Group__0 : ( ruleAbstractToken ) rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2720:1: ( ( ruleAbstractToken ) rule__Group__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2721:1: ( ruleAbstractToken ) rule__Group__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2721:1: ( ruleAbstractToken )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2722:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAbstractToken_in_rule__Group__Group__05628);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__Group__Group__1_in_rule__Group__Group__05636);
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


    // $ANTLR start rule__Group__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2734:1: rule__Group__Group__1 : ( ( rule__Group__Group_1__0 )? ) ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2738:1: ( ( ( rule__Group__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2739:1: ( ( rule__Group__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2739:1: ( ( rule__Group__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2740:1: ( rule__Group__Group_1__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2741:1: ( rule__Group__Group_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_STRING)||LA31_0==20||LA31_0==31) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2741:2: rule__Group__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Group__Group_1__0_in_rule__Group__Group__15664);
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
    // $ANTLR end rule__Group__Group__1


    // $ANTLR start rule__Group__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2755:1: rule__Group__Group_1__0 : ( () ) rule__Group__Group_1__1 ;
    public final void rule__Group__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2759:1: ( ( () ) rule__Group__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2760:1: ( () ) rule__Group__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2760:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2761:1: ()
            {
             before(grammarAccess.getGroupAccess().getGroupTokensAction_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2762:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2764:1: 
            {
            }

             after(grammarAccess.getGroupAccess().getGroupTokensAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__Group__Group_1__1_in_rule__Group__Group_1__05713);
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


    // $ANTLR start rule__Group__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2775:1: rule__Group__Group_1__1 : ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) ) ;
    public final void rule__Group__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2779:1: ( ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2780:1: ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2780:1: ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2781:1: ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2781:1: ( ( rule__Group__TokensAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2782:1: ( rule__Group__TokensAssignment_1_1 )
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2783:1: ( rule__Group__TokensAssignment_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2783:2: rule__Group__TokensAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__15743);
            rule__Group__TokensAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2786:1: ( ( rule__Group__TokensAssignment_1_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2787:1: ( rule__Group__TokensAssignment_1_1 )*
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2788:1: ( rule__Group__TokensAssignment_1_1 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_STRING)||LA32_0==20||LA32_0==31) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2788:2: rule__Group__TokensAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__15755);
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
    // $ANTLR end rule__Group__Group_1__1


    // $ANTLR start rule__AbstractTokenWithCardinality__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2803:1: rule__AbstractTokenWithCardinality__Group__0 : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) rule__AbstractTokenWithCardinality__Group__1 ;
    public final void rule__AbstractTokenWithCardinality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2807:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) rule__AbstractTokenWithCardinality__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2808:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) rule__AbstractTokenWithCardinality__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2808:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2809:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2810:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2810:2: rule__AbstractTokenWithCardinality__Alternatives_0
            {
            pushFollow(FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group__05796);
            rule__AbstractTokenWithCardinality__Alternatives_0();
            _fsp--;


            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 

            }

            pushFollow(FOLLOW_rule__AbstractTokenWithCardinality__Group__1_in_rule__AbstractTokenWithCardinality__Group__05805);
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


    // $ANTLR start rule__AbstractTokenWithCardinality__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2821:1: rule__AbstractTokenWithCardinality__Group__1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2825:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2826:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2826:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2827:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2828:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=11 && LA33_0<=13)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2828:2: rule__AbstractTokenWithCardinality__CardinalityAssignment_1
                    {
                    pushFollow(FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAssignment_1_in_rule__AbstractTokenWithCardinality__Group__15833);
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
    // $ANTLR end rule__AbstractTokenWithCardinality__Group__1


    // $ANTLR start rule__Action__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2842:1: rule__Action__Group__0 : ( '{' ) rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2846:1: ( ( '{' ) rule__Action__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2847:1: ( '{' ) rule__Action__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2847:1: ( '{' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2848:1: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__Action__Group__05873); 
             after(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Action__Group__1_in_rule__Action__Group__05883);
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


    // $ANTLR start rule__Action__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2862:1: rule__Action__Group__1 : ( ( rule__Action__TypeAssignment_1 ) ) rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2866:1: ( ( ( rule__Action__TypeAssignment_1 ) ) rule__Action__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2867:1: ( ( rule__Action__TypeAssignment_1 ) ) rule__Action__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2867:1: ( ( rule__Action__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2868:1: ( rule__Action__TypeAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2869:1: ( rule__Action__TypeAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2869:2: rule__Action__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__Action__TypeAssignment_1_in_rule__Action__Group__15911);
            rule__Action__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getTypeAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Action__Group__2_in_rule__Action__Group__15920);
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


    // $ANTLR start rule__Action__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2880:1: rule__Action__Group__2 : ( ( rule__Action__Group_2__0 )? ) rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2884:1: ( ( ( rule__Action__Group_2__0 )? ) rule__Action__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2885:1: ( ( rule__Action__Group_2__0 )? ) rule__Action__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2885:1: ( ( rule__Action__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2886:1: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2887:1: ( rule__Action__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==22) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2887:2: rule__Action__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Action__Group_2__0_in_rule__Action__Group__25948);
                    rule__Action__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__Action__Group__3_in_rule__Action__Group__25958);
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


    // $ANTLR start rule__Action__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2898:1: rule__Action__Group__3 : ( '}' ) ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2902:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2903:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2903:1: ( '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2904:1: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__Action__Group__35987); 
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
    // $ANTLR end rule__Action__Group__3


    // $ANTLR start rule__Action__Group_2__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2925:1: rule__Action__Group_2__0 : ( '.' ) rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2929:1: ( ( '.' ) rule__Action__Group_2__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2930:1: ( '.' ) rule__Action__Group_2__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2930:1: ( '.' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2931:1: '.'
            {
             before(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 
            match(input,22,FOLLOW_22_in_rule__Action__Group_2__06031); 
             after(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__Action__Group_2__1_in_rule__Action__Group_2__06041);
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


    // $ANTLR start rule__Action__Group_2__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2945:1: rule__Action__Group_2__1 : ( ( rule__Action__FeatureAssignment_2_1 ) ) rule__Action__Group_2__2 ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2949:1: ( ( ( rule__Action__FeatureAssignment_2_1 ) ) rule__Action__Group_2__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2950:1: ( ( rule__Action__FeatureAssignment_2_1 ) ) rule__Action__Group_2__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2950:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2951:1: ( rule__Action__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2952:1: ( rule__Action__FeatureAssignment_2_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2952:2: rule__Action__FeatureAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Action__FeatureAssignment_2_1_in_rule__Action__Group_2__16069);
            rule__Action__FeatureAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 

            }

            pushFollow(FOLLOW_rule__Action__Group_2__2_in_rule__Action__Group_2__16078);
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


    // $ANTLR start rule__Action__Group_2__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2963:1: rule__Action__Group_2__2 : ( ( rule__Action__OperatorAssignment_2_2 ) ) rule__Action__Group_2__3 ;
    public final void rule__Action__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2967:1: ( ( ( rule__Action__OperatorAssignment_2_2 ) ) rule__Action__Group_2__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2968:1: ( ( rule__Action__OperatorAssignment_2_2 ) ) rule__Action__Group_2__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2968:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2969:1: ( rule__Action__OperatorAssignment_2_2 )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2970:1: ( rule__Action__OperatorAssignment_2_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2970:2: rule__Action__OperatorAssignment_2_2
            {
            pushFollow(FOLLOW_rule__Action__OperatorAssignment_2_2_in_rule__Action__Group_2__26106);
            rule__Action__OperatorAssignment_2_2();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 

            }

            pushFollow(FOLLOW_rule__Action__Group_2__3_in_rule__Action__Group_2__26115);
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


    // $ANTLR start rule__Action__Group_2__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2981:1: rule__Action__Group_2__3 : ( 'current' ) ;
    public final void rule__Action__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2985:1: ( ( 'current' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2986:1: ( 'current' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2986:1: ( 'current' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:2987:1: 'current'
            {
             before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 
            match(input,33,FOLLOW_33_in_rule__Action__Group_2__36144); 
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
    // $ANTLR end rule__Action__Group_2__3


    // $ANTLR start rule__Assignment__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3008:1: rule__Assignment__Group__0 : ( ( rule__Assignment__FeatureAssignment_0 ) ) rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3012:1: ( ( ( rule__Assignment__FeatureAssignment_0 ) ) rule__Assignment__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3013:1: ( ( rule__Assignment__FeatureAssignment_0 ) ) rule__Assignment__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3013:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3014:1: ( rule__Assignment__FeatureAssignment_0 )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3015:1: ( rule__Assignment__FeatureAssignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3015:2: rule__Assignment__FeatureAssignment_0
            {
            pushFollow(FOLLOW_rule__Assignment__FeatureAssignment_0_in_rule__Assignment__Group__06187);
            rule__Assignment__FeatureAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Assignment__Group__1_in_rule__Assignment__Group__06196);
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


    // $ANTLR start rule__Assignment__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3026:1: rule__Assignment__Group__1 : ( ( rule__Assignment__OperatorAssignment_1 ) ) rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3030:1: ( ( ( rule__Assignment__OperatorAssignment_1 ) ) rule__Assignment__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3031:1: ( ( rule__Assignment__OperatorAssignment_1 ) ) rule__Assignment__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3031:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3032:1: ( rule__Assignment__OperatorAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3033:1: ( rule__Assignment__OperatorAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3033:2: rule__Assignment__OperatorAssignment_1
            {
            pushFollow(FOLLOW_rule__Assignment__OperatorAssignment_1_in_rule__Assignment__Group__16224);
            rule__Assignment__OperatorAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Assignment__Group__2_in_rule__Assignment__Group__16233);
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


    // $ANTLR start rule__Assignment__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3044:1: rule__Assignment__Group__2 : ( ( rule__Assignment__TerminalAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3048:1: ( ( ( rule__Assignment__TerminalAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3049:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3049:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3050:1: ( rule__Assignment__TerminalAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3051:1: ( rule__Assignment__TerminalAssignment_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3051:2: rule__Assignment__TerminalAssignment_2
            {
            pushFollow(FOLLOW_rule__Assignment__TerminalAssignment_2_in_rule__Assignment__Group__26261);
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
    // $ANTLR end rule__Assignment__Group__2


    // $ANTLR start rule__ParenthesizedAssignableElement__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3067:1: rule__ParenthesizedAssignableElement__Group__0 : ( '(' ) rule__ParenthesizedAssignableElement__Group__1 ;
    public final void rule__ParenthesizedAssignableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3071:1: ( ( '(' ) rule__ParenthesizedAssignableElement__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3072:1: ( '(' ) rule__ParenthesizedAssignableElement__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3072:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3073:1: '('
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__ParenthesizedAssignableElement__Group__06302); 
             after(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__ParenthesizedAssignableElement__Group__1_in_rule__ParenthesizedAssignableElement__Group__06312);
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


    // $ANTLR start rule__ParenthesizedAssignableElement__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3087:1: rule__ParenthesizedAssignableElement__Group__1 : ( ruleAssignableAlternatives ) rule__ParenthesizedAssignableElement__Group__2 ;
    public final void rule__ParenthesizedAssignableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3091:1: ( ( ruleAssignableAlternatives ) rule__ParenthesizedAssignableElement__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3092:1: ( ruleAssignableAlternatives ) rule__ParenthesizedAssignableElement__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3092:1: ( ruleAssignableAlternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3093:1: ruleAssignableAlternatives
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group__16340);
            ruleAssignableAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 

            }

            pushFollow(FOLLOW_rule__ParenthesizedAssignableElement__Group__2_in_rule__ParenthesizedAssignableElement__Group__16348);
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


    // $ANTLR start rule__ParenthesizedAssignableElement__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3105:1: rule__ParenthesizedAssignableElement__Group__2 : ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3109:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3110:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3110:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3111:1: ')'
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group__26377); 
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
    // $ANTLR end rule__ParenthesizedAssignableElement__Group__2


    // $ANTLR start rule__AssignableAlternatives__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3130:1: rule__AssignableAlternatives__Group__0 : ( ruleAssignableTerminal ) rule__AssignableAlternatives__Group__1 ;
    public final void rule__AssignableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3134:1: ( ( ruleAssignableTerminal ) rule__AssignableAlternatives__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3135:1: ( ruleAssignableTerminal ) rule__AssignableAlternatives__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3135:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3136:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group__06418);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__AssignableAlternatives__Group__1_in_rule__AssignableAlternatives__Group__06426);
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


    // $ANTLR start rule__AssignableAlternatives__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3148:1: rule__AssignableAlternatives__Group__1 : ( ( rule__AssignableAlternatives__Group_1__0 )? ) ;
    public final void rule__AssignableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3152:1: ( ( ( rule__AssignableAlternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3153:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3153:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3154:1: ( rule__AssignableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3155:1: ( rule__AssignableAlternatives__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==30) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3155:2: rule__AssignableAlternatives__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AssignableAlternatives__Group_1__0_in_rule__AssignableAlternatives__Group__16454);
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
    // $ANTLR end rule__AssignableAlternatives__Group__1


    // $ANTLR start rule__AssignableAlternatives__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3169:1: rule__AssignableAlternatives__Group_1__0 : ( () ) rule__AssignableAlternatives__Group_1__1 ;
    public final void rule__AssignableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3173:1: ( ( () ) rule__AssignableAlternatives__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3174:1: ( () ) rule__AssignableAlternatives__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3174:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3175:1: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3176:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3178:1: 
            {
            }

             after(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__AssignableAlternatives__Group_1__1_in_rule__AssignableAlternatives__Group_1__06503);
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


    // $ANTLR start rule__AssignableAlternatives__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3189:1: rule__AssignableAlternatives__Group_1__1 : ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__AssignableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3193:1: ( ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3194:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3194:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3195:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3195:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3196:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3197:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3197:2: rule__AssignableAlternatives__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__16533);
            rule__AssignableAlternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3200:1: ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3201:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3202:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==30) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3202:2: rule__AssignableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__16545);
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
    // $ANTLR end rule__AssignableAlternatives__Group_1__1


    // $ANTLR start rule__AssignableAlternatives__Group_1_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3217:1: rule__AssignableAlternatives__Group_1_1__0 : ( '|' ) rule__AssignableAlternatives__Group_1_1__1 ;
    public final void rule__AssignableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3221:1: ( ( '|' ) rule__AssignableAlternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3222:1: ( '|' ) rule__AssignableAlternatives__Group_1_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3222:1: ( '|' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3223:1: '|'
            {
             before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FOLLOW_30_in_rule__AssignableAlternatives__Group_1_1__06587); 
             after(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FOLLOW_rule__AssignableAlternatives__Group_1_1__1_in_rule__AssignableAlternatives__Group_1_1__06597);
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


    // $ANTLR start rule__AssignableAlternatives__Group_1_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3237:1: rule__AssignableAlternatives__Group_1_1__1 : ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3241:1: ( ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3242:1: ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3242:1: ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3243:1: ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3244:1: ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3244:2: rule__AssignableAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__AssignableAlternatives__GroupsAssignment_1_1_1_in_rule__AssignableAlternatives__Group_1_1__16625);
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
    // $ANTLR end rule__AssignableAlternatives__Group_1_1__1


    // $ANTLR start rule__CrossReference__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3258:1: rule__CrossReference__Group__0 : ( '[' ) rule__CrossReference__Group__1 ;
    public final void rule__CrossReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3262:1: ( ( '[' ) rule__CrossReference__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3263:1: ( '[' ) rule__CrossReference__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3263:1: ( '[' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3264:1: '['
            {
             before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 
            match(input,34,FOLLOW_34_in_rule__CrossReference__Group__06664); 
             after(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__CrossReference__Group__1_in_rule__CrossReference__Group__06674);
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


    // $ANTLR start rule__CrossReference__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3278:1: rule__CrossReference__Group__1 : ( ( rule__CrossReference__TypeAssignment_1 ) ) rule__CrossReference__Group__2 ;
    public final void rule__CrossReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3282:1: ( ( ( rule__CrossReference__TypeAssignment_1 ) ) rule__CrossReference__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3283:1: ( ( rule__CrossReference__TypeAssignment_1 ) ) rule__CrossReference__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3283:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3284:1: ( rule__CrossReference__TypeAssignment_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3285:1: ( rule__CrossReference__TypeAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3285:2: rule__CrossReference__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__CrossReference__TypeAssignment_1_in_rule__CrossReference__Group__16702);
            rule__CrossReference__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__CrossReference__Group__2_in_rule__CrossReference__Group__16711);
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


    // $ANTLR start rule__CrossReference__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3296:1: rule__CrossReference__Group__2 : ( ( rule__CrossReference__Group_2__0 )? ) rule__CrossReference__Group__3 ;
    public final void rule__CrossReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3300:1: ( ( ( rule__CrossReference__Group_2__0 )? ) rule__CrossReference__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3301:1: ( ( rule__CrossReference__Group_2__0 )? ) rule__CrossReference__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3301:1: ( ( rule__CrossReference__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3302:1: ( rule__CrossReference__Group_2__0 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3303:1: ( rule__CrossReference__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==30) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3303:2: rule__CrossReference__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__CrossReference__Group_2__0_in_rule__CrossReference__Group__26739);
                    rule__CrossReference__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCrossReferenceAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__CrossReference__Group__3_in_rule__CrossReference__Group__26749);
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


    // $ANTLR start rule__CrossReference__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3314:1: rule__CrossReference__Group__3 : ( ']' ) ;
    public final void rule__CrossReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3318:1: ( ( ']' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3319:1: ( ']' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3319:1: ( ']' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3320:1: ']'
            {
             before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__CrossReference__Group__36778); 
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
    // $ANTLR end rule__CrossReference__Group__3


    // $ANTLR start rule__CrossReference__Group_2__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3341:1: rule__CrossReference__Group_2__0 : ( '|' ) rule__CrossReference__Group_2__1 ;
    public final void rule__CrossReference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3345:1: ( ( '|' ) rule__CrossReference__Group_2__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3346:1: ( '|' ) rule__CrossReference__Group_2__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3346:1: ( '|' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3347:1: '|'
            {
             before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 
            match(input,30,FOLLOW_30_in_rule__CrossReference__Group_2__06822); 
             after(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__CrossReference__Group_2__1_in_rule__CrossReference__Group_2__06832);
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


    // $ANTLR start rule__CrossReference__Group_2__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3361:1: rule__CrossReference__Group_2__1 : ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) ;
    public final void rule__CrossReference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3365:1: ( ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3366:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3366:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3367:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3368:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3368:2: rule__CrossReference__TerminalAssignment_2_1
            {
            pushFollow(FOLLOW_rule__CrossReference__TerminalAssignment_2_1_in_rule__CrossReference__Group_2__16860);
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
    // $ANTLR end rule__CrossReference__Group_2__1


    // $ANTLR start rule__ParenthesizedCrossReferenceableElement__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3382:1: rule__ParenthesizedCrossReferenceableElement__Group__0 : ( '(' ) rule__ParenthesizedCrossReferenceableElement__Group__1 ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3386:1: ( ( '(' ) rule__ParenthesizedCrossReferenceableElement__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3387:1: ( '(' ) rule__ParenthesizedCrossReferenceableElement__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3387:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3388:1: '('
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__ParenthesizedCrossReferenceableElement__Group__06899); 
             after(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__1_in_rule__ParenthesizedCrossReferenceableElement__Group__06909);
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


    // $ANTLR start rule__ParenthesizedCrossReferenceableElement__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3402:1: rule__ParenthesizedCrossReferenceableElement__Group__1 : ( ruleCrossReferenceableAlternatives ) rule__ParenthesizedCrossReferenceableElement__Group__2 ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3406:1: ( ( ruleCrossReferenceableAlternatives ) rule__ParenthesizedCrossReferenceableElement__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3407:1: ( ruleCrossReferenceableAlternatives ) rule__ParenthesizedCrossReferenceableElement__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3407:1: ( ruleCrossReferenceableAlternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3408:1: ruleCrossReferenceableAlternatives
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getCrossReferenceableAlternativesParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleCrossReferenceableAlternatives_in_rule__ParenthesizedCrossReferenceableElement__Group__16937);
            ruleCrossReferenceableAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getCrossReferenceableAlternativesParserRuleCall_1()); 

            }

            pushFollow(FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__2_in_rule__ParenthesizedCrossReferenceableElement__Group__16945);
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


    // $ANTLR start rule__ParenthesizedCrossReferenceableElement__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3420:1: rule__ParenthesizedCrossReferenceableElement__Group__2 : ( ')' ) ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3424:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3425:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3425:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3426:1: ')'
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__ParenthesizedCrossReferenceableElement__Group__26974); 
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
    // $ANTLR end rule__ParenthesizedCrossReferenceableElement__Group__2


    // $ANTLR start rule__CrossReferenceableAlternatives__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3445:1: rule__CrossReferenceableAlternatives__Group__0 : ( ruleCrossReferenceableTerminal ) rule__CrossReferenceableAlternatives__Group__1 ;
    public final void rule__CrossReferenceableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3449:1: ( ( ruleCrossReferenceableTerminal ) rule__CrossReferenceableAlternatives__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3450:1: ( ruleCrossReferenceableTerminal ) rule__CrossReferenceableAlternatives__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3450:1: ( ruleCrossReferenceableTerminal )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3451:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getCrossReferenceableTerminalParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReferenceableAlternatives__Group__07015);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getCrossReferenceableTerminalParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__CrossReferenceableAlternatives__Group__1_in_rule__CrossReferenceableAlternatives__Group__07023);
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


    // $ANTLR start rule__CrossReferenceableAlternatives__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3463:1: rule__CrossReferenceableAlternatives__Group__1 : ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? ) ;
    public final void rule__CrossReferenceableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3467:1: ( ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3468:1: ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3468:1: ( ( rule__CrossReferenceableAlternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3469:1: ( rule__CrossReferenceableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3470:1: ( rule__CrossReferenceableAlternatives__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==30) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3470:2: rule__CrossReferenceableAlternatives__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__CrossReferenceableAlternatives__Group_1__0_in_rule__CrossReferenceableAlternatives__Group__17051);
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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group__1


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3484:1: rule__CrossReferenceableAlternatives__Group_1__0 : ( () ) rule__CrossReferenceableAlternatives__Group_1__1 ;
    public final void rule__CrossReferenceableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3488:1: ( ( () ) rule__CrossReferenceableAlternatives__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3489:1: ( () ) rule__CrossReferenceableAlternatives__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3489:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3490:1: ()
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3491:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3493:1: 
            {
            }

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__CrossReferenceableAlternatives__Group_1__1_in_rule__CrossReferenceableAlternatives__Group_1__07100);
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


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3504:1: rule__CrossReferenceableAlternatives__Group_1__1 : ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3508:1: ( ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3509:1: ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3509:1: ( ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3510:1: ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) ) ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3510:1: ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3511:1: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3512:1: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3512:2: rule__CrossReferenceableAlternatives__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__0_in_rule__CrossReferenceableAlternatives__Group_1__17130);
            rule__CrossReferenceableAlternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3515:1: ( ( rule__CrossReferenceableAlternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3516:1: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3517:1: ( rule__CrossReferenceableAlternatives__Group_1_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==30) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3517:2: rule__CrossReferenceableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__0_in_rule__CrossReferenceableAlternatives__Group_1__17142);
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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group_1__1


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3532:1: rule__CrossReferenceableAlternatives__Group_1_1__0 : ( '|' ) rule__CrossReferenceableAlternatives__Group_1_1__1 ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3536:1: ( ( '|' ) rule__CrossReferenceableAlternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3537:1: ( '|' ) rule__CrossReferenceableAlternatives__Group_1_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3537:1: ( '|' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3538:1: '|'
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FOLLOW_30_in_rule__CrossReferenceableAlternatives__Group_1_1__07184); 
             after(grammarAccess.getCrossReferenceableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__1_in_rule__CrossReferenceableAlternatives__Group_1_1__07194);
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


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3552:1: rule__CrossReferenceableAlternatives__Group_1_1__1 : ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3556:1: ( ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3557:1: ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3557:1: ( ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3558:1: ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3559:1: ( rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3559:2: rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1_in_rule__CrossReferenceableAlternatives__Group_1_1__17222);
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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group_1_1__1


    // $ANTLR start rule__ParenthesizedElement__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3573:1: rule__ParenthesizedElement__Group__0 : ( '(' ) rule__ParenthesizedElement__Group__1 ;
    public final void rule__ParenthesizedElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3577:1: ( ( '(' ) rule__ParenthesizedElement__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3578:1: ( '(' ) rule__ParenthesizedElement__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3578:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3579:1: '('
            {
             before(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__ParenthesizedElement__Group__07261); 
             after(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__ParenthesizedElement__Group__1_in_rule__ParenthesizedElement__Group__07271);
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


    // $ANTLR start rule__ParenthesizedElement__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3593:1: rule__ParenthesizedElement__Group__1 : ( ruleAlternatives ) rule__ParenthesizedElement__Group__2 ;
    public final void rule__ParenthesizedElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3597:1: ( ( ruleAlternatives ) rule__ParenthesizedElement__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3598:1: ( ruleAlternatives ) rule__ParenthesizedElement__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3598:1: ( ruleAlternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3599:1: ruleAlternatives
            {
             before(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group__17299);
            ruleAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 

            }

            pushFollow(FOLLOW_rule__ParenthesizedElement__Group__2_in_rule__ParenthesizedElement__Group__17307);
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


    // $ANTLR start rule__ParenthesizedElement__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3611:1: rule__ParenthesizedElement__Group__2 : ( ')' ) ;
    public final void rule__ParenthesizedElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3615:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3616:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3616:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3617:1: ')'
            {
             before(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__ParenthesizedElement__Group__27336); 
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
    // $ANTLR end rule__ParenthesizedElement__Group__2


    // $ANTLR start rule__TerminalRule__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3636:1: rule__TerminalRule__Group__0 : ( 'terminal' ) rule__TerminalRule__Group__1 ;
    public final void rule__TerminalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3640:1: ( ( 'terminal' ) rule__TerminalRule__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3641:1: ( 'terminal' ) rule__TerminalRule__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3641:1: ( 'terminal' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3642:1: 'terminal'
            {
             before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__TerminalRule__Group__07378); 
             after(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__TerminalRule__Group__1_in_rule__TerminalRule__Group__07388);
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


    // $ANTLR start rule__TerminalRule__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3656:1: rule__TerminalRule__Group__1 : ( ( rule__TerminalRule__NameAssignment_1 ) ) rule__TerminalRule__Group__2 ;
    public final void rule__TerminalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3660:1: ( ( ( rule__TerminalRule__NameAssignment_1 ) ) rule__TerminalRule__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3661:1: ( ( rule__TerminalRule__NameAssignment_1 ) ) rule__TerminalRule__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3661:1: ( ( rule__TerminalRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3662:1: ( rule__TerminalRule__NameAssignment_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3663:1: ( rule__TerminalRule__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3663:2: rule__TerminalRule__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TerminalRule__NameAssignment_1_in_rule__TerminalRule__Group__17416);
            rule__TerminalRule__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__TerminalRule__Group__2_in_rule__TerminalRule__Group__17425);
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


    // $ANTLR start rule__TerminalRule__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3674:1: rule__TerminalRule__Group__2 : ( ( rule__TerminalRule__Group_2__0 )? ) rule__TerminalRule__Group__3 ;
    public final void rule__TerminalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3678:1: ( ( ( rule__TerminalRule__Group_2__0 )? ) rule__TerminalRule__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3679:1: ( ( rule__TerminalRule__Group_2__0 )? ) rule__TerminalRule__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3679:1: ( ( rule__TerminalRule__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3680:1: ( rule__TerminalRule__Group_2__0 )?
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3681:1: ( rule__TerminalRule__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==28) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3681:2: rule__TerminalRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__TerminalRule__Group_2__0_in_rule__TerminalRule__Group__27453);
                    rule__TerminalRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalRuleAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__TerminalRule__Group__3_in_rule__TerminalRule__Group__27463);
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


    // $ANTLR start rule__TerminalRule__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3692:1: rule__TerminalRule__Group__3 : ( ':' ) rule__TerminalRule__Group__4 ;
    public final void rule__TerminalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3696:1: ( ( ':' ) rule__TerminalRule__Group__4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3697:1: ( ':' ) rule__TerminalRule__Group__4
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3697:1: ( ':' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3698:1: ':'
            {
             before(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 
            match(input,26,FOLLOW_26_in_rule__TerminalRule__Group__37492); 
             after(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__TerminalRule__Group__4_in_rule__TerminalRule__Group__37502);
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


    // $ANTLR start rule__TerminalRule__Group__4
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3712:1: rule__TerminalRule__Group__4 : ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) rule__TerminalRule__Group__5 ;
    public final void rule__TerminalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3716:1: ( ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) rule__TerminalRule__Group__5 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3717:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) rule__TerminalRule__Group__5
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3717:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3718:1: ( rule__TerminalRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3719:1: ( rule__TerminalRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3719:2: rule__TerminalRule__AlternativesAssignment_4
            {
            pushFollow(FOLLOW_rule__TerminalRule__AlternativesAssignment_4_in_rule__TerminalRule__Group__47530);
            rule__TerminalRule__AlternativesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__TerminalRule__Group__5_in_rule__TerminalRule__Group__47539);
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


    // $ANTLR start rule__TerminalRule__Group__5
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3730:1: rule__TerminalRule__Group__5 : ( ';' ) ;
    public final void rule__TerminalRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3734:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3735:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3735:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3736:1: ';'
            {
             before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FOLLOW_27_in_rule__TerminalRule__Group__57568); 
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
    // $ANTLR end rule__TerminalRule__Group__5


    // $ANTLR start rule__TerminalRule__Group_2__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3761:1: rule__TerminalRule__Group_2__0 : ( 'returns' ) rule__TerminalRule__Group_2__1 ;
    public final void rule__TerminalRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3765:1: ( ( 'returns' ) rule__TerminalRule__Group_2__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3766:1: ( 'returns' ) rule__TerminalRule__Group_2__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3766:1: ( 'returns' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3767:1: 'returns'
            {
             before(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FOLLOW_28_in_rule__TerminalRule__Group_2__07616); 
             after(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__TerminalRule__Group_2__1_in_rule__TerminalRule__Group_2__07626);
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


    // $ANTLR start rule__TerminalRule__Group_2__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3781:1: rule__TerminalRule__Group_2__1 : ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) ;
    public final void rule__TerminalRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3785:1: ( ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3786:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3786:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3787:1: ( rule__TerminalRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3788:1: ( rule__TerminalRule__TypeAssignment_2_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3788:2: rule__TerminalRule__TypeAssignment_2_1
            {
            pushFollow(FOLLOW_rule__TerminalRule__TypeAssignment_2_1_in_rule__TerminalRule__Group_2__17654);
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
    // $ANTLR end rule__TerminalRule__Group_2__1


    // $ANTLR start rule__TerminalAlternatives__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3802:1: rule__TerminalAlternatives__Group__0 : ( ruleTerminalGroup ) rule__TerminalAlternatives__Group__1 ;
    public final void rule__TerminalAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3806:1: ( ( ruleTerminalGroup ) rule__TerminalAlternatives__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3807:1: ( ruleTerminalGroup ) rule__TerminalAlternatives__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3807:1: ( ruleTerminalGroup )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3808:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group__07692);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__TerminalAlternatives__Group__1_in_rule__TerminalAlternatives__Group__07700);
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


    // $ANTLR start rule__TerminalAlternatives__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3820:1: rule__TerminalAlternatives__Group__1 : ( ( rule__TerminalAlternatives__Group_1__0 )? ) ;
    public final void rule__TerminalAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3824:1: ( ( ( rule__TerminalAlternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3825:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3825:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3826:1: ( rule__TerminalAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3827:1: ( rule__TerminalAlternatives__Group_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==30) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3827:2: rule__TerminalAlternatives__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TerminalAlternatives__Group_1__0_in_rule__TerminalAlternatives__Group__17728);
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
    // $ANTLR end rule__TerminalAlternatives__Group__1


    // $ANTLR start rule__TerminalAlternatives__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3841:1: rule__TerminalAlternatives__Group_1__0 : ( () ) rule__TerminalAlternatives__Group_1__1 ;
    public final void rule__TerminalAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3845:1: ( ( () ) rule__TerminalAlternatives__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3846:1: ( () ) rule__TerminalAlternatives__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3846:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3847:1: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3848:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3850:1: 
            {
            }

             after(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__TerminalAlternatives__Group_1__1_in_rule__TerminalAlternatives__Group_1__07777);
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


    // $ANTLR start rule__TerminalAlternatives__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3861:1: rule__TerminalAlternatives__Group_1__1 : ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__TerminalAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3865:1: ( ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3866:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3866:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3867:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3867:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3868:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3869:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3869:2: rule__TerminalAlternatives__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__17807);
            rule__TerminalAlternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3872:1: ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3873:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3874:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==30) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3874:2: rule__TerminalAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__17819);
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
    // $ANTLR end rule__TerminalAlternatives__Group_1__1


    // $ANTLR start rule__TerminalAlternatives__Group_1_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3889:1: rule__TerminalAlternatives__Group_1_1__0 : ( '|' ) rule__TerminalAlternatives__Group_1_1__1 ;
    public final void rule__TerminalAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3893:1: ( ( '|' ) rule__TerminalAlternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3894:1: ( '|' ) rule__TerminalAlternatives__Group_1_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3894:1: ( '|' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3895:1: '|'
            {
             before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FOLLOW_30_in_rule__TerminalAlternatives__Group_1_1__07861); 
             after(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FOLLOW_rule__TerminalAlternatives__Group_1_1__1_in_rule__TerminalAlternatives__Group_1_1__07871);
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


    // $ANTLR start rule__TerminalAlternatives__Group_1_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3909:1: rule__TerminalAlternatives__Group_1_1__1 : ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3913:1: ( ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3914:1: ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3914:1: ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3915:1: ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3916:1: ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3916:2: rule__TerminalAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__TerminalAlternatives__GroupsAssignment_1_1_1_in_rule__TerminalAlternatives__Group_1_1__17899);
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
    // $ANTLR end rule__TerminalAlternatives__Group_1_1__1


    // $ANTLR start rule__TerminalGroup__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3930:1: rule__TerminalGroup__Group__0 : ( ruleTerminalToken ) rule__TerminalGroup__Group__1 ;
    public final void rule__TerminalGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3934:1: ( ( ruleTerminalToken ) rule__TerminalGroup__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3935:1: ( ruleTerminalToken ) rule__TerminalGroup__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3935:1: ( ruleTerminalToken )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3936:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group__07937);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__TerminalGroup__Group__1_in_rule__TerminalGroup__Group__07945);
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


    // $ANTLR start rule__TerminalGroup__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3948:1: rule__TerminalGroup__Group__1 : ( ( rule__TerminalGroup__Group_1__0 )? ) ;
    public final void rule__TerminalGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3952:1: ( ( ( rule__TerminalGroup__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3953:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3953:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3954:1: ( rule__TerminalGroup__Group_1__0 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3955:1: ( rule__TerminalGroup__Group_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_STRING)||LA43_0==20||LA43_0==22||(LA43_0>=37 && LA43_0<=38)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3955:2: rule__TerminalGroup__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TerminalGroup__Group_1__0_in_rule__TerminalGroup__Group__17973);
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
    // $ANTLR end rule__TerminalGroup__Group__1


    // $ANTLR start rule__TerminalGroup__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3969:1: rule__TerminalGroup__Group_1__0 : ( () ) rule__TerminalGroup__Group_1__1 ;
    public final void rule__TerminalGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3973:1: ( ( () ) rule__TerminalGroup__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3974:1: ( () ) rule__TerminalGroup__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3974:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3975:1: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3976:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3978:1: 
            {
            }

             after(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__TerminalGroup__Group_1__1_in_rule__TerminalGroup__Group_1__08022);
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


    // $ANTLR start rule__TerminalGroup__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3989:1: rule__TerminalGroup__Group_1__1 : ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) ) ;
    public final void rule__TerminalGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3993:1: ( ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3994:1: ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3994:1: ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3995:1: ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3995:1: ( ( rule__TerminalGroup__TokensAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3996:1: ( rule__TerminalGroup__TokensAssignment_1_1 )
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3997:1: ( rule__TerminalGroup__TokensAssignment_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:3997:2: rule__TerminalGroup__TokensAssignment_1_1
            {
            pushFollow(FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__18052);
            rule__TerminalGroup__TokensAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4000:1: ( ( rule__TerminalGroup__TokensAssignment_1_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4001:1: ( rule__TerminalGroup__TokensAssignment_1_1 )*
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4002:1: ( rule__TerminalGroup__TokensAssignment_1_1 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||LA44_0==20||LA44_0==22||(LA44_0>=37 && LA44_0<=38)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4002:2: rule__TerminalGroup__TokensAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__18064);
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
    // $ANTLR end rule__TerminalGroup__Group_1__1


    // $ANTLR start rule__TerminalToken__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4017:1: rule__TerminalToken__Group__0 : ( ruleTerminalTokenElement ) rule__TerminalToken__Group__1 ;
    public final void rule__TerminalToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4021:1: ( ( ruleTerminalTokenElement ) rule__TerminalToken__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4022:1: ( ruleTerminalTokenElement ) rule__TerminalToken__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4022:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4023:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group__08105);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__TerminalToken__Group__1_in_rule__TerminalToken__Group__08113);
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


    // $ANTLR start rule__TerminalToken__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4035:1: rule__TerminalToken__Group__1 : ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) ;
    public final void rule__TerminalToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4039:1: ( ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4040:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4040:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4041:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4042:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=11 && LA45_0<=13)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4042:2: rule__TerminalToken__CardinalityAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TerminalToken__CardinalityAssignment_1_in_rule__TerminalToken__Group__18141);
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
    // $ANTLR end rule__TerminalToken__Group__1


    // $ANTLR start rule__ParenthesizedTerminalElement__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4056:1: rule__ParenthesizedTerminalElement__Group__0 : ( '(' ) rule__ParenthesizedTerminalElement__Group__1 ;
    public final void rule__ParenthesizedTerminalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4060:1: ( ( '(' ) rule__ParenthesizedTerminalElement__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4061:1: ( '(' ) rule__ParenthesizedTerminalElement__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4061:1: ( '(' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4062:1: '('
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__ParenthesizedTerminalElement__Group__08181); 
             after(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__ParenthesizedTerminalElement__Group__1_in_rule__ParenthesizedTerminalElement__Group__08191);
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


    // $ANTLR start rule__ParenthesizedTerminalElement__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4076:1: rule__ParenthesizedTerminalElement__Group__1 : ( ruleTerminalAlternatives ) rule__ParenthesizedTerminalElement__Group__2 ;
    public final void rule__ParenthesizedTerminalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4080:1: ( ( ruleTerminalAlternatives ) rule__ParenthesizedTerminalElement__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4081:1: ( ruleTerminalAlternatives ) rule__ParenthesizedTerminalElement__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4081:1: ( ruleTerminalAlternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4082:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group__18219);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 

            }

            pushFollow(FOLLOW_rule__ParenthesizedTerminalElement__Group__2_in_rule__ParenthesizedTerminalElement__Group__18227);
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


    // $ANTLR start rule__ParenthesizedTerminalElement__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4094:1: rule__ParenthesizedTerminalElement__Group__2 : ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4098:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4099:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4099:1: ( ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4100:1: ')'
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group__28256); 
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
    // $ANTLR end rule__ParenthesizedTerminalElement__Group__2


    // $ANTLR start rule__NegatedToken__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4119:1: rule__NegatedToken__Group__0 : ( '!' ) rule__NegatedToken__Group__1 ;
    public final void rule__NegatedToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4123:1: ( ( '!' ) rule__NegatedToken__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4124:1: ( '!' ) rule__NegatedToken__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4124:1: ( '!' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4125:1: '!'
            {
             before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 
            match(input,37,FOLLOW_37_in_rule__NegatedToken__Group__08298); 
             after(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__NegatedToken__Group__1_in_rule__NegatedToken__Group__08308);
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


    // $ANTLR start rule__NegatedToken__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4139:1: rule__NegatedToken__Group__1 : ( ( rule__NegatedToken__TerminalAssignment_1 ) ) ;
    public final void rule__NegatedToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4143:1: ( ( ( rule__NegatedToken__TerminalAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4144:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4144:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4145:1: ( rule__NegatedToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4146:1: ( rule__NegatedToken__TerminalAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4146:2: rule__NegatedToken__TerminalAssignment_1
            {
            pushFollow(FOLLOW_rule__NegatedToken__TerminalAssignment_1_in_rule__NegatedToken__Group__18336);
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
    // $ANTLR end rule__NegatedToken__Group__1


    // $ANTLR start rule__UntilToken__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4160:1: rule__UntilToken__Group__0 : ( '->' ) rule__UntilToken__Group__1 ;
    public final void rule__UntilToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4164:1: ( ( '->' ) rule__UntilToken__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4165:1: ( '->' ) rule__UntilToken__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4165:1: ( '->' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4166:1: '->'
            {
             before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,38,FOLLOW_38_in_rule__UntilToken__Group__08375); 
             after(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__UntilToken__Group__1_in_rule__UntilToken__Group__08385);
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


    // $ANTLR start rule__UntilToken__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4180:1: rule__UntilToken__Group__1 : ( ( rule__UntilToken__TerminalAssignment_1 ) ) ;
    public final void rule__UntilToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4184:1: ( ( ( rule__UntilToken__TerminalAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4185:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4185:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4186:1: ( rule__UntilToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4187:1: ( rule__UntilToken__TerminalAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4187:2: rule__UntilToken__TerminalAssignment_1
            {
            pushFollow(FOLLOW_rule__UntilToken__TerminalAssignment_1_in_rule__UntilToken__Group__18413);
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
    // $ANTLR end rule__UntilToken__Group__1


    // $ANTLR start rule__Wildcard__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4201:1: rule__Wildcard__Group__0 : ( () ) rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4205:1: ( ( () ) rule__Wildcard__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4206:1: ( () ) rule__Wildcard__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4206:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4207:1: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4208:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4210:1: 
            {
            }

             after(grammarAccess.getWildcardAccess().getWildcardAction_0()); 

            }

            pushFollow(FOLLOW_rule__Wildcard__Group__1_in_rule__Wildcard__Group__08461);
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


    // $ANTLR start rule__Wildcard__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4221:1: rule__Wildcard__Group__1 : ( '.' ) ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4225:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4226:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4226:1: ( '.' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4227:1: '.'
            {
             before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            match(input,22,FOLLOW_22_in_rule__Wildcard__Group__18490); 
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
    // $ANTLR end rule__Wildcard__Group__1


    // $ANTLR start rule__CharacterRange__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4244:1: rule__CharacterRange__Group__0 : ( ruleKeyword ) rule__CharacterRange__Group__1 ;
    public final void rule__CharacterRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4248:1: ( ( ruleKeyword ) rule__CharacterRange__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4249:1: ( ruleKeyword ) rule__CharacterRange__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4249:1: ( ruleKeyword )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4250:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__CharacterRange__Group__08529);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__CharacterRange__Group__1_in_rule__CharacterRange__Group__08537);
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


    // $ANTLR start rule__CharacterRange__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4262:1: rule__CharacterRange__Group__1 : ( ( rule__CharacterRange__Group_1__0 )? ) ;
    public final void rule__CharacterRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4266:1: ( ( ( rule__CharacterRange__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4267:1: ( ( rule__CharacterRange__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4267:1: ( ( rule__CharacterRange__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4268:1: ( rule__CharacterRange__Group_1__0 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4269:1: ( rule__CharacterRange__Group_1__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==39) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4269:2: rule__CharacterRange__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__CharacterRange__Group_1__0_in_rule__CharacterRange__Group__18565);
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
    // $ANTLR end rule__CharacterRange__Group__1


    // $ANTLR start rule__CharacterRange__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4283:1: rule__CharacterRange__Group_1__0 : ( () ) rule__CharacterRange__Group_1__1 ;
    public final void rule__CharacterRange__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4287:1: ( ( () ) rule__CharacterRange__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4288:1: ( () ) rule__CharacterRange__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4288:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4289:1: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4290:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4292:1: 
            {
            }

             after(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__CharacterRange__Group_1__1_in_rule__CharacterRange__Group_1__08614);
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


    // $ANTLR start rule__CharacterRange__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4303:1: rule__CharacterRange__Group_1__1 : ( '..' ) rule__CharacterRange__Group_1__2 ;
    public final void rule__CharacterRange__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4307:1: ( ( '..' ) rule__CharacterRange__Group_1__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4308:1: ( '..' ) rule__CharacterRange__Group_1__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4308:1: ( '..' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4309:1: '..'
            {
             before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,39,FOLLOW_39_in_rule__CharacterRange__Group_1__18643); 
             after(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 

            }

            pushFollow(FOLLOW_rule__CharacterRange__Group_1__2_in_rule__CharacterRange__Group_1__18653);
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


    // $ANTLR start rule__CharacterRange__Group_1__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4323:1: rule__CharacterRange__Group_1__2 : ( ( rule__CharacterRange__RightAssignment_1_2 ) ) ;
    public final void rule__CharacterRange__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4327:1: ( ( ( rule__CharacterRange__RightAssignment_1_2 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4328:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4328:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4329:1: ( rule__CharacterRange__RightAssignment_1_2 )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4330:1: ( rule__CharacterRange__RightAssignment_1_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4330:2: rule__CharacterRange__RightAssignment_1_2
            {
            pushFollow(FOLLOW_rule__CharacterRange__RightAssignment_1_2_in_rule__CharacterRange__Group_1__28681);
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
    // $ANTLR end rule__CharacterRange__Group_1__2


    // $ANTLR start rule__EnumRule__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4346:1: rule__EnumRule__Group__0 : ( 'enum' ) rule__EnumRule__Group__1 ;
    public final void rule__EnumRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4350:1: ( ( 'enum' ) rule__EnumRule__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4351:1: ( 'enum' ) rule__EnumRule__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4351:1: ( 'enum' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4352:1: 'enum'
            {
             before(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__EnumRule__Group__08722); 
             after(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__EnumRule__Group__1_in_rule__EnumRule__Group__08732);
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


    // $ANTLR start rule__EnumRule__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4366:1: rule__EnumRule__Group__1 : ( ( rule__EnumRule__NameAssignment_1 ) ) rule__EnumRule__Group__2 ;
    public final void rule__EnumRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4370:1: ( ( ( rule__EnumRule__NameAssignment_1 ) ) rule__EnumRule__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4371:1: ( ( rule__EnumRule__NameAssignment_1 ) ) rule__EnumRule__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4371:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4372:1: ( rule__EnumRule__NameAssignment_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4373:1: ( rule__EnumRule__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4373:2: rule__EnumRule__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__EnumRule__NameAssignment_1_in_rule__EnumRule__Group__18760);
            rule__EnumRule__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__EnumRule__Group__2_in_rule__EnumRule__Group__18769);
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


    // $ANTLR start rule__EnumRule__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4384:1: rule__EnumRule__Group__2 : ( ( rule__EnumRule__Group_2__0 )? ) rule__EnumRule__Group__3 ;
    public final void rule__EnumRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4388:1: ( ( ( rule__EnumRule__Group_2__0 )? ) rule__EnumRule__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4389:1: ( ( rule__EnumRule__Group_2__0 )? ) rule__EnumRule__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4389:1: ( ( rule__EnumRule__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4390:1: ( rule__EnumRule__Group_2__0 )?
            {
             before(grammarAccess.getEnumRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4391:1: ( rule__EnumRule__Group_2__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==28) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4391:2: rule__EnumRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__EnumRule__Group_2__0_in_rule__EnumRule__Group__28797);
                    rule__EnumRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumRuleAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__EnumRule__Group__3_in_rule__EnumRule__Group__28807);
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


    // $ANTLR start rule__EnumRule__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4402:1: rule__EnumRule__Group__3 : ( ':' ) rule__EnumRule__Group__4 ;
    public final void rule__EnumRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4406:1: ( ( ':' ) rule__EnumRule__Group__4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4407:1: ( ':' ) rule__EnumRule__Group__4
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4407:1: ( ':' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4408:1: ':'
            {
             before(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 
            match(input,26,FOLLOW_26_in_rule__EnumRule__Group__38836); 
             after(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__EnumRule__Group__4_in_rule__EnumRule__Group__38846);
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


    // $ANTLR start rule__EnumRule__Group__4
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4422:1: rule__EnumRule__Group__4 : ( ( rule__EnumRule__AlternativesAssignment_4 ) ) rule__EnumRule__Group__5 ;
    public final void rule__EnumRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4426:1: ( ( ( rule__EnumRule__AlternativesAssignment_4 ) ) rule__EnumRule__Group__5 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4427:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) ) rule__EnumRule__Group__5
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4427:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4428:1: ( rule__EnumRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4429:1: ( rule__EnumRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4429:2: rule__EnumRule__AlternativesAssignment_4
            {
            pushFollow(FOLLOW_rule__EnumRule__AlternativesAssignment_4_in_rule__EnumRule__Group__48874);
            rule__EnumRule__AlternativesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__EnumRule__Group__5_in_rule__EnumRule__Group__48883);
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


    // $ANTLR start rule__EnumRule__Group__5
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4440:1: rule__EnumRule__Group__5 : ( ';' ) ;
    public final void rule__EnumRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4444:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4445:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4445:1: ( ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4446:1: ';'
            {
             before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FOLLOW_27_in_rule__EnumRule__Group__58912); 
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
    // $ANTLR end rule__EnumRule__Group__5


    // $ANTLR start rule__EnumRule__Group_2__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4471:1: rule__EnumRule__Group_2__0 : ( 'returns' ) rule__EnumRule__Group_2__1 ;
    public final void rule__EnumRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4475:1: ( ( 'returns' ) rule__EnumRule__Group_2__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4476:1: ( 'returns' ) rule__EnumRule__Group_2__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4476:1: ( 'returns' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4477:1: 'returns'
            {
             before(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FOLLOW_28_in_rule__EnumRule__Group_2__08960); 
             after(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__EnumRule__Group_2__1_in_rule__EnumRule__Group_2__08970);
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


    // $ANTLR start rule__EnumRule__Group_2__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4491:1: rule__EnumRule__Group_2__1 : ( ( rule__EnumRule__TypeAssignment_2_1 ) ) ;
    public final void rule__EnumRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4495:1: ( ( ( rule__EnumRule__TypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4496:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4496:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4497:1: ( rule__EnumRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4498:1: ( rule__EnumRule__TypeAssignment_2_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4498:2: rule__EnumRule__TypeAssignment_2_1
            {
            pushFollow(FOLLOW_rule__EnumRule__TypeAssignment_2_1_in_rule__EnumRule__Group_2__18998);
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
    // $ANTLR end rule__EnumRule__Group_2__1


    // $ANTLR start rule__EnumLiterals__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4512:1: rule__EnumLiterals__Group__0 : ( ruleEnumLiteralDeclaration ) rule__EnumLiterals__Group__1 ;
    public final void rule__EnumLiterals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4516:1: ( ( ruleEnumLiteralDeclaration ) rule__EnumLiterals__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4517:1: ( ruleEnumLiteralDeclaration ) rule__EnumLiterals__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4517:1: ( ruleEnumLiteralDeclaration )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4518:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group__09036);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__EnumLiterals__Group__1_in_rule__EnumLiterals__Group__09044);
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


    // $ANTLR start rule__EnumLiterals__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4530:1: rule__EnumLiterals__Group__1 : ( ( rule__EnumLiterals__Group_1__0 )? ) ;
    public final void rule__EnumLiterals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4534:1: ( ( ( rule__EnumLiterals__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4535:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4535:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4536:1: ( rule__EnumLiterals__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4537:1: ( rule__EnumLiterals__Group_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==30) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4537:2: rule__EnumLiterals__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__EnumLiterals__Group_1__0_in_rule__EnumLiterals__Group__19072);
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
    // $ANTLR end rule__EnumLiterals__Group__1


    // $ANTLR start rule__EnumLiterals__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4551:1: rule__EnumLiterals__Group_1__0 : ( () ) rule__EnumLiterals__Group_1__1 ;
    public final void rule__EnumLiterals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4555:1: ( ( () ) rule__EnumLiterals__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4556:1: ( () ) rule__EnumLiterals__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4556:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4557:1: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4558:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4560:1: 
            {
            }

             after(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__EnumLiterals__Group_1__1_in_rule__EnumLiterals__Group_1__09121);
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


    // $ANTLR start rule__EnumLiterals__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4571:1: rule__EnumLiterals__Group_1__1 : ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) ;
    public final void rule__EnumLiterals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4575:1: ( ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4576:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4576:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4577:1: ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4577:1: ( ( rule__EnumLiterals__Group_1_1__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4578:1: ( rule__EnumLiterals__Group_1_1__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4579:1: ( rule__EnumLiterals__Group_1_1__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4579:2: rule__EnumLiterals__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__19151);
            rule__EnumLiterals__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4582:1: ( ( rule__EnumLiterals__Group_1_1__0 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4583:1: ( rule__EnumLiterals__Group_1_1__0 )*
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4584:1: ( rule__EnumLiterals__Group_1_1__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==30) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4584:2: rule__EnumLiterals__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__19163);
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
    // $ANTLR end rule__EnumLiterals__Group_1__1


    // $ANTLR start rule__EnumLiterals__Group_1_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4599:1: rule__EnumLiterals__Group_1_1__0 : ( '|' ) rule__EnumLiterals__Group_1_1__1 ;
    public final void rule__EnumLiterals__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4603:1: ( ( '|' ) rule__EnumLiterals__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4604:1: ( '|' ) rule__EnumLiterals__Group_1_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4604:1: ( '|' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4605:1: '|'
            {
             before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FOLLOW_30_in_rule__EnumLiterals__Group_1_1__09205); 
             after(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FOLLOW_rule__EnumLiterals__Group_1_1__1_in_rule__EnumLiterals__Group_1_1__09215);
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


    // $ANTLR start rule__EnumLiterals__Group_1_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4619:1: rule__EnumLiterals__Group_1_1__1 : ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__EnumLiterals__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4623:1: ( ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4624:1: ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4624:1: ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4625:1: ( rule__EnumLiterals__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4626:1: ( rule__EnumLiterals__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4626:2: rule__EnumLiterals__GroupsAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__EnumLiterals__GroupsAssignment_1_1_1_in_rule__EnumLiterals__Group_1_1__19243);
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
    // $ANTLR end rule__EnumLiterals__Group_1_1__1


    // $ANTLR start rule__EnumLiteralDeclaration__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4640:1: rule__EnumLiteralDeclaration__Group__0 : ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) rule__EnumLiteralDeclaration__Group__1 ;
    public final void rule__EnumLiteralDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4644:1: ( ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) rule__EnumLiteralDeclaration__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4645:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) rule__EnumLiteralDeclaration__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4645:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4646:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4647:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4647:2: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
            {
            pushFollow(FOLLOW_rule__EnumLiteralDeclaration__EnumLiteralAssignment_0_in_rule__EnumLiteralDeclaration__Group__09281);
            rule__EnumLiteralDeclaration__EnumLiteralAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__EnumLiteralDeclaration__Group__1_in_rule__EnumLiteralDeclaration__Group__09290);
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


    // $ANTLR start rule__EnumLiteralDeclaration__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4658:1: rule__EnumLiteralDeclaration__Group__1 : ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4662:1: ( ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4663:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4663:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4664:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4665:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==14) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4665:2: rule__EnumLiteralDeclaration__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__EnumLiteralDeclaration__Group_1__0_in_rule__EnumLiteralDeclaration__Group__19318);
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
    // $ANTLR end rule__EnumLiteralDeclaration__Group__1


    // $ANTLR start rule__EnumLiteralDeclaration__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4679:1: rule__EnumLiteralDeclaration__Group_1__0 : ( '=' ) rule__EnumLiteralDeclaration__Group_1__1 ;
    public final void rule__EnumLiteralDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4683:1: ( ( '=' ) rule__EnumLiteralDeclaration__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4684:1: ( '=' ) rule__EnumLiteralDeclaration__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4684:1: ( '=' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4685:1: '='
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 
            match(input,14,FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_1__09358); 
             after(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__EnumLiteralDeclaration__Group_1__1_in_rule__EnumLiteralDeclaration__Group_1__09368);
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


    // $ANTLR start rule__EnumLiteralDeclaration__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4699:1: rule__EnumLiteralDeclaration__Group_1__1 : ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4703:1: ( ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4704:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4704:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4705:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4706:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4706:2: rule__EnumLiteralDeclaration__LiteralAssignment_1_1
            {
            pushFollow(FOLLOW_rule__EnumLiteralDeclaration__LiteralAssignment_1_1_in_rule__EnumLiteralDeclaration__Group_1__19396);
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
    // $ANTLR end rule__EnumLiteralDeclaration__Group_1__1


    // $ANTLR start rule__Grammar__NameAssignment_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4720:1: rule__Grammar__NameAssignment_1 : ( ruleGrammarID ) ;
    public final void rule__Grammar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4724:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4725:1: ( ruleGrammarID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4725:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4726:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleGrammarID_in_rule__Grammar__NameAssignment_19434);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4735:1: rule__Grammar__UsedGrammarsAssignment_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4739:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4740:1: ( ( ruleGrammarID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4740:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4741:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4742:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4743:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_19469);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4754:1: rule__Grammar__UsedGrammarsAssignment_2_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4758:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4759:1: ( ( ruleGrammarID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4759:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4760:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4761:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4762:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 
            pushFollow(FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_2_19508);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4773:1: rule__Grammar__DefinesHiddenTokensAssignment_3_0 : ( ( 'hidden' ) ) ;
    public final void rule__Grammar__DefinesHiddenTokensAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4777:1: ( ( ( 'hidden' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4778:1: ( ( 'hidden' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4778:1: ( ( 'hidden' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4779:1: ( 'hidden' )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4780:1: ( 'hidden' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4781:1: 'hidden'
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            match(input,41,FOLLOW_41_in_rule__Grammar__DefinesHiddenTokensAssignment_3_09548); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4796:1: rule__Grammar__HiddenTokensAssignment_3_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4800:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4801:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4801:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4802:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4803:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4804:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_09591); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4815:1: rule__Grammar__HiddenTokensAssignment_3_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4819:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4820:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4820:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4821:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4822:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4823:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_1_19630); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4834:1: rule__Grammar__MetamodelDeclarationsAssignment_4 : ( ruleAbstractMetamodelDeclaration ) ;
    public final void rule__Grammar__MetamodelDeclarationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4838:1: ( ( ruleAbstractMetamodelDeclaration ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4839:1: ( ruleAbstractMetamodelDeclaration )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4839:1: ( ruleAbstractMetamodelDeclaration )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4840:1: ruleAbstractMetamodelDeclaration
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__MetamodelDeclarationsAssignment_49665);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4849:1: rule__Grammar__RulesAssignment_5 : ( ruleAbstractRule ) ;
    public final void rule__Grammar__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4853:1: ( ( ruleAbstractRule ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4854:1: ( ruleAbstractRule )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4854:1: ( ruleAbstractRule )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4855:1: ruleAbstractRule
            {
             before(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleAbstractRule_in_rule__Grammar__RulesAssignment_59696);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4864:1: rule__GeneratedMetamodel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4868:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4869:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4869:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4870:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__NameAssignment_19727); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4879:1: rule__GeneratedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__GeneratedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4883:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4884:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4884:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4885:1: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4886:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4887:1: RULE_STRING
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__EPackageAssignment_29762); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4898:1: rule__GeneratedMetamodel__AliasAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__AliasAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4902:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4903:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4903:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4904:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__AliasAssignment_3_19797); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4913:1: rule__ReferencedMetamodel__EPackageAssignment_1 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4917:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4918:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4918:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4919:1: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4920:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4921:1: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_19832); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4932:1: rule__ReferencedMetamodel__AliasAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4936:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4937:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4937:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4938:1: RULE_ID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_2_19867); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4947:1: rule__ParserRule__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParserRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4951:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4952:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4952:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4953:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParserRule__NameAssignment_09898); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4962:1: rule__ParserRule__TypeAssignment_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4966:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4967:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4967:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4968:1: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleTypeRef_in_rule__ParserRule__TypeAssignment_1_19929);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4977:1: rule__ParserRule__DefinesHiddenTokensAssignment_2_0 : ( ( 'hidden' ) ) ;
    public final void rule__ParserRule__DefinesHiddenTokensAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4981:1: ( ( ( 'hidden' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4982:1: ( ( 'hidden' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4982:1: ( ( 'hidden' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4983:1: ( 'hidden' )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4984:1: ( 'hidden' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:4985:1: 'hidden'
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            match(input,41,FOLLOW_41_in_rule__ParserRule__DefinesHiddenTokensAssignment_2_09965); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5000:1: rule__ParserRule__HiddenTokensAssignment_2_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5004:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5005:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5005:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5006:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5007:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5008:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_010008); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5019:1: rule__ParserRule__HiddenTokensAssignment_2_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5023:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5024:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5024:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5025:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5026:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5027:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_1_110047); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5038:1: rule__ParserRule__AlternativesAssignment_4 : ( ruleAlternatives ) ;
    public final void rule__ParserRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5042:1: ( ( ruleAlternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5043:1: ( ruleAlternatives )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5043:1: ( ruleAlternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5044:1: ruleAlternatives
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleAlternatives_in_rule__ParserRule__AlternativesAssignment_410082);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5053:1: rule__TypeRef__MetamodelAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__MetamodelAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5057:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5058:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5058:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5059:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5060:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5061:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeRef__MetamodelAssignment_0_010117); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5072:1: rule__TypeRef__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5076:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5077:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5077:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5078:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5079:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5080:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeRef__ClassifierAssignment_110156); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5091:1: rule__Alternatives__GroupsAssignment_1_1_1 : ( ruleGroup ) ;
    public final void rule__Alternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5095:1: ( ( ruleGroup ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5096:1: ( ruleGroup )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5096:1: ( ruleGroup )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5097:1: ruleGroup
            {
             before(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleGroup_in_rule__Alternatives__GroupsAssignment_1_1_110191);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5106:1: rule__Group__TokensAssignment_1_1 : ( ruleAbstractToken ) ;
    public final void rule__Group__TokensAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5110:1: ( ( ruleAbstractToken ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5111:1: ( ruleAbstractToken )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5111:1: ( ruleAbstractToken )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5112:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleAbstractToken_in_rule__Group__TokensAssignment_1_110222);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5121:1: rule__AbstractTokenWithCardinality__CardinalityAssignment_1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5125:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5126:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5126:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5127:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5128:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5128:2: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
            {
            pushFollow(FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__CardinalityAssignment_110253);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5137:1: rule__Action__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Action__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5141:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5142:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5142:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5143:1: ruleTypeRef
            {
             before(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTypeRef_in_rule__Action__TypeAssignment_110286);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5152:1: rule__Action__FeatureAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Action__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5156:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5157:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5157:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5158:1: RULE_ID
            {
             before(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Action__FeatureAssignment_2_110317); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5167:1: rule__Action__OperatorAssignment_2_2 : ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ;
    public final void rule__Action__OperatorAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5171:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5172:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5172:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5173:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5174:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5174:2: rule__Action__OperatorAlternatives_2_2_0
            {
            pushFollow(FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__OperatorAssignment_2_210348);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5183:1: rule__Keyword__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Keyword__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5187:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5188:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5188:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5189:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Keyword__ValueAssignment10381); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5198:1: rule__RuleCall__RuleAssignment : ( ( RULE_ID ) ) ;
    public final void rule__RuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5202:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5203:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5203:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5204:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5205:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5206:1: RULE_ID
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RuleCall__RuleAssignment10416); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5217:1: rule__Assignment__FeatureAssignment_0 : ( RULE_ID ) ;
    public final void rule__Assignment__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5221:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5222:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5222:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5223:1: RULE_ID
            {
             before(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Assignment__FeatureAssignment_010451); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5232:1: rule__Assignment__OperatorAssignment_1 : ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) ;
    public final void rule__Assignment__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5236:1: ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5237:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5237:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5238:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5239:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5239:2: rule__Assignment__OperatorAlternatives_1_0
            {
            pushFollow(FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__OperatorAssignment_110482);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5248:1: rule__Assignment__TerminalAssignment_2 : ( ruleAssignableTerminal ) ;
    public final void rule__Assignment__TerminalAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5252:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5253:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5253:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5254:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleAssignableTerminal_in_rule__Assignment__TerminalAssignment_210515);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5263:1: rule__AssignableAlternatives__GroupsAssignment_1_1_1 : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5267:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5268:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5268:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5269:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__GroupsAssignment_1_1_110546);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5278:1: rule__CrossReference__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__CrossReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5282:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5283:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5283:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5284:1: ruleTypeRef
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTypeRef_in_rule__CrossReference__TypeAssignment_110577);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5293:1: rule__CrossReference__TerminalAssignment_2_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReference__TerminalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5297:1: ( ( ruleCrossReferenceableTerminal ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5298:1: ( ruleCrossReferenceableTerminal )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5298:1: ( ruleCrossReferenceableTerminal )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5299:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__TerminalAssignment_2_110608);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5308:1: rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5312:1: ( ( ruleCrossReferenceableTerminal ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5313:1: ( ruleCrossReferenceableTerminal )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5313:1: ( ruleCrossReferenceableTerminal )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5314:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsCrossReferenceableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_110639);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5323:1: rule__TerminalRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TerminalRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5327:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5328:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5328:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5329:1: RULE_ID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_110670); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5338:1: rule__TerminalRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__TerminalRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5342:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5343:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5343:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5344:1: ruleTypeRef
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleTypeRef_in_rule__TerminalRule__TypeAssignment_2_110701);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5353:1: rule__TerminalRule__AlternativesAssignment_4 : ( ruleTerminalAlternatives ) ;
    public final void rule__TerminalRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5357:1: ( ( ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5358:1: ( ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5358:1: ( ruleTerminalAlternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5359:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__AlternativesAssignment_410732);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5368:1: rule__TerminalAlternatives__GroupsAssignment_1_1_1 : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5372:1: ( ( ruleTerminalGroup ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5373:1: ( ruleTerminalGroup )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5373:1: ( ruleTerminalGroup )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5374:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__GroupsAssignment_1_1_110763);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5383:1: rule__TerminalGroup__TokensAssignment_1_1 : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__TokensAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5387:1: ( ( ruleTerminalToken ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5388:1: ( ruleTerminalToken )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5388:1: ( ruleTerminalToken )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5389:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__TokensAssignment_1_110794);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5398:1: rule__TerminalToken__CardinalityAssignment_1 : ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__TerminalToken__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5402:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5403:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5403:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5404:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5405:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5405:2: rule__TerminalToken__CardinalityAlternatives_1_0
            {
            pushFollow(FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__CardinalityAssignment_110825);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5414:1: rule__NegatedToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__NegatedToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5418:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5419:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5419:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5420:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__TerminalAssignment_110858);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5429:1: rule__UntilToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__UntilToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5433:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5434:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5434:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5435:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__TerminalAssignment_110889);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5444:1: rule__CharacterRange__RightAssignment_1_2 : ( ruleKeyword ) ;
    public final void rule__CharacterRange__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5448:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5449:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5449:1: ( ruleKeyword )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5450:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__CharacterRange__RightAssignment_1_210920);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5459:1: rule__EnumRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5463:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5464:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5464:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5465:1: RULE_ID
            {
             before(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EnumRule__NameAssignment_110951); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5474:1: rule__EnumRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__EnumRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5478:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5479:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5479:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5480:1: ruleTypeRef
            {
             before(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleTypeRef_in_rule__EnumRule__TypeAssignment_2_110982);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5489:1: rule__EnumRule__AlternativesAssignment_4 : ( ruleEnumLiterals ) ;
    public final void rule__EnumRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5493:1: ( ( ruleEnumLiterals ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5494:1: ( ruleEnumLiterals )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5494:1: ( ruleEnumLiterals )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5495:1: ruleEnumLiterals
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleEnumLiterals_in_rule__EnumRule__AlternativesAssignment_411013);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5504:1: rule__EnumLiterals__GroupsAssignment_1_1_1 : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5508:1: ( ( ruleEnumLiteralDeclaration ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5509:1: ( ruleEnumLiteralDeclaration )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5509:1: ( ruleEnumLiteralDeclaration )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5510:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__GroupsAssignment_1_1_111044);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5519:1: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumLiteralDeclaration__EnumLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5523:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5524:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5524:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5525:1: ( RULE_ID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5526:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5527:1: RULE_ID
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__EnumLiteralAssignment_011079); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5538:1: rule__EnumLiteralDeclaration__LiteralAssignment_1_1 : ( ruleKeyword ) ;
    public final void rule__EnumLiteralDeclaration__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5542:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5543:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5543:1: ( ruleKeyword )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtextGrammarTestLanguage.g:5544:1: ruleKeyword
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__LiteralAssignment_1_111114);
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


 

    public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammar67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__Group__0_in_ruleGrammar94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GrammarID__Group__0_in_ruleGrammarID154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractMetamodelDeclaration__Alternatives_in_ruleAbstractMetamodelDeclaration274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__0_in_ruleGeneratedMetamodel334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__0_in_ruleReferencedMetamodel394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParserRule__Group__0_in_ruleParserRule454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRef__Group__0_in_ruleTypeRef514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alternatives__Group__0_in_ruleAlternatives574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group__0_in_ruleGroup634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__0_in_ruleAbstractTokenWithCardinality754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Action__Group__0_in_ruleAction814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keyword__ValueAssignment_in_ruleKeyword934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleCall__RuleAssignment_in_ruleRuleCall994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment1020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__Group__0_in_ruleAssignment1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__0_in_ruleParenthesizedAssignableElement1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__0_in_ruleAssignableAlternatives1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference1260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReference__Group__0_in_ruleCrossReference1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement1380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__0_in_ruleParenthesizedCrossReferenceableElement1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives1440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group__0_in_ruleCrossReferenceableAlternatives1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement1507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__0_in_ruleParenthesizedElement1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1560 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalRule__Group__0_in_ruleTerminalRule1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives1627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__0_in_ruleTerminalAlternatives1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1680 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalGroup__Group__0_in_ruleTerminalGroup1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken1747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalToken__Group__0_in_ruleTerminalToken1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement1867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__0_in_ruleParenthesizedTerminalElement1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1980 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NegatedToken__Group__0_in_ruleNegatedToken2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken2040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UntilToken__Group__0_in_ruleUntilToken2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard2100 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard2107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Wildcard__Group__0_in_ruleWildcard2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CharacterRange__Group__0_in_ruleCharacterRange2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule2220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumRule__Group__0_in_ruleEnumRule2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2280 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals2287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumLiterals__Group__0_in_ruleEnumLiterals2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration2347 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_17_in_rule__Grammar__Group__03270 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Grammar__Group__1_in_rule__Grammar__Group__03280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__NameAssignment_1_in_rule__Grammar__Group__13308 = new BitSet(new long[]{0x0000031002840010L});
    public static final BitSet FOLLOW_rule__Grammar__Group__2_in_rule__Grammar__Group__13317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__Group_2__0_in_rule__Grammar__Group__23345 = new BitSet(new long[]{0x0000031002800010L});
    public static final BitSet FOLLOW_rule__Grammar__Group__3_in_rule__Grammar__Group__23355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__Group_3__0_in_rule__Grammar__Group__33383 = new BitSet(new long[]{0x0000011002800010L});
    public static final BitSet FOLLOW_rule__Grammar__Group__4_in_rule__Grammar__Group__33393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__MetamodelDeclarationsAssignment_4_in_rule__Grammar__Group__43421 = new BitSet(new long[]{0x0000011002800010L});
    public static final BitSet FOLLOW_rule__Grammar__Group__5_in_rule__Grammar__Group__43431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__53461 = new BitSet(new long[]{0x0000011000000012L});
    public static final BitSet FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__53473 = new BitSet(new long[]{0x0000011000000012L});
    public static final BitSet FOLLOW_18_in_rule__Grammar__Group_2__03523 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Grammar__Group_2__1_in_rule__Grammar__Group_2__03533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_1_in_rule__Grammar__Group_2__13561 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__Grammar__Group_2__2_in_rule__Grammar__Group_2__13570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__Group_2_2__0_in_rule__Grammar__Group_2__23598 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_rule__Grammar__Group_2_2__03640 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Grammar__Group_2_2__1_in_rule__Grammar__Group_2_2__03650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_2_1_in_rule__Grammar__Group_2_2__13678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__DefinesHiddenTokensAssignment_3_0_in_rule__Grammar__Group_3__03716 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Grammar__Group_3__1_in_rule__Grammar__Group_3__03725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Grammar__Group_3__13754 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_rule__Grammar__Group_3__2_in_rule__Grammar__Group_3__13764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__Group_3_2__0_in_rule__Grammar__Group_3__23792 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Grammar__Group_3__3_in_rule__Grammar__Group_3__23802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Grammar__Group_3__33831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_0_in_rule__Grammar__Group_3_2__03874 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__Grammar__Group_3_2__1_in_rule__Grammar__Group_3_2__03883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__0_in_rule__Grammar__Group_3_2__13911 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_rule__Grammar__Group_3_2_1__03951 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__1_in_rule__Grammar__Group_3_2_1__03961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_1_1_in_rule__Grammar__Group_3_2_1__13989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group__04027 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__GrammarID__Group__1_in_rule__GrammarID__Group__04035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GrammarID__Group_1__0_in_rule__GrammarID__Group__14063 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_rule__GrammarID__Group_1__04103 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__GrammarID__Group_1__1_in_rule__GrammarID__Group_1__04113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group_1__14141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__GeneratedMetamodel__Group__04179 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__1_in_rule__GeneratedMetamodel__Group__04189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GeneratedMetamodel__NameAssignment_1_in_rule__GeneratedMetamodel__Group__14217 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__2_in_rule__GeneratedMetamodel__Group__14226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GeneratedMetamodel__EPackageAssignment_2_in_rule__GeneratedMetamodel__Group__24254 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__3_in_rule__GeneratedMetamodel__Group__24263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__0_in_rule__GeneratedMetamodel__Group__34291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__GeneratedMetamodel__Group_3__04335 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__1_in_rule__GeneratedMetamodel__Group_3__04345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GeneratedMetamodel__AliasAssignment_3_1_in_rule__GeneratedMetamodel__Group_3__14373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ReferencedMetamodel__Group__04412 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__04422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_1_in_rule__ReferencedMetamodel__Group__14450 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__14459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__0_in_rule__ReferencedMetamodel__Group__24487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ReferencedMetamodel__Group_2__04529 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__1_in_rule__ReferencedMetamodel__Group_2__04539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencedMetamodel__AliasAssignment_2_1_in_rule__ReferencedMetamodel__Group_2__14567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParserRule__NameAssignment_0_in_rule__ParserRule__Group__04605 = new BitSet(new long[]{0x0000020014000000L});
    public static final BitSet FOLLOW_rule__ParserRule__Group__1_in_rule__ParserRule__Group__04614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_1__0_in_rule__ParserRule__Group__14642 = new BitSet(new long[]{0x0000020004000000L});
    public static final BitSet FOLLOW_rule__ParserRule__Group__2_in_rule__ParserRule__Group__14652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_2__0_in_rule__ParserRule__Group__24680 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ParserRule__Group__3_in_rule__ParserRule__Group__24690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ParserRule__Group__34719 = new BitSet(new long[]{0x0000000080100030L});
    public static final BitSet FOLLOW_rule__ParserRule__Group__4_in_rule__ParserRule__Group__34729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParserRule__AlternativesAssignment_4_in_rule__ParserRule__Group__44757 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__ParserRule__Group__5_in_rule__ParserRule__Group__44766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ParserRule__Group__54795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ParserRule__Group_1__04843 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_1__1_in_rule__ParserRule__Group_1__04853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParserRule__TypeAssignment_1_1_in_rule__ParserRule__Group_1__14881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParserRule__DefinesHiddenTokensAssignment_2_0_in_rule__ParserRule__Group_2__04919 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_2__1_in_rule__ParserRule__Group_2__04928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ParserRule__Group_2__14957 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_2__2_in_rule__ParserRule__Group_2__14967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__0_in_rule__ParserRule__Group_2__24995 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_2__3_in_rule__ParserRule__Group_2__25005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ParserRule__Group_2__35034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_0_in_rule__ParserRule__Group_2_2__05077 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__1_in_rule__ParserRule__Group_2_2__05086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__0_in_rule__ParserRule__Group_2_2__15114 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_rule__ParserRule__Group_2_2_1__05154 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__1_in_rule__ParserRule__Group_2_2_1__05164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_1_1_in_rule__ParserRule__Group_2_2_1__15192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRef__Group_0__0_in_rule__TypeRef__Group__05230 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TypeRef__Group__1_in_rule__TypeRef__Group__05240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRef__ClassifierAssignment_1_in_rule__TypeRef__Group__15268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRef__MetamodelAssignment_0_0_in_rule__TypeRef__Group_0__05306 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__TypeRef__Group_0__1_in_rule__TypeRef__Group_0__05315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__TypeRef__Group_0__15344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_rule__Alternatives__Group__05383 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__Alternatives__Group__1_in_rule__Alternatives__Group__05391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alternatives__Group_1__0_in_rule__Alternatives__Group__15419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alternatives__Group_1__1_in_rule__Alternatives__Group_1__05468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__15498 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__15510 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_rule__Alternatives__Group_1_1__05552 = new BitSet(new long[]{0x0000000080100030L});
    public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__1_in_rule__Alternatives__Group_1_1__05562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alternatives__GroupsAssignment_1_1_1_in_rule__Alternatives__Group_1_1__15590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__Group__05628 = new BitSet(new long[]{0x0000000080100032L});
    public static final BitSet FOLLOW_rule__Group__Group__1_in_rule__Group__Group__05636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group_1__0_in_rule__Group__Group__15664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group_1__1_in_rule__Group__Group_1__05713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__15743 = new BitSet(new long[]{0x0000000080100032L});
    public static final BitSet FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__15755 = new BitSet(new long[]{0x0000000080100032L});
    public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group__05796 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__1_in_rule__AbstractTokenWithCardinality__Group__05805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAssignment_1_in_rule__AbstractTokenWithCardinality__Group__15833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Action__Group__05873 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Action__Group__1_in_rule__Action__Group__05883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Action__TypeAssignment_1_in_rule__Action__Group__15911 = new BitSet(new long[]{0x0000000100400000L});
    public static final BitSet FOLLOW_rule__Action__Group__2_in_rule__Action__Group__15920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Action__Group_2__0_in_rule__Action__Group__25948 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Action__Group__3_in_rule__Action__Group__25958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Action__Group__35987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Action__Group_2__06031 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Action__Group_2__1_in_rule__Action__Group_2__06041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Action__FeatureAssignment_2_1_in_rule__Action__Group_2__16069 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_rule__Action__Group_2__2_in_rule__Action__Group_2__16078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Action__OperatorAssignment_2_2_in_rule__Action__Group_2__26106 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Action__Group_2__3_in_rule__Action__Group_2__26115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Action__Group_2__36144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__FeatureAssignment_0_in_rule__Assignment__Group__06187 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_rule__Assignment__Group__1_in_rule__Assignment__Group__06196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__OperatorAssignment_1_in_rule__Assignment__Group__16224 = new BitSet(new long[]{0x0000000400100030L});
    public static final BitSet FOLLOW_rule__Assignment__Group__2_in_rule__Assignment__Group__16233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__TerminalAssignment_2_in_rule__Assignment__Group__26261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ParenthesizedAssignableElement__Group__06302 = new BitSet(new long[]{0x0000000400100030L});
    public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__1_in_rule__ParenthesizedAssignableElement__Group__06312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group__16340 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__2_in_rule__ParenthesizedAssignableElement__Group__16348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group__26377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group__06418 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__1_in_rule__AssignableAlternatives__Group__06426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__0_in_rule__AssignableAlternatives__Group__16454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__1_in_rule__AssignableAlternatives__Group_1__06503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__16533 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__16545 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_rule__AssignableAlternatives__Group_1_1__06587 = new BitSet(new long[]{0x0000000400100030L});
    public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__1_in_rule__AssignableAlternatives__Group_1_1__06597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignableAlternatives__GroupsAssignment_1_1_1_in_rule__AssignableAlternatives__Group_1_1__16625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__CrossReference__Group__06664 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CrossReference__Group__1_in_rule__CrossReference__Group__06674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReference__TypeAssignment_1_in_rule__CrossReference__Group__16702 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_rule__CrossReference__Group__2_in_rule__CrossReference__Group__16711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReference__Group_2__0_in_rule__CrossReference__Group__26739 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__CrossReference__Group__3_in_rule__CrossReference__Group__26749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__CrossReference__Group__36778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__CrossReference__Group_2__06822 = new BitSet(new long[]{0x0000000000100030L});
    public static final BitSet FOLLOW_rule__CrossReference__Group_2__1_in_rule__CrossReference__Group_2__06832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReference__TerminalAssignment_2_1_in_rule__CrossReference__Group_2__16860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ParenthesizedCrossReferenceableElement__Group__06899 = new BitSet(new long[]{0x0000000000100030L});
    public static final BitSet FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__1_in_rule__ParenthesizedCrossReferenceableElement__Group__06909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_rule__ParenthesizedCrossReferenceableElement__Group__16937 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group__2_in_rule__ParenthesizedCrossReferenceableElement__Group__16945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ParenthesizedCrossReferenceableElement__Group__26974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReferenceableAlternatives__Group__07015 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group__1_in_rule__CrossReferenceableAlternatives__Group__07023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1__0_in_rule__CrossReferenceableAlternatives__Group__17051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1__1_in_rule__CrossReferenceableAlternatives__Group_1__07100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__0_in_rule__CrossReferenceableAlternatives__Group_1__17130 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__0_in_rule__CrossReferenceableAlternatives__Group_1__17142 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_rule__CrossReferenceableAlternatives__Group_1_1__07184 = new BitSet(new long[]{0x0000000000100030L});
    public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1__1_in_rule__CrossReferenceableAlternatives__Group_1_1__07194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_1_in_rule__CrossReferenceableAlternatives__Group_1_1__17222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ParenthesizedElement__Group__07261 = new BitSet(new long[]{0x0000000080100030L});
    public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__1_in_rule__ParenthesizedElement__Group__07271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group__17299 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__2_in_rule__ParenthesizedElement__Group__17307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ParenthesizedElement__Group__27336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__TerminalRule__Group__07378 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TerminalRule__Group__1_in_rule__TerminalRule__Group__07388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalRule__NameAssignment_1_in_rule__TerminalRule__Group__17416 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_rule__TerminalRule__Group__2_in_rule__TerminalRule__Group__17425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalRule__Group_2__0_in_rule__TerminalRule__Group__27453 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__TerminalRule__Group__3_in_rule__TerminalRule__Group__27463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__TerminalRule__Group__37492 = new BitSet(new long[]{0x0000006000500030L});
    public static final BitSet FOLLOW_rule__TerminalRule__Group__4_in_rule__TerminalRule__Group__37502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalRule__AlternativesAssignment_4_in_rule__TerminalRule__Group__47530 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__TerminalRule__Group__5_in_rule__TerminalRule__Group__47539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__TerminalRule__Group__57568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__TerminalRule__Group_2__07616 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TerminalRule__Group_2__1_in_rule__TerminalRule__Group_2__07626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalRule__TypeAssignment_2_1_in_rule__TerminalRule__Group_2__17654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group__07692 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__1_in_rule__TerminalAlternatives__Group__07700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__0_in_rule__TerminalAlternatives__Group__17728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__1_in_rule__TerminalAlternatives__Group_1__07777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__17807 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__17819 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_rule__TerminalAlternatives__Group_1_1__07861 = new BitSet(new long[]{0x0000006000500030L});
    public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__1_in_rule__TerminalAlternatives__Group_1_1__07871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalAlternatives__GroupsAssignment_1_1_1_in_rule__TerminalAlternatives__Group_1_1__17899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group__07937 = new BitSet(new long[]{0x0000006000500032L});
    public static final BitSet FOLLOW_rule__TerminalGroup__Group__1_in_rule__TerminalGroup__Group__07945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__0_in_rule__TerminalGroup__Group__17973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__1_in_rule__TerminalGroup__Group_1__08022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__18052 = new BitSet(new long[]{0x0000006000500032L});
    public static final BitSet FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__18064 = new BitSet(new long[]{0x0000006000500032L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group__08105 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_rule__TerminalToken__Group__1_in_rule__TerminalToken__Group__08113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAssignment_1_in_rule__TerminalToken__Group__18141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ParenthesizedTerminalElement__Group__08181 = new BitSet(new long[]{0x0000006000500030L});
    public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__1_in_rule__ParenthesizedTerminalElement__Group__08191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group__18219 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__2_in_rule__ParenthesizedTerminalElement__Group__18227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group__28256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__NegatedToken__Group__08298 = new BitSet(new long[]{0x0000006000500030L});
    public static final BitSet FOLLOW_rule__NegatedToken__Group__1_in_rule__NegatedToken__Group__08308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NegatedToken__TerminalAssignment_1_in_rule__NegatedToken__Group__18336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__UntilToken__Group__08375 = new BitSet(new long[]{0x0000006000500030L});
    public static final BitSet FOLLOW_rule__UntilToken__Group__1_in_rule__UntilToken__Group__08385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UntilToken__TerminalAssignment_1_in_rule__UntilToken__Group__18413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Wildcard__Group__1_in_rule__Wildcard__Group__08461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Wildcard__Group__18490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__Group__08529 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_rule__CharacterRange__Group__1_in_rule__CharacterRange__Group__08537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CharacterRange__Group_1__0_in_rule__CharacterRange__Group__18565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CharacterRange__Group_1__1_in_rule__CharacterRange__Group_1__08614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__CharacterRange__Group_1__18643 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__CharacterRange__Group_1__2_in_rule__CharacterRange__Group_1__18653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CharacterRange__RightAssignment_1_2_in_rule__CharacterRange__Group_1__28681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__EnumRule__Group__08722 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EnumRule__Group__1_in_rule__EnumRule__Group__08732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumRule__NameAssignment_1_in_rule__EnumRule__Group__18760 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_rule__EnumRule__Group__2_in_rule__EnumRule__Group__18769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumRule__Group_2__0_in_rule__EnumRule__Group__28797 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__EnumRule__Group__3_in_rule__EnumRule__Group__28807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__EnumRule__Group__38836 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EnumRule__Group__4_in_rule__EnumRule__Group__38846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumRule__AlternativesAssignment_4_in_rule__EnumRule__Group__48874 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__EnumRule__Group__5_in_rule__EnumRule__Group__48883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__EnumRule__Group__58912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__EnumRule__Group_2__08960 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EnumRule__Group_2__1_in_rule__EnumRule__Group_2__08970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumRule__TypeAssignment_2_1_in_rule__EnumRule__Group_2__18998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group__09036 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__EnumLiterals__Group__1_in_rule__EnumLiterals__Group__09044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__0_in_rule__EnumLiterals__Group__19072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__1_in_rule__EnumLiterals__Group_1__09121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__19151 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__19163 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_rule__EnumLiterals__Group_1_1__09205 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__1_in_rule__EnumLiterals__Group_1_1__09215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumLiterals__GroupsAssignment_1_1_1_in_rule__EnumLiterals__Group_1_1__19243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__EnumLiteralAssignment_0_in_rule__EnumLiteralDeclaration__Group__09281 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__1_in_rule__EnumLiteralDeclaration__Group__09290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__0_in_rule__EnumLiteralDeclaration__Group__19318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_1__09358 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__1_in_rule__EnumLiteralDeclaration__Group_1__09368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__LiteralAssignment_1_1_in_rule__EnumLiteralDeclaration__Group_1__19396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__NameAssignment_19434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_19469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_2_19508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Grammar__DefinesHiddenTokensAssignment_3_09548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_09591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_1_19630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__MetamodelDeclarationsAssignment_49665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_rule__Grammar__RulesAssignment_59696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__NameAssignment_19727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__EPackageAssignment_29762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__AliasAssignment_3_19797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_19832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_2_19867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__NameAssignment_09898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_rule__ParserRule__TypeAssignment_1_19929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ParserRule__DefinesHiddenTokensAssignment_2_09965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_010008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_1_110047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParserRule__AlternativesAssignment_410082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__MetamodelAssignment_0_010117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__ClassifierAssignment_110156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_rule__Alternatives__GroupsAssignment_1_1_110191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__TokensAssignment_1_110222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__CardinalityAssignment_110253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_rule__Action__TypeAssignment_110286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Action__FeatureAssignment_2_110317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__OperatorAssignment_2_210348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__ValueAssignment10381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RuleCall__RuleAssignment10416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Assignment__FeatureAssignment_010451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__OperatorAssignment_110482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__Assignment__TerminalAssignment_210515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__GroupsAssignment_1_1_110546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_rule__CrossReference__TypeAssignment_110577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__TerminalAssignment_2_110608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReferenceableAlternatives__GroupsAssignment_1_1_110639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_110670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_rule__TerminalRule__TypeAssignment_2_110701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__AlternativesAssignment_410732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__GroupsAssignment_1_1_110763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__TokensAssignment_1_110794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__CardinalityAssignment_110825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__TerminalAssignment_110858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__TerminalAssignment_110889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__RightAssignment_1_210920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EnumRule__NameAssignment_110951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_rule__EnumRule__TypeAssignment_2_110982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumLiterals_in_rule__EnumRule__AlternativesAssignment_411013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__GroupsAssignment_1_1_111044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__EnumLiteralAssignment_011079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__LiteralAssignment_1_111114 = new BitSet(new long[]{0x0000000000000002L});

}
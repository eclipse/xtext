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
import org.eclipse.xtext.services.XtextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'?'", "'*'", "'+'", "'='", "'+='", "'?='", "'grammar'", "'with'", "','", "'hidden'", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "':'", "';'", "'returns'", "'::'", "'|'", "'{'", "'}'", "'current'", "'['", "']'", "'terminal'", "'!'", "'->'", "'..'", "'enum'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalXtextParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g"; }


     
     	private XtextGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(XtextGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }




    // $ANTLR start entryRuleGrammar
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:55:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:55:18: ( ruleGrammar EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:56:1: ruleGrammar EOF
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:63:1: ruleGrammar : ( ( rule__Grammar__Group ) ) ;
    public final void ruleGrammar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:67:2: ( ( ( rule__Grammar__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:68:1: ( ( rule__Grammar__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:68:1: ( ( rule__Grammar__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:69:1: ( rule__Grammar__Group )
            {
             before(grammarAccess.getGrammarAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:70:1: ( rule__Grammar__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:70:2: rule__Grammar__Group
            {
            pushFollow(FOLLOW_rule__Grammar__Group_in_ruleGrammar94);
            rule__Grammar__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:81:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:81:20: ( ruleGrammarID EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:82:1: ruleGrammarID EOF
            {
             before(grammarAccess.getGrammarIDRule()); 
            pushFollow(FOLLOW_ruleGrammarID_in_entryRuleGrammarID119);
            ruleGrammarID();
            _fsp--;

             after(grammarAccess.getGrammarIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammarID126); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:89:1: ruleGrammarID : ( ( rule__GrammarID__Group ) ) ;
    public final void ruleGrammarID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:93:2: ( ( ( rule__GrammarID__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:94:1: ( ( rule__GrammarID__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:94:1: ( ( rule__GrammarID__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:95:1: ( rule__GrammarID__Group )
            {
             before(grammarAccess.getGrammarIDAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:96:1: ( rule__GrammarID__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:96:2: rule__GrammarID__Group
            {
            pushFollow(FOLLOW_rule__GrammarID__Group_in_ruleGrammarID153);
            rule__GrammarID__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:107:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:107:23: ( ruleAbstractRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:108:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule178);
            ruleAbstractRule();
            _fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule185); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:115:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:119:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:120:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:120:1: ( ( rule__AbstractRule__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:121:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:122:1: ( rule__AbstractRule__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:122:2: rule__AbstractRule__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule212);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:133:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:133:39: ( ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:134:1: ruleAbstractMetamodelDeclaration EOF
            {
             before(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration237);
            ruleAbstractMetamodelDeclaration();
            _fsp--;

             after(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration244); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:141:1: ruleAbstractMetamodelDeclaration : ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:145:2: ( ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:146:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:146:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:147:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            {
             before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:148:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:148:2: rule__AbstractMetamodelDeclaration__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractMetamodelDeclaration__Alternatives_in_ruleAbstractMetamodelDeclaration271);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:159:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:159:29: ( ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:160:1: ruleGeneratedMetamodel EOF
            {
             before(grammarAccess.getGeneratedMetamodelRule()); 
            pushFollow(FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel296);
            ruleGeneratedMetamodel();
            _fsp--;

             after(grammarAccess.getGeneratedMetamodelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratedMetamodel303); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:167:1: ruleGeneratedMetamodel : ( ( rule__GeneratedMetamodel__Group ) ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:171:2: ( ( ( rule__GeneratedMetamodel__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:172:1: ( ( rule__GeneratedMetamodel__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:172:1: ( ( rule__GeneratedMetamodel__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:173:1: ( rule__GeneratedMetamodel__Group )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:174:1: ( rule__GeneratedMetamodel__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:174:2: rule__GeneratedMetamodel__Group
            {
            pushFollow(FOLLOW_rule__GeneratedMetamodel__Group_in_ruleGeneratedMetamodel330);
            rule__GeneratedMetamodel__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:185:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:185:30: ( ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:186:1: ruleReferencedMetamodel EOF
            {
             before(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel355);
            ruleReferencedMetamodel();
            _fsp--;

             after(grammarAccess.getReferencedMetamodelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel362); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:193:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:197:2: ( ( ( rule__ReferencedMetamodel__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:198:1: ( ( rule__ReferencedMetamodel__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:198:1: ( ( rule__ReferencedMetamodel__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:199:1: ( rule__ReferencedMetamodel__Group )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:200:1: ( rule__ReferencedMetamodel__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:200:2: rule__ReferencedMetamodel__Group
            {
            pushFollow(FOLLOW_rule__ReferencedMetamodel__Group_in_ruleReferencedMetamodel389);
            rule__ReferencedMetamodel__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:211:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:211:21: ( ruleParserRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:212:1: ruleParserRule EOF
            {
             before(grammarAccess.getParserRuleRule()); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule414);
            ruleParserRule();
            _fsp--;

             after(grammarAccess.getParserRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule421); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:219:1: ruleParserRule : ( ( rule__ParserRule__Group ) ) ;
    public final void ruleParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:223:2: ( ( ( rule__ParserRule__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:224:1: ( ( rule__ParserRule__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:224:1: ( ( rule__ParserRule__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:225:1: ( rule__ParserRule__Group )
            {
             before(grammarAccess.getParserRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:226:1: ( rule__ParserRule__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:226:2: rule__ParserRule__Group
            {
            pushFollow(FOLLOW_rule__ParserRule__Group_in_ruleParserRule448);
            rule__ParserRule__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:237:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:237:18: ( ruleTypeRef EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:238:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef473);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getTypeRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef480); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:245:1: ruleTypeRef : ( ( rule__TypeRef__Group ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:249:2: ( ( ( rule__TypeRef__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:250:1: ( ( rule__TypeRef__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:250:1: ( ( rule__TypeRef__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:251:1: ( rule__TypeRef__Group )
            {
             before(grammarAccess.getTypeRefAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:252:1: ( rule__TypeRef__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:252:2: rule__TypeRef__Group
            {
            pushFollow(FOLLOW_rule__TypeRef__Group_in_ruleTypeRef507);
            rule__TypeRef__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:263:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:263:23: ( ruleAlternatives EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:264:1: ruleAlternatives EOF
            {
             before(grammarAccess.getAlternativesRule()); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives532);
            ruleAlternatives();
            _fsp--;

             after(grammarAccess.getAlternativesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives539); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:271:1: ruleAlternatives : ( ( rule__Alternatives__Group ) ) ;
    public final void ruleAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:275:2: ( ( ( rule__Alternatives__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:276:1: ( ( rule__Alternatives__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:276:1: ( ( rule__Alternatives__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:277:1: ( rule__Alternatives__Group )
            {
             before(grammarAccess.getAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:278:1: ( rule__Alternatives__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:278:2: rule__Alternatives__Group
            {
            pushFollow(FOLLOW_rule__Alternatives__Group_in_ruleAlternatives566);
            rule__Alternatives__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:289:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:289:16: ( ruleGroup EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:290:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup591);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getGroupRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup598); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:297:1: ruleGroup : ( ( rule__Group__Group ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:301:2: ( ( ( rule__Group__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:302:1: ( ( rule__Group__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:302:1: ( ( rule__Group__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:303:1: ( rule__Group__Group )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:304:1: ( rule__Group__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:304:2: rule__Group__Group
            {
            pushFollow(FOLLOW_rule__Group__Group_in_ruleGroup625);
            rule__Group__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:315:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:315:24: ( ruleAbstractToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:316:1: ruleAbstractToken EOF
            {
             before(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken650);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getAbstractTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken657); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:323:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:327:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:328:1: ( ( rule__AbstractToken__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:328:1: ( ( rule__AbstractToken__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:329:1: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:330:1: ( rule__AbstractToken__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:330:2: rule__AbstractToken__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken684);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:341:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:341:39: ( ruleAbstractTokenWithCardinality EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:342:1: ruleAbstractTokenWithCardinality EOF
            {
             before(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality709);
            ruleAbstractTokenWithCardinality();
            _fsp--;

             after(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality716); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:349:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:353:2: ( ( ( rule__AbstractTokenWithCardinality__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:354:1: ( ( rule__AbstractTokenWithCardinality__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:354:1: ( ( rule__AbstractTokenWithCardinality__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:355:1: ( rule__AbstractTokenWithCardinality__Group )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:356:1: ( rule__AbstractTokenWithCardinality__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:356:2: rule__AbstractTokenWithCardinality__Group
            {
            pushFollow(FOLLOW_rule__AbstractTokenWithCardinality__Group_in_ruleAbstractTokenWithCardinality743);
            rule__AbstractTokenWithCardinality__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:367:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:367:17: ( ruleAction EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:368:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction768);
            ruleAction();
            _fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction775); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:375:1: ruleAction : ( ( rule__Action__Group ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:379:2: ( ( ( rule__Action__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:380:1: ( ( rule__Action__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:380:1: ( ( rule__Action__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:381:1: ( rule__Action__Group )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:382:1: ( rule__Action__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:382:2: rule__Action__Group
            {
            pushFollow(FOLLOW_rule__Action__Group_in_ruleAction802);
            rule__Action__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:393:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:393:27: ( ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:394:1: ruleAbstractTerminal EOF
            {
             before(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal827);
            ruleAbstractTerminal();
            _fsp--;

             after(grammarAccess.getAbstractTerminalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal834); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:401:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:405:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:406:1: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:406:1: ( ( rule__AbstractTerminal__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:407:1: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:408:1: ( rule__AbstractTerminal__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:408:2: rule__AbstractTerminal__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal861);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:419:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:419:18: ( ruleKeyword EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:420:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword886);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword893); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:427:1: ruleKeyword : ( ( ( RULE_STRING ) ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:431:2: ( ( ( ( RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:432:1: ( ( ( RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:432:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:433:1: ( ( RULE_STRING ) )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:434:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:435:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:435:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:436:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword927); 
             after(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 

            }


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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:451:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:451:19: ( ruleRuleCall EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:452:1: ruleRuleCall EOF
            {
             before(grammarAccess.getRuleCallRule()); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall958);
            ruleRuleCall();
            _fsp--;

             after(grammarAccess.getRuleCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall965); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:459:1: ruleRuleCall : ( ( ( ( RULE_ID ) ) ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:463:2: ( ( ( ( ( RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:464:1: ( ( ( ( RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:464:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:465:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:466:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:467:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:467:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:468:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:469:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:470:1: RULE_ID
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall1003); 
             after(grammarAccess.getRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 

            }


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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:487:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:487:21: ( ruleAssignment EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:488:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment1038);
            ruleAssignment();
            _fsp--;

             after(grammarAccess.getAssignmentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment1045); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:495:1: ruleAssignment : ( ( rule__Assignment__Group ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:499:2: ( ( ( rule__Assignment__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:500:1: ( ( rule__Assignment__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:500:1: ( ( rule__Assignment__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:501:1: ( rule__Assignment__Group )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:502:1: ( rule__Assignment__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:502:2: rule__Assignment__Group
            {
            pushFollow(FOLLOW_rule__Assignment__Group_in_ruleAssignment1072);
            rule__Assignment__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:513:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:513:29: ( ruleAssignableTerminal EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:514:1: ruleAssignableTerminal EOF
            {
             before(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1097);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableTerminalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignableTerminal1104); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:521:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:525:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:526:1: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:526:1: ( ( rule__AssignableTerminal__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:527:1: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:528:1: ( rule__AssignableTerminal__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:528:2: rule__AssignableTerminal__Alternatives
            {
            pushFollow(FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1131);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:539:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:539:41: ( ruleParenthesizedAssignableElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:540:1: ruleParenthesizedAssignableElement EOF
            {
             before(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1156);
            ruleParenthesizedAssignableElement();
            _fsp--;

             after(grammarAccess.getParenthesizedAssignableElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement1163); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:547:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:551:2: ( ( ( rule__ParenthesizedAssignableElement__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:552:1: ( ( rule__ParenthesizedAssignableElement__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:552:1: ( ( rule__ParenthesizedAssignableElement__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:553:1: ( rule__ParenthesizedAssignableElement__Group )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:554:1: ( rule__ParenthesizedAssignableElement__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:554:2: rule__ParenthesizedAssignableElement__Group
            {
            pushFollow(FOLLOW_rule__ParenthesizedAssignableElement__Group_in_ruleParenthesizedAssignableElement1190);
            rule__ParenthesizedAssignableElement__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:565:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:565:33: ( ruleAssignableAlternatives EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:566:1: ruleAssignableAlternatives EOF
            {
             before(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1215);
            ruleAssignableAlternatives();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignableAlternatives1222); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:573:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:577:2: ( ( ( rule__AssignableAlternatives__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:578:1: ( ( rule__AssignableAlternatives__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:578:1: ( ( rule__AssignableAlternatives__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:579:1: ( rule__AssignableAlternatives__Group )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:580:1: ( rule__AssignableAlternatives__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:580:2: rule__AssignableAlternatives__Group
            {
            pushFollow(FOLLOW_rule__AssignableAlternatives__Group_in_ruleAssignableAlternatives1249);
            rule__AssignableAlternatives__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:591:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:591:25: ( ruleCrossReference EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:592:1: ruleCrossReference EOF
            {
             before(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference1274);
            ruleCrossReference();
            _fsp--;

             after(grammarAccess.getCrossReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference1281); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:599:1: ruleCrossReference : ( ( rule__CrossReference__Group ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:603:2: ( ( ( rule__CrossReference__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:604:1: ( ( rule__CrossReference__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:604:1: ( ( rule__CrossReference__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:605:1: ( rule__CrossReference__Group )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:606:1: ( rule__CrossReference__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:606:2: rule__CrossReference__Group
            {
            pushFollow(FOLLOW_rule__CrossReference__Group_in_ruleCrossReference1308);
            rule__CrossReference__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:617:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:617:37: ( ruleCrossReferenceableTerminal EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:618:1: ruleCrossReferenceableTerminal EOF
            {
             before(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1333);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceableTerminalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal1340); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:625:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:629:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:630:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:630:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:631:1: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:632:1: ( rule__CrossReferenceableTerminal__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:632:2: rule__CrossReferenceableTerminal__Alternatives
            {
            pushFollow(FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1367);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:643:1: entryRuleParenthesizedCrossReferenceableElement : ruleParenthesizedCrossReferenceableElement EOF ;
    public final void entryRuleParenthesizedCrossReferenceableElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:643:49: ( ruleParenthesizedCrossReferenceableElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:644:1: ruleParenthesizedCrossReferenceableElement EOF
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementRule()); 
            pushFollow(FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement1392);
            ruleParenthesizedCrossReferenceableElement();
            _fsp--;

             after(grammarAccess.getParenthesizedCrossReferenceableElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement1399); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:651:1: ruleParenthesizedCrossReferenceableElement : ( ( rule__ParenthesizedCrossReferenceableElement__Group ) ) ;
    public final void ruleParenthesizedCrossReferenceableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:655:2: ( ( ( rule__ParenthesizedCrossReferenceableElement__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:656:1: ( ( rule__ParenthesizedCrossReferenceableElement__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:656:1: ( ( rule__ParenthesizedCrossReferenceableElement__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:657:1: ( rule__ParenthesizedCrossReferenceableElement__Group )
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:658:1: ( rule__ParenthesizedCrossReferenceableElement__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:658:2: rule__ParenthesizedCrossReferenceableElement__Group
            {
            pushFollow(FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group_in_ruleParenthesizedCrossReferenceableElement1426);
            rule__ParenthesizedCrossReferenceableElement__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:669:1: entryRuleCrossReferenceableAlternatives : ruleCrossReferenceableAlternatives EOF ;
    public final void entryRuleCrossReferenceableAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:669:41: ( ruleCrossReferenceableAlternatives EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:670:1: ruleCrossReferenceableAlternatives EOF
            {
             before(grammarAccess.getCrossReferenceableAlternativesRule()); 
            pushFollow(FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives1451);
            ruleCrossReferenceableAlternatives();
            _fsp--;

             after(grammarAccess.getCrossReferenceableAlternativesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives1458); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:677:1: ruleCrossReferenceableAlternatives : ( ( rule__CrossReferenceableAlternatives__Group ) ) ;
    public final void ruleCrossReferenceableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:681:2: ( ( ( rule__CrossReferenceableAlternatives__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:682:1: ( ( rule__CrossReferenceableAlternatives__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:682:1: ( ( rule__CrossReferenceableAlternatives__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:683:1: ( rule__CrossReferenceableAlternatives__Group )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:684:1: ( rule__CrossReferenceableAlternatives__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:684:2: rule__CrossReferenceableAlternatives__Group
            {
            pushFollow(FOLLOW_rule__CrossReferenceableAlternatives__Group_in_ruleCrossReferenceableAlternatives1485);
            rule__CrossReferenceableAlternatives__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:695:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:695:31: ( ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:696:1: ruleParenthesizedElement EOF
            {
             before(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1510);
            ruleParenthesizedElement();
            _fsp--;

             after(grammarAccess.getParenthesizedElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement1517); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:703:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:707:2: ( ( ( rule__ParenthesizedElement__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:708:1: ( ( rule__ParenthesizedElement__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:708:1: ( ( rule__ParenthesizedElement__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:709:1: ( rule__ParenthesizedElement__Group )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:710:1: ( rule__ParenthesizedElement__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:710:2: rule__ParenthesizedElement__Group
            {
            pushFollow(FOLLOW_rule__ParenthesizedElement__Group_in_ruleParenthesizedElement1544);
            rule__ParenthesizedElement__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:721:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:721:23: ( ruleTerminalRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:722:1: ruleTerminalRule EOF
            {
             before(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1569);
            ruleTerminalRule();
            _fsp--;

             after(grammarAccess.getTerminalRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule1576); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:729:1: ruleTerminalRule : ( ( rule__TerminalRule__Group ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:733:2: ( ( ( rule__TerminalRule__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:734:1: ( ( rule__TerminalRule__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:734:1: ( ( rule__TerminalRule__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:735:1: ( rule__TerminalRule__Group )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:736:1: ( rule__TerminalRule__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:736:2: rule__TerminalRule__Group
            {
            pushFollow(FOLLOW_rule__TerminalRule__Group_in_ruleTerminalRule1603);
            rule__TerminalRule__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:747:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:747:31: ( ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:748:1: ruleTerminalAlternatives EOF
            {
             before(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1628);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives1635); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:755:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:759:2: ( ( ( rule__TerminalAlternatives__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:760:1: ( ( rule__TerminalAlternatives__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:760:1: ( ( rule__TerminalAlternatives__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:761:1: ( rule__TerminalAlternatives__Group )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:762:1: ( rule__TerminalAlternatives__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:762:2: rule__TerminalAlternatives__Group
            {
            pushFollow(FOLLOW_rule__TerminalAlternatives__Group_in_ruleTerminalAlternatives1662);
            rule__TerminalAlternatives__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:773:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:773:24: ( ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:774:1: ruleTerminalGroup EOF
            {
             before(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1687);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalGroupRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup1694); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:781:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:785:2: ( ( ( rule__TerminalGroup__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:786:1: ( ( rule__TerminalGroup__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:786:1: ( ( rule__TerminalGroup__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:787:1: ( rule__TerminalGroup__Group )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:788:1: ( rule__TerminalGroup__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:788:2: rule__TerminalGroup__Group
            {
            pushFollow(FOLLOW_rule__TerminalGroup__Group_in_ruleTerminalGroup1721);
            rule__TerminalGroup__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:799:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:799:24: ( ruleTerminalToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:800:1: ruleTerminalToken EOF
            {
             before(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1746);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken1753); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:807:1: ruleTerminalToken : ( ( rule__TerminalToken__Group ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:811:2: ( ( ( rule__TerminalToken__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:812:1: ( ( rule__TerminalToken__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:812:1: ( ( rule__TerminalToken__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:813:1: ( rule__TerminalToken__Group )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:814:1: ( rule__TerminalToken__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:814:2: rule__TerminalToken__Group
            {
            pushFollow(FOLLOW_rule__TerminalToken__Group_in_ruleTerminalToken1780);
            rule__TerminalToken__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:825:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:825:31: ( ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:826:1: ruleTerminalTokenElement EOF
            {
             before(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1805);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getTerminalTokenElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement1812); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:833:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:837:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:838:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:838:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:839:1: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:840:1: ( rule__TerminalTokenElement__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:840:2: rule__TerminalTokenElement__Alternatives
            {
            pushFollow(FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1839);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:851:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:851:39: ( ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:852:1: ruleParenthesizedTerminalElement EOF
            {
             before(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1864);
            ruleParenthesizedTerminalElement();
            _fsp--;

             after(grammarAccess.getParenthesizedTerminalElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement1871); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:859:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:863:2: ( ( ( rule__ParenthesizedTerminalElement__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:864:1: ( ( rule__ParenthesizedTerminalElement__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:864:1: ( ( rule__ParenthesizedTerminalElement__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:865:1: ( rule__ParenthesizedTerminalElement__Group )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:866:1: ( rule__ParenthesizedTerminalElement__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:866:2: rule__ParenthesizedTerminalElement__Group
            {
            pushFollow(FOLLOW_rule__ParenthesizedTerminalElement__Group_in_ruleParenthesizedTerminalElement1898);
            rule__ParenthesizedTerminalElement__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:877:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:877:31: ( ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:878:1: ruleAbstractNegatedToken EOF
            {
             before(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1923);
            ruleAbstractNegatedToken();
            _fsp--;

             after(grammarAccess.getAbstractNegatedTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken1930); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:885:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:889:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:890:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:890:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:891:1: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:892:1: ( rule__AbstractNegatedToken__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:892:2: rule__AbstractNegatedToken__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1957);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:903:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:903:23: ( ruleNegatedToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:904:1: ruleNegatedToken EOF
            {
             before(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1982);
            ruleNegatedToken();
            _fsp--;

             after(grammarAccess.getNegatedTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken1989); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:911:1: ruleNegatedToken : ( ( rule__NegatedToken__Group ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:915:2: ( ( ( rule__NegatedToken__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:916:1: ( ( rule__NegatedToken__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:916:1: ( ( rule__NegatedToken__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:917:1: ( rule__NegatedToken__Group )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:918:1: ( rule__NegatedToken__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:918:2: rule__NegatedToken__Group
            {
            pushFollow(FOLLOW_rule__NegatedToken__Group_in_ruleNegatedToken2016);
            rule__NegatedToken__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:929:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:929:21: ( ruleUntilToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:930:1: ruleUntilToken EOF
            {
             before(grammarAccess.getUntilTokenRule()); 
            pushFollow(FOLLOW_ruleUntilToken_in_entryRuleUntilToken2041);
            ruleUntilToken();
            _fsp--;

             after(grammarAccess.getUntilTokenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUntilToken2048); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:937:1: ruleUntilToken : ( ( rule__UntilToken__Group ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:941:2: ( ( ( rule__UntilToken__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:942:1: ( ( rule__UntilToken__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:942:1: ( ( rule__UntilToken__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:943:1: ( rule__UntilToken__Group )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:944:1: ( rule__UntilToken__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:944:2: rule__UntilToken__Group
            {
            pushFollow(FOLLOW_rule__UntilToken__Group_in_ruleUntilToken2075);
            rule__UntilToken__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:955:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:955:19: ( ruleWildcard EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:956:1: ruleWildcard EOF
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:963:1: ruleWildcard : ( ( rule__Wildcard__Group ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:967:2: ( ( ( rule__Wildcard__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:968:1: ( ( rule__Wildcard__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:968:1: ( ( rule__Wildcard__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:969:1: ( rule__Wildcard__Group )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:970:1: ( rule__Wildcard__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:970:2: rule__Wildcard__Group
            {
            pushFollow(FOLLOW_rule__Wildcard__Group_in_ruleWildcard2134);
            rule__Wildcard__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:981:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:981:25: ( ruleCharacterRange EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:982:1: ruleCharacterRange EOF
            {
             before(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2159);
            ruleCharacterRange();
            _fsp--;

             after(grammarAccess.getCharacterRangeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange2166); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:989:1: ruleCharacterRange : ( ( rule__CharacterRange__Group ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:993:2: ( ( ( rule__CharacterRange__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:994:1: ( ( rule__CharacterRange__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:994:1: ( ( rule__CharacterRange__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:995:1: ( rule__CharacterRange__Group )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:996:1: ( rule__CharacterRange__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:996:2: rule__CharacterRange__Group
            {
            pushFollow(FOLLOW_rule__CharacterRange__Group_in_ruleCharacterRange2193);
            rule__CharacterRange__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1007:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1007:19: ( ruleEnumRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1008:1: ruleEnumRule EOF
            {
             before(grammarAccess.getEnumRuleRule()); 
            pushFollow(FOLLOW_ruleEnumRule_in_entryRuleEnumRule2218);
            ruleEnumRule();
            _fsp--;

             after(grammarAccess.getEnumRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumRule2225); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1015:1: ruleEnumRule : ( ( rule__EnumRule__Group ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1019:2: ( ( ( rule__EnumRule__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1020:1: ( ( rule__EnumRule__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1020:1: ( ( rule__EnumRule__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1021:1: ( rule__EnumRule__Group )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1022:1: ( rule__EnumRule__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1022:2: rule__EnumRule__Group
            {
            pushFollow(FOLLOW_rule__EnumRule__Group_in_ruleEnumRule2252);
            rule__EnumRule__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1033:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1033:23: ( ruleEnumLiterals EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1034:1: ruleEnumLiterals EOF
            {
             before(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2277);
            ruleEnumLiterals();
            _fsp--;

             after(grammarAccess.getEnumLiteralsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumLiterals2284); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1041:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1045:2: ( ( ( rule__EnumLiterals__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1046:1: ( ( rule__EnumLiterals__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1046:1: ( ( rule__EnumLiterals__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1047:1: ( rule__EnumLiterals__Group )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1048:1: ( rule__EnumLiterals__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1048:2: rule__EnumLiterals__Group
            {
            pushFollow(FOLLOW_rule__EnumLiterals__Group_in_ruleEnumLiterals2311);
            rule__EnumLiterals__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1059:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1059:33: ( ruleEnumLiteralDeclaration EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1060:1: ruleEnumLiteralDeclaration EOF
            {
             before(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2336);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration2343); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1067:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1071:2: ( ( ( rule__EnumLiteralDeclaration__Group ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1072:1: ( ( rule__EnumLiteralDeclaration__Group ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1072:1: ( ( rule__EnumLiteralDeclaration__Group ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1073:1: ( rule__EnumLiteralDeclaration__Group )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1074:1: ( rule__EnumLiteralDeclaration__Group )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1074:2: rule__EnumLiteralDeclaration__Group
            {
            pushFollow(FOLLOW_rule__EnumLiteralDeclaration__Group_in_ruleEnumLiteralDeclaration2370);
            rule__EnumLiteralDeclaration__Group();
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1085:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1089:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt1=1;
                }
                break;
            case 37:
                {
                alt1=2;
                }
                break;
            case 41:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1085:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1090:1: ( ruleParserRule )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1090:1: ( ruleParserRule )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1091:1: ruleParserRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleParserRule_in_rule__AbstractRule__Alternatives2405);
                    ruleParserRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1095:6: ( ruleTerminalRule )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1095:6: ( ruleTerminalRule )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1096:1: ruleTerminalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTerminalRule_in_rule__AbstractRule__Alternatives2421);
                    ruleTerminalRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1100:6: ( ruleEnumRule )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1100:6: ( ruleEnumRule )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1101:1: ruleEnumRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleEnumRule_in_rule__AbstractRule__Alternatives2437);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1110:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1114:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==24) ) {
                alt2=1;
            }
            else if ( (LA2_0==26) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1110:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1115:1: ( ruleGeneratedMetamodel )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1115:1: ( ruleGeneratedMetamodel )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1116:1: ruleGeneratedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2468);
                    ruleGeneratedMetamodel();
                    _fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1120:6: ( ruleReferencedMetamodel )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1120:6: ( ruleReferencedMetamodel )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1121:1: ruleReferencedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2484);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1130:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1134:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_ID)||LA3_0==21) ) {
                alt3=1;
            }
            else if ( (LA3_0==32) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1130:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1135:1: ( ruleAbstractTokenWithCardinality )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1135:1: ( ruleAbstractTokenWithCardinality )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1136:1: ruleAbstractTokenWithCardinality
                    {
                     before(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleAbstractTokenWithCardinality_in_rule__AbstractToken__Alternatives2515);
                    ruleAbstractTokenWithCardinality();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1140:6: ( ruleAction )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1140:6: ( ruleAction )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1141:1: ruleAction
                    {
                     before(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleAction_in_rule__AbstractToken__Alternatives2531);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1150:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1154:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==EOF||(LA4_1>=RULE_STRING && LA4_1<=RULE_ID)||(LA4_1>=11 && LA4_1<=13)||(LA4_1>=21 && LA4_1<=22)||LA4_1==28||(LA4_1>=31 && LA4_1<=32)) ) {
                    alt4=2;
                }
                else if ( ((LA4_1>=14 && LA4_1<=16)) ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1150:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==RULE_STRING||LA4_0==21) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1150:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1155:1: ( ruleAssignment )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1155:1: ( ruleAssignment )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1156:1: ruleAssignment
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_ruleAssignment_in_rule__AbstractTokenWithCardinality__Alternatives_02562);
                    ruleAssignment();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1160:6: ( ruleAbstractTerminal )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1160:6: ( ruleAbstractTerminal )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1161:1: ruleAbstractTerminal
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_rule__AbstractTokenWithCardinality__Alternatives_02578);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1170:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1174:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    new NoViableAltException("1170:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1175:1: ( '?' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1175:1: ( '?' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1176:1: '?'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FOLLOW_11_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02610); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1182:6: ( '*' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1182:6: ( '*' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1183:1: '*'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FOLLOW_12_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02629); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1189:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1189:6: ( '+' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1190:1: '+'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FOLLOW_13_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02648); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1201:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1205:1: ( ( '=' ) | ( '+=' ) )
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
                    new NoViableAltException("1201:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1206:1: ( '=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1206:1: ( '=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1207:1: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__Action__OperatorAlternatives_2_2_02682); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1213:6: ( '+=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1213:6: ( '+=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1214:1: '+='
                    {
                     before(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__Action__OperatorAlternatives_2_2_02701); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1225:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1229:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) )
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
            case 21:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1225:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1230:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1230:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1231:1: ruleKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleKeyword_in_rule__AbstractTerminal__Alternatives2734);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1235:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1235:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1236:1: ruleRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRuleCall_in_rule__AbstractTerminal__Alternatives2750);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1240:6: ( ruleParenthesizedElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1240:6: ( ruleParenthesizedElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1241:1: ruleParenthesizedElement
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_rule__AbstractTerminal__Alternatives2766);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1250:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1254:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
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
                    new NoViableAltException("1250:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1255:1: ( '+=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1255:1: ( '+=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1256:1: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__Assignment__OperatorAlternatives_1_02798); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1262:6: ( '=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1262:6: ( '=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1263:1: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 
                    match(input,14,FOLLOW_14_in_rule__Assignment__OperatorAlternatives_1_02817); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1269:6: ( '?=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1269:6: ( '?=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1270:1: '?='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2()); 
                    match(input,16,FOLLOW_16_in_rule__Assignment__OperatorAlternatives_1_02836); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1281:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1285:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
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
            case 21:
                {
                alt9=3;
                }
                break;
            case 35:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1281:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1286:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1286:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1287:1: ruleKeyword
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleKeyword_in_rule__AssignableTerminal__Alternatives2869);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1291:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1291:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1292:1: ruleRuleCall
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRuleCall_in_rule__AssignableTerminal__Alternatives2885);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1296:6: ( ruleParenthesizedAssignableElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1296:6: ( ruleParenthesizedAssignableElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1297:1: ruleParenthesizedAssignableElement
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleParenthesizedAssignableElement_in_rule__AssignableTerminal__Alternatives2901);
                    ruleParenthesizedAssignableElement();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1301:6: ( ruleCrossReference )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1301:6: ( ruleCrossReference )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1302:1: ruleCrossReference
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleCrossReference_in_rule__AssignableTerminal__Alternatives2917);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1311:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1315:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) )
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
            case 21:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1311:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedCrossReferenceableElement ) );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1316:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1316:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1317:1: ruleKeyword
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleKeyword_in_rule__CrossReferenceableTerminal__Alternatives2948);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1321:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1321:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1322:1: ruleRuleCall
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRuleCall_in_rule__CrossReferenceableTerminal__Alternatives2964);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1326:6: ( ruleParenthesizedCrossReferenceableElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1326:6: ( ruleParenthesizedCrossReferenceableElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1327:1: ruleParenthesizedCrossReferenceableElement
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getParenthesizedCrossReferenceableElementParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleParenthesizedCrossReferenceableElement_in_rule__CrossReferenceableTerminal__Alternatives2980);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1336:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__TerminalToken__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1340:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    new NoViableAltException("1336:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1341:1: ( '?' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1341:1: ( '?' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1342:1: '?'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_03012); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1348:6: ( '*' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1348:6: ( '*' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1349:1: '*'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_03031); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1355:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1355:6: ( '+' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1356:1: '+'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_03050); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1367:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1371:1: ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) )
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
            case 21:
                {
                alt12=3;
                }
                break;
            case 38:
            case 39:
                {
                alt12=4;
                }
                break;
            case 23:
                {
                alt12=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1367:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1372:1: ( ruleCharacterRange )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1372:1: ( ruleCharacterRange )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1373:1: ruleCharacterRange
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3083);
                    ruleCharacterRange();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1377:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1377:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1378:1: ruleRuleCall
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3099);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1382:6: ( ruleParenthesizedTerminalElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1382:6: ( ruleParenthesizedTerminalElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1383:1: ruleParenthesizedTerminalElement
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3115);
                    ruleParenthesizedTerminalElement();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1387:6: ( ruleAbstractNegatedToken )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1387:6: ( ruleAbstractNegatedToken )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1388:1: ruleAbstractNegatedToken
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3131);
                    ruleAbstractNegatedToken();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1392:6: ( ruleWildcard )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1392:6: ( ruleWildcard )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1393:1: ruleWildcard
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3147);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1402:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1406:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==38) ) {
                alt13=1;
            }
            else if ( (LA13_0==39) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1402:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1407:1: ( ruleNegatedToken )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1407:1: ( ruleNegatedToken )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1408:1: ruleNegatedToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3178);
                    ruleNegatedToken();
                    _fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1412:6: ( ruleUntilToken )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1412:6: ( ruleUntilToken )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1413:1: ruleUntilToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3194);
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


    // $ANTLR start rule__Grammar__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1423:1: rule__Grammar__Group : ( 'grammar' ) ( ( ( ruleGrammarID ) ) ) ( ( rule__Grammar__Group_2 )? ) ( ( rule__Grammar__Group_3 )? ) ( ( ( ruleAbstractMetamodelDeclaration ) )* ) ( ( ( ruleAbstractRule ) )+ ) ;
    public final void rule__Grammar__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1427:1: ( ( 'grammar' ) ( ( ( ruleGrammarID ) ) ) ( ( rule__Grammar__Group_2 )? ) ( ( rule__Grammar__Group_3 )? ) ( ( ( ruleAbstractMetamodelDeclaration ) )* ) ( ( ( ruleAbstractRule ) )+ ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1428:1: ( 'grammar' ) ( ( ( ruleGrammarID ) ) ) ( ( rule__Grammar__Group_2 )? ) ( ( rule__Grammar__Group_3 )? ) ( ( ( ruleAbstractMetamodelDeclaration ) )* ) ( ( ( ruleAbstractRule ) )+ )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1428:1: ( 'grammar' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1429:1: 'grammar'
            {
             before(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__Grammar__Group3227); 
             after(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1434:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1435:1: ( ( ruleGrammarID ) )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1436:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1437:1: ( ruleGrammarID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1437:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1438:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleGrammarID_in_rule__Grammar__Group3246);
            ruleGrammarID();
            _fsp--;

             after(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 

            }


            }

             after(grammarAccess.getGrammarAccess().getNameAssignment_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1444:1: ( ( rule__Grammar__Group_2 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1445:1: ( rule__Grammar__Group_2 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1446:1: ( rule__Grammar__Group_2 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1446:2: rule__Grammar__Group_2
                    {
                    pushFollow(FOLLOW_rule__Grammar__Group_2_in_rule__Grammar__Group3263);
                    rule__Grammar__Group_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_2()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1448:1: ( ( rule__Grammar__Group_3 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1449:1: ( rule__Grammar__Group_3 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1450:1: ( rule__Grammar__Group_3 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1450:2: rule__Grammar__Group_3
                    {
                    pushFollow(FOLLOW_rule__Grammar__Group_3_in_rule__Grammar__Group3275);
                    rule__Grammar__Group_3();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_3()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1452:1: ( ( ( ruleAbstractMetamodelDeclaration ) )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1453:1: ( ( ruleAbstractMetamodelDeclaration ) )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1454:1: ( ( ruleAbstractMetamodelDeclaration ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==24||LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1455:1: ( ruleAbstractMetamodelDeclaration )
            	    {
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1455:1: ( ruleAbstractMetamodelDeclaration )
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1456:1: ruleAbstractMetamodelDeclaration
            	    {
            	     before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__Group3294);
            	    ruleAbstractMetamodelDeclaration();
            	    _fsp--;

            	     after(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1462:1: ( ( ( ruleAbstractRule ) )+ )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1463:1: ( ( ruleAbstractRule ) )+
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1464:1: ( ( ruleAbstractRule ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID||LA17_0==37||LA17_0==41) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1465:1: ( ruleAbstractRule )
            	    {
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1465:1: ( ruleAbstractRule )
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1466:1: ruleAbstractRule
            	    {
            	     before(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 
            	    pushFollow(FOLLOW_ruleAbstractRule_in_rule__Grammar__Group3319);
            	    ruleAbstractRule();
            	    _fsp--;

            	     after(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Grammar__Group


    // $ANTLR start rule__Grammar__Group_2
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1478:1: rule__Grammar__Group_2 : ( 'with' ) ( ( ( ( ruleGrammarID ) ) ) ) ( ( rule__Grammar__Group_2_2 )* ) ;
    public final void rule__Grammar__Group_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1482:1: ( ( 'with' ) ( ( ( ( ruleGrammarID ) ) ) ) ( ( rule__Grammar__Group_2_2 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1483:1: ( 'with' ) ( ( ( ( ruleGrammarID ) ) ) ) ( ( rule__Grammar__Group_2_2 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1483:1: ( 'with' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1484:1: 'with'
            {
             before(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__Grammar__Group_23359); 
             after(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1489:1: ( ( ( ( ruleGrammarID ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1490:1: ( ( ( ruleGrammarID ) ) )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1491:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1492:1: ( ( ruleGrammarID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1492:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1493:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1494:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1495:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_ruleGrammarID_in_rule__Grammar__Group_23382);
            ruleGrammarID();
            _fsp--;

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 

            }


            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1503:1: ( ( rule__Grammar__Group_2_2 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1504:1: ( rule__Grammar__Group_2_2 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1505:1: ( rule__Grammar__Group_2_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1505:2: rule__Grammar__Group_2_2
            	    {
            	    pushFollow(FOLLOW_rule__Grammar__Group_2_2_in_rule__Grammar__Group_23403);
            	    rule__Grammar__Group_2_2();
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
    // $ANTLR end rule__Grammar__Group_2


    // $ANTLR start rule__Grammar__Group_2_2
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1513:1: rule__Grammar__Group_2_2 : ( ',' ) ( ( ( ( ruleGrammarID ) ) ) ) ;
    public final void rule__Grammar__Group_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1517:1: ( ( ',' ) ( ( ( ( ruleGrammarID ) ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1518:1: ( ',' ) ( ( ( ( ruleGrammarID ) ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1518:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1519:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 
            match(input,19,FOLLOW_19_in_rule__Grammar__Group_2_23437); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1524:1: ( ( ( ( ruleGrammarID ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1525:1: ( ( ( ruleGrammarID ) ) )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1526:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1527:1: ( ( ruleGrammarID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1527:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1528:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1529:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1530:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 
            pushFollow(FOLLOW_ruleGrammarID_in_rule__Grammar__Group_2_23460);
            ruleGrammarID();
            _fsp--;

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 

            }


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
    // $ANTLR end rule__Grammar__Group_2_2


    // $ANTLR start rule__Grammar__Group_3
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1544:1: rule__Grammar__Group_3 : ( ( ( ( 'hidden' ) ) ) ) ( '(' ) ( ( rule__Grammar__Group_3_2 )? ) ( ')' ) ;
    public final void rule__Grammar__Group_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1548:1: ( ( ( ( ( 'hidden' ) ) ) ) ( '(' ) ( ( rule__Grammar__Group_3_2 )? ) ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1549:1: ( ( ( ( 'hidden' ) ) ) ) ( '(' ) ( ( rule__Grammar__Group_3_2 )? ) ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1549:1: ( ( ( ( 'hidden' ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1550:1: ( ( ( 'hidden' ) ) )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1551:1: ( ( ( 'hidden' ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1552:1: ( ( 'hidden' ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1552:1: ( ( 'hidden' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1553:1: ( 'hidden' )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1554:1: ( 'hidden' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1555:1: 'hidden'
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            match(input,20,FOLLOW_20_in_rule__Grammar__Group_33514); 
             after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 

            }

             after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 

            }


            }

             after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1566:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1567:1: '('
            {
             before(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,21,FOLLOW_21_in_rule__Grammar__Group_33539); 
             after(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1572:1: ( ( rule__Grammar__Group_3_2 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1573:1: ( rule__Grammar__Group_3_2 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1574:1: ( rule__Grammar__Group_3_2 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1574:2: rule__Grammar__Group_3_2
                    {
                    pushFollow(FOLLOW_rule__Grammar__Group_3_2_in_rule__Grammar__Group_33551);
                    rule__Grammar__Group_3_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_3_2()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1576:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1577:1: ')'
            {
             before(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); 
            match(input,22,FOLLOW_22_in_rule__Grammar__Group_33564); 
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
    // $ANTLR end rule__Grammar__Group_3


    // $ANTLR start rule__Grammar__Group_3_2
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1588:1: rule__Grammar__Group_3_2 : ( ( ( ( RULE_ID ) ) ) ) ( ( rule__Grammar__Group_3_2_1 )* ) ;
    public final void rule__Grammar__Group_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1592:1: ( ( ( ( ( RULE_ID ) ) ) ) ( ( rule__Grammar__Group_3_2_1 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1593:1: ( ( ( ( RULE_ID ) ) ) ) ( ( rule__Grammar__Group_3_2_1 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1593:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1594:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1595:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1596:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1596:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1597:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1598:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1599:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Grammar__Group_3_23608); 
             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 

            }


            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1607:1: ( ( rule__Grammar__Group_3_2_1 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1608:1: ( rule__Grammar__Group_3_2_1 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1609:1: ( rule__Grammar__Group_3_2_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==19) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1609:2: rule__Grammar__Group_3_2_1
            	    {
            	    pushFollow(FOLLOW_rule__Grammar__Group_3_2_1_in_rule__Grammar__Group_3_23629);
            	    rule__Grammar__Group_3_2_1();
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
    // $ANTLR end rule__Grammar__Group_3_2


    // $ANTLR start rule__Grammar__Group_3_2_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1617:1: rule__Grammar__Group_3_2_1 : ( ',' ) ( ( ( ( RULE_ID ) ) ) ) ;
    public final void rule__Grammar__Group_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1621:1: ( ( ',' ) ( ( ( ( RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1622:1: ( ',' ) ( ( ( ( RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1622:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1623:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 
            match(input,19,FOLLOW_19_in_rule__Grammar__Group_3_2_13663); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1628:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1629:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1630:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1631:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1631:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1632:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1633:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1634:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Grammar__Group_3_2_13686); 
             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 

            }


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
    // $ANTLR end rule__Grammar__Group_3_2_1


    // $ANTLR start rule__GrammarID__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1648:1: rule__GrammarID__Group : ( RULE_ID ) ( ( rule__GrammarID__Group_1 )* ) ;
    public final void rule__GrammarID__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1652:1: ( ( RULE_ID ) ( ( rule__GrammarID__Group_1 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1653:1: ( RULE_ID ) ( ( rule__GrammarID__Group_1 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1653:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1654:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GrammarID__Group3728); 
             after(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1657:1: ( ( rule__GrammarID__Group_1 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1658:1: ( rule__GrammarID__Group_1 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1659:1: ( rule__GrammarID__Group_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==23) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1659:2: rule__GrammarID__Group_1
            	    {
            	    pushFollow(FOLLOW_rule__GrammarID__Group_1_in_rule__GrammarID__Group3738);
            	    rule__GrammarID__Group_1();
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
    // $ANTLR end rule__GrammarID__Group


    // $ANTLR start rule__GrammarID__Group_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1667:1: rule__GrammarID__Group_1 : ( '.' ) ( RULE_ID ) ;
    public final void rule__GrammarID__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1671:1: ( ( '.' ) ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1672:1: ( '.' ) ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1672:1: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1673:1: '.'
            {
             before(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 
            match(input,23,FOLLOW_23_in_rule__GrammarID__Group_13772); 
             after(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1678:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1679:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GrammarID__Group_13784); 
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
    // $ANTLR end rule__GrammarID__Group_1


    // $ANTLR start rule__GeneratedMetamodel__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1688:1: rule__GeneratedMetamodel__Group : ( 'generate' ) ( ( ( RULE_ID ) ) ) ( ( ( ( RULE_STRING ) ) ) ) ( ( rule__GeneratedMetamodel__Group_3 )? ) ;
    public final void rule__GeneratedMetamodel__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1692:1: ( ( 'generate' ) ( ( ( RULE_ID ) ) ) ( ( ( ( RULE_STRING ) ) ) ) ( ( rule__GeneratedMetamodel__Group_3 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1693:1: ( 'generate' ) ( ( ( RULE_ID ) ) ) ( ( ( ( RULE_STRING ) ) ) ) ( ( rule__GeneratedMetamodel__Group_3 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1693:1: ( 'generate' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1694:1: 'generate'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__GeneratedMetamodel__Group3816); 
             after(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1699:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1700:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1701:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1702:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1702:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1703:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__Group3835); 
             after(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1709:1: ( ( ( ( RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1710:1: ( ( ( RULE_STRING ) ) )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1711:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1712:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1712:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1713:1: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1714:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1715:1: RULE_STRING
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__Group3863); 
             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 

            }


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1723:1: ( ( rule__GeneratedMetamodel__Group_3 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1724:1: ( rule__GeneratedMetamodel__Group_3 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1725:1: ( rule__GeneratedMetamodel__Group_3 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==25) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1725:2: rule__GeneratedMetamodel__Group_3
                    {
                    pushFollow(FOLLOW_rule__GeneratedMetamodel__Group_3_in_rule__GeneratedMetamodel__Group3884);
                    rule__GeneratedMetamodel__Group_3();
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
    // $ANTLR end rule__GeneratedMetamodel__Group


    // $ANTLR start rule__GeneratedMetamodel__Group_3
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1733:1: rule__GeneratedMetamodel__Group_3 : ( 'as' ) ( ( ( RULE_ID ) ) ) ;
    public final void rule__GeneratedMetamodel__Group_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1737:1: ( ( 'as' ) ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1738:1: ( 'as' ) ( ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1738:1: ( 'as' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1739:1: 'as'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 
            match(input,25,FOLLOW_25_in_rule__GeneratedMetamodel__Group_33918); 
             after(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1744:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1745:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1746:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1747:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1747:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1748:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__Group_33937); 
             after(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 

            }


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
    // $ANTLR end rule__GeneratedMetamodel__Group_3


    // $ANTLR start rule__ReferencedMetamodel__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1760:1: rule__ReferencedMetamodel__Group : ( 'import' ) ( ( ( ( RULE_STRING ) ) ) ) ( ( rule__ReferencedMetamodel__Group_2 )? ) ;
    public final void rule__ReferencedMetamodel__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1764:1: ( ( 'import' ) ( ( ( ( RULE_STRING ) ) ) ) ( ( rule__ReferencedMetamodel__Group_2 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1765:1: ( 'import' ) ( ( ( ( RULE_STRING ) ) ) ) ( ( rule__ReferencedMetamodel__Group_2 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1765:1: ( 'import' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1766:1: 'import'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__ReferencedMetamodel__Group3976); 
             after(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1771:1: ( ( ( ( RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1772:1: ( ( ( RULE_STRING ) ) )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1773:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1774:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1774:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1775:1: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1776:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1777:1: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__Group3999); 
             after(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 

            }


            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1785:1: ( ( rule__ReferencedMetamodel__Group_2 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1786:1: ( rule__ReferencedMetamodel__Group_2 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1787:1: ( rule__ReferencedMetamodel__Group_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==25) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1787:2: rule__ReferencedMetamodel__Group_2
                    {
                    pushFollow(FOLLOW_rule__ReferencedMetamodel__Group_2_in_rule__ReferencedMetamodel__Group4020);
                    rule__ReferencedMetamodel__Group_2();
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
    // $ANTLR end rule__ReferencedMetamodel__Group


    // $ANTLR start rule__ReferencedMetamodel__Group_2
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1795:1: rule__ReferencedMetamodel__Group_2 : ( 'as' ) ( ( ( RULE_ID ) ) ) ;
    public final void rule__ReferencedMetamodel__Group_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1799:1: ( ( 'as' ) ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1800:1: ( 'as' ) ( ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1800:1: ( 'as' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1801:1: 'as'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 
            match(input,25,FOLLOW_25_in_rule__ReferencedMetamodel__Group_24054); 
             after(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1806:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1807:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1808:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1809:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1809:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1810:1: RULE_ID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__Group_24073); 
             after(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 

            }


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
    // $ANTLR end rule__ReferencedMetamodel__Group_2


    // $ANTLR start rule__ParserRule__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1822:1: rule__ParserRule__Group : ( ( ( RULE_ID ) ) ) ( ( rule__ParserRule__Group_1 )? ) ( ( rule__ParserRule__Group_2 )? ) ( ':' ) ( ( ( ruleAlternatives ) ) ) ( ';' ) ;
    public final void rule__ParserRule__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1826:1: ( ( ( ( RULE_ID ) ) ) ( ( rule__ParserRule__Group_1 )? ) ( ( rule__ParserRule__Group_2 )? ) ( ':' ) ( ( ( ruleAlternatives ) ) ) ( ';' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1827:1: ( ( ( RULE_ID ) ) ) ( ( rule__ParserRule__Group_1 )? ) ( ( rule__ParserRule__Group_2 )? ) ( ':' ) ( ( ( ruleAlternatives ) ) ) ( ';' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1827:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1828:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1829:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1830:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1830:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1831:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParserRule__Group4118); 
             after(grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

             after(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1837:1: ( ( rule__ParserRule__Group_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1838:1: ( rule__ParserRule__Group_1 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1839:1: ( rule__ParserRule__Group_1 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==29) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1839:2: rule__ParserRule__Group_1
                    {
                    pushFollow(FOLLOW_rule__ParserRule__Group_1_in_rule__ParserRule__Group4135);
                    rule__ParserRule__Group_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1841:1: ( ( rule__ParserRule__Group_2 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1842:1: ( rule__ParserRule__Group_2 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1843:1: ( rule__ParserRule__Group_2 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==20) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1843:2: rule__ParserRule__Group_2
                    {
                    pushFollow(FOLLOW_rule__ParserRule__Group_2_in_rule__ParserRule__Group4147);
                    rule__ParserRule__Group_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_2()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1845:1: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1846:1: ':'
            {
             before(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__ParserRule__Group4160); 
             after(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1851:1: ( ( ( ruleAlternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1852:1: ( ( ruleAlternatives ) )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1853:1: ( ( ruleAlternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1854:1: ( ruleAlternatives )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1854:1: ( ruleAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1855:1: ruleAlternatives
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleAlternatives_in_rule__ParserRule__Group4179);
            ruleAlternatives();
            _fsp--;

             after(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 

            }


            }

             after(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1861:1: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1862:1: ';'
            {
             before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); 
            match(input,28,FOLLOW_28_in_rule__ParserRule__Group4197); 
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
    // $ANTLR end rule__ParserRule__Group


    // $ANTLR start rule__ParserRule__Group_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1873:1: rule__ParserRule__Group_1 : ( 'returns' ) ( ( ( ruleTypeRef ) ) ) ;
    public final void rule__ParserRule__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1877:1: ( ( 'returns' ) ( ( ( ruleTypeRef ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1878:1: ( 'returns' ) ( ( ( ruleTypeRef ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1878:1: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1879:1: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 
            match(input,29,FOLLOW_29_in_rule__ParserRule__Group_14231); 
             after(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1884:1: ( ( ( ruleTypeRef ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1885:1: ( ( ruleTypeRef ) )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1886:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1887:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1887:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1888:1: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleTypeRef_in_rule__ParserRule__Group_14250);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0()); 

            }


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
    // $ANTLR end rule__ParserRule__Group_1


    // $ANTLR start rule__ParserRule__Group_2
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1900:1: rule__ParserRule__Group_2 : ( ( ( ( 'hidden' ) ) ) ) ( '(' ) ( ( rule__ParserRule__Group_2_2 )? ) ( ')' ) ;
    public final void rule__ParserRule__Group_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1904:1: ( ( ( ( ( 'hidden' ) ) ) ) ( '(' ) ( ( rule__ParserRule__Group_2_2 )? ) ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1905:1: ( ( ( ( 'hidden' ) ) ) ) ( '(' ) ( ( rule__ParserRule__Group_2_2 )? ) ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1905:1: ( ( ( ( 'hidden' ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1906:1: ( ( ( 'hidden' ) ) )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1907:1: ( ( ( 'hidden' ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1908:1: ( ( 'hidden' ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1908:1: ( ( 'hidden' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1909:1: ( 'hidden' )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1910:1: ( 'hidden' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1911:1: 'hidden'
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            match(input,20,FOLLOW_20_in_rule__ParserRule__Group_24300); 
             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 

            }

             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 

            }


            }

             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1922:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1923:1: '('
            {
             before(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 
            match(input,21,FOLLOW_21_in_rule__ParserRule__Group_24325); 
             after(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1928:1: ( ( rule__ParserRule__Group_2_2 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1929:1: ( rule__ParserRule__Group_2_2 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1930:1: ( rule__ParserRule__Group_2_2 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1930:2: rule__ParserRule__Group_2_2
                    {
                    pushFollow(FOLLOW_rule__ParserRule__Group_2_2_in_rule__ParserRule__Group_24337);
                    rule__ParserRule__Group_2_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_2_2()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1932:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1933:1: ')'
            {
             before(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); 
            match(input,22,FOLLOW_22_in_rule__ParserRule__Group_24350); 
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
    // $ANTLR end rule__ParserRule__Group_2


    // $ANTLR start rule__ParserRule__Group_2_2
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1944:1: rule__ParserRule__Group_2_2 : ( ( ( ( RULE_ID ) ) ) ) ( ( rule__ParserRule__Group_2_2_1 )* ) ;
    public final void rule__ParserRule__Group_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1948:1: ( ( ( ( ( RULE_ID ) ) ) ) ( ( rule__ParserRule__Group_2_2_1 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1949:1: ( ( ( ( RULE_ID ) ) ) ) ( ( rule__ParserRule__Group_2_2_1 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1949:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1950:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1951:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1952:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1952:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1953:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1954:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1955:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParserRule__Group_2_24394); 
             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1()); 

            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 

            }


            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1963:1: ( ( rule__ParserRule__Group_2_2_1 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1964:1: ( rule__ParserRule__Group_2_2_1 )*
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1965:1: ( rule__ParserRule__Group_2_2_1 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==19) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1965:2: rule__ParserRule__Group_2_2_1
            	    {
            	    pushFollow(FOLLOW_rule__ParserRule__Group_2_2_1_in_rule__ParserRule__Group_2_24415);
            	    rule__ParserRule__Group_2_2_1();
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
    // $ANTLR end rule__ParserRule__Group_2_2


    // $ANTLR start rule__ParserRule__Group_2_2_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1973:1: rule__ParserRule__Group_2_2_1 : ( ',' ) ( ( ( ( RULE_ID ) ) ) ) ;
    public final void rule__ParserRule__Group_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1977:1: ( ( ',' ) ( ( ( ( RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1978:1: ( ',' ) ( ( ( ( RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1978:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1979:1: ','
            {
             before(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 
            match(input,19,FOLLOW_19_in_rule__ParserRule__Group_2_2_14449); 
             after(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1984:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1985:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1986:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1987:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1987:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1988:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1989:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1990:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParserRule__Group_2_2_14472); 
             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1()); 

            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 

            }


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
    // $ANTLR end rule__ParserRule__Group_2_2_1


    // $ANTLR start rule__TypeRef__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2004:1: rule__TypeRef__Group : ( ( rule__TypeRef__Group_0 )? ) ( ( ( ( RULE_ID ) ) ) ) ;
    public final void rule__TypeRef__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2008:1: ( ( ( rule__TypeRef__Group_0 )? ) ( ( ( ( RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2009:1: ( ( rule__TypeRef__Group_0 )? ) ( ( ( ( RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2009:1: ( ( rule__TypeRef__Group_0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2010:1: ( rule__TypeRef__Group_0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2011:1: ( rule__TypeRef__Group_0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==30) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2011:2: rule__TypeRef__Group_0
                    {
                    pushFollow(FOLLOW_rule__TypeRef__Group_0_in_rule__TypeRef__Group4514);
                    rule__TypeRef__Group_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeRefAccess().getGroup_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2013:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2014:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2015:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2016:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2016:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2017:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2018:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2019:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeRef__Group4537); 
             after(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 

            }


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
    // $ANTLR end rule__TypeRef__Group


    // $ANTLR start rule__TypeRef__Group_0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2033:1: rule__TypeRef__Group_0 : ( ( ( ( RULE_ID ) ) ) ) ( '::' ) ;
    public final void rule__TypeRef__Group_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2037:1: ( ( ( ( ( RULE_ID ) ) ) ) ( '::' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2038:1: ( ( ( ( RULE_ID ) ) ) ) ( '::' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2038:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2039:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2040:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2041:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2041:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2042:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2043:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2044:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeRef__Group_04590); 
             after(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 

            }


            }

             after(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2052:1: ( '::' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2053:1: '::'
            {
             before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 
            match(input,30,FOLLOW_30_in_rule__TypeRef__Group_04612); 
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
    // $ANTLR end rule__TypeRef__Group_0


    // $ANTLR start rule__Alternatives__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2064:1: rule__Alternatives__Group : ( ruleGroup ) ( ( rule__Alternatives__Group_1 )? ) ;
    public final void rule__Alternatives__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2068:1: ( ( ruleGroup ) ( ( rule__Alternatives__Group_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2069:1: ( ruleGroup ) ( ( rule__Alternatives__Group_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2069:1: ( ruleGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2070:1: ruleGroup
            {
             before(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleGroup_in_rule__Alternatives__Group4645);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2073:1: ( ( rule__Alternatives__Group_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2074:1: ( rule__Alternatives__Group_1 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2075:1: ( rule__Alternatives__Group_1 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==31) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2075:2: rule__Alternatives__Group_1
                    {
                    pushFollow(FOLLOW_rule__Alternatives__Group_1_in_rule__Alternatives__Group4655);
                    rule__Alternatives__Group_1();
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
    // $ANTLR end rule__Alternatives__Group


    // $ANTLR start rule__Alternatives__Group_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2083:1: rule__Alternatives__Group_1 : ( () ) ( ( rule__Alternatives__Group_1_1 )+ ) ;
    public final void rule__Alternatives__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2087:1: ( ( () ) ( ( rule__Alternatives__Group_1_1 )+ ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2088:1: ( () ) ( ( rule__Alternatives__Group_1_1 )+ )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2088:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2089:1: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2090:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2092:1: 
            {
            }

             after(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2094:1: ( ( rule__Alternatives__Group_1_1 )+ )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2095:1: ( rule__Alternatives__Group_1_1 )+
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2096:1: ( rule__Alternatives__Group_1_1 )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==31) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2096:2: rule__Alternatives__Group_1_1
            	    {
            	    pushFollow(FOLLOW_rule__Alternatives__Group_1_1_in_rule__Alternatives__Group_14700);
            	    rule__Alternatives__Group_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Alternatives__Group_1


    // $ANTLR start rule__Alternatives__Group_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2104:1: rule__Alternatives__Group_1_1 : ( '|' ) ( ( ( ruleGroup ) ) ) ;
    public final void rule__Alternatives__Group_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2108:1: ( ( '|' ) ( ( ( ruleGroup ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2109:1: ( '|' ) ( ( ( ruleGroup ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2109:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2110:1: '|'
            {
             before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,31,FOLLOW_31_in_rule__Alternatives__Group_1_14734); 
             after(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2115:1: ( ( ( ruleGroup ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2116:1: ( ( ruleGroup ) )
            {
             before(grammarAccess.getAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2117:1: ( ( ruleGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2118:1: ( ruleGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2118:1: ( ruleGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2119:1: ruleGroup
            {
             before(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleGroup_in_rule__Alternatives__Group_1_14753);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0()); 

            }


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
    // $ANTLR end rule__Alternatives__Group_1_1


    // $ANTLR start rule__Group__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2131:1: rule__Group__Group : ( ruleAbstractToken ) ( ( rule__Group__Group_1 )? ) ;
    public final void rule__Group__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2135:1: ( ( ruleAbstractToken ) ( ( rule__Group__Group_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2136:1: ( ruleAbstractToken ) ( ( rule__Group__Group_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2136:1: ( ruleAbstractToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2137:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAbstractToken_in_rule__Group__Group4791);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2140:1: ( ( rule__Group__Group_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2141:1: ( rule__Group__Group_1 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2142:1: ( rule__Group__Group_1 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_STRING && LA31_0<=RULE_ID)||LA31_0==21||LA31_0==32) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2142:2: rule__Group__Group_1
                    {
                    pushFollow(FOLLOW_rule__Group__Group_1_in_rule__Group__Group4801);
                    rule__Group__Group_1();
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
    // $ANTLR end rule__Group__Group


    // $ANTLR start rule__Group__Group_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2150:1: rule__Group__Group_1 : ( () ) ( ( ( ruleAbstractToken ) )+ ) ;
    public final void rule__Group__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2154:1: ( ( () ) ( ( ( ruleAbstractToken ) )+ ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2155:1: ( () ) ( ( ( ruleAbstractToken ) )+ )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2155:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2156:1: ()
            {
             before(grammarAccess.getGroupAccess().getGroupTokensAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2157:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2159:1: 
            {
            }

             after(grammarAccess.getGroupAccess().getGroupTokensAction_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2161:1: ( ( ( ruleAbstractToken ) )+ )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2162:1: ( ( ruleAbstractToken ) )+
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2163:1: ( ( ruleAbstractToken ) )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_ID)||LA32_0==21||LA32_0==32) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2164:1: ( ruleAbstractToken )
            	    {
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2164:1: ( ruleAbstractToken )
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2165:1: ruleAbstractToken
            	    {
            	     before(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0()); 
            	    pushFollow(FOLLOW_ruleAbstractToken_in_rule__Group__Group_14853);
            	    ruleAbstractToken();
            	    _fsp--;

            	     after(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0()); 

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

             after(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Group__Group_1


    // $ANTLR start rule__AbstractTokenWithCardinality__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2177:1: rule__AbstractTokenWithCardinality__Group : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) ( ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2181:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) ( ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2182:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) ( ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2182:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2183:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2184:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2184:2: rule__AbstractTokenWithCardinality__Alternatives_0
            {
            pushFollow(FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group4892);
            rule__AbstractTokenWithCardinality__Alternatives_0();
            _fsp--;


            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2186:1: ( ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2187:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2188:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=11 && LA33_0<=13)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2189:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2189:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2190:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2191:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2191:2: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
                    {
                    pushFollow(FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__Group4910);
                    rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0();
                    _fsp--;


                    }

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 

                    }


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
    // $ANTLR end rule__AbstractTokenWithCardinality__Group


    // $ANTLR start rule__Action__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2203:1: rule__Action__Group : ( '{' ) ( ( ( ruleTypeRef ) ) ) ( ( rule__Action__Group_2 )? ) ( '}' ) ;
    public final void rule__Action__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2207:1: ( ( '{' ) ( ( ( ruleTypeRef ) ) ) ( ( rule__Action__Group_2 )? ) ( '}' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2208:1: ( '{' ) ( ( ( ruleTypeRef ) ) ) ( ( rule__Action__Group_2 )? ) ( '}' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2208:1: ( '{' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2209:1: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,32,FOLLOW_32_in_rule__Action__Group4952); 
             after(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2214:1: ( ( ( ruleTypeRef ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2215:1: ( ( ruleTypeRef ) )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2216:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2217:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2217:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2218:1: ruleTypeRef
            {
             before(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTypeRef_in_rule__Action__Group4971);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 

            }


            }

             after(grammarAccess.getActionAccess().getTypeAssignment_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2224:1: ( ( rule__Action__Group_2 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2225:1: ( rule__Action__Group_2 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2226:1: ( rule__Action__Group_2 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==23) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2226:2: rule__Action__Group_2
                    {
                    pushFollow(FOLLOW_rule__Action__Group_2_in_rule__Action__Group4988);
                    rule__Action__Group_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_2()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2228:1: ( '}' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2229:1: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,33,FOLLOW_33_in_rule__Action__Group5001); 
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
    // $ANTLR end rule__Action__Group


    // $ANTLR start rule__Action__Group_2
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2240:1: rule__Action__Group_2 : ( '.' ) ( ( ( RULE_ID ) ) ) ( ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ) ) ( 'current' ) ;
    public final void rule__Action__Group_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2244:1: ( ( '.' ) ( ( ( RULE_ID ) ) ) ( ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ) ) ( 'current' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2245:1: ( '.' ) ( ( ( RULE_ID ) ) ) ( ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ) ) ( 'current' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2245:1: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2246:1: '.'
            {
             before(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 
            match(input,23,FOLLOW_23_in_rule__Action__Group_25035); 
             after(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2251:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2252:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2253:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2254:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2254:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2255:1: RULE_ID
            {
             before(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Action__Group_25054); 
             after(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 

            }


            }

             after(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2261:1: ( ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2262:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2263:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2264:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2264:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2265:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2266:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2266:2: rule__Action__OperatorAlternatives_2_2_0
            {
            pushFollow(FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__Group_25078);
            rule__Action__OperatorAlternatives_2_2_0();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 

            }


            }

             after(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2272:1: ( 'current' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2273:1: 'current'
            {
             before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 
            match(input,34,FOLLOW_34_in_rule__Action__Group_25098); 
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
    // $ANTLR end rule__Action__Group_2


    // $ANTLR start rule__Assignment__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2284:1: rule__Assignment__Group : ( ( ( RULE_ID ) ) ) ( ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) ) ) ( ( ( ruleAssignableTerminal ) ) ) ;
    public final void rule__Assignment__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2288:1: ( ( ( ( RULE_ID ) ) ) ( ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) ) ) ( ( ( ruleAssignableTerminal ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2289:1: ( ( ( RULE_ID ) ) ) ( ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) ) ) ( ( ( ruleAssignableTerminal ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2289:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2290:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2291:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2292:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2292:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2293:1: RULE_ID
            {
             before(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Assignment__Group5138); 
             after(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 

            }


            }

             after(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2299:1: ( ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2300:1: ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2301:1: ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2302:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2302:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2303:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2304:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2304:2: rule__Assignment__OperatorAlternatives_1_0
            {
            pushFollow(FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__Group5162);
            rule__Assignment__OperatorAlternatives_1_0();
            _fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAlternatives_1_0()); 

            }


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2310:1: ( ( ( ruleAssignableTerminal ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2311:1: ( ( ruleAssignableTerminal ) )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2312:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2313:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2313:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2314:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleAssignableTerminal_in_rule__Assignment__Group5188);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0()); 

            }


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
    // $ANTLR end rule__Assignment__Group


    // $ANTLR start rule__ParenthesizedAssignableElement__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2326:1: rule__ParenthesizedAssignableElement__Group : ( '(' ) ( ruleAssignableAlternatives ) ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2330:1: ( ( '(' ) ( ruleAssignableAlternatives ) ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2331:1: ( '(' ) ( ruleAssignableAlternatives ) ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2331:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2332:1: '('
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group5227); 
             after(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2337:1: ( ruleAssignableAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2338:1: ruleAssignableAlternatives
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group5239);
            ruleAssignableAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2341:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2342:1: ')'
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,22,FOLLOW_22_in_rule__ParenthesizedAssignableElement__Group5250); 
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
    // $ANTLR end rule__ParenthesizedAssignableElement__Group


    // $ANTLR start rule__AssignableAlternatives__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2353:1: rule__AssignableAlternatives__Group : ( ruleAssignableTerminal ) ( ( rule__AssignableAlternatives__Group_1 )? ) ;
    public final void rule__AssignableAlternatives__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2357:1: ( ( ruleAssignableTerminal ) ( ( rule__AssignableAlternatives__Group_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2358:1: ( ruleAssignableTerminal ) ( ( rule__AssignableAlternatives__Group_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2358:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2359:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group5283);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2362:1: ( ( rule__AssignableAlternatives__Group_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2363:1: ( rule__AssignableAlternatives__Group_1 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2364:1: ( rule__AssignableAlternatives__Group_1 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==31) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2364:2: rule__AssignableAlternatives__Group_1
                    {
                    pushFollow(FOLLOW_rule__AssignableAlternatives__Group_1_in_rule__AssignableAlternatives__Group5293);
                    rule__AssignableAlternatives__Group_1();
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
    // $ANTLR end rule__AssignableAlternatives__Group


    // $ANTLR start rule__AssignableAlternatives__Group_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2372:1: rule__AssignableAlternatives__Group_1 : ( () ) ( ( rule__AssignableAlternatives__Group_1_1 )+ ) ;
    public final void rule__AssignableAlternatives__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2376:1: ( ( () ) ( ( rule__AssignableAlternatives__Group_1_1 )+ ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2377:1: ( () ) ( ( rule__AssignableAlternatives__Group_1_1 )+ )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2377:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2378:1: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2379:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2381:1: 
            {
            }

             after(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2383:1: ( ( rule__AssignableAlternatives__Group_1_1 )+ )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2384:1: ( rule__AssignableAlternatives__Group_1_1 )+
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2385:1: ( rule__AssignableAlternatives__Group_1_1 )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==31) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2385:2: rule__AssignableAlternatives__Group_1_1
            	    {
            	    pushFollow(FOLLOW_rule__AssignableAlternatives__Group_1_1_in_rule__AssignableAlternatives__Group_15338);
            	    rule__AssignableAlternatives__Group_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AssignableAlternatives__Group_1


    // $ANTLR start rule__AssignableAlternatives__Group_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2393:1: rule__AssignableAlternatives__Group_1_1 : ( '|' ) ( ( ( ruleAssignableTerminal ) ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2397:1: ( ( '|' ) ( ( ( ruleAssignableTerminal ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2398:1: ( '|' ) ( ( ( ruleAssignableTerminal ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2398:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2399:1: '|'
            {
             before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,31,FOLLOW_31_in_rule__AssignableAlternatives__Group_1_15372); 
             after(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2404:1: ( ( ( ruleAssignableTerminal ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2405:1: ( ( ruleAssignableTerminal ) )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2406:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2407:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2407:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2408:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group_1_15391);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0()); 

            }


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
    // $ANTLR end rule__AssignableAlternatives__Group_1_1


    // $ANTLR start rule__CrossReference__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2420:1: rule__CrossReference__Group : ( '[' ) ( ( ( ruleTypeRef ) ) ) ( ( rule__CrossReference__Group_2 )? ) ( ']' ) ;
    public final void rule__CrossReference__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2424:1: ( ( '[' ) ( ( ( ruleTypeRef ) ) ) ( ( rule__CrossReference__Group_2 )? ) ( ']' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2425:1: ( '[' ) ( ( ( ruleTypeRef ) ) ) ( ( rule__CrossReference__Group_2 )? ) ( ']' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2425:1: ( '[' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2426:1: '['
            {
             before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__CrossReference__Group5430); 
             after(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2431:1: ( ( ( ruleTypeRef ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2432:1: ( ( ruleTypeRef ) )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2433:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2434:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2434:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2435:1: ruleTypeRef
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTypeRef_in_rule__CrossReference__Group5449);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 

            }


            }

             after(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2441:1: ( ( rule__CrossReference__Group_2 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2442:1: ( rule__CrossReference__Group_2 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2443:1: ( rule__CrossReference__Group_2 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==31) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2443:2: rule__CrossReference__Group_2
                    {
                    pushFollow(FOLLOW_rule__CrossReference__Group_2_in_rule__CrossReference__Group5466);
                    rule__CrossReference__Group_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCrossReferenceAccess().getGroup_2()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2445:1: ( ']' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2446:1: ']'
            {
             before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 
            match(input,36,FOLLOW_36_in_rule__CrossReference__Group5479); 
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
    // $ANTLR end rule__CrossReference__Group


    // $ANTLR start rule__CrossReference__Group_2
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2457:1: rule__CrossReference__Group_2 : ( '|' ) ( ( ( ruleCrossReferenceableTerminal ) ) ) ;
    public final void rule__CrossReference__Group_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2461:1: ( ( '|' ) ( ( ( ruleCrossReferenceableTerminal ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2462:1: ( '|' ) ( ( ( ruleCrossReferenceableTerminal ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2462:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2463:1: '|'
            {
             before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 
            match(input,31,FOLLOW_31_in_rule__CrossReference__Group_25513); 
             after(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2468:1: ( ( ( ruleCrossReferenceableTerminal ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2469:1: ( ( ruleCrossReferenceableTerminal ) )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2470:1: ( ( ruleCrossReferenceableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2471:1: ( ruleCrossReferenceableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2471:1: ( ruleCrossReferenceableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2472:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__Group_25532);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 

            }


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
    // $ANTLR end rule__CrossReference__Group_2


    // $ANTLR start rule__ParenthesizedCrossReferenceableElement__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2484:1: rule__ParenthesizedCrossReferenceableElement__Group : ( '(' ) ( ruleCrossReferenceableAlternatives ) ( ')' ) ;
    public final void rule__ParenthesizedCrossReferenceableElement__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2488:1: ( ( '(' ) ( ruleCrossReferenceableAlternatives ) ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2489:1: ( '(' ) ( ruleCrossReferenceableAlternatives ) ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2489:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2490:1: '('
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__ParenthesizedCrossReferenceableElement__Group5571); 
             after(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2495:1: ( ruleCrossReferenceableAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2496:1: ruleCrossReferenceableAlternatives
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getCrossReferenceableAlternativesParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleCrossReferenceableAlternatives_in_rule__ParenthesizedCrossReferenceableElement__Group5583);
            ruleCrossReferenceableAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getCrossReferenceableAlternativesParserRuleCall_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2499:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2500:1: ')'
            {
             before(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,22,FOLLOW_22_in_rule__ParenthesizedCrossReferenceableElement__Group5594); 
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
    // $ANTLR end rule__ParenthesizedCrossReferenceableElement__Group


    // $ANTLR start rule__CrossReferenceableAlternatives__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2511:1: rule__CrossReferenceableAlternatives__Group : ( ruleCrossReferenceableTerminal ) ( ( rule__CrossReferenceableAlternatives__Group_1 )? ) ;
    public final void rule__CrossReferenceableAlternatives__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2515:1: ( ( ruleCrossReferenceableTerminal ) ( ( rule__CrossReferenceableAlternatives__Group_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2516:1: ( ruleCrossReferenceableTerminal ) ( ( rule__CrossReferenceableAlternatives__Group_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2516:1: ( ruleCrossReferenceableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2517:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getCrossReferenceableTerminalParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReferenceableAlternatives__Group5627);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getCrossReferenceableTerminalParserRuleCall_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2520:1: ( ( rule__CrossReferenceableAlternatives__Group_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2521:1: ( rule__CrossReferenceableAlternatives__Group_1 )?
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2522:1: ( rule__CrossReferenceableAlternatives__Group_1 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==31) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2522:2: rule__CrossReferenceableAlternatives__Group_1
                    {
                    pushFollow(FOLLOW_rule__CrossReferenceableAlternatives__Group_1_in_rule__CrossReferenceableAlternatives__Group5637);
                    rule__CrossReferenceableAlternatives__Group_1();
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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2530:1: rule__CrossReferenceableAlternatives__Group_1 : ( () ) ( ( rule__CrossReferenceableAlternatives__Group_1_1 )+ ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2534:1: ( ( () ) ( ( rule__CrossReferenceableAlternatives__Group_1_1 )+ ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2535:1: ( () ) ( ( rule__CrossReferenceableAlternatives__Group_1_1 )+ )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2535:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2536:1: ()
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2537:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2539:1: 
            {
            }

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2541:1: ( ( rule__CrossReferenceableAlternatives__Group_1_1 )+ )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2542:1: ( rule__CrossReferenceableAlternatives__Group_1_1 )+
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2543:1: ( rule__CrossReferenceableAlternatives__Group_1_1 )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==31) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2543:2: rule__CrossReferenceableAlternatives__Group_1_1
            	    {
            	    pushFollow(FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1_in_rule__CrossReferenceableAlternatives__Group_15682);
            	    rule__CrossReferenceableAlternatives__Group_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt39 >= 1 ) break loop39;
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
            } while (true);

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__CrossReferenceableAlternatives__Group_1


    // $ANTLR start rule__CrossReferenceableAlternatives__Group_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2551:1: rule__CrossReferenceableAlternatives__Group_1_1 : ( '|' ) ( ( ( ruleCrossReferenceableTerminal ) ) ) ;
    public final void rule__CrossReferenceableAlternatives__Group_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2555:1: ( ( '|' ) ( ( ( ruleCrossReferenceableTerminal ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2556:1: ( '|' ) ( ( ( ruleCrossReferenceableTerminal ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2556:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2557:1: '|'
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,31,FOLLOW_31_in_rule__CrossReferenceableAlternatives__Group_1_15716); 
             after(grammarAccess.getCrossReferenceableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2562:1: ( ( ( ruleCrossReferenceableTerminal ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2563:1: ( ( ruleCrossReferenceableTerminal ) )
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2564:1: ( ( ruleCrossReferenceableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2565:1: ( ruleCrossReferenceableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2565:1: ( ruleCrossReferenceableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2566:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsCrossReferenceableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReferenceableAlternatives__Group_1_15735);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsCrossReferenceableTerminalParserRuleCall_1_1_1_0()); 

            }


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
    // $ANTLR end rule__CrossReferenceableAlternatives__Group_1_1


    // $ANTLR start rule__ParenthesizedElement__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2578:1: rule__ParenthesizedElement__Group : ( '(' ) ( ruleAlternatives ) ( ')' ) ;
    public final void rule__ParenthesizedElement__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2582:1: ( ( '(' ) ( ruleAlternatives ) ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2583:1: ( '(' ) ( ruleAlternatives ) ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2583:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2584:1: '('
            {
             before(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__ParenthesizedElement__Group5774); 
             after(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2589:1: ( ruleAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2590:1: ruleAlternatives
            {
             before(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group5786);
            ruleAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2593:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2594:1: ')'
            {
             before(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 
            match(input,22,FOLLOW_22_in_rule__ParenthesizedElement__Group5797); 
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
    // $ANTLR end rule__ParenthesizedElement__Group


    // $ANTLR start rule__TerminalRule__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2605:1: rule__TerminalRule__Group : ( 'terminal' ) ( ( ( RULE_ID ) ) ) ( ( rule__TerminalRule__Group_2 )? ) ( ':' ) ( ( ( ruleTerminalAlternatives ) ) ) ( ';' ) ;
    public final void rule__TerminalRule__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2609:1: ( ( 'terminal' ) ( ( ( RULE_ID ) ) ) ( ( rule__TerminalRule__Group_2 )? ) ( ':' ) ( ( ( ruleTerminalAlternatives ) ) ) ( ';' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2610:1: ( 'terminal' ) ( ( ( RULE_ID ) ) ) ( ( rule__TerminalRule__Group_2 )? ) ( ':' ) ( ( ( ruleTerminalAlternatives ) ) ) ( ';' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2610:1: ( 'terminal' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2611:1: 'terminal'
            {
             before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 
            match(input,37,FOLLOW_37_in_rule__TerminalRule__Group5831); 
             after(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2616:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2617:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2618:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2619:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2619:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2620:1: RULE_ID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TerminalRule__Group5850); 
             after(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2626:1: ( ( rule__TerminalRule__Group_2 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2627:1: ( rule__TerminalRule__Group_2 )?
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2628:1: ( rule__TerminalRule__Group_2 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==29) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2628:2: rule__TerminalRule__Group_2
                    {
                    pushFollow(FOLLOW_rule__TerminalRule__Group_2_in_rule__TerminalRule__Group5867);
                    rule__TerminalRule__Group_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalRuleAccess().getGroup_2()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2630:1: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2631:1: ':'
            {
             before(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__TerminalRule__Group5880); 
             after(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2636:1: ( ( ( ruleTerminalAlternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2637:1: ( ( ruleTerminalAlternatives ) )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2638:1: ( ( ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2639:1: ( ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2639:1: ( ruleTerminalAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2640:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__Group5899);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 

            }


            }

             after(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2646:1: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2647:1: ';'
            {
             before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); 
            match(input,28,FOLLOW_28_in_rule__TerminalRule__Group5917); 
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
    // $ANTLR end rule__TerminalRule__Group


    // $ANTLR start rule__TerminalRule__Group_2
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2658:1: rule__TerminalRule__Group_2 : ( 'returns' ) ( ( ( ruleTypeRef ) ) ) ;
    public final void rule__TerminalRule__Group_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2662:1: ( ( 'returns' ) ( ( ( ruleTypeRef ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2663:1: ( 'returns' ) ( ( ( ruleTypeRef ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2663:1: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2664:1: 'returns'
            {
             before(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0()); 
            match(input,29,FOLLOW_29_in_rule__TerminalRule__Group_25951); 
             after(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2669:1: ( ( ( ruleTypeRef ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2670:1: ( ( ruleTypeRef ) )
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2671:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2672:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2672:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2673:1: ruleTypeRef
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleTypeRef_in_rule__TerminalRule__Group_25970);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 

            }


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
    // $ANTLR end rule__TerminalRule__Group_2


    // $ANTLR start rule__TerminalAlternatives__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2685:1: rule__TerminalAlternatives__Group : ( ruleTerminalGroup ) ( ( rule__TerminalAlternatives__Group_1 )? ) ;
    public final void rule__TerminalAlternatives__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2689:1: ( ( ruleTerminalGroup ) ( ( rule__TerminalAlternatives__Group_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2690:1: ( ruleTerminalGroup ) ( ( rule__TerminalAlternatives__Group_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2690:1: ( ruleTerminalGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2691:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group6008);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2694:1: ( ( rule__TerminalAlternatives__Group_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2695:1: ( rule__TerminalAlternatives__Group_1 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2696:1: ( rule__TerminalAlternatives__Group_1 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==31) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2696:2: rule__TerminalAlternatives__Group_1
                    {
                    pushFollow(FOLLOW_rule__TerminalAlternatives__Group_1_in_rule__TerminalAlternatives__Group6018);
                    rule__TerminalAlternatives__Group_1();
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
    // $ANTLR end rule__TerminalAlternatives__Group


    // $ANTLR start rule__TerminalAlternatives__Group_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2704:1: rule__TerminalAlternatives__Group_1 : ( () ) ( ( rule__TerminalAlternatives__Group_1_1 )+ ) ;
    public final void rule__TerminalAlternatives__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2708:1: ( ( () ) ( ( rule__TerminalAlternatives__Group_1_1 )+ ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2709:1: ( () ) ( ( rule__TerminalAlternatives__Group_1_1 )+ )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2709:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2710:1: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2711:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2713:1: 
            {
            }

             after(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2715:1: ( ( rule__TerminalAlternatives__Group_1_1 )+ )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2716:1: ( rule__TerminalAlternatives__Group_1_1 )+
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2717:1: ( rule__TerminalAlternatives__Group_1_1 )+
            int cnt42=0;
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==31) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2717:2: rule__TerminalAlternatives__Group_1_1
            	    {
            	    pushFollow(FOLLOW_rule__TerminalAlternatives__Group_1_1_in_rule__TerminalAlternatives__Group_16063);
            	    rule__TerminalAlternatives__Group_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt42 >= 1 ) break loop42;
                        EarlyExitException eee =
                            new EarlyExitException(42, input);
                        throw eee;
                }
                cnt42++;
            } while (true);

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TerminalAlternatives__Group_1


    // $ANTLR start rule__TerminalAlternatives__Group_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2725:1: rule__TerminalAlternatives__Group_1_1 : ( '|' ) ( ( ( ruleTerminalGroup ) ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2729:1: ( ( '|' ) ( ( ( ruleTerminalGroup ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2730:1: ( '|' ) ( ( ( ruleTerminalGroup ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2730:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2731:1: '|'
            {
             before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,31,FOLLOW_31_in_rule__TerminalAlternatives__Group_1_16097); 
             after(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2736:1: ( ( ( ruleTerminalGroup ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2737:1: ( ( ruleTerminalGroup ) )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2738:1: ( ( ruleTerminalGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2739:1: ( ruleTerminalGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2739:1: ( ruleTerminalGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2740:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group_1_16116);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0()); 

            }


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
    // $ANTLR end rule__TerminalAlternatives__Group_1_1


    // $ANTLR start rule__TerminalGroup__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2752:1: rule__TerminalGroup__Group : ( ruleTerminalToken ) ( ( rule__TerminalGroup__Group_1 )? ) ;
    public final void rule__TerminalGroup__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2756:1: ( ( ruleTerminalToken ) ( ( rule__TerminalGroup__Group_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2757:1: ( ruleTerminalToken ) ( ( rule__TerminalGroup__Group_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2757:1: ( ruleTerminalToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2758:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group6154);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2761:1: ( ( rule__TerminalGroup__Group_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2762:1: ( rule__TerminalGroup__Group_1 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2763:1: ( rule__TerminalGroup__Group_1 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_STRING && LA43_0<=RULE_ID)||LA43_0==21||LA43_0==23||(LA43_0>=38 && LA43_0<=39)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2763:2: rule__TerminalGroup__Group_1
                    {
                    pushFollow(FOLLOW_rule__TerminalGroup__Group_1_in_rule__TerminalGroup__Group6164);
                    rule__TerminalGroup__Group_1();
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
    // $ANTLR end rule__TerminalGroup__Group


    // $ANTLR start rule__TerminalGroup__Group_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2771:1: rule__TerminalGroup__Group_1 : ( () ) ( ( ( ruleTerminalToken ) )+ ) ;
    public final void rule__TerminalGroup__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2775:1: ( ( () ) ( ( ( ruleTerminalToken ) )+ ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2776:1: ( () ) ( ( ( ruleTerminalToken ) )+ )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2776:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2777:1: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2778:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2780:1: 
            {
            }

             after(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2782:1: ( ( ( ruleTerminalToken ) )+ )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2783:1: ( ( ruleTerminalToken ) )+
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2784:1: ( ( ruleTerminalToken ) )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_ID)||LA44_0==21||LA44_0==23||(LA44_0>=38 && LA44_0<=39)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2785:1: ( ruleTerminalToken )
            	    {
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2785:1: ( ruleTerminalToken )
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2786:1: ruleTerminalToken
            	    {
            	     before(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0()); 
            	    pushFollow(FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group_16216);
            	    ruleTerminalToken();
            	    _fsp--;

            	     after(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0()); 

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt44 >= 1 ) break loop44;
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
            } while (true);

             after(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TerminalGroup__Group_1


    // $ANTLR start rule__TerminalToken__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2798:1: rule__TerminalToken__Group : ( ruleTerminalTokenElement ) ( ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )? ) ;
    public final void rule__TerminalToken__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2802:1: ( ( ruleTerminalTokenElement ) ( ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2803:1: ( ruleTerminalTokenElement ) ( ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2803:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2804:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group6255);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2807:1: ( ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2808:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2809:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=11 && LA45_0<=13)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2810:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2810:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2811:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2812:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2812:2: rule__TerminalToken__CardinalityAlternatives_1_0
                    {
                    pushFollow(FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__Group6272);
                    rule__TerminalToken__CardinalityAlternatives_1_0();
                    _fsp--;


                    }

                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 

                    }


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
    // $ANTLR end rule__TerminalToken__Group


    // $ANTLR start rule__ParenthesizedTerminalElement__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2824:1: rule__ParenthesizedTerminalElement__Group : ( '(' ) ( ruleTerminalAlternatives ) ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2828:1: ( ( '(' ) ( ruleTerminalAlternatives ) ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2829:1: ( '(' ) ( ruleTerminalAlternatives ) ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2829:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2830:1: '('
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group6314); 
             after(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2835:1: ( ruleTerminalAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2836:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group6326);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2839:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2840:1: ')'
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 
            match(input,22,FOLLOW_22_in_rule__ParenthesizedTerminalElement__Group6337); 
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
    // $ANTLR end rule__ParenthesizedTerminalElement__Group


    // $ANTLR start rule__NegatedToken__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2851:1: rule__NegatedToken__Group : ( '!' ) ( ( ( ruleTerminalTokenElement ) ) ) ;
    public final void rule__NegatedToken__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2855:1: ( ( '!' ) ( ( ( ruleTerminalTokenElement ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2856:1: ( '!' ) ( ( ( ruleTerminalTokenElement ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2856:1: ( '!' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2857:1: '!'
            {
             before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 
            match(input,38,FOLLOW_38_in_rule__NegatedToken__Group6371); 
             after(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2862:1: ( ( ( ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2863:1: ( ( ruleTerminalTokenElement ) )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2864:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2865:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2865:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2866:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__Group6390);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 

            }


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
    // $ANTLR end rule__NegatedToken__Group


    // $ANTLR start rule__UntilToken__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2878:1: rule__UntilToken__Group : ( '->' ) ( ( ( ruleTerminalTokenElement ) ) ) ;
    public final void rule__UntilToken__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2882:1: ( ( '->' ) ( ( ( ruleTerminalTokenElement ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2883:1: ( '->' ) ( ( ( ruleTerminalTokenElement ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2883:1: ( '->' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2884:1: '->'
            {
             before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,39,FOLLOW_39_in_rule__UntilToken__Group6429); 
             after(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2889:1: ( ( ( ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2890:1: ( ( ruleTerminalTokenElement ) )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2891:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2892:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2892:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2893:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__Group6448);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 

            }


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
    // $ANTLR end rule__UntilToken__Group


    // $ANTLR start rule__Wildcard__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2905:1: rule__Wildcard__Group : ( () ) ( '.' ) ;
    public final void rule__Wildcard__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2909:1: ( ( () ) ( '.' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2910:1: ( () ) ( '.' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2910:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2911:1: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2912:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2914:1: 
            {
            }

             after(grammarAccess.getWildcardAccess().getWildcardAction_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2916:1: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2917:1: '.'
            {
             before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            match(input,23,FOLLOW_23_in_rule__Wildcard__Group6499); 
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
    // $ANTLR end rule__Wildcard__Group


    // $ANTLR start rule__CharacterRange__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2928:1: rule__CharacterRange__Group : ( ruleKeyword ) ( ( rule__CharacterRange__Group_1 )? ) ;
    public final void rule__CharacterRange__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2932:1: ( ( ruleKeyword ) ( ( rule__CharacterRange__Group_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2933:1: ( ruleKeyword ) ( ( rule__CharacterRange__Group_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2933:1: ( ruleKeyword )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2934:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__CharacterRange__Group6532);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2937:1: ( ( rule__CharacterRange__Group_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2938:1: ( rule__CharacterRange__Group_1 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2939:1: ( rule__CharacterRange__Group_1 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==40) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2939:2: rule__CharacterRange__Group_1
                    {
                    pushFollow(FOLLOW_rule__CharacterRange__Group_1_in_rule__CharacterRange__Group6542);
                    rule__CharacterRange__Group_1();
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
    // $ANTLR end rule__CharacterRange__Group


    // $ANTLR start rule__CharacterRange__Group_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2947:1: rule__CharacterRange__Group_1 : ( () ) ( '..' ) ( ( ( ruleKeyword ) ) ) ;
    public final void rule__CharacterRange__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2951:1: ( ( () ) ( '..' ) ( ( ( ruleKeyword ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2952:1: ( () ) ( '..' ) ( ( ( ruleKeyword ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2952:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2953:1: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2954:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2956:1: 
            {
            }

             after(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2958:1: ( '..' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2959:1: '..'
            {
             before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,40,FOLLOW_40_in_rule__CharacterRange__Group_16588); 
             after(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2964:1: ( ( ( ruleKeyword ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2965:1: ( ( ruleKeyword ) )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2966:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2967:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2967:1: ( ruleKeyword )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2968:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__CharacterRange__Group_16607);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 

            }


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
    // $ANTLR end rule__CharacterRange__Group_1


    // $ANTLR start rule__EnumRule__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2980:1: rule__EnumRule__Group : ( 'enum' ) ( ( ( RULE_ID ) ) ) ( ( rule__EnumRule__Group_2 )? ) ( ':' ) ( ( ( ruleEnumLiterals ) ) ) ( ';' ) ;
    public final void rule__EnumRule__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2984:1: ( ( 'enum' ) ( ( ( RULE_ID ) ) ) ( ( rule__EnumRule__Group_2 )? ) ( ':' ) ( ( ( ruleEnumLiterals ) ) ) ( ';' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2985:1: ( 'enum' ) ( ( ( RULE_ID ) ) ) ( ( rule__EnumRule__Group_2 )? ) ( ':' ) ( ( ( ruleEnumLiterals ) ) ) ( ';' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2985:1: ( 'enum' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2986:1: 'enum'
            {
             before(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 
            match(input,41,FOLLOW_41_in_rule__EnumRule__Group6646); 
             after(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2991:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2992:1: ( ( RULE_ID ) )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2993:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2994:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2994:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2995:1: RULE_ID
            {
             before(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EnumRule__Group6665); 
             after(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

             after(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3001:1: ( ( rule__EnumRule__Group_2 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3002:1: ( rule__EnumRule__Group_2 )?
            {
             before(grammarAccess.getEnumRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3003:1: ( rule__EnumRule__Group_2 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==29) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3003:2: rule__EnumRule__Group_2
                    {
                    pushFollow(FOLLOW_rule__EnumRule__Group_2_in_rule__EnumRule__Group6682);
                    rule__EnumRule__Group_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumRuleAccess().getGroup_2()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3005:1: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3006:1: ':'
            {
             before(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__EnumRule__Group6695); 
             after(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3011:1: ( ( ( ruleEnumLiterals ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3012:1: ( ( ruleEnumLiterals ) )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3013:1: ( ( ruleEnumLiterals ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3014:1: ( ruleEnumLiterals )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3014:1: ( ruleEnumLiterals )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3015:1: ruleEnumLiterals
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleEnumLiterals_in_rule__EnumRule__Group6714);
            ruleEnumLiterals();
            _fsp--;

             after(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 

            }


            }

             after(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3021:1: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3022:1: ';'
            {
             before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5()); 
            match(input,28,FOLLOW_28_in_rule__EnumRule__Group6732); 
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
    // $ANTLR end rule__EnumRule__Group


    // $ANTLR start rule__EnumRule__Group_2
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3033:1: rule__EnumRule__Group_2 : ( 'returns' ) ( ( ( ruleTypeRef ) ) ) ;
    public final void rule__EnumRule__Group_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3037:1: ( ( 'returns' ) ( ( ( ruleTypeRef ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3038:1: ( 'returns' ) ( ( ( ruleTypeRef ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3038:1: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3039:1: 'returns'
            {
             before(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 
            match(input,29,FOLLOW_29_in_rule__EnumRule__Group_26766); 
             after(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3044:1: ( ( ( ruleTypeRef ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3045:1: ( ( ruleTypeRef ) )
            {
             before(grammarAccess.getEnumRuleAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3046:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3047:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3047:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3048:1: ruleTypeRef
            {
             before(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleTypeRef_in_rule__EnumRule__Group_26785);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 

            }


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
    // $ANTLR end rule__EnumRule__Group_2


    // $ANTLR start rule__EnumLiterals__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3060:1: rule__EnumLiterals__Group : ( ruleEnumLiteralDeclaration ) ( ( rule__EnumLiterals__Group_1 )? ) ;
    public final void rule__EnumLiterals__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3064:1: ( ( ruleEnumLiteralDeclaration ) ( ( rule__EnumLiterals__Group_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3065:1: ( ruleEnumLiteralDeclaration ) ( ( rule__EnumLiterals__Group_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3065:1: ( ruleEnumLiteralDeclaration )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3066:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group6823);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3069:1: ( ( rule__EnumLiterals__Group_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3070:1: ( rule__EnumLiterals__Group_1 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3071:1: ( rule__EnumLiterals__Group_1 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==31) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3071:2: rule__EnumLiterals__Group_1
                    {
                    pushFollow(FOLLOW_rule__EnumLiterals__Group_1_in_rule__EnumLiterals__Group6833);
                    rule__EnumLiterals__Group_1();
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
    // $ANTLR end rule__EnumLiterals__Group


    // $ANTLR start rule__EnumLiterals__Group_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3079:1: rule__EnumLiterals__Group_1 : ( () ) ( ( rule__EnumLiterals__Group_1_1 )+ ) ;
    public final void rule__EnumLiterals__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3083:1: ( ( () ) ( ( rule__EnumLiterals__Group_1_1 )+ ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3084:1: ( () ) ( ( rule__EnumLiterals__Group_1_1 )+ )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3084:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3085:1: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3086:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3088:1: 
            {
            }

             after(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3090:1: ( ( rule__EnumLiterals__Group_1_1 )+ )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3091:1: ( rule__EnumLiterals__Group_1_1 )+
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3092:1: ( rule__EnumLiterals__Group_1_1 )+
            int cnt49=0;
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==31) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3092:2: rule__EnumLiterals__Group_1_1
            	    {
            	    pushFollow(FOLLOW_rule__EnumLiterals__Group_1_1_in_rule__EnumLiterals__Group_16878);
            	    rule__EnumLiterals__Group_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt49 >= 1 ) break loop49;
                        EarlyExitException eee =
                            new EarlyExitException(49, input);
                        throw eee;
                }
                cnt49++;
            } while (true);

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EnumLiterals__Group_1


    // $ANTLR start rule__EnumLiterals__Group_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3100:1: rule__EnumLiterals__Group_1_1 : ( '|' ) ( ( ( ruleEnumLiteralDeclaration ) ) ) ;
    public final void rule__EnumLiterals__Group_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3104:1: ( ( '|' ) ( ( ( ruleEnumLiteralDeclaration ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3105:1: ( '|' ) ( ( ( ruleEnumLiteralDeclaration ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3105:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3106:1: '|'
            {
             before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,31,FOLLOW_31_in_rule__EnumLiterals__Group_1_16912); 
             after(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3111:1: ( ( ( ruleEnumLiteralDeclaration ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3112:1: ( ( ruleEnumLiteralDeclaration ) )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3113:1: ( ( ruleEnumLiteralDeclaration ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3114:1: ( ruleEnumLiteralDeclaration )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3114:1: ( ruleEnumLiteralDeclaration )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3115:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group_1_16931);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 

            }


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
    // $ANTLR end rule__EnumLiterals__Group_1_1


    // $ANTLR start rule__EnumLiteralDeclaration__Group
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3127:1: rule__EnumLiteralDeclaration__Group : ( ( ( ( RULE_ID ) ) ) ) ( ( rule__EnumLiteralDeclaration__Group_1 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3131:1: ( ( ( ( ( RULE_ID ) ) ) ) ( ( rule__EnumLiteralDeclaration__Group_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3132:1: ( ( ( ( RULE_ID ) ) ) ) ( ( rule__EnumLiteralDeclaration__Group_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3132:1: ( ( ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3133:1: ( ( ( RULE_ID ) ) )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3134:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3135:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3135:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3136:1: ( RULE_ID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3137:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3138:1: RULE_ID
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__Group6980); 
             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 

            }


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3146:1: ( ( rule__EnumLiteralDeclaration__Group_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3147:1: ( rule__EnumLiteralDeclaration__Group_1 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3148:1: ( rule__EnumLiteralDeclaration__Group_1 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==14) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3148:2: rule__EnumLiteralDeclaration__Group_1
                    {
                    pushFollow(FOLLOW_rule__EnumLiteralDeclaration__Group_1_in_rule__EnumLiteralDeclaration__Group7001);
                    rule__EnumLiteralDeclaration__Group_1();
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
    // $ANTLR end rule__EnumLiteralDeclaration__Group


    // $ANTLR start rule__EnumLiteralDeclaration__Group_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3156:1: rule__EnumLiteralDeclaration__Group_1 : ( '=' ) ( ( ( ruleKeyword ) ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3160:1: ( ( '=' ) ( ( ( ruleKeyword ) ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3161:1: ( '=' ) ( ( ( ruleKeyword ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3161:1: ( '=' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3162:1: '='
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 
            match(input,14,FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_17035); 
             after(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3167:1: ( ( ( ruleKeyword ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3168:1: ( ( ruleKeyword ) )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3169:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3170:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3170:1: ( ruleKeyword )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3171:1: ruleKeyword
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__Group_17054);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 

            }


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
    // $ANTLR end rule__EnumLiteralDeclaration__Group_1


 

    public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammar67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Grammar__Group_in_ruleGrammar94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GrammarID__Group_in_ruleGrammarID153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration237 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractMetamodelDeclaration__Alternatives_in_ruleAbstractMetamodelDeclaration271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_in_ruleGeneratedMetamodel330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel355 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_in_ruleReferencedMetamodel389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule414 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_in_ruleParserRule448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRef__Group_in_ruleTypeRef507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alternatives__Group_in_ruleAlternatives566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group_in_ruleGroup625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality709 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group_in_ruleAbstractTokenWithCardinality743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction768 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Action__Group_in_ruleAction802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall958 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment1038 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__Group_in_ruleAssignment1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group_in_ruleParenthesizedAssignableElement1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1215 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_in_ruleAssignableAlternatives1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference1274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReference__Group_in_ruleCrossReference1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1333 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal1340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement1392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement1399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedCrossReferenceableElement__Group_in_ruleParenthesizedCrossReferenceableElement1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives1451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_in_ruleCrossReferenceableAlternatives1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedElement__Group_in_ruleParenthesizedElement1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalRule__Group_in_ruleTerminalRule1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1628 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_in_ruleTerminalAlternatives1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalGroup__Group_in_ruleTerminalGroup1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalToken__Group_in_ruleTerminalToken1780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group_in_ruleParenthesizedTerminalElement1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NegatedToken__Group_in_ruleNegatedToken2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken2041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UntilToken__Group_in_ruleUntilToken2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard2100 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard2107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Wildcard__Group_in_ruleWildcard2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2159 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange2166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CharacterRange__Group_in_ruleCharacterRange2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule2218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule2225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumRule__Group_in_ruleEnumRule2252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumLiterals__Group_in_ruleEnumLiterals2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration2343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_in_ruleEnumLiteralDeclaration2370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_rule__AbstractRule__Alternatives2405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_rule__AbstractRule__Alternatives2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumRule_in_rule__AbstractRule__Alternatives2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_rule__AbstractToken__Alternatives2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_rule__AbstractToken__Alternatives2531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_rule__AbstractTokenWithCardinality__Alternatives_02562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_rule__AbstractTokenWithCardinality__Alternatives_02578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Action__OperatorAlternatives_2_2_02682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Action__OperatorAlternatives_2_2_02701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__AbstractTerminal__Alternatives2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_rule__AbstractTerminal__Alternatives2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_rule__AbstractTerminal__Alternatives2766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Assignment__OperatorAlternatives_1_02798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Assignment__OperatorAlternatives_1_02817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Assignment__OperatorAlternatives_1_02836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__AssignableTerminal__Alternatives2869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_rule__AssignableTerminal__Alternatives2885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_rule__AssignableTerminal__Alternatives2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_rule__AssignableTerminal__Alternatives2917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__CrossReferenceableTerminal__Alternatives2948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_rule__CrossReferenceableTerminal__Alternatives2964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_rule__CrossReferenceableTerminal__Alternatives2980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_03012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_03031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_03050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Grammar__Group3227 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__Group3246 = new BitSet(new long[]{0x0000022005140020L});
    public static final BitSet FOLLOW_rule__Grammar__Group_2_in_rule__Grammar__Group3263 = new BitSet(new long[]{0x0000022005100020L});
    public static final BitSet FOLLOW_rule__Grammar__Group_3_in_rule__Grammar__Group3275 = new BitSet(new long[]{0x0000022005000020L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__Group3294 = new BitSet(new long[]{0x0000022005000020L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_rule__Grammar__Group3319 = new BitSet(new long[]{0x0000022000000022L});
    public static final BitSet FOLLOW_18_in_rule__Grammar__Group_23359 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__Group_23382 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__Grammar__Group_2_2_in_rule__Grammar__Group_23403 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_rule__Grammar__Group_2_23437 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__Group_2_23460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Grammar__Group_33514 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rule__Grammar__Group_33539 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_rule__Grammar__Group_3_2_in_rule__Grammar__Group_33551 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_rule__Grammar__Group_33564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__Group_3_23608 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1_in_rule__Grammar__Group_3_23629 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_rule__Grammar__Group_3_2_13663 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__Group_3_2_13686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group3728 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__GrammarID__Group_1_in_rule__GrammarID__Group3738 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_rule__GrammarID__Group_13772 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group_13784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__GeneratedMetamodel__Group3816 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__Group3835 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__Group3863 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3_in_rule__GeneratedMetamodel__Group3884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__GeneratedMetamodel__Group_33918 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__Group_33937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ReferencedMetamodel__Group3976 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__Group3999 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2_in_rule__ReferencedMetamodel__Group4020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ReferencedMetamodel__Group_24054 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__Group_24073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__Group4118 = new BitSet(new long[]{0x0000000028100000L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_1_in_rule__ParserRule__Group4135 = new BitSet(new long[]{0x0000000008100000L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_2_in_rule__ParserRule__Group4147 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rule__ParserRule__Group4160 = new BitSet(new long[]{0x0000000100200030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParserRule__Group4179 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rule__ParserRule__Group4197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ParserRule__Group_14231 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_rule__ParserRule__Group_14250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ParserRule__Group_24300 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rule__ParserRule__Group_24325 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_in_rule__ParserRule__Group_24337 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_rule__ParserRule__Group_24350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__Group_2_24394 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1_in_rule__ParserRule__Group_2_24415 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_rule__ParserRule__Group_2_2_14449 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__Group_2_2_14472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRef__Group_0_in_rule__TypeRef__Group4514 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__Group4537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__Group_04590 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rule__TypeRef__Group_04612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_rule__Alternatives__Group4645 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__Alternatives__Group_1_in_rule__Alternatives__Group4655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alternatives__Group_1_1_in_rule__Alternatives__Group_14700 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__Alternatives__Group_1_14734 = new BitSet(new long[]{0x0000000100200030L});
    public static final BitSet FOLLOW_ruleGroup_in_rule__Alternatives__Group_1_14753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__Group4791 = new BitSet(new long[]{0x0000000100200032L});
    public static final BitSet FOLLOW_rule__Group__Group_1_in_rule__Group__Group4801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__Group_14853 = new BitSet(new long[]{0x0000000100200032L});
    public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group4892 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__Group4910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Action__Group4952 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_rule__Action__Group4971 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_rule__Action__Group_2_in_rule__Action__Group4988 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_rule__Action__Group5001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Action__Group_25035 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Action__Group_25054 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__Group_25078 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_rule__Action__Group_25098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Assignment__Group5138 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__Group5162 = new BitSet(new long[]{0x0000000800200030L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__Assignment__Group5188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group5227 = new BitSet(new long[]{0x0000000800200030L});
    public static final BitSet FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group5239 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_rule__ParenthesizedAssignableElement__Group5250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group5283 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_in_rule__AssignableAlternatives__Group5293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1_in_rule__AssignableAlternatives__Group_15338 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__AssignableAlternatives__Group_1_15372 = new BitSet(new long[]{0x0000000800200030L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group_1_15391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__CrossReference__Group5430 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_rule__CrossReference__Group5449 = new BitSet(new long[]{0x0000001080000000L});
    public static final BitSet FOLLOW_rule__CrossReference__Group_2_in_rule__CrossReference__Group5466 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_rule__CrossReference__Group5479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__CrossReference__Group_25513 = new BitSet(new long[]{0x0000000000200030L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__Group_25532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ParenthesizedCrossReferenceableElement__Group5571 = new BitSet(new long[]{0x0000000000200030L});
    public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_rule__ParenthesizedCrossReferenceableElement__Group5583 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_rule__ParenthesizedCrossReferenceableElement__Group5594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReferenceableAlternatives__Group5627 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1_in_rule__CrossReferenceableAlternatives__Group5637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CrossReferenceableAlternatives__Group_1_1_in_rule__CrossReferenceableAlternatives__Group_15682 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__CrossReferenceableAlternatives__Group_1_15716 = new BitSet(new long[]{0x0000000000200030L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReferenceableAlternatives__Group_1_15735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ParenthesizedElement__Group5774 = new BitSet(new long[]{0x0000000100200030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group5786 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_rule__ParenthesizedElement__Group5797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__TerminalRule__Group5831 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TerminalRule__Group5850 = new BitSet(new long[]{0x0000000028000000L});
    public static final BitSet FOLLOW_rule__TerminalRule__Group_2_in_rule__TerminalRule__Group5867 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rule__TerminalRule__Group5880 = new BitSet(new long[]{0x000000C000A00030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__Group5899 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rule__TerminalRule__Group5917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__TerminalRule__Group_25951 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_rule__TerminalRule__Group_25970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group6008 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_in_rule__TerminalAlternatives__Group6018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1_in_rule__TerminalAlternatives__Group_16063 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__TerminalAlternatives__Group_1_16097 = new BitSet(new long[]{0x000000C000A00030L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group_1_16116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group6154 = new BitSet(new long[]{0x000000C000A00032L});
    public static final BitSet FOLLOW_rule__TerminalGroup__Group_1_in_rule__TerminalGroup__Group6164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group_16216 = new BitSet(new long[]{0x000000C000A00032L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group6255 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__Group6272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group6314 = new BitSet(new long[]{0x000000C000A00030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group6326 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_rule__ParenthesizedTerminalElement__Group6337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__NegatedToken__Group6371 = new BitSet(new long[]{0x000000C000A00030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__Group6390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__UntilToken__Group6429 = new BitSet(new long[]{0x000000C000A00030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__Group6448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Wildcard__Group6499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__Group6532 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_rule__CharacterRange__Group_1_in_rule__CharacterRange__Group6542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__CharacterRange__Group_16588 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__Group_16607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__EnumRule__Group6646 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EnumRule__Group6665 = new BitSet(new long[]{0x0000000028000000L});
    public static final BitSet FOLLOW_rule__EnumRule__Group_2_in_rule__EnumRule__Group6682 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rule__EnumRule__Group6695 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleEnumLiterals_in_rule__EnumRule__Group6714 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rule__EnumRule__Group6732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EnumRule__Group_26766 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_rule__EnumRule__Group_26785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group6823 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_in_rule__EnumLiterals__Group6833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1_in_rule__EnumLiterals__Group_16878 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__EnumLiterals__Group_1_16912 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group_1_16931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__Group6980 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1_in_rule__EnumLiteralDeclaration__Group7001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_17035 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__Group_17054 = new BitSet(new long[]{0x0000000000000002L});

}
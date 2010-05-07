package org.eclipse.xtext.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.services.XtextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtextParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'?'", "'*'", "'+'", "'='", "'+='", "'?='", "'grammar'", "'with'", "','", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "':'", "';'", "'returns'", "'::'", "'|'", "'&'", "'{'", "'}'", "'current'", "'['", "']'", "'terminal'", "'!'", "'->'", "'..'", "'enum'", "'hidden'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalXtextParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g"; }


     
     	private XtextGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(XtextGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:61:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:62:1: ( ruleGrammar EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:63:1: ruleGrammar EOF
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:70:1: ruleGrammar : ( ( rule__Grammar__Group__0 ) ) ;
    public final void ruleGrammar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:74:2: ( ( ( rule__Grammar__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:75:1: ( ( rule__Grammar__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:75:1: ( ( rule__Grammar__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:76:1: ( rule__Grammar__Group__0 )
            {
             before(grammarAccess.getGrammarAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:77:1: ( rule__Grammar__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:77:2: rule__Grammar__Group__0
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:89:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:90:1: ( ruleGrammarID EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:91:1: ruleGrammarID EOF
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:98:1: ruleGrammarID : ( ( rule__GrammarID__Group__0 ) ) ;
    public final void ruleGrammarID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:102:2: ( ( ( rule__GrammarID__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:103:1: ( ( rule__GrammarID__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:103:1: ( ( rule__GrammarID__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:104:1: ( rule__GrammarID__Group__0 )
            {
             before(grammarAccess.getGrammarIDAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:105:1: ( rule__GrammarID__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:105:2: rule__GrammarID__Group__0
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:117:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:118:1: ( ruleAbstractRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:119:1: ruleAbstractRule EOF
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:126:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:130:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:131:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:131:1: ( ( rule__AbstractRule__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:132:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:133:1: ( rule__AbstractRule__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:133:2: rule__AbstractRule__Alternatives
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:145:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:146:1: ( ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:147:1: ruleAbstractMetamodelDeclaration EOF
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:154:1: ruleAbstractMetamodelDeclaration : ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:158:2: ( ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:159:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:159:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:160:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            {
             before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:161:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:161:2: rule__AbstractMetamodelDeclaration__Alternatives
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:173:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:174:1: ( ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:175:1: ruleGeneratedMetamodel EOF
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:182:1: ruleGeneratedMetamodel : ( ( rule__GeneratedMetamodel__Group__0 ) ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:186:2: ( ( ( rule__GeneratedMetamodel__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:187:1: ( ( rule__GeneratedMetamodel__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:187:1: ( ( rule__GeneratedMetamodel__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:188:1: ( rule__GeneratedMetamodel__Group__0 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:189:1: ( rule__GeneratedMetamodel__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:189:2: rule__GeneratedMetamodel__Group__0
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:201:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:202:1: ( ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:203:1: ruleReferencedMetamodel EOF
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:210:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:214:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:215:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:215:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:216:1: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:217:1: ( rule__ReferencedMetamodel__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:217:2: rule__ReferencedMetamodel__Group__0
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:229:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:230:1: ( ruleParserRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:231:1: ruleParserRule EOF
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:238:1: ruleParserRule : ( ( rule__ParserRule__Group__0 ) ) ;
    public final void ruleParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:242:2: ( ( ( rule__ParserRule__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:243:1: ( ( rule__ParserRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:243:1: ( ( rule__ParserRule__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:244:1: ( rule__ParserRule__Group__0 )
            {
             before(grammarAccess.getParserRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:245:1: ( rule__ParserRule__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:245:2: rule__ParserRule__Group__0
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:257:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:258:1: ( ruleTypeRef EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:259:1: ruleTypeRef EOF
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:266:1: ruleTypeRef : ( ( rule__TypeRef__Group__0 ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:270:2: ( ( ( rule__TypeRef__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:271:1: ( ( rule__TypeRef__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:271:1: ( ( rule__TypeRef__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:272:1: ( rule__TypeRef__Group__0 )
            {
             before(grammarAccess.getTypeRefAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:273:1: ( rule__TypeRef__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:273:2: rule__TypeRef__Group__0
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:285:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:286:1: ( ruleAlternatives EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:287:1: ruleAlternatives EOF
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:294:1: ruleAlternatives : ( ( rule__Alternatives__Group__0 ) ) ;
    public final void ruleAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:298:2: ( ( ( rule__Alternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:299:1: ( ( rule__Alternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:299:1: ( ( rule__Alternatives__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:300:1: ( rule__Alternatives__Group__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:301:1: ( rule__Alternatives__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:301:2: rule__Alternatives__Group__0
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


    // $ANTLR start entryRuleUnorderedGroup
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:313:1: entryRuleUnorderedGroup : ruleUnorderedGroup EOF ;
    public final void entryRuleUnorderedGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:314:1: ( ruleUnorderedGroup EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:315:1: ruleUnorderedGroup EOF
            {
             before(grammarAccess.getUnorderedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup601);
            ruleUnorderedGroup();
            _fsp--;

             after(grammarAccess.getUnorderedGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedGroup608); 

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
    // $ANTLR end entryRuleUnorderedGroup


    // $ANTLR start ruleUnorderedGroup
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:322:1: ruleUnorderedGroup : ( ( rule__UnorderedGroup__Group__0 ) ) ;
    public final void ruleUnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:326:2: ( ( ( rule__UnorderedGroup__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:327:1: ( ( rule__UnorderedGroup__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:327:1: ( ( rule__UnorderedGroup__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:328:1: ( rule__UnorderedGroup__Group__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:329:1: ( rule__UnorderedGroup__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:329:2: rule__UnorderedGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group__0_in_ruleUnorderedGroup634);
            rule__UnorderedGroup__Group__0();
            _fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleUnorderedGroup


    // $ANTLR start entryRuleGroup
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:341:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:342:1: ( ruleGroup EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:343:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_entryRuleGroup661);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroup668); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:350:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:354:2: ( ( ( rule__Group__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:355:1: ( ( rule__Group__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:355:1: ( ( rule__Group__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:356:1: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:357:1: ( rule__Group__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:357:2: rule__Group__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__0_in_ruleGroup694);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:369:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:370:1: ( ruleAbstractToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:371:1: ruleAbstractToken EOF
            {
             before(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken721);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getAbstractTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractToken728); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:378:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:382:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:383:1: ( ( rule__AbstractToken__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:383:1: ( ( rule__AbstractToken__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:384:1: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:385:1: ( rule__AbstractToken__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:385:2: rule__AbstractToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken754);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:397:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:398:1: ( ruleAbstractTokenWithCardinality EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:399:1: ruleAbstractTokenWithCardinality EOF
            {
             before(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality781);
            ruleAbstractTokenWithCardinality();
            _fsp--;

             after(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality788); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:406:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:410:2: ( ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:411:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:411:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:412:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:413:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:413:2: rule__AbstractTokenWithCardinality__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__0_in_ruleAbstractTokenWithCardinality814);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:425:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:426:1: ( ruleAction EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:427:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction841);
            ruleAction();
            _fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction848); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:434:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:438:2: ( ( ( rule__Action__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:439:1: ( ( rule__Action__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:439:1: ( ( rule__Action__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:440:1: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:441:1: ( rule__Action__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:441:2: rule__Action__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__0_in_ruleAction874);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:453:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:454:1: ( ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:455:1: ruleAbstractTerminal EOF
            {
             before(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal901);
            ruleAbstractTerminal();
            _fsp--;

             after(grammarAccess.getAbstractTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTerminal908); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:462:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:466:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:467:1: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:467:1: ( ( rule__AbstractTerminal__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:468:1: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:469:1: ( rule__AbstractTerminal__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:469:2: rule__AbstractTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal934);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:481:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:482:1: ( ruleKeyword EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:483:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_entryRuleKeyword961);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeyword968); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:490:1: ruleKeyword : ( ( rule__Keyword__ValueAssignment ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:494:2: ( ( ( rule__Keyword__ValueAssignment ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:495:1: ( ( rule__Keyword__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:495:1: ( ( rule__Keyword__ValueAssignment ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:496:1: ( rule__Keyword__ValueAssignment )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:497:1: ( rule__Keyword__ValueAssignment )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:497:2: rule__Keyword__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Keyword__ValueAssignment_in_ruleKeyword994);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:509:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:510:1: ( ruleRuleCall EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:511:1: ruleRuleCall EOF
            {
             before(grammarAccess.getRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_entryRuleRuleCall1021);
            ruleRuleCall();
            _fsp--;

             after(grammarAccess.getRuleCallRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCall1028); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:518:1: ruleRuleCall : ( ( rule__RuleCall__RuleAssignment ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:522:2: ( ( ( rule__RuleCall__RuleAssignment ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:523:1: ( ( rule__RuleCall__RuleAssignment ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:523:1: ( ( rule__RuleCall__RuleAssignment ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:524:1: ( rule__RuleCall__RuleAssignment )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:525:1: ( rule__RuleCall__RuleAssignment )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:525:2: rule__RuleCall__RuleAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__RuleCall__RuleAssignment_in_ruleRuleCall1054);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:537:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:538:1: ( ruleAssignment EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:539:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment1081);
            ruleAssignment();
            _fsp--;

             after(grammarAccess.getAssignmentRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment1088); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:546:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:550:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:551:1: ( ( rule__Assignment__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:551:1: ( ( rule__Assignment__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:552:1: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:553:1: ( rule__Assignment__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:553:2: rule__Assignment__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__0_in_ruleAssignment1114);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:565:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:566:1: ( ruleAssignableTerminal EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:567:1: ruleAssignableTerminal EOF
            {
             before(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1141);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableTerminal1148); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:574:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:578:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:579:1: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:579:1: ( ( rule__AssignableTerminal__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:580:1: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:581:1: ( rule__AssignableTerminal__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:581:2: rule__AssignableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1174);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:593:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:594:1: ( ruleParenthesizedAssignableElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:595:1: ruleParenthesizedAssignableElement EOF
            {
             before(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1201);
            ruleParenthesizedAssignableElement();
            _fsp--;

             after(grammarAccess.getParenthesizedAssignableElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement1208); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:602:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:606:2: ( ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:607:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:607:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:608:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:609:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:609:2: rule__ParenthesizedAssignableElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__0_in_ruleParenthesizedAssignableElement1234);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:621:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:622:1: ( ruleAssignableAlternatives EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:623:1: ruleAssignableAlternatives EOF
            {
             before(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1261);
            ruleAssignableAlternatives();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableAlternatives1268); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:630:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group__0 ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:634:2: ( ( ( rule__AssignableAlternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:635:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:635:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:636:1: ( rule__AssignableAlternatives__Group__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:637:1: ( rule__AssignableAlternatives__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:637:2: rule__AssignableAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__0_in_ruleAssignableAlternatives1294);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:649:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:650:1: ( ruleCrossReference EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:651:1: ruleCrossReference EOF
            {
             before(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_entryRuleCrossReference1321);
            ruleCrossReference();
            _fsp--;

             after(grammarAccess.getCrossReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReference1328); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:658:1: ruleCrossReference : ( ( rule__CrossReference__Group__0 ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:662:2: ( ( ( rule__CrossReference__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:663:1: ( ( rule__CrossReference__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:663:1: ( ( rule__CrossReference__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:664:1: ( rule__CrossReference__Group__0 )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:665:1: ( rule__CrossReference__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:665:2: rule__CrossReference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__0_in_ruleCrossReference1354);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:677:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:678:1: ( ruleCrossReferenceableTerminal EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:679:1: ruleCrossReferenceableTerminal EOF
            {
             before(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1381);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceableTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal1388); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:686:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:690:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:691:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:691:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:692:1: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:693:1: ( rule__CrossReferenceableTerminal__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:693:2: rule__CrossReferenceableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1414);
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


    // $ANTLR start entryRuleParenthesizedElement
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:705:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:706:1: ( ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:707:1: ruleParenthesizedElement EOF
            {
             before(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1441);
            ruleParenthesizedElement();
            _fsp--;

             after(grammarAccess.getParenthesizedElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedElement1448); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:714:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group__0 ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:718:2: ( ( ( rule__ParenthesizedElement__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:719:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:719:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:720:1: ( rule__ParenthesizedElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:721:1: ( rule__ParenthesizedElement__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:721:2: rule__ParenthesizedElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__0_in_ruleParenthesizedElement1474);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:733:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:734:1: ( ruleTerminalRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:735:1: ruleTerminalRule EOF
            {
             before(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1501);
            ruleTerminalRule();
            _fsp--;

             after(grammarAccess.getTerminalRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule1508); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:742:1: ruleTerminalRule : ( ( rule__TerminalRule__Group__0 ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:746:2: ( ( ( rule__TerminalRule__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:747:1: ( ( rule__TerminalRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:747:1: ( ( rule__TerminalRule__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:748:1: ( rule__TerminalRule__Group__0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:749:1: ( rule__TerminalRule__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:749:2: rule__TerminalRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__0_in_ruleTerminalRule1534);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:761:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:762:1: ( ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:763:1: ruleTerminalAlternatives EOF
            {
             before(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1561);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalAlternatives1568); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:770:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group__0 ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:774:2: ( ( ( rule__TerminalAlternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:775:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:775:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:776:1: ( rule__TerminalAlternatives__Group__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:777:1: ( rule__TerminalAlternatives__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:777:2: rule__TerminalAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__0_in_ruleTerminalAlternatives1594);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:789:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:790:1: ( ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:791:1: ruleTerminalGroup EOF
            {
             before(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1621);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalGroup1628); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:798:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group__0 ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:802:2: ( ( ( rule__TerminalGroup__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:803:1: ( ( rule__TerminalGroup__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:803:1: ( ( rule__TerminalGroup__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:804:1: ( rule__TerminalGroup__Group__0 )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:805:1: ( rule__TerminalGroup__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:805:2: rule__TerminalGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__0_in_ruleTerminalGroup1654);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:817:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:818:1: ( ruleTerminalToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:819:1: ruleTerminalToken EOF
            {
             before(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1681);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalToken1688); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:826:1: ruleTerminalToken : ( ( rule__TerminalToken__Group__0 ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:830:2: ( ( ( rule__TerminalToken__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:831:1: ( ( rule__TerminalToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:831:1: ( ( rule__TerminalToken__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:832:1: ( rule__TerminalToken__Group__0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:833:1: ( rule__TerminalToken__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:833:2: rule__TerminalToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__0_in_ruleTerminalToken1714);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:845:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:846:1: ( ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:847:1: ruleTerminalTokenElement EOF
            {
             before(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1741);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getTerminalTokenElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalTokenElement1748); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:854:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:858:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:859:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:859:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:860:1: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:861:1: ( rule__TerminalTokenElement__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:861:2: rule__TerminalTokenElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1774);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:873:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:874:1: ( ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:875:1: ruleParenthesizedTerminalElement EOF
            {
             before(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1801);
            ruleParenthesizedTerminalElement();
            _fsp--;

             after(grammarAccess.getParenthesizedTerminalElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement1808); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:882:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:886:2: ( ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:887:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:887:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:888:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:889:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:889:2: rule__ParenthesizedTerminalElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__0_in_ruleParenthesizedTerminalElement1834);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:901:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:902:1: ( ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:903:1: ruleAbstractNegatedToken EOF
            {
             before(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1861);
            ruleAbstractNegatedToken();
            _fsp--;

             after(grammarAccess.getAbstractNegatedTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractNegatedToken1868); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:910:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:914:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:915:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:915:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:916:1: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:917:1: ( rule__AbstractNegatedToken__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:917:2: rule__AbstractNegatedToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1894);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:929:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:930:1: ( ruleNegatedToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:931:1: ruleNegatedToken EOF
            {
             before(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1921);
            ruleNegatedToken();
            _fsp--;

             after(grammarAccess.getNegatedTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegatedToken1928); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:938:1: ruleNegatedToken : ( ( rule__NegatedToken__Group__0 ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:942:2: ( ( ( rule__NegatedToken__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:943:1: ( ( rule__NegatedToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:943:1: ( ( rule__NegatedToken__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:944:1: ( rule__NegatedToken__Group__0 )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:945:1: ( rule__NegatedToken__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:945:2: rule__NegatedToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__0_in_ruleNegatedToken1954);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:957:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:958:1: ( ruleUntilToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:959:1: ruleUntilToken EOF
            {
             before(grammarAccess.getUntilTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_entryRuleUntilToken1981);
            ruleUntilToken();
            _fsp--;

             after(grammarAccess.getUntilTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUntilToken1988); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:966:1: ruleUntilToken : ( ( rule__UntilToken__Group__0 ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:970:2: ( ( ( rule__UntilToken__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:971:1: ( ( rule__UntilToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:971:1: ( ( rule__UntilToken__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:972:1: ( rule__UntilToken__Group__0 )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:973:1: ( rule__UntilToken__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:973:2: rule__UntilToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__0_in_ruleUntilToken2014);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:985:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:986:1: ( ruleWildcard EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:987:1: ruleWildcard EOF
            {
             before(grammarAccess.getWildcardRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_entryRuleWildcard2041);
            ruleWildcard();
            _fsp--;

             after(grammarAccess.getWildcardRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcard2048); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:994:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:998:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:999:1: ( ( rule__Wildcard__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:999:1: ( ( rule__Wildcard__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1000:1: ( rule__Wildcard__Group__0 )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1001:1: ( rule__Wildcard__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1001:2: rule__Wildcard__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__0_in_ruleWildcard2074);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1013:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1014:1: ( ruleCharacterRange EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1015:1: ruleCharacterRange EOF
            {
             before(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2101);
            ruleCharacterRange();
            _fsp--;

             after(grammarAccess.getCharacterRangeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCharacterRange2108); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1022:1: ruleCharacterRange : ( ( rule__CharacterRange__Group__0 ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1026:2: ( ( ( rule__CharacterRange__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1027:1: ( ( rule__CharacterRange__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1027:1: ( ( rule__CharacterRange__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1028:1: ( rule__CharacterRange__Group__0 )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1029:1: ( rule__CharacterRange__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1029:2: rule__CharacterRange__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__0_in_ruleCharacterRange2134);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1041:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1042:1: ( ruleEnumRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1043:1: ruleEnumRule EOF
            {
             before(grammarAccess.getEnumRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_entryRuleEnumRule2161);
            ruleEnumRule();
            _fsp--;

             after(grammarAccess.getEnumRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumRule2168); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1050:1: ruleEnumRule : ( ( rule__EnumRule__Group__0 ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1054:2: ( ( ( rule__EnumRule__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1055:1: ( ( rule__EnumRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1055:1: ( ( rule__EnumRule__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1056:1: ( rule__EnumRule__Group__0 )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1057:1: ( rule__EnumRule__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1057:2: rule__EnumRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__0_in_ruleEnumRule2194);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1069:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1070:1: ( ruleEnumLiterals EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1071:1: ruleEnumLiterals EOF
            {
             before(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2221);
            ruleEnumLiterals();
            _fsp--;

             after(grammarAccess.getEnumLiteralsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiterals2228); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1078:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group__0 ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1082:2: ( ( ( rule__EnumLiterals__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1083:1: ( ( rule__EnumLiterals__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1083:1: ( ( rule__EnumLiterals__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1084:1: ( rule__EnumLiterals__Group__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1085:1: ( rule__EnumLiterals__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1085:2: rule__EnumLiterals__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__0_in_ruleEnumLiterals2254);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1097:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1098:1: ( ruleEnumLiteralDeclaration EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1099:1: ruleEnumLiteralDeclaration EOF
            {
             before(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2281);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration2288); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1106:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group__0 ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1110:2: ( ( ( rule__EnumLiteralDeclaration__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1111:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1111:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1112:1: ( rule__EnumLiteralDeclaration__Group__0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1113:1: ( rule__EnumLiteralDeclaration__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1113:2: rule__EnumLiteralDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__0_in_ruleEnumLiteralDeclaration2314);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1125:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1129:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
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
                    new NoViableAltException("1125:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1130:1: ( ruleParserRule )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1130:1: ( ruleParserRule )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1131:1: ruleParserRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_rule__AbstractRule__Alternatives2350);
                    ruleParserRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1136:6: ( ruleTerminalRule )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1136:6: ( ruleTerminalRule )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1137:1: ruleTerminalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_rule__AbstractRule__Alternatives2367);
                    ruleTerminalRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1142:6: ( ruleEnumRule )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1142:6: ( ruleEnumRule )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1143:1: ruleEnumRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_rule__AbstractRule__Alternatives2384);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1153:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1157:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
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
                    new NoViableAltException("1153:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1158:1: ( ruleGeneratedMetamodel )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1158:1: ( ruleGeneratedMetamodel )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1159:1: ruleGeneratedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2416);
                    ruleGeneratedMetamodel();
                    _fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1164:6: ( ruleReferencedMetamodel )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1164:6: ( ruleReferencedMetamodel )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1165:1: ruleReferencedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2433);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1175:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1179:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_STRING)||LA3_0==20) ) {
                alt3=1;
            }
            else if ( (LA3_0==32) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1175:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1180:1: ( ruleAbstractTokenWithCardinality )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1180:1: ( ruleAbstractTokenWithCardinality )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1181:1: ruleAbstractTokenWithCardinality
                    {
                     before(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_rule__AbstractToken__Alternatives2465);
                    ruleAbstractTokenWithCardinality();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1186:6: ( ruleAction )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1186:6: ( ruleAction )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1187:1: ruleAction
                    {
                     before(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_rule__AbstractToken__Alternatives2482);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1197:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1201:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==EOF||(LA4_1>=RULE_ID && LA4_1<=RULE_STRING)||(LA4_1>=11 && LA4_1<=13)||(LA4_1>=20 && LA4_1<=21)||LA4_1==27||(LA4_1>=30 && LA4_1<=32)) ) {
                    alt4=2;
                }
                else if ( ((LA4_1>=14 && LA4_1<=16)) ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1197:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==RULE_STRING||LA4_0==20) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1197:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1202:1: ( ruleAssignment )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1202:1: ( ruleAssignment )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1203:1: ruleAssignment
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_rule__AbstractTokenWithCardinality__Alternatives_02514);
                    ruleAssignment();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1208:6: ( ruleAbstractTerminal )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1208:6: ( ruleAbstractTerminal )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1209:1: ruleAbstractTerminal
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_rule__AbstractTokenWithCardinality__Alternatives_02531);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1219:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1223:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    new NoViableAltException("1219:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1224:1: ( '?' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1224:1: ( '?' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1225:1: '?'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02564); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1232:6: ( '*' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1232:6: ( '*' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1233:1: '*'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02584); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1240:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1240:6: ( '+' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1241:1: '+'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02604); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1253:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1257:1: ( ( '=' ) | ( '+=' ) )
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
                    new NoViableAltException("1253:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1258:1: ( '=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1258:1: ( '=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1259:1: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Action__OperatorAlternatives_2_2_02639); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1266:6: ( '+=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1266:6: ( '+=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1267:1: '+='
                    {
                     before(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Action__OperatorAlternatives_2_2_02659); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1279:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1283:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) )
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
                    new NoViableAltException("1279:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1284:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1284:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1285:1: ruleKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__AbstractTerminal__Alternatives2693);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1290:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1290:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1291:1: ruleRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__AbstractTerminal__Alternatives2710);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1296:6: ( ruleParenthesizedElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1296:6: ( ruleParenthesizedElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1297:1: ruleParenthesizedElement
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_rule__AbstractTerminal__Alternatives2727);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1307:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1311:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
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
                    new NoViableAltException("1307:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1312:1: ( '+=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1312:1: ( '+=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1313:1: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Assignment__OperatorAlternatives_1_02760); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1320:6: ( '=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1320:6: ( '=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1321:1: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Assignment__OperatorAlternatives_1_02780); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1328:6: ( '?=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1328:6: ( '?=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1329:1: '?='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2()); 
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__Assignment__OperatorAlternatives_1_02800); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1341:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1345:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
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
            case 35:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1341:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1346:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1346:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1347:1: ruleKeyword
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__AssignableTerminal__Alternatives2834);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1352:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1352:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1353:1: ruleRuleCall
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__AssignableTerminal__Alternatives2851);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1358:6: ( ruleParenthesizedAssignableElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1358:6: ( ruleParenthesizedAssignableElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1359:1: ruleParenthesizedAssignableElement
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_rule__AssignableTerminal__Alternatives2868);
                    ruleParenthesizedAssignableElement();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1364:6: ( ruleCrossReference )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1364:6: ( ruleCrossReference )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1365:1: ruleCrossReference
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_rule__AssignableTerminal__Alternatives2885);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1375:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1379:1: ( ( ruleKeyword ) | ( ruleRuleCall ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_STRING) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1375:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1380:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1380:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1381:1: ruleKeyword
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CrossReferenceableTerminal__Alternatives2917);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1386:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1386:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1387:1: ruleRuleCall
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__CrossReferenceableTerminal__Alternatives2934);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1397:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__TerminalToken__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1401:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    new NoViableAltException("1397:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1402:1: ( '?' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1402:1: ( '?' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1403:1: '?'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_02967); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1410:6: ( '*' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1410:6: ( '*' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1411:1: '*'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_02987); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1418:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1418:6: ( '+' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1419:1: '+'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_03007); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1431:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1435:1: ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) )
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
            case 38:
            case 39:
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
                    new NoViableAltException("1431:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1436:1: ( ruleCharacterRange )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1436:1: ( ruleCharacterRange )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1437:1: ruleCharacterRange
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3041);
                    ruleCharacterRange();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1442:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1442:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1443:1: ruleRuleCall
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3058);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1448:6: ( ruleParenthesizedTerminalElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1448:6: ( ruleParenthesizedTerminalElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1449:1: ruleParenthesizedTerminalElement
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3075);
                    ruleParenthesizedTerminalElement();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1454:6: ( ruleAbstractNegatedToken )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1454:6: ( ruleAbstractNegatedToken )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1455:1: ruleAbstractNegatedToken
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3092);
                    ruleAbstractNegatedToken();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1460:6: ( ruleWildcard )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1460:6: ( ruleWildcard )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1461:1: ruleWildcard
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3109);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1471:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1475:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
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
                    new NoViableAltException("1471:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1476:1: ( ruleNegatedToken )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1476:1: ( ruleNegatedToken )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1477:1: ruleNegatedToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3141);
                    ruleNegatedToken();
                    _fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1482:6: ( ruleUntilToken )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1482:6: ( ruleUntilToken )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1483:1: ruleUntilToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3158);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1495:1: rule__Grammar__Group__0 : rule__Grammar__Group__0__Impl rule__Grammar__Group__1 ;
    public final void rule__Grammar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1499:1: ( rule__Grammar__Group__0__Impl rule__Grammar__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1500:2: rule__Grammar__Group__0__Impl rule__Grammar__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__0__Impl_in_rule__Grammar__Group__03188);
            rule__Grammar__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__1_in_rule__Grammar__Group__03191);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1507:1: rule__Grammar__Group__0__Impl : ( 'grammar' ) ;
    public final void rule__Grammar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1511:1: ( ( 'grammar' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1512:1: ( 'grammar' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1512:1: ( 'grammar' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1513:1: 'grammar'
            {
             before(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Grammar__Group__0__Impl3219); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1526:1: rule__Grammar__Group__1 : rule__Grammar__Group__1__Impl rule__Grammar__Group__2 ;
    public final void rule__Grammar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1530:1: ( rule__Grammar__Group__1__Impl rule__Grammar__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1531:2: rule__Grammar__Group__1__Impl rule__Grammar__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__1__Impl_in_rule__Grammar__Group__13250);
            rule__Grammar__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__2_in_rule__Grammar__Group__13253);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1538:1: rule__Grammar__Group__1__Impl : ( ( rule__Grammar__NameAssignment_1 ) ) ;
    public final void rule__Grammar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1542:1: ( ( ( rule__Grammar__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1543:1: ( ( rule__Grammar__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1543:1: ( ( rule__Grammar__NameAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1544:1: ( rule__Grammar__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1545:1: ( rule__Grammar__NameAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1545:2: rule__Grammar__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__NameAssignment_1_in_rule__Grammar__Group__1__Impl3280);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1555:1: rule__Grammar__Group__2 : rule__Grammar__Group__2__Impl rule__Grammar__Group__3 ;
    public final void rule__Grammar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1559:1: ( rule__Grammar__Group__2__Impl rule__Grammar__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1560:2: rule__Grammar__Group__2__Impl rule__Grammar__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__2__Impl_in_rule__Grammar__Group__23310);
            rule__Grammar__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__3_in_rule__Grammar__Group__23313);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1567:1: rule__Grammar__Group__2__Impl : ( ( rule__Grammar__Group_2__0 )? ) ;
    public final void rule__Grammar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1571:1: ( ( ( rule__Grammar__Group_2__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1572:1: ( ( rule__Grammar__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1572:1: ( ( rule__Grammar__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1573:1: ( rule__Grammar__Group_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1574:1: ( rule__Grammar__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1574:2: rule__Grammar__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__0_in_rule__Grammar__Group__2__Impl3340);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1584:1: rule__Grammar__Group__3 : rule__Grammar__Group__3__Impl rule__Grammar__Group__4 ;
    public final void rule__Grammar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1588:1: ( rule__Grammar__Group__3__Impl rule__Grammar__Group__4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1589:2: rule__Grammar__Group__3__Impl rule__Grammar__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__3__Impl_in_rule__Grammar__Group__33371);
            rule__Grammar__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__4_in_rule__Grammar__Group__33374);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1596:1: rule__Grammar__Group__3__Impl : ( ( rule__Grammar__Group_3__0 )? ) ;
    public final void rule__Grammar__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1600:1: ( ( ( rule__Grammar__Group_3__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1601:1: ( ( rule__Grammar__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1601:1: ( ( rule__Grammar__Group_3__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1602:1: ( rule__Grammar__Group_3__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1603:1: ( rule__Grammar__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==42) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1603:2: rule__Grammar__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__0_in_rule__Grammar__Group__3__Impl3401);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1613:1: rule__Grammar__Group__4 : rule__Grammar__Group__4__Impl rule__Grammar__Group__5 ;
    public final void rule__Grammar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1617:1: ( rule__Grammar__Group__4__Impl rule__Grammar__Group__5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1618:2: rule__Grammar__Group__4__Impl rule__Grammar__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__4__Impl_in_rule__Grammar__Group__43432);
            rule__Grammar__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__5_in_rule__Grammar__Group__43435);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1625:1: rule__Grammar__Group__4__Impl : ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) ;
    public final void rule__Grammar__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1629:1: ( ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1630:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1630:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1631:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1632:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23||LA16_0==25) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1632:2: rule__Grammar__MetamodelDeclarationsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__MetamodelDeclarationsAssignment_4_in_rule__Grammar__Group__4__Impl3462);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1642:1: rule__Grammar__Group__5 : rule__Grammar__Group__5__Impl ;
    public final void rule__Grammar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1646:1: ( rule__Grammar__Group__5__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1647:2: rule__Grammar__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__5__Impl_in_rule__Grammar__Group__53493);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1653:1: rule__Grammar__Group__5__Impl : ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) ;
    public final void rule__Grammar__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1657:1: ( ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1658:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1658:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1659:1: ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1659:1: ( ( rule__Grammar__RulesAssignment_5 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1660:1: ( rule__Grammar__RulesAssignment_5 )
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1661:1: ( rule__Grammar__RulesAssignment_5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1661:2: rule__Grammar__RulesAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__5__Impl3522);
            rule__Grammar__RulesAssignment_5();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1664:1: ( ( rule__Grammar__RulesAssignment_5 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1665:1: ( rule__Grammar__RulesAssignment_5 )*
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1666:1: ( rule__Grammar__RulesAssignment_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID||LA17_0==37||LA17_0==41) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1666:2: rule__Grammar__RulesAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__5__Impl3534);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1689:1: rule__Grammar__Group_2__0 : rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 ;
    public final void rule__Grammar__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1693:1: ( rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1694:2: rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__0__Impl_in_rule__Grammar__Group_2__03579);
            rule__Grammar__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__1_in_rule__Grammar__Group_2__03582);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1701:1: rule__Grammar__Group_2__0__Impl : ( 'with' ) ;
    public final void rule__Grammar__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1705:1: ( ( 'with' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1706:1: ( 'with' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1706:1: ( 'with' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1707:1: 'with'
            {
             before(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Grammar__Group_2__0__Impl3610); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1720:1: rule__Grammar__Group_2__1 : rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 ;
    public final void rule__Grammar__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1724:1: ( rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1725:2: rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__1__Impl_in_rule__Grammar__Group_2__13641);
            rule__Grammar__Group_2__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__2_in_rule__Grammar__Group_2__13644);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1732:1: rule__Grammar__Group_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) ;
    public final void rule__Grammar__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1736:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1737:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1737:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1738:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1739:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1739:2: rule__Grammar__UsedGrammarsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_1_in_rule__Grammar__Group_2__1__Impl3671);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1749:1: rule__Grammar__Group_2__2 : rule__Grammar__Group_2__2__Impl ;
    public final void rule__Grammar__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1753:1: ( rule__Grammar__Group_2__2__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1754:2: rule__Grammar__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__2__Impl_in_rule__Grammar__Group_2__23701);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1760:1: rule__Grammar__Group_2__2__Impl : ( ( rule__Grammar__Group_2_2__0 )* ) ;
    public final void rule__Grammar__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1764:1: ( ( ( rule__Grammar__Group_2_2__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1765:1: ( ( rule__Grammar__Group_2_2__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1765:1: ( ( rule__Grammar__Group_2_2__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1766:1: ( rule__Grammar__Group_2_2__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1767:1: ( rule__Grammar__Group_2_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1767:2: rule__Grammar__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__0_in_rule__Grammar__Group_2__2__Impl3728);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1783:1: rule__Grammar__Group_2_2__0 : rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 ;
    public final void rule__Grammar__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1787:1: ( rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1788:2: rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__0__Impl_in_rule__Grammar__Group_2_2__03765);
            rule__Grammar__Group_2_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__1_in_rule__Grammar__Group_2_2__03768);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1795:1: rule__Grammar__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1799:1: ( ( ',' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1800:1: ( ',' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1800:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1801:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Grammar__Group_2_2__0__Impl3796); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1814:1: rule__Grammar__Group_2_2__1 : rule__Grammar__Group_2_2__1__Impl ;
    public final void rule__Grammar__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1818:1: ( rule__Grammar__Group_2_2__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1819:2: rule__Grammar__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__1__Impl_in_rule__Grammar__Group_2_2__13827);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1825:1: rule__Grammar__Group_2_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) ;
    public final void rule__Grammar__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1829:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1830:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1830:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1831:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1832:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1832:2: rule__Grammar__UsedGrammarsAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_2_1_in_rule__Grammar__Group_2_2__1__Impl3854);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1846:1: rule__Grammar__Group_3__0 : rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 ;
    public final void rule__Grammar__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1850:1: ( rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1851:2: rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__0__Impl_in_rule__Grammar__Group_3__03888);
            rule__Grammar__Group_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__1_in_rule__Grammar__Group_3__03891);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1858:1: rule__Grammar__Group_3__0__Impl : ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) ;
    public final void rule__Grammar__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1862:1: ( ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1863:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1863:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1864:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1865:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1865:2: rule__Grammar__DefinesHiddenTokensAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__DefinesHiddenTokensAssignment_3_0_in_rule__Grammar__Group_3__0__Impl3918);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1875:1: rule__Grammar__Group_3__1 : rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 ;
    public final void rule__Grammar__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1879:1: ( rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1880:2: rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__1__Impl_in_rule__Grammar__Group_3__13948);
            rule__Grammar__Group_3__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__2_in_rule__Grammar__Group_3__13951);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1887:1: rule__Grammar__Group_3__1__Impl : ( '(' ) ;
    public final void rule__Grammar__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1891:1: ( ( '(' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1892:1: ( '(' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1892:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1893:1: '('
            {
             before(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Grammar__Group_3__1__Impl3979); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1906:1: rule__Grammar__Group_3__2 : rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 ;
    public final void rule__Grammar__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1910:1: ( rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1911:2: rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__2__Impl_in_rule__Grammar__Group_3__24010);
            rule__Grammar__Group_3__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__3_in_rule__Grammar__Group_3__24013);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1918:1: rule__Grammar__Group_3__2__Impl : ( ( rule__Grammar__Group_3_2__0 )? ) ;
    public final void rule__Grammar__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1922:1: ( ( ( rule__Grammar__Group_3_2__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1923:1: ( ( rule__Grammar__Group_3_2__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1923:1: ( ( rule__Grammar__Group_3_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1924:1: ( rule__Grammar__Group_3_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1925:1: ( rule__Grammar__Group_3_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1925:2: rule__Grammar__Group_3_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__0_in_rule__Grammar__Group_3__2__Impl4040);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1935:1: rule__Grammar__Group_3__3 : rule__Grammar__Group_3__3__Impl ;
    public final void rule__Grammar__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1939:1: ( rule__Grammar__Group_3__3__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1940:2: rule__Grammar__Group_3__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__3__Impl_in_rule__Grammar__Group_3__34071);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1946:1: rule__Grammar__Group_3__3__Impl : ( ')' ) ;
    public final void rule__Grammar__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1950:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1951:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1951:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1952:1: ')'
            {
             before(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Grammar__Group_3__3__Impl4099); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1973:1: rule__Grammar__Group_3_2__0 : rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 ;
    public final void rule__Grammar__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1977:1: ( rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1978:2: rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__0__Impl_in_rule__Grammar__Group_3_2__04138);
            rule__Grammar__Group_3_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__1_in_rule__Grammar__Group_3_2__04141);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1985:1: rule__Grammar__Group_3_2__0__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) ;
    public final void rule__Grammar__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1989:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1990:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1990:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1991:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1992:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:1992:2: rule__Grammar__HiddenTokensAssignment_3_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_0_in_rule__Grammar__Group_3_2__0__Impl4168);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2002:1: rule__Grammar__Group_3_2__1 : rule__Grammar__Group_3_2__1__Impl ;
    public final void rule__Grammar__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2006:1: ( rule__Grammar__Group_3_2__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2007:2: rule__Grammar__Group_3_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__1__Impl_in_rule__Grammar__Group_3_2__14198);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2013:1: rule__Grammar__Group_3_2__1__Impl : ( ( rule__Grammar__Group_3_2_1__0 )* ) ;
    public final void rule__Grammar__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2017:1: ( ( ( rule__Grammar__Group_3_2_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2018:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2018:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2019:1: ( rule__Grammar__Group_3_2_1__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2020:1: ( rule__Grammar__Group_3_2_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==19) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2020:2: rule__Grammar__Group_3_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__0_in_rule__Grammar__Group_3_2__1__Impl4225);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2034:1: rule__Grammar__Group_3_2_1__0 : rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 ;
    public final void rule__Grammar__Group_3_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2038:1: ( rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2039:2: rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__0__Impl_in_rule__Grammar__Group_3_2_1__04260);
            rule__Grammar__Group_3_2_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__1_in_rule__Grammar__Group_3_2_1__04263);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2046:1: rule__Grammar__Group_3_2_1__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_3_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2050:1: ( ( ',' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2051:1: ( ',' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2051:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2052:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Grammar__Group_3_2_1__0__Impl4291); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2065:1: rule__Grammar__Group_3_2_1__1 : rule__Grammar__Group_3_2_1__1__Impl ;
    public final void rule__Grammar__Group_3_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2069:1: ( rule__Grammar__Group_3_2_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2070:2: rule__Grammar__Group_3_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__1__Impl_in_rule__Grammar__Group_3_2_1__14322);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2076:1: rule__Grammar__Group_3_2_1__1__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) ;
    public final void rule__Grammar__Group_3_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2080:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2081:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2081:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2082:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2083:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2083:2: rule__Grammar__HiddenTokensAssignment_3_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_1_1_in_rule__Grammar__Group_3_2_1__1__Impl4349);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2097:1: rule__GrammarID__Group__0 : rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 ;
    public final void rule__GrammarID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2101:1: ( rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2102:2: rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__0__Impl_in_rule__GrammarID__Group__04383);
            rule__GrammarID__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__1_in_rule__GrammarID__Group__04386);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2109:1: rule__GrammarID__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__GrammarID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2113:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2114:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2114:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2115:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GrammarID__Group__0__Impl4413); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2126:1: rule__GrammarID__Group__1 : rule__GrammarID__Group__1__Impl ;
    public final void rule__GrammarID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2130:1: ( rule__GrammarID__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2131:2: rule__GrammarID__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__1__Impl_in_rule__GrammarID__Group__14442);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2137:1: rule__GrammarID__Group__1__Impl : ( ( rule__GrammarID__Group_1__0 )* ) ;
    public final void rule__GrammarID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2141:1: ( ( ( rule__GrammarID__Group_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2142:1: ( ( rule__GrammarID__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2142:1: ( ( rule__GrammarID__Group_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2143:1: ( rule__GrammarID__Group_1__0 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2144:1: ( rule__GrammarID__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2144:2: rule__GrammarID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__0_in_rule__GrammarID__Group__1__Impl4469);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2158:1: rule__GrammarID__Group_1__0 : rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 ;
    public final void rule__GrammarID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2162:1: ( rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2163:2: rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__0__Impl_in_rule__GrammarID__Group_1__04504);
            rule__GrammarID__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__1_in_rule__GrammarID__Group_1__04507);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2170:1: rule__GrammarID__Group_1__0__Impl : ( '.' ) ;
    public final void rule__GrammarID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2174:1: ( ( '.' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2175:1: ( '.' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2175:1: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2176:1: '.'
            {
             before(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__GrammarID__Group_1__0__Impl4535); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2189:1: rule__GrammarID__Group_1__1 : rule__GrammarID__Group_1__1__Impl ;
    public final void rule__GrammarID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2193:1: ( rule__GrammarID__Group_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2194:2: rule__GrammarID__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__1__Impl_in_rule__GrammarID__Group_1__14566);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2200:1: rule__GrammarID__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__GrammarID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2204:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2205:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2205:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2206:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GrammarID__Group_1__1__Impl4593); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2221:1: rule__GeneratedMetamodel__Group__0 : rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 ;
    public final void rule__GeneratedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2225:1: ( rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2226:2: rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__0__Impl_in_rule__GeneratedMetamodel__Group__04626);
            rule__GeneratedMetamodel__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__1_in_rule__GeneratedMetamodel__Group__04629);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2233:1: rule__GeneratedMetamodel__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GeneratedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2237:1: ( ( 'generate' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2238:1: ( 'generate' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2238:1: ( 'generate' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2239:1: 'generate'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__GeneratedMetamodel__Group__0__Impl4657); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2252:1: rule__GeneratedMetamodel__Group__1 : rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 ;
    public final void rule__GeneratedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2256:1: ( rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2257:2: rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__1__Impl_in_rule__GeneratedMetamodel__Group__14688);
            rule__GeneratedMetamodel__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__2_in_rule__GeneratedMetamodel__Group__14691);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2264:1: rule__GeneratedMetamodel__Group__1__Impl : ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2268:1: ( ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2269:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2269:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2270:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2271:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2271:2: rule__GeneratedMetamodel__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__NameAssignment_1_in_rule__GeneratedMetamodel__Group__1__Impl4718);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2281:1: rule__GeneratedMetamodel__Group__2 : rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 ;
    public final void rule__GeneratedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2285:1: ( rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2286:2: rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__2__Impl_in_rule__GeneratedMetamodel__Group__24748);
            rule__GeneratedMetamodel__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__3_in_rule__GeneratedMetamodel__Group__24751);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2293:1: rule__GeneratedMetamodel__Group__2__Impl : ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) ;
    public final void rule__GeneratedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2297:1: ( ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2298:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2298:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2299:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2300:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2300:2: rule__GeneratedMetamodel__EPackageAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__EPackageAssignment_2_in_rule__GeneratedMetamodel__Group__2__Impl4778);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2310:1: rule__GeneratedMetamodel__Group__3 : rule__GeneratedMetamodel__Group__3__Impl ;
    public final void rule__GeneratedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2314:1: ( rule__GeneratedMetamodel__Group__3__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2315:2: rule__GeneratedMetamodel__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__3__Impl_in_rule__GeneratedMetamodel__Group__34808);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2321:1: rule__GeneratedMetamodel__Group__3__Impl : ( ( rule__GeneratedMetamodel__Group_3__0 )? ) ;
    public final void rule__GeneratedMetamodel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2325:1: ( ( ( rule__GeneratedMetamodel__Group_3__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2326:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2326:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2327:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2328:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2328:2: rule__GeneratedMetamodel__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__0_in_rule__GeneratedMetamodel__Group__3__Impl4835);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2346:1: rule__GeneratedMetamodel__Group_3__0 : rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 ;
    public final void rule__GeneratedMetamodel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2350:1: ( rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2351:2: rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__0__Impl_in_rule__GeneratedMetamodel__Group_3__04874);
            rule__GeneratedMetamodel__Group_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__1_in_rule__GeneratedMetamodel__Group_3__04877);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2358:1: rule__GeneratedMetamodel__Group_3__0__Impl : ( 'as' ) ;
    public final void rule__GeneratedMetamodel__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2362:1: ( ( 'as' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2363:1: ( 'as' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2363:1: ( 'as' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2364:1: 'as'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__GeneratedMetamodel__Group_3__0__Impl4905); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2377:1: rule__GeneratedMetamodel__Group_3__1 : rule__GeneratedMetamodel__Group_3__1__Impl ;
    public final void rule__GeneratedMetamodel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2381:1: ( rule__GeneratedMetamodel__Group_3__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2382:2: rule__GeneratedMetamodel__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__1__Impl_in_rule__GeneratedMetamodel__Group_3__14936);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2388:1: rule__GeneratedMetamodel__Group_3__1__Impl : ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2392:1: ( ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2393:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2393:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2394:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2395:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2395:2: rule__GeneratedMetamodel__AliasAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__AliasAssignment_3_1_in_rule__GeneratedMetamodel__Group_3__1__Impl4963);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2409:1: rule__ReferencedMetamodel__Group__0 : rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2413:1: ( rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2414:2: rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__0__Impl_in_rule__ReferencedMetamodel__Group__04997);
            rule__ReferencedMetamodel__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__05000);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2421:1: rule__ReferencedMetamodel__Group__0__Impl : ( 'import' ) ;
    public final void rule__ReferencedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2425:1: ( ( 'import' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2426:1: ( 'import' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2426:1: ( 'import' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2427:1: 'import'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__ReferencedMetamodel__Group__0__Impl5028); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2440:1: rule__ReferencedMetamodel__Group__1 : rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2444:1: ( rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2445:2: rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__1__Impl_in_rule__ReferencedMetamodel__Group__15059);
            rule__ReferencedMetamodel__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__15062);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2452:1: rule__ReferencedMetamodel__Group__1__Impl : ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2456:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2457:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2457:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2458:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2459:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2459:2: rule__ReferencedMetamodel__EPackageAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_1_in_rule__ReferencedMetamodel__Group__1__Impl5089);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2469:1: rule__ReferencedMetamodel__Group__2 : rule__ReferencedMetamodel__Group__2__Impl ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2473:1: ( rule__ReferencedMetamodel__Group__2__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2474:2: rule__ReferencedMetamodel__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__2__Impl_in_rule__ReferencedMetamodel__Group__25119);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2480:1: rule__ReferencedMetamodel__Group__2__Impl : ( ( rule__ReferencedMetamodel__Group_2__0 )? ) ;
    public final void rule__ReferencedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2484:1: ( ( ( rule__ReferencedMetamodel__Group_2__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2485:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2485:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2486:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2487:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==24) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2487:2: rule__ReferencedMetamodel__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__0_in_rule__ReferencedMetamodel__Group__2__Impl5146);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2503:1: rule__ReferencedMetamodel__Group_2__0 : rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 ;
    public final void rule__ReferencedMetamodel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2507:1: ( rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2508:2: rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__0__Impl_in_rule__ReferencedMetamodel__Group_2__05183);
            rule__ReferencedMetamodel__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__1_in_rule__ReferencedMetamodel__Group_2__05186);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2515:1: rule__ReferencedMetamodel__Group_2__0__Impl : ( 'as' ) ;
    public final void rule__ReferencedMetamodel__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2519:1: ( ( 'as' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2520:1: ( 'as' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2520:1: ( 'as' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2521:1: 'as'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__ReferencedMetamodel__Group_2__0__Impl5214); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2534:1: rule__ReferencedMetamodel__Group_2__1 : rule__ReferencedMetamodel__Group_2__1__Impl ;
    public final void rule__ReferencedMetamodel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2538:1: ( rule__ReferencedMetamodel__Group_2__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2539:2: rule__ReferencedMetamodel__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__1__Impl_in_rule__ReferencedMetamodel__Group_2__15245);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2545:1: rule__ReferencedMetamodel__Group_2__1__Impl : ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2549:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2550:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2550:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2551:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2552:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2552:2: rule__ReferencedMetamodel__AliasAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__AliasAssignment_2_1_in_rule__ReferencedMetamodel__Group_2__1__Impl5272);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2566:1: rule__ParserRule__Group__0 : rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 ;
    public final void rule__ParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2570:1: ( rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2571:2: rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__0__Impl_in_rule__ParserRule__Group__05306);
            rule__ParserRule__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__1_in_rule__ParserRule__Group__05309);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2578:1: rule__ParserRule__Group__0__Impl : ( ( rule__ParserRule__NameAssignment_0 ) ) ;
    public final void rule__ParserRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2582:1: ( ( ( rule__ParserRule__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2583:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2583:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2584:1: ( rule__ParserRule__NameAssignment_0 )
            {
             before(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2585:1: ( rule__ParserRule__NameAssignment_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2585:2: rule__ParserRule__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__NameAssignment_0_in_rule__ParserRule__Group__0__Impl5336);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2595:1: rule__ParserRule__Group__1 : rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 ;
    public final void rule__ParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2599:1: ( rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2600:2: rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__1__Impl_in_rule__ParserRule__Group__15366);
            rule__ParserRule__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__2_in_rule__ParserRule__Group__15369);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2607:1: rule__ParserRule__Group__1__Impl : ( ( rule__ParserRule__Group_1__0 )? ) ;
    public final void rule__ParserRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2611:1: ( ( ( rule__ParserRule__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2612:1: ( ( rule__ParserRule__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2612:1: ( ( rule__ParserRule__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2613:1: ( rule__ParserRule__Group_1__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2614:1: ( rule__ParserRule__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==28) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2614:2: rule__ParserRule__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__0_in_rule__ParserRule__Group__1__Impl5396);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2624:1: rule__ParserRule__Group__2 : rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 ;
    public final void rule__ParserRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2628:1: ( rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2629:2: rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__2__Impl_in_rule__ParserRule__Group__25427);
            rule__ParserRule__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__3_in_rule__ParserRule__Group__25430);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2636:1: rule__ParserRule__Group__2__Impl : ( ( rule__ParserRule__Group_2__0 )? ) ;
    public final void rule__ParserRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2640:1: ( ( ( rule__ParserRule__Group_2__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2641:1: ( ( rule__ParserRule__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2641:1: ( ( rule__ParserRule__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2642:1: ( rule__ParserRule__Group_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2643:1: ( rule__ParserRule__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==42) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2643:2: rule__ParserRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__0_in_rule__ParserRule__Group__2__Impl5457);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2653:1: rule__ParserRule__Group__3 : rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 ;
    public final void rule__ParserRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2657:1: ( rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2658:2: rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__3__Impl_in_rule__ParserRule__Group__35488);
            rule__ParserRule__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__4_in_rule__ParserRule__Group__35491);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2665:1: rule__ParserRule__Group__3__Impl : ( ':' ) ;
    public final void rule__ParserRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2669:1: ( ( ':' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2670:1: ( ':' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2670:1: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2671:1: ':'
            {
             before(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__ParserRule__Group__3__Impl5519); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2684:1: rule__ParserRule__Group__4 : rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 ;
    public final void rule__ParserRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2688:1: ( rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2689:2: rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__4__Impl_in_rule__ParserRule__Group__45550);
            rule__ParserRule__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__5_in_rule__ParserRule__Group__45553);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2696:1: rule__ParserRule__Group__4__Impl : ( ( rule__ParserRule__AlternativesAssignment_4 ) ) ;
    public final void rule__ParserRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2700:1: ( ( ( rule__ParserRule__AlternativesAssignment_4 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2701:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2701:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2702:1: ( rule__ParserRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2703:1: ( rule__ParserRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2703:2: rule__ParserRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__AlternativesAssignment_4_in_rule__ParserRule__Group__4__Impl5580);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2713:1: rule__ParserRule__Group__5 : rule__ParserRule__Group__5__Impl ;
    public final void rule__ParserRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2717:1: ( rule__ParserRule__Group__5__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2718:2: rule__ParserRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__5__Impl_in_rule__ParserRule__Group__55610);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2724:1: rule__ParserRule__Group__5__Impl : ( ';' ) ;
    public final void rule__ParserRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2728:1: ( ( ';' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2729:1: ( ';' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2729:1: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2730:1: ';'
            {
             before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__ParserRule__Group__5__Impl5638); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2755:1: rule__ParserRule__Group_1__0 : rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1 ;
    public final void rule__ParserRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2759:1: ( rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2760:2: rule__ParserRule__Group_1__0__Impl rule__ParserRule__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__0__Impl_in_rule__ParserRule__Group_1__05681);
            rule__ParserRule__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__1_in_rule__ParserRule__Group_1__05684);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2767:1: rule__ParserRule__Group_1__0__Impl : ( 'returns' ) ;
    public final void rule__ParserRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2771:1: ( ( 'returns' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2772:1: ( 'returns' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2772:1: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2773:1: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__ParserRule__Group_1__0__Impl5712); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2786:1: rule__ParserRule__Group_1__1 : rule__ParserRule__Group_1__1__Impl ;
    public final void rule__ParserRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2790:1: ( rule__ParserRule__Group_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2791:2: rule__ParserRule__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__1__Impl_in_rule__ParserRule__Group_1__15743);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2797:1: rule__ParserRule__Group_1__1__Impl : ( ( rule__ParserRule__TypeAssignment_1_1 ) ) ;
    public final void rule__ParserRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2801:1: ( ( ( rule__ParserRule__TypeAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2802:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2802:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2803:1: ( rule__ParserRule__TypeAssignment_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2804:1: ( rule__ParserRule__TypeAssignment_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2804:2: rule__ParserRule__TypeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__TypeAssignment_1_1_in_rule__ParserRule__Group_1__1__Impl5770);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2818:1: rule__ParserRule__Group_2__0 : rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 ;
    public final void rule__ParserRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2822:1: ( rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2823:2: rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__0__Impl_in_rule__ParserRule__Group_2__05804);
            rule__ParserRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__1_in_rule__ParserRule__Group_2__05807);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2830:1: rule__ParserRule__Group_2__0__Impl : ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) ;
    public final void rule__ParserRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2834:1: ( ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2835:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2835:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2836:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2837:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2837:2: rule__ParserRule__DefinesHiddenTokensAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__DefinesHiddenTokensAssignment_2_0_in_rule__ParserRule__Group_2__0__Impl5834);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2847:1: rule__ParserRule__Group_2__1 : rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 ;
    public final void rule__ParserRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2851:1: ( rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2852:2: rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__1__Impl_in_rule__ParserRule__Group_2__15864);
            rule__ParserRule__Group_2__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__2_in_rule__ParserRule__Group_2__15867);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2859:1: rule__ParserRule__Group_2__1__Impl : ( '(' ) ;
    public final void rule__ParserRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2863:1: ( ( '(' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2864:1: ( '(' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2864:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2865:1: '('
            {
             before(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParserRule__Group_2__1__Impl5895); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2878:1: rule__ParserRule__Group_2__2 : rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 ;
    public final void rule__ParserRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2882:1: ( rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2883:2: rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__2__Impl_in_rule__ParserRule__Group_2__25926);
            rule__ParserRule__Group_2__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__3_in_rule__ParserRule__Group_2__25929);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2890:1: rule__ParserRule__Group_2__2__Impl : ( ( rule__ParserRule__Group_2_2__0 )? ) ;
    public final void rule__ParserRule__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2894:1: ( ( ( rule__ParserRule__Group_2_2__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2895:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2895:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2896:1: ( rule__ParserRule__Group_2_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2897:1: ( rule__ParserRule__Group_2_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2897:2: rule__ParserRule__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__0_in_rule__ParserRule__Group_2__2__Impl5956);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2907:1: rule__ParserRule__Group_2__3 : rule__ParserRule__Group_2__3__Impl ;
    public final void rule__ParserRule__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2911:1: ( rule__ParserRule__Group_2__3__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2912:2: rule__ParserRule__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__3__Impl_in_rule__ParserRule__Group_2__35987);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2918:1: rule__ParserRule__Group_2__3__Impl : ( ')' ) ;
    public final void rule__ParserRule__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2922:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2923:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2923:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2924:1: ')'
            {
             before(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParserRule__Group_2__3__Impl6015); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2945:1: rule__ParserRule__Group_2_2__0 : rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 ;
    public final void rule__ParserRule__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2949:1: ( rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2950:2: rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__0__Impl_in_rule__ParserRule__Group_2_2__06054);
            rule__ParserRule__Group_2_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__1_in_rule__ParserRule__Group_2_2__06057);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2957:1: rule__ParserRule__Group_2_2__0__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) ;
    public final void rule__ParserRule__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2961:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2962:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2962:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2963:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2964:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2964:2: rule__ParserRule__HiddenTokensAssignment_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_0_in_rule__ParserRule__Group_2_2__0__Impl6084);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2974:1: rule__ParserRule__Group_2_2__1 : rule__ParserRule__Group_2_2__1__Impl ;
    public final void rule__ParserRule__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2978:1: ( rule__ParserRule__Group_2_2__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2979:2: rule__ParserRule__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__1__Impl_in_rule__ParserRule__Group_2_2__16114);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2985:1: rule__ParserRule__Group_2_2__1__Impl : ( ( rule__ParserRule__Group_2_2_1__0 )* ) ;
    public final void rule__ParserRule__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2989:1: ( ( ( rule__ParserRule__Group_2_2_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2990:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2990:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2991:1: ( rule__ParserRule__Group_2_2_1__0 )*
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2992:1: ( rule__ParserRule__Group_2_2_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==19) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:2992:2: rule__ParserRule__Group_2_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__0_in_rule__ParserRule__Group_2_2__1__Impl6141);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3006:1: rule__ParserRule__Group_2_2_1__0 : rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 ;
    public final void rule__ParserRule__Group_2_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3010:1: ( rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3011:2: rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__0__Impl_in_rule__ParserRule__Group_2_2_1__06176);
            rule__ParserRule__Group_2_2_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__1_in_rule__ParserRule__Group_2_2_1__06179);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3018:1: rule__ParserRule__Group_2_2_1__0__Impl : ( ',' ) ;
    public final void rule__ParserRule__Group_2_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3022:1: ( ( ',' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3023:1: ( ',' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3023:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3024:1: ','
            {
             before(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__ParserRule__Group_2_2_1__0__Impl6207); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3037:1: rule__ParserRule__Group_2_2_1__1 : rule__ParserRule__Group_2_2_1__1__Impl ;
    public final void rule__ParserRule__Group_2_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3041:1: ( rule__ParserRule__Group_2_2_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3042:2: rule__ParserRule__Group_2_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__1__Impl_in_rule__ParserRule__Group_2_2_1__16238);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3048:1: rule__ParserRule__Group_2_2_1__1__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_2_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3052:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3053:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3053:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3054:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3055:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3055:2: rule__ParserRule__HiddenTokensAssignment_2_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_1_1_in_rule__ParserRule__Group_2_2_1__1__Impl6265);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3069:1: rule__TypeRef__Group__0 : rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3073:1: ( rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3074:2: rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__0__Impl_in_rule__TypeRef__Group__06299);
            rule__TypeRef__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__1_in_rule__TypeRef__Group__06302);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3081:1: rule__TypeRef__Group__0__Impl : ( ( rule__TypeRef__Group_0__0 )? ) ;
    public final void rule__TypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3085:1: ( ( ( rule__TypeRef__Group_0__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3086:1: ( ( rule__TypeRef__Group_0__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3086:1: ( ( rule__TypeRef__Group_0__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3087:1: ( rule__TypeRef__Group_0__0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3088:1: ( rule__TypeRef__Group_0__0 )?
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
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3088:2: rule__TypeRef__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__0_in_rule__TypeRef__Group__0__Impl6329);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3098:1: rule__TypeRef__Group__1 : rule__TypeRef__Group__1__Impl ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3102:1: ( rule__TypeRef__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3103:2: rule__TypeRef__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__1__Impl_in_rule__TypeRef__Group__16360);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3109:1: rule__TypeRef__Group__1__Impl : ( ( rule__TypeRef__ClassifierAssignment_1 ) ) ;
    public final void rule__TypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3113:1: ( ( ( rule__TypeRef__ClassifierAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3114:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3114:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3115:1: ( rule__TypeRef__ClassifierAssignment_1 )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3116:1: ( rule__TypeRef__ClassifierAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3116:2: rule__TypeRef__ClassifierAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__ClassifierAssignment_1_in_rule__TypeRef__Group__1__Impl6387);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3130:1: rule__TypeRef__Group_0__0 : rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 ;
    public final void rule__TypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3134:1: ( rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3135:2: rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__0__Impl_in_rule__TypeRef__Group_0__06421);
            rule__TypeRef__Group_0__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__1_in_rule__TypeRef__Group_0__06424);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3142:1: rule__TypeRef__Group_0__0__Impl : ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) ;
    public final void rule__TypeRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3146:1: ( ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3147:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3147:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3148:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3149:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3149:2: rule__TypeRef__MetamodelAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__MetamodelAssignment_0_0_in_rule__TypeRef__Group_0__0__Impl6451);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3159:1: rule__TypeRef__Group_0__1 : rule__TypeRef__Group_0__1__Impl ;
    public final void rule__TypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3163:1: ( rule__TypeRef__Group_0__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3164:2: rule__TypeRef__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__1__Impl_in_rule__TypeRef__Group_0__16481);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3170:1: rule__TypeRef__Group_0__1__Impl : ( '::' ) ;
    public final void rule__TypeRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3174:1: ( ( '::' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3175:1: ( '::' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3175:1: ( '::' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3176:1: '::'
            {
             before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__TypeRef__Group_0__1__Impl6509); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3193:1: rule__Alternatives__Group__0 : rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 ;
    public final void rule__Alternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3197:1: ( rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3198:2: rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__0__Impl_in_rule__Alternatives__Group__06544);
            rule__Alternatives__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__1_in_rule__Alternatives__Group__06547);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3205:1: rule__Alternatives__Group__0__Impl : ( ruleUnorderedGroup ) ;
    public final void rule__Alternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3209:1: ( ( ruleUnorderedGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3210:1: ( ruleUnorderedGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3210:1: ( ruleUnorderedGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3211:1: ruleUnorderedGroup
            {
             before(grammarAccess.getAlternativesAccess().getUnorderedGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_rule__Alternatives__Group__0__Impl6574);
            ruleUnorderedGroup();
            _fsp--;

             after(grammarAccess.getAlternativesAccess().getUnorderedGroupParserRuleCall_0()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3222:1: rule__Alternatives__Group__1 : rule__Alternatives__Group__1__Impl ;
    public final void rule__Alternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3226:1: ( rule__Alternatives__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3227:2: rule__Alternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__1__Impl_in_rule__Alternatives__Group__16603);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3233:1: rule__Alternatives__Group__1__Impl : ( ( rule__Alternatives__Group_1__0 )? ) ;
    public final void rule__Alternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3237:1: ( ( ( rule__Alternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3238:1: ( ( rule__Alternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3238:1: ( ( rule__Alternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3239:1: ( rule__Alternatives__Group_1__0 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3240:1: ( rule__Alternatives__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==30) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3240:2: rule__Alternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__0_in_rule__Alternatives__Group__1__Impl6630);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3254:1: rule__Alternatives__Group_1__0 : rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 ;
    public final void rule__Alternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3258:1: ( rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3259:2: rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__0__Impl_in_rule__Alternatives__Group_1__06665);
            rule__Alternatives__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__1_in_rule__Alternatives__Group_1__06668);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3266:1: rule__Alternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__Alternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3270:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3271:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3271:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3272:1: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3273:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3275:1: 
            {
            }

             after(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3285:1: rule__Alternatives__Group_1__1 : rule__Alternatives__Group_1__1__Impl ;
    public final void rule__Alternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3289:1: ( rule__Alternatives__Group_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3290:2: rule__Alternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__1__Impl_in_rule__Alternatives__Group_1__16726);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3296:1: rule__Alternatives__Group_1__1__Impl : ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) ;
    public final void rule__Alternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3300:1: ( ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3301:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3301:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3302:1: ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3302:1: ( ( rule__Alternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3303:1: ( rule__Alternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3304:1: ( rule__Alternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3304:2: rule__Alternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__1__Impl6755);
            rule__Alternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3307:1: ( ( rule__Alternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3308:1: ( rule__Alternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3309:1: ( rule__Alternatives__Group_1_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==30) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3309:2: rule__Alternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__1__Impl6767);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3324:1: rule__Alternatives__Group_1_1__0 : rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 ;
    public final void rule__Alternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3328:1: ( rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3329:2: rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0__Impl_in_rule__Alternatives__Group_1_1__06804);
            rule__Alternatives__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__1_in_rule__Alternatives__Group_1_1__06807);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3336:1: rule__Alternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__Alternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3340:1: ( ( '|' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3341:1: ( '|' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3341:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3342:1: '|'
            {
             before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__Alternatives__Group_1_1__0__Impl6835); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3355:1: rule__Alternatives__Group_1_1__1 : rule__Alternatives__Group_1_1__1__Impl ;
    public final void rule__Alternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3359:1: ( rule__Alternatives__Group_1_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3360:2: rule__Alternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__1__Impl_in_rule__Alternatives__Group_1_1__16866);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3366:1: rule__Alternatives__Group_1_1__1__Impl : ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__Alternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3370:1: ( ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3371:1: ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3371:1: ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3372:1: ( rule__Alternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativesAccess().getElementsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3373:1: ( rule__Alternatives__ElementsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3373:2: rule__Alternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__ElementsAssignment_1_1_1_in_rule__Alternatives__Group_1_1__1__Impl6893);
            rule__Alternatives__ElementsAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
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


    // $ANTLR start rule__UnorderedGroup__Group__0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3387:1: rule__UnorderedGroup__Group__0 : rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1 ;
    public final void rule__UnorderedGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3391:1: ( rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3392:2: rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group__0__Impl_in_rule__UnorderedGroup__Group__06927);
            rule__UnorderedGroup__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group__1_in_rule__UnorderedGroup__Group__06930);
            rule__UnorderedGroup__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__UnorderedGroup__Group__0


    // $ANTLR start rule__UnorderedGroup__Group__0__Impl
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3399:1: rule__UnorderedGroup__Group__0__Impl : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3403:1: ( ( ruleGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3404:1: ( ruleGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3404:1: ( ruleGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3405:1: ruleGroup
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_rule__UnorderedGroup__Group__0__Impl6957);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__UnorderedGroup__Group__0__Impl


    // $ANTLR start rule__UnorderedGroup__Group__1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3416:1: rule__UnorderedGroup__Group__1 : rule__UnorderedGroup__Group__1__Impl ;
    public final void rule__UnorderedGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3420:1: ( rule__UnorderedGroup__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3421:2: rule__UnorderedGroup__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group__1__Impl_in_rule__UnorderedGroup__Group__16986);
            rule__UnorderedGroup__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__UnorderedGroup__Group__1


    // $ANTLR start rule__UnorderedGroup__Group__1__Impl
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3427:1: rule__UnorderedGroup__Group__1__Impl : ( ( rule__UnorderedGroup__Group_1__0 )? ) ;
    public final void rule__UnorderedGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3431:1: ( ( ( rule__UnorderedGroup__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3432:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3432:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3433:1: ( rule__UnorderedGroup__Group_1__0 )?
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3434:1: ( rule__UnorderedGroup__Group_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==31) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3434:2: rule__UnorderedGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1__0_in_rule__UnorderedGroup__Group__1__Impl7013);
                    rule__UnorderedGroup__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__UnorderedGroup__Group__1__Impl


    // $ANTLR start rule__UnorderedGroup__Group_1__0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3448:1: rule__UnorderedGroup__Group_1__0 : rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1 ;
    public final void rule__UnorderedGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3452:1: ( rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3453:2: rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1__0__Impl_in_rule__UnorderedGroup__Group_1__07048);
            rule__UnorderedGroup__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1__1_in_rule__UnorderedGroup__Group_1__07051);
            rule__UnorderedGroup__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__UnorderedGroup__Group_1__0


    // $ANTLR start rule__UnorderedGroup__Group_1__0__Impl
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3460:1: rule__UnorderedGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__UnorderedGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3464:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3465:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3465:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3466:1: ()
            {
             before(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3467:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3469:1: 
            {
            }

             after(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__UnorderedGroup__Group_1__0__Impl


    // $ANTLR start rule__UnorderedGroup__Group_1__1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3479:1: rule__UnorderedGroup__Group_1__1 : rule__UnorderedGroup__Group_1__1__Impl ;
    public final void rule__UnorderedGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3483:1: ( rule__UnorderedGroup__Group_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3484:2: rule__UnorderedGroup__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1__1__Impl_in_rule__UnorderedGroup__Group_1__17109);
            rule__UnorderedGroup__Group_1__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__UnorderedGroup__Group_1__1


    // $ANTLR start rule__UnorderedGroup__Group_1__1__Impl
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3490:1: rule__UnorderedGroup__Group_1__1__Impl : ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) ;
    public final void rule__UnorderedGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3494:1: ( ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3495:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3495:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3496:1: ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3496:1: ( ( rule__UnorderedGroup__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3497:1: ( rule__UnorderedGroup__Group_1_1__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3498:1: ( rule__UnorderedGroup__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3498:2: rule__UnorderedGroup__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__0_in_rule__UnorderedGroup__Group_1__1__Impl7138);
            rule__UnorderedGroup__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3501:1: ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3502:1: ( rule__UnorderedGroup__Group_1_1__0 )*
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3503:1: ( rule__UnorderedGroup__Group_1_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==31) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3503:2: rule__UnorderedGroup__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__0_in_rule__UnorderedGroup__Group_1__1__Impl7150);
            	    rule__UnorderedGroup__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 

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
    // $ANTLR end rule__UnorderedGroup__Group_1__1__Impl


    // $ANTLR start rule__UnorderedGroup__Group_1_1__0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3518:1: rule__UnorderedGroup__Group_1_1__0 : rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1 ;
    public final void rule__UnorderedGroup__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3522:1: ( rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3523:2: rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__0__Impl_in_rule__UnorderedGroup__Group_1_1__07187);
            rule__UnorderedGroup__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__1_in_rule__UnorderedGroup__Group_1_1__07190);
            rule__UnorderedGroup__Group_1_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__UnorderedGroup__Group_1_1__0


    // $ANTLR start rule__UnorderedGroup__Group_1_1__0__Impl
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3530:1: rule__UnorderedGroup__Group_1_1__0__Impl : ( '&' ) ;
    public final void rule__UnorderedGroup__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3534:1: ( ( '&' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3535:1: ( '&' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3535:1: ( '&' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3536:1: '&'
            {
             before(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__UnorderedGroup__Group_1_1__0__Impl7218); 
             after(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__UnorderedGroup__Group_1_1__0__Impl


    // $ANTLR start rule__UnorderedGroup__Group_1_1__1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3549:1: rule__UnorderedGroup__Group_1_1__1 : rule__UnorderedGroup__Group_1_1__1__Impl ;
    public final void rule__UnorderedGroup__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3553:1: ( rule__UnorderedGroup__Group_1_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3554:2: rule__UnorderedGroup__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__1__Impl_in_rule__UnorderedGroup__Group_1_1__17249);
            rule__UnorderedGroup__Group_1_1__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__UnorderedGroup__Group_1_1__1


    // $ANTLR start rule__UnorderedGroup__Group_1_1__1__Impl
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3560:1: rule__UnorderedGroup__Group_1_1__1__Impl : ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__UnorderedGroup__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3564:1: ( ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3565:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3565:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3566:1: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3567:1: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3567:2: rule__UnorderedGroup__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__ElementsAssignment_1_1_1_in_rule__UnorderedGroup__Group_1_1__1__Impl7276);
            rule__UnorderedGroup__ElementsAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__UnorderedGroup__Group_1_1__1__Impl


    // $ANTLR start rule__Group__Group__0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3581:1: rule__Group__Group__0 : rule__Group__Group__0__Impl rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3585:1: ( rule__Group__Group__0__Impl rule__Group__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3586:2: rule__Group__Group__0__Impl rule__Group__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__0__Impl_in_rule__Group__Group__07310);
            rule__Group__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__1_in_rule__Group__Group__07313);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3593:1: rule__Group__Group__0__Impl : ( ruleAbstractToken ) ;
    public final void rule__Group__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3597:1: ( ( ruleAbstractToken ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3598:1: ( ruleAbstractToken )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3598:1: ( ruleAbstractToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3599:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_rule__Group__Group__0__Impl7340);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3610:1: rule__Group__Group__1 : rule__Group__Group__1__Impl ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3614:1: ( rule__Group__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3615:2: rule__Group__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__1__Impl_in_rule__Group__Group__17369);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3621:1: rule__Group__Group__1__Impl : ( ( rule__Group__Group_1__0 )? ) ;
    public final void rule__Group__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3625:1: ( ( ( rule__Group__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3626:1: ( ( rule__Group__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3626:1: ( ( rule__Group__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3627:1: ( rule__Group__Group_1__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3628:1: ( rule__Group__Group_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_ID && LA33_0<=RULE_STRING)||LA33_0==20||LA33_0==32) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3628:2: rule__Group__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__0_in_rule__Group__Group__1__Impl7396);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3642:1: rule__Group__Group_1__0 : rule__Group__Group_1__0__Impl rule__Group__Group_1__1 ;
    public final void rule__Group__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3646:1: ( rule__Group__Group_1__0__Impl rule__Group__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3647:2: rule__Group__Group_1__0__Impl rule__Group__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__0__Impl_in_rule__Group__Group_1__07431);
            rule__Group__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__1_in_rule__Group__Group_1__07434);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3654:1: rule__Group__Group_1__0__Impl : ( () ) ;
    public final void rule__Group__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3658:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3659:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3659:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3660:1: ()
            {
             before(grammarAccess.getGroupAccess().getGroupElementsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3661:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3663:1: 
            {
            }

             after(grammarAccess.getGroupAccess().getGroupElementsAction_1_0()); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3673:1: rule__Group__Group_1__1 : rule__Group__Group_1__1__Impl ;
    public final void rule__Group__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3677:1: ( rule__Group__Group_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3678:2: rule__Group__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__1__Impl_in_rule__Group__Group_1__17492);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3684:1: rule__Group__Group_1__1__Impl : ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__Group__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3688:1: ( ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3689:1: ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3689:1: ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3690:1: ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3690:1: ( ( rule__Group__ElementsAssignment_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3691:1: ( rule__Group__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3692:1: ( rule__Group__ElementsAssignment_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3692:2: rule__Group__ElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__ElementsAssignment_1_1_in_rule__Group__Group_1__1__Impl7521);
            rule__Group__ElementsAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3695:1: ( ( rule__Group__ElementsAssignment_1_1 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3696:1: ( rule__Group__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3697:1: ( rule__Group__ElementsAssignment_1_1 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=RULE_ID && LA34_0<=RULE_STRING)||LA34_0==20||LA34_0==32) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3697:2: rule__Group__ElementsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Group__ElementsAssignment_1_1_in_rule__Group__Group_1__1__Impl7533);
            	    rule__Group__ElementsAssignment_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3712:1: rule__AbstractTokenWithCardinality__Group__0 : rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 ;
    public final void rule__AbstractTokenWithCardinality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3716:1: ( rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3717:2: rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__0__Impl_in_rule__AbstractTokenWithCardinality__Group__07570);
            rule__AbstractTokenWithCardinality__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__1_in_rule__AbstractTokenWithCardinality__Group__07573);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3724:1: rule__AbstractTokenWithCardinality__Group__0__Impl : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3728:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3729:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3729:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3730:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3731:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3731:2: rule__AbstractTokenWithCardinality__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group__0__Impl7600);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3741:1: rule__AbstractTokenWithCardinality__Group__1 : rule__AbstractTokenWithCardinality__Group__1__Impl ;
    public final void rule__AbstractTokenWithCardinality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3745:1: ( rule__AbstractTokenWithCardinality__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3746:2: rule__AbstractTokenWithCardinality__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__1__Impl_in_rule__AbstractTokenWithCardinality__Group__17630);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3752:1: rule__AbstractTokenWithCardinality__Group__1__Impl : ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3756:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3757:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3757:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3758:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3759:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=11 && LA35_0<=13)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3759:2: rule__AbstractTokenWithCardinality__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAssignment_1_in_rule__AbstractTokenWithCardinality__Group__1__Impl7657);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3773:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3777:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3778:2: rule__Action__Group__0__Impl rule__Action__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__0__Impl_in_rule__Action__Group__07692);
            rule__Action__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__1_in_rule__Action__Group__07695);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3785:1: rule__Action__Group__0__Impl : ( '{' ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3789:1: ( ( '{' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3790:1: ( '{' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3790:1: ( '{' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3791:1: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Action__Group__0__Impl7723); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3804:1: rule__Action__Group__1 : rule__Action__Group__1__Impl rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3808:1: ( rule__Action__Group__1__Impl rule__Action__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3809:2: rule__Action__Group__1__Impl rule__Action__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__1__Impl_in_rule__Action__Group__17754);
            rule__Action__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__2_in_rule__Action__Group__17757);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3816:1: rule__Action__Group__1__Impl : ( ( rule__Action__TypeAssignment_1 ) ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3820:1: ( ( ( rule__Action__TypeAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3821:1: ( ( rule__Action__TypeAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3821:1: ( ( rule__Action__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3822:1: ( rule__Action__TypeAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3823:1: ( rule__Action__TypeAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3823:2: rule__Action__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__TypeAssignment_1_in_rule__Action__Group__1__Impl7784);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3833:1: rule__Action__Group__2 : rule__Action__Group__2__Impl rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3837:1: ( rule__Action__Group__2__Impl rule__Action__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3838:2: rule__Action__Group__2__Impl rule__Action__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__2__Impl_in_rule__Action__Group__27814);
            rule__Action__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__3_in_rule__Action__Group__27817);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3845:1: rule__Action__Group__2__Impl : ( ( rule__Action__Group_2__0 )? ) ;
    public final void rule__Action__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3849:1: ( ( ( rule__Action__Group_2__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3850:1: ( ( rule__Action__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3850:1: ( ( rule__Action__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3851:1: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3852:1: ( rule__Action__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==22) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3852:2: rule__Action__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__0_in_rule__Action__Group__2__Impl7844);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3862:1: rule__Action__Group__3 : rule__Action__Group__3__Impl ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3866:1: ( rule__Action__Group__3__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3867:2: rule__Action__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__3__Impl_in_rule__Action__Group__37875);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3873:1: rule__Action__Group__3__Impl : ( '}' ) ;
    public final void rule__Action__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3877:1: ( ( '}' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3878:1: ( '}' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3878:1: ( '}' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3879:1: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__Action__Group__3__Impl7903); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3900:1: rule__Action__Group_2__0 : rule__Action__Group_2__0__Impl rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3904:1: ( rule__Action__Group_2__0__Impl rule__Action__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3905:2: rule__Action__Group_2__0__Impl rule__Action__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__0__Impl_in_rule__Action__Group_2__07942);
            rule__Action__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__1_in_rule__Action__Group_2__07945);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3912:1: rule__Action__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Action__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3916:1: ( ( '.' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3917:1: ( '.' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3917:1: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3918:1: '.'
            {
             before(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Action__Group_2__0__Impl7973); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3931:1: rule__Action__Group_2__1 : rule__Action__Group_2__1__Impl rule__Action__Group_2__2 ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3935:1: ( rule__Action__Group_2__1__Impl rule__Action__Group_2__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3936:2: rule__Action__Group_2__1__Impl rule__Action__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__1__Impl_in_rule__Action__Group_2__18004);
            rule__Action__Group_2__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__2_in_rule__Action__Group_2__18007);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3943:1: rule__Action__Group_2__1__Impl : ( ( rule__Action__FeatureAssignment_2_1 ) ) ;
    public final void rule__Action__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3947:1: ( ( ( rule__Action__FeatureAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3948:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3948:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3949:1: ( rule__Action__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3950:1: ( rule__Action__FeatureAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3950:2: rule__Action__FeatureAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__FeatureAssignment_2_1_in_rule__Action__Group_2__1__Impl8034);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3960:1: rule__Action__Group_2__2 : rule__Action__Group_2__2__Impl rule__Action__Group_2__3 ;
    public final void rule__Action__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3964:1: ( rule__Action__Group_2__2__Impl rule__Action__Group_2__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3965:2: rule__Action__Group_2__2__Impl rule__Action__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__2__Impl_in_rule__Action__Group_2__28064);
            rule__Action__Group_2__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__3_in_rule__Action__Group_2__28067);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3972:1: rule__Action__Group_2__2__Impl : ( ( rule__Action__OperatorAssignment_2_2 ) ) ;
    public final void rule__Action__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3976:1: ( ( ( rule__Action__OperatorAssignment_2_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3977:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3977:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3978:1: ( rule__Action__OperatorAssignment_2_2 )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3979:1: ( rule__Action__OperatorAssignment_2_2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3979:2: rule__Action__OperatorAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__OperatorAssignment_2_2_in_rule__Action__Group_2__2__Impl8094);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3989:1: rule__Action__Group_2__3 : rule__Action__Group_2__3__Impl ;
    public final void rule__Action__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3993:1: ( rule__Action__Group_2__3__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:3994:2: rule__Action__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__3__Impl_in_rule__Action__Group_2__38124);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4000:1: rule__Action__Group_2__3__Impl : ( 'current' ) ;
    public final void rule__Action__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4004:1: ( ( 'current' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4005:1: ( 'current' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4005:1: ( 'current' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4006:1: 'current'
            {
             before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__Action__Group_2__3__Impl8152); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4027:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4031:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4032:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__0__Impl_in_rule__Assignment__Group__08191);
            rule__Assignment__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__1_in_rule__Assignment__Group__08194);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4039:1: rule__Assignment__Group__0__Impl : ( ( rule__Assignment__FeatureAssignment_0 ) ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4043:1: ( ( ( rule__Assignment__FeatureAssignment_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4044:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4044:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4045:1: ( rule__Assignment__FeatureAssignment_0 )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4046:1: ( rule__Assignment__FeatureAssignment_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4046:2: rule__Assignment__FeatureAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__FeatureAssignment_0_in_rule__Assignment__Group__0__Impl8221);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4056:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4060:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4061:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__1__Impl_in_rule__Assignment__Group__18251);
            rule__Assignment__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__2_in_rule__Assignment__Group__18254);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4068:1: rule__Assignment__Group__1__Impl : ( ( rule__Assignment__OperatorAssignment_1 ) ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4072:1: ( ( ( rule__Assignment__OperatorAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4073:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4073:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4074:1: ( rule__Assignment__OperatorAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4075:1: ( rule__Assignment__OperatorAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4075:2: rule__Assignment__OperatorAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__OperatorAssignment_1_in_rule__Assignment__Group__1__Impl8281);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4085:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4089:1: ( rule__Assignment__Group__2__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4090:2: rule__Assignment__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__2__Impl_in_rule__Assignment__Group__28311);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4096:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__TerminalAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4100:1: ( ( ( rule__Assignment__TerminalAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4101:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4101:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4102:1: ( rule__Assignment__TerminalAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4103:1: ( rule__Assignment__TerminalAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4103:2: rule__Assignment__TerminalAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__TerminalAssignment_2_in_rule__Assignment__Group__2__Impl8338);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4119:1: rule__ParenthesizedAssignableElement__Group__0 : rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 ;
    public final void rule__ParenthesizedAssignableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4123:1: ( rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4124:2: rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__0__Impl_in_rule__ParenthesizedAssignableElement__Group__08374);
            rule__ParenthesizedAssignableElement__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__1_in_rule__ParenthesizedAssignableElement__Group__08377);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4131:1: rule__ParenthesizedAssignableElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4135:1: ( ( '(' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4136:1: ( '(' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4136:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4137:1: '('
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedAssignableElement__Group__0__Impl8405); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4150:1: rule__ParenthesizedAssignableElement__Group__1 : rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 ;
    public final void rule__ParenthesizedAssignableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4154:1: ( rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4155:2: rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__1__Impl_in_rule__ParenthesizedAssignableElement__Group__18436);
            rule__ParenthesizedAssignableElement__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__2_in_rule__ParenthesizedAssignableElement__Group__18439);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4162:1: rule__ParenthesizedAssignableElement__Group__1__Impl : ( ruleAssignableAlternatives ) ;
    public final void rule__ParenthesizedAssignableElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4166:1: ( ( ruleAssignableAlternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4167:1: ( ruleAssignableAlternatives )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4167:1: ( ruleAssignableAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4168:1: ruleAssignableAlternatives
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group__1__Impl8466);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4179:1: rule__ParenthesizedAssignableElement__Group__2 : rule__ParenthesizedAssignableElement__Group__2__Impl ;
    public final void rule__ParenthesizedAssignableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4183:1: ( rule__ParenthesizedAssignableElement__Group__2__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4184:2: rule__ParenthesizedAssignableElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__2__Impl_in_rule__ParenthesizedAssignableElement__Group__28495);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4190:1: rule__ParenthesizedAssignableElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4194:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4195:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4195:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4196:1: ')'
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group__2__Impl8523); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4215:1: rule__AssignableAlternatives__Group__0 : rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 ;
    public final void rule__AssignableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4219:1: ( rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4220:2: rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__0__Impl_in_rule__AssignableAlternatives__Group__08560);
            rule__AssignableAlternatives__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__1_in_rule__AssignableAlternatives__Group__08563);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4227:1: rule__AssignableAlternatives__Group__0__Impl : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4231:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4232:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4232:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4233:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group__0__Impl8590);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4244:1: rule__AssignableAlternatives__Group__1 : rule__AssignableAlternatives__Group__1__Impl ;
    public final void rule__AssignableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4248:1: ( rule__AssignableAlternatives__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4249:2: rule__AssignableAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__1__Impl_in_rule__AssignableAlternatives__Group__18619);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4255:1: rule__AssignableAlternatives__Group__1__Impl : ( ( rule__AssignableAlternatives__Group_1__0 )? ) ;
    public final void rule__AssignableAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4259:1: ( ( ( rule__AssignableAlternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4260:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4260:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4261:1: ( rule__AssignableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4262:1: ( rule__AssignableAlternatives__Group_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==30) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4262:2: rule__AssignableAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__0_in_rule__AssignableAlternatives__Group__1__Impl8646);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4276:1: rule__AssignableAlternatives__Group_1__0 : rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 ;
    public final void rule__AssignableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4280:1: ( rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4281:2: rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__0__Impl_in_rule__AssignableAlternatives__Group_1__08681);
            rule__AssignableAlternatives__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__1_in_rule__AssignableAlternatives__Group_1__08684);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4288:1: rule__AssignableAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__AssignableAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4292:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4293:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4293:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4294:1: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4295:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4297:1: 
            {
            }

             after(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4307:1: rule__AssignableAlternatives__Group_1__1 : rule__AssignableAlternatives__Group_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4311:1: ( rule__AssignableAlternatives__Group_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4312:2: rule__AssignableAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__1__Impl_in_rule__AssignableAlternatives__Group_1__18742);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4318:1: rule__AssignableAlternatives__Group_1__1__Impl : ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__AssignableAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4322:1: ( ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4323:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4323:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4324:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4324:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4325:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4326:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4326:2: rule__AssignableAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__1__Impl8771);
            rule__AssignableAlternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4329:1: ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4330:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4331:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==30) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4331:2: rule__AssignableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__1__Impl8783);
            	    rule__AssignableAlternatives__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4346:1: rule__AssignableAlternatives__Group_1_1__0 : rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 ;
    public final void rule__AssignableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4350:1: ( rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4351:2: rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0__Impl_in_rule__AssignableAlternatives__Group_1_1__08820);
            rule__AssignableAlternatives__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__1_in_rule__AssignableAlternatives__Group_1_1__08823);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4358:1: rule__AssignableAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__AssignableAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4362:1: ( ( '|' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4363:1: ( '|' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4363:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4364:1: '|'
            {
             before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__AssignableAlternatives__Group_1_1__0__Impl8851); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4377:1: rule__AssignableAlternatives__Group_1_1__1 : rule__AssignableAlternatives__Group_1_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4381:1: ( rule__AssignableAlternatives__Group_1_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4382:2: rule__AssignableAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__1__Impl_in_rule__AssignableAlternatives__Group_1_1__18882);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4388:1: rule__AssignableAlternatives__Group_1_1__1__Impl : ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4392:1: ( ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4393:1: ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4393:1: ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4394:1: ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4395:1: ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4395:2: rule__AssignableAlternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__ElementsAssignment_1_1_1_in_rule__AssignableAlternatives__Group_1_1__1__Impl8909);
            rule__AssignableAlternatives__ElementsAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4409:1: rule__CrossReference__Group__0 : rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 ;
    public final void rule__CrossReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4413:1: ( rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4414:2: rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__0__Impl_in_rule__CrossReference__Group__08943);
            rule__CrossReference__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__1_in_rule__CrossReference__Group__08946);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4421:1: rule__CrossReference__Group__0__Impl : ( '[' ) ;
    public final void rule__CrossReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4425:1: ( ( '[' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4426:1: ( '[' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4426:1: ( '[' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4427:1: '['
            {
             before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__CrossReference__Group__0__Impl8974); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4440:1: rule__CrossReference__Group__1 : rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 ;
    public final void rule__CrossReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4444:1: ( rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4445:2: rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__1__Impl_in_rule__CrossReference__Group__19005);
            rule__CrossReference__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__2_in_rule__CrossReference__Group__19008);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4452:1: rule__CrossReference__Group__1__Impl : ( ( rule__CrossReference__TypeAssignment_1 ) ) ;
    public final void rule__CrossReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4456:1: ( ( ( rule__CrossReference__TypeAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4457:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4457:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4458:1: ( rule__CrossReference__TypeAssignment_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4459:1: ( rule__CrossReference__TypeAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4459:2: rule__CrossReference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__TypeAssignment_1_in_rule__CrossReference__Group__1__Impl9035);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4469:1: rule__CrossReference__Group__2 : rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 ;
    public final void rule__CrossReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4473:1: ( rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4474:2: rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__2__Impl_in_rule__CrossReference__Group__29065);
            rule__CrossReference__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__3_in_rule__CrossReference__Group__29068);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4481:1: rule__CrossReference__Group__2__Impl : ( ( rule__CrossReference__Group_2__0 )? ) ;
    public final void rule__CrossReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4485:1: ( ( ( rule__CrossReference__Group_2__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4486:1: ( ( rule__CrossReference__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4486:1: ( ( rule__CrossReference__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4487:1: ( rule__CrossReference__Group_2__0 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4488:1: ( rule__CrossReference__Group_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==30) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4488:2: rule__CrossReference__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__0_in_rule__CrossReference__Group__2__Impl9095);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4498:1: rule__CrossReference__Group__3 : rule__CrossReference__Group__3__Impl ;
    public final void rule__CrossReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4502:1: ( rule__CrossReference__Group__3__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4503:2: rule__CrossReference__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__3__Impl_in_rule__CrossReference__Group__39126);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4509:1: rule__CrossReference__Group__3__Impl : ( ']' ) ;
    public final void rule__CrossReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4513:1: ( ( ']' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4514:1: ( ']' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4514:1: ( ']' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4515:1: ']'
            {
             before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__CrossReference__Group__3__Impl9154); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4536:1: rule__CrossReference__Group_2__0 : rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 ;
    public final void rule__CrossReference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4540:1: ( rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4541:2: rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__0__Impl_in_rule__CrossReference__Group_2__09193);
            rule__CrossReference__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__1_in_rule__CrossReference__Group_2__09196);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4548:1: rule__CrossReference__Group_2__0__Impl : ( '|' ) ;
    public final void rule__CrossReference__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4552:1: ( ( '|' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4553:1: ( '|' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4553:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4554:1: '|'
            {
             before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__CrossReference__Group_2__0__Impl9224); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4567:1: rule__CrossReference__Group_2__1 : rule__CrossReference__Group_2__1__Impl ;
    public final void rule__CrossReference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4571:1: ( rule__CrossReference__Group_2__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4572:2: rule__CrossReference__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__1__Impl_in_rule__CrossReference__Group_2__19255);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4578:1: rule__CrossReference__Group_2__1__Impl : ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) ;
    public final void rule__CrossReference__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4582:1: ( ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4583:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4583:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4584:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4585:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4585:2: rule__CrossReference__TerminalAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__TerminalAssignment_2_1_in_rule__CrossReference__Group_2__1__Impl9282);
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


    // $ANTLR start rule__ParenthesizedElement__Group__0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4599:1: rule__ParenthesizedElement__Group__0 : rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 ;
    public final void rule__ParenthesizedElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4603:1: ( rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4604:2: rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__0__Impl_in_rule__ParenthesizedElement__Group__09316);
            rule__ParenthesizedElement__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__1_in_rule__ParenthesizedElement__Group__09319);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4611:1: rule__ParenthesizedElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4615:1: ( ( '(' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4616:1: ( '(' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4616:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4617:1: '('
            {
             before(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedElement__Group__0__Impl9347); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4630:1: rule__ParenthesizedElement__Group__1 : rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 ;
    public final void rule__ParenthesizedElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4634:1: ( rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4635:2: rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__1__Impl_in_rule__ParenthesizedElement__Group__19378);
            rule__ParenthesizedElement__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__2_in_rule__ParenthesizedElement__Group__19381);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4642:1: rule__ParenthesizedElement__Group__1__Impl : ( ruleAlternatives ) ;
    public final void rule__ParenthesizedElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4646:1: ( ( ruleAlternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4647:1: ( ruleAlternatives )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4647:1: ( ruleAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4648:1: ruleAlternatives
            {
             before(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group__1__Impl9408);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4659:1: rule__ParenthesizedElement__Group__2 : rule__ParenthesizedElement__Group__2__Impl ;
    public final void rule__ParenthesizedElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4663:1: ( rule__ParenthesizedElement__Group__2__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4664:2: rule__ParenthesizedElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__2__Impl_in_rule__ParenthesizedElement__Group__29437);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4670:1: rule__ParenthesizedElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4674:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4675:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4675:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4676:1: ')'
            {
             before(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedElement__Group__2__Impl9465); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4695:1: rule__TerminalRule__Group__0 : rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 ;
    public final void rule__TerminalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4699:1: ( rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4700:2: rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__0__Impl_in_rule__TerminalRule__Group__09502);
            rule__TerminalRule__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__1_in_rule__TerminalRule__Group__09505);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4707:1: rule__TerminalRule__Group__0__Impl : ( 'terminal' ) ;
    public final void rule__TerminalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4711:1: ( ( 'terminal' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4712:1: ( 'terminal' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4712:1: ( 'terminal' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4713:1: 'terminal'
            {
             before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__TerminalRule__Group__0__Impl9533); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4726:1: rule__TerminalRule__Group__1 : rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 ;
    public final void rule__TerminalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4730:1: ( rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4731:2: rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__1__Impl_in_rule__TerminalRule__Group__19564);
            rule__TerminalRule__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__2_in_rule__TerminalRule__Group__19567);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4738:1: rule__TerminalRule__Group__1__Impl : ( ( rule__TerminalRule__NameAssignment_1 ) ) ;
    public final void rule__TerminalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4742:1: ( ( ( rule__TerminalRule__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4743:1: ( ( rule__TerminalRule__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4743:1: ( ( rule__TerminalRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4744:1: ( rule__TerminalRule__NameAssignment_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4745:1: ( rule__TerminalRule__NameAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4745:2: rule__TerminalRule__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__NameAssignment_1_in_rule__TerminalRule__Group__1__Impl9594);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4755:1: rule__TerminalRule__Group__2 : rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 ;
    public final void rule__TerminalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4759:1: ( rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4760:2: rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__2__Impl_in_rule__TerminalRule__Group__29624);
            rule__TerminalRule__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__3_in_rule__TerminalRule__Group__29627);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4767:1: rule__TerminalRule__Group__2__Impl : ( ( rule__TerminalRule__Group_2__0 )? ) ;
    public final void rule__TerminalRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4771:1: ( ( ( rule__TerminalRule__Group_2__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4772:1: ( ( rule__TerminalRule__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4772:1: ( ( rule__TerminalRule__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4773:1: ( rule__TerminalRule__Group_2__0 )?
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4774:1: ( rule__TerminalRule__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==28) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4774:2: rule__TerminalRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_2__0_in_rule__TerminalRule__Group__2__Impl9654);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4784:1: rule__TerminalRule__Group__3 : rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 ;
    public final void rule__TerminalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4788:1: ( rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4789:2: rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__3__Impl_in_rule__TerminalRule__Group__39685);
            rule__TerminalRule__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__4_in_rule__TerminalRule__Group__39688);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4796:1: rule__TerminalRule__Group__3__Impl : ( ':' ) ;
    public final void rule__TerminalRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4800:1: ( ( ':' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4801:1: ( ':' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4801:1: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4802:1: ':'
            {
             before(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__TerminalRule__Group__3__Impl9716); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4815:1: rule__TerminalRule__Group__4 : rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5 ;
    public final void rule__TerminalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4819:1: ( rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4820:2: rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__4__Impl_in_rule__TerminalRule__Group__49747);
            rule__TerminalRule__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__5_in_rule__TerminalRule__Group__49750);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4827:1: rule__TerminalRule__Group__4__Impl : ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) ;
    public final void rule__TerminalRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4831:1: ( ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4832:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4832:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4833:1: ( rule__TerminalRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4834:1: ( rule__TerminalRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4834:2: rule__TerminalRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__AlternativesAssignment_4_in_rule__TerminalRule__Group__4__Impl9777);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4844:1: rule__TerminalRule__Group__5 : rule__TerminalRule__Group__5__Impl ;
    public final void rule__TerminalRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4848:1: ( rule__TerminalRule__Group__5__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4849:2: rule__TerminalRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__5__Impl_in_rule__TerminalRule__Group__59807);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4855:1: rule__TerminalRule__Group__5__Impl : ( ';' ) ;
    public final void rule__TerminalRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4859:1: ( ( ';' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4860:1: ( ';' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4860:1: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4861:1: ';'
            {
             before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__TerminalRule__Group__5__Impl9835); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4886:1: rule__TerminalRule__Group_2__0 : rule__TerminalRule__Group_2__0__Impl rule__TerminalRule__Group_2__1 ;
    public final void rule__TerminalRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4890:1: ( rule__TerminalRule__Group_2__0__Impl rule__TerminalRule__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4891:2: rule__TerminalRule__Group_2__0__Impl rule__TerminalRule__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_2__0__Impl_in_rule__TerminalRule__Group_2__09878);
            rule__TerminalRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_2__1_in_rule__TerminalRule__Group_2__09881);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4898:1: rule__TerminalRule__Group_2__0__Impl : ( 'returns' ) ;
    public final void rule__TerminalRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4902:1: ( ( 'returns' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4903:1: ( 'returns' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4903:1: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4904:1: 'returns'
            {
             before(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__TerminalRule__Group_2__0__Impl9909); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4917:1: rule__TerminalRule__Group_2__1 : rule__TerminalRule__Group_2__1__Impl ;
    public final void rule__TerminalRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4921:1: ( rule__TerminalRule__Group_2__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4922:2: rule__TerminalRule__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_2__1__Impl_in_rule__TerminalRule__Group_2__19940);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4928:1: rule__TerminalRule__Group_2__1__Impl : ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) ;
    public final void rule__TerminalRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4932:1: ( ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4933:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4933:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4934:1: ( rule__TerminalRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4935:1: ( rule__TerminalRule__TypeAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4935:2: rule__TerminalRule__TypeAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__TypeAssignment_2_1_in_rule__TerminalRule__Group_2__1__Impl9967);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4949:1: rule__TerminalAlternatives__Group__0 : rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 ;
    public final void rule__TerminalAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4953:1: ( rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4954:2: rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__0__Impl_in_rule__TerminalAlternatives__Group__010001);
            rule__TerminalAlternatives__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__1_in_rule__TerminalAlternatives__Group__010004);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4961:1: rule__TerminalAlternatives__Group__0__Impl : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4965:1: ( ( ruleTerminalGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4966:1: ( ruleTerminalGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4966:1: ( ruleTerminalGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4967:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group__0__Impl10031);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4978:1: rule__TerminalAlternatives__Group__1 : rule__TerminalAlternatives__Group__1__Impl ;
    public final void rule__TerminalAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4982:1: ( rule__TerminalAlternatives__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4983:2: rule__TerminalAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__1__Impl_in_rule__TerminalAlternatives__Group__110060);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4989:1: rule__TerminalAlternatives__Group__1__Impl : ( ( rule__TerminalAlternatives__Group_1__0 )? ) ;
    public final void rule__TerminalAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4993:1: ( ( ( rule__TerminalAlternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4994:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4994:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4995:1: ( rule__TerminalAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4996:1: ( rule__TerminalAlternatives__Group_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==30) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:4996:2: rule__TerminalAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__0_in_rule__TerminalAlternatives__Group__1__Impl10087);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5010:1: rule__TerminalAlternatives__Group_1__0 : rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 ;
    public final void rule__TerminalAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5014:1: ( rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5015:2: rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__0__Impl_in_rule__TerminalAlternatives__Group_1__010122);
            rule__TerminalAlternatives__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__1_in_rule__TerminalAlternatives__Group_1__010125);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5022:1: rule__TerminalAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5026:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5027:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5027:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5028:1: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5029:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5031:1: 
            {
            }

             after(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5041:1: rule__TerminalAlternatives__Group_1__1 : rule__TerminalAlternatives__Group_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5045:1: ( rule__TerminalAlternatives__Group_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5046:2: rule__TerminalAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__1__Impl_in_rule__TerminalAlternatives__Group_1__110183);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5052:1: rule__TerminalAlternatives__Group_1__1__Impl : ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__TerminalAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5056:1: ( ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5057:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5057:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5058:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5058:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5059:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5060:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5060:2: rule__TerminalAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__1__Impl10212);
            rule__TerminalAlternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5063:1: ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5064:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5065:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==30) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5065:2: rule__TerminalAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__1__Impl10224);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5080:1: rule__TerminalAlternatives__Group_1_1__0 : rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 ;
    public final void rule__TerminalAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5084:1: ( rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5085:2: rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0__Impl_in_rule__TerminalAlternatives__Group_1_1__010261);
            rule__TerminalAlternatives__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__1_in_rule__TerminalAlternatives__Group_1_1__010264);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5092:1: rule__TerminalAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__TerminalAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5096:1: ( ( '|' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5097:1: ( '|' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5097:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5098:1: '|'
            {
             before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__TerminalAlternatives__Group_1_1__0__Impl10292); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5111:1: rule__TerminalAlternatives__Group_1_1__1 : rule__TerminalAlternatives__Group_1_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5115:1: ( rule__TerminalAlternatives__Group_1_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5116:2: rule__TerminalAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__1__Impl_in_rule__TerminalAlternatives__Group_1_1__110323);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5122:1: rule__TerminalAlternatives__Group_1_1__1__Impl : ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5126:1: ( ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5127:1: ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5127:1: ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5128:1: ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getElementsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5129:1: ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5129:2: rule__TerminalAlternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__ElementsAssignment_1_1_1_in_rule__TerminalAlternatives__Group_1_1__1__Impl10350);
            rule__TerminalAlternatives__ElementsAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5143:1: rule__TerminalGroup__Group__0 : rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 ;
    public final void rule__TerminalGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5147:1: ( rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5148:2: rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__0__Impl_in_rule__TerminalGroup__Group__010384);
            rule__TerminalGroup__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__1_in_rule__TerminalGroup__Group__010387);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5155:1: rule__TerminalGroup__Group__0__Impl : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5159:1: ( ( ruleTerminalToken ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5160:1: ( ruleTerminalToken )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5160:1: ( ruleTerminalToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5161:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group__0__Impl10414);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5172:1: rule__TerminalGroup__Group__1 : rule__TerminalGroup__Group__1__Impl ;
    public final void rule__TerminalGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5176:1: ( rule__TerminalGroup__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5177:2: rule__TerminalGroup__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__1__Impl_in_rule__TerminalGroup__Group__110443);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5183:1: rule__TerminalGroup__Group__1__Impl : ( ( rule__TerminalGroup__Group_1__0 )? ) ;
    public final void rule__TerminalGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5187:1: ( ( ( rule__TerminalGroup__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5188:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5188:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5189:1: ( rule__TerminalGroup__Group_1__0 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5190:1: ( rule__TerminalGroup__Group_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_STRING)||LA43_0==20||LA43_0==22||(LA43_0>=38 && LA43_0<=39)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5190:2: rule__TerminalGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__0_in_rule__TerminalGroup__Group__1__Impl10470);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5204:1: rule__TerminalGroup__Group_1__0 : rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 ;
    public final void rule__TerminalGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5208:1: ( rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5209:2: rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__0__Impl_in_rule__TerminalGroup__Group_1__010505);
            rule__TerminalGroup__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__1_in_rule__TerminalGroup__Group_1__010508);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5216:1: rule__TerminalGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5220:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5221:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5221:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5222:1: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5223:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5225:1: 
            {
            }

             after(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5235:1: rule__TerminalGroup__Group_1__1 : rule__TerminalGroup__Group_1__1__Impl ;
    public final void rule__TerminalGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5239:1: ( rule__TerminalGroup__Group_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5240:2: rule__TerminalGroup__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__1__Impl_in_rule__TerminalGroup__Group_1__110566);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5246:1: rule__TerminalGroup__Group_1__1__Impl : ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__TerminalGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5250:1: ( ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5251:1: ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5251:1: ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5252:1: ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5252:1: ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5253:1: ( rule__TerminalGroup__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5254:1: ( rule__TerminalGroup__ElementsAssignment_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5254:2: rule__TerminalGroup__ElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__ElementsAssignment_1_1_in_rule__TerminalGroup__Group_1__1__Impl10595);
            rule__TerminalGroup__ElementsAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5257:1: ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5258:1: ( rule__TerminalGroup__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5259:1: ( rule__TerminalGroup__ElementsAssignment_1_1 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||LA44_0==20||LA44_0==22||(LA44_0>=38 && LA44_0<=39)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5259:2: rule__TerminalGroup__ElementsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__ElementsAssignment_1_1_in_rule__TerminalGroup__Group_1__1__Impl10607);
            	    rule__TerminalGroup__ElementsAssignment_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5274:1: rule__TerminalToken__Group__0 : rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 ;
    public final void rule__TerminalToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5278:1: ( rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5279:2: rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__0__Impl_in_rule__TerminalToken__Group__010644);
            rule__TerminalToken__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__1_in_rule__TerminalToken__Group__010647);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5286:1: rule__TerminalToken__Group__0__Impl : ( ruleTerminalTokenElement ) ;
    public final void rule__TerminalToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5290:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5291:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5291:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5292:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group__0__Impl10674);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5303:1: rule__TerminalToken__Group__1 : rule__TerminalToken__Group__1__Impl ;
    public final void rule__TerminalToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5307:1: ( rule__TerminalToken__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5308:2: rule__TerminalToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__1__Impl_in_rule__TerminalToken__Group__110703);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5314:1: rule__TerminalToken__Group__1__Impl : ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) ;
    public final void rule__TerminalToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5318:1: ( ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5319:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5319:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5320:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5321:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=11 && LA45_0<=13)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5321:2: rule__TerminalToken__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__CardinalityAssignment_1_in_rule__TerminalToken__Group__1__Impl10730);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5335:1: rule__ParenthesizedTerminalElement__Group__0 : rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 ;
    public final void rule__ParenthesizedTerminalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5339:1: ( rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5340:2: rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__0__Impl_in_rule__ParenthesizedTerminalElement__Group__010765);
            rule__ParenthesizedTerminalElement__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__1_in_rule__ParenthesizedTerminalElement__Group__010768);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5347:1: rule__ParenthesizedTerminalElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5351:1: ( ( '(' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5352:1: ( '(' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5352:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5353:1: '('
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedTerminalElement__Group__0__Impl10796); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5366:1: rule__ParenthesizedTerminalElement__Group__1 : rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 ;
    public final void rule__ParenthesizedTerminalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5370:1: ( rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5371:2: rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__1__Impl_in_rule__ParenthesizedTerminalElement__Group__110827);
            rule__ParenthesizedTerminalElement__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__2_in_rule__ParenthesizedTerminalElement__Group__110830);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5378:1: rule__ParenthesizedTerminalElement__Group__1__Impl : ( ruleTerminalAlternatives ) ;
    public final void rule__ParenthesizedTerminalElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5382:1: ( ( ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5383:1: ( ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5383:1: ( ruleTerminalAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5384:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group__1__Impl10857);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5395:1: rule__ParenthesizedTerminalElement__Group__2 : rule__ParenthesizedTerminalElement__Group__2__Impl ;
    public final void rule__ParenthesizedTerminalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5399:1: ( rule__ParenthesizedTerminalElement__Group__2__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5400:2: rule__ParenthesizedTerminalElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__2__Impl_in_rule__ParenthesizedTerminalElement__Group__210886);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5406:1: rule__ParenthesizedTerminalElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5410:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5411:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5411:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5412:1: ')'
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group__2__Impl10914); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5431:1: rule__NegatedToken__Group__0 : rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 ;
    public final void rule__NegatedToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5435:1: ( rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5436:2: rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__0__Impl_in_rule__NegatedToken__Group__010951);
            rule__NegatedToken__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__1_in_rule__NegatedToken__Group__010954);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5443:1: rule__NegatedToken__Group__0__Impl : ( '!' ) ;
    public final void rule__NegatedToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5447:1: ( ( '!' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5448:1: ( '!' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5448:1: ( '!' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5449:1: '!'
            {
             before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__NegatedToken__Group__0__Impl10982); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5462:1: rule__NegatedToken__Group__1 : rule__NegatedToken__Group__1__Impl ;
    public final void rule__NegatedToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5466:1: ( rule__NegatedToken__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5467:2: rule__NegatedToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__1__Impl_in_rule__NegatedToken__Group__111013);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5473:1: rule__NegatedToken__Group__1__Impl : ( ( rule__NegatedToken__TerminalAssignment_1 ) ) ;
    public final void rule__NegatedToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5477:1: ( ( ( rule__NegatedToken__TerminalAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5478:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5478:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5479:1: ( rule__NegatedToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5480:1: ( rule__NegatedToken__TerminalAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5480:2: rule__NegatedToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__TerminalAssignment_1_in_rule__NegatedToken__Group__1__Impl11040);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5494:1: rule__UntilToken__Group__0 : rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 ;
    public final void rule__UntilToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5498:1: ( rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5499:2: rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__0__Impl_in_rule__UntilToken__Group__011074);
            rule__UntilToken__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__1_in_rule__UntilToken__Group__011077);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5506:1: rule__UntilToken__Group__0__Impl : ( '->' ) ;
    public final void rule__UntilToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5510:1: ( ( '->' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5511:1: ( '->' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5511:1: ( '->' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5512:1: '->'
            {
             before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__UntilToken__Group__0__Impl11105); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5525:1: rule__UntilToken__Group__1 : rule__UntilToken__Group__1__Impl ;
    public final void rule__UntilToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5529:1: ( rule__UntilToken__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5530:2: rule__UntilToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__1__Impl_in_rule__UntilToken__Group__111136);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5536:1: rule__UntilToken__Group__1__Impl : ( ( rule__UntilToken__TerminalAssignment_1 ) ) ;
    public final void rule__UntilToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5540:1: ( ( ( rule__UntilToken__TerminalAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5541:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5541:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5542:1: ( rule__UntilToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5543:1: ( rule__UntilToken__TerminalAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5543:2: rule__UntilToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__TerminalAssignment_1_in_rule__UntilToken__Group__1__Impl11163);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5557:1: rule__Wildcard__Group__0 : rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5561:1: ( rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5562:2: rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__0__Impl_in_rule__Wildcard__Group__011197);
            rule__Wildcard__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__1_in_rule__Wildcard__Group__011200);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5569:1: rule__Wildcard__Group__0__Impl : ( () ) ;
    public final void rule__Wildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5573:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5574:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5574:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5575:1: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5576:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5578:1: 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5588:1: rule__Wildcard__Group__1 : rule__Wildcard__Group__1__Impl ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5592:1: ( rule__Wildcard__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5593:2: rule__Wildcard__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__1__Impl_in_rule__Wildcard__Group__111258);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5599:1: rule__Wildcard__Group__1__Impl : ( '.' ) ;
    public final void rule__Wildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5603:1: ( ( '.' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5604:1: ( '.' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5604:1: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5605:1: '.'
            {
             before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Wildcard__Group__1__Impl11286); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5622:1: rule__CharacterRange__Group__0 : rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 ;
    public final void rule__CharacterRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5626:1: ( rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5627:2: rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__0__Impl_in_rule__CharacterRange__Group__011321);
            rule__CharacterRange__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__1_in_rule__CharacterRange__Group__011324);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5634:1: rule__CharacterRange__Group__0__Impl : ( ruleKeyword ) ;
    public final void rule__CharacterRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5638:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5639:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5639:1: ( ruleKeyword )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5640:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CharacterRange__Group__0__Impl11351);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5651:1: rule__CharacterRange__Group__1 : rule__CharacterRange__Group__1__Impl ;
    public final void rule__CharacterRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5655:1: ( rule__CharacterRange__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5656:2: rule__CharacterRange__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__1__Impl_in_rule__CharacterRange__Group__111380);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5662:1: rule__CharacterRange__Group__1__Impl : ( ( rule__CharacterRange__Group_1__0 )? ) ;
    public final void rule__CharacterRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5666:1: ( ( ( rule__CharacterRange__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5667:1: ( ( rule__CharacterRange__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5667:1: ( ( rule__CharacterRange__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5668:1: ( rule__CharacterRange__Group_1__0 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5669:1: ( rule__CharacterRange__Group_1__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==40) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5669:2: rule__CharacterRange__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__0_in_rule__CharacterRange__Group__1__Impl11407);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5683:1: rule__CharacterRange__Group_1__0 : rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 ;
    public final void rule__CharacterRange__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5687:1: ( rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5688:2: rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__0__Impl_in_rule__CharacterRange__Group_1__011442);
            rule__CharacterRange__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__1_in_rule__CharacterRange__Group_1__011445);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5695:1: rule__CharacterRange__Group_1__0__Impl : ( () ) ;
    public final void rule__CharacterRange__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5699:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5700:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5700:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5701:1: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5702:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5704:1: 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5714:1: rule__CharacterRange__Group_1__1 : rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 ;
    public final void rule__CharacterRange__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5718:1: ( rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5719:2: rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__1__Impl_in_rule__CharacterRange__Group_1__111503);
            rule__CharacterRange__Group_1__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__2_in_rule__CharacterRange__Group_1__111506);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5726:1: rule__CharacterRange__Group_1__1__Impl : ( '..' ) ;
    public final void rule__CharacterRange__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5730:1: ( ( '..' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5731:1: ( '..' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5731:1: ( '..' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5732:1: '..'
            {
             before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,40,FollowSets000.FOLLOW_40_in_rule__CharacterRange__Group_1__1__Impl11534); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5745:1: rule__CharacterRange__Group_1__2 : rule__CharacterRange__Group_1__2__Impl ;
    public final void rule__CharacterRange__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5749:1: ( rule__CharacterRange__Group_1__2__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5750:2: rule__CharacterRange__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__2__Impl_in_rule__CharacterRange__Group_1__211565);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5756:1: rule__CharacterRange__Group_1__2__Impl : ( ( rule__CharacterRange__RightAssignment_1_2 ) ) ;
    public final void rule__CharacterRange__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5760:1: ( ( ( rule__CharacterRange__RightAssignment_1_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5761:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5761:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5762:1: ( rule__CharacterRange__RightAssignment_1_2 )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5763:1: ( rule__CharacterRange__RightAssignment_1_2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5763:2: rule__CharacterRange__RightAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__RightAssignment_1_2_in_rule__CharacterRange__Group_1__2__Impl11592);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5779:1: rule__EnumRule__Group__0 : rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 ;
    public final void rule__EnumRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5783:1: ( rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5784:2: rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__0__Impl_in_rule__EnumRule__Group__011628);
            rule__EnumRule__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__1_in_rule__EnumRule__Group__011631);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5791:1: rule__EnumRule__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5795:1: ( ( 'enum' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5796:1: ( 'enum' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5796:1: ( 'enum' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5797:1: 'enum'
            {
             before(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 
            match(input,41,FollowSets000.FOLLOW_41_in_rule__EnumRule__Group__0__Impl11659); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5810:1: rule__EnumRule__Group__1 : rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 ;
    public final void rule__EnumRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5814:1: ( rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5815:2: rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__1__Impl_in_rule__EnumRule__Group__111690);
            rule__EnumRule__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__2_in_rule__EnumRule__Group__111693);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5822:1: rule__EnumRule__Group__1__Impl : ( ( rule__EnumRule__NameAssignment_1 ) ) ;
    public final void rule__EnumRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5826:1: ( ( ( rule__EnumRule__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5827:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5827:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5828:1: ( rule__EnumRule__NameAssignment_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5829:1: ( rule__EnumRule__NameAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5829:2: rule__EnumRule__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__NameAssignment_1_in_rule__EnumRule__Group__1__Impl11720);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5839:1: rule__EnumRule__Group__2 : rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 ;
    public final void rule__EnumRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5843:1: ( rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5844:2: rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__2__Impl_in_rule__EnumRule__Group__211750);
            rule__EnumRule__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__3_in_rule__EnumRule__Group__211753);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5851:1: rule__EnumRule__Group__2__Impl : ( ( rule__EnumRule__Group_2__0 )? ) ;
    public final void rule__EnumRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5855:1: ( ( ( rule__EnumRule__Group_2__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5856:1: ( ( rule__EnumRule__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5856:1: ( ( rule__EnumRule__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5857:1: ( rule__EnumRule__Group_2__0 )?
            {
             before(grammarAccess.getEnumRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5858:1: ( rule__EnumRule__Group_2__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==28) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5858:2: rule__EnumRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__0_in_rule__EnumRule__Group__2__Impl11780);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5868:1: rule__EnumRule__Group__3 : rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 ;
    public final void rule__EnumRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5872:1: ( rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5873:2: rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__3__Impl_in_rule__EnumRule__Group__311811);
            rule__EnumRule__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__4_in_rule__EnumRule__Group__311814);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5880:1: rule__EnumRule__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5884:1: ( ( ':' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5885:1: ( ':' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5885:1: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5886:1: ':'
            {
             before(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__EnumRule__Group__3__Impl11842); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5899:1: rule__EnumRule__Group__4 : rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 ;
    public final void rule__EnumRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5903:1: ( rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5904:2: rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__4__Impl_in_rule__EnumRule__Group__411873);
            rule__EnumRule__Group__4__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__5_in_rule__EnumRule__Group__411876);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5911:1: rule__EnumRule__Group__4__Impl : ( ( rule__EnumRule__AlternativesAssignment_4 ) ) ;
    public final void rule__EnumRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5915:1: ( ( ( rule__EnumRule__AlternativesAssignment_4 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5916:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5916:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5917:1: ( rule__EnumRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5918:1: ( rule__EnumRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5918:2: rule__EnumRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__AlternativesAssignment_4_in_rule__EnumRule__Group__4__Impl11903);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5928:1: rule__EnumRule__Group__5 : rule__EnumRule__Group__5__Impl ;
    public final void rule__EnumRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5932:1: ( rule__EnumRule__Group__5__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5933:2: rule__EnumRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__5__Impl_in_rule__EnumRule__Group__511933);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5939:1: rule__EnumRule__Group__5__Impl : ( ';' ) ;
    public final void rule__EnumRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5943:1: ( ( ';' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5944:1: ( ';' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5944:1: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5945:1: ';'
            {
             before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__EnumRule__Group__5__Impl11961); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5970:1: rule__EnumRule__Group_2__0 : rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1 ;
    public final void rule__EnumRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5974:1: ( rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5975:2: rule__EnumRule__Group_2__0__Impl rule__EnumRule__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__0__Impl_in_rule__EnumRule__Group_2__012004);
            rule__EnumRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__1_in_rule__EnumRule__Group_2__012007);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5982:1: rule__EnumRule__Group_2__0__Impl : ( 'returns' ) ;
    public final void rule__EnumRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5986:1: ( ( 'returns' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5987:1: ( 'returns' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5987:1: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:5988:1: 'returns'
            {
             before(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__EnumRule__Group_2__0__Impl12035); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6001:1: rule__EnumRule__Group_2__1 : rule__EnumRule__Group_2__1__Impl ;
    public final void rule__EnumRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6005:1: ( rule__EnumRule__Group_2__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6006:2: rule__EnumRule__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__1__Impl_in_rule__EnumRule__Group_2__112066);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6012:1: rule__EnumRule__Group_2__1__Impl : ( ( rule__EnumRule__TypeAssignment_2_1 ) ) ;
    public final void rule__EnumRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6016:1: ( ( ( rule__EnumRule__TypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6017:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6017:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6018:1: ( rule__EnumRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6019:1: ( rule__EnumRule__TypeAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6019:2: rule__EnumRule__TypeAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__TypeAssignment_2_1_in_rule__EnumRule__Group_2__1__Impl12093);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6033:1: rule__EnumLiterals__Group__0 : rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 ;
    public final void rule__EnumLiterals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6037:1: ( rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6038:2: rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__0__Impl_in_rule__EnumLiterals__Group__012127);
            rule__EnumLiterals__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__1_in_rule__EnumLiterals__Group__012130);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6045:1: rule__EnumLiterals__Group__0__Impl : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6049:1: ( ( ruleEnumLiteralDeclaration ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6050:1: ( ruleEnumLiteralDeclaration )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6050:1: ( ruleEnumLiteralDeclaration )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6051:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group__0__Impl12157);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6062:1: rule__EnumLiterals__Group__1 : rule__EnumLiterals__Group__1__Impl ;
    public final void rule__EnumLiterals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6066:1: ( rule__EnumLiterals__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6067:2: rule__EnumLiterals__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__1__Impl_in_rule__EnumLiterals__Group__112186);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6073:1: rule__EnumLiterals__Group__1__Impl : ( ( rule__EnumLiterals__Group_1__0 )? ) ;
    public final void rule__EnumLiterals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6077:1: ( ( ( rule__EnumLiterals__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6078:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6078:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6079:1: ( rule__EnumLiterals__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6080:1: ( rule__EnumLiterals__Group_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==30) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6080:2: rule__EnumLiterals__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__0_in_rule__EnumLiterals__Group__1__Impl12213);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6094:1: rule__EnumLiterals__Group_1__0 : rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 ;
    public final void rule__EnumLiterals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6098:1: ( rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6099:2: rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__0__Impl_in_rule__EnumLiterals__Group_1__012248);
            rule__EnumLiterals__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__1_in_rule__EnumLiterals__Group_1__012251);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6106:1: rule__EnumLiterals__Group_1__0__Impl : ( () ) ;
    public final void rule__EnumLiterals__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6110:1: ( ( () ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6111:1: ( () )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6111:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6112:1: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6113:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6115:1: 
            {
            }

             after(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0()); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6125:1: rule__EnumLiterals__Group_1__1 : rule__EnumLiterals__Group_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6129:1: ( rule__EnumLiterals__Group_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6130:2: rule__EnumLiterals__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__1__Impl_in_rule__EnumLiterals__Group_1__112309);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6136:1: rule__EnumLiterals__Group_1__1__Impl : ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) ;
    public final void rule__EnumLiterals__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6140:1: ( ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6141:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6141:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6142:1: ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6142:1: ( ( rule__EnumLiterals__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6143:1: ( rule__EnumLiterals__Group_1_1__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6144:1: ( rule__EnumLiterals__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6144:2: rule__EnumLiterals__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__1__Impl12338);
            rule__EnumLiterals__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6147:1: ( ( rule__EnumLiterals__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6148:1: ( rule__EnumLiterals__Group_1_1__0 )*
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6149:1: ( rule__EnumLiterals__Group_1_1__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==30) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6149:2: rule__EnumLiterals__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__1__Impl12350);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6164:1: rule__EnumLiterals__Group_1_1__0 : rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 ;
    public final void rule__EnumLiterals__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6168:1: ( rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6169:2: rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0__Impl_in_rule__EnumLiterals__Group_1_1__012387);
            rule__EnumLiterals__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__1_in_rule__EnumLiterals__Group_1_1__012390);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6176:1: rule__EnumLiterals__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__EnumLiterals__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6180:1: ( ( '|' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6181:1: ( '|' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6181:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6182:1: '|'
            {
             before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__EnumLiterals__Group_1_1__0__Impl12418); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6195:1: rule__EnumLiterals__Group_1_1__1 : rule__EnumLiterals__Group_1_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6199:1: ( rule__EnumLiterals__Group_1_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6200:2: rule__EnumLiterals__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__1__Impl_in_rule__EnumLiterals__Group_1_1__112449);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6206:1: rule__EnumLiterals__Group_1_1__1__Impl : ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__EnumLiterals__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6210:1: ( ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6211:1: ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6211:1: ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6212:1: ( rule__EnumLiterals__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getElementsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6213:1: ( rule__EnumLiterals__ElementsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6213:2: rule__EnumLiterals__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__ElementsAssignment_1_1_1_in_rule__EnumLiterals__Group_1_1__1__Impl12476);
            rule__EnumLiterals__ElementsAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6227:1: rule__EnumLiteralDeclaration__Group__0 : rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 ;
    public final void rule__EnumLiteralDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6231:1: ( rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6232:2: rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__0__Impl_in_rule__EnumLiteralDeclaration__Group__012510);
            rule__EnumLiteralDeclaration__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__1_in_rule__EnumLiteralDeclaration__Group__012513);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6239:1: rule__EnumLiteralDeclaration__Group__0__Impl : ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6243:1: ( ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6244:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6244:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6245:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6246:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6246:2: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__EnumLiteralAssignment_0_in_rule__EnumLiteralDeclaration__Group__0__Impl12540);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6256:1: rule__EnumLiteralDeclaration__Group__1 : rule__EnumLiteralDeclaration__Group__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6260:1: ( rule__EnumLiteralDeclaration__Group__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6261:2: rule__EnumLiteralDeclaration__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__1__Impl_in_rule__EnumLiteralDeclaration__Group__112570);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6267:1: rule__EnumLiteralDeclaration__Group__1__Impl : ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6271:1: ( ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6272:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6272:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6273:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6274:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==14) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6274:2: rule__EnumLiteralDeclaration__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__0_in_rule__EnumLiteralDeclaration__Group__1__Impl12597);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6288:1: rule__EnumLiteralDeclaration__Group_1__0 : rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 ;
    public final void rule__EnumLiteralDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6292:1: ( rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6293:2: rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__0__Impl_in_rule__EnumLiteralDeclaration__Group_1__012632);
            rule__EnumLiteralDeclaration__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__1_in_rule__EnumLiteralDeclaration__Group_1__012635);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6300:1: rule__EnumLiteralDeclaration__Group_1__0__Impl : ( '=' ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6304:1: ( ( '=' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6305:1: ( '=' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6305:1: ( '=' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6306:1: '='
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_1__0__Impl12663); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6319:1: rule__EnumLiteralDeclaration__Group_1__1 : rule__EnumLiteralDeclaration__Group_1__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6323:1: ( rule__EnumLiteralDeclaration__Group_1__1__Impl )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6324:2: rule__EnumLiteralDeclaration__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__1__Impl_in_rule__EnumLiteralDeclaration__Group_1__112694);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6330:1: rule__EnumLiteralDeclaration__Group_1__1__Impl : ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6334:1: ( ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6335:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6335:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6336:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6337:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6337:2: rule__EnumLiteralDeclaration__LiteralAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__LiteralAssignment_1_1_in_rule__EnumLiteralDeclaration__Group_1__1__Impl12721);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6352:1: rule__Grammar__NameAssignment_1 : ( ruleGrammarID ) ;
    public final void rule__Grammar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6356:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6357:1: ( ruleGrammarID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6357:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6358:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__NameAssignment_112760);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6367:1: rule__Grammar__UsedGrammarsAssignment_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6371:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6372:1: ( ( ruleGrammarID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6372:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6373:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6374:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6375:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_112795);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6386:1: rule__Grammar__UsedGrammarsAssignment_2_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6390:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6391:1: ( ( ruleGrammarID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6391:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6392:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6393:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6394:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_2_112834);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6405:1: rule__Grammar__DefinesHiddenTokensAssignment_3_0 : ( ( 'hidden' ) ) ;
    public final void rule__Grammar__DefinesHiddenTokensAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6409:1: ( ( ( 'hidden' ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6410:1: ( ( 'hidden' ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6410:1: ( ( 'hidden' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6411:1: ( 'hidden' )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6412:1: ( 'hidden' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6413:1: 'hidden'
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            match(input,42,FollowSets000.FOLLOW_42_in_rule__Grammar__DefinesHiddenTokensAssignment_3_012874); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6428:1: rule__Grammar__HiddenTokensAssignment_3_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6432:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6433:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6433:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6434:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6435:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6436:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_012917); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6447:1: rule__Grammar__HiddenTokensAssignment_3_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6451:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6452:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6452:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6453:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6454:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6455:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_1_112956); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6466:1: rule__Grammar__MetamodelDeclarationsAssignment_4 : ( ruleAbstractMetamodelDeclaration ) ;
    public final void rule__Grammar__MetamodelDeclarationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6470:1: ( ( ruleAbstractMetamodelDeclaration ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6471:1: ( ruleAbstractMetamodelDeclaration )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6471:1: ( ruleAbstractMetamodelDeclaration )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6472:1: ruleAbstractMetamodelDeclaration
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__MetamodelDeclarationsAssignment_412991);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6481:1: rule__Grammar__RulesAssignment_5 : ( ruleAbstractRule ) ;
    public final void rule__Grammar__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6485:1: ( ( ruleAbstractRule ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6486:1: ( ruleAbstractRule )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6486:1: ( ruleAbstractRule )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6487:1: ruleAbstractRule
            {
             before(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_rule__Grammar__RulesAssignment_513022);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6496:1: rule__GeneratedMetamodel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6500:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6501:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6501:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6502:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__NameAssignment_113053); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6511:1: rule__GeneratedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__GeneratedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6515:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6516:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6516:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6517:1: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6518:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6519:1: RULE_STRING
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__EPackageAssignment_213088); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6530:1: rule__GeneratedMetamodel__AliasAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__AliasAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6534:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6535:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6535:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6536:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__AliasAssignment_3_113123); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6545:1: rule__ReferencedMetamodel__EPackageAssignment_1 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6549:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6550:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6550:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6551:1: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6552:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6553:1: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_113158); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6564:1: rule__ReferencedMetamodel__AliasAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6568:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6569:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6569:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6570:1: RULE_ID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_2_113193); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6579:1: rule__ParserRule__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParserRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6583:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6584:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6584:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6585:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__NameAssignment_013224); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6594:1: rule__ParserRule__TypeAssignment_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6598:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6599:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6599:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6600:1: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__ParserRule__TypeAssignment_1_113255);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6609:1: rule__ParserRule__DefinesHiddenTokensAssignment_2_0 : ( ( 'hidden' ) ) ;
    public final void rule__ParserRule__DefinesHiddenTokensAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6613:1: ( ( ( 'hidden' ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6614:1: ( ( 'hidden' ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6614:1: ( ( 'hidden' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6615:1: ( 'hidden' )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6616:1: ( 'hidden' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6617:1: 'hidden'
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            match(input,42,FollowSets000.FOLLOW_42_in_rule__ParserRule__DefinesHiddenTokensAssignment_2_013291); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6632:1: rule__ParserRule__HiddenTokensAssignment_2_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6636:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6637:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6637:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6638:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6639:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6640:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_013334); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6651:1: rule__ParserRule__HiddenTokensAssignment_2_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6655:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6656:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6656:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6657:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6658:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6659:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_1_113373); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6670:1: rule__ParserRule__AlternativesAssignment_4 : ( ruleAlternatives ) ;
    public final void rule__ParserRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6674:1: ( ( ruleAlternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6675:1: ( ruleAlternatives )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6675:1: ( ruleAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6676:1: ruleAlternatives
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rule__ParserRule__AlternativesAssignment_413408);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6685:1: rule__TypeRef__MetamodelAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__MetamodelAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6689:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6690:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6690:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6691:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6692:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6693:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeRef__MetamodelAssignment_0_013443); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6704:1: rule__TypeRef__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6708:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6709:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6709:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6710:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6711:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6712:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeRef__ClassifierAssignment_113482); 
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


    // $ANTLR start rule__Alternatives__ElementsAssignment_1_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6723:1: rule__Alternatives__ElementsAssignment_1_1_1 : ( ruleUnorderedGroup ) ;
    public final void rule__Alternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6727:1: ( ( ruleUnorderedGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6728:1: ( ruleUnorderedGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6728:1: ( ruleUnorderedGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6729:1: ruleUnorderedGroup
            {
             before(grammarAccess.getAlternativesAccess().getElementsUnorderedGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_rule__Alternatives__ElementsAssignment_1_1_113517);
            ruleUnorderedGroup();
            _fsp--;

             after(grammarAccess.getAlternativesAccess().getElementsUnorderedGroupParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Alternatives__ElementsAssignment_1_1_1


    // $ANTLR start rule__UnorderedGroup__ElementsAssignment_1_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6738:1: rule__UnorderedGroup__ElementsAssignment_1_1_1 : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6742:1: ( ( ruleGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6743:1: ( ruleGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6743:1: ( ruleGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6744:1: ruleGroup
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_rule__UnorderedGroup__ElementsAssignment_1_1_113548);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__UnorderedGroup__ElementsAssignment_1_1_1


    // $ANTLR start rule__Group__ElementsAssignment_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6753:1: rule__Group__ElementsAssignment_1_1 : ( ruleAbstractToken ) ;
    public final void rule__Group__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6757:1: ( ( ruleAbstractToken ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6758:1: ( ruleAbstractToken )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6758:1: ( ruleAbstractToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6759:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_rule__Group__ElementsAssignment_1_113579);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Group__ElementsAssignment_1_1


    // $ANTLR start rule__AbstractTokenWithCardinality__CardinalityAssignment_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6768:1: rule__AbstractTokenWithCardinality__CardinalityAssignment_1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6772:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6773:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6773:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6774:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6775:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6775:2: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__CardinalityAssignment_113610);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6784:1: rule__Action__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Action__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6788:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6789:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6789:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6790:1: ruleTypeRef
            {
             before(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Action__TypeAssignment_113643);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6799:1: rule__Action__FeatureAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Action__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6803:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6804:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6804:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6805:1: RULE_ID
            {
             before(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Action__FeatureAssignment_2_113674); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6814:1: rule__Action__OperatorAssignment_2_2 : ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ;
    public final void rule__Action__OperatorAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6818:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6819:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6819:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6820:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6821:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6821:2: rule__Action__OperatorAlternatives_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__OperatorAssignment_2_213705);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6830:1: rule__Keyword__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Keyword__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6834:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6835:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6835:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6836:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Keyword__ValueAssignment13738); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6845:1: rule__RuleCall__RuleAssignment : ( ( RULE_ID ) ) ;
    public final void rule__RuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6849:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6850:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6850:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6851:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6852:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6853:1: RULE_ID
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__RuleCall__RuleAssignment13773); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6864:1: rule__Assignment__FeatureAssignment_0 : ( RULE_ID ) ;
    public final void rule__Assignment__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6868:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6869:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6869:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6870:1: RULE_ID
            {
             before(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Assignment__FeatureAssignment_013808); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6879:1: rule__Assignment__OperatorAssignment_1 : ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) ;
    public final void rule__Assignment__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6883:1: ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6884:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6884:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6885:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6886:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6886:2: rule__Assignment__OperatorAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__OperatorAssignment_113839);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6895:1: rule__Assignment__TerminalAssignment_2 : ( ruleAssignableTerminal ) ;
    public final void rule__Assignment__TerminalAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6899:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6900:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6900:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6901:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__Assignment__TerminalAssignment_213872);
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


    // $ANTLR start rule__AssignableAlternatives__ElementsAssignment_1_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6910:1: rule__AssignableAlternatives__ElementsAssignment_1_1_1 : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6914:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6915:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6915:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6916:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__ElementsAssignment_1_1_113903);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AssignableAlternatives__ElementsAssignment_1_1_1


    // $ANTLR start rule__CrossReference__TypeAssignment_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6925:1: rule__CrossReference__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__CrossReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6929:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6930:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6930:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6931:1: ruleTypeRef
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__CrossReference__TypeAssignment_113934);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6940:1: rule__CrossReference__TerminalAssignment_2_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReference__TerminalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6944:1: ( ( ruleCrossReferenceableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6945:1: ( ruleCrossReferenceableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6945:1: ( ruleCrossReferenceableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6946:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__TerminalAssignment_2_113965);
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


    // $ANTLR start rule__TerminalRule__NameAssignment_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6955:1: rule__TerminalRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TerminalRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6959:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6960:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6960:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6961:1: RULE_ID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_113996); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6970:1: rule__TerminalRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__TerminalRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6974:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6975:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6975:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6976:1: ruleTypeRef
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__TerminalRule__TypeAssignment_2_114027);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6985:1: rule__TerminalRule__AlternativesAssignment_4 : ( ruleTerminalAlternatives ) ;
    public final void rule__TerminalRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6989:1: ( ( ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6990:1: ( ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6990:1: ( ruleTerminalAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:6991:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__AlternativesAssignment_414058);
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


    // $ANTLR start rule__TerminalAlternatives__ElementsAssignment_1_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7000:1: rule__TerminalAlternatives__ElementsAssignment_1_1_1 : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7004:1: ( ( ruleTerminalGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7005:1: ( ruleTerminalGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7005:1: ( ruleTerminalGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7006:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__ElementsAssignment_1_1_114089);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TerminalAlternatives__ElementsAssignment_1_1_1


    // $ANTLR start rule__TerminalGroup__ElementsAssignment_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7015:1: rule__TerminalGroup__ElementsAssignment_1_1 : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7019:1: ( ( ruleTerminalToken ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7020:1: ( ruleTerminalToken )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7020:1: ( ruleTerminalToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7021:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__ElementsAssignment_1_114120);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TerminalGroup__ElementsAssignment_1_1


    // $ANTLR start rule__TerminalToken__CardinalityAssignment_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7030:1: rule__TerminalToken__CardinalityAssignment_1 : ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__TerminalToken__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7034:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7035:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7035:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7036:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7037:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7037:2: rule__TerminalToken__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__CardinalityAssignment_114151);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7046:1: rule__NegatedToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__NegatedToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7050:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7051:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7051:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7052:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__TerminalAssignment_114184);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7061:1: rule__UntilToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__UntilToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7065:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7066:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7066:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7067:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__TerminalAssignment_114215);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7076:1: rule__CharacterRange__RightAssignment_1_2 : ( ruleKeyword ) ;
    public final void rule__CharacterRange__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7080:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7081:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7081:1: ( ruleKeyword )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7082:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CharacterRange__RightAssignment_1_214246);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7091:1: rule__EnumRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7095:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7096:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7096:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7097:1: RULE_ID
            {
             before(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EnumRule__NameAssignment_114277); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7106:1: rule__EnumRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__EnumRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7110:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7111:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7111:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7112:1: ruleTypeRef
            {
             before(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__EnumRule__TypeAssignment_2_114308);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7121:1: rule__EnumRule__AlternativesAssignment_4 : ( ruleEnumLiterals ) ;
    public final void rule__EnumRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7125:1: ( ( ruleEnumLiterals ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7126:1: ( ruleEnumLiterals )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7126:1: ( ruleEnumLiterals )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7127:1: ruleEnumLiterals
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_rule__EnumRule__AlternativesAssignment_414339);
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


    // $ANTLR start rule__EnumLiterals__ElementsAssignment_1_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7136:1: rule__EnumLiterals__ElementsAssignment_1_1_1 : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7140:1: ( ( ruleEnumLiteralDeclaration ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7141:1: ( ruleEnumLiteralDeclaration )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7141:1: ( ruleEnumLiteralDeclaration )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7142:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__ElementsAssignment_1_1_114370);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EnumLiterals__ElementsAssignment_1_1_1


    // $ANTLR start rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7151:1: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumLiteralDeclaration__EnumLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7155:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7156:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7156:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7157:1: ( RULE_ID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7158:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7159:1: RULE_ID
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__EnumLiteralAssignment_014405); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7170:1: rule__EnumLiteralDeclaration__LiteralAssignment_1_1 : ( ruleKeyword ) ;
    public final void rule__EnumLiteralDeclaration__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7174:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7175:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7175:1: ( ruleKeyword )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/ui/contentassist/antlr/internal/InternalXtext.g:7176:1: ruleKeyword
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__LiteralAssignment_1_114440);
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
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedGroup608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group__0_in_ruleUnorderedGroup634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroup668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group__0_in_ruleGroup694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__0_in_ruleAbstractTokenWithCardinality814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction841 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__0_in_ruleAction874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal901 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword961 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeyword968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Keyword__ValueAssignment_in_ruleKeyword994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall1021 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall1028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RuleCall__RuleAssignment_in_ruleRuleCall1054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment1081 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment1088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__0_in_ruleAssignment1114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1141 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal1148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1201 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement1208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__0_in_ruleParenthesizedAssignableElement1234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1261 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives1268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__0_in_ruleAssignableAlternatives1294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference1321 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference1328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__0_in_ruleCrossReference1354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1381 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal1388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1441 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement1448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__0_in_ruleParenthesizedElement1474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1501 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__0_in_ruleTerminalRule1534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1561 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives1568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__0_in_ruleTerminalAlternatives1594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1621 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup1628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__0_in_ruleTerminalGroup1654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1681 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken1688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__0_in_ruleTerminalToken1714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1741 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement1748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1801 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement1808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__0_in_ruleParenthesizedTerminalElement1834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1861 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken1868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1921 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken1928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__0_in_ruleNegatedToken1954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken1981 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken1988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__0_in_ruleUntilToken2014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard2041 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcard2048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__0_in_ruleWildcard2074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2101 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange2108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__0_in_ruleCharacterRange2134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule2161 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule2168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__0_in_ruleEnumRule2194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2221 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals2228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__0_in_ruleEnumLiterals2254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2281 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration2288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__0_in_ruleEnumLiteralDeclaration2314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_rule__AbstractRule__Alternatives2350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_rule__AbstractRule__Alternatives2367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_rule__AbstractRule__Alternatives2384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_rule__AbstractToken__Alternatives2465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_rule__AbstractToken__Alternatives2482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_rule__AbstractTokenWithCardinality__Alternatives_02514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_rule__AbstractTokenWithCardinality__Alternatives_02531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Action__OperatorAlternatives_2_2_02639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Action__OperatorAlternatives_2_2_02659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__AbstractTerminal__Alternatives2693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__AbstractTerminal__Alternatives2710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_rule__AbstractTerminal__Alternatives2727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Assignment__OperatorAlternatives_1_02760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Assignment__OperatorAlternatives_1_02780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Assignment__OperatorAlternatives_1_02800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__AssignableTerminal__Alternatives2834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__AssignableTerminal__Alternatives2851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_rule__AssignableTerminal__Alternatives2868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_rule__AssignableTerminal__Alternatives2885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CrossReferenceableTerminal__Alternatives2917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__CrossReferenceableTerminal__Alternatives2934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_02967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_02987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_03007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__0__Impl_in_rule__Grammar__Group__03188 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__1_in_rule__Grammar__Group__03191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Grammar__Group__0__Impl3219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__1__Impl_in_rule__Grammar__Group__13250 = new BitSet(new long[]{0x0000062002840010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__2_in_rule__Grammar__Group__13253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__NameAssignment_1_in_rule__Grammar__Group__1__Impl3280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__2__Impl_in_rule__Grammar__Group__23310 = new BitSet(new long[]{0x0000062002800010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__3_in_rule__Grammar__Group__23313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__0_in_rule__Grammar__Group__2__Impl3340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__3__Impl_in_rule__Grammar__Group__33371 = new BitSet(new long[]{0x0000022002800010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__4_in_rule__Grammar__Group__33374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__0_in_rule__Grammar__Group__3__Impl3401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__4__Impl_in_rule__Grammar__Group__43432 = new BitSet(new long[]{0x0000022000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__5_in_rule__Grammar__Group__43435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__MetamodelDeclarationsAssignment_4_in_rule__Grammar__Group__4__Impl3462 = new BitSet(new long[]{0x0000000002800002L});
        public static final BitSet FOLLOW_rule__Grammar__Group__5__Impl_in_rule__Grammar__Group__53493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__5__Impl3522 = new BitSet(new long[]{0x0000022000000012L});
        public static final BitSet FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__5__Impl3534 = new BitSet(new long[]{0x0000022000000012L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__0__Impl_in_rule__Grammar__Group_2__03579 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__1_in_rule__Grammar__Group_2__03582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Grammar__Group_2__0__Impl3610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__1__Impl_in_rule__Grammar__Group_2__13641 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__2_in_rule__Grammar__Group_2__13644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_1_in_rule__Grammar__Group_2__1__Impl3671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__2__Impl_in_rule__Grammar__Group_2__23701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__0_in_rule__Grammar__Group_2__2__Impl3728 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__0__Impl_in_rule__Grammar__Group_2_2__03765 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__1_in_rule__Grammar__Group_2_2__03768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Grammar__Group_2_2__0__Impl3796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__1__Impl_in_rule__Grammar__Group_2_2__13827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_2_1_in_rule__Grammar__Group_2_2__1__Impl3854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__0__Impl_in_rule__Grammar__Group_3__03888 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__1_in_rule__Grammar__Group_3__03891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__DefinesHiddenTokensAssignment_3_0_in_rule__Grammar__Group_3__0__Impl3918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__1__Impl_in_rule__Grammar__Group_3__13948 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__2_in_rule__Grammar__Group_3__13951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Grammar__Group_3__1__Impl3979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__2__Impl_in_rule__Grammar__Group_3__24010 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__3_in_rule__Grammar__Group_3__24013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__0_in_rule__Grammar__Group_3__2__Impl4040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__3__Impl_in_rule__Grammar__Group_3__34071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Grammar__Group_3__3__Impl4099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__0__Impl_in_rule__Grammar__Group_3_2__04138 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__1_in_rule__Grammar__Group_3_2__04141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_0_in_rule__Grammar__Group_3_2__0__Impl4168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__1__Impl_in_rule__Grammar__Group_3_2__14198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__0_in_rule__Grammar__Group_3_2__1__Impl4225 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__0__Impl_in_rule__Grammar__Group_3_2_1__04260 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__1_in_rule__Grammar__Group_3_2_1__04263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Grammar__Group_3_2_1__0__Impl4291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__1__Impl_in_rule__Grammar__Group_3_2_1__14322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_1_1_in_rule__Grammar__Group_3_2_1__1__Impl4349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__0__Impl_in_rule__GrammarID__Group__04383 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__1_in_rule__GrammarID__Group__04386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group__0__Impl4413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__1__Impl_in_rule__GrammarID__Group__14442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__0_in_rule__GrammarID__Group__1__Impl4469 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__0__Impl_in_rule__GrammarID__Group_1__04504 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__1_in_rule__GrammarID__Group_1__04507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__GrammarID__Group_1__0__Impl4535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__1__Impl_in_rule__GrammarID__Group_1__14566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group_1__1__Impl4593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__0__Impl_in_rule__GeneratedMetamodel__Group__04626 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__1_in_rule__GeneratedMetamodel__Group__04629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__GeneratedMetamodel__Group__0__Impl4657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__1__Impl_in_rule__GeneratedMetamodel__Group__14688 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__2_in_rule__GeneratedMetamodel__Group__14691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__NameAssignment_1_in_rule__GeneratedMetamodel__Group__1__Impl4718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__2__Impl_in_rule__GeneratedMetamodel__Group__24748 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__3_in_rule__GeneratedMetamodel__Group__24751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__EPackageAssignment_2_in_rule__GeneratedMetamodel__Group__2__Impl4778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__3__Impl_in_rule__GeneratedMetamodel__Group__34808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__0_in_rule__GeneratedMetamodel__Group__3__Impl4835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__0__Impl_in_rule__GeneratedMetamodel__Group_3__04874 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__1_in_rule__GeneratedMetamodel__Group_3__04877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__GeneratedMetamodel__Group_3__0__Impl4905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__1__Impl_in_rule__GeneratedMetamodel__Group_3__14936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__AliasAssignment_3_1_in_rule__GeneratedMetamodel__Group_3__1__Impl4963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__0__Impl_in_rule__ReferencedMetamodel__Group__04997 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__05000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ReferencedMetamodel__Group__0__Impl5028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__1__Impl_in_rule__ReferencedMetamodel__Group__15059 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__15062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_1_in_rule__ReferencedMetamodel__Group__1__Impl5089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__2__Impl_in_rule__ReferencedMetamodel__Group__25119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__0_in_rule__ReferencedMetamodel__Group__2__Impl5146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__0__Impl_in_rule__ReferencedMetamodel__Group_2__05183 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__1_in_rule__ReferencedMetamodel__Group_2__05186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__ReferencedMetamodel__Group_2__0__Impl5214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__1__Impl_in_rule__ReferencedMetamodel__Group_2__15245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__AliasAssignment_2_1_in_rule__ReferencedMetamodel__Group_2__1__Impl5272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__0__Impl_in_rule__ParserRule__Group__05306 = new BitSet(new long[]{0x0000040014000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__1_in_rule__ParserRule__Group__05309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__NameAssignment_0_in_rule__ParserRule__Group__0__Impl5336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__1__Impl_in_rule__ParserRule__Group__15366 = new BitSet(new long[]{0x0000040004000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__2_in_rule__ParserRule__Group__15369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__0_in_rule__ParserRule__Group__1__Impl5396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__2__Impl_in_rule__ParserRule__Group__25427 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__3_in_rule__ParserRule__Group__25430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__0_in_rule__ParserRule__Group__2__Impl5457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__3__Impl_in_rule__ParserRule__Group__35488 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__4_in_rule__ParserRule__Group__35491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__ParserRule__Group__3__Impl5519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__4__Impl_in_rule__ParserRule__Group__45550 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__5_in_rule__ParserRule__Group__45553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__AlternativesAssignment_4_in_rule__ParserRule__Group__4__Impl5580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__5__Impl_in_rule__ParserRule__Group__55610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ParserRule__Group__5__Impl5638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__0__Impl_in_rule__ParserRule__Group_1__05681 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__1_in_rule__ParserRule__Group_1__05684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ParserRule__Group_1__0__Impl5712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__1__Impl_in_rule__ParserRule__Group_1__15743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__TypeAssignment_1_1_in_rule__ParserRule__Group_1__1__Impl5770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__0__Impl_in_rule__ParserRule__Group_2__05804 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__1_in_rule__ParserRule__Group_2__05807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__DefinesHiddenTokensAssignment_2_0_in_rule__ParserRule__Group_2__0__Impl5834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__1__Impl_in_rule__ParserRule__Group_2__15864 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__2_in_rule__ParserRule__Group_2__15867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParserRule__Group_2__1__Impl5895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__2__Impl_in_rule__ParserRule__Group_2__25926 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__3_in_rule__ParserRule__Group_2__25929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__0_in_rule__ParserRule__Group_2__2__Impl5956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__3__Impl_in_rule__ParserRule__Group_2__35987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParserRule__Group_2__3__Impl6015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__0__Impl_in_rule__ParserRule__Group_2_2__06054 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__1_in_rule__ParserRule__Group_2_2__06057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_0_in_rule__ParserRule__Group_2_2__0__Impl6084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__1__Impl_in_rule__ParserRule__Group_2_2__16114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__0_in_rule__ParserRule__Group_2_2__1__Impl6141 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__0__Impl_in_rule__ParserRule__Group_2_2_1__06176 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__1_in_rule__ParserRule__Group_2_2_1__06179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__ParserRule__Group_2_2_1__0__Impl6207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__1__Impl_in_rule__ParserRule__Group_2_2_1__16238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_1_1_in_rule__ParserRule__Group_2_2_1__1__Impl6265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__0__Impl_in_rule__TypeRef__Group__06299 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__1_in_rule__TypeRef__Group__06302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__0_in_rule__TypeRef__Group__0__Impl6329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__1__Impl_in_rule__TypeRef__Group__16360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__ClassifierAssignment_1_in_rule__TypeRef__Group__1__Impl6387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__0__Impl_in_rule__TypeRef__Group_0__06421 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__1_in_rule__TypeRef__Group_0__06424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__MetamodelAssignment_0_0_in_rule__TypeRef__Group_0__0__Impl6451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__1__Impl_in_rule__TypeRef__Group_0__16481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__TypeRef__Group_0__1__Impl6509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__0__Impl_in_rule__Alternatives__Group__06544 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__1_in_rule__Alternatives__Group__06547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_rule__Alternatives__Group__0__Impl6574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__1__Impl_in_rule__Alternatives__Group__16603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__0_in_rule__Alternatives__Group__1__Impl6630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__0__Impl_in_rule__Alternatives__Group_1__06665 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__1_in_rule__Alternatives__Group_1__06668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__1__Impl_in_rule__Alternatives__Group_1__16726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__1__Impl6755 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__1__Impl6767 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0__Impl_in_rule__Alternatives__Group_1_1__06804 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__1_in_rule__Alternatives__Group_1_1__06807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__Alternatives__Group_1_1__0__Impl6835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__1__Impl_in_rule__Alternatives__Group_1_1__16866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__ElementsAssignment_1_1_1_in_rule__Alternatives__Group_1_1__1__Impl6893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group__0__Impl_in_rule__UnorderedGroup__Group__06927 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group__1_in_rule__UnorderedGroup__Group__06930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_rule__UnorderedGroup__Group__0__Impl6957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group__1__Impl_in_rule__UnorderedGroup__Group__16986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1__0_in_rule__UnorderedGroup__Group__1__Impl7013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1__0__Impl_in_rule__UnorderedGroup__Group_1__07048 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1__1_in_rule__UnorderedGroup__Group_1__07051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1__1__Impl_in_rule__UnorderedGroup__Group_1__17109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__0_in_rule__UnorderedGroup__Group_1__1__Impl7138 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__0_in_rule__UnorderedGroup__Group_1__1__Impl7150 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__0__Impl_in_rule__UnorderedGroup__Group_1_1__07187 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__1_in_rule__UnorderedGroup__Group_1_1__07190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__UnorderedGroup__Group_1_1__0__Impl7218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__1__Impl_in_rule__UnorderedGroup__Group_1_1__17249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__ElementsAssignment_1_1_1_in_rule__UnorderedGroup__Group_1_1__1__Impl7276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group__0__Impl_in_rule__Group__Group__07310 = new BitSet(new long[]{0x0000000100100032L});
        public static final BitSet FOLLOW_rule__Group__Group__1_in_rule__Group__Group__07313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__Group__0__Impl7340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group__1__Impl_in_rule__Group__Group__17369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__0_in_rule__Group__Group__1__Impl7396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__0__Impl_in_rule__Group__Group_1__07431 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__Group__Group_1__1_in_rule__Group__Group_1__07434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__1__Impl_in_rule__Group__Group_1__17492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__ElementsAssignment_1_1_in_rule__Group__Group_1__1__Impl7521 = new BitSet(new long[]{0x0000000100100032L});
        public static final BitSet FOLLOW_rule__Group__ElementsAssignment_1_1_in_rule__Group__Group_1__1__Impl7533 = new BitSet(new long[]{0x0000000100100032L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__0__Impl_in_rule__AbstractTokenWithCardinality__Group__07570 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__1_in_rule__AbstractTokenWithCardinality__Group__07573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group__0__Impl7600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__1__Impl_in_rule__AbstractTokenWithCardinality__Group__17630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAssignment_1_in_rule__AbstractTokenWithCardinality__Group__1__Impl7657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__0__Impl_in_rule__Action__Group__07692 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Action__Group__1_in_rule__Action__Group__07695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Action__Group__0__Impl7723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__1__Impl_in_rule__Action__Group__17754 = new BitSet(new long[]{0x0000000200400000L});
        public static final BitSet FOLLOW_rule__Action__Group__2_in_rule__Action__Group__17757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__TypeAssignment_1_in_rule__Action__Group__1__Impl7784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__2__Impl_in_rule__Action__Group__27814 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__Action__Group__3_in_rule__Action__Group__27817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__0_in_rule__Action__Group__2__Impl7844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__3__Impl_in_rule__Action__Group__37875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__Action__Group__3__Impl7903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__0__Impl_in_rule__Action__Group_2__07942 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Action__Group_2__1_in_rule__Action__Group_2__07945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Action__Group_2__0__Impl7973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__1__Impl_in_rule__Action__Group_2__18004 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_rule__Action__Group_2__2_in_rule__Action__Group_2__18007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__FeatureAssignment_2_1_in_rule__Action__Group_2__1__Impl8034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__2__Impl_in_rule__Action__Group_2__28064 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__Action__Group_2__3_in_rule__Action__Group_2__28067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__OperatorAssignment_2_2_in_rule__Action__Group_2__2__Impl8094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__3__Impl_in_rule__Action__Group_2__38124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__Action__Group_2__3__Impl8152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__0__Impl_in_rule__Assignment__Group__08191 = new BitSet(new long[]{0x000000000001C000L});
        public static final BitSet FOLLOW_rule__Assignment__Group__1_in_rule__Assignment__Group__08194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__FeatureAssignment_0_in_rule__Assignment__Group__0__Impl8221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__1__Impl_in_rule__Assignment__Group__18251 = new BitSet(new long[]{0x0000000800100030L});
        public static final BitSet FOLLOW_rule__Assignment__Group__2_in_rule__Assignment__Group__18254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__OperatorAssignment_1_in_rule__Assignment__Group__1__Impl8281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__2__Impl_in_rule__Assignment__Group__28311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__TerminalAssignment_2_in_rule__Assignment__Group__2__Impl8338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__0__Impl_in_rule__ParenthesizedAssignableElement__Group__08374 = new BitSet(new long[]{0x0000000800100030L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__1_in_rule__ParenthesizedAssignableElement__Group__08377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedAssignableElement__Group__0__Impl8405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__1__Impl_in_rule__ParenthesizedAssignableElement__Group__18436 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__2_in_rule__ParenthesizedAssignableElement__Group__18439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group__1__Impl8466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__2__Impl_in_rule__ParenthesizedAssignableElement__Group__28495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group__2__Impl8523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__0__Impl_in_rule__AssignableAlternatives__Group__08560 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__1_in_rule__AssignableAlternatives__Group__08563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group__0__Impl8590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__1__Impl_in_rule__AssignableAlternatives__Group__18619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__0_in_rule__AssignableAlternatives__Group__1__Impl8646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__0__Impl_in_rule__AssignableAlternatives__Group_1__08681 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__1_in_rule__AssignableAlternatives__Group_1__08684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__1__Impl_in_rule__AssignableAlternatives__Group_1__18742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__1__Impl8771 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__1__Impl8783 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0__Impl_in_rule__AssignableAlternatives__Group_1_1__08820 = new BitSet(new long[]{0x0000000800100030L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__1_in_rule__AssignableAlternatives__Group_1_1__08823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__AssignableAlternatives__Group_1_1__0__Impl8851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__1__Impl_in_rule__AssignableAlternatives__Group_1_1__18882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__ElementsAssignment_1_1_1_in_rule__AssignableAlternatives__Group_1_1__1__Impl8909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__0__Impl_in_rule__CrossReference__Group__08943 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__1_in_rule__CrossReference__Group__08946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__CrossReference__Group__0__Impl8974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__1__Impl_in_rule__CrossReference__Group__19005 = new BitSet(new long[]{0x0000001040000000L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__2_in_rule__CrossReference__Group__19008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__TypeAssignment_1_in_rule__CrossReference__Group__1__Impl9035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__2__Impl_in_rule__CrossReference__Group__29065 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__3_in_rule__CrossReference__Group__29068 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__0_in_rule__CrossReference__Group__2__Impl9095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__3__Impl_in_rule__CrossReference__Group__39126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__CrossReference__Group__3__Impl9154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__0__Impl_in_rule__CrossReference__Group_2__09193 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__1_in_rule__CrossReference__Group_2__09196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__CrossReference__Group_2__0__Impl9224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__1__Impl_in_rule__CrossReference__Group_2__19255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__TerminalAssignment_2_1_in_rule__CrossReference__Group_2__1__Impl9282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__0__Impl_in_rule__ParenthesizedElement__Group__09316 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__1_in_rule__ParenthesizedElement__Group__09319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedElement__Group__0__Impl9347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__1__Impl_in_rule__ParenthesizedElement__Group__19378 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__2_in_rule__ParenthesizedElement__Group__19381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group__1__Impl9408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__2__Impl_in_rule__ParenthesizedElement__Group__29437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedElement__Group__2__Impl9465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__0__Impl_in_rule__TerminalRule__Group__09502 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__1_in_rule__TerminalRule__Group__09505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__TerminalRule__Group__0__Impl9533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__1__Impl_in_rule__TerminalRule__Group__19564 = new BitSet(new long[]{0x0000000014000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__2_in_rule__TerminalRule__Group__19567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__NameAssignment_1_in_rule__TerminalRule__Group__1__Impl9594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__2__Impl_in_rule__TerminalRule__Group__29624 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__3_in_rule__TerminalRule__Group__29627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_2__0_in_rule__TerminalRule__Group__2__Impl9654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__3__Impl_in_rule__TerminalRule__Group__39685 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__4_in_rule__TerminalRule__Group__39688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__TerminalRule__Group__3__Impl9716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__4__Impl_in_rule__TerminalRule__Group__49747 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__5_in_rule__TerminalRule__Group__49750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__AlternativesAssignment_4_in_rule__TerminalRule__Group__4__Impl9777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__5__Impl_in_rule__TerminalRule__Group__59807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__TerminalRule__Group__5__Impl9835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_2__0__Impl_in_rule__TerminalRule__Group_2__09878 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_2__1_in_rule__TerminalRule__Group_2__09881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__TerminalRule__Group_2__0__Impl9909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_2__1__Impl_in_rule__TerminalRule__Group_2__19940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__TypeAssignment_2_1_in_rule__TerminalRule__Group_2__1__Impl9967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__0__Impl_in_rule__TerminalAlternatives__Group__010001 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__1_in_rule__TerminalAlternatives__Group__010004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group__0__Impl10031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__1__Impl_in_rule__TerminalAlternatives__Group__110060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__0_in_rule__TerminalAlternatives__Group__1__Impl10087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__0__Impl_in_rule__TerminalAlternatives__Group_1__010122 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__1_in_rule__TerminalAlternatives__Group_1__010125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__1__Impl_in_rule__TerminalAlternatives__Group_1__110183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__1__Impl10212 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__1__Impl10224 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0__Impl_in_rule__TerminalAlternatives__Group_1_1__010261 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__1_in_rule__TerminalAlternatives__Group_1_1__010264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__TerminalAlternatives__Group_1_1__0__Impl10292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__1__Impl_in_rule__TerminalAlternatives__Group_1_1__110323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__ElementsAssignment_1_1_1_in_rule__TerminalAlternatives__Group_1_1__1__Impl10350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__0__Impl_in_rule__TerminalGroup__Group__010384 = new BitSet(new long[]{0x000000C000500032L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__1_in_rule__TerminalGroup__Group__010387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group__0__Impl10414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__1__Impl_in_rule__TerminalGroup__Group__110443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__0_in_rule__TerminalGroup__Group__1__Impl10470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__0__Impl_in_rule__TerminalGroup__Group_1__010505 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__1_in_rule__TerminalGroup__Group_1__010508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__1__Impl_in_rule__TerminalGroup__Group_1__110566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__ElementsAssignment_1_1_in_rule__TerminalGroup__Group_1__1__Impl10595 = new BitSet(new long[]{0x000000C000500032L});
        public static final BitSet FOLLOW_rule__TerminalGroup__ElementsAssignment_1_1_in_rule__TerminalGroup__Group_1__1__Impl10607 = new BitSet(new long[]{0x000000C000500032L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__0__Impl_in_rule__TerminalToken__Group__010644 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__1_in_rule__TerminalToken__Group__010647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group__0__Impl10674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__1__Impl_in_rule__TerminalToken__Group__110703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAssignment_1_in_rule__TerminalToken__Group__1__Impl10730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__0__Impl_in_rule__ParenthesizedTerminalElement__Group__010765 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__1_in_rule__ParenthesizedTerminalElement__Group__010768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedTerminalElement__Group__0__Impl10796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__1__Impl_in_rule__ParenthesizedTerminalElement__Group__110827 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__2_in_rule__ParenthesizedTerminalElement__Group__110830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group__1__Impl10857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__2__Impl_in_rule__ParenthesizedTerminalElement__Group__210886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group__2__Impl10914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__0__Impl_in_rule__NegatedToken__Group__010951 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__1_in_rule__NegatedToken__Group__010954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__NegatedToken__Group__0__Impl10982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__1__Impl_in_rule__NegatedToken__Group__111013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__TerminalAssignment_1_in_rule__NegatedToken__Group__1__Impl11040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__0__Impl_in_rule__UntilToken__Group__011074 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__1_in_rule__UntilToken__Group__011077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__UntilToken__Group__0__Impl11105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__1__Impl_in_rule__UntilToken__Group__111136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__TerminalAssignment_1_in_rule__UntilToken__Group__1__Impl11163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__0__Impl_in_rule__Wildcard__Group__011197 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__1_in_rule__Wildcard__Group__011200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__1__Impl_in_rule__Wildcard__Group__111258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Wildcard__Group__1__Impl11286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__0__Impl_in_rule__CharacterRange__Group__011321 = new BitSet(new long[]{0x0000010000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__1_in_rule__CharacterRange__Group__011324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__Group__0__Impl11351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__1__Impl_in_rule__CharacterRange__Group__111380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__0_in_rule__CharacterRange__Group__1__Impl11407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__0__Impl_in_rule__CharacterRange__Group_1__011442 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__1_in_rule__CharacterRange__Group_1__011445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__1__Impl_in_rule__CharacterRange__Group_1__111503 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__2_in_rule__CharacterRange__Group_1__111506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__CharacterRange__Group_1__1__Impl11534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__2__Impl_in_rule__CharacterRange__Group_1__211565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__RightAssignment_1_2_in_rule__CharacterRange__Group_1__2__Impl11592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__0__Impl_in_rule__EnumRule__Group__011628 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__1_in_rule__EnumRule__Group__011631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__EnumRule__Group__0__Impl11659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__1__Impl_in_rule__EnumRule__Group__111690 = new BitSet(new long[]{0x0000000014000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__2_in_rule__EnumRule__Group__111693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__NameAssignment_1_in_rule__EnumRule__Group__1__Impl11720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__2__Impl_in_rule__EnumRule__Group__211750 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__3_in_rule__EnumRule__Group__211753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__0_in_rule__EnumRule__Group__2__Impl11780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__3__Impl_in_rule__EnumRule__Group__311811 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__4_in_rule__EnumRule__Group__311814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__EnumRule__Group__3__Impl11842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__4__Impl_in_rule__EnumRule__Group__411873 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__5_in_rule__EnumRule__Group__411876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__AlternativesAssignment_4_in_rule__EnumRule__Group__4__Impl11903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__5__Impl_in_rule__EnumRule__Group__511933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__EnumRule__Group__5__Impl11961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__0__Impl_in_rule__EnumRule__Group_2__012004 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__1_in_rule__EnumRule__Group_2__012007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__EnumRule__Group_2__0__Impl12035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__1__Impl_in_rule__EnumRule__Group_2__112066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__TypeAssignment_2_1_in_rule__EnumRule__Group_2__1__Impl12093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__0__Impl_in_rule__EnumLiterals__Group__012127 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__1_in_rule__EnumLiterals__Group__012130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group__0__Impl12157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__1__Impl_in_rule__EnumLiterals__Group__112186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__0_in_rule__EnumLiterals__Group__1__Impl12213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__0__Impl_in_rule__EnumLiterals__Group_1__012248 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__1_in_rule__EnumLiterals__Group_1__012251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__1__Impl_in_rule__EnumLiterals__Group_1__112309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__1__Impl12338 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__1__Impl12350 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0__Impl_in_rule__EnumLiterals__Group_1_1__012387 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__1_in_rule__EnumLiterals__Group_1_1__012390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__EnumLiterals__Group_1_1__0__Impl12418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__1__Impl_in_rule__EnumLiterals__Group_1_1__112449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__ElementsAssignment_1_1_1_in_rule__EnumLiterals__Group_1_1__1__Impl12476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__0__Impl_in_rule__EnumLiteralDeclaration__Group__012510 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__1_in_rule__EnumLiteralDeclaration__Group__012513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__EnumLiteralAssignment_0_in_rule__EnumLiteralDeclaration__Group__0__Impl12540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__1__Impl_in_rule__EnumLiteralDeclaration__Group__112570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__0_in_rule__EnumLiteralDeclaration__Group__1__Impl12597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__0__Impl_in_rule__EnumLiteralDeclaration__Group_1__012632 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__1_in_rule__EnumLiteralDeclaration__Group_1__012635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_1__0__Impl12663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__1__Impl_in_rule__EnumLiteralDeclaration__Group_1__112694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__LiteralAssignment_1_1_in_rule__EnumLiteralDeclaration__Group_1__1__Impl12721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__NameAssignment_112760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_112795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_2_112834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__Grammar__DefinesHiddenTokensAssignment_3_012874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_012917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_1_112956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__MetamodelDeclarationsAssignment_412991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_rule__Grammar__RulesAssignment_513022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__NameAssignment_113053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__EPackageAssignment_213088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__AliasAssignment_3_113123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_113158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_2_113193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__NameAssignment_013224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__ParserRule__TypeAssignment_1_113255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__ParserRule__DefinesHiddenTokensAssignment_2_013291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_013334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_1_113373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParserRule__AlternativesAssignment_413408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__MetamodelAssignment_0_013443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__ClassifierAssignment_113482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_rule__Alternatives__ElementsAssignment_1_1_113517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_rule__UnorderedGroup__ElementsAssignment_1_1_113548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__ElementsAssignment_1_113579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__CardinalityAssignment_113610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Action__TypeAssignment_113643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Action__FeatureAssignment_2_113674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__OperatorAssignment_2_213705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__ValueAssignment13738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__RuleCall__RuleAssignment13773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Assignment__FeatureAssignment_013808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__OperatorAssignment_113839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__Assignment__TerminalAssignment_213872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__ElementsAssignment_1_1_113903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__CrossReference__TypeAssignment_113934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__TerminalAssignment_2_113965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_113996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__TerminalRule__TypeAssignment_2_114027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__AlternativesAssignment_414058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__ElementsAssignment_1_1_114089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__ElementsAssignment_1_114120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__CardinalityAssignment_114151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__TerminalAssignment_114184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__TerminalAssignment_114215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__RightAssignment_1_214246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EnumRule__NameAssignment_114277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__EnumRule__TypeAssignment_2_114308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_rule__EnumRule__AlternativesAssignment_414339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__ElementsAssignment_1_1_114370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__EnumLiteralAssignment_014405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__LiteralAssignment_1_114440 = new BitSet(new long[]{0x0000000000000002L});
    }


}
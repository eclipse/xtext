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
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.services.XtextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g"; }


     
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:60:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:61:1: ( ruleGrammar EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:62:1: ruleGrammar EOF
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:69:1: ruleGrammar : ( ( rule__Grammar__Group__0 ) ) ;
    public final void ruleGrammar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:73:2: ( ( ( rule__Grammar__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:74:1: ( ( rule__Grammar__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:74:1: ( ( rule__Grammar__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:75:1: ( rule__Grammar__Group__0 )
            {
             before(grammarAccess.getGrammarAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:76:1: ( rule__Grammar__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:76:2: rule__Grammar__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__0_in_ruleGrammar95);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:88:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:89:1: ( ruleGrammarID EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:90:1: ruleGrammarID EOF
            {
             before(grammarAccess.getGrammarIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_entryRuleGrammarID122);
            ruleGrammarID();
            _fsp--;

             after(grammarAccess.getGrammarIDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammarID129); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:97:1: ruleGrammarID : ( ( rule__GrammarID__Group__0 ) ) ;
    public final void ruleGrammarID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:101:2: ( ( ( rule__GrammarID__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:102:1: ( ( rule__GrammarID__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:102:1: ( ( rule__GrammarID__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:103:1: ( rule__GrammarID__Group__0 )
            {
             before(grammarAccess.getGrammarIDAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:104:1: ( rule__GrammarID__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:104:2: rule__GrammarID__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__0_in_ruleGrammarID156);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:116:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:117:1: ( ruleAbstractRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:118:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule183);
            ruleAbstractRule();
            _fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRule190); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:125:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:129:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:130:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:130:1: ( ( rule__AbstractRule__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:131:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:132:1: ( rule__AbstractRule__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:132:2: rule__AbstractRule__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule217);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:144:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:145:1: ( ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:146:1: ruleAbstractMetamodelDeclaration EOF
            {
             before(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration244);
            ruleAbstractMetamodelDeclaration();
            _fsp--;

             after(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration251); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:153:1: ruleAbstractMetamodelDeclaration : ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:157:2: ( ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:158:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:158:1: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:159:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            {
             before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:160:1: ( rule__AbstractMetamodelDeclaration__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:160:2: rule__AbstractMetamodelDeclaration__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractMetamodelDeclaration__Alternatives_in_ruleAbstractMetamodelDeclaration278);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:172:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:173:1: ( ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:174:1: ruleGeneratedMetamodel EOF
            {
             before(grammarAccess.getGeneratedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel305);
            ruleGeneratedMetamodel();
            _fsp--;

             after(grammarAccess.getGeneratedMetamodelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGeneratedMetamodel312); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:181:1: ruleGeneratedMetamodel : ( ( rule__GeneratedMetamodel__Group__0 ) ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:185:2: ( ( ( rule__GeneratedMetamodel__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:186:1: ( ( rule__GeneratedMetamodel__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:186:1: ( ( rule__GeneratedMetamodel__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:187:1: ( rule__GeneratedMetamodel__Group__0 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:188:1: ( rule__GeneratedMetamodel__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:188:2: rule__GeneratedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__0_in_ruleGeneratedMetamodel339);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:200:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:201:1: ( ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:202:1: ruleReferencedMetamodel EOF
            {
             before(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel366);
            ruleReferencedMetamodel();
            _fsp--;

             after(grammarAccess.getReferencedMetamodelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferencedMetamodel373); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:209:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:213:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:214:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:214:1: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:215:1: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:216:1: ( rule__ReferencedMetamodel__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:216:2: rule__ReferencedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__0_in_ruleReferencedMetamodel400);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:228:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:229:1: ( ruleParserRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:230:1: ruleParserRule EOF
            {
             before(grammarAccess.getParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_entryRuleParserRule427);
            ruleParserRule();
            _fsp--;

             after(grammarAccess.getParserRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRule434); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:237:1: ruleParserRule : ( ( rule__ParserRule__Group__0 ) ) ;
    public final void ruleParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:241:2: ( ( ( rule__ParserRule__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:242:1: ( ( rule__ParserRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:242:1: ( ( rule__ParserRule__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:243:1: ( rule__ParserRule__Group__0 )
            {
             before(grammarAccess.getParserRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:244:1: ( rule__ParserRule__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:244:2: rule__ParserRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__0_in_ruleParserRule461);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:256:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:257:1: ( ruleTypeRef EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:258:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_entryRuleTypeRef488);
            ruleTypeRef();
            _fsp--;

             after(grammarAccess.getTypeRefRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRef495); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:265:1: ruleTypeRef : ( ( rule__TypeRef__Group__0 ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:269:2: ( ( ( rule__TypeRef__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:270:1: ( ( rule__TypeRef__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:270:1: ( ( rule__TypeRef__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:271:1: ( rule__TypeRef__Group__0 )
            {
             before(grammarAccess.getTypeRefAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:272:1: ( rule__TypeRef__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:272:2: rule__TypeRef__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__0_in_ruleTypeRef522);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:284:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:285:1: ( ruleAlternatives EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:286:1: ruleAlternatives EOF
            {
             before(grammarAccess.getAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_entryRuleAlternatives549);
            ruleAlternatives();
            _fsp--;

             after(grammarAccess.getAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternatives556); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:293:1: ruleAlternatives : ( ( rule__Alternatives__Group__0 ) ) ;
    public final void ruleAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:297:2: ( ( ( rule__Alternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:298:1: ( ( rule__Alternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:298:1: ( ( rule__Alternatives__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:299:1: ( rule__Alternatives__Group__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:300:1: ( rule__Alternatives__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:300:2: rule__Alternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__0_in_ruleAlternatives583);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:312:1: entryRuleUnorderedGroup : ruleUnorderedGroup EOF ;
    public final void entryRuleUnorderedGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:313:1: ( ruleUnorderedGroup EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:314:1: ruleUnorderedGroup EOF
            {
             before(grammarAccess.getUnorderedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup610);
            ruleUnorderedGroup();
            _fsp--;

             after(grammarAccess.getUnorderedGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedGroup617); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:321:1: ruleUnorderedGroup : ( ( rule__UnorderedGroup__Group__0 ) ) ;
    public final void ruleUnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:325:2: ( ( ( rule__UnorderedGroup__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:326:1: ( ( rule__UnorderedGroup__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:326:1: ( ( rule__UnorderedGroup__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:327:1: ( rule__UnorderedGroup__Group__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:328:1: ( rule__UnorderedGroup__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:328:2: rule__UnorderedGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group__0_in_ruleUnorderedGroup644);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:340:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:341:1: ( ruleGroup EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:342:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_entryRuleGroup671);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroup678); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:349:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:353:2: ( ( ( rule__Group__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:354:1: ( ( rule__Group__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:354:1: ( ( rule__Group__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:355:1: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:356:1: ( rule__Group__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:356:2: rule__Group__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__0_in_ruleGroup705);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:368:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:369:1: ( ruleAbstractToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:370:1: ruleAbstractToken EOF
            {
             before(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken732);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getAbstractTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractToken739); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:377:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:381:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:382:1: ( ( rule__AbstractToken__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:382:1: ( ( rule__AbstractToken__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:383:1: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:384:1: ( rule__AbstractToken__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:384:2: rule__AbstractToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken766);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:396:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:397:1: ( ruleAbstractTokenWithCardinality EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:398:1: ruleAbstractTokenWithCardinality EOF
            {
             before(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality793);
            ruleAbstractTokenWithCardinality();
            _fsp--;

             after(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality800); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:405:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:409:2: ( ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:410:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:410:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:411:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:412:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:412:2: rule__AbstractTokenWithCardinality__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__0_in_ruleAbstractTokenWithCardinality827);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:424:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:425:1: ( ruleAction EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:426:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction854);
            ruleAction();
            _fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction861); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:433:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:437:2: ( ( ( rule__Action__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:438:1: ( ( rule__Action__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:438:1: ( ( rule__Action__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:439:1: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:440:1: ( rule__Action__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:440:2: rule__Action__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__0_in_ruleAction888);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:452:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:453:1: ( ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:454:1: ruleAbstractTerminal EOF
            {
             before(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal915);
            ruleAbstractTerminal();
            _fsp--;

             after(grammarAccess.getAbstractTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTerminal922); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:461:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:465:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:466:1: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:466:1: ( ( rule__AbstractTerminal__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:467:1: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:468:1: ( rule__AbstractTerminal__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:468:2: rule__AbstractTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal949);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:480:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:481:1: ( ruleKeyword EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:482:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_entryRuleKeyword976);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeyword983); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:489:1: ruleKeyword : ( ( rule__Keyword__ValueAssignment ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:493:2: ( ( ( rule__Keyword__ValueAssignment ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:494:1: ( ( rule__Keyword__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:494:1: ( ( rule__Keyword__ValueAssignment ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:495:1: ( rule__Keyword__ValueAssignment )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:496:1: ( rule__Keyword__ValueAssignment )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:496:2: rule__Keyword__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Keyword__ValueAssignment_in_ruleKeyword1010);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:508:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:509:1: ( ruleRuleCall EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:510:1: ruleRuleCall EOF
            {
             before(grammarAccess.getRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_entryRuleRuleCall1037);
            ruleRuleCall();
            _fsp--;

             after(grammarAccess.getRuleCallRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCall1044); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:517:1: ruleRuleCall : ( ( rule__RuleCall__RuleAssignment ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:521:2: ( ( ( rule__RuleCall__RuleAssignment ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:522:1: ( ( rule__RuleCall__RuleAssignment ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:522:1: ( ( rule__RuleCall__RuleAssignment ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:523:1: ( rule__RuleCall__RuleAssignment )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:524:1: ( rule__RuleCall__RuleAssignment )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:524:2: rule__RuleCall__RuleAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__RuleCall__RuleAssignment_in_ruleRuleCall1071);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:536:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:537:1: ( ruleAssignment EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:538:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment1098);
            ruleAssignment();
            _fsp--;

             after(grammarAccess.getAssignmentRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment1105); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:545:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:549:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:550:1: ( ( rule__Assignment__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:550:1: ( ( rule__Assignment__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:551:1: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:552:1: ( rule__Assignment__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:552:2: rule__Assignment__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__0_in_ruleAssignment1132);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:564:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:565:1: ( ruleAssignableTerminal EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:566:1: ruleAssignableTerminal EOF
            {
             before(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1159);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableTerminal1166); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:573:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:577:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:578:1: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:578:1: ( ( rule__AssignableTerminal__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:579:1: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:580:1: ( rule__AssignableTerminal__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:580:2: rule__AssignableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1193);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:592:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:593:1: ( ruleParenthesizedAssignableElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:594:1: ruleParenthesizedAssignableElement EOF
            {
             before(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1220);
            ruleParenthesizedAssignableElement();
            _fsp--;

             after(grammarAccess.getParenthesizedAssignableElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement1227); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:601:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:605:2: ( ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:606:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:606:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:607:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:608:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:608:2: rule__ParenthesizedAssignableElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__0_in_ruleParenthesizedAssignableElement1254);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:620:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:621:1: ( ruleAssignableAlternatives EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:622:1: ruleAssignableAlternatives EOF
            {
             before(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1281);
            ruleAssignableAlternatives();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableAlternatives1288); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:629:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group__0 ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:633:2: ( ( ( rule__AssignableAlternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:634:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:634:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:635:1: ( rule__AssignableAlternatives__Group__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:636:1: ( rule__AssignableAlternatives__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:636:2: rule__AssignableAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__0_in_ruleAssignableAlternatives1315);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:648:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:649:1: ( ruleCrossReference EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:650:1: ruleCrossReference EOF
            {
             before(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_entryRuleCrossReference1342);
            ruleCrossReference();
            _fsp--;

             after(grammarAccess.getCrossReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReference1349); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:657:1: ruleCrossReference : ( ( rule__CrossReference__Group__0 ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:661:2: ( ( ( rule__CrossReference__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:662:1: ( ( rule__CrossReference__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:662:1: ( ( rule__CrossReference__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:663:1: ( rule__CrossReference__Group__0 )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:664:1: ( rule__CrossReference__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:664:2: rule__CrossReference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__0_in_ruleCrossReference1376);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:676:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:677:1: ( ruleCrossReferenceableTerminal EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:678:1: ruleCrossReferenceableTerminal EOF
            {
             before(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1403);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceableTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal1410); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:685:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:689:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:690:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:690:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:691:1: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:692:1: ( rule__CrossReferenceableTerminal__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:692:2: rule__CrossReferenceableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1437);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:704:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:705:1: ( ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:706:1: ruleParenthesizedElement EOF
            {
             before(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1464);
            ruleParenthesizedElement();
            _fsp--;

             after(grammarAccess.getParenthesizedElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedElement1471); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:713:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group__0 ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:717:2: ( ( ( rule__ParenthesizedElement__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:718:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:718:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:719:1: ( rule__ParenthesizedElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:720:1: ( rule__ParenthesizedElement__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:720:2: rule__ParenthesizedElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__0_in_ruleParenthesizedElement1498);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:732:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:733:1: ( ruleTerminalRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:734:1: ruleTerminalRule EOF
            {
             before(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1525);
            ruleTerminalRule();
            _fsp--;

             after(grammarAccess.getTerminalRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule1532); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:741:1: ruleTerminalRule : ( ( rule__TerminalRule__Group__0 ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:745:2: ( ( ( rule__TerminalRule__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:746:1: ( ( rule__TerminalRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:746:1: ( ( rule__TerminalRule__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:747:1: ( rule__TerminalRule__Group__0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:748:1: ( rule__TerminalRule__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:748:2: rule__TerminalRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__0_in_ruleTerminalRule1559);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:760:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:761:1: ( ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:762:1: ruleTerminalAlternatives EOF
            {
             before(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1586);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalAlternatives1593); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:769:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group__0 ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:773:2: ( ( ( rule__TerminalAlternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:774:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:774:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:775:1: ( rule__TerminalAlternatives__Group__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:776:1: ( rule__TerminalAlternatives__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:776:2: rule__TerminalAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__0_in_ruleTerminalAlternatives1620);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:788:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:789:1: ( ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:790:1: ruleTerminalGroup EOF
            {
             before(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1647);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalGroup1654); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:797:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group__0 ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:801:2: ( ( ( rule__TerminalGroup__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:802:1: ( ( rule__TerminalGroup__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:802:1: ( ( rule__TerminalGroup__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:803:1: ( rule__TerminalGroup__Group__0 )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:804:1: ( rule__TerminalGroup__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:804:2: rule__TerminalGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__0_in_ruleTerminalGroup1681);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:816:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:817:1: ( ruleTerminalToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:818:1: ruleTerminalToken EOF
            {
             before(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1708);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalToken1715); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:825:1: ruleTerminalToken : ( ( rule__TerminalToken__Group__0 ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:829:2: ( ( ( rule__TerminalToken__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:830:1: ( ( rule__TerminalToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:830:1: ( ( rule__TerminalToken__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:831:1: ( rule__TerminalToken__Group__0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:832:1: ( rule__TerminalToken__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:832:2: rule__TerminalToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__0_in_ruleTerminalToken1742);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:844:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:845:1: ( ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:846:1: ruleTerminalTokenElement EOF
            {
             before(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1769);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getTerminalTokenElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalTokenElement1776); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:853:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:857:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:858:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:858:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:859:1: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:860:1: ( rule__TerminalTokenElement__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:860:2: rule__TerminalTokenElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1803);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:872:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:873:1: ( ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:874:1: ruleParenthesizedTerminalElement EOF
            {
             before(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1830);
            ruleParenthesizedTerminalElement();
            _fsp--;

             after(grammarAccess.getParenthesizedTerminalElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement1837); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:881:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:885:2: ( ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:886:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:886:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:887:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:888:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:888:2: rule__ParenthesizedTerminalElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__0_in_ruleParenthesizedTerminalElement1864);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:900:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:901:1: ( ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:902:1: ruleAbstractNegatedToken EOF
            {
             before(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1891);
            ruleAbstractNegatedToken();
            _fsp--;

             after(grammarAccess.getAbstractNegatedTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractNegatedToken1898); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:909:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:913:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:914:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:914:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:915:1: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:916:1: ( rule__AbstractNegatedToken__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:916:2: rule__AbstractNegatedToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1925);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:928:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:929:1: ( ruleNegatedToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:930:1: ruleNegatedToken EOF
            {
             before(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1952);
            ruleNegatedToken();
            _fsp--;

             after(grammarAccess.getNegatedTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegatedToken1959); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:937:1: ruleNegatedToken : ( ( rule__NegatedToken__Group__0 ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:941:2: ( ( ( rule__NegatedToken__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:942:1: ( ( rule__NegatedToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:942:1: ( ( rule__NegatedToken__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:943:1: ( rule__NegatedToken__Group__0 )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:944:1: ( rule__NegatedToken__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:944:2: rule__NegatedToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__0_in_ruleNegatedToken1986);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:956:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:957:1: ( ruleUntilToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:958:1: ruleUntilToken EOF
            {
             before(grammarAccess.getUntilTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_entryRuleUntilToken2013);
            ruleUntilToken();
            _fsp--;

             after(grammarAccess.getUntilTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUntilToken2020); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:965:1: ruleUntilToken : ( ( rule__UntilToken__Group__0 ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:969:2: ( ( ( rule__UntilToken__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:970:1: ( ( rule__UntilToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:970:1: ( ( rule__UntilToken__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:971:1: ( rule__UntilToken__Group__0 )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:972:1: ( rule__UntilToken__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:972:2: rule__UntilToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__0_in_ruleUntilToken2047);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:984:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:985:1: ( ruleWildcard EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:986:1: ruleWildcard EOF
            {
             before(grammarAccess.getWildcardRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_entryRuleWildcard2074);
            ruleWildcard();
            _fsp--;

             after(grammarAccess.getWildcardRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcard2081); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:993:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:997:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:998:1: ( ( rule__Wildcard__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:998:1: ( ( rule__Wildcard__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:999:1: ( rule__Wildcard__Group__0 )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1000:1: ( rule__Wildcard__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1000:2: rule__Wildcard__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__0_in_ruleWildcard2108);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1012:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1013:1: ( ruleCharacterRange EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1014:1: ruleCharacterRange EOF
            {
             before(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2135);
            ruleCharacterRange();
            _fsp--;

             after(grammarAccess.getCharacterRangeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCharacterRange2142); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1021:1: ruleCharacterRange : ( ( rule__CharacterRange__Group__0 ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1025:2: ( ( ( rule__CharacterRange__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1026:1: ( ( rule__CharacterRange__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1026:1: ( ( rule__CharacterRange__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1027:1: ( rule__CharacterRange__Group__0 )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1028:1: ( rule__CharacterRange__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1028:2: rule__CharacterRange__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__0_in_ruleCharacterRange2169);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1040:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1041:1: ( ruleEnumRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1042:1: ruleEnumRule EOF
            {
             before(grammarAccess.getEnumRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_entryRuleEnumRule2196);
            ruleEnumRule();
            _fsp--;

             after(grammarAccess.getEnumRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumRule2203); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1049:1: ruleEnumRule : ( ( rule__EnumRule__Group__0 ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1053:2: ( ( ( rule__EnumRule__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1054:1: ( ( rule__EnumRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1054:1: ( ( rule__EnumRule__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1055:1: ( rule__EnumRule__Group__0 )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1056:1: ( rule__EnumRule__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1056:2: rule__EnumRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__0_in_ruleEnumRule2230);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1068:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1069:1: ( ruleEnumLiterals EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1070:1: ruleEnumLiterals EOF
            {
             before(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2257);
            ruleEnumLiterals();
            _fsp--;

             after(grammarAccess.getEnumLiteralsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiterals2264); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1077:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group__0 ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1081:2: ( ( ( rule__EnumLiterals__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1082:1: ( ( rule__EnumLiterals__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1082:1: ( ( rule__EnumLiterals__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1083:1: ( rule__EnumLiterals__Group__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1084:1: ( rule__EnumLiterals__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1084:2: rule__EnumLiterals__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__0_in_ruleEnumLiterals2291);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1096:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1097:1: ( ruleEnumLiteralDeclaration EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1098:1: ruleEnumLiteralDeclaration EOF
            {
             before(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2318);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration2325); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1105:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group__0 ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1109:2: ( ( ( rule__EnumLiteralDeclaration__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1110:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1110:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1111:1: ( rule__EnumLiteralDeclaration__Group__0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1112:1: ( rule__EnumLiteralDeclaration__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1112:2: rule__EnumLiteralDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__0_in_ruleEnumLiteralDeclaration2352);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1124:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1128:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
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
                    new NoViableAltException("1124:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1129:1: ( ruleParserRule )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1129:1: ( ruleParserRule )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1130:1: ruleParserRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_rule__AbstractRule__Alternatives2388);
                    ruleParserRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1135:6: ( ruleTerminalRule )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1135:6: ( ruleTerminalRule )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1136:1: ruleTerminalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_rule__AbstractRule__Alternatives2405);
                    ruleTerminalRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1141:6: ( ruleEnumRule )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1141:6: ( ruleEnumRule )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1142:1: ruleEnumRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_rule__AbstractRule__Alternatives2422);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1152:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1156:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
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
                    new NoViableAltException("1152:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1157:1: ( ruleGeneratedMetamodel )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1157:1: ( ruleGeneratedMetamodel )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1158:1: ruleGeneratedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2454);
                    ruleGeneratedMetamodel();
                    _fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1163:6: ( ruleReferencedMetamodel )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1163:6: ( ruleReferencedMetamodel )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1164:1: ruleReferencedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2471);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1174:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1178:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) )
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
                    new NoViableAltException("1174:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1179:1: ( ruleAbstractTokenWithCardinality )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1179:1: ( ruleAbstractTokenWithCardinality )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1180:1: ruleAbstractTokenWithCardinality
                    {
                     before(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_rule__AbstractToken__Alternatives2503);
                    ruleAbstractTokenWithCardinality();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1185:6: ( ruleAction )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1185:6: ( ruleAction )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1186:1: ruleAction
                    {
                     before(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_rule__AbstractToken__Alternatives2520);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1196:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1200:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( ((LA4_1>=14 && LA4_1<=16)) ) {
                    alt4=1;
                }
                else if ( (LA4_1==EOF||(LA4_1>=RULE_ID && LA4_1<=RULE_STRING)||(LA4_1>=11 && LA4_1<=13)||(LA4_1>=20 && LA4_1<=21)||LA4_1==27||(LA4_1>=30 && LA4_1<=32)) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1196:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==RULE_STRING||LA4_0==20) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1196:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1201:1: ( ruleAssignment )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1201:1: ( ruleAssignment )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1202:1: ruleAssignment
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_rule__AbstractTokenWithCardinality__Alternatives_02552);
                    ruleAssignment();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1207:6: ( ruleAbstractTerminal )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1207:6: ( ruleAbstractTerminal )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1208:1: ruleAbstractTerminal
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_rule__AbstractTokenWithCardinality__Alternatives_02569);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1218:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1222:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    new NoViableAltException("1218:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1223:1: ( '?' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1223:1: ( '?' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1224:1: '?'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02602); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1231:6: ( '*' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1231:6: ( '*' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1232:1: '*'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02622); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1239:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1239:6: ( '+' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1240:1: '+'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02642); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1252:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1256:1: ( ( '=' ) | ( '+=' ) )
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
                    new NoViableAltException("1252:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1257:1: ( '=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1257:1: ( '=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1258:1: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Action__OperatorAlternatives_2_2_02677); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1265:6: ( '+=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1265:6: ( '+=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1266:1: '+='
                    {
                     before(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Action__OperatorAlternatives_2_2_02697); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1278:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1282:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) )
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
                    new NoViableAltException("1278:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1283:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1283:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1284:1: ruleKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__AbstractTerminal__Alternatives2731);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1289:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1289:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1290:1: ruleRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__AbstractTerminal__Alternatives2748);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1295:6: ( ruleParenthesizedElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1295:6: ( ruleParenthesizedElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1296:1: ruleParenthesizedElement
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_rule__AbstractTerminal__Alternatives2765);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1306:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1310:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
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
                    new NoViableAltException("1306:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1311:1: ( '+=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1311:1: ( '+=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1312:1: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Assignment__OperatorAlternatives_1_02798); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1319:6: ( '=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1319:6: ( '=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1320:1: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Assignment__OperatorAlternatives_1_02818); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1327:6: ( '?=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1327:6: ( '?=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1328:1: '?='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2()); 
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__Assignment__OperatorAlternatives_1_02838); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1340:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1344:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
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
                    new NoViableAltException("1340:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1345:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1345:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1346:1: ruleKeyword
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__AssignableTerminal__Alternatives2872);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1351:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1351:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1352:1: ruleRuleCall
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__AssignableTerminal__Alternatives2889);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1357:6: ( ruleParenthesizedAssignableElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1357:6: ( ruleParenthesizedAssignableElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1358:1: ruleParenthesizedAssignableElement
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_rule__AssignableTerminal__Alternatives2906);
                    ruleParenthesizedAssignableElement();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1363:6: ( ruleCrossReference )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1363:6: ( ruleCrossReference )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1364:1: ruleCrossReference
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_rule__AssignableTerminal__Alternatives2923);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1374:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1378:1: ( ( ruleKeyword ) | ( ruleRuleCall ) )
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
                    new NoViableAltException("1374:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1379:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1379:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1380:1: ruleKeyword
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CrossReferenceableTerminal__Alternatives2955);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1385:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1385:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1386:1: ruleRuleCall
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__CrossReferenceableTerminal__Alternatives2972);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1396:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__TerminalToken__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1400:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    new NoViableAltException("1396:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1401:1: ( '?' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1401:1: ( '?' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1402:1: '?'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_03005); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1409:6: ( '*' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1409:6: ( '*' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1410:1: '*'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_03025); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1417:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1417:6: ( '+' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1418:1: '+'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_03045); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1430:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1434:1: ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) )
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
                    new NoViableAltException("1430:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1435:1: ( ruleCharacterRange )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1435:1: ( ruleCharacterRange )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1436:1: ruleCharacterRange
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3079);
                    ruleCharacterRange();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1441:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1441:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1442:1: ruleRuleCall
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3096);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1447:6: ( ruleParenthesizedTerminalElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1447:6: ( ruleParenthesizedTerminalElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1448:1: ruleParenthesizedTerminalElement
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3113);
                    ruleParenthesizedTerminalElement();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1453:6: ( ruleAbstractNegatedToken )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1453:6: ( ruleAbstractNegatedToken )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1454:1: ruleAbstractNegatedToken
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3130);
                    ruleAbstractNegatedToken();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1459:6: ( ruleWildcard )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1459:6: ( ruleWildcard )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1460:1: ruleWildcard
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3147);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1470:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1474:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
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
                    new NoViableAltException("1470:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1475:1: ( ruleNegatedToken )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1475:1: ( ruleNegatedToken )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1476:1: ruleNegatedToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3179);
                    ruleNegatedToken();
                    _fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1481:6: ( ruleUntilToken )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1481:6: ( ruleUntilToken )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1482:1: ruleUntilToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3196);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1494:1: rule__Grammar__Group__0 : ( 'grammar' ) rule__Grammar__Group__1 ;
    public final void rule__Grammar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1498:1: ( ( 'grammar' ) rule__Grammar__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1499:1: ( 'grammar' ) rule__Grammar__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1499:1: ( 'grammar' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1500:1: 'grammar'
            {
             before(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Grammar__Group__03231); 
             after(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__1_in_rule__Grammar__Group__03241);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1514:1: rule__Grammar__Group__1 : ( ( rule__Grammar__NameAssignment_1 ) ) rule__Grammar__Group__2 ;
    public final void rule__Grammar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1518:1: ( ( ( rule__Grammar__NameAssignment_1 ) ) rule__Grammar__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1519:1: ( ( rule__Grammar__NameAssignment_1 ) ) rule__Grammar__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1519:1: ( ( rule__Grammar__NameAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1520:1: ( rule__Grammar__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1521:1: ( rule__Grammar__NameAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1521:2: rule__Grammar__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__NameAssignment_1_in_rule__Grammar__Group__13269);
            rule__Grammar__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__2_in_rule__Grammar__Group__13278);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1532:1: rule__Grammar__Group__2 : ( ( rule__Grammar__Group_2__0 )? ) rule__Grammar__Group__3 ;
    public final void rule__Grammar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1536:1: ( ( ( rule__Grammar__Group_2__0 )? ) rule__Grammar__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1537:1: ( ( rule__Grammar__Group_2__0 )? ) rule__Grammar__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1537:1: ( ( rule__Grammar__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1538:1: ( rule__Grammar__Group_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1539:1: ( rule__Grammar__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1539:2: rule__Grammar__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__0_in_rule__Grammar__Group__23306);
                    rule__Grammar__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__3_in_rule__Grammar__Group__23316);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1550:1: rule__Grammar__Group__3 : ( ( rule__Grammar__Group_3__0 )? ) rule__Grammar__Group__4 ;
    public final void rule__Grammar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1554:1: ( ( ( rule__Grammar__Group_3__0 )? ) rule__Grammar__Group__4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1555:1: ( ( rule__Grammar__Group_3__0 )? ) rule__Grammar__Group__4
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1555:1: ( ( rule__Grammar__Group_3__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1556:1: ( rule__Grammar__Group_3__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1557:1: ( rule__Grammar__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==42) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1557:2: rule__Grammar__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__0_in_rule__Grammar__Group__33344);
                    rule__Grammar__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__4_in_rule__Grammar__Group__33354);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1568:1: rule__Grammar__Group__4 : ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) rule__Grammar__Group__5 ;
    public final void rule__Grammar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1572:1: ( ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) rule__Grammar__Group__5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1573:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) rule__Grammar__Group__5
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1573:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1574:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1575:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23||LA16_0==25) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1575:2: rule__Grammar__MetamodelDeclarationsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__MetamodelDeclarationsAssignment_4_in_rule__Grammar__Group__43382);
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

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__5_in_rule__Grammar__Group__43392);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1586:1: rule__Grammar__Group__5 : ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) ;
    public final void rule__Grammar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1590:1: ( ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1591:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1591:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1592:1: ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1592:1: ( ( rule__Grammar__RulesAssignment_5 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1593:1: ( rule__Grammar__RulesAssignment_5 )
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1594:1: ( rule__Grammar__RulesAssignment_5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1594:2: rule__Grammar__RulesAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__53422);
            rule__Grammar__RulesAssignment_5();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1597:1: ( ( rule__Grammar__RulesAssignment_5 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1598:1: ( rule__Grammar__RulesAssignment_5 )*
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1599:1: ( rule__Grammar__RulesAssignment_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID||LA17_0==37||LA17_0==41) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1599:2: rule__Grammar__RulesAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__53434);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1622:1: rule__Grammar__Group_2__0 : ( 'with' ) rule__Grammar__Group_2__1 ;
    public final void rule__Grammar__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1626:1: ( ( 'with' ) rule__Grammar__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1627:1: ( 'with' ) rule__Grammar__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1627:1: ( 'with' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1628:1: 'with'
            {
             before(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Grammar__Group_2__03484); 
             after(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__1_in_rule__Grammar__Group_2__03494);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1642:1: rule__Grammar__Group_2__1 : ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) rule__Grammar__Group_2__2 ;
    public final void rule__Grammar__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1646:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) rule__Grammar__Group_2__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1647:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) rule__Grammar__Group_2__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1647:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1648:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1649:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1649:2: rule__Grammar__UsedGrammarsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_1_in_rule__Grammar__Group_2__13522);
            rule__Grammar__UsedGrammarsAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__2_in_rule__Grammar__Group_2__13531);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1660:1: rule__Grammar__Group_2__2 : ( ( rule__Grammar__Group_2_2__0 )* ) ;
    public final void rule__Grammar__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1664:1: ( ( ( rule__Grammar__Group_2_2__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1665:1: ( ( rule__Grammar__Group_2_2__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1665:1: ( ( rule__Grammar__Group_2_2__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1666:1: ( rule__Grammar__Group_2_2__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1667:1: ( rule__Grammar__Group_2_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1667:2: rule__Grammar__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__0_in_rule__Grammar__Group_2__23559);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1683:1: rule__Grammar__Group_2_2__0 : ( ',' ) rule__Grammar__Group_2_2__1 ;
    public final void rule__Grammar__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1687:1: ( ( ',' ) rule__Grammar__Group_2_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1688:1: ( ',' ) rule__Grammar__Group_2_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1688:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1689:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Grammar__Group_2_2__03601); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__1_in_rule__Grammar__Group_2_2__03611);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1703:1: rule__Grammar__Group_2_2__1 : ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) ;
    public final void rule__Grammar__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1707:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1708:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1708:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1709:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1710:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1710:2: rule__Grammar__UsedGrammarsAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_2_1_in_rule__Grammar__Group_2_2__13639);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1724:1: rule__Grammar__Group_3__0 : ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) rule__Grammar__Group_3__1 ;
    public final void rule__Grammar__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1728:1: ( ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) rule__Grammar__Group_3__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1729:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) rule__Grammar__Group_3__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1729:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1730:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1731:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1731:2: rule__Grammar__DefinesHiddenTokensAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__DefinesHiddenTokensAssignment_3_0_in_rule__Grammar__Group_3__03677);
            rule__Grammar__DefinesHiddenTokensAssignment_3_0();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__1_in_rule__Grammar__Group_3__03686);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1742:1: rule__Grammar__Group_3__1 : ( '(' ) rule__Grammar__Group_3__2 ;
    public final void rule__Grammar__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1746:1: ( ( '(' ) rule__Grammar__Group_3__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1747:1: ( '(' ) rule__Grammar__Group_3__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1747:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1748:1: '('
            {
             before(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Grammar__Group_3__13715); 
             after(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__2_in_rule__Grammar__Group_3__13725);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1762:1: rule__Grammar__Group_3__2 : ( ( rule__Grammar__Group_3_2__0 )? ) rule__Grammar__Group_3__3 ;
    public final void rule__Grammar__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1766:1: ( ( ( rule__Grammar__Group_3_2__0 )? ) rule__Grammar__Group_3__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1767:1: ( ( rule__Grammar__Group_3_2__0 )? ) rule__Grammar__Group_3__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1767:1: ( ( rule__Grammar__Group_3_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1768:1: ( rule__Grammar__Group_3_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1769:1: ( rule__Grammar__Group_3_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1769:2: rule__Grammar__Group_3_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__0_in_rule__Grammar__Group_3__23753);
                    rule__Grammar__Group_3_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_3_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__3_in_rule__Grammar__Group_3__23763);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1780:1: rule__Grammar__Group_3__3 : ( ')' ) ;
    public final void rule__Grammar__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1784:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1785:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1785:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1786:1: ')'
            {
             before(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Grammar__Group_3__33792); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1807:1: rule__Grammar__Group_3_2__0 : ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) rule__Grammar__Group_3_2__1 ;
    public final void rule__Grammar__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1811:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) rule__Grammar__Group_3_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1812:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) rule__Grammar__Group_3_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1812:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1813:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1814:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1814:2: rule__Grammar__HiddenTokensAssignment_3_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_0_in_rule__Grammar__Group_3_2__03835);
            rule__Grammar__HiddenTokensAssignment_3_2_0();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__1_in_rule__Grammar__Group_3_2__03844);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1825:1: rule__Grammar__Group_3_2__1 : ( ( rule__Grammar__Group_3_2_1__0 )* ) ;
    public final void rule__Grammar__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1829:1: ( ( ( rule__Grammar__Group_3_2_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1830:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1830:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1831:1: ( rule__Grammar__Group_3_2_1__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1832:1: ( rule__Grammar__Group_3_2_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==19) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1832:2: rule__Grammar__Group_3_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__0_in_rule__Grammar__Group_3_2__13872);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1846:1: rule__Grammar__Group_3_2_1__0 : ( ',' ) rule__Grammar__Group_3_2_1__1 ;
    public final void rule__Grammar__Group_3_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1850:1: ( ( ',' ) rule__Grammar__Group_3_2_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1851:1: ( ',' ) rule__Grammar__Group_3_2_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1851:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1852:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Grammar__Group_3_2_1__03912); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__1_in_rule__Grammar__Group_3_2_1__03922);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1866:1: rule__Grammar__Group_3_2_1__1 : ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) ;
    public final void rule__Grammar__Group_3_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1870:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1871:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1871:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1872:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1873:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1873:2: rule__Grammar__HiddenTokensAssignment_3_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_1_1_in_rule__Grammar__Group_3_2_1__13950);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1887:1: rule__GrammarID__Group__0 : ( RULE_ID ) rule__GrammarID__Group__1 ;
    public final void rule__GrammarID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1891:1: ( ( RULE_ID ) rule__GrammarID__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1892:1: ( RULE_ID ) rule__GrammarID__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1892:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1893:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GrammarID__Group__03988); 
             after(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__1_in_rule__GrammarID__Group__03996);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1905:1: rule__GrammarID__Group__1 : ( ( rule__GrammarID__Group_1__0 )* ) ;
    public final void rule__GrammarID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1909:1: ( ( ( rule__GrammarID__Group_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1910:1: ( ( rule__GrammarID__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1910:1: ( ( rule__GrammarID__Group_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1911:1: ( rule__GrammarID__Group_1__0 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1912:1: ( rule__GrammarID__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1912:2: rule__GrammarID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__0_in_rule__GrammarID__Group__14024);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1926:1: rule__GrammarID__Group_1__0 : ( '.' ) rule__GrammarID__Group_1__1 ;
    public final void rule__GrammarID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1930:1: ( ( '.' ) rule__GrammarID__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1931:1: ( '.' ) rule__GrammarID__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1931:1: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1932:1: '.'
            {
             before(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__GrammarID__Group_1__04064); 
             after(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__1_in_rule__GrammarID__Group_1__04074);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1946:1: rule__GrammarID__Group_1__1 : ( RULE_ID ) ;
    public final void rule__GrammarID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1950:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1951:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1951:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1952:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GrammarID__Group_1__14102); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1967:1: rule__GeneratedMetamodel__Group__0 : ( 'generate' ) rule__GeneratedMetamodel__Group__1 ;
    public final void rule__GeneratedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1971:1: ( ( 'generate' ) rule__GeneratedMetamodel__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1972:1: ( 'generate' ) rule__GeneratedMetamodel__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1972:1: ( 'generate' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1973:1: 'generate'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__GeneratedMetamodel__Group__04140); 
             after(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__1_in_rule__GeneratedMetamodel__Group__04150);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1987:1: rule__GeneratedMetamodel__Group__1 : ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) rule__GeneratedMetamodel__Group__2 ;
    public final void rule__GeneratedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1991:1: ( ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) rule__GeneratedMetamodel__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1992:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) rule__GeneratedMetamodel__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1992:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1993:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1994:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1994:2: rule__GeneratedMetamodel__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__NameAssignment_1_in_rule__GeneratedMetamodel__Group__14178);
            rule__GeneratedMetamodel__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__2_in_rule__GeneratedMetamodel__Group__14187);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2005:1: rule__GeneratedMetamodel__Group__2 : ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) rule__GeneratedMetamodel__Group__3 ;
    public final void rule__GeneratedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2009:1: ( ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) rule__GeneratedMetamodel__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2010:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) rule__GeneratedMetamodel__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2010:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2011:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2012:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2012:2: rule__GeneratedMetamodel__EPackageAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__EPackageAssignment_2_in_rule__GeneratedMetamodel__Group__24215);
            rule__GeneratedMetamodel__EPackageAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__3_in_rule__GeneratedMetamodel__Group__24224);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2023:1: rule__GeneratedMetamodel__Group__3 : ( ( rule__GeneratedMetamodel__Group_3__0 )? ) ;
    public final void rule__GeneratedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2027:1: ( ( ( rule__GeneratedMetamodel__Group_3__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2028:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2028:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2029:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2030:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2030:2: rule__GeneratedMetamodel__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__0_in_rule__GeneratedMetamodel__Group__34252);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2048:1: rule__GeneratedMetamodel__Group_3__0 : ( 'as' ) rule__GeneratedMetamodel__Group_3__1 ;
    public final void rule__GeneratedMetamodel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2052:1: ( ( 'as' ) rule__GeneratedMetamodel__Group_3__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2053:1: ( 'as' ) rule__GeneratedMetamodel__Group_3__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2053:1: ( 'as' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2054:1: 'as'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__GeneratedMetamodel__Group_3__04296); 
             after(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__1_in_rule__GeneratedMetamodel__Group_3__04306);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2068:1: rule__GeneratedMetamodel__Group_3__1 : ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2072:1: ( ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2073:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2073:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2074:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2075:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2075:2: rule__GeneratedMetamodel__AliasAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__AliasAssignment_3_1_in_rule__GeneratedMetamodel__Group_3__14334);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2089:1: rule__ReferencedMetamodel__Group__0 : ( 'import' ) rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2093:1: ( ( 'import' ) rule__ReferencedMetamodel__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2094:1: ( 'import' ) rule__ReferencedMetamodel__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2094:1: ( 'import' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2095:1: 'import'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__ReferencedMetamodel__Group__04373); 
             after(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__04383);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2109:1: rule__ReferencedMetamodel__Group__1 : ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2113:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) rule__ReferencedMetamodel__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2114:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) rule__ReferencedMetamodel__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2114:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2115:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2116:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2116:2: rule__ReferencedMetamodel__EPackageAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_1_in_rule__ReferencedMetamodel__Group__14411);
            rule__ReferencedMetamodel__EPackageAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__14420);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2127:1: rule__ReferencedMetamodel__Group__2 : ( ( rule__ReferencedMetamodel__Group_2__0 )? ) ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2131:1: ( ( ( rule__ReferencedMetamodel__Group_2__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2132:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2132:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2133:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2134:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==24) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2134:2: rule__ReferencedMetamodel__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__0_in_rule__ReferencedMetamodel__Group__24448);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2150:1: rule__ReferencedMetamodel__Group_2__0 : ( 'as' ) rule__ReferencedMetamodel__Group_2__1 ;
    public final void rule__ReferencedMetamodel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2154:1: ( ( 'as' ) rule__ReferencedMetamodel__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2155:1: ( 'as' ) rule__ReferencedMetamodel__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2155:1: ( 'as' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2156:1: 'as'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__ReferencedMetamodel__Group_2__04490); 
             after(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__1_in_rule__ReferencedMetamodel__Group_2__04500);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2170:1: rule__ReferencedMetamodel__Group_2__1 : ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2174:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2175:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2175:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2176:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2177:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2177:2: rule__ReferencedMetamodel__AliasAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__AliasAssignment_2_1_in_rule__ReferencedMetamodel__Group_2__14528);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2191:1: rule__ParserRule__Group__0 : ( ( rule__ParserRule__NameAssignment_0 ) ) rule__ParserRule__Group__1 ;
    public final void rule__ParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2195:1: ( ( ( rule__ParserRule__NameAssignment_0 ) ) rule__ParserRule__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2196:1: ( ( rule__ParserRule__NameAssignment_0 ) ) rule__ParserRule__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2196:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2197:1: ( rule__ParserRule__NameAssignment_0 )
            {
             before(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2198:1: ( rule__ParserRule__NameAssignment_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2198:2: rule__ParserRule__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__NameAssignment_0_in_rule__ParserRule__Group__04566);
            rule__ParserRule__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__1_in_rule__ParserRule__Group__04575);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2209:1: rule__ParserRule__Group__1 : ( ( rule__ParserRule__Group_1__0 )? ) rule__ParserRule__Group__2 ;
    public final void rule__ParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2213:1: ( ( ( rule__ParserRule__Group_1__0 )? ) rule__ParserRule__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2214:1: ( ( rule__ParserRule__Group_1__0 )? ) rule__ParserRule__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2214:1: ( ( rule__ParserRule__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2215:1: ( rule__ParserRule__Group_1__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2216:1: ( rule__ParserRule__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==28) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2216:2: rule__ParserRule__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__0_in_rule__ParserRule__Group__14603);
                    rule__ParserRule__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__2_in_rule__ParserRule__Group__14613);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2227:1: rule__ParserRule__Group__2 : ( ( rule__ParserRule__Group_2__0 )? ) rule__ParserRule__Group__3 ;
    public final void rule__ParserRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2231:1: ( ( ( rule__ParserRule__Group_2__0 )? ) rule__ParserRule__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2232:1: ( ( rule__ParserRule__Group_2__0 )? ) rule__ParserRule__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2232:1: ( ( rule__ParserRule__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2233:1: ( rule__ParserRule__Group_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2234:1: ( rule__ParserRule__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==42) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2234:2: rule__ParserRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__0_in_rule__ParserRule__Group__24641);
                    rule__ParserRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__3_in_rule__ParserRule__Group__24651);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2245:1: rule__ParserRule__Group__3 : ( ':' ) rule__ParserRule__Group__4 ;
    public final void rule__ParserRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2249:1: ( ( ':' ) rule__ParserRule__Group__4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2250:1: ( ':' ) rule__ParserRule__Group__4
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2250:1: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2251:1: ':'
            {
             before(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__ParserRule__Group__34680); 
             after(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__4_in_rule__ParserRule__Group__34690);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2265:1: rule__ParserRule__Group__4 : ( ( rule__ParserRule__AlternativesAssignment_4 ) ) rule__ParserRule__Group__5 ;
    public final void rule__ParserRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2269:1: ( ( ( rule__ParserRule__AlternativesAssignment_4 ) ) rule__ParserRule__Group__5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2270:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) ) rule__ParserRule__Group__5
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2270:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2271:1: ( rule__ParserRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2272:1: ( rule__ParserRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2272:2: rule__ParserRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__AlternativesAssignment_4_in_rule__ParserRule__Group__44718);
            rule__ParserRule__AlternativesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__5_in_rule__ParserRule__Group__44727);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2283:1: rule__ParserRule__Group__5 : ( ';' ) ;
    public final void rule__ParserRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2287:1: ( ( ';' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2288:1: ( ';' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2288:1: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2289:1: ';'
            {
             before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__ParserRule__Group__54756); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2314:1: rule__ParserRule__Group_1__0 : ( 'returns' ) rule__ParserRule__Group_1__1 ;
    public final void rule__ParserRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2318:1: ( ( 'returns' ) rule__ParserRule__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2319:1: ( 'returns' ) rule__ParserRule__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2319:1: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2320:1: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__ParserRule__Group_1__04804); 
             after(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__1_in_rule__ParserRule__Group_1__04814);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2334:1: rule__ParserRule__Group_1__1 : ( ( rule__ParserRule__TypeAssignment_1_1 ) ) ;
    public final void rule__ParserRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2338:1: ( ( ( rule__ParserRule__TypeAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2339:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2339:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2340:1: ( rule__ParserRule__TypeAssignment_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2341:1: ( rule__ParserRule__TypeAssignment_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2341:2: rule__ParserRule__TypeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__TypeAssignment_1_1_in_rule__ParserRule__Group_1__14842);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2355:1: rule__ParserRule__Group_2__0 : ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) rule__ParserRule__Group_2__1 ;
    public final void rule__ParserRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2359:1: ( ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) rule__ParserRule__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2360:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) rule__ParserRule__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2360:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2361:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2362:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2362:2: rule__ParserRule__DefinesHiddenTokensAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__DefinesHiddenTokensAssignment_2_0_in_rule__ParserRule__Group_2__04880);
            rule__ParserRule__DefinesHiddenTokensAssignment_2_0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__1_in_rule__ParserRule__Group_2__04889);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2373:1: rule__ParserRule__Group_2__1 : ( '(' ) rule__ParserRule__Group_2__2 ;
    public final void rule__ParserRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2377:1: ( ( '(' ) rule__ParserRule__Group_2__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2378:1: ( '(' ) rule__ParserRule__Group_2__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2378:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2379:1: '('
            {
             before(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParserRule__Group_2__14918); 
             after(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__2_in_rule__ParserRule__Group_2__14928);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2393:1: rule__ParserRule__Group_2__2 : ( ( rule__ParserRule__Group_2_2__0 )? ) rule__ParserRule__Group_2__3 ;
    public final void rule__ParserRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2397:1: ( ( ( rule__ParserRule__Group_2_2__0 )? ) rule__ParserRule__Group_2__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2398:1: ( ( rule__ParserRule__Group_2_2__0 )? ) rule__ParserRule__Group_2__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2398:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2399:1: ( rule__ParserRule__Group_2_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2400:1: ( rule__ParserRule__Group_2_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2400:2: rule__ParserRule__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__0_in_rule__ParserRule__Group_2__24956);
                    rule__ParserRule__Group_2_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_2_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__3_in_rule__ParserRule__Group_2__24966);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2411:1: rule__ParserRule__Group_2__3 : ( ')' ) ;
    public final void rule__ParserRule__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2415:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2416:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2416:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2417:1: ')'
            {
             before(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParserRule__Group_2__34995); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2438:1: rule__ParserRule__Group_2_2__0 : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) rule__ParserRule__Group_2_2__1 ;
    public final void rule__ParserRule__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2442:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) rule__ParserRule__Group_2_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2443:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) rule__ParserRule__Group_2_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2443:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2444:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2445:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2445:2: rule__ParserRule__HiddenTokensAssignment_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_0_in_rule__ParserRule__Group_2_2__05038);
            rule__ParserRule__HiddenTokensAssignment_2_2_0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__1_in_rule__ParserRule__Group_2_2__05047);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2456:1: rule__ParserRule__Group_2_2__1 : ( ( rule__ParserRule__Group_2_2_1__0 )* ) ;
    public final void rule__ParserRule__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2460:1: ( ( ( rule__ParserRule__Group_2_2_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2461:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2461:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2462:1: ( rule__ParserRule__Group_2_2_1__0 )*
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2463:1: ( rule__ParserRule__Group_2_2_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==19) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2463:2: rule__ParserRule__Group_2_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__0_in_rule__ParserRule__Group_2_2__15075);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2477:1: rule__ParserRule__Group_2_2_1__0 : ( ',' ) rule__ParserRule__Group_2_2_1__1 ;
    public final void rule__ParserRule__Group_2_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2481:1: ( ( ',' ) rule__ParserRule__Group_2_2_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2482:1: ( ',' ) rule__ParserRule__Group_2_2_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2482:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2483:1: ','
            {
             before(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__ParserRule__Group_2_2_1__05115); 
             after(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__1_in_rule__ParserRule__Group_2_2_1__05125);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2497:1: rule__ParserRule__Group_2_2_1__1 : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_2_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2501:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2502:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2502:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2503:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2504:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2504:2: rule__ParserRule__HiddenTokensAssignment_2_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_1_1_in_rule__ParserRule__Group_2_2_1__15153);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2518:1: rule__TypeRef__Group__0 : ( ( rule__TypeRef__Group_0__0 )? ) rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2522:1: ( ( ( rule__TypeRef__Group_0__0 )? ) rule__TypeRef__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2523:1: ( ( rule__TypeRef__Group_0__0 )? ) rule__TypeRef__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2523:1: ( ( rule__TypeRef__Group_0__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2524:1: ( rule__TypeRef__Group_0__0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2525:1: ( rule__TypeRef__Group_0__0 )?
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
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2525:2: rule__TypeRef__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__0_in_rule__TypeRef__Group__05191);
                    rule__TypeRef__Group_0__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeRefAccess().getGroup_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__1_in_rule__TypeRef__Group__05201);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2536:1: rule__TypeRef__Group__1 : ( ( rule__TypeRef__ClassifierAssignment_1 ) ) ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2540:1: ( ( ( rule__TypeRef__ClassifierAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2541:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2541:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2542:1: ( rule__TypeRef__ClassifierAssignment_1 )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2543:1: ( rule__TypeRef__ClassifierAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2543:2: rule__TypeRef__ClassifierAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__ClassifierAssignment_1_in_rule__TypeRef__Group__15229);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2557:1: rule__TypeRef__Group_0__0 : ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) rule__TypeRef__Group_0__1 ;
    public final void rule__TypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2561:1: ( ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) rule__TypeRef__Group_0__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2562:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) rule__TypeRef__Group_0__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2562:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2563:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2564:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2564:2: rule__TypeRef__MetamodelAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__MetamodelAssignment_0_0_in_rule__TypeRef__Group_0__05267);
            rule__TypeRef__MetamodelAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__1_in_rule__TypeRef__Group_0__05276);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2575:1: rule__TypeRef__Group_0__1 : ( '::' ) ;
    public final void rule__TypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2579:1: ( ( '::' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2580:1: ( '::' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2580:1: ( '::' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2581:1: '::'
            {
             before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__TypeRef__Group_0__15305); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2598:1: rule__Alternatives__Group__0 : ( ruleUnorderedGroup ) rule__Alternatives__Group__1 ;
    public final void rule__Alternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2602:1: ( ( ruleUnorderedGroup ) rule__Alternatives__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2603:1: ( ruleUnorderedGroup ) rule__Alternatives__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2603:1: ( ruleUnorderedGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2604:1: ruleUnorderedGroup
            {
             before(grammarAccess.getAlternativesAccess().getUnorderedGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_rule__Alternatives__Group__05344);
            ruleUnorderedGroup();
            _fsp--;

             after(grammarAccess.getAlternativesAccess().getUnorderedGroupParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__1_in_rule__Alternatives__Group__05352);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2616:1: rule__Alternatives__Group__1 : ( ( rule__Alternatives__Group_1__0 )? ) ;
    public final void rule__Alternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2620:1: ( ( ( rule__Alternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2621:1: ( ( rule__Alternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2621:1: ( ( rule__Alternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2622:1: ( rule__Alternatives__Group_1__0 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2623:1: ( rule__Alternatives__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==30) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2623:2: rule__Alternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__0_in_rule__Alternatives__Group__15380);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2637:1: rule__Alternatives__Group_1__0 : ( () ) rule__Alternatives__Group_1__1 ;
    public final void rule__Alternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2641:1: ( ( () ) rule__Alternatives__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2642:1: ( () ) rule__Alternatives__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2642:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2643:1: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2644:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2646:1: 
            {
            }

             after(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__1_in_rule__Alternatives__Group_1__05429);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2657:1: rule__Alternatives__Group_1__1 : ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) ;
    public final void rule__Alternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2661:1: ( ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2662:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2662:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2663:1: ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2663:1: ( ( rule__Alternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2664:1: ( rule__Alternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2665:1: ( rule__Alternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2665:2: rule__Alternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__15459);
            rule__Alternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2668:1: ( ( rule__Alternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2669:1: ( rule__Alternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2670:1: ( rule__Alternatives__Group_1_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==30) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2670:2: rule__Alternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__15471);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2685:1: rule__Alternatives__Group_1_1__0 : ( '|' ) rule__Alternatives__Group_1_1__1 ;
    public final void rule__Alternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2689:1: ( ( '|' ) rule__Alternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2690:1: ( '|' ) rule__Alternatives__Group_1_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2690:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2691:1: '|'
            {
             before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__Alternatives__Group_1_1__05513); 
             after(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__1_in_rule__Alternatives__Group_1_1__05523);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2705:1: rule__Alternatives__Group_1_1__1 : ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__Alternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2709:1: ( ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2710:1: ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2710:1: ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2711:1: ( rule__Alternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2712:1: ( rule__Alternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2712:2: rule__Alternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__GroupsAssignment_1_1_1_in_rule__Alternatives__Group_1_1__15551);
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


    // $ANTLR start rule__UnorderedGroup__Group__0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2726:1: rule__UnorderedGroup__Group__0 : ( ruleGroup ) rule__UnorderedGroup__Group__1 ;
    public final void rule__UnorderedGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2730:1: ( ( ruleGroup ) rule__UnorderedGroup__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2731:1: ( ruleGroup ) rule__UnorderedGroup__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2731:1: ( ruleGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2732:1: ruleGroup
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_rule__UnorderedGroup__Group__05589);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group__1_in_rule__UnorderedGroup__Group__05597);
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


    // $ANTLR start rule__UnorderedGroup__Group__1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2744:1: rule__UnorderedGroup__Group__1 : ( ( rule__UnorderedGroup__Group_1__0 )? ) ;
    public final void rule__UnorderedGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2748:1: ( ( ( rule__UnorderedGroup__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2749:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2749:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2750:1: ( rule__UnorderedGroup__Group_1__0 )?
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2751:1: ( rule__UnorderedGroup__Group_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==31) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2751:2: rule__UnorderedGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1__0_in_rule__UnorderedGroup__Group__15625);
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
    // $ANTLR end rule__UnorderedGroup__Group__1


    // $ANTLR start rule__UnorderedGroup__Group_1__0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2765:1: rule__UnorderedGroup__Group_1__0 : ( () ) rule__UnorderedGroup__Group_1__1 ;
    public final void rule__UnorderedGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2769:1: ( ( () ) rule__UnorderedGroup__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2770:1: ( () ) rule__UnorderedGroup__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2770:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2771:1: ()
            {
             before(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2772:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2774:1: 
            {
            }

             after(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1__1_in_rule__UnorderedGroup__Group_1__05674);
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


    // $ANTLR start rule__UnorderedGroup__Group_1__1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2785:1: rule__UnorderedGroup__Group_1__1 : ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) ;
    public final void rule__UnorderedGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2789:1: ( ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2790:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2790:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2791:1: ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2791:1: ( ( rule__UnorderedGroup__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2792:1: ( rule__UnorderedGroup__Group_1_1__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2793:1: ( rule__UnorderedGroup__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2793:2: rule__UnorderedGroup__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__0_in_rule__UnorderedGroup__Group_1__15704);
            rule__UnorderedGroup__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2796:1: ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2797:1: ( rule__UnorderedGroup__Group_1_1__0 )*
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2798:1: ( rule__UnorderedGroup__Group_1_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==31) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2798:2: rule__UnorderedGroup__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__0_in_rule__UnorderedGroup__Group_1__15716);
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
    // $ANTLR end rule__UnorderedGroup__Group_1__1


    // $ANTLR start rule__UnorderedGroup__Group_1_1__0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2813:1: rule__UnorderedGroup__Group_1_1__0 : ( '&' ) rule__UnorderedGroup__Group_1_1__1 ;
    public final void rule__UnorderedGroup__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2817:1: ( ( '&' ) rule__UnorderedGroup__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2818:1: ( '&' ) rule__UnorderedGroup__Group_1_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2818:1: ( '&' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2819:1: '&'
            {
             before(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__UnorderedGroup__Group_1_1__05758); 
             after(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__Group_1_1__1_in_rule__UnorderedGroup__Group_1_1__05768);
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


    // $ANTLR start rule__UnorderedGroup__Group_1_1__1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2833:1: rule__UnorderedGroup__Group_1_1__1 : ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__UnorderedGroup__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2837:1: ( ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2838:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2838:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2839:1: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2840:1: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2840:2: rule__UnorderedGroup__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UnorderedGroup__ElementsAssignment_1_1_1_in_rule__UnorderedGroup__Group_1_1__15796);
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
    // $ANTLR end rule__UnorderedGroup__Group_1_1__1


    // $ANTLR start rule__Group__Group__0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2854:1: rule__Group__Group__0 : ( ruleAbstractToken ) rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2858:1: ( ( ruleAbstractToken ) rule__Group__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2859:1: ( ruleAbstractToken ) rule__Group__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2859:1: ( ruleAbstractToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2860:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_rule__Group__Group__05834);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__1_in_rule__Group__Group__05842);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2872:1: rule__Group__Group__1 : ( ( rule__Group__Group_1__0 )? ) ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2876:1: ( ( ( rule__Group__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2877:1: ( ( rule__Group__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2877:1: ( ( rule__Group__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2878:1: ( rule__Group__Group_1__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2879:1: ( rule__Group__Group_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_ID && LA33_0<=RULE_STRING)||LA33_0==20||LA33_0==32) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2879:2: rule__Group__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__0_in_rule__Group__Group__15870);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2893:1: rule__Group__Group_1__0 : ( () ) rule__Group__Group_1__1 ;
    public final void rule__Group__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2897:1: ( ( () ) rule__Group__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2898:1: ( () ) rule__Group__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2898:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2899:1: ()
            {
             before(grammarAccess.getGroupAccess().getGroupTokensAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2900:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2902:1: 
            {
            }

             after(grammarAccess.getGroupAccess().getGroupTokensAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__1_in_rule__Group__Group_1__05919);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2913:1: rule__Group__Group_1__1 : ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) ) ;
    public final void rule__Group__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2917:1: ( ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2918:1: ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2918:1: ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2919:1: ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2919:1: ( ( rule__Group__TokensAssignment_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2920:1: ( rule__Group__TokensAssignment_1_1 )
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2921:1: ( rule__Group__TokensAssignment_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2921:2: rule__Group__TokensAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__15949);
            rule__Group__TokensAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2924:1: ( ( rule__Group__TokensAssignment_1_1 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2925:1: ( rule__Group__TokensAssignment_1_1 )*
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2926:1: ( rule__Group__TokensAssignment_1_1 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=RULE_ID && LA34_0<=RULE_STRING)||LA34_0==20||LA34_0==32) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2926:2: rule__Group__TokensAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__15961);
            	    rule__Group__TokensAssignment_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2941:1: rule__AbstractTokenWithCardinality__Group__0 : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) rule__AbstractTokenWithCardinality__Group__1 ;
    public final void rule__AbstractTokenWithCardinality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2945:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) rule__AbstractTokenWithCardinality__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2946:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) rule__AbstractTokenWithCardinality__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2946:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2947:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2948:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2948:2: rule__AbstractTokenWithCardinality__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group__06002);
            rule__AbstractTokenWithCardinality__Alternatives_0();
            _fsp--;


            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__1_in_rule__AbstractTokenWithCardinality__Group__06011);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2959:1: rule__AbstractTokenWithCardinality__Group__1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2963:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2964:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2964:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2965:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2966:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=11 && LA35_0<=13)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2966:2: rule__AbstractTokenWithCardinality__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAssignment_1_in_rule__AbstractTokenWithCardinality__Group__16039);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2980:1: rule__Action__Group__0 : ( '{' ) rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2984:1: ( ( '{' ) rule__Action__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2985:1: ( '{' ) rule__Action__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2985:1: ( '{' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2986:1: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Action__Group__06079); 
             after(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__1_in_rule__Action__Group__06089);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3000:1: rule__Action__Group__1 : ( ( rule__Action__TypeAssignment_1 ) ) rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3004:1: ( ( ( rule__Action__TypeAssignment_1 ) ) rule__Action__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3005:1: ( ( rule__Action__TypeAssignment_1 ) ) rule__Action__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3005:1: ( ( rule__Action__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3006:1: ( rule__Action__TypeAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3007:1: ( rule__Action__TypeAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3007:2: rule__Action__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__TypeAssignment_1_in_rule__Action__Group__16117);
            rule__Action__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getTypeAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__2_in_rule__Action__Group__16126);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3018:1: rule__Action__Group__2 : ( ( rule__Action__Group_2__0 )? ) rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3022:1: ( ( ( rule__Action__Group_2__0 )? ) rule__Action__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3023:1: ( ( rule__Action__Group_2__0 )? ) rule__Action__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3023:1: ( ( rule__Action__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3024:1: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3025:1: ( rule__Action__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==22) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3025:2: rule__Action__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__0_in_rule__Action__Group__26154);
                    rule__Action__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__3_in_rule__Action__Group__26164);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3036:1: rule__Action__Group__3 : ( '}' ) ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3040:1: ( ( '}' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3041:1: ( '}' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3041:1: ( '}' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3042:1: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__Action__Group__36193); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3063:1: rule__Action__Group_2__0 : ( '.' ) rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3067:1: ( ( '.' ) rule__Action__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3068:1: ( '.' ) rule__Action__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3068:1: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3069:1: '.'
            {
             before(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Action__Group_2__06237); 
             after(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__1_in_rule__Action__Group_2__06247);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3083:1: rule__Action__Group_2__1 : ( ( rule__Action__FeatureAssignment_2_1 ) ) rule__Action__Group_2__2 ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3087:1: ( ( ( rule__Action__FeatureAssignment_2_1 ) ) rule__Action__Group_2__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3088:1: ( ( rule__Action__FeatureAssignment_2_1 ) ) rule__Action__Group_2__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3088:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3089:1: ( rule__Action__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3090:1: ( rule__Action__FeatureAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3090:2: rule__Action__FeatureAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__FeatureAssignment_2_1_in_rule__Action__Group_2__16275);
            rule__Action__FeatureAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__2_in_rule__Action__Group_2__16284);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3101:1: rule__Action__Group_2__2 : ( ( rule__Action__OperatorAssignment_2_2 ) ) rule__Action__Group_2__3 ;
    public final void rule__Action__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3105:1: ( ( ( rule__Action__OperatorAssignment_2_2 ) ) rule__Action__Group_2__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3106:1: ( ( rule__Action__OperatorAssignment_2_2 ) ) rule__Action__Group_2__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3106:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3107:1: ( rule__Action__OperatorAssignment_2_2 )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3108:1: ( rule__Action__OperatorAssignment_2_2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3108:2: rule__Action__OperatorAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__OperatorAssignment_2_2_in_rule__Action__Group_2__26312);
            rule__Action__OperatorAssignment_2_2();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__3_in_rule__Action__Group_2__26321);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3119:1: rule__Action__Group_2__3 : ( 'current' ) ;
    public final void rule__Action__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3123:1: ( ( 'current' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3124:1: ( 'current' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3124:1: ( 'current' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3125:1: 'current'
            {
             before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__Action__Group_2__36350); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3146:1: rule__Assignment__Group__0 : ( ( rule__Assignment__FeatureAssignment_0 ) ) rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3150:1: ( ( ( rule__Assignment__FeatureAssignment_0 ) ) rule__Assignment__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3151:1: ( ( rule__Assignment__FeatureAssignment_0 ) ) rule__Assignment__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3151:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3152:1: ( rule__Assignment__FeatureAssignment_0 )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3153:1: ( rule__Assignment__FeatureAssignment_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3153:2: rule__Assignment__FeatureAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__FeatureAssignment_0_in_rule__Assignment__Group__06393);
            rule__Assignment__FeatureAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__1_in_rule__Assignment__Group__06402);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3164:1: rule__Assignment__Group__1 : ( ( rule__Assignment__OperatorAssignment_1 ) ) rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3168:1: ( ( ( rule__Assignment__OperatorAssignment_1 ) ) rule__Assignment__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3169:1: ( ( rule__Assignment__OperatorAssignment_1 ) ) rule__Assignment__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3169:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3170:1: ( rule__Assignment__OperatorAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3171:1: ( rule__Assignment__OperatorAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3171:2: rule__Assignment__OperatorAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__OperatorAssignment_1_in_rule__Assignment__Group__16430);
            rule__Assignment__OperatorAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__2_in_rule__Assignment__Group__16439);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3182:1: rule__Assignment__Group__2 : ( ( rule__Assignment__TerminalAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3186:1: ( ( ( rule__Assignment__TerminalAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3187:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3187:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3188:1: ( rule__Assignment__TerminalAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3189:1: ( rule__Assignment__TerminalAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3189:2: rule__Assignment__TerminalAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__TerminalAssignment_2_in_rule__Assignment__Group__26467);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3205:1: rule__ParenthesizedAssignableElement__Group__0 : ( '(' ) rule__ParenthesizedAssignableElement__Group__1 ;
    public final void rule__ParenthesizedAssignableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3209:1: ( ( '(' ) rule__ParenthesizedAssignableElement__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3210:1: ( '(' ) rule__ParenthesizedAssignableElement__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3210:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3211:1: '('
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedAssignableElement__Group__06508); 
             after(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__1_in_rule__ParenthesizedAssignableElement__Group__06518);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3225:1: rule__ParenthesizedAssignableElement__Group__1 : ( ruleAssignableAlternatives ) rule__ParenthesizedAssignableElement__Group__2 ;
    public final void rule__ParenthesizedAssignableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3229:1: ( ( ruleAssignableAlternatives ) rule__ParenthesizedAssignableElement__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3230:1: ( ruleAssignableAlternatives ) rule__ParenthesizedAssignableElement__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3230:1: ( ruleAssignableAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3231:1: ruleAssignableAlternatives
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group__16546);
            ruleAssignableAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__2_in_rule__ParenthesizedAssignableElement__Group__16554);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3243:1: rule__ParenthesizedAssignableElement__Group__2 : ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3247:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3248:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3248:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3249:1: ')'
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group__26583); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3268:1: rule__AssignableAlternatives__Group__0 : ( ruleAssignableTerminal ) rule__AssignableAlternatives__Group__1 ;
    public final void rule__AssignableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3272:1: ( ( ruleAssignableTerminal ) rule__AssignableAlternatives__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3273:1: ( ruleAssignableTerminal ) rule__AssignableAlternatives__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3273:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3274:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group__06624);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__1_in_rule__AssignableAlternatives__Group__06632);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3286:1: rule__AssignableAlternatives__Group__1 : ( ( rule__AssignableAlternatives__Group_1__0 )? ) ;
    public final void rule__AssignableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3290:1: ( ( ( rule__AssignableAlternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3291:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3291:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3292:1: ( rule__AssignableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3293:1: ( rule__AssignableAlternatives__Group_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==30) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3293:2: rule__AssignableAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__0_in_rule__AssignableAlternatives__Group__16660);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3307:1: rule__AssignableAlternatives__Group_1__0 : ( () ) rule__AssignableAlternatives__Group_1__1 ;
    public final void rule__AssignableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3311:1: ( ( () ) rule__AssignableAlternatives__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3312:1: ( () ) rule__AssignableAlternatives__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3312:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3313:1: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3314:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3316:1: 
            {
            }

             after(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__1_in_rule__AssignableAlternatives__Group_1__06709);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3327:1: rule__AssignableAlternatives__Group_1__1 : ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__AssignableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3331:1: ( ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3332:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3332:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3333:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3333:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3334:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3335:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3335:2: rule__AssignableAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__16739);
            rule__AssignableAlternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3338:1: ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3339:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3340:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==30) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3340:2: rule__AssignableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__16751);
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
    // $ANTLR end rule__AssignableAlternatives__Group_1__1


    // $ANTLR start rule__AssignableAlternatives__Group_1_1__0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3355:1: rule__AssignableAlternatives__Group_1_1__0 : ( '|' ) rule__AssignableAlternatives__Group_1_1__1 ;
    public final void rule__AssignableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3359:1: ( ( '|' ) rule__AssignableAlternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3360:1: ( '|' ) rule__AssignableAlternatives__Group_1_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3360:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3361:1: '|'
            {
             before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__AssignableAlternatives__Group_1_1__06793); 
             after(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__1_in_rule__AssignableAlternatives__Group_1_1__06803);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3375:1: rule__AssignableAlternatives__Group_1_1__1 : ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3379:1: ( ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3380:1: ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3380:1: ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3381:1: ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3382:1: ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3382:2: rule__AssignableAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__GroupsAssignment_1_1_1_in_rule__AssignableAlternatives__Group_1_1__16831);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3396:1: rule__CrossReference__Group__0 : ( '[' ) rule__CrossReference__Group__1 ;
    public final void rule__CrossReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3400:1: ( ( '[' ) rule__CrossReference__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3401:1: ( '[' ) rule__CrossReference__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3401:1: ( '[' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3402:1: '['
            {
             before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__CrossReference__Group__06870); 
             after(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__1_in_rule__CrossReference__Group__06880);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3416:1: rule__CrossReference__Group__1 : ( ( rule__CrossReference__TypeAssignment_1 ) ) rule__CrossReference__Group__2 ;
    public final void rule__CrossReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3420:1: ( ( ( rule__CrossReference__TypeAssignment_1 ) ) rule__CrossReference__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3421:1: ( ( rule__CrossReference__TypeAssignment_1 ) ) rule__CrossReference__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3421:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3422:1: ( rule__CrossReference__TypeAssignment_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3423:1: ( rule__CrossReference__TypeAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3423:2: rule__CrossReference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__TypeAssignment_1_in_rule__CrossReference__Group__16908);
            rule__CrossReference__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__2_in_rule__CrossReference__Group__16917);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3434:1: rule__CrossReference__Group__2 : ( ( rule__CrossReference__Group_2__0 )? ) rule__CrossReference__Group__3 ;
    public final void rule__CrossReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3438:1: ( ( ( rule__CrossReference__Group_2__0 )? ) rule__CrossReference__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3439:1: ( ( rule__CrossReference__Group_2__0 )? ) rule__CrossReference__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3439:1: ( ( rule__CrossReference__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3440:1: ( rule__CrossReference__Group_2__0 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3441:1: ( rule__CrossReference__Group_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==30) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3441:2: rule__CrossReference__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__0_in_rule__CrossReference__Group__26945);
                    rule__CrossReference__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCrossReferenceAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__3_in_rule__CrossReference__Group__26955);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3452:1: rule__CrossReference__Group__3 : ( ']' ) ;
    public final void rule__CrossReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3456:1: ( ( ']' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3457:1: ( ']' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3457:1: ( ']' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3458:1: ']'
            {
             before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__CrossReference__Group__36984); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3479:1: rule__CrossReference__Group_2__0 : ( '|' ) rule__CrossReference__Group_2__1 ;
    public final void rule__CrossReference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3483:1: ( ( '|' ) rule__CrossReference__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3484:1: ( '|' ) rule__CrossReference__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3484:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3485:1: '|'
            {
             before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__CrossReference__Group_2__07028); 
             after(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__1_in_rule__CrossReference__Group_2__07038);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3499:1: rule__CrossReference__Group_2__1 : ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) ;
    public final void rule__CrossReference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3503:1: ( ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3504:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3504:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3505:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3506:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3506:2: rule__CrossReference__TerminalAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__TerminalAssignment_2_1_in_rule__CrossReference__Group_2__17066);
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


    // $ANTLR start rule__ParenthesizedElement__Group__0
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3520:1: rule__ParenthesizedElement__Group__0 : ( '(' ) rule__ParenthesizedElement__Group__1 ;
    public final void rule__ParenthesizedElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3524:1: ( ( '(' ) rule__ParenthesizedElement__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3525:1: ( '(' ) rule__ParenthesizedElement__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3525:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3526:1: '('
            {
             before(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedElement__Group__07105); 
             after(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__1_in_rule__ParenthesizedElement__Group__07115);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3540:1: rule__ParenthesizedElement__Group__1 : ( ruleAlternatives ) rule__ParenthesizedElement__Group__2 ;
    public final void rule__ParenthesizedElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3544:1: ( ( ruleAlternatives ) rule__ParenthesizedElement__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3545:1: ( ruleAlternatives ) rule__ParenthesizedElement__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3545:1: ( ruleAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3546:1: ruleAlternatives
            {
             before(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group__17143);
            ruleAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__2_in_rule__ParenthesizedElement__Group__17151);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3558:1: rule__ParenthesizedElement__Group__2 : ( ')' ) ;
    public final void rule__ParenthesizedElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3562:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3563:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3563:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3564:1: ')'
            {
             before(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedElement__Group__27180); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3583:1: rule__TerminalRule__Group__0 : ( 'terminal' ) rule__TerminalRule__Group__1 ;
    public final void rule__TerminalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3587:1: ( ( 'terminal' ) rule__TerminalRule__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3588:1: ( 'terminal' ) rule__TerminalRule__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3588:1: ( 'terminal' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3589:1: 'terminal'
            {
             before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__TerminalRule__Group__07222); 
             after(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__1_in_rule__TerminalRule__Group__07232);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3603:1: rule__TerminalRule__Group__1 : ( ( rule__TerminalRule__NameAssignment_1 ) ) rule__TerminalRule__Group__2 ;
    public final void rule__TerminalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3607:1: ( ( ( rule__TerminalRule__NameAssignment_1 ) ) rule__TerminalRule__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3608:1: ( ( rule__TerminalRule__NameAssignment_1 ) ) rule__TerminalRule__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3608:1: ( ( rule__TerminalRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3609:1: ( rule__TerminalRule__NameAssignment_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3610:1: ( rule__TerminalRule__NameAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3610:2: rule__TerminalRule__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__NameAssignment_1_in_rule__TerminalRule__Group__17260);
            rule__TerminalRule__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__2_in_rule__TerminalRule__Group__17269);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3621:1: rule__TerminalRule__Group__2 : ( ( rule__TerminalRule__Group_2__0 )? ) rule__TerminalRule__Group__3 ;
    public final void rule__TerminalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3625:1: ( ( ( rule__TerminalRule__Group_2__0 )? ) rule__TerminalRule__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3626:1: ( ( rule__TerminalRule__Group_2__0 )? ) rule__TerminalRule__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3626:1: ( ( rule__TerminalRule__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3627:1: ( rule__TerminalRule__Group_2__0 )?
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3628:1: ( rule__TerminalRule__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==28) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3628:2: rule__TerminalRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_2__0_in_rule__TerminalRule__Group__27297);
                    rule__TerminalRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalRuleAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__3_in_rule__TerminalRule__Group__27307);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3639:1: rule__TerminalRule__Group__3 : ( ':' ) rule__TerminalRule__Group__4 ;
    public final void rule__TerminalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3643:1: ( ( ':' ) rule__TerminalRule__Group__4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3644:1: ( ':' ) rule__TerminalRule__Group__4
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3644:1: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3645:1: ':'
            {
             before(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__TerminalRule__Group__37336); 
             after(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__4_in_rule__TerminalRule__Group__37346);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3659:1: rule__TerminalRule__Group__4 : ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) rule__TerminalRule__Group__5 ;
    public final void rule__TerminalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3663:1: ( ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) rule__TerminalRule__Group__5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3664:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) rule__TerminalRule__Group__5
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3664:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3665:1: ( rule__TerminalRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3666:1: ( rule__TerminalRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3666:2: rule__TerminalRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__AlternativesAssignment_4_in_rule__TerminalRule__Group__47374);
            rule__TerminalRule__AlternativesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__5_in_rule__TerminalRule__Group__47383);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3677:1: rule__TerminalRule__Group__5 : ( ';' ) ;
    public final void rule__TerminalRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3681:1: ( ( ';' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3682:1: ( ';' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3682:1: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3683:1: ';'
            {
             before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__TerminalRule__Group__57412); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3708:1: rule__TerminalRule__Group_2__0 : ( 'returns' ) rule__TerminalRule__Group_2__1 ;
    public final void rule__TerminalRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3712:1: ( ( 'returns' ) rule__TerminalRule__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3713:1: ( 'returns' ) rule__TerminalRule__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3713:1: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3714:1: 'returns'
            {
             before(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__TerminalRule__Group_2__07460); 
             after(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_2__1_in_rule__TerminalRule__Group_2__07470);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3728:1: rule__TerminalRule__Group_2__1 : ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) ;
    public final void rule__TerminalRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3732:1: ( ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3733:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3733:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3734:1: ( rule__TerminalRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3735:1: ( rule__TerminalRule__TypeAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3735:2: rule__TerminalRule__TypeAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__TypeAssignment_2_1_in_rule__TerminalRule__Group_2__17498);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3749:1: rule__TerminalAlternatives__Group__0 : ( ruleTerminalGroup ) rule__TerminalAlternatives__Group__1 ;
    public final void rule__TerminalAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3753:1: ( ( ruleTerminalGroup ) rule__TerminalAlternatives__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3754:1: ( ruleTerminalGroup ) rule__TerminalAlternatives__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3754:1: ( ruleTerminalGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3755:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group__07536);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__1_in_rule__TerminalAlternatives__Group__07544);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3767:1: rule__TerminalAlternatives__Group__1 : ( ( rule__TerminalAlternatives__Group_1__0 )? ) ;
    public final void rule__TerminalAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3771:1: ( ( ( rule__TerminalAlternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3772:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3772:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3773:1: ( rule__TerminalAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3774:1: ( rule__TerminalAlternatives__Group_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==30) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3774:2: rule__TerminalAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__0_in_rule__TerminalAlternatives__Group__17572);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3788:1: rule__TerminalAlternatives__Group_1__0 : ( () ) rule__TerminalAlternatives__Group_1__1 ;
    public final void rule__TerminalAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3792:1: ( ( () ) rule__TerminalAlternatives__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3793:1: ( () ) rule__TerminalAlternatives__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3793:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3794:1: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3795:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3797:1: 
            {
            }

             after(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__1_in_rule__TerminalAlternatives__Group_1__07621);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3808:1: rule__TerminalAlternatives__Group_1__1 : ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__TerminalAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3812:1: ( ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3813:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3813:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3814:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3814:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3815:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3816:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3816:2: rule__TerminalAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__17651);
            rule__TerminalAlternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3819:1: ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3820:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3821:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==30) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3821:2: rule__TerminalAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__17663);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3836:1: rule__TerminalAlternatives__Group_1_1__0 : ( '|' ) rule__TerminalAlternatives__Group_1_1__1 ;
    public final void rule__TerminalAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3840:1: ( ( '|' ) rule__TerminalAlternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3841:1: ( '|' ) rule__TerminalAlternatives__Group_1_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3841:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3842:1: '|'
            {
             before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__TerminalAlternatives__Group_1_1__07705); 
             after(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__1_in_rule__TerminalAlternatives__Group_1_1__07715);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3856:1: rule__TerminalAlternatives__Group_1_1__1 : ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3860:1: ( ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3861:1: ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3861:1: ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3862:1: ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3863:1: ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3863:2: rule__TerminalAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__GroupsAssignment_1_1_1_in_rule__TerminalAlternatives__Group_1_1__17743);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3877:1: rule__TerminalGroup__Group__0 : ( ruleTerminalToken ) rule__TerminalGroup__Group__1 ;
    public final void rule__TerminalGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3881:1: ( ( ruleTerminalToken ) rule__TerminalGroup__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3882:1: ( ruleTerminalToken ) rule__TerminalGroup__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3882:1: ( ruleTerminalToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3883:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group__07781);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__1_in_rule__TerminalGroup__Group__07789);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3895:1: rule__TerminalGroup__Group__1 : ( ( rule__TerminalGroup__Group_1__0 )? ) ;
    public final void rule__TerminalGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3899:1: ( ( ( rule__TerminalGroup__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3900:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3900:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3901:1: ( rule__TerminalGroup__Group_1__0 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3902:1: ( rule__TerminalGroup__Group_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_STRING)||LA43_0==20||LA43_0==22||(LA43_0>=38 && LA43_0<=39)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3902:2: rule__TerminalGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__0_in_rule__TerminalGroup__Group__17817);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3916:1: rule__TerminalGroup__Group_1__0 : ( () ) rule__TerminalGroup__Group_1__1 ;
    public final void rule__TerminalGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3920:1: ( ( () ) rule__TerminalGroup__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3921:1: ( () ) rule__TerminalGroup__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3921:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3922:1: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3923:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3925:1: 
            {
            }

             after(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__1_in_rule__TerminalGroup__Group_1__07866);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3936:1: rule__TerminalGroup__Group_1__1 : ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) ) ;
    public final void rule__TerminalGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3940:1: ( ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3941:1: ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3941:1: ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3942:1: ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3942:1: ( ( rule__TerminalGroup__TokensAssignment_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3943:1: ( rule__TerminalGroup__TokensAssignment_1_1 )
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3944:1: ( rule__TerminalGroup__TokensAssignment_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3944:2: rule__TerminalGroup__TokensAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__17896);
            rule__TerminalGroup__TokensAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3947:1: ( ( rule__TerminalGroup__TokensAssignment_1_1 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3948:1: ( rule__TerminalGroup__TokensAssignment_1_1 )*
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3949:1: ( rule__TerminalGroup__TokensAssignment_1_1 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||LA44_0==20||LA44_0==22||(LA44_0>=38 && LA44_0<=39)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3949:2: rule__TerminalGroup__TokensAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__17908);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3964:1: rule__TerminalToken__Group__0 : ( ruleTerminalTokenElement ) rule__TerminalToken__Group__1 ;
    public final void rule__TerminalToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3968:1: ( ( ruleTerminalTokenElement ) rule__TerminalToken__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3969:1: ( ruleTerminalTokenElement ) rule__TerminalToken__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3969:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3970:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group__07949);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__1_in_rule__TerminalToken__Group__07957);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3982:1: rule__TerminalToken__Group__1 : ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) ;
    public final void rule__TerminalToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3986:1: ( ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3987:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3987:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3988:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3989:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=11 && LA45_0<=13)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3989:2: rule__TerminalToken__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__CardinalityAssignment_1_in_rule__TerminalToken__Group__17985);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4003:1: rule__ParenthesizedTerminalElement__Group__0 : ( '(' ) rule__ParenthesizedTerminalElement__Group__1 ;
    public final void rule__ParenthesizedTerminalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4007:1: ( ( '(' ) rule__ParenthesizedTerminalElement__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4008:1: ( '(' ) rule__ParenthesizedTerminalElement__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4008:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4009:1: '('
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedTerminalElement__Group__08025); 
             after(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__1_in_rule__ParenthesizedTerminalElement__Group__08035);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4023:1: rule__ParenthesizedTerminalElement__Group__1 : ( ruleTerminalAlternatives ) rule__ParenthesizedTerminalElement__Group__2 ;
    public final void rule__ParenthesizedTerminalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4027:1: ( ( ruleTerminalAlternatives ) rule__ParenthesizedTerminalElement__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4028:1: ( ruleTerminalAlternatives ) rule__ParenthesizedTerminalElement__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4028:1: ( ruleTerminalAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4029:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group__18063);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__2_in_rule__ParenthesizedTerminalElement__Group__18071);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4041:1: rule__ParenthesizedTerminalElement__Group__2 : ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4045:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4046:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4046:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4047:1: ')'
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group__28100); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4066:1: rule__NegatedToken__Group__0 : ( '!' ) rule__NegatedToken__Group__1 ;
    public final void rule__NegatedToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4070:1: ( ( '!' ) rule__NegatedToken__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4071:1: ( '!' ) rule__NegatedToken__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4071:1: ( '!' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4072:1: '!'
            {
             before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__NegatedToken__Group__08142); 
             after(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__1_in_rule__NegatedToken__Group__08152);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4086:1: rule__NegatedToken__Group__1 : ( ( rule__NegatedToken__TerminalAssignment_1 ) ) ;
    public final void rule__NegatedToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4090:1: ( ( ( rule__NegatedToken__TerminalAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4091:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4091:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4092:1: ( rule__NegatedToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4093:1: ( rule__NegatedToken__TerminalAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4093:2: rule__NegatedToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__TerminalAssignment_1_in_rule__NegatedToken__Group__18180);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4107:1: rule__UntilToken__Group__0 : ( '->' ) rule__UntilToken__Group__1 ;
    public final void rule__UntilToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4111:1: ( ( '->' ) rule__UntilToken__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4112:1: ( '->' ) rule__UntilToken__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4112:1: ( '->' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4113:1: '->'
            {
             before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__UntilToken__Group__08219); 
             after(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__1_in_rule__UntilToken__Group__08229);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4127:1: rule__UntilToken__Group__1 : ( ( rule__UntilToken__TerminalAssignment_1 ) ) ;
    public final void rule__UntilToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4131:1: ( ( ( rule__UntilToken__TerminalAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4132:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4132:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4133:1: ( rule__UntilToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4134:1: ( rule__UntilToken__TerminalAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4134:2: rule__UntilToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__TerminalAssignment_1_in_rule__UntilToken__Group__18257);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4148:1: rule__Wildcard__Group__0 : ( () ) rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4152:1: ( ( () ) rule__Wildcard__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4153:1: ( () ) rule__Wildcard__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4153:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4154:1: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4155:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4157:1: 
            {
            }

             after(grammarAccess.getWildcardAccess().getWildcardAction_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__1_in_rule__Wildcard__Group__08305);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4168:1: rule__Wildcard__Group__1 : ( '.' ) ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4172:1: ( ( '.' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4173:1: ( '.' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4173:1: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4174:1: '.'
            {
             before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Wildcard__Group__18334); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4191:1: rule__CharacterRange__Group__0 : ( ruleKeyword ) rule__CharacterRange__Group__1 ;
    public final void rule__CharacterRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4195:1: ( ( ruleKeyword ) rule__CharacterRange__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4196:1: ( ruleKeyword ) rule__CharacterRange__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4196:1: ( ruleKeyword )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4197:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CharacterRange__Group__08373);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__1_in_rule__CharacterRange__Group__08381);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4209:1: rule__CharacterRange__Group__1 : ( ( rule__CharacterRange__Group_1__0 )? ) ;
    public final void rule__CharacterRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4213:1: ( ( ( rule__CharacterRange__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4214:1: ( ( rule__CharacterRange__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4214:1: ( ( rule__CharacterRange__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4215:1: ( rule__CharacterRange__Group_1__0 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4216:1: ( rule__CharacterRange__Group_1__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==40) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4216:2: rule__CharacterRange__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__0_in_rule__CharacterRange__Group__18409);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4230:1: rule__CharacterRange__Group_1__0 : ( () ) rule__CharacterRange__Group_1__1 ;
    public final void rule__CharacterRange__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4234:1: ( ( () ) rule__CharacterRange__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4235:1: ( () ) rule__CharacterRange__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4235:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4236:1: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4237:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4239:1: 
            {
            }

             after(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__1_in_rule__CharacterRange__Group_1__08458);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4250:1: rule__CharacterRange__Group_1__1 : ( '..' ) rule__CharacterRange__Group_1__2 ;
    public final void rule__CharacterRange__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4254:1: ( ( '..' ) rule__CharacterRange__Group_1__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4255:1: ( '..' ) rule__CharacterRange__Group_1__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4255:1: ( '..' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4256:1: '..'
            {
             before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,40,FollowSets000.FOLLOW_40_in_rule__CharacterRange__Group_1__18487); 
             after(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__2_in_rule__CharacterRange__Group_1__18497);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4270:1: rule__CharacterRange__Group_1__2 : ( ( rule__CharacterRange__RightAssignment_1_2 ) ) ;
    public final void rule__CharacterRange__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4274:1: ( ( ( rule__CharacterRange__RightAssignment_1_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4275:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4275:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4276:1: ( rule__CharacterRange__RightAssignment_1_2 )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4277:1: ( rule__CharacterRange__RightAssignment_1_2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4277:2: rule__CharacterRange__RightAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__RightAssignment_1_2_in_rule__CharacterRange__Group_1__28525);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4293:1: rule__EnumRule__Group__0 : ( 'enum' ) rule__EnumRule__Group__1 ;
    public final void rule__EnumRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4297:1: ( ( 'enum' ) rule__EnumRule__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4298:1: ( 'enum' ) rule__EnumRule__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4298:1: ( 'enum' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4299:1: 'enum'
            {
             before(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 
            match(input,41,FollowSets000.FOLLOW_41_in_rule__EnumRule__Group__08566); 
             after(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__1_in_rule__EnumRule__Group__08576);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4313:1: rule__EnumRule__Group__1 : ( ( rule__EnumRule__NameAssignment_1 ) ) rule__EnumRule__Group__2 ;
    public final void rule__EnumRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4317:1: ( ( ( rule__EnumRule__NameAssignment_1 ) ) rule__EnumRule__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4318:1: ( ( rule__EnumRule__NameAssignment_1 ) ) rule__EnumRule__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4318:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4319:1: ( rule__EnumRule__NameAssignment_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4320:1: ( rule__EnumRule__NameAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4320:2: rule__EnumRule__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__NameAssignment_1_in_rule__EnumRule__Group__18604);
            rule__EnumRule__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__2_in_rule__EnumRule__Group__18613);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4331:1: rule__EnumRule__Group__2 : ( ( rule__EnumRule__Group_2__0 )? ) rule__EnumRule__Group__3 ;
    public final void rule__EnumRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4335:1: ( ( ( rule__EnumRule__Group_2__0 )? ) rule__EnumRule__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4336:1: ( ( rule__EnumRule__Group_2__0 )? ) rule__EnumRule__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4336:1: ( ( rule__EnumRule__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4337:1: ( rule__EnumRule__Group_2__0 )?
            {
             before(grammarAccess.getEnumRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4338:1: ( rule__EnumRule__Group_2__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==28) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4338:2: rule__EnumRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__0_in_rule__EnumRule__Group__28641);
                    rule__EnumRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumRuleAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__3_in_rule__EnumRule__Group__28651);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4349:1: rule__EnumRule__Group__3 : ( ':' ) rule__EnumRule__Group__4 ;
    public final void rule__EnumRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4353:1: ( ( ':' ) rule__EnumRule__Group__4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4354:1: ( ':' ) rule__EnumRule__Group__4
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4354:1: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4355:1: ':'
            {
             before(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__EnumRule__Group__38680); 
             after(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__4_in_rule__EnumRule__Group__38690);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4369:1: rule__EnumRule__Group__4 : ( ( rule__EnumRule__AlternativesAssignment_4 ) ) rule__EnumRule__Group__5 ;
    public final void rule__EnumRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4373:1: ( ( ( rule__EnumRule__AlternativesAssignment_4 ) ) rule__EnumRule__Group__5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4374:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) ) rule__EnumRule__Group__5
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4374:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4375:1: ( rule__EnumRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4376:1: ( rule__EnumRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4376:2: rule__EnumRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__AlternativesAssignment_4_in_rule__EnumRule__Group__48718);
            rule__EnumRule__AlternativesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__5_in_rule__EnumRule__Group__48727);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4387:1: rule__EnumRule__Group__5 : ( ';' ) ;
    public final void rule__EnumRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4391:1: ( ( ';' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4392:1: ( ';' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4392:1: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4393:1: ';'
            {
             before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__EnumRule__Group__58756); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4418:1: rule__EnumRule__Group_2__0 : ( 'returns' ) rule__EnumRule__Group_2__1 ;
    public final void rule__EnumRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4422:1: ( ( 'returns' ) rule__EnumRule__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4423:1: ( 'returns' ) rule__EnumRule__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4423:1: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4424:1: 'returns'
            {
             before(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__EnumRule__Group_2__08804); 
             after(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__1_in_rule__EnumRule__Group_2__08814);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4438:1: rule__EnumRule__Group_2__1 : ( ( rule__EnumRule__TypeAssignment_2_1 ) ) ;
    public final void rule__EnumRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4442:1: ( ( ( rule__EnumRule__TypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4443:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4443:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4444:1: ( rule__EnumRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4445:1: ( rule__EnumRule__TypeAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4445:2: rule__EnumRule__TypeAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__TypeAssignment_2_1_in_rule__EnumRule__Group_2__18842);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4459:1: rule__EnumLiterals__Group__0 : ( ruleEnumLiteralDeclaration ) rule__EnumLiterals__Group__1 ;
    public final void rule__EnumLiterals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4463:1: ( ( ruleEnumLiteralDeclaration ) rule__EnumLiterals__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4464:1: ( ruleEnumLiteralDeclaration ) rule__EnumLiterals__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4464:1: ( ruleEnumLiteralDeclaration )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4465:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group__08880);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__1_in_rule__EnumLiterals__Group__08888);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4477:1: rule__EnumLiterals__Group__1 : ( ( rule__EnumLiterals__Group_1__0 )? ) ;
    public final void rule__EnumLiterals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4481:1: ( ( ( rule__EnumLiterals__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4482:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4482:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4483:1: ( rule__EnumLiterals__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4484:1: ( rule__EnumLiterals__Group_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==30) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4484:2: rule__EnumLiterals__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__0_in_rule__EnumLiterals__Group__18916);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4498:1: rule__EnumLiterals__Group_1__0 : ( () ) rule__EnumLiterals__Group_1__1 ;
    public final void rule__EnumLiterals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4502:1: ( ( () ) rule__EnumLiterals__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4503:1: ( () ) rule__EnumLiterals__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4503:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4504:1: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4505:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4507:1: 
            {
            }

             after(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__1_in_rule__EnumLiterals__Group_1__08965);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4518:1: rule__EnumLiterals__Group_1__1 : ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) ;
    public final void rule__EnumLiterals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4522:1: ( ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4523:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4523:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4524:1: ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4524:1: ( ( rule__EnumLiterals__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4525:1: ( rule__EnumLiterals__Group_1_1__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4526:1: ( rule__EnumLiterals__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4526:2: rule__EnumLiterals__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__18995);
            rule__EnumLiterals__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4529:1: ( ( rule__EnumLiterals__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4530:1: ( rule__EnumLiterals__Group_1_1__0 )*
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4531:1: ( rule__EnumLiterals__Group_1_1__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==30) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4531:2: rule__EnumLiterals__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__19007);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4546:1: rule__EnumLiterals__Group_1_1__0 : ( '|' ) rule__EnumLiterals__Group_1_1__1 ;
    public final void rule__EnumLiterals__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4550:1: ( ( '|' ) rule__EnumLiterals__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4551:1: ( '|' ) rule__EnumLiterals__Group_1_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4551:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4552:1: '|'
            {
             before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__EnumLiterals__Group_1_1__09049); 
             after(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__1_in_rule__EnumLiterals__Group_1_1__09059);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4566:1: rule__EnumLiterals__Group_1_1__1 : ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__EnumLiterals__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4570:1: ( ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4571:1: ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4571:1: ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4572:1: ( rule__EnumLiterals__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4573:1: ( rule__EnumLiterals__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4573:2: rule__EnumLiterals__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__GroupsAssignment_1_1_1_in_rule__EnumLiterals__Group_1_1__19087);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4587:1: rule__EnumLiteralDeclaration__Group__0 : ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) rule__EnumLiteralDeclaration__Group__1 ;
    public final void rule__EnumLiteralDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4591:1: ( ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) rule__EnumLiteralDeclaration__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4592:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) rule__EnumLiteralDeclaration__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4592:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4593:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4594:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4594:2: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__EnumLiteralAssignment_0_in_rule__EnumLiteralDeclaration__Group__09125);
            rule__EnumLiteralDeclaration__EnumLiteralAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__1_in_rule__EnumLiteralDeclaration__Group__09134);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4605:1: rule__EnumLiteralDeclaration__Group__1 : ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4609:1: ( ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4610:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4610:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4611:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4612:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==14) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4612:2: rule__EnumLiteralDeclaration__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__0_in_rule__EnumLiteralDeclaration__Group__19162);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4626:1: rule__EnumLiteralDeclaration__Group_1__0 : ( '=' ) rule__EnumLiteralDeclaration__Group_1__1 ;
    public final void rule__EnumLiteralDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4630:1: ( ( '=' ) rule__EnumLiteralDeclaration__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4631:1: ( '=' ) rule__EnumLiteralDeclaration__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4631:1: ( '=' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4632:1: '='
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_1__09202); 
             after(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__1_in_rule__EnumLiteralDeclaration__Group_1__09212);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4646:1: rule__EnumLiteralDeclaration__Group_1__1 : ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4650:1: ( ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4651:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4651:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4652:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4653:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4653:2: rule__EnumLiteralDeclaration__LiteralAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__LiteralAssignment_1_1_in_rule__EnumLiteralDeclaration__Group_1__19240);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4667:1: rule__Grammar__NameAssignment_1 : ( ruleGrammarID ) ;
    public final void rule__Grammar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4671:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4672:1: ( ruleGrammarID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4672:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4673:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__NameAssignment_19278);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4682:1: rule__Grammar__UsedGrammarsAssignment_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4686:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4687:1: ( ( ruleGrammarID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4687:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4688:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4689:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4690:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_19313);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4701:1: rule__Grammar__UsedGrammarsAssignment_2_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4705:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4706:1: ( ( ruleGrammarID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4706:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4707:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4708:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4709:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_2_19352);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4720:1: rule__Grammar__DefinesHiddenTokensAssignment_3_0 : ( ( 'hidden' ) ) ;
    public final void rule__Grammar__DefinesHiddenTokensAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4724:1: ( ( ( 'hidden' ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4725:1: ( ( 'hidden' ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4725:1: ( ( 'hidden' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4726:1: ( 'hidden' )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4727:1: ( 'hidden' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4728:1: 'hidden'
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            match(input,42,FollowSets000.FOLLOW_42_in_rule__Grammar__DefinesHiddenTokensAssignment_3_09392); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4743:1: rule__Grammar__HiddenTokensAssignment_3_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4747:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4748:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4748:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4749:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4750:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4751:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_09435); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4762:1: rule__Grammar__HiddenTokensAssignment_3_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4766:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4767:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4767:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4768:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4769:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4770:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_1_19474); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4781:1: rule__Grammar__MetamodelDeclarationsAssignment_4 : ( ruleAbstractMetamodelDeclaration ) ;
    public final void rule__Grammar__MetamodelDeclarationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4785:1: ( ( ruleAbstractMetamodelDeclaration ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4786:1: ( ruleAbstractMetamodelDeclaration )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4786:1: ( ruleAbstractMetamodelDeclaration )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4787:1: ruleAbstractMetamodelDeclaration
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__MetamodelDeclarationsAssignment_49509);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4796:1: rule__Grammar__RulesAssignment_5 : ( ruleAbstractRule ) ;
    public final void rule__Grammar__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4800:1: ( ( ruleAbstractRule ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4801:1: ( ruleAbstractRule )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4801:1: ( ruleAbstractRule )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4802:1: ruleAbstractRule
            {
             before(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_rule__Grammar__RulesAssignment_59540);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4811:1: rule__GeneratedMetamodel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4815:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4816:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4816:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4817:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__NameAssignment_19571); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4826:1: rule__GeneratedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__GeneratedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4830:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4831:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4831:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4832:1: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4833:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4834:1: RULE_STRING
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__EPackageAssignment_29606); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4845:1: rule__GeneratedMetamodel__AliasAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__AliasAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4849:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4850:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4850:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4851:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__AliasAssignment_3_19641); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4860:1: rule__ReferencedMetamodel__EPackageAssignment_1 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4864:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4865:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4865:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4866:1: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4867:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4868:1: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_19676); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4879:1: rule__ReferencedMetamodel__AliasAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4883:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4884:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4884:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4885:1: RULE_ID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_2_19711); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4894:1: rule__ParserRule__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParserRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4898:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4899:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4899:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4900:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__NameAssignment_09742); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4909:1: rule__ParserRule__TypeAssignment_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4913:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4914:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4914:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4915:1: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__ParserRule__TypeAssignment_1_19773);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4924:1: rule__ParserRule__DefinesHiddenTokensAssignment_2_0 : ( ( 'hidden' ) ) ;
    public final void rule__ParserRule__DefinesHiddenTokensAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4928:1: ( ( ( 'hidden' ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4929:1: ( ( 'hidden' ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4929:1: ( ( 'hidden' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4930:1: ( 'hidden' )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4931:1: ( 'hidden' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4932:1: 'hidden'
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            match(input,42,FollowSets000.FOLLOW_42_in_rule__ParserRule__DefinesHiddenTokensAssignment_2_09809); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4947:1: rule__ParserRule__HiddenTokensAssignment_2_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4951:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4952:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4952:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4953:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4954:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4955:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_09852); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4966:1: rule__ParserRule__HiddenTokensAssignment_2_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4970:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4971:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4971:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4972:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4973:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4974:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_1_19891); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4985:1: rule__ParserRule__AlternativesAssignment_4 : ( ruleAlternatives ) ;
    public final void rule__ParserRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4989:1: ( ( ruleAlternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4990:1: ( ruleAlternatives )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4990:1: ( ruleAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4991:1: ruleAlternatives
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rule__ParserRule__AlternativesAssignment_49926);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5000:1: rule__TypeRef__MetamodelAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__MetamodelAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5004:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5005:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5005:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5006:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5007:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5008:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeRef__MetamodelAssignment_0_09961); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5019:1: rule__TypeRef__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5023:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5024:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5024:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5025:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5026:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5027:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeRef__ClassifierAssignment_110000); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5038:1: rule__Alternatives__GroupsAssignment_1_1_1 : ( ruleUnorderedGroup ) ;
    public final void rule__Alternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5042:1: ( ( ruleUnorderedGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5043:1: ( ruleUnorderedGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5043:1: ( ruleUnorderedGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5044:1: ruleUnorderedGroup
            {
             before(grammarAccess.getAlternativesAccess().getGroupsUnorderedGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_rule__Alternatives__GroupsAssignment_1_1_110035);
            ruleUnorderedGroup();
            _fsp--;

             after(grammarAccess.getAlternativesAccess().getGroupsUnorderedGroupParserRuleCall_1_1_1_0()); 

            }


            }

        }
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


    // $ANTLR start rule__UnorderedGroup__ElementsAssignment_1_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5053:1: rule__UnorderedGroup__ElementsAssignment_1_1_1 : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5057:1: ( ( ruleGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5058:1: ( ruleGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5058:1: ( ruleGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5059:1: ruleGroup
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_rule__UnorderedGroup__ElementsAssignment_1_1_110066);
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


    // $ANTLR start rule__Group__TokensAssignment_1_1
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5068:1: rule__Group__TokensAssignment_1_1 : ( ruleAbstractToken ) ;
    public final void rule__Group__TokensAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5072:1: ( ( ruleAbstractToken ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5073:1: ( ruleAbstractToken )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5073:1: ( ruleAbstractToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5074:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_rule__Group__TokensAssignment_1_110097);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5083:1: rule__AbstractTokenWithCardinality__CardinalityAssignment_1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5087:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5088:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5088:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5089:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5090:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5090:2: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__CardinalityAssignment_110128);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5099:1: rule__Action__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Action__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5103:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5104:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5104:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5105:1: ruleTypeRef
            {
             before(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Action__TypeAssignment_110161);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5114:1: rule__Action__FeatureAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Action__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5118:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5119:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5119:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5120:1: RULE_ID
            {
             before(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Action__FeatureAssignment_2_110192); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5129:1: rule__Action__OperatorAssignment_2_2 : ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ;
    public final void rule__Action__OperatorAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5133:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5134:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5134:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5135:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5136:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5136:2: rule__Action__OperatorAlternatives_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__OperatorAssignment_2_210223);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5145:1: rule__Keyword__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Keyword__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5149:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5150:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5150:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5151:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Keyword__ValueAssignment10256); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5160:1: rule__RuleCall__RuleAssignment : ( ( RULE_ID ) ) ;
    public final void rule__RuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5164:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5165:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5165:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5166:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5167:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5168:1: RULE_ID
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__RuleCall__RuleAssignment10291); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5179:1: rule__Assignment__FeatureAssignment_0 : ( RULE_ID ) ;
    public final void rule__Assignment__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5183:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5184:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5184:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5185:1: RULE_ID
            {
             before(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Assignment__FeatureAssignment_010326); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5194:1: rule__Assignment__OperatorAssignment_1 : ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) ;
    public final void rule__Assignment__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5198:1: ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5199:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5199:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5200:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5201:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5201:2: rule__Assignment__OperatorAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__OperatorAssignment_110357);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5210:1: rule__Assignment__TerminalAssignment_2 : ( ruleAssignableTerminal ) ;
    public final void rule__Assignment__TerminalAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5214:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5215:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5215:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5216:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__Assignment__TerminalAssignment_210390);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5225:1: rule__AssignableAlternatives__GroupsAssignment_1_1_1 : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5229:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5230:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5230:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5231:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__GroupsAssignment_1_1_110421);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5240:1: rule__CrossReference__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__CrossReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5244:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5245:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5245:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5246:1: ruleTypeRef
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__CrossReference__TypeAssignment_110452);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5255:1: rule__CrossReference__TerminalAssignment_2_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReference__TerminalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5259:1: ( ( ruleCrossReferenceableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5260:1: ( ruleCrossReferenceableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5260:1: ( ruleCrossReferenceableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5261:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__TerminalAssignment_2_110483);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5270:1: rule__TerminalRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TerminalRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5274:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5275:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5275:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5276:1: RULE_ID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_110514); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5285:1: rule__TerminalRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__TerminalRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5289:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5290:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5290:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5291:1: ruleTypeRef
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__TerminalRule__TypeAssignment_2_110545);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5300:1: rule__TerminalRule__AlternativesAssignment_4 : ( ruleTerminalAlternatives ) ;
    public final void rule__TerminalRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5304:1: ( ( ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5305:1: ( ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5305:1: ( ruleTerminalAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5306:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__AlternativesAssignment_410576);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5315:1: rule__TerminalAlternatives__GroupsAssignment_1_1_1 : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5319:1: ( ( ruleTerminalGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5320:1: ( ruleTerminalGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5320:1: ( ruleTerminalGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5321:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__GroupsAssignment_1_1_110607);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5330:1: rule__TerminalGroup__TokensAssignment_1_1 : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__TokensAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5334:1: ( ( ruleTerminalToken ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5335:1: ( ruleTerminalToken )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5335:1: ( ruleTerminalToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5336:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__TokensAssignment_1_110638);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5345:1: rule__TerminalToken__CardinalityAssignment_1 : ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__TerminalToken__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5349:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5350:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5350:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5351:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5352:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5352:2: rule__TerminalToken__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__CardinalityAssignment_110669);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5361:1: rule__NegatedToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__NegatedToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5365:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5366:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5366:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5367:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__TerminalAssignment_110702);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5376:1: rule__UntilToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__UntilToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5380:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5381:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5381:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5382:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__TerminalAssignment_110733);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5391:1: rule__CharacterRange__RightAssignment_1_2 : ( ruleKeyword ) ;
    public final void rule__CharacterRange__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5395:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5396:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5396:1: ( ruleKeyword )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5397:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CharacterRange__RightAssignment_1_210764);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5406:1: rule__EnumRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5410:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5411:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5411:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5412:1: RULE_ID
            {
             before(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EnumRule__NameAssignment_110795); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5421:1: rule__EnumRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__EnumRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5425:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5426:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5426:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5427:1: ruleTypeRef
            {
             before(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__EnumRule__TypeAssignment_2_110826);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5436:1: rule__EnumRule__AlternativesAssignment_4 : ( ruleEnumLiterals ) ;
    public final void rule__EnumRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5440:1: ( ( ruleEnumLiterals ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5441:1: ( ruleEnumLiterals )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5441:1: ( ruleEnumLiterals )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5442:1: ruleEnumLiterals
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_rule__EnumRule__AlternativesAssignment_410857);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5451:1: rule__EnumLiterals__GroupsAssignment_1_1_1 : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5455:1: ( ( ruleEnumLiteralDeclaration ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5456:1: ( ruleEnumLiteralDeclaration )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5456:1: ( ruleEnumLiteralDeclaration )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5457:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__GroupsAssignment_1_1_110888);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5466:1: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumLiteralDeclaration__EnumLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5470:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5471:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5471:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5472:1: ( RULE_ID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5473:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5474:1: RULE_ID
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__EnumLiteralAssignment_010923); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5485:1: rule__EnumLiteralDeclaration__LiteralAssignment_1_1 : ( ruleKeyword ) ;
    public final void rule__EnumLiteralDeclaration__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5489:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5490:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5490:1: ( ruleKeyword )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5491:1: ruleKeyword
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__LiteralAssignment_1_110958);
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
        public static final BitSet FOLLOW_rule__Grammar__Group__0_in_ruleGrammar95 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__0_in_ruleGrammarID156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration244 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractMetamodelDeclaration__Alternatives_in_ruleAbstractMetamodelDeclaration278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel305 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__0_in_ruleGeneratedMetamodel339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel366 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__0_in_ruleReferencedMetamodel400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRule434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__0_in_ruleParserRule461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef488 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__0_in_ruleTypeRef522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives549 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__0_in_ruleAlternatives583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup610 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedGroup617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group__0_in_ruleUnorderedGroup644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup671 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroup678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group__0_in_ruleGroup705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken732 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality793 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__0_in_ruleAbstractTokenWithCardinality827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction854 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__0_in_ruleAction888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal915 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword976 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeyword983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Keyword__ValueAssignment_in_ruleKeyword1010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall1037 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall1044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RuleCall__RuleAssignment_in_ruleRuleCall1071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment1098 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment1105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__0_in_ruleAssignment1132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1159 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal1166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1220 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement1227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__0_in_ruleParenthesizedAssignableElement1254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1281 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives1288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__0_in_ruleAssignableAlternatives1315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference1342 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference1349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__0_in_ruleCrossReference1376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1403 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal1410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1464 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement1471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__0_in_ruleParenthesizedElement1498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1525 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__0_in_ruleTerminalRule1559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1586 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives1593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__0_in_ruleTerminalAlternatives1620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1647 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup1654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__0_in_ruleTerminalGroup1681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1708 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken1715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__0_in_ruleTerminalToken1742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1769 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement1776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1830 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement1837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__0_in_ruleParenthesizedTerminalElement1864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1891 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken1898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1952 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken1959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__0_in_ruleNegatedToken1986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken2013 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken2020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__0_in_ruleUntilToken2047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard2074 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcard2081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__0_in_ruleWildcard2108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2135 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange2142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__0_in_ruleCharacterRange2169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule2196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule2203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__0_in_ruleEnumRule2230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2257 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals2264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__0_in_ruleEnumLiterals2291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2318 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration2325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__0_in_ruleEnumLiteralDeclaration2352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_rule__AbstractRule__Alternatives2388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_rule__AbstractRule__Alternatives2405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_rule__AbstractRule__Alternatives2422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_rule__AbstractToken__Alternatives2503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_rule__AbstractToken__Alternatives2520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_rule__AbstractTokenWithCardinality__Alternatives_02552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_rule__AbstractTokenWithCardinality__Alternatives_02569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Action__OperatorAlternatives_2_2_02677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Action__OperatorAlternatives_2_2_02697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__AbstractTerminal__Alternatives2731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__AbstractTerminal__Alternatives2748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_rule__AbstractTerminal__Alternatives2765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Assignment__OperatorAlternatives_1_02798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Assignment__OperatorAlternatives_1_02818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Assignment__OperatorAlternatives_1_02838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__AssignableTerminal__Alternatives2872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__AssignableTerminal__Alternatives2889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_rule__AssignableTerminal__Alternatives2906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_rule__AssignableTerminal__Alternatives2923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CrossReferenceableTerminal__Alternatives2955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__CrossReferenceableTerminal__Alternatives2972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_03005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_03025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_03045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Grammar__Group__03231 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__1_in_rule__Grammar__Group__03241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__NameAssignment_1_in_rule__Grammar__Group__13269 = new BitSet(new long[]{0x0000062002840010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__2_in_rule__Grammar__Group__13278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__0_in_rule__Grammar__Group__23306 = new BitSet(new long[]{0x0000062002800010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__3_in_rule__Grammar__Group__23316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__0_in_rule__Grammar__Group__33344 = new BitSet(new long[]{0x0000022002800010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__4_in_rule__Grammar__Group__33354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__MetamodelDeclarationsAssignment_4_in_rule__Grammar__Group__43382 = new BitSet(new long[]{0x0000022002800010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__5_in_rule__Grammar__Group__43392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__53422 = new BitSet(new long[]{0x0000022000000012L});
        public static final BitSet FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__53434 = new BitSet(new long[]{0x0000022000000012L});
        public static final BitSet FOLLOW_18_in_rule__Grammar__Group_2__03484 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__1_in_rule__Grammar__Group_2__03494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_1_in_rule__Grammar__Group_2__13522 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__2_in_rule__Grammar__Group_2__13531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__0_in_rule__Grammar__Group_2__23559 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_rule__Grammar__Group_2_2__03601 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__1_in_rule__Grammar__Group_2_2__03611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_2_1_in_rule__Grammar__Group_2_2__13639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__DefinesHiddenTokensAssignment_3_0_in_rule__Grammar__Group_3__03677 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__1_in_rule__Grammar__Group_3__03686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Grammar__Group_3__13715 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__2_in_rule__Grammar__Group_3__13725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__0_in_rule__Grammar__Group_3__23753 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__3_in_rule__Grammar__Group_3__23763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Grammar__Group_3__33792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_0_in_rule__Grammar__Group_3_2__03835 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__1_in_rule__Grammar__Group_3_2__03844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__0_in_rule__Grammar__Group_3_2__13872 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_rule__Grammar__Group_3_2_1__03912 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__1_in_rule__Grammar__Group_3_2_1__03922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_1_1_in_rule__Grammar__Group_3_2_1__13950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group__03988 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__1_in_rule__GrammarID__Group__03996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__0_in_rule__GrammarID__Group__14024 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_rule__GrammarID__Group_1__04064 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__1_in_rule__GrammarID__Group_1__04074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group_1__14102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__GeneratedMetamodel__Group__04140 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__1_in_rule__GeneratedMetamodel__Group__04150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__NameAssignment_1_in_rule__GeneratedMetamodel__Group__14178 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__2_in_rule__GeneratedMetamodel__Group__14187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__EPackageAssignment_2_in_rule__GeneratedMetamodel__Group__24215 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__3_in_rule__GeneratedMetamodel__Group__24224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__0_in_rule__GeneratedMetamodel__Group__34252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__GeneratedMetamodel__Group_3__04296 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__1_in_rule__GeneratedMetamodel__Group_3__04306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__AliasAssignment_3_1_in_rule__GeneratedMetamodel__Group_3__14334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ReferencedMetamodel__Group__04373 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__04383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_1_in_rule__ReferencedMetamodel__Group__14411 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__14420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__0_in_rule__ReferencedMetamodel__Group__24448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__ReferencedMetamodel__Group_2__04490 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__1_in_rule__ReferencedMetamodel__Group_2__04500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__AliasAssignment_2_1_in_rule__ReferencedMetamodel__Group_2__14528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__NameAssignment_0_in_rule__ParserRule__Group__04566 = new BitSet(new long[]{0x0000040014000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__1_in_rule__ParserRule__Group__04575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__0_in_rule__ParserRule__Group__14603 = new BitSet(new long[]{0x0000040004000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__2_in_rule__ParserRule__Group__14613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__0_in_rule__ParserRule__Group__24641 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__3_in_rule__ParserRule__Group__24651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__ParserRule__Group__34680 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__4_in_rule__ParserRule__Group__34690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__AlternativesAssignment_4_in_rule__ParserRule__Group__44718 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__5_in_rule__ParserRule__Group__44727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ParserRule__Group__54756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ParserRule__Group_1__04804 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__1_in_rule__ParserRule__Group_1__04814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__TypeAssignment_1_1_in_rule__ParserRule__Group_1__14842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__DefinesHiddenTokensAssignment_2_0_in_rule__ParserRule__Group_2__04880 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__1_in_rule__ParserRule__Group_2__04889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParserRule__Group_2__14918 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__2_in_rule__ParserRule__Group_2__14928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__0_in_rule__ParserRule__Group_2__24956 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__3_in_rule__ParserRule__Group_2__24966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParserRule__Group_2__34995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_0_in_rule__ParserRule__Group_2_2__05038 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__1_in_rule__ParserRule__Group_2_2__05047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__0_in_rule__ParserRule__Group_2_2__15075 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_rule__ParserRule__Group_2_2_1__05115 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__1_in_rule__ParserRule__Group_2_2_1__05125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_1_1_in_rule__ParserRule__Group_2_2_1__15153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__0_in_rule__TypeRef__Group__05191 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__1_in_rule__TypeRef__Group__05201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__ClassifierAssignment_1_in_rule__TypeRef__Group__15229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__MetamodelAssignment_0_0_in_rule__TypeRef__Group_0__05267 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__1_in_rule__TypeRef__Group_0__05276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__TypeRef__Group_0__15305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_rule__Alternatives__Group__05344 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__1_in_rule__Alternatives__Group__05352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__0_in_rule__Alternatives__Group__15380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__1_in_rule__Alternatives__Group_1__05429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__15459 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__15471 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_rule__Alternatives__Group_1_1__05513 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__1_in_rule__Alternatives__Group_1_1__05523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__GroupsAssignment_1_1_1_in_rule__Alternatives__Group_1_1__15551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_rule__UnorderedGroup__Group__05589 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group__1_in_rule__UnorderedGroup__Group__05597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1__0_in_rule__UnorderedGroup__Group__15625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1__1_in_rule__UnorderedGroup__Group_1__05674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__0_in_rule__UnorderedGroup__Group_1__15704 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__0_in_rule__UnorderedGroup__Group_1__15716 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_31_in_rule__UnorderedGroup__Group_1_1__05758 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__Group_1_1__1_in_rule__UnorderedGroup__Group_1_1__05768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UnorderedGroup__ElementsAssignment_1_1_1_in_rule__UnorderedGroup__Group_1_1__15796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__Group__05834 = new BitSet(new long[]{0x0000000100100032L});
        public static final BitSet FOLLOW_rule__Group__Group__1_in_rule__Group__Group__05842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__0_in_rule__Group__Group__15870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__1_in_rule__Group__Group_1__05919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__15949 = new BitSet(new long[]{0x0000000100100032L});
        public static final BitSet FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__15961 = new BitSet(new long[]{0x0000000100100032L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group__06002 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__1_in_rule__AbstractTokenWithCardinality__Group__06011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAssignment_1_in_rule__AbstractTokenWithCardinality__Group__16039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Action__Group__06079 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Action__Group__1_in_rule__Action__Group__06089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__TypeAssignment_1_in_rule__Action__Group__16117 = new BitSet(new long[]{0x0000000200400000L});
        public static final BitSet FOLLOW_rule__Action__Group__2_in_rule__Action__Group__16126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__0_in_rule__Action__Group__26154 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__Action__Group__3_in_rule__Action__Group__26164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__Action__Group__36193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Action__Group_2__06237 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Action__Group_2__1_in_rule__Action__Group_2__06247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__FeatureAssignment_2_1_in_rule__Action__Group_2__16275 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_rule__Action__Group_2__2_in_rule__Action__Group_2__16284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__OperatorAssignment_2_2_in_rule__Action__Group_2__26312 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__Action__Group_2__3_in_rule__Action__Group_2__26321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__Action__Group_2__36350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__FeatureAssignment_0_in_rule__Assignment__Group__06393 = new BitSet(new long[]{0x000000000001C000L});
        public static final BitSet FOLLOW_rule__Assignment__Group__1_in_rule__Assignment__Group__06402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__OperatorAssignment_1_in_rule__Assignment__Group__16430 = new BitSet(new long[]{0x0000000800100030L});
        public static final BitSet FOLLOW_rule__Assignment__Group__2_in_rule__Assignment__Group__16439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__TerminalAssignment_2_in_rule__Assignment__Group__26467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedAssignableElement__Group__06508 = new BitSet(new long[]{0x0000000800100030L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__1_in_rule__ParenthesizedAssignableElement__Group__06518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group__16546 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__2_in_rule__ParenthesizedAssignableElement__Group__16554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group__26583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group__06624 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__1_in_rule__AssignableAlternatives__Group__06632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__0_in_rule__AssignableAlternatives__Group__16660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__1_in_rule__AssignableAlternatives__Group_1__06709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__16739 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__16751 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_rule__AssignableAlternatives__Group_1_1__06793 = new BitSet(new long[]{0x0000000800100030L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__1_in_rule__AssignableAlternatives__Group_1_1__06803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__GroupsAssignment_1_1_1_in_rule__AssignableAlternatives__Group_1_1__16831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__CrossReference__Group__06870 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__1_in_rule__CrossReference__Group__06880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__TypeAssignment_1_in_rule__CrossReference__Group__16908 = new BitSet(new long[]{0x0000001040000000L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__2_in_rule__CrossReference__Group__16917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__0_in_rule__CrossReference__Group__26945 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__3_in_rule__CrossReference__Group__26955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__CrossReference__Group__36984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__CrossReference__Group_2__07028 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__1_in_rule__CrossReference__Group_2__07038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__TerminalAssignment_2_1_in_rule__CrossReference__Group_2__17066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedElement__Group__07105 = new BitSet(new long[]{0x0000000100100030L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__1_in_rule__ParenthesizedElement__Group__07115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group__17143 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__2_in_rule__ParenthesizedElement__Group__17151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedElement__Group__27180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__TerminalRule__Group__07222 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__1_in_rule__TerminalRule__Group__07232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__NameAssignment_1_in_rule__TerminalRule__Group__17260 = new BitSet(new long[]{0x0000000014000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__2_in_rule__TerminalRule__Group__17269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_2__0_in_rule__TerminalRule__Group__27297 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__3_in_rule__TerminalRule__Group__27307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__TerminalRule__Group__37336 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__4_in_rule__TerminalRule__Group__37346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__AlternativesAssignment_4_in_rule__TerminalRule__Group__47374 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__5_in_rule__TerminalRule__Group__47383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__TerminalRule__Group__57412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__TerminalRule__Group_2__07460 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_2__1_in_rule__TerminalRule__Group_2__07470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__TypeAssignment_2_1_in_rule__TerminalRule__Group_2__17498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group__07536 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__1_in_rule__TerminalAlternatives__Group__07544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__0_in_rule__TerminalAlternatives__Group__17572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__1_in_rule__TerminalAlternatives__Group_1__07621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__17651 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__17663 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_rule__TerminalAlternatives__Group_1_1__07705 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__1_in_rule__TerminalAlternatives__Group_1_1__07715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__GroupsAssignment_1_1_1_in_rule__TerminalAlternatives__Group_1_1__17743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group__07781 = new BitSet(new long[]{0x000000C000500032L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__1_in_rule__TerminalGroup__Group__07789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__0_in_rule__TerminalGroup__Group__17817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__1_in_rule__TerminalGroup__Group_1__07866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__17896 = new BitSet(new long[]{0x000000C000500032L});
        public static final BitSet FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__17908 = new BitSet(new long[]{0x000000C000500032L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group__07949 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__1_in_rule__TerminalToken__Group__07957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAssignment_1_in_rule__TerminalToken__Group__17985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedTerminalElement__Group__08025 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__1_in_rule__ParenthesizedTerminalElement__Group__08035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group__18063 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__2_in_rule__ParenthesizedTerminalElement__Group__18071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group__28100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__NegatedToken__Group__08142 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__1_in_rule__NegatedToken__Group__08152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__TerminalAssignment_1_in_rule__NegatedToken__Group__18180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__UntilToken__Group__08219 = new BitSet(new long[]{0x000000C000500030L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__1_in_rule__UntilToken__Group__08229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__TerminalAssignment_1_in_rule__UntilToken__Group__18257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__1_in_rule__Wildcard__Group__08305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Wildcard__Group__18334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__Group__08373 = new BitSet(new long[]{0x0000010000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__1_in_rule__CharacterRange__Group__08381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__0_in_rule__CharacterRange__Group__18409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__1_in_rule__CharacterRange__Group_1__08458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__CharacterRange__Group_1__18487 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__2_in_rule__CharacterRange__Group_1__18497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__RightAssignment_1_2_in_rule__CharacterRange__Group_1__28525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__EnumRule__Group__08566 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__1_in_rule__EnumRule__Group__08576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__NameAssignment_1_in_rule__EnumRule__Group__18604 = new BitSet(new long[]{0x0000000014000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__2_in_rule__EnumRule__Group__18613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__0_in_rule__EnumRule__Group__28641 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__3_in_rule__EnumRule__Group__28651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__EnumRule__Group__38680 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__4_in_rule__EnumRule__Group__38690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__AlternativesAssignment_4_in_rule__EnumRule__Group__48718 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__5_in_rule__EnumRule__Group__48727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__EnumRule__Group__58756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__EnumRule__Group_2__08804 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__1_in_rule__EnumRule__Group_2__08814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__TypeAssignment_2_1_in_rule__EnumRule__Group_2__18842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group__08880 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__1_in_rule__EnumLiterals__Group__08888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__0_in_rule__EnumLiterals__Group__18916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__1_in_rule__EnumLiterals__Group_1__08965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__18995 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__19007 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_rule__EnumLiterals__Group_1_1__09049 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__1_in_rule__EnumLiterals__Group_1_1__09059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__GroupsAssignment_1_1_1_in_rule__EnumLiterals__Group_1_1__19087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__EnumLiteralAssignment_0_in_rule__EnumLiteralDeclaration__Group__09125 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__1_in_rule__EnumLiteralDeclaration__Group__09134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__0_in_rule__EnumLiteralDeclaration__Group__19162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_1__09202 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__1_in_rule__EnumLiteralDeclaration__Group_1__09212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__LiteralAssignment_1_1_in_rule__EnumLiteralDeclaration__Group_1__19240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__NameAssignment_19278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_19313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_2_19352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__Grammar__DefinesHiddenTokensAssignment_3_09392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_09435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_1_19474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__MetamodelDeclarationsAssignment_49509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_rule__Grammar__RulesAssignment_59540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__NameAssignment_19571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__EPackageAssignment_29606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__AliasAssignment_3_19641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_19676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_2_19711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__NameAssignment_09742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__ParserRule__TypeAssignment_1_19773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__ParserRule__DefinesHiddenTokensAssignment_2_09809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_09852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_1_19891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParserRule__AlternativesAssignment_49926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__MetamodelAssignment_0_09961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__ClassifierAssignment_110000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_rule__Alternatives__GroupsAssignment_1_1_110035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_rule__UnorderedGroup__ElementsAssignment_1_1_110066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__TokensAssignment_1_110097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__CardinalityAssignment_110128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Action__TypeAssignment_110161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Action__FeatureAssignment_2_110192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__OperatorAssignment_2_210223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__ValueAssignment10256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__RuleCall__RuleAssignment10291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Assignment__FeatureAssignment_010326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__OperatorAssignment_110357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__Assignment__TerminalAssignment_210390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__GroupsAssignment_1_1_110421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__CrossReference__TypeAssignment_110452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__TerminalAssignment_2_110483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_110514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__TerminalRule__TypeAssignment_2_110545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__AlternativesAssignment_410576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__GroupsAssignment_1_1_110607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__TokensAssignment_1_110638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__CardinalityAssignment_110669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__TerminalAssignment_110702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__TerminalAssignment_110733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__RightAssignment_1_210764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EnumRule__NameAssignment_110795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__EnumRule__TypeAssignment_2_110826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_rule__EnumRule__AlternativesAssignment_410857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__GroupsAssignment_1_1_110888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__EnumLiteralAssignment_010923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__LiteralAssignment_1_110958 = new BitSet(new long[]{0x0000000000000002L});
    }


}
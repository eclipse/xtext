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


    // $ANTLR start entryRuleGroup
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:312:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:313:1: ( ruleGroup EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:314:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_entryRuleGroup610);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroup617); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:321:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:325:2: ( ( ( rule__Group__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:326:1: ( ( rule__Group__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:326:1: ( ( rule__Group__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:327:1: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:328:1: ( rule__Group__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:328:2: rule__Group__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__0_in_ruleGroup644);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:340:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:341:1: ( ruleAbstractToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:342:1: ruleAbstractToken EOF
            {
             before(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken671);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getAbstractTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractToken678); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:349:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:353:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:354:1: ( ( rule__AbstractToken__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:354:1: ( ( rule__AbstractToken__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:355:1: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:356:1: ( rule__AbstractToken__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:356:2: rule__AbstractToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken705);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:368:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:369:1: ( ruleAbstractTokenWithCardinality EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:370:1: ruleAbstractTokenWithCardinality EOF
            {
             before(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality732);
            ruleAbstractTokenWithCardinality();
            _fsp--;

             after(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality739); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:377:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:381:2: ( ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:382:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:382:1: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:383:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:384:1: ( rule__AbstractTokenWithCardinality__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:384:2: rule__AbstractTokenWithCardinality__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__0_in_ruleAbstractTokenWithCardinality766);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:396:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:397:1: ( ruleAction EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:398:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction793);
            ruleAction();
            _fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction800); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:405:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:409:2: ( ( ( rule__Action__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:410:1: ( ( rule__Action__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:410:1: ( ( rule__Action__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:411:1: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:412:1: ( rule__Action__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:412:2: rule__Action__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__0_in_ruleAction827);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:424:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:425:1: ( ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:426:1: ruleAbstractTerminal EOF
            {
             before(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal854);
            ruleAbstractTerminal();
            _fsp--;

             after(grammarAccess.getAbstractTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTerminal861); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:433:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:437:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:438:1: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:438:1: ( ( rule__AbstractTerminal__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:439:1: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:440:1: ( rule__AbstractTerminal__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:440:2: rule__AbstractTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal888);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:452:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:453:1: ( ruleKeyword EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:454:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_entryRuleKeyword915);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeyword922); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:461:1: ruleKeyword : ( ( rule__Keyword__ValueAssignment ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:465:2: ( ( ( rule__Keyword__ValueAssignment ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:466:1: ( ( rule__Keyword__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:466:1: ( ( rule__Keyword__ValueAssignment ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:467:1: ( rule__Keyword__ValueAssignment )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:468:1: ( rule__Keyword__ValueAssignment )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:468:2: rule__Keyword__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Keyword__ValueAssignment_in_ruleKeyword949);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:480:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:481:1: ( ruleRuleCall EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:482:1: ruleRuleCall EOF
            {
             before(grammarAccess.getRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_entryRuleRuleCall976);
            ruleRuleCall();
            _fsp--;

             after(grammarAccess.getRuleCallRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCall983); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:489:1: ruleRuleCall : ( ( rule__RuleCall__RuleAssignment ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:493:2: ( ( ( rule__RuleCall__RuleAssignment ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:494:1: ( ( rule__RuleCall__RuleAssignment ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:494:1: ( ( rule__RuleCall__RuleAssignment ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:495:1: ( rule__RuleCall__RuleAssignment )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:496:1: ( rule__RuleCall__RuleAssignment )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:496:2: rule__RuleCall__RuleAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__RuleCall__RuleAssignment_in_ruleRuleCall1010);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:508:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:509:1: ( ruleAssignment EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:510:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment1037);
            ruleAssignment();
            _fsp--;

             after(grammarAccess.getAssignmentRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment1044); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:517:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:521:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:522:1: ( ( rule__Assignment__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:522:1: ( ( rule__Assignment__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:523:1: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:524:1: ( rule__Assignment__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:524:2: rule__Assignment__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__0_in_ruleAssignment1071);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:536:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:537:1: ( ruleAssignableTerminal EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:538:1: ruleAssignableTerminal EOF
            {
             before(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1098);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableTerminal1105); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:545:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:549:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:550:1: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:550:1: ( ( rule__AssignableTerminal__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:551:1: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:552:1: ( rule__AssignableTerminal__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:552:2: rule__AssignableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1132);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:564:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:565:1: ( ruleParenthesizedAssignableElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:566:1: ruleParenthesizedAssignableElement EOF
            {
             before(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1159);
            ruleParenthesizedAssignableElement();
            _fsp--;

             after(grammarAccess.getParenthesizedAssignableElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement1166); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:573:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:577:2: ( ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:578:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:578:1: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:579:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:580:1: ( rule__ParenthesizedAssignableElement__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:580:2: rule__ParenthesizedAssignableElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__0_in_ruleParenthesizedAssignableElement1193);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:592:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:593:1: ( ruleAssignableAlternatives EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:594:1: ruleAssignableAlternatives EOF
            {
             before(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1220);
            ruleAssignableAlternatives();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableAlternatives1227); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:601:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group__0 ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:605:2: ( ( ( rule__AssignableAlternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:606:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:606:1: ( ( rule__AssignableAlternatives__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:607:1: ( rule__AssignableAlternatives__Group__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:608:1: ( rule__AssignableAlternatives__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:608:2: rule__AssignableAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__0_in_ruleAssignableAlternatives1254);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:620:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:621:1: ( ruleCrossReference EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:622:1: ruleCrossReference EOF
            {
             before(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_entryRuleCrossReference1281);
            ruleCrossReference();
            _fsp--;

             after(grammarAccess.getCrossReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReference1288); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:629:1: ruleCrossReference : ( ( rule__CrossReference__Group__0 ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:633:2: ( ( ( rule__CrossReference__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:634:1: ( ( rule__CrossReference__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:634:1: ( ( rule__CrossReference__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:635:1: ( rule__CrossReference__Group__0 )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:636:1: ( rule__CrossReference__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:636:2: rule__CrossReference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__0_in_ruleCrossReference1315);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:648:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:649:1: ( ruleCrossReferenceableTerminal EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:650:1: ruleCrossReferenceableTerminal EOF
            {
             before(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1342);
            ruleCrossReferenceableTerminal();
            _fsp--;

             after(grammarAccess.getCrossReferenceableTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal1349); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:657:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:661:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:662:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:662:1: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:663:1: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:664:1: ( rule__CrossReferenceableTerminal__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:664:2: rule__CrossReferenceableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1376);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:676:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:677:1: ( ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:678:1: ruleParenthesizedElement EOF
            {
             before(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1403);
            ruleParenthesizedElement();
            _fsp--;

             after(grammarAccess.getParenthesizedElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedElement1410); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:685:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group__0 ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:689:2: ( ( ( rule__ParenthesizedElement__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:690:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:690:1: ( ( rule__ParenthesizedElement__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:691:1: ( rule__ParenthesizedElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:692:1: ( rule__ParenthesizedElement__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:692:2: rule__ParenthesizedElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__0_in_ruleParenthesizedElement1437);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:704:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:705:1: ( ruleTerminalRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:706:1: ruleTerminalRule EOF
            {
             before(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1464);
            ruleTerminalRule();
            _fsp--;

             after(grammarAccess.getTerminalRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule1471); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:713:1: ruleTerminalRule : ( ( rule__TerminalRule__Group__0 ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:717:2: ( ( ( rule__TerminalRule__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:718:1: ( ( rule__TerminalRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:718:1: ( ( rule__TerminalRule__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:719:1: ( rule__TerminalRule__Group__0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:720:1: ( rule__TerminalRule__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:720:2: rule__TerminalRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__0_in_ruleTerminalRule1498);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:732:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:733:1: ( ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:734:1: ruleTerminalAlternatives EOF
            {
             before(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1525);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalAlternatives1532); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:741:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group__0 ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:745:2: ( ( ( rule__TerminalAlternatives__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:746:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:746:1: ( ( rule__TerminalAlternatives__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:747:1: ( rule__TerminalAlternatives__Group__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:748:1: ( rule__TerminalAlternatives__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:748:2: rule__TerminalAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__0_in_ruleTerminalAlternatives1559);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:760:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:761:1: ( ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:762:1: ruleTerminalGroup EOF
            {
             before(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1586);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalGroup1593); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:769:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group__0 ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:773:2: ( ( ( rule__TerminalGroup__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:774:1: ( ( rule__TerminalGroup__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:774:1: ( ( rule__TerminalGroup__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:775:1: ( rule__TerminalGroup__Group__0 )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:776:1: ( rule__TerminalGroup__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:776:2: rule__TerminalGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__0_in_ruleTerminalGroup1620);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:788:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:789:1: ( ruleTerminalToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:790:1: ruleTerminalToken EOF
            {
             before(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1647);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalToken1654); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:797:1: ruleTerminalToken : ( ( rule__TerminalToken__Group__0 ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:801:2: ( ( ( rule__TerminalToken__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:802:1: ( ( rule__TerminalToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:802:1: ( ( rule__TerminalToken__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:803:1: ( rule__TerminalToken__Group__0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:804:1: ( rule__TerminalToken__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:804:2: rule__TerminalToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__0_in_ruleTerminalToken1681);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:816:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:817:1: ( ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:818:1: ruleTerminalTokenElement EOF
            {
             before(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1708);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getTerminalTokenElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalTokenElement1715); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:825:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:829:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:830:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:830:1: ( ( rule__TerminalTokenElement__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:831:1: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:832:1: ( rule__TerminalTokenElement__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:832:2: rule__TerminalTokenElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1742);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:844:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:845:1: ( ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:846:1: ruleParenthesizedTerminalElement EOF
            {
             before(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1769);
            ruleParenthesizedTerminalElement();
            _fsp--;

             after(grammarAccess.getParenthesizedTerminalElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement1776); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:853:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:857:2: ( ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:858:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:858:1: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:859:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:860:1: ( rule__ParenthesizedTerminalElement__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:860:2: rule__ParenthesizedTerminalElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__0_in_ruleParenthesizedTerminalElement1803);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:872:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:873:1: ( ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:874:1: ruleAbstractNegatedToken EOF
            {
             before(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1830);
            ruleAbstractNegatedToken();
            _fsp--;

             after(grammarAccess.getAbstractNegatedTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractNegatedToken1837); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:881:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:885:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:886:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:886:1: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:887:1: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:888:1: ( rule__AbstractNegatedToken__Alternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:888:2: rule__AbstractNegatedToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1864);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:900:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:901:1: ( ruleNegatedToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:902:1: ruleNegatedToken EOF
            {
             before(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1891);
            ruleNegatedToken();
            _fsp--;

             after(grammarAccess.getNegatedTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegatedToken1898); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:909:1: ruleNegatedToken : ( ( rule__NegatedToken__Group__0 ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:913:2: ( ( ( rule__NegatedToken__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:914:1: ( ( rule__NegatedToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:914:1: ( ( rule__NegatedToken__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:915:1: ( rule__NegatedToken__Group__0 )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:916:1: ( rule__NegatedToken__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:916:2: rule__NegatedToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__0_in_ruleNegatedToken1925);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:928:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:929:1: ( ruleUntilToken EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:930:1: ruleUntilToken EOF
            {
             before(grammarAccess.getUntilTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_entryRuleUntilToken1952);
            ruleUntilToken();
            _fsp--;

             after(grammarAccess.getUntilTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUntilToken1959); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:937:1: ruleUntilToken : ( ( rule__UntilToken__Group__0 ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:941:2: ( ( ( rule__UntilToken__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:942:1: ( ( rule__UntilToken__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:942:1: ( ( rule__UntilToken__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:943:1: ( rule__UntilToken__Group__0 )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:944:1: ( rule__UntilToken__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:944:2: rule__UntilToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__0_in_ruleUntilToken1986);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:956:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:957:1: ( ruleWildcard EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:958:1: ruleWildcard EOF
            {
             before(grammarAccess.getWildcardRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_entryRuleWildcard2013);
            ruleWildcard();
            _fsp--;

             after(grammarAccess.getWildcardRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcard2020); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:965:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:969:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:970:1: ( ( rule__Wildcard__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:970:1: ( ( rule__Wildcard__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:971:1: ( rule__Wildcard__Group__0 )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:972:1: ( rule__Wildcard__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:972:2: rule__Wildcard__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__0_in_ruleWildcard2047);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:984:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:985:1: ( ruleCharacterRange EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:986:1: ruleCharacterRange EOF
            {
             before(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2074);
            ruleCharacterRange();
            _fsp--;

             after(grammarAccess.getCharacterRangeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCharacterRange2081); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:993:1: ruleCharacterRange : ( ( rule__CharacterRange__Group__0 ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:997:2: ( ( ( rule__CharacterRange__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:998:1: ( ( rule__CharacterRange__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:998:1: ( ( rule__CharacterRange__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:999:1: ( rule__CharacterRange__Group__0 )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1000:1: ( rule__CharacterRange__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1000:2: rule__CharacterRange__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__0_in_ruleCharacterRange2108);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1012:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1013:1: ( ruleEnumRule EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1014:1: ruleEnumRule EOF
            {
             before(grammarAccess.getEnumRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_entryRuleEnumRule2135);
            ruleEnumRule();
            _fsp--;

             after(grammarAccess.getEnumRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumRule2142); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1021:1: ruleEnumRule : ( ( rule__EnumRule__Group__0 ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1025:2: ( ( ( rule__EnumRule__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1026:1: ( ( rule__EnumRule__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1026:1: ( ( rule__EnumRule__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1027:1: ( rule__EnumRule__Group__0 )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1028:1: ( rule__EnumRule__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1028:2: rule__EnumRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__0_in_ruleEnumRule2169);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1040:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1041:1: ( ruleEnumLiterals EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1042:1: ruleEnumLiterals EOF
            {
             before(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2196);
            ruleEnumLiterals();
            _fsp--;

             after(grammarAccess.getEnumLiteralsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiterals2203); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1049:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group__0 ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1053:2: ( ( ( rule__EnumLiterals__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1054:1: ( ( rule__EnumLiterals__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1054:1: ( ( rule__EnumLiterals__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1055:1: ( rule__EnumLiterals__Group__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1056:1: ( rule__EnumLiterals__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1056:2: rule__EnumLiterals__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__0_in_ruleEnumLiterals2230);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1068:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1069:1: ( ruleEnumLiteralDeclaration EOF )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1070:1: ruleEnumLiteralDeclaration EOF
            {
             before(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2257);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration2264); 

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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1077:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group__0 ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1081:2: ( ( ( rule__EnumLiteralDeclaration__Group__0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1082:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1082:1: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1083:1: ( rule__EnumLiteralDeclaration__Group__0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1084:1: ( rule__EnumLiteralDeclaration__Group__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1084:2: rule__EnumLiteralDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__0_in_ruleEnumLiteralDeclaration2291);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1096:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1100:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
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
                    new NoViableAltException("1096:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1101:1: ( ruleParserRule )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1101:1: ( ruleParserRule )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1102:1: ruleParserRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_rule__AbstractRule__Alternatives2327);
                    ruleParserRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1107:6: ( ruleTerminalRule )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1107:6: ( ruleTerminalRule )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1108:1: ruleTerminalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_rule__AbstractRule__Alternatives2344);
                    ruleTerminalRule();
                    _fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1113:6: ( ruleEnumRule )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1113:6: ( ruleEnumRule )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1114:1: ruleEnumRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_rule__AbstractRule__Alternatives2361);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1124:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1128:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
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
                    new NoViableAltException("1124:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1129:1: ( ruleGeneratedMetamodel )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1129:1: ( ruleGeneratedMetamodel )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1130:1: ruleGeneratedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2393);
                    ruleGeneratedMetamodel();
                    _fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1135:6: ( ruleReferencedMetamodel )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1135:6: ( ruleReferencedMetamodel )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1136:1: ruleReferencedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2410);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1146:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1150:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) )
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
                    new NoViableAltException("1146:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1151:1: ( ruleAbstractTokenWithCardinality )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1151:1: ( ruleAbstractTokenWithCardinality )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1152:1: ruleAbstractTokenWithCardinality
                    {
                     before(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_rule__AbstractToken__Alternatives2442);
                    ruleAbstractTokenWithCardinality();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1157:6: ( ruleAction )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1157:6: ( ruleAction )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1158:1: ruleAction
                    {
                     before(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_rule__AbstractToken__Alternatives2459);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1168:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1172:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
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
                        new NoViableAltException("1168:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==RULE_STRING||LA4_0==20) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1168:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1173:1: ( ruleAssignment )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1173:1: ( ruleAssignment )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1174:1: ruleAssignment
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_rule__AbstractTokenWithCardinality__Alternatives_02491);
                    ruleAssignment();
                    _fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1179:6: ( ruleAbstractTerminal )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1179:6: ( ruleAbstractTerminal )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1180:1: ruleAbstractTerminal
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_rule__AbstractTokenWithCardinality__Alternatives_02508);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1190:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1194:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    new NoViableAltException("1190:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1195:1: ( '?' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1195:1: ( '?' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1196:1: '?'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02541); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1203:6: ( '*' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1203:6: ( '*' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1204:1: '*'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02561); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1211:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1211:6: ( '+' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1212:1: '+'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02581); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1224:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1228:1: ( ( '=' ) | ( '+=' ) )
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
                    new NoViableAltException("1224:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1229:1: ( '=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1229:1: ( '=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1230:1: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Action__OperatorAlternatives_2_2_02616); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1237:6: ( '+=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1237:6: ( '+=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1238:1: '+='
                    {
                     before(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Action__OperatorAlternatives_2_2_02636); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1250:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1254:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) )
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
                    new NoViableAltException("1250:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1255:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1255:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1256:1: ruleKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__AbstractTerminal__Alternatives2670);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1261:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1261:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1262:1: ruleRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__AbstractTerminal__Alternatives2687);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1267:6: ( ruleParenthesizedElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1267:6: ( ruleParenthesizedElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1268:1: ruleParenthesizedElement
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_rule__AbstractTerminal__Alternatives2704);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1278:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1282:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
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
                    new NoViableAltException("1278:1: rule__Assignment__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1283:1: ( '+=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1283:1: ( '+=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1284:1: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Assignment__OperatorAlternatives_1_02737); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1291:6: ( '=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1291:6: ( '=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1292:1: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Assignment__OperatorAlternatives_1_02757); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1299:6: ( '?=' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1299:6: ( '?=' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1300:1: '?='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2()); 
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__Assignment__OperatorAlternatives_1_02777); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1312:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1316:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
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
                    new NoViableAltException("1312:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1317:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1317:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1318:1: ruleKeyword
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__AssignableTerminal__Alternatives2811);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1323:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1323:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1324:1: ruleRuleCall
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__AssignableTerminal__Alternatives2828);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1329:6: ( ruleParenthesizedAssignableElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1329:6: ( ruleParenthesizedAssignableElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1330:1: ruleParenthesizedAssignableElement
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_rule__AssignableTerminal__Alternatives2845);
                    ruleParenthesizedAssignableElement();
                    _fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1335:6: ( ruleCrossReference )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1335:6: ( ruleCrossReference )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1336:1: ruleCrossReference
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_rule__AssignableTerminal__Alternatives2862);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1346:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1350:1: ( ( ruleKeyword ) | ( ruleRuleCall ) )
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
                    new NoViableAltException("1346:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1351:1: ( ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1351:1: ( ruleKeyword )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1352:1: ruleKeyword
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CrossReferenceableTerminal__Alternatives2894);
                    ruleKeyword();
                    _fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1357:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1357:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1358:1: ruleRuleCall
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__CrossReferenceableTerminal__Alternatives2911);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1368:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__TerminalToken__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1372:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
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
                    new NoViableAltException("1368:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1373:1: ( '?' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1373:1: ( '?' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1374:1: '?'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_02944); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1381:6: ( '*' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1381:6: ( '*' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1382:1: '*'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_02964); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1389:6: ( '+' )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1389:6: ( '+' )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1390:1: '+'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_02984); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1402:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1406:1: ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) )
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
                    new NoViableAltException("1402:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1407:1: ( ruleCharacterRange )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1407:1: ( ruleCharacterRange )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1408:1: ruleCharacterRange
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3018);
                    ruleCharacterRange();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1413:6: ( ruleRuleCall )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1413:6: ( ruleRuleCall )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1414:1: ruleRuleCall
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3035);
                    ruleRuleCall();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1419:6: ( ruleParenthesizedTerminalElement )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1419:6: ( ruleParenthesizedTerminalElement )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1420:1: ruleParenthesizedTerminalElement
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3052);
                    ruleParenthesizedTerminalElement();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1425:6: ( ruleAbstractNegatedToken )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1425:6: ( ruleAbstractNegatedToken )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1426:1: ruleAbstractNegatedToken
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3069);
                    ruleAbstractNegatedToken();
                    _fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1431:6: ( ruleWildcard )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1431:6: ( ruleWildcard )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1432:1: ruleWildcard
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3086);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1442:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1446:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
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
                    new NoViableAltException("1442:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1447:1: ( ruleNegatedToken )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1447:1: ( ruleNegatedToken )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1448:1: ruleNegatedToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3118);
                    ruleNegatedToken();
                    _fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1453:6: ( ruleUntilToken )
                    {
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1453:6: ( ruleUntilToken )
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1454:1: ruleUntilToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3135);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1466:1: rule__Grammar__Group__0 : ( 'grammar' ) rule__Grammar__Group__1 ;
    public final void rule__Grammar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1470:1: ( ( 'grammar' ) rule__Grammar__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1471:1: ( 'grammar' ) rule__Grammar__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1471:1: ( 'grammar' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1472:1: 'grammar'
            {
             before(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Grammar__Group__03170); 
             after(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__1_in_rule__Grammar__Group__03180);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1486:1: rule__Grammar__Group__1 : ( ( rule__Grammar__NameAssignment_1 ) ) rule__Grammar__Group__2 ;
    public final void rule__Grammar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1490:1: ( ( ( rule__Grammar__NameAssignment_1 ) ) rule__Grammar__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1491:1: ( ( rule__Grammar__NameAssignment_1 ) ) rule__Grammar__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1491:1: ( ( rule__Grammar__NameAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1492:1: ( rule__Grammar__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1493:1: ( rule__Grammar__NameAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1493:2: rule__Grammar__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__NameAssignment_1_in_rule__Grammar__Group__13208);
            rule__Grammar__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__2_in_rule__Grammar__Group__13217);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1504:1: rule__Grammar__Group__2 : ( ( rule__Grammar__Group_2__0 )? ) rule__Grammar__Group__3 ;
    public final void rule__Grammar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1508:1: ( ( ( rule__Grammar__Group_2__0 )? ) rule__Grammar__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1509:1: ( ( rule__Grammar__Group_2__0 )? ) rule__Grammar__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1509:1: ( ( rule__Grammar__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1510:1: ( rule__Grammar__Group_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1511:1: ( rule__Grammar__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1511:2: rule__Grammar__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__0_in_rule__Grammar__Group__23245);
                    rule__Grammar__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__3_in_rule__Grammar__Group__23255);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1522:1: rule__Grammar__Group__3 : ( ( rule__Grammar__Group_3__0 )? ) rule__Grammar__Group__4 ;
    public final void rule__Grammar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1526:1: ( ( ( rule__Grammar__Group_3__0 )? ) rule__Grammar__Group__4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1527:1: ( ( rule__Grammar__Group_3__0 )? ) rule__Grammar__Group__4
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1527:1: ( ( rule__Grammar__Group_3__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1528:1: ( rule__Grammar__Group_3__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1529:1: ( rule__Grammar__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==41) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1529:2: rule__Grammar__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__0_in_rule__Grammar__Group__33283);
                    rule__Grammar__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__4_in_rule__Grammar__Group__33293);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1540:1: rule__Grammar__Group__4 : ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) rule__Grammar__Group__5 ;
    public final void rule__Grammar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1544:1: ( ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) rule__Grammar__Group__5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1545:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) rule__Grammar__Group__5
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1545:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1546:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1547:1: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23||LA16_0==25) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1547:2: rule__Grammar__MetamodelDeclarationsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__MetamodelDeclarationsAssignment_4_in_rule__Grammar__Group__43321);
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

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group__5_in_rule__Grammar__Group__43331);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1558:1: rule__Grammar__Group__5 : ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) ;
    public final void rule__Grammar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1562:1: ( ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1563:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1563:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1564:1: ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1564:1: ( ( rule__Grammar__RulesAssignment_5 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1565:1: ( rule__Grammar__RulesAssignment_5 )
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1566:1: ( rule__Grammar__RulesAssignment_5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1566:2: rule__Grammar__RulesAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__53361);
            rule__Grammar__RulesAssignment_5();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1569:1: ( ( rule__Grammar__RulesAssignment_5 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1570:1: ( rule__Grammar__RulesAssignment_5 )*
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1571:1: ( rule__Grammar__RulesAssignment_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID||LA17_0==36||LA17_0==40) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1571:2: rule__Grammar__RulesAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__53373);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1594:1: rule__Grammar__Group_2__0 : ( 'with' ) rule__Grammar__Group_2__1 ;
    public final void rule__Grammar__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1598:1: ( ( 'with' ) rule__Grammar__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1599:1: ( 'with' ) rule__Grammar__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1599:1: ( 'with' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1600:1: 'with'
            {
             before(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Grammar__Group_2__03423); 
             after(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__1_in_rule__Grammar__Group_2__03433);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1614:1: rule__Grammar__Group_2__1 : ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) rule__Grammar__Group_2__2 ;
    public final void rule__Grammar__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1618:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) rule__Grammar__Group_2__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1619:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) rule__Grammar__Group_2__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1619:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1620:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1621:1: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1621:2: rule__Grammar__UsedGrammarsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_1_in_rule__Grammar__Group_2__13461);
            rule__Grammar__UsedGrammarsAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2__2_in_rule__Grammar__Group_2__13470);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1632:1: rule__Grammar__Group_2__2 : ( ( rule__Grammar__Group_2_2__0 )* ) ;
    public final void rule__Grammar__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1636:1: ( ( ( rule__Grammar__Group_2_2__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1637:1: ( ( rule__Grammar__Group_2_2__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1637:1: ( ( rule__Grammar__Group_2_2__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1638:1: ( rule__Grammar__Group_2_2__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1639:1: ( rule__Grammar__Group_2_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1639:2: rule__Grammar__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__0_in_rule__Grammar__Group_2__23498);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1655:1: rule__Grammar__Group_2_2__0 : ( ',' ) rule__Grammar__Group_2_2__1 ;
    public final void rule__Grammar__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1659:1: ( ( ',' ) rule__Grammar__Group_2_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1660:1: ( ',' ) rule__Grammar__Group_2_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1660:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1661:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Grammar__Group_2_2__03540); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_2_2__1_in_rule__Grammar__Group_2_2__03550);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1675:1: rule__Grammar__Group_2_2__1 : ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) ;
    public final void rule__Grammar__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1679:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1680:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1680:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1681:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1682:1: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1682:2: rule__Grammar__UsedGrammarsAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_2_1_in_rule__Grammar__Group_2_2__13578);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1696:1: rule__Grammar__Group_3__0 : ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) rule__Grammar__Group_3__1 ;
    public final void rule__Grammar__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1700:1: ( ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) rule__Grammar__Group_3__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1701:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) rule__Grammar__Group_3__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1701:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1702:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1703:1: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1703:2: rule__Grammar__DefinesHiddenTokensAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__DefinesHiddenTokensAssignment_3_0_in_rule__Grammar__Group_3__03616);
            rule__Grammar__DefinesHiddenTokensAssignment_3_0();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__1_in_rule__Grammar__Group_3__03625);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1714:1: rule__Grammar__Group_3__1 : ( '(' ) rule__Grammar__Group_3__2 ;
    public final void rule__Grammar__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1718:1: ( ( '(' ) rule__Grammar__Group_3__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1719:1: ( '(' ) rule__Grammar__Group_3__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1719:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1720:1: '('
            {
             before(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Grammar__Group_3__13654); 
             after(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__2_in_rule__Grammar__Group_3__13664);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1734:1: rule__Grammar__Group_3__2 : ( ( rule__Grammar__Group_3_2__0 )? ) rule__Grammar__Group_3__3 ;
    public final void rule__Grammar__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1738:1: ( ( ( rule__Grammar__Group_3_2__0 )? ) rule__Grammar__Group_3__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1739:1: ( ( rule__Grammar__Group_3_2__0 )? ) rule__Grammar__Group_3__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1739:1: ( ( rule__Grammar__Group_3_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1740:1: ( rule__Grammar__Group_3_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1741:1: ( rule__Grammar__Group_3_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1741:2: rule__Grammar__Group_3_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__0_in_rule__Grammar__Group_3__23692);
                    rule__Grammar__Group_3_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_3_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3__3_in_rule__Grammar__Group_3__23702);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1752:1: rule__Grammar__Group_3__3 : ( ')' ) ;
    public final void rule__Grammar__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1756:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1757:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1757:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1758:1: ')'
            {
             before(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Grammar__Group_3__33731); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1779:1: rule__Grammar__Group_3_2__0 : ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) rule__Grammar__Group_3_2__1 ;
    public final void rule__Grammar__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1783:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) rule__Grammar__Group_3_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1784:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) rule__Grammar__Group_3_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1784:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1785:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1786:1: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1786:2: rule__Grammar__HiddenTokensAssignment_3_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_0_in_rule__Grammar__Group_3_2__03774);
            rule__Grammar__HiddenTokensAssignment_3_2_0();
            _fsp--;


            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2__1_in_rule__Grammar__Group_3_2__03783);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1797:1: rule__Grammar__Group_3_2__1 : ( ( rule__Grammar__Group_3_2_1__0 )* ) ;
    public final void rule__Grammar__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1801:1: ( ( ( rule__Grammar__Group_3_2_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1802:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1802:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1803:1: ( rule__Grammar__Group_3_2_1__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1804:1: ( rule__Grammar__Group_3_2_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==19) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1804:2: rule__Grammar__Group_3_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__0_in_rule__Grammar__Group_3_2__13811);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1818:1: rule__Grammar__Group_3_2_1__0 : ( ',' ) rule__Grammar__Group_3_2_1__1 ;
    public final void rule__Grammar__Group_3_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1822:1: ( ( ',' ) rule__Grammar__Group_3_2_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1823:1: ( ',' ) rule__Grammar__Group_3_2_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1823:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1824:1: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Grammar__Group_3_2_1__03851); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Grammar__Group_3_2_1__1_in_rule__Grammar__Group_3_2_1__03861);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1838:1: rule__Grammar__Group_3_2_1__1 : ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) ;
    public final void rule__Grammar__Group_3_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1842:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1843:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1843:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1844:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1845:1: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1845:2: rule__Grammar__HiddenTokensAssignment_3_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_1_1_in_rule__Grammar__Group_3_2_1__13889);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1859:1: rule__GrammarID__Group__0 : ( RULE_ID ) rule__GrammarID__Group__1 ;
    public final void rule__GrammarID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1863:1: ( ( RULE_ID ) rule__GrammarID__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1864:1: ( RULE_ID ) rule__GrammarID__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1864:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1865:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GrammarID__Group__03927); 
             after(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group__1_in_rule__GrammarID__Group__03935);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1877:1: rule__GrammarID__Group__1 : ( ( rule__GrammarID__Group_1__0 )* ) ;
    public final void rule__GrammarID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1881:1: ( ( ( rule__GrammarID__Group_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1882:1: ( ( rule__GrammarID__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1882:1: ( ( rule__GrammarID__Group_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1883:1: ( rule__GrammarID__Group_1__0 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1884:1: ( rule__GrammarID__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1884:2: rule__GrammarID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__0_in_rule__GrammarID__Group__13963);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1898:1: rule__GrammarID__Group_1__0 : ( '.' ) rule__GrammarID__Group_1__1 ;
    public final void rule__GrammarID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1902:1: ( ( '.' ) rule__GrammarID__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1903:1: ( '.' ) rule__GrammarID__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1903:1: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1904:1: '.'
            {
             before(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__GrammarID__Group_1__04003); 
             after(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GrammarID__Group_1__1_in_rule__GrammarID__Group_1__04013);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1918:1: rule__GrammarID__Group_1__1 : ( RULE_ID ) ;
    public final void rule__GrammarID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1922:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1923:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1923:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1924:1: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GrammarID__Group_1__14041); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1939:1: rule__GeneratedMetamodel__Group__0 : ( 'generate' ) rule__GeneratedMetamodel__Group__1 ;
    public final void rule__GeneratedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1943:1: ( ( 'generate' ) rule__GeneratedMetamodel__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1944:1: ( 'generate' ) rule__GeneratedMetamodel__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1944:1: ( 'generate' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1945:1: 'generate'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__GeneratedMetamodel__Group__04079); 
             after(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__1_in_rule__GeneratedMetamodel__Group__04089);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1959:1: rule__GeneratedMetamodel__Group__1 : ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) rule__GeneratedMetamodel__Group__2 ;
    public final void rule__GeneratedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1963:1: ( ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) rule__GeneratedMetamodel__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1964:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) rule__GeneratedMetamodel__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1964:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1965:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1966:1: ( rule__GeneratedMetamodel__NameAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1966:2: rule__GeneratedMetamodel__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__NameAssignment_1_in_rule__GeneratedMetamodel__Group__14117);
            rule__GeneratedMetamodel__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__2_in_rule__GeneratedMetamodel__Group__14126);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1977:1: rule__GeneratedMetamodel__Group__2 : ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) rule__GeneratedMetamodel__Group__3 ;
    public final void rule__GeneratedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1981:1: ( ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) rule__GeneratedMetamodel__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1982:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) rule__GeneratedMetamodel__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1982:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1983:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1984:1: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1984:2: rule__GeneratedMetamodel__EPackageAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__EPackageAssignment_2_in_rule__GeneratedMetamodel__Group__24154);
            rule__GeneratedMetamodel__EPackageAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group__3_in_rule__GeneratedMetamodel__Group__24163);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1995:1: rule__GeneratedMetamodel__Group__3 : ( ( rule__GeneratedMetamodel__Group_3__0 )? ) ;
    public final void rule__GeneratedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:1999:1: ( ( ( rule__GeneratedMetamodel__Group_3__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2000:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2000:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2001:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2002:1: ( rule__GeneratedMetamodel__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2002:2: rule__GeneratedMetamodel__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__0_in_rule__GeneratedMetamodel__Group__34191);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2020:1: rule__GeneratedMetamodel__Group_3__0 : ( 'as' ) rule__GeneratedMetamodel__Group_3__1 ;
    public final void rule__GeneratedMetamodel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2024:1: ( ( 'as' ) rule__GeneratedMetamodel__Group_3__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2025:1: ( 'as' ) rule__GeneratedMetamodel__Group_3__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2025:1: ( 'as' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2026:1: 'as'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__GeneratedMetamodel__Group_3__04235); 
             after(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__Group_3__1_in_rule__GeneratedMetamodel__Group_3__04245);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2040:1: rule__GeneratedMetamodel__Group_3__1 : ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2044:1: ( ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2045:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2045:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2046:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2047:1: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2047:2: rule__GeneratedMetamodel__AliasAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedMetamodel__AliasAssignment_3_1_in_rule__GeneratedMetamodel__Group_3__14273);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2061:1: rule__ReferencedMetamodel__Group__0 : ( 'import' ) rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2065:1: ( ( 'import' ) rule__ReferencedMetamodel__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2066:1: ( 'import' ) rule__ReferencedMetamodel__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2066:1: ( 'import' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2067:1: 'import'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__ReferencedMetamodel__Group__04312); 
             after(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__04322);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2081:1: rule__ReferencedMetamodel__Group__1 : ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2085:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) rule__ReferencedMetamodel__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2086:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) rule__ReferencedMetamodel__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2086:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2087:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2088:1: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2088:2: rule__ReferencedMetamodel__EPackageAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_1_in_rule__ReferencedMetamodel__Group__14350);
            rule__ReferencedMetamodel__EPackageAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__14359);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2099:1: rule__ReferencedMetamodel__Group__2 : ( ( rule__ReferencedMetamodel__Group_2__0 )? ) ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2103:1: ( ( ( rule__ReferencedMetamodel__Group_2__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2104:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2104:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2105:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2106:1: ( rule__ReferencedMetamodel__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==24) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2106:2: rule__ReferencedMetamodel__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__0_in_rule__ReferencedMetamodel__Group__24387);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2122:1: rule__ReferencedMetamodel__Group_2__0 : ( 'as' ) rule__ReferencedMetamodel__Group_2__1 ;
    public final void rule__ReferencedMetamodel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2126:1: ( ( 'as' ) rule__ReferencedMetamodel__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2127:1: ( 'as' ) rule__ReferencedMetamodel__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2127:1: ( 'as' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2128:1: 'as'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__ReferencedMetamodel__Group_2__04429); 
             after(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__Group_2__1_in_rule__ReferencedMetamodel__Group_2__04439);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2142:1: rule__ReferencedMetamodel__Group_2__1 : ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2146:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2147:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2147:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2148:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2149:1: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2149:2: rule__ReferencedMetamodel__AliasAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferencedMetamodel__AliasAssignment_2_1_in_rule__ReferencedMetamodel__Group_2__14467);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2163:1: rule__ParserRule__Group__0 : ( ( rule__ParserRule__NameAssignment_0 ) ) rule__ParserRule__Group__1 ;
    public final void rule__ParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2167:1: ( ( ( rule__ParserRule__NameAssignment_0 ) ) rule__ParserRule__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2168:1: ( ( rule__ParserRule__NameAssignment_0 ) ) rule__ParserRule__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2168:1: ( ( rule__ParserRule__NameAssignment_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2169:1: ( rule__ParserRule__NameAssignment_0 )
            {
             before(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2170:1: ( rule__ParserRule__NameAssignment_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2170:2: rule__ParserRule__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__NameAssignment_0_in_rule__ParserRule__Group__04505);
            rule__ParserRule__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getNameAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__1_in_rule__ParserRule__Group__04514);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2181:1: rule__ParserRule__Group__1 : ( ( rule__ParserRule__Group_1__0 )? ) rule__ParserRule__Group__2 ;
    public final void rule__ParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2185:1: ( ( ( rule__ParserRule__Group_1__0 )? ) rule__ParserRule__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2186:1: ( ( rule__ParserRule__Group_1__0 )? ) rule__ParserRule__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2186:1: ( ( rule__ParserRule__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2187:1: ( rule__ParserRule__Group_1__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2188:1: ( rule__ParserRule__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==28) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2188:2: rule__ParserRule__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__0_in_rule__ParserRule__Group__14542);
                    rule__ParserRule__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__2_in_rule__ParserRule__Group__14552);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2199:1: rule__ParserRule__Group__2 : ( ( rule__ParserRule__Group_2__0 )? ) rule__ParserRule__Group__3 ;
    public final void rule__ParserRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2203:1: ( ( ( rule__ParserRule__Group_2__0 )? ) rule__ParserRule__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2204:1: ( ( rule__ParserRule__Group_2__0 )? ) rule__ParserRule__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2204:1: ( ( rule__ParserRule__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2205:1: ( rule__ParserRule__Group_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2206:1: ( rule__ParserRule__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==41) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2206:2: rule__ParserRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__0_in_rule__ParserRule__Group__24580);
                    rule__ParserRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__3_in_rule__ParserRule__Group__24590);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2217:1: rule__ParserRule__Group__3 : ( ':' ) rule__ParserRule__Group__4 ;
    public final void rule__ParserRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2221:1: ( ( ':' ) rule__ParserRule__Group__4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2222:1: ( ':' ) rule__ParserRule__Group__4
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2222:1: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2223:1: ':'
            {
             before(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__ParserRule__Group__34619); 
             after(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__4_in_rule__ParserRule__Group__34629);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2237:1: rule__ParserRule__Group__4 : ( ( rule__ParserRule__AlternativesAssignment_4 ) ) rule__ParserRule__Group__5 ;
    public final void rule__ParserRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2241:1: ( ( ( rule__ParserRule__AlternativesAssignment_4 ) ) rule__ParserRule__Group__5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2242:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) ) rule__ParserRule__Group__5
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2242:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2243:1: ( rule__ParserRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2244:1: ( rule__ParserRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2244:2: rule__ParserRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__AlternativesAssignment_4_in_rule__ParserRule__Group__44657);
            rule__ParserRule__AlternativesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group__5_in_rule__ParserRule__Group__44666);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2255:1: rule__ParserRule__Group__5 : ( ';' ) ;
    public final void rule__ParserRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2259:1: ( ( ';' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2260:1: ( ';' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2260:1: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2261:1: ';'
            {
             before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__ParserRule__Group__54695); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2286:1: rule__ParserRule__Group_1__0 : ( 'returns' ) rule__ParserRule__Group_1__1 ;
    public final void rule__ParserRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2290:1: ( ( 'returns' ) rule__ParserRule__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2291:1: ( 'returns' ) rule__ParserRule__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2291:1: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2292:1: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__ParserRule__Group_1__04743); 
             after(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_1__1_in_rule__ParserRule__Group_1__04753);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2306:1: rule__ParserRule__Group_1__1 : ( ( rule__ParserRule__TypeAssignment_1_1 ) ) ;
    public final void rule__ParserRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2310:1: ( ( ( rule__ParserRule__TypeAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2311:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2311:1: ( ( rule__ParserRule__TypeAssignment_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2312:1: ( rule__ParserRule__TypeAssignment_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2313:1: ( rule__ParserRule__TypeAssignment_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2313:2: rule__ParserRule__TypeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__TypeAssignment_1_1_in_rule__ParserRule__Group_1__14781);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2327:1: rule__ParserRule__Group_2__0 : ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) rule__ParserRule__Group_2__1 ;
    public final void rule__ParserRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2331:1: ( ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) rule__ParserRule__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2332:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) rule__ParserRule__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2332:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2333:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2334:1: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2334:2: rule__ParserRule__DefinesHiddenTokensAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__DefinesHiddenTokensAssignment_2_0_in_rule__ParserRule__Group_2__04819);
            rule__ParserRule__DefinesHiddenTokensAssignment_2_0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__1_in_rule__ParserRule__Group_2__04828);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2345:1: rule__ParserRule__Group_2__1 : ( '(' ) rule__ParserRule__Group_2__2 ;
    public final void rule__ParserRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2349:1: ( ( '(' ) rule__ParserRule__Group_2__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2350:1: ( '(' ) rule__ParserRule__Group_2__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2350:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2351:1: '('
            {
             before(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParserRule__Group_2__14857); 
             after(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__2_in_rule__ParserRule__Group_2__14867);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2365:1: rule__ParserRule__Group_2__2 : ( ( rule__ParserRule__Group_2_2__0 )? ) rule__ParserRule__Group_2__3 ;
    public final void rule__ParserRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2369:1: ( ( ( rule__ParserRule__Group_2_2__0 )? ) rule__ParserRule__Group_2__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2370:1: ( ( rule__ParserRule__Group_2_2__0 )? ) rule__ParserRule__Group_2__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2370:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2371:1: ( rule__ParserRule__Group_2_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2372:1: ( rule__ParserRule__Group_2_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2372:2: rule__ParserRule__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__0_in_rule__ParserRule__Group_2__24895);
                    rule__ParserRule__Group_2_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_2_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2__3_in_rule__ParserRule__Group_2__24905);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2383:1: rule__ParserRule__Group_2__3 : ( ')' ) ;
    public final void rule__ParserRule__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2387:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2388:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2388:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2389:1: ')'
            {
             before(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParserRule__Group_2__34934); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2410:1: rule__ParserRule__Group_2_2__0 : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) rule__ParserRule__Group_2_2__1 ;
    public final void rule__ParserRule__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2414:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) rule__ParserRule__Group_2_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2415:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) rule__ParserRule__Group_2_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2415:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2416:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2417:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2417:2: rule__ParserRule__HiddenTokensAssignment_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_0_in_rule__ParserRule__Group_2_2__04977);
            rule__ParserRule__HiddenTokensAssignment_2_2_0();
            _fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2__1_in_rule__ParserRule__Group_2_2__04986);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2428:1: rule__ParserRule__Group_2_2__1 : ( ( rule__ParserRule__Group_2_2_1__0 )* ) ;
    public final void rule__ParserRule__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2432:1: ( ( ( rule__ParserRule__Group_2_2_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2433:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2433:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2434:1: ( rule__ParserRule__Group_2_2_1__0 )*
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2435:1: ( rule__ParserRule__Group_2_2_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==19) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2435:2: rule__ParserRule__Group_2_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__0_in_rule__ParserRule__Group_2_2__15014);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2449:1: rule__ParserRule__Group_2_2_1__0 : ( ',' ) rule__ParserRule__Group_2_2_1__1 ;
    public final void rule__ParserRule__Group_2_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2453:1: ( ( ',' ) rule__ParserRule__Group_2_2_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2454:1: ( ',' ) rule__ParserRule__Group_2_2_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2454:1: ( ',' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2455:1: ','
            {
             before(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__ParserRule__Group_2_2_1__05054); 
             after(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__Group_2_2_1__1_in_rule__ParserRule__Group_2_2_1__05064);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2469:1: rule__ParserRule__Group_2_2_1__1 : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_2_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2473:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2474:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2474:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2475:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2476:1: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2476:2: rule__ParserRule__HiddenTokensAssignment_2_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_1_1_in_rule__ParserRule__Group_2_2_1__15092);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2490:1: rule__TypeRef__Group__0 : ( ( rule__TypeRef__Group_0__0 )? ) rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2494:1: ( ( ( rule__TypeRef__Group_0__0 )? ) rule__TypeRef__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2495:1: ( ( rule__TypeRef__Group_0__0 )? ) rule__TypeRef__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2495:1: ( ( rule__TypeRef__Group_0__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2496:1: ( rule__TypeRef__Group_0__0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2497:1: ( rule__TypeRef__Group_0__0 )?
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
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2497:2: rule__TypeRef__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__0_in_rule__TypeRef__Group__05130);
                    rule__TypeRef__Group_0__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeRefAccess().getGroup_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group__1_in_rule__TypeRef__Group__05140);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2508:1: rule__TypeRef__Group__1 : ( ( rule__TypeRef__ClassifierAssignment_1 ) ) ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2512:1: ( ( ( rule__TypeRef__ClassifierAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2513:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2513:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2514:1: ( rule__TypeRef__ClassifierAssignment_1 )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2515:1: ( rule__TypeRef__ClassifierAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2515:2: rule__TypeRef__ClassifierAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__ClassifierAssignment_1_in_rule__TypeRef__Group__15168);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2529:1: rule__TypeRef__Group_0__0 : ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) rule__TypeRef__Group_0__1 ;
    public final void rule__TypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2533:1: ( ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) rule__TypeRef__Group_0__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2534:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) rule__TypeRef__Group_0__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2534:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2535:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2536:1: ( rule__TypeRef__MetamodelAssignment_0_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2536:2: rule__TypeRef__MetamodelAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__MetamodelAssignment_0_0_in_rule__TypeRef__Group_0__05206);
            rule__TypeRef__MetamodelAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TypeRef__Group_0__1_in_rule__TypeRef__Group_0__05215);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2547:1: rule__TypeRef__Group_0__1 : ( '::' ) ;
    public final void rule__TypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2551:1: ( ( '::' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2552:1: ( '::' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2552:1: ( '::' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2553:1: '::'
            {
             before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__TypeRef__Group_0__15244); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2570:1: rule__Alternatives__Group__0 : ( ruleGroup ) rule__Alternatives__Group__1 ;
    public final void rule__Alternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2574:1: ( ( ruleGroup ) rule__Alternatives__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2575:1: ( ruleGroup ) rule__Alternatives__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2575:1: ( ruleGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2576:1: ruleGroup
            {
             before(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_rule__Alternatives__Group__05283);
            ruleGroup();
            _fsp--;

             after(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group__1_in_rule__Alternatives__Group__05291);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2588:1: rule__Alternatives__Group__1 : ( ( rule__Alternatives__Group_1__0 )? ) ;
    public final void rule__Alternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2592:1: ( ( ( rule__Alternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2593:1: ( ( rule__Alternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2593:1: ( ( rule__Alternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2594:1: ( rule__Alternatives__Group_1__0 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2595:1: ( rule__Alternatives__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==30) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2595:2: rule__Alternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__0_in_rule__Alternatives__Group__15319);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2609:1: rule__Alternatives__Group_1__0 : ( () ) rule__Alternatives__Group_1__1 ;
    public final void rule__Alternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2613:1: ( ( () ) rule__Alternatives__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2614:1: ( () ) rule__Alternatives__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2614:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2615:1: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2616:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2618:1: 
            {
            }

             after(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1__1_in_rule__Alternatives__Group_1__05368);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2629:1: rule__Alternatives__Group_1__1 : ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) ;
    public final void rule__Alternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2633:1: ( ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2634:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2634:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2635:1: ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2635:1: ( ( rule__Alternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2636:1: ( rule__Alternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2637:1: ( rule__Alternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2637:2: rule__Alternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__15398);
            rule__Alternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2640:1: ( ( rule__Alternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2641:1: ( rule__Alternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2642:1: ( rule__Alternatives__Group_1_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==30) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2642:2: rule__Alternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__15410);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2657:1: rule__Alternatives__Group_1_1__0 : ( '|' ) rule__Alternatives__Group_1_1__1 ;
    public final void rule__Alternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2661:1: ( ( '|' ) rule__Alternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2662:1: ( '|' ) rule__Alternatives__Group_1_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2662:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2663:1: '|'
            {
             before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__Alternatives__Group_1_1__05452); 
             after(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__Group_1_1__1_in_rule__Alternatives__Group_1_1__05462);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2677:1: rule__Alternatives__Group_1_1__1 : ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__Alternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2681:1: ( ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2682:1: ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2682:1: ( ( rule__Alternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2683:1: ( rule__Alternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2684:1: ( rule__Alternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2684:2: rule__Alternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Alternatives__GroupsAssignment_1_1_1_in_rule__Alternatives__Group_1_1__15490);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2698:1: rule__Group__Group__0 : ( ruleAbstractToken ) rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2702:1: ( ( ruleAbstractToken ) rule__Group__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2703:1: ( ruleAbstractToken ) rule__Group__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2703:1: ( ruleAbstractToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2704:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_rule__Group__Group__05528);
            ruleAbstractToken();
            _fsp--;

             after(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Group__Group__1_in_rule__Group__Group__05536);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2716:1: rule__Group__Group__1 : ( ( rule__Group__Group_1__0 )? ) ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2720:1: ( ( ( rule__Group__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2721:1: ( ( rule__Group__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2721:1: ( ( rule__Group__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2722:1: ( rule__Group__Group_1__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2723:1: ( rule__Group__Group_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_STRING)||LA31_0==20||LA31_0==31) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2723:2: rule__Group__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__0_in_rule__Group__Group__15564);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2737:1: rule__Group__Group_1__0 : ( () ) rule__Group__Group_1__1 ;
    public final void rule__Group__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2741:1: ( ( () ) rule__Group__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2742:1: ( () ) rule__Group__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2742:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2743:1: ()
            {
             before(grammarAccess.getGroupAccess().getGroupTokensAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2744:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2746:1: 
            {
            }

             after(grammarAccess.getGroupAccess().getGroupTokensAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Group__Group_1__1_in_rule__Group__Group_1__05613);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2757:1: rule__Group__Group_1__1 : ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) ) ;
    public final void rule__Group__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2761:1: ( ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2762:1: ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2762:1: ( ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2763:1: ( ( rule__Group__TokensAssignment_1_1 ) ) ( ( rule__Group__TokensAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2763:1: ( ( rule__Group__TokensAssignment_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2764:1: ( rule__Group__TokensAssignment_1_1 )
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2765:1: ( rule__Group__TokensAssignment_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2765:2: rule__Group__TokensAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__15643);
            rule__Group__TokensAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2768:1: ( ( rule__Group__TokensAssignment_1_1 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2769:1: ( rule__Group__TokensAssignment_1_1 )*
            {
             before(grammarAccess.getGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2770:1: ( rule__Group__TokensAssignment_1_1 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_STRING)||LA32_0==20||LA32_0==31) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2770:2: rule__Group__TokensAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__15655);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2785:1: rule__AbstractTokenWithCardinality__Group__0 : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) rule__AbstractTokenWithCardinality__Group__1 ;
    public final void rule__AbstractTokenWithCardinality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2789:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) rule__AbstractTokenWithCardinality__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2790:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) rule__AbstractTokenWithCardinality__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2790:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2791:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2792:1: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2792:2: rule__AbstractTokenWithCardinality__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group__05696);
            rule__AbstractTokenWithCardinality__Alternatives_0();
            _fsp--;


            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__Group__1_in_rule__AbstractTokenWithCardinality__Group__05705);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2803:1: rule__AbstractTokenWithCardinality__Group__1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2807:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2808:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2808:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2809:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2810:1: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=11 && LA33_0<=13)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2810:2: rule__AbstractTokenWithCardinality__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAssignment_1_in_rule__AbstractTokenWithCardinality__Group__15733);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2824:1: rule__Action__Group__0 : ( '{' ) rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2828:1: ( ( '{' ) rule__Action__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2829:1: ( '{' ) rule__Action__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2829:1: ( '{' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2830:1: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__Action__Group__05773); 
             after(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__1_in_rule__Action__Group__05783);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2844:1: rule__Action__Group__1 : ( ( rule__Action__TypeAssignment_1 ) ) rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2848:1: ( ( ( rule__Action__TypeAssignment_1 ) ) rule__Action__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2849:1: ( ( rule__Action__TypeAssignment_1 ) ) rule__Action__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2849:1: ( ( rule__Action__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2850:1: ( rule__Action__TypeAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2851:1: ( rule__Action__TypeAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2851:2: rule__Action__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__TypeAssignment_1_in_rule__Action__Group__15811);
            rule__Action__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getTypeAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__2_in_rule__Action__Group__15820);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2862:1: rule__Action__Group__2 : ( ( rule__Action__Group_2__0 )? ) rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2866:1: ( ( ( rule__Action__Group_2__0 )? ) rule__Action__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2867:1: ( ( rule__Action__Group_2__0 )? ) rule__Action__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2867:1: ( ( rule__Action__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2868:1: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2869:1: ( rule__Action__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==22) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2869:2: rule__Action__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__0_in_rule__Action__Group__25848);
                    rule__Action__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group__3_in_rule__Action__Group__25858);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2880:1: rule__Action__Group__3 : ( '}' ) ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2884:1: ( ( '}' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2885:1: ( '}' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2885:1: ( '}' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2886:1: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Action__Group__35887); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2907:1: rule__Action__Group_2__0 : ( '.' ) rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2911:1: ( ( '.' ) rule__Action__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2912:1: ( '.' ) rule__Action__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2912:1: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2913:1: '.'
            {
             before(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Action__Group_2__05931); 
             after(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__1_in_rule__Action__Group_2__05941);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2927:1: rule__Action__Group_2__1 : ( ( rule__Action__FeatureAssignment_2_1 ) ) rule__Action__Group_2__2 ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2931:1: ( ( ( rule__Action__FeatureAssignment_2_1 ) ) rule__Action__Group_2__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2932:1: ( ( rule__Action__FeatureAssignment_2_1 ) ) rule__Action__Group_2__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2932:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2933:1: ( rule__Action__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2934:1: ( rule__Action__FeatureAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2934:2: rule__Action__FeatureAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__FeatureAssignment_2_1_in_rule__Action__Group_2__15969);
            rule__Action__FeatureAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__2_in_rule__Action__Group_2__15978);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2945:1: rule__Action__Group_2__2 : ( ( rule__Action__OperatorAssignment_2_2 ) ) rule__Action__Group_2__3 ;
    public final void rule__Action__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2949:1: ( ( ( rule__Action__OperatorAssignment_2_2 ) ) rule__Action__Group_2__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2950:1: ( ( rule__Action__OperatorAssignment_2_2 ) ) rule__Action__Group_2__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2950:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2951:1: ( rule__Action__OperatorAssignment_2_2 )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2952:1: ( rule__Action__OperatorAssignment_2_2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2952:2: rule__Action__OperatorAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__OperatorAssignment_2_2_in_rule__Action__Group_2__26006);
            rule__Action__OperatorAssignment_2_2();
            _fsp--;


            }

             after(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Action__Group_2__3_in_rule__Action__Group_2__26015);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2963:1: rule__Action__Group_2__3 : ( 'current' ) ;
    public final void rule__Action__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2967:1: ( ( 'current' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2968:1: ( 'current' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2968:1: ( 'current' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2969:1: 'current'
            {
             before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__Action__Group_2__36044); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2990:1: rule__Assignment__Group__0 : ( ( rule__Assignment__FeatureAssignment_0 ) ) rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2994:1: ( ( ( rule__Assignment__FeatureAssignment_0 ) ) rule__Assignment__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2995:1: ( ( rule__Assignment__FeatureAssignment_0 ) ) rule__Assignment__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2995:1: ( ( rule__Assignment__FeatureAssignment_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2996:1: ( rule__Assignment__FeatureAssignment_0 )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2997:1: ( rule__Assignment__FeatureAssignment_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:2997:2: rule__Assignment__FeatureAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__FeatureAssignment_0_in_rule__Assignment__Group__06087);
            rule__Assignment__FeatureAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getFeatureAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__1_in_rule__Assignment__Group__06096);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3008:1: rule__Assignment__Group__1 : ( ( rule__Assignment__OperatorAssignment_1 ) ) rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3012:1: ( ( ( rule__Assignment__OperatorAssignment_1 ) ) rule__Assignment__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3013:1: ( ( rule__Assignment__OperatorAssignment_1 ) ) rule__Assignment__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3013:1: ( ( rule__Assignment__OperatorAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3014:1: ( rule__Assignment__OperatorAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3015:1: ( rule__Assignment__OperatorAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3015:2: rule__Assignment__OperatorAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__OperatorAssignment_1_in_rule__Assignment__Group__16124);
            rule__Assignment__OperatorAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Assignment__Group__2_in_rule__Assignment__Group__16133);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3026:1: rule__Assignment__Group__2 : ( ( rule__Assignment__TerminalAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3030:1: ( ( ( rule__Assignment__TerminalAssignment_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3031:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3031:1: ( ( rule__Assignment__TerminalAssignment_2 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3032:1: ( rule__Assignment__TerminalAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3033:1: ( rule__Assignment__TerminalAssignment_2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3033:2: rule__Assignment__TerminalAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__TerminalAssignment_2_in_rule__Assignment__Group__26161);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3049:1: rule__ParenthesizedAssignableElement__Group__0 : ( '(' ) rule__ParenthesizedAssignableElement__Group__1 ;
    public final void rule__ParenthesizedAssignableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3053:1: ( ( '(' ) rule__ParenthesizedAssignableElement__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3054:1: ( '(' ) rule__ParenthesizedAssignableElement__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3054:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3055:1: '('
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedAssignableElement__Group__06202); 
             after(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__1_in_rule__ParenthesizedAssignableElement__Group__06212);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3069:1: rule__ParenthesizedAssignableElement__Group__1 : ( ruleAssignableAlternatives ) rule__ParenthesizedAssignableElement__Group__2 ;
    public final void rule__ParenthesizedAssignableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3073:1: ( ( ruleAssignableAlternatives ) rule__ParenthesizedAssignableElement__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3074:1: ( ruleAssignableAlternatives ) rule__ParenthesizedAssignableElement__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3074:1: ( ruleAssignableAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3075:1: ruleAssignableAlternatives
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group__16240);
            ruleAssignableAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedAssignableElement__Group__2_in_rule__ParenthesizedAssignableElement__Group__16248);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3087:1: rule__ParenthesizedAssignableElement__Group__2 : ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3091:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3092:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3092:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3093:1: ')'
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group__26277); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3112:1: rule__AssignableAlternatives__Group__0 : ( ruleAssignableTerminal ) rule__AssignableAlternatives__Group__1 ;
    public final void rule__AssignableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3116:1: ( ( ruleAssignableTerminal ) rule__AssignableAlternatives__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3117:1: ( ruleAssignableTerminal ) rule__AssignableAlternatives__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3117:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3118:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group__06318);
            ruleAssignableTerminal();
            _fsp--;

             after(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group__1_in_rule__AssignableAlternatives__Group__06326);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3130:1: rule__AssignableAlternatives__Group__1 : ( ( rule__AssignableAlternatives__Group_1__0 )? ) ;
    public final void rule__AssignableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3134:1: ( ( ( rule__AssignableAlternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3135:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3135:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3136:1: ( rule__AssignableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3137:1: ( rule__AssignableAlternatives__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==30) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3137:2: rule__AssignableAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__0_in_rule__AssignableAlternatives__Group__16354);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3151:1: rule__AssignableAlternatives__Group_1__0 : ( () ) rule__AssignableAlternatives__Group_1__1 ;
    public final void rule__AssignableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3155:1: ( ( () ) rule__AssignableAlternatives__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3156:1: ( () ) rule__AssignableAlternatives__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3156:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3157:1: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3158:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3160:1: 
            {
            }

             after(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1__1_in_rule__AssignableAlternatives__Group_1__06403);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3171:1: rule__AssignableAlternatives__Group_1__1 : ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__AssignableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3175:1: ( ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3176:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3176:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3177:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3177:1: ( ( rule__AssignableAlternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3178:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3179:1: ( rule__AssignableAlternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3179:2: rule__AssignableAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__16433);
            rule__AssignableAlternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3182:1: ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3183:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3184:1: ( rule__AssignableAlternatives__Group_1_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==30) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3184:2: rule__AssignableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__16445);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3199:1: rule__AssignableAlternatives__Group_1_1__0 : ( '|' ) rule__AssignableAlternatives__Group_1_1__1 ;
    public final void rule__AssignableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3203:1: ( ( '|' ) rule__AssignableAlternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3204:1: ( '|' ) rule__AssignableAlternatives__Group_1_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3204:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3205:1: '|'
            {
             before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__AssignableAlternatives__Group_1_1__06487); 
             after(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__Group_1_1__1_in_rule__AssignableAlternatives__Group_1_1__06497);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3219:1: rule__AssignableAlternatives__Group_1_1__1 : ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3223:1: ( ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3224:1: ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3224:1: ( ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3225:1: ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3226:1: ( rule__AssignableAlternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3226:2: rule__AssignableAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AssignableAlternatives__GroupsAssignment_1_1_1_in_rule__AssignableAlternatives__Group_1_1__16525);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3240:1: rule__CrossReference__Group__0 : ( '[' ) rule__CrossReference__Group__1 ;
    public final void rule__CrossReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3244:1: ( ( '[' ) rule__CrossReference__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3245:1: ( '[' ) rule__CrossReference__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3245:1: ( '[' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3246:1: '['
            {
             before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__CrossReference__Group__06564); 
             after(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__1_in_rule__CrossReference__Group__06574);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3260:1: rule__CrossReference__Group__1 : ( ( rule__CrossReference__TypeAssignment_1 ) ) rule__CrossReference__Group__2 ;
    public final void rule__CrossReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3264:1: ( ( ( rule__CrossReference__TypeAssignment_1 ) ) rule__CrossReference__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3265:1: ( ( rule__CrossReference__TypeAssignment_1 ) ) rule__CrossReference__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3265:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3266:1: ( rule__CrossReference__TypeAssignment_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3267:1: ( rule__CrossReference__TypeAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3267:2: rule__CrossReference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__TypeAssignment_1_in_rule__CrossReference__Group__16602);
            rule__CrossReference__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__2_in_rule__CrossReference__Group__16611);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3278:1: rule__CrossReference__Group__2 : ( ( rule__CrossReference__Group_2__0 )? ) rule__CrossReference__Group__3 ;
    public final void rule__CrossReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3282:1: ( ( ( rule__CrossReference__Group_2__0 )? ) rule__CrossReference__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3283:1: ( ( rule__CrossReference__Group_2__0 )? ) rule__CrossReference__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3283:1: ( ( rule__CrossReference__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3284:1: ( rule__CrossReference__Group_2__0 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3285:1: ( rule__CrossReference__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==30) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3285:2: rule__CrossReference__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__0_in_rule__CrossReference__Group__26639);
                    rule__CrossReference__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCrossReferenceAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group__3_in_rule__CrossReference__Group__26649);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3296:1: rule__CrossReference__Group__3 : ( ']' ) ;
    public final void rule__CrossReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3300:1: ( ( ']' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3301:1: ( ']' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3301:1: ( ']' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3302:1: ']'
            {
             before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__CrossReference__Group__36678); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3323:1: rule__CrossReference__Group_2__0 : ( '|' ) rule__CrossReference__Group_2__1 ;
    public final void rule__CrossReference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3327:1: ( ( '|' ) rule__CrossReference__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3328:1: ( '|' ) rule__CrossReference__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3328:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3329:1: '|'
            {
             before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__CrossReference__Group_2__06722); 
             after(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__Group_2__1_in_rule__CrossReference__Group_2__06732);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3343:1: rule__CrossReference__Group_2__1 : ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) ;
    public final void rule__CrossReference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3347:1: ( ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3348:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3348:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3349:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3350:1: ( rule__CrossReference__TerminalAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3350:2: rule__CrossReference__TerminalAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CrossReference__TerminalAssignment_2_1_in_rule__CrossReference__Group_2__16760);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3364:1: rule__ParenthesizedElement__Group__0 : ( '(' ) rule__ParenthesizedElement__Group__1 ;
    public final void rule__ParenthesizedElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3368:1: ( ( '(' ) rule__ParenthesizedElement__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3369:1: ( '(' ) rule__ParenthesizedElement__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3369:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3370:1: '('
            {
             before(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedElement__Group__06799); 
             after(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__1_in_rule__ParenthesizedElement__Group__06809);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3384:1: rule__ParenthesizedElement__Group__1 : ( ruleAlternatives ) rule__ParenthesizedElement__Group__2 ;
    public final void rule__ParenthesizedElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3388:1: ( ( ruleAlternatives ) rule__ParenthesizedElement__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3389:1: ( ruleAlternatives ) rule__ParenthesizedElement__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3389:1: ( ruleAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3390:1: ruleAlternatives
            {
             before(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group__16837);
            ruleAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedElement__Group__2_in_rule__ParenthesizedElement__Group__16845);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3402:1: rule__ParenthesizedElement__Group__2 : ( ')' ) ;
    public final void rule__ParenthesizedElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3406:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3407:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3407:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3408:1: ')'
            {
             before(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedElement__Group__26874); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3427:1: rule__TerminalRule__Group__0 : ( 'terminal' ) rule__TerminalRule__Group__1 ;
    public final void rule__TerminalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3431:1: ( ( 'terminal' ) rule__TerminalRule__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3432:1: ( 'terminal' ) rule__TerminalRule__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3432:1: ( 'terminal' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3433:1: 'terminal'
            {
             before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__TerminalRule__Group__06916); 
             after(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__1_in_rule__TerminalRule__Group__06926);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3447:1: rule__TerminalRule__Group__1 : ( ( rule__TerminalRule__NameAssignment_1 ) ) rule__TerminalRule__Group__2 ;
    public final void rule__TerminalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3451:1: ( ( ( rule__TerminalRule__NameAssignment_1 ) ) rule__TerminalRule__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3452:1: ( ( rule__TerminalRule__NameAssignment_1 ) ) rule__TerminalRule__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3452:1: ( ( rule__TerminalRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3453:1: ( rule__TerminalRule__NameAssignment_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3454:1: ( rule__TerminalRule__NameAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3454:2: rule__TerminalRule__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__NameAssignment_1_in_rule__TerminalRule__Group__16954);
            rule__TerminalRule__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__2_in_rule__TerminalRule__Group__16963);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3465:1: rule__TerminalRule__Group__2 : ( ( rule__TerminalRule__Group_2__0 )? ) rule__TerminalRule__Group__3 ;
    public final void rule__TerminalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3469:1: ( ( ( rule__TerminalRule__Group_2__0 )? ) rule__TerminalRule__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3470:1: ( ( rule__TerminalRule__Group_2__0 )? ) rule__TerminalRule__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3470:1: ( ( rule__TerminalRule__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3471:1: ( rule__TerminalRule__Group_2__0 )?
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3472:1: ( rule__TerminalRule__Group_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==28) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3472:2: rule__TerminalRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_2__0_in_rule__TerminalRule__Group__26991);
                    rule__TerminalRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalRuleAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__3_in_rule__TerminalRule__Group__27001);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3483:1: rule__TerminalRule__Group__3 : ( ':' ) rule__TerminalRule__Group__4 ;
    public final void rule__TerminalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3487:1: ( ( ':' ) rule__TerminalRule__Group__4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3488:1: ( ':' ) rule__TerminalRule__Group__4
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3488:1: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3489:1: ':'
            {
             before(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__TerminalRule__Group__37030); 
             after(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__4_in_rule__TerminalRule__Group__37040);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3503:1: rule__TerminalRule__Group__4 : ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) rule__TerminalRule__Group__5 ;
    public final void rule__TerminalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3507:1: ( ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) rule__TerminalRule__Group__5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3508:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) rule__TerminalRule__Group__5
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3508:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3509:1: ( rule__TerminalRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3510:1: ( rule__TerminalRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3510:2: rule__TerminalRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__AlternativesAssignment_4_in_rule__TerminalRule__Group__47068);
            rule__TerminalRule__AlternativesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group__5_in_rule__TerminalRule__Group__47077);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3521:1: rule__TerminalRule__Group__5 : ( ';' ) ;
    public final void rule__TerminalRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3525:1: ( ( ';' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3526:1: ( ';' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3526:1: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3527:1: ';'
            {
             before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__TerminalRule__Group__57106); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3552:1: rule__TerminalRule__Group_2__0 : ( 'returns' ) rule__TerminalRule__Group_2__1 ;
    public final void rule__TerminalRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3556:1: ( ( 'returns' ) rule__TerminalRule__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3557:1: ( 'returns' ) rule__TerminalRule__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3557:1: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3558:1: 'returns'
            {
             before(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__TerminalRule__Group_2__07154); 
             after(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__Group_2__1_in_rule__TerminalRule__Group_2__07164);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3572:1: rule__TerminalRule__Group_2__1 : ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) ;
    public final void rule__TerminalRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3576:1: ( ( ( rule__TerminalRule__TypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3577:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3577:1: ( ( rule__TerminalRule__TypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3578:1: ( rule__TerminalRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3579:1: ( rule__TerminalRule__TypeAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3579:2: rule__TerminalRule__TypeAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalRule__TypeAssignment_2_1_in_rule__TerminalRule__Group_2__17192);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3593:1: rule__TerminalAlternatives__Group__0 : ( ruleTerminalGroup ) rule__TerminalAlternatives__Group__1 ;
    public final void rule__TerminalAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3597:1: ( ( ruleTerminalGroup ) rule__TerminalAlternatives__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3598:1: ( ruleTerminalGroup ) rule__TerminalAlternatives__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3598:1: ( ruleTerminalGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3599:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group__07230);
            ruleTerminalGroup();
            _fsp--;

             after(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group__1_in_rule__TerminalAlternatives__Group__07238);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3611:1: rule__TerminalAlternatives__Group__1 : ( ( rule__TerminalAlternatives__Group_1__0 )? ) ;
    public final void rule__TerminalAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3615:1: ( ( ( rule__TerminalAlternatives__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3616:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3616:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3617:1: ( rule__TerminalAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3618:1: ( rule__TerminalAlternatives__Group_1__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==30) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3618:2: rule__TerminalAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__0_in_rule__TerminalAlternatives__Group__17266);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3632:1: rule__TerminalAlternatives__Group_1__0 : ( () ) rule__TerminalAlternatives__Group_1__1 ;
    public final void rule__TerminalAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3636:1: ( ( () ) rule__TerminalAlternatives__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3637:1: ( () ) rule__TerminalAlternatives__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3637:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3638:1: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3639:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3641:1: 
            {
            }

             after(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1__1_in_rule__TerminalAlternatives__Group_1__07315);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3652:1: rule__TerminalAlternatives__Group_1__1 : ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__TerminalAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3656:1: ( ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3657:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3657:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3658:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3658:1: ( ( rule__TerminalAlternatives__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3659:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3660:1: ( rule__TerminalAlternatives__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3660:2: rule__TerminalAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__17345);
            rule__TerminalAlternatives__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3663:1: ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3664:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3665:1: ( rule__TerminalAlternatives__Group_1_1__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==30) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3665:2: rule__TerminalAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__17357);
            	    rule__TerminalAlternatives__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3680:1: rule__TerminalAlternatives__Group_1_1__0 : ( '|' ) rule__TerminalAlternatives__Group_1_1__1 ;
    public final void rule__TerminalAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3684:1: ( ( '|' ) rule__TerminalAlternatives__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3685:1: ( '|' ) rule__TerminalAlternatives__Group_1_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3685:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3686:1: '|'
            {
             before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__TerminalAlternatives__Group_1_1__07399); 
             after(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__Group_1_1__1_in_rule__TerminalAlternatives__Group_1_1__07409);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3700:1: rule__TerminalAlternatives__Group_1_1__1 : ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3704:1: ( ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3705:1: ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3705:1: ( ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3706:1: ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3707:1: ( rule__TerminalAlternatives__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3707:2: rule__TerminalAlternatives__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalAlternatives__GroupsAssignment_1_1_1_in_rule__TerminalAlternatives__Group_1_1__17437);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3721:1: rule__TerminalGroup__Group__0 : ( ruleTerminalToken ) rule__TerminalGroup__Group__1 ;
    public final void rule__TerminalGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3725:1: ( ( ruleTerminalToken ) rule__TerminalGroup__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3726:1: ( ruleTerminalToken ) rule__TerminalGroup__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3726:1: ( ruleTerminalToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3727:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group__07475);
            ruleTerminalToken();
            _fsp--;

             after(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group__1_in_rule__TerminalGroup__Group__07483);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3739:1: rule__TerminalGroup__Group__1 : ( ( rule__TerminalGroup__Group_1__0 )? ) ;
    public final void rule__TerminalGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3743:1: ( ( ( rule__TerminalGroup__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3744:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3744:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3745:1: ( rule__TerminalGroup__Group_1__0 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3746:1: ( rule__TerminalGroup__Group_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_STRING)||LA41_0==20||LA41_0==22||(LA41_0>=37 && LA41_0<=38)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3746:2: rule__TerminalGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__0_in_rule__TerminalGroup__Group__17511);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3760:1: rule__TerminalGroup__Group_1__0 : ( () ) rule__TerminalGroup__Group_1__1 ;
    public final void rule__TerminalGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3764:1: ( ( () ) rule__TerminalGroup__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3765:1: ( () ) rule__TerminalGroup__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3765:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3766:1: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3767:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3769:1: 
            {
            }

             after(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__Group_1__1_in_rule__TerminalGroup__Group_1__07560);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3780:1: rule__TerminalGroup__Group_1__1 : ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) ) ;
    public final void rule__TerminalGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3784:1: ( ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3785:1: ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3785:1: ( ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3786:1: ( ( rule__TerminalGroup__TokensAssignment_1_1 ) ) ( ( rule__TerminalGroup__TokensAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3786:1: ( ( rule__TerminalGroup__TokensAssignment_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3787:1: ( rule__TerminalGroup__TokensAssignment_1_1 )
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3788:1: ( rule__TerminalGroup__TokensAssignment_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3788:2: rule__TerminalGroup__TokensAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__17590);
            rule__TerminalGroup__TokensAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3791:1: ( ( rule__TerminalGroup__TokensAssignment_1_1 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3792:1: ( rule__TerminalGroup__TokensAssignment_1_1 )*
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3793:1: ( rule__TerminalGroup__TokensAssignment_1_1 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=RULE_ID && LA42_0<=RULE_STRING)||LA42_0==20||LA42_0==22||(LA42_0>=37 && LA42_0<=38)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3793:2: rule__TerminalGroup__TokensAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__17602);
            	    rule__TerminalGroup__TokensAssignment_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3808:1: rule__TerminalToken__Group__0 : ( ruleTerminalTokenElement ) rule__TerminalToken__Group__1 ;
    public final void rule__TerminalToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3812:1: ( ( ruleTerminalTokenElement ) rule__TerminalToken__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3813:1: ( ruleTerminalTokenElement ) rule__TerminalToken__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3813:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3814:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group__07643);
            ruleTerminalTokenElement();
            _fsp--;

             after(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__Group__1_in_rule__TerminalToken__Group__07651);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3826:1: rule__TerminalToken__Group__1 : ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) ;
    public final void rule__TerminalToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3830:1: ( ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3831:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3831:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3832:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3833:1: ( rule__TerminalToken__CardinalityAssignment_1 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=11 && LA43_0<=13)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3833:2: rule__TerminalToken__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__CardinalityAssignment_1_in_rule__TerminalToken__Group__17679);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3847:1: rule__ParenthesizedTerminalElement__Group__0 : ( '(' ) rule__ParenthesizedTerminalElement__Group__1 ;
    public final void rule__ParenthesizedTerminalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3851:1: ( ( '(' ) rule__ParenthesizedTerminalElement__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3852:1: ( '(' ) rule__ParenthesizedTerminalElement__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3852:1: ( '(' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3853:1: '('
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__ParenthesizedTerminalElement__Group__07719); 
             after(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__1_in_rule__ParenthesizedTerminalElement__Group__07729);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3867:1: rule__ParenthesizedTerminalElement__Group__1 : ( ruleTerminalAlternatives ) rule__ParenthesizedTerminalElement__Group__2 ;
    public final void rule__ParenthesizedTerminalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3871:1: ( ( ruleTerminalAlternatives ) rule__ParenthesizedTerminalElement__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3872:1: ( ruleTerminalAlternatives ) rule__ParenthesizedTerminalElement__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3872:1: ( ruleTerminalAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3873:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group__17757);
            ruleTerminalAlternatives();
            _fsp--;

             after(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ParenthesizedTerminalElement__Group__2_in_rule__ParenthesizedTerminalElement__Group__17765);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3885:1: rule__ParenthesizedTerminalElement__Group__2 : ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3889:1: ( ( ')' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3890:1: ( ')' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3890:1: ( ')' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3891:1: ')'
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group__27794); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3910:1: rule__NegatedToken__Group__0 : ( '!' ) rule__NegatedToken__Group__1 ;
    public final void rule__NegatedToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3914:1: ( ( '!' ) rule__NegatedToken__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3915:1: ( '!' ) rule__NegatedToken__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3915:1: ( '!' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3916:1: '!'
            {
             before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__NegatedToken__Group__07836); 
             after(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__Group__1_in_rule__NegatedToken__Group__07846);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3930:1: rule__NegatedToken__Group__1 : ( ( rule__NegatedToken__TerminalAssignment_1 ) ) ;
    public final void rule__NegatedToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3934:1: ( ( ( rule__NegatedToken__TerminalAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3935:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3935:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3936:1: ( rule__NegatedToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3937:1: ( rule__NegatedToken__TerminalAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3937:2: rule__NegatedToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NegatedToken__TerminalAssignment_1_in_rule__NegatedToken__Group__17874);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3951:1: rule__UntilToken__Group__0 : ( '->' ) rule__UntilToken__Group__1 ;
    public final void rule__UntilToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3955:1: ( ( '->' ) rule__UntilToken__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3956:1: ( '->' ) rule__UntilToken__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3956:1: ( '->' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3957:1: '->'
            {
             before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__UntilToken__Group__07913); 
             after(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__Group__1_in_rule__UntilToken__Group__07923);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3971:1: rule__UntilToken__Group__1 : ( ( rule__UntilToken__TerminalAssignment_1 ) ) ;
    public final void rule__UntilToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3975:1: ( ( ( rule__UntilToken__TerminalAssignment_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3976:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3976:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3977:1: ( rule__UntilToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3978:1: ( rule__UntilToken__TerminalAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3978:2: rule__UntilToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UntilToken__TerminalAssignment_1_in_rule__UntilToken__Group__17951);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3992:1: rule__Wildcard__Group__0 : ( () ) rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3996:1: ( ( () ) rule__Wildcard__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3997:1: ( () ) rule__Wildcard__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3997:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3998:1: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:3999:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4001:1: 
            {
            }

             after(grammarAccess.getWildcardAccess().getWildcardAction_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Wildcard__Group__1_in_rule__Wildcard__Group__07999);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4012:1: rule__Wildcard__Group__1 : ( '.' ) ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4016:1: ( ( '.' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4017:1: ( '.' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4017:1: ( '.' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4018:1: '.'
            {
             before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Wildcard__Group__18028); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4035:1: rule__CharacterRange__Group__0 : ( ruleKeyword ) rule__CharacterRange__Group__1 ;
    public final void rule__CharacterRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4039:1: ( ( ruleKeyword ) rule__CharacterRange__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4040:1: ( ruleKeyword ) rule__CharacterRange__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4040:1: ( ruleKeyword )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4041:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CharacterRange__Group__08067);
            ruleKeyword();
            _fsp--;

             after(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group__1_in_rule__CharacterRange__Group__08075);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4053:1: rule__CharacterRange__Group__1 : ( ( rule__CharacterRange__Group_1__0 )? ) ;
    public final void rule__CharacterRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4057:1: ( ( ( rule__CharacterRange__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4058:1: ( ( rule__CharacterRange__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4058:1: ( ( rule__CharacterRange__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4059:1: ( rule__CharacterRange__Group_1__0 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4060:1: ( rule__CharacterRange__Group_1__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==39) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4060:2: rule__CharacterRange__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__0_in_rule__CharacterRange__Group__18103);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4074:1: rule__CharacterRange__Group_1__0 : ( () ) rule__CharacterRange__Group_1__1 ;
    public final void rule__CharacterRange__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4078:1: ( ( () ) rule__CharacterRange__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4079:1: ( () ) rule__CharacterRange__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4079:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4080:1: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4081:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4083:1: 
            {
            }

             after(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__1_in_rule__CharacterRange__Group_1__08152);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4094:1: rule__CharacterRange__Group_1__1 : ( '..' ) rule__CharacterRange__Group_1__2 ;
    public final void rule__CharacterRange__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4098:1: ( ( '..' ) rule__CharacterRange__Group_1__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4099:1: ( '..' ) rule__CharacterRange__Group_1__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4099:1: ( '..' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4100:1: '..'
            {
             before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__CharacterRange__Group_1__18181); 
             after(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__Group_1__2_in_rule__CharacterRange__Group_1__18191);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4114:1: rule__CharacterRange__Group_1__2 : ( ( rule__CharacterRange__RightAssignment_1_2 ) ) ;
    public final void rule__CharacterRange__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4118:1: ( ( ( rule__CharacterRange__RightAssignment_1_2 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4119:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4119:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4120:1: ( rule__CharacterRange__RightAssignment_1_2 )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4121:1: ( rule__CharacterRange__RightAssignment_1_2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4121:2: rule__CharacterRange__RightAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CharacterRange__RightAssignment_1_2_in_rule__CharacterRange__Group_1__28219);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4137:1: rule__EnumRule__Group__0 : ( 'enum' ) rule__EnumRule__Group__1 ;
    public final void rule__EnumRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4141:1: ( ( 'enum' ) rule__EnumRule__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4142:1: ( 'enum' ) rule__EnumRule__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4142:1: ( 'enum' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4143:1: 'enum'
            {
             before(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 
            match(input,40,FollowSets000.FOLLOW_40_in_rule__EnumRule__Group__08260); 
             after(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__1_in_rule__EnumRule__Group__08270);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4157:1: rule__EnumRule__Group__1 : ( ( rule__EnumRule__NameAssignment_1 ) ) rule__EnumRule__Group__2 ;
    public final void rule__EnumRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4161:1: ( ( ( rule__EnumRule__NameAssignment_1 ) ) rule__EnumRule__Group__2 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4162:1: ( ( rule__EnumRule__NameAssignment_1 ) ) rule__EnumRule__Group__2
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4162:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4163:1: ( rule__EnumRule__NameAssignment_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4164:1: ( rule__EnumRule__NameAssignment_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4164:2: rule__EnumRule__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__NameAssignment_1_in_rule__EnumRule__Group__18298);
            rule__EnumRule__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__2_in_rule__EnumRule__Group__18307);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4175:1: rule__EnumRule__Group__2 : ( ( rule__EnumRule__Group_2__0 )? ) rule__EnumRule__Group__3 ;
    public final void rule__EnumRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4179:1: ( ( ( rule__EnumRule__Group_2__0 )? ) rule__EnumRule__Group__3 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4180:1: ( ( rule__EnumRule__Group_2__0 )? ) rule__EnumRule__Group__3
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4180:1: ( ( rule__EnumRule__Group_2__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4181:1: ( rule__EnumRule__Group_2__0 )?
            {
             before(grammarAccess.getEnumRuleAccess().getGroup_2()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4182:1: ( rule__EnumRule__Group_2__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==28) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4182:2: rule__EnumRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__0_in_rule__EnumRule__Group__28335);
                    rule__EnumRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumRuleAccess().getGroup_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__3_in_rule__EnumRule__Group__28345);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4193:1: rule__EnumRule__Group__3 : ( ':' ) rule__EnumRule__Group__4 ;
    public final void rule__EnumRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4197:1: ( ( ':' ) rule__EnumRule__Group__4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4198:1: ( ':' ) rule__EnumRule__Group__4
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4198:1: ( ':' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4199:1: ':'
            {
             before(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__EnumRule__Group__38374); 
             after(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__4_in_rule__EnumRule__Group__38384);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4213:1: rule__EnumRule__Group__4 : ( ( rule__EnumRule__AlternativesAssignment_4 ) ) rule__EnumRule__Group__5 ;
    public final void rule__EnumRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4217:1: ( ( ( rule__EnumRule__AlternativesAssignment_4 ) ) rule__EnumRule__Group__5 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4218:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) ) rule__EnumRule__Group__5
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4218:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4219:1: ( rule__EnumRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4220:1: ( rule__EnumRule__AlternativesAssignment_4 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4220:2: rule__EnumRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__AlternativesAssignment_4_in_rule__EnumRule__Group__48412);
            rule__EnumRule__AlternativesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group__5_in_rule__EnumRule__Group__48421);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4231:1: rule__EnumRule__Group__5 : ( ';' ) ;
    public final void rule__EnumRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4235:1: ( ( ';' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4236:1: ( ';' )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4236:1: ( ';' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4237:1: ';'
            {
             before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__EnumRule__Group__58450); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4262:1: rule__EnumRule__Group_2__0 : ( 'returns' ) rule__EnumRule__Group_2__1 ;
    public final void rule__EnumRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4266:1: ( ( 'returns' ) rule__EnumRule__Group_2__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4267:1: ( 'returns' ) rule__EnumRule__Group_2__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4267:1: ( 'returns' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4268:1: 'returns'
            {
             before(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__EnumRule__Group_2__08498); 
             after(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__Group_2__1_in_rule__EnumRule__Group_2__08508);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4282:1: rule__EnumRule__Group_2__1 : ( ( rule__EnumRule__TypeAssignment_2_1 ) ) ;
    public final void rule__EnumRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4286:1: ( ( ( rule__EnumRule__TypeAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4287:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4287:1: ( ( rule__EnumRule__TypeAssignment_2_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4288:1: ( rule__EnumRule__TypeAssignment_2_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getTypeAssignment_2_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4289:1: ( rule__EnumRule__TypeAssignment_2_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4289:2: rule__EnumRule__TypeAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumRule__TypeAssignment_2_1_in_rule__EnumRule__Group_2__18536);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4303:1: rule__EnumLiterals__Group__0 : ( ruleEnumLiteralDeclaration ) rule__EnumLiterals__Group__1 ;
    public final void rule__EnumLiterals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4307:1: ( ( ruleEnumLiteralDeclaration ) rule__EnumLiterals__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4308:1: ( ruleEnumLiteralDeclaration ) rule__EnumLiterals__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4308:1: ( ruleEnumLiteralDeclaration )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4309:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group__08574);
            ruleEnumLiteralDeclaration();
            _fsp--;

             after(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group__1_in_rule__EnumLiterals__Group__08582);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4321:1: rule__EnumLiterals__Group__1 : ( ( rule__EnumLiterals__Group_1__0 )? ) ;
    public final void rule__EnumLiterals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4325:1: ( ( ( rule__EnumLiterals__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4326:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4326:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4327:1: ( rule__EnumLiterals__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4328:1: ( rule__EnumLiterals__Group_1__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==30) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4328:2: rule__EnumLiterals__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__0_in_rule__EnumLiterals__Group__18610);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4342:1: rule__EnumLiterals__Group_1__0 : ( () ) rule__EnumLiterals__Group_1__1 ;
    public final void rule__EnumLiterals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4346:1: ( ( () ) rule__EnumLiterals__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4347:1: ( () ) rule__EnumLiterals__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4347:1: ( () )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4348:1: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4349:1: ()
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4351:1: 
            {
            }

             after(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1__1_in_rule__EnumLiterals__Group_1__08659);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4362:1: rule__EnumLiterals__Group_1__1 : ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) ;
    public final void rule__EnumLiterals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4366:1: ( ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4367:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4367:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4368:1: ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4368:1: ( ( rule__EnumLiterals__Group_1_1__0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4369:1: ( rule__EnumLiterals__Group_1_1__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4370:1: ( rule__EnumLiterals__Group_1_1__0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4370:2: rule__EnumLiterals__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__18689);
            rule__EnumLiterals__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4373:1: ( ( rule__EnumLiterals__Group_1_1__0 )* )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4374:1: ( rule__EnumLiterals__Group_1_1__0 )*
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4375:1: ( rule__EnumLiterals__Group_1_1__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==30) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4375:2: rule__EnumLiterals__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__18701);
            	    rule__EnumLiterals__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4390:1: rule__EnumLiterals__Group_1_1__0 : ( '|' ) rule__EnumLiterals__Group_1_1__1 ;
    public final void rule__EnumLiterals__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4394:1: ( ( '|' ) rule__EnumLiterals__Group_1_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4395:1: ( '|' ) rule__EnumLiterals__Group_1_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4395:1: ( '|' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4396:1: '|'
            {
             before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__EnumLiterals__Group_1_1__08743); 
             after(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__Group_1_1__1_in_rule__EnumLiterals__Group_1_1__08753);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4410:1: rule__EnumLiterals__Group_1_1__1 : ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) ) ;
    public final void rule__EnumLiterals__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4414:1: ( ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4415:1: ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4415:1: ( ( rule__EnumLiterals__GroupsAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4416:1: ( rule__EnumLiterals__GroupsAssignment_1_1_1 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsAssignment_1_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4417:1: ( rule__EnumLiterals__GroupsAssignment_1_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4417:2: rule__EnumLiterals__GroupsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiterals__GroupsAssignment_1_1_1_in_rule__EnumLiterals__Group_1_1__18781);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4431:1: rule__EnumLiteralDeclaration__Group__0 : ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) rule__EnumLiteralDeclaration__Group__1 ;
    public final void rule__EnumLiteralDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4435:1: ( ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) rule__EnumLiteralDeclaration__Group__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4436:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) rule__EnumLiteralDeclaration__Group__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4436:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4437:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4438:1: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4438:2: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__EnumLiteralAssignment_0_in_rule__EnumLiteralDeclaration__Group__08819);
            rule__EnumLiteralDeclaration__EnumLiteralAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group__1_in_rule__EnumLiteralDeclaration__Group__08828);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4449:1: rule__EnumLiteralDeclaration__Group__1 : ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4453:1: ( ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4454:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4454:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4455:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4456:1: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==14) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4456:2: rule__EnumLiteralDeclaration__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__0_in_rule__EnumLiteralDeclaration__Group__18856);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4470:1: rule__EnumLiteralDeclaration__Group_1__0 : ( '=' ) rule__EnumLiteralDeclaration__Group_1__1 ;
    public final void rule__EnumLiteralDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4474:1: ( ( '=' ) rule__EnumLiteralDeclaration__Group_1__1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4475:1: ( '=' ) rule__EnumLiteralDeclaration__Group_1__1
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4475:1: ( '=' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4476:1: '='
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_1__08896); 
             after(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__Group_1__1_in_rule__EnumLiteralDeclaration__Group_1__08906);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4490:1: rule__EnumLiteralDeclaration__Group_1__1 : ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4494:1: ( ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4495:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4495:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4496:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4497:1: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4497:2: rule__EnumLiteralDeclaration__LiteralAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumLiteralDeclaration__LiteralAssignment_1_1_in_rule__EnumLiteralDeclaration__Group_1__18934);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4511:1: rule__Grammar__NameAssignment_1 : ( ruleGrammarID ) ;
    public final void rule__Grammar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4515:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4516:1: ( ruleGrammarID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4516:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4517:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__NameAssignment_18972);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4526:1: rule__Grammar__UsedGrammarsAssignment_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4530:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4531:1: ( ( ruleGrammarID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4531:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4532:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4533:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4534:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_19007);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4545:1: rule__Grammar__UsedGrammarsAssignment_2_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4549:1: ( ( ( ruleGrammarID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4550:1: ( ( ruleGrammarID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4550:1: ( ( ruleGrammarID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4551:1: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4552:1: ( ruleGrammarID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4553:1: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_2_19046);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4564:1: rule__Grammar__DefinesHiddenTokensAssignment_3_0 : ( ( 'hidden' ) ) ;
    public final void rule__Grammar__DefinesHiddenTokensAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4568:1: ( ( ( 'hidden' ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4569:1: ( ( 'hidden' ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4569:1: ( ( 'hidden' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4570:1: ( 'hidden' )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4571:1: ( 'hidden' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4572:1: 'hidden'
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            match(input,41,FollowSets000.FOLLOW_41_in_rule__Grammar__DefinesHiddenTokensAssignment_3_09086); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4587:1: rule__Grammar__HiddenTokensAssignment_3_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4591:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4592:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4592:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4593:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4594:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4595:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_09129); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4606:1: rule__Grammar__HiddenTokensAssignment_3_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4610:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4611:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4611:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4612:1: ( RULE_ID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4613:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4614:1: RULE_ID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_3_2_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_1_19168); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4625:1: rule__Grammar__MetamodelDeclarationsAssignment_4 : ( ruleAbstractMetamodelDeclaration ) ;
    public final void rule__Grammar__MetamodelDeclarationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4629:1: ( ( ruleAbstractMetamodelDeclaration ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4630:1: ( ruleAbstractMetamodelDeclaration )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4630:1: ( ruleAbstractMetamodelDeclaration )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4631:1: ruleAbstractMetamodelDeclaration
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__MetamodelDeclarationsAssignment_49203);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4640:1: rule__Grammar__RulesAssignment_5 : ( ruleAbstractRule ) ;
    public final void rule__Grammar__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4644:1: ( ( ruleAbstractRule ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4645:1: ( ruleAbstractRule )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4645:1: ( ruleAbstractRule )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4646:1: ruleAbstractRule
            {
             before(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_rule__Grammar__RulesAssignment_59234);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4655:1: rule__GeneratedMetamodel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4659:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4660:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4660:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4661:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__NameAssignment_19265); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4670:1: rule__GeneratedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__GeneratedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4674:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4675:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4675:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4676:1: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4677:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4678:1: RULE_STRING
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__EPackageAssignment_29300); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4689:1: rule__GeneratedMetamodel__AliasAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__AliasAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4693:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4694:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4694:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4695:1: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__AliasAssignment_3_19335); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4704:1: rule__ReferencedMetamodel__EPackageAssignment_1 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4708:1: ( ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4709:1: ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4709:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4710:1: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4711:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4712:1: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_19370); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4723:1: rule__ReferencedMetamodel__AliasAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4727:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4728:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4728:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4729:1: RULE_ID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_2_19405); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4738:1: rule__ParserRule__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParserRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4742:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4743:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4743:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4744:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__NameAssignment_09436); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4753:1: rule__ParserRule__TypeAssignment_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4757:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4758:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4758:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4759:1: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__ParserRule__TypeAssignment_1_19467);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4768:1: rule__ParserRule__DefinesHiddenTokensAssignment_2_0 : ( ( 'hidden' ) ) ;
    public final void rule__ParserRule__DefinesHiddenTokensAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4772:1: ( ( ( 'hidden' ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4773:1: ( ( 'hidden' ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4773:1: ( ( 'hidden' ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4774:1: ( 'hidden' )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4775:1: ( 'hidden' )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4776:1: 'hidden'
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            match(input,41,FollowSets000.FOLLOW_41_in_rule__ParserRule__DefinesHiddenTokensAssignment_2_09503); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4791:1: rule__ParserRule__HiddenTokensAssignment_2_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4795:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4796:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4796:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4797:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4798:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4799:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_09546); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4810:1: rule__ParserRule__HiddenTokensAssignment_2_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4814:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4815:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4815:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4816:1: ( RULE_ID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4817:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4818:1: RULE_ID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_2_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_1_19585); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4829:1: rule__ParserRule__AlternativesAssignment_4 : ( ruleAlternatives ) ;
    public final void rule__ParserRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4833:1: ( ( ruleAlternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4834:1: ( ruleAlternatives )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4834:1: ( ruleAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4835:1: ruleAlternatives
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_rule__ParserRule__AlternativesAssignment_49620);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4844:1: rule__TypeRef__MetamodelAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__MetamodelAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4848:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4849:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4849:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4850:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4851:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4852:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeRef__MetamodelAssignment_0_09655); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4863:1: rule__TypeRef__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4867:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4868:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4868:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4869:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4870:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4871:1: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeRef__ClassifierAssignment_19694); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4882:1: rule__Alternatives__GroupsAssignment_1_1_1 : ( ruleGroup ) ;
    public final void rule__Alternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4886:1: ( ( ruleGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4887:1: ( ruleGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4887:1: ( ruleGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4888:1: ruleGroup
            {
             before(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_rule__Alternatives__GroupsAssignment_1_1_19729);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4897:1: rule__Group__TokensAssignment_1_1 : ( ruleAbstractToken ) ;
    public final void rule__Group__TokensAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4901:1: ( ( ruleAbstractToken ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4902:1: ( ruleAbstractToken )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4902:1: ( ruleAbstractToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4903:1: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_rule__Group__TokensAssignment_1_19760);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4912:1: rule__AbstractTokenWithCardinality__CardinalityAssignment_1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4916:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4917:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4917:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4918:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4919:1: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4919:2: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__CardinalityAssignment_19791);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4928:1: rule__Action__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Action__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4932:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4933:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4933:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4934:1: ruleTypeRef
            {
             before(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__Action__TypeAssignment_19824);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4943:1: rule__Action__FeatureAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Action__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4947:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4948:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4948:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4949:1: RULE_ID
            {
             before(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Action__FeatureAssignment_2_19855); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4958:1: rule__Action__OperatorAssignment_2_2 : ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ;
    public final void rule__Action__OperatorAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4962:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4963:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4963:1: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4964:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4965:1: ( rule__Action__OperatorAlternatives_2_2_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4965:2: rule__Action__OperatorAlternatives_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__OperatorAssignment_2_29886);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4974:1: rule__Keyword__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Keyword__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4978:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4979:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4979:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4980:1: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Keyword__ValueAssignment9919); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4989:1: rule__RuleCall__RuleAssignment : ( ( RULE_ID ) ) ;
    public final void rule__RuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4993:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4994:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4994:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4995:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4996:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:4997:1: RULE_ID
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__RuleCall__RuleAssignment9954); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5008:1: rule__Assignment__FeatureAssignment_0 : ( RULE_ID ) ;
    public final void rule__Assignment__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5012:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5013:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5013:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5014:1: RULE_ID
            {
             before(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Assignment__FeatureAssignment_09989); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5023:1: rule__Assignment__OperatorAssignment_1 : ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) ;
    public final void rule__Assignment__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5027:1: ( ( ( rule__Assignment__OperatorAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5028:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5028:1: ( ( rule__Assignment__OperatorAlternatives_1_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5029:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5030:1: ( rule__Assignment__OperatorAlternatives_1_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5030:2: rule__Assignment__OperatorAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__OperatorAssignment_110020);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5039:1: rule__Assignment__TerminalAssignment_2 : ( ruleAssignableTerminal ) ;
    public final void rule__Assignment__TerminalAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5043:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5044:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5044:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5045:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__Assignment__TerminalAssignment_210053);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5054:1: rule__AssignableAlternatives__GroupsAssignment_1_1_1 : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5058:1: ( ( ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5059:1: ( ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5059:1: ( ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5060:1: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__GroupsAssignment_1_1_110084);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5069:1: rule__CrossReference__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__CrossReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5073:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5074:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5074:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5075:1: ruleTypeRef
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__CrossReference__TypeAssignment_110115);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5084:1: rule__CrossReference__TerminalAssignment_2_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReference__TerminalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5088:1: ( ( ruleCrossReferenceableTerminal ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5089:1: ( ruleCrossReferenceableTerminal )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5089:1: ( ruleCrossReferenceableTerminal )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5090:1: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__TerminalAssignment_2_110146);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5099:1: rule__TerminalRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TerminalRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5103:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5104:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5104:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5105:1: RULE_ID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_110177); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5114:1: rule__TerminalRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__TerminalRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5118:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5119:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5119:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5120:1: ruleTypeRef
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__TerminalRule__TypeAssignment_2_110208);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5129:1: rule__TerminalRule__AlternativesAssignment_4 : ( ruleTerminalAlternatives ) ;
    public final void rule__TerminalRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5133:1: ( ( ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5134:1: ( ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5134:1: ( ruleTerminalAlternatives )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5135:1: ruleTerminalAlternatives
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__AlternativesAssignment_410239);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5144:1: rule__TerminalAlternatives__GroupsAssignment_1_1_1 : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5148:1: ( ( ruleTerminalGroup ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5149:1: ( ruleTerminalGroup )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5149:1: ( ruleTerminalGroup )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5150:1: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__GroupsAssignment_1_1_110270);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5159:1: rule__TerminalGroup__TokensAssignment_1_1 : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__TokensAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5163:1: ( ( ruleTerminalToken ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5164:1: ( ruleTerminalToken )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5164:1: ( ruleTerminalToken )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5165:1: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__TokensAssignment_1_110301);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5174:1: rule__TerminalToken__CardinalityAssignment_1 : ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__TerminalToken__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5178:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5179:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5179:1: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5180:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5181:1: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5181:2: rule__TerminalToken__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__CardinalityAssignment_110332);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5190:1: rule__NegatedToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__NegatedToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5194:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5195:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5195:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5196:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__TerminalAssignment_110365);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5205:1: rule__UntilToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__UntilToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5209:1: ( ( ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5210:1: ( ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5210:1: ( ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5211:1: ruleTerminalTokenElement
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__TerminalAssignment_110396);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5220:1: rule__CharacterRange__RightAssignment_1_2 : ( ruleKeyword ) ;
    public final void rule__CharacterRange__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5224:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5225:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5225:1: ( ruleKeyword )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5226:1: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__CharacterRange__RightAssignment_1_210427);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5235:1: rule__EnumRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5239:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5240:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5240:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5241:1: RULE_ID
            {
             before(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EnumRule__NameAssignment_110458); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5250:1: rule__EnumRule__TypeAssignment_2_1 : ( ruleTypeRef ) ;
    public final void rule__EnumRule__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5254:1: ( ( ruleTypeRef ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5255:1: ( ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5255:1: ( ruleTypeRef )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5256:1: ruleTypeRef
            {
             before(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_rule__EnumRule__TypeAssignment_2_110489);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5265:1: rule__EnumRule__AlternativesAssignment_4 : ( ruleEnumLiterals ) ;
    public final void rule__EnumRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5269:1: ( ( ruleEnumLiterals ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5270:1: ( ruleEnumLiterals )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5270:1: ( ruleEnumLiterals )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5271:1: ruleEnumLiterals
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_rule__EnumRule__AlternativesAssignment_410520);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5280:1: rule__EnumLiterals__GroupsAssignment_1_1_1 : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__GroupsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5284:1: ( ( ruleEnumLiteralDeclaration ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5285:1: ( ruleEnumLiteralDeclaration )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5285:1: ( ruleEnumLiteralDeclaration )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5286:1: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__GroupsAssignment_1_1_110551);
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5295:1: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumLiteralDeclaration__EnumLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5299:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5300:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5300:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5301:1: ( RULE_ID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5302:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5303:1: RULE_ID
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__EnumLiteralAssignment_010586); 
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
    // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5314:1: rule__EnumLiteralDeclaration__LiteralAssignment_1_1 : ( ruleKeyword ) ;
    public final void rule__EnumLiteralDeclaration__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5318:1: ( ( ruleKeyword ) )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5319:1: ( ruleKeyword )
            {
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5319:1: ( ruleKeyword )
            // ../org.eclipse.xtext.xtext.ui/src-gen/org/eclipse/xtext/contentassist/antlr/internal/InternalXtext.g:5320:1: ruleKeyword
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__LiteralAssignment_1_110621);
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
        public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup610 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroup617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group__0_in_ruleGroup644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken671 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractToken__Alternatives_in_ruleAbstractToken705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality732 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__0_in_ruleAbstractTokenWithCardinality766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction793 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group__0_in_ruleAction827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal854 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTerminal__Alternatives_in_ruleAbstractTerminal888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword915 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeyword922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Keyword__ValueAssignment_in_ruleKeyword949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall976 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RuleCall__RuleAssignment_in_ruleRuleCall1010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment1037 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment1044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__Group__0_in_ruleAssignment1071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal1098 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal1105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableTerminal__Alternatives_in_ruleAssignableTerminal1132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement1159 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement1166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__0_in_ruleParenthesizedAssignableElement1193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives1220 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives1227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__0_in_ruleAssignableAlternatives1254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference1281 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference1288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__0_in_ruleCrossReference1315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal1342 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal1349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReferenceableTerminal__Alternatives_in_ruleCrossReferenceableTerminal1376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement1403 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement1410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__0_in_ruleParenthesizedElement1437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1464 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__0_in_ruleTerminalRule1498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives1525 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives1532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__0_in_ruleTerminalAlternatives1559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup1586 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup1593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__0_in_ruleTerminalGroup1620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken1647 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken1654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__0_in_ruleTerminalToken1681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement1708 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement1715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalTokenElement__Alternatives_in_ruleTerminalTokenElement1742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement1769 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement1776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__0_in_ruleParenthesizedTerminalElement1803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken1830 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken1837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractNegatedToken__Alternatives_in_ruleAbstractNegatedToken1864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken1891 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken1898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__0_in_ruleNegatedToken1925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken1952 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken1959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__0_in_ruleUntilToken1986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard2013 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcard2020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__0_in_ruleWildcard2047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange2074 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange2081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__0_in_ruleCharacterRange2108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule2135 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule2142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__0_in_ruleEnumRule2169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals2196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals2203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__0_in_ruleEnumLiterals2230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration2257 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration2264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__0_in_ruleEnumLiteralDeclaration2291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_rule__AbstractRule__Alternatives2327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_rule__AbstractRule__Alternatives2344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_rule__AbstractRule__Alternatives2361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_rule__AbstractMetamodelDeclaration__Alternatives2410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_rule__AbstractToken__Alternatives2442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_rule__AbstractToken__Alternatives2459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_rule__AbstractTokenWithCardinality__Alternatives_02491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_rule__AbstractTokenWithCardinality__Alternatives_02508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_02581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Action__OperatorAlternatives_2_2_02616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Action__OperatorAlternatives_2_2_02636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__AbstractTerminal__Alternatives2670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__AbstractTerminal__Alternatives2687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_rule__AbstractTerminal__Alternatives2704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Assignment__OperatorAlternatives_1_02737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Assignment__OperatorAlternatives_1_02757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Assignment__OperatorAlternatives_1_02777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__AssignableTerminal__Alternatives2811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__AssignableTerminal__Alternatives2828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_rule__AssignableTerminal__Alternatives2845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_rule__AssignableTerminal__Alternatives2862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CrossReferenceableTerminal__Alternatives2894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__CrossReferenceableTerminal__Alternatives2911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TerminalToken__CardinalityAlternatives_1_02944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__TerminalToken__CardinalityAlternatives_1_02964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TerminalToken__CardinalityAlternatives_1_02984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_rule__TerminalTokenElement__Alternatives3018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_rule__TerminalTokenElement__Alternatives3035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_rule__TerminalTokenElement__Alternatives3052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_rule__TerminalTokenElement__Alternatives3069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_rule__TerminalTokenElement__Alternatives3086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_rule__AbstractNegatedToken__Alternatives3118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_rule__AbstractNegatedToken__Alternatives3135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Grammar__Group__03170 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__1_in_rule__Grammar__Group__03180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__NameAssignment_1_in_rule__Grammar__Group__13208 = new BitSet(new long[]{0x0000031002840010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__2_in_rule__Grammar__Group__13217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__0_in_rule__Grammar__Group__23245 = new BitSet(new long[]{0x0000031002800010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__3_in_rule__Grammar__Group__23255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__0_in_rule__Grammar__Group__33283 = new BitSet(new long[]{0x0000011002800010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__4_in_rule__Grammar__Group__33293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__MetamodelDeclarationsAssignment_4_in_rule__Grammar__Group__43321 = new BitSet(new long[]{0x0000011002800010L});
        public static final BitSet FOLLOW_rule__Grammar__Group__5_in_rule__Grammar__Group__43331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__53361 = new BitSet(new long[]{0x0000011000000012L});
        public static final BitSet FOLLOW_rule__Grammar__RulesAssignment_5_in_rule__Grammar__Group__53373 = new BitSet(new long[]{0x0000011000000012L});
        public static final BitSet FOLLOW_18_in_rule__Grammar__Group_2__03423 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__1_in_rule__Grammar__Group_2__03433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_1_in_rule__Grammar__Group_2__13461 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2__2_in_rule__Grammar__Group_2__13470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__0_in_rule__Grammar__Group_2__23498 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_rule__Grammar__Group_2_2__03540 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_2_2__1_in_rule__Grammar__Group_2_2__03550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__UsedGrammarsAssignment_2_2_1_in_rule__Grammar__Group_2_2__13578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__DefinesHiddenTokensAssignment_3_0_in_rule__Grammar__Group_3__03616 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__1_in_rule__Grammar__Group_3__03625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Grammar__Group_3__13654 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__2_in_rule__Grammar__Group_3__13664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__0_in_rule__Grammar__Group_3__23692 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3__3_in_rule__Grammar__Group_3__23702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Grammar__Group_3__33731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_0_in_rule__Grammar__Group_3_2__03774 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2__1_in_rule__Grammar__Group_3_2__03783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__0_in_rule__Grammar__Group_3_2__13811 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_rule__Grammar__Group_3_2_1__03851 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Grammar__Group_3_2_1__1_in_rule__Grammar__Group_3_2_1__03861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Grammar__HiddenTokensAssignment_3_2_1_1_in_rule__Grammar__Group_3_2_1__13889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group__03927 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group__1_in_rule__GrammarID__Group__03935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__0_in_rule__GrammarID__Group__13963 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_rule__GrammarID__Group_1__04003 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GrammarID__Group_1__1_in_rule__GrammarID__Group_1__04013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GrammarID__Group_1__14041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__GeneratedMetamodel__Group__04079 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__1_in_rule__GeneratedMetamodel__Group__04089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__NameAssignment_1_in_rule__GeneratedMetamodel__Group__14117 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__2_in_rule__GeneratedMetamodel__Group__14126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__EPackageAssignment_2_in_rule__GeneratedMetamodel__Group__24154 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group__3_in_rule__GeneratedMetamodel__Group__24163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__0_in_rule__GeneratedMetamodel__Group__34191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__GeneratedMetamodel__Group_3__04235 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__Group_3__1_in_rule__GeneratedMetamodel__Group_3__04245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GeneratedMetamodel__AliasAssignment_3_1_in_rule__GeneratedMetamodel__Group_3__14273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ReferencedMetamodel__Group__04312 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__1_in_rule__ReferencedMetamodel__Group__04322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__EPackageAssignment_1_in_rule__ReferencedMetamodel__Group__14350 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group__2_in_rule__ReferencedMetamodel__Group__14359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__0_in_rule__ReferencedMetamodel__Group__24387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__ReferencedMetamodel__Group_2__04429 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__Group_2__1_in_rule__ReferencedMetamodel__Group_2__04439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferencedMetamodel__AliasAssignment_2_1_in_rule__ReferencedMetamodel__Group_2__14467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__NameAssignment_0_in_rule__ParserRule__Group__04505 = new BitSet(new long[]{0x0000020014000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__1_in_rule__ParserRule__Group__04514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__0_in_rule__ParserRule__Group__14542 = new BitSet(new long[]{0x0000020004000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__2_in_rule__ParserRule__Group__14552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__0_in_rule__ParserRule__Group__24580 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__3_in_rule__ParserRule__Group__24590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__ParserRule__Group__34619 = new BitSet(new long[]{0x0000000080100030L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__4_in_rule__ParserRule__Group__34629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__AlternativesAssignment_4_in_rule__ParserRule__Group__44657 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group__5_in_rule__ParserRule__Group__44666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ParserRule__Group__54695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ParserRule__Group_1__04743 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_1__1_in_rule__ParserRule__Group_1__04753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__TypeAssignment_1_1_in_rule__ParserRule__Group_1__14781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__DefinesHiddenTokensAssignment_2_0_in_rule__ParserRule__Group_2__04819 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__1_in_rule__ParserRule__Group_2__04828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParserRule__Group_2__14857 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__2_in_rule__ParserRule__Group_2__14867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__0_in_rule__ParserRule__Group_2__24895 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2__3_in_rule__ParserRule__Group_2__24905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParserRule__Group_2__34934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_0_in_rule__ParserRule__Group_2_2__04977 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2__1_in_rule__ParserRule__Group_2_2__04986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__0_in_rule__ParserRule__Group_2_2__15014 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_rule__ParserRule__Group_2_2_1__05054 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ParserRule__Group_2_2_1__1_in_rule__ParserRule__Group_2_2_1__05064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParserRule__HiddenTokensAssignment_2_2_1_1_in_rule__ParserRule__Group_2_2_1__15092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__0_in_rule__TypeRef__Group__05130 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TypeRef__Group__1_in_rule__TypeRef__Group__05140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__ClassifierAssignment_1_in_rule__TypeRef__Group__15168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeRef__MetamodelAssignment_0_0_in_rule__TypeRef__Group_0__05206 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__TypeRef__Group_0__1_in_rule__TypeRef__Group_0__05215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__TypeRef__Group_0__15244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_rule__Alternatives__Group__05283 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group__1_in_rule__Alternatives__Group__05291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__0_in_rule__Alternatives__Group__15319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1__1_in_rule__Alternatives__Group_1__05368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__15398 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__0_in_rule__Alternatives__Group_1__15410 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_rule__Alternatives__Group_1_1__05452 = new BitSet(new long[]{0x0000000080100030L});
        public static final BitSet FOLLOW_rule__Alternatives__Group_1_1__1_in_rule__Alternatives__Group_1_1__05462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Alternatives__GroupsAssignment_1_1_1_in_rule__Alternatives__Group_1_1__15490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__Group__05528 = new BitSet(new long[]{0x0000000080100032L});
        public static final BitSet FOLLOW_rule__Group__Group__1_in_rule__Group__Group__05536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__0_in_rule__Group__Group__15564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__Group_1__1_in_rule__Group__Group_1__05613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__15643 = new BitSet(new long[]{0x0000000080100032L});
        public static final BitSet FOLLOW_rule__Group__TokensAssignment_1_1_in_rule__Group__Group_1__15655 = new BitSet(new long[]{0x0000000080100032L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Alternatives_0_in_rule__AbstractTokenWithCardinality__Group__05696 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__Group__1_in_rule__AbstractTokenWithCardinality__Group__05705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAssignment_1_in_rule__AbstractTokenWithCardinality__Group__15733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__Action__Group__05773 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Action__Group__1_in_rule__Action__Group__05783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__TypeAssignment_1_in_rule__Action__Group__15811 = new BitSet(new long[]{0x0000000100400000L});
        public static final BitSet FOLLOW_rule__Action__Group__2_in_rule__Action__Group__15820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__Group_2__0_in_rule__Action__Group__25848 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__Action__Group__3_in_rule__Action__Group__25858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Action__Group__35887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Action__Group_2__05931 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Action__Group_2__1_in_rule__Action__Group_2__05941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__FeatureAssignment_2_1_in_rule__Action__Group_2__15969 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_rule__Action__Group_2__2_in_rule__Action__Group_2__15978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__OperatorAssignment_2_2_in_rule__Action__Group_2__26006 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__Action__Group_2__3_in_rule__Action__Group_2__26015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__Action__Group_2__36044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__FeatureAssignment_0_in_rule__Assignment__Group__06087 = new BitSet(new long[]{0x000000000001C000L});
        public static final BitSet FOLLOW_rule__Assignment__Group__1_in_rule__Assignment__Group__06096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__OperatorAssignment_1_in_rule__Assignment__Group__16124 = new BitSet(new long[]{0x0000000400100030L});
        public static final BitSet FOLLOW_rule__Assignment__Group__2_in_rule__Assignment__Group__16133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__TerminalAssignment_2_in_rule__Assignment__Group__26161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedAssignableElement__Group__06202 = new BitSet(new long[]{0x0000000400100030L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__1_in_rule__ParenthesizedAssignableElement__Group__06212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_rule__ParenthesizedAssignableElement__Group__16240 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedAssignableElement__Group__2_in_rule__ParenthesizedAssignableElement__Group__16248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedAssignableElement__Group__26277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__Group__06318 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group__1_in_rule__AssignableAlternatives__Group__06326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__0_in_rule__AssignableAlternatives__Group__16354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1__1_in_rule__AssignableAlternatives__Group_1__06403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__16433 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__0_in_rule__AssignableAlternatives__Group_1__16445 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_rule__AssignableAlternatives__Group_1_1__06487 = new BitSet(new long[]{0x0000000400100030L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__Group_1_1__1_in_rule__AssignableAlternatives__Group_1_1__06497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AssignableAlternatives__GroupsAssignment_1_1_1_in_rule__AssignableAlternatives__Group_1_1__16525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__CrossReference__Group__06564 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__1_in_rule__CrossReference__Group__06574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__TypeAssignment_1_in_rule__CrossReference__Group__16602 = new BitSet(new long[]{0x0000000840000000L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__2_in_rule__CrossReference__Group__16611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__0_in_rule__CrossReference__Group__26639 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__CrossReference__Group__3_in_rule__CrossReference__Group__26649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__CrossReference__Group__36678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__CrossReference__Group_2__06722 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__CrossReference__Group_2__1_in_rule__CrossReference__Group_2__06732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CrossReference__TerminalAssignment_2_1_in_rule__CrossReference__Group_2__16760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedElement__Group__06799 = new BitSet(new long[]{0x0000000080100030L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__1_in_rule__ParenthesizedElement__Group__06809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParenthesizedElement__Group__16837 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedElement__Group__2_in_rule__ParenthesizedElement__Group__16845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedElement__Group__26874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__TerminalRule__Group__06916 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__1_in_rule__TerminalRule__Group__06926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__NameAssignment_1_in_rule__TerminalRule__Group__16954 = new BitSet(new long[]{0x0000000014000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__2_in_rule__TerminalRule__Group__16963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_2__0_in_rule__TerminalRule__Group__26991 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__3_in_rule__TerminalRule__Group__27001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__TerminalRule__Group__37030 = new BitSet(new long[]{0x0000006000500030L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__4_in_rule__TerminalRule__Group__37040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__AlternativesAssignment_4_in_rule__TerminalRule__Group__47068 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group__5_in_rule__TerminalRule__Group__47077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__TerminalRule__Group__57106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__TerminalRule__Group_2__07154 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TerminalRule__Group_2__1_in_rule__TerminalRule__Group_2__07164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalRule__TypeAssignment_2_1_in_rule__TerminalRule__Group_2__17192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__Group__07230 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group__1_in_rule__TerminalAlternatives__Group__07238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__0_in_rule__TerminalAlternatives__Group__17266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1__1_in_rule__TerminalAlternatives__Group_1__07315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__17345 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__0_in_rule__TerminalAlternatives__Group_1__17357 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_rule__TerminalAlternatives__Group_1_1__07399 = new BitSet(new long[]{0x0000006000500030L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__Group_1_1__1_in_rule__TerminalAlternatives__Group_1_1__07409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalAlternatives__GroupsAssignment_1_1_1_in_rule__TerminalAlternatives__Group_1_1__17437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__Group__07475 = new BitSet(new long[]{0x0000006000500032L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group__1_in_rule__TerminalGroup__Group__07483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__0_in_rule__TerminalGroup__Group__17511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__Group_1__1_in_rule__TerminalGroup__Group_1__07560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__17590 = new BitSet(new long[]{0x0000006000500032L});
        public static final BitSet FOLLOW_rule__TerminalGroup__TokensAssignment_1_1_in_rule__TerminalGroup__Group_1__17602 = new BitSet(new long[]{0x0000006000500032L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__TerminalToken__Group__07643 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__TerminalToken__Group__1_in_rule__TerminalToken__Group__07651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAssignment_1_in_rule__TerminalToken__Group__17679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__ParenthesizedTerminalElement__Group__07719 = new BitSet(new long[]{0x0000006000500030L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__1_in_rule__ParenthesizedTerminalElement__Group__07729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__ParenthesizedTerminalElement__Group__17757 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ParenthesizedTerminalElement__Group__2_in_rule__ParenthesizedTerminalElement__Group__17765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ParenthesizedTerminalElement__Group__27794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__NegatedToken__Group__07836 = new BitSet(new long[]{0x0000006000500030L});
        public static final BitSet FOLLOW_rule__NegatedToken__Group__1_in_rule__NegatedToken__Group__07846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NegatedToken__TerminalAssignment_1_in_rule__NegatedToken__Group__17874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__UntilToken__Group__07913 = new BitSet(new long[]{0x0000006000500030L});
        public static final BitSet FOLLOW_rule__UntilToken__Group__1_in_rule__UntilToken__Group__07923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UntilToken__TerminalAssignment_1_in_rule__UntilToken__Group__17951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Wildcard__Group__1_in_rule__Wildcard__Group__07999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Wildcard__Group__18028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__Group__08067 = new BitSet(new long[]{0x0000008000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group__1_in_rule__CharacterRange__Group__08075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__0_in_rule__CharacterRange__Group__18103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__1_in_rule__CharacterRange__Group_1__08152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__CharacterRange__Group_1__18181 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__CharacterRange__Group_1__2_in_rule__CharacterRange__Group_1__18191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CharacterRange__RightAssignment_1_2_in_rule__CharacterRange__Group_1__28219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__EnumRule__Group__08260 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__1_in_rule__EnumRule__Group__08270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__NameAssignment_1_in_rule__EnumRule__Group__18298 = new BitSet(new long[]{0x0000000014000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__2_in_rule__EnumRule__Group__18307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__0_in_rule__EnumRule__Group__28335 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__3_in_rule__EnumRule__Group__28345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__EnumRule__Group__38374 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__4_in_rule__EnumRule__Group__38384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__AlternativesAssignment_4_in_rule__EnumRule__Group__48412 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__EnumRule__Group__5_in_rule__EnumRule__Group__48421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__EnumRule__Group__58450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__EnumRule__Group_2__08498 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumRule__Group_2__1_in_rule__EnumRule__Group_2__08508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumRule__TypeAssignment_2_1_in_rule__EnumRule__Group_2__18536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__Group__08574 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group__1_in_rule__EnumLiterals__Group__08582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__0_in_rule__EnumLiterals__Group__18610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1__1_in_rule__EnumLiterals__Group_1__08659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__18689 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__0_in_rule__EnumLiterals__Group_1__18701 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_rule__EnumLiterals__Group_1_1__08743 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumLiterals__Group_1_1__1_in_rule__EnumLiterals__Group_1_1__08753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiterals__GroupsAssignment_1_1_1_in_rule__EnumLiterals__Group_1_1__18781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__EnumLiteralAssignment_0_in_rule__EnumLiteralDeclaration__Group__08819 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group__1_in_rule__EnumLiteralDeclaration__Group__08828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__0_in_rule__EnumLiteralDeclaration__Group__18856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__EnumLiteralDeclaration__Group_1__08896 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__Group_1__1_in_rule__EnumLiteralDeclaration__Group_1__08906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumLiteralDeclaration__LiteralAssignment_1_1_in_rule__EnumLiteralDeclaration__Group_1__18934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__NameAssignment_18972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_19007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammarID_in_rule__Grammar__UsedGrammarsAssignment_2_2_19046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__Grammar__DefinesHiddenTokensAssignment_3_09086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_09129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Grammar__HiddenTokensAssignment_3_2_1_19168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_rule__Grammar__MetamodelDeclarationsAssignment_49203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_rule__Grammar__RulesAssignment_59234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__NameAssignment_19265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__GeneratedMetamodel__EPackageAssignment_29300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GeneratedMetamodel__AliasAssignment_3_19335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferencedMetamodel__EPackageAssignment_19370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencedMetamodel__AliasAssignment_2_19405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__NameAssignment_09436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__ParserRule__TypeAssignment_1_19467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__ParserRule__DefinesHiddenTokensAssignment_2_09503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_09546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ParserRule__HiddenTokensAssignment_2_2_1_19585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_rule__ParserRule__AlternativesAssignment_49620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__MetamodelAssignment_0_09655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRef__ClassifierAssignment_19694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_rule__Alternatives__GroupsAssignment_1_1_19729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_rule__Group__TokensAssignment_1_19760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0_in_rule__AbstractTokenWithCardinality__CardinalityAssignment_19791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__Action__TypeAssignment_19824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Action__FeatureAssignment_2_19855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Action__OperatorAlternatives_2_2_0_in_rule__Action__OperatorAssignment_2_29886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Keyword__ValueAssignment9919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__RuleCall__RuleAssignment9954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Assignment__FeatureAssignment_09989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Assignment__OperatorAlternatives_1_0_in_rule__Assignment__OperatorAssignment_110020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__Assignment__TerminalAssignment_210053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_rule__AssignableAlternatives__GroupsAssignment_1_1_110084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__CrossReference__TypeAssignment_110115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_rule__CrossReference__TerminalAssignment_2_110146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TerminalRule__NameAssignment_110177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__TerminalRule__TypeAssignment_2_110208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_rule__TerminalRule__AlternativesAssignment_410239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_rule__TerminalAlternatives__GroupsAssignment_1_1_110270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_rule__TerminalGroup__TokensAssignment_1_110301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TerminalToken__CardinalityAlternatives_1_0_in_rule__TerminalToken__CardinalityAssignment_110332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__NegatedToken__TerminalAssignment_110365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_rule__UntilToken__TerminalAssignment_110396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__CharacterRange__RightAssignment_1_210427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EnumRule__NameAssignment_110458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_rule__EnumRule__TypeAssignment_2_110489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_rule__EnumRule__AlternativesAssignment_410520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_rule__EnumLiterals__GroupsAssignment_1_1_110551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EnumLiteralDeclaration__EnumLiteralAssignment_010586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_rule__EnumLiteralDeclaration__LiteralAssignment_1_110621 = new BitSet(new long[]{0x0000000000000002L});
    }


}